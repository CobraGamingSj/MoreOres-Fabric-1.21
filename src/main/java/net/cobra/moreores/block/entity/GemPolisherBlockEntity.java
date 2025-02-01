package net.cobra.moreores.block.entity;

import net.cobra.moreores.block.ModBlocks;
import net.cobra.moreores.block.data.GemPolisherData;
import net.cobra.moreores.item.ModItems;
import net.cobra.moreores.recipe.GemPolisherRecipe;
import net.cobra.moreores.recipe.input.GemPolishingRecipeInput;
import net.cobra.moreores.registry.ModItemTags;
import net.cobra.moreores.screen.GemPolisherScreenHandler;
import net.fabricmc.fabric.api.networking.v1.PlayerLookup;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.fabricmc.fabric.api.transfer.v1.transaction.Transaction;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.recipe.ServerRecipeManager;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import team.reborn.energy.api.base.SimpleEnergyStorage;

import java.util.Optional;

public class GemPolisherBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory<GemPolisherData>, ImplementedInventory, TickableBlockEntity {
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(15, ItemStack.EMPTY);

    public final SimpleEnergyStorage energyStorage = new SimpleEnergyStorage(1000000, 64,128) {
        @Override
        public void onFinalCommit() {
            super.onFinalCommit();

            markDirty();

            for(ServerPlayerEntity user : PlayerLookup.tracking((ServerWorld) world, getPos())) {
                ServerPlayNetworking.send(user, new GemPolisherData(this.amount, getPos()));
            }
        }
    };

    public static final int INGREDIENT_SLOT = 0;
    public static final int RESULT_SLOT = 1;
    public static final int ENERGY_SOURCE_SLOT = 2;

    private long lastRemovedEnergyMilestone = 0;

    protected final PropertyDelegate propertyDelegate;
    private int initialProgress = 0;
    private int maxProgressTick = 384;
    private final ServerRecipeManager.MatchGetter<GemPolishingRecipeInput, GemPolisherRecipe> matchGetter;

    public GemPolisherBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityType.GEM_POLISHER_BLOCK_ENTITY, pos, state);
        this.matchGetter = ServerRecipeManager.createCachedMatchGetter(GemPolisherRecipe.Type.GEM_POLISHING);
        this.propertyDelegate = new PropertyDelegate() {
            @Override
            public int get(int index) {
                return switch (index) {
                    case 0 -> GemPolisherBlockEntity.this.initialProgress;
                    case 1 -> GemPolisherBlockEntity.this.maxProgressTick;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0 -> GemPolisherBlockEntity.this.initialProgress = value;
                    case 1 -> GemPolisherBlockEntity.this.maxProgressTick = value;
                }
            }

            @Override
            public int size() {
                return 2;
            }
        };
    }

    public void setEnergyLevel(long energyLevel) {
        this.energyStorage.amount = energyLevel;
    }

    public ItemStack getOutputStackRenderer() {
        if (this.getStack(RESULT_SLOT).isEmpty()) return ItemStack.EMPTY;
        return this.getStack(RESULT_SLOT);
    }

    public ItemStack getInputStackRenderer() {
        if (this.getStack(INGREDIENT_SLOT).isEmpty()) return ItemStack.EMPTY;
        return this.getStack(INGREDIENT_SLOT);
    }

    public ItemStack getEnergyStackRenderer() {
        if(this.getStack(ENERGY_SOURCE_SLOT).isEmpty()) return ItemStack.EMPTY;
        return this.getStack(ENERGY_SOURCE_SLOT);
    }

    @Nullable
    @Override
    public Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    @Override
    public NbtCompound toInitialChunkDataNbt(RegistryWrapper.WrapperLookup registryLookup) {
        var nbt = super.toInitialChunkDataNbt(registryLookup);
        writeNbt(nbt, registryLookup);
        return nbt;
    }

    @Override
    protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.readNbt(nbt, registryLookup);
        Inventories.readNbt(nbt, inventory, registryLookup);
        if(nbt.contains("gem_polisher.progress", NbtElement.INT_TYPE)) initialProgress = nbt.getInt("gem_polisher.progress");
        if(nbt.contains("gem_polisher.energy", NbtElement.LONG_TYPE)) energyStorage.amount = nbt.getLong("gem_polisher.energy");
    }

    @Override
    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.writeNbt(nbt, registryLookup);
        Inventories.writeNbt(nbt, inventory, registryLookup);
        nbt.putInt("gem_polisher.progress", initialProgress);
        nbt.putLong("gem_polisher.energy", energyStorage.amount);
    }

    @Override
    public Text getDisplayName() {
        return Text.translatable("block.moreores.gem_polisher_block");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new GemPolisherScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
    }

    @Override
    public boolean isValid(int slot, ItemStack stack) {
        if(slot == INGREDIENT_SLOT) {
            return stack.isIn(ModItemTags.GEMSTONE) || stack.isIn(ModItemTags.RAW_GEMSTONE);
        } else if(slot == ENERGY_SOURCE_SLOT) {
            return stack.isOf(ModItems.ENERGY_INGOT) || stack.isOf(ModBlocks.ENERGY_BLOCK.asItem());
        } else if(slot == RESULT_SLOT) {
            return stack.isIn(ModItemTags.GEMSTONE);
        }
        return true;
    }

    @Override
    public boolean canInsert(int slot, ItemStack stack, @Nullable Direction side) {
        return this.isValid(slot, stack);
    }

    @Override
    public boolean canExtract(int slot, ItemStack stack, Direction side) {
        return slot == RESULT_SLOT;
    }

    @Override
    public GemPolisherData getScreenOpeningData(ServerPlayerEntity serverPlayerEntity) {
        return new GemPolisherData(this.energyStorage.amount, this.pos);
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    @Override
    public void tick(World world, BlockPos pos, BlockState state) {
        if (world.isClient()) {
            return;
        }

        if(hasEnergySourceProviderItem()) {
            try(Transaction transaction = Transaction.openOuter()) {
                this.energyStorage.insert(32, transaction);

                if(this.world.isReceivingRedstonePower(this.pos)) {
                    this.energyStorage.insert(1024, transaction);
                }

                transaction.commit();
            }
        }

        checkForEnoughEnergyAndRemoveItem();

        if (isResultSlotEmptyOrReceivable() && hasRecipe() && hasEnoughEnergy()) {
            this.increaseProgress();
            this.extractEnergy();
            if (hasPolishingFinished()) {
                this.getPolishedGemstone();
                this.resetProgress();
            }
            markDirty(world, pos, state);
        } else {
            this.resetProgress();
            markDirty(world, pos, state);
        }
    }

    private void checkForEnoughEnergyAndRemoveItem() {
        long energy = this.energyStorage.amount;

        long[] milestones = {250000, 500000, 750000, 1000000};

        for (long milestone : milestones) {
            if (energy >= milestone && lastRemovedEnergyMilestone < milestone) {
                this.removeStack(ENERGY_SOURCE_SLOT, 1);
                lastRemovedEnergyMilestone = milestone;
                break;
            }
        }
    }

    private void extractEnergy() {
        try(Transaction transaction = Transaction.openOuter()) {
            this.energyStorage.extract(16, transaction);
            transaction.commit();
        }
    }

    private boolean hasEnoughEnergy() {
        return this.energyStorage.amount >= 16;
    }

    private void resetProgress() {
        this.initialProgress = 0;
    }

    private void getPolishedGemstone() {
        RecipeEntry<GemPolisherRecipe> recipe = currentRecipe().orElseThrow();

        this.removeStack(INGREDIENT_SLOT, 1);

        this.setStack(RESULT_SLOT, new ItemStack(recipe.value().getResult().getItem(),
                getStack(RESULT_SLOT).getCount() + recipe.value().getResult().getCount()));
    }

    private boolean hasPolishingFinished() {
        return initialProgress >= maxProgressTick;
    }

    private void increaseProgress() {
        if(this.world.isReceivingRedstonePower(this.pos)) {
            initialProgress += 5;
        } else {
            initialProgress++;
        }
    }

    private boolean hasRecipe() {
        Optional<RecipeEntry<GemPolisherRecipe>> recipe = currentRecipe();

        return recipe.isPresent() && hasEnoughEnergy() && canInsertCountIntoResultSlot(recipe.get().value().getResult())
                && canInsertItemIntoResultSlot(recipe.get().value().getResult().getItem());
    }

    private boolean hasEnergySourceProviderItem() {
        return this.getStack(ENERGY_SOURCE_SLOT).isOf(ModItems.ENERGY_INGOT) || this.getStack(ENERGY_SOURCE_SLOT).isOf(ModBlocks.ENERGY_BLOCK.asItem());
    }

    private Optional<RecipeEntry<GemPolisherRecipe>> currentRecipe() {
        ServerWorld serverWorld = (ServerWorld) world;
        return this.matchGetter.getFirstMatch(new GemPolishingRecipeInput(this.getStack(INGREDIENT_SLOT)), serverWorld);
    }

    private boolean canInsertItemIntoResultSlot(Item item) {
        return this.getStack(RESULT_SLOT).getItem() == item || this.getStack(RESULT_SLOT).isEmpty() || this.getStack(RESULT_SLOT).isIn(ModItemTags.GEMSTONE) || this.getStack(RESULT_SLOT).isIn(ModItemTags.RAW_GEMSTONE);
    }

    private boolean canInsertCountIntoResultSlot(ItemStack result) {
        return this.getStack(RESULT_SLOT).getCount() + result.getCount() <= getStack(RESULT_SLOT).getMaxCount();
    }

    private boolean isResultSlotEmptyOrReceivable() {
        return this.getStack(RESULT_SLOT).isEmpty() || this.getStack(RESULT_SLOT).getCount() < this.getStack(RESULT_SLOT).getMaxCount();
    }
}
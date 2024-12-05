package net.cobra.moreores.block.entity;

import net.cobra.moreores.block.ModBlocks;
import net.cobra.moreores.block.data.GemPolisherData;
import net.cobra.moreores.item.ModItems;
import net.cobra.moreores.recipe.GemPolisherRecipe;
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
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.recipe.ServerRecipeManager;
import net.minecraft.recipe.input.SingleStackRecipeInput;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import team.reborn.energy.api.base.SimpleEnergyStorage;

import java.util.Optional;

public class GemPolisherBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory<GemPolisherData>, ImplementedInventory, TickableBlockEntity {
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(15, ItemStack.EMPTY);

    public final SimpleEnergyStorage energyStorage = new SimpleEnergyStorage(1000000, 16,64) {
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

    protected final PropertyDelegate propertyDelegate;
    private int progress = 0;
    private int maxProgress = 400;
    private final ServerRecipeManager.MatchGetter<SingleStackRecipeInput, GemPolisherRecipe> matchGetter;

    public GemPolisherBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityType.GEM_POLISHER_BLOCK_ENTITY, pos, state);
        this.matchGetter = ServerRecipeManager.createCachedMatchGetter(GemPolisherRecipe.Type.GEM_POLISHING);
        this.propertyDelegate = new PropertyDelegate() {
            @Override
            public int get(int index) {
                return switch (index) {
                    case 0 -> GemPolisherBlockEntity.this.progress;
                    case 1 -> GemPolisherBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0 -> GemPolisherBlockEntity.this.progress = value;
                    case 1 -> GemPolisherBlockEntity.this.maxProgress = value;
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

    @Override
    public void markDirty() {
        world.updateListeners(pos, getCachedState(), getCachedState(), 3);
        super.markDirty();
    }

    @Nullable
    @Override
    public Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    @Override
    public NbtCompound toInitialChunkDataNbt(RegistryWrapper.WrapperLookup registryLookup) {
        return createNbt(registryLookup);
    }

    @Override
    protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.readNbt(nbt, registryLookup);
        Inventories.readNbt(nbt, inventory, registryLookup);
        progress = nbt.getInt("gem_polisher.progress");
        energyStorage.amount = nbt.getLong("gem_polisher.energy");
    }

    @Override
    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.writeNbt(nbt, registryLookup);
        Inventories.writeNbt(nbt, inventory, registryLookup);
        nbt.putInt("gem_polisher.progress", progress);
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
                this.energyStorage.insert(8, transaction);
                transaction.commit();
            }
        }

        if (this.energyStorage.amount == 250000) {
            this.removeStack(ENERGY_SOURCE_SLOT, 1);
        } else if (this.energyStorage.amount == 500000) {
            this.removeStack(ENERGY_SOURCE_SLOT, 1);
        } else if (this.energyStorage.amount == 750000) {
            this.removeStack(ENERGY_SOURCE_SLOT, 1);
        } else if(this.energyStorage.amount >= this.energyStorage.capacity) {
            this.removeStack(ENERGY_SOURCE_SLOT, 1);
        }

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
        this.progress = 0;
    }

    private void getPolishedGemstone() {
        RecipeEntry<GemPolisherRecipe> recipe = currentRecipe().orElseThrow();

        this.removeStack(INGREDIENT_SLOT, 1);
        if (this.getStack(ENERGY_SOURCE_SLOT).isEmpty()) {
            return;
        } else {
            this.removeStack(ENERGY_SOURCE_SLOT, 1);
        }

        this.setStack(RESULT_SLOT, new ItemStack(recipe.value().getResult().getItem(),
                getStack(RESULT_SLOT).getCount() + recipe.value().getResult().getCount()));
    }

    private boolean hasPolishingFinished() {
        return progress >= maxProgress;
    }

    private void increaseProgress() {
        progress++;
    }

    private boolean hasRecipe() {
        Optional<RecipeEntry<GemPolisherRecipe>> recipe = currentRecipe();

        return recipe.isPresent() && canInsertCountIntoResultSlot(recipe.get().value().getResult())
                && canInsertItemIntoResultSlot(recipe.get().value().getResult().getItem());
    }

    private boolean hasEnergySourceProviderItem() {
        return this.getStack(ENERGY_SOURCE_SLOT).isOf(ModItems.ENERGY_INGOT) || this.getStack(ENERGY_SOURCE_SLOT).isOf(ModBlocks.ENERGY_BLOCK.asItem());
    }

    private Optional<RecipeEntry<GemPolisherRecipe>> currentRecipe() {
        return this.matchGetter.getFirstMatch(new SingleStackRecipeInput(this.getStack(INGREDIENT_SLOT)), (ServerWorld) world);
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
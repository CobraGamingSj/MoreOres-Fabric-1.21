package net.cobra.moreores.block.entity;

import net.cobra.moreores.block.data.GemPolisherData;
import net.cobra.moreores.item.ModItems;
import net.cobra.moreores.recipe.GemPolisherRecipe;
import net.cobra.moreores.registry.ModItemTags;
import net.cobra.moreores.screen.GemPolisherScreenHandler;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.Block;
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

    public final SimpleEnergyStorage energyStorage = new SimpleEnergyStorage(1_000_000, 0,1_000_000) {
        @Override
        public void onFinalCommit() {
            markDirty();
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

    public SimpleEnergyStorage getEnergyStorage() {
        return this.energyStorage;
    }

    public SimpleEnergyStorage getEnergyCapacity() {
        return this.energyStorage;
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

    private void update() {
        markDirty();
        if(world != null) {
            world.updateListeners(pos, getCachedState(), getCachedState(), Block.NOTIFY_ALL);
        }
    }

    @Override
    public void markDirty() {
        if(world != null) world.updateListeners(pos, getCachedState(), getCachedState(), 3);
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
    }

    @Override
    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.writeNbt(nbt, registryLookup);
        Inventories.writeNbt(nbt, inventory, registryLookup);
        nbt.putInt("gem_polisher.progress", progress);
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
        return new GemPolisherData(this.pos);
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    @Override
    public void tick(World world, BlockPos pos, BlockState state) {
        if ( world == null ||world.isClient) {
            return;
        }
        if (isResultSlotEmptyOrReceivable() && hasRecipe() && hasEnergySource()) {
            this.increaseProgress();
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

    private void resetProgress() {
        this.progress = 0;
    }

    private void getPolishedGemstone() {
        RecipeEntry<GemPolisherRecipe> recipe = currentRecipe().orElseThrow();
        ItemStack energySlot = getStack(ENERGY_SOURCE_SLOT);


        this.removeStack(INGREDIENT_SLOT, 1);
        if (energySlot.getItem() == ModItems.ENERGY_INGOT) {
            if (energySlot.getDamage() < energySlot.getMaxDamage()) {
                energySlot.setDamage(energySlot.getDamage() + 5);
            }
        } else {
            this.removeStack(ENERGY_SOURCE_SLOT);
        }

        this.setStack(RESULT_SLOT, new ItemStack(recipe.value().output.getItem(),
                getStack(RESULT_SLOT).getCount() + recipe.value().output.getCount()));
    }

    private boolean hasPolishingFinished() {
        return progress >= maxProgress;
    }

    private void increaseProgress() {
        progress ++;
    }

    private boolean hasRecipe() {
        Optional<RecipeEntry<GemPolisherRecipe>> recipe = currentRecipe();

        return recipe.isPresent() && canInsertCountIntoResultSlot(recipe.get().value().output)
                && canInsertItemIntoResultSlot(recipe.get().value().output.getItem()) && canInsertItemIntoIngredientSlot() && canInsertCountIntoIngredientSlot(recipe.get().value().output);
    }

    private boolean canInsertCountIntoIngredientSlot(ItemStack result) {
        return this.getStack(INGREDIENT_SLOT).getCount() + result.getCount() <= this.getStack(INGREDIENT_SLOT).getMaxCount();
    }

    private boolean hasEnergySource() {
        return this.getStack(ENERGY_SOURCE_SLOT).isOf(ModItems.ENERGY_INGOT);
    }

    private Optional<RecipeEntry<GemPolisherRecipe>> currentRecipe() {
        if(this.world instanceof ServerWorld server) return this.matchGetter.getFirstMatch(new SingleStackRecipeInput(this.getStack(INGREDIENT_SLOT)), server);
        return Optional.empty();
    }

    private boolean canInsertItemIntoResultSlot(Item item) {
        return this.getStack(RESULT_SLOT).getItem() == item || this.getStack(RESULT_SLOT).isEmpty() || this.getStack(RESULT_SLOT).isIn(ModItemTags.GEMSTONE);
    }

    private boolean canInsertCountIntoResultSlot(ItemStack result) {
        return this.getStack(RESULT_SLOT).getCount() + result.getCount() <= getStack(RESULT_SLOT).getMaxCount();
    }

    private boolean canInsertItemIntoIngredientSlot() {
        return this.getStack(INGREDIENT_SLOT).isEmpty() || this.getStack(INGREDIENT_SLOT).isIn(ModItemTags.GEMSTONE) || this.getStack(INGREDIENT_SLOT).isIn(ModItemTags.RAW_GEMSTONE);
    }

    private boolean isResultSlotEmptyOrReceivable() {
        return this.getStack(RESULT_SLOT).isEmpty() || this.getStack(RESULT_SLOT).getCount() < this.getStack(RESULT_SLOT).getMaxCount();
    }
}

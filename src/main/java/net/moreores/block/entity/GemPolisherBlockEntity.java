package net.moreores.block.entity;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.recipe.RecipeManager;
import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.input.RecipeInput;
import net.minecraft.recipe.input.SingleStackRecipeInput;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.moreores.block.data.GemPolisherData;
import net.moreores.item.ModItems;
import net.moreores.recipe.GemPolisherRecipe;
import net.moreores.screen.GemPolisherScreenHandler;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;
import java.util.Optional;

public class GemPolisherBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory, ImplementedInventory {
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(15, ItemStack.EMPTY); // Corrected size to 15

    public static final int INPUT_SLOT = 0;
    public static final int OUTPUT_SLOT = 1;
    public static final int ENERGY_SLOT = 2;

    protected final PropertyDelegate propertyDelegate;
    private int progress = 0;
    private int maxProgress = 400;
    private final RecipeManager.MatchGetter<SingleStackRecipeInput, GemPolisherRecipe> matchGetter;

    public GemPolisherBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityType.GEM_POLISHER_BLOCK_ENTITY, pos, state);
        this.matchGetter = RecipeManager.createCachedMatchGetter(GemPolisherRecipe.Type.INSTANCE);
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

    public ItemStack getRenderStack() {
        if (this.getStack(OUTPUT_SLOT).isEmpty()) {
            return this.getStack(INPUT_SLOT);
        } else {
            return this.getStack(OUTPUT_SLOT);
        }
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
    }

    @Override
    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.writeNbt(nbt, registryLookup);
        Inventories.writeNbt(nbt, inventory, registryLookup);
        nbt.putInt("gem_polisher.progress", progress);
    }

    @Override
    public Object getScreenOpeningData(ServerPlayerEntity player) {
        return new GemPolisherData(this.pos);
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
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    public void tick(World world, BlockPos pos, BlockState state) {
        if (world.isClient()) {
            return;
        }

        if (isOutputSlotEmptyOrReceivable() && hasRecipe()) {
            this.increaseCraftProgress();
            if (hasCraftingFinished()) {
                this.craftItem();
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

    private void craftItem() {
        RecipeEntry<GemPolisherRecipe> recipe = getSlot1Recipe().orElseThrow();
        ItemStack energySlot = getStack(ENERGY_SLOT);


        this.removeStack(INPUT_SLOT, 1);
        if (energySlot.getItem() == ModItems.ENERGY_INGOT) {
            if (energySlot.getDamage() < energySlot.getMaxDamage()) {
                energySlot.setDamage(energySlot.getDamage() + 5);
            }
        }else {
            this.removeStack(ENERGY_SLOT);
        }


        this.setStack(OUTPUT_SLOT, new ItemStack(recipe.value().getResult(null).getItem(),
                getStack(OUTPUT_SLOT).getCount() + recipe.value().getResult(null).getCount()));
    }

//    private void craftItem() {
//        ItemStack inputStack = getStack(INPUT_SLOT);
//        ItemStack result;
//
//        if (inputStack.getItem() == ModItems.RAW_RUBY) {
//            result = new ItemStack(ModItems.RUBY);
//        } else if (inputStack.getItem() == ModItems.RAW_SAPPHIRE) {
//            result = new ItemStack(ModItems.SAPPHIRE);
//        } else if (inputStack.getItem() == ModItems.RAW_GREEN_SAPPHIRE) {
//            result = new ItemStack(ModItems.GREEN_SAPPHIRE);
//        } else if (inputStack.getItem() == ModItems.RAW_BLUE_GARNET) {
//            result = new ItemStack(ModItems.BLUE_GARNET);
//        } else if (inputStack.getItem() == ModItems.RAW_PINK_GARNET) {
//            result = new ItemStack(ModItems.PINK_GARNET);
//        } else if (inputStack.getItem() == ModItems.RAW_GREEN_GARNET) {
//            result = new ItemStack(ModItems.GREEN_GARNET);
//        } else if (inputStack.getItem() == ModItems.RAW_TOPAZ) {
//            result = new ItemStack(ModItems.TOPAZ);
//        } else if (inputStack.getItem() == ModItems.RAW_WHITE_TOPAZ) {
//            result = new ItemStack(ModItems.WHITE_TOPAZ);
//        } else if (inputStack.getItem() == ModItems.RAW_PERIDOT) {
//            result = new ItemStack(ModItems.PERIDOT);
//        } else if (inputStack.getItem() == ModItems.RAW_JADE) {
//            result = new ItemStack(ModItems.JADE);
//        } else if (inputStack.getItem() == ModItems.RAW_PYROPE) {
//            result = new ItemStack(ModItems.PYROPE);
//        } else {
//            return; // No valid input, so don't craft anything
//        }
//
//        this.removeStack(INPUT_SLOT, 1);
//
//        ItemStack energyStack = getStack(ENERGY_SLOT);
//        if (energyStack.getItem() == ModItems.ENERGY_INGOT) {
//            if (energyStack.getDamage() < energyStack.getMaxDamage()) {
//                energyStack.setDamage(energyStack.getDamage() + 5);
//            } else {
//                this.removeStack(ENERGY_SLOT);
//            }
//        }
//
//        this.setStack(OUTPUT_SLOT, new ItemStack(result.getItem(), getStack(OUTPUT_SLOT).getCount() + result.getCount()));
//    }

    private boolean hasCraftingFinished() {
        return progress >= maxProgress;
    }

    private void increaseCraftProgress() {
        progress++;
    }

    private boolean hasRecipe() {
        Optional<RecipeEntry<GemPolisherRecipe>> recipe = getSlot1Recipe();

        return recipe.isPresent() && canInsertAmountIntoOutputSlot(recipe.get().value().getResult(null))
                && canInsertItemIntoOutputSlot(recipe.get().value().getResult(null).getItem());
    }

    private Optional<RecipeEntry<GemPolisherRecipe>> getSlot1Recipe() {
        return this.matchGetter.getFirstMatch(new SingleStackRecipeInput(this.getStack(INPUT_SLOT)), this.world);
    }

//    private boolean hasRecipe() {
//
//        ItemStack hasInput = getStack(INPUT_SLOT);
//        ItemStack result = null;
//
//        if (hasInput.getItem() == ModItems.RAW_RUBY) {
//            result = new ItemStack(ModItems.RUBY);
//        } else if (hasInput.getItem() == ModItems.RAW_SAPPHIRE) {
//            result = new ItemStack(ModItems.SAPPHIRE);
//        } else if (hasInput.getItem() == ModItems.RAW_GREEN_SAPPHIRE) {
//            result = new ItemStack(ModItems.GREEN_SAPPHIRE);
//        } else if (hasInput.getItem() == ModItems.RAW_BLUE_GARNET) {
//            result = new ItemStack(ModItems.BLUE_GARNET);
//        } else if (hasInput.getItem() == ModItems.RAW_PINK_GARNET) {
//            result = new ItemStack(ModItems.PINK_GARNET);
//        } else if (hasInput.getItem() == ModItems.RAW_GREEN_GARNET) {
//            result = new ItemStack(ModItems.GREEN_GARNET);
//        } else if (hasInput.getItem() == ModItems.RAW_TOPAZ) {
//            result = new ItemStack(ModItems.TOPAZ);
//        } else if (hasInput.getItem() == ModItems.RAW_WHITE_TOPAZ) {
//            result = new ItemStack(ModItems.WHITE_TOPAZ);
//        } else if (hasInput.getItem() == ModItems.RAW_PERIDOT) {
//            result = new ItemStack(ModItems.PERIDOT);
//        } else if (hasInput.getItem() == ModItems.RAW_JADE) {
//            result = new ItemStack(ModItems.JADE);
//        } else if (hasInput.getItem() == ModItems.RAW_PYROPE) {
//            result = new ItemStack(ModItems.PYROPE);
//        }
//
//        return result != null && canInsertAmountIntoOutputSlot(result) && canInsertItemIntoOutputSlot(result.getItem());
//    }

    private boolean canInsertItemIntoOutputSlot(Item item) {
        return this.getStack(OUTPUT_SLOT).getItem() == item || this.getStack(OUTPUT_SLOT).isEmpty();
    }

    private boolean canInsertAmountIntoOutputSlot(ItemStack result) {
        return this.getStack(OUTPUT_SLOT).getCount() + result.getCount() <= getStack(OUTPUT_SLOT).getMaxCount();
    }

    private boolean isOutputSlotEmptyOrReceivable() {
        return this.getStack(OUTPUT_SLOT).isEmpty() || this.getStack(OUTPUT_SLOT).getCount() < this.getStack(OUTPUT_SLOT).getMaxCount();
    }
}

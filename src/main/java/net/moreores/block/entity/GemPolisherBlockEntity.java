package net.moreores.block.entity;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
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
import net.minecraft.recipe.RecipeManager;
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

import java.util.Optional;

public class GemPolisherBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory, ImplementedInventory {
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(15, ItemStack.EMPTY); // Changed size to 15(3 existing slots, 12 new slots added)

    public static final int ITEM_INPUT_SLOT = 0;
    public static final int ITEM_OUTPUT_SLOT = 1;
    public static final int ENERGY_SOURCE_SLOT = 2;

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

    //Renamed method form getRenderStack to getStackRenderer
    public ItemStack getRenderStack() {
        if (this.getStack(ITEM_OUTPUT_SLOT).isEmpty()) {
            return this.getStack(ITEM_INPUT_SLOT);
        } else {
            return this.getStack(ITEM_OUTPUT_SLOT);
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
            this.increaseProgress();
            if (hasPolishingFinished()) {
                this.craftResultItem();
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

    //Renamed method from craftItem to craftResultItem
    private void craftResultItem() {
        RecipeEntry<GemPolisherRecipe> recipe = currentRecipe().orElseThrow();
        ItemStack energySlot = getStack(ENERGY_SOURCE_SLOT);


        this.removeStack(ITEM_INPUT_SLOT, 1);
        if (energySlot.getItem() == ModItems.ENERGY_INGOT) {
            if (energySlot.getDamage() < energySlot.getMaxDamage()) {
                energySlot.setDamage(energySlot.getDamage() + 5);
            }
        }else {
            this.removeStack(ENERGY_SOURCE_SLOT);
        }


        this.setStack(ITEM_OUTPUT_SLOT, new ItemStack(recipe.value().getResult(null).getItem(),
                getStack(ITEM_OUTPUT_SLOT).getCount() + recipe.value().getResult(null).getCount()));
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

    //Renamed method from hasCraftingFinished to hasPolishingFinished
    private boolean hasPolishingFinished() {
        return progress >= maxProgress;
    }

    //Renamed method from increaseCraftProgress to increaseProgress
    private void increaseProgress() {
        progress++;
    }

    private boolean hasRecipe() {
        Optional<RecipeEntry<GemPolisherRecipe>> recipe = currentRecipe();

        return recipe.isPresent() && canInsertAmountIntoOutputSlot(recipe.get().value().getResult(null))
                && canInsertItemIntoOutputSlot(recipe.get().value().getResult(null).getItem());
    }

    //Renamed method from getCurrentRecipe to currentRecipe
    private Optional<RecipeEntry<GemPolisherRecipe>> currentRecipe() {
        return this.matchGetter.getFirstMatch(new SingleStackRecipeInput(this.getStack(ITEM_INPUT_SLOT)), this.world);
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
        return this.getStack(ITEM_OUTPUT_SLOT).getItem() == item || this.getStack(ITEM_OUTPUT_SLOT).isEmpty();
    }

    private boolean canInsertAmountIntoOutputSlot(ItemStack result) {
        return this.getStack(ITEM_OUTPUT_SLOT).getCount() + result.getCount() <= getStack(ITEM_OUTPUT_SLOT).getMaxCount();
    }

    private boolean isOutputSlotEmptyOrReceivable() {
        return this.getStack(ITEM_OUTPUT_SLOT).isEmpty() || this.getStack(ITEM_OUTPUT_SLOT).getCount() < this.getStack(ITEM_OUTPUT_SLOT).getMaxCount();
    }
}

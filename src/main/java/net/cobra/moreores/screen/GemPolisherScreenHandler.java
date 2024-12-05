package net.cobra.moreores.screen;

import net.cobra.moreores.block.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.slot.Slot;
import net.cobra.moreores.block.data.GemPolisherData;
import net.cobra.moreores.block.entity.GemPolisherBlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import team.reborn.energy.api.base.SimpleEnergyStorage;

public class GemPolisherScreenHandler extends ScreenHandler implements ScreenHandlerInventoryHelper {
    private final Inventory inventory;
    private final ScreenHandlerContext context;
    private final PropertyDelegate propertyDelegate;
    public final GemPolisherBlockEntity blockEntity;

    // Client Side Constructor
    public GemPolisherScreenHandler(int syncId, PlayerInventory playerInventory, GemPolisherData data) {
        this(syncId, playerInventory, playerInventory.player.getWorld().getBlockEntity(data.blockPos()),
                new ArrayPropertyDelegate(2));
    }

    // Main Constructor
    public GemPolisherScreenHandler(int syncId, PlayerInventory playerInventory, BlockEntity blockEntity, PropertyDelegate propertyDelegate) {
        super(ModScreenHandlerType.GEM_POLISHING_SCREEN_HANDLER, syncId);
        checkSize((Inventory) blockEntity, 15);

        this.inventory = ((Inventory) blockEntity);
        this.context = ScreenHandlerContext.create(blockEntity.getWorld(), blockEntity.getPos());
        this.propertyDelegate = propertyDelegate;
        this.blockEntity = (GemPolisherBlockEntity) blockEntity;

        this.addSlot(new Slot(inventory, 0, 83, 13));
        this.addSlot(new Slot(inventory, 1, 83, 61));
        this.addSlot(new Slot(inventory, 2, 39, 36));
        this.addSlot(new Slot(inventory, 3, 150, 8));
        this.addSlot(new Slot(inventory, 4, 150, 26));
        this.addSlot(new Slot(inventory, 5, 150, 44));
        this.addSlot(new Slot(inventory, 6, 150, 62));
        this.addSlot(new Slot(inventory, 7, 132, 8));
        this.addSlot(new Slot(inventory, 8, 132, 26));
        this.addSlot(new Slot(inventory, 9, 132, 44));
        this.addSlot(new Slot(inventory, 10, 132, 62));
        this.addSlot(new Slot(inventory, 11, 114, 8));
        this.addSlot(new Slot(inventory, 12, 114, 26));
        this.addSlot(new Slot(inventory, 13, 114, 44));
        this.addSlot(new Slot(inventory, 14, 114, 62));

        addPlayerGenericInventory(playerInventory);
        addPlayerHotbarInventory(playerInventory);

        addProperties(propertyDelegate);
    }

    public boolean isPolishing() {
        return propertyDelegate.get(0) > 0;
    }

    public int progressGetter() {
        int progress = this.propertyDelegate.get(0);
        int maxProgress = this.propertyDelegate.get(1);  // Max Progress
        int progressArrowSize = 26; // This is the width in pixels of your arrow

        return maxProgress != 0 && progress != 0 ? progress * progressArrowSize / maxProgress : 0;
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int invSlot) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return canUse(this.context, player, ModBlocks.GEM_POLISHER_BLOCK);
    }

    @Override
    public void addPlayerGenericInventory(PlayerInventory playerInventory) {
        for (int i = 0; i < 3; ++i) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, 84 + i * 18));
            }
        }
    }

    @Override
    public void addPlayerHotbarInventory(PlayerInventory playerInventory) {
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
        }
    }

    @Override
    public BlockEntity getBlockEntity(BlockPos pos, BlockState state, World world) {
        return this.blockEntity;
    }

    public long getEnergy() {
        return this.blockEntity.energyStorage.getAmount();
    }

    public long getMaxEnergy() {
        return this.blockEntity.energyStorage.getCapacity();
    }

    public float getEnergyPercent() {
        SimpleEnergyStorage energyStorage = this.blockEntity.energyStorage;
        long energy = energyStorage.getAmount();
        long maxEnergy = energyStorage.getCapacity();
        if (maxEnergy == 0 || energy == 0)
            return 0.0F;

        return MathHelper.clamp((float) energy / (float) maxEnergy, 0.0F, 1.0F);
    }
}
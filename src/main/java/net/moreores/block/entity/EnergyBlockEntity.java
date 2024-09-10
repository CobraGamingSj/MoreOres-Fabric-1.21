//package net.moreores.block.entity;
//
//import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
//import net.minecraft.block.BlockState;
//import net.minecraft.block.entity.BlockEntity;
//import net.minecraft.block.entity.BlockEntityType;
//import net.minecraft.entity.player.PlayerEntity;
//import net.minecraft.entity.player.PlayerInventory;
//import net.minecraft.item.ItemStack;
//import net.minecraft.screen.ScreenHandler;
//import net.minecraft.server.network.ServerPlayerEntity;
//import net.minecraft.text.Text;
//import net.minecraft.util.collection.DefaultedList;
//import net.minecraft.util.math.BlockPos;
//import org.jetbrains.annotations.Nullable;
//
//public class EnergyBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory, ImplementedInventory {
//    public EnergyBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
//        super(type, pos, state);
//    }
//
//    @Override
//    public Object getScreenOpeningData(ServerPlayerEntity player) {
//        return null;
//    }
//
//    @Override
//    public Text getDisplayName() {
//        return Text.translatable("block.moreores.energy_block");
//    }
//
//    @Override
//    public @Nullable ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
//        return null;
//    }
//
//    @Override
//    public DefaultedList<ItemStack> getItems() {
//        return null;
//    }
//
//    @Override
//    public int size() {
//        return 2;
//    }
//}

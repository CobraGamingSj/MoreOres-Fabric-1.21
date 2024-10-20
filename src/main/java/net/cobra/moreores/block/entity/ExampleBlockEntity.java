//package net.cobra.moreores.block.entity;
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
//import net.minecraft.world.World;
//import org.jetbrains.annotations.Nullable;
//
//public class ExampleBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory, ImplementedInventory {
//    public ExampleBlockEntity(BlockPos pos, BlockState state) {
//        super(ModBlockEntityType.EXAMPLE_BLOCK_ENTITY, pos, state);
//    }
//
//    @Override
//    public Object getScreenOpeningData(ServerPlayerEntity serverPlayerEntity) {
//        return null;
//    }
//
//    @Override
//    public Text getDisplayName() {
//        return null;
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
//    public void tick(World world, BlockPos pos, BlockState state) {
//        if (world.isClient()) {
//            return;
//        }
//    }
//}

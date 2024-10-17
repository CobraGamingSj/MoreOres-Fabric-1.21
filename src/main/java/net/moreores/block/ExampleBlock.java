//package net.moreores.block;
//
//import com.mojang.serialization.MapCodec;
//import net.minecraft.block.BlockEntityProvider;
//import net.minecraft.block.BlockState;
//import net.minecraft.block.BlockWithEntity;
//import net.minecraft.block.entity.BlockEntity;
//import net.minecraft.block.entity.BlockEntityTicker;
//import net.minecraft.block.entity.BlockEntityType;
//import net.minecraft.util.math.BlockPos;
//import net.minecraft.world.World;
//import net.moreores.block.entity.ExampleBlockEntity;
//import net.moreores.block.entity.ModBlockEntityType;
//import org.jetbrains.annotations.Nullable;
//
//public class ExampleBlock extends BlockWithEntity implements BlockEntityProvider {
//    private static final MapCodec<ExampleBlock> CODEC = ExampleBlock.createCodec(ExampleBlock::new);
//    protected ExampleBlock(Settings settings) {
//        super(settings);
//    }
//
//    @Override
//    protected MapCodec<? extends BlockWithEntity> getCodec() {
//        return CODEC;
//    }
//
//    @Override
//    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
//        return new ExampleBlockEntity(pos, state);
//    }
//
//    @Override
//    public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
//        return validateTicker(type, ModBlockEntityType.EXAMPLE_BLOCK_ENTITY, (world1, pos, state1, blockEntity) -> blockEntity.tick(world1, pos, state1));
//    }
//}

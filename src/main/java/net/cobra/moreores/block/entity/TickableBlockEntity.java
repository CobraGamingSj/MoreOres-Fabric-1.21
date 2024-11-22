package net.cobra.moreores.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public interface TickableBlockEntity {

    void tick(World world, BlockPos pos, BlockState state);

    static <T extends BlockEntity> BlockEntityTicker<T> getTicker(World Pworld, BlockState pState, BlockEntityType<T> type) {
        return Pworld.isClient ? null : (world, pos, state, blockEntity) -> {
            if (blockEntity instanceof TickableBlockEntity tickableBlockEntity) {
                tickableBlockEntity.tick(world, pos, state);
            }
        };
    }
}

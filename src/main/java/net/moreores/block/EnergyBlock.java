package net.moreores.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;

public class EnergyBlock extends Block{
    public EnergyBlock(Settings settings) {
        super(settings);
    }

//    @Nullable
//    @Override
//    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
//        return new EnergyBlockEntity(pos, state);
//    }
//
//    @Nullable
//    @Override
//    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
//        return world.isClient ? null : (BlockEntityTicker<T>) (world1, pos, state1, blockEntity) -> {
//            if (blockEntity instanceof EnergyBlockEntity energyBlockEntity) {
//                EnergyBlockEntity.tick(world1, pos, state1, energyBlockEntity);
//            }
//        };
//    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        if (!world.isClient && world instanceof ServerWorld serverWorld) {
            if (pos.getY() == world.getSeaLevel()) {
                serverWorld.setWeather(0, 6000, true, true);
            }
        }
        super.onPlaced(world, pos, state, placer, itemStack);
    }

    @Override
    public void onBroken(WorldAccess world, BlockPos pos, BlockState state) {
        if (!world.isClient() && world instanceof ServerWorld serverWorld) {
            serverWorld.setWeather(6000, 0, false, false);
        }
        super.onBroken(world, pos, state);
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if (!world.isClient()) {
            if (entity instanceof LivingEntity livingEntity) {
                livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE, 20, 1, false, false));
                livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, 100, 1, false, false));
                livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 100, 1, false, false));
                world.playSound(null, livingEntity.getX(), livingEntity.getY(), livingEntity.getZ(), SoundEvents.ENTITY_PLAYER_HURT, SoundCategory.PLAYERS, 5.0f, 1.0f);
            }
        }

        super.onSteppedOn(world, pos, state, entity);
    }

//    @Override
//    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType options) {
//        tooltip.add(Text.translatable("tooltip.moreores.energy_block").formatted(Formatting.GRAY));
//        super.appendTooltip(stack, context, tooltip, options);
//    }
}

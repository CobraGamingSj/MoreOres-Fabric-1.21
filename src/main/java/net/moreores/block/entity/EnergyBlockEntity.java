package net.moreores.block.entity;//package net.moreores.block.entity;
//
//import net.minecraft.block.entity.BlockEntity;
//import net.minecraft.entity.EntityType;
//import net.minecraft.entity.LightningEntity;
//import net.minecraft.entity.mob.HostileEntity;
//import net.minecraft.predicate.entity.EntityPredicates;
//import net.minecraft.server.world.ServerWorld;
//import net.minecraft.util.math.BlockPos;
//import net.minecraft.util.math.Box;
//import net.minecraft.util.math.Vec3d;
//import net.minecraft.world.World;
//import net.moreores.MoreOres;
//
//import java.util.List;
//
//public class EnergyBlockEntity extends BlockEntity {
//    private static final int LIGHTNING_RADIUS = 10;
//
//    public EnergyBlockEntity(BlockPos pos, net.minecraft.block.BlockState state) {
//        super(ModBlockEntities.ENERGY_BLOCK_ENTITY, pos, state);
//    }
//
//    public static void tick(World world, BlockPos pos, net.minecraft.block.BlockState state, EnergyBlockEntity be) {
//        if (world instanceof ServerWorld serverWorld) {
//            // Convert BlockPos to Vec3d for creating the bounding box
//            Vec3d minPos = new Vec3d(pos.getX() - LIGHTNING_RADIUS, pos.getY() - LIGHTNING_RADIUS, pos.getZ() - LIGHTNING_RADIUS);
//            Vec3d maxPos = new Vec3d(pos.getX() + LIGHTNING_RADIUS, pos.getY() + LIGHTNING_RADIUS, pos.getZ() + LIGHTNING_RADIUS);
//
//            // Find hostile entities within the bounding box
//            List<HostileEntity> hostileEntities = serverWorld.getEntitiesByClass(HostileEntity.class,
//                    new Box(minPos, maxPos),
//                    EntityPredicates.VALID_ENTITY);
//
//            // Spawn lightning at the location of each hostile mob
//            for (HostileEntity hostileEntity : hostileEntities) {
//                LightningEntity lightningEntity = new LightningEntity(EntityType.LIGHTNING_BOLT, world);
//                lightningEntity.setPos(hostileEntity.getX(), hostileEntity.getY(), hostileEntity.getZ());
//                serverWorld.spawnEntity(lightningEntity);
//            }
//        }
//    }
//}

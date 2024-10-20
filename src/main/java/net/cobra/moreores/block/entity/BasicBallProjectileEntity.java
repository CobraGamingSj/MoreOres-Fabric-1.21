//package net.cobra.moreores.block.entity;
//
//import net.minecraft.entity.Entity;
//import net.minecraft.entity.EntityType;
//import net.minecraft.entity.LivingEntity;
//import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
//import net.minecraft.item.Item;
//import net.minecraft.network.listener.ClientPlayPacketListener;
//import net.minecraft.network.packet.Packet;
//import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
//import net.minecraft.server.network.EntityTrackerEntry;
//import net.minecraft.world.World;
//
//public class BasicBallProjectileEntity extends ThrownItemEntity {
//    public BasicBallProjectileEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
//        super(entityType, world);
//    }
//
//    public BasicBallProjectileEntity(LivingEntity livingEntity, World world) {
//        super(ModBlockEntityType.BASIC_BALL, livingEntity, world);
//    }
//
//
//
//    @Override
//    protected Item getDefaultItem() {
//        return null;
//    }
//
//    @Override
//    public Packet<ClientPlayPacketListener> createSpawnPacket(EntityTrackerEntry entityTrackerEntry) {
//        return new EntitySpawnS2CPacket(this, entityTrackerEntry);
//    }
//}

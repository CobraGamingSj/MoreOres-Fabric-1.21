//package net.cobra.moreores.entity.mob;
//
//import net.minecraft.entity.EntityType;
//import net.minecraft.entity.LivingEntity;
//import net.minecraft.entity.ai.goal.*;
//import net.minecraft.entity.attribute.DefaultAttributeContainer;
//import net.minecraft.entity.attribute.EntityAttributes;
//import net.minecraft.entity.data.DataTracker;
//import net.minecraft.entity.data.TrackedDataHandlerRegistry;
//import net.minecraft.entity.mob.BlazeEntity;
//import net.minecraft.entity.mob.HostileEntity;
//import net.minecraft.entity.mob.MobEntity;
//import net.minecraft.entity.player.PlayerEntity;
//import net.minecraft.world.World;
//
//import java.util.EnumSet;
//
//public class ThunderEntity extends HostileEntity {
////    public final DataTracker dataTracker;
//    public ThunderEntity(EntityType<? extends HostileEntity> entityType, World world) {
//        super(entityType, world);
//    }
//
//    public static DefaultAttributeContainer.Builder createThunderEntityAttributes() {
//        return HostileEntity.createMobAttributes()
//                .add(EntityAttributes.GENERIC_MAX_HEALTH, 40)
//                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.5)
//                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 8)
//                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 64);
//    }
//
////    private static class ShootThunderChargeGoal extends Goal {
////        private final ThunderEntity thunder;
////        private int fireballsFired;
////        private int fireballCooldown;
////        private int targetNotVisibleTicks;
////
////        public ShootThunderChargeGoal(ThunderEntity thunder) {
////            this.thunder = thunder;
////            this.setControls(EnumSet.of(Goal.Control.MOVE, Goal.Control.LOOK));
////        }
////
////        void setFireActive(boolean fireActive) {
////            byte b = (Byte)this.dataTracker.get(BLAZE_FLAGS);
////            if (fireActive) {
////                b = (byte)(b | 1);
////            } else {
////                b &= -2;
////            }
////
////            this.dataTracker.set(BLAZE_FLAGS, b);
////        }
////
////        static {
////            BLAZE_FLAGS = DataTracker.registerData(BlazeEntity.class, TrackedDataHandlerRegistry.BYTE);
////        }
//
////        @Override
////        public boolean canStart() {
////            LivingEntity livingEntity = this.thunder.getTarget();
////            return livingEntity != null && livingEntity.isAlive() && this.thunder.canTarget(livingEntity);
////        }
////
////        @Override
////        public void stop() {
////            this.thunder.setFireActive
////            this.targetNotVisibleTicks = 0;
////        }
////
////        @Override
////        public boolean shouldRunEveryTick() {
////            return true;
////        }
////    }
//
//
//
//    @Override
//    protected void initGoals() {
//        this.goalSelector.add(5, new GoToWalkTargetGoal(this, 1.5));
//        this.goalSelector.add(7, new WanderAroundFarGoal(this, 0.5, 0.0F));
//        this.goalSelector.add(8, new LookAtEntityGoal(this, PlayerEntity.class, 15.0F));
//        this.goalSelector.add(8, new LookAroundGoal(this));
//        this.targetSelector.add(1, (new RevengeGoal(this, new Class[0])).setGroupRevenge(new Class[0]));
//        this.targetSelector.add(2, new ActiveTargetGoal(this, PlayerEntity.class, true));
//    }
//}

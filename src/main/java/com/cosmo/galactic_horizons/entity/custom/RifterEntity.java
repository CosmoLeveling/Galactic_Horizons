package com.cosmo.galactic_horizons.entity.custom;

import net.minecraft.block.BlockState;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.EntityView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class RifterEntity extends TameableEntity {

	public final AnimationState idleAnimationState = new AnimationState();
	public final AnimationState ChaseingAnimationState = new AnimationState();
	public final AnimationState ChaseingStartAnimationState = new AnimationState();
	public final AnimationState ChaseingEndAnimationState = new AnimationState();
	private int idleAnimationTimeout = 0;
	private int chaseingAnimationTimeout = 0;
	public static LivingEntity targ;

	public RifterEntity(EntityType<? extends TameableEntity> entityType, World world) {
		super(entityType, world);
	}

	@Override
	public void setTarget(@Nullable LivingEntity target) {
		super.setTarget(target);
		targ = target;
	}
	private void setupAnimationStates() {
		if (targ != null){
			this.idleAnimationState.stop();
			this.ChaseingAnimationState.restart(this.age);
		}else {
			if (this.idleAnimationTimeout <= 0) {
				this.idleAnimationTimeout = 30;
				this.idleAnimationState.restart(this.age);
			} else {
				--this.idleAnimationTimeout;
			}
			this.ChaseingAnimationState.stop();
		}
	}
	protected void updateLimbs(float limbDistance) {
		float f;
		if (this.getPose() == EntityPose.STANDING) {
			f = Math.min(limbDistance * 6.0F, 1.0F);
		} else {
			f = 0.0F;
		}

		this.limbData.updateLimbs(f, 0.2F);
	}

	@Override
	public void tickMovement() {
		super.tickMovement();
		Vec3d vec3d = this.getVelocity();
		if (!this.isOnGround() && vec3d.y < 0.0) {
			this.setVelocity(vec3d.multiply(1.0, 0.6, 1.0));
		}
	}

	@Override
	public void tick() {
		super.tick();
		if(this.getWorld().isClient){
			setupAnimationStates();
		}
	}

	@Override
	protected void fall(double fallDistance, boolean onGround, BlockState landedState, BlockPos landedPosition) {
	}

	@Override
	protected void initGoals() {
		this.goalSelector.add(0,new SwimGoal(this));
		this.goalSelector.add(8, new LookAtEntityGoal(this, PlayerEntity.class, 100.0F));
		this.goalSelector.add(8, new LookAroundGoal(this));
		this.goalSelector.add(2,new WanderAroundFarGoal(this,1.0f,0.0f));
		this.initCustomGoals();
	}

	protected void initCustomGoals() {
		this.goalSelector.add(1,new MeleeAttackGoal(this,3,false));
		this.targetSelector.add(2, new TargetGoal<>(this, PlayerEntity.class, false));
		//Just for testing vvv
		this.targetSelector.add(2, new TargetGoal<>(this, PigEntity.class, false));
	}

	public static DefaultAttributeContainer.Builder createRifterAttributes(){
		return HostileEntity.createAttributes()
			.add(EntityAttributes.GENERIC_MAX_HEALTH,30)
			.add(EntityAttributes.GENERIC_MOVEMENT_SPEED,0.2f)
			.add(EntityAttributes.GENERIC_ARMOR,0.5f)
			.add(EntityAttributes.GENERIC_FOLLOW_RANGE,50)
			.add(EntityAttributes.GENERIC_ATTACK_DAMAGE,4);
	}

	@Nullable
	@Override
	protected SoundEvent getAmbientSound() {
		return SoundEvents.ENTITY_ENDERMAN_AMBIENT;
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource source) {
		return SoundEvents.ENTITY_ENDERMAN_HURT;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return SoundEvents.ENTITY_ENDERMAN_DEATH;
	}

	@Override
	public EntityView getEntityView() {
		return null;
	}

	@Nullable
	@Override
	public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
		return null;
	}
}

package com.cosmo.galactic_horizons.effect;

import com.cosmo.galactic_horizons.GalacticHorizons;
import com.cosmo.galactic_horizons.particle.ModParticles;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffectType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.quiltmc.qsl.entity.effect.api.StatusEffectRemovalReason;
import org.quiltmc.qsl.networking.api.PacketByteBufs;
import org.quiltmc.qsl.networking.api.ServerPlayNetworking;

import static com.cosmo.galactic_horizons.networking.ModMessages.INVISIBILITY_REMOVE_UPDATE_PACKET_ID;
import static com.cosmo.galactic_horizons.networking.ModMessages.INVISIBILITY_UPDATE_PACKET_ID;

public class RealityTearEffect extends StatusEffect {
	protected RealityTearEffect(StatusEffectType type, int color) {
		super(type, color);
	}

	@Override
	public void applyUpdateEffect(LivingEntity entity, int amplifier) {
		Vec3d lookDir =entity.getRotationVec(1f);
		entity.setVelocity(lookDir.x, lookDir.y, lookDir.z);
		World world = entity.getWorld();
		if (entity instanceof PlayerEntity) {
			entity.noClip = true;
			entity.setOnGround(false);
		}

	}


	@Override
	public void onApplied(LivingEntity entity, AttributeContainer attributes, int amplifier) {
		if(entity instanceof ServerPlayerEntity) {
				((ServerPlayerEntity) entity).getAbilities().invulnerable = true;
				((ServerPlayerEntity) entity).getAbilities().allowModifyWorld = false;
				((ServerPlayerEntity) entity).sendAbilitiesUpdate();
		}
		if (entity.getWorld() instanceof ServerWorld serverWorld) {
			serverWorld.spawnParticles(ModParticles.REALITY_PARTICLE,entity.getBlockX(),entity.getBlockY(),entity.getBlockZ(),10,0.15,0.15,0.15,1);
		}
	}

	@Override
	public void onRemoved(@NotNull LivingEntity entity, @NotNull AttributeContainer attributes, @NotNull StatusEffectInstance effect, @NotNull StatusEffectRemovalReason reason) {
		if (entity instanceof ServerPlayerEntity) {
			if (!((ServerPlayerEntity) entity).isCreative() && !entity.isSpectator()) {
				((ServerPlayerEntity) entity).getAbilities().invulnerable = false;
			}
			((ServerPlayerEntity) entity).getAbilities().allowModifyWorld = true;
			((ServerPlayerEntity) entity).sendAbilitiesUpdate();
		}

	}

	@Override
	public boolean canApplyUpdateEffect(int duration, int amplifier) {
		return true;
	}
}

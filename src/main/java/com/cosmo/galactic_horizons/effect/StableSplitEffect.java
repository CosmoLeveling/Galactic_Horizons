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
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.quiltmc.qsl.entity.effect.api.StatusEffectRemovalReason;
import org.quiltmc.qsl.networking.api.PacketByteBufs;
import org.quiltmc.qsl.networking.api.ServerPlayNetworking;

import static com.cosmo.galactic_horizons.networking.ModMessages.INVISIBILITY_REMOVE_UPDATE_PACKET_ID;
import static com.cosmo.galactic_horizons.networking.ModMessages.INVISIBILITY_UPDATE_PACKET_ID;

public class StableSplitEffect extends StatusEffect {
	protected StableSplitEffect(StatusEffectType type, int color) {
		super(type, color);
	}

	@Override
	public void applyUpdateEffect(LivingEntity entity, int amplifier) {
		float f = entity.getYaw();
		float g = entity.getPitch();
		float h = -MathHelper.sin(f * 0.017453292F) * MathHelper.cos(g * 0.017453292F);
		float k = -MathHelper.sin(g * 0.017453292F);
		float l = MathHelper.cos(f * 0.017453292F) * MathHelper.cos(g * 0.017453292F);
		float m = MathHelper.sqrt(h * h + k * k + l * l);
		float n = 2.0F * ((1.0F + (float) 1) / 4.0F);
		h *= n / m;
		k *= n / m;
		l *= n / m;
		//entity.setVelocity(h, k, l);
		World world = entity.getWorld();
		//if (entity instanceof PlayerEntity) {
		//	entity.noClip = true;
		//	entity.setOnGround(false);
		//}
		if (entity.getWorld() instanceof ServerWorld serverWorld) {
			serverWorld.spawnParticles(ModParticles.SPLIT_PARTICLE,entity.getBlockX(),entity.getBlockY(),entity.getBlockZ(),10,0.15,0.15,0.15,1);
		}
	}


	@Override
	public void onApplied(LivingEntity entity, AttributeContainer attributes, int amplifier) {
		if(entity instanceof ServerPlayerEntity) {
				((ServerPlayerEntity) entity).getAbilities().invulnerable = true;
				((ServerPlayerEntity) entity).getAbilities().allowModifyWorld = false;
				((ServerPlayerEntity) entity).sendAbilitiesUpdate();
		}
		GalacticHorizons.livingEntities.add(entity.getUuid());
		System.out.println(GalacticHorizons.livingEntities);
		syncList(entity,1);
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
		GalacticHorizons.livingEntities.remove(entity.getUuid());
		syncList(entity,2);
	}

	@Override
	public boolean canApplyUpdateEffect(int duration, int amplifier) {
		return true;
	}

	public static void syncList( LivingEntity entity,int test) {
		if (entity.getServer() != null) {
			PacketByteBuf buf = PacketByteBufs.create();
			buf.writeUuid(entity.getUuid());
			if (test == 1) {
				entity.getServer().getPlayerManager().sendToAll(ServerPlayNetworking.createS2CPacket(INVISIBILITY_UPDATE_PACKET_ID, buf));
			} else {
				entity.getServer().getPlayerManager().sendToAll(ServerPlayNetworking.createS2CPacket(INVISIBILITY_REMOVE_UPDATE_PACKET_ID,buf));
			}
		}
	}
}

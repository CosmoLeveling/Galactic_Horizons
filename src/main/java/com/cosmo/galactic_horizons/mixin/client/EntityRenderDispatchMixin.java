package com.cosmo.galactic_horizons.mixin.client;


import com.cosmo.galactic_horizons.effect.ModEffects;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.cosmo.galactic_horizons.GalacticHorizonsClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.world.WorldView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EntityRenderDispatcher.class)
public class EntityRenderDispatchMixin {
	@Inject(method = "renderShadow", at = @At("HEAD"),cancellable = true)
	private static void renderShadow(MatrixStack matrices, VertexConsumerProvider vertexConsumers, Entity entity, float opacity, float tickDelta, WorldView world, float radius, CallbackInfo ci){
		if (GalacticHorizonsClient.entities.contains(entity.getUuid())) ci.cancel();
	}
	@Inject(method = "renderHitbox", at = @At("HEAD"),cancellable = true)
	private static void renderHitbox(MatrixStack matrices, VertexConsumer vertices, Entity entity, float tickDelta, CallbackInfo ci) {
		if(entity instanceof LivingEntity) {
			if (((LivingEntity) entity).getStatusEffects() != null && ((LivingEntity) entity).hasStatusEffect(ModEffects.REALITY_TEAR) || ((LivingEntity) entity).hasStatusEffect(ModEffects.REALITY_SPLIT))
				ci.cancel();
		}
	}
	@Inject(method = "renderFire",at = @At("HEAD"),cancellable = true)
	private void renderFire(MatrixStack matrices, VertexConsumerProvider vertexConsumers, Entity entity, CallbackInfo ci) {
		if(GalacticHorizonsClient.entities.contains(entity.getUuid())) ci.cancel();
	}
}

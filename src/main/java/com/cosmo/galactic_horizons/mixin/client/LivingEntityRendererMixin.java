package com.cosmo.galactic_horizons.mixin.client;

import com.cosmo.galactic_horizons.GalacticHorizonsClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntityRenderer.class)
public abstract class LivingEntityRendererMixin {
	@Inject(method = "render(Lnet/minecraft/entity/LivingEntity;FFLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V", at = @At("HEAD"),cancellable = true)
	private void invisibleRender(LivingEntity entity, float f, float g, MatrixStack matrixStack,
								 VertexConsumerProvider vertexConsumerProvider, int i, CallbackInfo ci) {
		if (entity != null && GalacticHorizonsClient.entities.contains(entity.getUuid())){
			ci.cancel();
		}
	}
}

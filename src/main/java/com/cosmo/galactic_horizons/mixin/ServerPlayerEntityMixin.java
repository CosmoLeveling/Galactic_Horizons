package com.cosmo.galactic_horizons.mixin;

import com.cosmo.galactic_horizons.PlayerDamageCallback;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.server.network.ServerPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ServerPlayerEntity.class)
public abstract class ServerPlayerEntityMixin {

	@Shadow
	public abstract boolean isInvulnerableTo(DamageSource damageSource);

	@Inject(method = "damage", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/player/PlayerEntity;damage(Lnet/minecraft/entity/damage/DamageSource;F)Z")
	)
	private void onDamage(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
		PlayerDamageCallback.EVENT.invoker().invoke((ServerPlayerEntity) (Object) this, source, amount);
	}

}

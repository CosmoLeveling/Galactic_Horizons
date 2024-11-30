package com.cosmo.galactic_horizons.mixin;


import com.cosmo.galactic_horizons.effect.GalacticHorizonsEffects;
import com.cosmo.galactic_horizons.entity.custom.RifterEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {
	@Shadow
	public abstract boolean hasStatusEffect(StatusEffect effect);

	@Inject(method = "updatePotionVisibility", at = @At("HEAD"),cancellable = true)
	private void hasSplit(CallbackInfo ci){
		if(!this.hasStatusEffect(null)&this.hasStatusEffect(GalacticHorizonsEffects.REALITY_TEAR)||this.hasStatusEffect(GalacticHorizonsEffects.REALITY_SPLIT)){
			ci.cancel();
		}
	}

	@Inject(method = "damage", at = @At("HEAD"), cancellable = true)
	private void Damage(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
		if ((this.hasStatusEffect(GalacticHorizonsEffects.REALITY_SPLIT) || this.hasStatusEffect(GalacticHorizonsEffects.REALITY_TEAR)) && !(source.getSource() instanceof RifterEntity)) {
			cir.setReturnValue(Boolean.FALSE);
		}
	}
}

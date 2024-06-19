package com.cosmo.galactic_horizons.mixin;


import com.cosmo.galactic_horizons.effect.ModEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {
	@Shadow
	public abstract boolean hasStatusEffect(StatusEffect effect);

	@Inject(method = "updatePotionVisibility", at = @At("HEAD"),cancellable = true)
	private void hasSplit(CallbackInfo ci){
		if(this.hasStatusEffect(ModEffects.REALITY_TEAR)||this.hasStatusEffect(ModEffects.REALITY_SPLIT)){
			ci.cancel();
		}
	}
}

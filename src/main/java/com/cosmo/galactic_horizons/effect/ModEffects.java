package com.cosmo.galactic_horizons.effect;

import com.cosmo.galactic_horizons.GalacticHorizons;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectType;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEffects extends StatusEffects {
	public static StatusEffect SPLIT;

	public static StatusEffect registerStatusEffect(String name) {
		return Registry.register(Registries.STATUS_EFFECT, new Identifier(GalacticHorizons.MOD_ID, name),
			new SplitEffect(StatusEffectType.NEUTRAL, 6422641));
	}

	public static void registerEffects() {
		SPLIT = registerStatusEffect("split");
	}
}

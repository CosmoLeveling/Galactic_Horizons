package com.cosmo.galactic_horizons.potion;

import com.cosmo.galactic_horizons.GalacticHorizons;
import com.cosmo.galactic_horizons.effect.ModEffects;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffectType;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModPotions {
	public static Potion SPLIT_POTION;
	public static Potion STABLE_SPLIT_POTION;

	public static Potion registerPotion(String name, StatusEffect effect,int duration,int Modifier) {
		return Registry.register(Registries.POTION, new Identifier(GalacticHorizons.MOD_ID,name),
			new Potion(new StatusEffectInstance(effect, duration, Modifier)));
	}

	public static void  registerPotions() {
		SPLIT_POTION = registerPotion("split",ModEffects.SPLIT,200,0);
		STABLE_SPLIT_POTION = registerPotion("stable_split",ModEffects.STABLE_SPLIT,200,0);
	}
}

package com.cosmo.galactic_horizons.potion;

import com.cosmo.galactic_horizons.GalacticHorizons;
import com.cosmo.galactic_horizons.effect.ModEffects;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModPotions {
	public static Potion SPLIT_POTION;

	public static Potion registerPotion(String name) {
		return Registry.register(Registries.POTION, new Identifier(GalacticHorizons.MOD_ID,name),
			new Potion(new StatusEffectInstance(ModEffects.SPLIT, 200, 0)));
	}

	public static void  registerPotions() {
		SPLIT_POTION = registerPotion("split");
	}
}

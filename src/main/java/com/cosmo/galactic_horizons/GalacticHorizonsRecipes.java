package com.cosmo.galactic_horizons;

import com.cosmo.galactic_horizons.block.entity.DimensionalMergingRecipe;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class GalacticHorizonsRecipes {
	public static void RegisterRecipes() {
		Registry.register(Registries.RECIPE_SERIALIZER, new Identifier(GalacticHorizons.MOD_ID, DimensionalMergingRecipe.Serializer.NAME), DimensionalMergingRecipe.Serializer.INSTANCE);
		Registry.register(Registries.RECIPE_TYPE, new Identifier(GalacticHorizons.MOD_ID, DimensionalMergingRecipe.NAME), DimensionalMergingRecipe.Type.INSTANCE);
	}
}

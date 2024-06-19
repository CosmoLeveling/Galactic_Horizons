package com.cosmo.galactic_horizons.world;

import com.cosmo.galactic_horizons.GalacticHorizons;
import net.minecraft.registry.Holder;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.BootstrapContext;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.HeightRangePlacementModifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacementModifier;

import java.util.List;

public class ModPlacedFeatures {
	public static final RegistryKey<PlacedFeature> ETERNIUM_ORE_PLACED_KEY = registerKey("eternium_ore_placed");
	public static final RegistryKey<PlacedFeature> END_ETERNIUM_ORE_PLACED_KEY = registerKey("end_eternium_ore_placed");

	public static void bootstrap(BootstrapContext<PlacedFeature> context) {
		var configuredFeatureRegistryEntryLookup = context.lookup(RegistryKeys.CONFIGURED_FEATURE);

		register(context, ETERNIUM_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getHolderOrThrow(ModConfiguredFeatures.ETERNIUM_ORE_KEY),
			ModOrePlacement.commonOrePlacementModifiers(6,
				HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-80), YOffset.aboveBottom(80))));
		register(context, END_ETERNIUM_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getHolderOrThrow(ModConfiguredFeatures.END_ETERNIUM_ORE_KEY),
			ModOrePlacement.commonOrePlacementModifiers(6,
				HeightRangePlacementModifier.createUniform(YOffset.fixed(-80), YOffset.fixed(80))));
	}

	public static RegistryKey<PlacedFeature> registerKey(String name) {
		return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(GalacticHorizons.MOD_ID, name));
	}

	private static void register(BootstrapContext<PlacedFeature> context, RegistryKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
								 List<PlacementModifier> modifiers) {
		context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
	}
}

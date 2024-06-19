package com.cosmo.galactic_horizons.world;

import com.cosmo.galactic_horizons.GalacticHorizons;
import com.cosmo.galactic_horizons.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.BootstrapContext;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;

import java.util.List;

public class ModConfiguredFeatures {
	public static final RegistryKey<ConfiguredFeature<?,?>> ETERNIUM_ORE_KEY = registryKey("eternium_ore");
	public static final RegistryKey<ConfiguredFeature<?,?>> END_ETERNIUM_ORE_KEY = registryKey("end_eternium_ore");

	public static void bootstrap(BootstrapContext<ConfiguredFeature<?,?>> context) {
		RuleTest stoneReplaceables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
		RuleTest deepslateReplaceables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
		RuleTest endReplaceables = new BlockMatchRuleTest(Blocks.END_STONE);

		List<OreFeatureConfig.Target> overworldEterniumOre =
			List.of(OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.ETERNIUM_ORE.getDefaultState()),
					OreFeatureConfig.createTarget(deepslateReplaceables,ModBlocks.DEEPSLATE_ETERNIUM_ORE.getDefaultState()));
		List<OreFeatureConfig.Target> endEterniumOre =
			List.of(OreFeatureConfig.createTarget(endReplaceables, ModBlocks.END_ETERNIUM_ORE.getDefaultState()));

		register(context, ETERNIUM_ORE_KEY,Feature.ORE, new OreFeatureConfig(overworldEterniumOre,6,0.5f));
		register(context, END_ETERNIUM_ORE_KEY,Feature.ORE, new OreFeatureConfig(endEterniumOre,6,0.5f));
	}

	public static RegistryKey<ConfiguredFeature<?, ?>> registryKey(String name) {
		return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE,new Identifier(GalacticHorizons.MOD_ID, name));
	}

	private static <FC extends FeatureConfig, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
																				   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
		context.register(key, new ConfiguredFeature<>(feature, configuration));
	}
}

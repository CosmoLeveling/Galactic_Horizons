package com.cosmo.galactic_horizons.datagen;

import com.cosmo.galactic_horizons.block.ModBlocks;
import com.cosmo.galactic_horizons.effect.ModEffects;
import com.cosmo.galactic_horizons.entity.ModEntities;
import com.cosmo.galactic_horizons.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

public class ModEnUsProvider extends FabricLanguageProvider {
	public ModEnUsProvider(FabricDataOutput dataOutput) {
		super(dataOutput);
	}

	@Override
	public void generateTranslations(TranslationBuilder translationBuilder) {
		translationBuilder.add(ModItems.Stable_Corrupted_Chorus, "Stable Corrupted Chorus Fruit");
		translationBuilder.add(ModItems.Corrupted_Chorus, "Corrupted Chorus Fruit");
		translationBuilder.add(ModItems.RAW_ETERNIUM, "Raw Eternium");
		translationBuilder.add(ModItems.RIFTER_SPAWN_EGG, "Rifter Spawn Egg");
		translationBuilder.add(ModBlocks.DEEPSLATE_ETERNIUM_ORE, "Deepslate Eternium Ore");
		translationBuilder.add(ModBlocks.END_ETERNIUM_ORE, "End Eternium Ore");
		translationBuilder.add(ModBlocks.ETERNIUM_ORE, "Eternium Ore");
		translationBuilder.add(ModBlocks.DIMENSIONAL_CRAFTER, "Dimensional Crafter");
		translationBuilder.add(ModEntities.RIFTER, "Rifter");
		translationBuilder.add(ModEffects.REALITY_SPLIT, "Reality Split");
		translationBuilder.add(ModEffects.REALITY_TEAR, "Reality Tear");
	}
}

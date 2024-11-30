package com.cosmo.galactic_horizons.datagen;

import com.cosmo.galactic_horizons.block.GalacticHorizonsBlocks;
import com.cosmo.galactic_horizons.effect.GalacticHorizonsEffects;
import com.cosmo.galactic_horizons.entity.GalacticHorizonsEntities;
import com.cosmo.galactic_horizons.item.GalacticHorizonsItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

public class ModEnUsProvider extends FabricLanguageProvider {
	public ModEnUsProvider(FabricDataOutput dataOutput) {
		super(dataOutput);
	}

	@Override
	public void generateTranslations(TranslationBuilder translationBuilder) {
		translationBuilder.add(GalacticHorizonsItems.DOUSED_CHORUS, "Doused Chorus Fruit");
		translationBuilder.add(GalacticHorizonsItems.RAW_ETERNIUM, "Raw Eternium");
		translationBuilder.add(GalacticHorizonsItems.RIFTER_SPAWN_EGG, "Rifter Spawn Egg");
		translationBuilder.add(GalacticHorizonsBlocks.DEEPSLATE_ETERNIUM_ORE, "Deepslate Eternium Ore");
		translationBuilder.add(GalacticHorizonsBlocks.END_ETERNIUM_ORE, "End Eternium Ore");
		translationBuilder.add(GalacticHorizonsBlocks.ETERNIUM_ORE, "Eternium Ore");
		translationBuilder.add(GalacticHorizonsEntities.RIFTER, "§kRifter");
		translationBuilder.add(GalacticHorizonsEffects.REALITY_SPLIT, "Reality Split");
		translationBuilder.add(GalacticHorizonsEffects.REALITY_TEAR, "Reality Tear");
		translationBuilder.add(GalacticHorizonsItems.ETERNIUM_INGOT, "Eternium Ingot");
		translationBuilder.add(GalacticHorizonsItems.ETERNIUM_HELMET, "Eternium Helmet");
		translationBuilder.add(GalacticHorizonsItems.ETERNIUM_CHESTPLATE, "Eternium Chestplate");
		translationBuilder.add(GalacticHorizonsItems.ETERNIUM_LEGGINGS, "Eternium Leggings");
		translationBuilder.add(GalacticHorizonsItems.ETERNIUM_BOOTS, "Eternium Boots");
		translationBuilder.add(GalacticHorizonsBlocks.REALITY_CORE, "Reality Stabilizer");
		translationBuilder.add(GalacticHorizonsItems.ENDERMAN_BLOOD,"Enderman Blood");
		translationBuilder.add(GalacticHorizonsItems.ENDERMAN_BLOOD_VIAL,"Enderman Blood Vial");
	}
}

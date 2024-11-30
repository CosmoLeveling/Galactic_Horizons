package com.cosmo.galactic_horizons.datagen;

import com.cosmo.galactic_horizons.block.GalacticHorizonsBlocks;
import com.cosmo.galactic_horizons.item.GalacticHorizonsItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.model.BlockStateModelGenerator;
import net.minecraft.data.client.model.Model;
import net.minecraft.data.client.model.Models;
import net.minecraft.util.Identifier;

import java.util.Optional;

public class ModModelProvider extends FabricModelProvider {
	public ModModelProvider(FabricDataOutput output) {
		super(output);
	}

	@Override
	public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
		blockStateModelGenerator.registerSimpleCubeAll(GalacticHorizonsBlocks.ETERNIUM_ORE);
		blockStateModelGenerator.registerSimpleCubeAll(GalacticHorizonsBlocks.END_ETERNIUM_ORE);
		blockStateModelGenerator.registerSimpleCubeAll(GalacticHorizonsBlocks.DEEPSLATE_ETERNIUM_ORE);
	}

	@Override
	public void generateItemModels(ItemModelGenerator itemModelGenerator) {
		itemModelGenerator.register(GalacticHorizonsItems.RAW_ETERNIUM, Models.SINGLE_LAYER_ITEM);
		itemModelGenerator.register(GalacticHorizonsItems.ETERNIUM_INGOT, Models.SINGLE_LAYER_ITEM);
		itemModelGenerator.register(GalacticHorizonsItems.ETERNIUM_HELMET, Models.SINGLE_LAYER_ITEM);
		itemModelGenerator.register(GalacticHorizonsItems.ETERNIUM_CHESTPLATE, Models.SINGLE_LAYER_ITEM);
		itemModelGenerator.register(GalacticHorizonsItems.ETERNIUM_LEGGINGS, Models.SINGLE_LAYER_ITEM);
		itemModelGenerator.register(GalacticHorizonsItems.ETERNIUM_BOOTS, Models.SINGLE_LAYER_ITEM);
		itemModelGenerator.register(GalacticHorizonsItems.DOUSED_CHORUS, Models.SINGLE_LAYER_ITEM);
		itemModelGenerator.register(GalacticHorizonsItems.ENDERMAN_BLOOD_VIAL, Models.SINGLE_LAYER_ITEM);
		itemModelGenerator.register(GalacticHorizonsItems.ENDERMAN_BLOOD,Models.SINGLE_LAYER_ITEM);
		itemModelGenerator.register(GalacticHorizonsItems.RIFTER_SPAWN_EGG,
			new Model(Optional.of(new Identifier("item/template_spawn_egg")), Optional.empty()));
	}
}

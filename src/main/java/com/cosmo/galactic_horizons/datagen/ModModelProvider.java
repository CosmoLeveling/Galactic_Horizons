package com.cosmo.galactic_horizons.datagen;

import com.cosmo.galactic_horizons.block.ModBlocks;
import com.cosmo.galactic_horizons.item.ModItems;
import com.cosmo.galactic_horizons.particle.ModParticles;
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
		blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ETERNIUM_ORE);
		blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_ETERNIUM_ORE);
		blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.END_ETERNIUM_ORE);
	}

	@Override
	public void generateItemModels(ItemModelGenerator itemModelGenerator) {
		itemModelGenerator.register(ModItems.RAW_ETERNIUM, Models.SINGLE_LAYER_ITEM);
		itemModelGenerator.register(ModItems.Stable_Corrupted_Chorus, Models.SINGLE_LAYER_ITEM);
		itemModelGenerator.register(ModItems.Corrupted_Chorus, Models.SINGLE_LAYER_ITEM);
		itemModelGenerator.register(ModItems.RIFTER_SPAWN_EGG,
			new Model(Optional.of(new Identifier("item/template_spawn_egg")), Optional.empty()));
	}
}

package com.cosmo.galactic_horizons.datagen;

import com.cosmo.galactic_horizons.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.HolderLookup;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
	public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
		super(output, registriesFuture);
	}

	@Override
	protected void configure(HolderLookup.Provider arg) {
		getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
			.add(ModBlocks.DEEPSLATE_ETERNIUM_ORE)
			.add(ModBlocks.ETERNIUM_ORE)
			.add(ModBlocks.DIMENSIONAL_CRAFTER);
		getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
			.add(ModBlocks.DIMENSIONAL_CRAFTER)
			.add(ModBlocks.ETERNIUM_ORE)
			.add(ModBlocks.DEEPSLATE_ETERNIUM_ORE);
	}
}

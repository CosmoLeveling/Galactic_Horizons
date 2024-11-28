package com.cosmo.galactic_horizons.datagen;

import com.cosmo.galactic_horizons.block.ModBlocks;
import com.cosmo.galactic_horizons.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.item.ItemConvertible;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
	public ModLootTableProvider(FabricDataOutput dataOutput) {
		super(dataOutput);
	}

	@Override
	public void generate() {
		add(ModBlocks.DEEPSLATE_ETERNIUM_ORE,oreDrops(ModBlocks.DEEPSLATE_ETERNIUM_ORE,ModItems.RAW_ETERNIUM));
		add(ModBlocks.ETERNIUM_ORE,oreDrops(ModBlocks.ETERNIUM_ORE,ModItems.RAW_ETERNIUM));
		add(ModBlocks.END_ETERNIUM_ORE,oreDrops(ModBlocks.END_ETERNIUM_ORE,ModItems.RAW_ETERNIUM));
		addDrop(ModBlocks.DIMENSIONAL_CRAFTER);
	}
}

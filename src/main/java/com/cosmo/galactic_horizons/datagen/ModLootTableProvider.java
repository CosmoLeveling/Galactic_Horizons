package com.cosmo.galactic_horizons.datagen;

import com.cosmo.galactic_horizons.block.GalacticHorizonsBlocks;
import com.cosmo.galactic_horizons.item.GalacticHorizonsItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
	public ModLootTableProvider(FabricDataOutput dataOutput) {
		super(dataOutput);
	}

	@Override
	public void generate() {
		add(GalacticHorizonsBlocks.DEEPSLATE_ETERNIUM_ORE,oreDrops(GalacticHorizonsBlocks.DEEPSLATE_ETERNIUM_ORE, GalacticHorizonsItems.RAW_ETERNIUM));
		add(GalacticHorizonsBlocks.ETERNIUM_ORE,oreDrops(GalacticHorizonsBlocks.ETERNIUM_ORE, GalacticHorizonsItems.RAW_ETERNIUM));
		add(GalacticHorizonsBlocks.END_ETERNIUM_ORE,oreDrops(GalacticHorizonsBlocks.END_ETERNIUM_ORE, GalacticHorizonsItems.RAW_ETERNIUM));
	}
}

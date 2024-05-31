package com.cosmo.galactic_horizons.block;

import com.cosmo.galactic_horizons.GalacticHorizons;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

public class ModBlocks {
	public static final Block DIMENSIONAL_CRAFTER = registerBlock("dimensional_crafter",
		new Block(QuiltBlockSettings.copyOf(Blocks.IRON_BLOCK)));



	private static Block registerBlock(String name, Block block) {
		registerBlockItem(name,block);
		return Registry.register(Registries.BLOCK,new Identifier(GalacticHorizons.MOD_ID,name),block);
	}

	private static Item registerBlockItem(String name, Block block) {
		return Registry.register(Registries.ITEM, new Identifier(GalacticHorizons.MOD_ID , name) , new BlockItem(block, new QuiltItemSettings()));
	}

	public static void registerModBlocks() {
		GalacticHorizons.LOGGER.info("Registering ModBlocks for " + GalacticHorizons.MOD_ID);
	}
}

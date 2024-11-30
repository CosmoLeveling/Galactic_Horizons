package com.cosmo.galactic_horizons.block;

import com.cosmo.galactic_horizons.GalacticHorizons;
import com.cosmo.galactic_horizons.block.custom.RealityStabilizer;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

public class GalacticHorizonsBlocks {
	public static final Block ETERNIUM_ORE = registerBlock("eternium_ore",
		new Block(QuiltBlockSettings.copyOf(Blocks.IRON_ORE)));
	public static final Block REALITY_CORE = registerBlock("reality_core",
		new RealityStabilizer(QuiltBlockSettings.copyOf(Blocks.CONDUIT)));
	public static final Block DEEPSLATE_ETERNIUM_ORE = registerBlock("deepslate_eternium_ore",
		new Block(QuiltBlockSettings.copyOf(Blocks.DEEPSLATE_IRON_ORE)));
	public static final Block END_ETERNIUM_ORE = registerBlock("end_eternium_ore", new Block(QuiltBlockSettings.copyOf(Blocks.END_STONE)));



	private static Block registerBlock(String name, Block block) {
		registerBlockItem(name,block);
		return Registry.register(Registries.BLOCK,new Identifier(GalacticHorizons.MOD_ID,name),block);
	}

	private static Item registerBlockItem(String name, Block block) {
		return Registry.register(Registries.ITEM,
			new Identifier(GalacticHorizons.MOD_ID , name) ,
			new BlockItem(block, new QuiltItemSettings()));
	}

	public static void registerModBlocks() {
		GalacticHorizons.LOGGER.info("Registering ModBlocks for " + GalacticHorizons.MOD_ID);
	}
}

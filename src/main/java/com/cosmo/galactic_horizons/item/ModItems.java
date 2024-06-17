package com.cosmo.galactic_horizons.item;

import com.cosmo.galactic_horizons.GalacticHorizons;
import com.cosmo.galactic_horizons.block.ModBlocks;
import com.cosmo.galactic_horizons.entity.ModEntities;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

public class ModItems {
	public static final Item RAW_ETERNIUM = registerItem("raw_eternium",new Item(new QuiltItemSettings()));
	public static final Item RIFTER_SPAWN_EGG = registerItem("rifter_spawn_egg",
		new SpawnEggItem(ModEntities.RIFTER,0x2f114d,0x3e1369,new QuiltItemSettings()));

	private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {
		entries.addItem(RAW_ETERNIUM);
		entries.addItem(ModBlocks.ETERNIUM_ORE);
		entries.addItem(ModBlocks.DEEPSLATE_ETERNIUM_ORE);
		entries.addItem(ModBlocks.DIMENSIONAL_CRAFTER);
	}
	private static void addItemsToSpawnItemGroup(FabricItemGroupEntries entries) {entries.addItem(RIFTER_SPAWN_EGG);}

	private static Item registerItem(String name, Item item) {
		return Registry.register(Registries.ITEM,new Identifier(GalacticHorizons.MOD_ID,name), item);
	}

	public static void registerModItems() {
		GalacticHorizons.LOGGER.info("Registering Mod Items for "+GalacticHorizons.MOD_ID);

		ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(ModItems::addItemsToSpawnItemGroup);
	}
}

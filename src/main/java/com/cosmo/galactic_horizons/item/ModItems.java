package com.cosmo.galactic_horizons.item;

import com.cosmo.galactic_horizons.GalacticHorizons;
import com.cosmo.galactic_horizons.block.ModBlocks;
import com.cosmo.galactic_horizons.effect.ModEffects;
import com.cosmo.galactic_horizons.entity.ModEntities;
import com.cosmo.galactic_horizons.item.custom.ModArmorItem;
import com.cosmo.galactic_horizons.item.custom.PrintItem;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

public class ModItems {
	public static final Item RAW_ETERNIUM = registerItem("raw_eternium",new Item(new QuiltItemSettings()));
	public static final Item ETERNIUM_INGOT = registerItem("eternium_ingot",new Item(new QuiltItemSettings()));
	public static final Item ETERNIUM_HELMET = registerItem("eternium_helmet",new ModArmorItem(ModArmorMaterials.ETERNIUM,ArmorItem.ArmorSlot.HELMET,new QuiltItemSettings()));
	public static final Item ETERNIUM_CHESTPLATE = registerItem("eternium_chestplate",new ModArmorItem(ModArmorMaterials.ETERNIUM,ArmorItem.ArmorSlot.CHESTPLATE,new QuiltItemSettings()));
	public static final Item ETERNIUM_LEGGINGS = registerItem("eternium_leggings",new ModArmorItem(ModArmorMaterials.ETERNIUM,ArmorItem.ArmorSlot.LEGGINGS,new QuiltItemSettings()));
	public static final Item ETERNIUM_BOOTS = registerItem("eternium_boots",new ModArmorItem(ModArmorMaterials.ETERNIUM,ArmorItem.ArmorSlot.BOOTS,new QuiltItemSettings()));
	public static final Item Stable_Corrupted_Chorus = registerItem("stable_corrupted_chorus",new Item(new QuiltItemSettings().food(new FoodComponent.Builder().saturationModifier(10f).hunger(1).statusEffect(new StatusEffectInstance(ModEffects.REALITY_SPLIT,200,0),1).alwaysEdible().build())));
	public static final Item Corrupted_Chorus = registerItem("corrupted_chorus",new Item(new QuiltItemSettings().food(new FoodComponent.Builder().saturationModifier(10f).hunger(1).statusEffect(new StatusEffectInstance(ModEffects.REALITY_TEAR,200,0),1).alwaysEdible().build())));
	public static final Item RIFTER_SPAWN_EGG = registerItem("rifter_spawn_egg",
		new SpawnEggItem(ModEntities.RIFTER,0x2f114d,0x3e1369,new QuiltItemSettings()));
	public static final Item R = registerItem("r",
		new PrintItem(new QuiltItemSettings()));
	private static void addItemsToNaturalBlocksItemGroup(FabricItemGroupEntries entries) {
		entries.addAfter(Items.DEEPSLATE_DIAMOND_ORE,ModBlocks.ETERNIUM_ORE);
		entries.addAfter(ModBlocks.ETERNIUM_ORE,ModBlocks.DEEPSLATE_ETERNIUM_ORE);
		entries.addAfter(ModBlocks.DEEPSLATE_ETERNIUM_ORE,ModBlocks.END_ETERNIUM_ORE);
	}
	private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {
		entries.addAfter(Items.RAW_GOLD,RAW_ETERNIUM);
		entries.addAfter(Items.GOLD_INGOT, ETERNIUM_INGOT);
		entries.addItem(ModBlocks.REALITY_STABILIZER);
	}
	private static void addItemsToFunctionalItemGroup(FabricItemGroupEntries entries) {
		entries.addAfter(Items.CRAFTING_TABLE,ModBlocks.DIMENSIONAL_CRAFTER);
	}
	private static void addItemsToSpawnItemGroup(FabricItemGroupEntries entries) {entries.addItem(RIFTER_SPAWN_EGG);}
	private static void addItemsToCombatItemGroup(FabricItemGroupEntries entries) {
		entries.addAfter(Items.DIAMOND_BOOTS,ETERNIUM_HELMET);
		entries.addAfter(ETERNIUM_HELMET,ETERNIUM_CHESTPLATE);
		entries.addAfter(ETERNIUM_CHESTPLATE,ETERNIUM_LEGGINGS);
		entries.addAfter(ETERNIUM_LEGGINGS,ETERNIUM_BOOTS);
	}

	private static Item registerItem(String name, Item item) {
		return Registry.register(Registries.ITEM,new Identifier(GalacticHorizons.MOD_ID,name), item);
	}

	public static void registerModItems() {
		GalacticHorizons.LOGGER.info("Registering Mod Items for "+GalacticHorizons.MOD_ID);

		ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(ModItems::addItemsToCombatItemGroup);
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL_BLOCKS).register(ModItems::addItemsToNaturalBlocksItemGroup);
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(ModItems::addItemsToSpawnItemGroup);
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL_BLOCKS).register(ModItems::addItemsToFunctionalItemGroup);
	}
}

package com.cosmo.galactic_horizons.item;

import com.cosmo.galactic_horizons.GalacticHorizons;
import com.cosmo.galactic_horizons.block.GalacticHorizonsBlocks;
import com.cosmo.galactic_horizons.effect.GalacticHorizonsEffects;
import com.cosmo.galactic_horizons.entity.GalacticHorizonsEntities;
import com.cosmo.galactic_horizons.item.custom.ModArmorItem;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

public class GalacticHorizonsItems {
	public static final Item RAW_ETERNIUM = registerItem("raw_eternium",new Item(new QuiltItemSettings()));
	public static final Item ETERNIUM_INGOT = registerItem("eternium_ingot",new Item(new QuiltItemSettings()));
	public static final Item ETERNIUM_HELMET = registerItem("eternium_helmet",new ModArmorItem(ModArmorMaterials.ETERNIUM,ArmorItem.ArmorSlot.HELMET,new QuiltItemSettings()));
	public static final Item ETERNIUM_CHESTPLATE = registerItem("eternium_chestplate",new ModArmorItem(ModArmorMaterials.ETERNIUM,ArmorItem.ArmorSlot.CHESTPLATE,new QuiltItemSettings()));
	public static final Item ETERNIUM_LEGGINGS = registerItem("eternium_leggings",new ModArmorItem(ModArmorMaterials.ETERNIUM,ArmorItem.ArmorSlot.LEGGINGS,new QuiltItemSettings()));
	public static final Item ETERNIUM_BOOTS = registerItem("eternium_boots",new ModArmorItem(ModArmorMaterials.ETERNIUM,ArmorItem.ArmorSlot.BOOTS,new QuiltItemSettings()));
	public static final Item DOUSED_CHORUS = registerItem("doused_chorus",new Item(new QuiltItemSettings().food(new FoodComponent.Builder().saturationModifier(10f).hunger(1).statusEffect(new StatusEffectInstance(GalacticHorizonsEffects.REALITY_SPLIT,200,0),1).alwaysEdible().build())));
	public static final Item ENDERMAN_BLOOD_VIAL = registerItem("enderman_blood_vial",new Item(new QuiltItemSettings().food(new FoodComponent.Builder().saturationModifier(10f).hunger(1).statusEffect(new StatusEffectInstance(GalacticHorizonsEffects.REALITY_SPLIT,200,0),1).alwaysEdible().build())));
	public static final Item ENDERMAN_BLOOD = registerItem("enderman_blood",new Item(new QuiltItemSettings()));

	public static final Item RIFTER_SPAWN_EGG = registerItem("rifter_spawn_egg",
		new SpawnEggItem(GalacticHorizonsEntities.RIFTER,0x2f114d,0x3e1369,new QuiltItemSettings()));
	private static void addItemsToNaturalBlocksItemGroup(FabricItemGroupEntries entries) {
		entries.addAfter(Items.DEEPSLATE_DIAMOND_ORE, GalacticHorizonsBlocks.ETERNIUM_ORE);
		entries.addAfter(GalacticHorizonsBlocks.ETERNIUM_ORE, GalacticHorizonsBlocks.DEEPSLATE_ETERNIUM_ORE);
		entries.addAfter(GalacticHorizonsBlocks.DEEPSLATE_ETERNIUM_ORE, GalacticHorizonsBlocks.END_ETERNIUM_ORE);
	}
	private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {
		entries.addAfter(Items.RAW_GOLD,RAW_ETERNIUM);
		entries.addAfter(Items.GOLD_INGOT, ETERNIUM_INGOT);
		entries.addItem(GalacticHorizonsBlocks.REALITY_CORE);
	}
	private static void addItemsToFunctionalItemGroup(FabricItemGroupEntries entries) {
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

		ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(GalacticHorizonsItems::addItemsToIngredientItemGroup);
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(GalacticHorizonsItems::addItemsToCombatItemGroup);
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL_BLOCKS).register(GalacticHorizonsItems::addItemsToNaturalBlocksItemGroup);
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(GalacticHorizonsItems::addItemsToSpawnItemGroup);
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL_BLOCKS).register(GalacticHorizonsItems::addItemsToFunctionalItemGroup);
	}
}

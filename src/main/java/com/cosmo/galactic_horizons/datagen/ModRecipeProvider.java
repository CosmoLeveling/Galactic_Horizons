package com.cosmo.galactic_horizons.datagen;

import com.cosmo.galactic_horizons.block.ModBlocks;
import com.cosmo.galactic_horizons.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonFactory;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonFactory;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.RecipeCategory;
import net.minecraft.recipe.ShapelessRecipe;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {
	private static final List<ItemConvertible> ETERNIUM_SMELTABLES = List.of(ModItems.RAW_ETERNIUM, ModBlocks.DEEPSLATE_ETERNIUM_ORE,ModBlocks.END_ETERNIUM_ORE,ModBlocks.ETERNIUM_ORE);
	public ModRecipeProvider(FabricDataOutput output) {
		super(output);
	}

	@Override
	public void generateRecipes(Consumer<RecipeJsonProvider> exporter) {
		offerSmelting(exporter, ETERNIUM_SMELTABLES, RecipeCategory.MISC,ModItems.ETERNIUM_INGOT,
		0.7f,200,"eternium");
		offerBlasting(exporter, ETERNIUM_SMELTABLES, RecipeCategory.MISC,ModItems.ETERNIUM_INGOT,
		0.7f,100,"eternium");
		ShapedRecipeJsonFactory.create(RecipeCategory.MISC,ModItems.ETERNIUM_BOOTS,1)
			.pattern("S S")
			.pattern("S S")
			.ingredient('S',ModItems.ETERNIUM_INGOT)
			.criterion(hasItem(ModItems.ETERNIUM_INGOT),conditionsFromItem(ModItems.ETERNIUM_INGOT))
			.offerTo(exporter,new Identifier(getRecipeName(ModItems.ETERNIUM_BOOTS)));
		ShapedRecipeJsonFactory.create(RecipeCategory.MISC,ModItems.ETERNIUM_HELMET,1)
			.pattern("SSS")
			.pattern("S S")
			.ingredient('S',ModItems.ETERNIUM_INGOT)
			.criterion(hasItem(ModItems.ETERNIUM_INGOT),conditionsFromItem(ModItems.ETERNIUM_INGOT))
			.offerTo(exporter,new Identifier(getRecipeName(ModItems.ETERNIUM_HELMET)));
		ShapedRecipeJsonFactory.create(RecipeCategory.MISC,ModItems.ETERNIUM_CHESTPLATE,1)
			.pattern("S S")
			.pattern("SSS")
			.pattern("SSS")
			.ingredient('S',ModItems.ETERNIUM_INGOT)
			.criterion(hasItem(ModItems.ETERNIUM_INGOT),conditionsFromItem(ModItems.ETERNIUM_INGOT))
			.offerTo(exporter,new Identifier(getRecipeName(ModItems.ETERNIUM_CHESTPLATE)));
		ShapedRecipeJsonFactory.create(RecipeCategory.MISC,ModItems.ETERNIUM_LEGGINGS,1)
			.pattern("SSS")
			.pattern("S S")
			.pattern("S S")
			.ingredient('S',ModItems.ETERNIUM_INGOT)
			.criterion(hasItem(ModItems.ETERNIUM_INGOT),conditionsFromItem(ModItems.ETERNIUM_INGOT))
			.offerTo(exporter,new Identifier(getRecipeName(ModItems.ETERNIUM_LEGGINGS)));
		ShapedRecipeJsonFactory.create(RecipeCategory.MISC,ModItems.Corrupted_Chorus,1)
			.pattern(" b ")
			.pattern("bcb")
			.pattern(" b ")
			.ingredient('b', Items.BONE)
			.ingredient('c',Items.CHORUS_FRUIT)
			.criterion(hasItem(Items.CHORUS_FRUIT),conditionsFromItem(Items.CHORUS_FRUIT))
			.offerTo(exporter,new Identifier(getRecipeName(ModItems.Corrupted_Chorus)));
		ShapelessRecipeJsonFactory.create(RecipeCategory.MISC,ModItems.Stable_Corrupted_Chorus,1)
			.ingredient(ModItems.Corrupted_Chorus)
			.ingredient(ModBlocks.REALITY_STABILIZER)
			.criterion(hasItem(ModBlocks.REALITY_STABILIZER),conditionsFromItem(ModBlocks.REALITY_STABILIZER))
			.offerTo(exporter,new Identifier(getRecipeName(ModItems.Stable_Corrupted_Chorus)));
	}
}

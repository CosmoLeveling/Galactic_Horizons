package com.cosmo.galactic_horizons.datagen;

import com.cosmo.galactic_horizons.block.GalacticHorizonsBlocks;
import com.cosmo.galactic_horizons.item.GalacticHorizonsItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonFactory;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonFactory;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {
	private static final List<ItemConvertible> ETERNIUM_SMELTABLES = List.of(GalacticHorizonsItems.RAW_ETERNIUM, GalacticHorizonsBlocks.DEEPSLATE_ETERNIUM_ORE, GalacticHorizonsBlocks.END_ETERNIUM_ORE, GalacticHorizonsBlocks.ETERNIUM_ORE);
	public ModRecipeProvider(FabricDataOutput output) {
		super(output);
	}

	@Override
	public void generateRecipes(Consumer<RecipeJsonProvider> exporter) {
		offerSmelting(exporter, ETERNIUM_SMELTABLES, RecipeCategory.MISC, GalacticHorizonsItems.ETERNIUM_INGOT,
		0.7f,200,"eternium");
		offerBlasting(exporter, ETERNIUM_SMELTABLES, RecipeCategory.MISC, GalacticHorizonsItems.ETERNIUM_INGOT,
		0.7f,100,"eternium");
		ShapedRecipeJsonFactory.create(RecipeCategory.MISC, GalacticHorizonsItems.ETERNIUM_BOOTS,1)
			.pattern("S S")
			.pattern("S S")
			.ingredient('S', GalacticHorizonsItems.ETERNIUM_INGOT)
			.criterion(hasItem(GalacticHorizonsItems.ETERNIUM_INGOT),conditionsFromItem(GalacticHorizonsItems.ETERNIUM_INGOT))
			.offerTo(exporter,new Identifier(getRecipeName(GalacticHorizonsItems.ETERNIUM_BOOTS)));
		ShapedRecipeJsonFactory.create(RecipeCategory.MISC, GalacticHorizonsItems.ETERNIUM_HELMET,1)
			.pattern("SSS")
			.pattern("S S")
			.ingredient('S', GalacticHorizonsItems.ETERNIUM_INGOT)
			.criterion(hasItem(GalacticHorizonsItems.ETERNIUM_INGOT),conditionsFromItem(GalacticHorizonsItems.ETERNIUM_INGOT))
			.offerTo(exporter,new Identifier(getRecipeName(GalacticHorizonsItems.ETERNIUM_HELMET)));
		ShapedRecipeJsonFactory.create(RecipeCategory.MISC, GalacticHorizonsItems.ETERNIUM_CHESTPLATE,1)
			.pattern("S S")
			.pattern("SSS")
			.pattern("SSS")
			.ingredient('S', GalacticHorizonsItems.ETERNIUM_INGOT)
			.criterion(hasItem(GalacticHorizonsItems.ETERNIUM_INGOT),conditionsFromItem(GalacticHorizonsItems.ETERNIUM_INGOT))
			.offerTo(exporter,new Identifier(getRecipeName(GalacticHorizonsItems.ETERNIUM_CHESTPLATE)));
		ShapedRecipeJsonFactory.create(RecipeCategory.MISC, GalacticHorizonsItems.ETERNIUM_LEGGINGS,1)
			.pattern("SSS")
			.pattern("S S")
			.pattern("S S")
			.ingredient('S', GalacticHorizonsItems.ETERNIUM_INGOT)
			.criterion(hasItem(GalacticHorizonsItems.ETERNIUM_INGOT),conditionsFromItem(GalacticHorizonsItems.ETERNIUM_INGOT))
			.offerTo(exporter,new Identifier(getRecipeName(GalacticHorizonsItems.ETERNIUM_LEGGINGS)));
	}
}

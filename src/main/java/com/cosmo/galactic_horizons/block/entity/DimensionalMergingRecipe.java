package com.cosmo.galactic_horizons.block.entity;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.*;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;
import org.quiltmc.qsl.recipe.api.serializer.QuiltRecipeSerializer;

public class DimensionalMergingRecipe implements Recipe<SimpleInventory> {
    private final Identifier id;
	public static final String NAME = "dimensional_merging";
    private final ItemStack result;
    private final DefaultedList<Ingredient> ingredients;

    public DimensionalMergingRecipe(Identifier id, ItemStack output, DefaultedList<Ingredient> inputs) {
        this.id = id;
        this.result = output;
        this.ingredients = inputs;
    }


    public boolean matches(SimpleInventory inventory, World world) {
        if(world.isClient()) {
            return false;
        }
        return ingredients.get(0).test(inventory.getStack(1)) && ingredients.get(1).test(inventory.getStack(2)) && ingredients.get(2).test(inventory.getStack(3)) && ingredients.get(3).test(inventory.getStack(4)) && ingredients.get(4).test(inventory.getStack(5));
    }

	public ItemStack craft(SimpleInventory inventory, DynamicRegistryManager registryManager) {
		return result;
	}

    public boolean fits(int width, int height) {
        return true;
    }

	public ItemStack getResult(DynamicRegistryManager registryManager) {
		return result;
	}

    public Identifier getId() {
        return id;
    }

    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public static class Type implements RecipeType<DimensionalMergingRecipe> {
        private Type() { }
        public static final Type INSTANCE = new Type();

    }

    public static class Serializer implements QuiltRecipeSerializer<DimensionalMergingRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final String NAME = "dimensional_merging";

        public DimensionalMergingRecipe read(Identifier id, JsonObject json) {
            ItemStack result = ShapedRecipe.outputFromJson(JsonHelper.getObject(json, "result"));

            JsonArray ingredients = JsonHelper.getArray(json, "ingredients");
            DefaultedList<Ingredient> inputs = DefaultedList.ofSize(5, Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromJson(ingredients.get(i)));
            }

            return new DimensionalMergingRecipe(id, result, inputs);
        }

        public DimensionalMergingRecipe read(Identifier id, PacketByteBuf buf) {
            DefaultedList<Ingredient> inputs = DefaultedList.ofSize(buf.readInt(), Ingredient.EMPTY);

			inputs.replaceAll(ignored -> Ingredient.fromPacket(buf));

            ItemStack output = buf.readItemStack();
            return new DimensionalMergingRecipe(id, output, inputs);
        }

        public void write(PacketByteBuf buf, DimensionalMergingRecipe recipe) {
            buf.writeInt(recipe.getIngredients().size());
            for (Ingredient ingredient : recipe.getIngredients()) {
				ingredient.write(buf);
            }
			buf.writeItemStack(recipe.getResult(null));
        }

		public JsonObject toJson(DimensionalMergingRecipe recipe) {
			return null;
		}
	}
}

package com.cosmo.galactic_horizons.util;

import com.cosmo.galactic_horizons.item.ModItems;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;

public class ModLootTableModifiers {
	private static final Identifier ENDERMAN_ID =
		new Identifier("entities/enderman");
	public static void modifyLootTables(){
		LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
			if(ENDERMAN_ID.equals(id)){
				LootPool.Builder poolBuilder = LootPool.builder()
					.rolls(ConstantLootNumberProvider.create(1))
					.conditionally(RandomChanceLootCondition.builder(1f))
					.with(ItemEntry.builder(ModItems.ENDERMAN_BLOOD))
					.apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f,1.0f)).build());
				tableBuilder.pool(poolBuilder.build());
			}
		});
	}
}

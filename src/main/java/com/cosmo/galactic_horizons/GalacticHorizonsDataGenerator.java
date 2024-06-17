package com.cosmo.galactic_horizons;

import com.cosmo.galactic_horizons.datagen.ModBlockTagProvider;
import com.cosmo.galactic_horizons.datagen.ModLootTableProvider;
import com.cosmo.galactic_horizons.datagen.ModModelProvider;
import com.cosmo.galactic_horizons.datagen.ModWorldGenerator;
import com.cosmo.galactic_horizons.world.ModConfiguredFeatures;
import com.cosmo.galactic_horizons.world.ModPlacedFeatures;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistrySetBuilder;

public class GalacticHorizonsDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(ModWorldGenerator::new);
		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModLootTableProvider::new);
		pack.addProvider(ModBlockTagProvider::new);
	}

	@Override
	public void buildRegistry(RegistrySetBuilder registryBuilder) {
		registryBuilder.add(RegistryKeys.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap);
		registryBuilder.add(RegistryKeys.PLACED_FEATURE, ModPlacedFeatures::bootstrap);
	}
}

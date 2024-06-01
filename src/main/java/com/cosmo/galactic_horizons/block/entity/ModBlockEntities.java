package com.cosmo.galactic_horizons.block.entity;

import com.cosmo.galactic_horizons.GalacticHorizons;
import com.cosmo.galactic_horizons.block.ModBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.quiltmc.qsl.block.entity.api.QuiltBlockEntityTypeBuilder;

public class ModBlockEntities {
	public static final BlockEntityType<DimensionalCrafterBlockEntity> DIMENSIONAL_CRAFTER_BLOCK_ENTITY =
		Registry.register(Registries.BLOCK_ENTITY_TYPE,new Identifier(GalacticHorizons.MOD_ID,"dimensional_crafter_be"),
			QuiltBlockEntityTypeBuilder.create(DimensionalCrafterBlockEntity::new,
				ModBlocks.DIMENSIONAL_CRAFTER).build());
	public static void registerBlockEntities() {
		GalacticHorizons.LOGGER.info("Registering Block Entities for " + GalacticHorizons.MOD_ID);
	}

}

package com.cosmo.galactic_horizons.entity;

import com.cosmo.galactic_horizons.GalacticHorizons;
import com.cosmo.galactic_horizons.entity.custom.RifterEntity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.quiltmc.qsl.entity.api.QuiltEntityTypeBuilder;

public class GalacticHorizonsEntities {
public static final EntityType<RifterEntity> RIFTER = Registry.register(Registries.ENTITY_TYPE,
	new Identifier(GalacticHorizons.MOD_ID,"rifter"),
	QuiltEntityTypeBuilder.create(SpawnGroup.MONSTER,RifterEntity::new)
		.setDimensions(EntityDimensions.fixed(.65f,2.9f)).build());

}

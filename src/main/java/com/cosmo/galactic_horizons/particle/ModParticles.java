package com.cosmo.galactic_horizons.particle;

import com.cosmo.galactic_horizons.GalacticHorizons;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;


public class ModParticles {
	public static final DefaultParticleType SPLIT_PARTICLE = FabricParticleTypes.simple();

	public static void registerParticles() {
		Registry.register(Registries.PARTICLE_TYPE,new Identifier(GalacticHorizons.MOD_ID,"split_particle"),
			SPLIT_PARTICLE);
	}
}

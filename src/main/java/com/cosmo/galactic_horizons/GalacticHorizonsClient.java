package com.cosmo.galactic_horizons;

import com.cosmo.galactic_horizons.effect.ModEffects;
import com.cosmo.galactic_horizons.entity.ModEntities;
import com.cosmo.galactic_horizons.entity.client.ModModelLayers;
import com.cosmo.galactic_horizons.entity.client.RifterModel;
import com.cosmo.galactic_horizons.entity.client.RifterRenderer;
import com.cosmo.galactic_horizons.networking.ModMessages;
import com.cosmo.galactic_horizons.particle.ModParticles;
import com.cosmo.galactic_horizons.particle.custom.RealityParticle;
import com.cosmo.galactic_horizons.screen.DimensionalCrafterScreen;
import com.cosmo.galactic_horizons.screen.ModScreenHandler;
import ladysnake.satin.api.event.ShaderEffectRenderCallback;
import ladysnake.satin.api.managed.ManagedShaderEffect;
import ladysnake.satin.api.managed.ShaderEffectManager;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.util.Identifier;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.client.ClientModInitializer;

import java.util.HashSet;
import java.util.UUID;

public class GalacticHorizonsClient implements ClientModInitializer {
	public static final Identifier SPLIT_ID = new Identifier("galactic_horizons","shaders/post/split.json");
	private final ManagedShaderEffect SplitShader = ShaderEffectManager.getInstance().manage(SPLIT_ID);
	public static final Identifier SPECTRAL_ID = GalacticHorizons.id("shaders/post/spectral.json");
	private final ManagedShaderEffect SpectralShader = ShaderEffectManager.getInstance().manage(SPECTRAL_ID);
	public static final Identifier GREEN_ID = GalacticHorizons.id("shaders/post/grainy_green.json");
	private final ManagedShaderEffect GreenShader = ShaderEffectManager.getInstance().manage(GREEN_ID);
	public static final Identifier WORLD_ID = new Identifier("galactic_horizons","shaders/post/world.json");
	private final ManagedShaderEffect WorldShader = ShaderEffectManager.getInstance().manage(WORLD_ID);
	public static HashSet<UUID> entities = new HashSet<>();

	@Override
	public void onInitializeClient(ModContainer mod) {
		ShaderEffectRenderCallback.EVENT.register(tickDelta -> {
			if (MinecraftClient.getInstance().player != null&&MinecraftClient.getInstance().player.hasStatusEffect(ModEffects.REALITY_TEAR)||MinecraftClient.getInstance().player.hasStatusEffect(ModEffects.REALITY_SPLIT)) {
					SplitShader.render(tickDelta);
			}
		});
		ModMessages.registerS2CPackets();
		ParticleFactoryRegistry.getInstance().register(ModParticles.REALITY_PARTICLE, RealityParticle.Factory::new);
		HandledScreens.register(ModScreenHandler.DIMENSIONAL_CRAFTER_SCREEN_HANDLER_SCREEN, DimensionalCrafterScreen::new);

		EntityRendererRegistry.register(ModEntities.RIFTER, RifterRenderer::new);
		EntityModelLayerRegistry.registerModelLayer(ModModelLayers.RIFTER, RifterModel::getTexturedModelData);
	}
}

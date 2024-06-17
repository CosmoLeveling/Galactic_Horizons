package com.cosmo.galactic_horizons.client.render.entity.feature;


import com.cosmo.galactic_horizons.GalacticHorizons;
import com.cosmo.galactic_horizons.entity.client.RifterModel;
import com.cosmo.galactic_horizons.entity.custom.RifterEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.feature.EyesFeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.util.Identifier;
import org.quiltmc.loader.api.minecraft.ClientOnly;

@ClientOnly
public class RifterGlowFeatureRenderer<T extends RifterEntity, M extends RifterModel<T>> extends EyesFeatureRenderer<T, M> {
	private static final RenderLayer SKIN = RenderLayer.getEyes(new Identifier(GalacticHorizons.MOD_ID,"textures/entity/rifter_glow.png"));

	public RifterGlowFeatureRenderer(FeatureRendererContext<T, M> featureRendererContext) {
		super(featureRendererContext);
	}

	public RenderLayer getEyesLayer() {
		return SKIN;
	}
}

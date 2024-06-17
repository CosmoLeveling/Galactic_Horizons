package com.cosmo.galactic_horizons.entity.client;

import com.cosmo.galactic_horizons.GalacticHorizons;
import com.cosmo.galactic_horizons.client.render.entity.feature.RifterGlowFeatureRenderer;
import com.cosmo.galactic_horizons.entity.custom.RifterEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;


public class RifterRenderer extends MobEntityRenderer<RifterEntity,RifterModel<RifterEntity>> {
	private static final Identifier TEXTURE = new Identifier(GalacticHorizons.MOD_ID,"textures/entity/rifter.png");

	public RifterRenderer(EntityRendererFactory.Context context) {
		super(context, new RifterModel<>(context.getPart(ModModelLayers.RIFTER)),0.6f);
		this.addFeature(new RifterGlowFeatureRenderer(this));
	}

	@Override
	public Identifier getTexture(RifterEntity entity) {
		return TEXTURE;
	}

	@Override
	public void render(RifterEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
		super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
	}
}

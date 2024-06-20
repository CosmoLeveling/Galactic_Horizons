package com.cosmo.galactic_horizons.entity.client;

import com.cosmo.galactic_horizons.entity.animation.ModAnimations;
import com.cosmo.galactic_horizons.entity.custom.RifterEntity;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

// Made with Blockbench 4.10.3
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class RifterModel<T extends RifterEntity> extends SinglePartEntityModel<T> {
	private final ModelPart Rifter;
	private final ModelPart Head;
	private boolean started;
	public RifterModel(ModelPart root) {
		this.Rifter = root.getChild("Rifter");
		this.Head = Rifter.getChild("Body").getChild("Head");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData Rifter = modelPartData.addChild("Rifter", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData Body = Rifter.addChild("Body", ModelPartBuilder.create().uv(32, 0).cuboid(-4.0F, -5.5F, -2.0F, 8.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -32.5F, 0.0F));

		ModelPartData Core = Body.addChild("Core", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -1.5F, -1.0F, 2.0F, 3.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -1.0F, 0.0F));

		ModelPartData Head = Body.addChild("Head", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -7.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(-0.5F)), ModelTransform.pivot(0.0F, -6.5F, 0.0F));

		ModelPartData LeftArm = Body.addChild("LeftArm", ModelPartBuilder.create().uv(56, 0).mirrored().cuboid(0.0F, -1.0F, -1.0F, 2.0F, 12.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(4.0F, -4.5F, 0.0F));

		ModelPartData LeftElbow = LeftArm.addChild("LeftElbow", ModelPartBuilder.create().uv(56, 0).mirrored().cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 12.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(1.0F, 11.0F, 0.0F));

		ModelPartData RightArm = Body.addChild("RightArm", ModelPartBuilder.create().uv(56, 0).cuboid(-2.0F, -1.0F, -1.0F, 2.0F, 10.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-4.0F, -4.5F, 0.0F));

		ModelPartData RightElbow = RightArm.addChild("RightElbow", ModelPartBuilder.create().uv(56, 0).cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 13.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-1.0F, 9.0F, 0.0F));

		ModelPartData LeftLeg = Body.addChild("LeftLeg", ModelPartBuilder.create().uv(56, 0).mirrored().cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 13.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(2.0F, 6.5F, 0.0F));

		ModelPartData LeftKnee = LeftLeg.addChild("LeftKnee", ModelPartBuilder.create().uv(56, 0).mirrored().cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(0.0F, 13.0F, 0.0F));

		ModelPartData RightLeg = Body.addChild("RightLeg", ModelPartBuilder.create().uv(56, 0).cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 12.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-2.0F, 6.5F, 0.0F));

		ModelPartData RightKnee = RightLeg.addChild("RightKnee", ModelPartBuilder.create().uv(56, 0).cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 14.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 12.0F, 0.0F));
		return TexturedModelData.of(modelData, 64, 32);
	}
	@Override
	public void setAngles(RifterEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.setHeadAngles(netHeadYaw,headPitch);
		this.animate(entity.idleAnimationState, ModAnimations.RIFTER_IDLE,ageInTicks,1f);
		if(entity.ChaseingAnimationState.isAnimating()&& !started) {
			this.animate(entity.ChaseingAnimationState, ModAnimations.RIFTER_CHASE_START, ageInTicks, 1f);
			this.started=true;
		}
		if(entity.ChaseingAnimationState.isAnimating()&& started) {
			this.animate(entity.ChaseingAnimationState, ModAnimations.RIFTER_CHASE_LOOP, ageInTicks, 1f);
		}
	}

	private void setHeadAngles(float headYaw,float headPitch) {
		headYaw = MathHelper.clamp(headYaw, -30.0F, 30.0F);
		headPitch = MathHelper.clamp(headPitch, -25.0F, 45.0F);

		this.Head.yaw = headYaw * 0.017453292F;
		this.Head.pitch = headPitch * 0.017453292F;
	}
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		Rifter.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getPart() {
		return Rifter;
	}
}

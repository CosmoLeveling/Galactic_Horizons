package com.cosmo.galactic_horizons.entity.animation;

import net.minecraft.client.render.animation.Animation;
import net.minecraft.client.render.animation.AnimationKeyframe;
import net.minecraft.client.render.animation.Animator;
import net.minecraft.client.render.animation.PartAnimation;

public class ModAnimations {
	//Created by Void
	public static final Animation RIFTER_IDLE = Animation.Builder.withLength(1.5f).looping()
		.addPartAnimation("Head",
			new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
				new AnimationKeyframe(0f, Animator.rotate(0f, 0f, 0f),
					PartAnimation.Interpolations.LINEAR),
				new AnimationKeyframe(0.75f, Animator.rotate(-2.5f, 0.11f, 2.5f),
					PartAnimation.Interpolations.LINEAR),
				new AnimationKeyframe(1.5f, Animator.rotate(0f, 0f, 0f),
					PartAnimation.Interpolations.LINEAR)))
		.addPartAnimation("RightArm",
			new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
				new AnimationKeyframe(0f, Animator.rotate(2.5f, 0f, 0f),
					PartAnimation.Interpolations.LINEAR),
				new AnimationKeyframe(0.75f, Animator.rotate(2f, 0f, 0f),
					PartAnimation.Interpolations.LINEAR),
				new AnimationKeyframe(1.5f, Animator.rotate(2.5f, 0f, 0f),
					PartAnimation.Interpolations.LINEAR)))
		.addPartAnimation("RightElbow",
			new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
				new AnimationKeyframe(0f, Animator.rotate(10f, 0f, 0f),
					PartAnimation.Interpolations.LINEAR),
				new AnimationKeyframe(0.75f, Animator.rotate(13.5f, 0f, 0f),
					PartAnimation.Interpolations.LINEAR),
				new AnimationKeyframe(1.5f, Animator.rotate(10f, 0f, 0f),
					PartAnimation.Interpolations.LINEAR)))
		.addPartAnimation("LeftArm",
			new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
				new AnimationKeyframe(0f, Animator.rotate(2.5f, 0f, 0f),
					PartAnimation.Interpolations.LINEAR),
				new AnimationKeyframe(0.75f, Animator.rotate(4.5f, 0f, 0f),
					PartAnimation.Interpolations.LINEAR),
				new AnimationKeyframe(1.5f, Animator.rotate(2.5f, 0f, 0f),
					PartAnimation.Interpolations.LINEAR)))
		.addPartAnimation("LeftElbow",
			new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
				new AnimationKeyframe(0f, Animator.rotate(10f, 0f, 0f),
					PartAnimation.Interpolations.LINEAR),
				new AnimationKeyframe(0.75f, Animator.rotate(13.5f, 0f, 0f),
					PartAnimation.Interpolations.LINEAR),
				new AnimationKeyframe(1.5f, Animator.rotate(10f, 0f, 0f),
					PartAnimation.Interpolations.LINEAR)))
		.addPartAnimation("RightLeg",
			new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
				new AnimationKeyframe(0f, Animator.rotate(7.5f, 0f, 0f),
					PartAnimation.Interpolations.LINEAR),
				new AnimationKeyframe(0.75f, Animator.rotate(6f, 0f, 0f),
					PartAnimation.Interpolations.LINEAR),
				new AnimationKeyframe(1.5f, Animator.rotate(7.5f, 0f, 0f),
					PartAnimation.Interpolations.LINEAR)))
		.addPartAnimation("RightKnee",
			new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
				new AnimationKeyframe(0f, Animator.rotate(15f, 0f, 0f),
					PartAnimation.Interpolations.LINEAR),
				new AnimationKeyframe(0.75f, Animator.rotate(20f, 0f, 0f),
					PartAnimation.Interpolations.LINEAR),
				new AnimationKeyframe(1.5f, Animator.rotate(15f, 0f, 0f),
					PartAnimation.Interpolations.LINEAR)))
		.addPartAnimation("LeftLeg",
			new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
				new AnimationKeyframe(0f, Animator.rotate(2.5f, 0f, 0f),
					PartAnimation.Interpolations.LINEAR),
				new AnimationKeyframe(0.75f, Animator.rotate(4.5f, 0f, 0f),
					PartAnimation.Interpolations.LINEAR),
				new AnimationKeyframe(1.5f, Animator.rotate(2.5f, 0f, 0f),
					PartAnimation.Interpolations.LINEAR)))
		.addPartAnimation("LeftKnee",
			new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
				new AnimationKeyframe(0f, Animator.rotate(5f, 0f, 0f),
					PartAnimation.Interpolations.LINEAR),
				new AnimationKeyframe(0.75f, Animator.rotate(2.5f, 0f, 0f),
					PartAnimation.Interpolations.LINEAR),
				new AnimationKeyframe(1.5f, Animator.rotate(5f, 0f, 0f),
					PartAnimation.Interpolations.LINEAR)))
		.addPartAnimation("Core",
			new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
				new AnimationKeyframe(0f, Animator.rotate(0f, 0f, 0f),
					PartAnimation.Interpolations.LINEAR),
				new AnimationKeyframe(1.5f, Animator.rotate(0f, 180f, 0f),
					PartAnimation.Interpolations.LINEAR))).build();
	public static final Animation RIFTER_CHASE_LOOP = Animation.Builder.withLength(1.5f).looping()
		.addPartAnimation("Body",
					  new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
		new AnimationKeyframe(0f, Animator.rotate(50f, 0f, 0f),
	PartAnimation.Interpolations.LINEAR)))
		.addPartAnimation("Core",
							  new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
		new AnimationKeyframe(0f, Animator.rotate(0f, 0f, 0f),
	PartAnimation.Interpolations.LINEAR),
		new AnimationKeyframe(1.5f, Animator.rotate(0f, 180f, 0f),
	PartAnimation.Interpolations.LINEAR)))
		.addPartAnimation("Head",
							  new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
		new AnimationKeyframe(0f, Animator.rotate(-50f, 0f, 0f),
	PartAnimation.Interpolations.LINEAR),
		new AnimationKeyframe(0.75f, Animator.rotate(-52.47f, 1.98f, 1.52f),
	PartAnimation.Interpolations.LINEAR),
		new AnimationKeyframe(1.5f, Animator.rotate(-50f, 0f, 0f),
	PartAnimation.Interpolations.LINEAR)))
		.addPartAnimation("LeftArm",
							  new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
		new AnimationKeyframe(0f, Animator.rotate(2.5f, 0f, 0f),
	PartAnimation.Interpolations.LINEAR),
		new AnimationKeyframe(0.75f, Animator.rotate(4.5f, 0f, 0f),
	PartAnimation.Interpolations.LINEAR),
		new AnimationKeyframe(1.5f, Animator.rotate(2.5f, 0f, 0f),
	PartAnimation.Interpolations.LINEAR)))
		.addPartAnimation("LeftElbow",
							  new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
		new AnimationKeyframe(0f, Animator.rotate(10f, 0f, 0f),
	PartAnimation.Interpolations.LINEAR),
		new AnimationKeyframe(0.75f, Animator.rotate(13.5f, 0f, 0f),
	PartAnimation.Interpolations.LINEAR),
		new AnimationKeyframe(1.5f, Animator.rotate(10f, 0f, 0f),
	PartAnimation.Interpolations.LINEAR)))
		.addPartAnimation("RightArm",
							  new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
		new AnimationKeyframe(0f, Animator.rotate(-137.53f, 1.69f, -1.84f),
	PartAnimation.Interpolations.LINEAR)))
		.addPartAnimation("RightElbow",
							  new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
		new AnimationKeyframe(0f, Animator.rotate(-2.5f, -0.11f, -2.5f),
	PartAnimation.Interpolations.LINEAR)))
		.addPartAnimation("RightElbow",
							  new PartAnimation(PartAnimation.AnimationTargets.SCALE,
		new AnimationKeyframe(0f, Animator.scale(1f, 2.2f, 1f),
	PartAnimation.Interpolations.LINEAR)))
		.addPartAnimation("LeftLeg",
							  new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
		new AnimationKeyframe(0f, Animator.rotate(2.5f, 0f, 0f),
	PartAnimation.Interpolations.LINEAR),
		new AnimationKeyframe(0.75f, Animator.rotate(4.5f, 0f, 0f),
	PartAnimation.Interpolations.LINEAR),
		new AnimationKeyframe(1.5f, Animator.rotate(2.5f, 0f, 0f),
	PartAnimation.Interpolations.LINEAR)))
		.addPartAnimation("LeftKnee",
							  new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
		new AnimationKeyframe(0f, Animator.rotate(5f, 0f, 0f),
	PartAnimation.Interpolations.LINEAR),
		new AnimationKeyframe(0.75f, Animator.rotate(2.5f, 0f, 0f),
	PartAnimation.Interpolations.LINEAR),
		new AnimationKeyframe(1.5f, Animator.rotate(5f, 0f, 0f),
	PartAnimation.Interpolations.LINEAR)))
		.addPartAnimation("RightLeg",
							  new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
		new AnimationKeyframe(0f, Animator.rotate(7.5f, 0f, 0f),
	PartAnimation.Interpolations.LINEAR),
		new AnimationKeyframe(0.75f, Animator.rotate(6f, 0f, 0f),
	PartAnimation.Interpolations.LINEAR),
		new AnimationKeyframe(1.5f, Animator.rotate(7.5f, 0f, 0f),
	PartAnimation.Interpolations.LINEAR)))
		.addPartAnimation("RightKnee",
							  new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
		new AnimationKeyframe(0f, Animator.rotate(15f, 0f, 0f),
	PartAnimation.Interpolations.LINEAR),
		new AnimationKeyframe(0.75f, Animator.rotate(20f, 0f, 0f),
	PartAnimation.Interpolations.LINEAR),
		new AnimationKeyframe(1.5f, Animator.rotate(15f, 0f, 0f),
	PartAnimation.Interpolations.LINEAR))).build();
	public static final Animation RIFTER_CHASE_START = Animation.Builder.withLength(1.5f)
		.addPartAnimation("Body",
							  new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
		new AnimationKeyframe(0f, Animator.rotate(0f, 0f, 0f),
			PartAnimation.Interpolations.LINEAR),
		new AnimationKeyframe(1.5f, Animator.rotate(50f, 0f, 0f),
			PartAnimation.Interpolations.LINEAR)))
		.addPartAnimation("Core",
							  new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
		new AnimationKeyframe(0f, Animator.rotate(0f, 0f, 0f),
			PartAnimation.Interpolations.LINEAR),
		new AnimationKeyframe(1.5f, Animator.rotate(0f, 180f, 0f),
			PartAnimation.Interpolations.LINEAR)))
		.addPartAnimation("Head",
							  new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
		new AnimationKeyframe(0f, Animator.rotate(0f, 0f, 0f),
			PartAnimation.Interpolations.LINEAR),
		new AnimationKeyframe(0.75f, Animator.rotate(-17.5f, 0f, 0f),
			PartAnimation.Interpolations.LINEAR),
		new AnimationKeyframe(0.7916766f, Animator.rotate(-12.57f, 12.28f, 43.64f),
			PartAnimation.Interpolations.LINEAR),
		new AnimationKeyframe(0.8343334f, Animator.rotate(-30f, 0f, 0f),
			PartAnimation.Interpolations.LINEAR),
		new AnimationKeyframe(1.5f, Animator.rotate(-52.5f, 0f, 0f),
			PartAnimation.Interpolations.LINEAR)))
		.addPartAnimation("LeftArm",
							  new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
		new AnimationKeyframe(0f, Animator.rotate(2.5f, 0f, 0f),
			PartAnimation.Interpolations.LINEAR),
		new AnimationKeyframe(0.75f, Animator.rotate(4.5f, 0f, 0f),
			PartAnimation.Interpolations.LINEAR),
		new AnimationKeyframe(1.5f, Animator.rotate(2.5f, 0f, 0f),
			PartAnimation.Interpolations.LINEAR)))
		.addPartAnimation("LeftElbow",
							  new PartAnimation(		PartAnimation.AnimationTargets.ROTATE,
		new AnimationKeyframe(0f, Animator.rotate(10f, 0f, 0f),
			PartAnimation.Interpolations.LINEAR),
		new AnimationKeyframe(0.75f, Animator.rotate(13.5f, 0f, 0f),
			PartAnimation.Interpolations.LINEAR),
		new AnimationKeyframe(1.5f, Animator.rotate(10f, 0f, 0f),
			PartAnimation.Interpolations.LINEAR)))
		.addPartAnimation("RightArm",
							  new PartAnimation(		PartAnimation.AnimationTargets.ROTATE,
		new AnimationKeyframe(0f, Animator.rotate(2.5f, 0f, 0f),
			PartAnimation.Interpolations.LINEAR),
		new AnimationKeyframe(0.75f, Animator.rotate(2f, 0f, 0f),
			PartAnimation.Interpolations.LINEAR),
		new AnimationKeyframe(0.875f, Animator.rotate(-100.42f, 0f, 0f),
			PartAnimation.Interpolations.LINEAR),
		new AnimationKeyframe(1.5f, Animator.rotate(-137.53f, 1.69f, -1.84f),
			PartAnimation.Interpolations.LINEAR)))
		.addPartAnimation("RightElbow",
							  new PartAnimation(		PartAnimation.AnimationTargets.ROTATE,
		new AnimationKeyframe(0f, Animator.rotate(10f, 0f, 0f),
			PartAnimation.Interpolations.LINEAR),
		new AnimationKeyframe(0.75f, Animator.rotate(13.5f, 0f, 0f),
			PartAnimation.Interpolations.LINEAR),
		new AnimationKeyframe(0.875f, Animator.rotate(-19.58f, 0f, 0f),
			PartAnimation.Interpolations.LINEAR),
		new AnimationKeyframe(1.5f, Animator.rotate(-2.5f, -0.11f, -2.5f),
			PartAnimation.Interpolations.LINEAR)))
		.addPartAnimation("RightElbow",
							  new PartAnimation(		PartAnimation.AnimationTargets.SCALE,
		new AnimationKeyframe(0f, Animator.scale(1f, 1f, 1f),
			PartAnimation.Interpolations.LINEAR),
		new AnimationKeyframe(0.8343334f, Animator.scale(1f, 1.04f, 1f),
			PartAnimation.Interpolations.LINEAR),
		new AnimationKeyframe(0.875f, Animator.scale(1f, 2.2f, 1f),
			PartAnimation.Interpolations.LINEAR)))
		.addPartAnimation("LeftLeg",
							  new PartAnimation(		PartAnimation.AnimationTargets.ROTATE,
		new AnimationKeyframe(0f, Animator.rotate(2.5f, 0f, 0f),
			PartAnimation.Interpolations.LINEAR),
		new AnimationKeyframe(0.75f, Animator.rotate(4.5f, 0f, 0f),
			PartAnimation.Interpolations.LINEAR),
		new AnimationKeyframe(1.5f, Animator.rotate(2.5f, 0f, 0f),
			PartAnimation.Interpolations.LINEAR)))
		.addPartAnimation("LeftKnee",
							  new PartAnimation(		PartAnimation.AnimationTargets.ROTATE,
		new AnimationKeyframe(0f, Animator.rotate(5f, 0f, 0f),
			PartAnimation.Interpolations.LINEAR),
		new AnimationKeyframe(0.75f, Animator.rotate(2.5f, 0f, 0f),
			PartAnimation.Interpolations.LINEAR),
		new AnimationKeyframe(1.5f, Animator.rotate(5f, 0f, 0f),
			PartAnimation.Interpolations.LINEAR)))
		.addPartAnimation("RightLeg",
							  new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
		new AnimationKeyframe(0f, Animator.rotate(7.5f, 0f, 0f),
			PartAnimation.Interpolations.LINEAR),
		new AnimationKeyframe(0.75f, Animator.rotate(6f, 0f, 0f),
			PartAnimation.Interpolations.LINEAR),
		new AnimationKeyframe(1.5f, Animator.rotate(7.5f, 0f, 0f),
			PartAnimation.Interpolations.LINEAR)))
		.addPartAnimation("RightKnee",
							  new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
		new AnimationKeyframe(0f, Animator.rotate(15f, 0f, 0f),
			PartAnimation.Interpolations.LINEAR),
		new AnimationKeyframe(0.75f, Animator.rotate(20f, 0f, 0f),
			PartAnimation.Interpolations.LINEAR),
		new AnimationKeyframe(1.5f, Animator.rotate(15f, 0f, 0f),
			PartAnimation.Interpolations.LINEAR))).build();
}

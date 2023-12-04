package net.brdle.collectorsreap.client.animation;

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;

public class ClamAnimation {
	public static final AnimationDefinition CLAM_CLOSED = AnimationDefinition.Builder.withLength(0.36f).looping()
		.addAnimation("Top",
			new AnimationChannel(AnimationChannel.Targets.ROTATION,
				new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
					AnimationChannel.Interpolations.LINEAR))).build();
	public static final AnimationDefinition CLAM_OPEN = AnimationDefinition.Builder.withLength(0f).looping()
		.addAnimation("Top",
			new AnimationChannel(AnimationChannel.Targets.ROTATION,
				new Keyframe(0f, KeyframeAnimations.degreeVec(-67.5f, 0f, 0f),
					AnimationChannel.Interpolations.LINEAR))).build();
	public static final AnimationDefinition CLAM_OPENING = AnimationDefinition.Builder.withLength(0.84f)
		.addAnimation("Top",
			new AnimationChannel(AnimationChannel.Targets.ROTATION,
				new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
					AnimationChannel.Interpolations.LINEAR),
				new Keyframe(0.08f, KeyframeAnimations.degreeVec(-33.5f, 0f, 0f),
					AnimationChannel.Interpolations.LINEAR),
				new Keyframe(0.2f, KeyframeAnimations.degreeVec(-64.6f, 0f, 0f),
					AnimationChannel.Interpolations.LINEAR),
				new Keyframe(0.4f, KeyframeAnimations.degreeVec(-87.25f, 0f, 0f),
					AnimationChannel.Interpolations.LINEAR),
				new Keyframe(0.64f, KeyframeAnimations.degreeVec(-98.4f, 0f, 0f),
					AnimationChannel.Interpolations.LINEAR),
				new Keyframe(0.84f, KeyframeAnimations.degreeVec(-103.5f, 0f, 0f),
					AnimationChannel.Interpolations.LINEAR))).build();
	public static final AnimationDefinition CLAM_CLOSING = AnimationDefinition.Builder.withLength(0.76f)
		.addAnimation("Top",
			new AnimationChannel(AnimationChannel.Targets.ROTATION,
				new Keyframe(0f, KeyframeAnimations.degreeVec(-102.5f, 0f, 0f),
					AnimationChannel.Interpolations.LINEAR),
				new Keyframe(0.36f, KeyframeAnimations.degreeVec(-92.5f, 0f, 0f),
					AnimationChannel.Interpolations.LINEAR),
				new Keyframe(0.56f, KeyframeAnimations.degreeVec(-68.5f, 0f, 0f),
					AnimationChannel.Interpolations.LINEAR),
				new Keyframe(0.68f, KeyframeAnimations.degreeVec(-40f, 0f, 0f),
					AnimationChannel.Interpolations.LINEAR),
				new Keyframe(0.76f, KeyframeAnimations.degreeVec(-3f, 0f, 0f),
					AnimationChannel.Interpolations.LINEAR))).build();
}

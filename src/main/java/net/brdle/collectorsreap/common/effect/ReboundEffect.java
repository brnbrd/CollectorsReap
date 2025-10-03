package net.brdle.collectorsreap.common.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

public class ReboundEffect extends MobEffect {
	/**
	 * 15% chance when hit to recover 10 HP
	 * Increases by 6 HP per amplifier
	 */
	protected ReboundEffect() {
		super(MobEffectCategory.BENEFICIAL, 0xF2951A);
	}

	/**
	 * Checks whether the effect is ready to be applied this tick.
	 */
	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return false;
	}
}
package net.brdle.collectorsreap.common.effect;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.NotNull;

public class SurgeEffect extends MobEffect {
	/**
	 * Striking an enemy has a chance of summoning a lightning bolt
	 */
	protected SurgeEffect() {
		super(MobEffectCategory.BENEFICIAL, 0xF1A3D2);
	}

	@Override
	public void applyEffectTick(@NotNull LivingEntity entity, int amplifier) {
		SurgeEffect.emitParticles(entity, amplifier);
	}

	/**
	 * Checks whether the effect is ready to be applied this tick.
	 */
	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return duration % 10 == 0;
	}

	public static void emitParticles(@NotNull LivingEntity entity, int amplifier) {
		if (entity.level() instanceof ServerLevel server) {
			for (int i = 0; i <= amplifier; i++) {
				server.sendParticles(
					CREffects.SURGE_PARTICLE,
					entity.getRandomX(0.6D),
					entity.getRandomY() + 0.5D,
					entity.getRandomZ(0.6D),
					2,
					0.1D,
					0.1D,
					0.1D,
					0.15D
				);
			}
		}
	}
}
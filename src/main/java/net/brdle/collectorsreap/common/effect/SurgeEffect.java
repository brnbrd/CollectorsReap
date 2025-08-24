package net.brdle.collectorsreap.common.effect;

import net.brdle.collectorsreap.common.CRParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.NotNull;

public class SurgeEffect extends MobEffect {
	public static final int MAX_SURGE = 2;
	public static final float SURGE_ZERO_MULTIPLIER = 1.2F;
	public static final float SURGE_ONE_MULTIPLIER = 1.4F;
	public static final float SURGE_TWO_MULTIPLIER = 1.6F;

	/**
	 * Striking an enemy can summon a lightning bolt
	 */
	protected SurgeEffect() {
		super(MobEffectCategory.BENEFICIAL, 0xF1A3D2);
	}

	/**
	 * Checks whether the effect is ready to be applied this tick.
	 */
	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return duration % 2 == 0;
	}

	@Override
	public void applyEffectTick(@NotNull LivingEntity entity, int amplifier) {
		if (amplifier == SurgeEffect.MAX_SURGE) {
			SurgeEffect.emitParticles(entity, 2);
		}
	}

	public static void emitParticles(@NotNull LivingEntity entity, int amount) {
		if (entity.level() instanceof ServerLevel server) {
			for (int i = 0; i < amount; i ++) {
				server.sendParticles(
					CRParticleTypes.SURGE.get(),
					entity.getRandomX(0.55D),
					entity.getRandomY() + 0.4D,
					entity.getRandomZ(0.55D),
					1,
					0D,
					0D,
					0D,
					0D
				);
			}
		}
	}
}
package net.brdle.collectorsreap.common.item.drink;

import net.brdle.collectorsreap.Util;
import net.brdle.collectorsreap.compat.Modid;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

public class LimboBrewItem extends CompatDrinkable {
	private final int buffExtension;

	public LimboBrewItem(Properties properties, boolean hasPotionEffectTooltip, boolean hasCustomTooltip, int buffExtension, Modid... modid) {
		super(properties, hasPotionEffectTooltip, hasCustomTooltip, modid);
		this.buffExtension = buffExtension;
	}

	// Time in ticks that beneficial effects are extended
	public final int getBuffExtension() {
		return buffExtension;
	}

	@Override
	public void affectConsumer(@NotNull ItemStack stack, @NotNull Level level, @NotNull LivingEntity consumer) {
		super.affectConsumer(stack, level, consumer);
		for (final MobEffect effect : Util.getBeneficialEffects(consumer)) {
			if (consumer.hasEffect(effect)) {
				final @NotNull MobEffectInstance current = Objects.requireNonNull(consumer.getEffect(effect));
				final MobEffectInstance extended = new MobEffectInstance(
					effect,
					current.getDuration() + this.getBuffExtension(),
					current.getAmplifier(),
					current.isVisible(),
					current.showIcon()
				);
				if (Util.removeEffect(consumer, effect)) {
					consumer.forceAddEffect(extended, null);
				}
			}
		}
	}
}
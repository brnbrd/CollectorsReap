package net.brdle.collectorsreap.common.item.food;

import net.brdle.collectorsreap.Util;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.ForgeRegistries;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import vectorwing.farmersdelight.common.item.ConsumableItem;
import org.jetbrains.annotations.NotNull;

public class ShimmeringAppleItem extends ConsumableItem {
	public ShimmeringAppleItem(Properties properties) {
		super(properties);
	}

	@Override
	public boolean isFoil(@NotNull ItemStack stack) {
		return true;
	}

	@Override
	public void affectConsumer(@NotNull ItemStack stack, @NotNull Level level, @NotNull LivingEntity consumer) {
		super.affectConsumer(stack, level, consumer);
		final Map<MobEffect, MobEffectInstance> active = new HashMap<>(consumer.getActiveEffectsMap());
		if (active.isEmpty()) {
			consumer.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 400, 1));
			return;
		}
		final List<MobEffect> allBuffs = new ArrayList<>();
		final List<MobEffect> allDebuffs = new ArrayList<>();
		ForgeRegistries.MOB_EFFECTS.getValues().forEach(mobEffect -> {
			if (!mobEffect.isInstantenous()) {
				if (mobEffect.getCategory() == MobEffectCategory.BENEFICIAL) {
					allBuffs.add(mobEffect);
				} else if (mobEffect.getCategory() == MobEffectCategory.HARMFUL) {
					allDebuffs.add(mobEffect);
				}
			}
		});
		final List<MobEffect> activeBuffs = Util.getBeneficialEffects(consumer);
		allBuffs.removeAll(activeBuffs);
		final List<MobEffect> activeDebuffs = Util.getCurableEffects(consumer);
		allDebuffs.removeAll(activeDebuffs);
		final RandomSource random = consumer.getRandom();
		active.entrySet().stream()
			.filter(pair ->
				!pair.getKey().isInstantenous() &&
				!pair.getValue().isAmbient() &&
				!pair.getValue().isInfiniteDuration() &&
				pair.getValue().getDuration() > 200 &&
				pair.getValue().isVisible() &&
				pair.getValue().showIcon()
			).forEach(entry -> {
				List<MobEffect> effectList;
				final MobEffect effect = entry.getKey();
				final MobEffectInstance instance = entry.getValue();
				if (effect.getCategory() == MobEffectCategory.BENEFICIAL) {
					effectList = allBuffs;
				} else if (effect.getCategory() == MobEffectCategory.HARMFUL) {
					effectList = allDebuffs;
				} else {
					return;
				}
				if (!effectList.isEmpty()) {
					final MobEffect selectedEffect = effectList.remove(random.nextInt(effectList.size()));
					final int duration = Math.min(instance.getDuration(), random.nextIntBetweenInclusive(800, 2400));
					final int amp = Math.min(instance.getAmplifier(), 2);
					if (Util.removeEffect(consumer, effect)) {
						consumer.forceAddEffect(new MobEffectInstance(selectedEffect, duration, amp), consumer);
					}
				}
			}
		);
	}
}
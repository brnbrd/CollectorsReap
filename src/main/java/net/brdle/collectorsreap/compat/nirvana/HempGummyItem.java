package net.brdle.collectorsreap.compat.nirvana;

import net.brdle.collectorsreap.common.item.food.GummyItem;
import net.brdle.collectorsreap.compat.Modid;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import galena.nirvana.world.effects.IStackingEffect;

public class HempGummyItem extends GummyItem {
	public HempGummyItem(Properties prop, Modid... modid) {
		super(prop, modid);
	}

	@Override
	public void affectConsumer(@NotNull ItemStack stack, @NotNull Level level, @NotNull LivingEntity consumer) {
		super.affectConsumer(stack, level, consumer);
		if (this.enabled()) {
			for (MobEffectInstance effectInstance : this.getEffects(stack, consumer)) {
				if (effectInstance.getEffect() instanceof IStackingEffect stacking) {
					stacking.onIncreasedTo(effectInstance, stack, consumer, level);
				}
			}
		}
	}

	@Override
	public void addEffects(@NotNull ItemStack stack, @NotNull LivingEntity consumer) {
		super.addEffects(stack, consumer);
		if (this.enabled()) {
			for (MobEffectInstance effectInstance : this.getEffects(stack, consumer)) {
				if (effectInstance.getEffect() instanceof IStackingEffect stacking) {
					stacking.onIncreasedTo(effectInstance, stack, consumer, consumer.level());
				}
			}
		}
	}
}
package net.brdle.collectorsreap.common.item.food;

import net.brdle.collectorsreap.compat.Modid;
import net.brdle.collectorsreap.compat.abnormals.NeapolitanCompat;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class AdzukiGummyItem extends GummyItem {
	private static final int MAX_NEARBY = 3;

	public AdzukiGummyItem(Properties prop) {
		super(prop, Modid.N);
	}

	@Override
	public void affectConsumer(@NotNull ItemStack stack, @NotNull Level level, @NotNull LivingEntity consumer) {
		super.affectConsumer(stack, level, consumer);
		if (this.enabled()) {
			final MobEffect vanilla = NeapolitanCompat.getVanillaScent();
			level.getNearbyEntities(LivingEntity.class, TargetingConditions.DEFAULT.selector(near ->
					near != consumer &&
					(near.getEffect(vanilla) == null || !near.hasEffect(NeapolitanCompat.getVanillaScent()))
				), consumer, consumer.getBoundingBox().inflate(6D, 2D, 6D))
				.stream().limit(MAX_NEARBY)
				.forEach(n -> n.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 200, 3)));
		}
	}
}
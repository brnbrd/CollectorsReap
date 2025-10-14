package net.brdle.collectorsreap.common.item.drink;

import net.brdle.collectorsreap.Util;
import net.brdle.collectorsreap.compat.Modid;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class VernalPurgeItem extends CompatDrinkable {
	public VernalPurgeItem(Properties properties, boolean hasPotionEffectTooltip, boolean hasCustomTooltip, Modid... modid) {
		super(properties, hasPotionEffectTooltip, hasCustomTooltip, modid);
	}

	@Override
	public void affectConsumer(@NotNull ItemStack stack, @NotNull Level level, @NotNull LivingEntity consumer) {
		super.affectConsumer(stack, level, consumer);
		Util.removeCurableEffects(consumer);
	}
}
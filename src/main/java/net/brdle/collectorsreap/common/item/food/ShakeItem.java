package net.brdle.collectorsreap.common.item.food;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import org.jetbrains.annotations.NotNull;
import vectorwing.farmersdelight.common.item.ConsumableItem;

public class ShakeItem extends ConsumableItem {

	public ShakeItem(Properties properties) {
		super(properties);
	}

	@Override
	public int getUseDuration(@NotNull ItemStack stack) {
		return 40;
	}

	@Override
	public @NotNull UseAnim getUseAnimation(@NotNull ItemStack stack) {
		return UseAnim.DRINK;
	}

	@Override
	public @NotNull SoundEvent getDrinkingSound() {
		return SoundEvents.HONEY_DRINK;
	}

	@Override
	public @NotNull SoundEvent getEatingSound() {
		return SoundEvents.HONEY_DRINK;
	}
}

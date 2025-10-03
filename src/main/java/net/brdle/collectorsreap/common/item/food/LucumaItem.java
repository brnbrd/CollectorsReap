package net.brdle.collectorsreap.common.item.food;

import net.minecraft.world.item.ItemStack;
import vectorwing.farmersdelight.common.item.ConsumableItem;
import org.jetbrains.annotations.NotNull;

public class LucumaItem extends ConsumableItem {
	public LucumaItem(Properties properties) {
		super(properties, true, false);
	}

	@Override
	public int getUseDuration(@NotNull ItemStack stack) {
		return 48;
	}
}
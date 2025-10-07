package net.brdle.collectorsreap.common.item.food;

import net.brdle.collectorsreap.compat.Modid;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class GummyItem extends CompatConsumable {
	public GummyItem(Properties prop) {
		super(prop, true, false);
	}

	public GummyItem(Properties prop, @NotNull Modid modid) {
		super(prop, true, false, modid);
	}

	// Healing gummy will have custom tooltip
	public GummyItem(Properties prop, float heal) {
		super(prop, true, true, heal);
	}

	public GummyItem(Properties prop, boolean hasCustomTooltip, float heal, @NotNull Modid modid) {
		super(prop, true, hasCustomTooltip, heal, modid);
	}

	@Override
	public int getUseDuration(@NotNull ItemStack stack) {
		return 14;
	}
}
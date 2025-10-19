package net.brdle.collectorsreap.common.item.food;

import net.brdle.collectorsreap.compat.Modid;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class GummyItem extends CompatConsumable {
	public GummyItem(Properties prop, Modid... modid) {
		super(prop, true, false, modid);
	}

	@Override
	public int getUseDuration(@NotNull ItemStack stack) {
		return 14;
	}
}
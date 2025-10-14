package net.brdle.collectorsreap.common.item.drink;

import net.brdle.collectorsreap.compat.ICompat;
import net.brdle.collectorsreap.compat.Modid;
import vectorwing.farmersdelight.common.item.DrinkableItem;

public class CompatDrinkable extends DrinkableItem implements ICompat {
	private final Modid[] modid;

	public CompatDrinkable(Properties properties, boolean hasPotionEffectTooltip, boolean hasCustomTooltip, Modid... modid) {
		super(
			properties,
			hasPotionEffectTooltip,
			hasCustomTooltip
		);
		this.modid = modid;
	}

	public Modid[] getModid() {
		return this.modid;
	}
}
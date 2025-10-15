package net.brdle.collectorsreap.common.item.drink;

import net.brdle.collectorsreap.common.item.IConfigured;
import net.brdle.collectorsreap.compat.Modid;
import vectorwing.farmersdelight.common.item.DrinkableItem;

public class CompatDrinkable extends DrinkableItem implements IConfigured {
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
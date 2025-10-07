package net.brdle.collectorsreap.common.item.food;

import net.brdle.collectorsreap.compat.ICompat;
import net.brdle.collectorsreap.compat.Modid;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import vectorwing.farmersdelight.common.item.DrinkableItem;

public class CompatDrinkable extends DrinkableItem implements ICompat {
	private final Modid[] modid;

	public CompatDrinkable(Properties properties, boolean hasPotionEffectTooltip, boolean hasCustomTooltip, Modid... modid) {
		super(
			properties
				.stacksTo(16)
				.craftRemainder(Items.GLASS_BOTTLE),
			hasPotionEffectTooltip,
			hasCustomTooltip
		);
		this.modid = modid;
	}

	public CompatDrinkable(Properties properties, boolean hasPotionEffectTooltip, boolean hasCustomTooltip, Item remainder, Modid... modid) {
		super(
			properties
				.stacksTo(16)
				.craftRemainder(remainder),
			hasPotionEffectTooltip,
			hasCustomTooltip
		);
		this.modid = modid;
	}

	public Modid[] getModid() {
		return this.modid;
	}
}
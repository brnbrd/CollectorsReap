package net.brdle.collectorsreap.compat.miners_delight;

import net.brdle.collectorsreap.common.item.food.CompatConsumable;
import net.brdle.collectorsreap.compat.Modid;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

public class CupItem extends CompatConsumable {
	public CupItem(Item.Properties properties, boolean hasFoodEffectTooltip, boolean hasCustomTooltip) {
		super(
			properties
				.stacksTo(16)
				.craftRemainder(Modid.MD.item("copper_cup", Items.BOWL)),
			hasFoodEffectTooltip,
			hasCustomTooltip,
			Modid.MD
		);
	}
}
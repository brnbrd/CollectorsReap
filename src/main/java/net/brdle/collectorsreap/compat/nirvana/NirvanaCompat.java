package net.brdle.collectorsreap.compat.nirvana;

import net.brdle.collectorsreap.common.item.food.Nutrition;
import net.minecraft.world.item.Item;

public class NirvanaCompat {
	public static Item hempGummyItem() {
		return new HempGummyItem((new Item.Properties()).food(Nutrition.HEMP_GUMMY));
	}
}
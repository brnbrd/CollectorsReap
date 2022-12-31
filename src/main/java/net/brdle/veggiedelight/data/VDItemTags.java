package net.brdle.veggiedelight.data;

import net.brdle.veggiedelight.Util;
import net.brdle.veggiedelight.VeggieDelight;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class VDItemTags {

	public static final TagKey<Item> FRUITS = forge("fruits");
	public static final TagKey<Item> FRUITS_POMEGRANATE = forge("fruits/pomegranate");
	public static final TagKey<Item> MUSHROOMS_PORTOBELLO = forge("mushrooms/portobello");

	private static TagKey<Item> vd(String name) {
		return Util.it(VeggieDelight.MODID, name);
	}

	private static TagKey<Item> forge(String name) {
		return Util.it("forge", name);
	}
}
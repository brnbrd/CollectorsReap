package net.brdle.collectorsreap.data;

import net.brdle.collectorsreap.Util;
import net.brdle.collectorsreap.CollectorsReap;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class CRItemTags {

	// Forge
	public static final TagKey<Item> FRUITS = forge("fruits");
	public static final TagKey<Item> FRUITS_CITRUS = forge("fruits/citrus");
	public static final TagKey<Item> FRUITS_POMEGRANATE = forge("fruits/pomegranate");
	public static final TagKey<Item> SEEDS_POMEGRANATE = forge("seeds/pomegranate");
	public static final TagKey<Item> FRUITS_LEMON = forge("fruits/lemon");
	public static final TagKey<Item> SEEDS_LEMON = forge("seeds/lemon");
	public static final TagKey<Item> MUSHROOMS_PORTOBELLO = forge("mushrooms/portobello");

	// VD
	public static final TagKey<Item> LEMON_OR_SLICE = vd("lemon_or_slice");

	private static TagKey<Item> vd(String name) {
		return Util.it(CollectorsReap.MODID, name);
	}

	private static TagKey<Item> forge(String name) {
		return Util.it("forge", name);
	}
}
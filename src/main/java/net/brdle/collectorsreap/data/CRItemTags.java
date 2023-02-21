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
	public static final TagKey<Item> FRUITS_LIME = forge("fruits/lime");
	public static final TagKey<Item> SEEDS_LIME = forge("seeds/lime");
	public static final TagKey<Item> MUSHROOMS_PORTOBELLO = forge("mushrooms/portobello");
	public static final TagKey<Item> TORTILLA = forge("tortilla");
	public static final TagKey<Item> ICE_CUBES = forge("ice_cubes");

	// VD
	public static final TagKey<Item> LIME_OR_SLICE = vd("lime_or_slice");

	// ND
	public static final TagKey<Item> RAW_STRIDER = Util.it("nethersdelight", "raw_strider");
	public static final TagKey<Item> PROPELPEARL = Util.it("nethersdelight", "propelpearl");
	public static final TagKey<Item> HOGLIN_LOIN = Util.it("nethersdelight", "hoglin_loin");

	// Neapolitan
	public static final TagKey<Item> ICE_CREAM = Util.it("neapolitan", "ice_cream");

	// Serene Seasons
	public static final TagKey<Item> WINTER_CROPS = Util.it("sereneseasons", "winter_crops");
	public static final TagKey<Item> SUMMER_CROPS = Util.it("sereneseasons", "summer_crops");
	public static final TagKey<Item> AUTUMN_CROPS = Util.it("sereneseasons", "autumn_crops");
	public static final TagKey<Item> SPRING_CROPS = Util.it("sereneseasons", "spring_crops");

	private static TagKey<Item> vd(String name) {
		return Util.it(CollectorsReap.MODID, name);
	}

	private static TagKey<Item> forge(String name) {
		return Util.it("forge", name);
	}
}
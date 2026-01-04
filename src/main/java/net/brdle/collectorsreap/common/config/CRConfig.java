package net.brdle.collectorsreap.common.config;

import net.brdle.collectorsreap.Util;
import net.brdle.collectorsreap.common.item.CRItems;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.registries.RegistryObject;
import java.util.HashMap;

public class CRConfig {
	public static final ForgeConfigSpec COMMON;
	private static final HashMap<String, ForgeConfigSpec.BooleanValue> ITEM_VALUES;

	// COMMON
	public static final ForgeConfigSpec.BooleanValue LIME_POLLINATION;
	public static final ForgeConfigSpec.BooleanValue POMEGRANATE_POLLINATION;
	public static final ForgeConfigSpec.BooleanValue FAST_POLLINATE;
	public static final ForgeConfigSpec.IntValue STYGIAN_POMEGRANATE_RARITY;
	public static final ForgeConfigSpec.IntValue PANETTONE_DURATION;
	public static final ForgeConfigSpec.DoubleValue SURGE_ZERO_MULTIPLIER;
	public static final ForgeConfigSpec.DoubleValue SURGE_ONE_MULTIPLIER;
	public static final ForgeConfigSpec.DoubleValue SURGE_TWO_MULTIPLIER;
	public static final ForgeConfigSpec.DoubleValue REBOUND_CHANCE;

	static {
		final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

		BUILDER.push("Behavior");
		FAST_POLLINATE = BUILDER
			.comment("Whether bee pollination of bushes should occur much quicker (when Bee collides with it) rather than on Bee's AI scheduled timing. Use this if having issues with pollination.")
			.define("fast_pollinate", false);
		LIME_POLLINATION = BUILDER
			.comment("Whether Lime Bushes require Bee pollination to reach final growth stage.")
			.define("lime_pollination", true);
		POMEGRANATE_POLLINATION = BUILDER
			.comment("Whether Pomegranate Bushes require Bee pollination to reach final growth stage in the Overworld.")
			.define("pomegranate_pollination", true);
		STYGIAN_POMEGRANATE_RARITY = BUILDER
			.comment("(1/x) Chance to pick a Stygian Pomegranate from a bush when all conditions are met.")
			.defineInRange("stygian_pomegranate_rarity", 10, 1, 100);
		BUILDER.pop();

		BUILDER.push("Effects");
		PANETTONE_DURATION = BUILDER
			.comment("Length in seconds of effect gained by eating Panettone.")
			.defineInRange("panettone_duration", 20, 0, 600);
		SURGE_ZERO_MULTIPLIER = BUILDER
			.comment("Attack damage multiplier gained from Surge I.")
			.defineInRange("surge_zero_multiplier", 1.2D, 1.0D, 10.0D);
		SURGE_ONE_MULTIPLIER = BUILDER
			.comment("Attack damage multiplier gained from Surge II.")
			.defineInRange("surge_one_multiplier", 1.4D, 1.0D, 10.0D);
		SURGE_TWO_MULTIPLIER = BUILDER
			.comment("Attack damage multiplier gained from Surge III.")
			.defineInRange("surge_two_multiplier", 1.6D, 1.0D, 10.0D);
		REBOUND_CHANCE = BUILDER
			.comment("Chance to regain health with Rebound")
			.defineInRange("rebound_chance", 0.15D, 0.01D, 1.0D);
		BUILDER.pop();

		ITEM_VALUES = new HashMap<>();
		BUILDER.push("Items");
		CRItems.HELPER.getDeferredRegister().getEntries().stream()
			.map(obj -> obj.getId().getPath())
			.sorted()
			.forEach(name -> defineItem(BUILDER, name));
		BUILDER.pop();
		COMMON = BUILDER.build();
	}

	public static boolean verify(String item) {
		return contains(item) && ITEM_VALUES.get(item).get();
	}

	public static boolean verify(RegistryObject<Item> item) {
		return verify(item.getId().getPath());
	}

	public static boolean verify(Item item) {
		return verify(Util.name(item));
	}

	private static void defineItem(ForgeConfigSpec.Builder builder, String name) {
		ITEM_VALUES.put(name, builder.define(name, true));
	}

	private static boolean contains(String item) {
		return ITEM_VALUES.containsKey(item);
	}
}
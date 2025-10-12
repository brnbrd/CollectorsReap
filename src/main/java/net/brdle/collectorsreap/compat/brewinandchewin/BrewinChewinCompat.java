package net.brdle.collectorsreap.compat.brewinandchewin;

import net.brdle.collectorsreap.Util;
import net.brdle.collectorsreap.common.fluid.CRFluids;
import net.brdle.collectorsreap.common.item.food.Nutrition;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import java.util.function.Supplier;

public class BrewinChewinCompat {
	private static final ResourceLocation tankard = Util.rl("brewinandchewin", "tankard");

	public static final Supplier<Item> DEIFIC_BLOOD = () -> new CRBoozeItem(
		CRFluids.DEIFIC_BLOOD.get(), (new Item.Properties())
			.stacksTo(16)
			.craftRemainder(Util.item(tankard, Items.GLASS_BOTTLE))
			.food(Nutrition.DEIFIC_BLOOD)
	);
	public static final Supplier<Item> HERMITS_SOUR = () -> new CRBoozeItem(
		CRFluids.HERMITS_SOUR.get(), (new Item.Properties())
			.stacksTo(16)
			.craftRemainder(Util.item(tankard, Items.GLASS_BOTTLE))
			.food(Nutrition.HERMITS_SOUR)
	);
	public static final Supplier<Item> ROSE_MOON = () -> new CRBoozeItem(
		CRFluids.ROSE_MOON.get(), (new Item.Properties())
			.stacksTo(16)
			.craftRemainder(Util.item(tankard, Items.GLASS_BOTTLE))
			.food(Nutrition.ROSE_MOON)
	);
	public static final Supplier<Item> REANIMATORS_GARDEN = () -> new CRBoozeItem(
		CRFluids.REANIMATORS_GARDEN.get(), (new Item.Properties())
			.stacksTo(16)
			.craftRemainder(Util.item(tankard, Items.GLASS_BOTTLE))
			.food(Nutrition.REANIMATORS_GARDEN)
	);
	public static final Supplier<Item> HEAVENS_CREAM = () -> new CRBoozeItem(
		CRFluids.HEAVENS_CREAM.get(), (new Item.Properties())
			.stacksTo(16)
			.craftRemainder(Util.item(tankard, Items.GLASS_BOTTLE))
			.food(Nutrition.HEAVENS_CREAM)
	);
}
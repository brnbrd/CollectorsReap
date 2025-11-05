package net.brdle.collectorsreap.common.item;

import java.util.Map;
import java.util.function.Supplier;
import com.mojang.datafixers.util.Pair;
import com.teamabnormals.blueprint.core.util.registry.ItemSubRegistryHelper;
import net.brdle.collectorsreap.CollectorsReap;
import net.brdle.collectorsreap.Util;
import net.brdle.collectorsreap.common.block.CRBlocks;
import net.brdle.collectorsreap.common.entity.CREntities;
import net.brdle.collectorsreap.common.item.drink.CompatDrinkable;
import net.brdle.collectorsreap.common.item.drink.LimboBrewItem;
import net.brdle.collectorsreap.common.item.drink.ShakeItem;
import net.brdle.collectorsreap.common.item.drink.VernalPurgeItem;
import net.brdle.collectorsreap.common.item.food.*;
import net.brdle.collectorsreap.compat.Modid;
import net.brdle.collectorsreap.compat.abnormals.AdzukiGummyItem;
import net.brdle.collectorsreap.compat.abnormals.AloeGummyItem;
import net.brdle.collectorsreap.compat.abnormals.CRBoatTypes;
import net.brdle.collectorsreap.compat.brewinandchewin.BrewinChewinCompat;
import net.brdle.collectorsreap.compat.letfishlove.LetFishLoveCompat;
import net.brdle.collectorsreap.compat.miners_delight.CupItem;
import net.brdle.collectorsreap.compat.mynethersdelight.StygianPomegranateItem;
import net.brdle.collectorsreap.compat.nirvana.NirvanaCompat;
import net.brdle.collectorsreap.compat.sob.AsparagusAspicItem;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.common.item.ConsumableItem;
import vectorwing.farmersdelight.common.item.DrinkableItem;
import vectorwing.farmersdelight.common.item.FuelBlockItem;
import vectorwing.farmersdelight.common.item.MushroomColonyItem;
import org.jetbrains.annotations.NotNull;
import static vectorwing.farmersdelight.common.registry.ModItems.*;

public class CRItems {
	public static final ItemSubRegistryHelper HELPER = CollectorsReap.REGISTRY_HELPER.getItemSubHelper();

	// Wild Crop Blocks
	public static final RegistryObject<Item> PORTOBELLO_COLONY = registerItem("portobello_colony", () ->
		new MushroomColonyItem(CRBlocks.PORTOBELLO_COLONY.get(), (new Item.Properties())));
	public static final RegistryObject<Item> PORTOBELLO = registerBlock(CRBlocks.PORTOBELLO);

	// Fruits/Veggies/Seeds
	public static final RegistryObject<Item> POMEGRANATE = registerItem("pomegranate", () ->
		new Item((new Item.Properties())));
	public static final RegistryObject<Item> POMEGRANATE_SLICE = registerFood("pomegranate_slice",
		new Item.Properties().food(Nutrition.POMEGRANATE_SLICE), true, false);
	public static final RegistryObject<Item> POMEGRANATE_SEEDS = registerItem("pomegranate_seeds", () ->
		new FruitBushSeedsItem(
			CRBlocks.POMEGRANATE_BUSH.get(), (new Item.Properties()).food(Nutrition.POMEGRANATE_SEEDS)
		));
	public static final RegistryObject<Item> STYGIAN_POMEGRANATE = registerItem("stygian_pomegranate", () ->
		new StygianPomegranateItem((new Item.Properties()).food(Nutrition.STYGIAN_POMEGRANATE)));
	public static final RegistryObject<Item> LIME = registerFood("lime",
		new Item.Properties().food(Nutrition.LIME), true, false);
	public static final RegistryObject<Item> LIME_SLICE = registerFood("lime_slice",
		new Item.Properties().food(Nutrition.LIME_SLICE), true, false);
	public static final RegistryObject<Item> LIME_SEEDS = registerItem("lime_seeds", () ->
		new FruitBushSeedsItem(CRBlocks.LIME_BUSH.get(), (new Item.Properties())));
	public static final RegistryObject<Item> PINK_DRAGON_FRUIT = registerFood("pink_dragon_fruit",
		new Item.Properties().food(Nutrition.PINK_DRAGON_FRUIT), true, false);
	public static final RegistryObject<Item> DRAGON_FRUIT_SEEDS = registerItem("dragon_fruit_seeds", () ->
		new ItemNameBlockItem(CRBlocks.BUDDING_PINK_DRAGON_FRUIT_CROP.get(), basicItem()) {
			public void registerBlocks(@NotNull Map<Block, Item> blockToItemMap, @NotNull Item item) {
				super.registerBlocks(blockToItemMap, item);
				blockToItemMap.put(CRBlocks.PINK_DRAGON_FRUIT_CROP.get(), item);
			}
			public void removeFromBlockToItemMap(@NotNull Map<Block, Item> blockToItemMap, @NotNull Item itemIn) {
				super.removeFromBlockToItemMap(blockToItemMap, itemIn);
				blockToItemMap.remove(CRBlocks.PINK_DRAGON_FRUIT_CROP.get());
			}
		});
	public static final RegistryObject<Item> LUCUMA = registerItem("lucuma", () ->
		new LucumaItem((new Item.Properties()).food(Nutrition.LUCUMA)));
	public static final RegistryObject<Item> GILDED_LUCUMA = registerItem("gilded_lucuma", () ->
		new ConsumableItem((new Item.Properties()).food(Nutrition.GILDED_LUCUMA), true, false));

	// Sliceable Blocks
	public static final RegistryObject<Item> PORTOBELLO_QUICHE = registerBlock(CRBlocks.PORTOBELLO_QUICHE);
	public static final RegistryObject<Item> PORTOBELLO_QUICHE_SLICE = registerFood("portobello_quiche_slice",
		Nutrition.PORTOBELLO_QUICHE_SLICE);
	public static final RegistryObject<Item> LIME_PIE = registerBlock(CRBlocks.LIME_PIE);
	public static final RegistryObject<Item> LIME_PIE_SLICE = registerItem("lime_pie_slice", () ->
		new EffectSliceItem((new Item.Properties()).food(Nutrition.LIME_PIE_SLICE)));

	// Cakes & Slices
	public static final RegistryObject<Item> LIME_CAKE = registerItem("lime_cake", () ->
		new BlockItem(CRBlocks.LIME_CAKE.get(), ((new Item.Properties()).stacksTo(1))));
	public static final RegistryObject<Item> LIME_CAKE_SLICE = registerItem("lime_cake_slice", () ->
		new EffectSliceItem((new Item.Properties()).food(Nutrition.LIME_CAKE_SLICE)));
	public static final RegistryObject<Item> POMEGRANATE_CAKE = registerItem("pomegranate_cake", () ->
		new BlockItem(CRBlocks.POMEGRANATE_CAKE.get(), ((new Item.Properties()).stacksTo(1))));
	public static final RegistryObject<Item> POMEGRANATE_CAKE_SLICE = registerItem("pomegranate_cake_slice", () ->
		new EffectSliceItem((new Item.Properties()).food(Nutrition.POMEGRANATE_CAKE_SLICE)));
	public static final RegistryObject<Item> PINK_DRAGON_FRUIT_CAKE = registerItem("pink_dragon_fruit_cake", () ->
		new BlockItem(CRBlocks.PINK_DRAGON_FRUIT_CAKE.get(), ((new Item.Properties()).stacksTo(1))));
	public static final RegistryObject<Item> PINK_DRAGON_FRUIT_CAKE_SLICE = registerItem("pink_dragon_fruit_cake_slice", () ->
		new EffectSliceItem((new Item.Properties()).food(Nutrition.PINK_DRAGON_FRUIT_CAKE_SLICE)));
	public static final RegistryObject<Item> LUCUMA_CAKE = registerItem("lucuma_cake", () ->
		new BlockItem(CRBlocks.LUCUMA_CAKE.get(), ((new Item.Properties()).stacksTo(1))));
	public static final RegistryObject<Item> LUCUMA_CAKE_SLICE = registerItem("lucuma_cake_slice", () ->
		new EffectSliceItem((new Item.Properties()).food(Nutrition.LUCUMA_CAKE_SLICE)));

	// Ice Cream
	public static final RegistryObject<Item> LIME_ICE_CREAM = registerItem("lime_ice_cream", () ->
		new IceCreamItem((new Item.Properties()).food(Nutrition.LIME_ICE_CREAM)));
	public static final RegistryObject<Item> POMEGRANATE_ICE_CREAM = registerItem("pomegranate_ice_cream", () ->
		new IceCreamItem((new Item.Properties()).food(Nutrition.POMEGRANATE_ICE_CREAM)));
	public static final RegistryObject<Item> PINK_DRAGON_FRUIT_ICE_CREAM = registerItem("pink_dragon_fruit_ice_cream", () ->
		new IceCreamItem((new Item.Properties()).food(Nutrition.PINK_DRAGON_FRUIT_ICE_CREAM)));
	public static final RegistryObject<Item> LUCUMA_ICE_CREAM = registerItem("lucuma_ice_cream", () ->
		new IceCreamItem((new Item.Properties()).food(Nutrition.LUCUMA_ICE_CREAM)));
	public static final RegistryObject<Item> SUNNY_ICE_CREAM = registerItem("sunny_ice_cream", () ->
		new IceCreamItem((new Item.Properties()).food(
			// Give Sunny effect with Buzzier Bees
			Modid.BB.loaded() ? Nutrition.SUNNY_ICE_CREAM_SUNNY : Nutrition.SUNNY_ICE_CREAM
		), 2F));

	// Milkshakes
	public static final RegistryObject<Item> LIME_MILKSHAKE = registerItem("lime_milkshake", () ->
		new ShakeItem(new Item.Properties().food(Nutrition.LIME_MILKSHAKE)
			.stacksTo(16).craftRemainder(Items.GLASS_BOTTLE)));
	public static final RegistryObject<Item> POMEGRANATE_MILKSHAKE = registerItem("pomegranate_milkshake", () ->
		new ShakeItem(new Item.Properties().food(Nutrition.POMEGRANATE_MILKSHAKE)
			.stacksTo(16).craftRemainder(Items.GLASS_BOTTLE)));
	public static final RegistryObject<Item> PINK_DRAGON_FRUIT_MILKSHAKE = registerItem("pink_dragon_fruit_milkshake", () ->
		new ShakeItem(new Item.Properties().food(Nutrition.PINK_DRAGON_FRUIT_MILKSHAKE)
			.stacksTo(16).craftRemainder(Items.GLASS_BOTTLE)));
	public static final RegistryObject<Item> LUCUMA_MILKSHAKE = registerItem("lucuma_milkshake", () ->
		new ShakeItem(new Item.Properties().food(Nutrition.LUCUMA_MILKSHAKE)
			.stacksTo(16).craftRemainder(Items.GLASS_BOTTLE)));

	// Smoothies/Custard/Pudding
	public static final RegistryObject<Item> POMEGRANATE_SMOOTHIE = registerItem("pomegranate_smoothie", () ->
		new CompatDrinkable((new Item.Properties()).food(Nutrition.POMEGRANATE_SMOOTHIE)
			.stacksTo(16).craftRemainder(Items.GLASS_BOTTLE), true, false, Modid.N));
	public static final RegistryObject<Item> POMEGRANATE_CUSTARD = registerItem("pomegranate_custard", () ->
		new ConsumableItem(drinkItem().food(Nutrition.POMEGRANATE_CUSTARD)
			.stacksTo(16).craftRemainder(Items.GLASS_BOTTLE), true, false));
	public static final RegistryObject<Item> LUCUMA_PUDDING = registerItem("lucuma_pudding", () ->
		new ConsumableItem(drinkItem().food(Nutrition.LUCUMA_PUDDING)
			.stacksTo(16).craftRemainder(Items.GLASS_BOTTLE), true, false));

	// Drinks
	public static final RegistryObject<Item> LIMEADE = registerDrink("limeade",
		drinkItem().food(Nutrition.LIMEADE), true, false);
	public static final RegistryObject<Item> STRONG_LIMEADE = registerDrink("strong_limeade",
		drinkItem().food(Nutrition.STRONG_LIMEADE), true, false);
	public static final RegistryObject<Item> BERRY_LIMEADE = registerDrink("berry_limeade",
		drinkItem().food(Nutrition.BERRY_LIMEADE), true, false);
	public static final RegistryObject<Item> PINK_LIMEADE = registerDrink("pink_limeade",
		drinkItem().food(Nutrition.PINK_LIMEADE), true, false);
	public static final RegistryObject<Item> MINT_LIMEADE = registerDrink("mint_limeade",
		drinkItem().food(Nutrition.MINT_LIMEADE), true, false, Modid.N);
	public static final RegistryObject<Item> DRAGONS_PASSION = registerDrink("dragons_passion",
		drinkItem().food(Nutrition.DRAGONS_PASSION), true, false, Modid.AT);

	// Farmer's Respite Drinks
	public static final RegistryObject<Item> LIME_GREEN_TEA = registerDrink("lime_green_tea",
		drinkItem().food(Nutrition.LIME_GREEN_TEA), true, false, Modid.FR);
	public static final RegistryObject<Item> POMEGRANATE_BLACK_TEA = registerDrink("pomegranate_black_tea",
		drinkItem().food(Nutrition.POMEGRANATE_BLACK_TEA), true, false, Modid.FR);
	public static final RegistryObject<Item> VERNAL_PURGE = registerItem("vernal_purge", () ->
		new VernalPurgeItem(drinkItem().food(Nutrition.VERNAL_PURGE), true, true, Modid.FR));
	public static final RegistryObject<Item> STRONG_VERNAL_PURGE = registerItem("strong_vernal_purge", () ->
		new VernalPurgeItem(drinkItem().food(Nutrition.STRONG_VERNAL_PURGE), true, true, Modid.FR));
	public static final RegistryObject<Item> LIMBO_BREW = registerItem("limbo_brew", () ->
		new LimboBrewItem(drinkItem().food(Nutrition.LIMBO_BREW), true, true, 600, Modid.FR));
	public static final RegistryObject<Item> LONG_LIMBO_BREW = registerItem("long_limbo_brew", () ->
		new LimboBrewItem(drinkItem(), false, true, 300, Modid.FR));
	public static final RegistryObject<Item> STRONG_LIMBO_BREW = registerItem("strong_limbo_brew", () ->
		new LimboBrewItem(drinkItem().food(Nutrition.STRONG_LIMBO_BREW), true, true, 1200, Modid.FR));
	public static final RegistryObject<Item> SWEET_RECOVERY = registerDrink("sweet_recovery",
		drinkItem().food(Nutrition.SWEET_RECOVERY), true, false, Modid.FR);
	public static final RegistryObject<Item> LONG_SWEET_RECOVERY = registerDrink("long_sweet_recovery",
		drinkItem().food(Nutrition.LONG_SWEET_RECOVERY), true, false, Modid.FR);
	public static final RegistryObject<Item> STRONG_SWEET_RECOVERY = registerDrink("strong_sweet_recovery",
		drinkItem().food(Nutrition.STRONG_SWEET_RECOVERY), true, false, Modid.FR);

	// Brewin and Chewin Drinks
	public static final RegistryObject<Item> DEIFIC_BLOOD = registerItem("deific_blood", () ->
		Modid.BC.loaded() ?
		BrewinChewinCompat.DEIFIC_BLOOD.get() :
		new CompatDrinkable((new Item.Properties()), false, false, Modid.BC)
	);
	public static final RegistryObject<Item> HERMITS_SOUR = registerItem("hermits_sour", () ->
		Modid.BC.loaded() ?
		BrewinChewinCompat.HERMITS_SOUR.get() :
		new CompatDrinkable((new Item.Properties()), false, false, Modid.BC)
	);
	public static final RegistryObject<Item> ROSE_MOON = registerItem("rose_moon", () ->
		Modid.BC.loaded() ?
		BrewinChewinCompat.ROSE_MOON.get() :
		new CompatDrinkable((new Item.Properties()), false, false, Modid.BC)
	);
	public static final RegistryObject<Item> REANIMATORS_GARDEN = registerItem("reanimators_garden", () ->
		Modid.BC.loaded() ?
		BrewinChewinCompat.REANIMATORS_GARDEN.get() :
		new CompatDrinkable((new Item.Properties()), false, false, Modid.BC)
	);
	public static final RegistryObject<Item> HEAVENS_CREAM = registerItem("heavens_cream", () ->
		Modid.BC.loaded() ?
		BrewinChewinCompat.HEAVENS_CREAM.get() :
		new CompatDrinkable((new Item.Properties()), false, false, Modid.BC)
	);

	// Soups/Stews & Cups
	public static final RegistryObject<Item> PORTOBELLO_RICE_SOUP = registerFood("portobello_rice_soup",
		bowlFoodItem(Nutrition.PORTOBELLO_RICE_SOUP), true, false);
	public static final RegistryObject<Item> PORTOBELLO_RICE_SOUP_CUP = registerItem("portobello_rice_soup_cup", () ->
		new CupItem((new Item.Properties()).food(Nutrition.PORTOBELLO_RICE_SOUP_CUP), true, false));
	public static final RegistryObject<Item> DRAGON_STEW = registerFood("dragon_stew",
		bowlFoodItem(Nutrition.DRAGON_STEW), true, false);
	public static final RegistryObject<Item> DRAGON_STEW_CUP = registerItem("dragon_stew_cup", () ->
		new CupItem((new Item.Properties()).food(Nutrition.DRAGON_STEW_CUP), true, false));
	public static final RegistryObject<Item> LUCUMA_GAZPACHO = registerFood("lucuma_gazpacho",
		bowlFoodItem(Nutrition.LUCUMA_GAZPACHO), true, false);
	public static final RegistryObject<Item> LUCUMA_GAZPACHO_CUP = registerItem("lucuma_gazpacho_cup", () ->
		new CupItem((new Item.Properties()).food(Nutrition.LUCUMA_GAZPACHO_CUP), true, false));
	public static final RegistryObject<Item> CLAM_MEATBALL_STEW = registerFood("clam_meatball_stew",
		bowlFoodItem(Nutrition.CLAM_MEATBALL_STEW), true, false);
	public static final RegistryObject<Item> CLAM_MEATBALL_STEW_CUP = registerItem("clam_meatball_stew_cup", () ->
		new CupItem((new Item.Properties()).food(Nutrition.CLAM_MEATBALL_STEW_CUP), true, false));
	public static final RegistryObject<Item> PRAWN_STEW = registerFood("prawn_stew",
		bowlFoodItem(Nutrition.PRAWN_STEW), true, false);
	public static final RegistryObject<Item> PRAWN_STEW_CUP = registerItem("prawn_stew_cup", () ->
		new CupItem((new Item.Properties()).food(Nutrition.PRAWN_STEW_CUP), true, false));
	public static final RegistryObject<Item> PLATINUM_BASS_STEW = registerFood("platinum_bass_stew",
		bowlFoodItem(Nutrition.PLATINUM_BASS_STEW), true, false);
	public static final RegistryObject<Item> PLATINUM_BASS_STEW_CUP = registerItem("platinum_bass_stew_cup", () ->
		new CupItem((new Item.Properties()).food(Nutrition.PLATINUM_BASS_STEW_CUP), true, false));

	// Tools
	public static final Pair<RegistryObject<Item>, RegistryObject<Item>> LUCUMA_BOATS = HELPER.createBoatAndChestBoatItem("lucuma", CRBlocks.LUCUMA_PLANKS);
	public static final RegistryObject<Item> LUCUMA_BOAT = LUCUMA_BOATS.getFirst();
	public static final RegistryObject<Item> LUCUMA_CHEST_BOAT = LUCUMA_BOATS.getSecond();
	public static final RegistryObject<Item> LUCUMA_FURNACE_BOAT = HELPER.createItem("lucuma_furnace_boat",
		Modid.BL.loaded() ?
		CRBoatTypes.LUCUMA_FURNACE_BOAT :
		() -> new CompatItem(new Item.Properties(), Modid.BL));
	public static final RegistryObject<Item> LARGE_LUCUMA_BOAT = HELPER.createItem("large_lucuma_boat",
		Modid.BL.loaded() ?
		CRBoatTypes.LARGE_LUCUMA_BOAT :
		() -> new CompatItem(new Item.Properties(), Modid.BL));

	// Portobello
	public static final RegistryObject<Item> BAKED_PORTOBELLO_CAP = registerFood("baked_portobello_cap",
		Nutrition.BAKED_PORTOBELLO_CAP);
	public static final RegistryObject<Item> STUFFED_PORTOBELLO_CAP = registerFood("stuffed_portobello_cap",
		Nutrition.STUFFED_PORTOBELLO_CAP);
	public static final RegistryObject<Item> PORTOBELLO_BURGER = registerFood("portobello_burger",
		Nutrition.PORTOBELLO_BURGER);
	public static final RegistryObject<Item> PORTOBELLO_WRAP = registerFood("portobello_wrap",
		Nutrition.PORTOBELLO_WRAP);
	public static final RegistryObject<Item> PORTOBELLO_RISOTTO = registerFood("portobello_risotto",
		bowlFoodItem(Nutrition.PORTOBELLO_RISOTTO), true, false);
	public static final RegistryObject<Item> PORTOBELLO_PASTA = registerFood("portobello_pasta",
		bowlFoodItem(Nutrition.PORTOBELLO_PASTA), true, false);

	// Lime
	public static final RegistryObject<Item> CANDIED_LIME = registerFood("candied_lime",
		new Item.Properties().food(Nutrition.CANDIED_LIME), true, false);
	public static final RegistryObject<Item> LIME_COOKIE = registerFood("lime_cookie",
		(new Item.Properties()).food(Nutrition.LIME_COOKIE), true, false);
	public static final RegistryObject<Item> LIME_POPSICLE = registerFood("lime_popsicle",
		(new Item.Properties()).food(Nutrition.LIME_POPSICLE).craftRemainder(Items.STICK), true, false);
	public static final RegistryObject<Item> CREAM_CHEESE = registerFood("cream_cheese",
		bowlFoodItem(Nutrition.CREAM_CHEESE), true, false);
	public static final RegistryObject<Item> HONEY_LIME_CHICKEN = registerFood("honey_lime_chicken",
		bowlFoodItem(Nutrition.HONEY_LIME_CHICKEN), true, false);
	public static final RegistryObject<Item> MEDITERRANEAN_SALMON = registerFood("mediterranean_salmon",
		bowlFoodItem(Nutrition.MEDITERRANEAN_SALMON), true, false);
	public static final RegistryObject<Item> SALMON_TARTARE = registerFood("salmon_tartare",
		bowlFoodItem(Nutrition.SALMON_TARTARE), true, false);
	public static final RegistryObject<Item> POTATO_FRITTERS = registerFood("potato_fritters",
		(new Item.Properties()).food(Nutrition.POTATO_FRITTERS), true, false);
	public static final RegistryObject<Item> COD_CEVICHE = registerFood("cod_ceviche",
		bowlFoodItem(Nutrition.COD_CEVICHE), true, false);

	// Pomegranate
	public static final RegistryObject<Item> CRIMSON_CARROT_ROAST = registerFood("crimson_carrot_roast",
		bowlFoodItem(Nutrition.CRIMSON_CARROT_ROAST), true, false);
	public static final RegistryObject<Item> POMEGRANATE_MUTTON = registerFood("pomegranate_mutton",
		bowlFoodItem(Nutrition.POMEGRANATE_MUTTON), true, false);
	public static final RegistryObject<Item> POMEGRANATE_PORK = registerFood("pomegranate_pork",
		bowlFoodItem(Nutrition.POMEGRANATE_PORK), true, false);
	public static final RegistryObject<Item> POMEGRANATE_CHICKEN = registerFood("pomegranate_chicken",
		bowlFoodItem(Nutrition.POMEGRANATE_CHICKEN), true, false);
	public static final RegistryObject<Item> DELUXE_SALAD = registerFood("deluxe_salad",
		bowlFoodItem(Nutrition.DELUXE_SALAD), true, false);

	// Pink Dragon Fruit
	public static final RegistryObject<Item> DRIED_PINK_DRAGON_FRUIT = registerFood("dried_pink_dragon_fruit",
		new Item.Properties().food(Nutrition.DRIED_PINK_DRAGON_FRUIT), true, false);
	public static final RegistryObject<Item> TROPICAL_SHAVED_ICE = registerItem("tropical_shaved_ice", () ->
		new CompatConsumable(bowlFoodItem(Nutrition.TROPICAL_SHAVED_ICE),
			true, false, Modid.N));
	public static final RegistryObject<Item> PINK_NOODLES = registerFood("pink_noodles",
		bowlFoodItem(Nutrition.PINK_NOODLES), true, false);

	// Lucuma
	public static final RegistryObject<Item> LUCUMA_BREAD = registerItem("lucuma_bread", () ->
		new ConsumableItem((new Item.Properties()).food(Nutrition.LUCUMA_BREAD), true, false));

	// Clam
	public static final RegistryObject<Item> CLAM = registerItem("clam", () -> new Item((new Item.Properties())));
	public static final RegistryObject<Item> CLAM_MEAT = registerFood("clam_meat", Nutrition.CLAM_MEAT);
	public static final RegistryObject<Item> CLAM_ROLL = registerFood("clam_roll", Nutrition.CLAM_ROLL);
	public static final RegistryObject<Item> SEA_WRAP = registerFood("sea_wrap",
		(new Item.Properties()).food(Nutrition.SEA_WRAP), true, false);
	public static final RegistryObject<Item> CLAM_PASTA = registerFood("clam_pasta",
		bowlFoodItem(Nutrition.CLAM_PASTA), true, false);
	public static final RegistryObject<Item> CLAM_CHOWDER = registerFood("clam_chowder",
		(new Item.Properties()).food(Nutrition.CLAM_CHOWDER).stacksTo(16), true, false);

	// Lunar Pearl
	public static final RegistryObject<Item> LUNAR_PEARL = registerItem("lunar_pearl", () ->
		new LunarPearlItem((new Item.Properties())));
	public static final RegistryObject<Item> SHIMMERING_PEARL = registerItem("shimmering_pearl", () ->
		new ShimmeringPearlItem((new Item.Properties()).stacksTo(16)));
	public static final RegistryObject<Item> PEARLY_CLAW = registerItem("pearly_claw", () ->
		new PearlyClawItem((new Item.Properties().rarity(Rarity.UNCOMMON).stacksTo(1))));
	public static final RegistryObject<Item> SHIMMERING_APPLE = registerItem("shimmering_apple", () ->
		new ShimmeringAppleItem((new Item.Properties().rarity(Rarity.RARE).food(Nutrition.SHIMMERING_APPLE))));

	// Tiger Prawn
	public static final RegistryObject<Item> TIGER_PRAWN = registerFood("tiger_prawn",
		(new Item.Properties()).food(Nutrition.TIGER_PRAWN), true, false);
	public static final RegistryObject<Item> COOKED_TIGER_PRAWN = registerFood("cooked_tiger_prawn", Nutrition.COOKED_TIGER_PRAWN);
	public static final RegistryObject<Item> SALMON_WRAPPED_PRAWN = registerFood("salmon_wrapped_prawn",
		bowlFoodItem(Nutrition.SALMON_WRAPPED_PRAWN), false, false);
	public static final RegistryObject<Item> PRAWN_ROLL = registerFood("prawn_roll", Nutrition.PRAWN_ROLL);
	public static final RegistryObject<Item> PRAWN_PO_BOY = registerFood("prawn_po_boy", Nutrition.PRAWN_PO_BOY);
	public static final RegistryObject<Item> PRAWN_CEVICHE = registerFood("prawn_ceviche",
		bowlFoodItem(Nutrition.PRAWN_CEVICHE), true, false);
	public static final RegistryObject<Item> PRAWN_NOODLES = registerFood("prawn_noodles",
		bowlFoodItem(Nutrition.PRAWN_NOODLES), true, false);

	// Platinum Bass
	public static final RegistryObject<Item> PLATINUM_BASS = registerFood("platinum_bass", Nutrition.PLATINUM_BASS);
	public static final RegistryObject<Item> COOKED_PLATINUM_BASS = registerFood("cooked_platinum_bass", Nutrition.COOKED_PLATINUM_BASS);
	public static final RegistryObject<Item> PLATINUM_BASS_HEAD = registerFood("platinum_bass_head", Nutrition.PLATINUM_BASS_HEAD);
	public static final RegistryObject<Item> COOKED_PLATINUM_BASS_HEAD = registerFood("cooked_platinum_bass_head", Nutrition.COOKED_PLATINUM_BASS_HEAD);
	public static final RegistryObject<Item> PLATINUM_BASS_SLICE = registerFood("platinum_bass_slice", Nutrition.PLATINUM_BASS_SLICE);
	public static final RegistryObject<Item> COOKED_PLATINUM_BASS_SLICE = registerFood("cooked_platinum_bass_slice", Nutrition.COOKED_PLATINUM_BASS_SLICE);
	public static final RegistryObject<Item> FISH_MIX = registerFood("fish_mix",
		bowlFoodItem(Nutrition.FISH_MIX), false, false);

	// Chieftain Crab
	public static final RegistryObject<Item> CHIEFTAIN_CRAB = registerItem("chieftain_crab", () -> new Item((new Item.Properties()).stacksTo(1).craftRemainder(Items.BOWL)));
	public static final RegistryObject<Item> CHIEFTAIN_CLAW = registerFood("chieftain_claw", Nutrition.CHIEFTAIN_CLAW);
	public static final RegistryObject<Item> CHIEFTAIN_LEG = registerFood("chieftain_leg", Nutrition.CHIEFTAIN_LEG);
	public static final RegistryObject<Item> CHIEFTAIN_CRAB_MEAT = registerFood("chieftain_crab_meat", Nutrition.CHIEFTAIN_CRAB_MEAT);
	public static final RegistryObject<Item> CRAB_MISO = registerFood("crab_miso",
		bowlFoodItem(Nutrition.CRAB_MISO), false, false);
	public static final RegistryObject<Item> CRAB_NOODLES = registerFood("crab_noodles",
		bowlFoodItem(Nutrition.CRAB_NOODLES), true, false);
	public static final RegistryObject<Item> CRAB_LASAGNA = registerFood("crab_lasagna",
		bowlFoodItem(Nutrition.CRAB_LASAGNA), true, false);
	public static final RegistryObject<Item> BUTTERED_LEGS = registerFood("buttered_legs",
		bowlFoodItem(Nutrition.BUTTERED_LEGS), false, false);
	public static final RegistryObject<Item> BIG_RICE_BALL = registerFood("big_rice_ball", Nutrition.BIG_RICE_BALL);
	public static final RegistryObject<Item> LAND_AND_SEA_BURGER = registerFood("land_and_sea_burger",
		new Item.Properties().food(Nutrition.LAND_AND_SEA_BURGER), true, false);

	// Urchin
	public static final RegistryObject<Item> URCHIN = registerItem("urchin", () -> new Item((new Item.Properties())));
	public static final RegistryObject<Item> UNI = registerFood("uni", Nutrition.UNI);
	public static final RegistryObject<Item> UNI_ROLL = registerFood("uni_roll", Nutrition.UNI_ROLL);
	public static final RegistryObject<Item> URCHIN_TEST = registerItem("urchin_test", () -> new Item((new Item.Properties())));
	public static final RegistryObject<Item> URCHIN_NEEDLE = registerItem("urchin_needle", () -> new Item((new Item.Properties())));
	public static final RegistryObject<Item> URCHIN_DART = registerItem("urchin_dart", () -> new UrchinDartItem((new Item.Properties())));

	// Other Compat
	public static final RegistryObject<Item> GLAZED_STRIDER = registerItem("glazed_strider", () ->
		new CompatConsumable(bowlFoodItem(Nutrition.GLAZED_STRIDER),
			true, false, Modid.MND, Modid.ND));
	public static final RegistryObject<Item> SPICY_GRENADINE_JELLY = registerItem("spicy_grenadine_jelly", () ->
		new CompatConsumable(bowlFoodItem(Nutrition.SPICY_GRENADINE_JELLY),
			true, false, Modid.MND, Modid.ND));
	public static final RegistryObject<Item> STRAWBERRY_JAM_BUN = registerItem("strawberry_jam_bun", () ->
		new CompatConsumable((new Item.Properties()).food(
			Nutrition.STRAWBERRY_JAM_BUN), true, false, 1F, Modid.N));
	public static final RegistryObject<Item> POMEGRANATE_BEAN_SALAD = registerItem("pomegranate_bean_salad", () ->
		new CompatConsumable(bowlFoodItem(Nutrition.POMEGRANATE_BEAN_SALAD),
			true, false, Modid.N));
	public static final RegistryObject<Item> CHOCOLATE_ARILS = registerItem("chocolate_arils", () ->
		new CompatConsumable((new Item.Properties()).food(
			Nutrition.CHOCOLATE_ARILS), true, false, Modid.N));

	// Vanilla/FD/CR Gummies
	public static final RegistryObject<Item> LIME_GUMMY = registerGummy("lime", Nutrition.LIME_GUMMY);
	public static final RegistryObject<Item> POMEGRANATE_GUMMY = registerGummy("pomegranate", Nutrition.POMEGRANATE_GUMMY);
	public static final RegistryObject<Item> PINK_DRAGON_FRUIT_GUMMY = registerGummy("pink_dragon_fruit", Nutrition.PINK_DRAGON_FRUIT_GUMMY);
	public static final RegistryObject<Item> LUCUMA_GUMMY = registerGummy("lucuma", Nutrition.LUCUMA_GUMMY);
	public static final RegistryObject<Item> MELON_GUMMY = registerGummy("melon", Nutrition.MELON_GUMMY);

	// Vanilla/Cosmopolitan Gummies
	public static final RegistryObject<Item> APPLE_GUMMY = registerGummy("apple", Nutrition.APPLE_GUMMY);
	public static final RegistryObject<Item> GLOW_BERRY_GUMMY = registerGummy("glow_berry", Nutrition.GLOW_BERRY_GUMMY);
	public static final RegistryObject<Item> CARROT_GUMMY = registerGummy("carrot", Nutrition.CARROT_GUMMY);

	// Farmer's Respite/Respiteful Gummies
	public static final RegistryObject<Item> GREEN_TEA_GUMMY = registerGummy("green_tea", Nutrition.GREEN_TEA_GUMMY, Modid.FR);
	public static final RegistryObject<Item> YELLOW_TEA_GUMMY = registerGummy("yellow_tea", Nutrition.YELLOW_TEA_GUMMY, Modid.FR);
	public static final RegistryObject<Item> BLACK_TEA_GUMMY = registerGummy("black_tea", Nutrition.BLACK_TEA_GUMMY, Modid.FR);
	public static final RegistryObject<Item> COFFEE_GUMMY = registerGummy("coffee", Nutrition.COFFEE_GUMMY, Modid.FR);

	// My Nether's Delight Gummies
	public static final RegistryObject<Item> BULLET_PEPPER_GUMMY = registerGummy("bullet_pepper", Nutrition.BULLET_PEPPER_GUMMY, Modid.MND);

	// Neapolitan Gummies
	public static final RegistryObject<Item> STRAWBERRY_GUMMY = registerGummy("strawberry", Nutrition.STRAWBERRY_GUMMY, Modid.N);
	public static final RegistryObject<Item> BANANA_GUMMY = registerGummy("banana", Nutrition.BANANA_GUMMY, Modid.N);
	public static final RegistryObject<Item> VANILLA_GUMMY = registerGummy("vanilla", Nutrition.VANILLA_GUMMY, Modid.N);
	public static final RegistryObject<Item> MINT_GUMMY = registerGummy("mint", Nutrition.MINT_GUMMY, Modid.N);
	public static final RegistryObject<Item> ADZUKI_GUMMY = registerItem("adzuki_gummy", () ->
		new AdzukiGummyItem((new Item.Properties()).food(Nutrition.ADZUKI_GUMMY)));
	public static final RegistryObject<Item> CHOCOLATE_GUMMY = registerGummy("chocolate", Nutrition.CHOCOLATE_GUMMY, Modid.N);

	// Atmospheric Gummies
	public static final RegistryObject<Item> PASSION_FRUIT_GUMMY = registerGummy("passion_fruit", Nutrition.PASSION_FRUIT_GUMMY, Modid.AT);
	public static final RegistryObject<Item> YUCCA_GUMMY = registerGummy("yucca", Nutrition.YUCCA_GUMMY, Modid.AT);
	public static final RegistryObject<Item> ALOE_GUMMY = registerItem("aloe_gummy", () ->
		new AloeGummyItem((new Item.Properties()).food(Nutrition.ALOE_GUMMY), Modid.AT));

	// Windswept Gummies
	public static final RegistryObject<Item> WILD_BERRY_GUMMY = registerGummy("wild_berry", Nutrition.WILD_BERRY_GUMMY, Modid.WS);

	// Seasonals Gummies
	public static final RegistryObject<Item> PUMPKIN_GUMMY = registerGummy("pumpkin", Nutrition.PUMPKIN_GUMMY, Modid.SEAS);
	public static final RegistryObject<Item> SWEET_BERRY_GUMMY = registerGummy("sweet_berry", Nutrition.SWEET_BERRY_GUMMY, Modid.SEAS);
	public static final RegistryObject<Item> BEETROOT_GUMMY = registerGummy("beetroot", Nutrition.BEETROOT_GUMMY, Modid.SEAS);

	// Smidgeon o' Bliss Gummies
	public static final RegistryObject<Item> PRICKLY_PEAR_GUMMY = registerGummy("prickly_pear", Nutrition.PRICKLY_PEAR_GUMMY, Modid.SOB);
	public static final RegistryObject<Item> PEANUT_GUMMY = registerGummy("peanut", Nutrition.PEANUT_GUMMY, Modid.SOB);
	public static final RegistryObject<Item> ASPARAGUS_ASPIC = registerItem("asparagus_aspic", () ->
		new AsparagusAspicItem((new Item.Properties()).food(Nutrition.ASPARAGUS_ASPIC), Modid.SOB));

	// Nirvana Gummies
	public static final RegistryObject<Item> HEMP_GUMMY = registerItem("hemp_gummy", () ->
		Modid.NIRV.loaded() ?
		NirvanaCompat.hempGummyItem() :
		new GummyItem((new Item.Properties()).food(Nutrition.HEMP_GUMMY), Modid.NIRV));

	// Spawn Eggs
	public static final RegistryObject<Item> TIGER_PRAWN_SPAWN_EGG = registerItem("tiger_prawn_spawn_egg", () -> new ForgeSpawnEggItem(CREntities.TIGER_PRAWN, 0x7c7248, 0x613432, new Item.Properties()));
	public static final RegistryObject<Item> PLATINUM_BASS_SPAWN_EGG = registerItem("platinum_bass_spawn_egg", () -> new ForgeSpawnEggItem(CREntities.PLATINUM_BASS, 0x091442, 0x7B8698, new Item.Properties()));
	public static final RegistryObject<Item> CHIEFTAIN_CRAB_SPAWN_EGG = registerItem("chieftain_crab_spawn_egg", () -> new ForgeSpawnEggItem(CREntities.CHIEFTAIN_CRAB, 0xB13125, 0xE1B865, new Item.Properties()));
	public static final RegistryObject<Item> URCHIN_SPAWN_EGG = registerItem("urchin_spawn_egg", () -> new ForgeSpawnEggItem(CREntities.URCHIN, 0x9990d7, 0x21132d, new Item.Properties()));
	public static final RegistryObject<Item> CLAM_SPAWN_EGG = registerItem("clam_spawn_egg", () -> new ForgeSpawnEggItem(CREntities.CLAM, 0x775745, 0xC5A877, new Item.Properties()));
	public static final RegistryObject<Item> TIGER_PRAWN_BUCKET = registerItem("tiger_prawn_bucket", () ->
		new MobBucketItem(CREntities.TIGER_PRAWN, () -> Fluids.WATER, () -> SoundEvents.BUCKET_EMPTY_TADPOLE, (new Item.Properties()).stacksTo(1).craftRemainder(Items.BUCKET)));
	public static final RegistryObject<Item> PLATINUM_BASS_BUCKET = registerItem("platinum_bass_bucket", () ->
		new MobBucketItem(CREntities.PLATINUM_BASS, () -> Fluids.WATER, () -> SoundEvents.BUCKET_EMPTY_FISH, (new Item.Properties()).stacksTo(1).craftRemainder(Items.BUCKET)));
	public static final RegistryObject<Item> CHIEFTAIN_CRAB_BUCKET = registerItem("chieftain_crab_bucket", () ->
		new MobBucketItem(CREntities.CHIEFTAIN_CRAB, () -> Fluids.WATER, () -> SoundEvents.BUCKET_EMPTY_AXOLOTL, (new Item.Properties()).stacksTo(1).craftRemainder(Items.BUCKET)));
	public static final RegistryObject<Item> URCHIN_BUCKET = registerItem("urchin_bucket", () ->
		new MobBucketItem(CREntities.URCHIN, () -> Fluids.WATER, () -> SoundEvents.BUCKET_EMPTY_TADPOLE, (new Item.Properties()).stacksTo(1).craftRemainder(Items.BUCKET)));
	public static final RegistryObject<Item> CLAM_BUCKET = registerItem("clam_bucket", () ->
		new MobBucketItem(CREntities.CLAM, () -> Fluids.WATER, () -> SoundEvents.BUCKET_EMPTY_TADPOLE, (new Item.Properties()).stacksTo(1).craftRemainder(Items.BUCKET)));

	// Let Fish Love
	public static final RegistryObject<Item> TIGER_PRAWN_ROE = registerItem("tiger_prawn_roe", () ->
		Modid.LFL.loaded() ?
		LetFishLoveCompat.tigerPrawnRoeItem() :
		new CompatItem(new Item.Properties(), Modid.LFL)
	);
	public static final RegistryObject<Item> PLATINUM_BASS_ROE = registerItem("platinum_bass_roe", () ->
		Modid.LFL.loaded() ?
		LetFishLoveCompat.platinumBassRoeItem() :
		new CompatItem(new Item.Properties(), Modid.LFL)
	);

	public static RegistryObject<Item> registerBlock(RegistryObject<? extends Block> block) {
		return registerBlock(Util.name(block), block);
	}

	public static RegistryObject<Item> registerFuel(RegistryObject<Block> block, int burnTime) {
		return registerItem(Util.name(block), () -> new FuelBlockItem(block.get(), (new Item.Properties()), burnTime));
	}

	public static RegistryObject<Item> registerBlock(String name, RegistryObject<? extends Block> block) {
		return registerItem(name, () -> new BlockItem(block.get(), (new Item.Properties())));
	}

	public static RegistryObject<Item> registerGummy(String name, FoodProperties properties, Modid... modid) {
		return registerItem(name + "_gummy", () ->
			new GummyItem((new Item.Properties()).food(properties), modid));
	}

	public static RegistryObject<Item> registerFood(String name, FoodProperties properties) {
		return registerItem(name, () -> new ConsumableItem((new Item.Properties().food(properties))));
	}

	public static RegistryObject<Item> registerFood(String name, Item.Properties properties, boolean hasFoodEffectTooltip, boolean hasCustomTooltip) {
		return registerItem(name, () -> new ConsumableItem(
			properties,
			hasFoodEffectTooltip,
			hasCustomTooltip
		));
	}

	public static RegistryObject<Item> registerDrink(String name, Item.Properties properties, boolean hasFoodEffectTooltip, boolean hasCustomTooltip) {
		return registerItem(name, () -> new DrinkableItem(
			properties
				.stacksTo(16)
				.craftRemainder(Items.GLASS_BOTTLE),
			hasFoodEffectTooltip,
			hasCustomTooltip
		));
	}

	public static RegistryObject<Item> registerDrink(String name, Item.Properties properties, boolean hasFoodEffectTooltip, boolean hasCustomTooltip, Modid... modid) {
		return registerItem(name, () -> new CompatDrinkable(
			properties
				.stacksTo(16)
				.craftRemainder(Items.GLASS_BOTTLE),
			hasFoodEffectTooltip,
			hasCustomTooltip,
			modid
		));
	}

	public static RegistryObject<Item> registerItem(String name, Supplier<Item> item) {
		return HELPER.createItem(name, item);
	}
}
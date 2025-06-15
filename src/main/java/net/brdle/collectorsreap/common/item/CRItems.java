package net.brdle.collectorsreap.common.item;

import net.brdle.collectorsreap.CollectorsReap;
import net.brdle.collectorsreap.Util;
import net.brdle.collectorsreap.common.block.CRBlocks;
import net.brdle.collectorsreap.common.entity.CREntities;
import net.brdle.collectorsreap.common.item.food.*;
import net.brdle.collectorsreap.compat.letfishlove.LetFishLoveCompat;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.common.item.ConsumableItem;
import vectorwing.farmersdelight.common.item.DrinkableItem;
import vectorwing.farmersdelight.common.item.MushroomColonyItem;
import vectorwing.farmersdelight.common.registry.ModItems;
import java.util.Map;
import java.util.function.Supplier;

public class CRItems extends ModItems {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CollectorsReap.MODID);

	// Portobello
	public static final RegistryObject<Item> PORTOBELLO_COLONY = registerItem("portobello_colony",
		() -> new MushroomColonyItem(CRBlocks.PORTOBELLO_COLONY.get(),
			(new Item.Properties())));
	public static final RegistryObject<Item> PORTOBELLO = registerBlock(CRBlocks.PORTOBELLO);
	public static final RegistryObject<Item> BAKED_PORTOBELLO_CAP = registerFood("baked_portobello_cap",
		Nutrition.BAKED_PORTOBELLO_CAP);
	public static final RegistryObject<Item> STUFFED_PORTOBELLO_CAP = registerFood("stuffed_portobello_cap",
		Nutrition.STUFFED_PORTOBELLO_CAP);
	public static final RegistryObject<Item> PORTOBELLO_BURGER = registerFood("portobello_burger",
		Nutrition.PORTOBELLO_BURGER);
	public static final RegistryObject<Item> PORTOBELLO_WRAP = registerFood("portobello_wrap",
		Nutrition.PORTOBELLO_WRAP);
	public static final RegistryObject<Item> PORTOBELLO_RICE_SOUP = registerFood("portobello_rice_soup",
		bowlFoodItem(Nutrition.PORTOBELLO_RICE_SOUP), true, false);
	public static final RegistryObject<Item> PORTOBELLO_RISOTTO = registerFood("portobello_risotto",
		bowlFoodItem(Nutrition.PORTOBELLO_RISOTTO), true, false);
	public static final RegistryObject<Item> PORTOBELLO_PASTA = registerFood("portobello_pasta",
		bowlFoodItem(Nutrition.PORTOBELLO_PASTA), true, false);
	public static final RegistryObject<Item> PORTOBELLO_QUICHE = registerBlock(CRBlocks.PORTOBELLO_QUICHE);
	public static final RegistryObject<Item> PORTOBELLO_QUICHE_SLICE = registerFood("portobello_quiche_slice",
		Nutrition.PORTOBELLO_QUICHE_SLICE);

	public static final RegistryObject<Item> DRAGON_FRUIT_SEEDS = registerItem("dragon_fruit_seeds",
		() -> new ItemNameBlockItem(CRBlocks.BUDDING_PINK_DRAGON_FRUIT_CROP.get(), basicItem()) {
			public void registerBlocks(Map<Block, Item> blockToItemMap, Item item) {
				super.registerBlocks(blockToItemMap, item);
				blockToItemMap.put(CRBlocks.PINK_DRAGON_FRUIT_CROP.get(), item);
			}
			public void removeFromBlockToItemMap(Map<Block, Item> blockToItemMap, Item itemIn) {
				super.removeFromBlockToItemMap(blockToItemMap, itemIn);
				blockToItemMap.remove(CRBlocks.PINK_DRAGON_FRUIT_CROP.get());
			}
		});
	public static final RegistryObject<Item> DRAGON_BUSH = registerItem("dragon_bush",
		() -> new BlockItem(CRBlocks.DRAGON_BUSH.get(), new Item.Properties()));
	public static final RegistryObject<Item> PINK_DRAGON_FRUIT = registerFood("pink_dragon_fruit",
		Nutrition.PINK_DRAGON_FRUIT);
	public static final RegistryObject<Item> PINK_NOODLES = registerFood("pink_noodles",
		bowlFoodItem(Nutrition.PINK_NOODLES), false, false);
	public static final RegistryObject<Item> DRAGON_STEW = registerFood("dragon_stew",
		bowlFoodItem(Nutrition.DRAGON_STEW), false, false);
	public static final RegistryObject<Item> TROPICAL_SHAVED_ICE = registerFood("tropical_shaved_ice",
		bowlFoodItem(Nutrition.TROPICAL_SHAVED_ICE), false, false);
	public static final RegistryObject<Item> DRAGONS_PASSION = registerDrink("dragons_passion",
		drinkItem().food(Nutrition.DRAGONS_PASSION), false, false);
	public static final RegistryObject<Item> POMEGRANATE = registerItem("pomegranate",
		() -> new Item((new Item.Properties())));
	public static final RegistryObject<Item> POMEGRANATE_SLICE = registerFood("pomegranate_slice",
		new Item.Properties().food(Nutrition.POMEGRANATE_SLICE), true, false);
	public static final RegistryObject<Item> POMEGRANATE_SEEDS = registerItem("pomegranate_seeds",
		() -> new FruitBushSeedsItem(
			CRBlocks.POMEGRANATE_BUSH.get(), (new Item.Properties()).food(Nutrition.POMEGRANATE_SEEDS)
		));
	public static final RegistryObject<Item> STYGIAN_POMEGRANATE = registerItem("stygian_pomegranate",
		() -> new StygianPomegranateItem((new Item.Properties()).food(Nutrition.STYGIAN_POMEGRANATE)));
	public static final RegistryObject<Item> LIME_SEEDS = registerItem("lime_seeds",
		() -> new FruitBushSeedsItem(
			CRBlocks.LIME_BUSH.get(), (new Item.Properties())
		));
	public static final RegistryObject<Item> LIME = registerFood("lime",
		Nutrition.LIME);
	public static final RegistryObject<Item> LIME_SLICE = registerFood("lime_slice",
		new Item.Properties().food(Nutrition.LIME_SLICE), true, false);
	public static final RegistryObject<Item> CANDIED_LIME = registerFood("candied_lime",
		new Item.Properties().food(Nutrition.CANDIED_LIME), true, false);
	public static final RegistryObject<Item> LIME_PIE = registerBlock(CRBlocks.LIME_PIE);
	public static final RegistryObject<Item> LIME_PIE_SLICE = registerItem("lime_pie_slice", () ->
		new EffectSliceItem((new Item.Properties()).food(Nutrition.LIME_PIE_SLICE)));
	public static final RegistryObject<Item> LIME_POPSICLE = registerFood("lime_popsicle",
		(new Item.Properties()).food(Nutrition.LIME_POPSICLE).craftRemainder(Items.STICK), true, false);
	public static final RegistryObject<Item> LIME_COOKIE = registerFood("lime_cookie",
		(new Item.Properties()).food(Nutrition.LIME_COOKIE), true, false);
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
	public static final RegistryObject<Item> POMEGRANATE_CUSTARD = registerDrink("pomegranate_custard",
		drinkItem().food(Nutrition.POMEGRANATE_CUSTARD), true, false);
	public static final RegistryObject<Item> LIMEADE = registerDrink("limeade",
		drinkItem().food(Nutrition.LIMEADE), true, false);
	public static final RegistryObject<Item> BERRY_LIMEADE = registerDrink("berry_limeade",
		drinkItem().food(Nutrition.BERRY_LIMEADE), true, false);
	public static final RegistryObject<Item> PINK_LIMEADE = registerDrink("pink_limeade",
		drinkItem().food(Nutrition.PINK_LIMEADE), true, false);
	public static final RegistryObject<Item> MINT_LIMEADE = registerItem("mint_limeade", () ->
		new CompatDrinkable((new Item.Properties()).food(
			Nutrition.MINT_LIMEADE), true, false, "neapolitan"));
	public static final RegistryObject<Item> LIME_GREEN_TEA = registerItem("lime_green_tea", () ->
		new CompatDrinkable((new Item.Properties()).food(
			Nutrition.LIME_GREEN_TEA), true, false, "farmersrespite"));
	public static final RegistryObject<Item> POMEGRANATE_BLACK_TEA = registerItem("pomegranate_black_tea", () ->
		new CompatDrinkable((new Item.Properties()).food(
			Nutrition.POMEGRANATE_BLACK_TEA), true, false, "farmersrespite"));
	public static final RegistryObject<Item> POMEGRANATE_SMOOTHIE = registerItem("pomegranate_smoothie", () ->
		new CompatDrinkable((new Item.Properties()).food(
			Nutrition.POMEGRANATE_SMOOTHIE), true, false, "neapolitan"));
	public static final RegistryObject<Item> LIME_CAKE = registerItem("lime_cake", () -> new BlockItem(CRBlocks.LIME_CAKE.get(), ((new Item.Properties()).stacksTo(1))));
	public static final RegistryObject<Item> LIME_CAKE_SLICE = registerItem("lime_cake_slice", () ->
		new EffectSliceItem((new Item.Properties()).food(Nutrition.LIME_CAKE_SLICE)));
	public static final RegistryObject<Item> POMEGRANATE_CAKE = registerItem("pomegranate_cake", () -> new BlockItem(CRBlocks.POMEGRANATE_CAKE.get(), ((new Item.Properties()).stacksTo(1))));
	public static final RegistryObject<Item> POMEGRANATE_CAKE_SLICE = registerItem("pomegranate_cake_slice", () ->
		new EffectSliceItem((new Item.Properties()).food(Nutrition.POMEGRANATE_CAKE_SLICE)));
	public static final RegistryObject<Item> LIME_CRATE = registerBlock(CRBlocks.LIME_CRATE);
	public static final RegistryObject<Item> POMEGRANATE_CRATE = registerBlock(CRBlocks.POMEGRANATE_CRATE);
	public static final RegistryObject<Item> STYGIAN_POMEGRANATE_CRATE = registerBlock(CRBlocks.STYGIAN_POMEGRANATE_CRATE);
	public static final RegistryObject<Item> PINK_DRAGON_FRUIT_CRATE = registerBlock(CRBlocks.PINK_DRAGON_FRUIT_CRATE);

	public static final RegistryObject<Item> SEA_WRAP = registerFood("sea_wrap", Nutrition.SEA_WRAP);

	// Tiger Prawn
	public static final RegistryObject<Item> TIGER_PRAWN_SPAWN_EGG = registerItem("tiger_prawn_spawn_egg", () -> new ForgeSpawnEggItem(CREntities.TIGER_PRAWN, 0x7c7248, 0x613432, new Item.Properties()));
	public static final RegistryObject<Item> TIGER_PRAWN_BUCKET = registerItem("tiger_prawn_bucket",
		() -> new MobBucketItem(CREntities.TIGER_PRAWN, () -> Fluids.WATER, () -> SoundEvents.BUCKET_EMPTY_TADPOLE, (new Item.Properties()).stacksTo(1)));
	public static final RegistryObject<Item> TIGER_PRAWN = registerFood("tiger_prawn", Nutrition.TIGER_PRAWN);
	public static final RegistryObject<Item> COOKED_TIGER_PRAWN = registerFood("cooked_tiger_prawn", Nutrition.COOKED_TIGER_PRAWN);
	public static final RegistryObject<Item> PRAWN_ROLL = registerFood("prawn_roll", Nutrition.PRAWN_ROLL);
	public static final RegistryObject<Item> SALMON_WRAPPED_PRAWN = registerFood("salmon_wrapped_prawn",
		bowlFoodItem(Nutrition.SALMON_WRAPPED_PRAWN), false, false);
	public static final RegistryObject<Item> PRAWN_PO_BOY = registerFood("prawn_po_boy", Nutrition.PRAWN_PO_BOY);
	public static final RegistryObject<Item> PRAWN_STEW = registerFood("prawn_stew",
		bowlFoodItem(Nutrition.PRAWN_STEW), false, false);
	public static final RegistryObject<Item> PRAWN_CEVICHE = registerFood("prawn_ceviche",
		bowlFoodItem(Nutrition.PRAWN_CEVICHE), false, false);
	public static final RegistryObject<Item> PRAWN_NOODLES = registerFood("prawn_noodles",
		bowlFoodItem(Nutrition.PRAWN_NOODLES), false, false);

	// Urchin
	public static final RegistryObject<Item> URCHIN_SPAWN_EGG = registerItem("urchin_spawn_egg", () -> new ForgeSpawnEggItem(CREntities.URCHIN, 0x9990d7, 0x21132d, new Item.Properties()));
	public static final RegistryObject<Item> URCHIN_BUCKET = registerItem("urchin_bucket",
		() -> new MobBucketItem(CREntities.URCHIN, () -> Fluids.WATER, () -> SoundEvents.BUCKET_EMPTY_TADPOLE, (new Item.Properties()).stacksTo(1)));
	public static final RegistryObject<Item> URCHIN = registerItem("urchin",
		() -> new Item((new Item.Properties())));
	public static final RegistryObject<Item> URCHIN_TEST = registerItem("urchin_test",
		() -> new Item((new Item.Properties())));
	public static final RegistryObject<Item> URCHIN_NEEDLE = registerItem("urchin_needle",
		() -> new Item((new Item.Properties())));
	public static final RegistryObject<Item> URCHIN_DART = registerItem("urchin_dart",
		() -> new UrchinDartItem((new Item.Properties())));
	public static final RegistryObject<Item> UNI = registerFood("uni", Nutrition.UNI);
	public static final RegistryObject<Item> UNI_ROLL = registerFood("uni_roll", Nutrition.UNI_ROLL);

	// Platinum Bass
	public static final RegistryObject<Item> PLATINUM_BASS_SPAWN_EGG = registerItem("platinum_bass_spawn_egg", () -> new ForgeSpawnEggItem(CREntities.PLATINUM_BASS, 0x091442, 0x7B8698, new Item.Properties()));
	public static final RegistryObject<Item> PLATINUM_BASS_BUCKET = registerItem("platinum_bass_bucket",
		() -> new MobBucketItem(CREntities.PLATINUM_BASS, () -> Fluids.WATER, () -> SoundEvents.BUCKET_EMPTY_FISH, (new Item.Properties()).stacksTo(1)));
	public static final RegistryObject<Item> PLATINUM_BASS = registerFood("platinum_bass", Nutrition.PLATINUM_BASS);
	public static final RegistryObject<Item> COOKED_PLATINUM_BASS = registerFood("cooked_platinum_bass", Nutrition.COOKED_PLATINUM_BASS);
	public static final RegistryObject<Item> PLATINUM_BASS_HEAD = registerFood("platinum_bass_head", Nutrition.PLATINUM_BASS_HEAD);
	public static final RegistryObject<Item> COOKED_PLATINUM_BASS_HEAD = registerFood("cooked_platinum_bass_head", Nutrition.COOKED_PLATINUM_BASS_HEAD);
	public static final RegistryObject<Item> PLATINUM_BASS_SLICE = registerFood("platinum_bass_slice", Nutrition.PLATINUM_BASS_SLICE);
	public static final RegistryObject<Item> COOKED_PLATINUM_BASS_SLICE = registerFood("cooked_platinum_bass_slice", Nutrition.COOKED_PLATINUM_BASS_SLICE);
	public static final RegistryObject<Item> PLATINUM_BASS_STEW = registerFood("platinum_bass_stew",
		bowlFoodItem(Nutrition.PLATINUM_BASS_STEW), true, false);
	public static final RegistryObject<Item> FISH_MIX = registerFood("fish_mix",
		bowlFoodItem(Nutrition.FISH_MIX), false, false);

	// Chieftain Crab
	public static final RegistryObject<Item> CHIEFTAIN_CRAB_SPAWN_EGG = registerItem("chieftain_crab_spawn_egg", () -> new ForgeSpawnEggItem(CREntities.CHIEFTAIN_CRAB, 0xB13125, 0xE1B865, new Item.Properties()));
	public static final RegistryObject<Item> CHIEFTAIN_CRAB_BUCKET = registerItem("chieftain_crab_bucket",
		() -> new MobBucketItem(CREntities.CHIEFTAIN_CRAB, () -> Fluids.WATER, () -> SoundEvents.BUCKET_EMPTY_AXOLOTL, (new Item.Properties()).stacksTo(1).craftRemainder(Items.BUCKET)));
	public static final RegistryObject<Item> CHIEFTAIN_CRAB = registerItem("chieftain_crab", () -> new Item((new Item.Properties()).stacksTo(1).craftRemainder(Items.BOWL)));
	public static final RegistryObject<Item> CHIEFTAIN_CLAW = registerFood("chieftain_claw", Nutrition.CHIEFTAIN_CLAW);
	public static final RegistryObject<Item> CHIEFTAIN_LEG = registerFood("chieftain_leg", Nutrition.CHIEFTAIN_LEG);
	public static final RegistryObject<Item> CHIEFTAIN_CRAB_MEAT = registerFood("chieftain_crab_meat", Nutrition.CHIEFTAIN_CRAB_MEAT);
	public static final RegistryObject<Item> CRAB_MISO = registerFood("crab_miso",
		bowlFoodItem(Nutrition.CRAB_MISO), false, false);
	public static final RegistryObject<Item> CRAB_NOODLES = registerFood("crab_noodles",
		bowlFoodItem(Nutrition.CRAB_NOODLES), false, false);
	public static final RegistryObject<Item> CRAB_LASAGNA = registerFood("crab_lasagna",
		bowlFoodItem(Nutrition.CRAB_LASAGNA), false, false);
	public static final RegistryObject<Item> BUTTERED_LEGS = registerFood("buttered_legs",
		bowlFoodItem(Nutrition.BUTTERED_LEGS), false, false);
	public static final RegistryObject<Item> BIG_RICE_BALL = registerFood("big_rice_ball", Nutrition.BIG_RICE_BALL);
	public static final RegistryObject<Item> LAND_AND_SEA_BURGER = registerFood("land_and_sea_burger",
		new Item.Properties().food(Nutrition.LAND_AND_SEA_BURGER), true, false);

	// Clam
	public static final RegistryObject<Item> CLAM_SPAWN_EGG = registerItem("clam_spawn_egg", () -> new ForgeSpawnEggItem(CREntities.CLAM, 0x775745, 0xC5A877, new Item.Properties()));
	public static final RegistryObject<Item> CLAM_BUCKET = registerItem("clam_bucket",
		() -> new MobBucketItem(CREntities.CLAM, () -> Fluids.WATER, () -> SoundEvents.BUCKET_EMPTY_TADPOLE, (new Item.Properties()).stacksTo(1)));
	public static final RegistryObject<Item> CLAM = registerItem("clam",
		() -> new Item((new Item.Properties())));
	public static final RegistryObject<Item> CLAM_MEAT = registerFood("clam_meat", Nutrition.CLAM_MEAT);
	public static final RegistryObject<Item> CLAM_ROLL = registerFood("clam_roll", Nutrition.CLAM_ROLL);
	public static final RegistryObject<Item> CLAM_CHOWDER = registerFood("clam_chowder",
		bowlFoodItem(Nutrition.CLAM_CHOWDER), false, false);
	public static final RegistryObject<Item> CLAM_PASTA = registerFood("clam_pasta",
		bowlFoodItem(Nutrition.CLAM_PASTA), false, false);
	public static final RegistryObject<Item> CLAM_MEATBALL_STEW = registerFood("clam_meatball_stew",
		bowlFoodItem(Nutrition.CLAM_MEATBALL_STEW), false, false);
	public static final RegistryObject<Item> LUNAR_PEARL = registerItem("lunar_pearl",
		() -> new PearlItem((new Item.Properties())));
	public static final RegistryObject<Item> SHIMMERING_APPLE = registerItem("shimmering_apple",
		() -> new ShimmeringAppleItem((new Item.Properties().food(Nutrition.SHIMMERING_APPLE))));
	public static final RegistryObject<Item> SHIMMERING_PEARL = registerItem("shimmering_pearl",
		() -> new ShimmeringPearlItem((new Item.Properties()).stacksTo(16)));
	public static final RegistryObject<Item> PEARLY_CLAW = registerItem("pearly_claw",
		() -> new PearlyClawItem((new Item.Properties())));

	// Nether's Delight Compat
	public static final RegistryObject<Item> GLAZED_STRIDER = registerItem("glazed_strider",
		() -> new CompatConsumable(bowlFoodItem(Nutrition.GLAZED_STRIDER),
			true, false, "mynethersdelight", "nethersdelight"));
	public static final RegistryObject<Item> SPICY_GRENADINE_JELLY = registerItem("spicy_grenadine_jelly",
		() -> new CompatConsumable(bowlFoodItem(Nutrition.SPICY_GRENADINE_JELLY),
			true, false, "mynethersdelight", "nethersdelight"));

	// Neapolitan Compat
	public static final RegistryObject<Item> STRAWBERRY_JAM_BUN = registerItem("strawberry_jam_bun",
		() -> new CompatConsumable((new Item.Properties()).food(
			Nutrition.STRAWBERRY_JAM_BUN), true, false, 1.0F, "neapolitan"));
	public static final RegistryObject<Item> POMEGRANATE_BEAN_SALAD = registerItem("pomegranate_bean_salad",
		() -> new CompatConsumable(bowlFoodItem(Nutrition.POMEGRANATE_BEAN_SALAD),
			true, false, "neapolitan"));
	public static final RegistryObject<Item> CHOCOLATE_ARILS = registerItem("chocolate_arils",
		() -> new CompatConsumable((new Item.Properties()).food(
			Nutrition.CHOCOLATE_ARILS), true, false, "neapolitan"));
	public static final RegistryObject<Item> LIME_MILKSHAKE = registerItem("lime_milkshake",
		() -> new ShakeItem(new Item.Properties().food(Nutrition.LIME_MILKSHAKE)));
	public static final RegistryObject<Item> POMEGRANATE_MILKSHAKE = registerItem("pomegranate_milkshake",
		() -> new ShakeItem(new Item.Properties().food(Nutrition.POMEGRANATE_MILKSHAKE)));
	public static final RegistryObject<Item> LIME_ICE_CREAM = registerItem("lime_ice_cream",
		() -> new IceCreamItem((new Item.Properties()).food(Nutrition.LIME_ICE_CREAM)));
	public static final RegistryObject<Item> POMEGRANATE_ICE_CREAM = registerItem("pomegranate_ice_cream",
		() -> new IceCreamItem((new Item.Properties()).food(Nutrition.POMEGRANATE_ICE_CREAM)));
	public static final RegistryObject<Item> LIME_ICE_CREAM_BLOCK = registerItem("lime_ice_cream_block",
		() -> new BlockItem(CRBlocks.LIME_ICE_CREAM_BLOCK.get(), (new Item.Properties())));
	public static final RegistryObject<Item> POMEGRANATE_ICE_CREAM_BLOCK = registerItem("pomegranate_ice_cream_block",
		() -> new BlockItem(CRBlocks.POMEGRANATE_ICE_CREAM_BLOCK.get(), (new Item.Properties())));

	// Urchin Test
	public static final RegistryObject<Item> URCHIN_TEST_BLOCK = registerBlock("urchin_test_block", CRBlocks.URCHIN_TEST_BLOCK);
	public static final RegistryObject<Item> URCHIN_TEST_BRICKS = registerBlock("urchin_test_bricks", CRBlocks.URCHIN_TEST_BRICKS);
	public static final RegistryObject<Item> URCHIN_TEST_BRICK_SLAB = registerBlock("urchin_test_brick_slab", CRBlocks.URCHIN_TEST_BRICK_SLAB);
	public static final RegistryObject<Item> URCHIN_TEST_BRICK_STAIRS = registerBlock("urchin_test_brick_stairs", CRBlocks.URCHIN_TEST_BRICK_STAIRS);
	public static final RegistryObject<Item> URCHIN_TEST_BRICK_WALL = registerBlock("urchin_test_brick_wall", CRBlocks.URCHIN_TEST_BRICK_WALL);
	public static final RegistryObject<Item> CHISELED_URCHIN_TEST_BRICKS = registerBlock("chiseled_urchin_test_bricks", CRBlocks.CHISELED_URCHIN_TEST_BRICKS);
	public static final RegistryObject<Item> URCHIN_TEST_TILES = registerBlock("urchin_test_tiles", CRBlocks.URCHIN_TEST_TILES);
	public static final RegistryObject<Item> URCHIN_TEST_TILE_SLAB = registerBlock("urchin_test_tile_slab", CRBlocks.URCHIN_TEST_TILE_SLAB);
	public static final RegistryObject<Item> URCHIN_TEST_TILE_STAIRS = registerBlock("urchin_test_tile_stairs", CRBlocks.URCHIN_TEST_TILE_STAIRS);
	public static final RegistryObject<Item> URCHIN_TEST_TILE_WALL = registerBlock("urchin_test_tile_wall", CRBlocks.URCHIN_TEST_TILE_WALL);

	// Gummies
	public static final RegistryObject<Item> LIME_GUMMY = registerGummy("lime", Nutrition.LIME_GUMMY);
	public static final RegistryObject<Item> POMEGRANATE_GUMMY = registerGummy("pomegranate", Nutrition.POMEGRANATE_GUMMY);
	public static final RegistryObject<Item> APPLE_GUMMY = registerGummy("apple", Nutrition.APPLE_GUMMY);
	public static final RegistryObject<Item> GLOW_BERRY_GUMMY = registerGummy("glow_berry", Nutrition.GLOW_BERRY_GUMMY);
	public static final RegistryObject<Item> MELON_GUMMY = registerItem("melon_gummy",
		() -> new MelonGummyItem((new Item.Properties()).food(Nutrition.MELON_GUMMY)));
	public static final RegistryObject<Item> STRAWBERRY_GUMMY = registerItem("strawberry_gummy",
		() -> new StrawberryGummyItem((new Item.Properties()).food(Nutrition.STRAWBERRY_GUMMY)));
	public static final RegistryObject<Item> BANANA_GUMMY = registerGummy("banana", Nutrition.BANANA_GUMMY, "neapolitan");
	public static final RegistryObject<Item> VANILLA_GUMMY = registerGummy("vanilla", Nutrition.VANILLA_GUMMY, "neapolitan");
	public static final RegistryObject<Item> CHOCOLATE_GUMMY = registerGummy("chocolate", Nutrition.CHOCOLATE_GUMMY, "neapolitan");
	public static final RegistryObject<Item> MINT_GUMMY = registerGummy("mint", Nutrition.MINT_GUMMY, "neapolitan");
	public static final RegistryObject<Item> ADZUKI_GUMMY = registerGummy("adzuki", Nutrition.ADZUKI_GUMMY, "neapolitan");
	public static final RegistryObject<Item> PUMPKIN_GUMMY = registerGummy("pumpkin", Nutrition.PUMPKIN_GUMMY, "seasonals");
	public static final RegistryObject<Item> SWEET_BERRY_GUMMY = registerGummy("sweet_berry", Nutrition.SWEET_BERRY_GUMMY, "seasonals");
	public static final RegistryObject<Item> BEETROOT_GUMMY = registerGummy("beetroot", Nutrition.BEETROOT_GUMMY, "seasonals");
	public static final RegistryObject<Item> ALOE_GUMMY = registerGummy("aloe", Nutrition.ALOE_GUMMY, "atmospheric");
	public static final RegistryObject<Item> PASSION_FRUIT_GUMMY = registerGummy("passion_fruit", Nutrition.PASSION_FRUIT_GUMMY, "atmospheric");
	public static final RegistryObject<Item> YUCCA_GUMMY = registerGummy("yucca", Nutrition.YUCCA_GUMMY, "atmospheric");
	public static final RegistryObject<Item> GREEN_TEA_GUMMY = registerGummy("green_tea", Nutrition.GREEN_TEA_GUMMY, "farmersrespite");
	public static final RegistryObject<Item> YELLOW_TEA_GUMMY = registerGummy("yellow_tea", Nutrition.YELLOW_TEA_GUMMY, "farmersrespite");
	public static final RegistryObject<Item> BLACK_TEA_GUMMY = registerGummy("black_tea", Nutrition.BLACK_TEA_GUMMY, "farmersrespite");
	public static final RegistryObject<Item> COFFEE_GUMMY = registerGummy("coffee", Nutrition.COFFEE_GUMMY, "farmersrespite");

	// Let Fish Love
	public static final RegistryObject<Item> PLATINUM_BASS_ROE = registerItem("platinum_bass_roe", () ->
		ModList.get().isLoaded("letfishlove") ?
		LetFishLoveCompat.platinumBassRoeItem() :
		new CompatItem(new Item.Properties(), "letfishlove")
	);
	public static final RegistryObject<Item> TIGER_PRAWN_ROE = registerItem("tiger_prawn_roe", () ->
		ModList.get().isLoaded("letfishlove") ?
		LetFishLoveCompat.tigerPrawnRoeItem() :
		new CompatItem(new Item.Properties(), "letfishlove")
	);

	public static RegistryObject<Item> registerBlock(RegistryObject<Block> block) {
		return registerBlock(Util.name(block), block);
	}

	public static RegistryObject<Item> registerBlock(String name, RegistryObject<Block> block) {
		return registerItem(name, () -> new BlockItem(block.get(), (new Item.Properties())));
	}

	public static RegistryObject<Item> registerGummy(String name, FoodProperties properties) {
		return registerItem(name + "_gummy", () ->
			new GummyItem((new Item.Properties()).food(properties)));
	}

	public static RegistryObject<Item> registerGummy(String name, FoodProperties properties, String modid) {
		return registerItem(name + "_gummy", () ->
			new GummyItem((new Item.Properties()).food(properties), modid));
	}

	public static RegistryObject<Item> registerFood(String name, FoodProperties properties) {
		return registerItem(name, () -> new ConsumableItem((new Item.Properties()
			.food(properties))));
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
			properties,
			hasFoodEffectTooltip,
			hasCustomTooltip
		));
	}

	public static RegistryObject<Item> registerItem(String name, Supplier<Item> item) {
		return ITEMS.register(name, item);
	}

	public static void create(IEventBus bus) {
		ITEMS.register(bus);
	}
}
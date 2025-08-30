package net.brdle.collectorsreap.data.gen;

import net.brdle.collectorsreap.CollectorsReap;
import net.brdle.collectorsreap.Util;
import net.brdle.collectorsreap.common.item.CRItems;
import net.brdle.collectorsreap.data.CRItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import vectorwing.farmersdelight.common.registry.ModItems;
import vectorwing.farmersdelight.common.tag.ForgeTags;
import vectorwing.farmersdelight.common.tag.ModTags;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class CRItemTagProvider extends ItemTagsProvider {
	public CRItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> provider, CompletableFuture<TagLookup<Block>> blockTagProvider, @Nullable ExistingFileHelper existingFileHelper) {
		super(output, provider, blockTagProvider, CollectorsReap.MODID, existingFileHelper);
	}

	@Override
	public void addTags(HolderLookup.@NotNull Provider provider) {
		// Collector's Reap
		this.tag(CRItemTags.DART_SHOOTERS)
			.add(Items.BAMBOO)
			.addOptional(Util.rl("mynethersdelight", "powder_cannon"));
		this.tag(CRItemTags.GUMMIES)
			.add(CRItems.LIME_GUMMY.get())
			.add(CRItems.POMEGRANATE_GUMMY.get())
			.add(CRItems.PINK_DRAGON_FRUIT_GUMMY.get())
			.add(CRItems.MELON_GUMMY.get())
			.add(CRItems.APPLE_GUMMY.get())
			.add(CRItems.GLOW_BERRY_GUMMY.get())
			.add(CRItems.BANANA_GUMMY.get())
			.add(CRItems.VANILLA_GUMMY.get())
			.add(CRItems.CHOCOLATE_GUMMY.get())
			.add(CRItems.STRAWBERRY_GUMMY.get())
			.add(CRItems.MINT_GUMMY.get())
			.add(CRItems.ADZUKI_GUMMY.get())
			.add(CRItems.PUMPKIN_GUMMY.get())
			.add(CRItems.SWEET_BERRY_GUMMY.get())
			.add(CRItems.BEETROOT_GUMMY.get())
			.add(CRItems.ALOE_GUMMY.get())
			.add(CRItems.PASSION_FRUIT_GUMMY.get())
			.add(CRItems.YUCCA_GUMMY.get())
			.add(CRItems.GREEN_TEA_GUMMY.get())
			.add(CRItems.YELLOW_TEA_GUMMY.get())
			.add(CRItems.BLACK_TEA_GUMMY.get())
			.add(CRItems.COFFEE_GUMMY.get());
		this.tag(CRItemTags.CHIEFTAIN_CRAB_FOOD)
			.addTag(CRItemTags.CLAM)
			.addTag(CRItemTags.RAW_CLAM);

		// Minecraft
		this.tag(ItemTags.TRIM_MATERIALS).add(CRItems.LUNAR_PEARL.get());
		this.tag(ItemTags.WALLS)
			.add(CRItems.URCHIN_TEST_BRICK_WALL.get())
			.add(CRItems.URCHIN_TEST_TILE_WALL.get());
		this.tag(ItemTags.SLABS)
			.add(CRItems.URCHIN_TEST_BRICK_SLAB.get())
			.add(CRItems.URCHIN_TEST_TILE_SLAB.get());
		this.tag(ItemTags.STAIRS)
			.add(CRItems.URCHIN_TEST_BRICK_STAIRS.get())
			.add(CRItems.URCHIN_TEST_TILE_STAIRS.get());

		// Fish
		this.tag(ForgeTags.RAW_FISHES).addTag(CRItemTags.RAW_FISHES_BASS);
		this.tag(ForgeTags.COOKED_FISHES).addTag(CRItemTags.COOKED_FISHES_BASS);
		this.tag(ItemTags.FISHES)
			.addTag(CRItemTags.RAW_FISHES_BASS)
			.addTag(CRItemTags.COOKED_FISHES_BASS);
		this.tag(CRItemTags.ROE_FISH)
			.add(CRItems.PLATINUM_BASS_ROE.get())
			.addOptional(Util.rl("letfishlove", "tropical_fish_roe"))
			.addOptional(Util.rl("letfishlove", "salmon_roe"))
			.addOptional(Util.rl("letfishlove", "pufferfish_roe"))
			.addOptional(Util.rl("letfishlove", "cod_roe"))
			.addOptional(Util.rl("letmorefishlove", "lanternfish_roe"))
			.addOptional(Util.rl("letmorefishlove", "catfish_roe"))
			.addOptional(Util.rl("letmorefishlove", "bass_roe"))
			.addOptional(Util.rl("letmorefishlove", "pike_roe"))
			.addOptional(Util.rl("letmorefishlove", "lionfish_roe"))
			.addOptional(Util.rl("letmorefishlove", "perch_roe"));
		this.tag(CRItemTags.ROE_PRAWN)
			.add(CRItems.TIGER_PRAWN_ROE.get());
		this.tag(CRItemTags.ROE)
			.addTag(CRItemTags.ROE_FISH)
			.addTag(CRItemTags.ROE_PRAWN);

		// Farmer's Delight
		this.tag(ModTags.WILD_CROPS_ITEM)
			.add(CRItems.DRAGON_BUSH.get());
		this.tag(ItemTags.SMALL_FLOWERS)
			.add(CRItems.DRAGON_BUSH.get());
		this.tag(ModTags.CABBAGE_ROLL_INGREDIENTS)
			.addTag(CRItemTags.RAW_CRAB_MEAT)
			.addTag(CRItemTags.RAW_CLAM)
			.addTag(CRItemTags.RAW_PRAWN)
			.addTag(CRItemTags.RAW_URCHIN);

		// Forge
		this.tag(CRItemTags.STORAGE_BLOCKS_LIME).add(CRItems.LIME_CRATE.get());
		this.tag(CRItemTags.STORAGE_BLOCKS_POMEGRANATE).add(CRItems.POMEGRANATE_CRATE.get());
		this.tag(CRItemTags.STORAGE_BLOCKS_STYGIAN_POMEGRANATE).add(CRItems.STYGIAN_POMEGRANATE_CRATE.get());
		this.tag(CRItemTags.STORAGE_BLOCKS_PINK_DRAGON_FRUIT).add(CRItems.PINK_DRAGON_FRUIT_CRATE.get());
		this.tag(Tags.Items.STORAGE_BLOCKS)
			.addTag(CRItemTags.STORAGE_BLOCKS_LIME)
			.addTag(CRItemTags.STORAGE_BLOCKS_POMEGRANATE)
			.addTag(CRItemTags.STORAGE_BLOCKS_STYGIAN_POMEGRANATE)
			.addTag(CRItemTags.STORAGE_BLOCKS_PINK_DRAGON_FRUIT);
		this.tag(CRItemTags.CHEESE).addOptional(Util.rl("brewinandchewin", "flaxen_cheese_wedge"));
		this.tag(CRItemTags.forge("fruits/dragonfruit"))
			.add(CRItems.PINK_DRAGON_FRUIT.get())
			.addOptional(Util.rl("atmospheric", "dragon_fruit"))
			.addOptional(Util.rl("pamhc2trees", "dragonfruititem"));
		this.tag(CRItemTags.FRUITS_DRAGON_FRUIT).addTag(CRItemTags.forge("fruits/dragonfruit"));
		this.tag(CRItemTags.FRUITS_POMEGRANATE).add(CRItems.POMEGRANATE_SLICE.get());
		this.tag(CRItemTags.FRUITS_LIME)
			.add(CRItems.LIME.get())
			.add(CRItems.LIME_SLICE.get());
		this.tag(CRItemTags.FRUITS_CITRUS)
			.addTag(CRItemTags.FRUITS_LIME)
			.addOptionalTag(Util.rl("forge", "fruits/lemon"))
			.addOptional(Util.rl("fruitsdelight", "lemon_slice"));
		this.tag(CRItemTags.FRUITS)
			.addTag(CRItemTags.FRUITS_CITRUS)
			.addTag(CRItemTags.FRUITS_POMEGRANATE)
			.addTag(CRItemTags.FRUITS_DRAGON_FRUIT);
		this.tag(CRItemTags.SEEDS_LIME).add(CRItems.LIME_SEEDS.get());
		this.tag(CRItemTags.SEEDS_POMEGRANATE).add(CRItems.POMEGRANATE_SEEDS.get());
		this.tag(CRItemTags.SEEDS_DRAGON_FRUIT).add(CRItems.DRAGON_FRUIT_SEEDS.get());
		this.tag(Tags.Items.SEEDS)
			.addTag(CRItemTags.SEEDS_LIME)
			.addTag(CRItemTags.SEEDS_POMEGRANATE)
			.addTag(CRItemTags.SEEDS_DRAGON_FRUIT);
		this.tag(CRItemTags.MUSHROOMS_PORTOBELLO).add(CRItems.PORTOBELLO.get());
		this.tag(Tags.Items.MUSHROOMS).addTag(CRItemTags.MUSHROOMS_PORTOBELLO);
		this.tag(CRItemTags.TORTILLA).addOptional(Util.rl("culturaldelights", "tortilla"));
		this.tag(CRItemTags.RAW_CRAB_MEAT)
			.addOptional(Util.rl("quark", "crab_leg"));
		this.tag(CRItemTags.COOKED_CRAB_MEAT)
			.add(CRItems.CHIEFTAIN_CRAB_MEAT.get())
			.add(CRItems.CHIEFTAIN_LEG.get())
			.addOptional(Util.rl("crabbersdelight", "crab_legs"))
			.addOptional(Util.rl("ecologics", "crab_meat"))
			.addOptional(Util.rl("quark", "cooked_crab_leg"));
		this.tag(CRItemTags.CLAM)
			.add(CRItems.CLAM.get())
			.addOptional(Util.rl("crabbersdelight", "clam"));
		this.tag(CRItemTags.RAW_CLAM)
			.add(CRItems.CLAM_MEAT.get())
			.addOptional(Util.rl("crabbersdelight", "raw_clam_meat"));
		this.tag(CRItemTags.RAW_URCHIN).add(CRItems.UNI.get());
		this.tag(CRItemTags.RAW_PRAWN)
			.add(CRItems.TIGER_PRAWN.get());
		this.tag(CRItemTags.COOKED_PRAWN)
			.add(CRItems.COOKED_TIGER_PRAWN.get());
		this.tag(CRItemTags.RAW_FISHES_BASS)
			.add(CRItems.PLATINUM_BASS.get())
			.add(CRItems.PLATINUM_BASS_SLICE.get());
		this.tag(CRItemTags.COOKED_FISHES_BASS)
			.add(CRItems.COOKED_PLATINUM_BASS.get())
			.add(CRItems.COOKED_PLATINUM_BASS_SLICE.get());
		this.tag(CRItemTags.HOT_NETHER_FRUIT)
			.addOptionalTag(Util.rl("mynethersdelight", "bullet_pepper"))
			.addOptional(Util.rl("nethersdelight", "propelpearl"));
		this.tag(CRItemTags.RAW_HOGLIN)
			.addOptionalTag(Util.rl("forge", "hoglin_loin"))
			.addOptionalTag(Util.rl("mynethersdelight", "raw_hoglin"))
			.addOptional(Util.rl("nethersdelight", "hoglin_loin"));
		this.tag(CRItemTags.RAW_STRIDER)
			.addOptionalTag(Util.rl("mynethersdelight", "strider_meats"))
			.addOptional(Util.rl("nethersdelight", "raw_strider"));
		this.tag(CRItemTags.COOKIES)
			.add(Items.COOKIE)
			.add(ModItems.HONEY_COOKIE.get())
			.add(ModItems.SWEET_BERRY_COOKIE.get())
			.add(CRItems.LIME_COOKIE.get());
		this.tag(CRItemTags.SUPP_COOKIES)
			.addTag(CRItemTags.COOKIES);
		this.tag(Tags.Items.EGGS)
			.add(Items.TURTLE_EGG)
			.addOptional(Util.rl("sullysmod", "tortoise_egg"))
			.addOptional(Util.rl("naturalist", "tortoise_egg"))
			.addOptional(Util.rl("naturalist", "duck_egg"))
			.addOptional(Util.rl("autumnity", "turkey_egg"))
			.addOptional(Util.rl("deep_aether", "quail_egg"));
		this.tag(CRItemTags.JUICES_LIME)
			.add(CRItems.LIMEADE.get())
			.addOptionalTag(Util.rl("forge", "juices/lime_juice"));
		this.tag(CRItemTags.JUICES)
			.addTag(CRItemTags.JUICES_LIME)
			.add(ModItems.MELON_JUICE.get());

		// Neapolitan
		this.addSelf(CRItemTags.FRUITS_BANANA);
		this.addSelf(CRItemTags.DRIED_VANILLA_PODS);
		this.addSelf(CRItemTags.CHOCOLATE_BAR);
		this.addSelf(CRItemTags.MINT_LEAVES);
		this.addSelf(CRItemTags.ROASTED_ADZUKI_BEANS);
		this.tag(CRItemTags.FRUITS_STRAWBERRY).addOptional(Util.rl("neapolitan", "strawberries"));
		this.tag(CRItemTags.ICE_CREAM)
			.add(CRItems.LIME_ICE_CREAM.get())
			.add(CRItems.POMEGRANATE_ICE_CREAM.get())
			.add(CRItems.PINK_DRAGON_FRUIT_ICE_CREAM.get());

		// Brewin and Chewin
		this.tag(CRItemTags.FERMENTED_DRINKS)
			.add(CRItems.DEIFIC_BLOOD.get())
			.add(CRItems.HERMITS_SOUR.get())
			.add(CRItems.ROSE_MOON.get())
			.add(CRItems.REANIMATORS_GARDEN.get());

		// Diet
		this.tag(CRItemTags.DIET_FRUITS)
			.add(CRItems.LIME.get())
			.add(CRItems.POMEGRANATE.get())
			.add(CRItems.STYGIAN_POMEGRANATE.get());
		this.tag(CRItemTags.DIET_PROTEINS)
			.add(CRItems.PLATINUM_BASS_HEAD.get())
			.add(CRItems.TIGER_PRAWN.get())
			.add(CRItems.UNI.get())
			.add(CRItems.CLAM_MEAT.get())
			.add(CRItems.CHIEFTAIN_CLAW.get())
			.add(CRItems.CHIEFTAIN_LEG.get())
			.add(CRItems.CRAB_MISO.get());
		this.tag(CRItemTags.DIET_VEGETABLES)
			.add(CRItems.CRAB_MISO.get());
		this.tag(CRItemTags.SPECIAL_FOOD)
			.add(CRItems.PORTOBELLO_QUICHE.get())
			.add(CRItems.LIME_CAKE.get())
			.add(CRItems.LIME_PIE.get())
			.add(CRItems.POMEGRANATE_CAKE.get())
			.add(CRItems.PINK_DRAGON_FRUIT_CAKE.get());

		// Atmospheric
		this.addSelf(CRItemTags.ALOE_LEAVES);
		this.addSelf(CRItemTags.YUCCA_FRUIT);
		this.addSelf(CRItemTags.PASSION_FRUIT);
		this.tag(CRItemTags.COCHINEAL_FOOD).addTag(CRItemTags.FRUITS_DRAGON_FRUIT);

		// Autumnity
		this.tag(CRItemTags.SNAIL_SNACKS).add(CRItems.PORTOBELLO.get());

		// Seasonals
		this.addSelf(CRItemTags.PUMPKIN_PUREE);

		// Serene Seasons
		//this.tag(CRItemTags.WINTER_CROPS);
		this.tag(CRItemTags.SUMMER_CROPS)
			.add(CRItems.POMEGRANATE_SEEDS.get())
			.add(CRItems.DRAGON_FRUIT_SEEDS.get());
		this.tag(CRItemTags.AUTUMN_CROPS).add(CRItems.POMEGRANATE_SEEDS.get());
		this.tag(CRItemTags.SPRING_CROPS).add(CRItems.LIME_SEEDS.get());

		// Tea and Coffee
		this.tag(CRItemTags.TEA_LEAVES_GREEN).addOptional(Util.rl("farmersrespite", "green_tea_leaves"));
		this.tag(CRItemTags.TEA_LEAVES_YELLOW).addOptional(Util.rl("farmersrespite", "yellow_tea_leaves"));
		this.tag(CRItemTags.TEA_LEAVES_BLACK).addOptional(Util.rl("farmersrespite", "black_tea_leaves"));
		this.tag(CRItemTags.COFFEE_BEANS).addOptional(Util.rl("farmersrespite", "coffee_beans"));

		// SAS
		this.addSelf(CRItemTags.BURGER_BUN);

		// Supplementaries
		this.tag(CRItemTags.FLOWER_BOX_PLANTABLE)
			.add(CRItems.PORTOBELLO_COLONY.get())
			.addOptional(Util.rl("mynethersdelight", "warped_fungus_colony"))
			.addOptional(Util.rl("mynethersdelight", "crimson_fungus_colony"));

		// Let Fish Love
		this.tag(CRItemTags.FISH_FOOD_PLATINUM_BASS).add(CRItems.TIGER_PRAWN.get());
		this.tag(CRItemTags.FISH_FOOD_TIGER_PRAWN).add(Items.SEAGRASS);
	}

	@SuppressWarnings("UnusedReturnValue")
	private TagsProvider.TagAppender<Item> addSelf(TagKey<Item> item) {
		return this.tag(item).addOptional(item.location());
	}
}
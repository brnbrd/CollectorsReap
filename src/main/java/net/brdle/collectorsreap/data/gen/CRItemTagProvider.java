package net.brdle.collectorsreap.data.gen;

import com.teamabnormals.blueprint.core.other.tags.BlueprintItemTags;
import net.brdle.collectorsreap.CollectorsReap;
import net.brdle.collectorsreap.Util;
import net.brdle.collectorsreap.common.block.CRBlocks;
import net.brdle.collectorsreap.common.item.CRItems;
import net.brdle.collectorsreap.compat.Modid;
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
		this.tag(CRItemTags.LUCUMA_LOGS)
			.add(CRBlocks.LUCUMA_LOG.get().asItem())
			.add(CRBlocks.LUCUMA_WOOD.get().asItem())
			.add(CRBlocks.STRIPPED_LUCUMA_LOG.get().asItem())
			.add(CRBlocks.STRIPPED_LUCUMA_WOOD.get().asItem());
		this.tag(CRItemTags.DART_SHOOTERS)
			.add(Items.BAMBOO)
			.addOptional(Modid.MND.rl("powder_cannon"));
		this.tag(CRItemTags.MOB_FEEDABLE_GUMMIES)
			.add(CRItems.HEMP_GUMMY.get());
		this.tag(CRItemTags.GUMMIES)
			.addTag(CRItemTags.MOB_FEEDABLE_GUMMIES)
			.add(CRItems.LIME_GUMMY.get())
			.add(CRItems.POMEGRANATE_GUMMY.get())
			.add(CRItems.PINK_DRAGON_FRUIT_GUMMY.get())
			.add(CRItems.LUCUMA_GUMMY.get())
			.add(CRItems.MELON_GUMMY.get())
			.add(CRItems.APPLE_GUMMY.get())
			.add(CRItems.GLOW_BERRY_GUMMY.get())
			.add(CRItems.CARROT_GUMMY.get())
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
			.add(CRItems.WILD_BERRY_GUMMY.get())
			.add(CRItems.PASSION_FRUIT_GUMMY.get())
			.add(CRItems.YUCCA_GUMMY.get())
			.add(CRItems.GREEN_TEA_GUMMY.get())
			.add(CRItems.YELLOW_TEA_GUMMY.get())
			.add(CRItems.BLACK_TEA_GUMMY.get())
			.add(CRItems.COFFEE_GUMMY.get())
			.add(CRItems.BULLET_PEPPER_GUMMY.get())
			.add(CRItems.PRICKLY_PEAR_GUMMY.get())
			.add(CRItems.PEANUT_GUMMY.get())
			.add(CRItems.ASPARAGUS_ASPIC.get());
		this.tag(CRItemTags.CHIEFTAIN_CRAB_FOOD)
			.addTag(CRItemTags.CLAM)
			.addTag(CRItemTags.RAW_CLAM);

		// Minecraft
		this.tag(ItemTags.LOGS_THAT_BURN).addTag(CRItemTags.LUCUMA_LOGS);
		this.tag(ItemTags.PLANKS).add(CRBlocks.LUCUMA_PLANKS.get().asItem());
		this.tag(ItemTags.WOODEN_STAIRS).add(CRBlocks.LUCUMA_STAIRS.get().asItem());
		this.tag(ItemTags.WOODEN_SLABS).add(CRBlocks.LUCUMA_SLAB.get().asItem());
		this.tag(ItemTags.WOODEN_FENCES).add(CRBlocks.LUCUMA_FENCE.get().asItem());
		this.tag(ItemTags.FENCE_GATES).add(CRBlocks.LUCUMA_FENCE_GATE.get().asItem());
		this.tag(ItemTags.WOODEN_DOORS).add(CRBlocks.LUCUMA_DOOR.get().asItem());
		this.tag(ItemTags.WOODEN_TRAPDOORS).add(CRBlocks.LUCUMA_TRAPDOOR.get().asItem());
		this.tag(ItemTags.WOODEN_PRESSURE_PLATES).add(CRBlocks.LUCUMA_PRESSURE_PLATE.get().asItem());
		this.tag(ItemTags.WOODEN_BUTTONS).add(CRBlocks.LUCUMA_BUTTON.get().asItem());
		this.tag(ItemTags.SIGNS).add(CRBlocks.LUCUMA_SIGN.get().asItem());
		this.tag(ItemTags.HANGING_SIGNS).add(CRBlocks.LUCUMA_HANGING_SIGN.get().asItem());
		this.tag(ItemTags.BOATS).add(CRItems.LUCUMA_BOAT.get());
		this.tag(ItemTags.CHEST_BOATS).add(CRItems.LUCUMA_CHEST_BOAT.get());
		this.tag(ItemTags.SAPLINGS).add(CRBlocks.LUCUMA_SAPLING.get().asItem());
		this.tag(ItemTags.LEAVES).add(CRBlocks.LUCUMA_LEAVES.get().asItem());

		this.tag(ItemTags.TRIM_MATERIALS).add(CRItems.LUNAR_PEARL.get());
		this.tag(ItemTags.WALLS)
			.add(CRBlocks.URCHIN_TEST_BRICK_WALL.get().asItem())
			.add(CRBlocks.URCHIN_TEST_TILE_WALL.get().asItem());
		this.tag(ItemTags.SLABS)
			.add(CRBlocks.URCHIN_TEST_BRICK_SLAB.get().asItem())
			.add(CRBlocks.URCHIN_TEST_TILE_SLAB.get().asItem());
		this.tag(ItemTags.STAIRS)
			.add(CRBlocks.URCHIN_TEST_BRICK_STAIRS.get().asItem())
			.add(CRBlocks.URCHIN_TEST_TILE_STAIRS.get().asItem());
		this.tag(ItemTags.PIGLIN_LOVED).add(CRItems.GILDED_LUCUMA.get());

		// Fish
		this.tag(ItemTags.FISHES).add(CRItems.PLATINUM_BASS.get());
		this.tag(ForgeTags.RAW_FISHES).addTag(CRItemTags.RAW_FISHES_PLATINUM_BASS);
		this.tag(ForgeTags.COOKED_FISHES).addTag(CRItemTags.COOKED_FISHES_PLATINUM_BASS);
		this.tag(CRItemTags.FISH_ROE)
			.add(CRItems.PLATINUM_BASS_ROE.get())
			.addOptional(Modid.LFL.rl("tropical_fish_roe"))
			.addOptional(Modid.LFL.rl("salmon_roe"))
			.addOptional(Modid.LFL.rl("pufferfish_roe"))
			.addOptional(Modid.LFL.rl("cod_roe"))
			.addOptional(Modid.LMFL.rl("lanternfish_roe"))
			.addOptional(Modid.LMFL.rl("catfish_roe"))
			.addOptional(Modid.LMFL.rl("bass_roe"))
			.addOptional(Modid.LMFL.rl("pike_roe"))
			.addOptional(Modid.LMFL.rl("lionfish_roe"))
			.addOptional(Modid.LMFL.rl("perch_roe"));
		this.tag(CRItemTags.PRAWN_ROE)
			.add(CRItems.TIGER_PRAWN_ROE.get());
		this.tag(CRItemTags.ROE)
			.addTag(CRItemTags.FISH_ROE)
			.addTag(CRItemTags.PRAWN_ROE);

		// Blueprint
		this.tag(BlueprintItemTags.FURNACE_BOATS).add(CRItems.LUCUMA_FURNACE_BOAT.get());
		this.tag(BlueprintItemTags.LARGE_BOATS).add(CRItems.LARGE_LUCUMA_BOAT.get());
		this.tag(BlueprintItemTags.LEAF_PILES).add(CRBlocks.LUCUMA_LEAF_PILE.get().asItem());
		this.tag(BlueprintItemTags.WOODEN_BEEHIVES).add(CRBlocks.LUCUMA_BEEHIVE.get().asItem());
		this.tag(BlueprintItemTags.WOODEN_LADDERS).add(CRBlocks.LUCUMA_LADDER.get().asItem());
		this.tag(BlueprintItemTags.WOODEN_BOOKSHELVES).add(CRBlocks.LUCUMA_BOOKSHELF.get().asItem());
		this.tag(BlueprintItemTags.WOODEN_CHISELED_BOOKSHELVES).add(CRBlocks.CHISELED_LUCUMA_BOOKSHELF.get().asItem());
		this.tag(BlueprintItemTags.WOODEN_BOARDS).add(CRBlocks.LUCUMA_BOARDS.get().asItem());
		this.tag(BlueprintItemTags.WOODEN_CHESTS).add(CRBlocks.LUCUMA_CHEST.get().asItem());
		this.tag(BlueprintItemTags.WOODEN_TRAPPED_CHESTS).add(CRBlocks.TRAPPED_LUCUMA_CHEST.get().asItem());

		// Stardew Fishing
		this.tag(Modid.SF.it("starts_minigame"))
			.add(CRItems.TIGER_PRAWN.get());

		// Farmer's Delight
		this.tag(ModTags.WOODEN_CABINETS).add(CRBlocks.LUCUMA_CABINET.get().asItem());
		this.tag(ModTags.WILD_CROPS_ITEM)
			.add(CRBlocks.DRAGON_BUSH.get().asItem());
		this.tag(ItemTags.SMALL_FLOWERS)
			.add(CRBlocks.DRAGON_BUSH.get().asItem());
		this.tag(ModTags.CABBAGE_ROLL_INGREDIENTS)
			.addTag(CRItemTags.RAW_CRAB_MEAT)
			.addTag(CRItemTags.RAW_CLAM)
			.addTag(CRItemTags.RAW_PRAWN)
			.addTag(CRItemTags.RAW_URCHIN);
		this.tag(ModTags.DRINKS)
			.addTag(CRItemTags.JUICES)
			.addTag(CRItemTags.FERMENTED_DRINKS)
			.add(CRItems.DRAGONS_PASSION.get())
			.add(CRItems.BERRY_LIMEADE.get())
			.add(CRItems.PINK_LIMEADE.get())
			.add(CRItems.MINT_LIMEADE.get())
			.add(CRItems.LIME_GREEN_TEA.get())
			.add(CRItems.POMEGRANATE_BLACK_TEA.get())
			.add(CRItems.VERNAL_PURGE.get())
			.add(CRItems.STRONG_VERNAL_PURGE.get())
			.add(CRItems.LIMBO_BREW.get())
			.add(CRItems.LONG_LIMBO_BREW.get())
			.add(CRItems.STRONG_LIMBO_BREW.get())
			.add(CRItems.SWEET_RECOVERY.get())
			.add(CRItems.LONG_SWEET_RECOVERY.get())
			.add(CRItems.STRONG_SWEET_RECOVERY.get())
			.add(CRItems.POMEGRANATE_SMOOTHIE.get());

		// Brewin and Chewin
		this.tag(CRItemTags.FERMENTED_DRINKS)
			.add(CRItems.DEIFIC_BLOOD.get())
			.add(CRItems.HERMITS_SOUR.get())
			.add(CRItems.ROSE_MOON.get())
			.add(CRItems.REANIMATORS_GARDEN.get())
			.add(CRItems.HEAVENS_CREAM.get());

		// Neapolitan
		this.addSelf(CRItemTags.DRIED_VANILLA_PODS);
		this.addSelf(CRItemTags.CHOCOLATE_BAR);
		this.addSelf(CRItemTags.MINT_LEAVES);
		this.addSelf(CRItemTags.ROASTED_ADZUKI_BEANS);
		this.tag(CRItemTags.ICE_CREAM)
			.add(CRItems.LIME_ICE_CREAM.get())
			.add(CRItems.POMEGRANATE_ICE_CREAM.get())
			.add(CRItems.PINK_DRAGON_FRUIT_ICE_CREAM.get())
			.add(CRItems.LUCUMA_ICE_CREAM.get())
			.add(CRItems.SUNNY_ICE_CREAM.get());

		// Forge
		this.tag(Tags.Items.FENCE_GATES_WOODEN).add(CRBlocks.LUCUMA_FENCE_GATE.get().asItem());
		this.tag(CRItemTags.STORAGE_BLOCKS_LIME).add(CRBlocks.LIME_CRATE.get().asItem());
		this.tag(CRItemTags.STORAGE_BLOCKS_POMEGRANATE).add(CRBlocks.POMEGRANATE_CRATE.get().asItem());
		this.tag(CRItemTags.STORAGE_BLOCKS_STYGIAN_POMEGRANATE).add(CRBlocks.STYGIAN_POMEGRANATE_CRATE.get().asItem());
		this.tag(CRItemTags.STORAGE_BLOCKS_PINK_DRAGON_FRUIT).add(CRBlocks.PINK_DRAGON_FRUIT_CRATE.get().asItem());
		this.tag(CRItemTags.STORAGE_BLOCKS_LUCUMA).add(CRBlocks.LUCUMA_CRATE.get().asItem());
		this.tag(CRItemTags.STORAGE_BLOCKS_GILDED_LUCUMA).add(CRBlocks.GILDED_LUCUMA_CRATE.get().asItem());
		this.tag(Tags.Items.STORAGE_BLOCKS)
			.addTag(CRItemTags.STORAGE_BLOCKS_LIME)
			.addTag(CRItemTags.STORAGE_BLOCKS_POMEGRANATE)
			.addTag(CRItemTags.STORAGE_BLOCKS_STYGIAN_POMEGRANATE)
			.addTag(CRItemTags.STORAGE_BLOCKS_PINK_DRAGON_FRUIT)
			.addTag(CRItemTags.STORAGE_BLOCKS_LUCUMA)
			.addTag(CRItemTags.STORAGE_BLOCKS_GILDED_LUCUMA);
		this.tag(CRItemTags.CHEESE_MILD_CREAM).add(CRItems.CREAM_CHEESE.get());
		this.tag(CRItemTags.CHEESE_MILD)
			.addTag(CRItemTags.CHEESE_MILD_CREAM)
			.addOptional(Modid.BC.rl("flaxen_cheese_wedge"));
		this.tag(CRItemTags.CHEESE_SPICY).addOptional(Modid.BC.rl("scarlet_cheese_wedge"));
		this.tag(CRItemTags.CHEESE_SWEET).addOptional(Modid.SOB.rl("eumozz_cheese_wedge"));
		this.tag(CRItemTags.CHEESE)
			.addTag(CRItemTags.CHEESE_MILD)
			.addTag(CRItemTags.CHEESE_SPICY)
			.addTag(CRItemTags.CHEESE_SWEET)
			.addOptionalTag(Modid.BC.rl("cheese_wedges"));
		this.tag(CRItemTags.forge("fruits/dragonfruit"))
			.add(CRItems.PINK_DRAGON_FRUIT.get())
			.addOptional(Modid.AT.rl("dragon_fruit"))
			.addOptional(Util.rl("pamhc2trees", "dragonfruititem"));
		this.tag(CRItemTags.FRUITS_DRAGON_FRUIT).addTag(CRItemTags.forge("fruits/dragonfruit"));
		this.tag(CRItemTags.forge("fruits/prickly_pear"))
			.addOptional(Modid.SOB.rl("prickly_pear"))
			.addOptional(Modid.ECO.rl("prickly_pear"));
		this.tag(CRItemTags.FRUITS_LUCUMA).add(CRItems.LUCUMA.get());
		this.tag(CRItemTags.FRUITS_POMEGRANATE).add(CRItems.POMEGRANATE_SLICE.get());
		this.tag(CRItemTags.FRUITS_LIME).add(CRItems.LIME.get());
		this.tag(CRItemTags.FRUITS_CITRUS)
			.addTag(CRItemTags.FRUITS_LIME)
			.addOptionalTag(Modid.LOADER.rl("fruits/lemon"));
		this.tag(CRItemTags.FRUITS)
			.addTag(CRItemTags.FRUITS_CITRUS)
			.addTag(CRItemTags.FRUITS_POMEGRANATE)
			.addTag(CRItemTags.FRUITS_LUCUMA)
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
		this.tag(CRItemTags.TORTILLA).addOptional(Modid.CD.rl("tortilla"));
		this.tag(CRItemTags.RAW_CRAB_MEAT)
			.addOptional(Modid.Q.rl("crab_leg"));
		this.tag(CRItemTags.COOKED_CRAB_MEAT)
			.add(CRItems.CHIEFTAIN_CRAB_MEAT.get())
			.add(CRItems.CHIEFTAIN_LEG.get())
			.addOptional(Modid.CRAB.rl("crab_legs"))
			.addOptional(Modid.ECO.rl("crab_meat"))
			.addOptional(Modid.Q.rl("cooked_crab_leg"));
		this.tag(CRItemTags.CLAM)
			.add(CRItems.CLAM.get())
			.addOptional(Modid.CRAB.rl("clam"));
		this.tag(CRItemTags.RAW_CLAM)
			.add(CRItems.CLAM_MEAT.get())
			.addOptional(Modid.CRAB.rl("raw_clam_meat"));
		this.tag(CRItemTags.RAW_URCHIN).add(CRItems.UNI.get());
		this.tag(CRItemTags.RAW_PRAWN)
			.add(CRItems.TIGER_PRAWN.get());
		this.tag(CRItemTags.COOKED_PRAWN)
			.add(CRItems.COOKED_TIGER_PRAWN.get());
		this.tag(CRItemTags.RAW_FISHES_PLATINUM_BASS)
			.add(CRItems.PLATINUM_BASS.get())
			.add(CRItems.PLATINUM_BASS_SLICE.get());
		this.tag(CRItemTags.COOKED_FISHES_PLATINUM_BASS)
			.add(CRItems.COOKED_PLATINUM_BASS.get())
			.add(CRItems.COOKED_PLATINUM_BASS_SLICE.get());
		this.tag(CRItemTags.HOT_NETHER_FRUITS)
			.addOptionalTag(Modid.MND.rl("bullet_pepper"))
			.addOptional(Modid.ND.rl("propelpearl"));
		this.tag(CRItemTags.RAW_HOGLIN)
			.addOptionalTag(Modid.LOADER.rl("hoglin_loin"))
			.addOptionalTag(Modid.MND.rl("raw_hoglin"))
			.addOptional(Modid.ND.rl("hoglin_loin"));
		this.tag(CRItemTags.RAW_STRIDER)
			.addOptionalTag(Modid.MND.rl("strider_meats"))
			.addOptional(Modid.ND.rl("raw_strider"));
		this.tag(CRItemTags.COOKIES)
			.add(Items.COOKIE)
			.add(ModItems.HONEY_COOKIE.get())
			.add(ModItems.SWEET_BERRY_COOKIE.get())
			.add(CRItems.LIME_COOKIE.get());
		this.tag(CRItemTags.SUPP_COOKIES)
			.addTag(CRItemTags.COOKIES);
		this.tag(Tags.Items.EGGS)
			.add(Items.TURTLE_EGG)
			.addOptional(Modid.SM.rl("tortoise_egg"))
			.addOptional(Modid.NA.rl("tortoise_egg"))
			.addOptional(Modid.NA.rl("duck_egg"))
			.addOptional(Modid.AUT.rl("turkey_egg"))
			.addOptional(Modid.DA.rl("quail_egg"));
		this.tag(CRItemTags.JUICES_LIME)
			.add(CRItems.LIMEADE.get())
			.add(CRItems.STRONG_LIMEADE.get())
			.addOptionalTag(Modid.LOADER.rl("juices/lime_juice"));
		this.tag(CRItemTags.JUICES)
			.addTag(CRItemTags.JUICES_LIME)
			.add(ModItems.MELON_JUICE.get());
		this.tag(CRItemTags.CONDENSED_MILK).addOptional(Modid.COS.rl("condensed_milk_bottle"));
		this.tag(CRItemTags.forge("nuts/peanut")).addOptional(Modid.SOB.rl("peanut"));
		this.tag(CRItemTags.forge("vegetables/asparagus")).addOptional(Modid.SOB.rl("asparagus"));
		this.tag(CRItemTags.forge("vegetables/ginger")).addOptional(Modid.WS.rl("ginger_root"));
		this.tag(CRItemTags.forge("fruits/wild_berries")).addOptional(Modid.WS.rl("wild_berries"));

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
			.add(CRItems.LIME_PIE.get())
			.add(CRItems.LIME_CAKE.get())
			.add(CRItems.POMEGRANATE_CAKE.get())
			.add(CRItems.PINK_DRAGON_FRUIT_CAKE.get())
			.add(CRItems.LUCUMA_CAKE.get());

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
		this.tag(CRItemTags.TEA_LEAVES_GREEN).addOptional(Modid.FR.rl("green_tea_leaves"));
		this.tag(CRItemTags.TEA_LEAVES_YELLOW).addOptional(Modid.FR.rl("yellow_tea_leaves"));
		this.tag(CRItemTags.TEA_LEAVES_BLACK).addOptional(Modid.FR.rl("black_tea_leaves"));
		this.tag(CRItemTags.COFFEE_BEANS).addOptional(Modid.FR.rl("coffee_beans"));

		// Supplementaries
		this.tag(CRItemTags.FLOWER_BOX_PLANTABLE)
			.add(CRItems.PORTOBELLO_COLONY.get())
			.addOptional(Modid.MND.rl("warped_fungus_colony"))
			.addOptional(Modid.MND.rl("crimson_fungus_colony"));

		// Let Fish Love
		this.tag(CRItemTags.FISH_FOOD_PLATINUM_BASS).add(CRItems.TIGER_PRAWN.get());
		this.tag(CRItemTags.FISH_FOOD_TIGER_PRAWN).add(Items.SEAGRASS);

		// Nirvana
		this.tag(Modid.NIRV.it("nauseating")).add(CRItems.HEMP_GUMMY.get());

		// SAS
		this.addSelf(CRItemTags.BURGER_BUN);
	}

	@SuppressWarnings("UnusedReturnValue")
	private TagsProvider.TagAppender<Item> addSelf(TagKey<Item> item) {
		return this.tag(item).addOptional(item.location());
	}
}
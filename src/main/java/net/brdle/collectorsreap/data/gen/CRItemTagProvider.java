package net.brdle.collectorsreap.data.gen;

import net.brdle.collectorsreap.CollectorsReap;
import net.brdle.collectorsreap.Util;
import net.brdle.collectorsreap.common.item.CRItems;
import net.brdle.collectorsreap.data.CRItemTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import umpaz.farmersrespite.common.registry.FRItems;

public class CRItemTagProvider extends ItemTagsProvider {
	public CRItemTagProvider(DataGenerator gen, BlockTagsProvider blockTagProvider, ExistingFileHelper existingFileHelper) {
		super(gen, blockTagProvider, CollectorsReap.MODID, existingFileHelper);
	}

	@Override
	protected void addTags() {
		// Minecraft
		this.tag(ItemTags.WALLS)
			.add(CRItems.URCHIN_TEST_BRICK_WALL.get())
			.add(CRItems.URCHIN_TEST_TILE_WALL.get());
		this.tag(ItemTags.SLABS)
			.add(CRItems.URCHIN_TEST_BRICK_SLAB.get())
			.add(CRItems.URCHIN_TEST_TILE_SLAB.get());
		this.tag(ItemTags.STAIRS)
			.add(CRItems.URCHIN_TEST_BRICK_STAIRS.get())
			.add(CRItems.URCHIN_TEST_TILE_STAIRS.get());
		
		this.tag(CRItemTags.FRUITS_POMEGRANATE)
			.add(CRItems.POMEGRANATE_SLICE.get());
		this.tag(CRItemTags.FRUITS_LIME)
			.add(CRItems.LIME.get());
		this.tag(CRItemTags.LIME_OR_SLICE)
			.addTag(CRItemTags.FRUITS_LIME)
			.add(CRItems.LIME_SLICE.get());
		this.tag(CRItemTags.FRUITS_CITRUS)
			.addTag(CRItemTags.FRUITS_LIME)
			.addOptionalTag(Util.rl("forge", "fruits/lemon"));
		this.tag(CRItemTags.FRUITS)
			.addTag(CRItemTags.FRUITS_POMEGRANATE)
			.addTag(CRItemTags.FRUITS_LIME);
		this.tag(CRItemTags.SEEDS_LIME)
			.add(CRItems.LIME_SEEDS.get());
		this.tag(CRItemTags.SEEDS_POMEGRANATE)
			.add(CRItems.POMEGRANATE_SEEDS.get());
		this.tag(Tags.Items.SEEDS)
			.addTag(CRItemTags.SEEDS_LIME)
			.addTag(CRItemTags.SEEDS_POMEGRANATE);
		this.tag(CRItemTags.MUSHROOMS_PORTOBELLO)
			.add(CRItems.PORTOBELLO.get());
		this.tag(Tags.Items.MUSHROOMS)
			.addTag(CRItemTags.MUSHROOMS_PORTOBELLO);
		this.tag(CRItemTags.TORTILLA)
			.addOptional(Util.rl("culturaldelights", "tortilla"));
		this.tag(CRItemTags.ICE_CREAM)
			.add(CRItems.LIME_ICE_CREAM.get())
			.add(CRItems.POMEGRANATE_ICE_CREAM.get());
		this.tag(CRItemTags.GUMMIES)
			.add(CRItems.LIME_GUMMY.get())
			.add(CRItems.POMEGRANATE_GUMMY.get())
			.add(CRItems.MELON_GUMMY.get())
			.add(CRItems.APPLE_GUMMY.get())
			.add(CRItems.BANANA_GUMMY.get())
			.add(CRItems.VANILLA_GUMMY.get())
			.add(CRItems.CHOCOLATE_GUMMY.get())
			.add(CRItems.STRAWBERRY_GUMMY.get())
			.add(CRItems.MINT_GUMMY.get())
			.add(CRItems.ADZUKI_GUMMY.get())
			.add(CRItems.PUMPKIN_GUMMY.get())
			.add(CRItems.ALOE_GUMMY.get())
			.add(CRItems.PASSIONFRUIT_GUMMY.get())
			.add(CRItems.YUCCA_GUMMY.get());
		this.tag(CRItemTags.CRAB_MEAT)
			.addOptionalTag(Util.rl("forge", "cooked_crab"))
			.add(CRItems.CHIEFTAIN_LEG.get())
			.add(CRItems.CHIEFTAIN_CRAB_MEAT.get())
			.addOptional(Util.rl("crabbersdelight", "crab_legs"));
		this.tag(CRItemTags.RAW_CLAM)
			.add(CRItems.CLAM_MEAT.get())
			.addOptional(Util.rl("crabbersdelight", "raw_clam_meat"));
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

		// Nether's Delight
		this.addSelf(CRItemTags.PROPELPEARL);
		this.addSelf(CRItemTags.HOGLIN_LOIN);

		// Neapolitan
		this.addSelf(CRItemTags.BANANA);
		this.addSelf(CRItemTags.DRIED_VANILLA_PODS);
		this.addSelf(CRItemTags.CHOCOLATE_BAR);
		this.addSelf(CRItemTags.MINT_LEAVES);
		this.addSelf(CRItemTags.ROASTED_ADZUKI_BEANS);
		this.tag(CRItemTags.RED_STRAWBERRIES).addOptional(Util.rl("neapolitan", "strawberries"));

		// Atmospheric
		this.addSelf(CRItemTags.ALOE_LEAVES);
		this.addSelf(CRItemTags.YUCCA_FRUIT);
		this.addSelf(CRItemTags.PASSIONFRUIT);

		// Seasonals
		this.addSelf(CRItemTags.ROASTED_PUMPKIN);

		// Serene Seasons
		this.tag(CRItemTags.WINTER_CROPS)
			.add(CRItems.PORTOBELLO.get())
			.add(CRItems.PORTOBELLO_COLONY.get());
		this.tag(CRItemTags.SUMMER_CROPS)
			.add(CRItems.POMEGRANATE_SEEDS.get());
		this.tag(CRItemTags.AUTUMN_CROPS)
			.add(CRItems.POMEGRANATE_SEEDS.get());
		this.tag(CRItemTags.SPRING_CROPS)
			.add(CRItems.LIME_SEEDS.get());

		// Tea and Coffee
		this.tag(CRItemTags.TEA_LEAVES_GREEN)
			.addOptional(FRItems.GREEN_TEA_LEAVES.getId());
		this.tag(CRItemTags.TEA_LEAVES_YELLOW)
			.addOptional(FRItems.YELLOW_TEA_LEAVES.getId());
		this.tag(CRItemTags.TEA_LEAVES_BLACK)
			.addOptional(FRItems.BLACK_TEA_LEAVES.getId());
		this.tag(CRItemTags.COFFEE_BEANS)
			.addOptional(FRItems.COFFEE_BEANS.getId());

		// SAS
		this.addSelf(CRItemTags.BURGER_BUN);
	}

	/**
	 * Gets a name for this provider, to use in logging.
	 */
	@Override
	public @NotNull String getName() {
		return CollectorsReap.MODID;
	}

	private TagsProvider.TagAppender<Item> addSelf(TagKey<Item> item) {
		return this.tag(item).addOptional(item.location());
	}
}

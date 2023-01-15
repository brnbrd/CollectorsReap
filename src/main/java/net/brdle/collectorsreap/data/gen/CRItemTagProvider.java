package net.brdle.collectorsreap.data.gen;

import net.brdle.collectorsreap.CollectorsReap;
import net.brdle.collectorsreap.common.item.CRItems;
import net.brdle.collectorsreap.data.CRItemTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

public class CRItemTagProvider extends ItemTagsProvider {
	public CRItemTagProvider(DataGenerator gen, BlockTagsProvider blockTagProvider, ExistingFileHelper existingFileHelper) {
		super(gen, blockTagProvider, CollectorsReap.MODID, existingFileHelper);
	}

	@Override
	protected void addTags() {
		this.tag(CRItemTags.FRUITS_POMEGRANATE)
			.add(CRItems.POMEGRANATE.get());
		this.tag(CRItemTags.FRUITS_LIME)
			.add(CRItems.LIME.get());
		this.tag(CRItemTags.LIME_OR_SLICE)
			.addTag(CRItemTags.FRUITS_LIME)
			.add(CRItems.LIME_SLICE.get());
		this.tag(CRItemTags.FRUITS_CITRUS)
			.addTag(CRItemTags.FRUITS_LIME);
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

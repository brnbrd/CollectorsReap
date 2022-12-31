package net.brdle.veggiedelight.data.gen;

import net.brdle.veggiedelight.VeggieDelight;
import net.brdle.veggiedelight.common.item.VDItems;
import net.brdle.veggiedelight.data.VDItemTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

public class VDItemTagProvider extends ItemTagsProvider {
	public VDItemTagProvider(DataGenerator gen, BlockTagsProvider blockTagProvider, ExistingFileHelper existingFileHelper) {
		super(gen, blockTagProvider, VeggieDelight.MODID, existingFileHelper);
	}

	@Override
	protected void addTags() {
		this.tag(VDItemTags.FRUITS_POMEGRANATE)
			.add(VDItems.POMEGRANATE.get());
		this.tag(VDItemTags.FRUITS_LEMON)
			.add(VDItems.LEMON.get());
		this.tag(VDItemTags.FRUITS_CITRUS)
			.addTag(VDItemTags.FRUITS_LEMON);
		this.tag(VDItemTags.FRUITS)
			.addTag(VDItemTags.FRUITS_POMEGRANATE)
			.addTag(VDItemTags.FRUITS_LEMON);
		this.tag(VDItemTags.MUSHROOMS_PORTOBELLO)
			.add(VDItems.PORTOBELLO.get());
		this.tag(Tags.Items.MUSHROOMS)
			.addTag(VDItemTags.MUSHROOMS_PORTOBELLO);
	}

	/**
	 * Gets a name for this provider, to use in logging.
	 */
	@Override
	public @NotNull String getName() {
		return VeggieDelight.MODID;
	}

	private TagsProvider.TagAppender<Item> addSelf(TagKey<Item> item) {
		return this.tag(item).addOptional(item.location());
	}
}

package net.brdle.collectorsreap.data.gen;

import net.brdle.collectorsreap.CollectorsReap;
import net.brdle.collectorsreap.common.block.CRBlocks;
import net.brdle.collectorsreap.data.CRBlockTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vectorwing.farmersdelight.common.tag.ModTags;

public class CRBlockTagProvider extends BlockTagsProvider {

	protected CRBlockTagProvider(DataGenerator pGenerator, @Nullable ExistingFileHelper existingFileHelper) {
		super(pGenerator, CollectorsReap.MODID, existingFileHelper);
	}

	@Override
	protected void addTags() {
		// Farmer's Delight
		this.tag(ModTags.MINEABLE_WITH_KNIFE)
			.add(CRBlocks.PORTOBELLO_QUICHE.get())
			.add(CRBlocks.LIME_PIE.get());

		// VD
		this.tag(CRBlockTags.PORTOBELLO_SPAWNS)
			.addTag(ModTags.MUSHROOM_COLONY_GROWABLE_ON)
			.add(Blocks.GRASS_BLOCK)
			.add(Blocks.DIRT)
			.add(Blocks.ROOTED_DIRT)
			.add(Blocks.MYCELIUM);

		// Minecraft
		this.tag(BlockTags.BEE_GROWABLES)
			.add(CRBlocks.LIME_BUSH.get());
		this.tag(BlockTags.FLOWERS)
			.add(CRBlocks.LIME_BUSH.get());
	}

	/**
	 * Gets a name for this provider, to use in logging.
	 */
	@Override
	public @NotNull String getName() {
		return CollectorsReap.MODID;
	}
}

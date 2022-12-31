package net.brdle.veggiedelight.data.gen;

import net.brdle.veggiedelight.VeggieDelight;
import net.brdle.veggiedelight.data.VDBlockTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vectorwing.farmersdelight.common.tag.ModTags;

public class VDBlockTagProvider extends BlockTagsProvider {

	protected VDBlockTagProvider(DataGenerator pGenerator, @Nullable ExistingFileHelper existingFileHelper) {
		super(pGenerator, VeggieDelight.MODID, existingFileHelper);
	}

	@Override
	protected void addTags() {
		// Farmer's Delight
		//this.tag(ModTags.MINEABLE_WITH_KNIFE)
		//	.add(VDBlocks.QUICHE.get());

		this.tag(VDBlockTags.PORTOBELLO_SPAWNS)
			.addTag(ModTags.MUSHROOM_COLONY_GROWABLE_ON)
			.add(Blocks.GRASS_BLOCK)
			.add(Blocks.DIRT)
			.add(Blocks.ROOTED_DIRT)
			.add(Blocks.MYCELIUM);
	}

	/**
	 * Gets a name for this provider, to use in logging.
	 */
	@Override
	public @NotNull String getName() {
		return VeggieDelight.MODID;
	}
}

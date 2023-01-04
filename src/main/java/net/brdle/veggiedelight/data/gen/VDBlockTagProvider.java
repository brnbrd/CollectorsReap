package net.brdle.veggiedelight.data.gen;

import net.brdle.veggiedelight.VeggieDelight;
import net.brdle.veggiedelight.common.block.VDBlocks;
import net.brdle.veggiedelight.data.VDBlockTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
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
		this.tag(ModTags.MINEABLE_WITH_KNIFE)
			.add(VDBlocks.PORTOBELLO_QUICHE.get())
			.add(VDBlocks.LEMON_PIE.get());

		// VD
		this.tag(VDBlockTags.PORTOBELLO_SPAWNS)
			.addTag(ModTags.MUSHROOM_COLONY_GROWABLE_ON)
			.add(Blocks.GRASS_BLOCK)
			.add(Blocks.DIRT)
			.add(Blocks.ROOTED_DIRT)
			.add(Blocks.MYCELIUM);

		// Minecraft
		this.tag(BlockTags.BEE_GROWABLES)
			.add(VDBlocks.LEMON_BUSH.get());
		this.tag(BlockTags.FLOWERS)
			.add(VDBlocks.LEMON_BUSH.get());
	}

	/**
	 * Gets a name for this provider, to use in logging.
	 */
	@Override
	public @NotNull String getName() {
		return VeggieDelight.MODID;
	}
}

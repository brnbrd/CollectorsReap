package net.brdle.veggiedelight.common.world;

import com.mojang.serialization.Codec;
import net.brdle.veggiedelight.common.block.LemonBushBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;

public class BushBlockFeature extends Feature<SimpleBlockConfiguration> {
	public BushBlockFeature(Codec<SimpleBlockConfiguration> c) {
		super(c);
	}

	/**
	 * Places the given feature at the given location.
	 * During world generation, features are provided with a 3x3 region of chunks, centered on the chunk being generated,
	 * that they can safely generate into.
	 * @param pContext A context object with a reference to the level and the position the feature is being placed at
	 */
	public boolean place(FeaturePlaceContext<SimpleBlockConfiguration> pContext) {
		WorldGenLevel worldgenlevel = pContext.level();
		BlockPos blockpos = pContext.origin();
		BlockState blockstate = pContext.config().toPlace().getState(pContext.random(), blockpos);
		if (blockstate.getBlock() instanceof LemonBushBlock &&
			blockstate.canSurvive(worldgenlevel, blockpos) &&
			worldgenlevel.isEmptyBlock(blockpos.above())) {
				LemonBushBlock.placeAt(worldgenlevel, blockstate, blockpos, 2);
				return true;
		} else {
			return false;
		}
	}
}
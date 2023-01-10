package net.brdle.collectorsreap.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import vectorwing.farmersdelight.common.tag.ModTags;

public class PortobelloBlock extends BushBlock {
	protected static final float AABB_OFFSET = 3.0F;
	protected static final VoxelShape SHAPE = Block.box(4.0D, 0.0D, 4.0D, 12.0D, 7.0D, 12.0D);

	public PortobelloBlock(Properties pProperties) {
		super(pProperties);
	}

	@SuppressWarnings("deprecation")
	@Override
	public @NotNull VoxelShape getShape(@NotNull BlockState pState, @NotNull BlockGetter pLevel, @NotNull BlockPos pPos, @NotNull CollisionContext pContext) {
		return SHAPE;
	}

	@Override
	public float getMaxHorizontalOffset() {
		return AABB_OFFSET;
	}

	@Override
	protected boolean mayPlaceOn(BlockState pState, @NotNull BlockGetter pLevel, @NotNull BlockPos pPos) {
		return pState.isSolidRender(pLevel, pPos);
	}

	@Override
	public boolean canSurvive(@NotNull BlockState pState, LevelReader level, BlockPos pos) {
		BlockPos below = pos.below();
		BlockState blockstate = level.getBlockState(below);
		return blockstate.is(BlockTags.MUSHROOM_GROW_BLOCK) ||
			(level.getRawBrightness(pos, 0) < 13 && blockstate.canSustainPlant(level, below, Direction.UP, this));
	}

	// Grow into colony on Rich Soil
	@Override
	public void randomTick(@NotNull BlockState state, ServerLevel level, @NotNull BlockPos pos, @NotNull RandomSource rand) {
		if (!level.isClientSide &&
			level.getRawBrightness(pos, 0) < 13 &&
			level.getBlockState(pos.below()).is(ModTags.MUSHROOM_COLONY_GROWABLE_ON)) {
			level.setBlockAndUpdate(pos, CRBlocks.PORTOBELLO_COLONY.get().defaultBlockState());
		}
	}
}

package net.brdle.collectorsreap.common.block;

import net.brdle.collectorsreap.common.item.CRItems;
import net.brdle.collectorsreap.data.CRBlockTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;
import vectorwing.farmersdelight.common.block.BuddingBushBlock;
import org.jetbrains.annotations.NotNull;

public class BuddingDragonFruitBlock extends BuddingBushBlock implements BonemealableBlock {
	public BuddingDragonFruitBlock(Properties properties) {
		super(properties);
	}

	@Override
	public @NotNull ItemLike getBaseSeedId() {
		return CRItems.DRAGON_FRUIT_SEEDS.get();
	}

	@Override
	public @NotNull BlockState getPlant(@NotNull BlockGetter world, @NotNull BlockPos pos) {
		return CRBlocks.BUDDING_PINK_DRAGON_FRUIT_CROP.get().defaultBlockState();
	}

	@Override
	protected boolean mayPlaceOn(BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos) {
		return state.is(CRBlockTags.CROPS_PLANTABLE_ON);
	}

	@Override
	public @NotNull BlockState updateShape(BlockState state, @NotNull Direction facing, @NotNull BlockState facingState, @NotNull LevelAccessor level, @NotNull BlockPos currentPos, @NotNull BlockPos facingPos) {
		if (state.getValue(AGE) == 4) {
			level.setBlock(currentPos, CRBlocks.PINK_DRAGON_FRUIT_CROP.get().defaultBlockState(), 3);
		}
		return super.updateShape(state, facing, facingState, level, currentPos, facingPos);
	}

	@Override
	public boolean canGrowPastMaxAge() {
		return true;
	}

	@Override
	public void growPastMaxAge(@NotNull BlockState state, ServerLevel level, @NotNull BlockPos pos, @NotNull RandomSource random) {
		level.setBlockAndUpdate(pos, CRBlocks.PINK_DRAGON_FRUIT_CROP.get().defaultBlockState());
	}

	@Override
	public boolean isValidBonemealTarget(@NotNull LevelReader level, @NotNull BlockPos pos, @NotNull BlockState state, boolean isClient) {
		return true;
	}

	@Override
	public boolean isBonemealSuccess(@NotNull Level level, @NotNull RandomSource random, @NotNull BlockPos pos, @NotNull BlockState state) {
		return true;
	}

	@Override
	public void performBonemeal(@NotNull ServerLevel level, @NotNull RandomSource random, @NotNull BlockPos pos, @NotNull BlockState state) {
		int maxAge = getMaxAge();
		int ageGrowth = Math.min(getAge(state) + level.getRandom().nextInt(1, 4), 7);
		if (ageGrowth <= maxAge) {
			level.setBlockAndUpdate(pos, state.setValue(AGE, ageGrowth));
		} else {
			level.setBlockAndUpdate(
				pos,
				CRBlocks.PINK_DRAGON_FRUIT_CROP.get().defaultBlockState().setValue(
					DragonFruitVineBlock.VINE_AGE,
					ageGrowth - maxAge - 1
				)
			);
		}
	}
}
package net.brdle.collectorsreap.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Ravager;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class TallFlowerCropBlock extends TallFlowerBlock implements BonemealableBlock {
	public static final int MAX_AGE = 4;
	public static final IntegerProperty AGE = BlockStateProperties.AGE_3;

	public TallFlowerCropBlock(Properties properties) {
		super(properties);
	}

	public final int getMaxAge() {
		return MAX_AGE;
	}

	public final IntegerProperty getAgeProperty() {
		return AGE;
	}

	public boolean isMaxAge(@NotNull BlockState state) {
		return state.getValue(this.getAgeProperty()) >= this.getMaxAge();
	}

	@Override
	public boolean isRandomlyTicking(BlockState state) {
		return state.getValue(HALF) == DoubleBlockHalf.LOWER && !this.isMaxAge(state);
	}

	@Override
	public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(this.getAgeProperty());
		super.createBlockStateDefinition(builder);
	}

	public @NotNull BlockState getStateForAge(final int age) {
		return this.defaultBlockState().setValue(AGE, age);
	}

	@Override
	public @Nullable BlockState getStateForPlacement(@NotNull BlockPlaceContext context) {
		return this.defaultBlockState();
	}

	@Override
	public @NotNull BlockState updateShape(BlockState state, @NotNull Direction facing, @NotNull BlockState facingState, @NotNull LevelAccessor level, @NotNull BlockPos pos, @NotNull BlockPos facingPos) {
		return !state.canSurvive(level, pos) ? Blocks.AIR.defaultBlockState() : state;
	}

	@Override
	public boolean canSurvive(@NotNull BlockState state, @NotNull LevelReader level, @NotNull BlockPos pos) {
		if (!isLower(state)) {
			return super.canSurvive(state, level, pos);
		} else {
			BlockPos below = pos.below();
			boolean isSoil = this.mayPlaceOn(level.getBlockState(below), level, below);
			if (state.getBlock() == this) {
				isSoil = level.getBlockState(below).canSustainPlant(level, below, Direction.UP, this);
			}
			return isSoil && sufficientLight(level, pos) && (state.getValue(AGE) < 3 || isUpper(level.getBlockState(pos.above())));
		}
	}

	@Override
	public boolean mayPlaceOn(BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos) {
		return state.is(Blocks.FARMLAND);
	}

	@Override
	public void entityInside(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Entity entity) {
		if (entity instanceof Ravager && level.getGameRules().getBoolean(GameRules.RULE_MOBGRIEFING)) {
			level.destroyBlock(pos, true, entity);
		}
		super.entityInside(state, level, pos, entity);
	}

	@Override
	public boolean canBeReplaced(@NotNull BlockState state, @NotNull BlockPlaceContext context) {
		return false;
	}

	@Override
	public void setPlacedBy(@NotNull Level level, @NotNull BlockPos pos, @NotNull BlockState state, @NotNull LivingEntity placer, @NotNull ItemStack stack) {
	}

	@Override
	public void randomTick(@NotNull BlockState state, @NotNull ServerLevel level, @NotNull BlockPos pos, RandomSource random) {
		float f = CropBlock.getGrowthSpeed(this, level, pos);
		boolean flag = random.nextInt((int)(25.0F / f) + 1) == 0;
		if (flag) {
			this.grow(level, state, pos, 1);
		}
	}

	public void grow(ServerLevel level, BlockState state, BlockPos pos, int ageIncrement) {
		int i = Math.min(state.getValue(this.getAgeProperty()) + ageIncrement, this.getMaxAge());
		if (this.canGrow(level, pos, state, i)) {
			if (state.getValue(HALF) == DoubleBlockHalf.UPPER) {
				pos = pos.below();
			}
			BlockState newState = this.getStateForAge(i);
			level.setBlock(pos, copyWaterloggedFrom(
				level, pos, newState.setValue(HALF, DoubleBlockHalf.LOWER)
			), 3);
			if (i > 2) {
				level.setBlock(pos.above(), copyWaterloggedFrom(
					level, pos.above(), newState.setValue(HALF, DoubleBlockHalf.UPPER)
				), 3);
			}
		}
	}

	public boolean canGrowInto(LevelReader level, BlockPos pos) {
		BlockState blockstate = level.getBlockState(pos);
		return blockstate.isAir() || blockstate.is(this);
	}

	public boolean sufficientLight(LevelReader level, BlockPos pos) {
		return level.getRawBrightness(pos, 0) >= 8 || level.canSeeSky(pos);
	}

	public boolean isLower(BlockState state) {
		return state.is(this) && state.getValue(HALF) == DoubleBlockHalf.LOWER;
	}

	public boolean isUpper(BlockState state) {
		return state.is(this) && state.getValue(HALF) == DoubleBlockHalf.UPPER;
	}

	public boolean canGrow(LevelReader level, BlockPos pos, BlockState state, int age) {
		return !this.isMaxAge(state) && sufficientLight(level, pos) && (age < 3 || canGrowInto(level, pos.above()));
	}

	private @Nullable TallFlowerCropBlock.PosAndState getLowerHalf(LevelReader level, BlockPos pos, BlockState state) {
		if (isLower(state)) {
			return new TallFlowerCropBlock.PosAndState(pos, state);
		} else {
			BlockPos blockpos = pos.below();
			BlockState blockstate = level.getBlockState(blockpos);
			return isLower(blockstate) ? new TallFlowerCropBlock.PosAndState(blockpos, blockstate) : null;
		}
	}

	@Override
	public boolean isValidBonemealTarget(@NotNull LevelReader level, @NotNull BlockPos pos, @NotNull BlockState state, boolean isClient) {
		TallFlowerCropBlock.PosAndState posAndState = this.getLowerHalf(level, pos, state);
		return posAndState != null && this.canGrow(level, posAndState.pos, posAndState.state, posAndState.state.getValue(this.getAgeProperty()) + 1);
	}

	@Override
	public boolean isBonemealSuccess(@NotNull Level level, @NotNull RandomSource random, @NotNull BlockPos pos, @NotNull BlockState state) {
		return true;
	}

	@Override
	public void performBonemeal(@NotNull ServerLevel pLevel, @NotNull RandomSource random, @NotNull BlockPos pos, @NotNull BlockState state) {
		TallFlowerCropBlock.PosAndState posAndState = this.getLowerHalf(pLevel, pos, state);
		if (posAndState != null) {
			this.grow(pLevel, posAndState.state, posAndState.pos, 1);
		}
	}

	record PosAndState(BlockPos pos, BlockState state) {}
}
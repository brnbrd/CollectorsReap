package net.brdle.collectorsreap.common.block;

import net.brdle.collectorsreap.data.CRBlockTags;
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
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.PlantType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class TallBushCropBlock extends DoublePlantBlock implements BonemealableBlock {
	public TallBushCropBlock(Properties properties) {
		super(properties);
		this.registerDefaultState(this.stateDefinition.any()
			.setValue(this.getAgeProperty(), 0)
			.setValue(HALF, DoubleBlockHalf.LOWER)
		);
	}

	public abstract IntegerProperty getAgeProperty();

	public abstract int getMaxAge();

	public abstract int getShortThreshold();

	public boolean isMaxAge(@NotNull BlockState state) {
		return state.getValue(this.getAgeProperty()) >= this.getMaxAge();
	}

	@Override
	public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(this.getAgeProperty());
		super.createBlockStateDefinition(builder);
	}

	public @NotNull BlockState getStateForAge(final int age) {
		return this.defaultBlockState().setValue(this.getAgeProperty(), age);
	}

	public boolean isLower(@NotNull BlockState state) {
		return state.is(this) && state.getValue(HALF) == DoubleBlockHalf.LOWER;
	}

	public boolean isUpper(@NotNull BlockState state) {
		return state.is(this) && state.getValue(HALF) == DoubleBlockHalf.UPPER;
	}

	public boolean sufficientLight(LevelReader level, BlockPos pos) {
		return level.getRawBrightness(pos, 0) >= 8 || level.canSeeSky(pos);
	}

	public boolean isTall(int age) {
		return age > this.getShortThreshold();
	}

	public boolean isTall(@NotNull BlockState state) {
		return this.isTall(state.getValue(this.getAgeProperty()));
	}

	@Override
	public PlantType getPlantType(BlockGetter level, BlockPos pos) {
		return PlantType.PLAINS;
	}

	public boolean canGrowInto(LevelReader level, BlockPos pos) {
		BlockState blockstate = level.getBlockState(pos);
		return blockstate.isAir() || blockstate.is(this);
	}

	public boolean canGrow(LevelReader level, BlockPos pos, BlockState state, int newAge) {
		return (
			!this.isMaxAge(state) &&
			this.isLower(state) &&
			this.sufficientLight(level, pos) &&
			(!this.isTall(newAge) || this.canGrowInto(level, pos.above()))
		);
	}

	public void grow(ServerLevel level, BlockState state, BlockPos pos, int ageIncrement) {
		final int newAge = Math.min(state.getValue(this.getAgeProperty()) + ageIncrement, this.getMaxAge());
		if (
			this.canGrow(level, pos, state, newAge) &&
			ForgeHooks.onCropsGrowPre(level, pos, state, true)
		) {
			final BlockState newState = this.getStateForAge(newAge);
			level.setBlock(pos, copyWaterloggedFrom(
				level, pos, newState.setValue(HALF, DoubleBlockHalf.LOWER)
			), 2);
			if (this.isTall(newAge)) {
				final BlockPos above = pos.above();
				level.setBlock(above, copyWaterloggedFrom(
					level, above, newState.setValue(HALF, DoubleBlockHalf.UPPER)
				), 3);
			}
			ForgeHooks.onCropsGrowPost(level, pos, state);
		}
	}

	@Override
	public @NotNull BlockState updateShape(BlockState state, @NotNull Direction facing, @NotNull BlockState facingState, @NotNull LevelAccessor level, @NotNull BlockPos pos, @NotNull BlockPos facingPos) {
		return !state.canSurvive(level, pos) ? Blocks.AIR.defaultBlockState() : state;
	}

	@Override
	public boolean mayPlaceOn(BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos) {
		return state.is(CRBlockTags.CROPS_PLANTABLE_ON);
	}

	@Override
	public boolean isRandomlyTicking(@NotNull BlockState state) {
		return this.isLower(state) && !this.isMaxAge(state);
	}

	@Override
	public void randomTick(@NotNull BlockState state, @NotNull ServerLevel level, @NotNull BlockPos pos, RandomSource random) {
		float f = CropBlock.getGrowthSpeed(this, level, pos);
		if (random.nextInt((int) (25.0F / f) + 1) == 0) {
			this.grow(level, state, pos, 1);
		}
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

	private @Nullable TallBushCropBlock.PosAndState getLowerHalf(LevelReader level, BlockPos pos, BlockState state) {
		if (isLower(state)) {
			return new TallBushCropBlock.PosAndState(pos, state);
		} else {
			BlockPos blockpos = pos.below();
			BlockState blockstate = level.getBlockState(blockpos);
			return isLower(blockstate) ? new TallBushCropBlock.PosAndState(blockpos, blockstate) : null;
		}
	}

	@Override
	public boolean isBonemealSuccess(@NotNull Level level, @NotNull RandomSource random, @NotNull BlockPos pos, @NotNull BlockState state) {
		return true;
	}

	@Override
	public boolean isValidBonemealTarget(@NotNull LevelReader level, @NotNull BlockPos pos, @NotNull BlockState state, boolean isClient) {
		TallBushCropBlock.PosAndState posAndState = this.getLowerHalf(level, pos, state);
		return posAndState != null && this.canGrow(level, posAndState.pos, posAndState.state, posAndState.state.getValue(this.getAgeProperty()) + 1);
	}

	@Override
	public void performBonemeal(@NotNull ServerLevel pLevel, @NotNull RandomSource random, @NotNull BlockPos pos, @NotNull BlockState state) {
		TallBushCropBlock.PosAndState posAndState = this.getLowerHalf(pLevel, pos, state);
		if (posAndState != null) {
			this.grow(pLevel, posAndState.state, posAndState.pos, 1);
		}
	}

	record PosAndState(BlockPos pos, BlockState state) {}
}
package net.brdle.collectorsreap.common.block;

import net.brdle.collectorsreap.common.item.CRItems;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

public class DamselflowerCropBlock extends CropBlock {
	public static final int MAX_AGE = 2;
	public static final IntegerProperty AGE = BlockStateProperties.AGE_1;
	private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{
		Block.box(5.0D, 0.0D, 5.0D, 11.0D, 6.0D, 11.0D),
		Block.box(5.0D, 0.0D, 5.0D, 11.0D, 10.0D, 11.0D)
	};

	public DamselflowerCropBlock(BlockBehaviour.Properties properties) {
		super(properties);
	}

	public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> state) {
		state.add(AGE);
	}

	public @NotNull VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter getter, @NotNull BlockPos pos, @NotNull CollisionContext context) {
		return SHAPE_BY_AGE[this.getAge(state)];
	}

	public @NotNull IntegerProperty getAgeProperty() {
		return AGE;
	}

	public final int getMaxAge() {
		return MAX_AGE;
	}

	public @NotNull ItemLike getBaseSeedId() {
		return CRItems.DAMSELFLOWER_SEEDS.get();
	}

	public @NotNull BlockState getStateForAge(int age) {
		return age == this.getMaxAge() ? CRBlocks.DAMSELFLOWER.get().defaultBlockState() : super.getStateForAge(age);
	}

	public void randomTick(@NotNull BlockState state, @NotNull ServerLevel level, @NotNull BlockPos pos, RandomSource random) {
		if (random.nextInt(3) != 0) {
			super.randomTick(state, level, pos, random);
		}
	}

	public int getBonemealAgeIncrease(@NotNull Level level) {
		return 1;
	}
}
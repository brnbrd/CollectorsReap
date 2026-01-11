package net.brdle.collectorsreap.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

public class TallFlowerCropBlock extends TallBushCropBlock {
	public static final VoxelShape SMALL_SHAPE = Block.box(3.0D, 0.0D, 3.0D, 13.0D, 13.0D, 13.0D);
	public static final int SHORT_THRESHOLD = 2;
	public static final int MAX_AGE = 4;
	public static final IntegerProperty AGE = BlockStateProperties.AGE_4;

	public TallFlowerCropBlock(Properties properties) {
		super(properties);
	}

	@SuppressWarnings("deprecation")
	@Override
	public @NotNull VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context) {
		return this.isTall(state) ? super.getShape(state, level, pos, context) : SMALL_SHAPE;
	}

	@Override
	public final IntegerProperty getAgeProperty() {
		return AGE;
	}

	@Override
	public final int getMaxAge() {
		return MAX_AGE;
	}

	@Override
	public final int getShortThreshold() {
		return SHORT_THRESHOLD;
	}
}
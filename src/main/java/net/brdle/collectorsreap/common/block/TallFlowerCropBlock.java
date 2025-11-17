package net.brdle.collectorsreap.common.block;

import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class TallFlowerCropBlock extends TallBushCropBlock {
	public static final int SHORT_THRESHOLD = 2;
	public static final int MAX_AGE = 4;
	public static final IntegerProperty AGE = BlockStateProperties.AGE_4;

	public TallFlowerCropBlock(Properties properties) {
		super(properties);
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
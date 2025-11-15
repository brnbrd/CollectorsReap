package net.brdle.collectorsreap.common.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class BulbousRoseCropBlock extends TallFlowerCropBlock {
	public BulbousRoseCropBlock(BlockBehaviour.Properties properties) {
		super(properties);
	}

	@Override
	public @NotNull BlockState getStateForAge(final int age) {
		return age == this.getMaxAge() ?
			CRBlocks.BULBOUS_ROSE.get().defaultBlockState() :
			super.getStateForAge(age);
	}
}
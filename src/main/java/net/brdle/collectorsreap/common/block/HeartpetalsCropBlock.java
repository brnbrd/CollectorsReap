package net.brdle.collectorsreap.common.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class HeartpetalsCropBlock extends TallFlowerCropBlock {
	public HeartpetalsCropBlock(BlockBehaviour.Properties properties) {
		super(properties);
	}

	@Override
	public @NotNull BlockState getStateForAge(final int age) {
		return age == this.getMaxAge() ?
			CRBlocks.HEARTPETALS.get().defaultBlockState() :
			super.getStateForAge(age);
	}
}
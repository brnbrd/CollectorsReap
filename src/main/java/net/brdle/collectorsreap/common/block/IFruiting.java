package net.brdle.collectorsreap.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.EnumProperty;

public interface IFruiting {

	default int getNumFruit(Level level) {
		return 2 + level.getRandom().nextInt(2);
	}

	Item getFruit();

	default void dropResources(Level level, BlockPos pos) {
		Block.popResource(level, pos, new ItemStack(this.getFruit(), this.getNumFruit(level)));
	}

	default void preventCreativeDropFromBottomPart(EnumProperty<DoubleBlockHalf> half, Level world, BlockPos pos, BlockState state, Player player) {
		if (state.getValue(half) == DoubleBlockHalf.UPPER) {
			BlockPos blockpos = pos.below();
			BlockState blockstate = world.getBlockState(blockpos);
			if (blockstate.getBlock() == state.getBlock() && blockstate.getValue(half) == DoubleBlockHalf.LOWER) {
				world.setBlock(blockpos, Blocks.AIR.defaultBlockState(), 35);
				world.levelEvent(player, 2001, blockpos, Block.getId(blockstate));
			}
		}
	}
}

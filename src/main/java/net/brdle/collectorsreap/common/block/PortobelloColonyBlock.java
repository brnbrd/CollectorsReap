package net.brdle.collectorsreap.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ForgeHooks;
import org.jetbrains.annotations.NotNull;
import vectorwing.farmersdelight.common.block.MushroomColonyBlock;
import vectorwing.farmersdelight.common.tag.ModTags;
import java.util.function.Supplier;

public class PortobelloColonyBlock extends MushroomColonyBlock {
	public PortobelloColonyBlock(Properties properties, Supplier<Item> mushroomType) {
		super(properties, mushroomType);
	}

	// Portobello Colony requires darkness to grow
	@Override
	public void tick(BlockState state, @NotNull ServerLevel level, @NotNull BlockPos pos, @NotNull RandomSource random) {
		int age = state.getValue(COLONY_AGE);
		if (age < getMaxAge() &&
			level.getRawBrightness(pos, 0) < 13 &&
			level.getBlockState(pos.below()).is(ModTags.MUSHROOM_COLONY_GROWABLE_ON) &&
			ForgeHooks.onCropsGrowPre(level, pos, state, random.nextInt(4) == 0)) {
			level.setBlock(pos, state.setValue(COLONY_AGE, age + 1), 2);
			ForgeHooks.onCropsGrowPost(level, pos, state);
		}
	}

	@Override
	public boolean isValidBonemealTarget(@NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull BlockState state, boolean isClient) {
		return false;
	}

	@Override
	public boolean isBonemealSuccess(@NotNull Level level, @NotNull RandomSource random, @NotNull BlockPos pos, @NotNull BlockState state) {
		return false;
	}
}

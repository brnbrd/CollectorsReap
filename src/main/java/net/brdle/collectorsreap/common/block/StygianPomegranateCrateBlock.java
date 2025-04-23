package net.brdle.collectorsreap.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import org.jetbrains.annotations.NotNull;

public class StygianPomegranateCrateBlock extends WoodenCrateBlock {
	public StygianPomegranateCrateBlock(MapColor color) {
		super(color);
	}

	@Override
	public void animateTick(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull RandomSource random) {
		super.animateTick(state, level, pos, random);
		if (random.nextFloat() < 0.35F) {
			level.addParticle(
				ParticleTypes.SOUL,
				(double) pos.getX() + 0.5D + (random.nextDouble() * 0.75D - 0.3D),
				pos.getY() + 1.1D,
				(double) pos.getZ() + 0.5D + (random.nextDouble() * 0.75D - 0.3D),
				0.0D,
				0.0D,
				0.0D
			);
		}
	}
}
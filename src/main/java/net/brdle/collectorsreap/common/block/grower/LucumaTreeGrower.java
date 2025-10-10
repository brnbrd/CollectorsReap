package net.brdle.collectorsreap.common.block.grower;

import net.brdle.collectorsreap.data.pack.CRConfiguredFeatures;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import org.jetbrains.annotations.NotNull;

public class LucumaTreeGrower extends AbstractTreeGrower {
	@Override
	protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(@NotNull RandomSource rand, boolean bees) {
		return bees ? CRConfiguredFeatures.LUCUMA_BEES : CRConfiguredFeatures.LUCUMA;
	}
}
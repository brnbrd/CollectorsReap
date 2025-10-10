package net.brdle.collectorsreap.data.pack;

import net.brdle.collectorsreap.Util;
import net.brdle.collectorsreap.common.block.CRBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.BeehiveDecorator;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import java.util.List;

public class CRConfiguredFeatures {
	public static final ResourceKey<ConfiguredFeature<?, ?>> LUCUMA = createKey("lucuma");
	public static final ResourceKey<ConfiguredFeature<?, ?>> LUCUMA_BEES = createKey("lucuma_bees");

	public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
		context.register(LUCUMA, new ConfiguredFeature<>(Feature.TREE, LUCUMA_TREE));
		context.register(LUCUMA_BEES, new ConfiguredFeature<>(Feature.TREE, LUCUMA_TREE_BEES));
	}

	// Tree Configurations
	public static final TreeConfiguration LUCUMA_TREE = createLucumaTree().build();
	public static final TreeConfiguration LUCUMA_TREE_BEES = createLucumaTree()
		.decorators(List.of(new BeehiveDecorator(0.005F))).build();

	private static TreeConfiguration.TreeConfigurationBuilder createLucumaTree() {
		return new TreeConfiguration.TreeConfigurationBuilder(
			BlockStateProvider.simple(CRBlocks.LUCUMA_LOG.get()),
			new StraightTrunkPlacer(4, 2, 0),
			BlockStateProvider.simple(CRBlocks.LUCUMA_LEAVES.get()),
			new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(2), 4),
			new TwoLayersFeatureSize(1, 0, 1))
			.forceDirt();
	}

	private static ResourceKey<ConfiguredFeature<?, ?>> createKey(String name) {
		return ResourceKey.create(Registries.CONFIGURED_FEATURE, Util.cr(name));
	}
}
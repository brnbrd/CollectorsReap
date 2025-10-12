package net.brdle.collectorsreap.data.pack;

import net.brdle.collectorsreap.Util;
import net.brdle.collectorsreap.common.block.CRBlocks;
import net.brdle.collectorsreap.data.CRBlockTags;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.util.valueproviders.WeightedListInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.RandomSpreadFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.rootplacers.MangroveRootPlacement;
import net.minecraft.world.level.levelgen.feature.rootplacers.MangroveRootPlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.BeehiveDecorator;
import net.minecraft.world.level.levelgen.feature.trunkplacers.CherryTrunkPlacer;
import java.util.List;
import java.util.Optional;

public class CRConfiguredFeatures {
	public static final ResourceKey<ConfiguredFeature<?, ?>> LUCUMA = createKey("lucuma");
	public static final ResourceKey<ConfiguredFeature<?, ?>> LUCUMA_BEES = createKey("lucuma_bees");

	public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
		final HolderGetter<Block> holdergetter = context.lookup(Registries.BLOCK);

		final TreeConfiguration LUCUMA_TREE = createLucumaTree(holdergetter).build();
		final TreeConfiguration LUCUMA_TREE_BEES = createLucumaTree(holdergetter)
			.decorators(List.of(new BeehiveDecorator(0.005F))).build();

		context.register(LUCUMA, new ConfiguredFeature<>(Feature.TREE, LUCUMA_TREE));
		context.register(LUCUMA_BEES, new ConfiguredFeature<>(Feature.TREE, LUCUMA_TREE_BEES));
	}

	private static TreeConfiguration.TreeConfigurationBuilder createLucumaTree(HolderGetter<Block> holdergetter) {
		return new TreeConfiguration.TreeConfigurationBuilder(
			BlockStateProvider.simple(CRBlocks.LUCUMA_LOG.get()),
			new CherryTrunkPlacer(7, 1, 0, new WeightedListInt(SimpleWeightedRandomList.<IntProvider>builder().add(ConstantInt.of(1), 1).add(ConstantInt.of(2), 1).add(ConstantInt.of(3), 1).build()), UniformInt.of(2, 4), UniformInt.of(-4, -3), UniformInt.of(-1, 0)),
			BlockStateProvider.simple(CRBlocks.LUCUMA_LEAVES.get()),
			new RandomSpreadFoliagePlacer(ConstantInt.of(3), ConstantInt.of(0), ConstantInt.of(2), 80),
			Optional.of(new MangroveRootPlacer(
				UniformInt.of(1, 2),
				BlockStateProvider.simple(CRBlocks.LUCUMA_LOG.get()),
				Optional.empty(),
				new MangroveRootPlacement(
					holdergetter.getOrThrow(CRBlockTags.LUCUMA_ROOTS_CAN_GROW_THROUGH),
					HolderSet.direct(Block::builtInRegistryHolder, Blocks.MUD, CRBlocks.LUCUMA_LOG.get()),
					BlockStateProvider.simple(CRBlocks.LUCUMA_LOG.get()),
					2,
					2,
					0.2F
				)
			)),
			new TwoLayersFeatureSize(2, 0, 2)
		).ignoreVines();
	}

	private static ResourceKey<ConfiguredFeature<?, ?>> createKey(String name) {
		return ResourceKey.create(Registries.CONFIGURED_FEATURE, Util.cr(name));
	}
}
package net.brdle.veggiedelight.common.world;

import net.brdle.veggiedelight.Util;
import net.brdle.veggiedelight.VeggieDelight;
import net.brdle.veggiedelight.common.block.VDBlocks;
import net.brdle.veggiedelight.common.config.VDConfig;
import net.brdle.veggiedelight.data.VDBlockTags;
import net.minecraft.core.Holder;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;
import vectorwing.farmersdelight.common.registry.ModBiomeFeatures;
import vectorwing.farmersdelight.common.world.WildCropGeneration;
import vectorwing.farmersdelight.common.world.configuration.WildCropConfiguration;
import java.util.List;

public class VDWorldGen extends WildCropGeneration {
	public static Holder<ConfiguredFeature<WildCropConfiguration, ?>> FEATURE_PATCH_PORTOBELLO;
	public static Holder<PlacedFeature> PATCH_PORTOBELLO;

	private static Holder<PlacedFeature> registerPlacement(ResourceLocation id, Holder<? extends ConfiguredFeature<?, ?>> feature, PlacementModifier... modifiers) {
		return BuiltinRegistries.register(BuiltinRegistries.PLACED_FEATURE, id, new PlacedFeature(Holder.hackyErase(feature), List.of(modifiers)));
	}

	private static Holder<PlacedFeature> registerConditionalPlacement(ResourceLocation id, Holder<? extends ConfiguredFeature<?, ?>> feature, boolean condition, PlacementModifier... modifiers) {
		return condition ? registerPlacement(id, feature, modifiers) : registerPlacement(id, feature, BlockPredicateFilter.forPredicate(BlockPredicate.not(BlockPredicate.alwaysTrue())));
	}

	public static void registerGeneration() {
		FEATURE_PATCH_PORTOBELLO = register(Util.rl(VeggieDelight.MODID, "patch_portobello"),
			ModBiomeFeatures.WILD_CROP.get(), mushroomColonyConfig(VDBlocks.PORTOBELLO_COLONY.get(), VDBlocks.PORTOBELLO.get(), BlockPredicate.matchesTag(BLOCK_BELOW, VDBlockTags.PORTOBELLO_SPAWNS)));

		PATCH_PORTOBELLO = registerConditionalPlacement(Util.rl(VeggieDelight.MODID, "patch_portobello"),
			FEATURE_PATCH_PORTOBELLO, VDConfig.verify("portobello") && VDConfig.CHANCE_PORTOBELLO.get() > 0, RarityFilter.onAverageOnceEvery(VDConfig.CHANCE_PORTOBELLO.get()), CountPlacement.of(3), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
	}
}
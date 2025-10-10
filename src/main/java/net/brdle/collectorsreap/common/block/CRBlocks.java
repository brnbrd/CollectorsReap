package net.brdle.collectorsreap.common.block;

import com.mojang.datafixers.util.Pair;
import com.teamabnormals.blueprint.common.block.LeafPileBlock;
import com.teamabnormals.blueprint.common.block.LogBlock;
import com.teamabnormals.blueprint.common.block.WoodBlock;
import com.teamabnormals.blueprint.common.block.sign.BlueprintCeilingHangingSignBlock;
import com.teamabnormals.blueprint.common.block.sign.BlueprintStandingSignBlock;
import com.teamabnormals.blueprint.common.block.sign.BlueprintWallHangingSignBlock;
import com.teamabnormals.blueprint.common.block.sign.BlueprintWallSignBlock;
import com.teamabnormals.blueprint.core.api.BlockSetTypeRegistryHelper;
import com.teamabnormals.blueprint.core.api.WoodTypeRegistryHelper;
import com.teamabnormals.blueprint.core.util.PropertyUtil;
import com.teamabnormals.blueprint.core.util.registry.BlockSubRegistryHelper;
import net.brdle.collectorsreap.CollectorsReap;
import net.brdle.collectorsreap.common.block.grower.LucumaTreeGrower;
import net.brdle.collectorsreap.common.item.CRItems;
import net.brdle.collectorsreap.compat.Modid;
import net.brdle.collectorsreap.compat.letfishlove.LetFishLoveCompat;
import net.minecraft.core.BlockPos;
import net.minecraft.core.cauldron.CauldronInteraction;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.common.block.PieBlock;
import vectorwing.farmersdelight.common.block.WildCropBlock;
import vectorwing.farmersdelight.common.registry.ModBlocks;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;

public class CRBlocks {
	public static final BlockSubRegistryHelper HELPER = CollectorsReap.REGISTRY_HELPER.getBlockSubHelper();

	// Crates
	public static final RegistryObject<Block> LIME_CRATE = registerBlock("lime_crate",
		() -> new WoodenCrateBlock(MapColor.COLOR_LIGHT_GREEN));
	public static final RegistryObject<Block> POMEGRANATE_CRATE = registerBlock("pomegranate_crate",
		() -> new WoodenCrateBlock(MapColor.COLOR_RED));
	public static final RegistryObject<Block> STYGIAN_POMEGRANATE_CRATE = registerBlock("stygian_pomegranate_crate",
		() -> new StygianPomegranateCrateBlock(MapColor.COLOR_CYAN));
	public static final RegistryObject<Block> PINK_DRAGON_FRUIT_CRATE = registerBlock("pink_dragon_fruit_crate",
		() -> new WoodenCrateBlock(MapColor.COLOR_PINK));
	public static final RegistryObject<Block> LUCUMA_CRATE = registerBlock("lucuma_crate",
		() -> new WoodenCrateBlock(MapColor.COLOR_ORANGE));
	public static final RegistryObject<Block> GILDED_LUCUMA_CRATE = registerBlock("gilded_lucuma_crate",
		() -> new WoodenCrateBlock(MapColor.COLOR_YELLOW));

	// Lucuma Wood
	public static final RegistryObject<Block> LUCUMA_LOG = registerBlock("lucuma_log", () -> new LogBlock(CRBlocks.STRIPPED_LUCUMA_LOG, Properties.LUCUMA.log()));
	public static final RegistryObject<Block> LUCUMA_WOOD = registerBlock("lucuma_wood", () -> new WoodBlock(CRBlocks.STRIPPED_LUCUMA_WOOD, Properties.LUCUMA.log()));
	public static final RegistryObject<Block> STRIPPED_LUCUMA_LOG = registerBlock("stripped_lucuma_log", () -> new RotatedPillarBlock(Properties.LUCUMA.log()));
	public static final RegistryObject<Block> STRIPPED_LUCUMA_WOOD = registerBlock("stripped_lucuma_wood", () -> new RotatedPillarBlock(Properties.LUCUMA.log()));
	public static final RegistryObject<Block> LUCUMA_PLANKS = registerBlock("lucuma_planks", () -> new Block(Properties.LUCUMA.planks()));
	public static final RegistryObject<Block> LUCUMA_STAIRS = registerBlock("lucuma_stairs", () -> new StairBlock(() -> LUCUMA_PLANKS.get().defaultBlockState(), Properties.LUCUMA.planks()));
	public static final RegistryObject<Block> LUCUMA_SLAB = registerBlock("lucuma_slab", () -> new SlabBlock(Properties.LUCUMA.planks()));
	public static final RegistryObject<Block> LUCUMA_FENCE = registerBlock("lucuma_fence", () -> new FenceBlock(Properties.LUCUMA.planks()));
	public static final RegistryObject<Block> LUCUMA_FENCE_GATE = registerBlock("lucuma_fence_gate", () -> new FenceGateBlock(Properties.LUCUMA.planks(), Properties.LUCUMA_WOOD_TYPE));
	public static final RegistryObject<Block> LUCUMA_DOOR = registerBlock("lucuma_door", () -> new DoorBlock(Properties.LUCUMA.door(), Properties.LUCUMA_BLOCK_SET));
	public static final RegistryObject<Block> LUCUMA_TRAPDOOR = registerBlock("lucuma_trapdoor", () -> new TrapDoorBlock(Properties.LUCUMA.trapdoor(), Properties.LUCUMA_BLOCK_SET));
	public static final RegistryObject<Block> LUCUMA_PRESSURE_PLATE = registerBlock("lucuma_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Properties.LUCUMA.pressurePlate(), Properties.LUCUMA_BLOCK_SET));
	public static final RegistryObject<Block> LUCUMA_BUTTON = registerBlock("lucuma_button", () ->  new ButtonBlock(Properties.LUCUMA.button(), Properties.LUCUMA_BLOCK_SET, 30, true));
	public static final Pair<RegistryObject<BlueprintStandingSignBlock>, RegistryObject<BlueprintWallSignBlock>> LUCUMA_SIGNS = HELPER.createSignBlock("lucuma", Properties.LUCUMA_WOOD_TYPE, Properties.LUCUMA.sign());
	public static final RegistryObject<BlueprintStandingSignBlock> LUCUMA_SIGN = LUCUMA_SIGNS.getFirst();
	public static final RegistryObject<BlueprintWallSignBlock> LUCUMA_WALL_SIGN = LUCUMA_SIGNS.getSecond();
	public static final Pair<RegistryObject<BlueprintCeilingHangingSignBlock>, RegistryObject<BlueprintWallHangingSignBlock>> LUCUMA_HANGING_SIGNS = HELPER.createHangingSignBlock("lucuma", Properties.LUCUMA_WOOD_TYPE, Properties.LUCUMA.hangingSign());
	public static final RegistryObject<BlueprintCeilingHangingSignBlock> LUCUMA_HANGING_SIGN = LUCUMA_HANGING_SIGNS.getFirst();
	public static final RegistryObject<BlueprintWallHangingSignBlock> LUCUMA_WALL_HANGING_SIGN = LUCUMA_HANGING_SIGNS.getSecond();

	public static final RegistryObject<Block> LUCUMA_SAPLING = HELPER.createBlock("lucuma_sapling", () -> new SaplingBlock(new LucumaTreeGrower(), PropertyUtil.sapling()));
	public static final RegistryObject<Block> POTTED_LUCUMA_SAPLING = HELPER.createBlockNoItem("potted_lucuma_sapling", () -> new FlowerPotBlock(LUCUMA_SAPLING.get(), PropertyUtil.flowerPot()));
	public static final RegistryObject<Block> LUCUMA_LEAVES = HELPER.createBlock("lucuma_leaves", () -> new LeavesBlock(Properties.LUCUMA.leaves()));
	public static final RegistryObject<Block> LUCUMA_LEAF_PILE = HELPER.createBlock("lucuma_leaf_pile", () -> new LeafPileBlock(Properties.LUCUMA.leafPile()));

	// Urchin Test
	public static final RegistryObject<Block> URCHIN_TEST_BLOCK = registerBlock("urchin_test_block", () -> new Block(Properties.URCHIN_TEST));
	public static final RegistryObject<Block> URCHIN_TEST_BRICKS = registerBlock("urchin_test_bricks", () -> new Block(Properties.URCHIN_TEST));
	public static final RegistryObject<Block> URCHIN_TEST_BRICK_STAIRS = registerBlock("urchin_test_brick_stairs", () -> new StairBlock(() -> URCHIN_TEST_BRICKS.get().defaultBlockState(), Properties.URCHIN_TEST));
	public static final RegistryObject<Block> URCHIN_TEST_BRICK_SLAB = registerBlock("urchin_test_brick_slab", () -> new SlabBlock(Properties.URCHIN_TEST.strength(2F, 6F)));
	public static final RegistryObject<Block> URCHIN_TEST_BRICK_WALL = registerBlock("urchin_test_brick_wall", () -> new WallBlock(Properties.URCHIN_TEST));
	public static final RegistryObject<Block> CHISELED_URCHIN_TEST_BRICKS = registerBlock("chiseled_urchin_test_bricks", () -> new Block(Properties.URCHIN_TEST));
	public static final RegistryObject<Block> URCHIN_TEST_TILES = registerBlock("urchin_test_tiles", () -> new Block(Properties.URCHIN_TEST));
	public static final RegistryObject<Block> URCHIN_TEST_TILE_STAIRS = registerBlock("urchin_test_tile_stairs", () -> new StairBlock(() -> URCHIN_TEST_TILES.get().defaultBlockState(), Properties.URCHIN_TEST));
	public static final RegistryObject<Block> URCHIN_TEST_TILE_SLAB = registerBlock("urchin_test_tile_slab", () -> new SlabBlock(Properties.URCHIN_TEST.strength(2F, 6F)));
	public static final RegistryObject<Block> URCHIN_TEST_TILE_WALL = registerBlock("urchin_test_tile_wall", () -> new WallBlock(Properties.URCHIN_TEST));

	// Ice Cream Blocks
	public static final RegistryObject<Block> LIME_ICE_CREAM_BLOCK = registerBlock("lime_ice_cream_block",
		() -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GREEN).strength(0.2F).sound(SoundType.SNOW)));
	public static final RegistryObject<Block> POMEGRANATE_ICE_CREAM_BLOCK = registerBlock("pomegranate_ice_cream_block",
		() -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).strength(0.2F).sound(SoundType.SNOW)));
	public static final RegistryObject<Block> PINK_DRAGON_FRUIT_ICE_CREAM_BLOCK = registerBlock("pink_dragon_fruit_ice_cream_block",
		() -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PINK).strength(0.2F).sound(SoundType.SNOW)));
	public static final RegistryObject<Block> LUCUMA_ICE_CREAM_BLOCK = registerBlock("lucuma_ice_cream_block",
		() -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).strength(0.2F).sound(SoundType.SNOW)));

	// Wild Crop Blocks
	public static final RegistryObject<Block> PORTOBELLO_COLONY = registerBlockNoItem("portobello_colony",
		() -> new PortobelloColonyBlock(copy(ModBlocks.BROWN_MUSHROOM_COLONY), CRItems.PORTOBELLO));
	public static final RegistryObject<Block> PORTOBELLO = registerBlockNoItem("portobello",
		() -> new PortobelloBlock(copy(Blocks.BROWN_MUSHROOM)
			.noCollission().randomTicks().instabreak().sound(SoundType.GRASS).lightLevel((l) -> 1).hasPostProcess(CRBlocks::always)));
	public static final RegistryObject<Block> LIME_BUSH = registerBlockNoItem("lime_bush",
		() -> new LimeBushBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).forceSolidOff().instabreak().sound(SoundType.SWEET_BERRY_BUSH).noOcclusion().pushReaction(PushReaction.DESTROY)));
	public static final RegistryObject<Block> POMEGRANATE_BUSH = registerBlockNoItem("pomegranate_bush",
		() -> new PomegranateBushBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).forceSolidOff().instabreak().sound(SoundType.SWEET_BERRY_BUSH).noOcclusion().pushReaction(PushReaction.DESTROY)));
	public static final RegistryObject<Block> DRAGON_BUSH = registerBlock("dragon_bush",
		() -> new WildCropBlock(MobEffects.GLOWING, 6, BlockBehaviour.Properties.copy(Blocks.TALL_GRASS)));

	// Crops
	public static final RegistryObject<Block> BUDDING_PINK_DRAGON_FRUIT_CROP = registerBlockNoItem("budding_pink_dragon_fruits",
		() -> new BuddingDragonFruitBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT)));
	public static final RegistryObject<Block> PINK_DRAGON_FRUIT_CROP = registerBlockNoItem("pink_dragon_fruits",
		() -> new DragonFruitVineBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT)));

	// Sliceables
	public static final RegistryObject<Block> PORTOBELLO_QUICHE = registerBlockNoItem("portobello_quiche",
		() -> new PieBlock(copy(ModBlocks.APPLE_PIE), CRItems.PORTOBELLO_QUICHE_SLICE));
	public static final RegistryObject<Block> LIME_PIE = registerBlockNoItem("lime_pie",
		() -> new PieBlock(copy(ModBlocks.APPLE_PIE), CRItems.LIME_PIE_SLICE));

	// Cakes
	public static final RegistryObject<Block> LIME_CAKE = registerBlockNoItem("lime_cake", () -> new EffectCakeBlock(copy(Blocks.CAKE), CRItems.LIME_CAKE_SLICE));
	public static final RegistryObject<Block> CANDLE_LIME_CAKE = registerBlockNoItem("candle_lime_cake", () -> new EffectCandleCakeBlock(CRBlocks.LIME_CAKE.get(), Blocks.CANDLE, copy(Blocks.CAKE).lightLevel(litBlockEmission(3))));
	public static final RegistryObject<Block> WHITE_CANDLE_LIME_CAKE = registerBlockNoItem("white_candle_lime_cake", () -> new EffectCandleCakeBlock(CRBlocks.LIME_CAKE.get(), Blocks.WHITE_CANDLE, copy(CANDLE_LIME_CAKE.get())));
	public static final RegistryObject<Block> ORANGE_CANDLE_LIME_CAKE = registerBlockNoItem("orange_candle_lime_cake", () -> new EffectCandleCakeBlock(CRBlocks.LIME_CAKE.get(), Blocks.ORANGE_CANDLE, copy(CANDLE_LIME_CAKE.get())));
	public static final RegistryObject<Block> MAGENTA_CANDLE_LIME_CAKE = registerBlockNoItem("magenta_candle_lime_cake", () -> new EffectCandleCakeBlock(CRBlocks.LIME_CAKE.get(), Blocks.MAGENTA_CANDLE, copy(CANDLE_LIME_CAKE.get())));
	public static final RegistryObject<Block> LIGHT_BLUE_CANDLE_LIME_CAKE = registerBlockNoItem("light_blue_candle_lime_cake", () -> new EffectCandleCakeBlock(CRBlocks.LIME_CAKE.get(), Blocks.LIGHT_BLUE_CANDLE, copy(CANDLE_LIME_CAKE.get())));
	public static final RegistryObject<Block> YELLOW_CANDLE_LIME_CAKE = registerBlockNoItem("yellow_candle_lime_cake", () -> new EffectCandleCakeBlock(CRBlocks.LIME_CAKE.get(), Blocks.YELLOW_CANDLE, copy(CANDLE_LIME_CAKE.get())));
	public static final RegistryObject<Block> LIME_CANDLE_LIME_CAKE = registerBlockNoItem("lime_candle_lime_cake", () -> new EffectCandleCakeBlock(CRBlocks.LIME_CAKE.get(), Blocks.LIME_CANDLE, copy(CANDLE_LIME_CAKE.get())));
	public static final RegistryObject<Block> PINK_CANDLE_LIME_CAKE = registerBlockNoItem("pink_candle_lime_cake", () -> new EffectCandleCakeBlock(CRBlocks.LIME_CAKE.get(), Blocks.PINK_CANDLE, copy(CANDLE_LIME_CAKE.get())));
	public static final RegistryObject<Block> GRAY_CANDLE_LIME_CAKE = registerBlockNoItem("gray_candle_lime_cake", () -> new EffectCandleCakeBlock(CRBlocks.LIME_CAKE.get(), Blocks.GRAY_CANDLE, copy(CANDLE_LIME_CAKE.get())));
	public static final RegistryObject<Block> LIGHT_GRAY_CANDLE_LIME_CAKE = registerBlockNoItem("light_gray_candle_lime_cake", () -> new EffectCandleCakeBlock(CRBlocks.LIME_CAKE.get(), Blocks.LIGHT_GRAY_CANDLE, copy(CANDLE_LIME_CAKE.get())));
	public static final RegistryObject<Block> CYAN_CANDLE_LIME_CAKE = registerBlockNoItem("cyan_candle_lime_cake", () -> new EffectCandleCakeBlock(CRBlocks.LIME_CAKE.get(), Blocks.CYAN_CANDLE, copy(CANDLE_LIME_CAKE.get())));
	public static final RegistryObject<Block> PURPLE_CANDLE_LIME_CAKE = registerBlockNoItem("purple_candle_lime_cake", () -> new EffectCandleCakeBlock(CRBlocks.LIME_CAKE.get(), Blocks.PURPLE_CANDLE, copy(CANDLE_LIME_CAKE.get())));
	public static final RegistryObject<Block> BLUE_CANDLE_LIME_CAKE = registerBlockNoItem("blue_candle_lime_cake", () -> new EffectCandleCakeBlock(CRBlocks.LIME_CAKE.get(), Blocks.BLUE_CANDLE, copy(CANDLE_LIME_CAKE.get())));
	public static final RegistryObject<Block> BROWN_CANDLE_LIME_CAKE = registerBlockNoItem("brown_candle_lime_cake", () -> new EffectCandleCakeBlock(CRBlocks.LIME_CAKE.get(), Blocks.BROWN_CANDLE, copy(CANDLE_LIME_CAKE.get())));
	public static final RegistryObject<Block> GREEN_CANDLE_LIME_CAKE = registerBlockNoItem("green_candle_lime_cake", () -> new EffectCandleCakeBlock(CRBlocks.LIME_CAKE.get(), Blocks.GREEN_CANDLE, copy(CANDLE_LIME_CAKE.get())));
	public static final RegistryObject<Block> RED_CANDLE_LIME_CAKE = registerBlockNoItem("red_candle_lime_cake", () -> new EffectCandleCakeBlock(CRBlocks.LIME_CAKE.get(), Blocks.RED_CANDLE, copy(CANDLE_LIME_CAKE.get())));
	public static final RegistryObject<Block> BLACK_CANDLE_LIME_CAKE = registerBlockNoItem("black_candle_lime_cake", () -> new EffectCandleCakeBlock(CRBlocks.LIME_CAKE.get(), Blocks.BLACK_CANDLE, copy(CANDLE_LIME_CAKE.get())));
	public static final RegistryObject<Block> POMEGRANATE_CAKE = registerBlockNoItem("pomegranate_cake", () -> new EffectCakeBlock(copy(Blocks.CAKE), CRItems.POMEGRANATE_CAKE_SLICE));
	public static final RegistryObject<Block> CANDLE_POMEGRANATE_CAKE = registerBlockNoItem("candle_pomegranate_cake", () -> new EffectCandleCakeBlock(CRBlocks.POMEGRANATE_CAKE.get(), Blocks.CANDLE, copy(Blocks.CAKE).lightLevel(litBlockEmission(3))));
	public static final RegistryObject<Block> WHITE_CANDLE_POMEGRANATE_CAKE = registerBlockNoItem("white_candle_pomegranate_cake", () -> new EffectCandleCakeBlock(CRBlocks.POMEGRANATE_CAKE.get(), Blocks.WHITE_CANDLE, copy(CANDLE_POMEGRANATE_CAKE.get())));
	public static final RegistryObject<Block> ORANGE_CANDLE_POMEGRANATE_CAKE = registerBlockNoItem("orange_candle_pomegranate_cake", () -> new EffectCandleCakeBlock(CRBlocks.POMEGRANATE_CAKE.get(), Blocks.ORANGE_CANDLE, copy(CANDLE_POMEGRANATE_CAKE.get())));
	public static final RegistryObject<Block> MAGENTA_CANDLE_POMEGRANATE_CAKE = registerBlockNoItem("magenta_candle_pomegranate_cake", () -> new EffectCandleCakeBlock(CRBlocks.POMEGRANATE_CAKE.get(), Blocks.MAGENTA_CANDLE, copy(CANDLE_POMEGRANATE_CAKE.get())));
	public static final RegistryObject<Block> LIGHT_BLUE_CANDLE_POMEGRANATE_CAKE = registerBlockNoItem("light_blue_candle_pomegranate_cake", () -> new EffectCandleCakeBlock(CRBlocks.POMEGRANATE_CAKE.get(), Blocks.LIGHT_BLUE_CANDLE, copy(CANDLE_POMEGRANATE_CAKE.get())));
	public static final RegistryObject<Block> YELLOW_CANDLE_POMEGRANATE_CAKE = registerBlockNoItem("yellow_candle_pomegranate_cake", () -> new EffectCandleCakeBlock(CRBlocks.POMEGRANATE_CAKE.get(), Blocks.YELLOW_CANDLE, copy(CANDLE_POMEGRANATE_CAKE.get())));
	public static final RegistryObject<Block> LIME_CANDLE_POMEGRANATE_CAKE = registerBlockNoItem("lime_candle_pomegranate_cake", () -> new EffectCandleCakeBlock(CRBlocks.POMEGRANATE_CAKE.get(), Blocks.LIME_CANDLE, copy(CANDLE_POMEGRANATE_CAKE.get())));
	public static final RegistryObject<Block> PINK_CANDLE_POMEGRANATE_CAKE = registerBlockNoItem("pink_candle_pomegranate_cake", () -> new EffectCandleCakeBlock(CRBlocks.POMEGRANATE_CAKE.get(), Blocks.PINK_CANDLE, copy(CANDLE_POMEGRANATE_CAKE.get())));
	public static final RegistryObject<Block> GRAY_CANDLE_POMEGRANATE_CAKE = registerBlockNoItem("gray_candle_pomegranate_cake", () -> new EffectCandleCakeBlock(CRBlocks.POMEGRANATE_CAKE.get(), Blocks.GRAY_CANDLE, copy(CANDLE_POMEGRANATE_CAKE.get())));
	public static final RegistryObject<Block> LIGHT_GRAY_CANDLE_POMEGRANATE_CAKE = registerBlockNoItem("light_gray_candle_pomegranate_cake", () -> new EffectCandleCakeBlock(CRBlocks.POMEGRANATE_CAKE.get(), Blocks.LIGHT_GRAY_CANDLE, copy(CANDLE_POMEGRANATE_CAKE.get())));
	public static final RegistryObject<Block> CYAN_CANDLE_POMEGRANATE_CAKE = registerBlockNoItem("cyan_candle_pomegranate_cake", () -> new EffectCandleCakeBlock(CRBlocks.POMEGRANATE_CAKE.get(), Blocks.CYAN_CANDLE, copy(CANDLE_POMEGRANATE_CAKE.get())));
	public static final RegistryObject<Block> PURPLE_CANDLE_POMEGRANATE_CAKE = registerBlockNoItem("purple_candle_pomegranate_cake", () -> new EffectCandleCakeBlock(CRBlocks.POMEGRANATE_CAKE.get(), Blocks.PURPLE_CANDLE, copy(CANDLE_POMEGRANATE_CAKE.get())));
	public static final RegistryObject<Block> BLUE_CANDLE_POMEGRANATE_CAKE = registerBlockNoItem("blue_candle_pomegranate_cake", () -> new EffectCandleCakeBlock(CRBlocks.POMEGRANATE_CAKE.get(), Blocks.BLUE_CANDLE, copy(CANDLE_POMEGRANATE_CAKE.get())));
	public static final RegistryObject<Block> BROWN_CANDLE_POMEGRANATE_CAKE = registerBlockNoItem("brown_candle_pomegranate_cake", () -> new EffectCandleCakeBlock(CRBlocks.POMEGRANATE_CAKE.get(), Blocks.BROWN_CANDLE, copy(CANDLE_POMEGRANATE_CAKE.get())));
	public static final RegistryObject<Block> GREEN_CANDLE_POMEGRANATE_CAKE = registerBlockNoItem("green_candle_pomegranate_cake", () -> new EffectCandleCakeBlock(CRBlocks.POMEGRANATE_CAKE.get(), Blocks.GREEN_CANDLE, copy(CANDLE_POMEGRANATE_CAKE.get())));
	public static final RegistryObject<Block> RED_CANDLE_POMEGRANATE_CAKE = registerBlockNoItem("red_candle_pomegranate_cake", () -> new EffectCandleCakeBlock(CRBlocks.POMEGRANATE_CAKE.get(), Blocks.RED_CANDLE, copy(CANDLE_POMEGRANATE_CAKE.get())));
	public static final RegistryObject<Block> BLACK_CANDLE_POMEGRANATE_CAKE = registerBlockNoItem("black_candle_pomegranate_cake", () -> new EffectCandleCakeBlock(CRBlocks.POMEGRANATE_CAKE.get(), Blocks.BLACK_CANDLE, copy(CANDLE_POMEGRANATE_CAKE.get())));
	public static final RegistryObject<Block> PINK_DRAGON_FRUIT_CAKE = registerBlockNoItem("pink_dragon_fruit_cake", () -> new EffectCakeBlock(copy(Blocks.CAKE), CRItems.PINK_DRAGON_FRUIT_CAKE_SLICE));
	public static final RegistryObject<Block> CANDLE_PINK_DRAGON_FRUIT_CAKE = registerBlockNoItem("candle_pink_dragon_fruit_cake", () -> new EffectCandleCakeBlock(CRBlocks.PINK_DRAGON_FRUIT_CAKE.get(), Blocks.CANDLE, copy(Blocks.CAKE).lightLevel(litBlockEmission(3))));
	public static final RegistryObject<Block> WHITE_CANDLE_PINK_DRAGON_FRUIT_CAKE = registerBlockNoItem("white_candle_pink_dragon_fruit_cake", () -> new EffectCandleCakeBlock(CRBlocks.PINK_DRAGON_FRUIT_CAKE.get(), Blocks.WHITE_CANDLE, copy(CANDLE_PINK_DRAGON_FRUIT_CAKE.get())));
	public static final RegistryObject<Block> ORANGE_CANDLE_PINK_DRAGON_FRUIT_CAKE = registerBlockNoItem("orange_candle_pink_dragon_fruit_cake", () -> new EffectCandleCakeBlock(CRBlocks.PINK_DRAGON_FRUIT_CAKE.get(), Blocks.ORANGE_CANDLE, copy(CANDLE_PINK_DRAGON_FRUIT_CAKE.get())));
	public static final RegistryObject<Block> MAGENTA_CANDLE_PINK_DRAGON_FRUIT_CAKE = registerBlockNoItem("magenta_candle_pink_dragon_fruit_cake", () -> new EffectCandleCakeBlock(CRBlocks.PINK_DRAGON_FRUIT_CAKE.get(), Blocks.MAGENTA_CANDLE, copy(CANDLE_PINK_DRAGON_FRUIT_CAKE.get())));
	public static final RegistryObject<Block> LIGHT_BLUE_CANDLE_PINK_DRAGON_FRUIT_CAKE = registerBlockNoItem("light_blue_candle_pink_dragon_fruit_cake", () -> new EffectCandleCakeBlock(CRBlocks.PINK_DRAGON_FRUIT_CAKE.get(), Blocks.LIGHT_BLUE_CANDLE, copy(CANDLE_PINK_DRAGON_FRUIT_CAKE.get())));
	public static final RegistryObject<Block> YELLOW_CANDLE_PINK_DRAGON_FRUIT_CAKE = registerBlockNoItem("yellow_candle_pink_dragon_fruit_cake", () -> new EffectCandleCakeBlock(CRBlocks.PINK_DRAGON_FRUIT_CAKE.get(), Blocks.YELLOW_CANDLE, copy(CANDLE_PINK_DRAGON_FRUIT_CAKE.get())));
	public static final RegistryObject<Block> LIME_CANDLE_PINK_DRAGON_FRUIT_CAKE = registerBlockNoItem("lime_candle_pink_dragon_fruit_cake", () -> new EffectCandleCakeBlock(CRBlocks.PINK_DRAGON_FRUIT_CAKE.get(), Blocks.LIME_CANDLE, copy(CANDLE_PINK_DRAGON_FRUIT_CAKE.get())));
	public static final RegistryObject<Block> PINK_CANDLE_PINK_DRAGON_FRUIT_CAKE = registerBlockNoItem("pink_candle_pink_dragon_fruit_cake", () -> new EffectCandleCakeBlock(CRBlocks.PINK_DRAGON_FRUIT_CAKE.get(), Blocks.PINK_CANDLE, copy(CANDLE_PINK_DRAGON_FRUIT_CAKE.get())));
	public static final RegistryObject<Block> GRAY_CANDLE_PINK_DRAGON_FRUIT_CAKE = registerBlockNoItem("gray_candle_pink_dragon_fruit_cake", () -> new EffectCandleCakeBlock(CRBlocks.PINK_DRAGON_FRUIT_CAKE.get(), Blocks.GRAY_CANDLE, copy(CANDLE_PINK_DRAGON_FRUIT_CAKE.get())));
	public static final RegistryObject<Block> LIGHT_GRAY_CANDLE_PINK_DRAGON_FRUIT_CAKE = registerBlockNoItem("light_gray_candle_pink_dragon_fruit_cake", () -> new EffectCandleCakeBlock(CRBlocks.PINK_DRAGON_FRUIT_CAKE.get(), Blocks.LIGHT_GRAY_CANDLE, copy(CANDLE_PINK_DRAGON_FRUIT_CAKE.get())));
	public static final RegistryObject<Block> CYAN_CANDLE_PINK_DRAGON_FRUIT_CAKE = registerBlockNoItem("cyan_candle_pink_dragon_fruit_cake", () -> new EffectCandleCakeBlock(CRBlocks.PINK_DRAGON_FRUIT_CAKE.get(), Blocks.CYAN_CANDLE, copy(CANDLE_PINK_DRAGON_FRUIT_CAKE.get())));
	public static final RegistryObject<Block> PURPLE_CANDLE_PINK_DRAGON_FRUIT_CAKE = registerBlockNoItem("purple_candle_pink_dragon_fruit_cake", () -> new EffectCandleCakeBlock(CRBlocks.PINK_DRAGON_FRUIT_CAKE.get(), Blocks.PURPLE_CANDLE, copy(CANDLE_PINK_DRAGON_FRUIT_CAKE.get())));
	public static final RegistryObject<Block> BLUE_CANDLE_PINK_DRAGON_FRUIT_CAKE = registerBlockNoItem("blue_candle_pink_dragon_fruit_cake", () -> new EffectCandleCakeBlock(CRBlocks.PINK_DRAGON_FRUIT_CAKE.get(), Blocks.BLUE_CANDLE, copy(CANDLE_PINK_DRAGON_FRUIT_CAKE.get())));
	public static final RegistryObject<Block> BROWN_CANDLE_PINK_DRAGON_FRUIT_CAKE = registerBlockNoItem("brown_candle_pink_dragon_fruit_cake", () -> new EffectCandleCakeBlock(CRBlocks.PINK_DRAGON_FRUIT_CAKE.get(), Blocks.BROWN_CANDLE, copy(CANDLE_PINK_DRAGON_FRUIT_CAKE.get())));
	public static final RegistryObject<Block> GREEN_CANDLE_PINK_DRAGON_FRUIT_CAKE = registerBlockNoItem("green_candle_pink_dragon_fruit_cake", () -> new EffectCandleCakeBlock(CRBlocks.PINK_DRAGON_FRUIT_CAKE.get(), Blocks.GREEN_CANDLE, copy(CANDLE_PINK_DRAGON_FRUIT_CAKE.get())));
	public static final RegistryObject<Block> RED_CANDLE_PINK_DRAGON_FRUIT_CAKE = registerBlockNoItem("red_candle_pink_dragon_fruit_cake", () -> new EffectCandleCakeBlock(CRBlocks.PINK_DRAGON_FRUIT_CAKE.get(), Blocks.RED_CANDLE, copy(CANDLE_PINK_DRAGON_FRUIT_CAKE.get())));
	public static final RegistryObject<Block> BLACK_CANDLE_PINK_DRAGON_FRUIT_CAKE = registerBlockNoItem("black_candle_pink_dragon_fruit_cake", () -> new EffectCandleCakeBlock(CRBlocks.PINK_DRAGON_FRUIT_CAKE.get(), Blocks.BLACK_CANDLE, copy(CANDLE_PINK_DRAGON_FRUIT_CAKE.get())));
	public static final RegistryObject<Block> LUCUMA_CAKE = registerBlockNoItem("lucuma_cake", () -> new EffectCakeBlock(copy(Blocks.CAKE), CRItems.LUCUMA_CAKE_SLICE));
	public static final RegistryObject<Block> CANDLE_LUCUMA_CAKE = registerBlockNoItem("candle_lucuma_cake", () -> new EffectCandleCakeBlock(CRBlocks.LUCUMA_CAKE.get(), Blocks.CANDLE, copy(Blocks.CAKE).lightLevel(litBlockEmission(3))));
	public static final RegistryObject<Block> WHITE_CANDLE_LUCUMA_CAKE = registerBlockNoItem("white_candle_lucuma_cake", () -> new EffectCandleCakeBlock(CRBlocks.LUCUMA_CAKE.get(), Blocks.WHITE_CANDLE, copy(CANDLE_LUCUMA_CAKE.get())));
	public static final RegistryObject<Block> ORANGE_CANDLE_LUCUMA_CAKE = registerBlockNoItem("orange_candle_lucuma_cake", () -> new EffectCandleCakeBlock(CRBlocks.LUCUMA_CAKE.get(), Blocks.ORANGE_CANDLE, copy(CANDLE_LUCUMA_CAKE.get())));
	public static final RegistryObject<Block> MAGENTA_CANDLE_LUCUMA_CAKE = registerBlockNoItem("magenta_candle_lucuma_cake", () -> new EffectCandleCakeBlock(CRBlocks.LUCUMA_CAKE.get(), Blocks.MAGENTA_CANDLE, copy(CANDLE_LUCUMA_CAKE.get())));
	public static final RegistryObject<Block> LIGHT_BLUE_CANDLE_LUCUMA_CAKE = registerBlockNoItem("light_blue_candle_lucuma_cake", () -> new EffectCandleCakeBlock(CRBlocks.LUCUMA_CAKE.get(), Blocks.LIGHT_BLUE_CANDLE, copy(CANDLE_LUCUMA_CAKE.get())));
	public static final RegistryObject<Block> YELLOW_CANDLE_LUCUMA_CAKE = registerBlockNoItem("yellow_candle_lucuma_cake", () -> new EffectCandleCakeBlock(CRBlocks.LUCUMA_CAKE.get(), Blocks.YELLOW_CANDLE, copy(CANDLE_LUCUMA_CAKE.get())));
	public static final RegistryObject<Block> LIME_CANDLE_LUCUMA_CAKE = registerBlockNoItem("lime_candle_lucuma_cake", () -> new EffectCandleCakeBlock(CRBlocks.LUCUMA_CAKE.get(), Blocks.LIME_CANDLE, copy(CANDLE_LUCUMA_CAKE.get())));
	public static final RegistryObject<Block> PINK_CANDLE_LUCUMA_CAKE = registerBlockNoItem("pink_candle_lucuma_cake", () -> new EffectCandleCakeBlock(CRBlocks.LUCUMA_CAKE.get(), Blocks.PINK_CANDLE, copy(CANDLE_LUCUMA_CAKE.get())));
	public static final RegistryObject<Block> GRAY_CANDLE_LUCUMA_CAKE = registerBlockNoItem("gray_candle_lucuma_cake", () -> new EffectCandleCakeBlock(CRBlocks.LUCUMA_CAKE.get(), Blocks.GRAY_CANDLE, copy(CANDLE_LUCUMA_CAKE.get())));
	public static final RegistryObject<Block> LIGHT_GRAY_CANDLE_LUCUMA_CAKE = registerBlockNoItem("light_gray_candle_lucuma_cake", () -> new EffectCandleCakeBlock(CRBlocks.LUCUMA_CAKE.get(), Blocks.LIGHT_GRAY_CANDLE, copy(CANDLE_LUCUMA_CAKE.get())));
	public static final RegistryObject<Block> CYAN_CANDLE_LUCUMA_CAKE = registerBlockNoItem("cyan_candle_lucuma_cake", () -> new EffectCandleCakeBlock(CRBlocks.LUCUMA_CAKE.get(), Blocks.CYAN_CANDLE, copy(CANDLE_LUCUMA_CAKE.get())));
	public static final RegistryObject<Block> PURPLE_CANDLE_LUCUMA_CAKE = registerBlockNoItem("purple_candle_lucuma_cake", () -> new EffectCandleCakeBlock(CRBlocks.LUCUMA_CAKE.get(), Blocks.PURPLE_CANDLE, copy(CANDLE_LUCUMA_CAKE.get())));
	public static final RegistryObject<Block> BLUE_CANDLE_LUCUMA_CAKE = registerBlockNoItem("blue_candle_lucuma_cake", () -> new EffectCandleCakeBlock(CRBlocks.LUCUMA_CAKE.get(), Blocks.BLUE_CANDLE, copy(CANDLE_LUCUMA_CAKE.get())));
	public static final RegistryObject<Block> BROWN_CANDLE_LUCUMA_CAKE = registerBlockNoItem("brown_candle_lucuma_cake", () -> new EffectCandleCakeBlock(CRBlocks.LUCUMA_CAKE.get(), Blocks.BROWN_CANDLE, copy(CANDLE_LUCUMA_CAKE.get())));
	public static final RegistryObject<Block> GREEN_CANDLE_LUCUMA_CAKE = registerBlockNoItem("green_candle_lucuma_cake", () -> new EffectCandleCakeBlock(CRBlocks.LUCUMA_CAKE.get(), Blocks.GREEN_CANDLE, copy(CANDLE_LUCUMA_CAKE.get())));
	public static final RegistryObject<Block> RED_CANDLE_LUCUMA_CAKE = registerBlockNoItem("red_candle_lucuma_cake", () -> new EffectCandleCakeBlock(CRBlocks.LUCUMA_CAKE.get(), Blocks.RED_CANDLE, copy(CANDLE_LUCUMA_CAKE.get())));
	public static final RegistryObject<Block> BLACK_CANDLE_LUCUMA_CAKE = registerBlockNoItem("black_candle_lucuma_cake", () -> new EffectCandleCakeBlock(CRBlocks.LUCUMA_CAKE.get(), Blocks.BLACK_CANDLE, copy(CANDLE_LUCUMA_CAKE.get())));

	// Milkshake Cauldrons
	public static final RegistryObject<Block> LIME_MILKSHAKE_CAULDRON = registerBlockNoItem("lime_milkshake_cauldron",
		() -> new CRMilkshakeCauldronBlock(
			Modid.N.loaded() ?
			CRCauldronInteractions.LIME_MILKSHAKE.map() :
			CauldronInteraction.newInteractionMap())
	);
	public static final RegistryObject<Block> POMEGRANATE_MILKSHAKE_CAULDRON = registerBlockNoItem("pomegranate_milkshake_cauldron",
		() -> new CRMilkshakeCauldronBlock(
			Modid.N.loaded() ?
			CRCauldronInteractions.POMEGRANATE_MILKSHAKE.map() :
			CauldronInteraction.newInteractionMap())
	);
	public static final RegistryObject<Block> PINK_DRAGON_FRUIT_MILKSHAKE_CAULDRON = registerBlockNoItem("pink_dragon_fruit_milkshake_cauldron",
		() -> new CRMilkshakeCauldronBlock(
			Modid.N.loaded() ?
			CRCauldronInteractions.PINK_DRAGON_FRUIT_MILKSHAKE.map() :
			CauldronInteraction.newInteractionMap())
	);
	public static final RegistryObject<Block> LUCUMA_MILKSHAKE_CAULDRON = registerBlockNoItem("lucuma_milkshake_cauldron",
		() -> new CRMilkshakeCauldronBlock(
			Modid.N.loaded() ?
			CRCauldronInteractions.LUCUMA_MILKSHAKE.map() :
			CauldronInteraction.newInteractionMap())
	);

	// Let Fish Love
	public static final RegistryObject<Block> PLATINUM_BASS_ROE = registerBlockNoItem("platinum_bass_roe_block", () ->
		Modid.LFL.loaded() ?
		LetFishLoveCompat.platinumBassRoeBlock() :
		new Block(BlockBehaviour.Properties.of())
	);
	public static final RegistryObject<Block> TIGER_PRAWN_ROE = registerBlockNoItem("tiger_prawn_roe_block", () ->
		Modid.LFL.loaded() ?
		LetFishLoveCompat.tigerPrawnRoeBlock() :
		new Block(BlockBehaviour.Properties.of())
	);

	public static RegistryObject<Block> registerBlock(String name, Supplier<Block> block) {
		return HELPER.createBlock(name, block);
	}

	public static RegistryObject<Block> registerBlockNoItem(String name, Supplier<Block> block) {
		return HELPER.createBlockNoItem(name, block);
	}

	private static BlockBehaviour.Properties copy(Supplier<Block> block) {
		return copy(block.get());
	}

	private static BlockBehaviour.Properties copy(Block block) {
		return BlockBehaviour.Properties.copy(block);
	}

	private static boolean always(BlockState a, BlockGetter b, BlockPos c) {
		return true;
	}

	private static ToIntFunction<BlockState> litBlockEmission(int lightValue) {
		return (state) -> state.getValue(BlockStateProperties.LIT) ? lightValue : 0;
	}

	public static class Properties {
		public static final BlockSetType LUCUMA_BLOCK_SET = BlockSetTypeRegistryHelper.register(new BlockSetType(CollectorsReap.MODID + ":lucuma"));

		public static final WoodType LUCUMA_WOOD_TYPE = WoodTypeRegistryHelper.registerWoodType(new WoodType(CollectorsReap.MODID + ":lucuma", LUCUMA_BLOCK_SET));

		public static final PropertyUtil.WoodSetProperties LUCUMA = PropertyUtil.WoodSetProperties.builder(MapColor.TERRACOTTA_BROWN, MapColor.WOOD).build();

		public static final BlockBehaviour.Properties URCHIN_TEST = BlockBehaviour.Properties.of().sound(SoundType.GILDED_BLACKSTONE).mapColor(MapColor.TERRACOTTA_WHITE);
	}
}
package net.brdle.collectorsreap.data.gen;

import com.mojang.datafixers.util.Pair;
import com.teamabnormals.blueprint.common.block.sign.BlueprintStandingSignBlock;
import com.teamabnormals.blueprint.common.block.sign.BlueprintWallSignBlock;
import com.teamabnormals.blueprint.core.data.client.BlueprintBlockStateProvider;
import net.brdle.collectorsreap.CollectorsReap;
import net.brdle.collectorsreap.Util;
import net.brdle.collectorsreap.common.block.BuddingDragonFruitBlock;
import net.brdle.collectorsreap.common.block.CRBlocks;
import net.brdle.collectorsreap.common.block.PortobelloColonyBlock;
import net.brdle.collectorsreap.compat.Modid;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.FarmersDelight;
import vectorwing.farmersdelight.common.block.PieBlock;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import org.jetbrains.annotations.Nullable;

public class CRBlockModelProvider extends BlueprintBlockStateProvider {
	public CRBlockModelProvider(final PackOutput output, final ExistingFileHelper helper) {
		super(output, CollectorsReap.MODID, helper);
	}

	@Override
	protected void registerStatesAndModels() {
		this.pieBlock(CRBlocks.PORTOBELLO_QUICHE);
		this.pieBlock(CRBlocks.LIME_PIE);
		this.stageBlock(CRBlocks.PORTOBELLO_COLONY.get(), PortobelloColonyBlock.COLONY_AGE);
		this.cross(CRBlocks.PORTOBELLO.get());
		this.cross(CRBlocks.DRAGON_BUSH.get());
		this.crateBlock(CRBlocks.LIME_CRATE.get(), "lime", false);
		this.crateBlock(CRBlocks.POMEGRANATE_CRATE.get(), "pomegranate", true);
		this.crateBlock(CRBlocks.STYGIAN_POMEGRANATE_CRATE.get(), "stygian_pomegranate", true);
		this.crateBlock(CRBlocks.PINK_DRAGON_FRUIT_CRATE.get(), "pink_dragon_fruit", false);
		this.crateBlock(CRBlocks.LUCUMA_CRATE.get(), "lucuma", true);
		this.crateBlock(CRBlocks.GILDED_LUCUMA_CRATE.get(), "gilded_lucuma", true);
		this.customStageBlock(CRBlocks.BUDDING_PINK_DRAGON_FRUIT_CROP.get(), Util.rl(FarmersDelight.MODID, "crop_cross"), "cross", BuddingDragonFruitBlock.AGE, Arrays.asList(0, 1, 2, 3, 3));
		this.cakeBlock(CRBlocks.LIME_CAKE);
		this.candleCakeBlock(CRBlocks.CANDLE_LIME_CAKE, CRBlocks.LIME_CAKE);
		this.candleCakeBlock(CRBlocks.WHITE_CANDLE_LIME_CAKE, CRBlocks.LIME_CAKE);
		this.candleCakeBlock(CRBlocks.ORANGE_CANDLE_LIME_CAKE, CRBlocks.LIME_CAKE);
		this.candleCakeBlock(CRBlocks.MAGENTA_CANDLE_LIME_CAKE, CRBlocks.LIME_CAKE);
		this.candleCakeBlock(CRBlocks.LIGHT_BLUE_CANDLE_LIME_CAKE, CRBlocks.LIME_CAKE);
		this.candleCakeBlock(CRBlocks.YELLOW_CANDLE_LIME_CAKE, CRBlocks.LIME_CAKE);
		this.candleCakeBlock(CRBlocks.LIME_CANDLE_LIME_CAKE, CRBlocks.LIME_CAKE);
		this.candleCakeBlock(CRBlocks.PINK_CANDLE_LIME_CAKE, CRBlocks.LIME_CAKE);
		this.candleCakeBlock(CRBlocks.GRAY_CANDLE_LIME_CAKE, CRBlocks.LIME_CAKE);
		this.candleCakeBlock(CRBlocks.LIGHT_GRAY_CANDLE_LIME_CAKE, CRBlocks.LIME_CAKE);
		this.candleCakeBlock(CRBlocks.CYAN_CANDLE_LIME_CAKE, CRBlocks.LIME_CAKE);
		this.candleCakeBlock(CRBlocks.PURPLE_CANDLE_LIME_CAKE, CRBlocks.LIME_CAKE);
		this.candleCakeBlock(CRBlocks.BLUE_CANDLE_LIME_CAKE, CRBlocks.LIME_CAKE);
		this.candleCakeBlock(CRBlocks.BROWN_CANDLE_LIME_CAKE, CRBlocks.LIME_CAKE);
		this.candleCakeBlock(CRBlocks.GREEN_CANDLE_LIME_CAKE, CRBlocks.LIME_CAKE);
		this.candleCakeBlock(CRBlocks.RED_CANDLE_LIME_CAKE, CRBlocks.LIME_CAKE);
		this.candleCakeBlock(CRBlocks.BLACK_CANDLE_LIME_CAKE, CRBlocks.LIME_CAKE);
		this.cakeBlock(CRBlocks.POMEGRANATE_CAKE);
		this.candleCakeBlock(CRBlocks.CANDLE_POMEGRANATE_CAKE, CRBlocks.POMEGRANATE_CAKE);
		this.candleCakeBlock(CRBlocks.WHITE_CANDLE_POMEGRANATE_CAKE, CRBlocks.POMEGRANATE_CAKE);
		this.candleCakeBlock(CRBlocks.ORANGE_CANDLE_POMEGRANATE_CAKE, CRBlocks.POMEGRANATE_CAKE);
		this.candleCakeBlock(CRBlocks.MAGENTA_CANDLE_POMEGRANATE_CAKE, CRBlocks.POMEGRANATE_CAKE);
		this.candleCakeBlock(CRBlocks.LIGHT_BLUE_CANDLE_POMEGRANATE_CAKE, CRBlocks.POMEGRANATE_CAKE);
		this.candleCakeBlock(CRBlocks.YELLOW_CANDLE_POMEGRANATE_CAKE, CRBlocks.POMEGRANATE_CAKE);
		this.candleCakeBlock(CRBlocks.LIME_CANDLE_POMEGRANATE_CAKE, CRBlocks.POMEGRANATE_CAKE);
		this.candleCakeBlock(CRBlocks.PINK_CANDLE_POMEGRANATE_CAKE, CRBlocks.POMEGRANATE_CAKE);
		this.candleCakeBlock(CRBlocks.GRAY_CANDLE_POMEGRANATE_CAKE, CRBlocks.POMEGRANATE_CAKE);
		this.candleCakeBlock(CRBlocks.LIGHT_GRAY_CANDLE_POMEGRANATE_CAKE, CRBlocks.POMEGRANATE_CAKE);
		this.candleCakeBlock(CRBlocks.CYAN_CANDLE_POMEGRANATE_CAKE, CRBlocks.POMEGRANATE_CAKE);
		this.candleCakeBlock(CRBlocks.PURPLE_CANDLE_POMEGRANATE_CAKE, CRBlocks.POMEGRANATE_CAKE);
		this.candleCakeBlock(CRBlocks.BLUE_CANDLE_POMEGRANATE_CAKE, CRBlocks.POMEGRANATE_CAKE);
		this.candleCakeBlock(CRBlocks.BROWN_CANDLE_POMEGRANATE_CAKE, CRBlocks.POMEGRANATE_CAKE);
		this.candleCakeBlock(CRBlocks.GREEN_CANDLE_POMEGRANATE_CAKE, CRBlocks.POMEGRANATE_CAKE);
		this.candleCakeBlock(CRBlocks.RED_CANDLE_POMEGRANATE_CAKE, CRBlocks.POMEGRANATE_CAKE);
		this.candleCakeBlock(CRBlocks.BLACK_CANDLE_POMEGRANATE_CAKE, CRBlocks.POMEGRANATE_CAKE);
		this.cakeBlock(CRBlocks.PINK_DRAGON_FRUIT_CAKE);
		this.candleCakeBlock(CRBlocks.CANDLE_PINK_DRAGON_FRUIT_CAKE, CRBlocks.PINK_DRAGON_FRUIT_CAKE);
		this.candleCakeBlock(CRBlocks.WHITE_CANDLE_PINK_DRAGON_FRUIT_CAKE, CRBlocks.PINK_DRAGON_FRUIT_CAKE);
		this.candleCakeBlock(CRBlocks.ORANGE_CANDLE_PINK_DRAGON_FRUIT_CAKE, CRBlocks.PINK_DRAGON_FRUIT_CAKE);
		this.candleCakeBlock(CRBlocks.MAGENTA_CANDLE_PINK_DRAGON_FRUIT_CAKE, CRBlocks.PINK_DRAGON_FRUIT_CAKE);
		this.candleCakeBlock(CRBlocks.LIGHT_BLUE_CANDLE_PINK_DRAGON_FRUIT_CAKE, CRBlocks.PINK_DRAGON_FRUIT_CAKE);
		this.candleCakeBlock(CRBlocks.YELLOW_CANDLE_PINK_DRAGON_FRUIT_CAKE, CRBlocks.PINK_DRAGON_FRUIT_CAKE);
		this.candleCakeBlock(CRBlocks.LIME_CANDLE_PINK_DRAGON_FRUIT_CAKE, CRBlocks.PINK_DRAGON_FRUIT_CAKE);
		this.candleCakeBlock(CRBlocks.PINK_CANDLE_PINK_DRAGON_FRUIT_CAKE, CRBlocks.PINK_DRAGON_FRUIT_CAKE);
		this.candleCakeBlock(CRBlocks.GRAY_CANDLE_PINK_DRAGON_FRUIT_CAKE, CRBlocks.PINK_DRAGON_FRUIT_CAKE);
		this.candleCakeBlock(CRBlocks.LIGHT_GRAY_CANDLE_PINK_DRAGON_FRUIT_CAKE, CRBlocks.PINK_DRAGON_FRUIT_CAKE);
		this.candleCakeBlock(CRBlocks.CYAN_CANDLE_PINK_DRAGON_FRUIT_CAKE, CRBlocks.PINK_DRAGON_FRUIT_CAKE);
		this.candleCakeBlock(CRBlocks.PURPLE_CANDLE_PINK_DRAGON_FRUIT_CAKE, CRBlocks.PINK_DRAGON_FRUIT_CAKE);
		this.candleCakeBlock(CRBlocks.BLUE_CANDLE_PINK_DRAGON_FRUIT_CAKE, CRBlocks.PINK_DRAGON_FRUIT_CAKE);
		this.candleCakeBlock(CRBlocks.BROWN_CANDLE_PINK_DRAGON_FRUIT_CAKE, CRBlocks.PINK_DRAGON_FRUIT_CAKE);
		this.candleCakeBlock(CRBlocks.GREEN_CANDLE_PINK_DRAGON_FRUIT_CAKE, CRBlocks.PINK_DRAGON_FRUIT_CAKE);
		this.candleCakeBlock(CRBlocks.RED_CANDLE_PINK_DRAGON_FRUIT_CAKE, CRBlocks.PINK_DRAGON_FRUIT_CAKE);
		this.candleCakeBlock(CRBlocks.BLACK_CANDLE_PINK_DRAGON_FRUIT_CAKE, CRBlocks.PINK_DRAGON_FRUIT_CAKE);
		this.cakeBlock(CRBlocks.LUCUMA_CAKE);
		this.candleCakeBlock(CRBlocks.CANDLE_LUCUMA_CAKE, CRBlocks.LUCUMA_CAKE);
		this.candleCakeBlock(CRBlocks.WHITE_CANDLE_LUCUMA_CAKE, CRBlocks.LUCUMA_CAKE);
		this.candleCakeBlock(CRBlocks.ORANGE_CANDLE_LUCUMA_CAKE, CRBlocks.LUCUMA_CAKE);
		this.candleCakeBlock(CRBlocks.MAGENTA_CANDLE_LUCUMA_CAKE, CRBlocks.LUCUMA_CAKE);
		this.candleCakeBlock(CRBlocks.LIGHT_BLUE_CANDLE_LUCUMA_CAKE, CRBlocks.LUCUMA_CAKE);
		this.candleCakeBlock(CRBlocks.YELLOW_CANDLE_LUCUMA_CAKE, CRBlocks.LUCUMA_CAKE);
		this.candleCakeBlock(CRBlocks.LIME_CANDLE_LUCUMA_CAKE, CRBlocks.LUCUMA_CAKE);
		this.candleCakeBlock(CRBlocks.PINK_CANDLE_LUCUMA_CAKE, CRBlocks.LUCUMA_CAKE);
		this.candleCakeBlock(CRBlocks.GRAY_CANDLE_LUCUMA_CAKE, CRBlocks.LUCUMA_CAKE);
		this.candleCakeBlock(CRBlocks.LIGHT_GRAY_CANDLE_LUCUMA_CAKE, CRBlocks.LUCUMA_CAKE);
		this.candleCakeBlock(CRBlocks.CYAN_CANDLE_LUCUMA_CAKE, CRBlocks.LUCUMA_CAKE);
		this.candleCakeBlock(CRBlocks.PURPLE_CANDLE_LUCUMA_CAKE, CRBlocks.LUCUMA_CAKE);
		this.candleCakeBlock(CRBlocks.BLUE_CANDLE_LUCUMA_CAKE, CRBlocks.LUCUMA_CAKE);
		this.candleCakeBlock(CRBlocks.BROWN_CANDLE_LUCUMA_CAKE, CRBlocks.LUCUMA_CAKE);
		this.candleCakeBlock(CRBlocks.GREEN_CANDLE_LUCUMA_CAKE, CRBlocks.LUCUMA_CAKE);
		this.candleCakeBlock(CRBlocks.RED_CANDLE_LUCUMA_CAKE, CRBlocks.LUCUMA_CAKE);
		this.candleCakeBlock(CRBlocks.BLACK_CANDLE_LUCUMA_CAKE, CRBlocks.LUCUMA_CAKE);
		this.simpleBlock(CRBlocks.LIME_ICE_CREAM_BLOCK.get());
		this.simpleBlock(CRBlocks.POMEGRANATE_ICE_CREAM_BLOCK.get());
		this.simpleBlock(CRBlocks.PINK_DRAGON_FRUIT_ICE_CREAM_BLOCK.get());
		this.simpleBlock(CRBlocks.LUCUMA_ICE_CREAM_BLOCK.get());

		// Urchin Test
		this.simpleBlock(CRBlocks.URCHIN_TEST_BLOCK.get(), this.models().cubeBottomTop(
			"urchin_test_block",
			resourceBlock("urchin_test_block_side"),
			resourceBlock("urchin_test_block_bottom"),
			resourceBlock("urchin_test_block_top")
		));
		this.simpleBlock(CRBlocks.URCHIN_TEST_BRICKS.get());
		this.slab(CRBlocks.URCHIN_TEST_BRICK_SLAB, this.blockTexture(CRBlocks.URCHIN_TEST_BRICKS.get()));
		this.stairs(CRBlocks.URCHIN_TEST_BRICK_STAIRS, this.blockTexture(CRBlocks.URCHIN_TEST_BRICKS.get()));
		this.wall(CRBlocks.URCHIN_TEST_BRICK_WALL, this.blockTexture(CRBlocks.URCHIN_TEST_BRICKS.get()));
		this.simpleBlock(CRBlocks.URCHIN_TEST_TILES.get());
		this.slab(CRBlocks.URCHIN_TEST_TILE_SLAB, this.blockTexture(CRBlocks.URCHIN_TEST_TILES.get()));
		this.stairs(CRBlocks.URCHIN_TEST_TILE_STAIRS, this.blockTexture(CRBlocks.URCHIN_TEST_TILES.get()));
		this.wall(CRBlocks.URCHIN_TEST_TILE_WALL, this.blockTexture(CRBlocks.URCHIN_TEST_TILES.get()));
		this.simpleBlock(CRBlocks.CHISELED_URCHIN_TEST_BRICKS.get());

		// Lucuma
		this.pillar(CRBlocks.STRIPPED_LUCUMA_LOG);
		this.wood(CRBlocks.STRIPPED_LUCUMA_WOOD, this.blockTexture(CRBlocks.STRIPPED_LUCUMA_LOG.get()));
		this.pillar(CRBlocks.LUCUMA_LOG);
		this.wood(CRBlocks.LUCUMA_WOOD, this.blockTexture(CRBlocks.LUCUMA_LOG.get()));
		this.simpleBlock(CRBlocks.LUCUMA_PLANKS.get());
		this.slab(CRBlocks.LUCUMA_SLAB, this.blockTexture(CRBlocks.LUCUMA_PLANKS.get()));
		this.stairs(CRBlocks.LUCUMA_STAIRS, this.blockTexture(CRBlocks.LUCUMA_PLANKS.get()));
		this.fence(CRBlocks.LUCUMA_FENCE, this.blockTexture(CRBlocks.LUCUMA_PLANKS.get()));
		this.fenceGate(CRBlocks.LUCUMA_FENCE_GATE, this.blockTexture(CRBlocks.LUCUMA_PLANKS.get()));
		this.doorCutout(CRBlocks.LUCUMA_DOOR);
		this.trapdoorCutout(CRBlocks.LUCUMA_TRAPDOOR);
		this.pressurePlate(CRBlocks.LUCUMA_PRESSURE_PLATE, this.blockTexture(CRBlocks.LUCUMA_PLANKS.get()));
		this.button(CRBlocks.LUCUMA_BUTTON, this.blockTexture(CRBlocks.LUCUMA_PLANKS.get()));
		this.signs(CRBlocks.LUCUMA_SIGNS, CRBlocks.LUCUMA_PLANKS);
		this.hangingSignBlocks(CRBlocks.STRIPPED_LUCUMA_LOG, CRBlocks.LUCUMA_HANGING_SIGNS);

		// Roe
		this.roeBlock(CRBlocks.PLATINUM_BASS_ROE.get());
		this.roeBlock(CRBlocks.TIGER_PRAWN_ROE.get());
	}

	private void stairs(RegistryObject<Block> stairs, ResourceLocation texture) {
		this.stairsBlock((StairBlock) stairs.get(), texture);
	}

	private void slab(RegistryObject<Block> slab, ResourceLocation texture) {
		this.slabBlock((SlabBlock) slab.get(), texture, texture);
	}

	private void wall(RegistryObject<Block> wall, ResourceLocation texture) {
		this.wallBlock((WallBlock) wall.get(), texture);
	}

	private void wood(RegistryObject<Block> log, ResourceLocation texture) {
		this.axisBlock((RotatedPillarBlock) log.get(), texture, texture);
	}

	private void pillar(RegistryObject<Block> pillar) {
		this.axisBlock((RotatedPillarBlock) pillar.get(), this.blockTexture(pillar.get()), this.modLoc("block/" + Util.name(pillar) + "_top"));
	}

	private void fence(RegistryObject<Block> fence, ResourceLocation texture) {
		this.fenceBlock((FenceBlock) fence.get(), texture);
	}

	private void fenceGate(RegistryObject<Block> gate, ResourceLocation texture) {
		this.fenceGateBlock((FenceGateBlock) gate.get(), texture);
	}

	private void door(RegistryObject<Block> door) {
		String name = Util.name(door);
		this.doorBlock((DoorBlock) door.get(), name.replace("_door", ""), this.modLoc("block/" + name + "_bottom"), this.modLoc("block/" + name + "_top"));
	}

	private void doorCutout(RegistryObject<Block> door) {
		String name = Util.name(door);
		this.doorBlockWithRenderType((DoorBlock) door.get(), name.replace("_door", ""), this.modLoc("block/" + name + "_bottom"), this.modLoc("block/" + name + "_top"), "cutout");
	}

	private void trapdoor(RegistryObject<Block> trapdoor) {
		this.trapdoorBlock((TrapDoorBlock) trapdoor.get(), this.blockTexture(trapdoor.get()), true);
	}

	private void trapdoorCutout(RegistryObject<Block> trapdoor) {
		this.trapdoorBlockWithRenderType((TrapDoorBlock) trapdoor.get(), this.blockTexture(trapdoor.get()), true, "cutout");
	}

	private void pressurePlate(RegistryObject<Block> pressurePlate, ResourceLocation texture) {
		this.pressurePlateBlock((PressurePlateBlock) pressurePlate.get(), texture);
	}

	private void button(RegistryObject<Block> button, ResourceLocation texture) {
		this.buttonBlock((ButtonBlock) button.get(), texture);
	}

	private void signs(Pair<RegistryObject<BlueprintStandingSignBlock>, RegistryObject<BlueprintWallSignBlock>> signs, Supplier<Block> planks) {
		this.signBlock(signs.getFirst().get(), signs.getSecond().get(), this.blockTexture(planks.get()));
	}

	private void crateBlock(Block block, String cropName, boolean customBottom) {
		this.simpleBlock(block, models().cubeBottomTop(
			Util.name(block),
			resourceBlock(cropName + "_crate_side"),
				customBottom ?
				resourceBlock(cropName + "_crate_bottom") :
				Util.rl(FarmersDelight.MODID, "block/crate_bottom"),
			resourceBlock(cropName + "_crate_top")
		));
	}

	private ModelFile existingModel(String path) {
		return new ModelFile.ExistingModelFile(resourceBlock(path), models().existingFileHelper);
	}

	private void cross(Block block) {
		this.simpleBlock(block, models().cross("block/" + Util.name(block),
			CRBlockModelProvider.resourceBlock(Util.name(block))).renderType("cutout"));
	}
	// Adapted from: https://github.com/vectorwing/FarmersDelight/blob/1.20/src/main/java/vectorwing/farmersdelight/data/BlockStates.java
	public void customStageBlock(Block block, @Nullable ResourceLocation parent, String textureKey, IntegerProperty ageProperty, List<Integer> suffixes, Property<?>... ignored) {
		getVariantBuilder(block)
			.forAllStatesExcept(state -> {
				int ageSuffix = state.getValue(ageProperty);
				String stageName = Util.name(block) + "_stage";
				stageName += suffixes.isEmpty() ? ageSuffix : suffixes.get(Math.min(suffixes.size(), ageSuffix));
				if (parent == null) {
					return ConfiguredModel.builder()
						.modelFile(models().cross(stageName, resourceBlock(stageName)).renderType("cutout")).build();
				}
				return ConfiguredModel.builder()
					.modelFile(models().singleTexture(stageName, parent, textureKey, resourceBlock(stageName)).renderType("cutout")).build();
			}, ignored);
	}

	// Adapted from: https://github.com/vectorwing/FarmersDelight/blob/1.19/src/main/java/vectorwing/farmersdelight/data/BlockStates.java
	private void stageBlock(Block block, IntegerProperty ageProperty, Property<?>... ignored) {
		getVariantBuilder(block).forAllStatesExcept(state -> {
			String stageName = Util.name(block) + "_stage" + state.getValue(ageProperty);
			return ConfiguredModel.builder()
				.modelFile(models().cross(stageName, resourceBlock(stageName)).renderType("cutout")).build();
		}, ignored);
	}

	private void upperLowerStageBlock(Block block, IntegerProperty ageProperty, EnumProperty<DoubleBlockHalf> halfProperty, Property<?> ignored) {
		getVariantBuilder(block).forAllStatesExcept(state -> {
			String name = Util.name(block) + "_" + state.getValue(halfProperty).getSerializedName();
			var mod = models()
				.withExistingParent("block/" + name + "_stage" + state.getValue(ageProperty), Util.cr(name))
				.texture("side", resourceBlock(Util.name(block) + "_side_stage" + state.getValue(ageProperty)))
				.texture("plant", resourceBlock(Util.name(block) + "_plant_" + state.getValue(halfProperty).getSerializedName() + "_stage" + state.getValue(ageProperty)))
				.texture("particle", resourceBlock(Util.name(block) + "_plant_" + state.getValue(halfProperty).getSerializedName() + "_stage" + state.getValue(ageProperty)));
			if (state.getValue(halfProperty) == DoubleBlockHalf.UPPER) {
				mod.texture("top", resourceBlock(Util.name(block) + "_top_stage" + state.getValue(ageProperty)));
			}
			return ConfiguredModel.builder().modelFile(mod).build();
		}, ignored);
	}

	private void pomegranateBushBlock(Block block, IntegerProperty ageProperty, EnumProperty<DoubleBlockHalf> halfProperty) {
		getVariantBuilder(block).forAllStates(state -> {
			String halfStageName = Util.name(block) + "_" + state.getValue(halfProperty).getSerializedName() + "_stage" + state.getValue(ageProperty);
			String name = Util.name(block) + "_stage" + state.getValue(ageProperty);
			return ConfiguredModel.builder()
				.modelFile(models()
					.withExistingParent("block/" + halfStageName,
						Util.cr(Util.name(block) + "_" + state.getValue(halfProperty).getSerializedName()))
					.texture("0", resourceBlock(name))).build();
		});
	}

	// Adapted from: https://github.com/vectorwing/FarmersDelight/blob/1.19/src/main/java/vectorwing/farmersdelight/data/BlockStates.java
	private void pieBlock(RegistryObject<Block> block) {
		getVariantBuilder(block.get()).forAllStates(state -> {
				int bites = state.getValue(PieBlock.BITES);
				String name = Util.name(block);
				String suffix = bites > 0 ? "_slice" + bites : "";
				var mod = models()
					.withExistingParent("block/" + name + suffix, Util.rl(FarmersDelight.MODID, "pie" + suffix))
					.texture("top", resourceBlock(name + "_top"))
					.texture("bottom", resourceBlock(name + "_bottom"))
					.texture("side", resourceBlock(name + "_side"))
					.texture("particle", resourceBlock(name + "_top"));
				if (bites > 0) {
					mod.texture("inner", resourceBlock(name + "_inner"));
				}
				return ConfiguredModel.builder().modelFile(mod)
					.rotationY(((int) state.getValue(PieBlock.FACING).toYRot() + 180) % 360).build();
			}
		);
	}

	private void cakeBlock(RegistryObject<Block> block) {
		getVariantBuilder(block.get()).forAllStates(state -> {
				int bites = state.getValue(CakeBlock.BITES);
				String name = Util.name(block);
				String suffix = bites > 0 ? "_slice" + bites : "";
				var mod = models()
					.withExistingParent("block/" + name + suffix, Util.rl("minecraft", "cake" + suffix))
					.texture("top", resourceBlock(name + "_top"))
					.texture("bottom", resourceBlock(name + "_bottom"))
					.texture("side", resourceBlock(name + "_side"))
					.texture("particle", resourceBlock(name + "_side"));
				if (bites > 0) {
					mod.texture("inside", resourceBlock(name + "_inner"));
				}
				return ConfiguredModel.builder().modelFile(mod).build();
			}
		);
	}

	private void candleCakeBlock(RegistryObject<Block> block, RegistryObject<Block> cake) {
		getVariantBuilder(block.get()).forAllStates(state -> {
			String lit = state.getValue(AbstractCandleBlock.LIT) ? "_lit" : "";
			String name = Util.name(block);
			String cakeName = Util.name(cake);
			String candle = name.replace("_" + cakeName, "") + lit;
			return ConfiguredModel.builder().modelFile(models()
				.withExistingParent("block/" + name + lit, Modid.MC.rl("template_cake_with_candle"))
				.texture("bottom", resourceBlock(cakeName + "_bottom"))
				.texture("candle", vanillaBlock(candle))
				.texture("particle", resourceBlock(cakeName + "_side"))
				.texture("side", resourceBlock(cakeName + "_side"))
				.texture("top", resourceBlock(cakeName + "_top"))).build();
		});
	}

	private void roeBlock(Block block) {
		getVariantBuilder(block).forAllStates(state -> {
			String name = Util.name(block);
			return ConfiguredModel.builder().modelFile(models()
				.withExistingParent(name, vanillaBlock("frogspawn"))
				.texture("particle", resourceBlock(name))
				.texture("texture", resourceBlock(name))
				.renderType("translucent")
			).build();
		});
	}

	public static ResourceLocation resourceBlock(String path) {
		return Util.cr("block/" + path);
	}

	// Adapted from: https://github.com/vectorwing/FarmersDelight/blob/1.19/src/main/java/vectorwing/farmersdelight/data/BlockStates.java
	public static ResourceLocation vanillaBlock(String path) {
		return Modid.MC.rl("block/" + path);
	}
}
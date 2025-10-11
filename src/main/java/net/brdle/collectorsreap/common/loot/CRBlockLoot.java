package net.brdle.collectorsreap.common.loot;

import net.brdle.collectorsreap.common.block.CRBlocks;
import net.brdle.collectorsreap.common.block.LimeBushBlock;
import net.brdle.collectorsreap.common.block.PomegranateBushBlock;
import net.brdle.collectorsreap.common.item.CRItems;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.common.Tags;
import net.minecraftforge.registries.RegistryObject;
import java.util.Collections;
import org.jetbrains.annotations.NotNull;

public class CRBlockLoot extends BlockLootSubProvider {
	public CRBlockLoot() {
		super(Collections.emptySet(), FeatureFlags.REGISTRY.allFlags());
	}

	@Override
	protected void generate() {
		this.dropSelf(CRBlocks.PORTOBELLO.get());
		this.empty(CRBlocks.PORTOBELLO_QUICHE);
		this.empty(CRBlocks.LIME_PIE);
		// Lime Bush drops Seeds and optional Limes
		this.add(CRBlocks.LIME_BUSH.get(), (b) -> applyExplosionDecay(b,
			LootTable.lootTable()
				.withPool(this.applyExplosionCondition(CRItems.LIME_SEEDS.get(),
					LootPool.lootPool()
						.when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(b)
							.setProperties(StatePropertiesPredicate.Builder.properties()
								.hasProperty(LimeBushBlock.HALF, DoubleBlockHalf.LOWER)))
						.setRolls(ConstantValue.exactly(1F))
						.add(LootItem.lootTableItem(CRItems.LIME_SEEDS.get()))))
				.withPool(this.applyExplosionCondition(CRItems.LIME.get(),
					LootPool.lootPool()
						.when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(b)
							.setProperties(StatePropertiesPredicate.Builder.properties()
								.hasProperty(LimeBushBlock.AGE, LimeBushBlock.MAX_AGE)
								.hasProperty(LimeBushBlock.HALF, DoubleBlockHalf.LOWER)))
						.setRolls(ConstantValue.exactly(1F))
						.add(LootItem.lootTableItem(CRItems.LIME.get()))
						.apply(SetItemCountFunction.setCount(UniformGenerator.between(2F, 3F)))))));
		// Pomegranate Bush drops Seeds and optional Pomegranates
		this.add(CRBlocks.POMEGRANATE_BUSH.get(), (b) -> applyExplosionDecay(b,
			LootTable.lootTable()
				.withPool(this.applyExplosionCondition(CRItems.POMEGRANATE_SEEDS.get(),
					LootPool.lootPool()
						.when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(b)
							.setProperties(StatePropertiesPredicate.Builder.properties()
								.hasProperty(PomegranateBushBlock.HALF, DoubleBlockHalf.LOWER)))
						.setRolls(ConstantValue.exactly(1F))
						.add(LootItem.lootTableItem(CRItems.POMEGRANATE_SEEDS.get()))))
				.withPool(this.applyExplosionCondition(CRItems.POMEGRANATE.get(),
					LootPool.lootPool()
						.when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(b)
							.setProperties(StatePropertiesPredicate.Builder.properties()
								.hasProperty(PomegranateBushBlock.AGE, PomegranateBushBlock.MAX_AGE)
								.hasProperty(PomegranateBushBlock.HALF, DoubleBlockHalf.LOWER)))
						.setRolls(ConstantValue.exactly(1F))
						.add(LootItem.lootTableItem(CRItems.POMEGRANATE.get()))
						.apply(SetItemCountFunction.setCount(UniformGenerator.between(1F, 3F)))))));
		this.dropOther(CRBlocks.DRAGON_BUSH.get(), CRItems.DRAGON_FRUIT_SEEDS.get());
		this.dropOther(CRBlocks.BUDDING_PINK_DRAGON_FRUIT_CROP.get(), CRItems.DRAGON_FRUIT_SEEDS.get());
		this.dropSelf(CRBlocks.LIME_CRATE.get());
		this.dropSelf(CRBlocks.POMEGRANATE_CRATE.get());
		this.dropSelf(CRBlocks.STYGIAN_POMEGRANATE_CRATE.get());
		this.dropSelf(CRBlocks.PINK_DRAGON_FRUIT_CRATE.get());
		this.dropSelf(CRBlocks.LUCUMA_CRATE.get());
		this.dropSelf(CRBlocks.GILDED_LUCUMA_CRATE.get());
		this.empty(CRBlocks.LIME_CAKE);
		this.dropOther(CRBlocks.CANDLE_LIME_CAKE.get(), Blocks.CANDLE);
		this.dropOther(CRBlocks.WHITE_CANDLE_LIME_CAKE.get(), Blocks.WHITE_CANDLE);
		this.dropOther(CRBlocks.ORANGE_CANDLE_LIME_CAKE.get(), Blocks.ORANGE_CANDLE);
		this.dropOther(CRBlocks.MAGENTA_CANDLE_LIME_CAKE.get(), Blocks.MAGENTA_CANDLE);
		this.dropOther(CRBlocks.LIGHT_BLUE_CANDLE_LIME_CAKE.get(), Blocks.LIGHT_BLUE_CANDLE);
		this.dropOther(CRBlocks.YELLOW_CANDLE_LIME_CAKE.get(), Blocks.YELLOW_CANDLE);
		this.dropOther(CRBlocks.LIME_CANDLE_LIME_CAKE.get(), Blocks.LIME_CANDLE);
		this.dropOther(CRBlocks.PINK_CANDLE_LIME_CAKE.get(), Blocks.PINK_CANDLE);
		this.dropOther(CRBlocks.GRAY_CANDLE_LIME_CAKE.get(), Blocks.GRAY_CANDLE);
		this.dropOther(CRBlocks.LIGHT_GRAY_CANDLE_LIME_CAKE.get(), Blocks.LIGHT_GRAY_CANDLE);
		this.dropOther(CRBlocks.CYAN_CANDLE_LIME_CAKE.get(), Blocks.CYAN_CANDLE);
		this.dropOther(CRBlocks.PURPLE_CANDLE_LIME_CAKE.get(), Blocks.PURPLE_CANDLE);
		this.dropOther(CRBlocks.BLUE_CANDLE_LIME_CAKE.get(), Blocks.BLUE_CANDLE);
		this.dropOther(CRBlocks.BROWN_CANDLE_LIME_CAKE.get(), Blocks.BROWN_CANDLE);
		this.dropOther(CRBlocks.GREEN_CANDLE_LIME_CAKE.get(), Blocks.GREEN_CANDLE);
		this.dropOther(CRBlocks.RED_CANDLE_LIME_CAKE.get(), Blocks.RED_CANDLE);
		this.dropOther(CRBlocks.BLACK_CANDLE_LIME_CAKE.get(), Blocks.BLACK_CANDLE);
		this.empty(CRBlocks.POMEGRANATE_CAKE);
		this.dropOther(CRBlocks.CANDLE_POMEGRANATE_CAKE.get(), Blocks.CANDLE);
		this.dropOther(CRBlocks.WHITE_CANDLE_POMEGRANATE_CAKE.get(), Blocks.WHITE_CANDLE);
		this.dropOther(CRBlocks.ORANGE_CANDLE_POMEGRANATE_CAKE.get(), Blocks.ORANGE_CANDLE);
		this.dropOther(CRBlocks.MAGENTA_CANDLE_POMEGRANATE_CAKE.get(), Blocks.MAGENTA_CANDLE);
		this.dropOther(CRBlocks.LIGHT_BLUE_CANDLE_POMEGRANATE_CAKE.get(), Blocks.LIGHT_BLUE_CANDLE);
		this.dropOther(CRBlocks.YELLOW_CANDLE_POMEGRANATE_CAKE.get(), Blocks.YELLOW_CANDLE);
		this.dropOther(CRBlocks.LIME_CANDLE_POMEGRANATE_CAKE.get(), Blocks.LIME_CANDLE);
		this.dropOther(CRBlocks.PINK_CANDLE_POMEGRANATE_CAKE.get(), Blocks.PINK_CANDLE);
		this.dropOther(CRBlocks.GRAY_CANDLE_POMEGRANATE_CAKE.get(), Blocks.GRAY_CANDLE);
		this.dropOther(CRBlocks.LIGHT_GRAY_CANDLE_POMEGRANATE_CAKE.get(), Blocks.LIGHT_GRAY_CANDLE);
		this.dropOther(CRBlocks.CYAN_CANDLE_POMEGRANATE_CAKE.get(), Blocks.CYAN_CANDLE);
		this.dropOther(CRBlocks.PURPLE_CANDLE_POMEGRANATE_CAKE.get(), Blocks.PURPLE_CANDLE);
		this.dropOther(CRBlocks.BLUE_CANDLE_POMEGRANATE_CAKE.get(), Blocks.BLUE_CANDLE);
		this.dropOther(CRBlocks.BROWN_CANDLE_POMEGRANATE_CAKE.get(), Blocks.BROWN_CANDLE);
		this.dropOther(CRBlocks.GREEN_CANDLE_POMEGRANATE_CAKE.get(), Blocks.GREEN_CANDLE);
		this.dropOther(CRBlocks.RED_CANDLE_POMEGRANATE_CAKE.get(), Blocks.RED_CANDLE);
		this.dropOther(CRBlocks.BLACK_CANDLE_POMEGRANATE_CAKE.get(), Blocks.BLACK_CANDLE);
		this.empty(CRBlocks.PINK_DRAGON_FRUIT_CAKE);
		this.dropOther(CRBlocks.CANDLE_PINK_DRAGON_FRUIT_CAKE.get(), Blocks.CANDLE);
		this.dropOther(CRBlocks.WHITE_CANDLE_PINK_DRAGON_FRUIT_CAKE.get(), Blocks.WHITE_CANDLE);
		this.dropOther(CRBlocks.ORANGE_CANDLE_PINK_DRAGON_FRUIT_CAKE.get(), Blocks.ORANGE_CANDLE);
		this.dropOther(CRBlocks.MAGENTA_CANDLE_PINK_DRAGON_FRUIT_CAKE.get(), Blocks.MAGENTA_CANDLE);
		this.dropOther(CRBlocks.LIGHT_BLUE_CANDLE_PINK_DRAGON_FRUIT_CAKE.get(), Blocks.LIGHT_BLUE_CANDLE);
		this.dropOther(CRBlocks.YELLOW_CANDLE_PINK_DRAGON_FRUIT_CAKE.get(), Blocks.YELLOW_CANDLE);
		this.dropOther(CRBlocks.LIME_CANDLE_PINK_DRAGON_FRUIT_CAKE.get(), Blocks.LIME_CANDLE);
		this.dropOther(CRBlocks.PINK_CANDLE_PINK_DRAGON_FRUIT_CAKE.get(), Blocks.PINK_CANDLE);
		this.dropOther(CRBlocks.GRAY_CANDLE_PINK_DRAGON_FRUIT_CAKE.get(), Blocks.GRAY_CANDLE);
		this.dropOther(CRBlocks.LIGHT_GRAY_CANDLE_PINK_DRAGON_FRUIT_CAKE.get(), Blocks.LIGHT_GRAY_CANDLE);
		this.dropOther(CRBlocks.CYAN_CANDLE_PINK_DRAGON_FRUIT_CAKE.get(), Blocks.CYAN_CANDLE);
		this.dropOther(CRBlocks.PURPLE_CANDLE_PINK_DRAGON_FRUIT_CAKE.get(), Blocks.PURPLE_CANDLE);
		this.dropOther(CRBlocks.BLUE_CANDLE_PINK_DRAGON_FRUIT_CAKE.get(), Blocks.BLUE_CANDLE);
		this.dropOther(CRBlocks.BROWN_CANDLE_PINK_DRAGON_FRUIT_CAKE.get(), Blocks.BROWN_CANDLE);
		this.dropOther(CRBlocks.GREEN_CANDLE_PINK_DRAGON_FRUIT_CAKE.get(), Blocks.GREEN_CANDLE);
		this.dropOther(CRBlocks.RED_CANDLE_PINK_DRAGON_FRUIT_CAKE.get(), Blocks.RED_CANDLE);
		this.dropOther(CRBlocks.BLACK_CANDLE_PINK_DRAGON_FRUIT_CAKE.get(), Blocks.BLACK_CANDLE);
		this.empty(CRBlocks.LUCUMA_CAKE);
		this.dropOther(CRBlocks.CANDLE_LUCUMA_CAKE.get(), Blocks.CANDLE);
		this.dropOther(CRBlocks.WHITE_CANDLE_LUCUMA_CAKE.get(), Blocks.WHITE_CANDLE);
		this.dropOther(CRBlocks.ORANGE_CANDLE_LUCUMA_CAKE.get(), Blocks.ORANGE_CANDLE);
		this.dropOther(CRBlocks.MAGENTA_CANDLE_LUCUMA_CAKE.get(), Blocks.MAGENTA_CANDLE);
		this.dropOther(CRBlocks.LIGHT_BLUE_CANDLE_LUCUMA_CAKE.get(), Blocks.LIGHT_BLUE_CANDLE);
		this.dropOther(CRBlocks.YELLOW_CANDLE_LUCUMA_CAKE.get(), Blocks.YELLOW_CANDLE);
		this.dropOther(CRBlocks.LIME_CANDLE_LUCUMA_CAKE.get(), Blocks.LIME_CANDLE);
		this.dropOther(CRBlocks.PINK_CANDLE_LUCUMA_CAKE.get(), Blocks.PINK_CANDLE);
		this.dropOther(CRBlocks.GRAY_CANDLE_LUCUMA_CAKE.get(), Blocks.GRAY_CANDLE);
		this.dropOther(CRBlocks.LIGHT_GRAY_CANDLE_LUCUMA_CAKE.get(), Blocks.LIGHT_GRAY_CANDLE);
		this.dropOther(CRBlocks.CYAN_CANDLE_LUCUMA_CAKE.get(), Blocks.CYAN_CANDLE);
		this.dropOther(CRBlocks.PURPLE_CANDLE_LUCUMA_CAKE.get(), Blocks.PURPLE_CANDLE);
		this.dropOther(CRBlocks.BLUE_CANDLE_LUCUMA_CAKE.get(), Blocks.BLUE_CANDLE);
		this.dropOther(CRBlocks.BROWN_CANDLE_LUCUMA_CAKE.get(), Blocks.BROWN_CANDLE);
		this.dropOther(CRBlocks.GREEN_CANDLE_LUCUMA_CAKE.get(), Blocks.GREEN_CANDLE);
		this.dropOther(CRBlocks.RED_CANDLE_LUCUMA_CAKE.get(), Blocks.RED_CANDLE);
		this.dropOther(CRBlocks.BLACK_CANDLE_LUCUMA_CAKE.get(), Blocks.BLACK_CANDLE);
		this.dropSelf(CRBlocks.LIME_ICE_CREAM_BLOCK.get());
		this.dropSelf(CRBlocks.POMEGRANATE_ICE_CREAM_BLOCK.get());
		this.dropSelf(CRBlocks.PINK_DRAGON_FRUIT_ICE_CREAM_BLOCK.get());
		this.dropSelf(CRBlocks.LUCUMA_ICE_CREAM_BLOCK.get());
		this.dropOther(CRBlocks.LIME_MILKSHAKE_CAULDRON.get(), Blocks.CAULDRON);
		this.dropOther(CRBlocks.POMEGRANATE_MILKSHAKE_CAULDRON.get(), Blocks.CAULDRON);
		this.dropOther(CRBlocks.PINK_DRAGON_FRUIT_MILKSHAKE_CAULDRON.get(), Blocks.CAULDRON);
		this.dropOther(CRBlocks.LUCUMA_MILKSHAKE_CAULDRON.get(), Blocks.CAULDRON);
		this.dropSelf(CRBlocks.URCHIN_TEST_BLOCK.get());
		this.dropSelf(CRBlocks.URCHIN_TEST_BRICKS.get());
		this.dropSelf(CRBlocks.URCHIN_TEST_BRICK_SLAB.get());
		this.dropSelf(CRBlocks.URCHIN_TEST_BRICK_STAIRS.get());
		this.dropSelf(CRBlocks.URCHIN_TEST_BRICK_WALL.get());
		this.dropSelf(CRBlocks.CHISELED_URCHIN_TEST_BRICKS.get());
		this.dropSelf(CRBlocks.URCHIN_TEST_TILES.get());
		this.dropSelf(CRBlocks.URCHIN_TEST_TILE_SLAB.get());
		this.dropSelf(CRBlocks.URCHIN_TEST_TILE_STAIRS.get());
		this.dropSelf(CRBlocks.URCHIN_TEST_TILE_WALL.get());
		this.dropOther(CRBlocks.PLATINUM_BASS_ROE.get(), CRItems.PLATINUM_BASS_ROE.get());
		this.dropOther(CRBlocks.TIGER_PRAWN_ROE.get(), CRItems.TIGER_PRAWN_ROE.get());

		// Lucuma wood
		this.dropSelf(CRBlocks.LUCUMA_LOG.get());
		this.dropSelf(CRBlocks.LUCUMA_WOOD.get());
		this.dropSelf(CRBlocks.STRIPPED_LUCUMA_LOG.get());
		this.dropSelf(CRBlocks.STRIPPED_LUCUMA_WOOD.get());
		this.dropSelf(CRBlocks.LUCUMA_PLANKS.get());
		this.dropSelf(CRBlocks.LUCUMA_STAIRS.get());
		this.dropSelf(CRBlocks.LUCUMA_SLAB.get());
		this.dropSelf(CRBlocks.LUCUMA_FENCE.get());
		this.dropSelf(CRBlocks.LUCUMA_FENCE_GATE.get());
		this.add(CRBlocks.LUCUMA_DOOR.get(), this::createDoorTable);
		this.dropSelf(CRBlocks.LUCUMA_TRAPDOOR.get());
		this.dropSelf(CRBlocks.LUCUMA_PRESSURE_PLATE.get());
		this.dropSelf(CRBlocks.LUCUMA_BUTTON.get());
		this.dropSelf(CRBlocks.LUCUMA_SIGN.get());
		this.dropSelf(CRBlocks.LUCUMA_HANGING_SIGN.get());
		this.dropSelf(CRBlocks.LUCUMA_SAPLING.get());
		this.dropPottedContents(CRBlocks.POTTED_LUCUMA_SAPLING.get());
		this.add(CRBlocks.LUCUMA_LEAVES.get(), b -> createLeavesDrops(b,
			CRBlocks.LUCUMA_SAPLING.get(), 0.05F, 0.0625F, 0.0833F, 0.1F));
		this.leafPile(CRBlocks.LUCUMA_LEAF_PILE.get());
		this.dropSelf(CRBlocks.LUCUMA_CABINET.get());
	}

	private void leafPile(Block block) {
		this.add(block, b -> createMultifaceBlockDrops(b, MatchTool.toolMatches(ItemPredicate.Builder.item().of(Tags.Items.SHEARS))));
	}

	@Override
	protected @NotNull Iterable<Block> getKnownBlocks() {
		return CRBlocks.HELPER.getDeferredRegister().getEntries()
			.stream()
			.filter(reg -> {
				return (
					reg != CRBlocks.PORTOBELLO_COLONY &&
					reg != CRBlocks.PINK_DRAGON_FRUIT_CROP
				);
			})
			.map(RegistryObject::get)
			::iterator;
	}

	public void empty(RegistryObject<Block> block) {
		this.add(block.get(), LootTable.lootTable());
	}
}
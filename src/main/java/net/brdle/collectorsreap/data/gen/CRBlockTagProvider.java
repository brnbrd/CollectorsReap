package net.brdle.collectorsreap.data.gen;

import net.brdle.collectorsreap.CollectorsReap;
import net.brdle.collectorsreap.Util;
import net.brdle.collectorsreap.common.block.CRBlocks;
import net.brdle.collectorsreap.common.block.EffectCandleCakeBlock;
import net.brdle.collectorsreap.data.CRBlockTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.common.tag.ForgeTags;
import vectorwing.farmersdelight.common.tag.ModTags;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class CRBlockTagProvider extends BlockTagsProvider {
	public CRBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
		super(output, lookupProvider, CollectorsReap.MODID, existingFileHelper);
	}

	@Override
	public void addTags(HolderLookup.@NotNull Provider provider) {
		// Collector's Reap
		this.tag(CRBlockTags.PORTOBELLO_SPAWNABLE_ON)
			.addTag(ModTags.MUSHROOM_COLONY_GROWABLE_ON)
			.addTag(BlockTags.MUSHROOM_GROW_BLOCK)
			.addTag(BlockTags.DIRT);
		this.tag(CRBlockTags.DRAGON_FRUIT_SPAWNABLE_ON)
			.addTag(Tags.Blocks.SAND_RED);
		this.tag(CRBlockTags.STYGIAN_POMEGRANATE_GROWABLE_ON)
			.addOptional(Util.rl("mynethersdelight", "resurgent_soil"))
			.addOptional(Util.rl("mynethersdelight", "resurgent_soil_farmland"));
		this.tag(CRBlockTags.POMEGRANATE_FAST_ON)
			.addTag(CRBlockTags.STYGIAN_POMEGRANATE_GROWABLE_ON)
			.addTag(BlockTags.NYLIUM)
			.addOptionalTag(Util.rl("nethersdelight", "rich_soul_soil"));
		this.tag(CRBlockTags.CRAB_SPAWNABLE_ON)
			.addTag(BlockTags.SAND)
			.addTag(Tags.Blocks.GRAVEL)
			.add(Blocks.WATER)
			.add(Blocks.CLAY)
			.addOptionalTag(Util.rl("quark", "crab_spawnable"))
			.addOptionalTag(Util.rl("crabbersdelight", "crab_spawn_on"));
		this.tag(CRBlockTags.LUCUMA_LOGS)
			.add(CRBlocks.LUCUMA_LOG.get())
			.add(CRBlocks.LUCUMA_WOOD.get())
			.add(CRBlocks.STRIPPED_LUCUMA_LOG.get())
			.add(CRBlocks.STRIPPED_LUCUMA_WOOD.get());

		// Minecraft
		CRBlocks.HELPER.getDeferredRegister().getEntries()
			.stream()
			.map(RegistryObject::get)
			.filter(b -> b instanceof EffectCandleCakeBlock)
			.forEach(b -> this.tag(BlockTags.CANDLE_CAKES).add(b));
		this.tag(BlockTags.LOGS_THAT_BURN).addTag(CRBlockTags.LUCUMA_LOGS);
		this.tag(BlockTags.PLANKS).add(CRBlocks.LUCUMA_PLANKS.get());
		this.tag(BlockTags.WOODEN_STAIRS).add(CRBlocks.LUCUMA_STAIRS.get());
		this.tag(BlockTags.WOODEN_SLABS).add(CRBlocks.LUCUMA_SLAB.get());
		this.tag(BlockTags.WOODEN_FENCES).add(CRBlocks.LUCUMA_FENCE.get());
		this.tag(BlockTags.FENCE_GATES).add(CRBlocks.LUCUMA_FENCE_GATE.get());
		this.tag(BlockTags.WOODEN_DOORS).add(CRBlocks.LUCUMA_DOOR.get());
		this.tag(BlockTags.WOODEN_TRAPDOORS).add(CRBlocks.LUCUMA_TRAPDOOR.get());
		this.tag(BlockTags.WOODEN_PRESSURE_PLATES).add(CRBlocks.LUCUMA_PRESSURE_PLATE.get());
		this.tag(BlockTags.WOODEN_BUTTONS).add(CRBlocks.LUCUMA_BUTTON.get());
		this.tag(BlockTags.STANDING_SIGNS).add(CRBlocks.LUCUMA_SIGN.get());
		this.tag(BlockTags.WALL_SIGNS).add(CRBlocks.LUCUMA_WALL_SIGN.get());
		this.tag(BlockTags.CEILING_HANGING_SIGNS).add(CRBlocks.LUCUMA_HANGING_SIGN.get());
		this.tag(BlockTags.WALL_HANGING_SIGNS).add(CRBlocks.LUCUMA_WALL_HANGING_SIGN.get());
		this.tag(BlockTags.MINEABLE_WITH_SHOVEL)
			.add(CRBlocks.LIME_ICE_CREAM_BLOCK.get())
			.add(CRBlocks.POMEGRANATE_ICE_CREAM_BLOCK.get())
			.add(CRBlocks.PINK_DRAGON_FRUIT_ICE_CREAM_BLOCK.get())
			.add(CRBlocks.PLATINUM_BASS_ROE.get())
			.add(CRBlocks.TIGER_PRAWN_ROE.get());
		this.tag(BlockTags.MINEABLE_WITH_AXE)
			.add(CRBlocks.PORTOBELLO.get())
			.add(CRBlocks.LIME_CRATE.get())
			.add(CRBlocks.POMEGRANATE_CRATE.get())
			.add(CRBlocks.STYGIAN_POMEGRANATE_CRATE.get())
			.add(CRBlocks.PINK_DRAGON_FRUIT_CRATE.get())
			.add(CRBlocks.LUCUMA_CRATE.get())
			.add(CRBlocks.GILDED_LUCUMA_CRATE.get());
		this.tag(BlockTags.CLIMBABLE).add(CRBlocks.PINK_DRAGON_FRUIT_CROP.get());
		this.tag(BlockTags.CROPS)
			.add(CRBlocks.BUDDING_PINK_DRAGON_FRUIT_CROP.get());
		this.tag(BlockTags.BEE_GROWABLES)
			.add(CRBlocks.LIME_BUSH.get())
			.add(CRBlocks.POMEGRANATE_BUSH.get());
		this.tag(BlockTags.WALLS)
			.add(CRBlocks.URCHIN_TEST_BRICK_WALL.get())
			.add(CRBlocks.URCHIN_TEST_TILE_WALL.get());
		this.tag(BlockTags.SLABS)
			.add(CRBlocks.URCHIN_TEST_BRICK_SLAB.get())
			.add(CRBlocks.URCHIN_TEST_TILE_SLAB.get());
		this.tag(BlockTags.STAIRS)
			.add(CRBlocks.URCHIN_TEST_BRICK_STAIRS.get())
			.add(CRBlocks.URCHIN_TEST_TILE_STAIRS.get());
		this.tag(BlockTags.CAULDRONS)
			.add(CRBlocks.LIME_MILKSHAKE_CAULDRON.get())
			.add(CRBlocks.POMEGRANATE_MILKSHAKE_CAULDRON.get())
			.add(CRBlocks.PINK_DRAGON_FRUIT_MILKSHAKE_CAULDRON.get())
			.add(CRBlocks.LUCUMA_MILKSHAKE_CAULDRON.get());

		// Forge
		this.tag(Tags.Blocks.FENCE_GATES_WOODEN).add(CRBlocks.LUCUMA_FENCE_GATE.get());
		this.tag(CRBlockTags.STORAGE_BLOCKS_LIME).add(CRBlocks.LIME_CRATE.get());
		this.tag(CRBlockTags.STORAGE_BLOCKS_POMEGRANATE).add(CRBlocks.POMEGRANATE_CRATE.get());
		this.tag(CRBlockTags.STORAGE_BLOCKS_STYGIAN_POMEGRANATE).add(CRBlocks.STYGIAN_POMEGRANATE_CRATE.get());
		this.tag(CRBlockTags.STORAGE_BLOCKS_PINK_DRAGON_FRUIT).add(CRBlocks.PINK_DRAGON_FRUIT_CRATE.get());
		this.tag(CRBlockTags.STORAGE_BLOCKS_LUCUMA).add(CRBlocks.LUCUMA_CRATE.get());
		this.tag(CRBlockTags.STORAGE_BLOCKS_GILDED_LUCUMA).add(CRBlocks.GILDED_LUCUMA_CRATE.get());
		this.tag(Tags.Blocks.STORAGE_BLOCKS)
			.addTag(CRBlockTags.STORAGE_BLOCKS_LIME)
			.addTag(CRBlockTags.STORAGE_BLOCKS_POMEGRANATE)
			.addTag(CRBlockTags.STORAGE_BLOCKS_STYGIAN_POMEGRANATE)
			.addTag(CRBlockTags.STORAGE_BLOCKS_PINK_DRAGON_FRUIT)
			.addTag(CRBlockTags.STORAGE_BLOCKS_LUCUMA)
			.addTag(CRBlockTags.STORAGE_BLOCKS_GILDED_LUCUMA);
		this.tag(ForgeTags.MINEABLE_WITH_KNIFE)
			.add(CRBlocks.PORTOBELLO_QUICHE.get())
			.add(CRBlocks.LIME_PIE.get())
			.add(CRBlocks.LIME_CAKE.get())
			.add(CRBlocks.POMEGRANATE_CAKE.get())
			.add(CRBlocks.PINK_DRAGON_FRUIT_CAKE.get())
			.add(CRBlocks.LUCUMA_CAKE.get());

		// Farmer's Delight
		this.tag(ModTags.COMPOST_ACTIVATORS)
			.add(CRBlocks.PORTOBELLO.get())
			.add(CRBlocks.PORTOBELLO_COLONY.get());
		this.tag(ModTags.UNAFFECTED_BY_RICH_SOIL)
			.add(CRBlocks.PORTOBELLO_COLONY.get());
		this.tag(ModTags.WILD_CROPS)
			.add(CRBlocks.DRAGON_BUSH.get());
		this.tag(BlockTags.SMALL_FLOWERS)
			.add(CRBlocks.DRAGON_BUSH.get());

		// Serene Seasons
		this.tag(CRBlockTags.WINTER_CROPS);
		this.tag(CRBlockTags.AUTUMN_CROPS)
			.add(CRBlocks.POMEGRANATE_BUSH.get());
		this.tag(CRBlockTags.SUMMER_CROPS)
			.add(CRBlocks.POMEGRANATE_BUSH.get())
			.add(CRBlocks.BUDDING_PINK_DRAGON_FRUIT_CROP.get())
			.add(CRBlocks.PINK_DRAGON_FRUIT_CROP.get());
		this.tag(CRBlockTags.SPRING_CROPS)
			.add(CRBlocks.LIME_BUSH.get());

		// My Nether's Delight
		this.tag(CRBlockTags.SHOWCASE_ACTIVATORS)
			.add(CRBlocks.PORTOBELLO.get())
			.add(CRBlocks.PORTOBELLO_COLONY.get());
		this.tag(CRBlockTags.NOT_PROPAGATE_PLANT)
			.add(CRBlocks.LIME_BUSH.get())
			.add(CRBlocks.POMEGRANATE_BUSH.get());

		// Let Fish Love
		this.tag(CRBlockTags.FISH_ROE_PLATINUM_BASS).add(CRBlocks.PLATINUM_BASS_ROE.get());
		this.tag(CRBlockTags.FISH_ROE_TIGER_PRAWN).add(CRBlocks.TIGER_PRAWN_ROE.get());

		// Supplementaries
		this.tag(CRBlockTags.HANG_FROM_ROPES).add(CRBlocks.PINK_DRAGON_FRUIT_CROP.get());

		// Other
		this.tag(BlockTags.create(Util.rl("twilightforest", "portal/decoration"))).add(CRBlocks.PORTOBELLO.get());
		this.tag(BlockTags.create(Util.rl("immersive_weathering", "small_mushrooms"))).add(CRBlocks.PORTOBELLO.get());
		this.tag(BlockTags.create(Util.rl("autumnity", "snail_snacks"))).add(CRBlocks.PORTOBELLO.get());
	}
}
package net.brdle.collectorsreap.data.gen;

import com.teamabnormals.blueprint.core.data.client.BlueprintBlockStateProvider;
import com.teamabnormals.blueprint.core.data.client.BlueprintItemModelProvider;
import net.brdle.collectorsreap.CollectorsReap;
import net.brdle.collectorsreap.Util;
import net.brdle.collectorsreap.common.block.CRBlocks;
import net.brdle.collectorsreap.common.item.CRItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class CRItemModelProvider extends BlueprintItemModelProvider {
	public CRItemModelProvider(final PackOutput output, final ExistingFileHelper helper) {
		super(output, CollectorsReap.MODID, helper);
	}

	@Override
	protected void registerModels() {
		// Crates
		this.blockItem(CRBlocks.LIME_CRATE);
		this.blockItem(CRBlocks.POMEGRANATE_CRATE);
		this.blockItem(CRBlocks.STYGIAN_POMEGRANATE_CRATE);
		this.blockItem(CRBlocks.PINK_DRAGON_FRUIT_CRATE);
		this.blockItem(CRBlocks.LUCUMA_CRATE);
		this.blockItem(CRBlocks.GILDED_LUCUMA_CRATE);

		// Lucuma Wood
		this.blockItem(CRBlocks.LUCUMA_LOG);
		this.blockItem(CRBlocks.LUCUMA_WOOD);
		this.blockItem(CRBlocks.STRIPPED_LUCUMA_LOG);
		this.blockItem(CRBlocks.STRIPPED_LUCUMA_WOOD);
		this.blockItem(CRBlocks.LUCUMA_PLANKS);
		this.blockItem(CRBlocks.LUCUMA_STAIRS);
		this.blockItem(CRBlocks.LUCUMA_SLAB);
		this.fenceInventory(Util.name(CRBlocks.LUCUMA_FENCE), resourceBlock(CRBlocks.LUCUMA_PLANKS));
		this.blockItem(CRBlocks.LUCUMA_FENCE_GATE);
		this.blockItem(CRBlocks.LUCUMA_TRAPDOOR, Util.name(CRBlocks.LUCUMA_TRAPDOOR) + "_bottom");
		this.blockItem(CRBlocks.LUCUMA_PRESSURE_PLATE);
		this.buttonInventory(Util.name(CRBlocks.LUCUMA_BUTTON), resourceBlock(CRBlocks.LUCUMA_PLANKS));
		this.generatedItem(CRBlocks.LUCUMA_DOOR);
		this.generatedItem(CRBlocks.LUCUMA_SIGN);
		this.generatedItem(CRBlocks.LUCUMA_HANGING_SIGN);
		this.generatedItem(CRItems.LUCUMA_BOAT);
		this.generatedItem(CRItems.LUCUMA_CHEST_BOAT);
		this.generatedItem(CRItems.LUCUMA_FURNACE_BOAT);
		this.generatedItem(CRItems.LARGE_LUCUMA_BOAT);
		this.flatBlock(CRBlocks.LUCUMA_SAPLING);
		this.blockItem(CRBlocks.LUCUMA_LEAVES);
		this.flatBlock(CRBlocks.LUCUMA_LEAF_PILE, Util.name(CRBlocks.LUCUMA_LEAVES));
		this.blockItem(CRBlocks.LUCUMA_CABINET);
		this.blockItem(CRBlocks.LUCUMA_BEEHIVE);
		this.flatBlock(CRBlocks.LUCUMA_LADDER);
		this.blockItem(CRBlocks.LUCUMA_BOOKSHELF);
		this.blockItem(CRBlocks.LUCUMA_BOARDS);
		this.chest(CRBlocks.LUCUMA_CHEST);
		this.chest(CRBlocks.TRAPPED_LUCUMA_CHEST);

		// Urchin Test
		this.blockItem(CRBlocks.URCHIN_TEST_BLOCK);
		this.blockItem(CRBlocks.URCHIN_TEST_BRICKS);
		this.blockItem(CRBlocks.URCHIN_TEST_BRICK_STAIRS);
		this.blockItem(CRBlocks.URCHIN_TEST_BRICK_SLAB);
		this.wallInventory(Util.name(CRBlocks.URCHIN_TEST_BRICK_WALL), resourceBlock(CRBlocks.URCHIN_TEST_BRICKS));
		this.blockItem(CRBlocks.CHISELED_URCHIN_TEST_BRICKS);
		this.blockItem(CRBlocks.URCHIN_TEST_TILES);
		this.blockItem(CRBlocks.URCHIN_TEST_TILE_STAIRS);
		this.blockItem(CRBlocks.URCHIN_TEST_TILE_SLAB);
		this.wallInventory(Util.name(CRBlocks.URCHIN_TEST_TILE_WALL), resourceBlock(CRBlocks.URCHIN_TEST_TILES));

		// Ice Cream Blocks
		this.blockItem(CRBlocks.LIME_ICE_CREAM_BLOCK);
		this.blockItem(CRBlocks.POMEGRANATE_ICE_CREAM_BLOCK);
		this.blockItem(CRBlocks.PINK_DRAGON_FRUIT_ICE_CREAM_BLOCK);
		this.blockItem(CRBlocks.LUCUMA_ICE_CREAM_BLOCK);

		// Wild Crop Blocks
		this.flatBlock(CRBlocks.PORTOBELLO_COLONY, Util.name(CRBlocks.PORTOBELLO_COLONY) + "_stage3");
		this.flatBlock(CRBlocks.PORTOBELLO);
		this.flatBlock(CRBlocks.DRAGON_BUSH);
		this.flatBlock(CRBlocks.DAMSELFLOWER);
		this.flatBlock(CRBlocks.MOONTEAR);
		this.flatBlock(CRBlocks.SKULL_LILY);
		this.flatBlock(CRBlocks.BULBOUS_ROSE, Util.name(CRBlocks.BULBOUS_ROSE) + "_top");
		this.flatBlock(CRBlocks.HEARTPETALS, Util.name(CRBlocks.HEARTPETALS) + "_top");

		// Fruits/Veggies
		this.generatedItem(CRItems.POMEGRANATE);
		this.generatedItem(CRItems.POMEGRANATE_SLICE);
		this.generatedItem(CRItems.STYGIAN_POMEGRANATE);
		this.generatedItem(CRItems.LIME);
		this.generatedItem(CRItems.LIME_SLICE);
		this.generatedItem(CRItems.PINK_DRAGON_FRUIT);
		this.generatedItem(CRItems.LUCUMA);
		this.generatedItem(CRItems.GILDED_LUCUMA);

		// Seeds
		this.generatedItem(CRItems.LIME_SEEDS);
		this.generatedItem(CRItems.POMEGRANATE_SEEDS);
		this.generatedItem(CRItems.DRAGON_FRUIT_SEEDS);
		this.generatedItem(CRItems.DAMSELFLOWER_SEEDS);
		this.generatedItem(CRItems.MOONTEAR_SEEDS);
		this.generatedItem(CRItems.SKULL_LILY_SEEDS);
		this.generatedItem(CRItems.BULBOUS_ROSE_SEEDS);
		this.generatedItem(CRItems.HEARTPETALS_SEEDS);

		// Sliceable Blocks
		this.generatedItem(CRItems.PORTOBELLO_QUICHE);
		this.generatedItem(CRItems.PORTOBELLO_QUICHE_SLICE);
		this.generatedItem(CRItems.LIME_PIE);
		this.generatedItem(CRItems.LIME_PIE_SLICE);
		this.generatedItem(CRItems.LIME_CAKE);
		this.generatedItem(CRItems.LIME_CAKE_SLICE);
		this.generatedItem(CRItems.POMEGRANATE_CAKE);
		this.generatedItem(CRItems.POMEGRANATE_CAKE_SLICE);
		this.generatedItem(CRItems.PINK_DRAGON_FRUIT_CAKE);
		this.generatedItem(CRItems.PINK_DRAGON_FRUIT_CAKE_SLICE);
		this.generatedItem(CRItems.LUCUMA_CAKE);
		this.generatedItem(CRItems.LUCUMA_CAKE_SLICE);
		this.generatedItem(CRItems.PANETTONE);
		this.generatedItem(CRItems.PANETTONE_SLICE);

		// Ice Cream
		this.generatedItem(CRItems.LIME_ICE_CREAM);
		this.generatedItem(CRItems.POMEGRANATE_ICE_CREAM);
		this.generatedItem(CRItems.PINK_DRAGON_FRUIT_ICE_CREAM);
		this.generatedItem(CRItems.LUCUMA_ICE_CREAM);
		this.generatedItem(CRItems.SUNNY_ICE_CREAM);

		// Milkshakes
		this.generatedItem(CRItems.LIME_MILKSHAKE);
		this.generatedItem(CRItems.POMEGRANATE_MILKSHAKE);
		this.generatedItem(CRItems.PINK_DRAGON_FRUIT_MILKSHAKE);
		this.generatedItem(CRItems.LUCUMA_MILKSHAKE);

		// Drinks
		this.generatedItem(CRItems.LIMEADE);
		this.otherTexture(CRItems.STRONG_LIMEADE, CRItems.LIMEADE);
		this.generatedItem(CRItems.BERRY_LIMEADE);
		this.generatedItem(CRItems.PINK_LIMEADE);
		this.generatedItem(CRItems.MINT_LIMEADE);
		this.generatedItem(CRItems.LIME_GREEN_TEA);
		this.generatedItem(CRItems.POMEGRANATE_BLACK_TEA);
		this.generatedItem(CRItems.VERNAL_PURGE);
		this.otherTexture(CRItems.STRONG_VERNAL_PURGE, CRItems.VERNAL_PURGE);
		this.generatedItem(CRItems.LIMBO_BREW);
		this.otherTexture(CRItems.LONG_LIMBO_BREW, CRItems.LIMBO_BREW);
		this.otherTexture(CRItems.STRONG_LIMBO_BREW, CRItems.LIMBO_BREW);
		this.generatedItem(CRItems.SWEET_RECOVERY);
		this.otherTexture(CRItems.LONG_SWEET_RECOVERY, CRItems.SWEET_RECOVERY);
		this.otherTexture(CRItems.STRONG_SWEET_RECOVERY, CRItems.SWEET_RECOVERY);
		this.generatedItem(CRItems.POMEGRANATE_SMOOTHIE);
		this.generatedItem(CRItems.POMEGRANATE_CUSTARD);
		this.generatedItem(CRItems.DRAGONS_PASSION);
		this.generatedItem(CRItems.LUCUMA_PUDDING);
		this.generatedItem(CRItems.DEIFIC_BLOOD);
		this.generatedItem(CRItems.HERMITS_SOUR);
		this.generatedItem(CRItems.ROSE_MOON);
		this.generatedItem(CRItems.REANIMATORS_GARDEN);
		this.generatedItem(CRItems.HEAVENS_CREAM);

		// Portobello
		this.generatedItem(CRItems.BAKED_PORTOBELLO_CAP);
		this.generatedItem(CRItems.STUFFED_PORTOBELLO_CAP);
		this.generatedItem(CRItems.PORTOBELLO_BURGER);
		this.generatedItem(CRItems.PORTOBELLO_WRAP);
		this.generatedItem(CRItems.PORTOBELLO_RISOTTO);
		this.generatedItem(CRItems.PORTOBELLO_PASTA);
		this.generatedItem(CRItems.PORTOBELLO_RICE_SOUP);
		this.generatedItem(CRItems.PORTOBELLO_RICE_SOUP_CUP);

		// Lime
		this.generatedItem(CRItems.CANDIED_LIME);
		this.generatedItem(CRItems.LIME_COOKIE);
		this.generatedItem(CRItems.LIME_POPSICLE);
		this.generatedItem(CRItems.CREAM_CHEESE);
		this.generatedItem(CRItems.PRAWN_SPREAD);
		this.generatedItem(CRItems.CARBONARA_PASTA);
		this.generatedItem(CRItems.STUFFED_PASTA_SHELLS);
		this.generatedItem(CRItems.BULLET_PEPPER_POPPER);
		this.generatedItem(CRItems.CANNOLI);
		this.generatedItem(CRItems.COFFEE_CANNOLI);
		this.generatedItem(CRItems.CHOCOLATE_CANNOLI);
		this.generatedItem(CRItems.MINT_CANNOLI);
		this.generatedItem(CRItems.STRAWBERRY_CANNOLI);
		this.generatedItem(CRItems.VANILLA_CANNOLI);
		this.generatedItem(CRItems.HONEY_LIME_CHICKEN);
		this.generatedItem(CRItems.MEDITERRANEAN_SALMON);
		this.generatedItem(CRItems.SALMON_TARTARE);
		this.generatedItem(CRItems.POTATO_FRITTERS);
		this.generatedItem(CRItems.COD_CEVICHE);

		// Pomegranate
		this.generatedItem(CRItems.CRIMSON_CARROT_ROAST);
		this.generatedItem(CRItems.POMEGRANATE_MUTTON);
		this.generatedItem(CRItems.POMEGRANATE_PORK);
		this.generatedItem(CRItems.POMEGRANATE_CHICKEN);
		this.generatedItem(CRItems.DELUXE_SALAD);

		// Pink Dragon Fruit
		this.generatedItem(CRItems.DRIED_PINK_DRAGON_FRUIT);
		this.generatedItem(CRItems.TROPICAL_SHAVED_ICE);
		this.generatedItem(CRItems.PINK_NOODLES);
		this.generatedItem(CRItems.DRAGON_STEW);
		this.generatedItem(CRItems.DRAGON_STEW_CUP);

		// Lucuma
		this.generatedItem(CRItems.LUCUMA_BREAD);
		this.generatedItem(CRItems.LUCUMA_GAZPACHO);
		this.generatedItem(CRItems.LUCUMA_GAZPACHO_CUP);

		// Tiger Prawn
		this.generatedItem(CRItems.TIGER_PRAWN);
		this.generatedItem(CRItems.COOKED_TIGER_PRAWN);
		this.generatedItem(CRItems.SALMON_WRAPPED_PRAWN);
		this.generatedItem(CRItems.PRAWN_ROLL);
		this.generatedItem(CRItems.PRAWN_PO_BOY);
		this.generatedItem(CRItems.PRAWN_CEVICHE);
		this.generatedItem(CRItems.PRAWN_NOODLES);
		this.generatedItem(CRItems.PRAWN_STEW);
		this.generatedItem(CRItems.PRAWN_STEW_CUP);

		// Platinum Bass
		this.generatedItem(CRItems.PLATINUM_BASS);
		this.generatedItem(CRItems.COOKED_PLATINUM_BASS);
		this.generatedItem(CRItems.PLATINUM_BASS_HEAD);
		this.generatedItem(CRItems.COOKED_PLATINUM_BASS_HEAD);
		this.generatedItem(CRItems.PLATINUM_BASS_SLICE);
		this.generatedItem(CRItems.COOKED_PLATINUM_BASS_SLICE);
		this.generatedItem(CRItems.FISH_MIX);
		this.generatedItem(CRItems.PLATINUM_BASS_STEW);
		this.generatedItem(CRItems.PLATINUM_BASS_STEW_CUP);

		// Chieftain Crab
		this.generatedItem(CRItems.CHIEFTAIN_CRAB);
		this.generatedItem(CRItems.CHIEFTAIN_CLAW);
		this.generatedItem(CRItems.CHIEFTAIN_LEG);
		this.generatedItem(CRItems.CHIEFTAIN_CRAB_MEAT);
		this.generatedItem(CRItems.CRAB_MISO);
		this.generatedItem(CRItems.CRAB_NOODLES);
		this.generatedItem(CRItems.CRAB_LASAGNA);
		this.generatedItem(CRItems.BUTTERED_LEGS);
		this.generatedItem(CRItems.BIG_RICE_BALL);
		this.generatedItem(CRItems.LAND_AND_SEA_BURGER);

		// Urchin
		this.generatedItem(CRItems.URCHIN);
		this.generatedItem(CRItems.URCHIN_TEST);
		this.generatedItem(CRItems.URCHIN_NEEDLE);
		this.generatedItem(CRItems.UNI);
		this.generatedItem(CRItems.UNI_ROLL);

		// Clam
		this.generatedItem(CRItems.CLAM);
		this.generatedItem(CRItems.CLAM_MEAT);
		this.generatedItem(CRItems.CLAM_ROLL);
		this.generatedItem(CRItems.SEA_WRAP);
		this.generatedItem(CRItems.CLAM_PASTA);
		this.generatedItem(CRItems.CLAM_CHOWDER);
		this.generatedItem(CRItems.CLAM_MEATBALL_STEW);
		this.generatedItem(CRItems.CLAM_MEATBALL_STEW_CUP);

		// Lunar Pearl
		this.generatedItem(CRItems.LUNAR_PEARL);
		this.generatedItem(CRItems.SHIMMERING_PEARL);
		this.generatedItem(CRItems.SHIMMERING_APPLE);
		this.generatedItem(CRItems.PEARLY_CLAW);

		// Other Compat
		this.generatedItem(CRItems.GLAZED_STRIDER);
		this.generatedItem(CRItems.SPICY_GRENADINE_JELLY);
		this.generatedItem(CRItems.STRAWBERRY_JAM_BUN);
		this.generatedItem(CRItems.POMEGRANATE_BEAN_SALAD);
		this.generatedItem(CRItems.CHOCOLATE_ARILS);

		// Gummies
		this.generatedItem(CRItems.LIME_GUMMY);
		this.generatedItem(CRItems.POMEGRANATE_GUMMY);
		this.generatedItem(CRItems.PINK_DRAGON_FRUIT_GUMMY);
		this.generatedItem(CRItems.LUCUMA_GUMMY);
		this.generatedItem(CRItems.APPLE_GUMMY);
		this.generatedItem(CRItems.GLOW_BERRY_GUMMY);
		this.generatedItem(CRItems.CARROT_GUMMY);
		this.generatedItem(CRItems.MELON_GUMMY);
		this.generatedItem(CRItems.STRAWBERRY_GUMMY);
		this.generatedItem(CRItems.BANANA_GUMMY);
		this.generatedItem(CRItems.VANILLA_GUMMY);
		this.generatedItem(CRItems.CHOCOLATE_GUMMY);
		this.generatedItem(CRItems.MINT_GUMMY);
		this.generatedItem(CRItems.ADZUKI_GUMMY);
		this.generatedItem(CRItems.PUMPKIN_GUMMY);
		this.generatedItem(CRItems.SWEET_BERRY_GUMMY);
		this.generatedItem(CRItems.BEETROOT_GUMMY);
		this.generatedItem(CRItems.ALOE_GUMMY);
		this.generatedItem(CRItems.WILD_BERRY_GUMMY);
		this.generatedItem(CRItems.PASSION_FRUIT_GUMMY);
		this.generatedItem(CRItems.YUCCA_GUMMY);
		this.generatedItem(CRItems.GREEN_TEA_GUMMY);
		this.generatedItem(CRItems.YELLOW_TEA_GUMMY);
		this.generatedItem(CRItems.BLACK_TEA_GUMMY);
		this.generatedItem(CRItems.COFFEE_GUMMY);
		this.generatedItem(CRItems.BULLET_PEPPER_GUMMY);
		this.generatedItem(CRItems.PRICKLY_PEAR_GUMMY);
		this.generatedItem(CRItems.PEANUT_GUMMY);
		this.generatedItem(CRItems.ASPARAGUS_ASPIC);
		this.generatedItem(CRItems.HEMP_GUMMY);

		// Spawn Eggs
		this.spawnEggItem(
			CRItems.TIGER_PRAWN_SPAWN_EGG,
			CRItems.PLATINUM_BASS_SPAWN_EGG,
			CRItems.CHIEFTAIN_CRAB_SPAWN_EGG,
			CRItems.URCHIN_SPAWN_EGG,
			CRItems.CLAM_SPAWN_EGG
		);
		this.generatedItem(CRItems.TIGER_PRAWN_BUCKET);
		this.generatedItem(CRItems.PLATINUM_BASS_BUCKET);
		this.generatedItem(CRItems.CHIEFTAIN_CRAB_BUCKET);
		this.generatedItem(CRItems.URCHIN_BUCKET);
		this.generatedItem(CRItems.CLAM_BUCKET);

		// Let Fish Love
		this.generatedItem(CRItems.PLATINUM_BASS_ROE);
		this.generatedItem(CRItems.TIGER_PRAWN_ROE);
	}

	private void blockItem(RegistryObject<Block> block, String path) {
		this.getBuilder(BlueprintBlockStateProvider.name(block.get())).parent(new ModelFile.UncheckedModelFile(new ResourceLocation(this.modid, "block/" + path)));
	}

	private void flatBlock(RegistryObject<?> blockItem, String blockPath) {
		this.withExistingParent(Util.name(blockItem), "item/generated").texture("layer0", resourceBlock(blockPath));
	}

	private void flatBlock(RegistryObject<?> blockItem) {
		this.withExistingParent(Util.name(blockItem), "item/generated").texture("layer0", resourceBlock(Util.name(blockItem)));
	}

	private void chest(RegistryObject<?> chestItem) {
		this.withExistingParent(Util.name(chestItem), "blueprint:item/template_chest");
	}

	private void otherTexture(RegistryObject<? extends ItemLike> item, RegistryObject<? extends ItemLike> textureItem) {
		this.item(item, Util.name(textureItem), "generated");
	}

	public static ResourceLocation resourceItem(String path) {
		return Util.cr("item/" + path);
	}

	public static ResourceLocation resourceItem(RegistryObject<?> item) {
		return resourceItem(item.getId().getPath());
	}

	public static ResourceLocation resourceBlock(String path) {
		return Util.cr("block/" + path);
	}

	public static ResourceLocation resourceBlock(RegistryObject<?> block) {
		return resourceBlock(block.getId().getPath());
	}
}
package net.brdle.collectorsreap.data.gen;

import com.teamabnormals.blueprint.core.data.server.BlueprintRecipeProvider;
import com.teamabnormals.boatload.core.data.server.BoatloadRecipeProvider;
import net.brdle.collectorsreap.CollectorsReap;
import net.brdle.collectorsreap.Util;
import net.brdle.collectorsreap.common.block.CRBlocks;
import net.brdle.collectorsreap.common.crafting.EnabledCondition;
import net.brdle.collectorsreap.common.item.CRItems;
import net.brdle.collectorsreap.compat.Modid;
import net.brdle.collectorsreap.compat.abnormals.CRBoatTypes;
import net.brdle.collectorsreap.data.CRItemTags;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.ConditionalRecipe;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.common.registry.ModItems;
import vectorwing.farmersdelight.common.tag.ForgeTags;
import vectorwing.farmersdelight.data.builder.CookingPotRecipeBuilder;
import java.util.function.Consumer;

public class CRRecipeProvider extends BlueprintRecipeProvider implements IConditionBuilder {
	public CRRecipeProvider(PackOutput output) {
		super(CollectorsReap.MODID, output);
	}

	private static void foodSmeltingRecipes(String name, ItemLike ingredient, ItemLike result, float experience, Consumer<FinishedRecipe> consumer) {
		final String namePrefix = Util.cr(name).toString();
		SimpleCookingRecipeBuilder.smelting(Ingredient.of(ingredient), RecipeCategory.FOOD, result, experience, 200).unlockedBy(name, has(ingredient)).save(consumer);
		SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(ingredient), RecipeCategory.FOOD, result, experience, 600).unlockedBy(name, has(ingredient)).save(consumer, namePrefix + "_from_campfire_cooking");
		SimpleCookingRecipeBuilder.smoking(Ingredient.of(ingredient), RecipeCategory.FOOD, result, experience, 100).unlockedBy(name, has(ingredient)).save(consumer, namePrefix + "_from_smoking");
	}

	@Override
	public void buildRecipes(Consumer<FinishedRecipe> finished) {
		// Smelting
		foodSmeltingRecipes("baked_portobello_cap", CRItems.PORTOBELLO.get(), CRItems.BAKED_PORTOBELLO_CAP.get(), 0.35F, finished);
		foodSmeltingRecipes("dried_pink_dragon_fruit", CRItems.PINK_DRAGON_FRUIT.get(), CRItems.DRIED_PINK_DRAGON_FRUIT.get(), 0.35F, finished);
		foodSmeltingRecipes("cooked_platinum_bass", CRItems.PLATINUM_BASS.get(), CRItems.COOKED_PLATINUM_BASS.get(), 0.35F, finished);
		foodSmeltingRecipes("cooked_platinum_bass_head", CRItems.PLATINUM_BASS_HEAD.get(), CRItems.COOKED_PLATINUM_BASS_HEAD.get(), 0.35F, finished);
		foodSmeltingRecipes("cooked_platinum_bass_slice", CRItems.PLATINUM_BASS_SLICE.get(), CRItems.COOKED_PLATINUM_BASS_SLICE.get(), 0.35F, finished);
		foodSmeltingRecipes("cooked_tiger_prawn", CRItems.TIGER_PRAWN.get(), CRItems.COOKED_TIGER_PRAWN.get(), 0.35F, finished);

		// Cooking Pot
		wrap(CookingPotRecipeBuilder.cookingPotRecipe(CRItems.PORTOBELLO_RISOTTO.get(), 1, 200, 1F, Items.BOWL)
				.addIngredient(CRItems.BAKED_PORTOBELLO_CAP.get())
				.addIngredient(ForgeTags.GRAIN_RICE)
				.addIngredient(ForgeTags.MILK)
				.addIngredient(ForgeTags.VEGETABLES_ONION)
				.unlockedBy("has_baked_portobello_cap", has(CRItems.BAKED_PORTOBELLO_CAP.get())),
			"food/portobello_risotto", finished, enabled(CRItems.PORTOBELLO), enabled(CRItems.BAKED_PORTOBELLO_CAP), enabled(CRItems.PORTOBELLO_RISOTTO));
		wrap(CookingPotRecipeBuilder.cookingPotRecipe(CRItems.PORTOBELLO_RICE_SOUP.get(), 1, 200, 1F, Items.BOWL)
				.addIngredient(CRItems.BAKED_PORTOBELLO_CAP.get())
				.addIngredient(ForgeTags.GRAIN_RICE)
				.addIngredient(ForgeTags.VEGETABLES_ONION)
				.addIngredient(ForgeTags.VEGETABLES_CARROT)
				.unlockedBy("has_baked_portobello_cap", has(CRItems.BAKED_PORTOBELLO_CAP.get())),
			"food/portobello_rice_soup", finished, enabled(CRItems.PORTOBELLO), enabled(CRItems.BAKED_PORTOBELLO_CAP), enabled(CRItems.PORTOBELLO_RICE_SOUP));
		wrap(CookingPotRecipeBuilder.cookingPotRecipe(CRItems.STUFFED_PORTOBELLO_CAP.get(), 1, 200, 1F, CRItems.BAKED_PORTOBELLO_CAP.get())
				.addIngredient(Items.BROWN_MUSHROOM)
				.addIngredient(ForgeTags.VEGETABLES_ONION)
				.addIngredient(ForgeTags.VEGETABLES_TOMATO)
				.unlockedBy("has_baked_portobello_cap", has(CRItems.BAKED_PORTOBELLO_CAP.get())),
			"food/stuffed_portobello_cap", finished, enabled(CRItems.PORTOBELLO), enabled(CRItems.BAKED_PORTOBELLO_CAP), enabled(CRItems.STUFFED_PORTOBELLO_CAP));
		wrap(CookingPotRecipeBuilder.cookingPotRecipe(CRItems.PORTOBELLO_PASTA.get(), 1, 200, 1F, Items.BOWL)
				.addIngredient(CRItems.BAKED_PORTOBELLO_CAP.get())
				.addIngredient(ForgeTags.PASTA_RAW_PASTA)
				.addIngredient(Items.BROWN_MUSHROOM)
				.addIngredient(ForgeTags.VEGETABLES_ONION)
				.addIngredient(ForgeTags.MILK)
				.unlockedBy("has_baked_portobello_cap", has(CRItems.BAKED_PORTOBELLO_CAP.get())),
			"food/portobello_pasta", finished, enabled(CRItems.PORTOBELLO), enabled(CRItems.BAKED_PORTOBELLO_CAP), enabled(CRItems.PORTOBELLO_PASTA));
		wrap(CookingPotRecipeBuilder.cookingPotRecipe(CRItems.PINK_NOODLES.get(), 1, 200, 1F, Items.BOWL)
				.addIngredient(CRItems.PINK_DRAGON_FRUIT.get())
				.addIngredient(ForgeTags.PASTA_RAW_PASTA)
				.addIngredient(ForgeTags.VEGETABLES_CARROT)
				.addIngredient(ForgeTags.VEGETABLES_BEETROOT)
				.unlockedBy("has_pink_dragon_fruit", has(CRItems.PINK_DRAGON_FRUIT.get())),
			"food/pink_noodles", finished, enabled(CRItems.PINK_DRAGON_FRUIT), enabled(CRItems.PINK_NOODLES));
		wrap(CookingPotRecipeBuilder.cookingPotRecipe(CRItems.DRAGON_STEW.get(), 1, 200, 1F, Items.BOWL)
				.addIngredient(CRItems.PINK_DRAGON_FRUIT.get())
				.addIngredient(ForgeTags.RAW_PORK)
				.addIngredient(ForgeTags.VEGETABLES_TOMATO)
				.addIngredient(ForgeTags.VEGETABLES_CARROT)
				.unlockedBy("has_pink_dragon_fruit", has(CRItems.PINK_DRAGON_FRUIT.get())),
			"food/dragon_stew", finished, enabled(CRItems.PINK_DRAGON_FRUIT), enabled(CRItems.DRAGON_STEW));
		wrap(CookingPotRecipeBuilder.cookingPotRecipe(CRItems.LUCUMA_GAZPACHO.get(), 1, 200, 1F, Items.BOWL)
				.addIngredient(CRItemTags.FRUITS_LUCUMA)
				.addIngredient(ModItems.PUMPKIN_SLICE.get())
				.addIngredient(ForgeTags.VEGETABLES_ONION)
				.addIngredient(ForgeTags.VEGETABLES_TOMATO)
				.unlockedBy("has_lucuma", has(CRItemTags.FRUITS_LUCUMA)),
			"food/lucuma_gazpacho", finished, enabled(CRItems.LUCUMA), enabled(CRItems.LUCUMA_GAZPACHO));
		wrap(CookingPotRecipeBuilder.cookingPotRecipe(CRItems.HONEY_LIME_CHICKEN.get(), 1, 200, 1F, Items.BOWL)
				.addIngredient(ForgeTags.RAW_CHICKEN)
				.addIngredient(Items.HONEY_BOTTLE)
				.addIngredient(CRItemTags.FRUITS_LIME)
				.addIngredient(ForgeTags.VEGETABLES_ONION)
				.addIngredient(ForgeTags.GRAIN_RICE)
				.unlockedBy("has_lime", has(CRItemTags.FRUITS_LIME)),
			"food/honey_lime_chicken", finished, enabled(CRItems.HONEY_LIME_CHICKEN));
		wrap(CookingPotRecipeBuilder.cookingPotRecipe(CRItems.MEDITERRANEAN_SALMON.get(), 1, 200, 1F, Items.BOWL)
				.addIngredient(ForgeTags.RAW_FISHES_SALMON)
				.addIngredient(CRItems.LIME_SLICE.get())
				.addIngredient(ForgeTags.VEGETABLES_POTATO)
				.addIngredient(ForgeTags.VEGETABLES_TOMATO)
				.addIngredient(ForgeTags.VEGETABLES_ONION)
				.unlockedBy("has_lime_slice", has(CRItems.LIME_SLICE.get())),
			"food/mediterranean_salmon", finished, enabled(CRItems.LIME), enabled(CRItems.LIME_SLICE), enabled(CRItems.MEDITERRANEAN_SALMON));
		wrap(CookingPotRecipeBuilder.cookingPotRecipe(CRItems.POTATO_FRITTERS.get(), 1, 200, 1F)
				.addIngredient(ForgeTags.VEGETABLES_POTATO)
				.addIngredient(ForgeTags.VEGETABLES_ONION)
				.addIngredient(CRItemTags.FRUITS_LIME)
				.unlockedBy("has_lime", has(CRItemTags.FRUITS_LIME)),
			"food/potato_fritters", finished, enabled(CRItems.LIME), enabled(CRItems.POTATO_FRITTERS));
		wrap(CookingPotRecipeBuilder.cookingPotRecipe(CRItems.CANDIED_LIME.get(), 3, 200, 1F)
				.addIngredient(CRItems.LIME_SLICE.get(), 3)
				.addIngredient(Items.HONEY_BOTTLE)
				.unlockedBy("has_lime_slice", has(CRItems.LIME_SLICE.get())),
			"food/candied_lime", finished, enabled(CRItems.LIME), enabled(CRItems.LIME_SLICE), enabled(CRItems.CANDIED_LIME));
		wrap(CookingPotRecipeBuilder.cookingPotRecipe(CRItems.CRIMSON_CARROT_ROAST.get(), 1, 200, 1F, Items.BOWL)
				.addIngredient(Items.CARROT)
				.addIngredient(CRItemTags.FRUITS_POMEGRANATE)
				.addIngredient(Items.CRIMSON_FUNGUS)
				.addIngredient(Items.WARPED_ROOTS)
				.unlockedBy("has_pomegranate_slice", has(CRItemTags.FRUITS_POMEGRANATE)),
			"food/crimson_carrot_roast", finished, enabled(CRItems.POMEGRANATE), enabled(CRItems.CRIMSON_CARROT_ROAST));
		wrap(CookingPotRecipeBuilder.cookingPotRecipe(CRItems.POMEGRANATE_MUTTON.get(), 1, 200, 1F, Items.BOWL)
				.addIngredient(ForgeTags.RAW_MUTTON)
				.addIngredient(CRItemTags.FRUITS_POMEGRANATE)
				.addIngredient(ForgeTags.VEGETABLES_ONION)
				.addIngredient(Items.WARPED_FUNGUS)
				.unlockedBy("has_pomegranate_slice", has(CRItemTags.FRUITS_POMEGRANATE)),
			"food/pomegranate_mutton", finished, enabled(CRItems.POMEGRANATE), enabled(CRItems.POMEGRANATE_MUTTON));
		wrap(CookingPotRecipeBuilder.cookingPotRecipe(CRItems.POMEGRANATE_PORK.get(), 1, 200, 1F, Items.BOWL)
				.addIngredient(ForgeTags.RAW_PORK)
				.addIngredient(Items.HONEY_BOTTLE)
				.addIngredient(CRItemTags.FRUITS_POMEGRANATE)
				.addIngredient(ForgeTags.VEGETABLES_ONION)
				.addIngredient(Items.CARROT)
				.unlockedBy("has_pomegranate_slice", has(CRItemTags.FRUITS_POMEGRANATE)),
			"food/pomegranate_pork", finished, enabled(CRItems.POMEGRANATE), enabled(CRItems.POMEGRANATE_PORK));
		wrap(CookingPotRecipeBuilder.cookingPotRecipe(CRItems.POMEGRANATE_PORK.get(), 1, 200, 1F, Items.BOWL)
				.addIngredient(CRItemTags.RAW_HOGLIN)
				.addIngredient(Items.HONEY_BOTTLE)
				.addIngredient(CRItemTags.FRUITS_POMEGRANATE)
				.addIngredient(ForgeTags.VEGETABLES_ONION)
				.addIngredient(Items.CARROT)
				.unlockedBy("has_raw_hoglin", has(CRItemTags.RAW_HOGLIN)),
			"food/pomegranate_pork_from_hoglin", finished, enabled(CRItems.POMEGRANATE), enabled(CRItems.POMEGRANATE_PORK), not(tagEmpty(CRItemTags.RAW_HOGLIN)));
		wrap(CookingPotRecipeBuilder.cookingPotRecipe(CRItems.POMEGRANATE_CHICKEN.get(), 1, 200, 1F, Items.BOWL)
				.addIngredient(ForgeTags.RAW_CHICKEN)
				.addIngredient(CRItemTags.FRUITS_POMEGRANATE)
				.addIngredient(ForgeTags.VEGETABLES_ONION)
				.addIngredient(Items.CRIMSON_FUNGUS)
				.addIngredient(Items.WARPED_FUNGUS)
				.addIngredient(ForgeTags.VEGETABLES_TOMATO)
				.unlockedBy("has_pomegranate_slice", has(CRItemTags.FRUITS_POMEGRANATE)),
			"food/pomegranate_chicken", finished, enabled(CRItems.POMEGRANATE), enabled(CRItems.POMEGRANATE_CHICKEN));
		wrap(CookingPotRecipeBuilder.cookingPotRecipe(CRItems.POMEGRANATE_CUSTARD.get(), 1, 200, 1F, Items.GLASS_BOTTLE)
				.addIngredient(CRItemTags.FRUITS_POMEGRANATE)
				.addIngredient(ForgeTags.MILK)
				.addIngredient(Tags.Items.EGGS)
				.addIngredient(Items.SUGAR)
				.unlockedBy("has_pomegranate_slice", has(CRItemTags.FRUITS_POMEGRANATE)),
			"food/pomegranate_custard", finished, enabled(CRItems.POMEGRANATE), enabled(CRItems.POMEGRANATE_CUSTARD));
		wrap(CookingPotRecipeBuilder.cookingPotRecipe(CRItems.GLAZED_STRIDER.get(), 1, 200, 1F, Items.BOWL)
				.addIngredient(CRItemTags.RAW_STRIDER)
				.addIngredient(CRItemTags.FRUITS_POMEGRANATE)
				.addIngredient(Items.CRIMSON_FUNGUS)
				.addIngredient(Items.CRIMSON_ROOTS)
				.unlockedBy("has_pomegranate_slice", has(CRItemTags.FRUITS_POMEGRANATE)),
			"food/glazed_strider", finished, enabled(CRItems.POMEGRANATE), enabled(CRItems.GLAZED_STRIDER), not(tagEmpty(CRItemTags.RAW_STRIDER)));
		wrap(CookingPotRecipeBuilder.cookingPotRecipe(CRItems.SPICY_GRENADINE_JELLY.get(), 1, 200, 1F, Items.BOWL)
				.addIngredient(Ingredient.of(CRItemTags.HOT_NETHER_FRUITS), 2)
				.addIngredient(Items.MAGMA_CREAM, 2)
				.addIngredient(CRItemTags.FRUITS_POMEGRANATE)
				.unlockedBy("has_pomegranate_slice", has(CRItemTags.FRUITS_POMEGRANATE)),
			"food/spicy_grenadine_jelly", finished, enabled(CRItems.POMEGRANATE), enabled(CRItems.SPICY_GRENADINE_JELLY), not(tagEmpty(CRItemTags.HOT_NETHER_FRUITS)));
		wrap(CookingPotRecipeBuilder.cookingPotRecipe(CRItems.CHIEFTAIN_CRAB.get(), 1, 600, 6F, Items.BOWL)
				.addIngredient(CRItems.CHIEFTAIN_CRAB_BUCKET.get())
				.addIngredient(ForgeTags.VEGETABLES_CARROT)
				.addIngredient(ForgeTags.VEGETABLES_ONION)
				.addIngredient(ForgeTags.VEGETABLES_TOMATO)
				.addIngredient(Items.DRIED_KELP)
				.unlockedBy("has_crab_bucket", has(CRItems.CHIEFTAIN_CRAB_BUCKET.get())),
			"food/chieftain_crab", finished, enabled(CRItems.CHIEFTAIN_CRAB));
		wrap(CookingPotRecipeBuilder.cookingPotRecipe(CRItems.CRAB_LASAGNA.get(), 1, 200, 1F, Items.BOWL)
				.addIngredient(CRItemTags.CHEESE_MILD_CREAM)
				.addIngredient(ModItems.TOMATO_SAUCE.get())
				.addIngredient(ForgeTags.PASTA_RAW_PASTA)
				.addIngredient(Ingredient.of(CRItemTags.COOKED_CRAB_MEAT), 2)
				.unlockedBy("has_cooked_crab", has(CRItemTags.COOKED_CRAB_MEAT)),
			"food/crab_lasagna", finished, enabled(CRItems.CRAB_LASAGNA));
		wrap(CookingPotRecipeBuilder.cookingPotRecipe(CRItems.CRAB_NOODLES.get(), 1, 200, 1F, Items.BOWL)
				.addIngredient(Ingredient.of(CRItemTags.COOKED_CRAB_MEAT), 2)
				.addIngredient(ForgeTags.PASTA_RAW_PASTA)
				.addIngredient(ForgeTags.MILK)
				.addIngredient(ForgeTags.VEGETABLES_TOMATO)
				.addIngredient(ForgeTags.VEGETABLES_ONION),
			"food/crab_noodles", finished, enabled(CRItems.CRAB_NOODLES));
		wrap(CookingPotRecipeBuilder.cookingPotRecipe(CRItems.BUTTERED_LEGS.get(), 1, 200, 1F, Items.BOWL)
				.addIngredient(CRItems.CHIEFTAIN_LEG.get(), 3)
				.addIngredient(ForgeTags.MILK)
				.unlockedBy("has_chieftain_leg", has(CRItems.CHIEFTAIN_LEG.get())),
			"food/buttered_legs", finished, enabled(CRItems.BUTTERED_LEGS));
		wrap(CookingPotRecipeBuilder.cookingPotRecipe(CRItems.CLAM_CHOWDER.get(), 1, 200, 1F, Items.BREAD)
				.addIngredient(CRItemTags.RAW_CLAM)
				.addIngredient(ForgeTags.MILK)
				.addIngredient(ForgeTags.VEGETABLES_ONION)
				.addIngredient(Items.DRIED_KELP)
				.unlockedBy("has_clam_meat", has(CRItems.CLAM_MEAT.get())),
			"food/clam_chowder", finished, enabled(CRItems.CLAM_CHOWDER));
		wrap(CookingPotRecipeBuilder.cookingPotRecipe(CRItems.CLAM_PASTA.get(), 1, 200, 1F, Items.BOWL)
				.addIngredient(CRItemTags.RAW_CLAM)
				.addIngredient(ForgeTags.PASTA_RAW_PASTA)
				.addIngredient(ForgeTags.MILK)
				.addIngredient(Tags.Items.EGGS)
				.addIngredient(ForgeTags.VEGETABLES_TOMATO)
				.addIngredient(ForgeTags.VEGETABLES_ONION)
				.unlockedBy("has_clam_meat", has(CRItems.CLAM_MEAT.get())),
			"food/clam_pasta", finished, enabled(CRItems.CLAM_PASTA));
		wrap(CookingPotRecipeBuilder.cookingPotRecipe(CRItems.CLAM_MEATBALL_STEW.get(), 1, 200, 1F, Items.BOWL)
				.addIngredient(CRItemTags.RAW_CLAM)
				.addIngredient(ModItems.MINCED_BEEF.get())
				.addIngredient(ModItems.TOMATO_SAUCE.get())
				.addIngredient(ForgeTags.VEGETABLES_CARROT)
				.unlockedBy("has_clam_meat", has(CRItems.CLAM_MEAT.get())),
			"food/clam_meatball_stew", finished, enabled(CRItems.CLAM_MEATBALL_STEW));
		wrap(CookingPotRecipeBuilder.cookingPotRecipe(CRItems.PRAWN_NOODLES.get(), 1, 200, 1F, Items.BOWL)
				.addIngredient(CRItemTags.COOKED_PRAWN)
				.addIngredient(ForgeTags.PASTA_RAW_PASTA)
				.addIngredient(ForgeTags.VEGETABLES_ONION)
				.addIngredient(Items.DRIED_KELP)
				.unlockedBy("has_cooked_prawn", has(CRItemTags.COOKED_PRAWN)),
			"food/prawn_noodles", finished, enabled(CRItems.PRAWN_NOODLES));
		wrap(CookingPotRecipeBuilder.cookingPotRecipe(CRItems.SALMON_WRAPPED_PRAWN.get(), 1, 200, 1F)
				.addIngredient(CRItemTags.COOKED_PRAWN)
				.addIngredient(ModItems.SALMON_SLICE.get())
				.addIngredient(CRItems.LIME_SLICE.get())
				.addIngredient(Items.HONEY_BOTTLE)
				.unlockedBy("has_cooked_prawn", has(CRItemTags.COOKED_PRAWN)),
			"food/salmon_wrapped_prawn", finished, enabled(CRItems.SALMON_WRAPPED_PRAWN), enabled(CRItems.LIME_SLICE));
		wrap(CookingPotRecipeBuilder.cookingPotRecipe(CRItems.PRAWN_STEW.get(), 1, 200, 1F, Items.BOWL)
				.addIngredient(CRItemTags.COOKED_PRAWN)
				.addIngredient(ForgeTags.MILK)
				.addIngredient(Tags.Items.EGGS)
				.addIngredient(ForgeTags.VEGETABLES_POTATO)
				.unlockedBy("has_cooked_prawn", has(CRItemTags.COOKED_PRAWN)),
			"food/prawn_stew", finished, enabled(CRItems.PRAWN_STEW));
		wrap(CookingPotRecipeBuilder.cookingPotRecipe(CRItems.PLATINUM_BASS_STEW.get(), 1, 200, 1F, Items.BOWL)
				.addIngredient(CRItems.PLATINUM_BASS_HEAD.get())
				.addIngredient(CRItems.PLATINUM_BASS_SLICE.get())
				.addIngredient(ForgeTags.GRAIN_RICE)
				.addIngredient(CRItems.LIME_SLICE.get())
				.unlockedBy("has_platinum_bass_head", has(CRItems.PLATINUM_BASS_HEAD.get())),
			"food/platinum_bass_stew", finished, enabled(CRItems.PLATINUM_BASS_STEW), enabled(CRItems.LIME_SLICE));
		wrap(CookingPotRecipeBuilder.cookingPotRecipe(CRItems.CREAM_CHEESE.get(), 1, 12000, 1F, Items.BOWL)
				.addIngredient(ForgeTags.MILK)
				.addIngredient(Ingredient.of(CRItemTags.FRUITS_LIME), 2)
				.unlockedBy("has_lime", has(CRItemTags.FRUITS_LIME)),
			"food/cream_cheese", finished, enabled(CRItems.LIME), enabled(CRItems.CREAM_CHEESE), not(modLoaded("brewinandchewin")));

		// Crafting
		wrap(shapeless(RecipeCategory.BUILDING_BLOCKS, CRItems.PINK_DRAGON_FRUIT.get(), 9)
				.requires(CRBlocks.PINK_DRAGON_FRUIT_CRATE.get())
				.unlockedBy("has_pink_dragon_fruit_crate", has(CRBlocks.PINK_DRAGON_FRUIT_CRATE.get())),
			"pink_dragon_fruit_from_pink_dragon_fruit_crate", finished, enabled(CRItems.PINK_DRAGON_FRUIT), enabled(CRBlocks.PINK_DRAGON_FRUIT_CRATE));
		wrap(shapeless(RecipeCategory.BUILDING_BLOCKS, CRBlocks.PINK_DRAGON_FRUIT_CRATE.get().asItem())
				.requires(CRItems.PINK_DRAGON_FRUIT.get(), 9)
				.unlockedBy("has_pink_dragon_fruit", has(CRItems.PINK_DRAGON_FRUIT.get())),
			"pink_dragon_fruit_crate", finished, enabled(CRItems.PINK_DRAGON_FRUIT), enabled(CRBlocks.PINK_DRAGON_FRUIT_CRATE));
		wrap(shapeless(RecipeCategory.BUILDING_BLOCKS, CRItems.LUCUMA.get(), 9)
				.requires(CRBlocks.LUCUMA_CRATE.get())
				.unlockedBy("has_lucuma_crate", has(CRBlocks.LUCUMA_CRATE.get())),
			"lucuma_from_lucuma_crate", finished, enabled(CRItems.LUCUMA), enabled(CRBlocks.LUCUMA_CRATE));
		wrap(shapeless(RecipeCategory.BUILDING_BLOCKS, CRBlocks.LUCUMA_CRATE.get().asItem())
				.requires(CRItems.LUCUMA.get(), 9)
				.unlockedBy("has_lucuma", has(CRItems.LUCUMA.get())),
			"lucuma_crate", finished, enabled(CRItems.LUCUMA), enabled(CRBlocks.LUCUMA_CRATE));
		wrap(shapeless(RecipeCategory.BUILDING_BLOCKS, CRItems.GILDED_LUCUMA.get(), 9)
				.requires(CRBlocks.GILDED_LUCUMA_CRATE.get())
				.unlockedBy("has_gilded_lucuma_crate", has(CRBlocks.GILDED_LUCUMA_CRATE.get())),
			"gilded_lucuma_from_gilded_lucuma_crate", finished, enabled(CRItems.LUCUMA), enabled(CRItems.GILDED_LUCUMA), enabled(CRBlocks.GILDED_LUCUMA_CRATE));
		wrap(shapeless(RecipeCategory.BUILDING_BLOCKS, CRBlocks.GILDED_LUCUMA_CRATE.get().asItem())
				.requires(CRItems.GILDED_LUCUMA.get(), 9)
				.unlockedBy("has_gilded_lucuma", has(CRItems.GILDED_LUCUMA.get())),
			"gilded_lucuma_crate", finished, enabled(CRItems.LUCUMA), enabled(CRItems.GILDED_LUCUMA), enabled(CRBlocks.GILDED_LUCUMA_CRATE));
		wrap(shapeless(RecipeCategory.BUILDING_BLOCKS, CRItems.LIME.get(), 9)
				.requires(CRBlocks.LIME_CRATE.get())
				.unlockedBy("has_lime_crate", has(CRBlocks.LIME_CRATE.get())),
			"lime_from_lime_crate", finished, enabled(CRItems.LIME), enabled(CRBlocks.LIME_CRATE));
		wrap(shapeless(RecipeCategory.BUILDING_BLOCKS, CRBlocks.LIME_CRATE.get().asItem())
				.requires(CRItems.LIME.get(), 9)
				.unlockedBy("has_lime", has(CRItems.LIME.get())),
			"lime_crate", finished, enabled(CRItems.LIME), enabled(CRBlocks.LIME_CRATE));
		wrap(shapeless(RecipeCategory.BUILDING_BLOCKS, CRItems.POMEGRANATE.get(), 9)
				.requires(CRBlocks.POMEGRANATE_CRATE.get())
				.unlockedBy("has_pomegranate_crate", has(CRBlocks.POMEGRANATE_CRATE.get())),
			"pomegranate_from_pomegranate_crate", finished, enabled(CRItems.POMEGRANATE), enabled(CRBlocks.POMEGRANATE_CRATE));
		wrap(shapeless(RecipeCategory.BUILDING_BLOCKS, CRBlocks.POMEGRANATE_CRATE.get().asItem())
				.requires(CRItems.POMEGRANATE.get(), 9)
				.unlockedBy("has_pomegranate", has(CRItems.POMEGRANATE.get())),
			"pomegranate_crate", finished, enabled(CRItems.POMEGRANATE), enabled(CRBlocks.POMEGRANATE_CRATE));
		wrap(shapeless(RecipeCategory.BUILDING_BLOCKS, CRItems.STYGIAN_POMEGRANATE.get(), 9)
				.requires(CRBlocks.STYGIAN_POMEGRANATE_CRATE.get())
				.unlockedBy("has_stygian_pomegranate_crate", has(CRBlocks.STYGIAN_POMEGRANATE_CRATE.get())),
			"stygian_pomegranate_from_stygian_pomegranate_crate", finished, enabled(CRItems.STYGIAN_POMEGRANATE), enabled(CRBlocks.STYGIAN_POMEGRANATE_CRATE));
		wrap(shapeless(RecipeCategory.BUILDING_BLOCKS, CRBlocks.STYGIAN_POMEGRANATE_CRATE.get().asItem())
				.requires(CRItems.STYGIAN_POMEGRANATE.get(), 9)
				.unlockedBy("has_stygian_pomegranate", has(CRItems.STYGIAN_POMEGRANATE.get())),
			"stygian_pomegranate_crate", finished, enabled(CRItems.STYGIAN_POMEGRANATE), enabled(CRBlocks.STYGIAN_POMEGRANATE_CRATE));
		wrap(shapeless(RecipeCategory.MISC, CRItems.LIME_SEEDS.get(), 1)
				.requires(CRItems.LIME.get())
				.unlockedBy("has_lime", has(CRItems.LIME.get())),
			"lime_seeds_from_lime", finished, enabled(CRItems.LIME), enabled(CRItems.LIME_SEEDS));
		wrap(shapeless(RecipeCategory.MISC, CRItems.POMEGRANATE_SEEDS.get(), 1)
				.requires(CRItems.POMEGRANATE_SLICE.get())
				.unlockedBy("has_pomegranate_slice", has(CRItems.POMEGRANATE_SLICE.get())),
			"pomegranate_seeds_from_slice", finished, enabled(CRItems.POMEGRANATE), enabled(CRItems.POMEGRANATE_SLICE), enabled(CRItems.POMEGRANATE_SEEDS));
		wrap(shapeless(RecipeCategory.MISC, CRItems.DRAGON_FRUIT_SEEDS.get(), 1)
				.requires(CRItems.PINK_DRAGON_FRUIT.get())
				.unlockedBy("has_pink_dragon_fruit", has(CRItems.PINK_DRAGON_FRUIT.get())),
			"dragon_fruit_seeds_from_pink_dragon_fruit", finished, enabled(CRItems.PINK_DRAGON_FRUIT), enabled(CRItems.DRAGON_FRUIT_SEEDS));
		wrap(shapeless(RecipeCategory.MISC, Items.PURPLE_DYE, 1)
				.group("purple_dye")
				.requires(CRBlocks.DAMSELFLOWER.get(), 1)
				.unlockedBy("has_damselflower", has(CRBlocks.DAMSELFLOWER.get())),
			"purple_dye_from_damselflower", finished, enabled(CRBlocks.DAMSELFLOWER));
		wrap(shapeless(RecipeCategory.MISC, Items.LIGHT_BLUE_DYE, 1)
				.group("light_blue_dye")
				.requires(CRBlocks.MOONTEAR.get(), 1)
				.unlockedBy("has_moontear", has(CRBlocks.MOONTEAR.get())),
			"light_blue_dye_from_moontear", finished, enabled(CRBlocks.MOONTEAR));
		wrap(shapeless(RecipeCategory.MISC, Items.WHITE_DYE, 1)
				.group("white_dye")
				.requires(CRBlocks.SKULL_LILY.get(), 1)
				.unlockedBy("has_skull_lily", has(CRBlocks.SKULL_LILY.get())),
			"white_dye_from_skull_lily", finished, enabled(CRBlocks.SKULL_LILY));
		wrap(shapeless(RecipeCategory.MISC, Items.PINK_DYE, 2)
				.group("pink_dye")
				.requires(CRBlocks.BULBOUS_ROSE.get(), 1)
				.unlockedBy("has_bulbous_rose", has(CRBlocks.BULBOUS_ROSE.get())),
			"pink_dye_from_bulbous_rose", finished, enabled(CRBlocks.BULBOUS_ROSE));
		wrap(shapeless(RecipeCategory.MISC, Items.RED_DYE, 2)
				.group("red_dye")
				.requires(CRBlocks.HEARTPETALS.get(), 1)
				.unlockedBy("has_heartpetals", has(CRBlocks.HEARTPETALS.get())),
			"red_dye_from_heartpetals", finished, enabled(CRBlocks.HEARTPETALS));
		wrap(shapeless(RecipeCategory.FOOD, CRItems.TROPICAL_SHAVED_ICE.get())
				.requires(Items.BOWL)
				.requires(CRItemTags.FRUITS_STRAWBERRY)
				.requires(CRItems.PINK_DRAGON_FRUIT.get())
				.requires(CRItemTags.ICE_CUBES)
				.unlockedBy("has_pink_dragon_fruit", has(CRItems.PINK_DRAGON_FRUIT.get())),
			"food/tropical_shaved_ice", finished, enabled(CRItems.TROPICAL_SHAVED_ICE), modLoaded("neapolitan"), not(tagEmpty(CRItemTags.FRUITS_STRAWBERRY)));
		wrap(shapeless(RecipeCategory.FOOD, CRItems.DRAGONS_PASSION.get())
				.requires(Items.GLASS_BOTTLE)
				.requires(CRItems.PINK_DRAGON_FRUIT.get(), 2)
				.requires(CRItemTags.PASSION_FRUIT)
				.requires(Ingredient.of(Items.SUGAR, Items.HONEY_BOTTLE))
				.unlockedBy("has_pink_dragon_fruit", has(CRItems.PINK_DRAGON_FRUIT.get())),
			"food/dragons_passion", finished, enabled(CRItems.DRAGONS_PASSION), modLoaded("atmospheric"), not(tagEmpty(CRItemTags.PASSION_FRUIT)));
		wrap(shapeless(RecipeCategory.FOOD, CRItems.PORTOBELLO_WRAP.get())
				.requires(ForgeTags.BREAD)
				.requires(CRItems.BAKED_PORTOBELLO_CAP.get())
				.requires(ForgeTags.VEGETABLES_ONION)
				.requires(ForgeTags.SALAD_INGREDIENTS_CABBAGE)
				.requires(ForgeTags.VEGETABLES_CARROT)
				.unlockedBy("has_baked_portobello_cap", has(CRItems.BAKED_PORTOBELLO_CAP.get())),
			"food/portobello_wrap", finished, enabled(CRItems.PORTOBELLO), enabled(CRItems.PORTOBELLO_WRAP), tagEmpty(CRItemTags.TORTILLA));
		wrap(shapeless(RecipeCategory.FOOD, CRItems.PORTOBELLO_WRAP.get())
				.requires(CRItemTags.TORTILLA)
				.requires(CRItems.BAKED_PORTOBELLO_CAP.get())
				.requires(ForgeTags.VEGETABLES_ONION)
				.requires(ForgeTags.SALAD_INGREDIENTS_CABBAGE)
				.requires(ForgeTags.VEGETABLES_CARROT)
				.unlockedBy("has_baked_portobello_cap", has(CRItems.BAKED_PORTOBELLO_CAP.get())),
			"food/portobello_wrap_from_tortilla", finished, enabled(CRItems.PORTOBELLO), enabled(CRItems.PORTOBELLO_WRAP), not(tagEmpty(CRItemTags.TORTILLA)));
		wrap(shapeless(RecipeCategory.FOOD, CRItems.PORTOBELLO_BURGER.get())
				.requires(ForgeTags.BREAD)
				.requires(CRItems.BAKED_PORTOBELLO_CAP.get())
				.requires(ForgeTags.SALAD_INGREDIENTS_CABBAGE)
				.requires(ForgeTags.VEGETABLES_TOMATO)
				.requires(ForgeTags.VEGETABLES_ONION)
				.unlockedBy("has_baked_portobello_cap", has(CRItems.BAKED_PORTOBELLO_CAP.get())),
			"food/portobello_burger", finished, enabled(CRItems.PORTOBELLO_BURGER), tagEmpty(CRItemTags.BURGER_BUN));
		wrap(shapeless(RecipeCategory.FOOD, CRItems.PORTOBELLO_BURGER.get())
				.requires(CRItemTags.BURGER_BUN)
				.requires(CRItems.BAKED_PORTOBELLO_CAP.get())
				.requires(ForgeTags.SALAD_INGREDIENTS_CABBAGE)
				.requires(ForgeTags.VEGETABLES_TOMATO)
				.requires(ForgeTags.VEGETABLES_ONION)
				.unlockedBy("has_baked_portobello_cap", has(CRItems.BAKED_PORTOBELLO_CAP.get())),
			"food/portobello_burger_from_bun", finished, enabled(CRItems.PORTOBELLO_BURGER), not(tagEmpty(CRItemTags.BURGER_BUN)));
		wrap(shapeless(RecipeCategory.FOOD, CRItems.LUCUMA_BREAD.get())
				.requires(ForgeTags.DOUGH)
				.requires(CRItemTags.FRUITS_LUCUMA)
				.requires(Items.SUGAR)
				.unlockedBy("has_lucuma", has(CRItemTags.FRUITS_LUCUMA)),
			"food/lucuma_bread", finished, enabled(CRItems.LUCUMA), enabled(CRItems.LUCUMA_BREAD));
		wrap(shapeless(RecipeCategory.FOOD, CRItems.LUCUMA_PUDDING.get())
				.requires(CRItemTags.FRUITS_LUCUMA)
				.requires(Items.SUGAR)
				.requires(ForgeTags.EGGS)
				.requires(ForgeTags.MILK)
				.requires(Items.GLASS_BOTTLE)
				.unlockedBy("has_lucuma", has(CRItemTags.FRUITS_LUCUMA)),
			"food/lucuma_pudding", finished, enabled(CRItems.LUCUMA), enabled(CRItems.LUCUMA_PUDDING));
		wrap(shapeless(RecipeCategory.FOOD, CRItems.LIMEADE.get())
				.requires(Ingredient.of(CRItemTags.FRUITS_LIME), 2)
				.requires(Items.SUGAR)
				.requires(Items.GLASS_BOTTLE)
				.unlockedBy("has_lime", has(CRItemTags.FRUITS_LIME)),
			"food/limeade", finished, enabled(CRItems.LIMEADE));
		wrap(shapeless(RecipeCategory.FOOD, CRItems.BERRY_LIMEADE.get())
				.requires(CRItems.LIMEADE.get(), 1)
				.requires(Ingredient.of(ForgeTags.BERRIES), 2)
				.unlockedBy("has_limeade", has(CRItems.LIMEADE.get())),
			"food/berry_limeade", finished, enabled(CRItems.BERRY_LIMEADE));
		wrap(shapeless(RecipeCategory.FOOD, CRItems.PINK_LIMEADE.get())
				.requires(CRItems.LIMEADE.get(), 1)
				.requires(Ingredient.of(CRItemTags.FRUITS_POMEGRANATE), 2)
				.unlockedBy("has_limeade", has(CRItems.LIMEADE.get())),
			"food/pink_limeade", finished, enabled(CRItems.PINK_LIMEADE));
		wrap(shapeless(RecipeCategory.FOOD, CRItems.MINT_LIMEADE.get())
				.requires(CRItems.LIMEADE.get(), 1)
				.requires(Ingredient.of(CRItemTags.MINT_LEAVES), 2)
				.unlockedBy("has_limeade", has(CRItems.LIMEADE.get())),
			"food/mint_limeade", finished, enabled(CRItems.MINT_LIMEADE), modLoaded("neapolitan"), not(tagEmpty(CRItemTags.MINT_LEAVES)));
		wrap(shapeless(RecipeCategory.FOOD, CRItems.POMEGRANATE_SMOOTHIE.get())
				.requires(Ingredient.of(CRItemTags.FRUITS_POMEGRANATE), 2)
				.requires(Ingredient.of(CRItemTags.FRUITS_BANANA), 1)
				.requires(Ingredient.of(CRItemTags.ICE_CUBES))
				.requires(Items.GLASS_BOTTLE)
				.unlockedBy("has_pomegranate", has(CRItemTags.FRUITS_POMEGRANATE)),
			"food/pomegranate_smoothie", finished, enabled(CRItems.POMEGRANATE_SMOOTHIE), modLoaded("neapolitan"), not(tagEmpty(CRItemTags.FRUITS_BANANA)), not(tagEmpty(CRItemTags.ICE_CUBES)));
		wrap(shapeless(RecipeCategory.FOOD, CRItems.SALMON_TARTARE.get())
				.requires(ModItems.SALMON_SLICE.get(), 3)
				.requires(CRItems.LIME_SLICE.get(), 2)
				.requires(Items.BOWL)
				.unlockedBy("has_lime_slice", has(CRItems.LIME_SLICE.get())),
			"food/salmon_tartare", finished, enabled(CRItems.LIME), enabled(CRItems.LIME_SLICE), enabled(CRItems.SALMON_TARTARE));
		wrap(shapeless(RecipeCategory.FOOD, CRItems.COD_CEVICHE.get())
				.requires(ForgeTags.RAW_FISHES_COD)
				.requires(CRItems.LIME_SLICE.get())
				.requires(ForgeTags.SALAD_INGREDIENTS_CABBAGE)
				.requires(ForgeTags.VEGETABLES_TOMATO)
				.requires(ForgeTags.VEGETABLES_ONION)
				.requires(Items.BOWL)
				.unlockedBy("has_lime_slice", has(CRItems.LIME_SLICE.get())),
			"food/cod_ceviche", finished, enabled(CRItems.LIME), enabled(CRItems.LIME_SLICE), enabled(CRItems.COD_CEVICHE));
		wrap(shapeless(RecipeCategory.FOOD, CRItems.DELUXE_SALAD.get())
				.requires(Items.APPLE)
				.requires(ForgeTags.SALAD_INGREDIENTS_CABBAGE)
				.requires(Items.MELON_SLICE)
				.requires(CRItemTags.FRUITS_POMEGRANATE)
				.requires(CRItemTags.FRUITS_LIME)
				.requires(Items.SWEET_BERRIES)
				.requires(ForgeTags.VEGETABLES_TOMATO)
				.requires(Items.BOWL)
				.unlockedBy("has_lime", has(CRItemTags.FRUITS_LIME)),
			"food/deluxe_salad", finished, enabled(CRItems.DELUXE_SALAD));
		wrap(shapeless(RecipeCategory.FOOD, CRItems.POMEGRANATE_BEAN_SALAD.get())
				.requires(CRItemTags.FRUITS_POMEGRANATE)
				.requires(CRItemTags.ROASTED_ADZUKI_BEANS)
				.requires(ForgeTags.VEGETABLES_TOMATO)
				.requires(ForgeTags.VEGETABLES_ONION)
				.requires(Items.BOWL)
				.unlockedBy("has_pomegranate", has(CRItemTags.FRUITS_POMEGRANATE)),
			"food/pomegranate_bean_salad", finished, enabled(CRItems.POMEGRANATE_BEAN_SALAD), not(tagEmpty(CRItemTags.ROASTED_ADZUKI_BEANS)), modLoaded("neapolitan"));
		wrap(shapeless(RecipeCategory.FOOD, CRItems.CHOCOLATE_ARILS.get())
				.requires(CRItemTags.SEEDS_POMEGRANATE)
				.requires(CRItemTags.CHOCOLATE_BAR)
				.unlockedBy("has_pomegranate_seeds", has(CRItemTags.SEEDS_POMEGRANATE)),
			"food/chocolate_arils", finished, enabled(CRItems.CHOCOLATE_ARILS), not(tagEmpty(CRItemTags.CHOCOLATE_BAR)), modLoaded("neapolitan"));
		wrap(shapeless(RecipeCategory.FOOD, CRItems.STRAWBERRY_JAM_BUN.get())
				.requires(ForgeTags.DOUGH)
				.requires(ForgeTags.MILK)
				.requires(CRItemTags.FRUITS_LIME)
				.requires(Ingredient.of(CRItemTags.FRUITS_STRAWBERRY), 2)
				.unlockedBy("has_strawberries", has(CRItemTags.FRUITS_STRAWBERRY)),
			"food/strawberry_jam_bun", finished, enabled(CRItems.STRAWBERRY_JAM_BUN), enabled(CRItems.LIME), not(tagEmpty(CRItemTags.FRUITS_STRAWBERRY)), modLoaded("neapolitan"), not(itemExists("sob", "strawberry_jam")));
		wrap(shapeless(RecipeCategory.FOOD, CRItems.BIG_RICE_BALL.get())
				.requires(Items.DRIED_KELP)
				.requires(ModItems.COOKED_RICE.get(), 3)
				.requires(CRItemTags.COOKED_CRAB_MEAT)
				.unlockedBy("has_cooked_crab", has(CRItemTags.COOKED_CRAB_MEAT)),
			"food/big_rice_ball", finished, enabled(CRItems.BIG_RICE_BALL));
		wrap(shapeless(RecipeCategory.FOOD, CRItems.LAND_AND_SEA_BURGER.get())
				.requires(ForgeTags.BREAD)
				.requires(CRItems.BAKED_PORTOBELLO_CAP.get())
				.requires(CRItems.CHIEFTAIN_CLAW.get())
				.requires(ModItems.BEEF_PATTY.get())
				.requires(ForgeTags.VEGETABLES_TOMATO)
				.requires(ForgeTags.VEGETABLES_ONION)
				.unlockedBy("has_chieftain_claw", has(CRItems.CHIEFTAIN_CLAW.get())),
			"food/land_and_sea_burger", finished, enabled(CRItems.LAND_AND_SEA_BURGER), tagEmpty(CRItemTags.BURGER_BUN));
		wrap(shapeless(RecipeCategory.FOOD, CRItems.LAND_AND_SEA_BURGER.get())
				.requires(CRItemTags.BURGER_BUN)
				.requires(CRItems.BAKED_PORTOBELLO_CAP.get())
				.requires(CRItems.CHIEFTAIN_CLAW.get())
				.requires(ModItems.BEEF_PATTY.get())
				.requires(ForgeTags.VEGETABLES_TOMATO)
				.requires(ForgeTags.VEGETABLES_ONION)
				.unlockedBy("has_chieftain_claw", has(CRItems.CHIEFTAIN_CLAW.get())),
			"food/land_and_sea_burger_from_bun", finished, enabled(CRItems.LAND_AND_SEA_BURGER), not(tagEmpty(CRItemTags.BURGER_BUN)));
		wrap(shapeless(RecipeCategory.FOOD, CRItems.CLAM_ROLL.get())
				.requires(Ingredient.of(CRItemTags.RAW_CLAM), 2)
				.requires(ModItems.COOKED_RICE.get())
				.unlockedBy("has_raw_claw", has(CRItemTags.RAW_CLAM)),
			"food/clam_roll", finished, enabled(CRItems.CLAM_ROLL));
		wrap(shapeless(RecipeCategory.FOOD, CRItems.UNI_ROLL.get())
				.requires(CRItems.UNI.get())
				.requires(ModItems.COOKED_RICE.get())
				.requires(Items.DRIED_KELP)
				.unlockedBy("has_uni", has(CRItems.UNI.get())),
			"food/uni_roll", finished, enabled(CRItems.UNI_ROLL));
		wrap(shapeless(RecipeCategory.FOOD, CRItems.PRAWN_ROLL.get())
				.requires(Ingredient.of(CRItemTags.RAW_PRAWN), 2)
				.requires(ModItems.COOKED_RICE.get())
				.unlockedBy("has_raw_prawn", has(CRItemTags.RAW_PRAWN)),
			"food/prawn_roll", finished, enabled(CRItems.PRAWN_ROLL));
		wrap(shapeless(RecipeCategory.FOOD, CRItems.PRAWN_PO_BOY.get())
				.requires(ForgeTags.BREAD)
				.requires(CRItemTags.COOKED_PRAWN)
				.requires(Tags.Items.EGGS)
				.requires(ForgeTags.SALAD_INGREDIENTS_CABBAGE)
				.requires(ForgeTags.VEGETABLES_TOMATO)
				.requires(ForgeTags.VEGETABLES_ONION)
				.unlockedBy("has_cooked_prawn", has(CRItemTags.COOKED_PRAWN)),
			"food/prawn_po_boy", finished, enabled(CRItems.PRAWN_PO_BOY));
		wrap(shapeless(RecipeCategory.FOOD, CRItems.PRAWN_CEVICHE.get())
				.requires(CRItemTags.COOKED_PRAWN)
				.requires(CRItems.LIME_SLICE.get())
				.requires(ForgeTags.SALAD_INGREDIENTS_CABBAGE)
				.requires(ForgeTags.VEGETABLES_TOMATO)
				.requires(ForgeTags.VEGETABLES_ONION)
				.requires(Items.BOWL)
				.unlockedBy("has_cooked_prawn", has(CRItemTags.COOKED_PRAWN)),
			"food/prawn_ceviche", finished, enabled(CRItems.LIME), enabled(CRItems.LIME_SLICE), enabled(CRItems.PRAWN_CEVICHE));
		wrap(shapeless(RecipeCategory.FOOD, CRItems.FISH_MIX.get())
				.requires(ModItems.SALMON_SLICE.get())
				.requires(ModItems.COD_SLICE.get())
				.requires(CRItems.PLATINUM_BASS_SLICE.get())
				.requires(ForgeTags.SALAD_INGREDIENTS_CABBAGE)
				.requires(ForgeTags.VEGETABLES_TOMATO)
				.requires(ForgeTags.VEGETABLES_ONION)
				.requires(Items.BOWL)
				.unlockedBy("has_slice", has(CRItems.PLATINUM_BASS_SLICE.get())),
			"food/fish_mix", finished, enabled(CRItems.FISH_MIX));
		wrap(shapeless(RecipeCategory.FOOD, CRItems.SEA_WRAP.get())
				.requires(ForgeTags.BREAD)
				.requires(CRItems.CHIEFTAIN_CLAW.get())
				.requires(CRItemTags.RAW_CLAM)
				.requires(CRItemTags.COOKED_PRAWN)
				.requires(ModItems.COOKED_COD_SLICE.get())
				.requires(ModItems.COOKED_SALMON_SLICE.get())
				.requires(Items.DRIED_KELP)
				.requires(ModItems.COOKED_RICE.get())
				.unlockedBy("has_claw", has(CRItems.CHIEFTAIN_CLAW.get())),
			"food/sea_wrap", finished, enabled(CRItems.SEA_WRAP), tagEmpty(CRItemTags.TORTILLA));
		wrap(shapeless(RecipeCategory.FOOD, CRItems.SEA_WRAP.get())
				.requires(CRItemTags.TORTILLA)
				.requires(CRItems.CHIEFTAIN_CLAW.get())
				.requires(CRItemTags.RAW_CLAM)
				.requires(ForgeTags.COOKED_FISHES_COD)
				.requires(ForgeTags.COOKED_FISHES_SALMON)
				.requires(CRItemTags.COOKED_PRAWN)
				.requires(Items.DRIED_KELP)
				.requires(ModItems.COOKED_RICE.get())
				.unlockedBy("has_claw", has(CRItems.CHIEFTAIN_CLAW.get())),
			"food/sea_wrap_from_tortilla", finished, enabled(CRItems.SEA_WRAP), not(tagEmpty(CRItemTags.TORTILLA)));

		// Shaped Crafting
		wrap(shaped(RecipeCategory.FOOD, CRItems.GILDED_LUCUMA.get())
				.pattern("ggg")
				.pattern("glg")
				.pattern("ggg")
				.define('g', Tags.Items.INGOTS_GOLD)
				.define('l', CRItems.LUCUMA.get())
				.unlockedBy("has_lucuma", has(CRItems.LUCUMA.get())),
			"food/gilded_lucuma", finished, enabled(CRItems.LUCUMA), enabled(CRItems.GILDED_LUCUMA));
		wrap(shaped(RecipeCategory.COMBAT, CRItems.SHIMMERING_PEARL.get(), 2)
				.pattern(" p ")
				.pattern("pep")
				.pattern(" p ")
				.define('p', CRItems.LUNAR_PEARL.get())
				.define('e', Items.ENDER_PEARL)
				.unlockedBy("has_lunar_pearl", has(CRItems.LUNAR_PEARL.get())),
			"shimmering_pearl", finished, enabled(CRItems.SHIMMERING_PEARL));
		wrap(shaped(RecipeCategory.FOOD, CRItems.SHIMMERING_APPLE.get(), 2)
				.pattern("ppp")
				.pattern("pap")
				.pattern("ppp")
				.define('p', CRItems.LUNAR_PEARL.get())
				.define('a', Items.GOLDEN_APPLE)
				.unlockedBy("has_lunar_pearl", has(CRItems.LUNAR_PEARL.get())),
			"food/shimmering_apple", finished, enabled(CRItems.SHIMMERING_APPLE));
		wrap(shaped(RecipeCategory.TOOLS, CRItems.PEARLY_CLAW.get(), 1)
				.pattern(" p ")
				.pattern("pcp")
				.pattern(" h ")
				.define('c', CRItems.CHIEFTAIN_CLAW.get())
				.define('p', CRItems.LUNAR_PEARL.get())
				.define('h', Items.HEART_OF_THE_SEA)
				.unlockedBy("has_chieftain_claw", has(CRItems.CHIEFTAIN_CLAW.get())),
			"pearly_claw", finished, enabled(CRItems.PEARLY_CLAW));
		wrap(shaped(RecipeCategory.FOOD, CRItems.PANETTONE.get())
				.pattern("bcn")
				.pattern("bcn")
				.pattern("mds")
				.define('b', ForgeTags.BERRIES)
				.define('c', CRItemTags.FRUITS_CITRUS)
				.define('n', CRItemTags.COOKED_NUTS)
				.define('m', ForgeTags.MILK)
				.define('d', ForgeTags.DOUGH)
				.define('s', Items.SUGAR)
				.unlockedBy("has_roasted_nuts", has(CRItemTags.COOKED_NUTS)),
			"food/panettone", finished, enabled(CRItems.PANETTONE), not(tagEmpty(CRItemTags.COOKED_NUTS)));
		wrap(ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, CRItems.PANETTONE.get(), 1)
				.requires(CRItems.PANETTONE_SLICE.get(), 4)
				.unlockedBy("has_panettone_slice", has(CRItems.PANETTONE_SLICE.get())),
			"food/panettone_from_slices", finished, enabled(CRItems.PANETTONE), enabled(CRItems.PANETTONE_SLICE), not(tagEmpty(CRItemTags.COOKED_NUTS)));
		wrap(shaped(RecipeCategory.FOOD, CRItems.PORTOBELLO_QUICHE.get())
				.pattern("pop")
				.pattern("mcm")
				.pattern("ere")
				.define('p', CRItemTags.MUSHROOMS_PORTOBELLO)
				.define('o', ForgeTags.VEGETABLES_ONION)
				.define('m', ForgeTags.MILK)
				.define('c', CRItemTags.CHEESE)
				.define('e', Tags.Items.EGGS)
				.define('r', ModItems.PIE_CRUST.get())
				.unlockedBy("has_portobello", has(CRItemTags.MUSHROOMS_PORTOBELLO)),
			"food/portobello_quiche", finished, enabled(CRItems.PORTOBELLO_QUICHE));
		wrap(ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, CRItems.PORTOBELLO_QUICHE.get(), 1)
				.requires(CRItems.PORTOBELLO_QUICHE_SLICE.get(), 4)
				.unlockedBy("has_portobello_quiche_slice", has(CRItems.PORTOBELLO_QUICHE_SLICE.get())),
			"food/portobello_quiche_from_slices", finished, enabled(CRItems.PORTOBELLO_QUICHE), enabled(CRItems.PORTOBELLO_QUICHE_SLICE));
		wrap(shaped(RecipeCategory.FOOD, CRItems.LIME_PIE.get())
				.pattern("lll")
				.pattern("mmm")
				.pattern("scs")
				.define('l', CRItemTags.FRUITS_LIME)
				.define('s', Items.SUGAR)
				.define('m', ForgeTags.MILK_BOTTLE)
				.define('c', ModItems.PIE_CRUST.get())
				.unlockedBy("has_lime", has(CRItemTags.FRUITS_LIME)),
			"food/lime_pie", finished, enabled(CRItems.LIME), enabled(CRItems.LIME_PIE));
		wrap(shaped(RecipeCategory.FOOD, CRItems.LIME_PIE.get())
				.pattern("lll")
				.pattern("lll")
				.pattern("mcm")
				.define('l', CRItems.LIME_SLICE.get())
				.define('m', CRItemTags.CONDENSED_MILK)
				.define('c', ModItems.PIE_CRUST.get())
				.unlockedBy("has_lime_slice", has(CRItems.LIME_SLICE.get())),
			"food/lime_pie_from_condensed_milk", finished, enabled(CRItems.LIME), enabled(CRItems.LIME_SLICE), enabled(CRItems.LIME_PIE), not(tagEmpty(CRItemTags.CONDENSED_MILK)));
		wrap(ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, CRItems.LIME_PIE.get(), 1)
				.requires(CRItems.LIME_PIE_SLICE.get(), 4)
				.unlockedBy("has_lime_pie_slice", has(CRItems.LIME_PIE_SLICE.get())),
			"food/lime_pie_from_slices", finished, enabled(CRItems.LIME), enabled(CRItems.LIME_PIE), enabled(CRItems.LIME_PIE_SLICE));
		wrap(ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, CRItems.LIME_COOKIE.get(), 8)
				.requires(CRItemTags.FRUITS_LIME)
				.requires(ForgeTags.GRAIN_WHEAT)
				.requires(ForgeTags.GRAIN_WHEAT)
				.unlockedBy("has_lime", has(CRItemTags.FRUITS_LIME)),
			"food/lime_cookie", finished, enabled(CRItems.LIME), enabled(CRItems.LIME_COOKIE));
		wrap(shaped(RecipeCategory.FOOD, CRItems.LIME_CAKE.get())
				.pattern("mlm")
				.pattern("ses")
				.pattern("wlw")
				.define('e', Tags.Items.EGGS)
				.define('m', ForgeTags.MILK)
				.define('l', CRItemTags.FRUITS_LIME)
				.define('s', Items.SUGAR)
				.define('w', ForgeTags.GRAIN_WHEAT)
				.unlockedBy("has_lime", has(CRItemTags.FRUITS_LIME)),
			"food/lime_cake", finished, enabled(CRItems.LIME), enabled(CRItems.LIME_CAKE));
		wrap(ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, CRItems.LIME_CAKE.get(), 1)
				.requires(CRItems.LIME_CAKE_SLICE.get(), 7)
				.unlockedBy("has_lime_cake_slice", has(CRItems.LIME_CAKE_SLICE.get())),
			"food/lime_cake_from_slices", finished, enabled(CRItems.LIME), enabled(CRItems.LIME_CAKE), enabled(CRItems.LIME_CAKE_SLICE));
		wrap(shaped(RecipeCategory.FOOD, CRItems.POMEGRANATE_CAKE.get())
				.pattern("mpm")
				.pattern("ses")
				.pattern("wpw")
				.define('e', Tags.Items.EGGS)
				.define('m', ForgeTags.MILK)
				.define('p', CRItems.POMEGRANATE_SLICE.get())
				.define('s', Items.SUGAR)
				.define('w', ForgeTags.GRAIN_WHEAT)
				.unlockedBy("has_pomegranate", has(CRItems.POMEGRANATE_SLICE.get())),
			"food/pomegranate_cake", finished, enabled(CRItems.POMEGRANATE), enabled(CRItems.POMEGRANATE_SLICE), enabled(CRItems.POMEGRANATE_CAKE));
		wrap(ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, CRItems.POMEGRANATE_CAKE.get(), 1)
				.requires(CRItems.POMEGRANATE_CAKE_SLICE.get(), 7)
				.unlockedBy("has_pomegranate_cake_slice", has(CRItems.POMEGRANATE_CAKE_SLICE.get())),
			"food/pomegranate_cake_from_slices", finished, enabled(CRItems.POMEGRANATE), enabled(CRItems.POMEGRANATE_SLICE), enabled(CRItems.POMEGRANATE_CAKE), enabled(CRItems.POMEGRANATE_CAKE_SLICE));
		wrap(shaped(RecipeCategory.FOOD, CRItems.PINK_DRAGON_FRUIT_CAKE.get())
				.pattern("mpm")
				.pattern("ses")
				.pattern("wpw")
				.define('e', Tags.Items.EGGS)
				.define('m', ForgeTags.MILK)
				.define('p', CRItems.PINK_DRAGON_FRUIT.get())
				.define('s', Items.SUGAR)
				.define('w', ForgeTags.GRAIN_WHEAT)
				.unlockedBy("has_pink_dragon_fruit", has(CRItems.PINK_DRAGON_FRUIT.get())),
			"food/pink_dragon_fruit_cake", finished, enabled(CRItems.PINK_DRAGON_FRUIT), enabled(CRItems.PINK_DRAGON_FRUIT_CAKE));
		wrap(ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, CRItems.PINK_DRAGON_FRUIT_CAKE.get(), 1)
				.requires(CRItems.PINK_DRAGON_FRUIT_CAKE_SLICE.get(), 7)
				.unlockedBy("has_pink_dragon_fruit_cake_slice", has(CRItems.PINK_DRAGON_FRUIT_CAKE_SLICE.get())),
			"food/pink_dragon_fruit_cake_from_slices", finished, enabled(CRItems.PINK_DRAGON_FRUIT), enabled(CRItems.PINK_DRAGON_FRUIT_CAKE), enabled(CRItems.PINK_DRAGON_FRUIT_CAKE_SLICE));
		wrap(shaped(RecipeCategory.FOOD, CRItems.LUCUMA_CAKE.get())
				.pattern("mlm")
				.pattern("ses")
				.pattern("wlw")
				.define('e', Tags.Items.EGGS)
				.define('m', ForgeTags.MILK)
				.define('l', CRItemTags.FRUITS_LUCUMA)
				.define('s', Items.SUGAR)
				.define('w', ForgeTags.GRAIN_WHEAT)
				.unlockedBy("has_lucuma", has(CRItemTags.FRUITS_LUCUMA)),
			"food/lucuma_cake", finished, enabled(CRItems.LUCUMA), enabled(CRItems.LUCUMA_CAKE));
		wrap(ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, CRItems.LUCUMA_CAKE.get(), 1)
				.requires(CRItems.LUCUMA_CAKE_SLICE.get(), 7)
				.unlockedBy("has_lucuma_cake_slice", has(CRItems.LUCUMA_CAKE_SLICE.get())),
			"food/lucuma_cake_from_slices", finished, enabled(CRItems.LUCUMA), enabled(CRItems.LUCUMA_CAKE), enabled(CRItems.LUCUMA_CAKE_SLICE));
		wrap(ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, CRItems.URCHIN_DART.get())
				.pattern("n")
				.pattern("c")
				.pattern("f")
				.define('n', CRItems.URCHIN_NEEDLE.get())
				.define('c', CRItemTags.NUGGETS_COPPER)
				.define('f', Tags.Items.FEATHERS)
				.unlockedBy("has_urchin_needle", has(CRItems.URCHIN_NEEDLE.get())),
			"urchin_dart_from_nugget", finished, enabled(CRItems.URCHIN_DART), not(tagEmpty(CRItemTags.NUGGETS_COPPER)));
		wrap(ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, CRItems.URCHIN_DART.get())
				.pattern("n")
				.pattern("c")
				.pattern("f")
				.define('n', CRItems.URCHIN_NEEDLE.get())
				.define('c', Tags.Items.INGOTS_COPPER)
				.define('f', Tags.Items.FEATHERS)
				.unlockedBy("has_urchin_needle", has(CRItems.URCHIN_NEEDLE.get())),
			"urchin_dart", finished, enabled(CRItems.URCHIN_DART), tagEmpty(CRItemTags.NUGGETS_COPPER));
		wrap(ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, CRBlocks.URCHIN_TEST_BLOCK.get().asItem())
				.pattern("xxx")
				.pattern("xxx")
				.pattern("xxx")
				.define('x', CRItems.URCHIN_TEST.get())
				.unlockedBy("has_urchin_test", has(CRItems.URCHIN_TEST.get())),
			"urchin_test_block", finished, enabled(CRItems.URCHIN_TEST), enabled(CRBlocks.URCHIN_TEST_BLOCK));
		wrap(ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, CRItems.URCHIN_TEST.get(), 9)
				.requires(CRBlocks.URCHIN_TEST_BLOCK.get(), 1)
				.unlockedBy("has_urchin_test_block", has(CRBlocks.URCHIN_TEST_BLOCK.get())),
			"unpack_urchin_test_block", finished, enabled(CRItems.URCHIN_TEST), enabled(CRBlocks.URCHIN_TEST_BLOCK));
		wrap(ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, CRBlocks.URCHIN_TEST_BRICKS.get(), 4)
				.pattern("xx")
				.pattern("xx")
				.define('x', CRBlocks.URCHIN_TEST_BLOCK.get())
				.unlockedBy("has_urchin_test_block", has(CRBlocks.URCHIN_TEST_BLOCK.get())),
			"urchin_test_bricks", finished, enabled(CRItems.URCHIN_TEST), enabled(CRBlocks.URCHIN_TEST_BRICKS));
		wrap(ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, CRBlocks.URCHIN_TEST_BRICK_SLAB.get(), 6)
				.pattern("xxx")
				.define('x', CRBlocks.URCHIN_TEST_BRICKS.get())
				.unlockedBy("has_urchin_test_bricks", has(CRBlocks.URCHIN_TEST_BRICKS.get())),
			"urchin_test_brick_slab", finished, enabled(CRItems.URCHIN_TEST), enabled(CRBlocks.URCHIN_TEST_BRICK_SLAB));
		wrap(ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, CRBlocks.URCHIN_TEST_BRICK_STAIRS.get(), 4)
				.pattern("x  ")
				.pattern("xx ")
				.pattern("xxx")
				.define('x', CRBlocks.URCHIN_TEST_BRICKS.get())
				.unlockedBy("has_urchin_test_bricks", has(CRBlocks.URCHIN_TEST_BRICKS.get())),
			"urchin_test_brick_stairs", finished, enabled(CRItems.URCHIN_TEST), enabled(CRBlocks.URCHIN_TEST_BRICK_STAIRS));
		wrap(ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, CRBlocks.URCHIN_TEST_BRICK_WALL.get(), 6)
				.pattern("xxx")
				.pattern("xxx")
				.define('x', CRBlocks.URCHIN_TEST_BRICKS.get())
				.unlockedBy("has_urchin_test_bricks", has(CRBlocks.URCHIN_TEST_BRICKS.get())),
			"urchin_test_brick_wall", finished, enabled(CRItems.URCHIN_TEST), enabled(CRBlocks.URCHIN_TEST_BRICK_WALL));
		wrap(ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, CRBlocks.URCHIN_TEST_TILES.get(), 4)
				.pattern("xx")
				.pattern("xx")
				.define('x', CRBlocks.URCHIN_TEST_BRICKS.get())
				.unlockedBy("has_urchin_test_bricks", has(CRBlocks.URCHIN_TEST_BRICKS.get())),
			"urchin_test_tiles", finished, enabled(CRItems.URCHIN_TEST), enabled(CRBlocks.URCHIN_TEST_TILES));
		wrap(ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, CRBlocks.URCHIN_TEST_TILE_SLAB.get(), 6)
				.pattern("xxx")
				.define('x', CRBlocks.URCHIN_TEST_TILES.get())
				.unlockedBy("has_urchin_test_tiles", has(CRBlocks.URCHIN_TEST_TILES.get())),
			"urchin_test_tile_slab", finished, enabled(CRItems.URCHIN_TEST), enabled(CRBlocks.URCHIN_TEST_TILE_SLAB));
		wrap(ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, CRBlocks.URCHIN_TEST_TILE_STAIRS.get(), 4)
				.pattern("x  ")
				.pattern("xx ")
				.pattern("xxx")
				.define('x', CRBlocks.URCHIN_TEST_TILES.get())
				.unlockedBy("has_urchin_test_tiles", has(CRBlocks.URCHIN_TEST_TILES.get())),
			"urchin_test_tile_stairs", finished, enabled(CRItems.URCHIN_TEST), enabled(CRBlocks.URCHIN_TEST_BRICK_STAIRS));
		wrap(ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, CRBlocks.URCHIN_TEST_TILE_WALL.get(), 6)
				.pattern("xxx")
				.pattern("xxx")
				.define('x', CRBlocks.URCHIN_TEST_TILES.get())
				.unlockedBy("has_urchin_test_tiles", has(CRBlocks.URCHIN_TEST_TILES.get())),
			"urchin_test_tile_wall", finished, enabled(CRItems.URCHIN_TEST), enabled(CRBlocks.URCHIN_TEST_TILE_WALL));
		wrap(ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, CRBlocks.CHISELED_URCHIN_TEST_BRICKS.get())
				.pattern("x")
				.pattern("x")
				.define('x', CRBlocks.URCHIN_TEST_BRICK_SLAB.get())
				.unlockedBy("has_urchin_test_brick_slab", has(CRBlocks.URCHIN_TEST_BRICK_SLAB.get())),
			"chiseled_urchin_test_bricks", finished, enabled(CRItems.URCHIN_TEST), enabled(CRBlocks.CHISELED_URCHIN_TEST_BRICKS));

		// Neapolitan Compat
		wrap(shapeless(RecipeCategory.FOOD, CRItems.LIME_ICE_CREAM.get())
				.requires(Items.BOWL)
				.requires(CRItemTags.FRUITS_LIME)
				.requires(ForgeTags.MILK)
				.requires(CRItemTags.ICE_CUBES)
				.requires(Items.SUGAR)
				.unlockedBy("has_lime", has(CRItemTags.FRUITS_LIME)),
			"food/lime_ice_cream", finished, enabled(CRItems.LIME_ICE_CREAM), not(tagEmpty(CRItemTags.ICE_CUBES)), modLoaded("neapolitan"));
		wrap(shapeless(RecipeCategory.FOOD, CRItems.LIME_MILKSHAKE.get(), 3)
				.requires(Items.GLASS_BOTTLE, 3)
				.requires(CRItems.LIME_ICE_CREAM.get())
				.requires(ForgeTags.MILK)
				.unlockedBy("has_lime_ice_cream", has(CRItems.LIME_ICE_CREAM.get())),
			"food/lime_milkshake", finished, enabled(CRItems.LIME_ICE_CREAM), enabled(CRItems.LIME_MILKSHAKE), modLoaded("neapolitan"));
		wrap(shaped(RecipeCategory.BUILDING_BLOCKS, CRBlocks.LIME_ICE_CREAM_BLOCK.get().asItem(), 8)
				.pattern("sss")
				.pattern("sis")
				.pattern("sss")
				.define('s', Blocks.SNOW_BLOCK)
				.define('i', CRItems.LIME_ICE_CREAM.get())
				.unlockedBy("has_lime_ice_cream", has(CRItems.LIME_ICE_CREAM.get())),
			"lime_ice_cream_block", finished, enabled(CRBlocks.LIME_ICE_CREAM_BLOCK), enabled(CRItems.LIME_ICE_CREAM), modLoaded("neapolitan"));
		wrap(shapeless(RecipeCategory.FOOD, CRItems.POMEGRANATE_ICE_CREAM.get())
				.requires(Items.BOWL)
				.requires(CRItems.POMEGRANATE_SLICE.get())
				.requires(ForgeTags.MILK)
				.requires(CRItemTags.ICE_CUBES)
				.requires(Items.SUGAR)
				.unlockedBy("has_pomegranate", has(CRItems.POMEGRANATE_SLICE.get())),
			"food/pomegranate_ice_cream", finished, enabled(CRItems.POMEGRANATE_ICE_CREAM), not(tagEmpty(CRItemTags.ICE_CUBES)), modLoaded("neapolitan"));
		wrap(shapeless(RecipeCategory.FOOD, CRItems.POMEGRANATE_MILKSHAKE.get(), 3)
				.requires(Items.GLASS_BOTTLE, 3)
				.requires(CRItems.POMEGRANATE_ICE_CREAM.get())
				.requires(ForgeTags.MILK)
				.unlockedBy("has_pomegranate_ice_cream", has(CRItems.POMEGRANATE_ICE_CREAM.get())),
			"food/pomegranate_milkshake", finished, enabled(CRItems.POMEGRANATE_ICE_CREAM), enabled(CRItems.POMEGRANATE_MILKSHAKE), modLoaded("neapolitan"));
		wrap(shaped(RecipeCategory.BUILDING_BLOCKS, CRBlocks.POMEGRANATE_ICE_CREAM_BLOCK.get().asItem(), 8)
				.pattern("sss")
				.pattern("sis")
				.pattern("sss")
				.define('s', Blocks.SNOW_BLOCK)
				.define('i', CRItems.POMEGRANATE_ICE_CREAM.get())
				.unlockedBy("has_pomegranate_ice_cream", has(CRItems.POMEGRANATE_ICE_CREAM.get())),
			"pomegranate_ice_cream_block", finished, enabled(CRBlocks.POMEGRANATE_ICE_CREAM_BLOCK), enabled(CRItems.POMEGRANATE_ICE_CREAM), modLoaded("neapolitan"));
		wrap(shapeless(RecipeCategory.FOOD, CRItems.PINK_DRAGON_FRUIT_ICE_CREAM.get())
				.requires(Items.BOWL)
				.requires(CRItems.PINK_DRAGON_FRUIT.get())
				.requires(ForgeTags.MILK)
				.requires(CRItemTags.ICE_CUBES)
				.requires(Items.SUGAR)
				.unlockedBy("has_pink_dragon_fruit", has(CRItems.PINK_DRAGON_FRUIT.get())),
			"food/pink_dragon_fruit_ice_cream", finished, enabled(CRItems.PINK_DRAGON_FRUIT_ICE_CREAM), not(tagEmpty(CRItemTags.ICE_CUBES)), modLoaded("neapolitan"));
		wrap(shapeless(RecipeCategory.FOOD, CRItems.PINK_DRAGON_FRUIT_MILKSHAKE.get(), 3)
				.requires(Items.GLASS_BOTTLE, 3)
				.requires(CRItems.PINK_DRAGON_FRUIT_ICE_CREAM.get())
				.requires(ForgeTags.MILK)
				.unlockedBy("has_pink_dragon_fruit_ice_cream", has(CRItems.PINK_DRAGON_FRUIT_ICE_CREAM.get())),
			"food/pink_dragon_fruit_milkshake", finished, enabled(CRItems.PINK_DRAGON_FRUIT_ICE_CREAM), enabled(CRItems.PINK_DRAGON_FRUIT_MILKSHAKE), modLoaded("neapolitan"));
		wrap(shaped(RecipeCategory.BUILDING_BLOCKS, CRBlocks.PINK_DRAGON_FRUIT_ICE_CREAM_BLOCK.get().asItem(), 8)
				.pattern("sss")
				.pattern("sis")
				.pattern("sss")
				.define('s', Blocks.SNOW_BLOCK)
				.define('i', CRItems.PINK_DRAGON_FRUIT_ICE_CREAM.get())
				.unlockedBy("has_pink_dragon_fruit_ice_cream", has(CRItems.PINK_DRAGON_FRUIT_ICE_CREAM.get())),
			"pink_dragon_fruit_ice_cream_block", finished, enabled(CRBlocks.PINK_DRAGON_FRUIT_ICE_CREAM_BLOCK), enabled(CRItems.PINK_DRAGON_FRUIT_ICE_CREAM), modLoaded("neapolitan"));
		wrap(shapeless(RecipeCategory.FOOD, CRItems.LUCUMA_ICE_CREAM.get())
				.requires(Items.BOWL)
				.requires(CRItems.LUCUMA.get())
				.requires(ForgeTags.MILK)
				.requires(CRItemTags.ICE_CUBES)
				.requires(Items.SUGAR)
				.unlockedBy("has_lucuma", has(CRItems.LUCUMA.get())),
			"food/lucuma_ice_cream", finished, enabled(CRItems.LUCUMA_ICE_CREAM), not(tagEmpty(CRItemTags.ICE_CUBES)), modLoaded("neapolitan"));
		wrap(shapeless(RecipeCategory.FOOD, CRItems.LUCUMA_MILKSHAKE.get(), 3)
				.requires(Items.GLASS_BOTTLE, 3)
				.requires(CRItems.LUCUMA_ICE_CREAM.get())
				.requires(ForgeTags.MILK)
				.unlockedBy("has_lucuma_ice_cream", has(CRItems.LUCUMA_ICE_CREAM.get())),
			"food/lucuma_milkshake", finished, enabled(CRItems.LUCUMA_ICE_CREAM), enabled(CRItems.LUCUMA_MILKSHAKE), modLoaded("neapolitan"));
		wrap(shaped(RecipeCategory.BUILDING_BLOCKS, CRBlocks.LUCUMA_ICE_CREAM_BLOCK.get().asItem(), 8)
				.pattern("sss")
				.pattern("sis")
				.pattern("sss")
				.define('s', Blocks.SNOW_BLOCK)
				.define('i', CRItems.LUCUMA_ICE_CREAM.get())
				.unlockedBy("has_lucuma_ice_cream", has(CRItems.LUCUMA_ICE_CREAM.get())),
			"lucuma_ice_cream_block", finished, enabled(CRBlocks.LUCUMA_ICE_CREAM_BLOCK), enabled(CRItems.LUCUMA_ICE_CREAM), modLoaded("neapolitan"));
		wrap(shapeless(RecipeCategory.FOOD, CRItems.SUNNY_ICE_CREAM.get(), 1)
				.requires(Items.BOWL)
				.requires(CRItems.LUCUMA.get())
				.requires(CRItemTags.DRIED_VANILLA_PODS)
				.requires(CRItemTags.FRUITS_STRAWBERRY)
				.requires(ForgeTags.MILK)
				.requires(CRItemTags.ICE_CUBES)
				.requires(Items.SUGAR)
				.unlockedBy("has_lucuma", has(CRItems.LUCUMA.get())),
			"food/sunny_ice_cream", finished, enabled(CRItems.SUNNY_ICE_CREAM), not(tagEmpty(CRItemTags.ICE_CUBES)), modLoaded("neapolitan"));

		// Lucuma Wood
		wrap(shaped(RecipeCategory.BUILDING_BLOCKS, CRBlocks.LUCUMA_WOOD.get().asItem(), 3)
				.pattern("##")
				.pattern("##")
				.define('#', CRBlocks.LUCUMA_LOG.get())
				.unlockedBy("has_lucuma_log", has(CRBlocks.LUCUMA_LOG.get()))
				.showNotification(true)
				.group("bark"),
			"lucuma_wood", finished, enabled(CRItems.LUCUMA), enabled(CRBlocks.LUCUMA_WOOD));
		wrap(shaped(RecipeCategory.BUILDING_BLOCKS, CRBlocks.STRIPPED_LUCUMA_WOOD.get().asItem(), 3)
				.pattern("##")
				.pattern("##")
				.define('#', CRBlocks.STRIPPED_LUCUMA_LOG.get())
				.unlockedBy("has_stripped_lucuma_log", has(CRBlocks.STRIPPED_LUCUMA_LOG.get()))
				.showNotification(true)
				.group("bark"),
			"stripped_lucuma_wood", finished, enabled(CRItems.LUCUMA), enabled(CRBlocks.STRIPPED_LUCUMA_WOOD));
		wrap(shapeless(RecipeCategory.BUILDING_BLOCKS, CRBlocks.LUCUMA_PLANKS.get(), 4)
			.requires(CRItemTags.LUCUMA_LOGS)
			.unlockedBy("has_lucuma_logs", has(CRItemTags.LUCUMA_LOGS))
			.group("planks"),
			"lucuma_planks", finished, enabled(CRItems.LUCUMA), enabled(CRBlocks.LUCUMA_PLANKS));
		wrap(shaped(RecipeCategory.BUILDING_BLOCKS, CRBlocks.LUCUMA_STAIRS.get().asItem(), 4)
			.pattern("#  ")
			.pattern("## ")
			.pattern("###")
			.define('#', CRBlocks.LUCUMA_PLANKS.get())
			.unlockedBy("has_lucuma_planks", has(CRBlocks.LUCUMA_PLANKS.get()))
			.showNotification(true)
			.group("wooden_stairs"),
			"lucuma_stairs", finished, enabled(CRItems.LUCUMA), enabled(CRBlocks.LUCUMA_STAIRS));
		wrap(shaped(RecipeCategory.BUILDING_BLOCKS, CRBlocks.LUCUMA_SLAB.get().asItem(), 6)
			.pattern("###")
			.define('#', CRBlocks.LUCUMA_PLANKS.get())
			.unlockedBy("has_lucuma_planks", has(CRBlocks.LUCUMA_PLANKS.get()))
			.showNotification(true)
			.group("wooden_slab"),
			"lucuma_slab", finished, enabled(CRItems.LUCUMA), enabled(CRBlocks.LUCUMA_SLAB));
		wrap(shaped(RecipeCategory.MISC, CRBlocks.LUCUMA_FENCE.get().asItem(), 3)
			.pattern("W#W")
			.pattern("W#W")
			.define('#', Tags.Items.RODS_WOODEN)
			.define('W', CRBlocks.LUCUMA_PLANKS.get())
			.unlockedBy("has_lucuma_planks", has(CRBlocks.LUCUMA_PLANKS.get()))
			.showNotification(true)
			.group("wooden_fence"),
			"lucuma_fence", finished, enabled(CRItems.LUCUMA), enabled(CRBlocks.LUCUMA_FENCE));
		wrap(shaped(RecipeCategory.REDSTONE, CRBlocks.LUCUMA_FENCE_GATE.get().asItem(), 1)
			.pattern("#W#")
			.pattern("#W#")
			.define('#', Tags.Items.RODS_WOODEN)
			.define('W', CRBlocks.LUCUMA_PLANKS.get())
			.unlockedBy("has_lucuma_planks", has(CRBlocks.LUCUMA_PLANKS.get()))
			.showNotification(true)
			.group("wooden_fence_gate"),
			"lucuma_fence_gate", finished, enabled(CRItems.LUCUMA), enabled(CRBlocks.LUCUMA_FENCE_GATE));
		wrap(shaped(RecipeCategory.REDSTONE, CRBlocks.LUCUMA_DOOR.get().asItem(), 3)
			.pattern("##")
			.pattern("##")
			.pattern("##")
			.define('#', CRBlocks.LUCUMA_PLANKS.get())
			.unlockedBy("has_lucuma_planks", has(CRBlocks.LUCUMA_PLANKS.get()))
			.showNotification(true)
			.group("wooden_door"),
			"lucuma_door", finished, enabled(CRItems.LUCUMA), enabled(CRBlocks.LUCUMA_DOOR));
		wrap(shaped(RecipeCategory.REDSTONE, CRBlocks.LUCUMA_TRAPDOOR.get().asItem(), 2)
			.pattern("###")
			.pattern("###")
			.define('#', CRBlocks.LUCUMA_PLANKS.get())
			.unlockedBy("has_lucuma_planks", has(CRBlocks.LUCUMA_PLANKS.get()))
			.showNotification(true)
			.group("wooden_trapdoor"),
			"lucuma_trapdoor", finished, enabled(CRItems.LUCUMA), enabled(CRBlocks.LUCUMA_TRAPDOOR));
		wrap(shaped(RecipeCategory.REDSTONE, CRBlocks.LUCUMA_PRESSURE_PLATE.get().asItem(), 1)
			.pattern("##")
			.define('#', CRBlocks.LUCUMA_PLANKS.get())
			.unlockedBy("has_lucuma_planks", has(CRBlocks.LUCUMA_PLANKS.get()))
			.showNotification(true)
			.group("wooden_pressure_plate"),
			"lucuma_pressure_plate", finished, enabled(CRItems.LUCUMA), enabled(CRBlocks.LUCUMA_PRESSURE_PLATE));
		wrap(shapeless(RecipeCategory.REDSTONE, CRBlocks.LUCUMA_BUTTON.get(), 1)
			.requires(CRBlocks.LUCUMA_PLANKS.get())
			.unlockedBy("has_lucuma_planks", has(CRBlocks.LUCUMA_PLANKS.get()))
			.group("wooden_button"),
			"lucuma_button", finished, enabled(CRItems.LUCUMA), enabled(CRBlocks.LUCUMA_BUTTON));
		wrap(shaped(RecipeCategory.MISC, CRBlocks.LUCUMA_SIGN.get().asItem(), 3)
			.pattern("###")
			.pattern("###")
			.pattern(" X ")
			.define('#', CRBlocks.LUCUMA_PLANKS.get())
			.define('X', Tags.Items.RODS_WOODEN)
			.unlockedBy("has_lucuma_planks", has(CRBlocks.LUCUMA_PLANKS.get()))
			.showNotification(true)
			.group("wooden_sign"),
			"lucuma_sign", finished, enabled(CRItems.LUCUMA), enabled(CRBlocks.LUCUMA_SIGN));
		wrap(shaped(RecipeCategory.MISC, CRBlocks.LUCUMA_HANGING_SIGN.get().asItem(), 6)
			.pattern("X X")
			.pattern("###")
			.pattern("###")
			.define('#', CRBlocks.STRIPPED_LUCUMA_LOG.get())
			.define('X', Items.CHAIN)
			.unlockedBy("has_stripped_lucuma_log", has(CRBlocks.STRIPPED_LUCUMA_LOG.get()))
			.showNotification(true)
			.group("hanging_sign"),
			"lucuma_hanging_sign", finished, enabled(CRItems.LUCUMA), enabled(CRBlocks.LUCUMA_HANGING_SIGN));
		wrap(shaped(RecipeCategory.MISC, CRBlocks.LUCUMA_CABINET.get().asItem(), 1)
			.pattern("SSS")
			.pattern("T T")
			.pattern("SSS")
			.define('S', CRBlocks.LUCUMA_SLAB.get())
			.define('T', CRBlocks.LUCUMA_TRAPDOOR.get())
			.unlockedBy("has_lucuma_trapdoor", has(CRBlocks.LUCUMA_TRAPDOOR.get()))
			.showNotification(true)
			.group("fd_cabinet"),
			"lucuma_cabinet", finished, enabled(CRItems.LUCUMA), enabled(CRBlocks.LUCUMA_CABINET));

		// Woodworks
		wrap(shaped(RecipeCategory.MISC, CRBlocks.LUCUMA_BEEHIVE.get().asItem(), 1)
			.pattern("###")
			.pattern("HHH")
			.pattern("###")
			.define('#', CRBlocks.LUCUMA_PLANKS.get())
			.define('H', Items.HONEYCOMB)
			.unlockedBy("has_honeycomb", has(Items.HONEYCOMB))
			.showNotification(true)
			.group("wooden_beehive"),
			"lucuma_beehive", finished, enabled(CRItems.LUCUMA), enabled(CRBlocks.LUCUMA_BEEHIVE), modLoaded(Modid.WW.get()));
		wrap(shaped(RecipeCategory.MISC, CRBlocks.LUCUMA_LADDER.get().asItem(), 4)
			.pattern("S S")
			.pattern("S#S")
			.pattern("S S")
			.define('#', CRBlocks.LUCUMA_PLANKS.get())
			.define('S', Tags.Items.RODS_WOODEN)
			.unlockedBy("has_lucuma_planks", has(CRBlocks.LUCUMA_PLANKS.get()))
			.showNotification(true)
			.group("wooden_ladder"),
			"lucuma_ladder", finished, enabled(CRItems.LUCUMA), enabled(CRBlocks.LUCUMA_LADDER), modLoaded(Modid.WW.get()));
		wrap(shaped(RecipeCategory.BUILDING_BLOCKS, CRBlocks.LUCUMA_BOOKSHELF.get().asItem(), 1)
			.pattern("###")
			.pattern("XXX")
			.pattern("###")
			.define('#', CRBlocks.LUCUMA_PLANKS.get())
			.define('X', Items.BOOK)
			.unlockedBy("has_lucuma_planks_and_book", has(CRBlocks.LUCUMA_PLANKS.get(), Items.BOOK))
			.showNotification(true)
			.group("wooden_bookshelf"),
			"lucuma_bookshelf", finished, enabled(CRItems.LUCUMA), enabled(CRBlocks.LUCUMA_BOOKSHELF), modLoaded(Modid.WW.get()));
		wrap(shaped(RecipeCategory.BUILDING_BLOCKS, CRBlocks.CHISELED_LUCUMA_BOOKSHELF.get().asItem(), 1)
			.pattern("###")
			.pattern("XXX")
			.pattern("###")
			.define('#', CRBlocks.LUCUMA_PLANKS.get())
			.define('X', CRBlocks.LUCUMA_SLAB.get())
			.unlockedBy("has_lucuma_planks_and_slab", has(CRBlocks.LUCUMA_PLANKS.get(), CRBlocks.LUCUMA_SLAB.get()))
			.showNotification(true)
			.group("chiseled_wooden_bookshelf"),
			"chiseled_lucuma_bookshelf", finished, enabled(CRItems.LUCUMA), enabled(CRBlocks.CHISELED_LUCUMA_BOOKSHELF), modLoaded(Modid.WW.get()));
		wrap(shaped(RecipeCategory.MISC, CRBlocks.LUCUMA_BOARDS.get().asItem(), 1)
			.pattern("#")
			.pattern("#")
			.define('#', CRBlocks.LUCUMA_SLAB.get())
			.unlockedBy("has_lucuma_slab", has(CRBlocks.LUCUMA_SLAB.get()))
			.showNotification(true)
			.group("wooden_boards"),
			"lucuma_boards", finished, enabled(CRItems.LUCUMA), enabled(CRBlocks.LUCUMA_BOARDS), modLoaded(Modid.WW.get()));
		wrap(shaped(RecipeCategory.MISC, CRBlocks.LUCUMA_CHEST.get().asItem(), 1)
			.pattern("###")
			.pattern("# #")
			.pattern("###")
			.define('#', CRBlocks.LUCUMA_PLANKS.get())
			.unlockedBy("has_lucuma_planks", has(CRBlocks.LUCUMA_PLANKS.get()))
			.showNotification(true)
			.group("wooden_chest"),
			"lucuma_chest", finished, enabled(CRItems.LUCUMA), enabled(CRBlocks.LUCUMA_CHEST), modLoaded(Modid.WW.get()));
		wrap(shapeless(RecipeCategory.REDSTONE, CRBlocks.TRAPPED_LUCUMA_CHEST.get(), 1)
			.requires(CRBlocks.LUCUMA_CHEST.get())
			.requires(Items.TRIPWIRE_HOOK)
			.unlockedBy("has_lucuma_chest", has(CRBlocks.LUCUMA_CHEST.get()))
			.group("wooden_trapped_chest"),
			"trapped_lucuma_chest", finished, enabled(CRItems.LUCUMA), enabled(CRBlocks.TRAPPED_LUCUMA_CHEST), modLoaded(Modid.WW.get()));
		BoatloadRecipeProvider.boatRecipes(finished, CRBoatTypes.LUCUMA);
	}

	private InventoryChangeTrigger.TriggerInstance has(ItemLike... items) {
		return InventoryChangeTrigger.TriggerInstance.hasItems(items);
	}

	private void wrap(RecipeBuilder builder, String name, Consumer<FinishedRecipe> consumer, ICondition... conds) {
		wrap(builder, CollectorsReap.MODID, name, consumer, conds);
	}

	private void wrap(RecipeBuilder builder, String modid, String name, Consumer<FinishedRecipe> consumer, ICondition... conds) {
		ResourceLocation loc = Util.rl(modid, name);
		ConditionalRecipe.Builder cond;
		if (conds.length > 1) {
			cond = ConditionalRecipe.builder().addCondition(and(conds));
		} else if (conds.length == 1) {
			cond = ConditionalRecipe.builder().addCondition(conds[0]);
		} else {
			cond = ConditionalRecipe.builder();
		}
		FinishedRecipe[] recipe = new FinishedRecipe[1];
		builder.save(f -> recipe[0] = f, loc);
		cond.addRecipe(recipe[0])
			.generateAdvancement()
			.build(consumer, loc);
	}

	private void wrap(CookingPotRecipeBuilder builder, String name, Consumer<FinishedRecipe> consumer, ICondition... conds) {
		wrap(builder, CollectorsReap.MODID, name, consumer, conds);
	}

	private void wrap(CookingPotRecipeBuilder builder, String modid, String name, Consumer<FinishedRecipe> consumer, ICondition... conds) {
		ResourceLocation loc = Util.rl(modid, name);
		ConditionalRecipe.Builder cond;
		if (conds.length > 1) {
			cond = ConditionalRecipe.builder().addCondition(and(conds));
		} else if (conds.length == 1) {
			cond = ConditionalRecipe.builder().addCondition(conds[0]);
		} else {
			cond = ConditionalRecipe.builder();
		}
		FinishedRecipe[] recipe = new FinishedRecipe[1];
		builder.build(f -> recipe[0] = f, loc);
		cond.addRecipe(recipe[0])
			.generateAdvancement()
			.build(consumer, loc);
	}

	private ShapelessRecipeBuilder shapeless(RecipeCategory category, ItemLike returns, int... count) {
		if (count.length > 0 && count[0] > 1) {
			return ShapelessRecipeBuilder.shapeless(category, returns, count[0]);
		}
		return ShapelessRecipeBuilder.shapeless(category, returns);
	}

	private ShapelessRecipeBuilder shapeless(RecipeCategory category, Item returns, int... count) {
		if (count.length > 0 && count[0] > 1) {
			return ShapelessRecipeBuilder.shapeless(category, returns, count[0]);
		}
		return ShapelessRecipeBuilder.shapeless(category, returns);
	}

	private ShapedRecipeBuilder shaped(RecipeCategory category, ItemLike returns, int... count) {
		if (count.length > 0 && count[0] > 1) {
			return ShapedRecipeBuilder.shaped(category, returns, count[0]);
		}
		return ShapedRecipeBuilder.shaped(category, returns);
	}

	private EnabledCondition enabled(RegistryObject<? extends ItemLike> item) {
		return new EnabledCondition(Util.name(item));
	}
}
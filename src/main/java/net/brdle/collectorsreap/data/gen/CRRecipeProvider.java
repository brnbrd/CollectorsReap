package net.brdle.collectorsreap.data.gen;

import net.brdle.collectorsreap.Util;
import net.brdle.collectorsreap.CollectorsReap;
import net.brdle.collectorsreap.common.crafting.EnabledCondition;
import net.brdle.collectorsreap.common.item.CRItems;
import net.brdle.collectorsreap.data.CRItemTags;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.ConditionalRecipe;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import org.jetbrains.annotations.NotNull;
import vectorwing.farmersdelight.common.registry.ModItems;
import vectorwing.farmersdelight.common.tag.ForgeTags;
import vectorwing.farmersdelight.data.builder.CookingPotRecipeBuilder;
import vectorwing.farmersdelight.data.builder.CuttingBoardRecipeBuilder;
import java.util.function.Consumer;

public class CRRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public CRRecipeProvider(DataGenerator pGenerator) {
        super(pGenerator);
    }

    @Override
    protected void buildCraftingRecipes(@NotNull Consumer<FinishedRecipe> finished) {
        // Smelting
        foodSmeltingRecipes("baked_portobello_cap", CRItems.PORTOBELLO.get(), CRItems.BAKED_PORTOBELLO_CAP.get(), 0.35F, finished);

        // Cutting
        wrap(CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(CRItems.PORTOBELLO_QUICHE.get()), Ingredient.of(ForgeTags.TOOLS_KNIVES), CRItems.PORTOBELLO_QUICHE_SLICE.get(), 4),
            "cutting/portobello_quiche", finished, enabled("portobello"), enabled("portobello_quiche"));
        wrap(CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(CRItems.PORTOBELLO_COLONY.get()), Ingredient.of(ForgeTags.TOOLS_KNIVES), CRItems.PORTOBELLO.get(), 5),
            "cutting/portobello_colony", finished, enabled("portobello"));
        wrap(CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(CRItems.LIME.get()), Ingredient.of(ForgeTags.TOOLS_KNIVES), CRItems.LIME_SLICE.get(), 2)
            .addResultWithChance(Items.LIME_DYE, 0.25f),
            "cutting/lime", finished, enabled("lime"), enabled("lime_slice"));
        wrap(CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(CRItems.LIME_SLICE.get()), Ingredient.of(ForgeTags.TOOLS_KNIVES), Items.LIME_DYE, 1),
            "cutting/lime_slice", finished, enabled("lime"), enabled("lime_slice"));
        wrap(CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(CRItems.LIME_PIE.get()), Ingredient.of(ForgeTags.TOOLS_KNIVES), CRItems.LIME_PIE_SLICE.get(), 4),
            "cutting/lime_pie", finished, enabled("lime_pie"), enabled("lime_pie"));
        wrap(CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(CRItems.POMEGRANATE.get()), Ingredient.of(ForgeTags.TOOLS_KNIVES), CRItems.POMEGRANATE_SLICE.get(), 4)
            .addResultWithChance(Items.RED_DYE, 0.25f),
            "cutting/pomegranate", finished, enabled("pomegranate"), enabled("pomegranate_seeds"));

        // Cooking Pot
        wrap(CookingPotRecipeBuilder.cookingPotRecipe(CRItems.PORTOBELLO_RISOTTO.get(), 1, 200, 1.0F, Items.BOWL)
                .addIngredient(CRItems.BAKED_PORTOBELLO_CAP.get())
                .addIngredient(ForgeTags.CROPS_RICE)
                .addIngredient(ForgeTags.MILK)
                .addIngredient(ForgeTags.CROPS_ONION)
                .unlockedBy("has_baked_portobello_cap", has(CRItems.BAKED_PORTOBELLO_CAP.get())),
            "food/portobello_risotto", finished, enabled("portobello_risotto"));
        wrap(CookingPotRecipeBuilder.cookingPotRecipe(CRItems.PORTOBELLO_RICE_SOUP.get(), 1, 200, 1.0F, Items.BOWL)
                .addIngredient(CRItems.BAKED_PORTOBELLO_CAP.get())
                .addIngredient(ForgeTags.CROPS_RICE)
                .addIngredient(ForgeTags.CROPS_ONION)
                .addIngredient(ForgeTags.VEGETABLES_CARROT)
                .addIngredient(Items.DRIED_KELP)
                .unlockedBy("has_baked_portobello_cap", has(CRItems.BAKED_PORTOBELLO_CAP.get())),
            "food/portobello_rice_soup", finished, enabled("portobello_rice_soup"));
        wrap(CookingPotRecipeBuilder.cookingPotRecipe(CRItems.STUFFED_PORTOBELLO_CAP.get(), 1, 200, 1.0F, Items.BOWL)
                .addIngredient(CRItems.BAKED_PORTOBELLO_CAP.get())
                .addIngredient(Items.BROWN_MUSHROOM)
                .addIngredient(ForgeTags.CROPS_ONION)
                .addIngredient(ForgeTags.CROPS_TOMATO)
                .unlockedBy("has_baked_portobello_cap", has(CRItems.BAKED_PORTOBELLO_CAP.get())),
            "food/stuffed_portobello_cap", finished, enabled("stuffed_portobello_cap"));
        wrap(CookingPotRecipeBuilder.cookingPotRecipe(CRItems.PORTOBELLO_PASTA.get(), 1, 200, 1.0F, Items.BOWL)
                .addIngredient(CRItems.BAKED_PORTOBELLO_CAP.get())
                .addIngredient(ForgeTags.PASTA_RAW_PASTA)
                .addIngredient(Items.BROWN_MUSHROOM)
                .addIngredient(ForgeTags.CROPS_ONION)
                .addIngredient(ForgeTags.MILK)
                .unlockedBy("has_baked_portobello_cap", has(CRItems.BAKED_PORTOBELLO_CAP.get())),
            "food/portobello_pasta", finished, enabled("portobello_pasta"));
        wrap(CookingPotRecipeBuilder.cookingPotRecipe(CRItems.HONEY_LIME_CHICKEN.get(), 1, 200, 1.0F, Items.BOWL)
                .addIngredient(ForgeTags.RAW_CHICKEN)
                .addIngredient(Items.HONEY_BOTTLE)
                .addIngredient(CRItemTags.LIME_OR_SLICE)
                .addIngredient(ForgeTags.CROPS_ONION)
                .addIngredient(ForgeTags.CROPS_RICE)
                .unlockedBy("has_lime_or_slice", has(CRItemTags.LIME_OR_SLICE)),
            "food/honey_lime_chicken", finished, enabled("honey_lime_chicken"));
        wrap(CookingPotRecipeBuilder.cookingPotRecipe(CRItems.MEDITERRANEAN_SALMON.get(), 1, 200, 1.0F, Items.BOWL)
                .addIngredient(ForgeTags.RAW_FISHES_SALMON)
                .addIngredient(CRItemTags.LIME_OR_SLICE)
                .addIngredient(Tags.Items.CROPS_POTATO)
                .addIngredient(ForgeTags.CROPS_TOMATO)
                .addIngredient(ForgeTags.CROPS_ONION)
                .unlockedBy("has_lime_or_slice", has(CRItemTags.LIME_OR_SLICE)),
            "food/mediterranean_salmon", finished, enabled("mediterranean_salmon"));
        wrap(CookingPotRecipeBuilder.cookingPotRecipe(CRItems.POTATO_FRITTERS.get(), 1, 200, 1.0F, Items.BOWL)
                .addIngredient(Items.BAKED_POTATO)
                .addIngredient(Ingredient.of(CRItemTags.LIME_OR_SLICE), 2)
                .addIngredient(ForgeTags.CROPS_ONION)
                .unlockedBy("has_lime_or_slice", has(CRItemTags.LIME_OR_SLICE)),
            "food/potato_fritters", finished, enabled("potato_fritters"));
        wrap(CookingPotRecipeBuilder.cookingPotRecipe(CRItems.CANDIED_LIME.get(), 3, 200, 1.0F, Items.BOWL)
                .addIngredient(CRItems.LIME_SLICE.get(), 3)
                .addIngredient(Items.HONEY_BOTTLE)
                .unlockedBy("has_lime_slice", has(CRItems.LIME_SLICE.get())),
            "food/candied_lime", finished, enabled("candied_lime"));

        // Crafting
        wrap(ShapelessRecipeBuilder.shapeless(CRItems.POMEGRANATE_SEEDS.get(), 8)
                .requires(CRItems.POMEGRANATE.get())
                .unlockedBy("has_pomegranate", has(CRItems.POMEGRANATE.get())),
            "pomegranate_seeds_from_pomegranate", finished, enabled("pomegranate"), enabled("pomegranate_seeds"));
        wrap(ShapelessRecipeBuilder.shapeless(CRItems.POMEGRANATE_SEEDS.get(), 2)
                .requires(CRItems.POMEGRANATE_SLICE.get())
                .unlockedBy("has_pomegranate_slice", has(CRItems.POMEGRANATE_SLICE.get())),
            "pomegranate_seeds_from_pomegranate_slice", finished, enabled("pomegranate"), enabled("pomegranate_slice"), enabled("pomegranate_seeds"));
        wrap(ShapelessRecipeBuilder.shapeless(CRItems.LIME_SEEDS.get(), 2)
                .requires(CRItems.LIME.get())
                .unlockedBy("has_lime", has(CRItems.LIME.get())),
            "lime_seeds_from_lime", finished, enabled("lime"), enabled("lime_seeds"));
        wrap(ShapelessRecipeBuilder.shapeless(CRItems.LIME_SEEDS.get())
                .requires(CRItems.LIME_SLICE.get())
                .unlockedBy("has_lime_slice", has(CRItems.LIME_SLICE.get())),
            "lime_seeds_from_slice", finished, enabled("lime"), enabled("lime_slice"), enabled("lime_seeds"));
        wrap(ShapelessRecipeBuilder.shapeless(CRItems.PORTOBELLO_WRAP.get())
                .requires(CRItems.BAKED_PORTOBELLO_CAP.get())
                .requires(ForgeTags.BREAD)
                .requires(ForgeTags.CROPS_ONION)
                .requires(ForgeTags.CROPS_CABBAGE)
                .requires(ForgeTags.VEGETABLES_CARROT)
                .unlockedBy("has_baked_portobello_cap", has(CRItems.BAKED_PORTOBELLO_CAP.get())),
            "food/portobello_wrap", finished, enabled("portobello_wrap"));
        wrap(ShapelessRecipeBuilder.shapeless(CRItems.PORTOBELLO_BURGER.get())
                .requires(CRItems.BAKED_PORTOBELLO_CAP.get())
                .requires(ForgeTags.BREAD)
                .requires(ForgeTags.CROPS_ONION)
                .requires(ForgeTags.CROPS_CABBAGE)
                .requires(ForgeTags.CROPS_TOMATO)
                .unlockedBy("has_baked_portobello_cap", has(CRItems.BAKED_PORTOBELLO_CAP.get())),
            "food/portobello_burger", finished, enabled("portobello_burger"));
        wrap(ShapelessRecipeBuilder.shapeless(CRItems.LIMEADE.get())
                .requires(CRItems.LIME.get(), 2)
                .requires(Items.SUGAR)
                .requires(Items.GLASS_BOTTLE)
                .unlockedBy("has_lime", has(CRItems.LIME.get())),
            "food/limeade", finished, enabled("limeade"));
        wrap(ShapelessRecipeBuilder.shapeless(CRItems.BERRY_LIMEADE.get())
                .requires(CRItems.LIME.get(), 2)
                .requires(Ingredient.of(ForgeTags.BERRIES), 3)
                .requires(Items.SUGAR)
                .requires(Items.GLASS_BOTTLE)
                .unlockedBy("has_lime", has(CRItems.LIME.get())),
            "food/berry_limeade", finished, enabled("berry_limeade"));
        wrap(ShapelessRecipeBuilder.shapeless(CRItems.BERRY_LIMEADE.get())
                .requires(CRItems.LIMEADE.get(), 1)
                .requires(Ingredient.of(ForgeTags.BERRIES), 3)
                .unlockedBy("has_limeade", has(CRItems.LIMEADE.get())),
            "food/berry_limeade_from_limeade", finished, enabled("berry_limeade"));
        wrap(ShapelessRecipeBuilder.shapeless(CRItems.SALMON_TARTARE.get())
                .requires(Ingredient.of(ForgeTags.RAW_FISHES_SALMON), 3)
                .requires(CRItems.LIME.get())
                .requires(Items.BOWL)
                .unlockedBy("has_lime", has(CRItems.LIME.get())),
            "food/salmon_tartare", finished, enabled("salmon_tartare"));
        wrap(ShapelessRecipeBuilder.shapeless(CRItems.COD_CEVICHE.get())
                .requires(ForgeTags.RAW_FISHES_COD)
                .requires(CRItems.LIME.get())
                .requires(ForgeTags.CROPS_ONION)
                .requires(ForgeTags.CROPS_CABBAGE)
                .requires(ForgeTags.CROPS_TOMATO)
                .requires(Items.BOWL)
                .unlockedBy("has_lime", has(CRItems.LIME.get())),
            "food/cod_ceviche", finished, enabled("cod_ceviche"));

        // Shaped Crafting
        wrap(ShapedRecipeBuilder.shaped(CRItems.PORTOBELLO_QUICHE.get())
                .pattern("eme")
                .pattern("ooo")
                .pattern("pcp")
                .define('e', ForgeTags.EGGS)
                .define('m', ForgeTags.MILK)
                .define('o', ForgeTags.CROPS_ONION)
                .define('p', CRItems.BAKED_PORTOBELLO_CAP.get())
                .define('c', ModItems.PIE_CRUST.get())
                .unlockedBy("has_baked_portobello_cap", has(CRItems.BAKED_PORTOBELLO_CAP.get())),
            "food/portobello_quiche", finished, enabled("portobello_quiche"));
        wrap(ShapedRecipeBuilder.shaped(CRItems.LIME_PIE.get())
                .pattern("ese")
                .pattern("lll")
                .pattern("mcm")
                .define('e', ForgeTags.EGGS)
                .define('m', ForgeTags.MILK)
                .define('l', CRItems.LIME.get())
                .define('s', Items.SUGAR)
                .define('c', ModItems.PIE_CRUST.get())
                .unlockedBy("has_lime", has(CRItems.LIME.get())),
            "food/lime_pie", finished, enabled("lime_pie"));
        wrap(ShapedRecipeBuilder.shaped(CRItems.LIME_POPSICLE.get())
                .pattern(" ll")
                .pattern("ill")
                .pattern("si ")
                .define('l', CRItems.LIME.get())
                .define('i', Items.ICE)
                .define('s', Tags.Items.RODS_WOODEN)
                .unlockedBy("has_lime", has(CRItems.LIME.get())),
            "food/lime_popsicle", finished, enabled("lime_popsicle"));
        wrap(ShapedRecipeBuilder.shaped(CRItems.LIME_COOKIE.get(), 8)
                .pattern("wlw")
                .define('l', CRItems.LIME.get())
                .define('w', Tags.Items.CROPS_WHEAT)
                .unlockedBy("has_lime", has(CRItems.LIME.get())),
            "food/lime_cookie", finished, enabled("lime_cookie"));
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

    private void wrap(UpgradeRecipeBuilder builder, String name, Consumer<FinishedRecipe> consumer, ICondition... conds) {
        ResourceLocation loc = Util.rl(CollectorsReap.MODID, name);
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

    private void wrap(CuttingBoardRecipeBuilder builder, String name, Consumer<FinishedRecipe> consumer, ICondition... conds) {
        wrap(builder, CollectorsReap.MODID, name, consumer, conds);
    }

    private void wrap(CuttingBoardRecipeBuilder builder, String modid, String name, Consumer<FinishedRecipe> consumer, ICondition... conds) {
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

    private static void foodSmeltingRecipes(String name, ItemLike ingredient, ItemLike result, float experience, Consumer<FinishedRecipe> consumer) {
        String namePrefix = Util.rl(CollectorsReap.MODID, name).toString();
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ingredient), result, experience, 200).unlockedBy(name, has(ingredient)).save(consumer);
        SimpleCookingRecipeBuilder.cooking(Ingredient.of(ingredient), result, experience, 600, RecipeSerializer.CAMPFIRE_COOKING_RECIPE).unlockedBy(name, has(ingredient)).save(consumer, namePrefix + "_from_campfire_cooking");
        SimpleCookingRecipeBuilder.cooking(Ingredient.of(ingredient), result, experience, 100, RecipeSerializer.SMOKING_RECIPE).unlockedBy(name, has(ingredient)).save(consumer, namePrefix + "_from_smoking");
    }

    private EnabledCondition enabled(String name) {
        return new EnabledCondition(name);
    }
}
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
        wrap(CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(CRItems.LEMON.get()), Ingredient.of(ForgeTags.TOOLS_KNIVES), CRItems.LEMON_SLICE.get(), 2),
            "cutting/lemon", finished, enabled("lemon"), enabled("lemon_slice"));
        wrap(CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(CRItems.LEMON_PIE.get()), Ingredient.of(ForgeTags.TOOLS_KNIVES), CRItems.LEMON_PIE_SLICE.get(), 4),
            "cutting/lemon_pie", finished, enabled("lemon_pie"), enabled("lemon_pie"));

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
        wrap(CookingPotRecipeBuilder.cookingPotRecipe(CRItems.HONEY_LEMON_CHICKEN.get(), 1, 200, 1.0F, Items.BOWL)
                .addIngredient(ForgeTags.RAW_CHICKEN)
                .addIngredient(Items.HONEY_BOTTLE)
                .addIngredient(CRItemTags.LEMON_OR_SLICE)
                .addIngredient(ForgeTags.CROPS_ONION)
                .addIngredient(ForgeTags.CROPS_RICE)
                .unlockedBy("has_lemon_or_slice", has(CRItemTags.LEMON_OR_SLICE)),
            "food/honey_lemon_chicken", finished, enabled("honey_lemon_chicken"));
        wrap(CookingPotRecipeBuilder.cookingPotRecipe(CRItems.MEDITERRANEAN_SALMON.get(), 1, 200, 1.0F, Items.BOWL)
                .addIngredient(ForgeTags.RAW_FISHES_SALMON)
                .addIngredient(CRItemTags.LEMON_OR_SLICE)
                .addIngredient(Tags.Items.CROPS_POTATO)
                .addIngredient(ForgeTags.CROPS_TOMATO)
                .addIngredient(ForgeTags.CROPS_ONION)
                .unlockedBy("has_lemon_or_slice", has(CRItemTags.LEMON_OR_SLICE)),
            "food/mediterranean_salmon", finished, enabled("mediterranean_salmon"));
        wrap(CookingPotRecipeBuilder.cookingPotRecipe(CRItems.POTATO_FRITTERS.get(), 1, 200, 1.0F, Items.BOWL)
                .addIngredient(Items.BAKED_POTATO)
                .addIngredient(Ingredient.of(CRItemTags.LEMON_OR_SLICE), 2)
                .addIngredient(ForgeTags.CROPS_ONION)
                .unlockedBy("has_lemon_or_slice", has(CRItemTags.LEMON_OR_SLICE)),
            "food/potato_fritters", finished, enabled("potato_fritters"));
        wrap(CookingPotRecipeBuilder.cookingPotRecipe(CRItems.CANDIED_LEMON.get(), 3, 200, 1.0F, Items.BOWL)
                .addIngredient(CRItems.LEMON_SLICE.get(), 3)
                .addIngredient(Items.HONEY_BOTTLE)
                .unlockedBy("has_lemon_slice", has(CRItems.LEMON_SLICE.get())),
            "food/candied_lemon", finished, enabled("candied_lemon"));

        // Crafting
        wrap(ShapelessRecipeBuilder.shapeless(CRItems.LEMON_SEEDS.get(), 2)
                .requires(CRItems.LEMON.get())
                .unlockedBy("has_lemon", has(CRItems.LEMON.get())),
            "lemon_seeds_from_lemon", finished, enabled("lemon"), enabled("lemon_seeds"));
        wrap(ShapelessRecipeBuilder.shapeless(CRItems.LEMON_SEEDS.get())
                .requires(CRItems.LEMON_SLICE.get())
                .unlockedBy("has_lemon_slice", has(CRItems.LEMON_SLICE.get())),
            "lemon_seeds_from_slice", finished, enabled("lemon"), enabled("lemon_slice"), enabled("lemon_seeds"));
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
        wrap(ShapelessRecipeBuilder.shapeless(CRItems.LEMONADE.get())
                .requires(CRItems.LEMON.get(), 2)
                .requires(Items.SUGAR)
                .requires(Items.GLASS_BOTTLE)
                .unlockedBy("has_lemon", has(CRItems.LEMON.get())),
            "food/lemonade", finished, enabled("lemonade"));
        wrap(ShapelessRecipeBuilder.shapeless(CRItems.BERRY_LEMONADE.get())
                .requires(CRItems.LEMON.get(), 2)
                .requires(Ingredient.of(ForgeTags.BERRIES), 3)
                .requires(Items.SUGAR)
                .requires(Items.GLASS_BOTTLE)
                .unlockedBy("has_lemon", has(CRItems.LEMON.get())),
            "food/berry_lemonade", finished, enabled("berry_lemonade"));
        wrap(ShapelessRecipeBuilder.shapeless(CRItems.BERRY_LEMONADE.get())
                .requires(CRItems.LEMONADE.get(), 1)
                .requires(Ingredient.of(ForgeTags.BERRIES), 3)
                .unlockedBy("has_lemonade", has(CRItems.LEMONADE.get())),
            "food/berry_lemonade_from_lemonade", finished, enabled("berry_lemonade"));
        wrap(ShapelessRecipeBuilder.shapeless(CRItems.SALMON_TARTARE.get())
                .requires(Ingredient.of(ForgeTags.RAW_FISHES_SALMON), 3)
                .requires(CRItems.LEMON.get())
                .requires(Items.BOWL)
                .unlockedBy("has_lemon", has(CRItems.LEMON.get())),
            "food/salmon_tartare", finished, enabled("salmon_tartare"));
        wrap(ShapelessRecipeBuilder.shapeless(CRItems.COD_CEVICHE.get())
                .requires(ForgeTags.RAW_FISHES_COD)
                .requires(CRItems.LEMON.get())
                .requires(ForgeTags.CROPS_ONION)
                .requires(ForgeTags.CROPS_CABBAGE)
                .requires(ForgeTags.CROPS_TOMATO)
                .requires(Items.BOWL)
                .unlockedBy("has_lemon", has(CRItems.LEMON.get())),
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
        wrap(ShapedRecipeBuilder.shaped(CRItems.LEMON_PIE.get())
                .pattern("ese")
                .pattern("lll")
                .pattern("mcm")
                .define('e', ForgeTags.EGGS)
                .define('m', ForgeTags.MILK)
                .define('l', CRItems.LEMON.get())
                .define('s', Items.SUGAR)
                .define('c', ModItems.PIE_CRUST.get())
                .unlockedBy("has_lemon", has(CRItems.LEMON.get())),
            "food/lemon_pie", finished, enabled("lemon_pie"));
        wrap(ShapedRecipeBuilder.shaped(CRItems.LEMON_POPSICLE.get())
                .pattern(" ll")
                .pattern("ill")
                .pattern("si ")
                .define('l', CRItems.LEMON.get())
                .define('i', Items.ICE)
                .define('s', Tags.Items.RODS_WOODEN)
                .unlockedBy("has_lemon", has(CRItems.LEMON.get())),
            "food/lemon_popsicle", finished, enabled("lemon_popsicle"));
        wrap(ShapedRecipeBuilder.shaped(CRItems.LEMON_COOKIE.get(), 8)
                .pattern("wlw")
                .define('l', CRItems.LEMON.get())
                .define('w', Tags.Items.CROPS_WHEAT)
                .unlockedBy("has_lemon", has(CRItems.LEMON.get())),
            "food/lemon_cookie", finished, enabled("lemon_cookie"));
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
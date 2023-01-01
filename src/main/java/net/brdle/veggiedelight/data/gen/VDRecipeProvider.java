package net.brdle.veggiedelight.data.gen;

import net.brdle.veggiedelight.Util;
import net.brdle.veggiedelight.VeggieDelight;
import net.brdle.veggiedelight.common.crafting.EnabledCondition;
import net.brdle.veggiedelight.common.item.VDItems;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.ConditionalRecipe;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import org.jetbrains.annotations.NotNull;
import vectorwing.farmersdelight.common.block.RichSoilFarmlandBlock;
import vectorwing.farmersdelight.common.registry.ModItems;
import vectorwing.farmersdelight.common.tag.ForgeTags;
import vectorwing.farmersdelight.data.builder.CookingPotRecipeBuilder;
import vectorwing.farmersdelight.data.builder.CuttingBoardRecipeBuilder;
import java.util.function.Consumer;

public class VDRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public VDRecipeProvider(DataGenerator pGenerator) {
        super(pGenerator);
    }

    @Override
    protected void buildCraftingRecipes(@NotNull Consumer<FinishedRecipe> finished) {
        // Smelting
        foodSmeltingRecipes("baked_portobello_cap", VDItems.PORTOBELLO.get(), VDItems.BAKED_PORTOBELLO_CAP.get(), 0.35F, finished);

        // Cutting
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(VDItems.PORTOBELLO_QUICHE.get()), Ingredient.of(ForgeTags.TOOLS_KNIVES), VDItems.PORTOBELLO_QUICHE_SLICE.get(), 4).build(finished);
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(VDItems.PORTOBELLO_COLONY.get()), Ingredient.of(ForgeTags.TOOLS_KNIVES), VDItems.PORTOBELLO.get(), 5).build(finished);

        // Cooking Pot
        wrap(CookingPotRecipeBuilder.cookingPotRecipe(VDItems.PORTOBELLO_RISOTTO.get(), 1, 200, 1.0F, Items.BOWL)
                .addIngredient(VDItems.BAKED_PORTOBELLO_CAP.get())
                .addIngredient(ForgeTags.CROPS_RICE)
                .addIngredient(ForgeTags.MILK)
                .addIngredient(ForgeTags.CROPS_ONION)
                .unlockedBy("has_baked_portobello_cap", has(VDItems.BAKED_PORTOBELLO_CAP.get())),
            "food/portobello_risotto", finished, enabled("portobello_risotto"));
        wrap(CookingPotRecipeBuilder.cookingPotRecipe(VDItems.PORTOBELLO_RICE_SOUP.get(), 1, 200, 1.0F, Items.BOWL)
                .addIngredient(VDItems.BAKED_PORTOBELLO_CAP.get())
                .addIngredient(ForgeTags.CROPS_RICE)
                .addIngredient(ForgeTags.CROPS_ONION)
                .addIngredient(ForgeTags.VEGETABLES_CARROT)
                .addIngredient(Items.DRIED_KELP)
                .unlockedBy("has_baked_portobello_cap", has(VDItems.BAKED_PORTOBELLO_CAP.get())),
            "food/portobello_rice_soup", finished, enabled("portobello_rice_soup"));
        wrap(CookingPotRecipeBuilder.cookingPotRecipe(VDItems.STUFFED_PORTOBELLO_CAP.get(), 1, 200, 1.0F, Items.BOWL)
                .addIngredient(VDItems.BAKED_PORTOBELLO_CAP.get())
                .addIngredient(Items.BROWN_MUSHROOM)
                .addIngredient(ForgeTags.CROPS_ONION)
                .addIngredient(ForgeTags.CROPS_TOMATO)
                .unlockedBy("has_baked_portobello_cap", has(VDItems.BAKED_PORTOBELLO_CAP.get())),
            "food/stuffed_portobello_cap", finished, enabled("stuffed_portobello_cap"));
        wrap(CookingPotRecipeBuilder.cookingPotRecipe(VDItems.PORTOBELLO_PASTA.get(), 1, 200, 1.0F, Items.BOWL)
                .addIngredient(VDItems.BAKED_PORTOBELLO_CAP.get())
                .addIngredient(ForgeTags.PASTA_RAW_PASTA)
                .addIngredient(Items.BROWN_MUSHROOM)
                .addIngredient(ForgeTags.CROPS_ONION)
                .addIngredient(ForgeTags.MILK)
                .unlockedBy("has_baked_portobello_cap", has(VDItems.BAKED_PORTOBELLO_CAP.get())),
            "food/portobello_pasta", finished, enabled("portobello_pasta"));

        // Crafting
        wrap(ShapelessRecipeBuilder.shapeless(VDItems.PORTOBELLO_WRAP.get())
                .requires(VDItems.BAKED_PORTOBELLO_CAP.get())
                .requires(ForgeTags.BREAD)
                .requires(ForgeTags.CROPS_ONION)
                .requires(ForgeTags.CROPS_CABBAGE)
                .requires(ForgeTags.VEGETABLES_CARROT)
                .unlockedBy("has_baked_portobello_cap", has(VDItems.BAKED_PORTOBELLO_CAP.get())),
            "food/portobello_wrap", finished, enabled("portobello_wrap"));
        wrap(ShapelessRecipeBuilder.shapeless(VDItems.PORTOBELLO_BURGER.get())
                .requires(VDItems.BAKED_PORTOBELLO_CAP.get())
                .requires(ForgeTags.BREAD)
                .requires(ForgeTags.CROPS_ONION)
                .requires(ForgeTags.CROPS_CABBAGE)
                .requires(ForgeTags.CROPS_TOMATO)
                .unlockedBy("has_baked_portobello_cap", has(VDItems.BAKED_PORTOBELLO_CAP.get())),
            "food/portobello_burger", finished, enabled("portobello_burger"));
        wrap(ShapedRecipeBuilder.shaped(VDItems.PORTOBELLO_QUICHE.get())
                .pattern("eme")
                .pattern("ooo")
                .pattern("pcp")
                .define('e', ForgeTags.EGGS)
                .define('m', ForgeTags.MILK)
                .define('o', ForgeTags.CROPS_ONION)
                .define('p', VDItems.BAKED_PORTOBELLO_CAP.get())
                .define('c', ModItems.PIE_CRUST.get())
                .unlockedBy("has_baked_portobello_cap", has(VDItems.BAKED_PORTOBELLO_CAP.get())),
            "food/portobello_quiche", finished, enabled("portobello_quiche"));
    }


    private InventoryChangeTrigger.TriggerInstance has(ItemLike... items) {
        return InventoryChangeTrigger.TriggerInstance.hasItems(items);
    }

    private void wrap(RecipeBuilder builder, String name, Consumer<FinishedRecipe> consumer, ICondition... conds) {
        wrap(builder, VeggieDelight.MODID, name, consumer, conds);
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
        ResourceLocation loc = Util.rl(VeggieDelight.MODID, name);
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
        wrap(builder, VeggieDelight.MODID, name, consumer, conds);
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
        wrap(builder, VeggieDelight.MODID, name, consumer, conds);
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
        String namePrefix = Util.rl(VeggieDelight.MODID, name).toString();
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ingredient), result, experience, 200).unlockedBy(name, has(ingredient)).save(consumer);
        SimpleCookingRecipeBuilder.cooking(Ingredient.of(ingredient), result, experience, 600, RecipeSerializer.CAMPFIRE_COOKING_RECIPE).unlockedBy(name, has(ingredient)).save(consumer, namePrefix + "_from_campfire_cooking");
        SimpleCookingRecipeBuilder.cooking(Ingredient.of(ingredient), result, experience, 100, RecipeSerializer.SMOKING_RECIPE).unlockedBy(name, has(ingredient)).save(consumer, namePrefix + "_from_smoking");
    }

    private EnabledCondition enabled(String name) {
        return new EnabledCondition(name);
    }
}
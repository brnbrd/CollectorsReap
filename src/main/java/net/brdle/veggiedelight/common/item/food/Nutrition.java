package net.brdle.veggiedelight.common.item.food;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class Nutrition {
    public static final FoodProperties BAKED_PORTOBELLO_CAP = (new FoodProperties.Builder())
        .nutrition(3).saturationMod(0.2F).build();
    public static final FoodProperties STUFFED_PORTOBELLO_CAP = (new FoodProperties.Builder())
        .nutrition(3).saturationMod(0.2F).build();
    public static final FoodProperties PORTOBELLO_PASTA = (new FoodProperties.Builder())
        .nutrition(3).saturationMod(0.2F).build();
    public static final FoodProperties PORTOBELLO_RICE_SOUP = (new FoodProperties.Builder())
        .nutrition(3).saturationMod(0.2F).build();
    public static final FoodProperties PORTOBELLO_RISOTTO = (new FoodProperties.Builder())
        .nutrition(3).saturationMod(0.2F).build();
    public static final FoodProperties PORTOBELLO_WRAP = (new FoodProperties.Builder())
        .nutrition(3).saturationMod(0.2F).build();
    public static final FoodProperties PORTOBELLO_QUICHE_SLICE = (new FoodProperties.Builder())
        .nutrition(3).saturationMod(0.2F).build();
    public static final FoodProperties PORTOBELLO_BURGER = (new FoodProperties.Builder()).nutrition(12).saturationMod(0.8F)
        .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 600, 0), 1.0F).build();
}
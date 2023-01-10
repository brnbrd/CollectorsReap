package net.brdle.collectorsreap.common.item.food;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class Nutrition {
    public static final FoodProperties LEMON = (new FoodProperties.Builder())
        .nutrition(2).saturationMod(0.2F).build();
    public static final FoodProperties LEMON_SLICE = (new FoodProperties.Builder())
        .nutrition(1).saturationMod(0.2F).fast().build();
    public static final FoodProperties LEMON_PIE_SLICE = (new FoodProperties.Builder())
        .nutrition(3).saturationMod(0.2F).build();
    public static final FoodProperties LEMON_POPSICLE = (new FoodProperties.Builder())
        .nutrition(3).saturationMod(0.2F).build();
    public static final FoodProperties LEMON_COOKIE = (new FoodProperties.Builder())
        .nutrition(3).saturationMod(0.2F).build();
    public static final FoodProperties HONEY_LEMON_CHICKEN = (new FoodProperties.Builder())
        .nutrition(14).saturationMod(0.78F).build();
    public static final FoodProperties MEDITERRANEAN_SALMON = (new FoodProperties.Builder())
        .nutrition(14).saturationMod(0.78F).build();
    public static final FoodProperties SALMON_TARTARE = (new FoodProperties.Builder())
        .nutrition(6).saturationMod(0.67F).build();
    public static final FoodProperties POTATO_FRITTERS = (new FoodProperties.Builder())
        .nutrition(7).saturationMod(1.0F).build();
    public static final FoodProperties CANDIED_LEMON = (new FoodProperties.Builder())
        .nutrition(3).saturationMod(1.0F).fast().build();
    public static final FoodProperties COD_CEVICHE = (new FoodProperties.Builder())
        .nutrition(11).saturationMod(0.73F).build();
    public static final FoodProperties POMEGRANATE = (new FoodProperties.Builder())
        .nutrition(4).saturationMod(0.5F).build();
    public static final FoodProperties BAKED_PORTOBELLO_CAP = (new FoodProperties.Builder())
        .nutrition(6).saturationMod(0.75F).build();
    public static final FoodProperties STUFFED_PORTOBELLO_CAP = (new FoodProperties.Builder())
        .nutrition(10).saturationMod(0.8F).build();
    public static final FoodProperties PORTOBELLO_PASTA = (new FoodProperties.Builder())
        .nutrition(13).saturationMod(0.8F).build();
    public static final FoodProperties PORTOBELLO_RICE_SOUP = (new FoodProperties.Builder())
        .nutrition(14).saturationMod(0.8F).build();
    public static final FoodProperties PORTOBELLO_RISOTTO = (new FoodProperties.Builder())
        .nutrition(12).saturationMod(0.83F).build();
    public static final FoodProperties PORTOBELLO_WRAP = (new FoodProperties.Builder())
        .nutrition(10).saturationMod(0.8F).build();
    public static final FoodProperties PORTOBELLO_QUICHE_SLICE = (new FoodProperties.Builder())
        .nutrition(3).saturationMod(0.2F).build();
    public static final FoodProperties PORTOBELLO_BURGER = (new FoodProperties.Builder()).nutrition(12).saturationMod(0.8F)
        .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 600, 0), 1.0F).build();
    public static final FoodProperties LEMONADE = (new FoodProperties.Builder()).alwaysEat()
        .nutrition(3).saturationMod(0.2F)
        .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 1200, 0), 1.0F).build();
    public static final FoodProperties BERRY_LEMONADE = (new FoodProperties.Builder()).alwaysEat()
        .nutrition(5).saturationMod(0.2F)
        .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 1200, 0), 1.0F).build();
}
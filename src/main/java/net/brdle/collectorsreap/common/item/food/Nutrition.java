package net.brdle.collectorsreap.common.item.food;

import net.brdle.collectorsreap.common.effect.CREffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import vectorwing.farmersdelight.common.registry.ModEffects;

public class Nutrition {
    public static final FoodProperties LIME = (new FoodProperties.Builder())
        .nutrition(2).saturationMod(0.2F)
        .effect(() -> new MobEffectInstance(CREffects.CORROSION.get(), 100, 0), 1.0F).build();
    public static final FoodProperties LIME_SLICE = (new FoodProperties.Builder())
        .nutrition(1).saturationMod(0.2F).fast()
        .effect(() -> new MobEffectInstance(CREffects.CORROSION.get(), 60, 0), 1.0F).build();
    public static final FoodProperties LIME_PIE_SLICE = (new FoodProperties.Builder())
        .nutrition(3).saturationMod(0.2F).build();
    public static final FoodProperties LIME_POPSICLE = (new FoodProperties.Builder())
        .nutrition(3).saturationMod(0.2F).fast()
        .effect(() -> new MobEffectInstance(CREffects.CORROSION.get(), 300, 0), 1.0F).build();
    public static final FoodProperties LIME_COOKIE = (new FoodProperties.Builder())
        .nutrition(3).saturationMod(0.2F)
        .effect(() -> new MobEffectInstance(CREffects.CORROSION.get(), 300, 0), 1.0F).build();
    public static final FoodProperties HONEY_LIME_CHICKEN = (new FoodProperties.Builder())
        .nutrition(14).saturationMod(0.78F)
        .effect(() -> new MobEffectInstance(CREffects.CORROSION.get(), 400, 0), 1.0F).build();
    public static final FoodProperties MEDITERRANEAN_SALMON = (new FoodProperties.Builder())
        .nutrition(14).saturationMod(0.78F).build();
    public static final FoodProperties SALMON_TARTARE = (new FoodProperties.Builder())
        .nutrition(6).saturationMod(0.67F).build();
    public static final FoodProperties POTATO_FRITTERS = (new FoodProperties.Builder())
        .nutrition(7).saturationMod(1.0F)
        .effect(() -> new MobEffectInstance(CREffects.CORROSION.get(), 300, 0), 1.0F).build();
    public static final FoodProperties CANDIED_LIME = (new FoodProperties.Builder())
        .nutrition(3).saturationMod(1.0F).fast()
        .effect(() -> new MobEffectInstance(CREffects.CORROSION.get(), 200, 0), 1.0F).build();
    public static final FoodProperties COD_CEVICHE = (new FoodProperties.Builder())
        .nutrition(11).saturationMod(0.73F).build();
    public static final FoodProperties POMEGRANATE_SLICE = (new FoodProperties.Builder())
        .nutrition(4).saturationMod(0.5F)
        .effect(() -> new MobEffectInstance(CREffects.VOLATILITY.get(), 200, 0), 1.0F).build();
    public static final FoodProperties POMEGRANATE_SEEDS = (new FoodProperties.Builder())
        .nutrition(2).saturationMod(0.5F)
        .effect(() -> new MobEffectInstance(CREffects.VOLATILITY.get(), 100, 0), 1.0F).build();
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
    public static final FoodProperties CRIMSON_CARROT_ROAST = (new FoodProperties.Builder())
        .nutrition(6).saturationMod(0.5F)
        .effect(() -> new MobEffectInstance(CREffects.VOLATILITY.get(), 400, 0), 1.0F).build();
    public static final FoodProperties POMEGRANATE_MUTTON = (new FoodProperties.Builder())
        .nutrition(14).saturationMod(0.78F)
        .effect(() -> new MobEffectInstance(CREffects.VOLATILITY.get(), 1200, 0), 1.0F).build();
    public static final FoodProperties POMEGRANATE_PORK = (new FoodProperties.Builder())
        .nutrition(16).saturationMod(0.81F)
        .effect(() -> new MobEffectInstance(CREffects.VOLATILITY.get(), 1200, 0), 1.0F).build();
    public static final FoodProperties POMEGRANATE_CHICKEN = (new FoodProperties.Builder())
        .nutrition(14).saturationMod(0.78F)
        .effect(() -> new MobEffectInstance(CREffects.VOLATILITY.get(), 1200, 0), 1.0F).build();
    public static final FoodProperties POMEGRANATE_CUSTARD = (new FoodProperties.Builder())
        .nutrition(8).saturationMod(0.65F)
        .effect(() -> new MobEffectInstance(CREffects.VOLATILITY.get(), 400, 0), 1.0F).build();
    public static final FoodProperties GLAZED_STRIDER = (new FoodProperties.Builder())
        .nutrition(10).saturationMod(0.8F)
        .effect(() -> new MobEffectInstance(CREffects.VOLATILITY.get(), 1200, 0), 1.0F).build();
    public static final FoodProperties SPICY_GRENADINE_JELLY = (new FoodProperties.Builder())
        .nutrition(6).saturationMod(2.33F)
        .effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 1800, 0), 1.0F)
        .effect(() -> new MobEffectInstance(CREffects.VOLATILITY.get(), 1200, 0), 1.0F).build();
    public static final FoodProperties LIMEADE = (new FoodProperties.Builder())
        .alwaysEat()
        .nutrition(3).saturationMod(0.2F)
        .effect(() -> new MobEffectInstance(CREffects.CORROSION.get(), 1200, 0), 1.0F)
        .build();
    public static final FoodProperties BERRY_LIMEADE = (new FoodProperties.Builder())
        .alwaysEat()
        .nutrition(5).saturationMod(0.2F)
        .effect(() -> new MobEffectInstance(CREffects.CORROSION.get(), 1200, 0), 1.0F)
        .build();
    public static final FoodProperties PINK_LIMEADE = (new FoodProperties.Builder())
        .alwaysEat()
        .nutrition(5).saturationMod(1.0F)
        .effect(() -> new MobEffectInstance(CREffects.CORROSION.get(), 1200, 0), 1.0F)
        .effect(() -> new MobEffectInstance(CREffects.VOLATILITY.get(), 1200, 0), 1.0F)
        .build();
    public static final FoodProperties DELUXE_SALAD = (new FoodProperties.Builder())
        .nutrition(8).saturationMod(0.75F)
        .effect(() -> new MobEffectInstance(CREffects.CORROSION.get(), 600, 0), 1.0F)
        .effect(() -> new MobEffectInstance(CREffects.VOLATILITY.get(), 600, 0), 1.0F)
        .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 600, 0), 1.0F)
        .build();
    public static final FoodProperties LIME_CAKE_SLICE = (new FoodProperties.Builder())
        .nutrition(2).saturationMod(0.1F)
        .effect(() -> new MobEffectInstance(CREffects.CORROSION.get(), 200, 0), 1.0F)
        .build();
    public static final FoodProperties POMEGRANATE_CAKE_SLICE = (new FoodProperties.Builder())
        .nutrition(2).saturationMod(0.1F)
        .effect(() -> new MobEffectInstance(CREffects.VOLATILITY.get(), 300, 0), 1.0F)
        .build();
    public static final FoodProperties LIME_ICE_CREAM = (new FoodProperties.Builder())
        .nutrition(6).saturationMod(0.4F)
        .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 2), 1.0F)
        .effect(() -> new MobEffectInstance(CREffects.CORROSION.get(), 1200, 0), 1.0F)
        .build();
    public static final FoodProperties POMEGRANATE_ICE_CREAM = (new FoodProperties.Builder())
        .nutrition(6).saturationMod(0.4F)
        .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 2), 1.0F)
        .effect(() -> new MobEffectInstance(CREffects.VOLATILITY.get(), 1600, 0), 1.0F)
        .build();
    public static final FoodProperties MILKSHAKE = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.6F).alwaysEat().build();
}
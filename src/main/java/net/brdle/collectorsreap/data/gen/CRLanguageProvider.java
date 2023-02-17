package net.brdle.collectorsreap.data.gen;

import net.brdle.collectorsreap.CollectorsReap;
import net.brdle.collectorsreap.Util;
import net.brdle.collectorsreap.common.block.CRBlocks;
import net.brdle.collectorsreap.common.effect.CREffects;
import net.brdle.collectorsreap.common.item.CRItems;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class CRLanguageProvider extends LanguageProvider {
    public CRLanguageProvider(DataGenerator gen) {
        super(gen, CollectorsReap.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
        addBlocks();
        addItems();
    }

    private void addBlocks() {
        addBlock(CRBlocks.PORTOBELLO, "Portobello");
        addBlock(CRBlocks.PORTOBELLO_COLONY, "Portobello Colony");
        addBlock(CRBlocks.PORTOBELLO_QUICHE, "Portobello Quiche");
        addBlock(CRBlocks.LIME_PIE, "Key Lime Pie");
        addBlock(CRBlocks.SMALL_LIME_BUSH, "Lime Seeds");
        addBlock(CRBlocks.LIME_BUSH, "Lime Bush");
        addBlock(CRBlocks.LIME_CRATE, "Lime Crate");
        addBlock(CRBlocks.SMALL_POMEGRANATE_BUSH, "Pomegranate Seeds");
        addBlock(CRBlocks.POMEGRANATE_BUSH, "Pomegranate Bush");
        addBlock(CRBlocks.POMEGRANATE_CRATE, "Pomegranate Crate");
        addBlock(CRBlocks.LIME_CAKE, "Lime Cake");
        addBlock(CRBlocks.CANDLE_LIME_CAKE, "Lime Cake with Candle");
        addBlock(CRBlocks.WHITE_CANDLE_LIME_CAKE, "Lime Cake with White Candle");
        addBlock(CRBlocks.ORANGE_CANDLE_LIME_CAKE, "Lime Cake with Orange Candle");
        addBlock(CRBlocks.MAGENTA_CANDLE_LIME_CAKE, "Lime Cake with Magenta Candle");
        addBlock(CRBlocks.LIME_CANDLE_LIME_CAKE, "Lime Cake with Lime Candle");
        addBlock(CRBlocks.PINK_CANDLE_LIME_CAKE, "Lime Cake with Pink Candle");
        addBlock(CRBlocks.GRAY_CANDLE_LIME_CAKE, "Lime Cake with Gray Candle");
        addBlock(CRBlocks.LIGHT_GRAY_CANDLE_LIME_CAKE, "Lime Cake with Light Gray Candle");
        addBlock(CRBlocks.CYAN_CANDLE_LIME_CAKE, "Lime Cake with Cyan Candle");
        addBlock(CRBlocks.PURPLE_CANDLE_LIME_CAKE, "Lime Cake with Purple Candle");
        addBlock(CRBlocks.BLUE_CANDLE_LIME_CAKE, "Lime Cake with Blue Candle");
        addBlock(CRBlocks.BROWN_CANDLE_LIME_CAKE, "Lime Cake with Brown Candle");
        addBlock(CRBlocks.GREEN_CANDLE_LIME_CAKE, "Lime Cake with Green Candle");
        addBlock(CRBlocks.RED_CANDLE_LIME_CAKE, "Lime Cake with Red Candle");
        addBlock(CRBlocks.BLACK_CANDLE_LIME_CAKE, "Lime Cake with Black Candle");
        addBlock(CRBlocks.POMEGRANATE_CAKE, "Pomegranate Cake");
        addBlock(CRBlocks.CANDLE_POMEGRANATE_CAKE, "Pomegranate Cake with Candle");
        addBlock(CRBlocks.WHITE_CANDLE_POMEGRANATE_CAKE, "Pomegranate Cake with White Candle");
        addBlock(CRBlocks.ORANGE_CANDLE_POMEGRANATE_CAKE, "Pomegranate Cake with Orange Candle");
        addBlock(CRBlocks.MAGENTA_CANDLE_POMEGRANATE_CAKE, "Pomegranate Cake with Magenta Candle");
        addBlock(CRBlocks.LIME_CANDLE_POMEGRANATE_CAKE, "Pomegranate Cake with Lime Candle");
        addBlock(CRBlocks.PINK_CANDLE_POMEGRANATE_CAKE, "Pomegranate Cake with Pink Candle");
        addBlock(CRBlocks.GRAY_CANDLE_POMEGRANATE_CAKE, "Pomegranate Cake with Gray Candle");
        addBlock(CRBlocks.LIGHT_GRAY_CANDLE_POMEGRANATE_CAKE, "Pomegranate Cake with Light Gray Candle");
        addBlock(CRBlocks.CYAN_CANDLE_POMEGRANATE_CAKE, "Pomegranate Cake with Cyan Candle");
        addBlock(CRBlocks.PURPLE_CANDLE_POMEGRANATE_CAKE, "Pomegranate Cake with Purple Candle");
        addBlock(CRBlocks.BLUE_CANDLE_POMEGRANATE_CAKE, "Pomegranate Cake with Blue Candle");
        addBlock(CRBlocks.BROWN_CANDLE_POMEGRANATE_CAKE, "Pomegranate Cake with Brown Candle");
        addBlock(CRBlocks.GREEN_CANDLE_POMEGRANATE_CAKE, "Pomegranate Cake with Green Candle");
        addBlock(CRBlocks.RED_CANDLE_POMEGRANATE_CAKE, "Pomegranate Cake with Red Candle");
        addBlock(CRBlocks.BLACK_CANDLE_POMEGRANATE_CAKE, "Pomegranate Cake with Black Candle");
        addBlock(CRBlocks.LIME_ICE_CREAM_BLOCK, "Lime Ice Cream Block");
        addBlock(CRBlocks.POMEGRANATE_ICE_CREAM_BLOCK, "Pomegranate Ice Cream Block");
    }

    private void addItems() {
        addItem(CRItems.BAKED_PORTOBELLO_CAP, "Baked Portobello Cap");
        addItem(CRItems.STUFFED_PORTOBELLO_CAP, "Stuffed Portobello");
        addItem(CRItems.PORTOBELLO_BURGER, "Portoburger");
        addItem(CRItems.PORTOBELLO_PASTA, "Mushroom Pasta");
        addItem(CRItems.PORTOBELLO_RISOTTO, "Portobello Risotto");
        addItem(CRItems.PORTOBELLO_WRAP, "Veggie Wrap");
        addItem(CRItems.PORTOBELLO_RICE_SOUP, "Wild Rice Soup");
        addItem(CRItems.PORTOBELLO_QUICHE_SLICE, "Slice of Portobello Quiche");
        addItem(CRItems.LIME_PIE_SLICE, "Slice of Key Lime Pie");
        addItem(CRItems.LIME, "Lime");
        addItem(CRItems.LIME_SLICE, "Lime Slice");
        addItem(CRItems.LIME_POPSICLE, "Lime Popsicle");
        addItem(CRItems.LIME_COOKIE, "Lime Cookie");
        addItem(CRItems.CANDIED_LIME, "Candied Lime");
        addItem(CRItems.HONEY_LIME_CHICKEN, "Honey Lime Chicken");
        addItem(CRItems.COD_CEVICHE, "Cod Ceviche");
        addItem(CRItems.MEDITERRANEAN_SALMON, "Mediterranean Salmon");
        addItem(CRItems.SALMON_TARTARE, "Salmon Tartare");
        addItem(CRItems.POTATO_FRITTERS, "Potato Fritters");
        addItem(CRItems.LIMEADE, "Limeade");
        addItem(CRItems.BERRY_LIMEADE, "Berry Limeade");
        addItem(CRItems.POMEGRANATE, "Pomegranate");
        addItem(CRItems.POMEGRANATE_SLICE, "Pomegranate Slice");
        addItem(CRItems.POMEGRANATE_MUTTON, "Pomegranate Mutton");
        addItem(CRItems.POMEGRANATE_CHICKEN, "Pomegranate Chicken");
        addItem(CRItems.POMEGRANATE_PORK, "Pomegranate Pork");
        addItem(CRItems.POMEGRANATE_CUSTARD, "Pomegranate Custard");
        addItem(CRItems.PINK_LIMEADE, "Pink Limeade");
        addItem(CRItems.SPICY_GRENADINE_JELLY, "Spicy Grenadine Jelly");
        addItem(CRItems.GLAZED_STRIDER, "Glazed Strider");
        addItem(CRItems.CRIMSON_CARROT_ROAST, "Crimson Carrot Roast");
        addItem(CRItems.DELUXE_SALAD, "Deluxe Salad");
        addItem(CRItems.LIME_CAKE_SLICE, "Slice of Lime Cake");
        addItem(CRItems.POMEGRANATE_CAKE_SLICE, "Slice of Pomegranate Cake");
        addItem(CRItems.LIME_ICE_CREAM, "Lime Ice Cream");
        addItem(CRItems.POMEGRANATE_ICE_CREAM, "Pomegranate Ice Cream");
        addItem(CRItems.LIME_MILKSHAKE, "Lime Milkshake");
        addItem(CRItems.POMEGRANATE_MILKSHAKE, "Pomegranate Milkshake");
        addEffect(CREffects.CORROSION, "Corrosion");
        addEffect(CREffects.VOLATILITY, "Volatility");
        add("tooltip.requires_modid", "Requires modid:");
        add("desc." + CollectorsReap.MODID + "." + Util.name(CRItems.PORTOBELLO), "Found in Meadows.");
        add("desc." + CollectorsReap.MODID + "." + Util.name(CRItems.LIME), "Found in Flower Forests.");
        add("desc." + CollectorsReap.MODID + "." + Util.name(CRItems.POMEGRANATE), "Found in Warped Forests.");
        add("effect." + CollectorsReap.MODID + ".corrosion.description", "Provides the user a defensive acid shield, corroding projectiles and damaging attack weapons.");
        add("effect." + CollectorsReap.MODID + ".volatility.description", "Each hit the user inflicts on an entity creates a shockwave of splash damage.");
    }
}

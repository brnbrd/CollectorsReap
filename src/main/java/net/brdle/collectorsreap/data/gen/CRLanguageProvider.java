package net.brdle.collectorsreap.data.gen;

import net.brdle.collectorsreap.CollectorsReap;
import net.brdle.collectorsreap.common.block.CRBlocks;
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
        addBlock(CRBlocks.LEMON_PIE, "Lemon Pie");
        addBlock(CRBlocks.LEMON_BUSH, "Lemon Bush");
        addBlock(CRBlocks.SMALL_LEMON_BUSH, "Lemon Seeds");
        addBlock(CRBlocks.MEDIUM_LEMON_BUSH, "Lemon Bush");
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
        addItem(CRItems.LEMON_PIE_SLICE, "Slice of Lemon Pie");
        addItem(CRItems.LEMON, "Lemon");
        addItem(CRItems.LEMON_SLICE, "Lemon Slice");
        addItem(CRItems.LEMON_POPSICLE, "Lemon Popsicle");
        addItem(CRItems.LEMON_COOKIE, "Lemon Cookie");
        addItem(CRItems.CANDIED_LEMON, "Candied Lemon");
        addItem(CRItems.HONEY_LEMON_CHICKEN, "Honey Lemon Chicken");
        addItem(CRItems.COD_CEVICHE, "Cod Ceviche");
        addItem(CRItems.MEDITERRANEAN_SALMON, "Mediterranean Salmon");
        addItem(CRItems.SALMON_TARTARE, "Salmon Tartare");
        addItem(CRItems.POTATO_FRITTERS, "Potato Fritters");
        addItem(CRItems.LEMONADE, "Lemonade");
        addItem(CRItems.BERRY_LEMONADE, "Berry Lemonade");
        addItem(CRItems.POMEGRANATE, "Pomegranate");
    }
}

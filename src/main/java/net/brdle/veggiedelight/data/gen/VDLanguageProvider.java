package net.brdle.veggiedelight.data.gen;

import net.brdle.veggiedelight.VeggieDelight;
import net.brdle.veggiedelight.common.block.VDBlocks;
import net.brdle.veggiedelight.common.item.VDItems;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class VDLanguageProvider extends LanguageProvider {
    public VDLanguageProvider(DataGenerator gen) {
        super(gen, VeggieDelight.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
        addBlocks();
        addItems();
    }

    private void addBlocks() {
        addBlock(VDBlocks.PORTOBELLO, "Portobello");
        addBlock(VDBlocks.PORTOBELLO_COLONY, "Portobello Colony");
        addBlock(VDBlocks.PORTOBELLO_QUICHE, "Portobello Quiche");
        addBlock(VDBlocks.LEMON_BUSH, "Lemon Bush");
        addBlock(VDBlocks.SMALL_LEMON_BUSH, "Lemon Seeds");
        addBlock(VDBlocks.MEDIUM_LEMON_BUSH, "Lemon Bush");
    }

    private void addItems() {
        addItem(VDItems.BAKED_PORTOBELLO_CAP, "Baked Portobello Cap");
        addItem(VDItems.STUFFED_PORTOBELLO_CAP, "Stuffed Portobello");
        addItem(VDItems.PORTOBELLO_BURGER, "Portoburger");
        addItem(VDItems.PORTOBELLO_PASTA, "Mushroom Pasta");
        addItem(VDItems.PORTOBELLO_RISOTTO, "Portobello Risotto");
        addItem(VDItems.PORTOBELLO_WRAP, "Veggie Wrap");
        addItem(VDItems.PORTOBELLO_RICE_SOUP, "Wild Rice Soup");
        addItem(VDItems.PORTOBELLO_QUICHE_SLICE, "Slice of Portobello Quiche");
        addItem(VDItems.POMEGRANATE, "Pomegranate");
        addItem(VDItems.LEMON, "Lemon");
        addItem(VDItems.LEMON_SLICE, "Lemon Slice");
        addItem(VDItems.LEMON_PIE_SLICE, "Lemon Pie Slice");
        addItem(VDItems.LEMON_POPSICLE, "Lemon Popsicle");
        addItem(VDItems.LEMON_COOKIE, "Lemon Cookie");
        addItem(VDItems.CANDIED_LEMON, "Candied Lemon");
        addItem(VDItems.HONEY_LEMON_CHICKEN, "Honey Lemon Chicken");
        addItem(VDItems.COD_CEVICHE, "Cod Ceviche");
        addItem(VDItems.MEDITERRANEAN_SALMON, "Mediterranean Salmon");
        addItem(VDItems.SALMON_TARTARE, "Salmon Tartare");
        addItem(VDItems.POTATO_FRITTERS, "Potato Fritters");
        addItem(VDItems.LEMONADE, "Lemonade");
        addItem(VDItems.BERRY_LEMONADE, "Berry Lemonade");
    }
}

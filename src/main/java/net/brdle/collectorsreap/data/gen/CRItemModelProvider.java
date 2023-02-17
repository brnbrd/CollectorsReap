package net.brdle.collectorsreap.data.gen;

import net.brdle.collectorsreap.Util;
import net.brdle.collectorsreap.CollectorsReap;
import net.brdle.collectorsreap.common.item.CRItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.data.ItemModels;

public class CRItemModelProvider extends ItemModelProvider {
    public CRItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, CollectorsReap.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        for (RegistryObject<Item> entry : CRItems.ITEMS.getEntries()) {
            ResourceLocation id = entry.getId();
            if (entry == CRItems.PORTOBELLO) {
                itemGeneratedModel(CRItems.PORTOBELLO.get(), CRBlockStateProvider.resourceBlock(Util.name(CRItems.PORTOBELLO)));
            } else if (entry == CRItems.PORTOBELLO_COLONY) {
                itemGeneratedModel(CRItems.PORTOBELLO_COLONY.get(), CRBlockStateProvider.resourceBlock(Util.name(CRItems.PORTOBELLO_COLONY) + "_stage3"));
            } else if (isBasic(entry)) {
                basicItem(id);
            } else if (entry.get() instanceof BlockItem && !(entry.get() instanceof ItemNameBlockItem)) {
                withExistingParent(id.getPath(), Util.rl(this.modid, "block/" + id.getPath()));
            } else {
                basicItem(id);
            }
        }
    }

    public ItemModelBuilder itemGeneratedModel(Item item, ResourceLocation texture) {
        return withExistingParent(Util.name(item), ItemModels.GENERATED).texture("layer0", texture);
    }

    public ItemModelBuilder handheld(ResourceLocation item) {
        return withExistingParent(item.getPath(), ItemModels.HANDHELD).texture("layer0", Util.cr("item/" + item.getPath()));
    }

    private boolean isBasic(RegistryObject<Item> entry) {
        return entry == CRItems.PORTOBELLO_QUICHE ||
            entry == CRItems.LIME_PIE ||
            entry == CRItems.LIME_CAKE ||
            entry == CRItems.POMEGRANATE_CAKE ||
            entry == CRItems.LIME_SEEDS ||
            entry == CRItems.POMEGRANATE_SEEDS;
    }
}
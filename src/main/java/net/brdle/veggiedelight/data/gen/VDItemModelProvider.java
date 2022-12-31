package net.brdle.veggiedelight.data.gen;

import net.brdle.veggiedelight.Util;
import net.brdle.veggiedelight.VeggieDelight;
import net.brdle.veggiedelight.common.item.VDItems;
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

public class VDItemModelProvider extends ItemModelProvider {
    public VDItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, VeggieDelight.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        for (RegistryObject<Item> entry : VDItems.ITEMS.getEntries()) {
            ResourceLocation id = entry.getId();
            if (entry == VDItems.PORTOBELLO) {
                itemGeneratedModel(VDItems.PORTOBELLO.get(), VDBlockStateProvider.resourceBlock(Util.name(VDItems.PORTOBELLO)));
            } else if (entry == VDItems.PORTOBELLO_COLONY) {
                itemGeneratedModel(VDItems.PORTOBELLO_COLONY.get(), VDBlockStateProvider.resourceBlock(Util.name(VDItems.PORTOBELLO_COLONY) + "_stage3"));
            } else if (entry == VDItems.PORTOBELLO_QUICHE) {
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
        return withExistingParent(item.getPath(), ItemModels.HANDHELD).texture("layer0", Util.rl(VeggieDelight.MODID, "item/" + item.getPath()));
    }
}
package net.brdle.collectorsreap.common;

import net.brdle.collectorsreap.CollectorsReap;
import net.brdle.collectorsreap.common.crafting.EnabledCondition;
import net.brdle.collectorsreap.common.item.CRItems;
import net.brdle.collectorsreap.common.world.CRWorldGen;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid=CollectorsReap.MODID)
public class Events {

    @SubscribeEvent
    public static void setup(FMLCommonSetupEvent e) {
        e.enqueueWork(() -> {
            CRWorldGen.registerGeneration();

            //Flammables

            //Compostables
            compost(CRItems.PORTOBELLO, 0.65F);
            compost(CRItems.PORTOBELLO_COLONY, 0.85F);
            compost(CRItems.BAKED_PORTOBELLO_CAP, 0.65F);
            compost(CRItems.PORTOBELLO_QUICHE, 1.0F);
            compost(CRItems.PORTOBELLO_QUICHE_SLICE, 0.85F);
            compost(CRItems.PORTOBELLO_BURGER, 0.85F);
            compost(CRItems.PORTOBELLO_RICE_SOUP, 0.85F);
            compost(CRItems.POTATO_FRITTERS, 0.65F);
            compost(CRItems.LIME, 0.3F);
            compost(CRItems.LIME_SEEDS, 0.3F);
            compost(CRItems.LIME_PIE, 1.0F);
            compost(CRItems.LIME_PIE_SLICE, 0.85F);
            compost(CRItems.POMEGRANATE, 0.3F);
            compost(CRItems.POMEGRANATE_SLICE, 0.2F);
            compost(CRItems.POMEGRANATE_SEEDS, 0.1F);
        });
    }

    // Adds collectorsreap:enabled, etc. conditions
    @SubscribeEvent
    public static void registerSerializers(RegisterEvent event) {
        if (event.getRegistryKey() == ForgeRegistries.RECIPE_SERIALIZERS.getRegistryKey()) {
            CraftingHelper.register(EnabledCondition.Serializer.INSTANCE);
        }
    }

    public static void compost(RegistryObject<Item> it, float value) {
        ComposterBlock.COMPOSTABLES.put(it.get(), value);
    }
}

package net.brdle.collectorsreap.common;

import net.brdle.collectorsreap.common.block.CRCauldronInteractions;
import net.brdle.collectorsreap.common.crafting.EnabledCondition;
import net.brdle.collectorsreap.common.entity.*;
import net.brdle.collectorsreap.common.item.CRItems;
import net.brdle.collectorsreap.common.item.food.CompatConsumable;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.common.registry.ModCreativeTabs;

public class ModEvents {

    @SubscribeEvent
    public static void setup(FMLCommonSetupEvent e) {
        e.enqueueWork(() -> {
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

            //
            if (ModList.get().isLoaded("neapolitan")) {
                CRCauldronInteractions.registerCauldronInteractions();
            }
        });
    }

    public static void compost(RegistryObject<Item> it, float value) {
        ComposterBlock.COMPOSTABLES.put(it.get(), value);
    }

    @SubscribeEvent
    public static void registerEntityAttributes(EntityAttributeCreationEvent e) {
        e.put(CREntities.TIGER_PRAWN.get(), TigerPrawn.createAttributes().build());
        e.put(CREntities.URCHIN.get(), Urchin.createAttributes().build());
        e.put(CREntities.PLATINUM_BASS.get(), PlatinumBass.createAttributes().build());
        e.put(CREntities.CHIEFTAIN_CRAB.get(), ChieftainCrab.createAttributes().build());
        e.put(CREntities.CLAM.get(), Clam.createAttributes().build());
    }

    // Adds collectorsreap:enabled, etc. conditions
    @SubscribeEvent
    public static void registerSerializers(RegisterEvent e) {
        if (e.getRegistryKey() == ForgeRegistries.RECIPE_SERIALIZERS.getRegistryKey()) {
            CraftingHelper.register(EnabledCondition.Serializer.INSTANCE);
        }
    }

    @SubscribeEvent
    public void buildContents(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == ModCreativeTabs.TAB_FARMERS_DELIGHT.getKey()) {
            CRItems.ITEMS.getEntries().stream().filter(RegistryObject::isPresent).forEach((item) -> {
                Item i = item.get();
                if (i instanceof CompatConsumable compat && !ModList.get().isLoaded(compat.getModid())) {
                    return;
                }
                event.accept(i.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            });
        }
    }
}

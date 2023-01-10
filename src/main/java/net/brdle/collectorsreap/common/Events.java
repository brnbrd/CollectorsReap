package net.brdle.collectorsreap.common;

import net.brdle.collectorsreap.CollectorsReap;
import net.brdle.collectorsreap.common.crafting.EnabledCondition;
import net.brdle.collectorsreap.common.item.CRItems;
import net.brdle.collectorsreap.common.world.CRWorldGen;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;

@Mod.EventBusSubscriber(modid= CollectorsReap.MODID)
public class Events {

    @SubscribeEvent
    public static void setup(FMLCommonSetupEvent e) {
        e.enqueueWork(() -> {
            CRWorldGen.registerGeneration();

            //Flammables

            //Compostables
            ComposterBlock.COMPOSTABLES.put(CRItems.PORTOBELLO.get(), 0.65F);
            ComposterBlock.COMPOSTABLES.put(CRItems.BAKED_PORTOBELLO_CAP.get(), 0.65F);
        });
    }

    // Adds Delightful conditions
    @SubscribeEvent
    public static void registerSerializers(RegisterEvent event) {
        if (event.getRegistryKey() == ForgeRegistries.RECIPE_SERIALIZERS.getRegistryKey()) {
            CraftingHelper.register(EnabledCondition.Serializer.INSTANCE);
        }
    }
}

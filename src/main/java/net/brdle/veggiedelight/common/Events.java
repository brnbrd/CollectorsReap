package net.brdle.veggiedelight.common;

import net.brdle.veggiedelight.VeggieDelight;
import net.brdle.veggiedelight.common.crafting.EnabledCondition;
import net.brdle.veggiedelight.common.item.VDItems;
import net.brdle.veggiedelight.common.world.VDWorldGen;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;

@Mod.EventBusSubscriber(modid= VeggieDelight.MODID)
public class Events {

    @SubscribeEvent
    public static void setup(FMLCommonSetupEvent e) {
        e.enqueueWork(() -> {
            VDWorldGen.registerGeneration();

            //Flammables

            //Compostables
            ComposterBlock.COMPOSTABLES.put(VDItems.PORTOBELLO.get(), 0.65F);
            ComposterBlock.COMPOSTABLES.put(VDItems.BAKED_PORTOBELLO_CAP.get(), 0.65F);
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

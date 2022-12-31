package net.brdle.veggiedelight.data.gen;

import net.brdle.veggiedelight.VeggieDelight;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid=VeggieDelight.MODID)
public class Generators {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent e) {
        var gen = e.getGenerator();
        var helper = e.getExistingFileHelper();
        VDBlockTagProvider blockTag = new VDBlockTagProvider(gen, helper);
        e.getGenerator().addProvider(e.includeServer(), blockTag);
        e.getGenerator().addProvider(e.includeServer(), new VDItemTagProvider(gen, blockTag, helper));
        e.getGenerator().addProvider(e.includeServer(), new VDBiomeTagProvider(gen, helper));
        e.getGenerator().addProvider(e.includeServer(), new VDRecipeProvider(gen));
        e.getGenerator().addProvider(e.includeServer(), new VDLootTableProvider(gen));
        e.getGenerator().addProvider(e.includeServer(), new VDLootModifierProvider(gen));

        e.getGenerator().addProvider(e.includeClient(), new VDBlockStateProvider(gen, helper));
        e.getGenerator().addProvider(e.includeClient(), new VDBlockModelProvider(gen, helper));
        e.getGenerator().addProvider(e.includeClient(), new VDItemModelProvider(gen, helper));
        e.getGenerator().addProvider(e.includeClient(), new VDLanguageProvider(gen));
    }
}

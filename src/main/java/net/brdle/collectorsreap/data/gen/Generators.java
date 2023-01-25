package net.brdle.collectorsreap.data.gen;

import net.brdle.collectorsreap.CollectorsReap;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid=CollectorsReap.MODID)
public class Generators {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent e) {
        var gen = e.getGenerator();
        var helper = e.getExistingFileHelper();
        CRBlockTagProvider blockTag = new CRBlockTagProvider(gen, helper);
        e.getGenerator().addProvider(e.includeServer(), blockTag);
        e.getGenerator().addProvider(e.includeServer(), new CRItemTagProvider(gen, blockTag, helper));
        e.getGenerator().addProvider(e.includeServer(), new CRBiomeTagProvider(gen, helper));
        e.getGenerator().addProvider(e.includeServer(), new CRRecipeProvider(gen));
        e.getGenerator().addProvider(e.includeServer(), new CRLootTableProvider(gen));
        e.getGenerator().addProvider(e.includeServer(), new CRLootModifierProvider(gen));

        e.getGenerator().addProvider(e.includeClient(), new CRBlockStateProvider(gen, helper));
        e.getGenerator().addProvider(e.includeClient(), new CRItemModelProvider(gen, helper));
        e.getGenerator().addProvider(e.includeClient(), new CRLanguageProvider(gen));
    }
}

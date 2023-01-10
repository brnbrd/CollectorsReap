package net.brdle.collectorsreap.proxy;

import net.brdle.collectorsreap.common.Events;
import net.brdle.collectorsreap.common.ForgeEvents;
import net.brdle.collectorsreap.common.block.CRBlocks;
import net.brdle.collectorsreap.common.item.CRItems;
import net.brdle.collectorsreap.common.loot.CRLootItemConditions;
import net.brdle.collectorsreap.common.loot.CRLootModifiers;
import net.brdle.collectorsreap.common.world.CRFeatures;
import net.brdle.collectorsreap.data.gen.Generators;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class CommonProxy {

    public void start() {
        final var modBus = FMLJavaModLoadingContext.get().getModEventBus();
        final var forgeBus = MinecraftForge.EVENT_BUS;
        forgeBus.register(ForgeEvents.class);
        modBus.register(Events.class);
        modBus.register(Generators.class);
        CRBlocks.create(modBus);
        CRItems.create(modBus);
        CRFeatures.create(modBus);
        CRLootItemConditions.create(modBus);
        CRLootModifiers.create(modBus);
    }
}
package net.brdle.veggiedelight.proxy;

import net.brdle.veggiedelight.common.Events;
import net.brdle.veggiedelight.common.ForgeEvents;
import net.brdle.veggiedelight.common.block.VDBlocks;
import net.brdle.veggiedelight.common.item.VDItems;
import net.brdle.veggiedelight.common.loot.VDLootItemConditions;
import net.brdle.veggiedelight.common.loot.VDLootModifiers;
import net.brdle.veggiedelight.common.world.VDFeatures;
import net.brdle.veggiedelight.data.gen.Generators;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class CommonProxy {

    public void start() {
        final var modBus = FMLJavaModLoadingContext.get().getModEventBus();
        final var forgeBus = MinecraftForge.EVENT_BUS;
        forgeBus.register(ForgeEvents.class);
        modBus.register(Events.class);
        modBus.register(Generators.class);
        VDBlocks.create(modBus);
        VDItems.create(modBus);
        VDFeatures.create(modBus);
        VDLootItemConditions.create(modBus);
        VDLootModifiers.create(modBus);
    }
}
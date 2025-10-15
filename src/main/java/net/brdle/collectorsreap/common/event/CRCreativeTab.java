package net.brdle.collectorsreap.common.event;

import net.brdle.collectorsreap.CollectorsReap;
import net.brdle.collectorsreap.Util;
import net.brdle.collectorsreap.common.item.CRItems;
import net.brdle.collectorsreap.common.item.IConfigured;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class CRCreativeTab {
	public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CollectorsReap.MODID);

	public static final RegistryObject<CreativeModeTab> TAB_COLLECTORS_REAP = TABS.register(CollectorsReap.MODID, () ->
		CreativeModeTab.builder()
			.title(Component.translatable("itemGroup." + CollectorsReap.MODID))
			.icon(() -> Util.getStack(CRItems.POMEGRANATE))
			.displayItems((params, output) ->
				CRItems.HELPER.getDeferredRegister().getEntries().stream()
					.filter(RegistryObject::isPresent)
					.map(RegistryObject::get)
					.filter(item -> !(item instanceof IConfigured configured) || configured.enabled())
					.forEach(output::accept)
			).build());

	public static void create(IEventBus bus) {
		TABS.register(bus);
	}
}
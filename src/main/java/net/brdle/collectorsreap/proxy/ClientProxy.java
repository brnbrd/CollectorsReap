package net.brdle.collectorsreap.proxy;

import net.brdle.collectorsreap.client.ClientEvents;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class ClientProxy extends CommonProxy {
	@Override
	public void start() {
		super.start();
		final IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
		modBus.register(new ClientEvents());
	}
}
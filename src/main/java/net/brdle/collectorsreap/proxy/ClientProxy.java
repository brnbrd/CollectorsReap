package net.brdle.collectorsreap.proxy;

import net.brdle.collectorsreap.client.particle.AcidParticle;
import net.brdle.collectorsreap.common.CRParticleTypes;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class ClientProxy extends CommonProxy {

    @Override
    public void start() {
        super.start();
        final IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
        //final IEventBus forgeBus = MinecraftForge.EVENT_BUS;
        modBus.register(this);
    }

    /*@SubscribeEvent
    public void setupClient(FMLClientSetupEvent e){
    }*/

    @SubscribeEvent
    public void registerParticles(RegisterParticleProvidersEvent e) {
        e.register(CRParticleTypes.ACID.get(), AcidParticle.Provider::new);
    }
}

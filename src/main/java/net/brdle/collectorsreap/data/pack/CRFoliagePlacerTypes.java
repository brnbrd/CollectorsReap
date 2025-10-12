package net.brdle.collectorsreap.data.pack;

import net.brdle.collectorsreap.CollectorsReap;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class CRFoliagePlacerTypes {
	public static final DeferredRegister<FoliagePlacerType<?>> FOLIAGE_PLACERS = DeferredRegister.create(ForgeRegistries.FOLIAGE_PLACER_TYPES, CollectorsReap.MODID);

	public static void create(IEventBus bus) {
		FOLIAGE_PLACERS.register(bus);
	}
}
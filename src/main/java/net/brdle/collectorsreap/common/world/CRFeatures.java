package net.brdle.collectorsreap.common.world;

import net.brdle.collectorsreap.CollectorsReap;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CRFeatures {
	public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, CollectorsReap.MODID);

	public static final RegistryObject<Feature<SimpleBlockConfiguration>> BUSH_BLOCK = FEATURES.register("bush_block", () -> new BushBlockFeature(SimpleBlockConfiguration.CODEC));

	public static void create(IEventBus bus) {
		FEATURES.register(bus);
	}
}
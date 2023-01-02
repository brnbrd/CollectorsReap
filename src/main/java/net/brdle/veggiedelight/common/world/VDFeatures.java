package net.brdle.veggiedelight.common.world;

import net.brdle.veggiedelight.VeggieDelight;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class VDFeatures {
	public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, VeggieDelight.MODID);

	public static final RegistryObject<Feature<SimpleBlockConfiguration>> BUSH_BLOCK = FEATURES.register("bush_block", () -> new BushBlockFeature(SimpleBlockConfiguration.CODEC));

	public static void create(IEventBus bus) {
		FEATURES.register(bus);
	}
}
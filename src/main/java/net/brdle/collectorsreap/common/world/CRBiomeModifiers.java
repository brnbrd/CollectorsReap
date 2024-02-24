package net.brdle.collectorsreap.common.world;

import com.mojang.serialization.Codec;
import net.brdle.collectorsreap.CollectorsReap;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CRBiomeModifiers {
	public static DeferredRegister<Codec<? extends BiomeModifier>> BIOME_MODIFIERS = DeferredRegister.create(ForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, CollectorsReap.MODID);

	public static RegistryObject<Codec<AddSpawnBiomeModifier>> ADD_SPAWN = BIOME_MODIFIERS.register("add_spawn", () -> Codec.unit(AddSpawnBiomeModifier::new));

	public static void create(IEventBus bus) {
		BIOME_MODIFIERS.register(bus);
	}
}
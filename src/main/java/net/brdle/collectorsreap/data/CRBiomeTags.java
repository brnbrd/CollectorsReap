package net.brdle.collectorsreap.data;

import net.brdle.collectorsreap.Util;
import net.brdle.collectorsreap.CollectorsReap;
import net.minecraft.core.Registry;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;

public class CRBiomeTags {

	public static final TagKey<Biome> PORTOBELLO_SPAWNS = bind(CollectorsReap.MODID, "portobello_spawns");
	public static final TagKey<Biome> LEMON_SPAWNS = bind(CollectorsReap.MODID, "lemon_spawns");

	private static TagKey<Biome> bind(String modid, String name) {
		return TagKey.create(Registry.BIOME_REGISTRY, Util.rl(modid, name));
	}
}

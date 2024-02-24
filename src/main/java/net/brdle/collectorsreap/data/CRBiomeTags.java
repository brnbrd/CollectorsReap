package net.brdle.collectorsreap.data;

import net.brdle.collectorsreap.Util;
import net.brdle.collectorsreap.CollectorsReap;
import net.minecraft.core.Registry;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;

public class CRBiomeTags {

	public static final TagKey<Biome> PORTOBELLO_SPAWNS = bind(CollectorsReap.MODID, "portobello_spawns");
	public static final TagKey<Biome> LIME_SPAWNS = bind(CollectorsReap.MODID, "lime_spawns");
	public static final TagKey<Biome> POMEGRANATE_SPAWNS = bind(CollectorsReap.MODID, "pomegranate_spawns");
	public static final TagKey<Biome> PLATINUM_BASS_SPAWNS = bind(CollectorsReap.MODID, "platinum_bass_spawns");
	public static final TagKey<Biome> TIGER_PRAWN_SPAWNS = bind(CollectorsReap.MODID, "tiger_prawn_spawns");
	public static final TagKey<Biome> URCHIN_SPAWNS = bind(CollectorsReap.MODID, "urchin_spawns");
	public static final TagKey<Biome> CLAM_SPAWNS = bind(CollectorsReap.MODID, "clam_spawns");
	public static final TagKey<Biome> CHIEFTAIN_CRAB_SPAWNS = bind(CollectorsReap.MODID, "chieftain_crab_spawns");

	private static TagKey<Biome> bind(String modid, String name) {
		return TagKey.create(Registry.BIOME_REGISTRY, Util.rl(modid, name));
	}
}

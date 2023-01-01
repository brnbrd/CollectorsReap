package net.brdle.veggiedelight.data;

import net.brdle.veggiedelight.Util;
import net.brdle.veggiedelight.VeggieDelight;
import net.minecraft.core.Registry;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;

public class VDBiomeTags {

	public static final TagKey<Biome> PORTOBELLO_SPAWNS = bind(VeggieDelight.MODID, "portobello_spawns");
	public static final TagKey<Biome> LEMON_SPAWNS = bind(VeggieDelight.MODID, "lemon_spawns");

	private static TagKey<Biome> bind(String modid, String name) {
		return TagKey.create(Registry.BIOME_REGISTRY, Util.rl(modid, name));
	}
}

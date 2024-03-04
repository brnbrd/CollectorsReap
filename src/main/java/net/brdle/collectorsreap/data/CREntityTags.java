package net.brdle.collectorsreap.data;

import net.brdle.collectorsreap.CollectorsReap;
import net.brdle.collectorsreap.Util;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;

public class CREntityTags {

	// Forge

	// CR
	public static final TagKey<EntityType<?>> CORROSION_IMMUNE = vd("corrosion_immune");
	public static final TagKey<EntityType<?>> VOLATILITY_IMMUNE = vd("volatility_immune");
	public static final TagKey<EntityType<?>> INVOLATILE = vd("involatile");

	private static TagKey<EntityType<?>> vd(String name) {
		return TagKey.create(Registries.ENTITY_TYPE, Util.rl(CollectorsReap.MODID, name));
	}
}
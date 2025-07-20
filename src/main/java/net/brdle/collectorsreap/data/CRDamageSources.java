package net.brdle.collectorsreap.data;

import net.brdle.collectorsreap.Util;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.damagesource.DamageType;
import org.jetbrains.annotations.NotNull;

public class CRDamageSources {
	public static final TagKey<DamageType> TRIGGERS_SURGE = bind("triggers_surge");

	private static TagKey<DamageType> bind(@NotNull String name) {
		return TagKey.create(Registries.DAMAGE_TYPE, Util.cr(name));
	}
}
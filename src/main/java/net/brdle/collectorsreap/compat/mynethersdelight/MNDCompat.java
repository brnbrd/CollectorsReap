package net.brdle.collectorsreap.compat.mynethersdelight;

import net.brdle.collectorsreap.compat.Modid;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;

public class MNDCompat {
	public static MobEffect getBeneficialPungent() {
		return Modid.MND.effect("g_pungent", MobEffects.DAMAGE_RESISTANCE);
	}
}
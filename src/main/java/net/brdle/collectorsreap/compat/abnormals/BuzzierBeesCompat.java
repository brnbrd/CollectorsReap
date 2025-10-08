package net.brdle.collectorsreap.compat.abnormals;

import net.brdle.collectorsreap.compat.Modid;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;

public class BuzzierBeesCompat {
	public static MobEffect getSunny() {
		return Modid.BB.effect("sunny", MobEffects.DIG_SPEED);
	}
}
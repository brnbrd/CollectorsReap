package net.brdle.collectorsreap.compat.abnormals;

import net.brdle.collectorsreap.compat.Modid;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;

public class NeapolitanCompat {
	public static SoundEvent getIceCreamEatSound() {
		return (
			Modid.N.loaded() ?
			NeapolitanUtils.ICE_CREAM_EAT.get() :
			SoundEvents.GENERIC_EAT
		);
	}
}
package net.brdle.collectorsreap.compat.abnormals;

import net.brdle.collectorsreap.compat.Modid;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;

public class NeapolitanCompat {
	public static SoundEvent getIceCreamEatSound() {
		return (
			Modid.N.loaded() ?
			NeapolitanUtils.ICE_CREAM_EAT.get() :
			SoundEvents.GENERIC_EAT
		);
	}

	public static MobEffect getAgility() {
		return Modid.N.effect("agility", MobEffects.CONFUSION);
	}

	public static MobEffect getVanillaScent() {
		return Modid.N.effect("vanilla_scent", MobEffects.CONFUSION);
	}

	public static MobEffect getSugarRush() {
		return Modid.N.effect("sugar_rush", MobEffects.MOVEMENT_SPEED);
	}

	public static MobEffect getBerserking() {
		return Modid.N.effect("berserking", MobEffects.CONFUSION);
	}

	public static MobEffect getHarmony() {
		return Modid.N.effect("harmony", MobEffects.CONFUSION);
	}
}
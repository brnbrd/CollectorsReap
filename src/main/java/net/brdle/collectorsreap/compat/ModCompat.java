package net.brdle.collectorsreap.compat;

import net.brdle.collectorsreap.Util;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.CreativeModeTab;
import java.util.function.Supplier;
import org.jetbrains.annotations.Nullable;

public class ModCompat {
	@Nullable
	public static CreativeModeTab ifLoaded(String modid, CreativeModeTab tab) {
		return ifLoaded(modid, () -> tab);
	}

	@Nullable
	public static CreativeModeTab ifLoaded(String modid, Supplier<CreativeModeTab> tab) {
		if (Mods.stringLoaded(modid)) {
			return tab.get();
		} else {
			return null;
		}
	}

	public static MobEffect getCaffeinated() {
		return Util.effect("farmersrespite", "caffeinated", MobEffects.CONFUSION);
	}

	public static MobEffect getAgility() {
		return Util.effect("neapolitan", "agility", MobEffects.CONFUSION);
	}

	public static MobEffect getVanillaScent() {
		return Util.effect("neapolitan", "vanilla_scent", MobEffects.CONFUSION);
	}

	public static MobEffect getSugarRush() {
		return Util.effect("neapolitan", "sugar_rush", MobEffects.MOVEMENT_SPEED);
	}

	public static MobEffect getBerserking() {
		return Util.effect("neapolitan", "berserking", MobEffects.CONFUSION);
	}

	public static MobEffect getHarmony() {
		return Util.effect("neapolitan", "harmony", MobEffects.CONFUSION);
	}

	public static MobEffect getSpitting() {
		return Util.effect("atmospheric", "spitting", MobEffects.CONFUSION);
	}

	public static MobEffect getPersistence() {
		return Util.effect("atmospheric", "persistence", MobEffects.CONFUSION);
	}

	public static MobEffect getRelief() {
		return Util.effect("atmospheric", "relief", MobEffects.CONFUSION);
	}

	public static MobEffect getStuffed() {
		return Util.effect("seasonals", "stuffed", MobEffects.CONFUSION);
	}

	public static MobEffect getThornResistance() {
		return Util.effect("seasonals", "thorn_resistance", MobEffects.FIRE_RESISTANCE);
	}

	public static MobEffect getRooted() {
		return Util.effect("seasonals", "rooted", MobEffects.DAMAGE_RESISTANCE);
	}

	public static MobEffect getVitality() {
		return Util.effect("respiteful", "vitality", MobEffects.DIG_SPEED);
	}

	public static MobEffect getTenacity() {
		return Util.effect("respiteful", "tenacity", MobEffects.DAMAGE_RESISTANCE);
	}

	public static MobEffect getMaturity() {
		return Util.effect("respiteful", "maturity", getCaffeinated());
	}

	public static MobEffect getTipsy() {
		return Util.effect("brewinandchewin", "tipsy", getCaffeinated());
	}

	public static MobEffect getIntoxication() {
		return Util.effect("brewinandchewin", "intoxication", getCaffeinated());
	}

	public static MobEffect getRaging() {
		return Util.effect("brewinandchewin", "raging", getCaffeinated());
	}

	public static MobEffect getSweetHeart() {
		return Util.effect("brewinandchewin", "sweet_heart", getCaffeinated());
	}

	public static MobEffect getTracer() {
		return Util.effect("cosmopolitan", "tracer", MobEffects.GLOWING);
	}
}
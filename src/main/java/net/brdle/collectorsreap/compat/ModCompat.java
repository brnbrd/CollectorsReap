package net.brdle.collectorsreap.compat;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.CreativeModeTab;
import java.util.function.Supplier;
import vectorwing.farmersdelight.common.registry.ModEffects;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.NotNull;

public class ModCompat {
	@Nullable
	public static CreativeModeTab ifLoaded(Modid modid, CreativeModeTab tab) {
		return ifLoaded(modid, () -> tab);
	}

	@Nullable
	public static CreativeModeTab ifLoaded(@NotNull Modid modid, Supplier<CreativeModeTab> tab) {
		return modid.loaded() ? tab.get() : null;
	}

	public static MobEffect getCaffeinated() {
		return Modid.FR.effect("caffeinated", MobEffects.CONFUSION);
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

	public static MobEffect getSpitting() {
		return Modid.AT.effect("spitting", MobEffects.CONFUSION);
	}

	public static MobEffect getPersistence() {
		return Modid.AT.effect("persistence", MobEffects.CONFUSION);
	}

	public static MobEffect getRelief() {
		return Modid.AT.effect("relief", MobEffects.CONFUSION);
	}

	public static MobEffect getStuffed() {
		return Modid.SEAS.effect("stuffed", MobEffects.CONFUSION);
	}

	public static MobEffect getThornResistance() {
		return Modid.SEAS.effect("thorn_resistance", MobEffects.FIRE_RESISTANCE);
	}

	public static MobEffect getRooted() {
		return Modid.SEAS.effect("rooted", MobEffects.DAMAGE_RESISTANCE);
	}

	public static MobEffect getVitality() {
		return Modid.RF.effect("vitality", MobEffects.DIG_SPEED);
	}

	public static MobEffect getTenacity() {
		return Modid.RF.effect("tenacity", MobEffects.DAMAGE_RESISTANCE);
	}

	public static MobEffect getMaturity() {
		return Modid.RF.effect("maturity", getCaffeinated());
	}

	public static MobEffect getTipsy() {
		return Modid.BC.effect("tipsy", getCaffeinated());
	}

	public static MobEffect getIntoxication() {
		return Modid.BC.effect("intoxication", getCaffeinated());
	}

	public static MobEffect getRaging() {
		return Modid.BC.effect("raging", getCaffeinated());
	}

	public static MobEffect getSweetHeart() {
		return Modid.BC.effect("sweet_heart", getCaffeinated());
	}

	public static MobEffect getTracer() {
		return Modid.COS.effect("tracer", MobEffects.GLOWING);
	}

	public static MobEffect getExuberant() {
		return Modid.COS.effect("exuberant", ModEffects.COMFORT.get());
	}
}
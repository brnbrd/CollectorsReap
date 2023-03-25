package net.brdle.collectorsreap.compat;

import net.minecraft.world.effect.MobEffect;
import plus.dragons.respiteful.entries.RespitefulMobEffects;
import java.util.function.Supplier;

public class RespitefulCompat {
	public static Supplier<MobEffect> VITALITY = RespitefulMobEffects.VITALITY;
	public static Supplier<MobEffect> TENACITY = RespitefulMobEffects.TENACITY;
	public static Supplier<MobEffect> MATURITY = RespitefulMobEffects.MATURITY;
}

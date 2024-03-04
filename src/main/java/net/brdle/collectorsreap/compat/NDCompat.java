package net.brdle.collectorsreap.compat;

import net.minecraft.world.item.CreativeModeTab;
import umpaz.nethersdelight.common.registry.NDCreativeTab;

import java.util.function.Supplier;

public class NDCompat {
	public static Supplier<CreativeModeTab> CREATIVE_TAB = NDCreativeTab.NETHERS_DELIGHT_TAB;
}

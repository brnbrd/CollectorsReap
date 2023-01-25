package net.brdle.collectorsreap.compat;

import net.minecraft.world.item.CreativeModeTab;
import umpaz.nethersdelight.NethersDelight;
import java.util.function.Supplier;

public class NDCompat {
	public static Supplier<CreativeModeTab> CREATIVE_TAB = () -> NethersDelight.CREATIVE_TAB;
}

package net.brdle.collectorsreap.compat;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.fml.ModList;
import org.jetbrains.annotations.Nullable;

public class ModCompat {
	@Nullable public static CreativeModeTab getNDTab() {
		return ifLoaded("nethersdelight", NDCompat.CREATIVE_TAB.get());
	}

	@Nullable public static CreativeModeTab ifLoaded(String modid, CreativeModeTab tab) {
		if (ModList.get().isLoaded(modid)) {
			return tab;
		} else {
			return null;
		}
	}
}

package net.brdle.collectorsreap.compat;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.fml.ModList;
import org.jetbrains.annotations.Nullable;

public class ModCompat {
	@Nullable public static CreativeModeTab getNDTab() {
		if (ModList.get().isLoaded("nethersdelight")) {
			return NDCompat.CREATIVE_TAB.get();
		} else {
			return null;
		}
	}
}

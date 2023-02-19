package net.brdle.collectorsreap.compat;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.fml.ModList;
import org.jetbrains.annotations.Nullable;
import java.util.function.Supplier;

public class ModCompat {
	@Nullable public static CreativeModeTab getNDTab() {
		return ifLoaded("nethersdelight", NDCompat.CREATIVE_TAB);
	}

	@Nullable public static CreativeModeTab ifLoaded(String modid, CreativeModeTab tab) {
		return ifLoaded(modid, () -> tab);
	}

	@Nullable public static CreativeModeTab ifLoaded(String modid, Supplier<CreativeModeTab> tab) {
		if (ModList.get().isLoaded(modid)) {
			return tab.get();
		} else {
			return null;
		}
	}
}

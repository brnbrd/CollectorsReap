package net.brdle.collectorsreap.compat;

import net.brdle.collectorsreap.CollectorsReap;
import net.brdle.collectorsreap.Util;
import net.minecraftforge.fml.ModList;
import vectorwing.farmersdelight.FarmersDelight;
import org.jetbrains.annotations.NotNull;

public class Mods {
	public static boolean stringLoaded(@NotNull String stringId) {
		return (
			stringId.equals(CollectorsReap.MODID) ||
			stringId.equals(FarmersDelight.MODID) ||
			stringId.equals(Util.MC) ||
			ModList.get().isLoaded(stringId)
		);
	}
}
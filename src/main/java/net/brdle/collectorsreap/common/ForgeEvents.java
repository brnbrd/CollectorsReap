package net.brdle.collectorsreap.common;

import net.brdle.collectorsreap.CollectorsReap;
import net.brdle.collectorsreap.Util;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.MissingMappingsEvent;

@Mod.EventBusSubscriber(modid= CollectorsReap.MODID)
public class ForgeEvents {

	@SubscribeEvent
	public static void onMissingBlockMappings(MissingMappingsEvent e) {
		if (e.getRegistry() == ForgeRegistries.ITEMS) {
			for (var map : e.getMappings(ForgeRegistries.ITEMS.getRegistryKey(), CollectorsReap.MODID)) {
				var remap = Util.rl(CollectorsReap.MODID, map.getKey().getPath().replace("lemon", "lime"));
				if (ForgeRegistries.ITEMS.containsKey(remap)) {
					map.remap(ForgeRegistries.ITEMS.getValue(remap));
				} else {
					map.warn();
				}
			}
		} else if (e.getRegistry() == ForgeRegistries.BLOCKS) {
			for (var map : e.getMappings(ForgeRegistries.BLOCKS.getRegistryKey(), CollectorsReap.MODID)) {
				var remap = Util.rl(CollectorsReap.MODID, map.getKey().getPath().replace("lemon", "lime"));
				if (ForgeRegistries.BLOCKS.containsKey(remap)) {
					map.remap(ForgeRegistries.BLOCKS.getValue(remap));
				} else {
					map.warn();
				}
			}
		}
	}

}
package net.brdle.collectorsreap.data;

import net.brdle.collectorsreap.Util;
import net.brdle.collectorsreap.CollectorsReap;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class CRBlockTags {

	public static final TagKey<Block> PORTOBELLO_SPAWNS = bind(CollectorsReap.MODID, "portobello_spawns");

	public static final TagKey<Block> POMEGRANATE_FAST_ON = bind(CollectorsReap.MODID, "pomegranate_fast_on");

	private static TagKey<Block> bind(String modid, String name) {
		return BlockTags.create(Util.rl(modid, name));
	}
}

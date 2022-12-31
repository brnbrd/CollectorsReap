package net.brdle.veggiedelight.data;

import net.brdle.veggiedelight.Util;
import net.brdle.veggiedelight.VeggieDelight;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class VDBlockTags {

	public static final TagKey<Block> PORTOBELLO_SPAWNS = bind(VeggieDelight.MODID, "portobello_spawns");

	private static TagKey<Block> bind(String modid, String name) {
		return BlockTags.create(Util.rl(modid, name));
	}
}

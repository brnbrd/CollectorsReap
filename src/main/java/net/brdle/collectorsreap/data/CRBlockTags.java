package net.brdle.collectorsreap.data;

import net.brdle.collectorsreap.CollectorsReap;
import net.brdle.collectorsreap.Util;
import net.brdle.collectorsreap.common.entity.CREntities;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

public class CRBlockTags {
	// Collector's Reap
	public static final TagKey<Block> PORTOBELLO_SPAWNABLE_ON = bind(CollectorsReap.MODID, "portobello_spawnable_on");
	public static final TagKey<Block> DRAGON_FRUIT_SPAWNABLE_ON = bind(CollectorsReap.MODID, "dragon_fruit_spawnable_on");
	public static final TagKey<Block> POMEGRANATE_FAST_ON = bind(CollectorsReap.MODID, "pomegranate_fast_on");
	public static final TagKey<Block> STYGIAN_POMEGRANATE_GROWABLE_ON = bind(CollectorsReap.MODID, "stygian_pomegranate_growable_on");
	public static final TagKey<Block> CRAB_SPAWNABLE_ON = bind(CollectorsReap.MODID, "crab_spawnable_on");

	// Forge
	public static final TagKey<Block> STORAGE_BLOCKS_LIME = forge("storage_blocks/lime");
	public static final TagKey<Block> STORAGE_BLOCKS_POMEGRANATE = forge("storage_blocks/pomegranate");
	public static final TagKey<Block> STORAGE_BLOCKS_STYGIAN_POMEGRANATE = forge("storage_blocks/stygian_pomegranate");
	public static final TagKey<Block> STORAGE_BLOCKS_PINK_DRAGON_FRUIT = forge("storage_blocks/pink_dragon_fruit");

	// Serene Seasons
	public static final TagKey<Block> WINTER_CROPS = bind("sereneseasons", "winter_crops");
	public static final TagKey<Block> SUMMER_CROPS = bind("sereneseasons", "summer_crops");
	public static final TagKey<Block> AUTUMN_CROPS = bind("sereneseasons", "autumn_crops");
	public static final TagKey<Block> SPRING_CROPS = bind("sereneseasons", "spring_crops");

	// My Nether's Delight
	public static final TagKey<Block> SHOWCASE_ACTIVATORS = bind("mynethersdelight", "showcase_activators");
	public static final TagKey<Block> NOT_PROPAGATE_PLANT = bind("mynethersdelight", "not_propagate_plant");

	// Let Fish Love
	public static final TagKey<Block> FISH_ROE_PLATINUM_BASS = bind("letfishlove",
		"fish_roe/" + CollectorsReap.MODID + "/" + CREntities.PLATINUM_BASS.getId().getPath());
	public static final TagKey<Block> FISH_ROE_TIGER_PRAWN = bind("letfishlove",
		"fish_roe/" + CollectorsReap.MODID + "/" + CREntities.TIGER_PRAWN.getId().getPath());

	// Supplementaries
	public static final TagKey<Block> HANG_FROM_ROPES = bind("supplementaries", "hang_from_ropes");

	private static TagKey<Block> bind(String modid, String name) {
		return BlockTags.create(Util.rl(modid, name));
	}

	private static TagKey<Block> forge(@NotNull String name) {
		return bind("forge", name);
	}
}
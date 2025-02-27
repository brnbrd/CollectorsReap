package net.brdle.collectorsreap.compat.letfishlove;

import net.brdle.collectorsreap.common.block.CRBlocks;
import net.brdle.collectorsreap.common.entity.CREntities;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class LetFishLoveCompat {
	public static Block platinumBassRoeBlock() {
		return new CRRoeBlock(CREntities.PLATINUM_BASS::get);
	}

	public static Item platinumBassRoeItem() {
		return new CRRoeItem(CRBlocks.PLATINUM_BASS_ROE);
	}

	public static Block tigerPrawnRoeBlock() {
		return new CRRoeBlock(CREntities.TIGER_PRAWN::get);
	}

	public static Item tigerPrawnRoeItem() {
		return new CRRoeItem(CRBlocks.TIGER_PRAWN_ROE);
	}
}
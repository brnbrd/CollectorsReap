package net.brdle.collectorsreap.common.block;

import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;

public class WoodenCrateBlock extends Block {
	public WoodenCrateBlock(MapColor color) {
		super(BlockBehaviour.Properties.of()
			.strength(2.0F, 3.0F)
			.sound(SoundType.WOOD)
			.mapColor(color)
		);
	}

	public WoodenCrateBlock(DyeColor color) {
		super(BlockBehaviour.Properties.of()
			.strength(2.0F, 3.0F)
			.sound(SoundType.WOOD)
			.mapColor(color)
		);
	}
}
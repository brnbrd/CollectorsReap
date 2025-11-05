package net.brdle.collectorsreap.common.item.food;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import org.jetbrains.annotations.NotNull;

public class GildedLucumaItem extends LucumaItem {
	public GildedLucumaItem(Properties properties) {
		super(properties);
	}

	@Override
	public @NotNull Rarity getRarity(@NotNull ItemStack stack) {
		return Rarity.RARE;
	}
}
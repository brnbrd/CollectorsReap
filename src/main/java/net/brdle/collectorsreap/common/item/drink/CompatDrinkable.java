package net.brdle.collectorsreap.common.item.drink;

import net.brdle.collectorsreap.common.item.IConfigured;
import net.brdle.collectorsreap.compat.Modid;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import vectorwing.farmersdelight.common.item.DrinkableItem;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class CompatDrinkable extends DrinkableItem implements IConfigured {
	private final Modid[] modid;

	public CompatDrinkable(Properties properties, boolean hasPotionEffectTooltip, boolean hasCustomTooltip, Modid... modid) {
		super(
			properties,
			hasPotionEffectTooltip,
			hasCustomTooltip
		);
		this.modid = modid;
	}

	public Modid[] getModid() {
		return this.modid;
	}

	@Override
	public void appendHoverText(@NotNull ItemStack stack, @Nullable Level level, @NotNull List<Component> comps, @NotNull TooltipFlag isAdvanced) {
		if (this.enabledText(comps)) {
			super.appendHoverText(stack, level, comps, isAdvanced);
		}
	}
}
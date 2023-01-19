package net.brdle.collectorsreap.common.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.ModList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vectorwing.farmersdelight.common.item.ConsumableItem;
import java.util.List;

public class CompatConsumable extends ConsumableItem {

	private String modid;
	public CompatConsumable(Properties properties, boolean hasFoodEffectTooltip, boolean hasCustomTooltip, String modid) {
		super(properties, hasFoodEffectTooltip, hasCustomTooltip);
		this.modid = modid;
	}

	@Override
	public void appendHoverText(@NotNull ItemStack stack, @Nullable Level level, @NotNull List<Component> tooltip, @NotNull TooltipFlag isAdvanced) {
		if (!ModList.get().isLoaded(this.modid)) {
			tooltip.add(Component.translatable("tooltip.requires_modid"));
			tooltip.add(Component.literal(this.modid));
		}
		super.appendHoverText(stack, level, tooltip, isAdvanced);
	}
}

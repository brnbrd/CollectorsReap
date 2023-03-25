package net.brdle.collectorsreap.common.item.food;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.ModList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vectorwing.farmersdelight.common.item.ConsumableItem;
import java.util.List;

public class CompatConsumable extends ConsumableItem {

	private final String modid;
	private final float heal;
	public CompatConsumable(Properties properties, boolean hasFoodEffectTooltip, boolean hasCustomTooltip, String modid) {
		super(properties, hasFoodEffectTooltip, hasCustomTooltip);
		this.modid = modid;
		this.heal = 0.0F;
	}

	public CompatConsumable(Properties properties, boolean hasFoodEffectTooltip, boolean hasCustomTooltip, String modid, float heal) {
		super(properties, hasFoodEffectTooltip, hasCustomTooltip);
		this.modid = modid;
		this.heal = heal;
	}

	@Override
	public void appendHoverText(@NotNull ItemStack stack, @Nullable Level level, @NotNull List<Component> tooltip, @NotNull TooltipFlag isAdvanced) {
		setTooltip(tooltip, this.modid);
		super.appendHoverText(stack, level, tooltip, isAdvanced);
	}

	public static void setTooltip(List<Component> tool, String modid) {
		if (!ModList.get().isLoaded(modid)) {
			tool.add(Component.translatable("tooltip.requires_modid").withStyle(ChatFormatting.GRAY));
			tool.add(Component.literal(modid).withStyle(ChatFormatting.UNDERLINE));
		}
	}

	@Override
	public @NotNull ItemStack finishUsingItem(@NotNull ItemStack stack, @NotNull Level worldIn, @NotNull LivingEntity entity) {
		if (ModList.get().isLoaded(modid) && this.heal > 0.0F) {
			entity.heal(this.heal);
		}
		return super.finishUsingItem(stack, worldIn, entity);
	}
}

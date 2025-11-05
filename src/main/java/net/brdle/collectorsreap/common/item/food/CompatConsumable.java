package net.brdle.collectorsreap.common.item.food;

import net.brdle.collectorsreap.common.item.IConfigured;
import net.brdle.collectorsreap.compat.Modid;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import vectorwing.farmersdelight.common.item.ConsumableItem;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class CompatConsumable extends ConsumableItem implements IConfigured {
	private final Modid[] modid;
	private final float heal;

	public CompatConsumable(Properties properties, boolean hasFoodEffectTooltip, boolean hasCustomTooltip, Modid... modid) {
		super(properties, hasFoodEffectTooltip, hasCustomTooltip);
		this.heal = 0F;
		this.modid = modid;
	}

	public CompatConsumable(Properties properties, boolean hasFoodEffectTooltip, boolean hasCustomTooltip, float heal, Modid... modid) {
		super(properties, hasFoodEffectTooltip, hasCustomTooltip);
		this.heal = heal;
		this.modid = modid;
	}

	public float getHeal() {
		return this.heal;
	}

	@Override
	public void affectConsumer(@NotNull ItemStack stack, @NotNull Level level, @NotNull LivingEntity consumer) {
		super.affectConsumer(stack, level, consumer);
		if (this.enabled() && this.getHeal() > 0F) consumer.heal(this.getHeal());
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
package net.brdle.collectorsreap.common.item.food;

import net.brdle.collectorsreap.common.item.IConfigured;
import net.brdle.collectorsreap.compat.Modid;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import vectorwing.farmersdelight.common.item.ConsumableItem;
import org.jetbrains.annotations.NotNull;

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

	public Modid[] getModid() {
		return this.modid;
	}

	public float getHeal() {
		return this.heal;
	}

	@Override
	public void affectConsumer(@NotNull ItemStack stack, @NotNull Level level, @NotNull LivingEntity consumer) {
		super.affectConsumer(stack, level, consumer);
		if (this.enabled() && this.getHeal() > 0F) consumer.heal(this.getHeal());
	}
}
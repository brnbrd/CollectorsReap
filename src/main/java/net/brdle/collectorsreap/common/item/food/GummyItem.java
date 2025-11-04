package net.brdle.collectorsreap.common.item.food;

import net.brdle.collectorsreap.Util;
import net.brdle.collectorsreap.compat.Modid;
import net.brdle.collectorsreap.data.CRItemTags;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffectUtil;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import java.util.List;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class GummyItem extends CompatConsumable {
	public GummyItem(Properties prop, Modid... modid) {
		super(prop, true, false, modid);
	}

	public GummyItem(Properties prop, boolean hasCustomTooltip, Modid... modid) {
		super(prop, true, hasCustomTooltip, modid);
	}

	@Override
	public int getUseDuration(@NotNull ItemStack stack) {
		return 14;
	}

	@Override
	public void appendHoverText(@NotNull ItemStack stack, @Nullable Level level, @NotNull List<Component> comps, @NotNull TooltipFlag isAdvanced) {
		super.appendHoverText(stack, level, comps, isAdvanced);
		if (this.enabled() && stack.is(CRItemTags.GUMMIES_MOB_FEEDABLE)) {
			comps.add(Component.empty());
			comps.add(Util.crTooltip(Util.name(this) + ".when_feeding").withStyle(ChatFormatting.GRAY));
			for (MobEffectInstance effectInstance : this.getEffects(stack, null)) {
				MutableComponent effectDescription = Component.literal(" ");
				effectDescription.append(Component.translatable(effectInstance.getDescriptionId()));
				MobEffect effect = effectInstance.getEffect();
				if (effectInstance.getAmplifier() > 0) {
					effectDescription.append(" ").append(Component.translatable("potion.potency." + effectInstance.getAmplifier()));
				}
				if (effectInstance.getDuration() > 20) {
					effectDescription.append(" (").append(MobEffectUtil.formatDuration(effectInstance, 1.0F)).append(")");
				}
				comps.add(effectDescription.withStyle(effect.getCategory().getTooltipFormatting()));
			}
		}
	}

	protected List<MobEffectInstance> getEffects(@NotNull ItemStack stack, @Nullable LivingEntity consumer) {
		return Util.getFoodEffects(stack.getFoodProperties(consumer));
	}

	// Applies food effects when called, used for mob_feedable interaction
	public void addEffects(@NotNull ItemStack stack, @NotNull LivingEntity consumer) {
		if (this.enabled()) {
			Util.addEffects(consumer, this.getEffects(stack, consumer));
		}
	}
}
package net.brdle.collectorsreap.common.item.food;

import net.brdle.collectorsreap.common.item.CRItems;
import net.brdle.collectorsreap.compat.ModCompat;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.ModList;
import org.jetbrains.annotations.NotNull;

public class GummyItem extends Item {
	private static final int MAX_NEARBY = 3;

	public GummyItem(Properties prop) {
		super(prop);
	}

	@Override
	public int getUseDuration(@NotNull ItemStack stack) {
		return 14;
	}

	@Override
	public @NotNull ItemStack finishUsingItem(@NotNull ItemStack stack, @NotNull Level worldIn, @NotNull LivingEntity entity) {
		if (ModList.get().isLoaded("neapolitan")) {
			if (this == CRItems.ADZUKI_GUMMY.get()) {
				worldIn.getNearbyEntities(LivingEntity.class,
					TargetingConditions.DEFAULT.selector((living) -> {
						return (living != entity && living.getEffect(ModCompat.getVanillaScent().get()) == null);
					}), entity, entity.getBoundingBox().inflate(6.0D, 2.0D, 6.0D)).stream().limit(MAX_NEARBY)
					.forEach(n -> n.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 200, 3)));
			} else if (this == CRItems.STRAWBERRY_GUMMY.get()) {
				entity.heal(3.0F);
			}
		} else if (ModList.get().isLoaded("atmospheric")) {
			if (this == CRItems.ALOE_GUMMY.get()) {
				entity.clearFire();
			}
		}
		return super.finishUsingItem(stack, worldIn, entity);
	}
}

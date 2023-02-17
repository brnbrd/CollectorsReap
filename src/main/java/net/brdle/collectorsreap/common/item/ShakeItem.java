package net.brdle.collectorsreap.common.item;

import com.google.common.collect.Lists;
import net.brdle.collectorsreap.compat.NeapolitanCompat;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.ModList;
import vectorwing.farmersdelight.common.item.ConsumableItem;
import java.util.List;

public class ShakeItem extends ConsumableItem {
	private static final int MAX_NEARBY = 3;

	public ShakeItem(Properties properties) {
		super(properties);
	}

	@Override
	public ItemStack finishUsingItem(ItemStack stack, Level worldIn, LivingEntity entity) {
		handleEffects(entity);
		return super.finishUsingItem(stack, worldIn, entity);
	}

	@Override
	public InteractionResult interactLivingEntity(ItemStack stack, Player player, LivingEntity entity, InteractionHand hand) {
		if (!ModList.get().isLoaded("neapolitan")) {
			return InteractionResult.FAIL;
		}
		if (entity.level.isClientSide()) {
			return InteractionResult.CONSUME;
		}
		entity.level.playSound(null, entity.blockPosition(), SoundEvents.WANDERING_TRADER_DRINK_MILK, SoundSource.NEUTRAL, 1, 1);
		if (player instanceof ServerPlayer serverplayerentity) {
			CriteriaTriggers.CONSUME_ITEM.trigger(serverplayerentity, stack);
			serverplayerentity.awardStat(Stats.ITEM_USED.get(this));
		}
		if (entity.getEffect(NeapolitanCompat.VANILLA_SCRENT.get()) == null) {
			handleEffects(entity);
		}
		if (!player.getAbilities().instabuild) {
			stack.shrink(1);
			ItemStack itemstack = new ItemStack(Items.GLASS_BOTTLE);
			if (!player.getInventory().add(itemstack)) {
				player.drop(itemstack, false);
			}
		}
		return InteractionResult.SUCCESS;
	}

	private void handleEffects(LivingEntity user) {
		List<MobEffectInstance> effects = Lists.newArrayList(user.getActiveEffects());
		List<LivingEntity> nearest = user.level.getNearbyEntities(LivingEntity.class,
			TargetingConditions.DEFAULT.selector((living) -> {
				return (living != user && living.getEffect(NeapolitanCompat.VANILLA_SCRENT.get()) == null);
			}), user, user.getBoundingBox().inflate(6.0D, 2.0D, 6.0D)).stream().limit(MAX_NEARBY).toList();
		if (nearest.size() > 0) {
			for (LivingEntity near : nearest) {
				if (this == CRItems.LIME_MILKSHAKE.get()) {
					effects = effects.stream()
						.filter(i -> !i.getEffect().isBeneficial())
						.map(i -> new MobEffectInstance(i.getEffect(), i.getDuration() / 2, i.getAmplifier()))
						.toList();
				} else if (this == CRItems.POMEGRANATE_MILKSHAKE.get()) {
					effects = effects.stream()
						.filter(i -> i.getEffect().isBeneficial())
						.map(i -> new MobEffectInstance(i.getEffect(), i.getDuration() / 2, i.getAmplifier()))
						.toList();
				}
				effects.forEach(near::addEffect);
			}
		}
	}

	@Override
	public int getUseDuration(ItemStack stack) {
		return 40;
	}

	@Override
	public UseAnim getUseAnimation(ItemStack stack) {
		return UseAnim.DRINK;
	}

	@Override
	public SoundEvent getDrinkingSound() {
		return SoundEvents.HONEY_DRINK;
	}

	@Override
	public SoundEvent getEatingSound() {
		return SoundEvents.HONEY_DRINK;
	}
}

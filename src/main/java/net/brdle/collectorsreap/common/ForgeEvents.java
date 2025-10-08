package net.brdle.collectorsreap.common;

import net.brdle.collectorsreap.Util;
import net.brdle.collectorsreap.common.config.CRConfig;
import net.brdle.collectorsreap.common.effect.CREffects;
import net.brdle.collectorsreap.common.effect.CorrosionEffect;
import net.brdle.collectorsreap.common.effect.SurgeEffect;
import net.brdle.collectorsreap.common.entity.BeeGoToFruitBushGoal;
import net.brdle.collectorsreap.common.entity.BeeGrowFruitGoal;
import net.brdle.collectorsreap.common.item.CRItems;
import net.brdle.collectorsreap.data.CRDamageSources;
import net.brdle.collectorsreap.data.CREntityTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.animal.Bee;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.ThrownTrident;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.ProjectileImpactEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import java.util.List;
import java.util.Objects;

public class ForgeEvents {
	@SubscribeEvent
	public void onBeeJoin(EntityJoinLevelEvent e) {
		if (e.getEntity() instanceof Bee bee) {
			bee.getGoalSelector().addGoal(3, new BeeGrowFruitGoal(bee));
			bee.getGoalSelector().addGoal(4, new BeeGoToFruitBushGoal(bee));
		}
	}

	@SubscribeEvent
	public void onWanderingTrader(WandererTradesEvent e) {
		final List<VillagerTrades.ItemListing> trades = e.getGenericTrades();
		if (Util.enabled(CRItems.PORTOBELLO)) {
			trades.add((ent, r) -> new MerchantOffer(new ItemStack(Items.BROWN_MUSHROOM, 4),
				Util.getStack(CRItems.PORTOBELLO), 10, 1, 1));
		}
		if (Util.enabled(CRItems.LIME) && Util.enabled(CRItems.LIME_SEEDS)) {
			trades.add((ent, r) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1),
				Util.getStack(CRItems.LIME_SEEDS), 5, 1, 1));
		}
		if (Util.enabled(CRItems.PINK_DRAGON_FRUIT) && Util.enabled(CRItems.DRAGON_FRUIT_SEEDS)) {
			trades.add((ent, r) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1),
				Util.getStack(CRItems.DRAGON_FRUIT_SEEDS), 5, 1, 1));
		}
		if (Util.enabled(CRItems.LUCUMA)) {
			trades.add((ent, r) -> new MerchantOffer(new ItemStack(Items.EMERALD, 3),
				Util.getStack(CRItems.LUCUMA, 3), 5, 1, 1));
			if (Util.enabled(CRItems.GILDED_LUCUMA)) {
				trades.add((ent, r) -> new MerchantOffer(new ItemStack(Items.EMERALD, 10),
					Util.getStack(CRItems.GILDED_LUCUMA, 1), 5, 1, 1));
			}
		}
	}

	// Rebound
	@SubscribeEvent(priority = EventPriority.HIGHEST) // Apply damage modifiers early
	public void onReboundDamage(LivingDamageEvent e) {
		final LivingEntity hurt = e.getEntity();
		final MobEffect rebound = CREffects.REBOUND.get();
		if (
			!hurt.level().isClientSide() &&
			hurt.hasEffect(rebound) &&
			e.getAmount() > 0F &&
			hurt.level() instanceof ServerLevel server &&
			server.getRandom().nextFloat() <= CRConfig.REBOUND_CHANCE.get() // 15% chance to recover
		) {
			final MobEffectInstance effectInstance = hurt.getEffect(rebound);
			if (effectInstance != null) {
				final float recoveredHealth = (6F * effectInstance.getAmplifier()) + 10F;
				final float initialDamage = e.getAmount();
				if (recoveredHealth > initialDamage) {
					e.setAmount(0F);
					hurt.heal(recoveredHealth - initialDamage);
				} else {
					e.setAmount(initialDamage - recoveredHealth);
				}
				server.playSound(null, hurt.getX(), hurt.getY(), hurt.getZ(), CRSoundEvents.REBOUND_HEAL.get(), SoundSource.NEUTRAL, 0.8F, 0.8F);
			}
		}
	}

	// Surge
	@SubscribeEvent(priority = EventPriority.HIGH) // Apply damage modifiers early
	public void onSurgeDamage(LivingDamageEvent e) {
		final MobEffect surge = CREffects.SURGE.get();
		final DamageSource source = e.getSource();
		final LivingEntity hurt = e.getEntity();
		if (
			source.is(CRDamageSources.TRIGGERS_SURGE) &&
			source.getEntity() instanceof LivingEntity living &&
			!living.level().isClientSide() &&
			living.hasEffect(surge) &&
			(!(living instanceof Player player) || player.getAttackStrengthScale(0F) > 0.8F)
		) {
			final MobEffectInstance effectInstance = living.getEffect(surge);
			if (effectInstance != null) {
				final float beforeDamage = e.getAmount();
				final int amplifier = effectInstance.getAmplifier();

				// Hurt
				e.setAmount(
					Util.roundToHalf((beforeDamage + amplifier + 1F) *
						(float) switch (amplifier) {
							case 0 -> CRConfig.SURGE_ZERO_MULTIPLIER.get();
							case 1 -> CRConfig.SURGE_ONE_MULTIPLIER.get();
							case 2 -> CRConfig.SURGE_TWO_MULTIPLIER.get();
							default -> 1F;
						}
					)
				);

				// Knockback
				if (amplifier == SurgeEffect.MAX_SURGE) {
					SurgeEffect.emitParticles(hurt, 12);
					hurt.knockback(2.2D, -living.getLookAngle().x(), -living.getLookAngle().z());
				} else {
					SurgeEffect.emitParticles(hurt, 3);
				}

				// Increment Surge amplifier or reset to zero
				final int duration = effectInstance.getDuration();
				living.removeEffect(surge);
				living.addEffect(new MobEffectInstance(
					surge,
					duration,
					amplifier >= SurgeEffect.MAX_SURGE ? 0 : Math.min(SurgeEffect.MAX_SURGE, amplifier + 1),
					effectInstance.isAmbient(),
					effectInstance.isVisible(),
					effectInstance.showIcon()
				));
			}
		}
	}

	// Weapon Corrosion
	@SuppressWarnings("DataFlowIssue")
	@SubscribeEvent(priority = EventPriority.HIGH)
	public void onCorrodeWeapon(LivingDamageEvent e) {
		final LivingEntity victim = e.getEntity();
		if (
			e.getSource().getDirectEntity() instanceof LivingEntity attacker &&
			victim.hasEffect(CREffects.CORROSION.get())
		) {
			final int amplifier = victim.getEffect(CREffects.CORROSION.get()).getAmplifier();
			final InteractionHand hand = attacker.getUsedItemHand();
			final ItemStack stack = attacker.getItemInHand(hand);
			if (
				victim.level() instanceof ServerLevel server &&
				stack.isDamageableItem()
			) {
				stack.hurtAndBreak(amplifier, victim, en -> en.broadcastBreakEvent(hand));
				CorrosionEffect.emitParticles(victim, amplifier);
				server.playSound(null, victim.getX(), victim.getY(), victim.getZ(), CRSoundEvents.CORROSION_CORRODE.get(), SoundSource.NEUTRAL, 0.8F, 1.1F);
			}
		}
	}

	// Projectile Corrosion
	@SuppressWarnings("DataFlowIssue")
	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public void onCorrodeProjectile(ProjectileImpactEvent e) {
		final Projectile projectile = e.getProjectile();
		if (
			!projectile.getType().is(CREntityTags.CORROSION_IMMUNE) &&
			e.getRayTraceResult() instanceof EntityHitResult result &&
			result.getEntity() instanceof LivingEntity victim &&
			victim.hasEffect(CREffects.CORROSION.get())
		) {
			final int amplifier = victim.getEffect(CREffects.CORROSION.get()).getAmplifier();
			if (victim.level() instanceof ServerLevel server) {
				e.setCanceled(true);
				if (projectile instanceof ThrownTrident trident) {
					trident.tridentItem.hurt(5 * amplifier, victim.getRandom(), null);
				} else {
					projectile.discard();
					projectile.gameEvent(GameEvent.ENTITY_DIE);
				}
				CorrosionEffect.emitParticles(victim, amplifier);
				server.playSound(null, victim.getX(), victim.getY(), victim.getZ(), CRSoundEvents.CORROSION_CORRODE.get(), SoundSource.NEUTRAL, 0.8F, 1.1F);
			}
		}
	}

	// Volatility
	private boolean validateVolatile(LivingEntity attacker) {
		return (
			attacker != null &&
			attacker.hasEffect(CREffects.VOLATILITY.get()) &&
			!attacker.getType().is(CREntityTags.INVOLATILE) &&
			!(attacker instanceof Player p && p.getAttackStrengthScale(0F) != 1F)
		);
	}

	@SubscribeEvent
	public void onVolatile(LivingDamageEvent e) {
		LivingEntity victim = e.getEntity();
		if (
			victim instanceof Mob &&
			e.getSource().getEntity() != null &&
			!victim.level().isClientSide() &&
			victim.level() instanceof ServerLevel server &&
			!victim.hasEffect(MobEffects.DAMAGE_RESISTANCE) &&
			e.getSource().getEntity() instanceof LivingEntity attacker &&
			attacker != victim &&
			validateVolatile(attacker)
		) {
			server.sendParticles(CRParticleTypes.SHOCKWAVE.get(), victim.getX(), victim.getY(), victim.getZ(), 1, 0D, 0D, 0D, 0D);
			int level = Objects.requireNonNull(attacker.getEffect(CREffects.VOLATILITY.get())).getAmplifier();
			List<Mob> mobs = server.getNearbyEntities(Mob.class,
					TargetingConditions.DEFAULT.selector(mob -> (
						mob != attacker &&
						mob != victim &&
						!mob.getType().is(CREntityTags.VOLATILITY_IMMUNE) &&
						!(mob instanceof TamableAnimal tame && tame.isTame())
					)),
					victim, victim.getBoundingBox().inflate(4D + ((double) level), 2D, 4D + ((double) level)))
				.stream().limit(3 + level).toList();
			if (!mobs.isEmpty()) {
				float hurtAmount = Math.round(((e.getAmount() + ((level + 2F) * 0.85F)) / (mobs.size() + 1)) * 2F) / 2F;
				mobs.forEach(mob -> {
					mob.forceAddEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 10, 0), null);
					Vec3 vec32 = mob.getEyePosition().subtract(victim.position().add(0D, 1F, 0D)).normalize();
					mob.playSound(SoundEvents.LIGHTNING_BOLT_THUNDER, 0.2F, 1.75F);
					mob.hurt(e.getSource(), hurtAmount);
					double d1 = (1D - mob.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE)) * 0.75D;
					mob.push(vec32.x() * d1, vec32.y() * d1 * 0.35D, vec32.z() * d1);
				});
			}
		}
	}
}
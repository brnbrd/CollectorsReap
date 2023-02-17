package net.brdle.collectorsreap.common;

import net.brdle.collectorsreap.CollectorsReap;
import net.brdle.collectorsreap.Util;
import net.brdle.collectorsreap.common.block.CRBlocks;
import net.brdle.collectorsreap.common.config.CRConfig;
import net.brdle.collectorsreap.common.effect.CREffects;
import net.brdle.collectorsreap.common.item.CRItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.ThrownTrident;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.MissingMappingsEvent;

import java.util.List;
import java.util.Objects;

@Mod.EventBusSubscriber(modid=CollectorsReap.MODID)
public class ForgeEvents {

	@SubscribeEvent
	public static void onMissingMappings(MissingMappingsEvent e) {
		if (e.getRegistry() == ForgeRegistries.ITEMS) {
			for (var map : e.getMappings(ForgeRegistries.ITEMS.getRegistryKey(), CollectorsReap.MODID)) {
				var remap = Util.cr(map.getKey().getPath().replace("lemon", "lime"));
				if (ForgeRegistries.ITEMS.containsKey(remap)) {
					map.remap(ForgeRegistries.ITEMS.getValue(remap));
				} else {
					map.warn();
				}
			}
		} else if (e.getRegistry() == ForgeRegistries.BLOCKS) {
			for (var map : e.getMappings(ForgeRegistries.BLOCKS.getRegistryKey(), CollectorsReap.MODID)) {
				String path = map.getKey().getPath();
				if (path.equalsIgnoreCase("medium_lime_bush") || path.equalsIgnoreCase("medium_lemon_bush")) {
					map.remap(CRBlocks.LIME_BUSH.get());
				} else {
					ResourceLocation remap = Util.cr(path.replace("lemon", "lime"));
					if (ForgeRegistries.BLOCKS.containsKey(remap)) {
						map.remap(ForgeRegistries.BLOCKS.getValue(remap));
					} else {
						map.warn();
					}
				}
			}
		}
	}

	@SubscribeEvent
	public static void onWanderingTrader(WandererTradesEvent e) {
		if (CRConfig.verify(CRItems.LIME) && CRConfig.verify(CRItems.LIME_SEEDS)) {
			e.getGenericTrades()
				.add((ent, r) ->
					new MerchantOffer(new ItemStack(Items.EMERALD, 1), Util.gs(CRItems.LIME_SEEDS), 5, 1, 1));
		}
	}

	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public static void onCorrode(LivingAttackEvent e) {
		LivingEntity victim = e.getEntity();
		Level world = victim.getLevel();
		DamageSource d = e.getSource();
		if (victim.hasEffect(CREffects.CORROSION.get())) {
			if (d.isProjectile() && d.getDirectEntity() != null && d.getDirectEntity() instanceof Projectile proj) {
				if (d.getEntity() != null) {
					double x = ((victim.getX() * 2.0D) + d.getEntity().getX()) / 3.0D;
					double y = victim.getY() + 0.5D;
					double z = ((victim.getZ() * 2.0D) + d.getEntity().getZ()) / 3.0D;
					world.addParticle(CRParticleTypes.ACID.get(), x, y, z, 0.0D, 0.0D, 0.0D);
				}
				world.playSound(null, e.getEntity(), SoundEvents.REDSTONE_TORCH_BURNOUT, SoundSource.NEUTRAL, 0.4F, 1.1F);
				if (proj instanceof ThrownTrident trident) {
					trident.hurt(DamageSource.mobAttack(victim), 3.0F);
				} else {
					proj.discard();
				}
				e.setCanceled(true);
			} else if (d.getEntity() instanceof Player p) {
				InteractionHand hand = p.getUsedItemHand();
				ItemStack stack = p.getItemInHand(hand);
				if (p.hasEffect(CREffects.CORROSION.get()) && stack.isDamageableItem()) {
					stack.hurtAndBreak(Objects.requireNonNull(p.getEffect(CREffects.CORROSION.get())).getAmplifier(), p, en -> en.broadcastBreakEvent(hand));
				}
			}
		}
	}

	@SubscribeEvent(priority = EventPriority.HIGH)
	public static void onVolatile(LivingAttackEvent e) {
		LivingEntity victim = e.getEntity();
		if (!victim.getLevel().isClientSide() && victim.getLevel() instanceof ServerLevel server) {
			DamageSource d = e.getSource();
			if (d.getEntity() != null &&
				d.getEntity() instanceof LivingEntity attacker &&
				attacker.hasEffect(CREffects.VOLATILITY.get())) {
				if (attacker instanceof Player p) {
					ItemStack inHand = p.getMainHandItem();
					if (p.getCooldowns().isOnCooldown(inHand.getItem())) {
						return;
					} else {
						p.getCooldowns().addCooldown(inHand.getItem(), 40);
					}
				}
				List<LivingEntity> nearby = server.getNearbyEntities(LivingEntity.class, TargetingConditions.forCombat().ignoreLineOfSight().range(5.0D), victim, victim.getBoundingBox().inflate(4.0D, 2.0D, 4.0D));
				nearby.remove(attacker);
				float damage = 2.0F + (4.0F / nearby.size());
				server.sendParticles(CRParticleTypes.SHOCKWAVE.get(), victim.getX(), victim.getY(), victim.getZ(), 1, 0.0D, 0.0D, 0.0D, 0.0D);
				for (LivingEntity ent : nearby) {
					Vec3 vec3 = attacker.position().add(0.0D, 1.0F, 0.0D);
					Vec3 vec31 = ent.getEyePosition().subtract(vec3);
					Vec3 vec32 = vec31.normalize();
					/*for (int i = 1; i < Mth.floor(vec31.length()) + 7; ++i) {
						Vec3 vec33 = vec3.add(vec32.scale(i));
						server.sendParticles(CRParticleTypes.SHOCKWAVE.get(), vec33.x, vec33.y, vec33.z, 1, 0.0D, 0.0D, 0.0D, 0.0D);
					}*/
					attacker.playSound(SoundEvents.WARDEN_SONIC_BOOM, 3.0F, 1.0F);
					ent.hurt(DamageSource.mobAttack(ent), damage);
					double d1 = (1.0D - ent.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
					ent.push(vec32.x() * d1, vec32.y() * d1 * 0.5D, vec32.z() * d1);
				}
			}
		}
	}
}
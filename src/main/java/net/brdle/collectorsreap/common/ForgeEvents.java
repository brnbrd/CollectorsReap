package net.brdle.collectorsreap.common;

import net.brdle.collectorsreap.CollectorsReap;
import net.brdle.collectorsreap.Util;
import net.brdle.collectorsreap.common.block.CRBlocks;
import net.brdle.collectorsreap.common.config.CRConfig;
import net.brdle.collectorsreap.common.effect.CREffects;
import net.brdle.collectorsreap.common.item.CRItems;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.player.Player;
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
			if (d.isProjectile() && d.getDirectEntity() != null) {
				if (d.getEntity() != null) {
					double x = ((victim.getX() * 2.0D) + d.getEntity().getX()) / 3.0D;
					double y = victim.getY() + 0.5D;
					double z = ((victim.getZ() * 2.0D) + d.getEntity().getZ()) / 3.0D;
					world.addParticle(CRParticleTypes.ACID.get(), x, y, z, 0.0D, 0.0D, 0.0D);
				}
				world.playSound(null, e.getEntity(), SoundEvents.REDSTONE_TORCH_BURNOUT, SoundSource.NEUTRAL, 0.4F, 1.1F);
				d.getDirectEntity().kill();
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
		Level world = victim.getLevel();
		if (world.isClientSide()) {
			return;
		}
		DamageSource d = e.getSource();
		if (d.getEntity() != null && d.getEntity() instanceof LivingEntity attacker && attacker.hasEffect(CREffects.VOLATILITY.get())) {
			for (LivingEntity ent : world.getNearbyEntities(LivingEntity.class, TargetingConditions.forCombat().ignoreLineOfSight().range(5.0D), victim, victim.getBoundingBox().inflate(4.0D, 2.0D, 4.0D))) {
				if (ent != attacker) {
					Vec3 vec3 = attacker.position().add(0.0D, 1.6F, 0.0D);
					Vec3 vec31 = ent.getEyePosition().subtract(vec3);
					Vec3 vec32 = vec31.normalize();
					for (int i = 1; i < Mth.floor(vec31.length()) + 7; ++i) {
						Vec3 vec33 = vec3.add(vec32.scale(i));
						((ServerLevel)world).sendParticles(ParticleTypes.SONIC_BOOM, vec33.x, vec33.y, vec33.z, 1, 0.0D, 0.0D, 0.0D, 0.0D);
					}
					attacker.playSound(SoundEvents.WARDEN_SONIC_BOOM, 3.0F, 1.0F);
					ent.hurt(DamageSource.mobAttack(ent), 10.0F);
					double d1 = 0.5D * (1.0D - ent.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
					double d0 = 2.5D * (1.0D - ent.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
					ent.push(vec32.x() * d0, vec32.y() * d1, vec32.z() * d0);
				}
			}
		}
	}
}
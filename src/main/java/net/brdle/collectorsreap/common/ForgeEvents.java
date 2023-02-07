package net.brdle.collectorsreap.common;

import net.brdle.collectorsreap.CollectorsReap;
import net.brdle.collectorsreap.Util;
import net.brdle.collectorsreap.common.block.CRBlocks;
import net.brdle.collectorsreap.common.config.CRConfig;
import net.brdle.collectorsreap.common.effect.CREffects;
import net.brdle.collectorsreap.common.item.CRItems;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.MissingMappingsEvent;

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
		Level world = e.getEntity().getLevel();
		DamageSource d = e.getSource();
		if (d.isProjectile() && e.getEntity().hasEffect(CREffects.CORROSION.get()) && d.getDirectEntity() != null) {
			world.addParticle(CRParticleTypes.ACID.get(), (e.getEntity().getX() + d.getDirectEntity().getX()) / 2.0D, d.getDirectEntity().getY(), (e.getEntity().getZ() + d.getDirectEntity().getZ()) / 2.0D, 0.0D, 0.0D, 0.0D);
			world.playSound(null, e.getEntity(), SoundEvents.REDSTONE_TORCH_BURNOUT, SoundSource.NEUTRAL, 0.4F, 1.1F);
			d.getDirectEntity().kill();
			e.setCanceled(true);
		} else if (d.getEntity() instanceof Player p) {
			InteractionHand hand = p.getUsedItemHand();
			ItemStack stack = p.getItemInHand(hand);
			if (p.hasEffect(CREffects.CORROSION.get()) && stack.isDamageableItem()) {
				stack.hurtAndBreak(1, p, en -> en.broadcastBreakEvent(hand));
			}
		}
	}

}
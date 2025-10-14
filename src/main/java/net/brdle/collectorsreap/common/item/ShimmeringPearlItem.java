package net.brdle.collectorsreap.common.item;

import net.brdle.collectorsreap.common.event.CRSoundEvents;
import net.brdle.collectorsreap.common.entity.ThrownShimmeringPearl;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class ShimmeringPearlItem extends Item {
	public ShimmeringPearlItem(Properties properties) {
		super(properties);
	}

	@Override
	public boolean isFoil(@NotNull ItemStack stack) {
		return true;
	}

	@Override
	public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand hand) {
		final ItemStack itemstack = player.getItemInHand(hand);
		level.playSound(null, player.getX(), player.getY(), player.getZ(), CRSoundEvents.SHIMMERING_PEARL_THROW.get(), SoundSource.NEUTRAL, 0.5F, 0.4F / (level.getRandom().nextFloat() * 0.4F + 0.8F));
		player.getCooldowns().addCooldown(this, 15);
		if (!level.isClientSide()) {
			ThrownShimmeringPearl thrown = new ThrownShimmeringPearl(level, player);
			thrown.setItem(itemstack);
			thrown.shootFromRotation(player, player.getXRot(), player.getYRot(), 0F, 1.75F, 1F);
			level.addFreshEntity(thrown);
		}
		player.awardStat(Stats.ITEM_USED.get(this));
		if (!player.getAbilities().instabuild) {
			itemstack.shrink(1);
		}
		return InteractionResultHolder.sidedSuccess(itemstack, level.isClientSide());
	}
}
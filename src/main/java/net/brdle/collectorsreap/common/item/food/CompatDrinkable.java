package net.brdle.collectorsreap.common.item.food;

import net.brdle.collectorsreap.compat.ModCompat;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import vectorwing.farmersdelight.FarmersDelight;
import java.util.Objects;

public class CompatDrinkable extends CompatConsumable {

	public CompatDrinkable(Properties properties, boolean hasPotionEffectTooltip, boolean hasCustomTooltip, String modid) {
		super(properties.craftRemainder(Items.GLASS_BOTTLE)
			.stacksTo(16).tab(ModCompat.ifLoaded(modid, FarmersDelight.CREATIVE_TAB)),
			hasPotionEffectTooltip, hasCustomTooltip, modid);
	}

	@Override
	public int getUseDuration(@NotNull ItemStack stack) {
		return 32;
	}

	@Override
	public @NotNull UseAnim getUseAnimation(@NotNull ItemStack stack) {
		return UseAnim.DRINK;
	}

	@Override
	public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level level, Player player, @NotNull InteractionHand hand) {
		ItemStack heldStack = player.getItemInHand(hand);
		if (heldStack.isEdible()) {
			if (player.canEat(Objects.requireNonNull(heldStack.getFoodProperties(player)).canAlwaysEat())) {
				player.startUsingItem(hand);
				return InteractionResultHolder.consume(heldStack);
			} else {
				return InteractionResultHolder.fail(heldStack);
			}
		} else {
			return ItemUtils.startUsingInstantly(level, player, hand);
		}
	}
}

package net.brdle.collectorsreap.common.item.food;

import net.brdle.collectorsreap.compat.ModCompat;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class IceCreamItem extends CompatConsumable {

	public IceCreamItem(Properties properties) {
		super(properties
			.craftRemainder(Items.BOWL)
			.stacksTo(1)
			.tab(ModCompat.ifLoaded("neapolitan", CreativeModeTab.TAB_BUILDING_BLOCKS)),
		false, false, "neapolitan");
	}

	@Override
	public @NotNull ItemStack finishUsingItem(@NotNull ItemStack stack, @NotNull Level level, LivingEntity entity) {
		entity.setTicksFrozen(entity.getTicksFrozen() + 200);
		return super.finishUsingItem(stack, level, entity);
	}
}

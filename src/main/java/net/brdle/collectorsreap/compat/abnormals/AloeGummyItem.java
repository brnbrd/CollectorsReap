package net.brdle.collectorsreap.compat.abnormals;

import net.brdle.collectorsreap.common.item.food.GummyItem;
import net.brdle.collectorsreap.compat.Modid;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class AloeGummyItem extends GummyItem {
	public AloeGummyItem(Properties prop, Modid... modid) {
		super(prop, modid);
	}

	@Override
	public void affectConsumer(@NotNull ItemStack stack, @NotNull Level level, @NotNull LivingEntity consumer) {
		super.affectConsumer(stack, level, consumer);
		if (this.enabled()) consumer.clearFire();
	}
}
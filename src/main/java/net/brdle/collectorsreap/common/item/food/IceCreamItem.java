package net.brdle.collectorsreap.common.item.food;

import net.brdle.collectorsreap.compat.Modid;
import net.brdle.collectorsreap.compat.abnormals.NeapolitanCompat;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class IceCreamItem extends CompatConsumable {
	public IceCreamItem(Properties properties) {
		super(properties.craftRemainder(Items.BOWL).stacksTo(1), false, false, Modid.N);
	}

	public IceCreamItem(Properties properties, float heal) {
		super(properties.craftRemainder(Items.BOWL).stacksTo(1), false, false, heal, Modid.N);
	}

	@Override
	public void affectConsumer(@NotNull ItemStack stack, @NotNull Level level, @NotNull LivingEntity consumer) {
		if (this.enabled()) consumer.setTicksFrozen(consumer.getTicksFrozen() + 200);
		super.affectConsumer(stack, level, consumer);
	}

	@Override
	public @NotNull SoundEvent getEatingSound() {
		return NeapolitanCompat.getIceCreamEatSound();
	}
}
package net.brdle.collectorsreap.common.item.food;

import net.brdle.collectorsreap.compat.Modid;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class StygianPomegranateItem extends CompatConsumable {
	public StygianPomegranateItem(Properties properties) {
		super(properties, false, true, 1F, Modid.MND);
	}

	@Override
	public @NotNull Rarity getRarity(@NotNull ItemStack stack) {
		return Rarity.RARE;
	}

	@Override
	public void affectConsumer(@NotNull ItemStack stack, @NotNull Level level, @NotNull LivingEntity consumer) {
		super.affectConsumer(stack, level, consumer);
		if (this.enabled()) {
			level.explode(
				consumer,
				consumer.getX(),
				consumer.getY(),
				consumer.getZ(),
				3F,
				Level.ExplosionInteraction.NONE
			);
		}
	}
}
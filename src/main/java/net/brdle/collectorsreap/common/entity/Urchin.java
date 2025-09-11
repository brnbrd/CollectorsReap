package net.brdle.collectorsreap.common.entity;

import net.brdle.collectorsreap.common.item.CRItems;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.ForgeMod;
import org.jetbrains.annotations.NotNull;

public class Urchin extends WaterGroundCreature {

	public Urchin(EntityType<? extends Urchin> type, Level level) {
		super(type, level);
	}

	public static AttributeSupplier.@NotNull Builder createAttributes() {
		return Mob.createMobAttributes()
			.add(Attributes.MOVEMENT_SPEED, 0.1D)
			.add(Attributes.MAX_HEALTH, 10D);
	}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(0, new PanicGoal(this, 1.5D));
		this.goalSelector.addGoal(2, new AvoidEntityGoal<>(this, Player.class, 6F, 1.25D, 1.35D, EntitySelector.NO_SPECTATORS::test));
		this.goalSelector.addGoal(4, new RandomSwimmingGoal(this, 0.5D, 40));
	}

	@Override
	public @NotNull ItemStack getBucketItemStack() {
		return CRItems.URCHIN_BUCKET.get().getDefaultInstance();
	}

	@Override
	public boolean isPushable() {
		return false;
	}

	@Override
	public void aiStep() {
		if (this.isInWater() && !this.onGround()) {
			this.sinkInFluid(ForgeMod.WATER_TYPE.get());
		}
		super.aiStep();
	}

	@Override
	public boolean hurt(@NotNull DamageSource source, float amount) {
		final boolean superHurt = super.hurt(source, amount); // Also checks !clientSide and isInvulnerableTo
		if (
			superHurt &&
			!source.isIndirect() &&
			source.getEntity() instanceof final LivingEntity attacker
		) {
			final DamageSource thorns = this.damageSources().thorns(this);
			if (!attacker.isDeadOrDying() && !attacker.isInvulnerableTo(thorns)) {
				attacker.hurt(thorns, 2F);
				attacker.addEffect(new MobEffectInstance(MobEffects.POISON, 60, 0), this);
			}
		}
		return superHurt;
	}
}
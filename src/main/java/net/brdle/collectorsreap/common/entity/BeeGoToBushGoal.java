package net.brdle.collectorsreap.common.entity;

import net.brdle.collectorsreap.common.block.LimeBushBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.animal.Bee;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class BeeGoToBushGoal extends Goal {

	private final Bee bee;
	int travellingTicks;

	public BeeGoToBushGoal(Bee bee) {
		this.bee = bee;
		this.travellingTicks = bee.level().random.nextInt(10);
	}

	public boolean validateLime(BlockPos pos, Level world) {
		BlockState b = world.getBlockState(pos);
		return b.getBlock() instanceof LimeBushBlock lime &&
			(b.getValue(lime.getAgeProperty()) != lime.getMaxAge() - 1);
	}

	public boolean canBeeUse() {
		return (this.bee.getSavedFlowerPos() == null || validateLime(this.bee.getSavedFlowerPos(), this.bee.level())) && !this.bee.hasRestriction() && this.wantsToGoToBush() && this.bee.isFlowerValid(this.bee.getSavedFlowerPos()) && !this.bee.closerThan(this.bee.getSavedFlowerPos(), 2);
	}

	public boolean canBeeContinueToUse() {
		return this.canBeeUse();
	}

	/**
	 * Execute a one shot task or start executing a continuous task
	 */
	public void start() {
		this.travellingTicks = 0;
		super.start();
	}

	/**
	 * Reset the task's internal state. Called when this task is interrupted by another one
	 */
	public void stop() {
		this.travellingTicks = 0;
		this.bee.getNavigation().stop();
		this.bee.getNavigation().resetMaxVisitedNodesMultiplier();
	}

	/**
	 * Keep ticking a continuous task that has already been started
	 */
	public void tick() {
		if (this.bee.getSavedFlowerPos() != null) {
			++this.travellingTicks;
			if (this.travellingTicks > this.adjustedTickDelay(600)) {
				this.bee.setSavedFlowerPos(null);
			} else if (!this.bee.getNavigation().isInProgress()) {
				if (this.bee.isTooFarAway(this.bee.getSavedFlowerPos())) {
					this.bee.setSavedFlowerPos(null);
				} else {
					this.bee.pathfindRandomlyTowards(this.bee.getSavedFlowerPos());
				}
			}
		}
	}

	private boolean wantsToGoToBush() {
		return this.bee.ticksWithoutNectarSinceExitingHive > 2000;
	}

	/**
	 * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
	 * method as well.
	 */
	public boolean canUse() {
		return this.canBeeUse() && !this.bee.isAngry();
	}

	/**
	 * Returns whether an in-progress EntityAIBase should continue executing
	 */
	public boolean canContinueToUse() {
		return this.canBeeContinueToUse() && !this.bee.isAngry();
	}
}
package net.brdle.collectorsreap.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.common.Tags;
import java.util.Optional;
import org.jetbrains.annotations.NotNull;

public abstract class FruitBushBlock extends TallBushCropBlock {
	public static final int MAX_AGE = 4;
	public static final IntegerProperty AGE = BlockStateProperties.AGE_4;
	public static final BooleanProperty STUNTED = BooleanProperty.create("stunted");

	public FruitBushBlock(Properties properties) {
		super(properties);
		this.registerDefaultState(this.stateDefinition.any()
			.setValue(this.getAgeProperty(), 0)
			.setValue(HALF, DoubleBlockHalf.LOWER)
			.setValue(STUNTED, false)
		);
	}

	@Override
	public final IntegerProperty getAgeProperty() {
		return AGE;
	}

	@Override
	public final int getMaxAge() {
		return MAX_AGE;
	}

	@Override
	public int getShortThreshold() {
		return 1;
	}

	public abstract Item getFruit();

	public abstract Item getSeeds();

	@Override
	public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		super.createBlockStateDefinition(builder);
		builder.add(STUNTED);
	}

	@Override
	public boolean isRandomlyTicking(@NotNull BlockState state) {
		return super.isRandomlyTicking(state) && !state.getValue(STUNTED);
	}

	@Override
	public ItemStack getCloneItemStack(BlockState state, HitResult target, BlockGetter level, BlockPos pos, Player player) {
		return new ItemStack(this.getSeeds());
	}

	public Optional<Item> getSpecialFruit() {
		return Optional.empty();
	}

	public boolean hasSpecialFruit() {
		return this.getSpecialFruit().isPresent();
	}

	public int getSpecialChance() {
		return 0;
	}

	public boolean isSpecial(Level level, BlockPos pos) {
		int chance = this.getSpecialChance();
		return (
			this.hasSpecialFruit() &
			chance > 0 &&
			level.getRandom().nextInt(chance) == 0
		);
	}

	@SuppressWarnings("deprecation")
	@Override
	public @NotNull InteractionResult use(BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult hit) {
		if (state.getValue(AGE) != MAX_AGE && player.getItemInHand(hand).is(Items.BONE_MEAL)) {
			return InteractionResult.PASS;
		}
		if (state.getValue(HALF) == DoubleBlockHalf.UPPER) {
			state = level.getBlockState(pos.below());
			pos = pos.below();
		}
		if (state.getValue(AGE) == MAX_AGE) {
			if (state.getBlock() instanceof PomegranateBushBlock && !player.getItemInHand(hand).is(Tags.Items.SHEARS)) {
				player.hurt(player.damageSources().sweetBerryBush(), 1F);
			}
			this.dropFruit(level, pos);
			level.playSound(null, pos, this.getPickSound(), SoundSource.BLOCKS, 1F, 0.8F + level.getRandom().nextFloat() * 0.4F);
			BlockState picked = state.setValue(AGE, MAX_AGE - 2);
			level.setBlock(pos, picked, 2); // Revert to pre-flowering
			level.setBlock(pos.above(), picked.setValue(HALF, DoubleBlockHalf.UPPER), 2); // Revert upper to pre-flowering
			level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(player, picked));
			return InteractionResult.sidedSuccess(level.isClientSide());
		} else if (player.getItemInHand(hand).getItem() instanceof AxeItem && !state.hasProperty(STUNTED)) {
			BlockState stunted = state.setValue(STUNTED, true);
			level.playSound(player, pos, SoundEvents.AXE_STRIP, SoundSource.BLOCKS, 1F, 1F);
			level.setBlockAndUpdate(pos, stunted);
			level.setBlockAndUpdate(pos.above(), stunted.setValue(HALF, DoubleBlockHalf.UPPER));
			level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(player, stunted));
			player.getItemInHand(hand).hurtAndBreak(1, player, (b) -> b.broadcastBreakEvent(b.getUsedItemHand()));
			return InteractionResult.sidedSuccess(level.isClientSide());
		}
		return InteractionResult.PASS;
	}

	public int getMaxBonus() {
		return 1;
	}

	public void dropFruit(Level level, BlockPos pos) {
		if (!level.isClientSide()) {
			ItemStack stack =
				this.isSpecial(level, pos) ?
				new ItemStack(this.getSpecialFruit().get()) :
				new ItemStack(this.getFruit(), level.getRandom().nextIntBetweenInclusive(1, 1 + this.getMaxBonus()));
			popResource(level, pos, stack);
		}
	}

	public SoundEvent getPickSound() {
		return SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES;
	}
}
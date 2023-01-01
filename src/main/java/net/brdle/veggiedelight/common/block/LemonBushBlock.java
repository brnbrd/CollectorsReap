package net.brdle.veggiedelight.common.block;

import net.brdle.veggiedelight.common.item.VDItems;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.ForgeHooks;
import org.jetbrains.annotations.NotNull;

public class LemonBushBlock extends CropBlock {
	public static final int MAX_AGE = 4;
	public static final IntegerProperty AGE = BlockStateProperties.AGE_4;
	private static final VoxelShape SAPLING_SHAPE = Block.box(3.0D, 0.0D, 3.0D, 13.0D, 8.0D, 13.0D);
	private static final VoxelShape MID_GROWTH_SHAPE = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D);

	public LemonBushBlock(Properties pProperties) {
		super(pProperties);
		this.registerDefaultState(this.stateDefinition.any().setValue(AGE, 0));
	}

	@Override
	public int getMaxAge() {
		return MAX_AGE;
	}

	@Override
	public @NotNull IntegerProperty getAgeProperty() {
		return AGE;
	}

	@Override
	protected @NotNull ItemLike getBaseSeedId() {
		return Items.WHEAT_SEEDS; // Lemon Seeds
	}

	@Override
	protected boolean mayPlaceOn(BlockState pState, @NotNull BlockGetter pLevel, @NotNull BlockPos pPos) {
		return pState.is(Blocks.FARMLAND);
	}

	@Override
	public ItemStack getCloneItemStack(BlockState state, HitResult target, BlockGetter level, BlockPos pos, Player player) {
		return new ItemStack(VDItems.LEMON.get());
	}

	@Override
	public @NotNull VoxelShape getShape(BlockState pState, @NotNull BlockGetter pLevel, @NotNull BlockPos pPos, @NotNull CollisionContext pContext) {
		if (pState.getValue(AGE) == 0) {
			return SAPLING_SHAPE;
		} else {
			return pState.getValue(AGE) < this.getMaxAge() ? MID_GROWTH_SHAPE : super.getShape(pState, pLevel, pPos, pContext);
		}
	}

	/**
	 * @return whether this block needs random ticking.
	 */
	@Override
	public boolean isRandomlyTicking(BlockState pState) {
		return pState.getValue(AGE) < MAX_AGE;
	}

	@Override
	public void randomTick(BlockState pState, @NotNull ServerLevel pLevel, @NotNull BlockPos pPos, @NotNull RandomSource pRandom) {
		int age = pState.getValue(AGE);
		if (age < (this.getMaxAge() - 1) && pLevel.getRawBrightness(pPos.above(), 0) >= 9 && ForgeHooks.onCropsGrowPre(pLevel, pPos, pState, pRandom.nextInt(5) == 0)) {
			BlockState blockstate = pState.setValue(AGE, age + 1);
			pLevel.setBlock(pPos, blockstate, 2);
			pLevel.gameEvent(GameEvent.BLOCK_CHANGE, pPos, GameEvent.Context.of(blockstate));
			ForgeHooks.onCropsGrowPost(pLevel, pPos, pState);
		}

	}

	@SuppressWarnings("deprecation")
	@Override
	public @NotNull InteractionResult use(BlockState pState, @NotNull Level pLevel, @NotNull BlockPos pPos, @NotNull Player pPlayer, @NotNull InteractionHand pHand, @NotNull BlockHitResult pHit) {
		if (pState.getValue(AGE) == this.getMaxAge()) {
			popResource(pLevel, pPos, new ItemStack(VDItems.LEMON.get(), 2 + pLevel.getRandom().nextInt(2)));
			pLevel.playSound(null, pPos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 0.8F + pLevel.random.nextFloat() * 0.4F);
			BlockState blockstate = pState.setValue(AGE, 2); // Revert to pre-flowering
			pLevel.setBlock(pPos, blockstate, 2);
			pLevel.gameEvent(GameEvent.BLOCK_CHANGE, pPos, GameEvent.Context.of(pPlayer, blockstate));
			return InteractionResult.sidedSuccess(pLevel.isClientSide);
		} else if (pPlayer.getItemInHand(pHand).is(Items.BONE_MEAL)) {
			return InteractionResult.PASS;
		} else {
			return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);
		}
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		pBuilder.add(AGE);
	}

	/**
	 * @return whether bonemeal can be used on this block
	 */
	@Override
	public boolean isValidBonemealTarget(@NotNull BlockGetter pLevel, @NotNull BlockPos pPos, BlockState pState, boolean pIsClient) {
		return pState.getValue(AGE) < (this.getMaxAge() - 1);
	}

	@Override
	public boolean isBonemealSuccess(@NotNull Level pLevel, @NotNull RandomSource pRandom, @NotNull BlockPos pPos, @NotNull BlockState pState) {
		return true;
	}

	@Override
	protected int getBonemealAgeIncrease(@NotNull Level pLevel) {
		return 1;
	}

	@Override
	public void performBonemeal(ServerLevel pLevel, @NotNull RandomSource pRandom, @NotNull BlockPos pPos, BlockState pState) {
		pLevel.setBlock(pPos, pState.setValue(AGE, Math.min(this.getMaxAge() - 1, pState.getValue(AGE) + 1)), 2);
	}

	@Override
	public void entityInside(@NotNull BlockState pState, @NotNull Level pLevel, @NotNull BlockPos pPos, @NotNull Entity pEntity) {
	}
}

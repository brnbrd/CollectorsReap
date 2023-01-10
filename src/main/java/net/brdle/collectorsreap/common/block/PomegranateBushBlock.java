package net.brdle.collectorsreap.common.block;

import net.brdle.collectorsreap.common.item.CRItems;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

public class PomegranateBushBlock extends BushBlock implements BonemealableBlock {
	public static final int MAX_AGE = 4;
	public static final IntegerProperty AGE = BlockStateProperties.AGE_4;
	private static final VoxelShape SAPLING_SHAPE = Block.box(3.0D, 0.0D, 3.0D, 13.0D, 8.0D, 13.0D);
	private static final VoxelShape MID_GROWTH_SHAPE = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D);

	public PomegranateBushBlock(Properties pProperties) {
		super(pProperties);
		this.registerDefaultState(this.stateDefinition.any().setValue(AGE, 0));
	}

	@Override
	public ItemStack getCloneItemStack(BlockState state, HitResult target, BlockGetter level, BlockPos pos, Player player) {
		return new ItemStack(CRItems.POMEGRANATE.get());
	}

	@SuppressWarnings("deprecation")
	@Override
	public @NotNull VoxelShape getShape(BlockState pState, @NotNull BlockGetter pLevel, @NotNull BlockPos pPos, @NotNull CollisionContext pContext) {
		if (pState.getValue(AGE) == 0) {
			return SAPLING_SHAPE;
		} else {
			return pState.getValue(AGE) < 3 ? MID_GROWTH_SHAPE : super.getShape(pState, pLevel, pPos, pContext);
		}
	}

	/**
	 * @return whether this block needs random ticking.
	 */
	@Override
	public boolean isRandomlyTicking(BlockState pState) {
		return pState.getValue(AGE) < 3;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void randomTick(BlockState pState, @NotNull ServerLevel pLevel, @NotNull BlockPos pPos, @NotNull RandomSource pRandom) {
		int i = pState.getValue(AGE);
		if (i < 3 && pLevel.getRawBrightness(pPos.above(), 0) >= 9 && net.minecraftforge.common.ForgeHooks.onCropsGrowPre(pLevel, pPos, pState, pRandom.nextInt(5) == 0)) {
			BlockState blockstate = pState.setValue(AGE, i + 1);
			pLevel.setBlock(pPos, blockstate, 2);
			pLevel.gameEvent(GameEvent.BLOCK_CHANGE, pPos, GameEvent.Context.of(blockstate));
			net.minecraftforge.common.ForgeHooks.onCropsGrowPost(pLevel, pPos, pState);
		}

	}

	@SuppressWarnings("deprecation")
	@Override
	public @NotNull InteractionResult use(BlockState pState, @NotNull Level pLevel, @NotNull BlockPos pPos, @NotNull Player pPlayer, @NotNull InteractionHand pHand, @NotNull BlockHitResult pHit) {
		int i = pState.getValue(AGE);
		boolean flag = i == 3;
		if (!flag && pPlayer.getItemInHand(pHand).is(Items.BONE_MEAL)) {
			return InteractionResult.PASS;
		} else if (i > 1) {
			int j = 1 + pLevel.random.nextInt(2);
			popResource(pLevel, pPos, new ItemStack(Items.SWEET_BERRIES, j + (flag ? 1 : 0)));
			pLevel.playSound(null, pPos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 0.8F + pLevel.random.nextFloat() * 0.4F);
			BlockState blockstate = pState.setValue(AGE, 1);
			pLevel.setBlock(pPos, blockstate, 2);
			pLevel.gameEvent(GameEvent.BLOCK_CHANGE, pPos, GameEvent.Context.of(pPlayer, blockstate));
			return InteractionResult.sidedSuccess(pLevel.isClientSide);
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
		return pState.getValue(AGE) < 3;
	}

	@Override
	public boolean isBonemealSuccess(@NotNull Level pLevel, @NotNull RandomSource pRandom, @NotNull BlockPos pPos, @NotNull BlockState pState) {
		return true;
	}

	@Override
	public void performBonemeal(ServerLevel pLevel, @NotNull RandomSource pRandom, @NotNull BlockPos pPos, BlockState pState) {
		int i = Math.min(3, pState.getValue(AGE) + 1);
		pLevel.setBlock(pPos, pState.setValue(AGE, i), 2);
	}
}

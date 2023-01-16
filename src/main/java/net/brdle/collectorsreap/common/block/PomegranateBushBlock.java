package net.brdle.collectorsreap.common.block;

import net.brdle.collectorsreap.common.item.CRItems;
import net.brdle.collectorsreap.data.CRBlockTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.animal.Bee;
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
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.Tags;
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
		return new ItemStack(state.getValue(AGE) < 3 ? CRItems.POMEGRANATE_SEEDS.get() : CRItems.POMEGRANATE.get());
	}

	@SuppressWarnings("deprecation")
	@Override
	public @NotNull VoxelShape getShape(BlockState pState, @NotNull BlockGetter pLevel, @NotNull BlockPos pPos, @NotNull CollisionContext pContext) {
		if (pState.getValue(AGE) == 0) {
			return SAPLING_SHAPE;
		} else {
			return pState.getValue(AGE) < 2 ? MID_GROWTH_SHAPE :
				super.getShape(pState, pLevel, pPos, pContext);
		}
	}

	/**
	 * @return whether this block needs random ticking.
	 */
	@Override
	public boolean isRandomlyTicking(BlockState pState) {
		return pState.getValue(AGE) < MAX_AGE;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void randomTick(BlockState pState, @NotNull ServerLevel pLevel, @NotNull BlockPos pPos, @NotNull RandomSource pRandom) {
		int i = pState.getValue(AGE);
		if (i < MAX_AGE && pLevel.getRawBrightness(pPos.above(), 0) >= 9 &&
			ForgeHooks.onCropsGrowPre(pLevel, pPos, pState, pRandom.nextInt(5) == 0)) {
			BlockState blockstate = pState.setValue(AGE, i + 1);
			pLevel.setBlock(pPos, blockstate, 2);
			pLevel.gameEvent(GameEvent.BLOCK_CHANGE, pPos, GameEvent.Context.of(blockstate));
			ForgeHooks.onCropsGrowPost(pLevel, pPos, pState);
		}
	}

	@Override
	protected boolean mayPlaceOn(@NotNull BlockState pState, @NotNull BlockGetter pLevel, @NotNull BlockPos pPos) {
		return pState.is(BlockTags.DIRT) || pState.is(CRBlockTags.POMEGRANATE_FAST_ON);
	}

	@SuppressWarnings("deprecation")
	@Override
	public @NotNull InteractionResult use(BlockState pState, @NotNull Level pLevel, @NotNull BlockPos pPos, @NotNull Player pPlayer, @NotNull InteractionHand pHand, @NotNull BlockHitResult pHit) {
		if (pState.getValue(AGE) == MAX_AGE) {
			if (!pPlayer.getItemInHand(pHand).is(Tags.Items.SHEARS)) {
				pPlayer.hurt(DamageSource.SWEET_BERRY_BUSH, 1.0F);
			}
			popResource(pLevel, pPos, new ItemStack(CRItems.POMEGRANATE.get(), 1 + pLevel.random.nextInt(2)));
			pLevel.playSound(null, pPos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 0.8F + pLevel.random.nextFloat() * 0.4F);
			BlockState blockstate = pState.setValue(AGE, 2);
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
		return false;
	}

	@Override
	public boolean isBonemealSuccess(@NotNull Level pLevel, @NotNull RandomSource pRandom, @NotNull BlockPos pPos, @NotNull BlockState pState) {
		return false;
	}

	@Override
	public void performBonemeal(ServerLevel pLevel, @NotNull RandomSource pRandom, @NotNull BlockPos pPos, BlockState pState) {
		pLevel.setBlock(pPos, pState.setValue(AGE, Math.min(MAX_AGE, pState.getValue(AGE) + 1)), 2);
	}

	@Override
	public void entityInside(@NotNull BlockState pState, @NotNull Level pLevel, @NotNull BlockPos pPos, @NotNull Entity e) {
		if (!pLevel.isClientSide() &&
			e instanceof Bee &&
			pState.getValue(AGE) == MAX_AGE - 1 &&
			pLevel.getRandom().nextInt(150) == 0) {
			this.performBonemeal((ServerLevel) pLevel, pLevel.getRandom(), pPos, pState);
		}
	}

	@Override
	public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
		return 60;
	}

	@Override
	public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
		return 30;
	}
}

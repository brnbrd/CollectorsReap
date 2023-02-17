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
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Bee;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.EntityCollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.Tags;
import org.jetbrains.annotations.NotNull;
import javax.annotation.Nullable;

public class PomegranateBushBlock extends CropBlock implements IFruiting {
	public static final int MAX_AGE = 2;
	public static final IntegerProperty AGE = BlockStateProperties.AGE_2;
	public static final EnumProperty<DoubleBlockHalf> HALF = BlockStateProperties.DOUBLE_BLOCK_HALF;
	private static final VoxelShape SHAPE_LOWER = Block.box(5.0D, 0.0D, 5.0D, 11.0D, 16.0D, 11.0D);
	private static final VoxelShape SHAPE_UPPER = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);

	public PomegranateBushBlock(Properties pProperties) {
		super(pProperties);
		this.registerDefaultState(this.stateDefinition.any()
			.setValue(AGE, 0)
			.setValue(HALF, DoubleBlockHalf.LOWER)
		);
	}

	@Override
	public @NotNull IntegerProperty getAgeProperty() {
		return AGE;
	}

	@Override
	public int getMaxAge() {
		return MAX_AGE;
	}

	@SuppressWarnings("deprecation")
	@Override
	public @NotNull VoxelShape getCollisionShape(@NotNull BlockState pState, @NotNull BlockGetter pLevel, @NotNull BlockPos pPos, @NotNull CollisionContext pContext) {
		if (pContext instanceof EntityCollisionContext ent && ent.getEntity() instanceof Bee) {
			return pState.getValue(HALF) == DoubleBlockHalf.LOWER ?
				Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D) : Shapes.empty();
		}
		return getShape(pState, pLevel, pPos, pContext);
	}

	@Override
	public @NotNull VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter pLevel, @NotNull BlockPos pPos, @NotNull CollisionContext pContext) {
		return state.getValue(HALF) == DoubleBlockHalf.UPPER ? SHAPE_UPPER : SHAPE_LOWER;
	}

	/**
	 * Update the provided state given the provided neighbor direction and neighbor state, returning a new state.
	 * For example, fences make their connections to the passed in state if possible, and wet concrete powder immediately
	 * returns its solidified counterpart.
	 * Note that this method should ideally consider only the specific direction passed in.
	 */
	@Override
	public @NotNull BlockState updateShape(BlockState state, Direction facing, @NotNull BlockState facingState, @NotNull LevelAccessor world, @NotNull BlockPos pos, @NotNull BlockPos facingPos) {
		DoubleBlockHalf doubleblockhalf = state.getValue(HALF);
		if (facing.getAxis() == Direction.Axis.Y && doubleblockhalf == DoubleBlockHalf.LOWER == (facing == Direction.UP)) {
			return facingState.is(this) && facingState.getValue(HALF) != doubleblockhalf ? state.setValue(AGE, facingState.getValue(AGE)) : Blocks.AIR.defaultBlockState();
		} else {
			return doubleblockhalf == DoubleBlockHalf.LOWER && facing == Direction.DOWN && !state.canSurvive(world, pos) ? Blocks.AIR.defaultBlockState() : super.updateShape(state, facing, facingState, world, pos, facingPos);
		}
	}

	@Override
	protected boolean mayPlaceOn(@NotNull BlockState pState, @NotNull BlockGetter pLevel, @NotNull BlockPos pPos) {
		return pState.is(BlockTags.DIRT) || pState.is(CRBlockTags.POMEGRANATE_FAST_ON);
	}

	@Override
	public boolean canSurvive(BlockState state, @NotNull LevelReader level, BlockPos pos) {
		BlockPos blockpos = pos.below();
		return state.getValue(HALF) == DoubleBlockHalf.LOWER ? this.mayPlaceOn(level.getBlockState(blockpos), level, blockpos) : state.is(this);
	}

	@Override
	protected @NotNull ItemLike getBaseSeedId() {
		return CRItems.POMEGRANATE_SEEDS.get();
	}

	@Override
	public ItemStack getCloneItemStack(BlockState state, HitResult target, BlockGetter level, BlockPos pos, Player player) {
		return new ItemStack(state.getValue(AGE) == this.getMaxAge() ? CRItems.POMEGRANATE.get() : this.getBaseSeedId());
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		pBuilder.add(AGE, HALF);
	}

	/**
	 * @return whether this block needs random ticking.
	 */
	@Override
	public boolean isRandomlyTicking(BlockState pState) {
		return pState.getValue(AGE) < this.getMaxAge();
	}

	// Can only grow to flowering if not in nether. Can receive boost from block below.
	@Override
	public void randomTick(@NotNull BlockState state, @NotNull ServerLevel pLevel, @NotNull BlockPos pPos, @NotNull RandomSource pRandom) {
		if (state.getValue(AGE) < this.getMaxAge() && state.getValue(HALF) == DoubleBlockHalf.LOWER) {
			int growthRate = (pLevel.getBlockState(pPos.below()).is(CRBlockTags.POMEGRANATE_FAST_ON)) ? 9 : 13;
			if (pLevel.dimension() == Level.NETHER) {
				growthRate -= 4;
			} else if (state.getValue(AGE) != 0) {
				return;
			}
			if (ForgeHooks.onCropsGrowPre(pLevel, pPos, state, pRandom.nextInt(growthRate) == 0)) {
				this.performBonemeal(pLevel, pRandom, pPos, state);
				ForgeHooks.onCropsGrowPost(pLevel, pPos, state);
			}
		}
	}

	@Override
	public Item getFruit() {
		return CRItems.POMEGRANATE.get();
	}

	@Override
	public int getNumFruit(Level level) {
		return 1 + level.getRandom().nextInt(2);
	}

	@SuppressWarnings("deprecation")
	@Override
	public @NotNull InteractionResult use(BlockState pState, @NotNull Level pLevel, @NotNull BlockPos pPos, @NotNull Player pPlayer, @NotNull InteractionHand pHand, @NotNull BlockHitResult pHit) {
		if (pState.getValue(AGE) == this.getMaxAge()) {
			if (!pPlayer.getItemInHand(pHand).is(Tags.Items.SHEARS)) {
				pPlayer.hurt(DamageSource.SWEET_BERRY_BUSH, 1.0F);
			}
			dropResources(pLevel, pPos);
			pLevel.playSound(null, pPos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 0.8F + pLevel.getRandom().nextFloat() * 0.4F);
			pLevel.setBlockAndUpdate(pPos,  pState.setValue(AGE, 0));  // Revert to pre-flowering
			return InteractionResult.sidedSuccess(pLevel.isClientSide());
		} else {
			return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);
		}
	}

	/**
	 * @return whether bonemeal can be used on this block
	 */
	@Override
	public boolean isValidBonemealTarget(@NotNull BlockGetter pLevel, @NotNull BlockPos pPos, @NotNull BlockState pState, boolean pIsClient) {
		return false;
	}

	@Override
	public boolean isBonemealSuccess(@NotNull Level pLevel, @NotNull RandomSource pRandom, @NotNull BlockPos pPos, @NotNull BlockState pState) {
		return false;
	}

	@Override
	public void performBonemeal(ServerLevel pLevel, @NotNull RandomSource pRandom, @NotNull BlockPos pPos, BlockState pState) {
		pLevel.setBlockAndUpdate(pPos, pState.setValue(AGE, Math.min(this.getMaxAge(), pState.getValue(AGE) + 1)));
	}

	@Override
	@Nullable
	public BlockState getStateForPlacement(BlockPlaceContext pContext) {
		BlockPos blockpos = pContext.getClickedPos();
		return blockpos.getY() < 255 && pContext.getLevel().getBlockState(blockpos.above()).canBeReplaced(pContext) ?
			this.defaultBlockState().setValue(AGE, 0).setValue(HALF, DoubleBlockHalf.LOWER) :
			null;
	}

	/**
	 * Called by BlockItem after this block has been placed.
	 */
	@Override
	public void setPlacedBy(Level pLevel, BlockPos pPos, BlockState pState, LivingEntity pPlacer, @NotNull ItemStack pStack) {
		pLevel.setBlock(pPos.above(), pState.setValue(HALF, DoubleBlockHalf.UPPER), 3);
	}

	public static void placeAt(LevelAccessor pLevel, BlockState pState, BlockPos pPos, int pFlags) {
		pLevel.setBlock(pPos, pState.setValue(AGE, MAX_AGE).setValue(HALF, DoubleBlockHalf.LOWER), pFlags);
		pLevel.setBlock(pPos.above(), pState.setValue(AGE, MAX_AGE).setValue(HALF, DoubleBlockHalf.UPPER), pFlags);
	}

	@Override
	public void playerWillDestroy(Level pLevel, @NotNull BlockPos pPos, @NotNull BlockState pState, @NotNull Player pPlayer) {
		if (!pLevel.isClientSide()) {
			if (pPlayer.isCreative()) {
				preventCreativeDropFromBottomPart(HALF, pLevel, pPos, pState, pPlayer);
			} else if (pState.getValue(AGE) == this.getMaxAge()) {
				if (!pPlayer.getMainHandItem().is(Tags.Items.SHEARS)) {
					pPlayer.hurt(DamageSource.SWEET_BERRY_BUSH, 1.0F);
				}
				dropResources(pLevel, pPos);
			}
		}
		super.playerWillDestroy(pLevel, pPos, pState, pPlayer);
	}

	@Override
	public void entityInside(@NotNull BlockState pState, @NotNull Level pLevel, @NotNull BlockPos pPos, @NotNull Entity e) {
		if (!pLevel.isClientSide() &&
			e instanceof Bee &&
			pState.getValue(AGE) == this.getMaxAge() - 1 &&
			pLevel.getRandom().nextInt(150) == 0) {
			this.performBonemeal((ServerLevel) pLevel, pLevel.getRandom(), pPos, pState);
		}
	}
}

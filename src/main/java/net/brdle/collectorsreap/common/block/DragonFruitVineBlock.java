package net.brdle.collectorsreap.common.block;

import net.brdle.collectorsreap.common.event.CRSoundEvents;
import net.brdle.collectorsreap.common.item.CRItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.registries.ForgeRegistries;
import vectorwing.farmersdelight.common.Configuration;
import vectorwing.farmersdelight.common.registry.ModBlocks;
import vectorwing.farmersdelight.common.tag.ModTags;
import javax.annotation.Nullable;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("deprecation")
public class DragonFruitVineBlock extends CropBlock {
	public static final IntegerProperty VINE_AGE = BlockStateProperties.AGE_3;
	public static final BooleanProperty ROPELOGGED = BooleanProperty.create("ropelogged");
	private static final VoxelShape SHAPE = Block.box(2D, 0D, 2D, 14D, 16D, 14D);

	public DragonFruitVineBlock(Properties properties) {
		super(properties);
		registerDefaultState(stateDefinition.any()
			.setValue(this.getAgeProperty(), 0)
			.setValue(ROPELOGGED, false)
		);
	}

	@Override
	public @NotNull InteractionResult use(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult hit) {
		boolean isMature = this.isMaxAge(state);
		if (!isMature && player.getItemInHand(hand).is(Items.BONE_MEAL)) {
			return InteractionResult.PASS;
		} else if (isMature) {
			RandomSource random = level.getRandom();
			Block.popResource(level, pos, new ItemStack(CRItems.PINK_DRAGON_FRUIT.get(), 1 + random.nextInt(2)));
			level.playSound(null, pos, CRSoundEvents.PICK_DRAGON_FRUITS.get(), SoundSource.BLOCKS, 1F, 0.8F + random.nextFloat() * 0.4F);
			level.setBlock(pos, state.setValue(this.getAgeProperty(), 0), 2);
			return InteractionResult.SUCCESS;
		} else {
			return super.use(state, level, pos, player, hand, hit);
		}
	}

	@Override
	public boolean isRandomlyTicking(@NotNull BlockState state) {
		return true;
	}

	@Override
	public void randomTick(@NotNull BlockState state, ServerLevel level, @NotNull BlockPos pos, @NotNull RandomSource random) {
		if (!level.isAreaLoaded(pos, 1)) return;
		if (level.getRawBrightness(pos, 0) >= 9) {
			int age = this.getAge(state);
			if (age < this.getMaxAge()) {
				float speed = getGrowthSpeed(this, level, pos);
				if (ForgeHooks.onCropsGrowPre(level, pos, state, random.nextInt((int) (25F / speed) + 1) == 0)) {
					level.setBlock(pos, state.setValue(this.getAgeProperty(), age + 1), 2);
					ForgeHooks.onCropsGrowPost(level, pos, state);
				}
			}
			attemptRopeClimb(level, pos, random);
		}
	}

	public void attemptRopeClimb(@NotNull ServerLevel level, @NotNull BlockPos pos, RandomSource random) {
		if (random.nextFloat() < 0.3F) {
			BlockPos posAbove = pos.above();
			if (level.getBlockState(posAbove).is(ModTags.ROPES)) {
				int vineHeight;
				for (vineHeight = 1; level.getBlockState(pos.below(vineHeight)).is(this); ++vineHeight);
				if (vineHeight < 3) {
					level.setBlockAndUpdate(posAbove, defaultBlockState().setValue(ROPELOGGED, true));
				}
			}
		}

	}

	@Override
	public @NotNull BlockState getStateForAge(int age) {
		return this.defaultBlockState().setValue(this.getAgeProperty(), age);
	}

	@Override
	public @NotNull IntegerProperty getAgeProperty() {
		return VINE_AGE;
	}

	@Override
	public @NotNull VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context) {
		return SHAPE;
	}

	@Override
	public int getMaxAge() {
		return 3;
	}

	@Override
	protected @NotNull ItemLike getBaseSeedId() {
		return CRItems.DRAGON_FRUIT_SEEDS.get();
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(VINE_AGE, ROPELOGGED);
	}

	@Override
	protected int getBonemealAgeIncrease(@NotNull Level level) {
		return super.getBonemealAgeIncrease(level) / 2;
	}

	@Override
	public void performBonemeal(@NotNull ServerLevel level, @NotNull RandomSource random, @NotNull BlockPos pos, @NotNull BlockState state) {
		level.setBlockAndUpdate(pos, state.setValue(
			this.getAgeProperty(),
			Math.min(this.getMaxAge(), this.getAge(state) + this.getBonemealAgeIncrease(level))
		));
		attemptRopeClimb(level, pos, random);
	}

	@Override
	public boolean isLadder(BlockState state, @NotNull LevelReader level, @NotNull BlockPos pos, @NotNull LivingEntity entity) {
		return state.getValue(ROPELOGGED) && state.is(BlockTags.CLIMBABLE);
	}

	@Override
	public boolean canSurvive(BlockState state, @NotNull LevelReader level, @NotNull BlockPos pos) {
		return state.getValue(ROPELOGGED) ? (
			level.getBlockState(pos.below()).is(CRBlocks.PINK_DRAGON_FRUIT_CROP.get()) &&
			(level.getRawBrightness(pos, 0) >= 8 || level.canSeeSky(pos))
		) : super.canSurvive(state, level, pos);
	}

	@Override
	public void playerDestroy(@NotNull Level level, @NotNull Player player, @NotNull BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, @NotNull ItemStack stack) {
		boolean isRopelogged = state.getValue(ROPELOGGED);
		super.playerDestroy(level, player, pos, state, blockEntity, stack);
		if (isRopelogged) {
			destroyAndPlaceRope(level, pos);
		}
	}

	@Override
	public @NotNull BlockState updateShape(BlockState state, @NotNull Direction facing, @NotNull BlockState facingState, @NotNull LevelAccessor level, @NotNull BlockPos currentPos, @NotNull BlockPos facingPos) {
		if (!state.canSurvive(level, currentPos)) {
			level.scheduleTick(currentPos, this, 1);
		}
		return state;
	}

	@Override
	public void tick(BlockState state, @NotNull ServerLevel level, @NotNull BlockPos pos, @NotNull RandomSource random) {
		if (!state.canSurvive(level, pos)) {
			level.destroyBlock(pos, true);
			if (state.getValue(ROPELOGGED)) {
				destroyAndPlaceRope(level, pos);
			}
		}
	}

	public static void destroyAndPlaceRope(Level level, @NotNull BlockPos pos) {
		Block configuredRopeBlock = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(Configuration.DEFAULT_TOMATO_VINE_ROPE.get()));
		Block finalRopeBlock = configuredRopeBlock != null ? configuredRopeBlock : ModBlocks.ROPE.get();
		level.setBlockAndUpdate(pos, finalRopeBlock.defaultBlockState());
	}
}
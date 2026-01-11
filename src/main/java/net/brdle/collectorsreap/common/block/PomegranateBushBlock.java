package net.brdle.collectorsreap.common.block;

import net.brdle.collectorsreap.common.config.CRConfig;
import net.brdle.collectorsreap.common.event.CRSoundEvents;
import net.brdle.collectorsreap.common.item.CRItems;
import net.brdle.collectorsreap.data.CRBlockTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.animal.Bee;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.EntityCollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.PlantType;
import java.util.Optional;
import org.jetbrains.annotations.NotNull;

public class PomegranateBushBlock extends FruitBushBlock {
	private static final VoxelShape SAPLING_SHAPE = Block.box(3D, 0D, 3D, 13D, 5D, 13D);
	private static final VoxelShape MID_GROWTH_SHAPE = Block.box(2D, 0D, 2D, 14D, 15D, 14D);
	private static final VoxelShape SHAPE_LOWER = Block.box(5D, 0D, 5D, 11D, 16D, 11D);
	private static final VoxelShape SHAPE_UPPER = Block.box(0D, 0D, 0D, 16D, 16D, 16D);

	public PomegranateBushBlock(Properties properties) {
		super(properties);
	}

	@Override
	protected boolean mayPlaceOn(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos) {
		return state.is(CRBlockTags.POMEGRANATE_FAST_ON) || state.is(CRBlockTags.CROPS_PLANTABLE_ON);
	}

	@Override
	public PlantType getPlantType(BlockGetter level, BlockPos pos) {
		return PlantType.NETHER;
	}

	@SuppressWarnings("deprecation")
	@Override
	public @NotNull VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter pLevel, @NotNull BlockPos pPos, @NotNull CollisionContext pContext) {
		return switch (state.getValue(AGE)) {
			case 0 -> SAPLING_SHAPE;
			case 1 -> MID_GROWTH_SHAPE;
			default -> state.hasProperty(HALF) && state.getValue(HALF) == DoubleBlockHalf.UPPER ?
				SHAPE_UPPER : SHAPE_LOWER;
		};
	}

	@Override
	public Item getSeeds() {
		return CRItems.POMEGRANATE_SEEDS.get();
	}

	@Override
	public Item getFruit() {
		return CRItems.POMEGRANATE.get();
	}

	@Override
	public Optional<Item> getSpecialFruit() {
		return Optional.of(CRItems.STYGIAN_POMEGRANATE.get());
	}

	@Override
	public int getSpecialChance() {
		return CRConfig.STYGIAN_POMEGRANATE_RARITY.get();
	}

	@Override
	public boolean isSpecial(Level level, BlockPos pos) {
		return super.isSpecial(level, pos) && level.getBlockState(pos.below()).is(CRBlockTags.STYGIAN_POMEGRANATE_GROWABLE_ON);
	}

	// Can receive boost from Nether or block below.
	@SuppressWarnings("deprecation")
	@Override
	public void randomTick(@NotNull BlockState state, @NotNull ServerLevel server, @NotNull BlockPos pos, @NotNull RandomSource random) {
		if (
			state.getValue(AGE) < MAX_AGE &&
			state.getValue(HALF) == DoubleBlockHalf.LOWER
		) {
			int growthRate = (server.getBlockState(pos.below()).is(CRBlockTags.POMEGRANATE_FAST_ON)) ? 8 : 12;
			if (server.dimension() == Level.NETHER) {
				growthRate -= 4;
			} else if (state.getValue(AGE) == MAX_AGE - 1 && CRConfig.POMEGRANATE_POLLINATION.get()) {
				return;
			}
			if (ForgeHooks.onCropsGrowPre(server, pos, state, random.nextInt(growthRate) == 0)) {
				this.performBonemeal(server, random, pos, state);
				ForgeHooks.onCropsGrowPost(server, pos, state);
			}
		}
	}

	@Override
	public boolean isValidBonemealTarget(@NotNull LevelReader level, @NotNull BlockPos pos, BlockState state, boolean isClient) {
		return state.getValue(AGE) < MAX_AGE;
	}

	@Override
	public boolean isBonemealSuccess(@NotNull Level pLevel, @NotNull RandomSource pRandom, @NotNull BlockPos pPos, @NotNull BlockState pState) {
		return false;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void entityInside(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Entity entity) {
		if (
			!level.isClientSide() &&
			level instanceof ServerLevel server &&
			CRConfig.POMEGRANATE_POLLINATION.get() &&
			CRConfig.FAST_POLLINATE.get() &&
			entity instanceof Bee &&
			state.getValue(AGE) == MAX_AGE - 1 &&
			level.getRandom().nextInt(150) == 0
		) {
			this.performBonemeal(server, level.getRandom(), pos, state);
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public @NotNull VoxelShape getCollisionShape(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context) {
		if (context instanceof EntityCollisionContext ent && ent.getEntity() instanceof Bee && CRConfig.POMEGRANATE_POLLINATION.get()) {
			return state.getValue(HALF) == DoubleBlockHalf.LOWER ?
				Block.box(0D, 0D, 0D, 16D, 8D, 16D) : Shapes.empty();
		}
		return getShape(state, level, pos, context);
	}

	@Override
	public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
		return 0;
	}

	@Override
	public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
		return 0;
	}

	@Override
	public SoundEvent getPickSound() {
		return CRSoundEvents.PICK_POMEGRANATE.get();
	}
}
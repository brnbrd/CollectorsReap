package net.brdle.collectorsreap.common.block;

import net.brdle.collectorsreap.common.config.CRConfig;
import net.brdle.collectorsreap.common.event.CRSoundEvents;
import net.brdle.collectorsreap.common.item.CRItems;
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
import org.jetbrains.annotations.NotNull;

public class LimeBushBlock extends FruitBushBlock {
	public static final VoxelShape SMALL_SHAPE = Block.box(4, 0, 4, 12, 11, 12);
	private static final VoxelShape MEDIUM_SHAPE = Shapes.or(
		Block.box(0D, 8D, 0D, 16D, 16D, 16D),
		Block.box(6D, 0D, 6D, 10D, 8D, 10D)
	);
	private static final VoxelShape SHAPE_LOWER = Shapes.or(
		Block.box(0D, 12D, 0D, 16D, 16D, 16D),
		Block.box(6D, 0D, 6D, 10D, 12D, 10D));
	private static final VoxelShape SHAPE_UPPER = Block.box(0D, 0D, 0D, 16D, 8D, 16D);

	public LimeBushBlock(Properties properties) {
		super(properties);
	}

	@SuppressWarnings("deprecation")
	@Override
	public @NotNull VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter pLevel, @NotNull BlockPos pPos, @NotNull CollisionContext pContext) {
		return switch (state.getValue(AGE)) {
			case 0 -> SMALL_SHAPE;
			case 1 -> MEDIUM_SHAPE;
			default -> state.hasProperty(HALF) && state.getValue(HALF) == DoubleBlockHalf.UPPER ?
				SHAPE_UPPER : SHAPE_LOWER;
		};
	}

	@Override
	public Item getFruit() {
		return CRItems.LIME.get();
	}

	@Override
	public Item getSeeds() {
		return CRItems.LIME_SEEDS.get();
	}

	@SuppressWarnings("deprecation")
	@Override
	public void randomTick(BlockState state, @NotNull ServerLevel level, @NotNull BlockPos pos, @NotNull RandomSource random) {
		int age = state.getValue(AGE);
		if (
			!(CRConfig.LIME_POLLINATION.get() && age == MAX_AGE - 1) && // Making sure we aren't a flowering state bush that needs pollination
			age < MAX_AGE &&
			state.getValue(HALF) == DoubleBlockHalf.LOWER && !state.getValue(STUNTED) &&
			level.getRawBrightness(pos.above().above(), 0) >= 9 &&
			ForgeHooks.onCropsGrowPre(level, pos, state, random.nextInt(9) == 0)
		) {
			this.performBonemeal(level, random, pos, state);
			ForgeHooks.onCropsGrowPost(level, pos, state);
		}
	}

	// Reaching the final stage requires pollination
	@Override
	public boolean isBonemealSuccess(@NotNull Level level, @NotNull RandomSource randomSource, @NotNull BlockPos blockPos, @NotNull BlockState blockState) {
		return (
			super.isBonemealSuccess(level, randomSource, blockPos, blockState) &&
			(!CRConfig.LIME_POLLINATION.get() || blockState.getValue(AGE) < (MAX_AGE - 1))
		);
	}

	@Override
	public boolean isValidBonemealTarget(@NotNull LevelReader level, @NotNull BlockPos pos, BlockState state, boolean isClient) {
		return state.getValue(AGE) < MAX_AGE;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void entityInside(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Entity e) {
		if (
			!level.isClientSide() &&
			level instanceof ServerLevel server &&
			CRConfig.LIME_POLLINATION.get() &&
			CRConfig.FAST_POLLINATE.get() &&
			e instanceof Bee &&
			state.getValue(AGE) == MAX_AGE - 1 &&
			server.getRandom().nextInt(150) == 0
		) {
			this.performBonemeal(server, server.getRandom(), pos, state);
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public @NotNull VoxelShape getCollisionShape(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context) {
		if (context instanceof EntityCollisionContext ent && ent.getEntity() instanceof Bee && CRConfig.LIME_POLLINATION.get()) {
			return (
				state.getValue(HALF) == DoubleBlockHalf.LOWER ?
				Block.box(0D, 0D, 0D, 16D, 8D, 16D) :
				Shapes.empty()
			);
		}
		return getShape(state, level, pos, context);
	}

	@Override
	public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
		return 60;
	}

	@Override
	public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
		return 30;
	}

	@Override
	public SoundEvent getPickSound() {
		return CRSoundEvents.PICK_LIME.get();
	}
}
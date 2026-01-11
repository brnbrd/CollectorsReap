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
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.EntityCollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
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

	@Override
	public boolean mayPlaceOn(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos) {
		return super.mayPlaceOn(state, level, pos) || state.is(CRBlockTags.LIME_SPAWNABLE_ON);
	}

	@SuppressWarnings("deprecation")
	@Override
	public @NotNull VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context) {
		return switch (state.getValue(this.getAgeProperty())) {
			case 0 -> SMALL_SHAPE;
			case 1 -> MEDIUM_SHAPE;
			default -> this.isLower(state) ? SHAPE_LOWER : SHAPE_UPPER;
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

	@Override
	public boolean isRandomlyTicking(@NotNull BlockState state) {
		return (
			!(CRConfig.LIME_POLLINATION.get() && state.getValue(this.getAgeProperty()) >= this.getMaxAge() - 1) &&
			super.isRandomlyTicking(state)
		);
	}

	@Override
	public void randomTick(@NotNull BlockState state, @NotNull ServerLevel level, @NotNull BlockPos pos, @NotNull RandomSource random) {
		if (level.getRawBrightness(pos.above().above(), 0) >= 9 && random.nextInt(9) == 0) {
			this.grow(level, state, pos, 1);
		}
	}

	// Reaching the final stage requires pollination
	@Override
	public boolean isBonemealSuccess(@NotNull Level level, @NotNull RandomSource randomSource, @NotNull BlockPos blockPos, @NotNull BlockState blockState) {
		return (
			super.isBonemealSuccess(level, randomSource, blockPos, blockState) &&
			(!CRConfig.LIME_POLLINATION.get() || blockState.getValue(this.getAgeProperty()) < this.getMaxAge() - 1)
		);
	}

	@Override
	public void entityInside(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Entity entity) {
		if (
			!level.isClientSide() &&
			level instanceof ServerLevel server &&
			CRConfig.LIME_POLLINATION.get() &&
			CRConfig.FAST_POLLINATE.get() &&
			entity instanceof Bee bee &&
			bee.hasNectar() &&
			state.getValue(this.getAgeProperty()) == this.getMaxAge() - 1
		) {
			this.grow(server, state, pos, 1);
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public @NotNull VoxelShape getCollisionShape(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context) {
		if (context instanceof EntityCollisionContext ent && ent.getEntity() instanceof Bee && CRConfig.LIME_POLLINATION.get()) {
			return (
				this.isLower(state) ?
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
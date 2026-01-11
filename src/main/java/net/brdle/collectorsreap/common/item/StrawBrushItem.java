package net.brdle.collectorsreap.common.item;

import net.brdle.collectorsreap.Util;
import net.brdle.collectorsreap.common.config.CRConfig;
import net.brdle.collectorsreap.common.event.CRSoundEvents;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Bee;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class StrawBrushItem extends Item implements IConfigured {
	private static final String POLLINATED = "Pollinated";

	public StrawBrushItem(Properties properties) {
		super(properties);
	}

	@Override
	public void appendHoverText(@NotNull ItemStack stack, @Nullable Level level, @NotNull List<Component> components, @NotNull TooltipFlag isAdvanced) {
		super.appendHoverText(stack, level, components, isAdvanced);
		if (this.enabledText(components)) {
			if (isPollinated(stack)) {
				components.add(Util.crTooltip(Util.name(stack) + ".pollinated").withStyle(ChatFormatting.YELLOW));
			}
		}
	}

	@Override
	public int getMaxDamage(ItemStack stack) {
		return CRConfig.STRAW_BRUSH_DURABILITY.get();
	}

	@Override
	public @NotNull InteractionResult useOn(@NotNull UseOnContext context) {
		final ItemStack stack = context.getItemInHand();
		if (stack.is(this)) {
			if (!isPollinated(stack)) {
				return InteractionResult.PASS;
			}
			final Level level = context.getLevel();
			final BlockPos pos = context.getClickedPos();
			final BlockState state = level.getBlockState(pos);
			if (
				state.is(BlockTags.BEE_GROWABLES) &&
				state.getBlock() instanceof BonemealableBlock plant &&
				plant.isValidBonemealTarget(level, pos, state, level.isClientSide())
			) {
				level.playSound(
					null,
					pos,
					CRSoundEvents.STRAW_BRUSH_POLLINATE.get(),
					SoundSource.PLAYERS,
					1.0F,
					1.0F
				);
				if (level instanceof ServerLevel server) {
					final Player player = context.getPlayer();
					setPollinated(stack, false);
					grow(server, pos, CRConfig.STRAW_BRUSH_BONE_MEALS.get());
					if (player != null) {
						stack.hurtAndBreak(
							1,
							player,
							p -> p.broadcastBreakEvent(context.getHand())
						);
						player.getInventory().setChanged();
					}
				}
				return InteractionResult.sidedSuccess(level.isClientSide());
			}
		}
		return super.useOn(context);
	}

	@Override
	public @NotNull InteractionResult interactLivingEntity(@NotNull ItemStack stack, @NotNull Player player, @NotNull LivingEntity entity, @NotNull InteractionHand hand) {
		final ItemStack held = player.getItemInHand(hand);
		if (held.is(this)) {
			final Level level = player.level();
			if (isPollinated(held) || !(entity instanceof Bee bee && bee.hasNectar())) {
				return InteractionResult.PASS;
			}
			level.playSound(
				null,
				bee.blockPosition(),
				CRSoundEvents.STRAW_BRUSH_COLLECT.get(),
				SoundSource.PLAYERS,
				1.0F,
				1.0F
			);
			if (!level.isClientSide()) {
				bee.setHasNectar(false);
				setPollinated(held, true);
				player.getInventory().setChanged();
			}
			return InteractionResult.sidedSuccess(level.isClientSide());
		}
		return super.interactLivingEntity(stack, player, entity, hand);
	}

	public static void setPollinated(@NotNull ItemStack stack, boolean pollinated) {
		stack.getOrCreateTag().putBoolean(POLLINATED, pollinated);
	}

	public static boolean isPollinated(@NotNull ItemStack stack) {
		final CompoundTag tag = stack.getOrCreateTag();
		return tag.contains(POLLINATED) && tag.getBoolean(POLLINATED);
	}

	public static ItemStack getPollinatedStack() {
		ItemStack brush = new ItemStack(CRItems.STRAW_BRUSH.get());
		setPollinated(brush, true);
		return brush;
	}

	public void grow(final ServerLevel server, final BlockPos pos, final int growths) {
		if (server.isLoaded(pos)) {
			final RandomSource random = server.getRandom();
			int actualGrowths;
			for (actualGrowths = 0; actualGrowths < growths; actualGrowths++) {
				BlockState state = server.getBlockState(pos);
				if (
					!(state.getBlock() instanceof BonemealableBlock plant) ||
						!plant.isValidBonemealTarget(server, pos, state, false)
				) {
					break;
				}
				plant.performBonemeal(server, random, pos, state);
			}
			if (actualGrowths > 0) {
				server.levelEvent(2005, pos, 0);
			}
		}
	}
}
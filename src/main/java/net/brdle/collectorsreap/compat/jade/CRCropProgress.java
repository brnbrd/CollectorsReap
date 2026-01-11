package net.brdle.collectorsreap.compat.jade;

import net.brdle.collectorsreap.Util;
import net.brdle.collectorsreap.common.block.TallBushCropBlock;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.BlockState;
import snownee.jade.api.BlockAccessor;
import snownee.jade.api.IBlockComponentProvider;
import snownee.jade.api.ITooltip;
import snownee.jade.api.config.IPluginConfig;

public enum CRCropProgress implements IBlockComponentProvider {
	INSTANCE;
	public static final ResourceLocation CROP_PROGRESS = Util.cr("crop_progress");

	private static void addMaturityTooltip(ITooltip tooltip, int age, int maxAge) {
		tooltip.add(Component.translatable("tooltip.jade.crop_growth",
			age == maxAge ?
			Component.translatable("tooltip.jade.crop_mature").withStyle(ChatFormatting.GREEN) :
			Component.literal(String.format("%.0f%%", (age / (float) maxAge) * 100F)).withStyle(ChatFormatting.WHITE)
		));
	}

	@Override
	public void appendTooltip(ITooltip tooltip, BlockAccessor blockAccessor, IPluginConfig iPluginConfig) {
		final BlockState state = blockAccessor.getBlockState();
		if (state.getBlock() instanceof TallBushCropBlock crop) {
			addMaturityTooltip(tooltip, state.getValue(crop.getAgeProperty()), crop.getMaxAge());
		}
	}

	@Override
	public ResourceLocation getUid() {
		return CROP_PROGRESS;
	}
}
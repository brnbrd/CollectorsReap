package net.brdle.collectorsreap.common.fluid;

import net.brdle.collectorsreap.Util;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraftforge.client.extensions.common.IClientFluidTypeExtensions;
import net.minecraftforge.common.SoundActions;
import net.minecraftforge.fluids.FluidType;
import java.util.function.Consumer;

public class CreamCheeseFluidType extends FluidType {
	public static final ResourceLocation CREAM_CHEESE_STILL_TEXTURE = Util.cr("block/cream_cheese_still");
	public static final ResourceLocation CREAM_CHEESE_FLOWING_TEXTURE = Util.cr("block/cream_cheese_flow");

	public CreamCheeseFluidType() {
		super(FluidType.Properties.create()
			.sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL)
			.sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY)
			.sound(SoundActions.FLUID_VAPORIZE, SoundEvents.FIRE_EXTINGUISH)
		);
	}

	@Override
	public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer) {
		consumer.accept(new IClientFluidTypeExtensions() {
			@Override
			public ResourceLocation getStillTexture() {
				return CREAM_CHEESE_STILL_TEXTURE;
			}

			@Override
			public ResourceLocation getFlowingTexture() {
				return CREAM_CHEESE_FLOWING_TEXTURE;
			}
		});
	}
}
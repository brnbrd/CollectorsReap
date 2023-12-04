package net.brdle.collectorsreap.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.brdle.collectorsreap.Util;
import net.brdle.collectorsreap.client.model.UrchinModel;
import net.brdle.collectorsreap.common.entity.Urchin;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

@OnlyIn(Dist.CLIENT)
public class UrchinRenderer extends MobRenderer<Urchin, UrchinModel> {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(Util.cr("urchin"), "main");
	private static final ResourceLocation TEXTURE = Util.cr("textures/entity/urchin/urchin.png");

	public UrchinRenderer(EntityRendererProvider.Context manager) {
		super(manager, new UrchinModel(manager.bakeLayer(LAYER_LOCATION)), 0.4F);
	}

	@Override
	public @NotNull ResourceLocation getTextureLocation(@NotNull Urchin pEntity) {
		return TEXTURE;
	}

	@Override
	protected void setupRotations(@NotNull Urchin entityLiving, @NotNull PoseStack stack, float pAgeInTicks, float pRotationYaw, float pPartialTicks) {
		super.setupRotations(entityLiving, stack, pAgeInTicks, pRotationYaw, pPartialTicks);
	}
}
package net.brdle.collectorsreap.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import net.brdle.collectorsreap.Util;
import net.brdle.collectorsreap.client.model.ChieftainCrabModel;
import net.brdle.collectorsreap.common.entity.ChieftainCrab;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

@OnlyIn(Dist.CLIENT)
public class ChieftainCrabRenderer extends VariantMobRenderer<ChieftainCrab, ChieftainCrabModel> {
	private static final String resource = "chieftain_crab";
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(Util.cr(resource), "main");
	private static final ResourceLocation[] TEXTURES = new ResourceLocation[ChieftainCrab.VARIANTS];

	public ChieftainCrabRenderer(EntityRendererProvider.Context manager) {
		super(manager, new ChieftainCrabModel(manager.bakeLayer(LAYER_LOCATION)), 0.8F);
	}

	@Override
	protected void setupRotations(@NotNull ChieftainCrab entityLiving, @NotNull PoseStack stack, float pAgeInTicks, float pRotationYaw, float pPartialTicks) {
		super.setupRotations(entityLiving, stack, pAgeInTicks, pRotationYaw, pPartialTicks);
		stack.mulPose(Vector3f.YP.rotationDegrees(90.0F));
	}

	@Override
	String getResource() {
		return resource;
	}

	@Override
	ResourceLocation[] getTextures() {
		return TEXTURES;
	}

	@Override
	int getVariant(ChieftainCrab entity) {
		return entity.getVariant();
	}
}
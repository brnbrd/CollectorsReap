package net.brdle.collectorsreap.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.brdle.collectorsreap.CollectorsReap;
import net.brdle.collectorsreap.Util;
import net.brdle.collectorsreap.client.model.ClamModel;
import net.brdle.collectorsreap.common.entity.Clam;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

@OnlyIn(Dist.CLIENT)
public class ClamRenderer extends MobRenderer<Clam, ClamModel> {
	private static final String resource = "clam";
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(Util.cr(resource), "main");
	private static final ResourceLocation[] TEXTURES = new ResourceLocation[Clam.VARIANTS];

	public ClamRenderer(EntityRendererProvider.Context manager) {
		super(manager, new ClamModel(manager.bakeLayer(LAYER_LOCATION)), 0.4F);
	}

	@Override
	public @NotNull ResourceLocation getTextureLocation(@NotNull Clam entity) {
		int variant = entity.getVariant();
		if (TEXTURES[variant] == null) {
			ResourceLocation loc = Util.rl(CollectorsReap.MODID, "textures/entity/clam/clam_" + variant + ".png");
			if (!Minecraft.getInstance().getResourceManager().getResource(loc).isPresent()) {
				loc = new ResourceLocation(CollectorsReap.MODID, "textures/entity/clam/clam_0.png");
			}
			return TEXTURES[variant] = loc;
		}
		return TEXTURES[variant];
	}

	@Override
	protected void setupRotations(@NotNull Clam entityLiving, @NotNull PoseStack stack, float pAgeInTicks, float pRotationYaw, float pPartialTicks) {
		super.setupRotations(entityLiving, stack, pAgeInTicks, pRotationYaw, pPartialTicks);
	}
}
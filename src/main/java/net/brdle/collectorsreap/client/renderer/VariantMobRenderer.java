package net.brdle.collectorsreap.client.renderer;

import net.brdle.collectorsreap.CollectorsReap;
import net.brdle.collectorsreap.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Mob;
import org.jetbrains.annotations.NotNull;

public abstract class VariantMobRenderer<T extends Mob, M extends EntityModel<T>> extends MobRenderer<T, M> {
	public VariantMobRenderer(EntityRendererProvider.Context pContext, M pModel, float pShadowRadius) {
		super(pContext, pModel, pShadowRadius);
	}

	abstract String getResource();

	abstract ResourceLocation[] getTextures();

	abstract int getVariant(T entity);

	private ResourceLocation res(int variant) {
		return Util.rl(CollectorsReap.MODID, "textures/entity/" + getResource() + "/" + getResource() + "_" + variant + ".png");
	}

	@Override
	public @NotNull ResourceLocation getTextureLocation(@NotNull T entity) {
		int variant = getVariant(entity);
		if (getTextures()[variant] == null) {
			ResourceLocation loc = res(variant);
			if (Minecraft.getInstance().getResourceManager().getResource(loc).isEmpty()) {
				loc = res(0);
			}
			return getTextures()[variant] = loc;
		}
		return getTextures()[variant];
	}
}

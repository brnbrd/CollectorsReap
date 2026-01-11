package net.brdle.collectorsreap.client;

import com.teamabnormals.blueprint.core.util.DataUtil;
import net.brdle.collectorsreap.Util;
import net.brdle.collectorsreap.client.model.*;
import net.brdle.collectorsreap.client.particle.AcidParticle;
import net.brdle.collectorsreap.client.particle.ShockwaveParticle;
import net.brdle.collectorsreap.client.particle.SurgeParticle;
import net.brdle.collectorsreap.client.renderer.*;
import net.brdle.collectorsreap.common.CRParticleTypes;
import net.brdle.collectorsreap.common.block.CRBlocks;
import net.brdle.collectorsreap.common.entity.CREntities;
import net.brdle.collectorsreap.common.item.CRItems;
import net.brdle.collectorsreap.common.item.StrawBrushItem;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.GrassColor;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.RegistryObject;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ClientEvents {
	private static final List<RegistryObject<Block>> FOLIAGE_COLOR_BLOCKS = Arrays.asList(CRBlocks.LUCUMA_LEAVES, CRBlocks.LUCUMA_LEAF_PILE);
	private static final List<RegistryObject<Block>> GRASS_COLOR_BLOCKS = Collections.emptyList();

	@SubscribeEvent
	public void setupClient(FMLClientSetupEvent e){
		e.enqueueWork(() -> {
			ItemProperties.register(
				CRItems.STRAW_BRUSH.get(),
				Util.cr("pollinated"),
				(stack, level, entity, seed) ->
					StrawBrushItem.isPollinated(stack) ? 1.0F : 0.0F
			);
		});
	}

	@SubscribeEvent
	public void registerBlockColors(RegisterColorHandlersEvent.Block e) {
		if (!FOLIAGE_COLOR_BLOCKS.isEmpty()) {
			DataUtil.registerBlockColor(e.getBlockColors(), (state, tint, pos, u) -> pos != null && tint != null ? BiomeColors.getAverageFoliageColor(tint, pos) : FoliageColor.getDefaultColor(), FOLIAGE_COLOR_BLOCKS);
		}
		if (!GRASS_COLOR_BLOCKS.isEmpty()) {
			DataUtil.registerBlockColor(e.getBlockColors(), (state, tint, pos, u) -> pos != null && tint != null ? BiomeColors.getAverageGrassColor(tint, pos) : GrassColor.getDefaultColor(), GRASS_COLOR_BLOCKS);
		}
	}

	@SubscribeEvent
	public void registerItemColors(RegisterColorHandlersEvent.Item event) {
		if (!FOLIAGE_COLOR_BLOCKS.isEmpty()) {
			DataUtil.registerBlockItemColor(event.getItemColors(), (stack, c) -> event.getBlockColors().getColor(((BlockItem) stack.getItem()).getBlock().defaultBlockState(), null, null, c), FOLIAGE_COLOR_BLOCKS);
		}
	}

	@SubscribeEvent
	public void registerLayerDefinition(EntityRenderersEvent.RegisterLayerDefinitions e) {
		e.registerLayerDefinition(TigerPrawnRenderer.LAYER_LOCATION, TigerPrawnModel::createBodyLayer);
		e.registerLayerDefinition(UrchinRenderer.LAYER_LOCATION, UrchinModel::createBodyLayer);
		e.registerLayerDefinition(PlatinumBassRenderer.LAYER_LOCATION, PlatinumBassModel::createBodyLayer);
		e.registerLayerDefinition(ChieftainCrabRenderer.LAYER_LOCATION, ChieftainCrabModel::createBodyLayer);
		e.registerLayerDefinition(ClamRenderer.LAYER_LOCATION, ClamModel::createBodyLayer);
	}


	@SubscribeEvent
	public void registerEntityRenders(EntityRenderersEvent.RegisterRenderers e) {
		e.registerEntityRenderer(CREntities.TIGER_PRAWN.get(), TigerPrawnRenderer::new);
		e.registerEntityRenderer(CREntities.URCHIN.get(), UrchinRenderer::new);
		e.registerEntityRenderer(CREntities.PLATINUM_BASS.get(), PlatinumBassRenderer::new);
		e.registerEntityRenderer(CREntities.CHIEFTAIN_CRAB.get(), ChieftainCrabRenderer::new);
		e.registerEntityRenderer(CREntities.CLAM.get(), ClamRenderer::new);
		e.registerEntityRenderer(CREntities.URCHIN_DART.get(), UrchinDartRenderer::new);
		e.registerEntityRenderer(CREntities.SHIMMERING_PEARL.get(), ThrownItemRenderer::new);
	}

	@SubscribeEvent
	public void registerParticles(RegisterParticleProvidersEvent e) {
		e.registerSpriteSet(CRParticleTypes.ACID.get(), AcidParticle.Provider::new);
		e.registerSpriteSet(CRParticleTypes.SHOCKWAVE.get(), ShockwaveParticle.Provider::new);
		e.registerSpriteSet(CRParticleTypes.SURGE.get(), SurgeParticle.Provider::new);
	}
}
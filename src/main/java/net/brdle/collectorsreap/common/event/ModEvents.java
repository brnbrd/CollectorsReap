package net.brdle.collectorsreap.common.event;

import net.brdle.collectorsreap.common.block.CRBlocks;
import net.brdle.collectorsreap.common.block.CRCauldronInteractions;
import net.brdle.collectorsreap.common.crafting.EnabledCondition;
import net.brdle.collectorsreap.common.item.CRItems;
import net.brdle.collectorsreap.compat.Modid;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;

public class ModEvents {
	@SubscribeEvent
	public void setup(final FMLCommonSetupEvent event) {
		event.enqueueWork(this::registerCompostables);
		event.enqueueWork(() -> {
			if (Modid.N.loaded()) {
				CRCauldronInteractions.registerCauldronInteractions();
			}
		});
	}

	private void registerCompostables() {
		// Portobello
		ComposterBlock.COMPOSTABLES.put(CRBlocks.PORTOBELLO.get().asItem(), 0.65F);
		ComposterBlock.COMPOSTABLES.put(CRItems.PORTOBELLO_COLONY.get(), 1F);
		ComposterBlock.COMPOSTABLES.put(CRItems.BAKED_PORTOBELLO_CAP.get(), 0.65F);
		ComposterBlock.COMPOSTABLES.put(CRItems.STUFFED_PORTOBELLO_CAP.get(), 1F);
		ComposterBlock.COMPOSTABLES.put(CRItems.PORTOBELLO_QUICHE.get(), 1F);
		ComposterBlock.COMPOSTABLES.put(CRItems.PORTOBELLO_QUICHE_SLICE.get(), 0.85F);

		// Lime
		ComposterBlock.COMPOSTABLES.put(CRItems.LIME.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(CRItems.LIME_SLICE.get(), 0.2F);
		ComposterBlock.COMPOSTABLES.put(CRItems.LIME_SEEDS.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(CRItems.LIME_COOKIE.get(), 0.85F);
		ComposterBlock.COMPOSTABLES.put(CRItems.POTATO_FRITTERS.get(), 0.65F);
		ComposterBlock.COMPOSTABLES.put(CRItems.LIME_PIE.get(), 1F);
		ComposterBlock.COMPOSTABLES.put(CRItems.LIME_PIE_SLICE.get(), 0.85F);
		ComposterBlock.COMPOSTABLES.put(CRItems.LIME_CAKE.get(), 1F);
		ComposterBlock.COMPOSTABLES.put(CRItems.LIME_CAKE_SLICE.get(), 0.65F);
		ComposterBlock.COMPOSTABLES.put(CRItems.PANETTONE.get(), 1F);
		ComposterBlock.COMPOSTABLES.put(CRItems.PANETTONE_SLICE.get(), 0.85F);

		// Pomegranate
		ComposterBlock.COMPOSTABLES.put(CRItems.POMEGRANATE.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(CRItems.POMEGRANATE_SLICE.get(), 0.2F);
		ComposterBlock.COMPOSTABLES.put(CRItems.POMEGRANATE_SEEDS.get(), 0.1F);
		ComposterBlock.COMPOSTABLES.put(CRItems.POMEGRANATE_CAKE.get(), 1F);
		ComposterBlock.COMPOSTABLES.put(CRItems.POMEGRANATE_CAKE_SLICE.get(), 0.65F);

		// Pink Dragon Fruit
		ComposterBlock.COMPOSTABLES.put(CRBlocks.DRAGON_BUSH.get().asItem(), 0.65F);
		ComposterBlock.COMPOSTABLES.put(CRItems.PINK_DRAGON_FRUIT.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(CRItems.DRAGON_FRUIT_SEEDS.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(CRItems.DRIED_PINK_DRAGON_FRUIT.get(), 0.5F);
		ComposterBlock.COMPOSTABLES.put(CRItems.PINK_DRAGON_FRUIT_CAKE.get(), 1F);
		ComposterBlock.COMPOSTABLES.put(CRItems.PINK_DRAGON_FRUIT_CAKE_SLICE.get(), 0.65F);

		// Lucuma
		ComposterBlock.COMPOSTABLES.put(CRItems.LUCUMA.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(CRItems.LUCUMA_BREAD.get(), 0.65F);
		ComposterBlock.COMPOSTABLES.put(CRItems.LUCUMA_CAKE.get(), 1F);
		ComposterBlock.COMPOSTABLES.put(CRItems.LUCUMA_CAKE_SLICE.get(), 0.65F);

		// Sniffer Plants
		ComposterBlock.COMPOSTABLES.put(CRBlocks.DAMSELFLOWER.get().asItem(), 0.85F);
		ComposterBlock.COMPOSTABLES.put(CRItems.DAMSELFLOWER_SEEDS.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(CRBlocks.MOONTEAR.get().asItem(), 0.85F);
		ComposterBlock.COMPOSTABLES.put(CRItems.MOONTEAR_SEEDS.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(CRBlocks.SKULL_LILY.get().asItem(), 0.85F);
		ComposterBlock.COMPOSTABLES.put(CRItems.SKULL_LILY_SEEDS.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(CRBlocks.BULBOUS_ROSE.get().asItem(), 0.85F);
		ComposterBlock.COMPOSTABLES.put(CRItems.BULBOUS_ROSE_SEEDS.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(CRBlocks.HEARTPETALS.get().asItem(), 0.85F);
		ComposterBlock.COMPOSTABLES.put(CRItems.HEARTPETALS_SEEDS.get(), 0.3F);
	}

	// Adds collectorsreap:enabled, etc. conditions
	@SubscribeEvent
	public void registerSerializers(RegisterEvent e) {
		if (e.getRegistryKey() == ForgeRegistries.RECIPE_SERIALIZERS.getRegistryKey()) {
			CraftingHelper.register(EnabledCondition.Serializer.INSTANCE);
		}
	}
}
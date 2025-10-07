package net.brdle.collectorsreap.common;

import net.brdle.collectorsreap.common.block.CRCauldronInteractions;
import net.brdle.collectorsreap.common.crafting.EnabledCondition;
import net.brdle.collectorsreap.common.item.CRItems;
import net.brdle.collectorsreap.compat.IConfigured;
import net.brdle.collectorsreap.compat.Modid;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.common.registry.ModCreativeTabs;

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
		ComposterBlock.COMPOSTABLES.put(CRItems.DRAGON_BUSH.get(), 0.65F);
		ComposterBlock.COMPOSTABLES.put(CRItems.PINK_DRAGON_FRUIT.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(CRItems.DRAGON_FRUIT_SEEDS.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(CRItems.PORTOBELLO.get(), 0.65F);
		ComposterBlock.COMPOSTABLES.put(CRItems.PORTOBELLO_COLONY.get(), 1F);
		ComposterBlock.COMPOSTABLES.put(CRItems.BAKED_PORTOBELLO_CAP.get(), 0.65F);
		ComposterBlock.COMPOSTABLES.put(CRItems.PORTOBELLO_QUICHE.get(), 1F);
		ComposterBlock.COMPOSTABLES.put(CRItems.PORTOBELLO_QUICHE_SLICE.get(), 0.85F);
		ComposterBlock.COMPOSTABLES.put(CRItems.PORTOBELLO_BURGER.get(), 0.85F);
		ComposterBlock.COMPOSTABLES.put(CRItems.PORTOBELLO_RICE_SOUP.get(), 0.85F);
		ComposterBlock.COMPOSTABLES.put(CRItems.POTATO_FRITTERS.get(), 0.65F);
		ComposterBlock.COMPOSTABLES.put(CRItems.LIME.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(CRItems.LIME_SEEDS.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(CRItems.LIME_PIE.get(), 1F);
		ComposterBlock.COMPOSTABLES.put(CRItems.LIME_PIE_SLICE.get(), 0.85F);
		ComposterBlock.COMPOSTABLES.put(CRItems.POMEGRANATE.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(CRItems.POMEGRANATE_SLICE.get(), 0.2F);
		ComposterBlock.COMPOSTABLES.put(CRItems.POMEGRANATE_SEEDS.get(), 0.1F);
		ComposterBlock.COMPOSTABLES.put(CRItems.STYGIAN_POMEGRANATE.get(), 0.35F);
	}

	// Adds collectorsreap:enabled, etc. conditions
	@SubscribeEvent
	public void registerSerializers(RegisterEvent e) {
		if (e.getRegistryKey() == ForgeRegistries.RECIPE_SERIALIZERS.getRegistryKey()) {
			CraftingHelper.register(EnabledCondition.Serializer.INSTANCE);
		}
	}

	@SubscribeEvent
	public void buildContents(BuildCreativeModeTabContentsEvent event) {
		if (event.getTabKey() == ModCreativeTabs.TAB_FARMERS_DELIGHT.getKey()) {
			CRItems.ITEMS.getEntries().stream().filter(RegistryObject::isPresent).forEach(object -> {
				final Item item = object.get();
				if (item instanceof IConfigured configured && !configured.enabled()) {
					return;
				}
				event.accept(new ItemStack(item), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
			});
		}
	}
}
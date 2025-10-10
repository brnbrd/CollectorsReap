package net.brdle.collectorsreap.compat;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.forge.ForgeTypes;
import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.runtime.IIngredientManager;
import net.brdle.collectorsreap.CollectorsReap;
import net.brdle.collectorsreap.Util;
import net.brdle.collectorsreap.common.block.CRBlocks;
import net.brdle.collectorsreap.common.config.CRConfig;
import net.brdle.collectorsreap.common.fluid.CRFluids;
import net.brdle.collectorsreap.common.item.CRItems;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import javax.annotation.ParametersAreNonnullByDefault;
import org.jetbrains.annotations.NotNull;

@JeiPlugin
@ParametersAreNonnullByDefault
@SuppressWarnings("unused")
public class JEIPlugin implements IModPlugin {
	private static final ResourceLocation ID = Util.cr("jei_plugin");

	@Override
	public void registerRecipes(IRecipeRegistration registration) {
		// Remove all disabled Items from JEI
		final IIngredientManager manager = registration.getIngredientManager();
		final List<ItemStack> hidden = CRItems.HELPER.getDeferredRegister().getEntries().stream()
			.filter(Predicate.not(CRConfig::verify)) // Keep disabled items (to add to hidden list)
			.map(Util::getStack)
			.collect(Collectors.toCollection(ArrayList::new)); // Create new mutable list
		final List<FluidStack> hiddenFluids = new ArrayList<>();

		if (!Modid.FR.loaded()) {
			hidden.addAll(List.of(
				CRItems.STRONG_LIMEADE.get().getDefaultInstance(),
				CRItems.LIME_GREEN_TEA.get().getDefaultInstance(),
				CRItems.POMEGRANATE_BLACK_TEA.get().getDefaultInstance()
			));
			hiddenFluids.addAll(List.of(
				new FluidStack(CRFluids.LIME_JUICE.get(), 1000),
				new FluidStack(CRFluids.STRONG_LIME_JUICE.get(), 1000),
				new FluidStack(CRFluids.BERRY_LIMEADE.get(), 1000),
				new FluidStack(CRFluids.PINK_LIMEADE.get(), 1000),
				new FluidStack(CRFluids.MINT_LIMEADE.get(), 1000),
				new FluidStack(CRFluids.LIME_GREEN_TEA.get(), 1000),
				new FluidStack(CRFluids.POMEGRANATE_BLACK_TEA.get(), 1000)
			));
		}
		if (!Modid.BC.loaded()) {
			hidden.addAll(List.of(
				CRItems.DEIFIC_BLOOD.get().getDefaultInstance(),
				CRItems.HERMITS_SOUR.get().getDefaultInstance(),
				CRItems.ROSE_MOON.get().getDefaultInstance(),
				CRItems.REANIMATORS_GARDEN.get().getDefaultInstance()
			));
			hiddenFluids.addAll(List.of(
				new FluidStack(CRFluids.CREAM_CHEESE.get(), 1000),
				new FluidStack(CRFluids.DEIFIC_BLOOD.get(), 1000),
				new FluidStack(CRFluids.HERMITS_SOUR.get(), 1000),
				new FluidStack(CRFluids.ROSE_MOON.get(), 1000),
				new FluidStack(CRFluids.REANIMATORS_GARDEN.get(), 1000)
			));
		}

		if (!hidden.isEmpty()) {
			manager.removeIngredientsAtRuntime(VanillaTypes.ITEM_STACK, hidden);
		}
		if (!hiddenFluids.isEmpty()) {
			manager.removeIngredientsAtRuntime(ForgeTypes.FLUID_STACK, hiddenFluids);
		}

		// Portobello
		registration.addItemStackInfo(Util.getStack(CRBlocks.PORTOBELLO), Component.translatable("desc." + CollectorsReap.MODID + "." + Util.name(CRBlocks.PORTOBELLO)));

		// Lime
		String limeTranslationKey = "desc." + CollectorsReap.MODID + "." + Util.name(CRItems.LIME);
		List<ItemStack> limeStack = List.of(Util.getStack(CRItems.LIME), Util.getStack(CRItems.LIME_SLICE));
		if (CRConfig.verify(CRItems.LIME) && CRConfig.LIME_POLLINATION.get()) {
			registration.addItemStackInfo(limeStack, Component.translatable(limeTranslationKey),
				Component.translatable(limeTranslationKey + ".pollination")
			);
		} else {
			registration.addItemStackInfo(limeStack, Component.translatable(limeTranslationKey));
		}

		// Pomegranate
		String pomTranslationKey = "desc." + CollectorsReap.MODID + "." + Util.name(CRItems.POMEGRANATE);
		List<ItemStack> pomStack = List.of(Util.getStack(CRItems.POMEGRANATE), Util.getStack(CRItems.POMEGRANATE_SLICE));
		if (CRConfig.verify(CRItems.POMEGRANATE)) {
			if (CRConfig.POMEGRANATE_POLLINATION.get()) {
				registration.addItemStackInfo(pomStack,
					Component.translatable(pomTranslationKey),
					Component.translatable(pomTranslationKey + ".pollination")
				);
			} else {
				registration.addItemStackInfo(pomStack, Component.translatable(pomTranslationKey));
			}
		}

		// Pink Dragon Fruit
		String dragonFruitTranslationKey = "desc." + CollectorsReap.MODID + "." + Util.name(CRItems.PINK_DRAGON_FRUIT);
		List<ItemStack> dragonFruitStack = List.of(Util.getStack(CRBlocks.DRAGON_BUSH), Util.getStack(CRItems.PINK_DRAGON_FRUIT));
		if (CRConfig.verify(CRItems.PINK_DRAGON_FRUIT)) {
			registration.addItemStackInfo(dragonFruitStack, Component.translatable(dragonFruitTranslationKey));
		}

		// Urchin Dart
		String dartTranslationKey = "desc." + CollectorsReap.MODID + "." + Util.name(CRItems.URCHIN_DART);
		if (CRConfig.verify(CRItems.URCHIN_DART)) {
			registration.addItemStackInfo(Util.getStack(CRItems.URCHIN_DART), Component.translatable(dartTranslationKey));
		}

		if (Modid.MND.loaded()) {
			if (CRConfig.verify(CRItems.STYGIAN_POMEGRANATE)) {
				registration.addItemStackInfo(
					Util.getStack(CRItems.STYGIAN_POMEGRANATE),
					Component.translatable("desc." + CollectorsReap.MODID + "." + Util.name(CRItems.STYGIAN_POMEGRANATE))
				);
			}
			registration.addItemStackInfo(Util.getStack(CRItems.PORTOBELLO_COLONY), Component.translatable("mynethersdelight.jei.info.mushroom_colony"));
		}
	}

	@Override
	public @NotNull ResourceLocation getPluginUid() {
		return ID;
	}
}
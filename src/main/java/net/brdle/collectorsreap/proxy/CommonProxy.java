package net.brdle.collectorsreap.proxy;

import net.brdle.collectorsreap.common.CRParticleTypes;
import net.brdle.collectorsreap.common.block.CRBlocks;
import net.brdle.collectorsreap.common.event.CRCreativeTab;
import net.brdle.collectorsreap.common.event.CRSoundEvents;
import net.brdle.collectorsreap.common.event.ForgeEvents;
import net.brdle.collectorsreap.common.event.ModEvents;
import net.brdle.collectorsreap.common.effect.CREffects;
import net.brdle.collectorsreap.common.entity.CREntities;
import net.brdle.collectorsreap.common.fluid.CRFluids;
import net.brdle.collectorsreap.common.item.CRItems;
import net.brdle.collectorsreap.common.loot.CRLootItemConditions;
import net.brdle.collectorsreap.common.loot.CRLootModifiers;
import net.brdle.collectorsreap.common.world.CRFeatures;
import net.brdle.collectorsreap.compat.Modid;
import net.brdle.collectorsreap.data.gen.Generators;
import net.brdle.collectorsreap.data.pack.CRFoliagePlacerTypes;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.RegistryObject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class CommonProxy {
	private static @NotNull List<RegistryObject<? extends ItemLike>> hiddenItems = Collections.emptyList();

	public void start() {
		final var modBus = FMLJavaModLoadingContext.get().getModEventBus();
		final var forgeBus = MinecraftForge.EVENT_BUS;
		forgeBus.register(new ForgeEvents());
		modBus.register(new ModEvents());
		modBus.register(new Generators());
		CRFluids.create(modBus);
		CREntities.create(modBus);
		CRParticleTypes.create(modBus);
		CREffects.create(modBus);
		CRCreativeTab.create(modBus);
		CRFeatures.create(modBus);
		CRLootItemConditions.create(modBus);
		CRLootModifiers.create(modBus);
		CRSoundEvents.create(modBus);
		CRFoliagePlacerTypes.create(modBus);

		hiddenItems = new ArrayList<>();
		if (!Modid.FR.loaded()) {
			hiddenItems.addAll(List.of(
				CRItems.STRONG_LIMEADE,
				CRItems.LIME_GREEN_TEA,
				CRItems.POMEGRANATE_BLACK_TEA,
				CRItems.VERNAL_PURGE,
				CRItems.STRONG_VERNAL_PURGE,
				CRItems.LIMBO_BREW,
				CRItems.LONG_LIMBO_BREW,
				CRItems.STRONG_LIMBO_BREW,
				CRItems.SWEET_RECOVERY,
				CRItems.LONG_SWEET_RECOVERY,
				CRItems.STRONG_SWEET_RECOVERY
			));
		}
		if (!Modid.BC.loaded()) {
			hiddenItems.addAll(List.of(
				CRItems.DEIFIC_BLOOD,
				CRItems.HERMITS_SOUR,
				CRItems.ROSE_MOON,
				CRItems.REANIMATORS_GARDEN,
				CRItems.HEAVENS_CREAM
			));
		}
		if (!Modid.WW.loaded()) {
			hiddenItems.addAll(List.of(
				CRBlocks.LUCUMA_BEEHIVE,
				CRBlocks.LUCUMA_LADDER,
				CRBlocks.LUCUMA_BOOKSHELF,
				CRBlocks.CHISELED_LUCUMA_BOOKSHELF,
				CRBlocks.LUCUMA_BOARDS,
				CRBlocks.LUCUMA_CHEST,
				CRBlocks.TRAPPED_LUCUMA_CHEST
			));
		}
	}

	public static @NotNull List<RegistryObject<? extends ItemLike>> getHiddenItems() {
		return hiddenItems;
	}
}
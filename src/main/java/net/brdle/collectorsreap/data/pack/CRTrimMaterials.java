package net.brdle.collectorsreap.data.pack;

import net.brdle.collectorsreap.Util;
import net.brdle.collectorsreap.common.item.CRItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraftforge.registries.ForgeRegistries;
import java.util.Map;

public class CRTrimMaterials {
	public static final ResourceKey<TrimMaterial> PEARL = registerKey("pearl");

	public static void bootstrap(final BootstapContext<TrimMaterial> context) {
		register(context, PEARL, CRItems.LUNAR_PEARL.get().asItem(), Style.EMPTY.withColor(15715308), Map.of());
	}

	private static ResourceKey<TrimMaterial> registerKey(final String name) {
		return ResourceKey.create(Registries.TRIM_MATERIAL, Util.cr(name));
	}

	private static void register(BootstapContext<TrimMaterial> context, ResourceKey<TrimMaterial> key, Item item, Style style, Map<ArmorMaterials, String> overrides) {
		final ResourceLocation rl = key.location();
		context.register(key, new TrimMaterial(
			rl.getNamespace() + "_" + rl.getPath(),
			ForgeRegistries.ITEMS.getHolder(item).get(),
			-1.0F,
			overrides,
			Component.translatable("trim_material." + rl.toLanguageKey()).withStyle(style)
		));
	}
}
package net.brdle.collectorsreap.data.pack;

import net.brdle.collectorsreap.CollectorsReap;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class CRRegistries extends DatapackBuiltinEntriesProvider {
	public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
		.add(Registries.CONFIGURED_FEATURE, CRConfiguredFeatures::bootstrap)
		.add(Registries.TRIM_MATERIAL, CRTrimMaterials::bootstrap);

	public CRRegistries(PackOutput output, CompletableFuture<HolderLookup.Provider> future) {
		super(output, future, BUILDER, Set.of("minecraft", CollectorsReap.MODID));
	}
}
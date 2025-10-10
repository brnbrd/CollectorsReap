package net.brdle.collectorsreap.data.gen;

import com.teamabnormals.blueprint.core.other.tags.BlueprintTrimMaterialTags;
import net.brdle.collectorsreap.CollectorsReap;
import net.brdle.collectorsreap.data.pack.CRTrimMaterials;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraftforge.common.data.ExistingFileHelper;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;

public class CRTrimMaterialTagProvider extends TagsProvider<TrimMaterial> {
	public CRTrimMaterialTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookup, ExistingFileHelper helper) {
		super(output, Registries.TRIM_MATERIAL, lookup, CollectorsReap.MODID, helper);
	}

	@Override
	protected void addTags(HolderLookup.@NotNull Provider provider) {
		this.tag(BlueprintTrimMaterialTags.GENERATES_OVERRIDES).add(CRTrimMaterials.PEARL);
	}
}
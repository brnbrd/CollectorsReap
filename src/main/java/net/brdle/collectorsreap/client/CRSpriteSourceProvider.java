package net.brdle.collectorsreap.client;

import com.teamabnormals.blueprint.core.api.BlueprintTrims;
import net.brdle.collectorsreap.CollectorsReap;
import net.brdle.collectorsreap.common.item.CRTrimMaterials;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.SpriteSourceProvider;

public class CRSpriteSourceProvider extends SpriteSourceProvider {
	public CRSpriteSourceProvider(PackOutput output, ExistingFileHelper helper) {
		super(output, helper, CollectorsReap.MODID);
	}

	@Override
	protected void addSources() {
		this.atlas(BlueprintTrims.ARMOR_TRIMS_ATLAS).addSource(BlueprintTrims.materialPatternPermutations(CRTrimMaterials.PEARL));
		this.atlas(SpriteSourceProvider.BLOCKS_ATLAS).addSource(BlueprintTrims.materialPermutationsForItemLayers(CRTrimMaterials.PEARL));
	}
}
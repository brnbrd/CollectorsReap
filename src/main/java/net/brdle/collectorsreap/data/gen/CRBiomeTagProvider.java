package net.brdle.collectorsreap.data.gen;

import net.brdle.collectorsreap.CollectorsReap;
import net.brdle.collectorsreap.data.CRBiomeTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.world.level.biome.Biomes;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class CRBiomeTagProvider extends BiomeTagsProvider {
	public CRBiomeTagProvider(DataGenerator gen, @Nullable ExistingFileHelper existingFileHelper) {
		super(gen, CollectorsReap.MODID, existingFileHelper);
	}

	@Override
	protected void addTags() {
		this.tag(CRBiomeTags.PORTOBELLO_SPAWNS).add(Biomes.MEADOW);
		this.tag(CRBiomeTags.LIME_SPAWNS).add(Biomes.FLOWER_FOREST);
		this.tag(CRBiomeTags.POMEGRANATE_SPAWNS)
			.add(Biomes.WARPED_FOREST)
			.add(Biomes.CRIMSON_FOREST);
	}
}

package net.brdle.veggiedelight.data.gen;

import net.brdle.veggiedelight.VeggieDelight;
import net.brdle.veggiedelight.data.VDBiomeTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.world.level.biome.Biomes;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class VDBiomeTagProvider extends BiomeTagsProvider {
	public VDBiomeTagProvider(DataGenerator gen, @Nullable ExistingFileHelper existingFileHelper) {
		super(gen, VeggieDelight.MODID, existingFileHelper);
	}

	@Override
	protected void addTags() {
		this.tag(VDBiomeTags.PORTOBELLO_SPAWNS).add(Biomes.MEADOW);
	}
}

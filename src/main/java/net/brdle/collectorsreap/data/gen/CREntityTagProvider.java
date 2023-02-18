package net.brdle.collectorsreap.data.gen;

import net.brdle.collectorsreap.CollectorsReap;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.EntityTypeTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

public class CREntityTagProvider extends EntityTypeTagsProvider {
	public CREntityTagProvider(DataGenerator gen, ExistingFileHelper existingFileHelper) {
		super(gen, CollectorsReap.MODID, existingFileHelper);
	}

	@Override
	protected void addTags() {
	}

	/**
	 * Gets a name for this provider, to use in logging.
	 */
	@Override
	public @NotNull String getName() {
		return CollectorsReap.MODID;
	}
}

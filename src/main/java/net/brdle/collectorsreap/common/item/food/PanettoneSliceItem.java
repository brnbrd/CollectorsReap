package net.brdle.collectorsreap.common.item.food;

import net.brdle.collectorsreap.common.item.IConfigured;
import net.brdle.collectorsreap.data.CRItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import vectorwing.farmersdelight.common.item.ConsumableItem;
import org.jetbrains.annotations.Nullable;

public class PanettoneSliceItem extends ConsumableItem implements IConfigured {
	public PanettoneSliceItem(Properties properties) {
		super(properties, false, true);
	}

	@Override
	public @Nullable TagKey<Item> getDependencyTag() {
		return CRItemTags.NUTS;
	}
}

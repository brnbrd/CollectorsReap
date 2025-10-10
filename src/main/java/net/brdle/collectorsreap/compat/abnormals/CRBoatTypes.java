package net.brdle.collectorsreap.compat.abnormals;

import com.teamabnormals.boatload.common.item.FurnaceBoatItem;
import com.teamabnormals.boatload.common.item.LargeBoatItem;
import com.teamabnormals.boatload.core.api.BoatloadBoatType;
import net.brdle.collectorsreap.Util;
import net.brdle.collectorsreap.common.block.CRBlocks;
import net.brdle.collectorsreap.common.item.CRItems;
import net.minecraft.world.item.Item;
import java.util.function.Supplier;

public class CRBoatTypes {
	public static final BoatloadBoatType LUCUMA = BoatloadBoatType.register(BoatloadBoatType.create(
		Util.cr("lucuma"),
		() -> CRBlocks.LUCUMA_PLANKS.get().asItem(),
		() -> CRItems.LUCUMA_BOAT.get(),
		() -> CRItems.LUCUMA_CHEST_BOAT.get(),
		() -> CRItems.LUCUMA_FURNACE_BOAT.get(),
		() -> CRItems.LARGE_LUCUMA_BOAT.get()
	));
	public static final Supplier<Item> LUCUMA_FURNACE_BOAT = () -> new FurnaceBoatItem(LUCUMA);
	public static final Supplier<Item> LARGE_LUCUMA_BOAT = () -> new LargeBoatItem(LUCUMA);
}
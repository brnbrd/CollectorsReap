package net.brdle.collectorsreap.common.block;

import com.teamabnormals.blueprint.core.api.BlueprintCauldronInteraction;
import com.teamabnormals.neapolitan.core.other.NeapolitanCauldronInteractions;
import net.brdle.collectorsreap.CollectorsReap;
import net.brdle.collectorsreap.Util;
import net.brdle.collectorsreap.common.item.CRItems;
import net.minecraft.core.cauldron.CauldronInteraction;

public class CRCauldronInteractions {
	public static BlueprintCauldronInteraction LIME_MILKSHAKE = BlueprintCauldronInteraction.register(Util.rl(CollectorsReap.MODID, "lime_milkshake"), CauldronInteraction.newInteractionMap());
	public static BlueprintCauldronInteraction POMEGRANATE_MILKSHAKE = BlueprintCauldronInteraction.register(Util.rl(CollectorsReap.MODID, "pomegranate_milkshake"), CauldronInteraction.newInteractionMap());

	public static void registerCauldronInteractions() {
		NeapolitanCauldronInteractions.addMilkshakeInteractions(CRItems.LIME_MILKSHAKE.get(), CRBlocks.LIME_MILKSHAKE_CAULDRON.get(), CRItems.LIME_ICE_CREAM.get(), LIME_MILKSHAKE.map());
		NeapolitanCauldronInteractions.addMilkshakeInteractions(CRItems.POMEGRANATE_MILKSHAKE.get(), CRBlocks.POMEGRANATE_MILKSHAKE_CAULDRON.get(), CRItems.POMEGRANATE_ICE_CREAM.get(), POMEGRANATE_MILKSHAKE.map());
	}
}
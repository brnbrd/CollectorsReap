package net.brdle.collectorsreap.data.gen;

import net.brdle.collectorsreap.CollectorsReap;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.GlobalLootModifierProvider;

public class CRLootModifierProvider extends GlobalLootModifierProvider {
	public CRLootModifierProvider(PackOutput output) {
		super(output, CollectorsReap.MODID);
	}

	@Override
	protected void start() {
		/*add("straw_from_compat", new AddItemLootModifier(
			new LootItemCondition[]{
				LootItemRandomChanceCondition.randomChance(0.2F).build(),
				MatchTool.toolMatches(ItemPredicate.Builder.item().of(DelightfulItemTags.SCAVENGING_TOOLS)).build(),
				LootItemBlockIsTagCondition.isTag(DelightfulBlockTags.DROPS_STRAW)
			},
		ModItems.STRAW.get(), 1, 1, true
		));*/
	}
}

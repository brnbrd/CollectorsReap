package net.brdle.veggiedelight.data.gen;

import net.brdle.veggiedelight.VeggieDelight;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.GlobalLootModifierProvider;

public class VDLootModifierProvider extends GlobalLootModifierProvider {
	public VDLootModifierProvider(DataGenerator gen) {
		super(gen, VeggieDelight.MODID);
	}

	/**
	 * Call {@link #add} here, which will pass in the necessary information to write the jsons.
	 */
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

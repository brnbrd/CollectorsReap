package net.brdle.collectorsreap.data.gen;

import com.teamabnormals.blueprint.common.loot.modification.LootModifierProvider;
import com.teamabnormals.blueprint.common.loot.modification.modifiers.LootPoolEntriesModifier;
import net.brdle.collectorsreap.CollectorsReap;
import net.brdle.collectorsreap.common.block.CRBlocks;
import net.brdle.collectorsreap.common.item.CRItems;
import net.brdle.collectorsreap.common.loot.LootItemEnabledCondition;
import net.minecraft.advancements.critereon.LocationPredicate;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LocationCheck;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class CRLootModifierProvider extends LootModifierProvider {
	public CRLootModifierProvider(PackOutput output, CompletableFuture<Provider> provider) {
		super(CollectorsReap.MODID, output, provider);
	}

	@Override
	protected void registerEntries(Provider provider) {
		this.entry("abandoned_mineshaft").selects(BuiltInLootTables.ABANDONED_MINESHAFT)
			.addModifier(new LootPoolEntriesModifier(false, 0, List.of(
				LootItem.lootTableItem(CRItems.LIME.get())
					.setWeight(8)
					.apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2)))
					.when(enabled(CRItems.LIME)).build()
			)));
		this.entry("simple_dungeon").selects(BuiltInLootTables.SIMPLE_DUNGEON)
			.addModifier(new LootPoolEntriesModifier(false, 0, List.of(
				LootItem.lootTableItem(CRItems.LIME_SEEDS.get())
					.setWeight(10)
					.apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 4)))
					.when(enabled(CRItems.LIME_SEEDS)).build()
			)));
		this.entry("bastion_hoglin_stable").selects(BuiltInLootTables.BASTION_HOGLIN_STABLE)
			.addModifier(new LootPoolEntriesModifier(false, 0, List.of(
				LootItem.lootTableItem(CRItems.POMEGRANATE_SLICE.get())
					.setWeight(10)
					.apply(SetItemCountFunction.setCount(UniformGenerator.between(4, 12)))
					.when(enabled(CRItems.POMEGRANATE_SLICE)).build()
			)));
		this.entry("bastion_other").selects(BuiltInLootTables.BASTION_OTHER)
			.addModifier(new LootPoolEntriesModifier(false, 0, List.of(
				LootItem.lootTableItem(CRItems.POMEGRANATE_SLICE.get())
					.setWeight(10)
					.apply(SetItemCountFunction.setCount(UniformGenerator.between(6, 16)))
					.when(enabled(CRItems.POMEGRANATE_SLICE)).build()
			)));
		this.entry("ancient_city").selects(BuiltInLootTables.ANCIENT_CITY)
			.addModifier(new LootPoolEntriesModifier(false, 0, List.of(
				LootItem.lootTableItem(CRBlocks.LUCUMA_SAPLING.get())
					.setWeight(4)
					.when(enabled(CRBlocks.LUCUMA_SAPLING)).build(),
				LootItem.lootTableItem(CRItems.GILDED_LUCUMA.get())
					.setWeight(1)
					.when(enabled(CRItems.GILDED_LUCUMA)).build()
			)));
		this.entry("shipwreck_treasure").selects(BuiltInLootTables.SHIPWRECK_TREASURE)
			.addModifier(new LootPoolEntriesModifier(false, 0, List.of(
				LootItem.lootTableItem(CRItems.LUNAR_PEARL.get())
					.setWeight(14)
					.apply(SetItemCountFunction.setCount(UniformGenerator.between(4, 8)))
					.when(enabled(CRItems.LUNAR_PEARL)).build()
			)));
		this.entry("buried_treasure").selects(BuiltInLootTables.BURIED_TREASURE)
			.addModifier(new LootPoolEntriesModifier(false, 0, List.of(
				LootItem.lootTableItem(CRItems.LUNAR_PEARL.get())
					.setWeight(2)
					.apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 7)))
					.when(enabled(CRItems.LUNAR_PEARL)).build()
			)));

		// Fishing
		final LootItemCondition.Builder inRiver = LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiome(Biomes.RIVER));
		final LootItemCondition.Builder inSwamp = LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiome(Biomes.SWAMP));
		final LootItemCondition.Builder inMangroveSwamp = LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiome(Biomes.MANGROVE_SWAMP));
		final LootItemCondition.Builder inOcean = LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiome(Biomes.OCEAN));
		final LootItemCondition.Builder inWarmOcean = LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiome(Biomes.WARM_OCEAN));
		final LootItemCondition.Builder inColdOcean = LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiome(Biomes.COLD_OCEAN));
		this.entry(BuiltInLootTables.FISHING_FISH.getPath())
			.selects(BuiltInLootTables.FISHING_FISH)
			.addModifier(new LootPoolEntriesModifier(false, 0,
				LootItem.lootTableItem(CRItems.PLATINUM_BASS.get())
					.setWeight(7)
					.when(inRiver)
					.when(enabled(CRItems.PLATINUM_BASS)).build(),
				LootItem.lootTableItem(CRItems.TIGER_PRAWN.get())
					.setWeight(9)
					.when(inRiver.or(inSwamp).or(inMangroveSwamp))
					.when(enabled(CRItems.TIGER_PRAWN)).build(),
				LootItem.lootTableItem(CRItems.URCHIN.get())
					.setWeight(9)
					.when(inOcean.or(inWarmOcean).or(inColdOcean))
					.when(enabled(CRItems.URCHIN)).build(),
				LootItem.lootTableItem(CRItems.CLAM.get())
					.setWeight(10)
					.when(inOcean.or(inWarmOcean).or(inColdOcean))
					.when(enabled(CRItems.CLAM)).build()
			));
	}

	private LootItemCondition.Builder enabled(RegistryObject<? extends ItemLike> feature) {
		return LootItemEnabledCondition.enabled(feature);
	}
}
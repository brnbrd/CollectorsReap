package net.brdle.collectorsreap.common.world;

import com.mojang.serialization.Codec;
import net.brdle.collectorsreap.common.entity.CREntities;
import net.brdle.collectorsreap.data.CRBiomeTags;
import net.minecraft.core.Holder;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ModifiableBiomeInfo;

public class AddSpawnBiomeModifier implements BiomeModifier {

	@Override
	public void modify(Holder<Biome> biome, Phase phase, ModifiableBiomeInfo.BiomeInfo.Builder builder) {
		if (phase.equals(Phase.ADD)) {
			addMobSpawn(builder, biome, CRBiomeTags.PLATINUM_BASS_SPAWNS, MobCategory.WATER_AMBIENT, CREntities.PLATINUM_BASS.get(), 2, 1, 4);
			addMobSpawn(builder, biome, CRBiomeTags.TIGER_PRAWN_SPAWNS, MobCategory.WATER_AMBIENT, CREntities.TIGER_PRAWN.get(), 6, 3, 6);
			addMobSpawn(builder, biome, CRBiomeTags.URCHIN_SPAWNS, MobCategory.WATER_AMBIENT, CREntities.URCHIN.get(), 5, 3, 7);
			addMobSpawn(builder, biome, CRBiomeTags.CLAM_SPAWNS, MobCategory.WATER_AMBIENT, CREntities.CLAM.get(), 5, 2, 4);
			addMobSpawn(builder, biome, CRBiomeTags.CHIEFTAIN_CRAB_SPAWNS, MobCategory.WATER_CREATURE, CREntities.CHIEFTAIN_CRAB.get(), 4, 2, 4);
			addMobSpawn(builder, biome, BiomeTags.IS_BEACH, MobCategory.CREATURE, CREntities.CHIEFTAIN_CRAB.get(), 5, 2, 4);
		}
	}

	void addMobSpawn(ModifiableBiomeInfo.BiomeInfo.Builder builder, Holder<Biome> biome, TagKey<Biome> tag, MobCategory mobCategory, EntityType<?> entityType, int weight, int minGroupSize, int maxGroupSize) {
		if (biome.is(tag)) {
			builder.getMobSpawnSettings().addSpawn(mobCategory, new MobSpawnSettings.SpawnerData(entityType, weight, minGroupSize, maxGroupSize));
		}
	}

	@Override
	public Codec<? extends BiomeModifier> codec() {
		return CRBiomeModifiers.ADD_SPAWN.get();
	}
}
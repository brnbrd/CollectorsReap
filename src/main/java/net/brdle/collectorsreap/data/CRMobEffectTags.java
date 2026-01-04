package net.brdle.collectorsreap.data;

import com.teamabnormals.blueprint.core.util.TagUtil;
import net.brdle.collectorsreap.CollectorsReap;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import org.jetbrains.annotations.NotNull;

public class CRMobEffectTags {
	public static final TagKey<MobEffect> UNOBTAINABLE_FROM_PANETTONE = mobEffectTag("unobtainable_from_panettone");

	private static TagKey<MobEffect> mobEffectTag(@NotNull String name) {
		return TagUtil.mobEffectTag(CollectorsReap.MODID, name);
	}
}
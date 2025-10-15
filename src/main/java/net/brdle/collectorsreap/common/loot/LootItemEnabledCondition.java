package net.brdle.collectorsreap.common.loot;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import net.brdle.collectorsreap.Util;
import net.brdle.collectorsreap.common.config.CRConfig;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemConditionType;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

public class LootItemEnabledCondition implements LootItemCondition {
	final String item;

	LootItemEnabledCondition(String item) {
		this.item = item;
	}

	private static LootItemCondition.Builder enabled(String item) {
		return () -> new LootItemEnabledCondition(item);
	}

	public static LootItemCondition.Builder enabled(RegistryObject<? extends ItemLike> item) {
		return enabled(Util.name(item));
	}

	@Override
	public @NotNull LootItemConditionType getType() {
		return CRLootItemConditions.ENABLED.get();
	}

	/**
	 * Evaluates this predicate on the given argument.
	 *
	 * @param context the input argument
	 * @return {@code true} if the input argument matches the predicate,
	 * otherwise {@code false}
	 */
	@Override
	public boolean test(LootContext context) {
		return CRConfig.verify(this.item);
	}

	public static class Serializer implements net.minecraft.world.level.storage.loot.Serializer<LootItemEnabledCondition> {
		// Serialize the value by putting its data into the JsonObject.
		public void serialize(JsonObject object, LootItemEnabledCondition condition, @NotNull JsonSerializationContext context) {
			object.addProperty("item", condition.item);
		}

		// Deserialize a value by reading it from the JsonObject.
		public @NotNull LootItemEnabledCondition deserialize(@NotNull JsonObject object, @NotNull JsonDeserializationContext context) {
			return new LootItemEnabledCondition(GsonHelper.getAsString(object, "item"));
		}
	}
}
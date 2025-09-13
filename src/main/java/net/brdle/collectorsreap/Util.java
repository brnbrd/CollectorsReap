package net.brdle.collectorsreap;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.brdle.collectorsreap.compat.Mods;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryObject;
import java.util.Objects;
import java.util.UUID;
import java.util.function.Supplier;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Util {
	public static final String EMPTY_STR = "";
	public static final String MC = "minecraft";
	public static final UUID BLOCK_REACH = UUID.fromString("6ba3d68d-2e14-4b88-92c8-5a6796650af3");

	public static ResourceLocation rl(@NotNull String modid, @NotNull String path) {
		return ResourceLocation.tryBuild(modid, path);
	}

	public static ResourceLocation rl(@NotNull String separated) {
		return ResourceLocation.tryParse(separated);
	}

	public static ResourceLocation rl(ItemLike itemLike) {
		if (itemLike instanceof Item item) {
			IForgeRegistry<Item> reg = ForgeRegistries.ITEMS;
			if (reg.containsValue(item)) return reg.getKey(item);
		} else if (itemLike instanceof Block block) {
			IForgeRegistry<Block> reg = ForgeRegistries.BLOCKS;
			if (reg.containsValue(block)) return reg.getKey(block);
		}
		return rl(EMPTY_STR, EMPTY_STR);
	}

	public static ResourceLocation cr(String path) {
		return rl(CollectorsReap.MODID, path);
	}

	public static ResourceLocation mc(String path) {
		return rl(MC, path);
	}

	public static TagKey<Item> it(String modid, String path) {
		return ItemTags.create(rl(modid, path));
	}

	public static ObjectArrayList<ItemStack> with(ObjectArrayList<ItemStack> before, ItemStack addition) {
		before.add(addition);
		return before.clone();
	}

	public static ObjectArrayList<ItemStack> with(ObjectArrayList<ItemStack> before, Item addition, int count) {
		return (count < 1) ? before : with(before, new ItemStack(addition, count));
	}

	public static ObjectArrayList<ItemStack> with(ObjectArrayList<ItemStack> before, Item addition, RandomSource rand, int min, int max) {
		if (max < min) {
			return before;
		}
		return with(before, addition, (max == min) ? min : rand.nextIntBetweenInclusive(min, max));
	}

	public static ObjectArrayList<ItemStack> with(ObjectArrayList<ItemStack> before, Item addition) {
		return with(before, addition, 1);
	}

	public static boolean itemExists(ResourceLocation location) {
		return Mods.stringLoaded(location.getNamespace()) && ForgeRegistries.ITEMS.containsKey(location);
	}

	@Nullable
	public static Item item(ResourceLocation rl) {
		return ForgeRegistries.ITEMS.getValue(rl);
	}

	@Nullable
	public static Item item(String id, String path) {
		return item(rl(id, path));
	}

	@NotNull
	public static Item item(ResourceLocation location, @NotNull Item backup) {
		if (itemExists(location)) {
			Item item = item(location);
			if (item != null) {
				return item;
			}
		}
		return backup;
	}

	@NotNull
	public static Item item(ResourceLocation location, @NotNull Supplier<Item> backup) {
		return item(location, backup.get());
	}

	public static ItemStack getStack(Supplier<Item> r) {
		return r.get().getDefaultInstance();
	}

	@Nullable
	public static Block block(String id, String path) {
		return block(rl(id, path));
	}

	@Nullable
	public static Block block(ResourceLocation rl) {
		return ForgeRegistries.BLOCKS.getValue(rl);
	}

	public static boolean effectExists(ResourceLocation effect) {
		return Mods.stringLoaded(effect.getNamespace()) && ForgeRegistries.MOB_EFFECTS.containsKey(effect);
	}

	@Nullable
	private static MobEffect getBackup(@Nullable MobEffect[] backup) {
		return (
			(backup != null && backup.length > 0) ?
			backup[0] :
			null
		);
	}

	@Nullable
	public static MobEffect effect(ResourceLocation effLocation, MobEffect... backup) {
		return (
			effectExists(effLocation) ?
			ForgeRegistries.MOB_EFFECTS.getValue(effLocation) :
			getBackup(backup)
		);
	}

	@Nullable
	public static MobEffect effect(String id, String name, MobEffect... backup) {
		return effect(rl(id, name), backup);
	}

	public static String name(Item item) {
		return Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(item)).getPath();
	}

	public static String name(Block block) {
		return Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block)).getPath();
	}

	public static String name(RegistryObject<?> reg) {
		return reg.getId().getPath();
	}

	public static float roundToHalf(float x) {
		return (float) Math.round(x * 0.5F) / 0.5F;
	}
}
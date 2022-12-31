package net.brdle.veggiedelight.common.config;

import net.brdle.veggiedelight.Util;
import net.brdle.veggiedelight.common.item.VDItems;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.registries.RegistryObject;
import java.util.HashMap;
import java.util.Map;

public class VDConfig {

    private static final VDConfig CONFIG;
    public static final ForgeConfigSpec SPEC;
    private static final Map<String, ForgeConfigSpec.BooleanValue> stuff = new HashMap<>();
    public static ForgeConfigSpec.IntValue CHANCE_PORTOBELLO;

    VDConfig(ForgeConfigSpec.Builder builder) {
        builder.comment(" Let's Configure Veggie Delight");
        stuff.clear();
        builder.push("Items");
            VDItems.ITEMS.getEntries().stream()
                    .map(obj -> obj.getId().getPath())
                    .sorted()
                    .forEach(not -> put(builder, stuff, not, true));
        builder.pop();
        builder.push("Generation");
            CHANCE_PORTOBELLO = builder
              .comment("Chance of generating clusters. Smaller value = more frequent (once every ...). To disable, set the item Portobello to false above.")
              .defineInRange("chance_portobello", 30, 0, Integer.MAX_VALUE);
        builder.pop();
    }

    private static void put(ForgeConfigSpec.Builder builder, Map<String, ForgeConfigSpec.BooleanValue> map, String name, boolean def) {
        map.put(name, builder.define(name, def));
    }

    private static boolean contains(String item) {
        return stuff.containsKey(item);
    }

    public static boolean verify(String item) {
        return contains(item) && stuff.get(item).get();
    }

    public static boolean verify(RegistryObject<Item> item) {
        return verify(item.getId().getPath());
    }

    public static boolean verify(Item item) {
        return verify(Util.name(item));
    }

    static {
        var pair = new ForgeConfigSpec.Builder().configure(VDConfig::new);
        SPEC = pair.getRight();
        CONFIG = pair.getLeft();
    }
}
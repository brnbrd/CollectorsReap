package net.brdle.collectorsreap.common.config;

import net.brdle.collectorsreap.Util;
import net.brdle.collectorsreap.common.item.CRItems;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.registries.RegistryObject;
import java.util.HashMap;
import java.util.Map;

public class CRConfig {

    private static final CRConfig CONFIG;
    public static final ForgeConfigSpec SPEC;
    private static final Map<String, ForgeConfigSpec.BooleanValue> stuff = new HashMap<>();
    public static ForgeConfigSpec.IntValue CHANCE_PORTOBELLO;
    public static ForgeConfigSpec.IntValue CHANCE_LEMON_BUSH;

    CRConfig(ForgeConfigSpec.Builder builder) {
        builder.comment(" Let's Configure Veggie Delight");
        stuff.clear();
        builder.push("Items");
            CRItems.ITEMS.getEntries().stream()
                    .map(obj -> obj.getId().getPath())
                    .sorted()
                    .forEach(not -> put(builder, stuff, not, true));
        builder.pop();
        builder.push("Generation");
            CHANCE_PORTOBELLO = builder
              .comment("Chance of generating clusters. Smaller value = more frequent (once every ...). To disable, set the item Portobello to false above.")
              .defineInRange("chance_portobello", 30, 0, Integer.MAX_VALUE);
            CHANCE_LEMON_BUSH = builder
                .comment("Chance of generating bushes. Smaller value = more frequent (once every ...). To disable, set the item Portobello to false above.")
                .defineInRange("chance_lemon_bush", 30, 0, Integer.MAX_VALUE);
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
        var pair = new ForgeConfigSpec.Builder().configure(CRConfig::new);
        SPEC = pair.getRight();
        CONFIG = pair.getLeft();
    }
}
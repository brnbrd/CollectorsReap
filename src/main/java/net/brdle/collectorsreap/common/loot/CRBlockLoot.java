package net.brdle.collectorsreap.common.loot;

import net.brdle.collectorsreap.common.block.CRBlocks;
import net.brdle.collectorsreap.common.block.PortobelloColonyBlock;
import net.brdle.collectorsreap.common.item.CRItems;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

public class CRBlockLoot extends BlockLoot {

    @Override
    protected void addTables() {
        this.dropSelf(CRBlocks.PORTOBELLO.get());
        this.empty(CRBlocks.PORTOBELLO_QUICHE);
        this.empty(CRBlocks.LIME_PIE);
        this.dropSelf(CRBlocks.SMALL_LIME_BUSH.get());
        this.dropOther(CRBlocks.LIME_BUSH.get(), CRItems.LIME_SEEDS.get());
        this.dropSelf(CRBlocks.SMALL_POMEGRANATE_BUSH.get());
        this.dropOther(CRBlocks.POMEGRANATE_BUSH.get(), CRItems.POMEGRANATE_SEEDS.get());
        this.dropSelf(CRBlocks.LIME_CRATE.get());
        this.dropSelf(CRBlocks.POMEGRANATE_CRATE.get());
        this.empty(CRBlocks.LIME_CAKE);
        this.dropOther(CRBlocks.CANDLE_LIME_CAKE.get(), Blocks.CANDLE);
        this.dropOther(CRBlocks.WHITE_CANDLE_LIME_CAKE.get(), Blocks.WHITE_CANDLE);
        this.dropOther(CRBlocks.ORANGE_CANDLE_LIME_CAKE.get(), Blocks.ORANGE_CANDLE);
        this.dropOther(CRBlocks.MAGENTA_CANDLE_LIME_CAKE.get(), Blocks.MAGENTA_CANDLE);
        this.dropOther(CRBlocks.LIGHT_BLUE_CANDLE_LIME_CAKE.get(), Blocks.LIGHT_BLUE_CANDLE);
        this.dropOther(CRBlocks.YELLOW_CANDLE_LIME_CAKE.get(), Blocks.YELLOW_CANDLE);
        this.dropOther(CRBlocks.LIME_CANDLE_LIME_CAKE.get(), Blocks.LIME_CANDLE);
        this.dropOther(CRBlocks.PINK_CANDLE_LIME_CAKE.get(), Blocks.PINK_CANDLE);
        this.dropOther(CRBlocks.GRAY_CANDLE_LIME_CAKE.get(), Blocks.GRAY_CANDLE);
        this.dropOther(CRBlocks.LIGHT_GRAY_CANDLE_LIME_CAKE.get(), Blocks.LIGHT_GRAY_CANDLE);
        this.dropOther(CRBlocks.CYAN_CANDLE_LIME_CAKE.get(), Blocks.CYAN_CANDLE);
        this.dropOther(CRBlocks.PURPLE_CANDLE_LIME_CAKE.get(), Blocks.PURPLE_CANDLE);
        this.dropOther(CRBlocks.BLUE_CANDLE_LIME_CAKE.get(), Blocks.BLUE_CANDLE);
        this.dropOther(CRBlocks.BROWN_CANDLE_LIME_CAKE.get(), Blocks.BROWN_CANDLE);
        this.dropOther(CRBlocks.GREEN_CANDLE_LIME_CAKE.get(), Blocks.GREEN_CANDLE);
        this.dropOther(CRBlocks.RED_CANDLE_LIME_CAKE.get(), Blocks.RED_CANDLE);
        this.dropOther(CRBlocks.BLACK_CANDLE_LIME_CAKE.get(), Blocks.BLACK_CANDLE);
        this.empty(CRBlocks.POMEGRANATE_CAKE);
        this.dropOther(CRBlocks.CANDLE_POMEGRANATE_CAKE.get(), Blocks.CANDLE);
        this.dropOther(CRBlocks.WHITE_CANDLE_POMEGRANATE_CAKE.get(), Blocks.WHITE_CANDLE);
        this.dropOther(CRBlocks.ORANGE_CANDLE_POMEGRANATE_CAKE.get(), Blocks.ORANGE_CANDLE);
        this.dropOther(CRBlocks.MAGENTA_CANDLE_POMEGRANATE_CAKE.get(), Blocks.MAGENTA_CANDLE);
        this.dropOther(CRBlocks.LIGHT_BLUE_CANDLE_POMEGRANATE_CAKE.get(), Blocks.LIGHT_BLUE_CANDLE);
        this.dropOther(CRBlocks.YELLOW_CANDLE_POMEGRANATE_CAKE.get(), Blocks.YELLOW_CANDLE);
        this.dropOther(CRBlocks.LIME_CANDLE_POMEGRANATE_CAKE.get(), Blocks.LIME_CANDLE);
        this.dropOther(CRBlocks.PINK_CANDLE_POMEGRANATE_CAKE.get(), Blocks.PINK_CANDLE);
        this.dropOther(CRBlocks.GRAY_CANDLE_POMEGRANATE_CAKE.get(), Blocks.GRAY_CANDLE);
        this.dropOther(CRBlocks.LIGHT_GRAY_CANDLE_POMEGRANATE_CAKE.get(), Blocks.LIGHT_GRAY_CANDLE);
        this.dropOther(CRBlocks.CYAN_CANDLE_POMEGRANATE_CAKE.get(), Blocks.CYAN_CANDLE);
        this.dropOther(CRBlocks.PURPLE_CANDLE_POMEGRANATE_CAKE.get(), Blocks.PURPLE_CANDLE);
        this.dropOther(CRBlocks.BLUE_CANDLE_POMEGRANATE_CAKE.get(), Blocks.BLUE_CANDLE);
        this.dropOther(CRBlocks.BROWN_CANDLE_POMEGRANATE_CAKE.get(), Blocks.BROWN_CANDLE);
        this.dropOther(CRBlocks.GREEN_CANDLE_POMEGRANATE_CAKE.get(), Blocks.GREEN_CANDLE);
        this.dropOther(CRBlocks.RED_CANDLE_POMEGRANATE_CAKE.get(), Blocks.RED_CANDLE);
        this.dropOther(CRBlocks.BLACK_CANDLE_POMEGRANATE_CAKE.get(), Blocks.BLACK_CANDLE);
        this.dropSelf(CRBlocks.LIME_ICE_CREAM_BLOCK.get());
        this.dropSelf(CRBlocks.POMEGRANATE_ICE_CREAM_BLOCK.get());
        this.dropOther(CRBlocks.LIME_MILKSHAKE_CAULDRON.get(), Blocks.CAULDRON);
        this.dropOther(CRBlocks.POMEGRANATE_MILKSHAKE_CAULDRON.get(), Blocks.CAULDRON);
        this.dropSelf(CRBlocks.URCHIN_TEST_BLOCK.get());
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        return CRBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)
            .filter(b -> !(b instanceof PortobelloColonyBlock))
            ::iterator;
    }

    public void empty(RegistryObject<Block> block) {
        this.add(block.get(), LootTable.lootTable());
    }
}

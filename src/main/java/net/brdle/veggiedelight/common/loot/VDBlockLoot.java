package net.brdle.veggiedelight.common.loot;

import net.brdle.veggiedelight.common.block.PortobelloColonyBlock;
import net.brdle.veggiedelight.common.block.VDBlocks;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

public class VDBlockLoot extends BlockLoot {

    @Override
    protected void addTables() {
        this.dropSelf(VDBlocks.PORTOBELLO.get());
        this.empty(VDBlocks.PORTOBELLO_QUICHE);
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        return VDBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)
            .filter(b -> !(b instanceof PortobelloColonyBlock))
            ::iterator;
    }

    public void empty(RegistryObject<Block> block) {
        this.add(block.get(), LootTable.lootTable());
    }
}

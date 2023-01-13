package net.brdle.collectorsreap.common.loot;

import net.brdle.collectorsreap.common.block.PortobelloColonyBlock;
import net.brdle.collectorsreap.common.block.CRBlocks;
import net.brdle.collectorsreap.common.item.CRItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.NetherWartBlock;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

public class CRBlockLoot extends BlockLoot {

    @Override
    protected void addTables() {
        this.dropSelf(CRBlocks.PORTOBELLO.get());
        this.empty(CRBlocks.PORTOBELLO_QUICHE);
        this.empty(CRBlocks.LEMON_PIE);
        this.dropSelf(CRBlocks.SMALL_LEMON_BUSH.get());
        this.dropOther(CRBlocks.MEDIUM_LEMON_BUSH.get(), CRItems.LEMON_SEEDS.get());
        this.dropOther(CRBlocks.LEMON_BUSH.get(), CRItems.LEMON_SEEDS.get());
        this.dropOther(CRBlocks.WILD_POMEGRANATE_BUSH.get(), CRItems.POMEGRANATE_SEEDS.get());
        this.add(CRBlocks.WILD_POMEGRANATE_BUSH.get(), s ->
            LootTable.lootTable().withPool(applyExplosionDecay(s,
                LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                    .add(LootItem.lootTableItem(CRItems.POMEGRANATE_SEEDS.get())
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F)))))));
        this.dropSelf(CRBlocks.SMALL_POMEGRANATE_BUSH.get());
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

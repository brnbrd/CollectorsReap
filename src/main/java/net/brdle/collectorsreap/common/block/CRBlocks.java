package net.brdle.collectorsreap.common.block;

import net.brdle.collectorsreap.CollectorsReap;
import net.brdle.collectorsreap.common.item.CRItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.common.block.PieBlock;
import vectorwing.farmersdelight.common.registry.ModBlocks;
import java.util.function.Supplier;

public class CRBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, CollectorsReap.MODID);

    public static final RegistryObject<Block> PORTOBELLO = registerBlock("portobello",
        () -> new PortobelloBlock(copy(Blocks.BROWN_MUSHROOM)
            .noCollission().randomTicks().instabreak().sound(SoundType.GRASS).lightLevel((l) -> 1).hasPostProcess(CRBlocks::always)));
    public static final RegistryObject<Block> PORTOBELLO_COLONY = registerBlock("portobello_colony",
        () -> new PortobelloColonyBlock(copy(ModBlocks.BROWN_MUSHROOM_COLONY), CRItems.PORTOBELLO));
    public static final RegistryObject<Block> PORTOBELLO_QUICHE = registerBlock("portobello_quiche",
        () -> new PieBlock(copy(ModBlocks.APPLE_PIE), CRItems.PORTOBELLO_QUICHE_SLICE));
    public static final RegistryObject<Block> LIME_PIE = registerBlock("lime_pie",
        () -> new PieBlock(copy(ModBlocks.APPLE_PIE), CRItems.LIME_PIE_SLICE));
    public static final RegistryObject<Block> LIME_BUSH = registerBlock("lime_bush",
        () -> new LimeBushBlock(BlockBehaviour.Properties.of(Material.PLANT).instabreak().sound(SoundType.GRASS).noOcclusion()));
    public static final RegistryObject<Block> SMALL_LIME_BUSH = registerBlock("small_lime_bush",
        () -> new SmallLimeBushBlock(BlockBehaviour.Properties.of(Material.PLANT).instabreak().sound(SoundType.GRASS).noOcclusion()));
    public static final RegistryObject<Block> MEDIUM_LIME_BUSH = registerBlock("medium_lime_bush",
        () -> new MediumLimeBushBlock(BlockBehaviour.Properties.of(Material.PLANT).instabreak().sound(SoundType.GRASS).noOcclusion()));
    public static final RegistryObject<Block> POMEGRANATE_BUSH = registerBlock("pomegranate_bush",
        () -> new PomegranateBushBlock(BlockBehaviour.Properties.of(Material.PLANT).instabreak().sound(SoundType.GRASS).noOcclusion()));
    public static final RegistryObject<Block> LIME_CRATE = BLOCKS.register("lime_crate",
        () -> new Block(BlockBehaviour.Properties.of(Material.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> POMEGRANATE_CRATE = BLOCKS.register("pomegranate_crate",
        () -> new Block(BlockBehaviour.Properties.of(Material.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)));

    public static RegistryObject<Block> registerBlock(String name, Supplier<Block> block) {
        return BLOCKS.register(name, block);
    }

    public static void create(IEventBus bus) {
        BLOCKS.register(bus);
    }

    private static BlockBehaviour.Properties copy(Supplier<Block> block) {
        return BlockBehaviour.Properties.copy(block.get());
    }

    private static BlockBehaviour.Properties copy(Block block) {
        return BlockBehaviour.Properties.copy(block);
    }

    private static boolean always(BlockState a, BlockGetter b, BlockPos c) {
        return true;
    }
}
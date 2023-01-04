package net.brdle.veggiedelight.common.block;

import net.brdle.veggiedelight.VeggieDelight;
import net.brdle.veggiedelight.common.item.VDItems;
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
import umpaz.farmersrespite.common.registry.FRItems;
import vectorwing.farmersdelight.common.block.PieBlock;
import vectorwing.farmersdelight.common.registry.ModBlocks;
import java.util.function.Supplier;

public class VDBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, VeggieDelight.MODID);

    public static final RegistryObject<Block> PORTOBELLO = registerBlock("portobello",
        () -> new PortobelloBlock(copy(Blocks.BROWN_MUSHROOM)
            .noCollission().randomTicks().instabreak().sound(SoundType.GRASS).lightLevel((l) -> 1).hasPostProcess(VDBlocks::always)));
    public static final RegistryObject<Block> PORTOBELLO_COLONY = registerBlock("portobello_colony",
        () -> new PortobelloColonyBlock(copy(ModBlocks.BROWN_MUSHROOM_COLONY), VDItems.PORTOBELLO));
    public static final RegistryObject<Block> PORTOBELLO_QUICHE = registerBlock("portobello_quiche",
        () -> new PieBlock(copy(ModBlocks.APPLE_PIE), VDItems.PORTOBELLO_QUICHE_SLICE));
    public static final RegistryObject<Block> LEMON_PIE = registerBlock("lemon_pie",
        () -> new PieBlock(copy(ModBlocks.APPLE_PIE), VDItems.LEMON_PIE_SLICE));
    public static final RegistryObject<Block> LEMON_BUSH = registerBlock("lemon_bush",
        () -> new LemonBushBlock(BlockBehaviour.Properties.of(Material.PLANT).instabreak().sound(SoundType.GRASS).noOcclusion()));
    public static final RegistryObject<Block> SMALL_LEMON_BUSH = registerBlock("small_lemon_bush",
        () -> new SmallLemonBushBlock(BlockBehaviour.Properties.of(Material.PLANT).instabreak().sound(SoundType.GRASS).noOcclusion()));
    public static final RegistryObject<Block> MEDIUM_LEMON_BUSH = registerBlock("medium_lemon_bush",
        () -> new MediumLemonBushBlock(BlockBehaviour.Properties.of(Material.PLANT).instabreak().sound(SoundType.GRASS).noOcclusion()));

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
package net.brdle.veggiedelight.data.gen;

import net.brdle.veggiedelight.Util;
import net.brdle.veggiedelight.VeggieDelight;
import net.brdle.veggiedelight.common.block.PortobelloColonyBlock;
import net.brdle.veggiedelight.common.block.VDBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.common.block.PieBlock;

public class VDBlockStateProvider extends BlockStateProvider {
    public VDBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, VeggieDelight.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        this.pieBlock(VDBlocks.PORTOBELLO_QUICHE);
        this.stageBlock(VDBlocks.PORTOBELLO_COLONY.get(), PortobelloColonyBlock.COLONY_AGE);
        this.simpleBlock(VDBlocks.PORTOBELLO.get(),
            models().cross("block/" + Util.name(VDBlocks.PORTOBELLO),
                VDBlockStateProvider.resourceBlock(Util.name(VDBlocks.PORTOBELLO))).renderType("cutout"));
        this.simpleBlock(VDBlocks.SMALL_LEMON_BUSH.get(), existingModel("small_lemon_bush"));
    }

    // Adapted from: https://github.com/vectorwing/FarmersDelight/blob/1.19/src/main/java/vectorwing/farmersdelight/data/BlockStates.java
    public static ResourceLocation resourceBlock(String path) {
        return Util.rl(VeggieDelight.MODID, "block/" + path);
    }

    public ModelFile existingModel(String path) {
        return new ModelFile.ExistingModelFile(resourceBlock(path), models().existingFileHelper);
    }

    // Adapted from: https://github.com/vectorwing/FarmersDelight/blob/1.19/src/main/java/vectorwing/farmersdelight/data/BlockStates.java
    public void stageBlock(Block block, IntegerProperty ageProperty, Property<?>... ignored) {
        getVariantBuilder(block)
            .forAllStatesExcept(state -> {
                String stageName = Util.name(block) + "_stage" + state.getValue(ageProperty);
                return ConfiguredModel.builder()
                    .modelFile(models().cross(stageName, resourceBlock(stageName)).renderType("cutout")).build();
            }, ignored);
    }

    // Adapted from: https://github.com/vectorwing/FarmersDelight/blob/1.19/src/main/java/vectorwing/farmersdelight/data/BlockStates.java
    public void pieBlock(RegistryObject<Block> block) {
        getVariantBuilder(block.get()).forAllStates(state -> {
            int bites = state.getValue(PieBlock.BITES);
            String suffix = bites > 0 ? "_slice" + bites : "";
            return ConfiguredModel.builder()
                .modelFile(existingModel(block.getId().getPath() + suffix))
                .rotationY(((int) state.getValue(PieBlock.FACING).toYRot() + 180) % 360)
                .build();
            }
        );
    }
}

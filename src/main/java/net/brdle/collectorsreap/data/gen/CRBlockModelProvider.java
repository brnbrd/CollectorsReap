package net.brdle.collectorsreap.data.gen;

import net.brdle.collectorsreap.CollectorsReap;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class CRBlockModelProvider extends BlockModelProvider {
    public CRBlockModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, CollectorsReap.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
    }

    /*public void bush(String name) {
        for (int i = 0; i <= 3; i++) {
            String stage = "block/" + name + "_bush_stage" + i;
            cross(stage, Util.rl(this.modid, stage)).renderType("cutout");
        }
    }

    public void cabinet(String name) {
        orientable(name,
                Util.rl(this.modid, "block/" + name + "_side"),
                Util.rl(this.modid, "block/" + name + "_front"),
                Util.rl(this.modid, "block/" + name + "_top"));
        orientable(name + "_open",
                Util.rl(this.modid, "block/" + name + "_side"),
                Util.rl(this.modid, "block/" + name + "_front_open"),
                Util.rl(this.modid, "block/" + name + "_top"));
    }*/
}
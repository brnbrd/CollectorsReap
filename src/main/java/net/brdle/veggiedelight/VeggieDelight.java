package net.brdle.veggiedelight;

import net.brdle.veggiedelight.common.config.VDConfig;
import net.brdle.veggiedelight.proxy.ClientProxy;
import net.brdle.veggiedelight.proxy.CommonProxy;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(VeggieDelight.MODID)
public class VeggieDelight {
    public static final String MODID = "veggiedelight";
    public static VeggieDelight instance;
    public static CommonProxy proxy;
    private static final Logger LOGGER = LogManager.getLogger();

    public VeggieDelight() {
        instance = this;
        proxy = DistExecutor.safeRunForDist(() -> ClientProxy::new, () -> CommonProxy::new);
        proxy.start();
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, VDConfig.SPEC);
    }

    public static Logger getLogger() {
        return LOGGER;
    }
}

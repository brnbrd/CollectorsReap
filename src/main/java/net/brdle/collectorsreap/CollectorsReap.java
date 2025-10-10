package net.brdle.collectorsreap;

import com.teamabnormals.blueprint.core.util.registry.RegistryHelper;
import net.brdle.collectorsreap.common.config.CRConfig;
import net.brdle.collectorsreap.common.item.CRItemSubRegistryHelper;
import net.brdle.collectorsreap.proxy.ClientProxy;
import net.brdle.collectorsreap.proxy.CommonProxy;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;

@Mod(CollectorsReap.MODID)
public class CollectorsReap {
	public static final String MODID = "collectorsreap";
	public static final RegistryHelper REGISTRY_HELPER = RegistryHelper.create(MODID, helper -> {
		helper.putSubHelper(ForgeRegistries.ITEMS, new CRItemSubRegistryHelper(helper));
	});
	public static CommonProxy proxy;

	public CollectorsReap() {
		final IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
		REGISTRY_HELPER.register(modBus);

		proxy = DistExecutor.safeRunForDist(() -> ClientProxy::new, () -> CommonProxy::new);
		proxy.start();

		ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, CRConfig.COMMON);
	}
}
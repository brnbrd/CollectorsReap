package net.brdle.collectorsreap.compat.jade;

import net.brdle.collectorsreap.common.block.TallBushCropBlock;
import snownee.jade.api.IWailaClientRegistration;
import snownee.jade.api.IWailaCommonRegistration;
import snownee.jade.api.IWailaPlugin;
import snownee.jade.api.WailaPlugin;

@WailaPlugin
public class CRJadePlugin implements IWailaPlugin {
	@Override
	public void register(IWailaCommonRegistration registration) {}

	@Override
	public void registerClient(IWailaClientRegistration registration) {
		registration.registerBlockComponent(CRCropProgress.INSTANCE, TallBushCropBlock.class);
	}
}
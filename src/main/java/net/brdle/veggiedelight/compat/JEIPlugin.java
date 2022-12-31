package net.brdle.veggiedelight.compat;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.registration.IRecipeRegistration;
import net.brdle.veggiedelight.Util;
import net.brdle.veggiedelight.VeggieDelight;
import net.brdle.veggiedelight.common.config.VDConfig;
import net.brdle.veggiedelight.common.item.VDItems;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.function.Predicate;

@JeiPlugin
@ParametersAreNonnullByDefault
@SuppressWarnings("unused")
public class JEIPlugin implements IModPlugin
{
    private static final ResourceLocation ID = Util.rl(VeggieDelight.MODID, "jei_plugin");

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        // Remove all disabled Items from JEI
        var items = VDItems.ITEMS.getEntries().stream()
            .filter(Predicate.not(VDConfig::verify)) // Keep only Items that are not enabled in the config
            .map(Util::gs) // Get ItemStack
            .toList();
        if (!items.isEmpty()) {
            registration.getIngredientManager().removeIngredientsAtRuntime(VanillaTypes.ITEM_STACK, items);
        }
    }

    @Override
    public @NotNull ResourceLocation getPluginUid() {
        return ID;
    }
}
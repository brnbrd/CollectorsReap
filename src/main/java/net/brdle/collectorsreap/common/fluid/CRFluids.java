package net.brdle.collectorsreap.common.fluid;

import net.brdle.collectorsreap.CollectorsReap;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CRFluids {
	public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, CollectorsReap.MODID);
	public static final DeferredRegister<FluidType> TYPES = DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, CollectorsReap.MODID);

	public static final RegistryObject<FluidType> LIME_JUICE_TYPE = TYPES.register("lime_juice_type",
		() -> new DrinkFluidType(0xFF7AD10D));
	public static final RegistryObject<FlowingFluid> LIME_JUICE = FLUIDS.register("lime_juice",
		() -> new ForgeFlowingFluid.Source(CRFluids.LIME_JUICE_PROPERTIES));
	public static final RegistryObject<FlowingFluid> FLOWING_LIME_JUICE = FLUIDS.register("flowing_lime_juice",
		() -> new ForgeFlowingFluid.Flowing(CRFluids.LIME_JUICE_PROPERTIES));
	public static final ForgeFlowingFluid.Properties LIME_JUICE_PROPERTIES = new ForgeFlowingFluid.Properties(
		LIME_JUICE_TYPE,
		LIME_JUICE,
		FLOWING_LIME_JUICE
	);

	public static final RegistryObject<FluidType> STRONG_LIME_JUICE_TYPE = TYPES.register("strong_lime_juice_type",
		() -> new DrinkFluidType(0xFF7AD10D));
	public static final RegistryObject<FlowingFluid> STRONG_LIME_JUICE = FLUIDS.register("strong_lime_juice",
		() -> new ForgeFlowingFluid.Source(CRFluids.STRONG_LIME_JUICE_PROPERTIES));
	public static final RegistryObject<FlowingFluid> FLOWING_STRONG_LIME_JUICE = FLUIDS.register("flowing_strong_lime_juice",
		() -> new ForgeFlowingFluid.Flowing(CRFluids.STRONG_LIME_JUICE_PROPERTIES));
	public static final ForgeFlowingFluid.Properties STRONG_LIME_JUICE_PROPERTIES = new ForgeFlowingFluid.Properties(
		STRONG_LIME_JUICE_TYPE,
		STRONG_LIME_JUICE,
		FLOWING_STRONG_LIME_JUICE
	);

	public static final RegistryObject<FluidType> BERRY_LIMEADE_TYPE = TYPES.register("berry_limeade_type",
		() -> new DrinkFluidType(0xFFE3552A));
	public static final RegistryObject<FlowingFluid> BERRY_LIMEADE = FLUIDS.register("berry_limeade",
		() -> new ForgeFlowingFluid.Source(CRFluids.BERRY_LIMEADE_PROPERTIES));
	public static final RegistryObject<FlowingFluid> FLOWING_BERRY_LIMEADE = FLUIDS.register("flowing_berry_limeade",
		() -> new ForgeFlowingFluid.Flowing(CRFluids.BERRY_LIMEADE_PROPERTIES));
	public static final ForgeFlowingFluid.Properties BERRY_LIMEADE_PROPERTIES = new ForgeFlowingFluid.Properties(
		BERRY_LIMEADE_TYPE,
		BERRY_LIMEADE,
		FLOWING_BERRY_LIMEADE
	);

	public static final RegistryObject<FluidType> PINK_LIMEADE_TYPE = TYPES.register("pink_limeade_type",
		() -> new DrinkFluidType(0xFFFFAB99));
	public static final RegistryObject<FlowingFluid> PINK_LIMEADE = FLUIDS.register("pink_limeade",
		() -> new ForgeFlowingFluid.Source(CRFluids.PINK_LIMEADE_PROPERTIES));
	public static final RegistryObject<FlowingFluid> FLOWING_PINK_LIMEADE = FLUIDS.register("flowing_pink_limeade",
		() -> new ForgeFlowingFluid.Flowing(CRFluids.PINK_LIMEADE_PROPERTIES));
	public static final ForgeFlowingFluid.Properties PINK_LIMEADE_PROPERTIES = new ForgeFlowingFluid.Properties(
		PINK_LIMEADE_TYPE,
		PINK_LIMEADE,
		FLOWING_PINK_LIMEADE
	);

	public static final RegistryObject<FluidType> MINT_LIMEADE_TYPE = TYPES.register("mint_limeade_type",
		() -> new DrinkFluidType(0xFF57E94A));
	public static final RegistryObject<FlowingFluid> MINT_LIMEADE = FLUIDS.register("mint_limeade",
		() -> new ForgeFlowingFluid.Source(CRFluids.MINT_LIMEADE_PROPERTIES));
	public static final RegistryObject<FlowingFluid> FLOWING_MINT_LIMEADE = FLUIDS.register("flowing_mint_limeade",
		() -> new ForgeFlowingFluid.Flowing(CRFluids.MINT_LIMEADE_PROPERTIES));
	public static final ForgeFlowingFluid.Properties MINT_LIMEADE_PROPERTIES = new ForgeFlowingFluid.Properties(
		MINT_LIMEADE_TYPE,
		MINT_LIMEADE,
		FLOWING_MINT_LIMEADE
	);

	public static final RegistryObject<FluidType> LIME_GREEN_TEA_TYPE = TYPES.register("lime_green_tea_type",
		() -> new DrinkFluidType(0xFF95ac38));
	public static final RegistryObject<FlowingFluid> LIME_GREEN_TEA = FLUIDS.register("lime_green_tea",
		() -> new ForgeFlowingFluid.Source(CRFluids.LIME_GREEN_TEA_PROPERTIES));
	public static final RegistryObject<FlowingFluid> FLOWING_LIME_GREEN_TEA = FLUIDS.register("flowing_lime_green_tea",
		() -> new ForgeFlowingFluid.Flowing(CRFluids.LIME_GREEN_TEA_PROPERTIES));
	public static final ForgeFlowingFluid.Properties LIME_GREEN_TEA_PROPERTIES = new ForgeFlowingFluid.Properties(
		LIME_GREEN_TEA_TYPE,
		LIME_GREEN_TEA,
		FLOWING_LIME_GREEN_TEA
	);

	public static final RegistryObject<FluidType> POMEGRANATE_BLACK_TEA_TYPE = TYPES.register("pomegranate_black_tea_type",
		() -> new DrinkFluidType(0xFF900f2f));
	public static final RegistryObject<FlowingFluid> POMEGRANATE_BLACK_TEA = FLUIDS.register("pomegranate_black_tea",
		() -> new ForgeFlowingFluid.Source(CRFluids.POMEGRANATE_BLACK_TEA_PROPERTIES));
	public static final RegistryObject<FlowingFluid> FLOWING_POMEGRANATE_BLACK_TEA = FLUIDS.register("flowing_pomegranate_black_tea",
		() -> new ForgeFlowingFluid.Flowing(CRFluids.POMEGRANATE_BLACK_TEA_PROPERTIES));
	public static final ForgeFlowingFluid.Properties POMEGRANATE_BLACK_TEA_PROPERTIES = new ForgeFlowingFluid.Properties(
		POMEGRANATE_BLACK_TEA_TYPE,
		POMEGRANATE_BLACK_TEA,
		FLOWING_POMEGRANATE_BLACK_TEA
	);

	public static final RegistryObject<FluidType> VERNAL_PURGE_TYPE = TYPES.register("vernal_purge_type",
		() -> new DrinkFluidType(0xFF58421F));
	public static final RegistryObject<FlowingFluid> VERNAL_PURGE = FLUIDS.register("vernal_purge",
		() -> new ForgeFlowingFluid.Source(CRFluids.VERNAL_PURGE_PROPERTIES));
	public static final RegistryObject<FlowingFluid> FLOWING_VERNAL_PURGE = FLUIDS.register("flowing_vernal_purge",
		() -> new ForgeFlowingFluid.Flowing(CRFluids.VERNAL_PURGE_PROPERTIES));
	public static final ForgeFlowingFluid.Properties VERNAL_PURGE_PROPERTIES = new ForgeFlowingFluid.Properties(
		VERNAL_PURGE_TYPE,
		VERNAL_PURGE,
		FLOWING_VERNAL_PURGE
	);

	public static final RegistryObject<FluidType> STRONG_VERNAL_PURGE_TYPE = TYPES.register("strong_vernal_purge_type",
		() -> new DrinkFluidType(0xFF58421F));
	public static final RegistryObject<FlowingFluid> STRONG_VERNAL_PURGE = FLUIDS.register("strong_vernal_purge",
		() -> new ForgeFlowingFluid.Source(CRFluids.STRONG_VERNAL_PURGE_PROPERTIES));
	public static final RegistryObject<FlowingFluid> FLOWING_STRONG_VERNAL_PURGE = FLUIDS.register("flowing_strong_vernal_purge",
		() -> new ForgeFlowingFluid.Flowing(CRFluids.STRONG_VERNAL_PURGE_PROPERTIES));
	public static final ForgeFlowingFluid.Properties STRONG_VERNAL_PURGE_PROPERTIES = new ForgeFlowingFluid.Properties(
		STRONG_VERNAL_PURGE_TYPE,
		STRONG_VERNAL_PURGE,
		FLOWING_STRONG_VERNAL_PURGE
	);

	public static final RegistryObject<FluidType> LIMBO_BREW_TYPE = TYPES.register("limbo_brew_type",
		() -> new DrinkFluidType(0xFF3F1221));
	public static final RegistryObject<FlowingFluid> LIMBO_BREW = FLUIDS.register("limbo_brew",
		() -> new ForgeFlowingFluid.Source(CRFluids.LIMBO_BREW_PROPERTIES));
	public static final RegistryObject<FlowingFluid> FLOWING_LIMBO_BREW = FLUIDS.register("flowing_limbo_brew",
		() -> new ForgeFlowingFluid.Flowing(CRFluids.LIMBO_BREW_PROPERTIES));
	public static final ForgeFlowingFluid.Properties LIMBO_BREW_PROPERTIES = new ForgeFlowingFluid.Properties(
		LIMBO_BREW_TYPE,
		LIMBO_BREW,
		FLOWING_LIMBO_BREW
	);

	public static final RegistryObject<FluidType> LONG_LIMBO_BREW_TYPE = TYPES.register("long_limbo_brew_type",
		() -> new DrinkFluidType(0xFF3F1221));
	public static final RegistryObject<FlowingFluid> LONG_LIMBO_BREW = FLUIDS.register("long_limbo_brew",
		() -> new ForgeFlowingFluid.Source(CRFluids.LONG_LIMBO_BREW_PROPERTIES));
	public static final RegistryObject<FlowingFluid> FLOWING_LONG_LIMBO_BREW = FLUIDS.register("flowing_long_limbo_brew",
		() -> new ForgeFlowingFluid.Flowing(CRFluids.LONG_LIMBO_BREW_PROPERTIES));
	public static final ForgeFlowingFluid.Properties LONG_LIMBO_BREW_PROPERTIES = new ForgeFlowingFluid.Properties(
		LONG_LIMBO_BREW_TYPE,
		LONG_LIMBO_BREW,
		FLOWING_LONG_LIMBO_BREW
	);

	public static final RegistryObject<FluidType> STRONG_LIMBO_BREW_TYPE = TYPES.register("strong_limbo_brew_type",
		() -> new DrinkFluidType(0xFF3F1221));
	public static final RegistryObject<FlowingFluid> STRONG_LIMBO_BREW = FLUIDS.register("strong_limbo_brew",
		() -> new ForgeFlowingFluid.Source(CRFluids.STRONG_LIMBO_BREW_PROPERTIES));
	public static final RegistryObject<FlowingFluid> FLOWING_STRONG_LIMBO_BREW = FLUIDS.register("flowing_strong_limbo_brew",
		() -> new ForgeFlowingFluid.Flowing(CRFluids.STRONG_LIMBO_BREW_PROPERTIES));
	public static final ForgeFlowingFluid.Properties STRONG_LIMBO_BREW_PROPERTIES = new ForgeFlowingFluid.Properties(
		STRONG_LIMBO_BREW_TYPE,
		STRONG_LIMBO_BREW,
		FLOWING_STRONG_LIMBO_BREW
	);

	public static final RegistryObject<FluidType> SWEET_RECOVERY_TYPE = TYPES.register("sweet_recovery_type",
		() -> new DrinkFluidType(0xFF98592A));
	public static final RegistryObject<FlowingFluid> SWEET_RECOVERY = FLUIDS.register("sweet_recovery",
		() -> new ForgeFlowingFluid.Source(CRFluids.SWEET_RECOVERY_PROPERTIES));
	public static final RegistryObject<FlowingFluid> FLOWING_SWEET_RECOVERY = FLUIDS.register("flowing_sweet_recovery",
		() -> new ForgeFlowingFluid.Flowing(CRFluids.SWEET_RECOVERY_PROPERTIES));
	public static final ForgeFlowingFluid.Properties SWEET_RECOVERY_PROPERTIES = new ForgeFlowingFluid.Properties(
		SWEET_RECOVERY_TYPE,
		SWEET_RECOVERY,
		FLOWING_SWEET_RECOVERY
	);

	public static final RegistryObject<FluidType> LONG_SWEET_RECOVERY_TYPE = TYPES.register("long_sweet_recovery_type",
		() -> new DrinkFluidType(0xFF98592A));
	public static final RegistryObject<FlowingFluid> LONG_SWEET_RECOVERY = FLUIDS.register("long_sweet_recovery",
		() -> new ForgeFlowingFluid.Source(CRFluids.LONG_SWEET_RECOVERY_PROPERTIES));
	public static final RegistryObject<FlowingFluid> FLOWING_LONG_SWEET_RECOVERY = FLUIDS.register("flowing_long_sweet_recovery",
		() -> new ForgeFlowingFluid.Flowing(CRFluids.LONG_SWEET_RECOVERY_PROPERTIES));
	public static final ForgeFlowingFluid.Properties LONG_SWEET_RECOVERY_PROPERTIES = new ForgeFlowingFluid.Properties(
		LONG_SWEET_RECOVERY_TYPE,
		LONG_SWEET_RECOVERY,
		FLOWING_LONG_SWEET_RECOVERY
	);

	public static final RegistryObject<FluidType> STRONG_SWEET_RECOVERY_TYPE = TYPES.register("strong_sweet_recovery_type",
		() -> new DrinkFluidType(0xFF98592A));
	public static final RegistryObject<FlowingFluid> STRONG_SWEET_RECOVERY = FLUIDS.register("strong_sweet_recovery",
		() -> new ForgeFlowingFluid.Source(CRFluids.STRONG_SWEET_RECOVERY_PROPERTIES));
	public static final RegistryObject<FlowingFluid> FLOWING_STRONG_SWEET_RECOVERY = FLUIDS.register("flowing_strong_sweet_recovery",
		() -> new ForgeFlowingFluid.Flowing(CRFluids.STRONG_SWEET_RECOVERY_PROPERTIES));
	public static final ForgeFlowingFluid.Properties STRONG_SWEET_RECOVERY_PROPERTIES = new ForgeFlowingFluid.Properties(
		STRONG_SWEET_RECOVERY_TYPE,
		STRONG_SWEET_RECOVERY,
		FLOWING_STRONG_SWEET_RECOVERY
	);

	public static final RegistryObject<FluidType> DEIFIC_BLOOD_TYPE = TYPES.register("deific_blood_type",
		() -> new DrinkFluidType(0xFFac1927));
	public static final RegistryObject<FlowingFluid> DEIFIC_BLOOD = FLUIDS.register("deific_blood",
		() -> new ForgeFlowingFluid.Source(CRFluids.DEIFIC_BLOOD_PROPERTIES));
	public static final RegistryObject<FlowingFluid> FLOWING_DEIFIC_BLOOD = FLUIDS.register("flowing_deific_blood",
		() -> new ForgeFlowingFluid.Flowing(CRFluids.DEIFIC_BLOOD_PROPERTIES));
	public static final ForgeFlowingFluid.Properties DEIFIC_BLOOD_PROPERTIES = new ForgeFlowingFluid.Properties(
		DEIFIC_BLOOD_TYPE,
		DEIFIC_BLOOD,
		FLOWING_DEIFIC_BLOOD
	);

	public static final RegistryObject<FluidType> HERMITS_SOUR_TYPE = TYPES.register("hermits_sour_type",
		() -> new DrinkFluidType(0xFFb5b55c));
	public static final RegistryObject<FlowingFluid> HERMITS_SOUR = FLUIDS.register("hermits_sour",
		() -> new ForgeFlowingFluid.Source(CRFluids.HERMITS_SOUR_PROPERTIES));
	public static final RegistryObject<FlowingFluid> FLOWING_HERMITS_SOUR = FLUIDS.register("flowing_hermits_sour",
		() -> new ForgeFlowingFluid.Flowing(CRFluids.HERMITS_SOUR_PROPERTIES));
	public static final ForgeFlowingFluid.Properties HERMITS_SOUR_PROPERTIES = new ForgeFlowingFluid.Properties(
		HERMITS_SOUR_TYPE,
		HERMITS_SOUR,
		FLOWING_HERMITS_SOUR
	);

	public static final RegistryObject<FluidType> ROSE_MOON_TYPE = TYPES.register("rose_moon_type",
		() -> new DrinkFluidType(0xFF602848));
	public static final RegistryObject<FlowingFluid> ROSE_MOON = FLUIDS.register("rose_moon",
		() -> new ForgeFlowingFluid.Source(CRFluids.ROSE_MOON_PROPERTIES));
	public static final RegistryObject<FlowingFluid> FLOWING_ROSE_MOON = FLUIDS.register("flowing_rose_moon",
		() -> new ForgeFlowingFluid.Flowing(CRFluids.ROSE_MOON_PROPERTIES));
	public static final ForgeFlowingFluid.Properties ROSE_MOON_PROPERTIES = new ForgeFlowingFluid.Properties(
		ROSE_MOON_TYPE,
		ROSE_MOON,
		FLOWING_ROSE_MOON
	);

	public static final RegistryObject<FluidType> REANIMATORS_GARDEN_TYPE = TYPES.register("reanimators_garden_type",
		() -> new DrinkFluidType(0xFFb32600));
	public static final RegistryObject<FlowingFluid> REANIMATORS_GARDEN = FLUIDS.register("reanimators_garden",
		() -> new ForgeFlowingFluid.Source(CRFluids.REANIMATORS_GARDEN_PROPERTIES));
	public static final RegistryObject<FlowingFluid> FLOWING_REANIMATORS_GARDEN = FLUIDS.register("flowing_reanimators_garden",
		() -> new ForgeFlowingFluid.Flowing(CRFluids.REANIMATORS_GARDEN_PROPERTIES));
	public static final ForgeFlowingFluid.Properties REANIMATORS_GARDEN_PROPERTIES = new ForgeFlowingFluid.Properties(
		REANIMATORS_GARDEN_TYPE,
		REANIMATORS_GARDEN,
		FLOWING_REANIMATORS_GARDEN
	);

	public static final RegistryObject<FluidType> HEAVENS_CREAM_TYPE = TYPES.register("heavens_cream_type",
		() -> new DrinkFluidType(0xFFFACF6F));
	public static final RegistryObject<FlowingFluid> HEAVENS_CREAM = FLUIDS.register("heavens_cream",
		() -> new ForgeFlowingFluid.Source(CRFluids.HEAVENS_CREAM_PROPERTIES));
	public static final RegistryObject<FlowingFluid> FLOWING_HEAVENS_CREAM = FLUIDS.register("flowing_heavens_cream",
		() -> new ForgeFlowingFluid.Flowing(CRFluids.HEAVENS_CREAM_PROPERTIES));
	public static final ForgeFlowingFluid.Properties HEAVENS_CREAM_PROPERTIES = new ForgeFlowingFluid.Properties(
		HEAVENS_CREAM_TYPE,
		HEAVENS_CREAM,
		FLOWING_HEAVENS_CREAM
	);

	public static final RegistryObject<FluidType> CREAM_CHEESE_TYPE = TYPES.register("cream_cheese_type",
		CreamCheeseFluidType::new);
	public static final RegistryObject<FlowingFluid> CREAM_CHEESE = FLUIDS.register("cream_cheese",
		() -> new ForgeFlowingFluid.Source(CRFluids.CREAM_CHEESE_PROPERTIES));
	public static final RegistryObject<FlowingFluid> FLOWING_CREAM_CHEESE = FLUIDS.register("flowing_cream_cheese",
		() -> new ForgeFlowingFluid.Flowing(CRFluids.CREAM_CHEESE_PROPERTIES));
	public static final ForgeFlowingFluid.Properties CREAM_CHEESE_PROPERTIES = new ForgeFlowingFluid.Properties(
		CREAM_CHEESE_TYPE,
		CREAM_CHEESE,
		FLOWING_CREAM_CHEESE
	);

	public static void create(IEventBus bus) {
		FLUIDS.register(bus);
		TYPES.register(bus);
	}
}
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

	public static void create(IEventBus bus) {
		FLUIDS.register(bus);
		TYPES.register(bus);
	}
}
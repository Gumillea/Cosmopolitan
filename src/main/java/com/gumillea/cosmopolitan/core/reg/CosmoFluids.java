package com.gumillea.cosmopolitan.core.reg;

import com.gumillea.cosmopolitan.Cosmopolitan;
import com.gumillea.cosmopolitan.common.fluid.CosmoIceCreamFluidType;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CosmoFluids {
    public static final DeferredRegister<FluidType> FLUID_TYPES = DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, Cosmopolitan.MODID);
    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, Cosmopolitan.MODID);

    public static final RegistryObject<FluidType> VANILLA_ICE_CREAM_TYPE = FLUID_TYPES.register("vanilla_ice_cream", () -> new CosmoIceCreamFluidType("vanilla"));
    public static final RegistryObject<FlowingFluid> VANILLA_ICE_CREAM = FLUIDS.register("vanilla_ice_cream", () -> new ForgeFlowingFluid.Source(CosmoFluids.VANILLA_ICE_CREAM_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_VANILLA_ICE_CREAM = FLUIDS.register("flowing_vanilla_ice_cream", () -> new ForgeFlowingFluid.Flowing(CosmoFluids.VANILLA_ICE_CREAM_PROPERTIES));
    public static final ForgeFlowingFluid.Properties VANILLA_ICE_CREAM_PROPERTIES = new ForgeFlowingFluid.Properties(VANILLA_ICE_CREAM_TYPE, VANILLA_ICE_CREAM, FLOWING_VANILLA_ICE_CREAM);

    public static final RegistryObject<FluidType> STRAWBERRY_ICE_CREAM_TYPE = FLUID_TYPES.register("strawberry_ice_cream", () -> new CosmoIceCreamFluidType("strawberry"));
    public static final RegistryObject<FlowingFluid> STRAWBERRY_ICE_CREAM = FLUIDS.register("strawberry_ice_cream", () -> new ForgeFlowingFluid.Source(CosmoFluids.STRAWBERRY_ICE_CREAM_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_STRAWBERRY_ICE_CREAM = FLUIDS.register("flowing_strawberry_ice_cream", () -> new ForgeFlowingFluid.Flowing(CosmoFluids.VANILLA_ICE_CREAM_PROPERTIES));
    public static final ForgeFlowingFluid.Properties STRAWBERRY_ICE_CREAM_PROPERTIES = new ForgeFlowingFluid.Properties(STRAWBERRY_ICE_CREAM_TYPE, STRAWBERRY_ICE_CREAM, FLOWING_STRAWBERRY_ICE_CREAM);
}

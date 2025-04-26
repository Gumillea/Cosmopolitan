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

    //neapolitan
    public static final RegistryObject<FluidType> VANILLA_ICE_CREAM_TYPE = FLUID_TYPES.register("vanilla_ice_cream", () -> new CosmoIceCreamFluidType("vanilla"));
    public static final RegistryObject<FlowingFluid> VANILLA_ICE_CREAM = FLUIDS.register("vanilla_ice_cream", () -> new ForgeFlowingFluid.Source(CosmoFluids.VANILLA_ICE_CREAM_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_VANILLA_ICE_CREAM = FLUIDS.register("flowing_vanilla_ice_cream", () -> new ForgeFlowingFluid.Flowing(CosmoFluids.VANILLA_ICE_CREAM_PROPERTIES));
    public static final ForgeFlowingFluid.Properties VANILLA_ICE_CREAM_PROPERTIES = new ForgeFlowingFluid.Properties(VANILLA_ICE_CREAM_TYPE, VANILLA_ICE_CREAM, FLOWING_VANILLA_ICE_CREAM);

    public static final RegistryObject<FluidType> STRAWBERRY_ICE_CREAM_TYPE = FLUID_TYPES.register("strawberry_ice_cream", () -> new CosmoIceCreamFluidType("strawberry"));
    public static final RegistryObject<FlowingFluid> STRAWBERRY_ICE_CREAM = FLUIDS.register("strawberry_ice_cream", () -> new ForgeFlowingFluid.Source(CosmoFluids.STRAWBERRY_ICE_CREAM_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_STRAWBERRY_ICE_CREAM = FLUIDS.register("flowing_strawberry_ice_cream", () -> new ForgeFlowingFluid.Flowing(CosmoFluids.VANILLA_ICE_CREAM_PROPERTIES));
    public static final ForgeFlowingFluid.Properties STRAWBERRY_ICE_CREAM_PROPERTIES = new ForgeFlowingFluid.Properties(STRAWBERRY_ICE_CREAM_TYPE, STRAWBERRY_ICE_CREAM, FLOWING_STRAWBERRY_ICE_CREAM);

    public static final RegistryObject<FluidType> CHOCOLATE_ICE_CREAM_TYPE = FLUID_TYPES.register("chocolate_ice_cream", () -> new CosmoIceCreamFluidType("chocolate"));
    public static final RegistryObject<FlowingFluid> CHOCOLATE_ICE_CREAM = FLUIDS.register("chocolate_ice_cream", () -> new ForgeFlowingFluid.Source(CosmoFluids.CHOCOLATE_ICE_CREAM_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_CHOCOLATE_ICE_CREAM = FLUIDS.register("flowing_chocolate_ice_cream", () -> new ForgeFlowingFluid.Flowing(CosmoFluids.CHOCOLATE_ICE_CREAM_PROPERTIES));
    public static final ForgeFlowingFluid.Properties CHOCOLATE_ICE_CREAM_PROPERTIES = new ForgeFlowingFluid.Properties(CHOCOLATE_ICE_CREAM_TYPE, CHOCOLATE_ICE_CREAM, FLOWING_CHOCOLATE_ICE_CREAM);

    public static final RegistryObject<FluidType> MINT_ICE_CREAM_TYPE = FLUID_TYPES.register("mint_ice_cream", () -> new CosmoIceCreamFluidType("mint"));
    public static final RegistryObject<FlowingFluid> MINT_ICE_CREAM = FLUIDS.register("mint_ice_cream", () -> new ForgeFlowingFluid.Source(CosmoFluids.MINT_ICE_CREAM_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_MINT_ICE_CREAM = FLUIDS.register("flowing_mint_ice_cream", () -> new ForgeFlowingFluid.Flowing(CosmoFluids.MINT_ICE_CREAM_PROPERTIES));
    public static final ForgeFlowingFluid.Properties MINT_ICE_CREAM_PROPERTIES = new ForgeFlowingFluid.Properties(MINT_ICE_CREAM_TYPE, MINT_ICE_CREAM, FLOWING_MINT_ICE_CREAM);

    public static final RegistryObject<FluidType> ADZUKI_ICE_CREAM_TYPE = FLUID_TYPES.register("adzuki_ice_cream", () -> new CosmoIceCreamFluidType("adzuki"));
    public static final RegistryObject<FlowingFluid> ADZUKI_ICE_CREAM = FLUIDS.register("adzuki_ice_cream", () -> new ForgeFlowingFluid.Source(CosmoFluids.ADZUKI_ICE_CREAM_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_ADZUKI_ICE_CREAM = FLUIDS.register("flowing_adzuki_ice_cream", () -> new ForgeFlowingFluid.Flowing(CosmoFluids.ADZUKI_ICE_CREAM_PROPERTIES));
    public static final ForgeFlowingFluid.Properties ADZUKI_ICE_CREAM_PROPERTIES = new ForgeFlowingFluid.Properties(ADZUKI_ICE_CREAM_TYPE, ADZUKI_ICE_CREAM, FLOWING_ADZUKI_ICE_CREAM);

    public static final RegistryObject<FluidType> BANANA_ICE_CREAM_TYPE = FLUID_TYPES.register("banana_ice_cream", () -> new CosmoIceCreamFluidType("banana"));
    public static final RegistryObject<FlowingFluid> BANANA_ICE_CREAM = FLUIDS.register("banana_ice_cream", () -> new ForgeFlowingFluid.Source(CosmoFluids.BANANA_ICE_CREAM_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_BANANA_ICE_CREAM = FLUIDS.register("flowing_banana_ice_cream", () -> new ForgeFlowingFluid.Flowing(CosmoFluids.BANANA_ICE_CREAM_PROPERTIES));
    public static final ForgeFlowingFluid.Properties BANANA_ICE_CREAM_PROPERTIES = new ForgeFlowingFluid.Properties(BANANA_ICE_CREAM_TYPE, BANANA_ICE_CREAM, FLOWING_BANANA_ICE_CREAM);
    //vanilla
    public static final RegistryObject<FluidType> APPLE_ICE_CREAM_TYPE = FLUID_TYPES.register("apple_ice_cream", () -> new CosmoIceCreamFluidType("apple"));
    public static final RegistryObject<FlowingFluid> APPLE_ICE_CREAM = FLUIDS.register("apple_ice_cream", () -> new ForgeFlowingFluid.Source(CosmoFluids.APPLE_ICE_CREAM_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_APPLE_ICE_CREAM = FLUIDS.register("flowing_apple_ice_cream", () -> new ForgeFlowingFluid.Flowing(CosmoFluids.APPLE_ICE_CREAM_PROPERTIES));
    public static final ForgeFlowingFluid.Properties APPLE_ICE_CREAM_PROPERTIES = new ForgeFlowingFluid.Properties(APPLE_ICE_CREAM_TYPE, APPLE_ICE_CREAM, FLOWING_APPLE_ICE_CREAM);

    public static final RegistryObject<FluidType> CARROT_ICE_CREAM_TYPE = FLUID_TYPES.register("carrot_ice_cream", () -> new CosmoIceCreamFluidType("carrot"));
    public static final RegistryObject<FlowingFluid> CARROT_ICE_CREAM = FLUIDS.register("carrot_ice_cream", () -> new ForgeFlowingFluid.Source(CosmoFluids.CARROT_ICE_CREAM_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_CARROT_ICE_CREAM = FLUIDS.register("flowing_carrot_ice_cream", () -> new ForgeFlowingFluid.Flowing(CosmoFluids.CARROT_ICE_CREAM_PROPERTIES));
    public static final ForgeFlowingFluid.Properties CARROT_ICE_CREAM_PROPERTIES = new ForgeFlowingFluid.Properties(CARROT_ICE_CREAM_TYPE, CARROT_ICE_CREAM, FLOWING_CARROT_ICE_CREAM);

    public static final RegistryObject<FluidType> GLOW_BERRY_ICE_CREAM_TYPE = FLUID_TYPES.register("glow_berry_ice_cream", () -> new CosmoIceCreamFluidType("glow_berry"));
    public static final RegistryObject<FlowingFluid> GLOW_BERRY_ICE_CREAM = FLUIDS.register("glow_berry_ice_cream", () -> new ForgeFlowingFluid.Source(CosmoFluids.GLOW_BERRY_ICE_CREAM_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_GLOW_BERRY_ICE_CREAM = FLUIDS.register("flowing_glow_berry_ice_cream", () -> new ForgeFlowingFluid.Flowing(CosmoFluids.GLOW_BERRY_ICE_CREAM_PROPERTIES));
    public static final ForgeFlowingFluid.Properties GLOW_BERRY_ICE_CREAM_PROPERTIES = new ForgeFlowingFluid.Properties(GLOW_BERRY_ICE_CREAM_TYPE, GLOW_BERRY_ICE_CREAM, FLOWING_GLOW_BERRY_ICE_CREAM);
    //peculiars
    public static final RegistryObject<FluidType> ALOE_ICE_CREAM_TYPE = FLUID_TYPES.register("aloe_ice_cream", () -> new CosmoIceCreamFluidType("aloe"));
    public static final RegistryObject<FlowingFluid> ALOE_ICE_CREAM = FLUIDS.register("aloe_ice_cream", () -> new ForgeFlowingFluid.Source(CosmoFluids.ALOE_ICE_CREAM_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_ALOE_ICE_CREAM = FLUIDS.register("flowing_aloe_ice_cream", () -> new ForgeFlowingFluid.Flowing(CosmoFluids.ALOE_ICE_CREAM_PROPERTIES));
    public static final ForgeFlowingFluid.Properties ALOE_ICE_CREAM_PROPERTIES = new ForgeFlowingFluid.Properties(ALOE_ICE_CREAM_TYPE, ALOE_ICE_CREAM, FLOWING_ALOE_ICE_CREAM);

    public static final RegistryObject<FluidType> PASSION_FRUIT_ICE_CREAM_TYPE = FLUID_TYPES.register("passion_fruit_ice_cream", () -> new CosmoIceCreamFluidType("passion_fruit"));
    public static final RegistryObject<FlowingFluid> PASSION_FRUIT_ICE_CREAM = FLUIDS.register("passion_fruit_ice_cream", () -> new ForgeFlowingFluid.Source(CosmoFluids.PASSION_FRUIT_ICE_CREAM_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_PASSION_FRUIT_ICE_CREAM = FLUIDS.register("flowing_passion_fruit_ice_cream", () -> new ForgeFlowingFluid.Flowing(CosmoFluids.PASSION_FRUIT_ICE_CREAM_PROPERTIES));
    public static final ForgeFlowingFluid.Properties PASSION_FRUIT_ICE_CREAM_PROPERTIES = new ForgeFlowingFluid.Properties(PASSION_FRUIT_ICE_CREAM_TYPE, PASSION_FRUIT_ICE_CREAM, FLOWING_PASSION_FRUIT_ICE_CREAM);

    public static final RegistryObject<FluidType> YUCCA_ICE_CREAM_TYPE = FLUID_TYPES.register("yucca_ice_cream", () -> new CosmoIceCreamFluidType("yucca"));
    public static final RegistryObject<FlowingFluid> YUCCA_ICE_CREAM = FLUIDS.register("yucca_ice_cream", () -> new ForgeFlowingFluid.Source(CosmoFluids.YUCCA_ICE_CREAM_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_YUCCA_ICE_CREAM = FLUIDS.register("flowing_yucca_ice_cream", () -> new ForgeFlowingFluid.Flowing(CosmoFluids.YUCCA_ICE_CREAM_PROPERTIES));
    public static final ForgeFlowingFluid.Properties YUCCA_ICE_CREAM_PROPERTIES = new ForgeFlowingFluid.Properties(YUCCA_ICE_CREAM_TYPE, YUCCA_ICE_CREAM, FLOWING_YUCCA_ICE_CREAM);
    //seasonals
    public static final RegistryObject<FluidType> BEETROOT_ICE_CREAM_TYPE = FLUID_TYPES.register("beetroot_ice_cream", () -> new CosmoIceCreamFluidType("beetroot"));
    public static final RegistryObject<FlowingFluid> BEETROOT_ICE_CREAM = FLUIDS.register("beetroot_ice_cream", () -> new ForgeFlowingFluid.Source(CosmoFluids.BEETROOT_ICE_CREAM_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_BEETROOT_ICE_CREAM = FLUIDS.register("flowing_beetroot_ice_cream", () -> new ForgeFlowingFluid.Flowing(CosmoFluids.BEETROOT_ICE_CREAM_PROPERTIES));
    public static final ForgeFlowingFluid.Properties BEETROOT_ICE_CREAM_PROPERTIES = new ForgeFlowingFluid.Properties(BEETROOT_ICE_CREAM_TYPE, BEETROOT_ICE_CREAM, FLOWING_BEETROOT_ICE_CREAM);

    public static final RegistryObject<FluidType> SWEET_BERRY_ICE_CREAM_TYPE = FLUID_TYPES.register("sweet_berry_ice_cream", () -> new CosmoIceCreamFluidType("sweet_berry"));
    public static final RegistryObject<FlowingFluid> SWEET_BERRY_ICE_CREAM = FLUIDS.register("sweet_berry_ice_cream", () -> new ForgeFlowingFluid.Source(CosmoFluids.SWEET_BERRY_ICE_CREAM_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_SWEET_BERRY_ICE_CREAM = FLUIDS.register("flowing_sweet_berry_ice_cream", () -> new ForgeFlowingFluid.Flowing(CosmoFluids.SWEET_BERRY_ICE_CREAM_PROPERTIES));
    public static final ForgeFlowingFluid.Properties SWEET_BERRY_ICE_CREAM_PROPERTIES = new ForgeFlowingFluid.Properties(SWEET_BERRY_ICE_CREAM_TYPE, SWEET_BERRY_ICE_CREAM, FLOWING_SWEET_BERRY_ICE_CREAM);

    public static final RegistryObject<FluidType> PUMPKIN_ICE_CREAM_TYPE = FLUID_TYPES.register("pumpkin_ice_cream", () -> new CosmoIceCreamFluidType("pumpkin"));
    public static final RegistryObject<FlowingFluid> PUMPKIN_ICE_CREAM = FLUIDS.register("pumpkin_ice_cream", () -> new ForgeFlowingFluid.Source(CosmoFluids.PUMPKIN_ICE_CREAM_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_PUMPKIN_ICE_CREAM = FLUIDS.register("flowing_pumpkin_ice_cream", () -> new ForgeFlowingFluid.Flowing(CosmoFluids.PUMPKIN_ICE_CREAM_PROPERTIES));
    public static final ForgeFlowingFluid.Properties PUMPKIN_ICE_CREAM_PROPERTIES = new ForgeFlowingFluid.Properties(PUMPKIN_ICE_CREAM_TYPE, PUMPKIN_ICE_CREAM, FLOWING_PUMPKIN_ICE_CREAM);
    //cr
    public static final RegistryObject<FluidType> LIME_ICE_CREAM_TYPE = FLUID_TYPES.register("lime_ice_cream", () -> new CosmoIceCreamFluidType("lime"));
    public static final RegistryObject<FlowingFluid> LIME_ICE_CREAM = FLUIDS.register("lime_ice_cream", () -> new ForgeFlowingFluid.Source(CosmoFluids.LIME_ICE_CREAM_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_LIME_ICE_CREAM = FLUIDS.register("flowing_lime_ice_cream", () -> new ForgeFlowingFluid.Flowing(CosmoFluids.LIME_ICE_CREAM_PROPERTIES));
    public static final ForgeFlowingFluid.Properties LIME_ICE_CREAM_PROPERTIES = new ForgeFlowingFluid.Properties(LIME_ICE_CREAM_TYPE, LIME_ICE_CREAM, FLOWING_LIME_ICE_CREAM);

    public static final RegistryObject<FluidType> POMEGRANATE_ICE_CREAM_TYPE = FLUID_TYPES.register("pomegranate_ice_cream", () -> new CosmoIceCreamFluidType("pomegranate"));
    public static final RegistryObject<FlowingFluid> POMEGRANATE_ICE_CREAM = FLUIDS.register("pomegranate_ice_cream", () -> new ForgeFlowingFluid.Source(CosmoFluids.POMEGRANATE_ICE_CREAM_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_POMEGRANATE_ICE_CREAM = FLUIDS.register("flowing_pomegranate_ice_cream", () -> new ForgeFlowingFluid.Flowing(CosmoFluids.POMEGRANATE_ICE_CREAM_PROPERTIES));
    public static final ForgeFlowingFluid.Properties POMEGRANATE_ICE_CREAM_PROPERTIES = new ForgeFlowingFluid.Properties(POMEGRANATE_ICE_CREAM_TYPE, POMEGRANATE_ICE_CREAM, FLOWING_POMEGRANATE_ICE_CREAM);
    //delightful
    public static final RegistryObject<FluidType> MATCHA_ICE_CREAM_TYPE = FLUID_TYPES.register("matcha_ice_cream", () -> new CosmoIceCreamFluidType("matcha"));
    public static final RegistryObject<FlowingFluid> MATCHA_ICE_CREAM = FLUIDS.register("matcha_ice_cream", () -> new ForgeFlowingFluid.Source(CosmoFluids.MATCHA_ICE_CREAM_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_MATCHA_ICE_CREAM = FLUIDS.register("flowing_matcha_ice_cream", () -> new ForgeFlowingFluid.Flowing(CosmoFluids.MATCHA_ICE_CREAM_PROPERTIES));
    public static final ForgeFlowingFluid.Properties MATCHA_ICE_CREAM_PROPERTIES = new ForgeFlowingFluid.Properties(MATCHA_ICE_CREAM_TYPE, MATCHA_ICE_CREAM, FLOWING_MATCHA_ICE_CREAM);

    public static final RegistryObject<FluidType> SALMONBERRY_ICE_CREAM_TYPE = FLUID_TYPES.register("salmonberry_ice_cream", () -> new CosmoIceCreamFluidType("salmonberry"));
    public static final RegistryObject<FlowingFluid> SALMONBERRY_ICE_CREAM = FLUIDS.register("salmonberry_ice_cream", () -> new ForgeFlowingFluid.Source(CosmoFluids.SALMONBERRY_ICE_CREAM_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_SALMONBERRY_ICE_CREAM = FLUIDS.register("flowing_salmonberry_ice_cream", () -> new ForgeFlowingFluid.Flowing(CosmoFluids.SALMONBERRY_ICE_CREAM_PROPERTIES));
    public static final ForgeFlowingFluid.Properties SALMONBERRY_ICE_CREAM_PROPERTIES = new ForgeFlowingFluid.Properties(SALMONBERRY_ICE_CREAM_TYPE, SALMONBERRY_ICE_CREAM, FLOWING_SALMONBERRY_ICE_CREAM);
    //exquisito
    public static final RegistryObject<FluidType> CHORUS_FRUIT_ICE_CREAM_TYPE = FLUID_TYPES.register("chorus_fruit_ice_cream", () -> new CosmoIceCreamFluidType("chorus_fruit"));
    public static final RegistryObject<FlowingFluid> CHORUS_FRUIT_ICE_CREAM = FLUIDS.register("chorus_fruit_ice_cream", () -> new ForgeFlowingFluid.Source(CosmoFluids.CHORUS_FRUIT_ICE_CREAM_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_CHORUS_FRUIT_ICE_CREAM = FLUIDS.register("flowing_chorus_fruit_ice_cream", () -> new ForgeFlowingFluid.Flowing(CosmoFluids.CHORUS_FRUIT_ICE_CREAM_PROPERTIES));
    public static final ForgeFlowingFluid.Properties CHORUS_FRUIT_ICE_CREAM_PROPERTIES = new ForgeFlowingFluid.Properties(CHORUS_FRUIT_ICE_CREAM_TYPE, CHORUS_FRUIT_ICE_CREAM, FLOWING_CHORUS_FRUIT_ICE_CREAM);

    public static final RegistryObject<FluidType> WARZIPAN_ICE_CREAM_TYPE = FLUID_TYPES.register("warzipan_ice_cream", () -> new CosmoIceCreamFluidType("warzipan"));
    public static final RegistryObject<FlowingFluid> WARZIPAN_ICE_CREAM = FLUIDS.register("warzipan_ice_cream", () -> new ForgeFlowingFluid.Source(CosmoFluids.WARZIPAN_ICE_CREAM_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_WARZIPAN_ICE_CREAM = FLUIDS.register("flowing_warzipan_ice_cream", () -> new ForgeFlowingFluid.Flowing(CosmoFluids.WARZIPAN_ICE_CREAM_PROPERTIES));
    public static final ForgeFlowingFluid.Properties WARZIPAN_ICE_CREAM_PROPERTIES = new ForgeFlowingFluid.Properties(WARZIPAN_ICE_CREAM_TYPE, WARZIPAN_ICE_CREAM, FLOWING_WARZIPAN_ICE_CREAM);

    public static final RegistryObject<FluidType> JELLY_RING_ICE_CREAM_TYPE = FLUID_TYPES.register("jelly_ring_ice_cream", () -> new CosmoIceCreamFluidType("jelly_ring"));
    public static final RegistryObject<FlowingFluid> JELLY_RING_ICE_CREAM = FLUIDS.register("jelly_ring_ice_cream", () -> new ForgeFlowingFluid.Source(CosmoFluids.JELLY_RING_ICE_CREAM_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_JELLY_RING_ICE_CREAM = FLUIDS.register("flowing_jelly_ring_ice_cream", () -> new ForgeFlowingFluid.Flowing(CosmoFluids.JELLY_RING_ICE_CREAM_PROPERTIES));
    public static final ForgeFlowingFluid.Properties JELLY_RING_ICE_CREAM_PROPERTIES = new ForgeFlowingFluid.Properties(JELLY_RING_ICE_CREAM_TYPE, JELLY_RING_ICE_CREAM, FLOWING_JELLY_RING_ICE_CREAM);

    public static final RegistryObject<FluidType> AZURE_BERRY_ICE_CREAM_TYPE = FLUID_TYPES.register("azure_berry_ice_cream", () -> new CosmoIceCreamFluidType("azure_berry"));
    public static final RegistryObject<FlowingFluid> AZURE_BERRY_ICE_CREAM = FLUIDS.register("azure_berry_ice_cream", () -> new ForgeFlowingFluid.Source(CosmoFluids.AZURE_BERRY_ICE_CREAM_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_AZURE_BERRY_ICE_CREAM = FLUIDS.register("flowing_azure_berry_ice_cream", () -> new ForgeFlowingFluid.Flowing(CosmoFluids.AZURE_BERRY_ICE_CREAM_PROPERTIES));
    public static final ForgeFlowingFluid.Properties AZURE_BERRY_ICE_CREAM_PROPERTIES = new ForgeFlowingFluid.Properties(AZURE_BERRY_ICE_CREAM_TYPE, AZURE_BERRY_ICE_CREAM, FLOWING_AZURE_BERRY_ICE_CREAM);

    public static final RegistryObject<FluidType> MIDNIGHT_ICE_CREAM_TYPE = FLUID_TYPES.register("midnight_ice_cream", () -> new CosmoIceCreamFluidType("midnight"));
    public static final RegistryObject<FlowingFluid> MIDNIGHT_ICE_CREAM = FLUIDS.register("midnight_ice_cream", () -> new ForgeFlowingFluid.Source(CosmoFluids.MIDNIGHT_ICE_CREAM_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_MIDNIGHT_ICE_CREAM = FLUIDS.register("flowing_midnight_ice_cream", () -> new ForgeFlowingFluid.Flowing(CosmoFluids.MIDNIGHT_ICE_CREAM_PROPERTIES));
    public static final ForgeFlowingFluid.Properties MIDNIGHT_ICE_CREAM_PROPERTIES = new ForgeFlowingFluid.Properties(MIDNIGHT_ICE_CREAM_TYPE, MIDNIGHT_ICE_CREAM, FLOWING_MIDNIGHT_ICE_CREAM);

    public static final RegistryObject<FluidType> STARCLOUD_ICE_CREAM_TYPE = FLUID_TYPES.register("starcloud_ice_cream", () -> new CosmoIceCreamFluidType("starcloud"));
    public static final RegistryObject<FlowingFluid> STARCLOUD_ICE_CREAM = FLUIDS.register("starcloud_ice_cream", () -> new ForgeFlowingFluid.Source(CosmoFluids.STARCLOUD_ICE_CREAM_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_STARCLOUD_ICE_CREAM = FLUIDS.register("flowing_starcloud_ice_cream", () -> new ForgeFlowingFluid.Flowing(CosmoFluids.STARCLOUD_ICE_CREAM_PROPERTIES));
    public static final ForgeFlowingFluid.Properties STARCLOUD_ICE_CREAM_PROPERTIES = new ForgeFlowingFluid.Properties(STARCLOUD_ICE_CREAM_TYPE, STARCLOUD_ICE_CREAM, FLOWING_STARCLOUD_ICE_CREAM);
    //twilight_delight
    public static final RegistryObject<FluidType> AURORA_ICE_CREAM_TYPE = FLUID_TYPES.register("aurora_ice_cream", () -> new CosmoIceCreamFluidType("aurora"));
    public static final RegistryObject<FlowingFluid> AURORA_ICE_CREAM = FLUIDS.register("aurora_ice_cream", () -> new ForgeFlowingFluid.Source(CosmoFluids.AURORA_ICE_CREAM_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_AURORA_ICE_CREAM = FLUIDS.register("flowing_aurora_ice_cream", () -> new ForgeFlowingFluid.Flowing(CosmoFluids.VANILLA_ICE_CREAM_PROPERTIES));
    public static final ForgeFlowingFluid.Properties AURORA_ICE_CREAM_PROPERTIES = new ForgeFlowingFluid.Properties(AURORA_ICE_CREAM_TYPE, AURORA_ICE_CREAM, FLOWING_AURORA_ICE_CREAM);

    public static final RegistryObject<FluidType> GLACIER_ICE_CREAM_TYPE = FLUID_TYPES.register("glacier_ice_cream", () -> new CosmoIceCreamFluidType("glacier"));
    public static final RegistryObject<FlowingFluid> GLACIER_ICE_CREAM = FLUIDS.register("glacier_ice_cream", () -> new ForgeFlowingFluid.Source(CosmoFluids.GLACIER_ICE_CREAM_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_GLACIER_ICE_CREAM = FLUIDS.register("flowing_glacier_ice_cream", () -> new ForgeFlowingFluid.Flowing(CosmoFluids.VANILLA_ICE_CREAM_PROPERTIES));
    public static final ForgeFlowingFluid.Properties GLACIER_ICE_CREAM_PROPERTIES = new ForgeFlowingFluid.Properties(GLACIER_ICE_CREAM_TYPE, GLACIER_ICE_CREAM, FLOWING_GLACIER_ICE_CREAM);

    public static final RegistryObject<FluidType> PHYTOCHEMICAL_ICE_CREAM_TYPE = FLUID_TYPES.register("phytochemical_ice_cream", () -> new CosmoIceCreamFluidType("phytochemical"));
    public static final RegistryObject<FlowingFluid> PHYTOCHEMICAL_ICE_CREAM = FLUIDS.register("phytochemical_ice_cream", () -> new ForgeFlowingFluid.Source(CosmoFluids.PHYTOCHEMICAL_ICE_CREAM_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_PHYTOCHEMICAL_ICE_CREAM = FLUIDS.register("flowing_phytochemical_ice_cream", () -> new ForgeFlowingFluid.Flowing(CosmoFluids.VANILLA_ICE_CREAM_PROPERTIES));
    public static final ForgeFlowingFluid.Properties PHYTOCHEMICAL_ICE_CREAM_PROPERTIES = new ForgeFlowingFluid.Properties(PHYTOCHEMICAL_ICE_CREAM_TYPE, PHYTOCHEMICAL_ICE_CREAM, FLOWING_PHYTOCHEMICAL_ICE_CREAM);

    public static final RegistryObject<FluidType> TORCHBERRY_ICE_CREAM_TYPE = FLUID_TYPES.register("torchberry_ice_cream", () -> new CosmoIceCreamFluidType("torchberry"));
    public static final RegistryObject<FlowingFluid> TORCHBERRY_ICE_CREAM = FLUIDS.register("torchberry_ice_cream", () -> new ForgeFlowingFluid.Source(CosmoFluids.TORCHBERRY_ICE_CREAM_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_TORCHBERRY_ICE_CREAM = FLUIDS.register("flowing_torchberry_ice_cream", () -> new ForgeFlowingFluid.Flowing(CosmoFluids.VANILLA_ICE_CREAM_PROPERTIES));
    public static final ForgeFlowingFluid.Properties TORCHBERRY_ICE_CREAM_PROPERTIES = new ForgeFlowingFluid.Properties(TORCHBERRY_ICE_CREAM_TYPE, TORCHBERRY_ICE_CREAM, FLOWING_TORCHBERRY_ICE_CREAM);
    //habitat
    public static final RegistryObject<FluidType> KABLOOM_ICE_CREAM_TYPE = FLUID_TYPES.register("kabloom_ice_cream", () -> new CosmoIceCreamFluidType("kabloom"));
    public static final RegistryObject<FlowingFluid> KABLOOM_ICE_CREAM = FLUIDS.register("kabloom_ice_cream", () -> new ForgeFlowingFluid.Source(CosmoFluids.KABLOOM_ICE_CREAM_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_KABLOOM_ICE_CREAM = FLUIDS.register("flowing_kabloom_ice_cream", () -> new ForgeFlowingFluid.Flowing(CosmoFluids.KABLOOM_ICE_CREAM_PROPERTIES));
    public static final ForgeFlowingFluid.Properties KABLOOM_ICE_CREAM_PROPERTIES = new ForgeFlowingFluid.Properties(KABLOOM_ICE_CREAM_TYPE, KABLOOM_ICE_CREAM, FLOWING_KABLOOM_ICE_CREAM);
    //an
    public static final RegistryObject<FluidType> SOURCE_BERRY_ICE_CREAM_TYPE = FLUID_TYPES.register("source_berry_ice_cream", () -> new CosmoIceCreamFluidType("source_berry"));
    public static final RegistryObject<FlowingFluid> SOURCE_BERRY_ICE_CREAM = FLUIDS.register("source_berry_ice_cream", () -> new ForgeFlowingFluid.Source(CosmoFluids.SOURCE_BERRY_ICE_CREAM_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_SOURCE_BERRY_ICE_CREAM = FLUIDS.register("flowing_source_berry_ice_cream", () -> new ForgeFlowingFluid.Flowing(CosmoFluids.SOURCE_BERRY_ICE_CREAM_PROPERTIES));
    public static final ForgeFlowingFluid.Properties SOURCE_BERRY_ICE_CREAM_PROPERTIES = new ForgeFlowingFluid.Properties(SOURCE_BERRY_ICE_CREAM_TYPE, SOURCE_BERRY_ICE_CREAM, FLOWING_SOURCE_BERRY_ICE_CREAM);
    //quark
    public static final RegistryObject<FluidType> ENCHANTED_FRUIT_ICE_CREAM_TYPE = FLUID_TYPES.register("enchanted_fruit_ice_cream", () -> new CosmoIceCreamFluidType("enchanted_fruit"));
    public static final RegistryObject<FlowingFluid> ENCHANTED_FRUIT_ICE_CREAM = FLUIDS.register("enchanted_fruit_ice_cream", () -> new ForgeFlowingFluid.Source(CosmoFluids.ENCHANTED_FRUIT_ICE_CREAM_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_ENCHANTED_FRUIT_ICE_CREAM = FLUIDS.register("flowing_enchanted_fruit_ice_cream", () -> new ForgeFlowingFluid.Flowing(CosmoFluids.ENCHANTED_FRUIT_ICE_CREAM_PROPERTIES));
    public static final ForgeFlowingFluid.Properties ENCHANTED_FRUIT_ICE_CREAM_PROPERTIES = new ForgeFlowingFluid.Properties(ENCHANTED_FRUIT_ICE_CREAM_TYPE, ENCHANTED_FRUIT_ICE_CREAM, FLOWING_ENCHANTED_FRUIT_ICE_CREAM);

}

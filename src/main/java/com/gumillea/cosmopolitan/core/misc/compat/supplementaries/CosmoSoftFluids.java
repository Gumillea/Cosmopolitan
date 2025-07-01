package com.gumillea.cosmopolitan.core.misc.compat.supplementaries;

import net.mehvahdjukaar.moonlight.api.fluids.SoftFluid;
import net.mehvahdjukaar.moonlight.api.fluids.SoftFluidRegistry;
import net.mehvahdjukaar.moonlight.api.misc.DataObjectReference;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.fml.ModList;

public class CosmoSoftFluids {
    public static DataObjectReference<SoftFluid> BIRCH_SAP;

    public static void init() {
        if (ModList.get().isLoaded("supplementaries")) {
            BIRCH_SAP = new DataObjectReference<>(new ResourceLocation("supplementaries", "birch_sap"), SoftFluidRegistry.KEY);
        }
    }
}

package com.gumillea.cosmopolitan.core.misc.compat.supplementaries;

import com.gumillea.cosmopolitan.core.util.CosmoCompat;
import net.mehvahdjukaar.moonlight.api.fluids.SoftFluid;
import net.mehvahdjukaar.moonlight.api.fluids.SoftFluidRegistry;
import net.mehvahdjukaar.moonlight.api.misc.DataObjectReference;
import net.minecraft.resources.ResourceLocation;

public class CosmoSoftFluids {
    public static DataObjectReference<SoftFluid> BIRCH_SAP;

    public static void init() {
        if (!CosmoCompat.sup) return;
        BIRCH_SAP = new DataObjectReference<>(new ResourceLocation("supplementaries", "birch_sap"), SoftFluidRegistry.KEY);
    }

}

package com.gumillea.cosmopolitan.common.fluid;

import com.gumillea.cosmopolitan.Cosmopolitan;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraftforge.client.extensions.common.IClientFluidTypeExtensions;
import net.minecraftforge.common.SoundActions;
import net.minecraftforge.fluids.FluidType;

import java.util.function.Consumer;

public class CosmoIceCreamFluidType extends FluidType {
    private final ResourceLocation stillTexture;
    private final ResourceLocation flowingTexture;
    private final ResourceLocation tubStillTexture;
    private final ResourceLocation tubFlowingTexture;

    public CosmoIceCreamFluidType(String texture) {
        super(FluidType.Properties.create()
                .sound(SoundActions.BUCKET_FILL, SoundEvents.SNOW_BREAK)
                .sound(SoundActions.BUCKET_EMPTY, SoundEvents.SNOW_PLACE)
                .sound(SoundActions.FLUID_VAPORIZE, SoundEvents.SNOW_BREAK)
        );

        this.stillTexture = new ResourceLocation(Cosmopolitan.MODID, "fluid/" + texture + "_ice_cream");
        this.flowingTexture = new ResourceLocation(Cosmopolitan.MODID, "fluid/" + texture + "_ice_cream");

        this.tubStillTexture = new ResourceLocation(Cosmopolitan.MODID, "fluid/tub/" + texture + "_ice_cream");
        this.tubFlowingTexture = new ResourceLocation(Cosmopolitan.MODID, "fluid/tub/" + texture + "_ice_cream");
    }

    @Override
    public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer) {
        consumer.accept(new IClientFluidTypeExtensions() {
            @Override
            public ResourceLocation getStillTexture() {
                return selectTexture(false);
            }

            @Override
            public ResourceLocation getFlowingTexture() {
                return selectTexture(true);
            }

            private ResourceLocation selectTexture(boolean flowing) {
                if (CosmoIceCreamFluidType.isInTubContext()) {
                    return flowing ? tubFlowingTexture : tubStillTexture;
                } else {
                    return flowing ? flowingTexture : stillTexture;
                }
            }
        });
    }

    private static boolean isInTubContext() {
        return IN_TUB_CONTEXT.get();
    }

    private static final ThreadLocal<Boolean> IN_TUB_CONTEXT = ThreadLocal.withInitial(() -> false);

    public static void setTubContext(boolean inTub) {
        IN_TUB_CONTEXT.set(inTub);
    }
}

package com.gumillea.cosmopolitan.common.fluid;

import com.gumillea.cosmopolitan.Cosmopolitan;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraftforge.client.extensions.common.IClientFluidTypeExtensions;
import net.minecraftforge.common.SoundActions;
import net.minecraftforge.fluids.FluidType;

import java.util.function.Consumer;

public class CosmoIceCreamFluidType extends FluidType {
    private final ResourceLocation ICE_CREAM_STILL_TEXTURE;
    private final ResourceLocation ICE_CREAM_FLOWING_TEXTURE;

    public CosmoIceCreamFluidType(String texture) {
        super(FluidType.Properties.create()
                .sound(SoundActions.BUCKET_FILL, SoundEvents.SNOW_BREAK)
                .sound(SoundActions.BUCKET_EMPTY, SoundEvents.SNOW_PLACE)
                .sound(SoundActions.FLUID_VAPORIZE, SoundEvents.SNOW_BREAK)
        );

        this.ICE_CREAM_STILL_TEXTURE = new ResourceLocation(Cosmopolitan.MODID, "fluid/" + texture + "_ice_cream");
        this.ICE_CREAM_FLOWING_TEXTURE = new ResourceLocation(Cosmopolitan.MODID, "fluid/" + texture + "_ice_cream");
    }

    public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer) {
        consumer.accept(new IClientFluidTypeExtensions() {
            public ResourceLocation getStillTexture() {
                return ICE_CREAM_STILL_TEXTURE;
            }

            public ResourceLocation getFlowingTexture() {
                return ICE_CREAM_FLOWING_TEXTURE;
            }
        });
    }

}

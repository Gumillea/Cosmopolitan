package com.gumillea.cosmopolitan.common.fluid;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraftforge.client.extensions.common.IClientFluidTypeExtensions;
import net.minecraftforge.common.SoundActions;
import net.minecraftforge.fluids.FluidType;

import java.util.function.Consumer;

public class BnCAlcoholFluidType extends FluidType {
    public static final ResourceLocation FLUID_STILL_TEXTURE = new ResourceLocation("block/water_still");
    public static final ResourceLocation FLUID_FLOWING_TEXTURE = new ResourceLocation("block/water_flow");
    private final int tintColor;

    public BnCAlcoholFluidType(int tintColor) {
        super(Properties.create().sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL).sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY).sound(SoundActions.FLUID_VAPORIZE, SoundEvents.FIRE_EXTINGUISH));
        this.tintColor = tintColor;
    }

    public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer) {
        consumer.accept(new IClientFluidTypeExtensions() {
            public ResourceLocation getStillTexture() {
                return FLUID_STILL_TEXTURE;
            }

            public ResourceLocation getFlowingTexture() {
                return FLUID_FLOWING_TEXTURE;
            }

            public int getTintColor() {
                return BnCAlcoholFluidType.this.tintColor;
            }
        });
    }
}

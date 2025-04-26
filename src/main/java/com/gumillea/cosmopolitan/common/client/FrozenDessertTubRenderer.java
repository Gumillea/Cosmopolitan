package com.gumillea.cosmopolitan.common.client;

import com.gumillea.cosmopolitan.common.blockEntity.FrozenDessertTubBlockEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.client.extensions.common.IClientFluidTypeExtensions;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidType;
import org.joml.Matrix3f;
import org.joml.Matrix4f;

public class FrozenDessertTubRenderer implements BlockEntityRenderer<FrozenDessertTubBlockEntity> {
    private static final float INNER_MIN = 2/16f;
    private static final float INNER_MAX = 14/16f;
    private static final float BASE_HEIGHT = 1/16f;

    public FrozenDessertTubRenderer(BlockEntityRendererProvider.Context context) {}

    @Override
    public void render(FrozenDessertTubBlockEntity be, float partialTick, PoseStack poseStack,
                       MultiBufferSource buffer, int packedLight, int packedOverlay) {
        FluidStack stack = be.getTank().getFluid();
        if (stack.isEmpty()) return;

        float fill = (float)stack.getAmount() / FrozenDessertTubBlockEntity.CAPACITY;
        float height = BASE_HEIGHT + (INNER_MAX - BASE_HEIGHT) * fill;

        TextureAtlasSprite fluidSprite = getFluidSprite(stack);
        renderFluidPlane(poseStack, buffer, fluidSprite, height, packedLight);
    }

    private TextureAtlasSprite getFluidSprite(FluidStack stack) {
        Fluid fluid = stack.getFluid();
        FluidType type = fluid.getFluidType();
        IClientFluidTypeExtensions clientExtensions = IClientFluidTypeExtensions.of(type);
        ResourceLocation texture = clientExtensions.getStillTexture(stack);
        return Minecraft.getInstance().getTextureAtlas(TextureAtlas.LOCATION_BLOCKS).apply(texture);
    }

    private void renderFluidPlane(PoseStack poseStack, MultiBufferSource buffer,
                                  TextureAtlasSprite sprite, float height, int light) {
        VertexConsumer vertexBuilder = buffer.getBuffer(RenderType.translucent());
        Matrix4f matrix = poseStack.last().pose();
        Matrix3f normal = poseStack.last().normal();

        float x1 = INNER_MIN, z1 = INNER_MIN;
        float x2 = INNER_MIN, z2 = INNER_MAX;
        float x3 = INNER_MAX, z3 = INNER_MAX;
        float x4 = INNER_MAX, z4 = INNER_MIN;

        float uMin = sprite.getU0();
        float uMax = sprite.getU1();
        float vMin = sprite.getV0();
        float vMax = sprite.getV1();

        int r = 255, g = 255, b = 255, a = 255;

        vertexBuilder.vertex(matrix, x1, height, z1).color(r, g, b, a).uv(uMin, vMin).uv2(light).normal(normal, 0, 1, 0).endVertex();
        vertexBuilder.vertex(matrix, x2, height, z2).color(r, g, b, a).uv(uMin, vMax).uv2(light).normal(normal, 0, 1, 0).endVertex();
        vertexBuilder.vertex(matrix, x3, height, z3).color(r, g, b, a).uv(uMax, vMax).uv2(light).normal(normal, 0, 1, 0).endVertex();
        vertexBuilder.vertex(matrix, x4, height, z4).color(r, g, b, a).uv(uMax, vMin).uv2(light).normal(normal, 0, 1, 0).endVertex();
    }

}
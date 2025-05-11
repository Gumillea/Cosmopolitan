package com.gumillea.cosmopolitan.common.client;

import com.gumillea.cosmopolitan.common.block.FrozenDessertTubBlock;
import com.gumillea.cosmopolitan.common.blockEntity.FrozenDessertTubBlockEntity;
import com.gumillea.cosmopolitan.common.fluid.CosmoIceCreamFluidType;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.client.extensions.common.IClientFluidTypeExtensions;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidType;
import org.joml.Matrix3f;
import org.joml.Matrix4f;

public class FrozenDessertTubRenderer implements BlockEntityRenderer<FrozenDessertTubBlockEntity> {
    private static final float INNER_MIN = 2F / 16F;
    private static final float INNER_MAX = 14F / 16F;
    private static final float BASE_HEIGHT = 1F / 16F;

    public FrozenDessertTubRenderer(BlockEntityRendererProvider.Context context) {}

    @Override
    public void render(FrozenDessertTubBlockEntity be, float partialTick, PoseStack poseStack,
                       MultiBufferSource buffer, int packedLight, int packedOverlay) {
        FluidStack stack = be.getTank().getFluid();
        if (stack.isEmpty()) return;

        try {
            CosmoIceCreamFluidType.setTubContext(true);

            float fill = (float) stack.getAmount() / FrozenDessertTubBlockEntity.CAPACITY;
            float height = BASE_HEIGHT + (INNER_MAX - BASE_HEIGHT) * fill;

            Direction facing = be.getBlockState().getValue(FrozenDessertTubBlock.FACING);
            poseStack.pushPose();

            poseStack.translate(0.5, 0, 0.5);
            switch (facing) {
                case NORTH -> poseStack.mulPose(com.mojang.math.Axis.YP.rotationDegrees(0));
                case SOUTH -> poseStack.mulPose(com.mojang.math.Axis.YP.rotationDegrees(180));
                case WEST  -> poseStack.mulPose(com.mojang.math.Axis.YP.rotationDegrees(90));
                case EAST  -> poseStack.mulPose(com.mojang.math.Axis.YP.rotationDegrees(270));
            }
            poseStack.translate(-0.5, 0, -0.5);

            TextureAtlasSprite sprite = getFluidSprite(stack);
            renderFluidPlane(poseStack, buffer, sprite, height, packedLight);

            poseStack.popPose();
        } finally {
            CosmoIceCreamFluidType.setTubContext(false);
        }
    }

    private TextureAtlasSprite getFluidSprite(FluidStack stack) {
        Fluid fluid = stack.getFluid();
        FluidType type = fluid.getFluidType();
        IClientFluidTypeExtensions extensions = IClientFluidTypeExtensions.of(type);
        ResourceLocation texture = extensions.getStillTexture(stack);
        return Minecraft.getInstance().getTextureAtlas(TextureAtlas.LOCATION_BLOCKS).apply(texture);
    }

    private void renderFluidPlane(PoseStack poseStack, MultiBufferSource buffer,
                                  TextureAtlasSprite sprite, float height, int light) {
        VertexConsumer vertexBuilder = buffer.getBuffer(RenderType.translucent());
        Matrix4f matrix = poseStack.last().pose();
        Matrix3f normal = poseStack.last().normal();

        float uMin = sprite.getU(2);
        float uMax = sprite.getU(14);
        float vMin = sprite.getV(2);
        float vMax = sprite.getV(14);
        int r = 255, g = 255, b = 255, a = 255;

        vertexBuilder.vertex(matrix, INNER_MIN, height, INNER_MIN).color(r, g, b, a).uv(uMin, vMin).uv2(light).normal(normal, 0, 1, 0).endVertex();
        vertexBuilder.vertex(matrix, INNER_MIN, height, INNER_MAX).color(r, g, b, a).uv(uMin, vMax).uv2(light).normal(normal, 0, 1, 0).endVertex();
        vertexBuilder.vertex(matrix, INNER_MAX, height, INNER_MAX).color(r, g, b, a).uv(uMax, vMax).uv2(light).normal(normal, 0, 1, 0).endVertex();
        vertexBuilder.vertex(matrix, INNER_MAX, height, INNER_MIN).color(r, g, b, a).uv(uMax, vMin).uv2(light).normal(normal, 0, 1, 0).endVertex();
    }

}
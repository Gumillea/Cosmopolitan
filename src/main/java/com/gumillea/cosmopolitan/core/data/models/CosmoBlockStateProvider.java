package com.gumillea.cosmopolitan.core.data.models;

import com.gumillea.cosmopolitan.Cosmopolitan;
import com.gumillea.cosmopolitan.common.block.IceCreamTubBlock;
import com.gumillea.cosmopolitan.core.reg.CosmoBlocks;
import com.gumillea.cosmopolitan.core.util.CosmoCompat;
import com.teamabnormals.blueprint.core.data.client.BlueprintBlockStateProvider;
import net.minecraft.core.Direction;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.client.model.generators.MultiPartBlockStateBuilder;
import net.minecraftforge.client.model.generators.VariantBlockStateBuilder;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class CosmoBlockStateProvider extends BlueprintBlockStateProvider {

    public CosmoBlockStateProvider(PackOutput output, ExistingFileHelper helper) {
        super(output, Cosmopolitan.MODID, helper);
    }

    @Override
    protected void registerStatesAndModels() {
        registerIceCreamTub(CosmoBlocks.CHOCOLATE_ICE_CREAM_TUB);
        registerIceCreamTub(CosmoBlocks.STRAWBERRY_ICE_CREAM_TUB);
        registerIceCreamTub(CosmoBlocks.VANILLA_ICE_CREAM_TUB);
        registerIceCreamTub(CosmoBlocks.ADZUKI_ICE_CREAM_TUB);
        registerIceCreamTub(CosmoBlocks.BANANA_ICE_CREAM_TUB);
        registerIceCreamTub(CosmoBlocks.MINT_ICE_CREAM_TUB);

        registerIceCreamTub(CosmoBlocks.APPLE_ICE_CREAM_TUB);
        registerIceCreamTub(CosmoBlocks.CARROT_ICE_CREAM_TUB);
        registerIceCreamTub(CosmoBlocks.GLOW_BERRY_ICE_CREAM_TUB);

        registerIceCreamTub(CosmoBlocks.SOURCE_BERRY_ICE_CREAM_TUB);
        registerIceCreamTub(CosmoBlocks.ENCHANTED_FRUIT_ICE_CREAM_TUB);
        registerIceCreamTub(CosmoBlocks.KABLOOM_ICE_CREAM_TUB);
    }

    private void registerIceCreamTub(RegistryObject<Block> block) {
        String path = block.getId().getPath();
        String flavor = path.replace("ice_cream_tub_", "");
        String layerTexture = flavor + "_ice_cream";

        VariantBlockStateBuilder builder = getVariantBuilder(block.get());

        for (int i = 0; i < 6; i++) {
            String modelPath = path + "_layer" + i;
            String parent = "block/frozen_dessert_tub_layer" + i;

            ModelFile model = models().withExistingParent(modelPath, modLoc(parent))
                    .texture("layers", modLoc("block/tub_layers/" + layerTexture));

            builder.partialState()
                    .with(IceCreamTubBlock.LEVEL, i + 1)
                    .modelForState()
                    .modelFile(model)
                    .addModel();
        }

        builder.partialState()
                .with(IceCreamTubBlock.LEVEL, 0)
                .modelForState()
                .modelFile(models().getExistingFile(mcLoc("block/air"))) // 隐形模型
                .addModel();
    }
}
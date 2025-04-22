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
    }

    private void registerIceCreamTub(RegistryObject<Block> block) {
        String baseName = block.getId().getPath();
        String flavor = baseName.replace("ice_cream_tub_", "");
        String layerTexture = flavor + "_ice_cream";

        MultiPartBlockStateBuilder builder = getMultipartBuilder(block.get());

        ModelFile containerModel = models().withExistingParent(baseName + "_container", modLoc("block/ice_cream_tub"));
        builder.part()
                .modelFile(containerModel)
                .addModel()
                .end();

        for (int i = 1; i <= 6; i++) {
            int y = 4 + (i - 1) * 2;
            String layerName = baseName + "_layer" + (i - 1);

            ModelFile layerModel = models().getBuilder(layerName)
                    .parent(new ModelFile.UncheckedModelFile("block/block"))
                    .texture("ice_cream", new ResourceLocation(Cosmopolitan.MODID, "block/tub_layers/" + layerTexture))
                    .element()
                    .from(2, y, 2)
                    .to(14, y + 2, 14)
                    .face(Direction.UP).texture("#ice_cream").end()
                    .face(Direction.DOWN).texture("#ice_cream").end()
                    .end();

            builder.part()
                    .modelFile(layerModel)
                    .addModel()
                    .condition(IceCreamTubBlock.LEVEL, i)
                    .end();
        }
    }
}
package com.gumillea.cosmopolitan.core.data.models;

import com.gumillea.cosmopolitan.Cosmopolitan;
import com.gumillea.cosmopolitan.core.reg.CosmoBlocks;
import com.teamabnormals.blueprint.core.data.client.BlueprintBlockStateProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LayeredCauldronBlock;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class CosmoBlockStateProvider extends BlueprintBlockStateProvider {

    public CosmoBlockStateProvider(PackOutput output, ExistingFileHelper helper) {
        super(output, Cosmopolitan.MODID, helper);
    }

    @Override
    protected void registerStatesAndModels() {
        this.block(CosmoBlocks.MASHED_POTATO_BLOCK);
        this.block(CosmoBlocks.APPLE_ICE_CREAM_BLOCK);
        this.block(CosmoBlocks.CARROT_ICE_CREAM_BLOCK);
        this.block(CosmoBlocks.GLOW_BERRY_ICE_CREAM_BLOCK);
        this.crossBlock(CosmoBlocks.LIFELIGHT);

        this.cauldronBlock(CosmoBlocks.APPLE_MILKSHAKE_CAULDRON);
        this.cauldronBlock(CosmoBlocks.CARROT_MILKSHAKE_CAULDRON);
        this.cauldronBlock(CosmoBlocks.GLOW_BERRY_MILKSHAKE_CAULDRON);
        this.cauldronBlock(CosmoBlocks.ENCHANTED_FRUIT_MILKSHAKE_CAULDRON);
        this.cauldronBlock(CosmoBlocks.KABLOOM_MILKSHAKE_CAULDRON);
        this.cauldronBlock(CosmoBlocks.SOURCE_BERRY_MILKSHAKE_CAULDRON);

        this.logBlock(CosmoBlocks.WHEATGRASS_BALE);
    }

    public void cauldronBlock(RegistryObject<Block> block) {
        String path = block.getId().getPath();
        String content = path.replace("_cauldron", "");

        ModelFile level1 = models().withExistingParent(path + "_level1", mcLoc("block/template_cauldron_level1"))
                .texture("content", new ResourceLocation(Cosmopolitan.MODID, "block/fluid/" + content))
                .texture("inside", mcLoc("block/cauldron_inner"))
                .texture("particle", mcLoc("block/cauldron_side"))
                .texture("top", mcLoc("block/cauldron_top"))
                .texture("bottom", mcLoc("block/cauldron_bottom"))
                .texture("side", mcLoc("block/cauldron_side"));

        ModelFile level2 = models().withExistingParent(path + "_level2", mcLoc("block/template_cauldron_level2"))
                .texture("content", new ResourceLocation(Cosmopolitan.MODID, "block/fluid/" + content))
                .texture("inside", mcLoc("block/cauldron_inner"))
                .texture("particle", mcLoc("block/cauldron_side"))
                .texture("top", mcLoc("block/cauldron_top"))
                .texture("bottom", mcLoc("block/cauldron_bottom"))
                .texture("side", mcLoc("block/cauldron_side"));

        ModelFile full = models().withExistingParent(path + "_full", mcLoc("block/template_cauldron_full"))
                .texture("content", new ResourceLocation(Cosmopolitan.MODID, "block/fluid/" + content))
                .texture("inside", mcLoc("block/cauldron_inner"))
                .texture("particle", mcLoc("block/cauldron_side"))
                .texture("top", mcLoc("block/cauldron_top"))
                .texture("bottom", mcLoc("block/cauldron_bottom"))
                .texture("side", mcLoc("block/cauldron_side"));

        getVariantBuilder(block.get())
                .partialState().with(LayeredCauldronBlock.LEVEL, 1).modelForState().modelFile(level1).addModel()
                .partialState().with(LayeredCauldronBlock.LEVEL, 2).modelForState().modelFile(level2).addModel()
                .partialState().with(LayeredCauldronBlock.LEVEL, 3).modelForState().modelFile(full).addModel();
    }
}
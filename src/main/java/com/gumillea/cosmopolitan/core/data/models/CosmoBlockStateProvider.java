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

        this.block(CosmoBlocks.STRAWBERRY_ICE_CREAM_BRICKS);
        this.block(CosmoBlocks.CHOCOLATE_ICE_CREAM_BRICKS);
        this.block(CosmoBlocks.VANILLA_ICE_CREAM_BRICKS);
        this.block(CosmoBlocks.MINT_ICE_CREAM_BRICKS);
        this.block(CosmoBlocks.BANANA_ICE_CREAM_BRICKS);
        this.block(CosmoBlocks.ADZUKI_ICE_CREAM_BRICKS);
        this.block(CosmoBlocks.APPLE_ICE_CREAM_BRICKS);
        this.block(CosmoBlocks.CARROT_ICE_CREAM_BRICKS);
        this.block(CosmoBlocks.GLOW_BERRY_ICE_CREAM_BRICKS);
        this.block(CosmoBlocks.ENCHANTED_FRUIT_ICE_CREAM_BRICKS);
        this.block(CosmoBlocks.SOURCE_BERRY_ICE_CREAM_BRICKS);
        this.block(CosmoBlocks.KABLOOM_ICE_CREAM_BRICKS);
        this.block(CosmoBlocks.GLOWY_ICE_CREAM_BRICKS);
        this.block(CosmoBlocks.FLAVORED_ICE_CREAM_BRICKS);
        this.block(CosmoBlocks.CHERRY_ICE_CREAM_BRICKS);
        this.block(CosmoBlocks.TORCHBERRY_ICE_CREAM_BRICKS);
        this.block(CosmoBlocks.PHYTOCHEMICAL_ICE_CREAM_BRICKS);
        this.block(CosmoBlocks.GLACIER_ICE_CREAM_BRICKS);
        this.block(CosmoBlocks.AURORA_ICE_CREAM_BRICKS);
        this.block(CosmoBlocks.SALMONBERRY_ICE_CREAM_BRICKS);
        this.block(CosmoBlocks.MATCHA_ICE_CREAM_BRICKS);
        this.block(CosmoBlocks.POMEGRANATE_ICE_CREAM_BRICKS);
        this.block(CosmoBlocks.LIME_ICE_CREAM_BRICKS);
        this.block(CosmoBlocks.CHORUS_FRUIT_ICE_CREAM_BRICKS);
        this.block(CosmoBlocks.WARZIPAN_ICE_CREAM_BRICKS);
        this.block(CosmoBlocks.AZURE_BERRY_ICE_CREAM_BRICKS);
        this.block(CosmoBlocks.JELLY_RING_ICE_CREAM_BRICKS);
        this.block(CosmoBlocks.MIDNIGHT_ICE_CREAM_BRICKS);
        this.block(CosmoBlocks.STARCLOUD_ICE_CREAM_BRICKS);
        this.block(CosmoBlocks.BEETROOT_ICE_CREAM_BRICKS);
        this.block(CosmoBlocks.SWEET_BERRY_ICE_CREAM_BRICKS);
        this.block(CosmoBlocks.PUMPKIN_ICE_CREAM_BRICKS);
        this.block(CosmoBlocks.ALOE_ICE_CREAM_BRICKS);
        this.block(CosmoBlocks.PASSION_FRUIT_ICE_CREAM_BRICKS);
        this.block(CosmoBlocks.YUCCA_ICE_CREAM_BRICKS);
        this.block(CosmoBlocks.GREEN_TEA_ICE_CREAM_BRICKS);
        this.block(CosmoBlocks.YELLOW_TEA_ICE_CREAM_BRICKS);
        this.block(CosmoBlocks.BLACK_TEA_ICE_CREAM_BRICKS);
        this.block(CosmoBlocks.COFFEE_ICE_CREAM_BRICKS);

        this.syrupBlock(CosmoBlocks.BERRY_SYRUP_BLOCK);
        this.syrupBlock(CosmoBlocks.BIRCH_SAP_BLOCK);

        this.crossBlock(CosmoBlocks.LIFELIGHT);

        this.cauldronBlock(CosmoBlocks.APPLE_MILKSHAKE_CAULDRON);
        this.cauldronBlock(CosmoBlocks.CARROT_MILKSHAKE_CAULDRON);
        this.cauldronBlock(CosmoBlocks.GLOW_BERRY_MILKSHAKE_CAULDRON);
        this.cauldronBlock(CosmoBlocks.ENCHANTED_FRUIT_MILKSHAKE_CAULDRON);
        this.cauldronBlock(CosmoBlocks.KABLOOM_MILKSHAKE_CAULDRON);
        this.cauldronBlock(CosmoBlocks.SOURCE_BERRY_MILKSHAKE_CAULDRON);

        this.logBlock(CosmoBlocks.WHEATGRASS_BALE);
        this.directionalBlock(CosmoBlocks.WILDBERRIES_BASKET);
        this.directionalBlock(CosmoBlocks.FIDDLEHEAD_CRATE);
    }

    public void syrupBlock(RegistryObject<Block> block) {
        String path = block.getId().getPath();
        ResourceLocation texture = new ResourceLocation(Cosmopolitan.MODID, "block/" + path);

        ModelFile syrupBlock = models().withExistingParent(path, mcLoc("block/honey_block"))
                .texture("particle", texture)
                .texture("down", texture)
                .texture("up", texture)
                .texture("side", texture);

        simpleBlock(block.get(), syrupBlock);
        this.blockItem(block);
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
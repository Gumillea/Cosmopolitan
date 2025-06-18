package com.gumillea.cosmopolitan.core.data.tags;

import com.gumillea.cosmopolitan.Cosmopolitan;
import com.gumillea.cosmopolitan.core.reg.CosmoBlocks;
import com.gumillea.cosmopolitan.core.util.CosmoBlockTags;
import com.gumillea.cosmopolitan.core.util.CosmoCompat;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

public class CosmoBlockTagsProvider extends BlockTagsProvider {
    public CosmoBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> provider, ExistingFileHelper helper) {
        super(output, provider, Cosmopolitan.MODID, helper);
    }

    @Override
    public void addTags(HolderLookup.Provider provider) {
        this.tag(BlockTags.MINEABLE_WITH_SHOVEL).add(
                CosmoBlocks.STRAWBERRY_ICE_CREAM_BRICKS.get(),
                CosmoBlocks.VANILLA_ICE_CREAM_BRICKS.get(),
                CosmoBlocks.CHOCOLATE_ICE_CREAM_BRICKS.get(),
                CosmoBlocks.MINT_ICE_CREAM_BRICKS.get(),
                CosmoBlocks.ADZUKI_ICE_CREAM_BRICKS.get(),
                CosmoBlocks.BANANA_ICE_CREAM_BRICKS.get(),
                CosmoBlocks.GLOWY_ICE_CREAM_BRICKS.get(),
                CosmoBlocks.FLAVORED_ICE_CREAM_BRICKS.get(),
                CosmoBlocks.CHERRY_ICE_CREAM_BRICKS.get(),
                CosmoBlocks.TORCHBERRY_ICE_CREAM_BRICKS.get(),
                CosmoBlocks.PHYTOCHEMICAL_ICE_CREAM_BRICKS.get(),
                CosmoBlocks.GLACIER_ICE_CREAM_BRICKS.get(),
                CosmoBlocks.AURORA_ICE_CREAM_BRICKS.get(),
                CosmoBlocks.SALMONBERRY_ICE_CREAM_BRICKS.get(),
                CosmoBlocks.MATCHA_ICE_CREAM_BRICKS.get(),
                CosmoBlocks.POMEGRANATE_ICE_CREAM_BRICKS.get(),
                CosmoBlocks.LIME_ICE_CREAM_BRICKS.get(),
                CosmoBlocks.CHORUS_FRUIT_ICE_CREAM_BRICKS.get(),
                CosmoBlocks.WARZIPAN_ICE_CREAM_BRICKS.get(),
                CosmoBlocks.AZURE_BERRY_ICE_CREAM_BRICKS.get(),
                CosmoBlocks.JELLY_RING_ICE_CREAM_BRICKS.get(),
                CosmoBlocks.MIDNIGHT_ICE_CREAM_BRICKS.get(),
                CosmoBlocks.STARCLOUD_ICE_CREAM_BRICKS.get(),
                CosmoBlocks.BEETROOT_ICE_CREAM_BRICKS.get(),
                CosmoBlocks.SWEET_BERRY_ICE_CREAM_BRICKS.get(),
                CosmoBlocks.PUMPKIN_ICE_CREAM_BRICKS.get(),
                CosmoBlocks.ALOE_ICE_CREAM_BRICKS.get(),
                CosmoBlocks.PASSION_FRUIT_ICE_CREAM_BRICKS.get(),
                CosmoBlocks.YUCCA_ICE_CREAM_BRICKS.get(),
                CosmoBlocks.GREEN_TEA_ICE_CREAM_BRICKS.get(),
                CosmoBlocks.YELLOW_TEA_ICE_CREAM_BRICKS.get(),
                CosmoBlocks.BLACK_TEA_ICE_CREAM_BRICKS.get(),
                CosmoBlocks.COFFEE_ICE_CREAM_BRICKS.get(),

                CosmoBlocks.APPLE_ICE_CREAM_BLOCK.get(),
                CosmoBlocks.CARROT_ICE_CREAM_BLOCK.get(),
                CosmoBlocks.GLOW_BERRY_ICE_CREAM_BLOCK.get(),
                CosmoBlocks.ENCHANTED_FRUIT_ICE_CREAM_BLOCK.get(),
                CosmoBlocks.KABLOOM_ICE_CREAM_BLOCK.get(),
                CosmoBlocks.SOURCE_BERRY_ICE_CREAM_BLOCK.get(),
                CosmoBlocks.CHERRY_ICE_CREAM_BLOCK.get(),
                CosmoBlocks.TORCHBERRY_ICE_CREAM_BLOCK.get(),
                CosmoBlocks.PHYTOCHEMICAL_ICE_CREAM_BLOCK.get(),
                CosmoBlocks.GLACIER_ICE_CREAM_BLOCK.get(),
                CosmoBlocks.AURORA_ICE_CREAM_BLOCK.get(),

                CosmoBlocks.CHISELED_CHOCOLATE_ICE_CREAM_BLOCK.get(),
                CosmoBlocks.CHISELED_BANANA_ICE_CREAM_BLOCK.get(),
                CosmoBlocks.CHISELED_STRAWBERRY_ICE_CREAM_BLOCK.get(),
                CosmoBlocks.CHISELED_MINT_ICE_CREAM_BLOCK.get(),
                CosmoBlocks.CHISELED_VANILLA_ICE_CREAM_BLOCK.get(),
                CosmoBlocks.CHISELED_ADZUKI_ICE_CREAM_BLOCK.get(),

                CosmoBlocks.MASHED_POTATO_BLOCK.get()
        );
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(
                CosmoBlocks.IRON_FROZEN_DESSERT_TUB.get(),
                CosmoBlocks.COPPER_FROZEN_DESSERT_TUB.get()
        );
        this.tag(BlockTags.MINEABLE_WITH_HOE).add(
                CosmoBlocks.WHEATGRASS_BALE.get()
        );
        this.tag(BlockTags.MINEABLE_WITH_AXE).add(
                CosmoBlocks.WILDBERRIES_BASKET.get(),
                CosmoBlocks.FIDDLEHEAD_CRATE.get(),
                CosmoBlocks.IRON_FIDDLEHEAD_CRATE.get(),
                CosmoBlocks.SAPPY_BIRCH_LOG.get()
        );
        this.tag(BlockTags.BIRCH_LOGS).add(
                CosmoBlocks.SAPPY_BIRCH_LOG.get()
        );
        this.tag(BlockTags.CLIMBABLE).add(
                CosmoBlocks.BERRY_SYRUP_BLOCK.get()
        );
        this.tag(CosmoBlockTags.COOLING_SOURCES).add(
                Blocks.SNOW_BLOCK,
                Blocks.POWDER_SNOW)
                .addTag(BlockTags.ICE);

        this.tag(CosmoBlockTags.EXUBERANT_SOURCES)
                .addOptional(new ResourceLocation(CosmoCompat.FD, "apple_pie"));

        this.tag(CosmoBlockTags.CAROTENE_SOURCES)
                .addOptional(new ResourceLocation(CosmoCompat.VC, "carrot_cake"));

        this.tag(CosmoBlockTags.TRACER_SOURCES)
                .addOptional(new ResourceLocation(CosmoCompat.VC, "glow_berry_cake"));
    }
}

package com.gumillea.cosmopolitan.core.data.tags;

import com.gumillea.cosmopolitan.Cosmopolitan;
import com.gumillea.cosmopolitan.core.reg.CosmoBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
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
                CosmoBlocks.ENCHANTED_FRUIT_ICE_CREAM_BLOCK.get(),
                CosmoBlocks.KABLOOM_ICE_CREAM_BLOCK.get(),
                CosmoBlocks.SOURCE_BERRY_ICE_CREAM_BLOCK.get(),

                CosmoBlocks.CHISELED_CHOCOLATE_ICE_CREAM_BLOCK.get(),
                CosmoBlocks.CHISELED_BANANA_ICE_CREAM_BLOCK.get(),
                CosmoBlocks.CHISELED_STRAWBERRY_ICE_CREAM_BLOCK.get(),
                CosmoBlocks.CHISELED_MINT_ICE_CREAM_BLOCK.get(),
                CosmoBlocks.CHISELED_VANILLA_ICE_CREAM_BLOCK.get(),
                CosmoBlocks.CHISELED_ADZUKI_ICE_CREAM_BLOCK.get()
        );
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(
                CosmoBlocks.IRON_FROZEN_DESSERT_TUB.get()
        );
    }
}

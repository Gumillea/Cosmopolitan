package com.gumillea.cosmopolitan.core.data.tags;

import com.gumillea.cosmopolitan.Cosmopolitan;
import com.gumillea.cosmopolitan.core.reg.CosmoItems;
import com.gumillea.cosmopolitan.core.util.CosmoItemTags;
import com.teamabnormals.neapolitan.core.other.tags.NeapolitanItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

public class CosmopolitanItemTagsProvider extends ItemTagsProvider {
    public CosmopolitanItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> provider, CompletableFuture<TagsProvider.TagLookup<Block>> lookup, ExistingFileHelper helper) {
        super(output, provider, lookup, Cosmopolitan.MODID, helper);
    }
    @Override
    public void addTags(HolderLookup.Provider provider) {
        this.tag(NeapolitanItemTags.ICE_CREAM).add(
                CosmoItems.STRAWBERRY_ICE_CREAM_CONE.get(),
                CosmoItems.ADZUKI_ICE_CREAM_CONE.get(),
                CosmoItems.BANANA_ICE_CREAM_CONE.get(),
                CosmoItems.CHOCOLATE_ICE_CREAM_CONE.get(),
                CosmoItems.ENCHANTED_FRUIT_ICE_CREAM.get(),
                CosmoItems.ENCHANTED_FRUIT_ICE_CREAM_CONE.get(),
                CosmoItems.KABLOOM_ICE_CREAM.get(),
                CosmoItems.KABLOOM_ICE_CREAM_CONE.get(),
                CosmoItems.NEAPOLITAN_ICE_CREAM_SANDWICH.get(),
                CosmoItems.MINT_ICE_CREAM_CONE.get(),
                CosmoItems.SOURCE_BERRY_ICE_CREAM.get(),
                CosmoItems.SOURCE_BERRY_ICE_CREAM_CONE.get(),
                CosmoItems.VANILLA_ICE_CREAM_CONE.get()
        );

        this.tag(CosmoItemTags.POTATO).add(
                CosmoItems.POTATO_SLICES.get()
        );
    }
}

package com.gumillea.cosmopolitan.core.data.tags;

import com.gumillea.cosmopolitan.Cosmopolitan;
import com.gumillea.cosmopolitan.core.reg.CosmoItems;
import com.gumillea.cosmopolitan.core.util.CosmoCompat;
import com.gumillea.cosmopolitan.core.util.CosmoItemTags;
import com.teamabnormals.blueprint.core.other.tags.BlueprintItemTags;
import com.teamabnormals.neapolitan.core.other.tags.NeapolitanItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

public class CosmopolitanItemTagsProvider extends ItemTagsProvider {
    public CosmopolitanItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> provider, CompletableFuture<TagsProvider.TagLookup<Block>> lookup, ExistingFileHelper helper) {
        super(output, provider, lookup, Cosmopolitan.MODID, helper);
    }
    @Override
    public void addTags(HolderLookup.Provider provider) {
        this.tag(Tags.Items.SEEDS).add(
                CosmoItems.SOURCE_BERRY_PIPS.get(),
                CosmoItems.KABLOOM_PIPS.get(),
                CosmoItems.BLISTERBERRY_PIPS.get(),
                CosmoItems.DROOPFRUIT_PIPS.get()
        );

        this.tag(BlueprintItemTags.CHICKEN_FOOD).add(
                CosmoItems.SOURCE_BERRY_PIPS.get(),
                CosmoItems.KABLOOM_PIPS.get(),
                CosmoItems.BLISTERBERRY_PIPS.get(),
                CosmoItems.DROOPFRUIT_PIPS.get()
        );

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

        this.tag(CosmoItemTags.BERRIES).add(
                CosmoItems.WILDBERRY.get()
        );

        this.tag(CosmoItemTags.POTATO).add(
                CosmoItems.CUT_POTATOES.get()
        );

        this.tag(CosmoItemTags.VEGETABLES).add(
                CosmoItems.FIDDLEHEAD.get()
        );

        this.tag(CosmoItemTags.SALAD_INGREDIENTS).add(
                CosmoItems.FIDDLEHEAD.get()
        );

        this.tag(CosmoItemTags.PUMPKINS)
                .addOptional(new ResourceLocation(CosmoCompat.FD, "pumpkin_slice"))
        ;

        this.tag(CosmoItemTags.CHOCOLATE)
                .addOptional(new ResourceLocation(CosmoCompat.NEA, "chocolate_bar"))
        ;

        this.tag(CosmoItemTags.JAMS).add(
                CosmoItems.BERRY_SYRUP_BOTTLE.get(),
                CosmoItems.STEELEAF_NECTAR.get()
        );
        ;

    }
}

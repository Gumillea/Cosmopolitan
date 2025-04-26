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

        this.tag(BlueprintItemTags.PIG_FOOD).add(
                CosmoItems.FIDDLEHEAD.get()
        );

        this.tag(CosmoItemTags.ICE_CREAM)
                .add(
                        CosmoItems.APPLE_ICE_CREAM.get(),
                        CosmoItems.CARROT_ICE_CREAM.get(),
                        CosmoItems.GLOW_BERRY_ICE_CREAM.get(),

                        CosmoItems.ENCHANTED_FRUIT_ICE_CREAM.get(),
                        CosmoItems.KABLOOM_ICE_CREAM.get(),
                        CosmoItems.SOURCE_BERRY_ICE_CREAM.get(),

                        CosmoItems.SEASONAL_ICE_CREAM.get(),
                        CosmoItems.PECULIAR_ICE_CREAM.get(),

                        CosmoItems.REFRESHING_ICE_CREAM_SANDWICH.get(),
                        CosmoItems.TWILIGHT_ICE_CREAM_SANDWICH.get(),
                        CosmoItems.RAINBOW_ICE_CREAM_SANDWICH.get(),
                        CosmoItems.SEASONAL_ICE_CREAM_SANDWICH.get(),
                        CosmoItems.PECULIAR_ICE_CREAM_SANDWICH.get(),
                        CosmoItems.NEAPOLITAN_ICE_CREAM_SANDWICH.get()
                )
                .addTag(CosmoItemTags.ICE_CREAM_CONES
                );

        this.tag(CosmoItemTags.ICE_CREAM_CONES).add(
                CosmoItems.STRAWBERRY_ICE_CREAM_CONE.get(),
                CosmoItems.ADZUKI_ICE_CREAM_CONE.get(),
                CosmoItems.BANANA_ICE_CREAM_CONE.get(),
                CosmoItems.VANILLA_ICE_CREAM_CONE.get(),
                CosmoItems.CHOCOLATE_ICE_CREAM_CONE.get(),
                CosmoItems.MINT_ICE_CREAM_CONE.get(),

                CosmoItems.CHORUS_ICE_CREAM_CONE.get(),
                CosmoItems.WARZIPAN_ICE_CREAM_CONE.get(),
                CosmoItems.JELLY_RING_ICE_CREAM_CONE.get(),
                CosmoItems.AZURE_BERRY_ICE_CREAM_CONE.get(),
                CosmoItems.MIDNIGHT_ICE_CREAM_CONE.get(),
                CosmoItems.STARCLOUD_ICE_CREAM_CONE.get(),

                CosmoItems.BEETROOT_ICE_CREAM_CONE.get(),
                CosmoItems.PUMPKIN_ICE_CREAM_CONE.get(),
                CosmoItems.SWEET_BERRY_ICE_CREAM_CONE.get(),

                CosmoItems.ALOE_ICE_CREAM_CONE.get(),
                CosmoItems.PASSION_FRUIT_ICE_CREAM_CONE.get(),
                CosmoItems.YUCCA_ICE_CREAM_CONE.get(),

                CosmoItems.MATCHA_ICE_CREAM_CONE.get(),
                CosmoItems.SALMONBERRY_ICE_CREAM_CONE.get(),
                CosmoItems.LIME_ICE_CREAM_CONE.get(),
                CosmoItems.POMEGRANATE_ICE_CREAM_CONE.get(),

                CosmoItems.AURORA_ICE_CREAM_CONE.get(),
                CosmoItems.PHYTOCHEMICAL_ICE_CREAM_CONE.get(),
                CosmoItems.TORCHBERRY_ICE_CREAM_CONE.get(),
                CosmoItems.GLACIER_ICE_CREAM_CONE.get(),

                CosmoItems.APPLE_ICE_CREAM_CONE.get(),
                CosmoItems.CARROT_ICE_CREAM_CONE.get(),
                CosmoItems.GLOW_BERRY_ICE_CREAM_CONE.get(),

                CosmoItems.ENCHANTED_FRUIT_ICE_CREAM_CONE.get(),
                CosmoItems.KABLOOM_ICE_CREAM_CONE.get(),
                CosmoItems.SOURCE_BERRY_ICE_CREAM_CONE.get()
        );

        this.tag(CosmoItemTags.UPRIGHT_ON_BELT).add(
                        CosmoItems.WAFER_CONE.get())
                .addTag(CosmoItemTags.ICE_CREAM
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

        this.tag(CosmoItemTags.MILK_BOTTLE)
                .addOptional(new ResourceLocation(CosmoCompat.NEA, "milk_bottle"))
        ;

        this.tag(CosmoItemTags.JAMS).add(
                CosmoItems.BERRY_SYRUP_BOTTLE.get(),
                CosmoItems.STEELEAF_NECTAR.get()
        );

    }
}

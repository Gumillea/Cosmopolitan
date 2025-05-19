package com.gumillea.cosmopolitan.core.data.models;

import com.gumillea.cosmopolitan.Cosmopolitan;
import com.gumillea.cosmopolitan.core.reg.CosmoItems;
import com.teamabnormals.blueprint.core.data.client.BlueprintItemModelProvider;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;

public class CosmoItemModelProvider extends BlueprintItemModelProvider {

    public CosmoItemModelProvider(PackOutput output, ExistingFileHelper helper) {
        super(output, Cosmopolitan.MODID, helper);
    }

    @Override
    protected void registerModels() {
        this.generatedItem(
                CosmoItems.CREAM_BUCKET, CosmoItems.CREAM, CosmoItems.CONDENSED_MILK_BUCKET, CosmoItems.CONDENSED_MILK_BOTTLE,CosmoItems.KABLOOM_MILKSHAKE, CosmoItems.SOURCE_BERRY_MILKSHAKE, CosmoItems.ENCHANTED_FRUIT_MILKSHAKE, CosmoItems.APPLE_MILKSHAKE, CosmoItems.CARROT_MILKSHAKE, CosmoItems.GLOW_BERRY_MILKSHAKE, CosmoItems.WILD_RISOTTO, CosmoItems.ROASTED_MUSHROOM, CosmoItems.INK_ROLL_SLICE, CosmoItems.INK_ROLL, CosmoItems.SUMMER_CORDIAL, CosmoItems.WINTER_GLOGG, CosmoItems.AUTUMN_TEA, CosmoItems.BIRCH_SAP_BOTTLE, CosmoItems.SPRING_SODA, CosmoItems.SPROUTED_UNDERBEANS, CosmoItems.CLASSIC_ICE_CREAM, CosmoItems.CLASSIC_ICE_CREAM_SANDWICH, CosmoItems.CLASSIC_FRUIT_SALAD, CosmoItems.TOFFEE_GOLDEN_APPLE, CosmoItems.LUSH_STEW, CosmoItems.LUSH_STEW_CUP, CosmoItems.JELLO_SALAD, CosmoItems.JELLO_SALAD_CUP, CosmoItems.WILDBERRY, CosmoItems.BERRY_SYRUP_BOTTLE, CosmoItems.JELLY_ROLL, CosmoItems.JELLY_ROLL_SLICE, CosmoItems.CHOCOLATE_ROLL, CosmoItems.CHOCOLATE_ROLL_SLICE, CosmoItems.COSMOPOLITAN_COCKTAIL, CosmoItems.FIDDLEHEAD, CosmoItems.BAKED_FIDDLEHEAD, CosmoItems.GREEN_SAUCE, CosmoItems.WAFER,
                CosmoItems.POTATO_PANCAKES, CosmoItems.CUT_POTATOES, CosmoItems.POTATO_WEDGES, CosmoItems.GREEN_PASTA, CosmoItems.WHEATGRASS, CosmoItems.UNDERGROUND_GULIME, CosmoItems.UNDERGROUND_GULIME_SMALL, CosmoItems.TAIGA_GULIME, CosmoItems.CHORUS_GULIME, CosmoItems.CHORUS_GULIME_SMALL,
                CosmoItems.SOURCE_BERRY_PIPS, CosmoItems.KABLOOM_PIPS, CosmoItems.BLISTERBERRY_PIPS, CosmoItems.DROOPFRUIT_PIPS, CosmoItems.ENCHANTED_COSMOPOLITAN_COCKTAIL, CosmoItems.GULIME, CosmoItems.GULIME_SMALL, CosmoItems.TAIGA_GULIME_SMALL, CosmoItems.GLIMMERING_GULIME, CosmoItems.GLIMMERING_GULIME_SMALL,
                CosmoItems.NEAPOLITAN_ICE_CREAM_SANDWICH, CosmoItems.BLISTERBERRY_TART, CosmoItems.RAINDROOP_CAKE, CosmoItems.DROOPFRUIT_SORBET, CosmoItems.BLISTERBERRY_SORBET, CosmoItems.PAW_COOKIE, CosmoItems.STRAWBERRY_GULIME_SMALL, CosmoItems.STRAWBERRY_GULIME,
                CosmoItems.AURORA_KOHAKUTOU, CosmoItems.STEELEAF_NECTAR, CosmoItems.GLACIER_ESSENCE, CosmoItems.MATCHA_ICE_CREAM_CONE, CosmoItems.SALMONBERRY_ICE_CREAM_CONE, CosmoItems.LIME_ICE_CREAM_CONE, CosmoItems.POMEGRANATE_ICE_CREAM_CONE, CosmoItems.IRON_FIDDLEHEAD, CosmoItems.GREEN_CREAM_STEW,
                CosmoItems.BEETROOT_ICE_CREAM_CONE, CosmoItems.PUMPKIN_ICE_CREAM_CONE, CosmoItems.SWEET_BERRY_ICE_CREAM_CONE, CosmoItems.SEASONAL_ICE_CREAM, CosmoItems.SEASONAL_ICE_CREAM_SANDWICH,
                CosmoItems.ALOE_ICE_CREAM_CONE, CosmoItems.PASSION_FRUIT_ICE_CREAM_CONE, CosmoItems.YUCCA_ICE_CREAM_CONE, CosmoItems.PECULIAR_ICE_CREAM, CosmoItems.PECULIAR_ICE_CREAM_SANDWICH, CosmoItems.BLISTERBERRY_DOUBLE_POPSICLE, CosmoItems.BLISTERBERRY_POPSICLE, CosmoItems.MENDOSTEEN_TART,
                CosmoItems.AURORA_ICE_CREAM_CONE, CosmoItems.GLACIER_ICE_CREAM_CONE, CosmoItems.PHYTOCHEMICAL_ICE_CREAM_CONE, CosmoItems.TORCHBERRY_ICE_CREAM_CONE, CosmoItems.GREEN_CREAM_STEW_CUP, CosmoItems.TOFFEE_APPLE,
                CosmoItems.RAINBOW_ICE_CREAM_SANDWICH, CosmoItems.REFRESHING_ICE_CREAM_SANDWICH, CosmoItems.TWILIGHT_ICE_CREAM_SANDWICH
        );
    }
}
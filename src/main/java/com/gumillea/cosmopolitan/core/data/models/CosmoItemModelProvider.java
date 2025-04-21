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
                CosmoItems.WILDBERRY, CosmoItems.BERRY_SYRUP_BOTTLE, CosmoItems.JELLY_ROLL, CosmoItems.JELLY_ROLL_SLICE, CosmoItems.CHOCOLATE_ROLL, CosmoItems.CHOCOLATE_ROLL_SLICE, CosmoItems.COSMOPOLITAN_COCKTAIL, CosmoItems.FIDDLEHEAD, CosmoItems.BAKED_FIDDLEHEAD, CosmoItems.GREEN_SAUCE, CosmoItems.WAFER,
                CosmoItems.POTATO_PANCAKES, CosmoItems.CUT_POTATOES, CosmoItems.POTATO_WEDGES, CosmoItems.GREEN_PASTA, CosmoItems.WHEATGRASS,
                CosmoItems.SOURCE_BERRY_PIPS, CosmoItems.KABLOOM_PIPS, CosmoItems.BLISTERBERRY_PIPS, CosmoItems.DROOPFRUIT_PIPS,
                CosmoItems.NEAPOLITAN_ICE_CREAM_SANDWICH, CosmoItems.BLISTERBERRY_TART, CosmoItems.RAINDROOP_CAKE, CosmoItems.DROOPFRUIT_SORBET, CosmoItems.BLISTERBERRY_SORBET,
                CosmoItems.AURORA_KOHAKUTOU, CosmoItems.STEELEAF_NECTAR, CosmoItems.GLACIER_ESSENCE, CosmoItems.MATCHA_ICE_CREAM_CONE, CosmoItems.SALMONBERRY_ICE_CREAM_CONE, CosmoItems.LIME_ICE_CREAM_CONE, CosmoItems.POMEGRANATE_ICE_CREAM_CONE,
                CosmoItems.BEETROOT_ICE_CREAM_CONE, CosmoItems.PUMPKIN_ICE_CREAM_CONE, CosmoItems.SWEET_BERRY_ICE_CREAM_CONE, CosmoItems.SEASONAL_ICE_CREAM, CosmoItems.SEASONAL_ICE_CREAM_SANDWICH,
                CosmoItems.ALOE_ICE_CREAM_CONE, CosmoItems.PASSION_FRUIT_ICE_CREAM_CONE, CosmoItems.YUCCA_ICE_CREAM_CONE, CosmoItems.PECULIAR_ICE_CREAM, CosmoItems.PECULIAR_ICE_CREAM_SANDWICH,
                CosmoItems.AURORA_ICE_CREAM_CONE, CosmoItems.GLACIER_ICE_CREAM_CONE, CosmoItems.PHYTOCHEMICAL_ICE_CREAM_CONE, CosmoItems.TORCHBERRY_ICE_CREAM_CONE,
                CosmoItems.RAINBOW_ICE_CREAM_SANDWICH, CosmoItems.REFRESHING_ICE_CREAM_SANDWICH, CosmoItems.TWILIGHT_ICE_CREAM_SANDWICH
        );
    }
}
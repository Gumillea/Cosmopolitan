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
                CosmoItems.WAFER,
                CosmoItems.POTATO_PANCAKES,
                CosmoItems.NEAPOLITAN_ICE_CREAM_SANDWICH,
                CosmoItems.AURORA_KOHAKUTOU, CosmoItems.STEELEAF_NECTAR, CosmoItems.GLACIER_ESSENCE,
                CosmoItems.BEETROOT_ICE_CREAM_CONE, CosmoItems.PUMPKIN_ICE_CREAM_CONE, CosmoItems.SWEET_BERRY_ICE_CREAM_CONE,
                CosmoItems.AURORA_ICE_CREAM_CONE, CosmoItems.GLACIER_ICE_CREAM_CONE, CosmoItems.PHYTOCHEMICAL_ICE_CREAM_CONE, CosmoItems.TORCHBERRY_ICE_CREAM_CONE,
                CosmoItems.RAINBOW_ICE_CREAM_SANDWICH, CosmoItems.REFRESHING_ICE_CREAM_SANDWICH, CosmoItems.TWILIGHT_ICE_CREAM_SANDWICH
        );
    }
}
package com.gumillea.cosmopolitan.core.data.models;

import com.gumillea.cosmopolitan.Cosmopolitan;
import com.gumillea.cosmopolitan.core.reg.CosmoBlocks;
import com.teamabnormals.blueprint.core.data.client.BlueprintBlockStateProvider;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;

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

        this.logBlock(CosmoBlocks.WHEATGRASS_BALE);
    }
}
package com.gumillea.cosmopolitan.core.reg.client;

import com.gumillea.cosmopolitan.Cosmopolitan;
import com.gumillea.cosmopolitan.common.client.FrozenDessertTubRenderer;
import com.gumillea.cosmopolitan.core.reg.CosmoBlockEntityTypes;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = Cosmopolitan.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class CosmoClientReg {
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        BlockEntityRenderers.register(CosmoBlockEntityTypes.FROZEN_DESSERT_TUB.get(), FrozenDessertTubRenderer::new);
    }
}

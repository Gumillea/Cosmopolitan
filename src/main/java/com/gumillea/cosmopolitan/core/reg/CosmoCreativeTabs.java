package com.gumillea.cosmopolitan.core.reg;

import com.gumillea.cosmopolitan.CosmoConfig;
import com.gumillea.cosmopolitan.Cosmopolitan;
import com.gumillea.cosmopolitan.core.util.CosmoCompat;
import com.gumillea.exquisito.core.ExquisitoConfig;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class CosmoCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Cosmopolitan.MODID);

    public static final RegistryObject<CreativeModeTab> COSMO_TAB = TABS.register("tab", () -> CreativeModeTab.builder()
            .title(Component.translatable("item_group." + Cosmopolitan.MODID + ".tab"))
            .icon(() -> new ItemStack(CosmoItems.COSMOPOLITAN_COCKTAIL.get()))
            .displayItems((parameters, output) -> {
                //BLOCKS
                output.accept(CosmoBlocks.COPPER_FROZEN_DESSERT_TUB.get());
                output.accept(CosmoBlocks.IRON_FROZEN_DESSERT_TUB.get());
                output.accept(CosmoBlocks.WHEATGRASS_BALE.get());
                output.accept(CosmoBlocks.MASHED_POTATO_BLOCK.get());
                if (CosmoCompat.nea) {
                    output.accept(CosmoBlocks.APPLE_ICE_CREAM_BLOCK.get());
                    output.accept(CosmoBlocks.CARROT_ICE_CREAM_BLOCK.get());
                    output.accept(CosmoBlocks.GLOW_BERRY_ICE_CREAM_BLOCK.get());
                    output.accept(CosmoBlocks.ENCHANTED_FRUIT_ICE_CREAM_BLOCK.get());
                    output.accept(CosmoBlocks.KABLOOM_ICE_CREAM_BLOCK.get());
                    output.accept(CosmoBlocks.SOURCE_BERRY_ICE_CREAM_BLOCK.get());
                    output.accept(CosmoBlocks.CHISELED_ADZUKI_ICE_CREAM_BLOCK.get());
                    output.accept(CosmoBlocks.CHISELED_BANANA_ICE_CREAM_BLOCK.get());
                    output.accept(CosmoBlocks.CHISELED_CHOCOLATE_ICE_CREAM_BLOCK.get());
                    output.accept(CosmoBlocks.CHISELED_MINT_ICE_CREAM_BLOCK.get());
                    output.accept(CosmoBlocks.CHISELED_STRAWBERRY_ICE_CREAM_BLOCK.get());
                    output.accept(CosmoBlocks.CHISELED_VANILLA_ICE_CREAM_BLOCK.get());
                }
                if (CosmoCompat.bg && CosmoConfig.Common.BERRY_GOOD_COMPAT_TWEAKS.get()) {
                    if (CosmoCompat.an) output.accept(CosmoItems.SOURCE_BERRY_PIPS.get());
                    if (CosmoCompat.ha) output.accept(CosmoItems.KABLOOM_PIPS.get());
                    if (CosmoCompat.ug) {
                        output.accept(CosmoItems.BLISTERBERRY_PIPS.get());
                        output.accept(CosmoItems.DROOPFRUIT_PIPS.get());
                    }
                }
                //ITEMS
                output.accept(CosmoItems.WILDBERRY.get());
                output.accept(CosmoItems.FIDDLEHEAD.get());
                output.accept(CosmoItems.BAKED_FIDDLEHEAD.get());
                output.accept(CosmoItems.IRON_FIDDLEHEAD.get());
                output.accept(CosmoItems.WHEATGRASS.get());
                if (CosmoCompat.fd) {
                    output.accept(CosmoItems.CUT_POTATOES.get());
                    output.accept(CosmoItems.POTATO_WEDGES.get());
                    if (CosmoCompat.cad || CosmoCompat.fcd) {
                        output.accept(CosmoItems.POTATO_PANCAKES.get());
                    }
                }
                if (CosmoCompat.tf) {
                    output.accept(CosmoItems.AURORA_KOHAKUTOU.get());
                    output.accept(CosmoItems.GLACIER_ESSENCE.get());
                }

                output.accept(CosmoItems.JELLY_ROLL.get());
                if (CosmoCompat.fd) output.accept(CosmoItems.JELLY_ROLL_SLICE.get());
                output.accept(CosmoItems.CHOCOLATE_ROLL.get());
                if (CosmoCompat.fd) output.accept(CosmoItems.CHOCOLATE_ROLL_SLICE.get());
                output.accept(CosmoItems.PAW_COOKIE.get());
                if (CosmoCompat.an) output.accept(CosmoItems.MENDOSTEEN_TART.get());
                if (CosmoCompat.ug) {
                    output.accept(CosmoItems.BLISTERBERRY_TART.get());
                    output.accept(CosmoItems.RAINDROOP_CAKE.get());
                }
                output.accept(CosmoItems.TOFFEE_APPLE.get());
                output.accept(CosmoItems.TOFFEE_GOLDEN_APPLE.get());

                if (CosmoConfig.Common.GULIME.get()) {
                    output.accept(CosmoItems.GULIME.get());
                    output.accept(CosmoItems.GULIME_SMALL.get());
                    output.accept(CosmoItems.UNDERGROUND_GULIME.get());
                    output.accept(CosmoItems.UNDERGROUND_GULIME_SMALL.get());
                    output.accept(CosmoItems.TAIGA_GULIME.get());
                    output.accept(CosmoItems.TAIGA_GULIME_SMALL.get());
                    output.accept(CosmoItems.CHORUS_GULIME.get());
                    output.accept(CosmoItems.CHORUS_GULIME_SMALL.get());
                    if (CosmoCompat.qua) {
                        output.accept(CosmoItems.GLIMMERING_GULIME.get());
                        output.accept(CosmoItems.GLIMMERING_GULIME_SMALL.get());
                    }
                    if (CosmoCompat.nea) {
                        output.accept(CosmoItems.STRAWBERRY_GULIME.get());
                        output.accept(CosmoItems.STRAWBERRY_GULIME_SMALL.get());
                    }
                }

                output.accept(CosmoItems.BERRY_SYRUP_BOTTLE.get());
                if (CosmoCompat.tf) output.accept(CosmoItems.STEELEAF_NECTAR.get());

                output.accept(CosmoItems.COSMOPOLITAN_COCKTAIL.get());

                output.accept(CosmoItems.CLASSIC_FRUIT_SALAD.get());
                output.accept(CosmoItems.MASHED_POTATO.get());
                if (CosmoCompat.fd) {
                    output.accept(CosmoItems.GREEN_SAUCE.get());
                    output.accept(CosmoItems.GREEN_CREAM_STEW.get());
                    output.accept(CosmoItems.GREEN_PASTA.get());
                }
                if (CosmoCompat.mf) {
                    output.accept(CosmoItems.GREEN_CREAM_STEW_CUP.get());
                    if (CosmoCompat.vc) {
                        output.accept(CosmoItems.JELLY_CUP.get());
                        output.accept(CosmoItems.MAGMA_JELLY_CUP.get());
                    }
                }

                //ice_dessert
                if (CosmoCompat.nea) {
                    if (CosmoCompat.ug) {
                        output.accept(CosmoItems.BLISTERBERRY_SORBET.get());
                        output.accept(CosmoItems.DROOPFRUIT_SORBET.get());
                    }
                    if (CosmoConfig.Common.APPLE_FLAVOR.get()) output.accept(CosmoItems.APPLE_ICE_CREAM.get());
                    if (CosmoConfig.Common.CARROT_FLAVOR.get()) output.accept(CosmoItems.CARROT_ICE_CREAM.get());
                    if (CosmoConfig.Common.GLOW_BERRY_FLAVOR.get()) output.accept(CosmoItems.GLOW_BERRY_ICE_CREAM.get());
                    if (CosmoCompat.qua && CosmoConfig.Common.ENCHANTED_FRUIT_FLAVOR.get()) output.accept(CosmoItems.ENCHANTED_FRUIT_ICE_CREAM.get());
                    if (CosmoCompat.an && CosmoConfig.Common.SOURCE_BERRY_FLAVOR.get()) output.accept(CosmoItems.SOURCE_BERRY_ICE_CREAM.get());
                    if (CosmoCompat.ha && CosmoConfig.Common.KABLOOM_FLAVOR.get()) output.accept(CosmoItems.KABLOOM_ICE_CREAM.get());
                    if (CosmoCompat.pec) output.accept(CosmoItems.PECULIAR_ICE_CREAM.get());
                    if (CosmoCompat.sea) output.accept(CosmoItems.SEASONAL_ICE_CREAM.get());
                }
                //cones
                if (CosmoCompat.ug) {
                    output.accept(CosmoItems.BLISTERBERRY_DOUBLE_POPSICLE.get());
                    output.accept(CosmoItems.BLISTERBERRY_POPSICLE.get());
                }
                output.accept(CosmoItems.WAFER.get());
                if (CosmoCompat.nea) {
                    output.accept(CosmoItems.NEAPOLITAN_ICE_CREAM_SANDWICH.get());
                    if (CosmoCompat.pec) output.accept(CosmoItems.PECULIAR_ICE_CREAM_SANDWICH.get());
                    if (CosmoCompat.sea) output.accept(CosmoItems.SEASONAL_ICE_CREAM_SANDWICH.get());
                    if (CosmoCompat.tfd) {
                        output.accept(CosmoItems.RAINBOW_ICE_CREAM_SANDWICH.get());
                        output.accept(CosmoItems.REFRESHING_ICE_CREAM_SANDWICH.get());
                        output.accept(CosmoItems.TWILIGHT_ICE_CREAM_SANDWICH.get());
                    }
                }
                output.accept(CosmoItems.WAFER_CONE.get());
                output.accept(CosmoItems.SNOW_CONE.get());
                output.accept(CosmoItems.MASHED_POTATO_CONE.get());
                if (CosmoCompat.nea) {
                    output.accept(CosmoItems.ADZUKI_ICE_CREAM_CONE.get());
                    output.accept(CosmoItems.BANANA_ICE_CREAM_CONE.get());
                    output.accept(CosmoItems.CHOCOLATE_ICE_CREAM_CONE.get());
                    output.accept(CosmoItems.MINT_ICE_CREAM_CONE.get());
                    output.accept(CosmoItems.STRAWBERRY_ICE_CREAM_CONE.get());
                    output.accept(CosmoItems.VANILLA_ICE_CREAM_CONE.get());
                    if (CosmoConfig.Common.APPLE_FLAVOR.get()) output.accept(CosmoItems.APPLE_ICE_CREAM_CONE.get());
                    if (CosmoConfig.Common.CARROT_FLAVOR.get()) output.accept(CosmoItems.CARROT_ICE_CREAM_CONE.get());
                    if (CosmoConfig.Common.GLOW_BERRY_FLAVOR.get()) output.accept(CosmoItems.GLOW_BERRY_ICE_CREAM_CONE.get());
                    if (CosmoCompat.qua && CosmoConfig.Common.ENCHANTED_FRUIT_FLAVOR.get()) output.accept(CosmoItems.ENCHANTED_FRUIT_ICE_CREAM_CONE.get());
                    if (CosmoCompat.an && (CosmoConfig.Common.SOURCE_BERRY_FLAVOR.get() || CosmoCompat.df)) output.accept(CosmoItems.SOURCE_BERRY_ICE_CREAM_CONE.get());
                    if (CosmoCompat.ha && CosmoConfig.Common.KABLOOM_FLAVOR.get()) output.accept(CosmoItems.KABLOOM_ICE_CREAM_CONE.get());
                    if (CosmoCompat.ex) {
                        if (ExquisitoConfig.Common.CHORUS_FLAVOR.get()) output.accept(CosmoItems.CHORUS_ICE_CREAM_CONE.get());
                        if (ExquisitoConfig.Common.ELMOND_FLAVOR.get()) output.accept(CosmoItems.WARZIPAN_ICE_CREAM_CONE.get());
                        if (ExquisitoConfig.Common.NIGHTSHADE_BERRY_FLAVOR.get()) output.accept(CosmoItems.MIDNIGHT_ICE_CREAM_CONE.get());
                        if (ExquisitoConfig.Common.ETHER_BULB_FLAVOR.get()) output.accept(CosmoItems.STARCLOUD_ICE_CREAM_CONE.get());
                        if (CosmoCompat.ee && ExquisitoConfig.Common.JELLY_RING_FLAVOR.get()) output.accept(CosmoItems.JELLY_RING_ICE_CREAM_CONE.get());
                        if (CosmoCompat.ee && ExquisitoConfig.Common.ZURE_BERRY_FLAVOR.get()) output.accept(CosmoItems.AZURE_BERRY_ICE_CREAM_CONE.get());
                    }
                    if (CosmoCompat.pec) {
                        output.accept(CosmoItems.ALOE_ICE_CREAM_CONE.get());
                        output.accept(CosmoItems.PASSION_FRUIT_ICE_CREAM_CONE.get());
                        output.accept(CosmoItems.YUCCA_ICE_CREAM_CONE.get());
                    }
                    if (CosmoCompat.sea) {
                        output.accept(CosmoItems.BEETROOT_ICE_CREAM_CONE.get());
                        output.accept(CosmoItems.PUMPKIN_ICE_CREAM_CONE.get());
                        output.accept(CosmoItems.SWEET_BERRY_ICE_CREAM_CONE.get());
                    }
                    if (CosmoCompat.cr) {
                        output.accept(CosmoItems.LIME_ICE_CREAM_CONE.get());
                        output.accept(CosmoItems.POMEGRANATE_ICE_CREAM_CONE.get());
                    }
                    if (CosmoCompat.df) {
                        output.accept(CosmoItems.MATCHA_ICE_CREAM_CONE.get());
                        output.accept(CosmoItems.SALMONBERRY_ICE_CREAM_CONE.get());
                    }
                    if (CosmoCompat.tfd) {
                        output.accept(CosmoItems.AURORA_ICE_CREAM_CONE.get());
                        output.accept(CosmoItems.GLACIER_ICE_CREAM_CONE.get());
                        output.accept(CosmoItems.PHYTOCHEMICAL_ICE_CREAM_CONE.get());
                        output.accept(CosmoItems.TORCHBERRY_ICE_CREAM_CONE.get());
                    }
                }
            })
            .build());
}
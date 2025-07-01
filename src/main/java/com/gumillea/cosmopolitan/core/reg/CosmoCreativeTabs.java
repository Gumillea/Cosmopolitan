package com.gumillea.cosmopolitan.core.reg;

import com.gumillea.cosmopolitan.CosmoConfig;
import com.gumillea.cosmopolitan.Cosmopolitan;
import com.gumillea.cosmopolitan.common.item.HerbalCookieItem;
import com.gumillea.cosmopolitan.core.util.CosmoCompat;
import com.gumillea.cosmopolitan.core.util.CosmoItemTags;
import com.gumillea.exquisito.core.ExquisitoConfig;
import net.brdle.collectorsreap.common.item.CRItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.SuspiciousEffectHolder;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.Set;

public class CosmoCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Cosmopolitan.MODID);

    public static final RegistryObject<CreativeModeTab> COSMO_TAB = TABS.register("tab", () -> CreativeModeTab.builder()
            .title(Component.translatable("item_group." + Cosmopolitan.MODID + ".tab"))
            .icon(() -> new ItemStack(CosmoItems.WILDBERRY.get()))
            .displayItems((parameters, output) -> {
                //BLOCKS
                output.accept(CosmoBlocks.COPPER_FROZEN_DESSERT_TUB.get());
                output.accept(CosmoBlocks.IRON_FROZEN_DESSERT_TUB.get());
                output.accept(CosmoBlocks.SAPPY_BIRCH_LOG.get());
                output.accept(CosmoBlocks.WHEATGRASS_BALE.get());
                output.accept(CosmoBlocks.WILDBERRIES_BASKET.get());
                output.accept(CosmoBlocks.FIDDLEHEAD_CRATE.get());
                output.accept(CosmoBlocks.IRON_FIDDLEHEAD_CRATE.get());
                output.accept(CosmoBlocks.MASHED_POTATO_BLOCK.get());
                output.accept(CosmoBlocks.BERRY_SYRUP_BLOCK.get());
                output.accept(CosmoBlocks.BIRCH_SAP_BLOCK.get());
                if (CosmoCompat.tf) output.accept(CosmoBlocks.STEELEAF_NECTAR_BLOCK.get());
                if (CosmoCompat.nea) {
                    if (CosmoConfig.Common.APPLE_FLAVOR.get()) output.accept(CosmoBlocks.APPLE_ICE_CREAM_BLOCK.get());
                    if (CosmoConfig.Common.CARROT_FLAVOR.get()) output.accept(CosmoBlocks.CARROT_ICE_CREAM_BLOCK.get());
                    if (CosmoConfig.Common.GLOW_BERRY_FLAVOR.get()) output.accept(CosmoBlocks.GLOW_BERRY_ICE_CREAM_BLOCK.get());
                    if (CosmoCompat.qua && CosmoConfig.Common.ENCHANTED_FRUIT_FLAVOR.get()) output.accept(CosmoBlocks.ENCHANTED_FRUIT_ICE_CREAM_BLOCK.get());
                    if (CosmoCompat.ha && CosmoConfig.Common.KABLOOM_FLAVOR.get()) output.accept(CosmoBlocks.KABLOOM_ICE_CREAM_BLOCK.get());
                    if (CosmoCompat.an && CosmoConfig.Common.SOURCE_BERRY_FLAVOR.get()) output.accept(CosmoBlocks.SOURCE_BERRY_ICE_CREAM_BLOCK.get());
                    if (CosmoCompat.tfd) {
                        output.accept(CosmoBlocks.AURORA_ICE_CREAM_BLOCK.get());
                        output.accept(CosmoBlocks.GLACIER_ICE_CREAM_BLOCK.get());
                        output.accept(CosmoBlocks.PHYTOCHEMICAL_ICE_CREAM_BLOCK.get());
                        output.accept(CosmoBlocks.TORCHBERRY_ICE_CREAM_BLOCK.get());
                    }
                    if (CosmoCompat.sd) output.accept(CosmoBlocks.CHERRY_ICE_CREAM_BLOCK.get());

                    output.accept(CosmoBlocks.ADZUKI_ICE_CREAM_BRICKS.get());
                    output.accept(CosmoBlocks.BANANA_ICE_CREAM_BRICKS.get());
                    output.accept(CosmoBlocks.CHOCOLATE_ICE_CREAM_BRICKS.get());
                    output.accept(CosmoBlocks.MINT_ICE_CREAM_BRICKS.get());
                    output.accept(CosmoBlocks.STRAWBERRY_ICE_CREAM_BRICKS.get());
                    output.accept(CosmoBlocks.VANILLA_ICE_CREAM_BRICKS.get());
                    if (CosmoConfig.Common.APPLE_FLAVOR.get()) output.accept(CosmoBlocks.APPLE_ICE_CREAM_BRICKS.get());
                    if (CosmoConfig.Common.CARROT_FLAVOR.get()) output.accept(CosmoBlocks.CARROT_ICE_CREAM_BRICKS.get());
                    if (CosmoConfig.Common.GLOW_BERRY_FLAVOR.get()) output.accept(CosmoBlocks.GLOW_BERRY_ICE_CREAM_BRICKS.get());
                    if (CosmoCompat.qua && CosmoConfig.Common.ENCHANTED_FRUIT_FLAVOR.get()) output.accept(CosmoBlocks.ENCHANTED_FRUIT_ICE_CREAM_BRICKS.get());
                    if (CosmoCompat.ha && CosmoConfig.Common.KABLOOM_FLAVOR.get()) output.accept(CosmoBlocks.KABLOOM_ICE_CREAM_BRICKS.get());
                    if (CosmoCompat.an && CosmoConfig.Common.SOURCE_BERRY_FLAVOR.get()) output.accept(CosmoBlocks.SOURCE_BERRY_ICE_CREAM_BRICKS.get());
                    if (CosmoCompat.ex) {
                        if (ExquisitoConfig.Common.CHORUS_FLAVOR.get()) output.accept(CosmoBlocks.CHORUS_FRUIT_ICE_CREAM_BRICKS.get());
                        if (ExquisitoConfig.Common.ELMOND_FLAVOR.get()) output.accept(CosmoBlocks.WARZIPAN_ICE_CREAM_BRICKS.get());
                        if (ExquisitoConfig.Common.NIGHTSHADE_BERRY_FLAVOR.get()) output.accept(CosmoBlocks.MIDNIGHT_ICE_CREAM_BRICKS.get());
                        if (ExquisitoConfig.Common.ETHER_BULB_FLAVOR.get()) output.accept(CosmoBlocks.STARCLOUD_ICE_CREAM_BRICKS.get());
                        if (CosmoCompat.ee && ExquisitoConfig.Common.JELLY_RING_FLAVOR.get()) output.accept(CosmoBlocks.JELLY_RING_ICE_CREAM_BRICKS.get());
                        if (CosmoCompat.ee && ExquisitoConfig.Common.ZURE_BERRY_FLAVOR.get()) output.accept(CosmoBlocks.AZURE_BERRY_ICE_CREAM_BRICKS.get());
                    }
                    if (CosmoCompat.pec) {
                        output.accept(CosmoBlocks.ALOE_ICE_CREAM_BRICKS.get());
                        output.accept(CosmoBlocks.PASSION_FRUIT_ICE_CREAM_BRICKS.get());
                        output.accept(CosmoBlocks.YUCCA_ICE_CREAM_BRICKS.get());
                    }
                    if (CosmoCompat.sea) {
                        output.accept(CosmoBlocks.BEETROOT_ICE_CREAM_BRICKS.get());
                        output.accept(CosmoBlocks.PUMPKIN_ICE_CREAM_BRICKS.get());
                        output.accept(CosmoBlocks.SWEET_BERRY_ICE_CREAM_BRICKS.get());
                    }
                    if (CosmoCompat.cr) {
                        output.accept(CosmoBlocks.LIME_ICE_CREAM_BRICKS.get());
                        output.accept(CosmoBlocks.POMEGRANATE_ICE_CREAM_BRICKS.get());
                    }
                    if (CosmoCompat.df) {
                        output.accept(CosmoBlocks.MATCHA_ICE_CREAM_BRICKS.get());
                        output.accept(CosmoBlocks.SALMONBERRY_ICE_CREAM_BRICKS.get());
                    }
                    if (CosmoCompat.tfd) {
                        output.accept(CosmoBlocks.AURORA_ICE_CREAM_BRICKS.get());
                        output.accept(CosmoBlocks.GLACIER_ICE_CREAM_BRICKS.get());
                        output.accept(CosmoBlocks.PHYTOCHEMICAL_ICE_CREAM_BRICKS.get());
                        output.accept(CosmoBlocks.TORCHBERRY_ICE_CREAM_BRICKS.get());
                    }
                    if (CosmoCompat.rf) {
                        output.accept(CosmoBlocks.GREEN_TEA_ICE_CREAM_BRICKS.get());
                        output.accept(CosmoBlocks.YELLOW_TEA_ICE_CREAM_BRICKS.get());
                        output.accept(CosmoBlocks.BLACK_TEA_ICE_CREAM_BRICKS.get());
                        output.accept(CosmoBlocks.COFFEE_ICE_CREAM_BRICKS.get());
                    }
                    if (CosmoCompat.sud) {
                        output.accept(CosmoBlocks.FLAVORED_ICE_CREAM_BRICKS.get());
                        output.accept(CosmoBlocks.GLOWY_ICE_CREAM_BRICKS.get());
                    }
                    if (CosmoCompat.sd) output.accept(CosmoBlocks.CHERRY_ICE_CREAM_BRICKS.get());

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
                        output.accept(CosmoItems.SPROUTED_UNDERBEANS.get());
                        output.accept(CosmoItems.DROOPFRUIT_PIPS.get());
                    }
                }
                //ITEMS
                output.accept(CosmoItems.WILDBERRY.get());
                output.accept(CosmoItems.FIDDLEHEAD.get());
                output.accept(CosmoItems.BAKED_FIDDLEHEAD.get());
                output.accept(CosmoItems.IRON_FIDDLEHEAD.get());
                output.accept(CosmoItems.WHEATGRASS.get());
                output.accept(CosmoItems.TUBER.get());
                output.accept(CosmoItems.ROASTED_TUBER.get());
                if (CosmoCompat.fd) {
                    output.accept(CosmoItems.CUT_POTATOES.get());
                    output.accept(CosmoItems.POTATO_WEDGES.get());
                    if (CosmoCompat.cad || CosmoCompat.fcd) {
                        output.accept(CosmoItems.POTATO_PANCAKES.get());
                    }
                }
                output.accept(CosmoItems.ROASTED_MUSHROOM.get());
                if (CosmoCompat.tf) {
                    output.accept(CosmoItems.AURORA_KOHAKUTOU.get());
                    output.accept(CosmoItems.GLACIER_ESSENCE.get());
                }

                output.accept(CosmoItems.WOODLAND_SUB.get());
                output.accept(CosmoItems.TRAVELERS_PANINI.get());
                if (!CosmoCompat.isTagEmpty(CosmoItemTags.CATTAILS)) output.accept(CosmoItems.HOT_CATTAIL.get());
                output.accept(CosmoItems.CREAM_BUN.get());
                if (CosmoCompat.nea) {
                    output.accept(CosmoItems.CHOCOLATE_BANANA_CREAM_BUN.get());
                    output.accept(CosmoItems.STRAWBERRY_VANILLA_CREAM_BUN.get());
                    output.accept(CosmoItems.ADZUKI_MINT_CREAM_BUN.get());
                }
                output.accept(CosmoItems.JELLY_ROLL.get());
                if (CosmoCompat.fd) output.accept(CosmoItems.JELLY_ROLL_SLICE.get());
                output.accept(CosmoItems.CHOCOLATE_ROLL.get());
                if (CosmoCompat.fd) output.accept(CosmoItems.CHOCOLATE_ROLL_SLICE.get());
                output.accept(CosmoItems.INK_ROLL.get());
                if (CosmoCompat.fd) output.accept(CosmoItems.INK_ROLL_SLICE.get());
                output.accept(CosmoItems.BIRCH_COOKIE.get());
                output.accept(CosmoItems.PAW_COOKIE.get());
                generateHerbalCookies(output, CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                if (CosmoCompat.an) output.accept(CosmoItems.MENDOSTEEN_TART.get());
                if (CosmoCompat.ug) {
                    output.accept(CosmoItems.BLISTERBERRY_TART.get());
                    output.accept(CosmoItems.RAINDROOP_CAKE.get());
                }
                output.accept(CosmoItems.BERRY_CHEESECAKE_BAR.get());
                output.accept(CosmoItems.WHEATGRASS_CUBECAKE.get());
                output.accept(CosmoItems.GLOW_BERRY_CUBECAKE.get());

                output.accept(CosmoItems.LLAMA_MARSHMALLOW.get());
                output.accept(CosmoItems.LLAMA_MARSHMALLOW_BROWN.get());
                output.accept(CosmoItems.LLAMA_MARSHMALLOW_TRADER.get());

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

                output.accept(CosmoItems.CLASSIC_FRUIT_SALAD.get());
                output.accept(CosmoItems.JELLO_SALAD.get());
                output.accept(CosmoItems.MASHED_POTATO.get());
                output.accept(CosmoItems.TUBER_PUREE.get());
                output.accept(CosmoItems.TUBER_PUREE_WITH_BERRY_SYRUP.get());
                if (CosmoCompat.fd) {
                    output.accept(CosmoItems.GREEN_SAUCE.get());
                    output.accept(CosmoItems.GREEN_CREAM_STEW.get());
                }
                output.accept(CosmoItems.LUSH_STEW.get());
                if (CosmoCompat.fd) {
                    output.accept(CosmoItems.GREEN_PASTA.get());
                    output.accept(CosmoItems.WILD_RISOTTO.get());
                }
                if (CosmoCompat.mf) {
                    output.accept(CosmoItems.JELLO_SALAD_CUP.get());
                    output.accept(CosmoItems.GREEN_CREAM_STEW_CUP.get());
                    output.accept(CosmoItems.LUSH_STEW_CUP.get());
                }

                output.accept(CosmoItems.CONDENSED_MILK_BUCKET.get());
                output.accept(CosmoItems.CONDENSED_MILK_BOTTLE.get());
                output.accept(CosmoItems.CREAM_BUCKET.get());
                output.accept(CosmoItems.CREAM.get());
                output.accept(CosmoItems.BIRCH_SAP_BOTTLE.get());
                output.accept(CosmoItems.BERRY_SYRUP_BOTTLE.get());
                if (CosmoCompat.tf) output.accept(CosmoItems.STEELEAF_NECTAR.get());
                if (CosmoCompat.fd) {
                    output.accept(CosmoItems.SPRING_SODA.get());
                    output.accept(CosmoItems.SUMMER_CORDIAL.get());
                    output.accept(CosmoItems.AUTUMN_TEA.get());
                    output.accept(CosmoItems.WINTER_GLOGG.get());
                }
                if (CosmoCompat.bnc) {
                    output.accept(CosmoItems.ROOT_BEER.get());
                    output.accept(CosmoItems.WILDBERRY_PUNCH.get());
                    if (CosmoCompat.tf) output.accept(CosmoItems.TWILIGHT_CHARTREUSE.get());
                    if (CosmoCompat.ug) output.accept(CosmoItems.SMOGGY_APEROL.get());
                }

                output.accept(CosmoItems.COSMOPOLITAN_COCKTAIL.get());
                output.accept(CosmoItems.ENCHANTED_COSMOPOLITAN_COCKTAIL.get());

                //ice_dessert
                if (CosmoCompat.nea) {
                    if (CosmoConfig.Common.APPLE_FLAVOR.get()) output.accept(CosmoItems.APPLE_MILKSHAKE.get());
                    if (CosmoConfig.Common.CARROT_FLAVOR.get()) output.accept(CosmoItems.CARROT_MILKSHAKE.get());
                    if (CosmoConfig.Common.GLOW_BERRY_FLAVOR.get()) output.accept(CosmoItems.GLOW_BERRY_MILKSHAKE.get());
                    if (CosmoCompat.qua && CosmoConfig.Common.ENCHANTED_FRUIT_FLAVOR.get()) output.accept(CosmoItems.ENCHANTED_FRUIT_MILKSHAKE.get());
                    if (CosmoCompat.an && CosmoConfig.Common.SOURCE_BERRY_FLAVOR.get()) output.accept(CosmoItems.SOURCE_BERRY_MILKSHAKE.get());
                    if (CosmoCompat.ha && CosmoConfig.Common.KABLOOM_FLAVOR.get()) output.accept(CosmoItems.KABLOOM_MILKSHAKE.get());

                    if (CosmoCompat.fd) output.accept(CosmoItems.ICE_CREAM_FLOAT.get());
                    if (CosmoCompat.bnc) output.accept(CosmoItems.BLACK_COW.get());

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
                    if (CosmoConfig.Common.APPLE_FLAVOR.get() && CosmoConfig.Common.CARROT_FLAVOR.get() && CosmoConfig.Common.GLOW_BERRY_FLAVOR.get()) output.accept(CosmoItems.CLASSIC_ICE_CREAM.get());
                    if (CosmoCompat.pec) output.accept(CosmoItems.PECULIAR_ICE_CREAM.get());
                    if (CosmoCompat.sea) output.accept(CosmoItems.SEASONAL_ICE_CREAM.get());
                }
                //cones
                output.accept(CosmoItems.BERRY_DOUBLE_POPSICLE.get());
                output.accept(CosmoItems.BERRY_POPSICLE.get());
                output.accept(CosmoItems.CHORUS_FRUIT_DOUBLE_POPSICLE.get());
                output.accept(CosmoItems.CHORUS_FRUIT_POPSICLE.get());
                if (CosmoCompat.ug) {
                    output.accept(CosmoItems.BLISTERBERRY_DOUBLE_POPSICLE.get());
                    output.accept(CosmoItems.BLISTERBERRY_POPSICLE.get());
                }
                if (CosmoCompat.cr)  {
                    output.accept(CosmoItems.LIME_DOUBLE_POPSICLE.get());
                    output.accept(CRItems.LIME_POPSICLE.get());
                }
                output.accept(CosmoItems.WAFER.get());
                if (CosmoCompat.nea) {
                    output.accept(CosmoItems.NEAPOLITAN_ICE_CREAM_SANDWICH.get());
                    if (CosmoConfig.Common.APPLE_FLAVOR.get() && CosmoConfig.Common.CARROT_FLAVOR.get() && CosmoConfig.Common.GLOW_BERRY_FLAVOR.get()) output.accept(CosmoItems.CLASSIC_ICE_CREAM_SANDWICH.get());
                    if (CosmoCompat.pec) output.accept(CosmoItems.PECULIAR_ICE_CREAM_SANDWICH.get());
                    if (CosmoCompat.sea) output.accept(CosmoItems.SEASONAL_ICE_CREAM_SANDWICH.get());
                    if (CosmoCompat.tfd) {
                        output.accept(CosmoItems.RAINBOW_ICE_CREAM_SANDWICH.get());
                        output.accept(CosmoItems.REFRESHING_ICE_CREAM_SANDWICH.get());
                        output.accept(CosmoItems.TWILIGHT_ICE_CREAM_SANDWICH.get());
                    }
                    if (CosmoCompat.rf) output.accept(CosmoItems.RESPITEFUL_ICE_CREAM_SANDWICH.get());
                    if (CosmoCompat.sud) output.accept(CosmoItems.TRICOLORED_ICE_CREAM_SANDWICH.get());
                }
                output.accept(CosmoItems.WAFER_CONE.get());
                output.accept(CosmoItems.MASHED_POTATO_CONE.get());
                output.accept(CosmoItems.TUBER_PUREE_CONE.get());
                output.accept(CosmoItems.TUBER_PUREE_CONE_WITH_BERRY_SYRUP.get());
                output.accept(CosmoItems.SNOW_CONE.get());
                output.accept(CosmoItems.WANDERING_GELATO.get());
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
                    if (CosmoCompat.rf) {
                        output.accept(CosmoItems.GREEN_TEA_ICE_CREAM_CONE.get());
                        output.accept(CosmoItems.YELLOW_TEA_ICE_CREAM_CONE.get());
                        output.accept(CosmoItems.BLACK_TEA_ICE_CREAM_CONE.get());
                        output.accept(CosmoItems.COFFEE_ICE_CREAM_CONE.get());
                    }
                    if (CosmoCompat.sud) {
                        output.accept(CosmoItems.FLAVORED_ICE_CREAM_CONE.get());
                        output.accept(CosmoItems.GLOWY_ICE_CREAM_CONE.get());
                    }
                    if (CosmoCompat.sd) output.accept(CosmoItems.CHERRY_ICE_CREAM_CONE.get());
                }
            })
            .build());

    private static void generateHerbalCookies(CreativeModeTab.Output output, CreativeModeTab.TabVisibility visibility) {
        List<SuspiciousEffectHolder> list = SuspiciousEffectHolder.getAllEffectHolders();
        Set<ItemStack> set = ItemStackLinkedSet.createTypeAndTagSet();

        for(SuspiciousEffectHolder suspiciouseffectholder : list) {
            ItemStack itemstack = new ItemStack(CosmoItems.HERBAL_COOKIE.get());
            HerbalCookieItem.saveMobEffect(itemstack, suspiciouseffectholder.getSuspiciousEffect(), suspiciouseffectholder.getEffectDuration());
            set.add(itemstack);
        }

        output.acceptAll(set, visibility);
    }

}
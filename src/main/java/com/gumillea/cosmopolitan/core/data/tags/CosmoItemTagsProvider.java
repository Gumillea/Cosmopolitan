package com.gumillea.cosmopolitan.core.data.tags;

import com.gumillea.cosmopolitan.Cosmopolitan;
import com.gumillea.cosmopolitan.core.reg.CosmoBlocks;
import com.gumillea.cosmopolitan.core.reg.CosmoItems;
import com.gumillea.cosmopolitan.core.util.CosmoBlockTags;
import com.gumillea.cosmopolitan.core.util.CosmoCompat;
import com.gumillea.cosmopolitan.core.util.CosmoItemTags;
import com.teamabnormals.blueprint.core.other.tags.BlueprintItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

public class CosmoItemTagsProvider extends ItemTagsProvider {
    public CosmoItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> provider, CompletableFuture<TagsProvider.TagLookup<Block>> lookup, ExistingFileHelper helper) {
        super(output, provider, lookup, Cosmopolitan.MODID, helper);
    }
    @Override
    public void addTags(HolderLookup.Provider provider) {

        this.tag(ItemTags.BIRCH_LOGS).add(
                CosmoBlocks.SAPPY_BIRCH_LOG.get().asItem()
        );

        this.tag(Tags.Items.SEEDS).add(
                CosmoItems.SOURCE_BERRY_PIPS.get(),
                CosmoItems.KABLOOM_PIPS.get(),
                CosmoItems.BLISTERBERRY_PIPS.get(),
                CosmoItems.DROOPFRUIT_PIPS.get()
        );

        this.tag(ItemTags.PIGLIN_LOVED).add(
                CosmoItems.TOFFEE_GOLDEN_APPLE.get(),
                CosmoItems.GOLDEN_ARBUTUS_BERRIES.get()
        );

        this.tag(BlueprintItemTags.CHICKEN_FOOD).add(
                CosmoItems.SOURCE_BERRY_PIPS.get(),
                CosmoItems.KABLOOM_PIPS.get(),
                CosmoItems.BLISTERBERRY_PIPS.get(),
                CosmoItems.DROOPFRUIT_PIPS.get()
        );

        this.tag(BlueprintItemTags.PIG_FOOD).add(
                CosmoItems.FIDDLEHEAD.get(),
                CosmoItems.CHARD.get(),
                CosmoItems.WHEATGRASS.get()
        );

        this.tag(CosmoItemTags.APPLE).add(
                Items.APPLE
        );

        this.tag(CosmoItemTags.SUGARCANE).add(
                Items.SUGAR_CANE,
                CosmoItems.SUGARCANE_PIECES.get()
        );


        this.tag(CosmoItemTags.CARROT).add(
                Items.CARROT
        );

        this.tag(CosmoItemTags.SWEET_BERRY).add(
                Items.SWEET_BERRIES
        );

        this.tag(CosmoItemTags.GLOW_BERRY).add(
                Items.GLOW_BERRIES
        );

        this.tag(CosmoItemTags.MELON).add(
                Items.MELON_SLICE
        );

        this.tag(CosmoItemTags.MOSS).add(
                Blocks.MOSS_BLOCK.asItem(),
                Blocks.MOSS_CARPET.asItem()
        );

        this.tag(CosmoItemTags.GRAIN).add(
                Items.WHEAT,
                CosmoItems.WATTLESEEDS.get()
        );

        this.tag(CosmoItemTags.FERMENTED_DRINKS).add(
                CosmoItems.TWILIGHT_CHARTREUSE.get(),
                CosmoItems.SMOGGY_APEROL.get(),
                CosmoItems.WILDBERRY_PUNCH.get(),
                CosmoItems.CACHACA.get(),
                CosmoItems.NEVERENDING_NIGHT.get(),
                CosmoItems.MORNING_FOG.get(),
                CosmoItems.ROOT_BEER.get()
        );

        this.tag(CosmoItemTags.SYRUP).add(
                CosmoItems.MOLASSES_BOTTLE.get()
        );

        this.tag(CosmoItemTags.CATTAILS)
                .addOptional(CosmoCompat.id(CosmoCompat.EN, "cattail"))
                .addOptional(CosmoCompat.id(CosmoCompat.BOP, "cattail"))
                .addOptional(CosmoCompat.id("bwg", "cattail"))
                .addOptional(CosmoCompat.id("regions_unexplored", "cattail"))
        ;

        this.tag(CosmoItemTags.CROPS).add(
                CosmoItems.WHEATGRASS.get()
        );

        this.tag(CosmoItemTags.TUBER).add(
                CosmoItems.TUBER.get(),
                CosmoItems.CUT_TUBERS.get()
        );

        this.tag(CosmoItemTags.FRUITS)
                .addOptional(CosmoCompat.id(CosmoCompat.HA, "kabloom_pulp"))
        ;

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
                        CosmoItems.CLASSIC_ICE_CREAM.get(),
                        CosmoItems.COLLECTIVE_ICE_CREAM.get(),
                        CosmoItems.DELIGHTFUL_ICE_CREAM.get(),
                        CosmoItems.EXQUISITE_ICE_CREAM.get(),

                        CosmoItems.REFRESHING_ICE_CREAM_SANDWICH.get(),
                        CosmoItems.TWILIGHT_ICE_CREAM_SANDWICH.get(),
                        CosmoItems.RAINBOW_ICE_CREAM_SANDWICH.get(),
                        CosmoItems.SEASONAL_ICE_CREAM_SANDWICH.get(),
                        CosmoItems.PECULIAR_ICE_CREAM_SANDWICH.get(),
                        CosmoItems.NEAPOLITAN_ICE_CREAM_SANDWICH.get(),
                        CosmoItems.RESPITEFUL_ICE_CREAM_SANDWICH.get(),
                        CosmoItems.TRICOLORED_ICE_CREAM_SANDWICH.get(),
                        CosmoItems.CLASSIC_ICE_CREAM_SANDWICH.get(),
                        CosmoItems.COLLECTIVE_ICE_CREAM_SANDWICH.get(),
                        CosmoItems.DELIGHTFUL_ICE_CREAM_SANDWICH.get(),
                        CosmoItems.EXQUISITE_ICE_CREAM_SANDWICH.get(),
                        CosmoItems.SUNNY_ICE_CREAM_SANDWICH.get()
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

                CosmoItems.GREEN_TEA_ICE_CREAM_CONE.get(),
                CosmoItems.YELLOW_TEA_ICE_CREAM_CONE.get(),
                CosmoItems.BLACK_TEA_ICE_CREAM_CONE.get(),
                CosmoItems.COFFEE_ICE_CREAM_CONE.get(),

                CosmoItems.GLOWY_ICE_CREAM_CONE.get(),
                CosmoItems.FLAVORED_ICE_CREAM_CONE.get(),

                CosmoItems.ENCHANTED_FRUIT_ICE_CREAM_CONE.get(),
                CosmoItems.KABLOOM_ICE_CREAM_CONE.get(),
                CosmoItems.SOURCE_BERRY_ICE_CREAM_CONE.get()
        );

        this.tag(CosmoItemTags.UPRIGHT_ON_BELT)
                .add(
                        CosmoItems.WAFER_CONE.get(),
                        CosmoItems.WATER_PIE.get()
                )
                .addTag(CosmoItemTags.ICE_CREAM);

        this.tag(CosmoItemTags.COOKIE).add(
                CosmoItems.PAW_COOKIE.get(),
                CosmoItems.MOLASSES_COOKIE.get(),
                CosmoItems.BIRCH_COOKIE.get(),
                CosmoItems.HERBAL_COOKIE.get(),
                CosmoItems.HOWLING_COOKIE.get(),
                CosmoItems.ARBUTUS_BERRY_COOKIE.get(),
                Items.COOKIE
        );

        this.tag(CosmoItemTags.CHORUS).add(
                Items.CHORUS_FRUIT
        );

        this.tag(CosmoItemTags.FUNGUIS).add(
                CosmoItems.FUNGUIS_BOTTLE.get(),
                CosmoItems.WARPED_FUNGUIS_BOTTLE.get(),
                CosmoItems.SOULBLIGHT_FUNGUIS_BOTTLE.get()
        );

        this.tag(CosmoItemTags.SALMON_EGGS)
                .addOptional(CosmoCompat.id("croptopia", "roe"))
                .addOptional(CosmoCompat.id("youkaisfeasts", "roe"));

        this.tag(CosmoItemTags.CHERRY)
                .addOptional(CosmoCompat.id(CosmoCompat.SD, "cherry"));

        this.tag(CosmoItemTags.BERRIES).add(
                CosmoItems.WILDBERRY.get(),
                CosmoItems.SPINALBERRY.get(),
                CosmoItems.BOILBERRY.get(),
                CosmoItems.ARBUTUS_BERRIES.get()
        );

        this.tag(CosmoItemTags.POTATO).add(
                CosmoItems.CUT_POTATOES.get()
        );

        this.tag(CosmoItemTags.VEGETABLES).add(
                CosmoItems.FIDDLEHEAD.get(),
                CosmoItems.CHARD.get()
        );

        this.tag(CosmoItemTags.NUTS).add(
                CosmoItems.WATTLESEEDS.get()
        );

        this.tag(CosmoItemTags.SALAD_INGREDIENTS).add(
                CosmoItems.FIDDLEHEAD.get(),
                CosmoItems.CHARD.get()
        );

        this.tag(CosmoItemTags.HERBAL_POWDER_INGREDIENTS).add(
                CosmoItems.BAKED_FIDDLEHEAD.get(),
                CosmoItems.WHEATGRASS.get())
                .addOptional(CosmoCompat.id(CosmoCompat.BOP, "sprout"))
                .addOptional(CosmoCompat.id(CosmoCompat.BOP, "bush"))
                .addOptional(CosmoCompat.id(CosmoCompat.DF, "chopped_clover"))
        ;

        this.tag(CosmoItemTags.KYKEON_INGREDIENTS).add(
                        Blocks.SCULK.asItem())
                .addOptional(CosmoCompat.id(CosmoCompat.QUA, "ancient_fruit"))
                .addOptional(CosmoCompat.id(CosmoCompat.AN, "experience_gem"))
                .addOptional(CosmoCompat.id("create", "experience_nugget"))
        ;

        this.tag(CosmoItemTags.FIDDLEHEADS)
                .add(CosmoItems.FIDDLEHEAD.get())
                .addOptional(CosmoCompat.id("alexscaves", "fiddlehead"))
                .addOptional(CosmoCompat.id(CosmoCompat.TF, "fiddlehead"))
        ;

        this.tag(CosmoItemTags.RED_BEAN)
                .addOptional(CosmoCompat.id(CosmoCompat.NEA, "adzuki_beans"))
                .addOptional(CosmoCompat.id("youkaishomecoming", "redbean"))
                .addOptional(CosmoCompat.id("youkaisfeasts", "redbean"))
        ;

        this.tag(CosmoItemTags.PUMPKINS)
                .addOptional(CosmoCompat.id(CosmoCompat.FD, "pumpkin_slice"))
        ;

        this.tag(CosmoItemTags.CHOCOLATE)
                .addOptional(CosmoCompat.id(CosmoCompat.NEA, "chocolate_bar"))
        ;

        this.tag(CosmoItemTags.MILK)
                .addTag(CosmoItemTags.CREAM)
                .addTag(CosmoItemTags.CONDENSED_MILK);

        this.tag(CosmoItemTags.CREAM).add(
                CosmoItems.CREAM.get(),
                CosmoItems.CREAM_BUCKET.get())
                .addOptional(CosmoCompat.id("braziliandelight", "heavy_cream_bucket"))
                .addOptional(CosmoCompat.id("youkaisfeasts", "bowl_of_cream"));

        this.tag(CosmoItemTags.CONDENSED_MILK).add(
                CosmoItems.CONDENSED_MILK_BOTTLE.get(),
                CosmoItems.CONDENSED_MILK_BUCKET.get());

        this.tag(CosmoItemTags.MILK_BOTTLE)
                .addOptional(CosmoCompat.id(CosmoCompat.NEA, "milk_bottle"))
        ;

        this.tag(CosmoItemTags.FISH_SLICE)
                .addOptional(CosmoCompat.id(CosmoCompat.FD, "cod_slice"))
                .addOptional(CosmoCompat.id(CosmoCompat.FD, "salmon_slice"))
                .addOptional(CosmoCompat.id(CosmoCompat.AD, "pike_slice"))
                .addOptional(CosmoCompat.id(CosmoCompat.AD, "perch_slice"))
                .addOptional(CosmoCompat.id(CosmoCompat.CR, "platinum_bass_slice"))
                .addOptional(CosmoCompat.id("aquaculture", "fish_fillet_raw"))
        ;

        this.tag(CosmoItemTags.CAKE_SLICES)
                .addOptional(CosmoCompat.id(CosmoCompat.FD, "cake_slice"))
                .addOptional(CosmoCompat.id(CosmoCompat.AD, "vanilla_cake_slice"))
                .addOptional(CosmoCompat.id(CosmoCompat.AD, "banana_cake_slice"))
                .addOptional(CosmoCompat.id(CosmoCompat.AD, "strawberry_cake_slice"))
                .addOptional(CosmoCompat.id(CosmoCompat.AD, "adzuki_cake_slice"))
                .addOptional(CosmoCompat.id(CosmoCompat.AD, "chocolate_cake_slice"))
                .addOptional(CosmoCompat.id(CosmoCompat.AD, "mint_cake_slice"))
                .addOptional(CosmoCompat.id(CosmoCompat.VC, "carrot_cake_slice"))
                .addOptional(CosmoCompat.id(CosmoCompat.VC, "berry_cake_slice"))
                .addOptional(CosmoCompat.id(CosmoCompat.VC, "cheesecake_slice"))
                .addOptional(CosmoCompat.id(CosmoCompat.VC, "glow_berry_cake_slice"))
                .addOptional(CosmoCompat.id(CosmoCompat.VC, "chocolate_cake_slice"))
                .addOptional(CosmoCompat.id(CosmoCompat.VC, "ice_cream_cake_slice"))
                .addOptional(CosmoCompat.id(CosmoCompat.VC, "rose_cake_slice"))
                .addOptional(CosmoCompat.id(CosmoCompat.VC, "chorus_cake_slice"))
                .addOptional(CosmoCompat.id(CosmoCompat.VC, "book_cake_slice"))
                .addOptional(CosmoCompat.id(CosmoCompat.EX, "chorus_cake_slice"))
                .addOptional(CosmoCompat.id(CosmoCompat.EX, "jelly_ring_cake_slice"))
                .addOptional(CosmoCompat.id(CosmoCompat.EX, "zure_berry_cake_slice"))
                .addOptional(CosmoCompat.id(CosmoCompat.EX, "nightshade_berry_cake_slice"))
                .addOptional(CosmoCompat.id(CosmoCompat.EX, "ether_bulb_cake_slice"))
                .addOptional(CosmoCompat.id(CosmoCompat.SEA, "pumpkin_cake_slice"))
                .addOptional(CosmoCompat.id(CosmoCompat.SEA, "sweet_berry_cake_slice"))
                .addOptional(CosmoCompat.id(CosmoCompat.SEA, "beetroot_cake_slice"))
                .addOptional(CosmoCompat.id(CosmoCompat.PEC, "aloe_cake_slice"))
                .addOptional(CosmoCompat.id(CosmoCompat.PEC, "passion_fruit_cake_slice"))
                .addOptional(CosmoCompat.id(CosmoCompat.PEC, "yucca_cake_slice"))
        ;

        this.tag(CosmoItemTags.JAMS).add(
                CosmoItems.BERRY_SYRUP_BOTTLE.get(),
                CosmoItems.LUSH_CONFITURE_BOTTLE.get(),
                CosmoItems.STEELEAF_NECTAR.get()
        );

        this.tag(CosmoItemTags.BIOME_GULIME).add(
                CosmoItems.UNDERGROUND_GULIME.get(),
                CosmoItems.TAIGA_GULIME.get(),
                CosmoItems.CHORUS_GULIME.get(),
                CosmoItems.GLIMMERING_GULIME.get(),
                CosmoItems.ARID_GULIME.get(),
                CosmoItems.WARPED_GULIME.get(),
                CosmoItems.STRAWBERRY_GULIME.get()
        );

        this.tag(CosmoItemTags.ALL_SEASONS_CROPS).add(
                CosmoItems.WILDBERRY.get(),
                CosmoItems.FIDDLEHEAD.get()
        );

        this.tag(CosmoItemTags.AVERAGE_HUMID_CROPS).add(
                CosmoItems.WILDBERRY.get(),
                CosmoItems.FIDDLEHEAD.get()
        );

        this.tag(CosmoItemTags.YEAR_ROUND_CROPS).add(
                CosmoItems.WILDBERRY.get(),
                CosmoItems.FIDDLEHEAD.get()
        );

        this.tag(CosmoItemTags.SPRING_CROPS).add(
                CosmoItems.BIRCH_SAP_BOTTLE.get()
        );

        this.tag(CosmoItemTags.SUMMER_CROPS).add(
                CosmoItems.WHEATGRASS.get()
        );

        this.tag(CosmoItemTags.AUTUMN_CROPS).add(
                CosmoItems.WHEATGRASS.get()
        );

        this.tag(CosmoItemTags.WINTER_CROPS).add(
                CosmoItems.BIRCH_SAP_BOTTLE.get()
        );

        this.tag(CosmoItemTags.TWO_THIRST_ITEMS)
                .addTag(CosmoItemTags.ICE_CREAM)
                .add(
                        CosmoItems.SNOW_CONE.get(),
                        CosmoItems.COSMIC_SNOW_CONE.get(),
                        CosmoItems.BERRY_SYRUP_SHAVED_ICE_CONE.get(),
                        CosmoItems.BERRY_SYRUP_SHAVED_ICE.get(),

                        CosmoItems.BIRCH_SAP_BOTTLE.get(),

                        CosmoItems.BLISTERBERRY_POPSICLE.get(),
                        CosmoItems.GAMBLERS_POPSICLE.get(),
                        CosmoItems.TRANQUIL_SPLIT_POPSICLE.get(),
                        CosmoItems.ARDENT_SPLIT_POPSICLE.get(),
                        CosmoItems.BERRY_POPSICLE.get(),

                        CosmoItems.BLISTERBERRY_SORBET.get(),
                        CosmoItems.DROOPFRUIT_SORBET.get()
                );

        this.tag(CosmoItemTags.FIVE_THIRST_ITEMS)
                .add(
                        CosmoItems.WILDBERRY_PUNCH.get(),
                        CosmoItems.ROOT_BEER.get(),
                        CosmoItems.TWILIGHT_CHARTREUSE.get(),
                        CosmoItems.SMOGGY_APEROL.get(),
                        CosmoItems.NEVERENDING_NIGHT.get(),
                        CosmoItems.MORNING_FOG.get(),
                        CosmoItems.CACHACA.get(),

                        CosmoItems.ICED_AMERICANO.get(),
                        CosmoItems.CHORUS_FRUIT_AMERICANO.get(),
                        CosmoItems.BERRY_SYRUP_AMERICANO.get(),
                        CosmoItems.ORANGE_AMERICANO.get(),
                        CosmoItems.STRAWBERRY_MATCHA_LATTE.get(),
                        CosmoItems.MOCHA.get(),
                        CosmoItems.TISANE.get(),
                        CosmoItems.GREENDAY_JUICE.get(),
                        CosmoItems.CHARMED_INFUSION.get(),

                        CosmoItems.GAMBLERS_POPSICLE_DOUBLE.get(),
                        CosmoItems.TRANQUIL_SPLIT_POPSICLE_DOUBLE.get(),
                        CosmoItems.ARDENT_SPLIT_POPSICLE_DOUBLE.get(),
                        CosmoItems.BERRY_DOUBLE_POPSICLE.get(),
                        CosmoItems.BLISTERBERRY_DOUBLE_POPSICLE.get(),
                        CosmoItems.LIME_DOUBLE_POPSICLE.get(),

                        CosmoItems.SPRING_SODA.get(),
                        CosmoItems.SUMMER_CORDIAL.get(),
                        CosmoItems.AUTUMN_TEA.get(),
                        CosmoItems.WINTER_GLOGG.get(),

                        CosmoItems.COSMOPOLITAN_COCKTAIL.get(),
                        CosmoItems.ENCHANTED_COSMOPOLITAN_COCKTAIL.get()
                );

        this.tag(CosmoItemTags.COOLING_ITEMS)
                .addTag(CosmoItemTags.ICE_CREAM)
                .add(
                        CosmoItems.SPAGHETTIEIS.get(),
                        CosmoItems.SNOW_CONE.get(),
                        CosmoItems.COSMIC_SNOW_CONE.get(),
                        CosmoItems.BERRY_SYRUP_SHAVED_ICE_CONE.get(),
                        CosmoItems.BERRY_SYRUP_SHAVED_ICE.get(),
                        CosmoItems.GAMBLERS_POPSICLE_DOUBLE.get(),
                        CosmoItems.GAMBLERS_POPSICLE.get(),
                        CosmoItems.TRANQUIL_SPLIT_POPSICLE_DOUBLE.get(),
                        CosmoItems.TRANQUIL_SPLIT_POPSICLE.get(),
                        CosmoItems.ARDENT_SPLIT_POPSICLE_DOUBLE.get(),
                        CosmoItems.ARDENT_SPLIT_POPSICLE.get(),
                        CosmoItems.BERRY_DOUBLE_POPSICLE.get(),
                        CosmoItems.BERRY_POPSICLE.get(),
                        CosmoItems.BLISTERBERRY_POPSICLE.get(),
                        CosmoItems.BLISTERBERRY_DOUBLE_POPSICLE.get(),
                        CosmoItems.BLISTERBERRY_SORBET.get(),
                        CosmoItems.DROOPFRUIT_SORBET.get()
                );

        this.tag(CosmoItemTags.HEATING_ITEMS)
                .add(
                        CosmoItems.FARINA.get(),
                        CosmoItems.WILD_RISOTTO.get(),
                        CosmoItems.GHOSTCREAM.get(),
                        CosmoItems.WARPED_GHOSTCREAM.get(),
                        CosmoItems.SOULBLIGHT_GHOSTCREAM.get(),
                        CosmoItems.STOBHACH_GAELACH.get(),
                        CosmoItems.STOBHACH_GAELACH_CUP.get(),
                        CosmoItems.GREEN_CREAM_STEW_CUP.get(),
                        CosmoItems.GREEN_CREAM_STEW.get(),
                        CosmoItems.GREEN_CREAM_STEW_CUP.get(),
                        CosmoItems.ABC_SOUP.get(),
                        CosmoItems.ABC_SOUP_CUP.get(),
                        CosmoItems.LUSH_STEW.get(),
                        CosmoItems.LUSH_STEW_CUP.get()
                );

        this.tag(CosmoItemTags.INGRAINED_SOURCES)
                .addOptional(CosmoCompat.id(CosmoCompat.MD, "cave_carrot"))
                .addOptional(CosmoCompat.id(CosmoCompat.MD, "baked_cave_carrot"))
                .addOptional(CosmoCompat.id(CosmoCompat.MD, "vegan_patty"))
                .addOptional(CosmoCompat.id(CosmoCompat.MD, "vegan_wrap"))
                .addOptional(CosmoCompat.id(CosmoCompat.MD, "vegan_hamburger"))
                .addOptional(CosmoCompat.id(CosmoCompat.MD, "vegan_steak_and_potatoes"))
                .addOptional(CosmoCompat.id(CosmoCompat.MD, "pasta_with_veggieballs"))
                .addOptional(CosmoCompat.id(CosmoCompat.MD, "cave_soup"))
                .addOptional(CosmoCompat.id(CosmoCompat.MD, "improvised_barbecue_stick"))
        ;

        this.tag(CosmoItemTags.EXUBERANT_SOURCES)
                .addOptional(CosmoCompat.id(CosmoCompat.BAC, "apple_jelly"))
                .addOptional(CosmoCompat.id(CosmoCompat.FD, "apple_pie_slice"))
                .addOptional(CosmoCompat.id(CosmoCompat.BF, "apple_stew"))
                .addOptional(CosmoCompat.id(CosmoCompat.BF, "candied_apple"))
                .addOptional(CosmoCompat.id(CosmoCompat.BF, "apple_cider_jar"))
                .addOptional(CosmoCompat.id(CosmoCompat.BF, "apple_compote_jar"))
                .addOptional(CosmoCompat.id(CosmoCompat.CR, "deluxe_salad"))
                .addOptional(CosmoCompat.id(CosmoCompat.FD, "fruit_salad"))
                .addOptional(CosmoCompat.id(CosmoCompat.VC, "baked_apple"))
                .addOptional(CosmoCompat.id(CosmoCompat.VC, "apple_chips"))
                .addOptional(CosmoCompat.id(CosmoCompat.VC, "apple_pie"))
                .addOptional(CosmoCompat.id(CosmoCompat.VC, "apple_juice"))
                .addOptional(CosmoCompat.id(CosmoCompat.VC, "apple_sauce"))
                .addOptional(CosmoCompat.id(CosmoCompat.VC, "fruit_salad"))
                .addOptional(CosmoCompat.id(CosmoCompat.MB, "apple_juice"));

        this.tag(CosmoItemTags.CAROTENE_SOURCES)
                .addTag(CosmoItemTags.CARROT)
                .add(Items.GOLDEN_CARROT,
                        Items.RABBIT_STEW,
                        CosmoItems.CLASSIC_ICE_CREAM.get(),
                        CosmoItems.CLASSIC_ICE_CREAM_SANDWICH.get(),
                        CosmoItems.CARROT_MILKSHAKE.get(),
                        CosmoItems.CARROT_ICE_CREAM.get(),
                        CosmoItems.CARROT_ICE_CREAM_CONE.get())
                .addOptional(CosmoCompat.id(CosmoCompat.NEA, "adzuki_curry"))
                .addOptional(CosmoCompat.id(CosmoCompat.NEA, "adzuki_stew"))
                .addOptional(CosmoCompat.id(CosmoCompat.CAD, "beef_noodles"))
                .addOptional(CosmoCompat.id(CosmoCompat.BAC, "vegetable_omelet"))
                .addOptional(CosmoCompat.id(CosmoCompat.CR, "portobello_rice_soup"))
                .addOptional(CosmoCompat.id(CosmoCompat.CR, "portobello_wrap"))
                .addOptional(CosmoCompat.id(CosmoCompat.CR, "crimson_carrot_roast"))
                .addOptional(CosmoCompat.id(CosmoCompat.CR, "venison_stew"))
                .addOptional(CosmoCompat.id(CosmoCompat.CR, "chieftain_carb"))
                .addOptional(CosmoCompat.id(CosmoCompat.CR, "clam_meatball_stew"))
                .addOptional(CosmoCompat.id(CosmoCompat.CR, "pomegranate_pork"))
                .addOptional(CosmoCompat.id(CosmoCompat.DF, "field_salad"))
                .addOptional(CosmoCompat.id(CosmoCompat.FD, "beef_stew"))
                .addOptional(CosmoCompat.id(CosmoCompat.FD, "chicken_sandwich"))
                .addOptional(CosmoCompat.id(CosmoCompat.FD, "fried_rice"))
                .addOptional(CosmoCompat.id(CosmoCompat.FD, "kelp_roll"))
                .addOptional(CosmoCompat.id(CosmoCompat.FD, "kelp_roll_slice"))
                .addOptional(CosmoCompat.id(CosmoCompat.FD, "vegetable_noodles"))
                .addOptional(CosmoCompat.id(CosmoCompat.FD, "vegetable_soup"))
                .addOptional(CosmoCompat.id(CosmoCompat.KK, "gem_carrot"))
                .addOptional(CosmoCompat.id(CosmoCompat.KK, "carrot_and_carrot"))
                .addOptional(CosmoCompat.id(CosmoCompat.KK, "carrot_tart"))
                .addOptional(CosmoCompat.id(CosmoCompat.KK, "curry_udon"))
                .addOptional(CosmoCompat.id(CosmoCompat.VC, "chicken_soup"))
                .addOptional(CosmoCompat.id(CosmoCompat.VC, "garden_soup"))
                .addOptional(CosmoCompat.id(CosmoCompat.VC, "carrot_cake_slice"))
                .addOptional(CosmoCompat.id(CosmoCompat.VC, "meaty_stew"))
                .addOptional(CosmoCompat.id(CosmoCompat.VC, "vegetable_stew"))
                .addOptional(CosmoCompat.id(CosmoCompat.TFD, "fried_insect"))
                .addOptional(CosmoCompat.id(CosmoCompat.MB, "forest_medley"));

        this.tag(CosmoItemTags.TRACER_SOURCES)
                .addTag(CosmoItemTags.GLOW_BERRY)
                .addOptional(CosmoCompat.id(CosmoCompat.BG, "glowgurt"))
                .addOptional(CosmoCompat.id(CosmoCompat.BAC, "glow_berry_marmalade"))
                .addOptional(CosmoCompat.id(CosmoCompat.BAC, "pickled_pickles"))
                .addOptional(CosmoCompat.id(CosmoCompat.MD, "glow_ink_pasta"))
                .addOptional(CosmoCompat.id(CosmoCompat.FD, "glow_berry_custard"))
                .addOptional(CosmoCompat.id(CosmoCompat.KK, "lush_salad"))
                .addOptional(CosmoCompat.id(CosmoCompat.TFD, "berry_stick"))
                .addOptional(CosmoCompat.id(CosmoCompat.SEA, "mixed_berry_muffin"))
                .addOptional(CosmoCompat.id(CosmoCompat.VC, "golden_fruit_salad"))
                .addOptional(CosmoCompat.id(CosmoCompat.VC, "glow_berry_cake_slice"))
                .addOptional(CosmoCompat.id(CosmoCompat.VC, "glazed_glow_berries"));

        this.tag(CosmoItemTags.ABYSMAL_TORCH_SOURCES)
                .addOptional(CosmoCompat.id(CosmoCompat.UG, "droopvine_item"))
                .addOptional(CosmoCompat.id("undergardendelight", "droopstew"));

        this.tag(CosmoItemTags.VARDOGER_SOURCES)
                .addOptional(CosmoCompat.id(CosmoCompat.UG, "blisterberry"))
                .addOptional(CosmoCompat.id("undergardendelight", "mogsteak"))
                .addOptional(CosmoCompat.id("undergardendelight", "glitterdish"));

        this.tag(CosmoItemTags.BLACK_COFFEE)
                .addOptional(CosmoCompat.id(CosmoCompat.FR, "coffee"))
                .addOptional(CosmoCompat.id("youkaishomecoming", "espresso"))
                .addOptional(CosmoCompat.id("caffeinated", "coffee_bottle"))
                .addOptional(CosmoCompat.id("croptopia", "coffee"));

        this.tag(CosmoItemTags.FLAVORED_ITEM).add(
                CosmoItems.BERRY_SYRUP_BOTTLE.get(),
                CosmoItems.BERRY_CHEESECAKE_BAR.get(),
                CosmoItems.BERRY_SYRUP_AMERICANO.get(),
                CosmoItems.BERRY_SYRUP_GUMMY.get(),
                CosmoItems.BERRY_SYRUP_SHAVED_ICE.get(),
                CosmoItems.BERRY_SYRUP_SHAVED_ICE_CONE.get(),
                CosmoItems.BERRY_POPSICLE.get(),
                CosmoItems.BERRY_DOUBLE_POPSICLE.get()
        );

        this.tag(CosmoItemTags.BERRY_SYRUP_BLOCK).add(
                CosmoBlocks.SWEET_BERRY_SYRUP_BLOCK.get().asItem(),
                CosmoBlocks.SOUR_BERRY_SYRUP_BLOCK.get().asItem(),
                CosmoBlocks.BITTER_BERRY_SYRUP_BLOCK.get().asItem(),
                CosmoBlocks.SPICY_BERRY_SYRUP_BLOCK.get().asItem(),
                CosmoBlocks.STRANGE_BERRY_SYRUP_BLOCK.get().asItem());
    }
}

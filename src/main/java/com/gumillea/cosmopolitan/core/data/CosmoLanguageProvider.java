package com.gumillea.cosmopolitan.core.data;

import com.gumillea.cosmopolitan.Cosmopolitan;
import com.gumillea.cosmopolitan.core.reg.CosmoBlocks;
import com.gumillea.cosmopolitan.core.reg.CosmoEffects;
import com.gumillea.cosmopolitan.core.reg.CosmoFluids;
import com.gumillea.cosmopolitan.core.reg.CosmoItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.commons.lang3.text.WordUtils;

import java.util.Objects;

public class CosmoLanguageProvider extends LanguageProvider {

    public CosmoLanguageProvider(PackOutput output) {
        super(output, Cosmopolitan.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
        this.addItem(
                CosmoItems.BROCCOLI_AMERICANO.get(), CosmoItems.SPINALBERRY_GUMMY.get(), CosmoItems.BOILBERRY_GUMMY.get(), CosmoItems.FROST_GUMMY.get(), CosmoItems.BROCCOLI_GUMMY.get(), CosmoItems.ASTERA_GUMMY.get(), CosmoItems.DANDELION_COFFEE.get(), CosmoItems.MATE.get(), CosmoItems.CHA_JAU.get(), CosmoItems.PRIMORDIAL_CAVE_CONE.get(), CosmoItems.MAGNETIC_CAVE_CONE.get(), CosmoItems.TOXIC_CAVE_CONE.get(), CosmoItems.FORLORN_CAVE_CONE.get(), CosmoItems.ABYSSAL_CAVE_CONE.get(), CosmoItems.CANDY_CAVE_CONE.get(), CosmoItems.DRIPLEAF_ROLL.get(), CosmoItems.CAVE_CONE.get(), CosmoItems.MOSS_PIE.get(), CosmoItems.MATCHA_SALMONBERRY_CREAM_BUN.get(), CosmoItems.ECTOCARAMEL_POMEGRANATE_CREAM_BUN.get(), CosmoItems.BLISTERBERRY_DROOPFRUIT_CREAM_BUN.get(), CosmoItems.BERRY_DUO_CREAM_BUN.get(), CosmoItems.COLORFUL_CREAM_BUN.get(), CosmoItems.ORGANIC_MUFFIN.get(), CosmoItems.NETHERESSO.get(), CosmoItems.ASTERA_ICE_CREAM_CONE.get(), CosmoItems.FROST_ICE_CREAM_CONE.get(), CosmoItems.BROCCOLI_ICE_CREAM_CONE.get(), CosmoItems.BOILBERRY.get(), CosmoItems.SPINALBERRY.get(), CosmoItems.HOWLING_COOKIE.get(), CosmoItems.ARBUTUS_BERRY_COOKIE.get(), CosmoItems.POPWART.get(), CosmoItems.GREEN_BEER.get(), CosmoItems.GENERIC_ROMANCE.get(), CosmoItems.EXOTIC_MIRAGE.get(), CosmoItems.COUSCOUS_WITH_MUTTON.get(), CosmoItems.BAKED_COD_WITH_MASHED_POTATOES.get(), CosmoItems.BEETROOT_MIXED_RICE.get(), CosmoItems.GLAZED_FISH.get(), CosmoItems.GLAZED_FISH_ROLL.get(), CosmoItems.CHARD_ROLLS.get(), CosmoItems.MORNING_FOG.get(), CosmoItems.NEVERENDING_NIGHT.get(), CosmoItems.SPAGHETTIEIS.get(), CosmoItems.ENCHANTED_GOLDEN_ARBUTUS_BERRIES.get(), CosmoItems.CHARD.get(), CosmoItems.MOJANG_MESS.get(), CosmoItems.LUSH_SNOW_CONE.get(), CosmoItems.ACACIA_SNOW_CONE.get(), CosmoItems.MOLASSES_COOKIE.get(), CosmoItems.YULE_LOG.get(), CosmoItems.SHOOFLY_PIE.get(), CosmoItems.GEODE_BREAD.get(), CosmoItems.BAGASSE.get(), CosmoItems.STRAWBERRY_TANGHULU.get(), CosmoItems.MOLASSES_BOTTLE.get(), CosmoItems.SUGARCANE_JUICE.get(), CosmoItems.ETON_MESS.get(), CosmoItems.PENUCHE.get(), CosmoItems.WILDBERRY_MEDLEY.get(), CosmoItems.FARINA.get(), CosmoItems.OCCULT_APPLE.get(), CosmoItems.LUCUMA_ICE_CREAM_CONE.get(), CosmoItems.SOULBLIGHT_GHOSTCREAM.get(), CosmoItems.WARPED_GHOSTCREAM.get(), CosmoItems.GHOSTCREAM.get(), CosmoItems.MERINGUE.get(), CosmoItems.FLOWER_LOVE.get(), CosmoItems.FISH_KEBAB.get(), CosmoItems.ECTOCARAMEL.get(), CosmoItems.SOULBLIGHT_FUNGUIS_BOTTLE.get(), CosmoItems.WARPED_FUNGUIS_BOTTLE.get(), CosmoItems.FUNGUIS_BOTTLE.get(), CosmoItems.SALTED_QINGTUAN.get(), CosmoItems.SWEET_QINGTUAN.get(), CosmoItems.SLIME_CONE.get(), CosmoItems.EMERALD_CANDY.get(), CosmoItems.ZEBRA_CAKE.get(), CosmoItems.TRIFLE.get(), CosmoItems.RICE_PUDDING.get(), CosmoItems.COUSCOUS_WITH_VEGETABLES.get(), CosmoItems.MEADOW_BREAD.get(), CosmoItems.BUSH_BREAD.get(), CosmoItems.WATTLESEEDS.get(), CosmoItems.TISANE.get(), CosmoItems.KYKEON.get(), CosmoItems.HERBAL_POWDER.get(), CosmoItems.GREENDAY_JUICE.get(), CosmoItems.SUNNY_ICE_CREAM_SANDWICH.get(), CosmoItems.STOBHACH_GAELACH_CUP.get(), CosmoItems.STOBHACH_GAELACH.get(), CosmoItems.CHORUS_FRUIT_AMERICANO.get(), CosmoItems.MOCHA.get(), CosmoItems.BERRY_SYRUP_AMERICANO.get(), CosmoItems.STRAWBERRY_MATCHA_LATTE.get(), CosmoItems.ICED_AMERICANO.get(), CosmoItems.ORANGE_AMERICANO.get(), CosmoItems.WARPED_GULIME.get(), CosmoItems.ARID_GULIME.get(), CosmoItems.MAGEBLOOM_TART.get(), CosmoItems.SLABFISH_JELLY_POPSICLE.get(), CosmoItems.ARDENT_SPLIT_POPSICLE.get(), CosmoItems.ARDENT_SPLIT_POPSICLE_DOUBLE.get(), CosmoItems.TRANQUIL_SPLIT_POPSICLE.get(), CosmoItems.TRANQUIL_SPLIT_POPSICLE_DOUBLE.get(), CosmoItems.SHIELDING_BUTTER_BUN.get(), CosmoItems.RECOVERY_LAVA_CAKE.get(), CosmoItems.CHARMED_INFUSION.get(), CosmoItems.BASTION_GUMMY.get(), CosmoItems.MENDOSTEEN_GUMMY.get(), CosmoItems.MANA_SALAD.get(), CosmoItems.GLITTERKELP_BURRITO.get(), CosmoItems.NEAPOLITAN_ICE_CREAM_BAGEL.get(), CosmoItems.PINK_DRAGON_FRUIT_ICE_CREAM_CONE.get(), CosmoItems.COLLECTIVE_ICE_CREAM_SANDWICH.get(), CosmoItems.COLLECTIVE_ICE_CREAM.get(),CosmoItems.DELIGHTFUL_ICE_CREAM_SANDWICH.get(), CosmoItems.DELIGHTFUL_ICE_CREAM.get(), CosmoItems.EXQUISITE_ICE_CREAM_SANDWICH.get(), CosmoItems.EXQUISITE_ICE_CREAM.get(),CosmoItems.BACON_EGG_BAGEL.get(), CosmoItems.MATCHA_CREAM_INK_BAGEL.get(), CosmoItems.BERRY_CREAM_CHEESE_BAGEL.get(), CosmoItems.BAGEL_SANDWICH.get(), CosmoItems.BAGEL.get(), CosmoItems.TUBER_CHIPS.get(), CosmoItems.FLYING_DUTCHMAN_BURGER.get(), CosmoItems.FIDDLEHEAD_TEMPURA.get(), CosmoItems.CUT_TUBERS.get(), CosmoItems.BLISTERBERRY_GUMMY.get(), CosmoItems.DROOPFRUIT_GUMMY.get(), CosmoItems.ENCHANTED_FRUIT_GUMMY.get(), CosmoItems.KABLOOM_GUMMY.get(), CosmoItems.BERRY_SYRUP_GUMMY.get(), CosmoItems.CARROT_GUMMY.get(), CosmoItems.ARBUTUS_BERRY_GUMMY.get(), CosmoItems.WARPED_VELVET_CUBECAKE.get(), CosmoItems.CHORUS_FRUIT_CUBECAKE.get(), CosmoItems.BERRY_SYRUP_SHAVED_ICE_CONE.get(), CosmoItems.BERRY_SYRUP_SHAVED_ICE.get(), CosmoItems.WATER_PIE.get(), CosmoItems.LUSH_CONFITURE_BOTTLE.get(), CosmoItems.ARBUTUS_BERRIES.get(), CosmoItems.GOLDEN_ARBUTUS_BERRIES.get(), CosmoItems.TUBER_PUREE_WITH_CONFITURE.get(), CosmoItems.TUBER_PUREE_CONE_WITH_CONFITURE.get(), CosmoItems.HERBAL_COOKIE.get(), CosmoItems.BIRCH_COOKIE.get(), CosmoItems.TUBER_PUREE_CONE.get(), CosmoItems.TUBER_PUREE.get(), CosmoItems.WOODLAND_SUB.get(), CosmoItems.TUBER.get(), CosmoItems.ROASTED_TUBER.get(), CosmoItems.LLAMA_MARSHMALLOW.get(), CosmoItems.TWILIGHT_CHARTREUSE.get(), CosmoItems.SMOGGY_APEROL.get(), CosmoItems.WANDERING_GELATO.get(), CosmoItems.ICE_CREAM_FLOAT.get(), CosmoItems.WILDBERRY_PUNCH.get(), CosmoItems.ROOT_BEER.get(), CosmoItems.BLACK_COW.get(), CosmoItems.HOT_CATTAIL.get(), CosmoItems.TRICOLORED_ICE_CREAM_SANDWICH.get(), CosmoItems.RESPITEFUL_ICE_CREAM_SANDWICH.get(), CosmoItems.WHEATGRASS_CUBECAKE.get(), CosmoItems.ADZUKI_MINT_CREAM_BUN.get(), CosmoItems.STRAWBERRY_VANILLA_CREAM_BUN.get(), CosmoItems.CHOCOLATE_BANANA_CREAM_BUN.get(), CosmoItems.CREAM_BUN.get(), CosmoItems.GLOW_BERRY_CUBECAKE.get(), CosmoItems.CHORUS_FRUIT_POPSICLE.get(), CosmoItems.GLOWY_ICE_CREAM_CONE.get(), CosmoItems.FLAVORED_ICE_CREAM_CONE.get(), CosmoItems.CHERRY_ICE_CREAM_CONE.get(), CosmoItems.BERRY_CHEESECAKE_BAR.get(), CosmoItems.BERRY_POPSICLE.get(), CosmoItems.COFFEE_ICE_CREAM_CONE.get(), CosmoItems.BLACK_TEA_ICE_CREAM_CONE.get(), CosmoItems.YELLOW_TEA_ICE_CREAM_CONE.get(), CosmoItems.GREEN_TEA_ICE_CREAM_CONE.get(), CosmoItems.JELLO_SALAD.get(), CosmoItems.JELLO_SALAD_CUP.get(), CosmoItems.CREAM_BUCKET.get(), CosmoItems.CREAM.get(), CosmoItems.CONDENSED_MILK_BUCKET.get(), CosmoItems.CONDENSED_MILK_BOTTLE.get(), CosmoItems.KABLOOM_MILKSHAKE.get(), CosmoItems.SOURCE_BERRY_MILKSHAKE.get(), CosmoItems.ENCHANTED_FRUIT_MILKSHAKE.get(), CosmoItems.APPLE_MILKSHAKE.get(), CosmoItems.CARROT_MILKSHAKE.get(), CosmoItems.GLOW_BERRY_MILKSHAKE.get(), CosmoItems.WILD_RISOTTO.get(), CosmoItems.ROASTED_MUSHROOM.get(), CosmoItems.INK_ROLL.get(), CosmoItems.SUMMER_CORDIAL.get(), CosmoItems.AUTUMN_TEA.get(), CosmoItems.BIRCH_SAP_BOTTLE.get(), CosmoItems.SPRING_SODA.get(), CosmoItems.SPROUTED_UNDERBEANS.get(), CosmoItems.CLASSIC_ICE_CREAM.get(), CosmoItems.CLASSIC_ICE_CREAM_SANDWICH.get(), CosmoItems.TOFFEE_GOLDEN_APPLE.get(), CosmoItems.LUSH_STEW_CUP.get(), CosmoItems.LUSH_STEW.get(), CosmoItems.WILDBERRY.get(), CosmoItems.BERRY_SYRUP_BOTTLE.get(), CosmoItems.COSMOPOLITAN_COCKTAIL.get(), CosmoItems.FIDDLEHEAD.get(), CosmoItems.IRON_FIDDLEHEAD.get(), CosmoItems.GREEN_CREAM_STEW.get(), CosmoItems.CUT_POTATOES.get(), CosmoItems.POTATO_WEDGES.get(), CosmoItems.MASHED_POTATO.get(), CosmoItems.MASHED_POTATO_CONE.get(), CosmoItems.WAFER.get(), CosmoItems.WAFER_CONE.get(), CosmoItems.SNOW_CONE.get(), CosmoItems.POTATO_PANCAKES.get(), CosmoItems.ADZUKI_ICE_CREAM_CONE.get(), CosmoItems.BANANA_ICE_CREAM_CONE.get(), CosmoItems.CHOCOLATE_ICE_CREAM_CONE.get(), CosmoItems.MINT_ICE_CREAM_CONE.get(), CosmoItems.STRAWBERRY_ICE_CREAM_CONE.get(), CosmoItems.VANILLA_ICE_CREAM_CONE.get(), CosmoItems.NEAPOLITAN_ICE_CREAM_SANDWICH.get(), CosmoItems.CHORUS_ICE_CREAM_CONE.get(), CosmoItems.WARZIPAN_ICE_CREAM_CONE.get(), CosmoItems.MIDNIGHT_ICE_CREAM_CONE.get(), CosmoItems.STARCLOUD_ICE_CREAM_CONE.get(), CosmoItems.JELLY_RING_ICE_CREAM_CONE.get(), CosmoItems.AZURE_BERRY_ICE_CREAM_CONE.get(), CosmoItems.BEETROOT_ICE_CREAM_CONE.get(), CosmoItems.PUMPKIN_ICE_CREAM_CONE.get(), CosmoItems.SWEET_BERRY_ICE_CREAM_CONE.get(), CosmoItems.SEASONAL_ICE_CREAM.get(), CosmoItems.SEASONAL_ICE_CREAM_SANDWICH.get(), CosmoItems.APPLE_ICE_CREAM.get(), CosmoItems.APPLE_ICE_CREAM_CONE.get(), CosmoItems.CARROT_ICE_CREAM.get(), CosmoItems.CARROT_ICE_CREAM_CONE.get(), CosmoItems.GLOW_BERRY_ICE_CREAM.get(), CosmoItems.GLOW_BERRY_ICE_CREAM_CONE.get(), CosmoItems.DROOPFRUIT_PIPS.get(), CosmoItems.SOURCE_BERRY_PIPS.get(), CosmoItems.KABLOOM_PIPS.get(), CosmoItems.BLISTERBERRY_PIPS.get(), CosmoItems.SOURCE_BERRY_ICE_CREAM.get(), CosmoItems.SOURCE_BERRY_ICE_CREAM_CONE.get(), CosmoItems.KABLOOM_ICE_CREAM.get(), CosmoItems.KABLOOM_ICE_CREAM_CONE.get(), CosmoItems.ENCHANTED_FRUIT_ICE_CREAM.get(), CosmoItems.ENCHANTED_FRUIT_ICE_CREAM_CONE.get(), CosmoItems.AURORA_KOHAKUTOU.get(), CosmoItems.GLACIER_ESSENCE.get(), CosmoItems.STEELEAF_NECTAR.get(), CosmoItems.AURORA_ICE_CREAM_CONE.get(), CosmoItems.GLACIER_ICE_CREAM_CONE.get(), CosmoItems.PHYTOCHEMICAL_ICE_CREAM_CONE.get(), CosmoItems.TORCHBERRY_ICE_CREAM_CONE.get(), CosmoItems.RAINBOW_ICE_CREAM_SANDWICH.get(), CosmoItems.REFRESHING_ICE_CREAM_SANDWICH.get(), CosmoItems.TWILIGHT_ICE_CREAM_SANDWICH.get(), CosmoItems.WHEATGRASS.get(), CosmoItems.PAW_COOKIE.get(),  CosmoItems.BAKED_FIDDLEHEAD.get(), CosmoItems.GREEN_SAUCE.get(), CosmoItems.GREEN_PASTA.get(), CosmoItems.ALOE_ICE_CREAM_CONE.get(), CosmoItems.STRAWBERRY_GULIME.get() , CosmoItems.PASSION_FRUIT_ICE_CREAM_CONE.get(), CosmoItems.YUCCA_ICE_CREAM_CONE.get(), CosmoItems.PECULIAR_ICE_CREAM.get(), CosmoItems.PECULIAR_ICE_CREAM_SANDWICH.get(), CosmoItems.JELLY_ROLL.get(), CosmoItems.CHOCOLATE_ROLL.get(),  CosmoItems.SALMONBERRY_ICE_CREAM_CONE.get(), CosmoItems.MATCHA_ICE_CREAM_CONE.get(), CosmoItems.LIME_ICE_CREAM_CONE.get(), CosmoItems.POMEGRANATE_ICE_CREAM_CONE.get(), CosmoItems.BLISTERBERRY_TART.get(), CosmoItems.RAINDROOP_CAKE.get(), CosmoItems.BLISTERBERRY_SORBET.get(), CosmoItems.DROOPFRUIT_SORBET.get(), CosmoItems.UNDERGROUND_GULIME.get(), CosmoItems.ENCHANTED_COSMOPOLITAN_COCKTAIL.get(), CosmoItems.TAIGA_GULIME.get(), CosmoItems.GULIME.get(), CosmoItems.GLIMMERING_GULIME.get(), CosmoItems.CHORUS_GULIME.get(), CosmoItems.BLISTERBERRY_POPSICLE.get(), CosmoItems.MENDOSTEEN_TART.get(), CosmoItems.GREEN_CREAM_STEW_CUP.get(), CosmoItems.TOFFEE_APPLE.get()
        );

        this.addSpecialBlock(CosmoBlocks.SWEET_BERRY_SYRUP_BLOCK.get(), "Sweet Berry Syrup Block");
        this.addSpecialItem(CosmoItems.TUBER_CHIP_BAG.get(), "Bag of Tuber Chips");
        this.addSpecialItem(CosmoItems.CACHACA.get(), "Cachaça");
        this.addSpecialFluidType(CosmoFluids.CACHACA_TYPE.get(), "Cachaça");
        this.addSpecialFluidType(CosmoFluids.SWEET_BERRY_SYRUP_TYPE.get(), "Sweet Berry Syrup");
        this.addSpecialItem(CosmoItems.RODGROD.get(), "Rødgrød");
        this.addSpecialItem(CosmoItems.SUGARCANE_PIECES.get(), "Pieces of Sugarcane");
        this.addSpecialItem(CosmoItems.COSMIC_SNOW_CONE.get(), "The Eternal Snow Cone");
        this.addSpecialItem(CosmoItems.GAMBLERS_POPSICLE_DOUBLE.get(), "Double Gambler's Popsicle");
        this.addSpecialItem(CosmoItems.ABC_SOUP.get(), "ABC Soup");
        this.addSpecialItem(CosmoItems.ABC_SOUP_CUP.get(), "ABC Soup Cup");
        this.addSpecialItem(CosmoItems.CLASSIC_FRUIT_SALAD.get(), "Vintage Fruit Salad");
        this.addSpecialItem(CosmoItems.WINTER_GLOGG.get(),  "Winter Glögg");
        this.addSpecialItem(CosmoItems.SMC_ICE_CREAM_SANDWICH.get(),  "SMC Ice Cream Sandwich");
        this.addSpecialItem(CosmoItems.RAINBOW_ICE_CREAM_SANDWICH_SMC.get(),  "Rainbow Ice Cream Sandwich");


        this.addSpecialItem(CosmoItems.MUSIC_DISC_WOC.get(),  "Music Disc");
        this.add("item." + Cosmopolitan.MODID + ".music_disc_woc.desc", "astrovan - World of Color");

        this.addTradeItem(
                CosmoItems.TRAVELERS_PANINI.get(), CosmoItems.GAMBLERS_POPSICLE.get()
        );
        this.addLlamaMarshmallow(
                CosmoItems.LLAMA_MARSHMALLOW_BROWN.get(), CosmoItems.LLAMA_MARSHMALLOW_TRADER.get()
        );
        this.addSmallGulime(
                CosmoItems.WARPED_GULIME_SMALL.get(), CosmoItems.ARID_GULIME_SMALL.get(), CosmoItems.GULIME_SMALL.get(), CosmoItems.UNDERGROUND_GULIME_SMALL.get(), CosmoItems.TAIGA_GULIME_SMALL.get(), CosmoItems.CHORUS_GULIME_SMALL.get(), CosmoItems.GLIMMERING_GULIME_SMALL.get(), CosmoItems.STRAWBERRY_GULIME_SMALL.get()
        );
        this.addSlice(
                CosmoItems.MOSS_PIE_SLICE.get(), CosmoItems.YULE_LOG_SLICE.get(), CosmoItems.SHOOFLY_PIE_SLICE.get(), CosmoItems.WATER_PIE_SLICE.get(), CosmoItems.JELLY_ROLL_SLICE.get(), CosmoItems.CHOCOLATE_ROLL_SLICE.get(), CosmoItems.INK_ROLL_SLICE.get()
        );
        this.addDoublePopsicle(
                CosmoItems.CHORUS_FRUIT_DOUBLE_POPSICLE.get(), CosmoItems.LIME_DOUBLE_POPSICLE.get(), CosmoItems.BERRY_DOUBLE_POPSICLE.get(), CosmoItems.BLISTERBERRY_DOUBLE_POPSICLE.get()
        );
        this.addBlock(
                CosmoBlocks.LUCUMA_ICE_CREAM_BRICKS.get(), CosmoBlocks.PINK_DRAGON_FRUIT_ICE_CREAM_BRICKS.get(), CosmoBlocks.RAINBOW_ICE_CREAM_BRICKS.get(), CosmoBlocks.RAINBOW_ICE_CREAM_BLOCK.get(), CosmoBlocks.FROST_ICE_CREAM_BRICKS.get(), CosmoBlocks.FROST_ICE_CREAM_BLOCK.get(), CosmoBlocks.BROCCOLI_ICE_CREAM_BRICKS.get(), CosmoBlocks.BROCCOLI_ICE_CREAM_BLOCK.get(), CosmoBlocks.ASTERA_ICE_CREAM_BRICKS.get(), CosmoBlocks.ASTERA_ICE_CREAM_BLOCK.get(), CosmoBlocks.STRANGE_BERRY_SYRUP_BLOCK.get(), CosmoBlocks.SPICY_BERRY_SYRUP_BLOCK.get(), CosmoBlocks.BITTER_BERRY_SYRUP_BLOCK.get(), CosmoBlocks.SOUR_BERRY_SYRUP_BLOCK.get(), CosmoBlocks.MOLASSES_BLOCK.get(), CosmoBlocks.EXHAUSTED_SHROOMNIGHT.get(), CosmoBlocks.EXHAUSTED_SHROOMBLIGHT.get(), CosmoBlocks.EXHAUSTED_SHROOMLIGHT.get(), CosmoBlocks.POTTED_WILDBERRY_BUSH.get(), CosmoBlocks.POTTED_FIDDLEHEAD_GREENS.get(), CosmoBlocks.TUBER_CRATE.get(), CosmoBlocks.HERBAL_COOKIE_TILE.get(), CosmoBlocks.HERBAL_COOKIE_TILE_SLAB.get(), CosmoBlocks.HERBAL_COOKIE_TILE_STAIRS.get(), CosmoBlocks.HERBAL_COOKIE_TILE_WALL.get(), CosmoBlocks.PAW_COOKIE_TILE.get(), CosmoBlocks.PAW_COOKIE_TILE_SLAB.get(), CosmoBlocks.PAW_COOKIE_TILE_STAIRS.get(), CosmoBlocks.PAW_COOKIE_TILE_WALL.get(), CosmoBlocks.BIRCH_COOKIE_TILE.get(), CosmoBlocks.BIRCH_COOKIE_TILE_SLAB.get(), CosmoBlocks.BIRCH_COOKIE_TILE_STAIRS.get(), CosmoBlocks.BIRCH_COOKIE_TILE_WALL.get(),
                CosmoBlocks.STEELEAF_NECTAR_BLOCK.get(), CosmoBlocks.IRON_FIDDLEHEAD_CRATE.get(), CosmoBlocks.FIDDLEHEAD_CRATE.get(), CosmoBlocks.BIRCH_SAP_BLOCK.get(), CosmoBlocks.SOURCE_BERRY_ICE_CREAM_BRICKS.get(), CosmoBlocks.ENCHANTED_FRUIT_ICE_CREAM_BRICKS.get(), CosmoBlocks.KABLOOM_ICE_CREAM_BRICKS.get(), CosmoBlocks.GLOW_BERRY_ICE_CREAM_BRICKS.get(), CosmoBlocks.CARROT_ICE_CREAM_BRICKS.get(), CosmoBlocks.APPLE_ICE_CREAM_BRICKS.get(), CosmoBlocks.STRAWBERRY_ICE_CREAM_BRICKS.get(), CosmoBlocks.CHOCOLATE_ICE_CREAM_BRICKS.get(), CosmoBlocks.VANILLA_ICE_CREAM_BRICKS.get(), CosmoBlocks.MINT_ICE_CREAM_BRICKS.get(), CosmoBlocks.BANANA_ICE_CREAM_BRICKS.get(), CosmoBlocks.ADZUKI_ICE_CREAM_BRICKS.get(),
                CosmoBlocks.GLOW_PETALS.get(), CosmoBlocks.SOURCE_BERRY_MILKSHAKE_CAULDRON.get(), CosmoBlocks.KABLOOM_MILKSHAKE_CAULDRON.get(), CosmoBlocks.ENCHANTED_FRUIT_MILKSHAKE_CAULDRON.get(), CosmoBlocks.GLOW_BERRY_MILKSHAKE_CAULDRON.get(), CosmoBlocks.CARROT_MILKSHAKE_CAULDRON.get(), CosmoBlocks.APPLE_MILKSHAKE_CAULDRON.get(), CosmoBlocks.SAPPY_BIRCH_LOG.get(), CosmoBlocks.LIFELIGHT.get(), CosmoBlocks.COPPER_FROZEN_DESSERT_TUB.get(), CosmoBlocks.IRON_FROZEN_DESSERT_TUB.get(), CosmoBlocks.NETHERITE_FROZEN_DESSERT_TUB.get(), CosmoBlocks.MASHED_POTATO_BLOCK.get(), CosmoBlocks.WHEATGRASS_BALE.get(),
                CosmoBlocks.CHISELED_ADZUKI_ICE_CREAM_BLOCK.get(), CosmoBlocks.CHISELED_BANANA_ICE_CREAM_BLOCK.get(), CosmoBlocks.CHISELED_CHOCOLATE_ICE_CREAM_BLOCK.get(), CosmoBlocks.CHISELED_MINT_ICE_CREAM_BLOCK.get(), CosmoBlocks.CHISELED_STRAWBERRY_ICE_CREAM_BLOCK.get(), CosmoBlocks.CHISELED_VANILLA_ICE_CREAM_BLOCK.get(),
                CosmoBlocks.GLOWY_ICE_CREAM_BRICKS.get(), CosmoBlocks.FLAVORED_ICE_CREAM_BRICKS.get(), CosmoBlocks.CHERRY_ICE_CREAM_BRICKS.get(), CosmoBlocks.TORCHBERRY_ICE_CREAM_BRICKS.get(), CosmoBlocks.PHYTOCHEMICAL_ICE_CREAM_BRICKS.get(), CosmoBlocks.GLACIER_ICE_CREAM_BRICKS.get(), CosmoBlocks.AURORA_ICE_CREAM_BRICKS.get(), CosmoBlocks.SALMONBERRY_ICE_CREAM_BRICKS.get(), CosmoBlocks.MATCHA_ICE_CREAM_BRICKS.get(), CosmoBlocks.POMEGRANATE_ICE_CREAM_BRICKS.get(), CosmoBlocks.LIME_ICE_CREAM_BRICKS.get(), CosmoBlocks.CHORUS_FRUIT_ICE_CREAM_BRICKS.get(), CosmoBlocks.WARZIPAN_ICE_CREAM_BRICKS.get(), CosmoBlocks.AZURE_BERRY_ICE_CREAM_BRICKS.get(), CosmoBlocks.JELLY_RING_ICE_CREAM_BRICKS.get(), CosmoBlocks.MIDNIGHT_ICE_CREAM_BRICKS.get(), CosmoBlocks.STARCLOUD_ICE_CREAM_BRICKS.get(), CosmoBlocks.BEETROOT_ICE_CREAM_BRICKS.get(), CosmoBlocks.SWEET_BERRY_ICE_CREAM_BRICKS.get(), CosmoBlocks.PUMPKIN_ICE_CREAM_BRICKS.get(), CosmoBlocks.ALOE_ICE_CREAM_BRICKS.get(), CosmoBlocks.PASSION_FRUIT_ICE_CREAM_BRICKS.get(), CosmoBlocks.YUCCA_ICE_CREAM_BRICKS.get(), CosmoBlocks.GREEN_TEA_ICE_CREAM_BRICKS.get(), CosmoBlocks.YELLOW_TEA_ICE_CREAM_BRICKS.get(), CosmoBlocks.BLACK_TEA_ICE_CREAM_BRICKS.get(), CosmoBlocks.COFFEE_ICE_CREAM_BRICKS.get(),
                CosmoBlocks.CHERRY_ICE_CREAM_BLOCK.get(), CosmoBlocks.TORCHBERRY_ICE_CREAM_BLOCK.get(), CosmoBlocks.PHYTOCHEMICAL_ICE_CREAM_BLOCK.get(), CosmoBlocks.GLACIER_ICE_CREAM_BLOCK.get(), CosmoBlocks.AURORA_ICE_CREAM_BLOCK.get(), CosmoBlocks.APPLE_ICE_CREAM_BLOCK.get(), CosmoBlocks.CARROT_ICE_CREAM_BLOCK.get(), CosmoBlocks.GLOW_BERRY_ICE_CREAM_BLOCK.get(), CosmoBlocks.ENCHANTED_FRUIT_ICE_CREAM_BLOCK.get(), CosmoBlocks.KABLOOM_ICE_CREAM_BLOCK.get(), CosmoBlocks.SOURCE_BERRY_ICE_CREAM_BLOCK.get()
        );
        this.addBasket(
                CosmoBlocks.WILDBERRIES_BASKET.get(),
                CosmoBlocks.ARBUTUS_BERRIES_BASKET.get(),
                CosmoBlocks.GOLDEN_ARBUTUS_BERRIES_BASKET.get()
        );
        this.addSack(
                CosmoBlocks.WATTLESEED_SACK.get()
        );
        this.addPotion(
                CosmoEffects.WRATH.get(), CosmoEffects.WRATH_LONG.get(), CosmoEffects.WRATH_STRONG.get(),
                CosmoEffects.PANIC.get(), CosmoEffects.PANIC_LONG.get(), CosmoEffects.PANIC_STRONG.get(),
                CosmoEffects.LUSH.get(), CosmoEffects.LUSH_LONG.get(), CosmoEffects.LUSH_STRONG.get(),
                CosmoEffects.IRON_HEART.get(), CosmoEffects.IRON_HEART_LONG.get(), CosmoEffects.IRON_HEART_STRONG.get()
        );
        this.addBerrySyrupType(
                CosmoFluids.BITTER_BERRY_SYRUP_TYPE.get(), CosmoFluids.STRANGE_BERRY_SYRUP_TYPE.get(), CosmoFluids.SOUR_BERRY_SYRUP_TYPE.get(), CosmoFluids.SPICY_BERRY_SYRUP_TYPE.get()
        );
        this.addFluidType(
                CosmoFluids.RAINBOW_ICE_CREAM_TYPE.get(), CosmoFluids.FROST_ICE_CREAM_TYPE.get(), CosmoFluids.BROCCOLI_ICE_CREAM_TYPE.get(), CosmoFluids.ASTERA_ICE_CREAM_TYPE.get(), CosmoFluids.GREEN_BEER_TYPE.get(), CosmoFluids.GENERIC_ROMANCE_TYPE.get(), CosmoFluids.EXOTIC_MIRAGE_TYPE.get(), CosmoFluids.MORNING_FOG_TYPE.get(), CosmoFluids.NEVERENDING_NIGHT_TYPE.get(), CosmoFluids.LUCUMA_ICE_CREAM_TYPE.get(), CosmoFluids.PINK_DRAGON_FRUIT_ICE_CREAM_TYPE.get(), CosmoFluids.MOLASSES_TYPE.get(), CosmoFluids.SMOGGY_APEROL_TYPE.get(), CosmoFluids.TWILIGHT_CHARTREUSE_TYPE.get(), CosmoFluids.STEELEAF_NECTAR_TYPE.get(), CosmoFluids.BIRCH_SAP_TYPE.get(), CosmoFluids.ROOT_BEER_TYPE.get(), CosmoFluids.WILDBERRY_PUNCH_TYPE.get(), CosmoFluids.CONDENSED_MILK_TYPE.get(), CosmoFluids.CREAM_TYPE.get(), CosmoFluids.VANILLA_ICE_CREAM_TYPE.get(), CosmoFluids.STRAWBERRY_ICE_CREAM_TYPE.get(), CosmoFluids.CHOCOLATE_ICE_CREAM_TYPE.get(), CosmoFluids.MINT_ICE_CREAM_TYPE.get(), CosmoFluids.ADZUKI_ICE_CREAM_TYPE.get(), CosmoFluids.BANANA_ICE_CREAM_TYPE.get(), CosmoFluids.APPLE_ICE_CREAM_TYPE.get(), CosmoFluids.CARROT_ICE_CREAM_TYPE.get(), CosmoFluids.GLOW_BERRY_ICE_CREAM_TYPE.get(), CosmoFluids.ALOE_ICE_CREAM_TYPE.get(), CosmoFluids.PASSION_FRUIT_ICE_CREAM_TYPE.get(), CosmoFluids.YUCCA_ICE_CREAM_TYPE.get(), CosmoFluids.BEETROOT_ICE_CREAM_TYPE.get(), CosmoFluids.SWEET_BERRY_ICE_CREAM_TYPE.get(), CosmoFluids.PUMPKIN_ICE_CREAM_TYPE.get(), CosmoFluids.LIME_ICE_CREAM_TYPE.get(), CosmoFluids.POMEGRANATE_ICE_CREAM_TYPE.get(), CosmoFluids.MATCHA_ICE_CREAM_TYPE.get(), CosmoFluids.SALMONBERRY_ICE_CREAM_TYPE.get(), CosmoFluids.CHORUS_FRUIT_ICE_CREAM_TYPE.get(), CosmoFluids.WARZIPAN_ICE_CREAM_TYPE.get(), CosmoFluids.JELLY_RING_ICE_CREAM_TYPE.get(), CosmoFluids.AZURE_BERRY_ICE_CREAM_TYPE.get(), CosmoFluids.MIDNIGHT_ICE_CREAM_TYPE.get(), CosmoFluids.STARCLOUD_ICE_CREAM_TYPE.get(), CosmoFluids.KABLOOM_ICE_CREAM_TYPE.get(), CosmoFluids.SOURCE_BERRY_ICE_CREAM_TYPE.get(), CosmoFluids.ENCHANTED_FRUIT_ICE_CREAM_TYPE.get(),
                CosmoFluids.CHERRY_ICE_CREAM_TYPE.get(), CosmoFluids.GLOWY_ICE_CREAM_TYPE.get(), CosmoFluids.FLAVORED_ICE_CREAM_TYPE.get(), CosmoFluids.BLACK_TEA_ICE_CREAM_TYPE.get(), CosmoFluids.COFFEE_ICE_CREAM_TYPE.get(), CosmoFluids.GREEN_TEA_ICE_CREAM_TYPE.get(), CosmoFluids.YELLOW_TEA_ICE_CREAM_TYPE.get(), CosmoFluids.AURORA_ICE_CREAM_TYPE.get(), CosmoFluids.PHYTOCHEMICAL_ICE_CREAM_TYPE.get(), CosmoFluids.GLACIER_ICE_CREAM_TYPE.get(), CosmoFluids.TORCHBERRY_ICE_CREAM_TYPE.get()
        );

        this.addEffect("When sleeping with this effect, the user will grants a small amount of experience and a random beneficial effect upon waking.", CosmoEffects.COMFORT.get());
        this.addEffect("Gain a small amount of extra health at the end of the duration. It will be removed if the user takes damage before it ends.", CosmoEffects.EXUBERANT.get());
        this.addEffect("This effect activates after the player has consumed enough carrot-based food, slightly improving the user's vision in dark environments.", CosmoEffects.CAROTENE.get());
        this.addEffect("The user will leave a glowing trail on the blocks they pass over.", CosmoEffects.MARKED.get());
        this.addEffect("The user's ranged attack will mark and blind the first living target they hit.", CosmoEffects.TRACER.get());
        this.addEffect("Increases attack and mining speed depending on the user's surrounding light level.", CosmoEffects.PHOTOTAXIS.get());
        this.addEffect("Reduces incoming damage depending on the user's current Y level.", CosmoEffects.INGRAINED.get());
        this.addEffect("Grants a chance to dodge incoming damage, but also a chance for user's attacks to miss.", CosmoEffects.OBSCURE.get());

        this.addEffect("Summons a temporary glowing block upon killing a monster. While in The Undergarden, this block also provides healing.", CosmoEffects.ABYSMAL_TORCH.get());
        this.addEffect("When the user attacks or takes damage, the outgoing damage has a chance to be doubled. While in The Undergarden, this extra damage becomes an explosion.", CosmoEffects.VARDOGER.get());

        this.addEffect("The original effect of the item could not be applied because the compatible mod was not installed.", CosmoEffects.PLACEHOLDER.get());

        this.add("jei." + Cosmopolitan.MODID + ".category.tub_inject", "Tub Injecting");
        this.add("jei." + Cosmopolitan.MODID + ".category.tub_extract", "Tub Extracting");

        this.add("tooltip." + Cosmopolitan.MODID + ".placeable", "Placeable");
        this.add("tooltip." + Cosmopolitan.MODID + ".placeable_while_sneaking", "Placeable while sneaking");
        this.add("tooltip." + Cosmopolitan.MODID + ".wheatgrass.when_feeding", "When fed to a tamed Cat:");
        this.add("tooltip." + Cosmopolitan.MODID + ".seasonal_drink.when_consumed.in_spring", "When consumed in Spring:");
        this.add("tooltip." + Cosmopolitan.MODID + ".seasonal_drink.when_consumed.in_summer", "When consumed in Summer:");
        this.add("tooltip." + Cosmopolitan.MODID + ".seasonal_drink.when_consumed.in_autumn", "When consumed in Autumn:");
        this.add("tooltip." + Cosmopolitan.MODID + ".seasonal_drink.when_consumed.in_winter", "When consumed in Winter:");

        this.add("tooltip." + Cosmopolitan.MODID + ".seasoned.condensed_milk", "Smooth");
        this.add("tooltip." + Cosmopolitan.MODID + ".seasoned.condensed_milk.info", "Reduces eating time");
        this.add("tooltip." + Cosmopolitan.MODID + ".seasoned.cream", "Luscious");
        this.add("tooltip." + Cosmopolitan.MODID + ".seasoned.cream.info", "Restores extra hunger points");

        this.add("tooltip." + Cosmopolitan.MODID + ".flavor.sour", "Sour");
        this.add("tooltip." + Cosmopolitan.MODID + ".flavor.sour.info", "Extends a beneficial effect duration; reduces armor while active");
        this.add("tooltip." + Cosmopolitan.MODID + ".flavor.sweet", "Sweet");
        this.add("tooltip." + Cosmopolitan.MODID + ".flavor.sweet.info", "Shortens a harmful or neutral effect duration; restores health while active");
        this.add("tooltip." + Cosmopolitan.MODID + ".flavor.bitter", "Bitter");
        this.add("tooltip." + Cosmopolitan.MODID + ".flavor.bitter.info", "Extends a harmful or neutral effect duration; grants experience when it expires");
        this.add("tooltip." + Cosmopolitan.MODID + ".flavor.spicy", "Spicy");
        this.add("tooltip." + Cosmopolitan.MODID + ".flavor.spicy.info", "Shortens a beneficial effect duration; damages and ignites nearby monsters when it expires");
        this.add("tooltip." + Cosmopolitan.MODID + ".flavor.strange", "Strange");
        this.add("tooltip." + Cosmopolitan.MODID + ".flavor.strange.info", "Swaps the duration and level of a beneficial effect with a harmful or neutral effect");

        this.add("tooltip." + Cosmopolitan.MODID + ".ghost_food", "Twisted");
        this.add("tooltip." + Cosmopolitan.MODID + ".ghost_food.info", "Randomly increase or decrease hunger points");

        this.add("tooltip." + Cosmopolitan.MODID + ".cream.when_consumed", "Randomly increases or decreases the duration of 1 effect");
        this.add("tooltip." + Cosmopolitan.MODID + ".cream_bucket.when_consumed", "Randomly increases or decreases the duration of all effects");

        this.add("tooltip." + Cosmopolitan.MODID + ".condensed_milk_bottle.when_consumed", "Clears one Level 1 effect");
        this.add("tooltip." + Cosmopolitan.MODID + ".condensed_milk_bucket.when_consumed", "Clears all Level 1 effects");

        this.add("tooltip." + Cosmopolitan.MODID + ".berry_syrup_shaved_ice.when_consumed", "Seasons up to 3 effects");

        this.add("tooltip." + Cosmopolitan.MODID + ".seasonal_drink.when_consumed.cold", "Clears Fire");
        this.add("tooltip." + Cosmopolitan.MODID + ".seasonal_drink.when_consumed.hot", "Clears Freeze");

        this.add("tooltip." + Cosmopolitan.MODID + ".sweet_qingtuan.when_consumed", "Reduces harmful effect level");
        this.add("tooltip." + Cosmopolitan.MODID + ".salt_qingtuan.when_consumed", "Reduces harmful effect duration");

        this.add("tooltip." + Cosmopolitan.MODID + ".birch_sap_bottle.when_consumed", "Converts Mining Fatigue into Haste");
        this.add("tooltip." + Cosmopolitan.MODID + ".molasses_bottle.when_consumed", "Converts Weakness into Strength");
        this.add("tooltip." + Cosmopolitan.MODID + ".sugarcane_juice.when_consumed", "Converts Slowness into Speed");

        this.add("tooltip." + Cosmopolitan.MODID + ".generic_romance.when_consumed", "Makes up to 4 nearby animals feel happy");
        this.add("tooltip." + Cosmopolitan.MODID + ".wildberry_punch.when_consumed", "Clears all seasoned effects, and restores health based on the number cleared");
        this.add("tooltip." + Cosmopolitan.MODID + ".cosmopolitan_cocktail.when_consumed", "Increases all seasoned effects by 1 level");
        this.add("tooltip." + Cosmopolitan.MODID + ".enchanted_cosmopolitan_cocktail.when_consumed", "Increases all seasoned effects by 2 levels");

        this.add("tooltip." + Cosmopolitan.MODID + ".enhance_drink", "Enhances %s");

        this.add("tooltip." + Cosmopolitan.MODID + ".cave_cone.when_consumed.in_underground", "When consumed below Y=16:");
        this.add("tooltip." + Cosmopolitan.MODID + ".cave_cone.when_consumed.in_underground.nutrition", "Restores additional hunger points");

        this.add("tooltip." + Cosmopolitan.MODID + ".carrot", "Rich in Carotene");

        this.addJeiItemDescriptions("Fiddlehead can be dropped when breaking fern or large fern.", CosmoItems.FIDDLEHEAD.get());
        this.addJeiItemDescriptions("These varied wild berries can be dropped when breaking grass or tall grass. When used to craft a Berry Syrup Bottle, the flavor they contain is random.", CosmoItems.WILDBERRY.get());
        this.addJeiItemDescriptions("Wheatgrass can be obtained by harvesting a wheat crop that is in the middle of its growth phase.", CosmoItems.WHEATGRASS.get());
        this.addJeiItemDescriptions("A kind of edible golem that can split into 4 small, edible pieces after eating. It will slowly restore if the player has more than 4 pieces in their inventory and might change its form if the restore takes place in some specific biomes.", CosmoItems.GULIME.get());
        this.addJeiItemDescriptions("The player can share this type of popsicle with most creatures they meet.", CosmoItems.BLISTERBERRY_DOUBLE_POPSICLE.get());
        this.addJeiItemDescriptions("Condensed milk can be used in crafting recipes in place of milk; foods crafted with it will be slightly faster to consume.", CosmoItems.CONDENSED_MILK_BUCKET.get());
        this.addJeiItemDescriptions("Cream can be used in crafting recipes in place of milk; foods crafted with it will restore extra hunger points.", CosmoItems.CREAM_BUCKET.get());
        this.addJeiItemDescriptions("Wandering traders will now sell some special foods.", CosmoItems.WANDERING_GELATO.get());
        this.addJeiItemDescriptions("Depending on the ingredients used to craft the syrup, it can carry one of five flavors: sour, sweet, bitter, spicy, or strange. These flavors can modify the user's existing status effects, alter their duration, and grant additional effects.", CosmoItems.BERRY_SYRUP_BOTTLE.get());
        this.addJeiItemDescriptions("These nether-dwelling parasitic plants only have a chance to drop when player kill living entities in specific biomes. Boilberries are found in the Crimson Forest, while Spinalberries appear in the Warped Forest.", CosmoItems.BOILBERRY.get());
        this.addJeiItemDescriptions("Use a glass bottle on a Shroomlight can extract its sap; an exhausted Shroomlight takes some time to recover.", CosmoItems.FUNGUIS_BOTTLE.get());

        this.addJeiItemDescriptions("Frozen Dessert Tubs are a type of specialised block used for crafting and storing frozen dessert. Firstly, pour milk into the tub and add sugar to begin the transformation into condensed milk. Once the tub is closed, the condensed milk will gradually turn into cream. Place an ice or snow block nearby, add flavor ingredients to the cream, and you will have a tub of ice cream.", CosmoBlocks.IRON_FROZEN_DESSERT_TUB.get());

        this.addAdvancement(".husbandry.eat_special_wildberry", "Berry Special", "Eat a wildberry with a special effect");
        this.addAdvancement(".husbandry.feed_wheatgrass", "It's Hairball Time!", "Feed any wheatgrass-based food to a tamed cat");
        this.addAdvancement(".husbandry.plant_potted_crop", "Zen Garden", "Plant a wildberry or fiddlehead in a flower pot and watch it grow");
        this.addAdvancement(".husbandry.eat_herbal_cookie", "Suspicious Cookie", "Eat a herbal cookie, no matter what it's made of");
        this.addAdvancement(".husbandry.restore_gulime", "...Baby One More Time", "Keep at least 4 small gulimes in your inventory and wait for them to restore");
        this.addAdvancement(".husbandry.obtain_all_biome_gulimes", "Oops!... We Did It Again", "Collect all Gulime variants as you travel around the world");

        this.addAdvancement(".husbandry.craft_a_berry_syrup_bottle", "100% Homemade", "Craft a Berry Syrup Bottle, regardless of the ingredients or flavor");
        this.addAdvancement(".husbandry.has_a_sour_flavor", "Sour Candy Challenge", "Use the Sour flavor to modify an existing beneficial effect");
        this.addAdvancement(".husbandry.has_a_sweet_flavor", "Sweetener", "Use the Sweet flavor to modify an existing harmful or neutral effect");
        this.addAdvancement(".husbandry.has_a_bitter_flavor", "May Flowers", "Use the Bitter flavor to modify an existing harmful or neutral effect");
        this.addAdvancement(".husbandry.has_a_spicy_flavor", "Hot Stuff", "Use the Spicy flavor to modify an existing beneficial effect");
        this.addAdvancement(".husbandry.has_all_four_flavors", "Berrfect", "Have all 4 standard flavors at the same time");

        this.add("item_group." + Cosmopolitan.MODID + ".tab.blocks", "Cosmopolitan: Blocks");
        this.add("item_group." + Cosmopolitan.MODID + ".tab.items", "Cosmopolitan: Items");
    }

    private void addAdvancement(String path, String title, String description) {
        this.add("advancements." + Cosmopolitan.MODID + path + ".title", title);
        this.add("advancements." + Cosmopolitan.MODID + path + ".description", description);
    }

    private void addBlock(Block... blocks) {
        for (Block block : blocks)
            this.add(block, format(Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block))));
    }

    private void addBasket(Block... blocks) {
        for (Block block : blocks)
            this.add(block, "Basket of " + format(Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block))).replace(" Basket", ""));
    }

    private void addSack(Block... blocks) {
        for (Block block : blocks)
            this.add(block, "Sack of " + format(Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block))).replace(" Sack", ""));
    }

    private void addFluidType(FluidType... fluidTypes) {
        for (FluidType fluidType : fluidTypes) {
            ResourceLocation id = ForgeRegistries.FLUID_TYPES.get().getKey(fluidType);
            String key = "fluid_type." + id.getNamespace() + "." + id.getPath();
            add(key, format(id));
        }
    }

    private void addBerrySyrupType(FluidType... fluidTypes) {
        for (FluidType fluidType : fluidTypes) {
            ResourceLocation id = ForgeRegistries.FLUID_TYPES.get().getKey(fluidType);
            String key = "fluid_type." + id.getNamespace() + "." + id.getPath();
            add(key, format(id).replace("Berry Syrup ", "") + " Berry Syrup");
        }
    }

    private void addPotion(Potion... potions) {
        for (Potion potion : potions) {
            ResourceLocation id = ForgeRegistries.POTIONS.getKey(potion);
            String key = "item.minecraft.potion.effect." + id.getPath();
            add(key, "Potion of " + format(id).replace(" Long", "").replace(" Strong", ""));
            String key2 = "item.minecraft.splash_potion.effect." + id.getPath();
            add(key2,  "Splash Potion of " + format(id).replace(" Long", "").replace(" Strong", ""));
            String key3 = "item.minecraft.lingering_potion.effect." + id.getPath();
            add(key3,  "Lingering Potion of " + format(id).replace(" Long", "").replace(" Strong", ""));
            String key4 = "item.minecraft.tipped_arrow.effect." + id.getPath();
            add(key4,  "Arrow of " + format(id).replace(" Long", "").replace(" Strong", ""));
        }
    }
    private void addEffect(String description, MobEffect... effects) {
        for (MobEffect effect : effects) {
            ResourceLocation key = Objects.requireNonNull(ForgeRegistries.MOB_EFFECTS.getKey(effect));
            String path = "effect." + key.getNamespace() + "." + key.getPath();

            this.add(effect, format(key));
            this.add(path + ".description", description);
        }
    }

    private void addSpecialFluidType(FluidType fluidType, String name) {
        ResourceLocation id = ForgeRegistries.FLUID_TYPES.get().getKey(fluidType);
        String key = "fluid_type." + id.getNamespace() + "." + id.getPath();
        add(key, name);
    }

    private void addSpecialItem(Item item, String name) {
            this.add(item, name);
    }

    private void addSpecialBlock(Block block, String name) {
        this.add(block, name);
    }

    private void addItem(Item... items) {
        for (Item item : items)
            this.add(item, format(Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(item))).replace(" With ", " with ").replace(" De ", " de ").replace(" And ", " and "));
    }

    private void addSlice(Item... items) {
        for (Item item : items)
            this.add(item, "Slice of " + format(Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(item))).replace(" Slice", ""));
    }

    private void addTradeItem(Item... items) {
        for (Item item : items)
            this.add(item, format(Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(item))).replace("s ", "'s "));
    }


    private void addLlamaMarshmallow(Item... items) {
        for (Item item : items)
            this.add(item, format(Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(item))).replace("Llama Marshmallow ", "") + " Llama Marshmallow");
    }

    private void addDoublePopsicle(Item... items) {
        for (Item item : items)
            this.add(item, "Double " + format(Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(item))).replace(" Double", ""));
    }

    private void addSmallGulime(Item... items) {
        for (Item item : items)
            this.add(item, "Small " + format(Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(item))).replace(" Small", ""));
    }

    private void addJeiItemDescriptions(String description, Item... items) {
        for (Item item : items) {
            ResourceLocation id = Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(item));
            String key = "jei." + id.getNamespace() + "." + id.getPath() + ".desc";
            add(key, description);
        }
    }

    private void addJeiItemDescriptions(String description, Block... blocks) {
        for (Block block : blocks) {
            ResourceLocation id = Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block));
            String key = "jei." + id.getNamespace() + "." + id.getPath() + ".desc";
            add(key, description);
        }
    }

    private String format(ResourceLocation registryName) {
        return WordUtils.capitalizeFully(registryName.getPath().replace("_", " "));
    }

}

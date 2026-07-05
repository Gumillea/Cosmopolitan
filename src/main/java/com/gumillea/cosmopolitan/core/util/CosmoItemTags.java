package com.gumillea.cosmopolitan.core.util;

import com.gumillea.cosmopolitan.Cosmopolitan;
import com.teamabnormals.blueprint.core.util.TagUtil;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class CosmoItemTags {
    public static final TagKey<Item> BERRIES = TagUtil.itemTag("forge", "berries");
    public static final TagKey<Item> FRUITS = TagUtil.itemTag("forge", "fruits");
    public static final TagKey<Item> FRUITS_SWEET = TagUtil.itemTag("forge", "fruits/sweet");
    public static final TagKey<Item> APPLE = TagUtil.itemTag("forge", "fruits/apple");
    public static final TagKey<Item> BANANA = TagUtil.itemTag("forge", "fruits/banana");
    public static final TagKey<Item> BAYBERRY = TagUtil.itemTag("forge", "fruits/bayberry");
    public static final TagKey<Item> BLUEBERRY = TagUtil.itemTag("forge", "fruits/blueberries");
    public static final TagKey<Item> CHORUS = TagUtil.itemTag("forge", "fruits/chorus");
    public static final TagKey<Item> CHERRY = TagUtil.itemTag("forge", "fruits/cherry");
    public static final TagKey<Item> CRANBERRY = TagUtil.itemTag("forge", "fruits/cranberry");
    public static final TagKey<Item> CURRANT = TagUtil.itemTag("forge", "fruits/currant");
    public static final TagKey<Item> LEMON = TagUtil.itemTag("forge", "fruits/lemon");
    public static final TagKey<Item> LIME = TagUtil.itemTag("forge", "fruits/lime");
    public static final TagKey<Item> LYCHEE = TagUtil.itemTag("forge", "fruits/lychee");
    public static final TagKey<Item> MANGO = TagUtil.itemTag("forge", "fruits/mango");
    public static final TagKey<Item> MANGOSTEEN = TagUtil.itemTag("forge", "fruits/mangosteen");
    public static final TagKey<Item> MELON = TagUtil.itemTag("forge", "fruits/melon");
    public static final TagKey<Item> MULBERRY = TagUtil.itemTag("forge", "fruits/mulberry");
    public static final TagKey<Item> ORANGE = TagUtil.itemTag("forge", "fruits/orange");
    public static final TagKey<Item> PEACH = TagUtil.itemTag("forge", "fruits/peach");
    public static final TagKey<Item> PEAR = TagUtil.itemTag("forge", "fruits/pear");
    public static final TagKey<Item> PERSIMMON = TagUtil.itemTag("forge", "fruits/persimmon");
    public static final TagKey<Item> PINEAPPLE = TagUtil.itemTag("forge", "fruits/pineapple");
    public static final TagKey<Item> POMEGRANATE = TagUtil.itemTag("forge", "fruits/pomegranate");
    public static final TagKey<Item> SALMONBERRIES = TagUtil.itemTag("forge", "fruits/salmonberries");
    public static final TagKey<Item> ELDERBERRY = TagUtil.itemTag("forge", "fruits/elderberry");

    public static final TagKey<Item> SWEET_BERRY = TagUtil.itemTag("forge", "fruits/sweet_berries");
    public static final TagKey<Item> STRAWBERRY = TagUtil.itemTag("forge", "fruits/strawberry");
    public static final TagKey<Item> GLOW_BERRY = TagUtil.itemTag("forge", "fruits/glow_berries");

    public static final TagKey<Item> CATTAILS = TagUtil.itemTag("forge", "cattails");
    public static final TagKey<Item> COOKIE = TagUtil.itemTag("forge", "cookies");
    public static final TagKey<Item> DOUGH = TagUtil.itemTag("forge", "dough");

    public static final TagKey<Item> CROPS = TagUtil.itemTag("forge", "crops");
    public static final TagKey<Item> CARROT = TagUtil.itemTag("forge", "crops/carrot");
    public static final TagKey<Item> FIDDLEHEADS = TagUtil.itemTag("forge", "crops/fiddleheads");
    public static final TagKey<Item> POTATO = TagUtil.itemTag("forge", "crops/potato");
    public static final TagKey<Item> TUBER = TagUtil.itemTag("forge", "crops/tuber");
    public static final TagKey<Item> RED_BEAN = TagUtil.itemTag("forge", "crops/red_bean");
    public static final TagKey<Item> TOMATO = TagUtil.itemTag("forge", "crops/tomato");
    public static final TagKey<Item> SUGARCANE = TagUtil.itemTag("forge", "crops/sugarcane");

    public static final TagKey<Item> BREAD = TagUtil.itemTag("forge", "bread");
    public static final TagKey<Item> CAKE_SLICES = TagUtil.itemTag("forge", "cake_slices");
    public static final TagKey<Item> FISH_SLICE = TagUtil.itemTag("forge", "fish_slices");
    public static final TagKey<Item> JAMS = TagUtil.itemTag("forge", "jams");
    public static final TagKey<Item> GRAIN = TagUtil.itemTag("forge", "grain");
    public static final TagKey<Item> NUTS = TagUtil.itemTag("forge", "nuts");
    public static final TagKey<Item> CHOCOLATE = TagUtil.itemTag("forge", "chocolate");
    public static final TagKey<Item> VEGETABLES = TagUtil.itemTag("forge", "vegetables");
    public static final TagKey<Item> PUMPKINS = TagUtil.itemTag("forge", "pumpkins");
    public static final TagKey<Item> MOSS = TagUtil.itemTag("forge", "moss");
    public static final TagKey<Item> SALAD_INGREDIENTS = TagUtil.itemTag("forge", "salad_ingredients");
    public static final TagKey<Item> MILK = TagUtil.itemTag("forge", "milk");
    public static final TagKey<Item> CREAM = TagUtil.itemTag("forge", "cream");
    public static final TagKey<Item> BLACK_COFFEE = TagUtil.itemTag("forge", "coffees/black");
    public static final TagKey<Item> CONDENSED_MILK = TagUtil.itemTag("forge", "condensed_milk");
    public static final TagKey<Item> MILK_BOTTLE = TagUtil.itemTag("forge", "milk/milk_bottle");
    public static final TagKey<Item> COOKING_OIL = TagUtil.itemTag("forge", "cooking_oil");
    public static final TagKey<Item> KNIVES = TagUtil.itemTag("forge", "tools/knives");
    public static final TagKey<Item> SALMON_EGGS = TagUtil.itemTag("forge", "eggs/salmon");
    public static final TagKey<Item> COOKED_SALMON = TagUtil.itemTag("forge", "cooked_fishes/salmon");
    public static final TagKey<Item> SYRUP = TagUtil.itemTag("forge", "syrup");
    public static final TagKey<Item> COOKED_COD = TagUtil.itemTag("forge", "cooked_fishes/cod");

    public static final TagKey<Item> UPRIGHT_ON_BELT = TagUtil.itemTag("create", "upright_on_belt");

    public static final TagKey<Item> FERMENTED_DRINKS = TagUtil.itemTag(CosmoCompat.BAC, "fermented_drinks");

    public static final TagKey<Item> ICE_CREAM = TagUtil.itemTag(CosmoCompat.NEA, "ice_cream");
    public static final TagKey<Item> ICE_CUBE = TagUtil.itemTag("forge", "ice_cubes");
    public static final TagKey<Item> FROZEN_DESSERT_INGREDIENTS = TagUtil.itemTag("forge", "frozen_dessert_ingredients");

    public static final TagKey<Item> ICE_CREAM_CONES = TagUtil.itemTag(Cosmopolitan.MODID, "ice_cream_cones");
    public static final TagKey<Item> BIOME_GULIME = TagUtil.itemTag(Cosmopolitan.MODID, "biome_gulimes");

    public static final TagKey<Item> HERBAL_POWDER_INGREDIENTS = TagUtil.itemTag(Cosmopolitan.MODID, "herbal_powder_ingredients");
    public static final TagKey<Item> KYKEON_INGREDIENTS = TagUtil.itemTag(Cosmopolitan.MODID, "kykeon_ingredients");
    public static final TagKey<Item> FUNGUIS = TagUtil.itemTag(Cosmopolitan.MODID, "funguis");

    public static final TagKey<Item> EXUBERANT_SOURCES = TagUtil.itemTag(Cosmopolitan.MODID, "exuberant_sources");
    public static final TagKey<Item> COMFORT_SOURCES = TagUtil.itemTag(Cosmopolitan.MODID, "comfort_sources");
    public static final TagKey<Item> CAROTENE_SOURCES = TagUtil.itemTag(Cosmopolitan.MODID, "carotene_sources");
    public static final TagKey<Item> TRACER_SOURCES = TagUtil.itemTag(Cosmopolitan.MODID, "tracer_sources");
    public static final TagKey<Item> ABYSMAL_TORCH_SOURCES = TagUtil.itemTag(Cosmopolitan.MODID, "abysmal_torch_sources");
    public static final TagKey<Item> VARDOGER_SOURCES = TagUtil.itemTag(Cosmopolitan.MODID, "vardoger_sources");
    public static final TagKey<Item> INGRAINED_SOURCES = TagUtil.itemTag(Cosmopolitan.MODID, "ingrained_sources");

    public static final TagKey<Item> YEAR_ROUND_CROPS = TagUtil.itemTag(CosmoCompat.SS, "year_round_crops");
    public static final TagKey<Item> SPRING_CROPS = TagUtil.itemTag(CosmoCompat.SS, "spring_crops");
    public static final TagKey<Item> SUMMER_CROPS = TagUtil.itemTag(CosmoCompat.SS, "summer_crops");
    public static final TagKey<Item> AUTUMN_CROPS = TagUtil.itemTag(CosmoCompat.SS, "autumn_crops");
    public static final TagKey<Item> WINTER_CROPS = TagUtil.itemTag(CosmoCompat.SS, "winter_crops");

    public static final TagKey<Item> ALL_SEASONS_CROPS = TagUtil.itemTag(CosmoCompat.ES, "crops/all_seasons");
    public static final TagKey<Item> AVERAGE_HUMID_CROPS = TagUtil.itemTag(CosmoCompat.ES, "crops/average_humid");

    public static final TagKey<Item> TWO_THIRST_ITEMS = TagUtil.itemTag("toughasnails", "thirst/2_thirst_drinks");
    public static final TagKey<Item> FIVE_THIRST_ITEMS = TagUtil.itemTag("toughasnails", "thirst/5_thirst_drinks");
    public static final TagKey<Item> COOLING_ITEMS = TagUtil.itemTag("toughasnails", "cooling_consumed_items");
    public static final TagKey<Item> HEATING_ITEMS = TagUtil.itemTag("toughasnails", "heating_consumed_items");

    public static final TagKey<Item> FLAVORED_ITEM = TagUtil.itemTag("berrfect", "flavored_items");
    public static final TagKey<Item> BERRY_SYRUP_BLOCK = TagUtil.itemTag("berrfect", "berry_syrup_block");
}

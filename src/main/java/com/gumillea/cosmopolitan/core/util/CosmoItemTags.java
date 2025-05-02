package com.gumillea.cosmopolitan.core.util;

import com.teamabnormals.blueprint.core.util.TagUtil;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class CosmoItemTags {
    public static final TagKey<Item> COOKIE = TagUtil.itemTag("forge", "cookies");
    public static final TagKey<Item> POTATO = TagUtil.itemTag("forge", "crops/potato");
    public static final TagKey<Item> BERRIES = TagUtil.itemTag("forge", "berries");
    public static final TagKey<Item> FRUITS = TagUtil.itemTag("forge", "fruits");
    public static final TagKey<Item> JAMS = TagUtil.itemTag("forge", "jams");
    public static final TagKey<Item> CHOCOLATE = TagUtil.itemTag("forge", "chocolate");
    public static final TagKey<Item> VEGETABLES = TagUtil.itemTag("forge", "vegetables");
    public static final TagKey<Item> PUMPKINS = TagUtil.itemTag("forge", "pumpkins");
    public static final TagKey<Item> SALAD_INGREDIENTS = TagUtil.itemTag("forge", "salad_ingredients");
    public static final TagKey<Item> MILK_BOTTLE = TagUtil.itemTag("forge", "milk/milk_bottle");

    public static final TagKey<Item> UPRIGHT_ON_BELT = TagUtil.itemTag("create", "upright_on_belt");
    public static final TagKey<Item> ICE_CREAM = TagUtil.itemTag("neapolitan", "ice_cream");
    public static final TagKey<Item> ICE_CREAM_CONES = TagUtil.itemTag("cosmopolitan", "ice_cream_cones");
    public static final TagKey<Item> BIOME_GULIME = TagUtil.itemTag("cosmopolitan", "biome_gulimes");
}

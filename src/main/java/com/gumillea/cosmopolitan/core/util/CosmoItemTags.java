package com.gumillea.cosmopolitan.core.util;

import com.teamabnormals.blueprint.core.util.TagUtil;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class CosmoItemTags {
    public static final TagKey<Item> POTATO = TagUtil.itemTag("forge", "crops/potato");
    public static final TagKey<Item> BERRIES = TagUtil.itemTag("forge", "berries");
    public static final TagKey<Item> FRUITS = TagUtil.itemTag("forge", "fruits");
    public static final TagKey<Item> VEGETABLES = TagUtil.itemTag("forge", "vegetables");
    public static final TagKey<Item> PUMPKINS = TagUtil.itemTag("forge", "pumpkins");
    public static final TagKey<Item> SALAD_INGREDIENTS = TagUtil.itemTag("forge", "salad_ingredients");
}

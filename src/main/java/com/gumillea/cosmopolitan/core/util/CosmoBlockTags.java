package com.gumillea.cosmopolitan.core.util;

import com.teamabnormals.blueprint.core.util.TagUtil;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class CosmoBlockTags {
    public static final TagKey<Block> FREEZE_SOURCES = TagUtil.blockTag(CosmoCompat.BAC, "freeze_sources");
}

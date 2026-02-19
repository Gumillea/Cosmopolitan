package com.gumillea.cosmopolitan.core.misc;

import com.gumillea.cosmopolitan.core.reg.CosmoBlocks;
import net.minecraft.data.BlockFamily;

public class CosmoBlockFamilies {
    public static final BlockFamily BIRCH_COOKIE_FAMILY = new BlockFamily.Builder(CosmoBlocks.BIRCH_COOKIE_TILE.get()).slab(CosmoBlocks.BIRCH_COOKIE_TILE_SLAB.get()).stairs(CosmoBlocks.BIRCH_COOKIE_TILE_STAIRS.get()).wall(CosmoBlocks.BIRCH_COOKIE_TILE_WALL.get()).getFamily();
    public static final BlockFamily HERBAL_COOKIE_FAMILY = new BlockFamily.Builder(CosmoBlocks.HERBAL_COOKIE_TILE.get()).slab(CosmoBlocks.HERBAL_COOKIE_TILE_SLAB.get()).stairs(CosmoBlocks.HERBAL_COOKIE_TILE_STAIRS.get()).wall(CosmoBlocks.HERBAL_COOKIE_TILE_WALL.get()).getFamily();
    public static final BlockFamily PAW_COOKIE_FAMILY = new BlockFamily.Builder(CosmoBlocks.PAW_COOKIE_TILE.get()).slab(CosmoBlocks.PAW_COOKIE_TILE_SLAB.get()).stairs(CosmoBlocks.PAW_COOKIE_TILE_STAIRS.get()).wall(CosmoBlocks.PAW_COOKIE_TILE_WALL.get()).getFamily();
}

package com.gumillea.cosmopolitan.common.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class LongEatDurationItem extends Item
{
    public LongEatDurationItem(Properties properties) {
        super(properties);
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 64;
    }
}

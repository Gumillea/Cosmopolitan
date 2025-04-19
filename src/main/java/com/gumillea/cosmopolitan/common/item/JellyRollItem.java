package com.gumillea.cosmopolitan.common.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class JellyRollItem extends Item
{
    public JellyRollItem(Properties properties) {
        super(properties);
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 64;
    }
}

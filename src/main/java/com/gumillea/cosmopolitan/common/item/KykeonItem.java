package com.gumillea.cosmopolitan.common.item;

import net.minecraft.world.item.ItemStack;

public class KykeonItem extends DrinkItem{

    public KykeonItem(Properties properties) {
        super(properties.stacksTo(1), false, false);
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return true;
    }

}

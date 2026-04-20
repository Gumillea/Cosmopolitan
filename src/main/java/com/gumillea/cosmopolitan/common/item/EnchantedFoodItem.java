package com.gumillea.cosmopolitan.common.item;

import net.minecraft.world.item.ItemStack;

public class EnchantedFoodItem extends EffectItem{
    public EnchantedFoodItem(Properties properties) {
        super(properties);
    }

    public boolean isFoil(ItemStack stack) {
        return true;
    }
}

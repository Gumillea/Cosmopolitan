package com.gumillea.cosmopolitan.common.item;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class IcedDrinkItem extends DrinkItem{

    public IcedDrinkItem(Properties properties, boolean honey_drink, boolean tooltip) {
        super(properties, honey_drink, tooltip);
    }

    public ItemStack finishUsingItem(ItemStack itemStack, Level level, LivingEntity living) {
        living.setTicksFrozen(living.getTicksFrozen() + 80);

        return super.finishUsingItem(itemStack, level, living);
    }

}

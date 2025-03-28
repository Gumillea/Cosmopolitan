package com.gumillea.cosmopolitan.common.item;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public class FrozenDessertItem extends Item {
    private final boolean bowl;
    private final int tFrozen;

    public FrozenDessertItem(Properties p, boolean bowl, int tFrozen) {
        super(p);
        this.tFrozen = tFrozen;
        this.bowl = bowl;
    }

    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity living) {
        ItemStack itemstack = super.finishUsingItem(stack, level, living);
        living.setTicksFrozen(living.getTicksFrozen() + tFrozen);

        return !bowl || living instanceof Player && ((Player)living).getAbilities().instabuild ? itemstack : new ItemStack(Items.BOWL);
    }
}


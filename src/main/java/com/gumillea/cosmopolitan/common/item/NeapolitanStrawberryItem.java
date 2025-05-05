package com.gumillea.cosmopolitan.common.item;

import com.gumillea.cosmopolitan.core.util.CosmoCompat;
import com.teamabnormals.neapolitan.common.item.HealingItem;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.ModList;

public class NeapolitanStrawberryItem extends NeapolitanIceCreamItem {
    private final float hAmount;
    public NeapolitanStrawberryItem(Properties p, boolean bowl, int tFrozen, float hAmount) {
        super(p, bowl, tFrozen);
        this.hAmount = hAmount;
    }

    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity living) {
        if (ModList.get().isLoaded(CosmoCompat.NEA)) {
            HealingItem.applyHealing(this.hAmount, level, living);
        }
        return super.finishUsingItem(stack, level, living);
    }
}
package com.gumillea.cosmopolitan.common.item;

import com.gumillea.cosmopolitan.core.util.CosmoUtils;
import com.teamabnormals.neapolitan.core.registry.NeapolitanSoundEvents;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class NeapolitanStrawberryItem extends NeapolitanIceCreamItem {
    private final float hAmount;
    public NeapolitanStrawberryItem(Properties p, boolean bowl, int tFrozen, float hAmount) {
        super(p, bowl, tFrozen);
        this.hAmount = hAmount;
    }

    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity living) {
        CosmoUtils.applyHealing(hAmount, living);
        return super.finishUsingItem(stack, level, living);
    }

    public SoundEvent getDrinkingSound() {
        return this.gettFrozen() > 0 ? NeapolitanSoundEvents.ICE_CREAM_EAT.get() : SoundEvents.GENERIC_EAT;
    }

    public SoundEvent getEatingSound() {
        return this.gettFrozen() > 0 ? NeapolitanSoundEvents.ICE_CREAM_EAT.get() : SoundEvents.GENERIC_EAT;
    }
}
package com.gumillea.cosmopolitan.common.item;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;

public class GummyItem extends EffectItem{

    public GummyItem(Properties properties) {
        super(properties);
    }
    public SoundEvent getDrinkingSound() {
        return SoundEvents.HONEY_BLOCK_HIT;
    }

    public SoundEvent getEatingSound() {
        return SoundEvents.HONEY_BLOCK_HIT;
    }
}

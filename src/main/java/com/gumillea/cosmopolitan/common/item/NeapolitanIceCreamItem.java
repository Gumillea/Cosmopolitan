package com.gumillea.cosmopolitan.common.item;

import com.gumillea.cosmopolitan.core.util.CosmoCompat;
import com.teamabnormals.neapolitan.core.registry.NeapolitanSoundEvents;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;

public class NeapolitanIceCreamItem extends FrozenDessertItem{
    public NeapolitanIceCreamItem(Properties properties, boolean bowl, int tFrozen) {
        super(properties, bowl, tFrozen);
    }

    public SoundEvent getDrinkingSound() {
        return CosmoCompat.nea ? NeapolitanSoundEvents.ICE_CREAM_EAT.get() : SoundEvents.GENERIC_EAT;
    }

    public SoundEvent getEatingSound() {
        return CosmoCompat.nea ? NeapolitanSoundEvents.ICE_CREAM_EAT.get() : SoundEvents.GENERIC_EAT;
    }
}

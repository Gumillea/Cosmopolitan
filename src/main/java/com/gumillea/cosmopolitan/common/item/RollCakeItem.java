package com.gumillea.cosmopolitan.common.item;

import com.gumillea.cosmopolitan.core.reg.CosmoItems;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;

public class RollCakeItem extends EdibleBlockItem
{
    public RollCakeItem(Block block, Properties properties) {
    super(block, properties);
}

    @Override
    public int getUseDuration(ItemStack stack) {
        return 64;
    }

    public SoundEvent getDrinkingSound() {
        return this == CosmoItems.IRON_FIDDLEHEAD.get() ? SoundEvents.COPPER_HIT : SoundEvents.GENERIC_EAT;
    }

    public SoundEvent getEatingSound() {
        return this == CosmoItems.IRON_FIDDLEHEAD.get() ? SoundEvents.COPPER_HIT : SoundEvents.GENERIC_EAT;
    }
}

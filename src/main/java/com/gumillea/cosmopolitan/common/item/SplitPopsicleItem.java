package com.gumillea.cosmopolitan.common.item;

import com.gumillea.cosmopolitan.core.util.CosmoUtils;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class SplitPopsicleItem extends FrozenDessertItem{
    private final MobEffect effect1;
    private final MobEffect effect2;
    private final int duration;

    public SplitPopsicleItem(Properties properties, MobEffect effect1, MobEffect effect2, int duration) {
        super(properties, false, 80);
        this.effect1 = effect1;
        this.effect2 = effect2;
        this.duration = duration;
    }

    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity living) {
        if (!level.isClientSide) {
            CosmoUtils.gainRandomEffect(level, living, effect1, effect2, duration);
        }
        return super.finishUsingItem(stack, level, living);
    }

}

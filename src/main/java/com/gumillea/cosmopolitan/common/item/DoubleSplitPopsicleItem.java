package com.gumillea.cosmopolitan.common.item;

import com.gumillea.cosmopolitan.core.util.CosmoUtils;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.RegistryObject;

public class DoubleSplitPopsicleItem extends DoublePopsicleItem{
    private final MobEffect effect1;
    private final MobEffect effect2;
    private final int duration;

    public DoubleSplitPopsicleItem(Properties properties, RegistryObject<Item> result, MobEffect effect1, MobEffect effect2, int duration) {
        super(properties, false, 160, result);
        this.effect1 = effect1;
        this.effect2 = effect2;
        this.duration = duration;
    }

    public ItemStack finishUsingItem(ItemStack itemStack, Level level, LivingEntity living) {
        if (!level.isClientSide) {
            CosmoUtils.gainRandomEffect(level, living, effect1, effect2, duration);
        }
        return super.finishUsingItem(itemStack, level, living);
    }

    public MobEffect getEffect1() {
        return effect1;
    }

    public MobEffect getEffect2() {
        return effect2;
    }

    public int getDuration() {
        return duration;
    }
}

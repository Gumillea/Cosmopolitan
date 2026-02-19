package com.gumillea.cosmopolitan.common.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public class SatietyEffect extends MobEffect {

    public SatietyEffect() {
        super(MobEffectCategory.BENEFICIAL, 0xB559B2);
    }

    @Override
    public void applyEffectTick(LivingEntity living, int amplifier) {
        if (living instanceof Player player1) {
            player1.getFoodData().eat(2, 0.1F);
        }

    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return duration % 40 == 0;
    }

}

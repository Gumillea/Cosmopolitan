package com.gumillea.cosmopolitan.common.effect;

import com.gumillea.cosmopolitan.CosmoConfig;
import com.gumillea.cosmopolitan.core.reg.CosmoEffects;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public class ExuberantEffect extends MobEffect {

    public ExuberantEffect() {
        super(MobEffectCategory.BENEFICIAL, 0xDD2617);
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        int duration = entity.getEffect(CosmoEffects.EXUBERANT.get()).getDuration();
        if (duration == 2 && entity.getAbsorptionAmount() <= entity.getMaxHealth() * CosmoConfig.Common.EXUBERANT_MAXIMUM.get()) {
            if (entity instanceof Player player){
                player.playSound(SoundEvents.BEEHIVE_ENTER, 1.5F, 1.0F);
            }
            entity.setAbsorptionAmount(entity.getAbsorptionAmount() + (amplifier + 1) * 2);
        }
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }

}

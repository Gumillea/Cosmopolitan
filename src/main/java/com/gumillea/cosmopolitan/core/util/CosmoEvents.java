package com.gumillea.cosmopolitan.core.util;

import com.gumillea.cosmopolitan.Cosmopolitan;
import com.gumillea.cosmopolitan.core.reg.CosmoEffects;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;

@Mod.EventBusSubscriber(modid = Cosmopolitan.MODID)
public class CosmoEvents {

    @SubscribeEvent
    public static void onEntityAttacked(LivingDamageEvent event) {
        LivingEntity target = event.getEntity();
        if (target.getEffect(CosmoEffects.EXUBERANT.get()) != null) {
            target.removeEffect(CosmoEffects.EXUBERANT.get());
            if (target instanceof Player player){
                player.playSound(SoundEvents.AZALEA_BREAK, 1.5F, 1.0F);
            }
        }
        if (event.getSource().getEntity() instanceof LivingEntity attacker) {
            if (attacker.getEffect(CosmoEffects.TRACER.get()) != null) {
                int amplifier = Objects.requireNonNull(attacker.getEffect(CosmoEffects.TRACER.get())).getAmplifier();
                target.addEffect(new MobEffectInstance(CosmoEffects.MARKED.get(), 200 * amplifier));
                attacker.removeEffect(CosmoEffects.TRACER.get());
            }
        }
    }

}

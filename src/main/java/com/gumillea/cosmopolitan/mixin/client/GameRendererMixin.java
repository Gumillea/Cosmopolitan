package com.gumillea.cosmopolitan.mixin.client;

import com.gumillea.cosmopolitan.core.reg.CosmoEffects;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(GameRenderer.class)
public class GameRendererMixin {
    @Redirect(method = "getNightVisionScale", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/LivingEntity;getEffect(Lnet/minecraft/world/effect/MobEffect;)Lnet/minecraft/world/effect/MobEffectInstance;"))
    private static MobEffectInstance cosmo$fakeNightVision(LivingEntity entity, MobEffect effect) {
        MobEffectInstance realEffect = entity.getEffect(effect);

        if (effect == MobEffects.NIGHT_VISION && realEffect == null && entity.hasEffect(CosmoEffects.CAROTENE.get())) {
            return new MobEffectInstance(MobEffects.NIGHT_VISION, 888);
        }

        return realEffect;
    }
}


package com.gumillea.cosmopolitan.mixin.client;

import com.gumillea.cosmopolitan.core.reg.CosmoEffects;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(LightTexture.class)
public class LightTextureMixin {

    @Redirect(method = "updateLightTexture", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/player/LocalPlayer;hasEffect(Lnet/minecraft/world/effect/MobEffect;)Z"))
    private boolean cosmo$allowCarotene(LocalPlayer player, MobEffect effect) {
        if (effect == MobEffects.NIGHT_VISION && player.hasEffect(CosmoEffects.CAROTENE.get())) {
            return true;
        }
        return player.hasEffect(effect);
    }

    @Redirect(method = "updateLightTexture", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/GameRenderer;getNightVisionScale(Lnet/minecraft/world/entity/LivingEntity;F)F"))
    private float cosmo$applyCarotene(LivingEntity living, float f) {
        float scale = GameRenderer.getNightVisionScale(living, f);
        if (living.hasEffect(CosmoEffects.CAROTENE.get()) && !living.hasEffect(MobEffects.NIGHT_VISION)) {
            return 0.06F;
        }
        return scale;
    }
}
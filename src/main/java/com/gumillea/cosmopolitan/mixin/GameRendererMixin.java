package com.gumillea.cosmopolitan.mixin;

import com.gumillea.cosmopolitan.core.reg.CosmoEffects;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.fml.ModList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(GameRenderer.class)
public class GameRendererMixin {

    @Redirect(method = "getNightVisionScale", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/effect/MobEffectInstance;endsWithin(I)Z"))
    private static boolean modifyNightVision(MobEffectInstance instance, int duration, LivingEntity entity) {
        if (!ModList.get().isLoaded("no_nv_flash") && !ModList.get().isLoaded("flickerfix") && !ModList.get().isLoaded("betternightvision")) {
            if (entity instanceof Player player && player.hasEffect(MobEffects.NIGHT_VISION) && player.hasEffect(CosmoEffects.CAROTENE.get())) {
                return false;
            }
        }
        return instance.endsWithin(duration);
    }

}


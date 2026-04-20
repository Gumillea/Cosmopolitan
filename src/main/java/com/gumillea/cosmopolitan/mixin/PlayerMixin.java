package com.gumillea.cosmopolitan.mixin;

import com.gumillea.cosmopolitan.core.reg.CosmoEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Player.class)
public abstract class PlayerMixin {

    @Inject(method = "getDigSpeed", at = @At("RETURN"), cancellable = true, remap = false)
    private void cosmo$addedPhototaxisSpeed(BlockState state, BlockPos pos, CallbackInfoReturnable<Float> cir) {
        Player player = (Player)(Object)this;
        if (player.hasEffect(CosmoEffects.PHOTOTAXIS.get())) {
            Level level = player.level();
            BlockPos playerPos = BlockPos.containing(player.getX(), player.getY(), player.getZ());

            float speed = cir.getReturnValue();
            int amplifier = player.getEffect(CosmoEffects.PHOTOTAXIS.get()).getAmplifier() + 1;
            int light = level.getRawBrightness(playerPos, level.getSkyDarken()) + 1;
            float amount = player.hasEffect(MobEffects.GLOWING) ? amplifier * 16F : amplifier * light;
            speed *= 1.0F + amount * 0.01F;

            cir.setReturnValue(speed);
        }
    }
}

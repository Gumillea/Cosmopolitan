package com.gumillea.cosmopolitan.mixin;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Item.class)
public class ItemMixin {
    @Inject(method = "getUseDuration(Lnet/minecraft/world/item/ItemStack;)I", at = @At("RETURN"), cancellable = true)
    private void onGetUseDuration(ItemStack stack, CallbackInfoReturnable<Integer> cir) {
        int duration = cir.getReturnValue();
        if (stack.hasTag() && stack.getTag().getBoolean("has_condensed_milk")) {
            int smoothDuration = duration * 3 / 4;
            cir.setReturnValue(smoothDuration);
        }
    }
}
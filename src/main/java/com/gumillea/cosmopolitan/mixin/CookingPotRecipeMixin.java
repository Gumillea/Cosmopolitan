package com.gumillea.cosmopolitan.mixin;

import com.gumillea.cosmopolitan.core.util.CosmoItemTags;
import net.minecraft.core.RegistryAccess;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.items.wrapper.RecipeWrapper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import vectorwing.farmersdelight.common.crafting.CookingPotRecipe;

@Mixin(value = CookingPotRecipe.class, remap = false)
public class CookingPotRecipeMixin {

    @Unique
    private boolean hasMilk;
    @Unique
    private boolean hasCream;

    @Inject(method = "matches", at = @At("RETURN"), cancellable = true)
    private void onMatches(RecipeWrapper inv, Level level, CallbackInfoReturnable<Boolean> cir) {
        if (cir.getReturnValue()) {
            hasMilk = false;
            hasCream = false;

            for (int i = 0; i < inv.getContainerSize(); i++) {
                ItemStack stack = inv.getItem(i);
                CompoundTag tag = stack.getTag();
                if (!stack.isEmpty()) {
                    if (stack.is(CosmoItemTags.CONDENSED_MILK)) hasMilk = true;
                    if (stack.is(CosmoItemTags.CREAM)) hasCream = true;
                    if (tag != null) {
                        if (tag.getBoolean("has_condensed_milk")) hasMilk = true;
                        if (tag.getBoolean("has_cream")) hasCream = true;
                    }
                }
                if (hasMilk && hasCream) break;
            }
        }
    }

    @Inject(method = "getResultItem", at = @At("RETURN"), cancellable = true)
    private void onGetResultItem(RegistryAccess access, CallbackInfoReturnable<ItemStack> cir) {
        ItemStack result = cir.getReturnValue().copy();
        if (!result.isEmpty() && result.getItem().isEdible()) {
            CompoundTag tag = result.getOrCreateTag();
            if (hasMilk) tag.putBoolean("has_condensed_milk", true);
            if (hasCream) tag.putBoolean("has_cream", true);
        }
        cir.setReturnValue(result);

    }

    @Inject(method = "getOutputContainer", at = @At("RETURN"), cancellable = true)
    private void onGetOutputContainer(CallbackInfoReturnable<ItemStack> cir) {
        ItemStack container = cir.getReturnValue().copy();
        if (!container.isEmpty()) {
            cir.setReturnValue(container);
        }
    }
}
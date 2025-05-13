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
import vectorwing.farmersdelight.common.crafting.CuttingBoardRecipe;

@Mixin(value = CuttingBoardRecipe.class, remap = false)
public class CuttingBoardRecipeMixin {
    @Unique
    private boolean hasMilk;
    @Unique
    private boolean hasCream;

    @Inject(method = "matches", at = @At("RETURN"), cancellable = true)
    private void onMatches(RecipeWrapper inv, Level level, CallbackInfoReturnable<Boolean> cir) {
        if (cir.getReturnValue()) {
            hasMilk = false;
            hasCream = false;

            ItemStack input = inv.getItem(0);
            if (!input.isEmpty()) {
                if (input.is(CosmoItemTags.CONDENSED_MILK)) hasMilk = true;
                if (input.is(CosmoItemTags.CREAM)) hasCream = true;

                CompoundTag tag = input.getTag();
                if (tag != null) {
                    if (tag.getBoolean("has_condensed_milk")) hasMilk = true;
                    if (tag.getBoolean("has_cream")) hasCream = true;
                }
            }
        }
    }

    @Inject(method = "getResultItem", at = @At("RETURN"), cancellable = true)
    private void onGetResultItem(RegistryAccess access, CallbackInfoReturnable<ItemStack> cir) {
        ItemStack result = cir.getReturnValue();
        if (!result.isEmpty() && result.getItem().isEdible()) {
            result = result.copy();
            CompoundTag tag = result.getOrCreateTag();
            if (hasMilk) tag.putBoolean("has_condensed_milk", true);
            if (hasCream) tag.putBoolean("has_cream", true);
            cir.setReturnValue(result);
        }
    }

    @Inject(method = "rollResults", at = @At("RETURN"), cancellable = true)
    private void onRollResults(net.minecraft.util.RandomSource rand, int fortuneLevel, CallbackInfoReturnable<java.util.List<ItemStack>> cir) {
        java.util.List<ItemStack> results = cir.getReturnValue();
        if (!results.isEmpty()) {
            for (int i = 0; i < results.size(); i++) {
                ItemStack stack = results.get(i);
                if (!stack.isEmpty() && stack.getItem().isEdible()) {
                    ItemStack newStack = stack.copy();
                    CompoundTag tag = newStack.getOrCreateTag();
                    if (hasMilk) tag.putBoolean("has_condensed_milk", true);
                    if (hasCream) tag.putBoolean("has_cream", true);
                    results.set(i, newStack);
                }
            }
            cir.setReturnValue(results);
        }
    }
}

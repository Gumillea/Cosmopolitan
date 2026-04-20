package com.gumillea.cosmopolitan.mixin;

import net.minecraft.core.RegistryAccess;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.items.wrapper.RecipeWrapper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import vectorwing.farmersdelight.common.crafting.CuttingBoardRecipe;

import java.util.ArrayList;
import java.util.List;

@Mixin(value = CuttingBoardRecipe.class, remap = false)
public class CuttingBoardRecipeMixin {
    @Unique
    private CompoundTag TAG;

    @Inject(method = "matches(Lnet/minecraftforge/items/wrapper/RecipeWrapper;Lnet/minecraft/world/level/Level;)Z", at = @At("RETURN"), cancellable = true)
    private void cosmo$onMatches(RecipeWrapper inv, Level level, CallbackInfoReturnable<Boolean> cir) {
        if (cir.getReturnValue()) {
            ItemStack input = inv.getItem(0);
            if (!input.isEmpty() && input.hasTag()) {
                TAG = input.getTag().copy();
            } else {
                TAG = null;
            }
        }
    }

    @Inject(method = "assemble(Lnet/minecraftforge/items/wrapper/RecipeWrapper;Lnet/minecraft/core/RegistryAccess;)Lnet/minecraft/world/item/ItemStack;", at = @At("RETURN"), cancellable = true)
    private void cosmo$onAssemble(RecipeWrapper inv, RegistryAccess access, CallbackInfoReturnable<ItemStack> cir) {
        if (TAG != null) {
            ItemStack result = cir.getReturnValue();
            if (!result.isEmpty()) {
                ItemStack copy = result.copy();
                copy.setTag(TAG.copy());
                cir.setReturnValue(copy);
            }
        }
    }

    @Inject(method = "rollResults(Lnet/minecraft/util/RandomSource;I)Ljava/util/List;",
            at = @At("RETURN"), cancellable = true)
    private void cosmo$onRollResults(RandomSource random, int i, CallbackInfoReturnable<List<ItemStack>> cir) {
        if (TAG != null) {
            List<ItemStack> results = cir.getReturnValue();
            if (!results.isEmpty()) {
                List<ItemStack> newResults = new ArrayList<>();
                for (ItemStack stack : results) {
                    if (!stack.isEmpty()) {
                        ItemStack copy = stack.copy();
                        copy.setTag(TAG.copy());
                        newResults.add(copy);
                    } else {
                        newResults.add(stack);
                    }
                }
                cir.setReturnValue(newResults);
            }
        }
    }
}
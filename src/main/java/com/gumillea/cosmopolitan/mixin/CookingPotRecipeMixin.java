package com.gumillea.cosmopolitan.mixin;

import com.gumillea.cosmopolitan.common.item.HerbalFoodItem;
import com.gumillea.cosmopolitan.core.reg.CosmoItems;
import com.gumillea.cosmopolitan.core.util.CosmoItemTags;
import net.minecraft.core.RegistryAccess;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.SuspiciousEffectHolder;
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
    private boolean cosmopolitan$hasMilk;
    @Unique
    private boolean cosmopolitan$hasCream;
    @Unique
    private MobEffect cosmopolitan$tisaneEffect;
    @Unique
    private int cosmopolitan$tisaneDuration;

    @Inject(method = "matches(Lnet/minecraftforge/items/wrapper/RecipeWrapper;Lnet/minecraft/world/level/Level;)Z", at = @At("RETURN"), cancellable = true)
    private void onMatches(RecipeWrapper inv, Level level, CallbackInfoReturnable<Boolean> cir) {
        if (cir.getReturnValue()) {
            cosmopolitan$hasMilk = false;
            cosmopolitan$hasCream = false;
            cosmopolitan$tisaneEffect = null;
            cosmopolitan$tisaneDuration = 0;

            ItemStack recipeOutput = ((CookingPotRecipe) (Object) this).getResultItem(level.registryAccess());
            boolean isTisane = recipeOutput.is(CosmoItems.TISANE.get());
            boolean isEdible = recipeOutput.getItem().isEdible();

            if (!isEdible) return;

            for (int i = 0; i < inv.getContainerSize(); i++) {
                ItemStack stack = inv.getItem(i);
                if (stack.isEmpty()) continue;

                if (isEdible) {
                    if (stack.is(CosmoItemTags.CONDENSED_MILK)) cosmopolitan$hasMilk = true;
                    if (stack.is(CosmoItemTags.CREAM)) cosmopolitan$hasCream = true;

                    CompoundTag tag = stack.getTag();
                    if (tag != null) {
                        if (tag.getBoolean("has_condensed_milk")) cosmopolitan$hasMilk = true;
                        if (tag.getBoolean("has_cream")) cosmopolitan$hasCream = true;
                    }
                }

                if (isTisane && cosmopolitan$tisaneEffect == null) {
                    SuspiciousEffectHolder holder = SuspiciousEffectHolder.tryGet(stack.getItem());
                    if (holder != null) {
                        cosmopolitan$tisaneEffect = holder.getSuspiciousEffect();
                        int duration = holder.getEffectDuration();
                        cosmopolitan$tisaneDuration = duration <= 1 ? duration : duration * 2;
                    }
                }

                if (cosmopolitan$hasMilk && cosmopolitan$hasCream && (!isTisane || cosmopolitan$tisaneEffect != null)) {
                    break;
                }
            }
        }
    }

    @Inject(method = "getResultItem(Lnet/minecraft/core/RegistryAccess;)Lnet/minecraft/world/item/ItemStack;", at = @At("RETURN"), cancellable = true, remap = true)
    private void onGetResultItem(RegistryAccess access, CallbackInfoReturnable<ItemStack> cir) {
        ItemStack result = cir.getReturnValue().copy();
        if (result.isEmpty()) return;

        if (result.getItem().isEdible()) {
            if (cosmopolitan$hasMilk || cosmopolitan$hasCream) {
                CompoundTag tag = result.getOrCreateTag();
                if (cosmopolitan$hasMilk) tag.putBoolean("has_condensed_milk", true);
                if (cosmopolitan$hasCream) tag.putBoolean("has_cream", true);
            }
        }

        if (result.is(CosmoItems.TISANE.get()) && cosmopolitan$tisaneEffect != null) {
            HerbalFoodItem.saveMobEffect(result, cosmopolitan$tisaneEffect, cosmopolitan$tisaneDuration);
        }

        cir.setReturnValue(result);
    }
}
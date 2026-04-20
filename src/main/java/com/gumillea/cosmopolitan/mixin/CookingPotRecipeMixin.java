package com.gumillea.cosmopolitan.mixin;

import com.gumillea.cosmopolitan.CosmoConfig;
import com.gumillea.cosmopolitan.common.item.HerbalFoodItem;
import com.gumillea.cosmopolitan.core.misc.BerrfectFlavorHelper;
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

import java.util.ArrayList;
import java.util.List;

@Mixin(value = CookingPotRecipe.class, remap = false)
public class CookingPotRecipeMixin {

    @Unique
    private boolean cosmo$hasMilk;
    @Unique
    private boolean cosmo$hasCream;
    @Unique
    private final List<MobEffect> cosmo$tisaneEffects = new ArrayList<>();
    @Unique
    private final List<Integer> cosmo$tisaneDurations = new ArrayList<>();
    @Unique
    private String cosmo$berryFlavor;
    @Unique
    private final List<ItemStack> cosmo$ingredients = new ArrayList<>();

    @Inject(method = "matches(Lnet/minecraftforge/items/wrapper/RecipeWrapper;Lnet/minecraft/world/level/Level;)Z", at = @At("RETURN"))
    private void cosmo$onMatches(RecipeWrapper inv, Level level, CallbackInfoReturnable<Boolean> cir) {
        if (cir.getReturnValue()) {
            cosmo$hasMilk = false;
            cosmo$hasCream = false;
            cosmo$tisaneEffects.clear();
            cosmo$tisaneDurations.clear();
            cosmo$berryFlavor = null;
            cosmo$ingredients.clear();

            ItemStack recipeOutput = ((CookingPotRecipe) (Object) this).getResultItem(level.registryAccess());
            boolean isTisane = recipeOutput.is(CosmoItems.TISANE.get());
            boolean isBerrySyrup = CosmoConfig.Common.FLAVORED_SYRUP.get() && recipeOutput.is(CosmoItems.BERRY_SYRUP_BOTTLE.get());
            boolean isEdible = recipeOutput.getItem().isEdible();

            if (!isEdible) return;

            for (int i = 0; i < inv.getContainerSize(); i++) {
                ItemStack stack = inv.getItem(i);
                if (stack.isEmpty()) continue;

                if (isBerrySyrup) {
                    cosmo$ingredients.add(stack);
                }

                if (stack.is(CosmoItemTags.CONDENSED_MILK)) cosmo$hasMilk = true;
                if (stack.is(CosmoItemTags.CREAM)) cosmo$hasCream = true;

                CompoundTag tag = stack.getTag();
                if (tag != null) {
                    if (tag.getBoolean("has_condensed_milk")) cosmo$hasMilk = true;
                    if (tag.getBoolean("has_cream")) cosmo$hasCream = true;

                    if (cosmo$berryFlavor == null && tag.contains(BerrfectFlavorHelper.KEY)) {
                        cosmo$berryFlavor = tag.getString(BerrfectFlavorHelper.KEY);
                    }
                }

                if (isTisane) {
                    SuspiciousEffectHolder holder = SuspiciousEffectHolder.tryGet(stack.getItem());
                    if (holder != null) {
                        cosmo$tisaneEffects.add(holder.getSuspiciousEffect());
                        cosmo$tisaneDurations.add(holder.getEffectDuration());
                    }
                }
            }
        }
    }

    @Inject(method = "getResultItem(Lnet/minecraft/core/RegistryAccess;)Lnet/minecraft/world/item/ItemStack;", at = @At("RETURN"), cancellable = true, remap = true)
    private void cosmo$onGetResultItem(RegistryAccess access, CallbackInfoReturnable<ItemStack> cir) {
        ItemStack result = cir.getReturnValue().copy();
        if (result.isEmpty()) return;

        if (result.is(CosmoItems.BERRY_SYRUP_BOTTLE.get())) {
            BerrfectFlavorHelper.calculateFlavor(result, cosmo$ingredients);
        } else if (result.getItem().isEdible() && cosmo$berryFlavor != null) {
            result.getOrCreateTag().putString(BerrfectFlavorHelper.KEY, cosmo$berryFlavor);
        }

        if (result.getItem().isEdible()) {
            if (cosmo$hasMilk || cosmo$hasCream) {
                CompoundTag tag = result.getOrCreateTag();
                if (cosmo$hasMilk) tag.putBoolean("has_condensed_milk", true);
                if (cosmo$hasCream) tag.putBoolean("has_cream", true);
            }
        }

        if (result.is(CosmoItems.TISANE.get()) && !cosmo$tisaneEffects.isEmpty()) {
            for (int i = 0; i < cosmo$tisaneEffects.size(); i++) {
                HerbalFoodItem.saveMobEffect(result, cosmo$tisaneEffects.get(i), cosmo$tisaneDurations.get(i));
            }
        }

        cir.setReturnValue(result);
    }
}
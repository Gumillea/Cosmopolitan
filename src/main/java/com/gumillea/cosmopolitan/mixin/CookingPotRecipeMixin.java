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
import net.minecraft.world.level.block.SuspiciousEffectHolder;
import net.minecraftforge.items.wrapper.RecipeWrapper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import vectorwing.farmersdelight.common.crafting.CookingPotRecipe;

import java.util.ArrayList;
import java.util.List;

@Mixin(value = CookingPotRecipe.class, remap = false)
public class CookingPotRecipeMixin {

    @Inject(method = "assemble(Lnet/minecraftforge/items/wrapper/RecipeWrapper;Lnet/minecraft/core/RegistryAccess;)Lnet/minecraft/world/item/ItemStack;", at = @At("RETURN"), cancellable = true)
    private void cosmo$assemble(RecipeWrapper inv, RegistryAccess access, CallbackInfoReturnable<ItemStack> cir) {
        ItemStack result = cir.getReturnValue().copy();

        if (result.isEmpty() || !result.getItem().isEdible()) return;

        boolean hasMilk = false;
        boolean hasCream = false;
        boolean isBerrySyrup = CosmoConfig.Common.FLAVORED_SYRUP.get() && result.is(CosmoItems.BERRY_SYRUP_BOTTLE.get());
        boolean isTisane = result.is(CosmoItems.TISANE.get());

        String berryFlavor = null;
        List<ItemStack> berryIngredients = new ArrayList<>();
        List<MobEffect> tisaneEffects = new ArrayList<>();
        List<Integer> tisaneDurations = new ArrayList<>();

        for (int i = 0; i < inv.getContainerSize(); i++) {
            ItemStack stack = inv.getItem(i);

            if (stack.isEmpty()) {
                continue;
            }

            if (isBerrySyrup) {
                berryIngredients.add(stack);
            }

            if (stack.is(CosmoItemTags.CONDENSED_MILK)) {
                hasMilk = true;
            }

            if (stack.is(CosmoItemTags.CREAM)) {
                hasCream = true;
            }

            CompoundTag tag = stack.getTag();

            if (tag != null) {
                if (tag.getBoolean("has_condensed_milk")) {
                    hasMilk = true;
                }

                if (tag.getBoolean("has_cream")) {
                    hasCream = true;
                }

                if (berryFlavor == null && tag.contains(BerrfectFlavorHelper.KEY)) {
                    berryFlavor = tag.getString(BerrfectFlavorHelper.KEY);
                }
            }

            if (isTisane) {
                SuspiciousEffectHolder holder = SuspiciousEffectHolder.tryGet(stack.getItem());

                if (holder != null) {
                    tisaneEffects.add(holder.getSuspiciousEffect());
                    tisaneDurations.add(holder.getEffectDuration());
                }
            }
        }

        if (isBerrySyrup) {
            BerrfectFlavorHelper.calculateFlavor(result, berryIngredients);

        } else if (berryFlavor != null) {
            result.getOrCreateTag().putString(BerrfectFlavorHelper.KEY, berryFlavor);
        }

        if (hasMilk || hasCream) {
            CompoundTag tag = result.getOrCreateTag();

            if (hasMilk) tag.putBoolean("has_condensed_milk", true);
            if (hasCream) tag.putBoolean("has_cream", true);
        }

        if (isTisane && !tisaneEffects.isEmpty()) {

            for (int i = 0; i < tisaneEffects.size(); i++) {
                HerbalFoodItem.saveMobEffect(result, tisaneEffects.get(i), tisaneDurations.get(i));
            }
        }

        cir.setReturnValue(result);
    }
}
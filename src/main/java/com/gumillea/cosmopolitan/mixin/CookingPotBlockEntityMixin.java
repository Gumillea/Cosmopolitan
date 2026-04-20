package com.gumillea.cosmopolitan.mixin;

import com.gumillea.cosmopolitan.core.misc.BerrfectFlavorHelper;
import com.gumillea.cosmopolitan.core.reg.CosmoItems;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.ItemStackHandler;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import vectorwing.farmersdelight.common.block.entity.CookingPotBlockEntity;
import vectorwing.farmersdelight.common.crafting.CookingPotRecipe;

import java.util.ArrayList;
import java.util.List;

@Mixin(value = CookingPotBlockEntity.class, remap = false)
public abstract class CookingPotBlockEntityMixin {

    @Shadow
    @Final
    private ItemStackHandler inventory;

    @Inject(method = "canCook", at = @At("RETURN"), cancellable = true)
    private void cosmo$preventMismatch(CookingPotRecipe recipe, CallbackInfoReturnable<Boolean> cir) {
        if (!cir.getReturnValue()) return;

        CookingPotBlockEntity pot = (CookingPotBlockEntity) (Object) this;
        if (pot.getLevel() == null) return;

        ItemStack slot = this.inventory.getStackInSlot(6);
        if (slot.isEmpty()) return;

        ItemStack result = recipe.getResultItem(pot.getLevel().registryAccess());
        if (ItemStack.isSameItem(slot, result)) {
            if (!cosmo$checkNbt(slot)) {
                cir.setReturnValue(false);
            }
        }
    }

    @Inject(method = "moveMealToOutput", at = @At("HEAD"), cancellable = true)
    private void cosmo$moveMealToOutput(CallbackInfo ci) {
        ItemStack meal = this.inventory.getStackInSlot(6);
        ItemStack output = this.inventory.getStackInSlot(8);

        if (!meal.isEmpty() && !output.isEmpty() && ItemStack.isSameItem(meal, output)) {
            if (!cosmo$checkNbt(output)) {
                ci.cancel();
            }
        }
    }

    @Inject(method = "useStoredContainersOnMeal", at = @At("HEAD"), cancellable = true)
    private void cosmo$useStoredContainersOnMeal(CallbackInfo ci) {
        ItemStack meal = this.inventory.getStackInSlot(6);
        ItemStack output = this.inventory.getStackInSlot(8);

        if (!meal.isEmpty() && !output.isEmpty() && ItemStack.isSameItem(meal, output)) {
            if (!cosmo$checkNbt(output)) {
                ci.cancel();
            }
        }
    }

    @Unique
    private boolean cosmo$checkNbt(ItemStack stack) {
        if (stack.is(CosmoItems.BERRY_SYRUP_BOTTLE.get())) {
            List<ItemStack> input = new ArrayList<>();
            for (int i = 0; i < 6; i++) {
                ItemStack slot = this.inventory.getStackInSlot(i);
                if (!slot.isEmpty()) {
                    input.add(slot);
                }
            }
            String current = BerrfectFlavorHelper.getFlavorFromIngredients(input);
            String stored = stack.getOrCreateTag().getString(BerrfectFlavorHelper.KEY);

            return stored.equals(current);
        }


        return true;
    }
}
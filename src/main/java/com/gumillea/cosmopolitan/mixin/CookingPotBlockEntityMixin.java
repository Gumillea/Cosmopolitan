package com.gumillea.cosmopolitan.mixin;

import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.wrapper.RecipeWrapper;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import vectorwing.farmersdelight.common.block.entity.CookingPotBlockEntity;
import vectorwing.farmersdelight.common.crafting.CookingPotRecipe;

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

        ItemStack result = recipe.assemble(new RecipeWrapper(this.inventory), pot.getLevel().registryAccess());

        if (ItemStack.isSameItem(slot, result)) {
            if (!ItemStack.isSameItemSameTags(slot, result)) {
                cir.setReturnValue(false);
            }
        }
    }
}
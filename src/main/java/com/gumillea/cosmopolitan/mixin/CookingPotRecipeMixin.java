package com.gumillea.cosmopolitan.mixin;

import com.gumillea.cosmopolitan.core.util.CosmoItemTags;
import net.minecraft.core.RegistryAccess;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.tags.TagKey;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.ShapedRecipe;
import net.minecraftforge.items.wrapper.RecipeWrapper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import vectorwing.farmersdelight.common.crafting.CookingPotRecipe;

@Mixin(value = CookingPotRecipe.class, remap = false)
public abstract class CookingPotRecipeMixin {

    @Inject(
            method = "assemble(Lnet/minecraftforge/items/wrapper/RecipeWrapper;Lnet/minecraft/core/RegistryAccess;)Lnet/minecraft/world/item/ItemStack;",
            at = @At("RETURN"),
            cancellable = true
    )private void onAssemble(RecipeWrapper inv, RegistryAccess access, CallbackInfoReturnable<ItemStack> cir) {
        TagKey<Item> CONDENSED_MILK = CosmoItemTags.CONDENSED_MILK;
        TagKey<Item> CREAM = CosmoItemTags.CREAM;
        ItemStack result = cir.getReturnValue();
        boolean hasMilk = false;
        boolean  hasCream = false;

        if (!result.getItem().isEdible() && !result.is(CONDENSED_MILK) && !result.is(CREAM)) return;

        for (int i = 0; i < inv.getContainerSize(); i++) {
            ItemStack slot = inv.getItem(i);
            if (slot.is(CONDENSED_MILK)) hasMilk  = true;
            if (slot.is(CREAM)) hasCream = true;
            if (hasMilk && hasCream) break;
        }

        if (hasMilk || hasCream) {
            CompoundTag tag = result.getOrCreateTag();
            if (hasMilk)  tag.putBoolean("has_condensed_milk", true);
            if (hasCream) tag.putBoolean("has_cream", true);
            cir.setReturnValue(result);
        }
    }
}
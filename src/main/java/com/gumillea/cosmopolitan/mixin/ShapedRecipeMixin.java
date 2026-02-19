package com.gumillea.cosmopolitan.mixin;

import com.gumillea.cosmopolitan.core.util.CosmoItemTags;
import net.minecraft.core.RegistryAccess;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.tags.TagKey;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.ShapedRecipe;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ShapedRecipe.class)
public abstract class ShapedRecipeMixin {

    @Inject(method = "assemble(Lnet/minecraft/world/inventory/CraftingContainer;Lnet/minecraft/core/RegistryAccess;)Lnet/minecraft/world/item/ItemStack;", at = @At("RETURN"), cancellable = true)
    private void onAssemble(CraftingContainer inv, RegistryAccess access, CallbackInfoReturnable<ItemStack> cir) {
        ItemStack result = cir.getReturnValue();

        if (!result.getItem().isEdible()) return;

        TagKey<Item> CONDENSED_MILK = CosmoItemTags.CONDENSED_MILK;
        TagKey<Item> CREAM = CosmoItemTags.CREAM;
        boolean hasMilk = false;
        boolean hasCream = false;

        if (!result.is(CONDENSED_MILK) && !result.is(CREAM)){

            for (int i = 0; i < inv.getContainerSize(); i++) {
                ItemStack slot = inv.getItem(i);
                CompoundTag tag = slot.getTag();
                if (slot.is(CONDENSED_MILK)) hasMilk  = true;
                if (slot.is(CREAM)) hasCream = true;
                if (tag != null) {
                    if (tag.getBoolean("has_condensed_milk")) hasMilk = true;
                    if (tag.getBoolean("has_cream")) hasCream = true;
                }
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

}
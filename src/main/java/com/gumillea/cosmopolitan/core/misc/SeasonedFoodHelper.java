package com.gumillea.cosmopolitan.core.misc;

import com.gumillea.cosmopolitan.core.reg.CosmoItems;
import com.gumillea.cosmopolitan.core.util.CosmoItemTags;
import com.gumillea.cosmopolitan.core.util.CosmoUtils;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.ArrayList;
import java.util.List;

public class SeasonedFoodHelper {
    public static String HAS_MILK = "has_condensed_milk";
    public static String HAS_CREAM = "has_cream";

    public static void applyNbt(CraftingContainer inv, CallbackInfoReturnable<ItemStack> cir){
        if (!cir.getReturnValue().getItem().isEdible()) return;

        handleMilkNbt(inv, cir);
        handleBerrfectNbt(inv, cir);
    }

    public static void handleMilkNbt(CraftingContainer inv, CallbackInfoReturnable<ItemStack> cir) {
        ItemStack result = cir.getReturnValue();

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
                    if (tag.getBoolean(HAS_MILK)) hasMilk = true;
                    if (tag.getBoolean(HAS_CREAM)) hasCream = true;
                }
                if (hasMilk && hasCream) break;
            }

            if (hasMilk || hasCream) {
                CompoundTag tag = result.getOrCreateTag();
                if (hasMilk)  tag.putBoolean(HAS_MILK, true);
                if (hasCream) tag.putBoolean(HAS_CREAM, true);
                cir.setReturnValue(result);
            }
        }
    }

    public static void handleBerrfectNbt(CraftingContainer inv, CallbackInfoReturnable<ItemStack> cir) {
        ItemStack result = cir.getReturnValue();
        boolean isBerrfect = false;

        List<ItemStack> ingredients = new ArrayList<>();
        for (int i = 0; i < inv.getContainerSize(); ++i) {
            ItemStack slot = inv.getItem(i);

            if (CosmoUtils.containsNbt(slot, BerrfectFlavorHelper.KEY)) {
                isBerrfect = true;
            }
        }

        if(!isBerrfect) return;

        for (int i = 0; i < inv.getContainerSize(); ++i) {
            ItemStack slot = inv.getItem(i);

            if (CosmoUtils.containsNbt(slot, BerrfectFlavorHelper.KEY) || slot.is(CosmoItemTags.BERRIES)) {
                ingredients.add(slot);
            }
        }

        BerrfectFlavorHelper.calculateFlavor(result, ingredients);
        cir.setReturnValue(result);
    }
}

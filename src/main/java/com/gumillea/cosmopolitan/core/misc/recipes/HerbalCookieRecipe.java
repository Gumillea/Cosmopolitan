package com.gumillea.cosmopolitan.core.misc.recipes;

import com.gumillea.cosmopolitan.common.item.HerbalCookieItem;
import com.gumillea.cosmopolitan.core.reg.CosmoItems;
import com.gumillea.cosmopolitan.core.reg.CosmoRecipes;
import net.minecraft.core.RegistryAccess;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.SuspiciousEffectHolder;

public class HerbalCookieRecipe extends CustomRecipe {
    public HerbalCookieRecipe(ResourceLocation rl, CraftingBookCategory category) {
        super(rl, category);
    }

    public boolean matches(CraftingContainer container, Level level) {
        boolean $$2 = false;
        boolean $$3 = false;
        boolean $$4 = false;
        boolean $$5 = false;

        for(int $$6 = 0; $$6 < container.getContainerSize(); ++$$6) {
            ItemStack $$7 = container.getItem($$6);
            if (!$$7.isEmpty()) {
                if ($$7.is(Items.WHEAT) && !$$4) {
                    $$4 = true;
                } else if ($$7.is(Items.WHEAT) && !$$3) {
                    $$3 = true;
                } else if ($$7.is(ItemTags.SMALL_FLOWERS) && !$$2) {
                    $$2 = true;
                } else {
                    if (!$$7.is(CosmoItems.BAKED_FIDDLEHEAD.get()) || $$5) {
                        return false;
                    }

                    $$5 = true;
                }
            }
        }

        return $$2 && $$4 && $$3 && $$5;
    }

    public ItemStack assemble(CraftingContainer container, RegistryAccess registryAccess) {
        ItemStack cookie = new ItemStack(CosmoItems.HERBAL_COOKIE.get(), 4);

        for(int $$3 = 0; $$3 < container.getContainerSize(); ++$$3) {
            ItemStack stack = container.getItem($$3);
            if (!stack.isEmpty()) {
                SuspiciousEffectHolder holder = SuspiciousEffectHolder.tryGet(stack.getItem());
                if (holder != null) {
                    int duration = holder.getEffectDuration() < 1 ? holder.getEffectDuration() : holder.getEffectDuration() / 2;
                    HerbalCookieItem.saveMobEffect(cookie, holder.getSuspiciousEffect(), duration);
                    break;
                }
            }
        }

        return cookie;
    }

    public boolean canCraftInDimensions(int p_44489_, int p_44490_) {
        return p_44489_ >= 2 && p_44490_ >= 2;
    }

    public RecipeSerializer<?> getSerializer() {
        return CosmoRecipes.HERBAL_COOKIE.get();
    }
}

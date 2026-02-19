package com.gumillea.cosmopolitan.core.misc.recipes;

import com.gumillea.cosmopolitan.common.item.HerbalFoodItem;
import com.gumillea.cosmopolitan.core.reg.CosmoItems;
import com.gumillea.cosmopolitan.core.reg.CosmoRecipes;
import net.minecraft.core.RegistryAccess;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
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
        boolean flower = false;
        boolean honey = false;
        boolean wheat1 = false;
        boolean wheat2 = false;
        boolean powder = false;

        for(int i = 0; i < container.getContainerSize(); ++i) {
            ItemStack item = container.getItem(i);
            if (!item.isEmpty()) {
                if (item.is(Items.WHEAT) && !wheat1) {
                    wheat1 = true;
                } else if (item.is(Items.WHEAT) && !wheat2) {
                    wheat2 = true;
                } else if (item.is(Items.HONEY_BOTTLE) && !honey) {
                    honey = true;
                } else if (item.is(ItemTags.SMALL_FLOWERS) && !flower) {
                    flower = true;
                } else {
                    if (!item.is(CosmoItems.HERBAL_POWDER.get()) || powder) {
                        return false;
                    }
                    powder = true;
                }
            }
        }

        return wheat1 && wheat2 && honey && flower && powder;
    }

    public ItemStack assemble(CraftingContainer container, RegistryAccess registryAccess) {
        ItemStack cookie = new ItemStack(CosmoItems.HERBAL_COOKIE.get(), 8);

        for(int $$3 = 0; $$3 < container.getContainerSize(); ++$$3) {
            ItemStack stack = container.getItem($$3);
            if (!stack.isEmpty()) {
                SuspiciousEffectHolder holder = SuspiciousEffectHolder.tryGet(stack.getItem());
                if (holder != null) {
                    MobEffect effect = holder.getSuspiciousEffect();
                    int duration = holder.getEffectDuration();
                    int newDuration =  effect == MobEffects.SATURATION ? 1 : (duration == 1 ? 1 : duration / 2);

                    HerbalFoodItem.saveMobEffect(cookie, effect, newDuration);
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

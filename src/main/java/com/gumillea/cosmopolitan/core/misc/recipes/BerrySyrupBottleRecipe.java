package com.gumillea.cosmopolitan.core.misc.recipes;

import com.gumillea.cosmopolitan.core.misc.BerrfectFlavorHelper;
import com.gumillea.cosmopolitan.core.reg.CosmoItems;
import com.gumillea.cosmopolitan.core.reg.CosmoRecipes;
import com.gumillea.cosmopolitan.core.util.CosmoItemTags;
import net.minecraft.core.RegistryAccess;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.Level;

import java.util.ArrayList;
import java.util.List;

public class BerrySyrupBottleRecipe extends CustomRecipe {

    public BerrySyrupBottleRecipe(ResourceLocation rl, CraftingBookCategory category) {
        super(rl, category);
    }

    public boolean matches(CraftingContainer container, Level level) {
        int berry = 0;
        int sugar = 0;
        boolean bottle = false;

        for (int i = 0; i < container.getContainerSize(); ++i) {
            ItemStack stack = container.getItem(i);
            if (!stack.isEmpty()) {
                if (stack.is(CosmoItemTags.BERRIES)) {
                    berry++;
                }
                else if (stack.is(Items.SUGAR)) {
                    sugar++;
                }
                else if (stack.is(Items.GLASS_BOTTLE) && !bottle) {
                    bottle = true;
                }
                else {
                    return false;
                }
            }
        }

        return bottle && berry == 4 && sugar == 4;
    }

    @Override
    public ItemStack assemble(CraftingContainer container, RegistryAccess registryAccess) {
        ItemStack result = new ItemStack(CosmoItems.BERRY_SYRUP_BOTTLE.get());

        List<ItemStack> ingredients = new ArrayList<>();
        for (int i = 0; i < container.getContainerSize(); ++i) {
            ItemStack stack = container.getItem(i);
            if (!stack.isEmpty() && stack.is(CosmoItemTags.BERRIES)) {
                ingredients.add(stack);
            }
        }

        BerrfectFlavorHelper.calculateFlavor(result, ingredients);

        return result;
    }

    public boolean canCraftInDimensions(int p_44489_, int p_44490_) {
        return p_44489_ >= 2 && p_44490_ >= 2;
    }

    public RecipeSerializer<?> getSerializer() {
        return CosmoRecipes.BERRY_SYRUP_BOTTLE.get();
    }
}

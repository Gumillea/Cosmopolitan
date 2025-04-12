package com.gumillea.cosmopolitan.core.misc;

import com.gumillea.cosmopolitan.core.reg.CosmoRecipes;
import com.gumillea.cosmopolitan.core.util.CosmoItemTags;
import com.teamabnormals.neapolitan.core.registry.NeapolitanItems;
import net.minecraft.core.RegistryAccess;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class IcedFoodRecipe extends CustomRecipe {
    private ItemStack food = ItemStack.EMPTY;

    public IcedFoodRecipe(ResourceLocation id, CraftingBookCategory category) {
        super(id, category);
    }

    @Override
    public boolean matches(CraftingContainer container, @NotNull Level level) {
        food = ItemStack.EMPTY;
        boolean iceCube = false;


        for (int i = 0; i < container.getContainerSize(); ++i) {
            ItemStack itemstack = container.getItem(i);
            if (itemstack.isEmpty()) {
                continue;
            }

            if (itemstack.is(CosmoItemTags.FRUITS) && itemstack.isEdible()) {
                if (!food.isEmpty()) {
                    return false;
                }
                if (itemstack.getTag() != null && itemstack.getTag().getBoolean("iced")) {
                    return false;
                }
                food = itemstack;
            } else if (itemstack.getItem() == NeapolitanItems.ICE_CUBES.get()) {
                if (iceCube) {
                    return false;
                }
                iceCube = true;
            }
        }
        return !food.isEmpty() && iceCube;
    }

    @Override
    public @NotNull ItemStack assemble(@NotNull CraftingContainer craftingContainer, @NotNull RegistryAccess registryAccess) {
        if (food.isEmpty()) {
            return ItemStack.EMPTY;
        }

        ItemStack chilledFruit = food.copy();
        chilledFruit.setCount(1);
        chilledFruit.getOrCreateTag().putBoolean("iced", true);

        return chilledFruit;
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return true;
    }

    @Override
    public @NotNull RecipeSerializer<?> getSerializer() {
        return CosmoRecipes.FOOD_CHILLING.get();
    }
}
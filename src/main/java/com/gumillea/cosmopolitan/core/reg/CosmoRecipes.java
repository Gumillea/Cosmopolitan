package com.gumillea.cosmopolitan.core.reg;

import com.gumillea.cosmopolitan.Cosmopolitan;
import com.gumillea.cosmopolitan.core.misc.IcedFoodRecipe;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SimpleCraftingRecipeSerializer;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class CosmoRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(Registries.RECIPE_SERIALIZER, Cosmopolitan.MODID);
    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPE = DeferredRegister.create(Registries.RECIPE_TYPE, Cosmopolitan.MODID);

    public static final RegistryObject<RecipeSerializer<?>> FOOD_CHILLING = RECIPE_SERIALIZERS.register("food_chilling", () -> new SimpleCraftingRecipeSerializer<>(IcedFoodRecipe::new));
}

package com.gumillea.cosmopolitan.core.reg;

import com.gumillea.cosmopolitan.Cosmopolitan;
import com.gumillea.cosmopolitan.core.misc.IcedFoodRecipe;
import com.gumillea.cosmopolitan.core.misc.TubExtractRecipe;
import com.gumillea.cosmopolitan.core.misc.TubInjectRecipe;
import com.gumillea.cosmopolitan.core.misc.TubInteractingRecipe;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SimpleCraftingRecipeSerializer;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class CosmoRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(Registries.RECIPE_SERIALIZER, Cosmopolitan.MODID);
    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPE = DeferredRegister.create(Registries.RECIPE_TYPE, Cosmopolitan.MODID);

    public static final RegistryObject<RecipeSerializer<?>> FOOD_CHILLING = RECIPE_SERIALIZERS.register("food_chilling", () -> new SimpleCraftingRecipeSerializer<>(IcedFoodRecipe::new));

    public static final RegistryObject<RecipeSerializer<TubInjectRecipe>> TUB_INJECT_SERIALIZER = RECIPE_SERIALIZERS.register("tub_injecting", TubInjectRecipe.Serializer::new);
    public static final RegistryObject<RecipeType<TubInjectRecipe>> TUB_INJECT_TYPE = RECIPE_TYPE.register("tub_injecting", () -> RecipeType.simple(new ResourceLocation(Cosmopolitan.MODID, "tub_injecting")));

    public static final RegistryObject<RecipeSerializer<TubInteractingRecipe>> TUB_INTERACTING_SERIALIZER = RECIPE_SERIALIZERS.register("tub_interacting", TubInteractingRecipe.Serializer::new);
    public static final RegistryObject<RecipeType<TubInteractingRecipe>> TUB_INTERACTING_TYPE = RECIPE_TYPE.register("tub_interacting", () -> RecipeType.simple(new ResourceLocation(Cosmopolitan.MODID, "tub_interacting")));

    public static final RegistryObject<RecipeSerializer<TubExtractRecipe>> TUB_EXTRACT_SERIALIZER = RECIPE_SERIALIZERS.register("tub_extracting", TubExtractRecipe.Serializer::new);
    public static final RegistryObject<RecipeType<TubExtractRecipe>> TUB_EXTRACT_TYPE = RECIPE_TYPE.register("tub_extracting", () -> RecipeType.simple(new ResourceLocation(Cosmopolitan.MODID, "tub_extracting")));
}

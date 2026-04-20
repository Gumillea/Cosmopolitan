package com.gumillea.cosmopolitan.core.reg;

import com.gumillea.cosmopolitan.Cosmopolitan;
import com.gumillea.cosmopolitan.core.misc.recipes.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SimpleCraftingRecipeSerializer;
import net.minecraft.world.item.crafting.SuspiciousStewRecipe;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.common.crafting.CookingPotRecipe;

public class CosmoRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(Registries.RECIPE_SERIALIZER, Cosmopolitan.MODID);
    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPE = DeferredRegister.create(Registries.RECIPE_TYPE, Cosmopolitan.MODID);

    public static final RegistryObject<RecipeSerializer<?>> HERBAL_COOKIE = RECIPE_SERIALIZERS.register("herbal_cookie", () -> new SimpleCraftingRecipeSerializer<>(HerbalCookieRecipe::new));
    public static final RegistryObject<RecipeSerializer<?>> BERRY_SYRUP_BOTTLE = RECIPE_SERIALIZERS.register("berry_syrup_bottle", () -> new SimpleCraftingRecipeSerializer<>(BerrySyrupBottleRecipe::new));
    //public static final RegistryObject<RecipeSerializer<?>> JELLY_BEANS = RECIPE_SERIALIZERS.register("jean_beans", () -> new SimpleCraftingRecipeSerializer<>(JellyBeansRecipe::new));

    public static final RegistryObject<RecipeSerializer<TubInjectRecipe>> TUB_INJECT_SERIALIZER = RECIPE_SERIALIZERS.register("tub_injecting", TubInjectRecipe.Serializer::new);
    public static final RegistryObject<RecipeType<TubInjectRecipe>> TUB_INJECT_TYPE = RECIPE_TYPE.register("tub_injecting", () -> RecipeType.simple(new ResourceLocation(Cosmopolitan.MODID, "tub_injecting")));

    public static final RegistryObject<RecipeSerializer<TubInteractingRecipe>> TUB_INTERACTING_SERIALIZER = RECIPE_SERIALIZERS.register("tub_interacting", TubInteractingRecipe.Serializer::new);
    public static final RegistryObject<RecipeType<TubInteractingRecipe>> TUB_INTERACTING_TYPE = RECIPE_TYPE.register("tub_interacting", () -> RecipeType.simple(new ResourceLocation(Cosmopolitan.MODID, "tub_interacting")));

    public static final RegistryObject<RecipeSerializer<TubExtractRecipe>> TUB_EXTRACT_SERIALIZER = RECIPE_SERIALIZERS.register("tub_extracting", TubExtractRecipe.Serializer::new);
    public static final RegistryObject<RecipeType<TubExtractRecipe>> TUB_EXTRACT_TYPE = RECIPE_TYPE.register("tub_extracting", () -> RecipeType.simple(new ResourceLocation(Cosmopolitan.MODID, "tub_extracting")));
}

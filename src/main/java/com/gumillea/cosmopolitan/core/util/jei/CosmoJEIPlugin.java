package com.gumillea.cosmopolitan.core.util.jei;

import com.gumillea.cosmopolitan.Cosmopolitan;
import com.gumillea.cosmopolitan.core.reg.CosmoBlocks;
import com.gumillea.cosmopolitan.core.reg.CosmoItems;
import com.gumillea.cosmopolitan.core.reg.CosmoRecipes;
import com.gumillea.cosmopolitan.core.util.CosmoCompat;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.RecipeTypes;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CraftingRecipe;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraftforge.registries.ForgeRegistries;
import vectorwing.farmersdelight.integration.jei.FDRecipeTypes;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

@JeiPlugin
@ParametersAreNonnullByDefault
public class CosmoJEIPlugin implements IModPlugin {
    public static final ResourceLocation ID = new ResourceLocation(Cosmopolitan.MODID, "jei_plugin");

    private static final List<Supplier<Item>> INFO_ITEMS = List.of(
            CosmoItems.FIDDLEHEAD, CosmoItems.WILDBERRY, CosmoItems.WHEATGRASS
    );

    @Override
    public ResourceLocation getPluginUid() {
        return ID;
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        IGuiHelper guiHelper = registration.getJeiHelpers().getGuiHelper();
        registration.addRecipeCategories(new TubExtractCategory(guiHelper), new TubInjectCategory(guiHelper));
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        ItemStack copperTub = new ItemStack(CosmoBlocks.COPPER_FROZEN_DESSERT_TUB.get());
        ItemStack ironTub = new ItemStack(CosmoBlocks.IRON_FROZEN_DESSERT_TUB.get());

        registration.addRecipeCatalyst(copperTub, TubExtractCategory.TYPE, TubInjectCategory.TYPE);
        registration.addRecipeCatalyst(ironTub, TubExtractCategory.TYPE, TubInjectCategory.TYPE);
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager manager = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();

        registration.addRecipes(TubExtractCategory.TYPE, manager.getAllRecipesFor(CosmoRecipes.TUB_EXTRACT_TYPE.get()));
        registration.addRecipes(TubInjectCategory.TYPE, manager.getAllRecipesFor(CosmoRecipes.TUB_INJECT_TYPE.get()));

        registration.addRecipes(RecipeTypes.CRAFTING, HerbalCookieRecipeMaker.createRecipes());
        if (CosmoCompat.fd) registration.addRecipes(FDRecipeTypes.COOKING, TisaneRecipeMaker.createRecipes());

        for (Supplier<Item> itemSupplier : INFO_ITEMS) {
            Item item = itemSupplier.get();
            ResourceLocation key = Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(item));
            String translationKey = "jei." + Cosmopolitan.MODID + "." + key.getPath() + ".desc";

            registration.addIngredientInfo(new ItemStack(item), VanillaTypes.ITEM_STACK, Component.translatable(translationKey));
        }

        registration.addIngredientInfo(
                List.of(
                        new ItemStack(CosmoItems.GULIME.get()),
                        new ItemStack(CosmoItems.UNDERGROUND_GULIME.get()),
                        new ItemStack(CosmoItems.ARID_GULIME.get()),
                        new ItemStack(CosmoItems.TAIGA_GULIME.get()),
                        new ItemStack(CosmoItems.CHORUS_GULIME.get()),
                        new ItemStack(CosmoItems.WARPED_GULIME.get()),
                        new ItemStack(CosmoItems.GULIME_SMALL.get()),
                        new ItemStack(CosmoItems.UNDERGROUND_GULIME_SMALL.get()),
                        new ItemStack(CosmoItems.TAIGA_GULIME_SMALL.get()),
                        new ItemStack(CosmoItems.ARID_GULIME_SMALL.get()),
                        new ItemStack(CosmoItems.CHORUS_GULIME_SMALL.get()),
                        new ItemStack(CosmoItems.WARPED_GULIME_SMALL.get())
                ),
                VanillaTypes.ITEM_STACK,
                Component.translatable("jei." + Cosmopolitan.MODID + ".gulime.desc")
        );

        registration.addIngredientInfo(
                List.of(
                        new ItemStack(CosmoItems.CONDENSED_MILK_BUCKET.get()),
                        new ItemStack(CosmoItems.CONDENSED_MILK_BOTTLE.get())
                ),
                VanillaTypes.ITEM_STACK,
                Component.translatable("jei." + Cosmopolitan.MODID + ".condensed_milk_bucket.desc")
        );

        registration.addIngredientInfo(
                List.of(
                        new ItemStack(CosmoItems.CREAM_BUCKET.get()),
                        new ItemStack(CosmoItems.CREAM.get())
                ),
                VanillaTypes.ITEM_STACK,
                Component.translatable("jei." + Cosmopolitan.MODID + ".cream_bucket.desc")
        );

        registration.addIngredientInfo(
                List.of(
                        new ItemStack(CosmoBlocks.COPPER_FROZEN_DESSERT_TUB.get()),
                        new ItemStack(CosmoBlocks.IRON_FROZEN_DESSERT_TUB.get())
                ),
                VanillaTypes.ITEM_STACK,
                Component.translatable("jei." + Cosmopolitan.MODID + ".frozen_dessert_tub.desc")
        );

        registration.addIngredientInfo(
                List.of(
                        new ItemStack(CosmoItems.BERRY_DOUBLE_POPSICLE.get()),
                        new ItemStack(CosmoItems.CHORUS_FRUIT_DOUBLE_POPSICLE.get()),
                        new ItemStack(CosmoItems.LIME_DOUBLE_POPSICLE.get()),
                        new ItemStack(CosmoItems.BLISTERBERRY_DOUBLE_POPSICLE.get())
                ),
                VanillaTypes.ITEM_STACK,
                Component.translatable("jei." + Cosmopolitan.MODID + ".blisterberry_popsicle_double.desc")
        );

        registration.addIngredientInfo(
                List.of(
                        new ItemStack(CosmoItems.WANDERING_GELATO.get()),
                        new ItemStack(CosmoItems.TRAVELERS_PANINI.get()),
                        new ItemStack(CosmoItems.LLAMA_MARSHMALLOW_TRADER.get())
                ),
                VanillaTypes.ITEM_STACK,
                Component.translatable("jei." + Cosmopolitan.MODID + ".wandering_gelato.desc")
        );
    }
}
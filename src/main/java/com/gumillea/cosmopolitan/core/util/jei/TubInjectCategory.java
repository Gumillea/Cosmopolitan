package com.gumillea.cosmopolitan.core.util.jei;

import com.gumillea.cosmopolitan.Cosmopolitan;
import com.gumillea.cosmopolitan.core.misc.recipes.TubInjectRecipe;
import com.gumillea.cosmopolitan.core.reg.CosmoBlocks;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.forge.ForgeTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public class TubInjectCategory implements IRecipeCategory<TubInjectRecipe> {
    public static final RecipeType<TubInjectRecipe> TYPE = RecipeType.create(Cosmopolitan.MODID, "tub_inject", TubInjectRecipe.class);
    private final IDrawable background;
    private final IDrawable icon;

    public TubInjectCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(new ResourceLocation(Cosmopolitan.MODID, "textures/gui/jei/inject.png"), 0, 0, 120, 45);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(CosmoBlocks.COPPER_FROZEN_DESSERT_TUB.get()));
    }

    @Override
    public RecipeType<TubInjectRecipe> getRecipeType() {
        return TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("jei." + Cosmopolitan.MODID + ".category.tub_inject");
    }

    @Override
    public @Nullable IDrawable getIcon() {
        return icon;
    }

    @Override
    public int getWidth() {
        return 120;
    }

    @Override
    public int getHeight() {
        return 45;
    }

    @Override
    public void draw(TubInjectRecipe recipe, IRecipeSlotsView slotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
        background.draw(guiGraphics, 0, 0);
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, TubInjectRecipe recipe, IFocusGroup group) {
        builder.addSlot(RecipeIngredientRole.INPUT, 12, 15)
                .addIngredients(recipe.getIngredient());

        builder.addSlot(RecipeIngredientRole.OUTPUT, 72, 15)
                .addIngredient(ForgeTypes.FLUID_STACK, recipe.getFluid())
                .setFluidRenderer(recipe.getFluid().getAmount(), false, 16, 16);

        if (!recipe.getResultItem(RegistryAccess.EMPTY).isEmpty()) {
            builder.addSlot(RecipeIngredientRole.OUTPUT, 96, 15)
                    .addItemStack(recipe.getResultItem(RegistryAccess.EMPTY));
        }
    }
}
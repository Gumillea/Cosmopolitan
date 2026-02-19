package com.gumillea.cosmopolitan.core.util.jei;

import com.gumillea.cosmopolitan.Cosmopolitan;
import com.gumillea.cosmopolitan.core.misc.recipes.TubExtractRecipe;
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

public class TubExtractCategory implements IRecipeCategory<TubExtractRecipe> {
    public static final RecipeType<TubExtractRecipe> TYPE = RecipeType.create(Cosmopolitan.MODID, "tub_extract", TubExtractRecipe.class);
    private static final ResourceLocation TEXTURE = new ResourceLocation(Cosmopolitan.MODID, "textures/gui/jei/extract.png");
    private final IDrawable background;
    private final IDrawable backgroundCooling;
    private final IDrawable icon;

    public TubExtractCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 120, 45);
        this.backgroundCooling = helper.createDrawable(TEXTURE, 0, 45, 120, 45);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(CosmoBlocks.IRON_FROZEN_DESSERT_TUB.get()));
    }

    @Override
    public RecipeType<TubExtractRecipe> getRecipeType() {
        return TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("jei." + Cosmopolitan.MODID + ".category.tub_extract");
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
    public void draw(TubExtractRecipe recipe, IRecipeSlotsView slotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
        if (recipe.requiresCooling()) {
            backgroundCooling.draw(guiGraphics, 0, 0);
        } else {
            background.draw(guiGraphics, 0, 0);
        }
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, TubExtractRecipe recipe, IFocusGroup group) {
        builder.addSlot(RecipeIngredientRole.INPUT, 12, 15)
                .addIngredient(ForgeTypes.FLUID_STACK, recipe.getFluid())
                .setFluidRenderer(recipe.getFluid().getAmount(), false, 16, 16);

        builder.addSlot(RecipeIngredientRole.INPUT, 36, 15)
                .addIngredients(recipe.getIngredient());

        builder.addSlot(RecipeIngredientRole.OUTPUT, 96, 15)
                .addItemStack(recipe.getResultItem(RegistryAccess.EMPTY));
    }
}
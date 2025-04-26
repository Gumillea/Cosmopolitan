package com.gumillea.cosmopolitan.core.misc;

import com.gumillea.cosmopolitan.Cosmopolitan;
import com.gumillea.cosmopolitan.common.blockEntity.FrozenDessertTubBlockEntity;
import com.gumillea.cosmopolitan.core.reg.CosmoRecipes;
import com.google.gson.JsonObject;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.Container;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.core.RegistryAccess;

import javax.annotation.Nullable;
import java.util.Objects;

public class TubInjectRecipe implements net.minecraft.world.item.crafting.Recipe<Container> {
    private final Ingredient ingredient;
    private final ItemStack resultItem;
    private final FluidStack fluid;

    public TubInjectRecipe(Ingredient ingredient, ItemStack result, FluidStack fluid) {
        this.ingredient = ingredient;
        this.resultItem = result;
        this.fluid = fluid;
    }
    public Ingredient getIngredient() {
        return ingredient;
    }
    public FluidStack getFluid() {
        return fluid;
    }

    @Override
    public boolean matches(Container inv, Level world) {
        return inv.getItem(0).getItem() == this.ingredient.getItems()[0].getItem();
    }

    @Override
    public ItemStack assemble(Container inv, RegistryAccess registryAccess) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean canCraftInDimensions(int w, int h) {
        return false;
    }

    @Override
    public ItemStack getResultItem(RegistryAccess registryAccess) {
        return resultItem;
    }

    @Override
    public ResourceLocation getId() {
        return new ResourceLocation(Cosmopolitan.MODID, "tub_injecting");
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return CosmoRecipes.TUB_INJECT_SERIALIZER.get();
    }

    @Override
    public RecipeType<?> getType() {
        return CosmoRecipes.TUB_INJECT_TYPE.get();
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public net.minecraft.core.NonNullList<Ingredient> getIngredients() {
        net.minecraft.core.NonNullList<Ingredient> list = net.minecraft.core.NonNullList.create();
        list.add(ingredient);
        return list;
    }

    @Nullable
    public static ItemStack tryApply(Level level, FrozenDessertTubBlockEntity tub, ItemStack heldItem, Player player, InteractionHand hand) {
        var recipes = level.getRecipeManager().getAllRecipesFor(CosmoRecipes.TUB_INJECT_TYPE.get());
        for (TubInjectRecipe recipe : recipes) {
            if (recipe.getIngredient().test(heldItem)) {
                if (tub.getFluidHandler().fill(recipe.getFluid(), IFluidHandler.FluidAction.SIMULATE) >= recipe.getFluid().getAmount()) {
                    tub.getFluidHandler().fill(recipe.getFluid(), IFluidHandler.FluidAction.EXECUTE);
                    ItemStack result = recipe.getResultItem(level.registryAccess()).copy();
                    if (!player.isCreative()) {
                        heldItem.shrink(1);
                        if (!result.isEmpty()) {
                            if (!player.getInventory().add(result)) {
                                player.drop(result, false);
                            }
                        }
                    }
                    return heldItem.isEmpty() ? ItemStack.EMPTY : heldItem;
                }
            }
        }
        return ItemStack.EMPTY;
    }

    public static class Serializer implements RecipeSerializer<TubInjectRecipe> {
        @Override
        public TubInjectRecipe fromJson(ResourceLocation location, JsonObject json) {
            Ingredient ingredient1 = Ingredient.fromJson(GsonHelper.getAsJsonObject(json, "ingredient"));
            JsonObject result1 = GsonHelper.getAsJsonObject(json, "result");
            ItemStack result = new ItemStack(
                    Objects.requireNonNull(ForgeRegistries.ITEMS.getValue(
                            new ResourceLocation(GsonHelper.getAsString(result1, "item"))
                    )),
                    GsonHelper.getAsInt(result1, "count", 1)
            );
            JsonObject fluid1 = GsonHelper.getAsJsonObject(json, "fluid");
            FluidStack stack = new FluidStack(
                    Objects.requireNonNull(ForgeRegistries.FLUIDS.getValue(
                            new ResourceLocation(GsonHelper.getAsString(fluid1, "name"))
                    )),
                    GsonHelper.getAsInt(fluid1, "amount")
            );
            return new TubInjectRecipe(ingredient1, result, stack);
        }

        @Override
        @Nullable
        public TubInjectRecipe fromNetwork(ResourceLocation location, FriendlyByteBuf byteBuf) {
            Ingredient ing = Ingredient.fromNetwork(byteBuf);
            ItemStack result = byteBuf.readItem();
            FluidStack fs = FluidStack.readFromPacket(byteBuf);
            return new TubInjectRecipe(ing, result, fs);
        }

        @Override
        public void toNetwork(FriendlyByteBuf byteBuf, TubInjectRecipe recipe) {
            recipe.ingredient.toNetwork(byteBuf);
            byteBuf.writeItem(recipe.resultItem);
            recipe.fluid.writeToPacket(byteBuf);
        }
    }
}

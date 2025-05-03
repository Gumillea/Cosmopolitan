package com.gumillea.cosmopolitan.core.misc;

import com.google.gson.JsonElement;
import com.gumillea.cosmopolitan.common.blockEntity.FrozenDessertTubBlockEntity;
import com.gumillea.cosmopolitan.core.reg.CosmoRecipes;
import com.google.gson.JsonObject;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.Container;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
import java.util.Objects;

public class TubExtractRecipe implements Recipe<Container> {
    private final ResourceLocation location;
    private final Ingredient ingredient;
    private final ItemStack resultItem;
    private final FluidStack fluid;

    public TubExtractRecipe(ResourceLocation location, Ingredient ingredient, ItemStack result, FluidStack fluid) {
        this.location = location;
        this.ingredient = ingredient;
        this.resultItem = result;
        this.fluid = fluid;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public ItemStack getResultItem() {
        return resultItem.copy();
    }

    public FluidStack getFluid() {
        return fluid;
    }

    @Override
    public boolean matches(Container inv, Level world) {
        return true;
    }

    @Override
    public ItemStack assemble(Container inv, RegistryAccess registryAccess) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return false;
    }

    @Override
    public ItemStack getResultItem(RegistryAccess registryAccess) {
        return resultItem;
    }

    @Override
    public ResourceLocation getId() {
        return this.location;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return CosmoRecipes.TUB_EXTRACT_SERIALIZER.get();
    }

    @Override
    public RecipeType<?> getType() {
        return CosmoRecipes.TUB_EXTRACT_TYPE.get();
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> list = NonNullList.create();
        list.add(ingredient);
        return list;
    }

    @Nullable
    public static ItemStack tryApply(Level level, FrozenDessertTubBlockEntity tub, ItemStack heldItem, Player player, InteractionHand hand) {
        var recipes = level.getRecipeManager().getAllRecipesFor(CosmoRecipes.TUB_EXTRACT_TYPE.get());
        for (TubExtractRecipe recipe : recipes) {
            if (recipe.getIngredient().test(heldItem)) {
                if (tub.getFluidHandler().drain(recipe.getFluid(), IFluidHandler.FluidAction.SIMULATE).getAmount() >= recipe.getFluid().getAmount()) {
                    tub.getFluidHandler().drain(recipe.getFluid(), IFluidHandler.FluidAction.EXECUTE);
                    ItemStack result = recipe.getResultItem(level.registryAccess()).copy();
                    if (!player.isCreative()) {
                        heldItem.shrink(1);
                        if (heldItem.isEmpty()) {
                            player.setItemInHand(hand, result);
                        } else if (!player.addItem(result)) {
                            player.drop(result, false);
                        }
                        return player.getItemInHand(hand);
                    }

                    if (!player.addItem(result)) {
                        player.drop(result, false);
                    }

                    return heldItem;
                }
            }
        }
        return ItemStack.EMPTY;
    }

    public static class Serializer implements RecipeSerializer<TubExtractRecipe> {
        @Override
        public TubExtractRecipe fromJson(ResourceLocation location, JsonObject json) {
            JsonElement ingElem = json.get("ingredient");
            Ingredient ingredient = Ingredient.EMPTY;
            FluidStack fluidStack = FluidStack.EMPTY;

            if (ingElem.isJsonArray()) {
                for (JsonElement el : ingElem.getAsJsonArray()) {
                    JsonObject obj = el.getAsJsonObject();
                    if (obj.has("fluid")) {
                        JsonObject f = obj.getAsJsonObject("fluid");
                        ResourceLocation id = ResourceLocation.tryParse(GsonHelper.getAsString(f, "name"));
                        int amt = GsonHelper.getAsInt(f, "amount", 0);
                        fluidStack = new FluidStack(
                                Objects.requireNonNull(ForgeRegistries.FLUIDS.getValue(id)), amt
                        );
                    } else {
                        ingredient = Ingredient.fromJson(obj);
                    }
                }
            } else {
                JsonObject obj = ingElem.getAsJsonObject();
                if (obj.has("fluid")) {
                    JsonObject f = obj.getAsJsonObject("fluid");
                    ResourceLocation id = ResourceLocation.tryParse(GsonHelper.getAsString(f, "name"));
                    int amt = GsonHelper.getAsInt(f, "amount", 0);
                    fluidStack = new FluidStack(
                            Objects.requireNonNull(ForgeRegistries.FLUIDS.getValue(id)), amt
                    );
                } else {
                    ingredient = Ingredient.fromJson(obj);
                }
            }

            JsonObject resultObj = GsonHelper.getAsJsonObject(json, "result");
            ItemStack result = new ItemStack(
                    Objects.requireNonNull(ForgeRegistries.ITEMS.getValue(ResourceLocation.tryParse(GsonHelper.getAsString(resultObj, "item")))),
                    GsonHelper.getAsInt(resultObj, "count", 1)
            );

            return new TubExtractRecipe(location, ingredient, result, fluidStack);
        }


        @Override
        @Nullable
        public TubExtractRecipe fromNetwork(ResourceLocation location, FriendlyByteBuf byteBuf) {
            Ingredient ingredient1 = Ingredient.fromNetwork(byteBuf);
            ItemStack result = byteBuf.readItem();
            FluidStack stack = FluidStack.readFromPacket(byteBuf);
            return new TubExtractRecipe(location, ingredient1, result, stack);
        }

        @Override
        public void toNetwork(FriendlyByteBuf byteBuf, TubExtractRecipe recipe) {
            recipe.ingredient.toNetwork(byteBuf);
            byteBuf.writeItem(recipe.resultItem);
            recipe.fluid.writeToPacket(byteBuf);
        }
    }
}


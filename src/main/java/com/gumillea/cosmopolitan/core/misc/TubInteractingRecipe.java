package com.gumillea.cosmopolitan.core.misc;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.gumillea.cosmopolitan.Cosmopolitan;
import com.gumillea.cosmopolitan.common.blockEntity.FrozenDessertTubBlockEntity;
import com.gumillea.cosmopolitan.core.reg.CosmoRecipes;
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
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
import java.util.Objects;

public class TubInteractingRecipe implements Recipe<Container> {
    private final Ingredient ingredient;
    private final ItemStack resultItem;
    private final FluidStack fluid;

    public TubInteractingRecipe(Ingredient ingredient, ItemStack result, FluidStack fluid) {
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
        return new ResourceLocation(Cosmopolitan.MODID, "tub_interacting");
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return CosmoRecipes.TUB_INTERACTING_SERIALIZER.get();
    }

    @Override
    public RecipeType<?> getType() {
        return CosmoRecipes.TUB_INTERACTING_TYPE.get();
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
    public static ItemStack tryApply(Level level, FrozenDessertTubBlockEntity tub, ItemStack inHand, Player player, InteractionHand hand) {
        var recipes = level.getRecipeManager().getAllRecipesFor(CosmoRecipes.TUB_INTERACTING_TYPE.get());
        for (TubInteractingRecipe recipe : recipes) {
            if (recipe.getIngredient().test(inHand)) {
                FluidStack newFluid = new FluidStack(recipe.getFluid().getFluid(), tub.getTank().getFluidAmount());
                tub.getTank().setFluid(newFluid);

                if (!player.isCreative()) {
                    inHand.shrink(1);
                    ItemStack result = recipe.getResultItem();
                    if (!result.isEmpty()) {
                        if (inHand.isEmpty()) {
                            player.setItemInHand(hand, result);
                        } else if (!player.addItem(result)) {
                            player.drop(result, false);
                        }
                    }
                }
                return inHand.isEmpty() ? ItemStack.EMPTY : inHand;
            }
        }
        return ItemStack.EMPTY;
    }

    public static class Serializer implements RecipeSerializer<TubInteractingRecipe> {
        @Override
        public TubInteractingRecipe fromJson(ResourceLocation location, JsonObject json) {
            JsonElement element = json.get("ingredient");
            Ingredient ingredient = Ingredient.EMPTY;
            if (element.isJsonArray()) {
                ingredient = Ingredient.fromJson(element.getAsJsonArray());
            } else if (element.isJsonObject()) {
                ingredient = Ingredient.fromJson(element.getAsJsonObject());
            }

            JsonArray array = GsonHelper.getAsJsonArray(json, "result");
            ItemStack result = ItemStack.EMPTY;
            FluidStack fluidStack = FluidStack.EMPTY;

            for (JsonElement resultElement : array) {
                JsonObject resultObj = resultElement.getAsJsonObject();
                if (resultObj.has("item")) {
                    ResourceLocation itemId = new ResourceLocation(GsonHelper.getAsString(resultObj, "item"));
                    int itemCount = GsonHelper.getAsInt(resultObj, "count", 1);
                    result = new ItemStack(Objects.requireNonNull(ForgeRegistries.ITEMS.getValue(itemId)), itemCount);
                }
                else if (resultObj.has("fluid")) {
                    ResourceLocation fluidId = new ResourceLocation(GsonHelper.getAsString(resultObj, "fluid"));
                    int fluidAmount = GsonHelper.getAsInt(resultObj, "amount", 1000);
                    fluidStack = new FluidStack(Objects.requireNonNull(ForgeRegistries.FLUIDS.getValue(fluidId)), fluidAmount);
                }
            }

            return new TubInteractingRecipe(ingredient, result, fluidStack);
        }

        @Override
        public @Nullable TubInteractingRecipe fromNetwork(ResourceLocation location, FriendlyByteBuf byteBuf) {
            Ingredient ingredient = Ingredient.fromNetwork(byteBuf);
            ItemStack itemResult = byteBuf.readItem();
            FluidStack fluidResult = FluidStack.readFromPacket(byteBuf);
            return new TubInteractingRecipe(ingredient, itemResult, fluidResult);
        }

        @Override
        public void toNetwork(FriendlyByteBuf byteBuf, TubInteractingRecipe recipe) {
            recipe.ingredient.toNetwork(byteBuf);
            byteBuf.writeItem(recipe.resultItem);
            recipe.fluid.writeToPacket(byteBuf);
        }
    }
}

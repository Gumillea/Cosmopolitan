package com.gumillea.cosmopolitan.core.misc;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.gumillea.cosmopolitan.common.blockEntity.FrozenDessertTubBlockEntity;
import com.gumillea.cosmopolitan.core.reg.CosmoRecipes;
import com.google.gson.JsonObject;
import net.minecraft.nbt.CompoundTag;
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
    private final ResourceLocation location;
    private final Ingredient ingredient;
    private final ItemStack resultItem;
    private final FluidStack fluid;

    public TubInjectRecipe(ResourceLocation location, Ingredient ingredient, ItemStack result, FluidStack fluid) {
        this.location = location;
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

    public ItemStack getResultItem(RegistryAccess registryAccess) {
        return resultItem;
    }

    @Override
    public boolean matches(Container inv, Level world) {
        return false;
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
    public ResourceLocation getId() {
        return this.location;
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
    public static ItemStack tryApply(Level level, FrozenDessertTubBlockEntity tub, ItemStack inHand, Player player, InteractionHand hand) {
        var recipes = level.getRecipeManager().getAllRecipesFor(CosmoRecipes.TUB_INJECT_TYPE.get());

        for (TubInjectRecipe recipe : recipes) {
            if (recipe.getIngredient().test(inHand)) {
                FluidStack newFluid = recipe.getFluid().copy();
                if (inHand.hasTag() && inHand.getTag().getBoolean("has_cream")) {
                    CompoundTag tag = newFluid.getOrCreateTag();
                    tag.putBoolean("has_cream", true);
                }

                FluidStack currentFluid = tub.getTank().getFluid();
                if (currentFluid.isEmpty() || isSameNBT(currentFluid, newFluid)) {
                    if (tub.getFluidHandler().fill(newFluid, IFluidHandler.FluidAction.SIMULATE) >= newFluid.getAmount()) {
                        tub.getFluidHandler().fill(newFluid, IFluidHandler.FluidAction.EXECUTE);

                        ItemStack result = recipe.getResultItem(level.registryAccess()).copy();
                        if (!player.isCreative()) {
                            inHand.shrink(1);
                            if (inHand.isEmpty()) {
                                player.setItemInHand(hand, result);
                                return result;
                            } else {
                                if (!player.addItem(result)) {
                                    player.drop(result, false);
                                }
                                return inHand;
                            }
                        }
                        return inHand.isEmpty() ? ItemStack.EMPTY : inHand;
                    }
                } else {
                    return ItemStack.EMPTY;
                }
            }
        }
        return ItemStack.EMPTY;
    }
    private static boolean isSameNBT(FluidStack currentFluid, FluidStack newFluid) {
        if (!newFluid.getFluid().isSame(newFluid.getFluid())) return false;
        CompoundTag tag = currentFluid.getTag();
        CompoundTag tag1 = newFluid.getTag();
        if (tag == null && tag1 == null) return true;
        if (tag == null || tag1 == null) return false;
        return tag.equals(tag1);
    }

    public static class Serializer implements RecipeSerializer<TubInjectRecipe> {
        @Override
        public TubInjectRecipe fromJson(ResourceLocation location, JsonObject json) {
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
                    ResourceLocation itemId = ResourceLocation.tryParse(GsonHelper.getAsString(resultObj, "item"));
                    int itemCount = GsonHelper.getAsInt(resultObj, "count", 1);
                    result = new ItemStack(Objects.requireNonNull(ForgeRegistries.ITEMS.getValue(itemId)), itemCount);
                }
                else if (resultObj.has("fluid")) {
                    ResourceLocation fluidId = ResourceLocation.tryParse(GsonHelper.getAsString(resultObj, "fluid"));
                    int fluidAmount = GsonHelper.getAsInt(resultObj, "amount", 1000);
                    fluidStack = new FluidStack(Objects.requireNonNull(ForgeRegistries.FLUIDS.getValue(fluidId)), fluidAmount);
                }
            }
            return new TubInjectRecipe(location, ingredient, result, fluidStack);
        }

        @Override
        public @Nullable TubInjectRecipe fromNetwork(ResourceLocation location, FriendlyByteBuf byteBuf) {
            Ingredient ingredient = Ingredient.fromNetwork(byteBuf);
            ItemStack itemResult = byteBuf.readItem();
            FluidStack fluidResult = FluidStack.readFromPacket(byteBuf);
            return new TubInjectRecipe(location, ingredient, itemResult, fluidResult);
        }

        @Override
        public void toNetwork(FriendlyByteBuf byteBuf, TubInjectRecipe recipe) {
            recipe.ingredient.toNetwork(byteBuf);
            byteBuf.writeItem(recipe.resultItem);
            recipe.fluid.writeToPacket(byteBuf);
        }
    }
}

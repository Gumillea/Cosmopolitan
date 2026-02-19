package com.gumillea.cosmopolitan.core.misc.recipes;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.gumillea.cosmopolitan.common.blockEntity.FrozenDessertTubBlockEntity;
import com.gumillea.cosmopolitan.core.reg.CosmoRecipes;
import com.gumillea.cosmopolitan.core.util.CosmoBlockTags;
import com.gumillea.cosmopolitan.core.util.CosmoItemTags;
import net.minecraft.core.BlockPos;
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
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TubExtractRecipe implements Recipe<Container> {
    private final ResourceLocation location;
    private final Ingredient ingredient;
    private final ItemStack resultItem;
    private final FluidStack fluid;
    private final boolean requiresCooling;

    public TubExtractRecipe(ResourceLocation location, Ingredient ingredient, ItemStack result, FluidStack fluid, boolean requiresCooling) {
        this.location = location;
        this.ingredient = ingredient;
        this.resultItem = result;
        this.fluid = fluid;
        this.requiresCooling = requiresCooling;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public FluidStack getFluid() {
        return fluid;
    }

    public boolean requiresCooling() {
        return requiresCooling;
    }


    @Nullable
    public static ItemStack tryApply(Level level, FrozenDessertTubBlockEntity tub, ItemStack heldItem, Player player, InteractionHand hand) {
        List<TubExtractRecipe> recipes = new ArrayList<>(level.getRecipeManager().getAllRecipesFor(CosmoRecipes.TUB_EXTRACT_TYPE.get()));

        recipes.sort((a, b) -> Boolean.compare(b.requiresCooling(), a.requiresCooling()));

        BlockPos pos = tub.getBlockPos();
        boolean isCooled = hasCoolingSource(level, pos);

        for (TubExtractRecipe recipe : recipes) {
            if (recipe.requiresCooling() && !isCooled) continue;
            if (!recipe.getIngredient().test(heldItem)) continue;

            FluidStack recipeFluid = recipe.getFluid();
            FluidStack inTank = tub.getTank().getFluid();

            if (inTank.getFluid().isSame(recipeFluid.getFluid()) && inTank.getAmount() >= recipeFluid.getAmount()) {
                tub.getFluidHandler().drain(recipeFluid.getAmount(), IFluidHandler.FluidAction.EXECUTE);
                ItemStack result = recipe.getResultItem(level.registryAccess()).copy();

                if (inTank.hasTag() && inTank.getTag().getBoolean("has_cream")) {
                    if (result.isEdible() && !result.is(CosmoItemTags.CREAM)) {
                        result.getOrCreateTag().putBoolean("has_cream", true);
                    }
                }

                if (!player.isCreative()) {
                    heldItem.shrink(1);
                    if (heldItem.isEmpty()) {
                        player.setItemInHand(hand, result);
                    } else if (!player.addItem(result)) {
                        player.drop(result, false);
                    }
                    return player.getItemInHand(hand);
                } else {
                    if (!player.addItem(result)) {
                        player.drop(result, false);
                    }
                    return heldItem;
                }
            }
        }
        return ItemStack.EMPTY;
    }

    private static boolean hasCoolingSource(Level level, BlockPos pos) {
        return BlockPos.betweenClosedStream(pos.offset(-1, -1, -1), pos.offset(1, 2, 1))
                .anyMatch(checkPos -> {
                    BlockState state = level.getBlockState(checkPos);
                    return state.is(CosmoBlockTags.COOLING_SOURCES);
                });
    }

    @Override public boolean matches(Container inv, Level world) {
        return false;
    }

    @Override public ItemStack assemble(Container inv, RegistryAccess registryAccess) {
        return ItemStack.EMPTY;
    }

    @Override public boolean canCraftInDimensions(int width, int height) {
        return false;
    }

    @Override public ItemStack getResultItem(RegistryAccess registryAccess) {
        return resultItem;
    }

    @Override public ResourceLocation getId() {
        return this.location;
    }

    @Override public RecipeSerializer<?> getSerializer() {
        return CosmoRecipes.TUB_EXTRACT_SERIALIZER.get();
    }

    @Override public RecipeType<?> getType() {
        return CosmoRecipes.TUB_EXTRACT_TYPE.get();
    }

    @Override public boolean isSpecial() {
        return true;
    }

    @Override public NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> list = NonNullList.create();
        list.add(ingredient);
        return list;
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
                        fluidStack = parseFluid(obj.getAsJsonObject("fluid"));
                    } else {
                        ingredient = Ingredient.fromJson(obj);
                    }
                }
            } else {
                JsonObject obj = ingElem.getAsJsonObject();
                if (obj.has("fluid")) {
                    fluidStack = parseFluid(obj.getAsJsonObject("fluid"));
                } else {
                    ingredient = Ingredient.fromJson(obj);
                }
            }
            JsonObject resultObj = GsonHelper.getAsJsonObject(json, "result");
            ItemStack result = new ItemStack(Objects.requireNonNull(ForgeRegistries.ITEMS.getValue(ResourceLocation.tryParse(GsonHelper.getAsString(resultObj, "item")))), GsonHelper.getAsInt(resultObj, "count", 1));

            boolean requiresCooling = GsonHelper.getAsBoolean(json, "requiresCooling", false);

            return new TubExtractRecipe(location, ingredient, result, fluidStack, requiresCooling);
        }

        private FluidStack parseFluid(JsonObject f) {
            ResourceLocation id = ResourceLocation.tryParse(GsonHelper.getAsString(f, "name"));
            int amount = GsonHelper.getAsInt(f, "amount", 0);
            return new FluidStack(Objects.requireNonNull(ForgeRegistries.FLUIDS.getValue(id)), amount);
        }

        @Override
        public TubExtractRecipe fromNetwork(ResourceLocation location, FriendlyByteBuf byteBuf) {
            Ingredient ingredient = Ingredient.fromNetwork(byteBuf);
            ItemStack result = byteBuf.readItem();
            FluidStack stack = FluidStack.readFromPacket(byteBuf);
            boolean requiresCooling = byteBuf.readBoolean();
            return new TubExtractRecipe(location, ingredient, result, stack, requiresCooling);
        }

        @Override
        public void toNetwork(FriendlyByteBuf byteBuf, TubExtractRecipe recipe) {
            recipe.ingredient.toNetwork(byteBuf);
            byteBuf.writeItem(recipe.resultItem);
            recipe.fluid.writeToPacket(byteBuf);
            byteBuf.writeBoolean(recipe.requiresCooling);
        }
    }
}
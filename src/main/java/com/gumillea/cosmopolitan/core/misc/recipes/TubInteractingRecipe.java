package com.gumillea.cosmopolitan.core.misc.recipes;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.gumillea.cosmopolitan.common.block.FrozenDessertTubBlock;
import com.gumillea.cosmopolitan.common.blockEntity.FrozenDessertTubBlockEntity;
import com.gumillea.cosmopolitan.core.reg.CosmoFluids;
import com.gumillea.cosmopolitan.core.reg.CosmoRecipes;
import com.gumillea.cosmopolitan.core.util.CosmoBlockTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.Container;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TubInteractingRecipe implements Recipe<Container> {
    private final ResourceLocation id;
    private final Ingredient itemIngredient;
    private final FluidStack fluidIngredient;
    private final FluidStack result;
    private final int baseCount;
    private final boolean requiresCooling;

    public TubInteractingRecipe(ResourceLocation id, Ingredient itemIngredient, FluidStack fluidIngredient, FluidStack result, int baseCount, boolean requiresCooling) {
        this.id = id;
        this.itemIngredient = itemIngredient;
        this.fluidIngredient = fluidIngredient;
        this.result = result;
        this.baseCount = baseCount;
        this.requiresCooling = requiresCooling;
    }

    public FluidStack getResult() {
        return result.copy();
    }

    public boolean requiresCooling() {
        return requiresCooling;
    }

    @Override
    public boolean matches(Container container, Level level) {
        return false;
    }

    @Override
    public ItemStack assemble(Container container, RegistryAccess registryAccess) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return false;
    }

    @Override
    public ItemStack getResultItem(RegistryAccess registryAccess) {
        return ItemStack.EMPTY;
    }

    @Override
    public ResourceLocation getId() {
        return id;
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
    public NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> list = NonNullList.create();
        list.add(itemIngredient);
        return list;
    }

    @Nullable
    public static FluidStack tryApply(Level level, FrozenDessertTubBlockEntity tub, BlockPos pos, BlockState state) {
        List<TubInteractingRecipe> recipes = level.getRecipeManager().getAllRecipesFor(CosmoRecipes.TUB_INTERACTING_TYPE.get());
        FluidStack currentFluid = tub.getFluidHandler().getFluidInTank(0);
        AABB area = new AABB(pos).inflate(0.5);
        List<ItemEntity> items = level.getEntitiesOfClass(ItemEntity.class, area);

        for (TubInteractingRecipe recipe : recipes) {
            if (recipe.requiresCooling() && !hasCoolingSource(level, pos)) continue;
            if (!currentFluid.getFluid().isSame(recipe.fluidIngredient.getFluid())) continue;

            int multiplier = (int) Math.ceil(currentFluid.getAmount() / 1000.0);
            int required = recipe.baseCount * multiplier;

            List<ItemEntity> entities = new ArrayList<>();
            int total = 0;
            for (ItemEntity entity : items) {
                ItemStack stack = entity.getItem();
                if (recipe.itemIngredient.test(stack)) {
                    entities.add(entity);
                    total += stack.getCount();
                    if (total >= required)
                        break;
                }
            }

            if (total >= required) {
                if (!entities.isEmpty()) {
                    ItemStack item = entities.get(0).getItem();
                    if (item.hasCraftingRemainingItem()) {
                        ItemStack remaining = new ItemStack(item.getCraftingRemainingItem().getItem(), required);
                        Block.popResource(level, pos, remaining);
                    }
                }
                int remaining = required;
                for (ItemEntity entity : entities) {
                    ItemStack stack = entity.getItem();
                    int deduct = Math.min(stack.getCount(), remaining);
                    stack.shrink(deduct);
                    remaining -= deduct;
                    if (stack.isEmpty()) {
                        entity.discard();
                    }
                    if (remaining == 0)
                        break;
                }

                FluidStack newFluid = recipe.result.copy();
                if (currentFluid.getFluid() == CosmoFluids.CREAM.get() || (currentFluid.hasTag() && currentFluid.getTag().getBoolean("has_cream"))) {
                    CompoundTag tag = newFluid.getOrCreateTag();
                    tag.putBoolean("has_cream", true);
                }

                newFluid.setAmount(currentFluid.getAmount());
                tub.getTank().setFluid(newFluid);
                level.sendBlockUpdated(pos, state, state, 3);
                FrozenDessertTubBlock.contentApply(level, pos);
                return newFluid;
            }
        }
        return null;
    }

    private static boolean hasCoolingSource(Level level, BlockPos pos) {
        return BlockPos.betweenClosedStream(pos.offset(-1, -1, -1), pos.offset(1, 2, 1))
                .anyMatch(checkPos -> {
                    BlockState state = level.getBlockState(checkPos);
                    return state.is(CosmoBlockTags.COOLING_SOURCES);
                });
    }

    public static class Serializer implements RecipeSerializer<TubInteractingRecipe> {
        @Override
        public TubInteractingRecipe fromJson(ResourceLocation id, JsonObject json) {
            JsonArray ingredients = GsonHelper.getAsJsonArray(json, "ingredient");
            Ingredient itemIngredient = Ingredient.EMPTY;
            FluidStack fluidIngredient = FluidStack.EMPTY;

            for (JsonElement element : ingredients) {
                JsonObject obj = element.getAsJsonObject();
                if (obj.has("item") || obj.has("tag")) {
                    itemIngredient = Ingredient.fromJson(obj);
                } else if (obj.has("fluid")) {
                    JsonObject fluidObj = obj.getAsJsonObject("fluid");
                    ResourceLocation fluidId = new ResourceLocation(GsonHelper.getAsString(fluidObj, "name"));
                    int amount = GsonHelper.getAsInt(fluidObj, "amount", 1);
                    fluidIngredient = new FluidStack(Objects.requireNonNull(ForgeRegistries.FLUIDS.getValue(fluidId)), amount);
                }
            }
            JsonObject resultJson = GsonHelper.getAsJsonObject(json, "result");
            FluidStack result = new FluidStack(Objects.requireNonNull(ForgeRegistries.FLUIDS.getValue(new ResourceLocation(GsonHelper.getAsString(resultJson, "fluid")))), GsonHelper.getAsInt(resultJson, "amount", 1));

            int baseCount = GsonHelper.getAsInt(json, "baseCount", 1);
            boolean requiresCooling = GsonHelper.getAsBoolean(json, "requiresCooling", false);

            return new TubInteractingRecipe(id, itemIngredient, fluidIngredient, result, baseCount, requiresCooling);
        }

        @Override
        public TubInteractingRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf byteBuf) {
            Ingredient itemIngredient = Ingredient.fromNetwork(byteBuf);
            FluidStack fluidIngredient = FluidStack.readFromPacket(byteBuf);
            FluidStack result = FluidStack.readFromPacket(byteBuf);
            int baseCount = byteBuf.readVarInt();
            boolean requiresCooling = byteBuf.readBoolean();
            return new TubInteractingRecipe(id, itemIngredient, fluidIngredient, result, baseCount, requiresCooling);
        }

        @Override
        public void toNetwork(FriendlyByteBuf byteBuf, TubInteractingRecipe recipe) {
            recipe.itemIngredient.toNetwork(byteBuf);
            recipe.fluidIngredient.writeToPacket(byteBuf);
            recipe.result.writeToPacket(byteBuf);
            byteBuf.writeVarInt(recipe.baseCount);
            byteBuf.writeBoolean(recipe.requiresCooling());
        }
    }
}
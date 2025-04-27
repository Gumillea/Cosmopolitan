package com.gumillea.cosmopolitan.core.data;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.gumillea.cosmopolitan.Cosmopolitan;
import com.gumillea.cosmopolitan.core.reg.CosmoFluids;
import com.gumillea.cosmopolitan.core.reg.CosmoItems;
import com.gumillea.cosmopolitan.core.reg.CosmoRecipes;
import com.gumillea.cosmopolitan.core.util.CosmoCompat;
import com.teamabnormals.blueprint.core.data.server.BlueprintRecipeProvider;
import com.teamabnormals.neapolitan.core.registry.NeapolitanItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class CosmoRecipeProvider extends BlueprintRecipeProvider {
    public CosmoRecipeProvider(PackOutput output) {
        super(Cosmopolitan.MODID, output);
    }

    public void buildRecipes(@NotNull Consumer<FinishedRecipe> finished) {
        registerFlavorRecipes(finished,
                NeapolitanItems.VANILLA_ICE_CREAM.get(),
                NeapolitanItems.VANILLA_MILKSHAKE.get(),
                CosmoFluids.VANILLA_ICE_CREAM.get(),
                CosmoCompat.NEA
        );
        registerFlavorRecipes(finished,
                NeapolitanItems.STRAWBERRY_ICE_CREAM.get(),
                NeapolitanItems.STRAWBERRY_MILKSHAKE.get(),
                CosmoFluids.STRAWBERRY_ICE_CREAM.get(),
                CosmoCompat.NEA
        );
        registerFlavorRecipes(finished,
                NeapolitanItems.CHOCOLATE_ICE_CREAM.get(),
                NeapolitanItems.CHOCOLATE_MILKSHAKE.get(),
                CosmoFluids.CHOCOLATE_ICE_CREAM.get(),
                CosmoCompat.NEA
        );
        registerFlavorRecipes(finished,
                NeapolitanItems.BANANA_ICE_CREAM.get(),
                NeapolitanItems.BANANA_MILKSHAKE.get(),
                CosmoFluids.BANANA_ICE_CREAM.get(),
                CosmoCompat.NEA
        );
        registerFlavorRecipes(finished,
                NeapolitanItems.ADZUKI_ICE_CREAM.get(),
                NeapolitanItems.ADZUKI_MILKSHAKE.get(),
                CosmoFluids.ADZUKI_ICE_CREAM.get(),
                CosmoCompat.NEA
        );
        registerFlavorRecipes(finished,
                NeapolitanItems.MINT_ICE_CREAM.get(),
                NeapolitanItems.MINT_MILKSHAKE.get(),
                CosmoFluids.MINT_ICE_CREAM.get(),
                CosmoCompat.NEA
        );

        registerFlavorRecipes(finished,
                NeapolitanItems.MINT_ICE_CREAM.get(),
                NeapolitanItems.MINT_MILKSHAKE.get(),
                CosmoFluids.MINT_ICE_CREAM.get(),
                CosmoCompat.NEA
        );
    }

    private void registerFlavorRecipes(
            Consumer<FinishedRecipe> consumer,
            Item iceCreamItem,
            Item milkshakeItem,
            Fluid iceCreamFluid,
            String... modids
    ) {
        String name = ForgeRegistries.FLUIDS.getKey(iceCreamFluid).getPath();
        List<JsonObject> conds = modsLoaded(modids);

        registerTubRecipe(
                consumer,
                name,
                CosmoRecipes.TUB_EXTRACT_SERIALIZER.get(),
                conds,
                List.of(
                        itemIngredient(Items.BOWL),
                        fluidIngredient(iceCreamFluid, 750)
                ),
                List.of(
                        resultItem(iceCreamItem, 1)
                )
        );

        registerTubRecipe(
                consumer,
                name,
                CosmoRecipes.TUB_INJECT_SERIALIZER.get(),
                conds,
                List.of(
                        itemIngredient(iceCreamItem)
                ),
                List.of(
                        resultItem(Items.BOWL, 1),
                        resultFluid(iceCreamFluid, 750)
                )
        );

        String coneName = name + "_cone";
        Item coneItem = CosmoItems.WAFER_CONE.get();
        registerTubRecipe(
                consumer,
                coneName,
                CosmoRecipes.TUB_EXTRACT_SERIALIZER.get(),
                conds,
                List.of(
                        itemIngredient(coneItem),
                        fluidIngredient(iceCreamFluid, 250)
                ),
                List.of(
                        resultItem(ForgeRegistries.ITEMS.getValue(new ResourceLocation(Cosmopolitan.MODID, coneName)), 1)
                )
        );

        String shakeName = name + "_milkshake";
        registerTubRecipe(
                consumer,
                shakeName,
                CosmoRecipes.TUB_EXTRACT_SERIALIZER.get(),
                conds,
                List.of(
                        tagIngredient("forge:milk/milk_bottle"),
                        fluidIngredient(iceCreamFluid, 250)
                ),
                List.of(
                        resultItem(milkshakeItem, 1)
                )
        );
    }

    private void registerTubRecipe(
            Consumer<FinishedRecipe> consumer,
            String name,
            RecipeSerializer<?> serializer,
            List<JsonObject> conditions,
            List<JsonObject> ingredients,
            List<JsonObject> results
    ) {
        JsonObject json = new JsonObject();
        JsonArray condArr = new JsonArray();
        conditions.forEach(condArr::add);
        json.add("conditions", condArr);
        JsonArray ingArr = new JsonArray();
        ingredients.forEach(ingArr::add);
        json.add("ingredient", ingArr.size() == 1 ? ingArr.get(0) : ingArr);
        JsonArray resArr = new JsonArray();
        results.forEach(resArr::add);
        json.add("result", resArr.size() == 1 ? resArr.get(0) : resArr);

        ResourceLocation id = new ResourceLocation(
                "cosmopolitan",
                (serializer == CosmoRecipes.TUB_EXTRACT_SERIALIZER.get() ? "tub_extracting/" : "tub_injecting/") + name
        );
        consumer.accept(new CustomFinishedRecipe(id, serializer, json));
    }

    private List<JsonObject> modsLoaded(String... modids) {
        return Arrays.stream(modids)
                .map(this::modLoaded)
                .toList();
    }

    private JsonObject modLoaded(String modid) {
        JsonObject cond = new JsonObject();
        cond.addProperty("type", "forge:mod_loaded");
        cond.addProperty("modid", modid);
        return cond;
    }

    private JsonObject itemIngredient(Item item) {
        JsonObject obj = new JsonObject();
        obj.addProperty("item", ForgeRegistries.ITEMS.getKey(item).toString());
        return obj;
    }

    private JsonObject tagIngredient(String tag) {
        JsonObject obj = new JsonObject();
        obj.addProperty("tag", tag);
        return obj;
    }

    private JsonObject fluidIngredient(Fluid fluid, int amount) {
        JsonObject obj = new JsonObject();
        JsonObject fj = new JsonObject();
        fj.addProperty("name", ForgeRegistries.FLUIDS.getKey(fluid).toString());
        fj.addProperty("amount", amount);
        obj.add("fluid", fj);
        return obj;
    }

    private JsonObject resultItem(Item item, int count) {
        JsonObject obj = new JsonObject();
        obj.addProperty("item", ForgeRegistries.ITEMS.getKey(item).toString());
        obj.addProperty("count", count);
        return obj;
    }

    private JsonObject resultFluid(Fluid fluid, int amount) {
        JsonObject obj = new JsonObject();
        obj.addProperty("fluid", ForgeRegistries.FLUIDS.getKey(fluid).toString());
        obj.addProperty("amount", amount);
        return obj;
    }

    private static class CustomFinishedRecipe implements FinishedRecipe {
        private final ResourceLocation id;
        private final RecipeSerializer<?> serializer;
        private final JsonObject json;

        public CustomFinishedRecipe(ResourceLocation id, RecipeSerializer<?> serializer, JsonObject json) {
            this.id = id;
            this.serializer = serializer;
            this.json = json;
        }

        @Override
        public void serializeRecipeData(JsonObject out) {
            out.addProperty("type", ForgeRegistries.RECIPE_SERIALIZERS.getKey(serializer).toString());
            json.entrySet().forEach(e -> out.add(e.getKey(), e.getValue()));
        }

        @Override
        public ResourceLocation getId() {
            return id;
        }

        @Override
        public RecipeSerializer<?> getType() {
            return serializer;
        }

        @Override
        public JsonObject serializeAdvancement() {
            return null;
        }

        @Override
        public ResourceLocation getAdvancementId() {
            return null;
        }
    }
}


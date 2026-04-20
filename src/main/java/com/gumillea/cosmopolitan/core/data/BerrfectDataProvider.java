package com.gumillea.cosmopolitan.core.data;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.gumillea.cosmopolitan.Cosmopolitan;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.ForgeRegistries;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public abstract class BerrfectDataProvider implements DataProvider {
    private final PackOutput.PathProvider pathProvider;
    private final List<FlavorEntry> entries = new ArrayList<>();

    public record FlavorEntry(String key, String id, int[] scores, String fileName) {}

    public BerrfectDataProvider(PackOutput output) {
        this.pathProvider = output.createPathProvider(PackOutput.Target.DATA_PACK, "berrfect/flavors");
    }

    protected abstract void generate();

    protected void add(Item item, int sour, int sweet, int bitter, int spicy) {
        ResourceLocation id = ForgeRegistries.ITEMS.getKey(item);
        if (id != null) {
            entries.add(new FlavorEntry("item", id.toString(), new int[]{sour, sweet, bitter, spicy}, id.getPath()));
        }
    }

    protected void add(TagKey<Item> tag, int sour, int sweet, int bitter, int spicy) {
        ResourceLocation id = tag.location();
        entries.add(new FlavorEntry("tag", id.toString(), new int[]{sour, sweet, bitter, spicy}, id.getPath().replace("/", "_")));
    }

    @Override
    public CompletableFuture<?> run(CachedOutput output) {
        entries.clear();
        generate();

        List<CompletableFuture<?>> futures = new ArrayList<>();
        for (FlavorEntry entry : entries) {
            JsonObject json = new JsonObject();
            json.addProperty(entry.key(), entry.id());
            JsonArray values = new JsonArray();
            for (int s : entry.scores()) values.add(s);
            json.add("values", values);

            Path path = pathProvider.json(new ResourceLocation(Cosmopolitan.MODID, entry.fileName()));
            futures.add(DataProvider.saveStable(output, json, path));
        }
        return CompletableFuture.allOf(futures.toArray(CompletableFuture[]::new));
    }

    @Override
    public String getName() {
        return "Berrfect Flavor Data";
    }
}






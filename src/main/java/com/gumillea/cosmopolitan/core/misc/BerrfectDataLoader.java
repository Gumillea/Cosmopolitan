package com.gumillea.cosmopolitan.core.misc;

import com.google.gson.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.SimpleJsonResourceReloadListener;
import net.minecraft.tags.TagKey;
import net.minecraft.util.profiling.ProfilerFiller;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Map;

public class BerrfectDataLoader extends SimpleJsonResourceReloadListener {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();

    public BerrfectDataLoader() {
        super(GSON, "berrfect/flavors");
    }

    @Override
    protected void apply(Map<ResourceLocation, JsonElement> map, ResourceManager manager, ProfilerFiller filler) {
        BerrfectFlavorHelper.clearData();

        map.forEach((location, element) -> {
            try {
                JsonObject json = element.getAsJsonObject();
                JsonArray values = json.getAsJsonArray("values");
                int[] scores = new int[]{
                        values.get(0).getAsInt(), values.get(1).getAsInt(), values.get(2).getAsInt(), values.get(3).getAsInt()
                };

                if (json.has("item")) {
                    ResourceLocation id = new ResourceLocation(json.get("item").getAsString());
                    Item item = ForgeRegistries.ITEMS.getValue(id);
                    if (item != null && item != Items.AIR) {
                        BerrfectFlavorHelper.registerItemFlavor(item, scores);
                    }
                } else if (json.has("tag")) {
                    ResourceLocation id = new ResourceLocation(json.get("tag").getAsString());
                    TagKey<Item> tagKey = TagKey.create(Registries.ITEM, id);
                    BerrfectFlavorHelper.registerTagFlavor(tagKey, scores);
                }
            } catch (Exception ignored) {}
        });
    }
}
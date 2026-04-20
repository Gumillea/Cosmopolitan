package com.gumillea.cosmopolitan.core.misc;

import com.gumillea.cosmopolitan.core.reg.CosmoItems;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.*;

public class BerrfectFlavorHelper {
    public static final String KEY = "berrySyrupFlavor";
    private static final Random RANDOM = new Random();
    private static final Map<Item, int[]> ITEM_FLAVORS = new HashMap<>();
    private static final Map<TagKey<Item>, int[]> TAG_FLAVORS = new HashMap<>();

    public static final String[] FLAVORS = {
            "sweet", "spicy", "sour", "bitter", "strange"
    };

    public static void clearData() {
        ITEM_FLAVORS.clear();
        TAG_FLAVORS.clear();
    }

    public static void registerItemFlavor(Item item, int[] i) {
        ITEM_FLAVORS.put(item, i);
    }

    public static void registerTagFlavor(TagKey<Item> tag, int[] i) {
        TAG_FLAVORS.put(tag, i);
    }

    public static String getFlavorFromIngredients(List<ItemStack> ingredients) {
        int[] total = new int[4];

        for (ItemStack stack : ingredients) {
            if (stack.isEmpty()) continue;
            if (stack.hasTag() && stack.getTag().contains(KEY)) {
                inheritFlavor(total, stack.getTag().getString(KEY));
            } else {
                int[] data = getFlavorData(stack);
                if (data != null) {
                    for (int i = 0; i < 4; i++) total[i] += data[i];
                }
            }
        }
        return determineFlavor(total);
    }

    public static void calculateFlavor(ItemStack result, List<ItemStack> ingredients) {
        String determined = getFlavorFromIngredients(ingredients);
        result.getOrCreateTag().putString(KEY, determined);
    }

    private static int[] getFlavorData(ItemStack itemStack) {
        if (itemStack.isEmpty()) return null;
        Item item = itemStack.getItem();

        if (item == CosmoItems.WILDBERRY.get()) {
            return new int[] {RANDOM.nextInt(4), RANDOM.nextInt(4), RANDOM.nextInt(4), RANDOM.nextInt(4)};
        }

        if (ITEM_FLAVORS.containsKey(item)) return ITEM_FLAVORS.get(item);

        for (Map.Entry<TagKey<Item>, int[]> entry : TAG_FLAVORS.entrySet()) {
            if (itemStack.is(entry.getKey())) return entry.getValue();
        }
        return null;
    }

    private static void inheritFlavor(int[] scores, String flavor) {
        switch (flavor) {
            case "sour" -> scores[0] += 5;
            case "sweet" -> scores[1] += 5;
            case "bitter" -> scores[2] += 5;
            case "spicy" -> scores[3] += 5;
        }
    }

    private static String determineFlavor(int[] scores) {
        int maxValue = 0;
        for (int score : scores) {
            if (score > maxValue) maxValue = score;
        }
        if (maxValue == 0) return "strange";

        List<Integer> maxIndices = new ArrayList<>();
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == maxValue) maxIndices.add(i);
        }

        int selected = maxIndices.get(RANDOM.nextInt(maxIndices.size()));
        String[] names = {"sour", "sweet", "bitter", "spicy"};
        return names[selected];
    }
}
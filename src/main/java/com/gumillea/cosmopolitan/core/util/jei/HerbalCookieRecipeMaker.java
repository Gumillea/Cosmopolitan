package com.gumillea.cosmopolitan.core.util.jei;

import com.gumillea.cosmopolitan.common.item.HerbalFoodItem;
import com.gumillea.cosmopolitan.core.reg.CosmoItems;
import mezz.jei.api.constants.ModIds;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.NonNullList;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.CraftingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.ShapelessRecipe;
import net.minecraft.world.level.block.FlowerBlock;

import java.util.List;

public class HerbalCookieRecipeMaker {

    public static List<CraftingRecipe> createRecipes() {
        String group = "jei.cosmopolitan.herbal.cookie";
        Ingredient powder = Ingredient.of(CosmoItems.HERBAL_POWDER.get());
        Ingredient wheat1 = Ingredient.of(Items.WHEAT);
        Ingredient wheat2 = Ingredient.of(Items.WHEAT);
        Ingredient honey = Ingredient.of(Items.HONEY_BOTTLE);

        return BuiltInRegistries.ITEM.getTag(ItemTags.SMALL_FLOWERS)
                .stream()
                .flatMap(HolderSet.ListBacked::stream)
                .map(Holder::value)
                .filter(BlockItem.class::isInstance)
                .map(item -> ((BlockItem) item).getBlock())
                .filter(FlowerBlock.class::isInstance)
                .map(FlowerBlock.class::cast)
                .<CraftingRecipe>map(flowerBlock -> {
                    Ingredient flower = Ingredient.of(flowerBlock.asItem());
                    NonNullList<Ingredient> inputs = NonNullList.of(Ingredient.EMPTY, wheat1, wheat2, honey, powder, flower);
                    ItemStack output = new ItemStack(CosmoItems.HERBAL_COOKIE.get(), 8);
                    MobEffect mobeffect = flowerBlock.getSuspiciousEffect();
                    HerbalFoodItem.saveMobEffect(output, mobeffect, flowerBlock.getEffectDuration());
                    ResourceLocation id = new ResourceLocation(ModIds.MINECRAFT_ID, "jei.cosmopolitan.herbal.cookie." + flowerBlock.getDescriptionId());
                    return new ShapelessRecipe(id, group, CraftingBookCategory.MISC, output, inputs);
                })
                .toList();
    }

    private HerbalCookieRecipeMaker() {

    }
}

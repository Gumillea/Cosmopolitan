package com.gumillea.cosmopolitan.core.util.jei;

import com.gumillea.cosmopolitan.common.item.HerbalCookieItem;
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
        Ingredient fiddlehead = Ingredient.of(CosmoItems.BAKED_FIDDLEHEAD.get());
        Ingredient wheat = Ingredient.of(Items.WHEAT);

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
                    NonNullList<Ingredient> inputs = NonNullList.of(Ingredient.EMPTY, wheat, wheat, fiddlehead, flower);
                    ItemStack output = new ItemStack(CosmoItems.HERBAL_COOKIE.get(), 4);
                    MobEffect mobeffect = flowerBlock.getSuspiciousEffect();
                    HerbalCookieItem.saveMobEffect(output, mobeffect, flowerBlock.getEffectDuration());
                    ResourceLocation id = new ResourceLocation(ModIds.MINECRAFT_ID, "jei.cosmopolitan.herbal.cookie." + flowerBlock.getDescriptionId());
                    return new ShapelessRecipe(id, group, CraftingBookCategory.MISC, output, inputs);
                })
                .toList();
    }

    private HerbalCookieRecipeMaker() {

    }
}

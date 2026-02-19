package com.gumillea.cosmopolitan.core.util.jei;

import com.gumillea.cosmopolitan.common.item.HerbalFoodItem;
import com.gumillea.cosmopolitan.core.reg.CosmoItems;
import com.gumillea.cosmopolitan.core.util.CosmoItemTags;
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
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.FlowerBlock;
import vectorwing.farmersdelight.client.recipebook.CookingPotRecipeBookTab;
import vectorwing.farmersdelight.common.crafting.CookingPotRecipe;
import vectorwing.farmersdelight.common.tag.ForgeTags;

import java.util.List;

public class TisaneRecipeMaker {

    public static List<CookingPotRecipe> createRecipes() {
        Ingredient powder = Ingredient.of(CosmoItems.HERBAL_POWDER.get());
        Ingredient seeds = Ingredient.of(ForgeTags.SEEDS);

        return BuiltInRegistries.ITEM.getTag(ItemTags.SMALL_FLOWERS)
                .stream()
                .flatMap(HolderSet.ListBacked::stream)
                .map(Holder::value)
                .filter(BlockItem.class::isInstance)
                .map(item -> ((BlockItem) item).getBlock())
                .filter(FlowerBlock.class::isInstance)
                .map(FlowerBlock.class::cast)
                .map(flowerBlock -> {
                    NonNullList<Ingredient> inputs = NonNullList.create();
                    inputs.add(powder);
                    inputs.add(powder);
                    inputs.add(Ingredient.of(flowerBlock.asItem()));
                    inputs.add(Ingredient.of(flowerBlock.asItem()));
                    inputs.add(seeds);

                    ItemStack output = new ItemStack(CosmoItems.TISANE.get());
                    MobEffect effect = flowerBlock.getSuspiciousEffect();
                    int duration = flowerBlock.getEffectDuration();

                    int newDuration = duration <= 1 ? duration : duration * 2;
                    HerbalFoodItem.saveMobEffect(output, effect, newDuration);

                    return new CookingPotRecipe(
                            new ResourceLocation("cosmopolitan", "jei.tisane." + BuiltInRegistries.BLOCK.getKey(flowerBlock).getPath()),
                            "jei.cosmopolitan.tisane",
                            CookingPotRecipeBookTab.DRINKS,
                            inputs,
                            output,
                            new ItemStack(Items.HONEY_BOTTLE),
                            1F,
                            1800
                    );
                })
                .toList();
    }

    private TisaneRecipeMaker() {

    }
}

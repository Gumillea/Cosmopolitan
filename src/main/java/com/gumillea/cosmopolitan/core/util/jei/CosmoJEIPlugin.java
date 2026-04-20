package com.gumillea.cosmopolitan.core.util.jei;

import com.gumillea.cosmopolitan.CosmoConfig;
import com.gumillea.cosmopolitan.Cosmopolitan;
import com.gumillea.cosmopolitan.core.misc.BerrfectFlavorHelper;
import com.gumillea.cosmopolitan.core.reg.CosmoBlocks;
import com.gumillea.cosmopolitan.core.reg.CosmoItems;
import com.gumillea.cosmopolitan.core.reg.CosmoRecipes;
import com.gumillea.cosmopolitan.core.reg.client.CosmoItemProperties;
import com.gumillea.cosmopolitan.core.util.CosmoCompat;
import com.gumillea.cosmopolitan.core.util.CosmoItemTags;
import com.gumillea.cosmopolitan.core.util.CosmoUtils;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.RecipeTypes;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IRecipeManager;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.registration.ISubtypeRegistration;
import mezz.jei.api.runtime.IJeiRuntime;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;
import vectorwing.farmersdelight.integration.jei.FDRecipeTypes;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

@JeiPlugin
@ParametersAreNonnullByDefault
public class CosmoJEIPlugin implements IModPlugin {
    public static final ResourceLocation ID = new ResourceLocation(Cosmopolitan.MODID, "jei_plugin");

    private static final List<Supplier<Item>> INFO_ITEMS = List.of(
            CosmoItems.FIDDLEHEAD, CosmoItems.WILDBERRY, CosmoItems.WHEATGRASS
    );

    @Override
    public ResourceLocation getPluginUid() {
        return ID;
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        IGuiHelper guiHelper = registration.getJeiHelpers().getGuiHelper();
        registration.addRecipeCategories(new TubExtractCategory(guiHelper), new TubInjectCategory(guiHelper));
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        ItemStack copperTub = new ItemStack(CosmoBlocks.COPPER_FROZEN_DESSERT_TUB.get());
        ItemStack ironTub = new ItemStack(CosmoBlocks.IRON_FROZEN_DESSERT_TUB.get());
        ItemStack netheriteTub = new ItemStack(CosmoBlocks.NETHERITE_FROZEN_DESSERT_TUB.get());

        registration.addRecipeCatalyst(copperTub, TubExtractCategory.TYPE, TubInjectCategory.TYPE);
        registration.addRecipeCatalyst(ironTub, TubExtractCategory.TYPE, TubInjectCategory.TYPE);
        registration.addRecipeCatalyst(netheriteTub, TubExtractCategory.TYPE, TubInjectCategory.TYPE);
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager manager = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();

        registration.addRecipes(TubExtractCategory.TYPE, manager.getAllRecipesFor(CosmoRecipes.TUB_EXTRACT_TYPE.get()));
        registration.addRecipes(TubInjectCategory.TYPE, manager.getAllRecipesFor(CosmoRecipes.TUB_INJECT_TYPE.get()));

        registration.addRecipes(RecipeTypes.CRAFTING, HerbalCookieRecipeMaker.createRecipes());
        if (CosmoCompat.fd) registration.addRecipes(FDRecipeTypes.COOKING, TisaneRecipeMaker.createRecipes());

        for (Supplier<Item> itemSupplier : INFO_ITEMS) {
            Item item = itemSupplier.get();
            ResourceLocation key = Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(item));
            String translationKey = "jei." + Cosmopolitan.MODID + "." + key.getPath() + ".desc";

            registration.addIngredientInfo(new ItemStack(item), VanillaTypes.ITEM_STACK, Component.translatable(translationKey));
        }

        List<@NotNull ItemStack> gulime = new ArrayList<>(List.of(
                new ItemStack(CosmoItems.GULIME.get()),
                new ItemStack(CosmoItems.GULIME_SMALL.get()),
                new ItemStack(CosmoItems.UNDERGROUND_GULIME.get()),
                new ItemStack(CosmoItems.UNDERGROUND_GULIME_SMALL.get()),
                new ItemStack(CosmoItems.ARID_GULIME.get()),
                new ItemStack(CosmoItems.ARID_GULIME_SMALL.get()),
                new ItemStack(CosmoItems.TAIGA_GULIME.get()),
                new ItemStack(CosmoItems.TAIGA_GULIME_SMALL.get()),
                new ItemStack(CosmoItems.CHORUS_GULIME.get()),
                new ItemStack(CosmoItems.CHORUS_GULIME_SMALL.get()),
                new ItemStack(CosmoItems.WARPED_GULIME.get()),
                new ItemStack(CosmoItems.WARPED_GULIME_SMALL.get())
        ));

        if (CosmoCompat.nea) {
            gulime.add(new ItemStack(CosmoItems.STRAWBERRY_GULIME.get()));
            gulime.add(new ItemStack(CosmoItems.STRAWBERRY_GULIME_SMALL.get()));
        }

        if (CosmoCompat.qua) {
            gulime.add(new ItemStack(CosmoItems.GLIMMERING_GULIME.get()));
            gulime.add(new ItemStack(CosmoItems.GLIMMERING_GULIME_SMALL.get()));
        }

        registration.addIngredientInfo(gulime, VanillaTypes.ITEM_STACK, Component.translatable("jei." + Cosmopolitan.MODID + ".gulime.desc"));

        registration.addIngredientInfo(
                List.of(
                        new ItemStack(CosmoItems.CONDENSED_MILK_BUCKET.get()),
                        new ItemStack(CosmoItems.CONDENSED_MILK_BOTTLE.get())
                ),
                VanillaTypes.ITEM_STACK,
                Component.translatable("jei." + Cosmopolitan.MODID + ".condensed_milk_bucket.desc")
        );

        registration.addIngredientInfo(
                List.of(
                        new ItemStack(CosmoItems.CREAM_BUCKET.get()),
                        new ItemStack(CosmoItems.CREAM.get())
                ),
                VanillaTypes.ITEM_STACK,
                Component.translatable("jei." + Cosmopolitan.MODID + ".cream_bucket.desc")
        );

        registration.addIngredientInfo(
                List.of(
                        new ItemStack(CosmoBlocks.COPPER_FROZEN_DESSERT_TUB.get()),
                        new ItemStack(CosmoBlocks.IRON_FROZEN_DESSERT_TUB.get()),
                        new ItemStack(CosmoBlocks.NETHERITE_FROZEN_DESSERT_TUB.get())
                ),
                VanillaTypes.ITEM_STACK,
                Component.translatable("jei." + Cosmopolitan.MODID + ".frozen_dessert_tub.desc")
        );

        List<@NotNull ItemStack> doublePopsicle = new ArrayList<>(List.of(
                new ItemStack(CosmoItems.BERRY_DOUBLE_POPSICLE.get()),
                new ItemStack(CosmoItems.CHORUS_FRUIT_DOUBLE_POPSICLE.get())
        ));

        if (CosmoCompat.cr) doublePopsicle.add(new ItemStack(CosmoItems.LIME_DOUBLE_POPSICLE.get()));
        if (CosmoCompat.ug) doublePopsicle.add(new ItemStack(CosmoItems.BLISTERBERRY_DOUBLE_POPSICLE.get()));
        if (CosmoCompat.fr) doublePopsicle.add(new ItemStack(CosmoItems.GAMBLERS_POPSICLE_DOUBLE.get()));
        if (CosmoCompat.an) {
            doublePopsicle.add(new ItemStack(CosmoItems.ARDENT_SPLIT_POPSICLE_DOUBLE.get()));
            doublePopsicle.add(new ItemStack(CosmoItems.TRANQUIL_SPLIT_POPSICLE_DOUBLE.get()));
        }

        registration.addIngredientInfo(doublePopsicle, VanillaTypes.ITEM_STACK, Component.translatable("jei." + Cosmopolitan.MODID + ".blisterberry_popsicle_double.desc"));

        List<@NotNull ItemStack> tradersFood = new ArrayList<>(List.of(
                new ItemStack(CosmoItems.EMERALD_CANDY.get()),
                new ItemStack(CosmoItems.WANDERING_GELATO.get()),
                new ItemStack(CosmoItems.TRAVELERS_PANINI.get()),
                new ItemStack(CosmoItems.LLAMA_MARSHMALLOW_TRADER.get())));

        if (CosmoCompat.en) tradersFood.add(new ItemStack(CosmoItems.SLABFISH_JELLY_POPSICLE.get()));

        registration.addIngredientInfo(tradersFood, VanillaTypes.ITEM_STACK, Component.translatable("jei." + Cosmopolitan.MODID + ".wandering_gelato.desc"));


        if (CosmoConfig.Common.FLAVORED_SYRUP.get()) {
            List<@NotNull ItemStack> flavoredFood = new ArrayList<>(List.of(
                    new ItemStack(CosmoItems.BERRY_SYRUP_BOTTLE.get()),
                    new ItemStack(CosmoItems.BERRY_CREAM_CHEESE_BAGEL.get()),
                    new ItemStack(CosmoItems.BERRY_CHEESECAKE_BAR.get())));

            if (CosmoCompat.fr) flavoredFood.add(new ItemStack(CosmoItems.BERRY_SYRUP_AMERICANO.get()));
            if (CosmoCompat.cr) flavoredFood.add(new ItemStack(CosmoItems.BERRY_SYRUP_GUMMY.get()));
            if (CosmoCompat.fd) {
                flavoredFood.add(new ItemStack(CosmoItems.BERRY_DOUBLE_POPSICLE.get()));
                flavoredFood.add(new ItemStack(CosmoItems.BERRY_POPSICLE.get()));
            }
            if (!CosmoUtils.isTagEmpty(CosmoItemTags.ICE_CUBE)) {
                flavoredFood.add(new ItemStack(CosmoItems.BERRY_SYRUP_SHAVED_ICE.get()));
                flavoredFood.add(new ItemStack(CosmoItems.BERRY_SYRUP_SHAVED_ICE_CONE.get()));
            }
            registration.addIngredientInfo(flavoredFood, VanillaTypes.ITEM_STACK, Component.translatable("jei." + Cosmopolitan.MODID + ".berry_syrup_bottle.desc"));
        }

        List<@NotNull ItemStack> netherBerries = new ArrayList<>();

        if (CosmoConfig.Common.BOILBERRY_CHANCE.get() > 0) netherBerries.add(new ItemStack(CosmoItems.BOILBERRY.get()));
        if (CosmoConfig.Common.SPINALBERRY_CHANCE.get() > 0) netherBerries.add(new ItemStack(CosmoItems.SPINALBERRY.get()));

        registration.addIngredientInfo(netherBerries, VanillaTypes.ITEM_STACK, Component.translatable("jei." + Cosmopolitan.MODID + ".boilberry.desc"));

        List<@NotNull ItemStack> funguis_bottle = new ArrayList<>(List.of(
                new ItemStack(CosmoItems.FUNGUIS_BOTTLE.get())));

        if (CosmoCompat.ja) {
            funguis_bottle.add(new ItemStack(CosmoItems.WARPED_FUNGUIS_BOTTLE.get()));
            if (CosmoCompat.gd) funguis_bottle.add(new ItemStack(CosmoItems.SOULBLIGHT_FUNGUIS_BOTTLE.get()));
        }

        registration.addIngredientInfo(funguis_bottle, VanillaTypes.ITEM_STACK, Component.translatable("jei." + Cosmopolitan.MODID + ".funguis_bottle.desc"));

    }

    @Override
    public void onRuntimeAvailable(IJeiRuntime runtime) {
        IRecipeManager manager = runtime.getRecipeManager();
        ResourceLocation tisane = CosmoUtils.id(Cosmopolitan.MODID, "farmersdelight/cooking/tisane");
        var tisaneRecipe = manager.createRecipeLookup(FDRecipeTypes.COOKING).get().filter(holder -> holder.getId().equals(tisane)).toList();

        if (!tisaneRecipe.isEmpty()) {
            manager.hideRecipes(FDRecipeTypes.COOKING, tisaneRecipe);
        }
    }

}
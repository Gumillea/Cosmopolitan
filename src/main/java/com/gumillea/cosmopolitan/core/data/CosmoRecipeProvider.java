package com.gumillea.cosmopolitan.core.data;

import com.cosmicgelatin.peculiars.core.registry.PeculiarsBlocks;
import com.cosmicgelatin.peculiars.core.registry.PeculiarsItems;
import com.cosmicgelatin.seasonals.core.registry.SeasonalsBlocks;
import com.cosmicgelatin.seasonals.core.registry.SeasonalsItems;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.gumillea.cosmopolitan.Cosmopolitan;
import com.gumillea.cosmopolitan.core.reg.CosmoBlocks;
import com.gumillea.cosmopolitan.core.reg.CosmoFluids;
import com.gumillea.cosmopolitan.core.reg.CosmoItems;
import com.gumillea.cosmopolitan.core.reg.CosmoRecipes;
import com.gumillea.cosmopolitan.core.util.CosmoCompat;
import com.gumillea.cosmopolitan.core.util.CosmoItemTags;
import com.gumillea.exquisito.core.reg.ExquisitoBlocks;
import com.gumillea.exquisito.core.reg.ExquisitoItems;
import com.gumillea.exquisito.core.util.tags.ExquisitoItemTags;
import com.sammy.minersdelight.setup.MDItems;
import com.teamabnormals.atmospheric.core.other.tags.AtmosphericItemTags;
import com.teamabnormals.atmospheric.core.registry.AtmosphericItems;
import com.teamabnormals.blueprint.core.data.server.BlueprintRecipeProvider;
import com.teamabnormals.caverns_and_chasms.core.registry.CCItems;
import com.teamabnormals.neapolitan.core.other.tags.NeapolitanItemTags;
import com.teamabnormals.neapolitan.core.registry.NeapolitanBlocks;
import com.teamabnormals.neapolitan.core.registry.NeapolitanItems;
import net.brdle.collectorsreap.common.block.CRBlocks;
import net.brdle.collectorsreap.common.item.CRItems;
import net.brnbrd.delightful.common.block.DelightfulBlocks;
import net.brnbrd.delightful.common.item.DelightfulItems;
import net.brnbrd.delightful.data.tags.DelightfulItemTags;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.common.crafting.ConditionalRecipe;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.common.crafting.conditions.*;
import net.minecraftforge.registries.ForgeRegistries;
import org.hiedacamellia.seeddelight.registry.BlockRegistry;
import org.hiedacamellia.seeddelight.registry.ItemRegistry;
import org.jetbrains.annotations.NotNull;
import twilightforest.init.TFItems;
import umpaz.farmersrespite.common.registry.FRItems;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class CosmoRecipeProvider extends BlueprintRecipeProvider {
    public CosmoRecipeProvider(PackOutput output) {
        super(Cosmopolitan.MODID, output);
    }

    public void buildRecipes(@NotNull Consumer<FinishedRecipe> finished) {
        registerFourStorageRecipe(finished, CosmoItems.BERRY_SYRUP_BOTTLE.get(), CosmoBlocks.BERRY_SYRUP_BLOCK.get());
        registerFourStorageRecipe(finished, CosmoItems.BIRCH_SAP_BOTTLE.get(), CosmoBlocks.BIRCH_SAP_BLOCK.get());

        registerNineStorageRecipe(finished, CosmoItems.WILDBERRY.get(), CosmoBlocks.WILDBERRIES_BASKET.get());
        registerNineStorageRecipe(finished, CosmoItems.FIDDLEHEAD.get(), CosmoBlocks.FIDDLEHEAD_CRATE.get());

        registerConeRecipe(finished, CosmoItemTags.CHERRY, ItemRegistry.CherryIceCream.get(), CosmoItems.CHERRY_ICE_CREAM_CONE.get());

        registerConeRecipe(finished, FRItems.GREEN_TEA_LEAVES.get(), ForgeRegistries.ITEMS.getValue(new ResourceLocation(CosmoCompat.RF, "green_tea_ice_cream")), CosmoItems.GREEN_TEA_ICE_CREAM_CONE.get());
        registerConeRecipe(finished, FRItems.YELLOW_TEA_LEAVES.get(), ForgeRegistries.ITEMS.getValue(new ResourceLocation(CosmoCompat.RF, "yellow_tea_ice_cream")), CosmoItems.YELLOW_TEA_ICE_CREAM_CONE.get());
        registerConeRecipe(finished, FRItems.BLACK_TEA_LEAVES.get(), ForgeRegistries.ITEMS.getValue(new ResourceLocation(CosmoCompat.RF, "black_tea_ice_cream")), CosmoItems.BLACK_TEA_ICE_CREAM_CONE.get());
        registerConeRecipe(finished, FRItems.COFFEE_BEANS.get(), ForgeRegistries.ITEMS.getValue(new ResourceLocation(CosmoCompat.RF, "coffee_ice_cream")), CosmoItems.COFFEE_ICE_CREAM_CONE.get());

        registerIceCreamBlocksRecipe(finished, CosmoItems.APPLE_ICE_CREAM.get(), CosmoBlocks.APPLE_ICE_CREAM_BLOCK.get());
        registerIceCreamBlocksRecipe(finished, CosmoItems.CARROT_ICE_CREAM.get(), CosmoBlocks.CARROT_ICE_CREAM_BLOCK.get());
        registerIceCreamBlocksRecipe(finished, CosmoItems.GLOW_BERRY_ICE_CREAM.get(), CosmoBlocks.GLOW_BERRY_ICE_CREAM_BLOCK.get());

        registerFourBlocksRecipe(finished, NeapolitanBlocks.STRAWBERRY_ICE_CREAM_BLOCK.get(), CosmoBlocks.STRAWBERRY_ICE_CREAM_BRICKS.get());
        registerFourBlocksRecipe(finished, NeapolitanBlocks.VANILLA_ICE_CREAM_BLOCK.get(), CosmoBlocks.VANILLA_ICE_CREAM_BRICKS.get());
        registerFourBlocksRecipe(finished, NeapolitanBlocks.CHOCOLATE_ICE_CREAM_BLOCK.get(), CosmoBlocks.CHOCOLATE_ICE_CREAM_BRICKS.get());
        registerFourBlocksRecipe(finished, NeapolitanBlocks.ADZUKI_ICE_CREAM_BLOCK.get(), CosmoBlocks.ADZUKI_ICE_CREAM_BRICKS.get());
        registerFourBlocksRecipe(finished, NeapolitanBlocks.MINT_ICE_CREAM_BLOCK.get(), CosmoBlocks.MINT_ICE_CREAM_BRICKS.get());
        registerFourBlocksRecipe(finished, NeapolitanBlocks.BANANA_ICE_CREAM_BLOCK.get(), CosmoBlocks.BANANA_ICE_CREAM_BRICKS.get());
        registerFourBlocksRecipe(finished, DelightfulBlocks.SALMONBERRY_ICE_CREAM_BLOCK.get(), CosmoBlocks.SALMONBERRY_ICE_CREAM_BRICKS.get());
        registerFourBlocksRecipe(finished, DelightfulBlocks.MATCHA_ICE_CREAM_BLOCK.get(), CosmoBlocks.MATCHA_ICE_CREAM_BRICKS.get());
        registerFourBlocksRecipe(finished, CRBlocks.POMEGRANATE_ICE_CREAM_BLOCK.get(), CosmoBlocks.POMEGRANATE_ICE_CREAM_BRICKS.get());
        registerFourBlocksRecipe(finished, CRBlocks.LIME_ICE_CREAM_BLOCK.get(), CosmoBlocks.LIME_ICE_CREAM_BRICKS.get());
        registerFourBlocksRecipe(finished, ExquisitoBlocks.CHORUS_ICE_CREAM_BLOCK.get(), CosmoBlocks.CHORUS_FRUIT_ICE_CREAM_BRICKS.get());
        registerFourBlocksRecipe(finished, ExquisitoBlocks.WARZIPAN_ICE_CREAM_BLOCK.get(), CosmoBlocks.WARZIPAN_ICE_CREAM_BRICKS.get());
        registerFourBlocksRecipe(finished, ExquisitoBlocks.ZURE_BERRY_ICE_CREAM_BLOCK.get(), CosmoBlocks.AZURE_BERRY_ICE_CREAM_BRICKS.get());
        registerFourBlocksRecipe(finished, ExquisitoBlocks.JELLY_RING_ICE_CREAM_BLOCK.get(), CosmoBlocks.JELLY_RING_ICE_CREAM_BRICKS.get());
        registerFourBlocksRecipe(finished, ExquisitoBlocks.NIGHTSHADE_BERRY_ICE_CREAM_BLOCK.get(), CosmoBlocks.MIDNIGHT_ICE_CREAM_BRICKS.get());
        registerFourBlocksRecipe(finished, ExquisitoBlocks.ETHER_BULB_ICE_CREAM_BLOCK.get(), CosmoBlocks.STARCLOUD_ICE_CREAM_BRICKS.get());
        registerFourBlocksRecipe(finished, SeasonalsBlocks.BEETROOT_ICE_CREAM_BLOCK.get(), CosmoBlocks.BEETROOT_ICE_CREAM_BRICKS.get());
        registerFourBlocksRecipe(finished, SeasonalsBlocks.SWEET_BERRY_ICE_CREAM_BLOCK.get(), CosmoBlocks.SWEET_BERRY_ICE_CREAM_BRICKS.get());
        registerFourBlocksRecipe(finished, SeasonalsBlocks.PUMPKIN_ICE_CREAM_BLOCK.get(), CosmoBlocks.PUMPKIN_ICE_CREAM_BRICKS.get());
        registerFourBlocksRecipe(finished, PeculiarsBlocks.ALOE_ICE_CREAM_BLOCK.get(), CosmoBlocks.ALOE_ICE_CREAM_BRICKS.get());
        registerFourBlocksRecipe(finished, PeculiarsBlocks.PASSION_FRUIT_ICE_CREAM_BLOCK.get(), CosmoBlocks.PASSION_FRUIT_ICE_CREAM_BRICKS.get());
        registerFourBlocksRecipe(finished, PeculiarsBlocks.YUCCA_ICE_CREAM_BLOCK.get(), CosmoBlocks.YUCCA_ICE_CREAM_BRICKS.get());
        registerFourBlocksRecipe(finished, ForgeRegistries.BLOCKS.getValue(new ResourceLocation(CosmoCompat.RF, "green_tea_ice_cream_block")), CosmoBlocks.GREEN_TEA_ICE_CREAM_BRICKS.get());
        registerFourBlocksRecipe(finished, ForgeRegistries.BLOCKS.getValue(new ResourceLocation(CosmoCompat.RF, "yellow_tea_ice_cream_block")), CosmoBlocks.YELLOW_TEA_ICE_CREAM_BRICKS.get());
        registerFourBlocksRecipe(finished, ForgeRegistries.BLOCKS.getValue(new ResourceLocation(CosmoCompat.RF, "black_tea_ice_cream_block")), CosmoBlocks.BLACK_TEA_ICE_CREAM_BRICKS.get());
        registerFourBlocksRecipe(finished, ForgeRegistries.BLOCKS.getValue(new ResourceLocation(CosmoCompat.RF, "coffee_ice_cream_block")), CosmoBlocks.COFFEE_ICE_CREAM_BRICKS.get());

        registerFourBlocksRecipe(finished, CosmoBlocks.APPLE_ICE_CREAM_BLOCK.get(), CosmoBlocks.APPLE_ICE_CREAM_BRICKS.get());
        registerFourBlocksRecipe(finished, CosmoBlocks.CARROT_ICE_CREAM_BLOCK.get(), CosmoBlocks.CARROT_ICE_CREAM_BRICKS.get());
        registerFourBlocksRecipe(finished, CosmoBlocks.GLOW_BERRY_ICE_CREAM_BLOCK.get(), CosmoBlocks.GLOW_BERRY_ICE_CREAM_BRICKS.get());
        registerFourBlocksRecipe(finished, CosmoBlocks.SOURCE_BERRY_ICE_CREAM_BLOCK.get(), CosmoBlocks.SOURCE_BERRY_ICE_CREAM_BRICKS.get());
        registerFourBlocksRecipe(finished, CosmoBlocks.ENCHANTED_FRUIT_ICE_CREAM_BLOCK.get(), CosmoBlocks.ENCHANTED_FRUIT_ICE_CREAM_BRICKS.get());
        registerFourBlocksRecipe(finished, CosmoBlocks.KABLOOM_ICE_CREAM_BLOCK.get(), CosmoBlocks.KABLOOM_ICE_CREAM_BRICKS.get());

        registerFourBlocksRecipe(finished, CosmoBlocks.STRAWBERRY_ICE_CREAM_BRICKS.get(), CosmoBlocks.CHISELED_STRAWBERRY_ICE_CREAM_BLOCK.get());
        registerFourBlocksRecipe(finished, CosmoBlocks.VANILLA_ICE_CREAM_BRICKS.get(), CosmoBlocks.CHISELED_VANILLA_ICE_CREAM_BLOCK.get());
        registerFourBlocksRecipe(finished, CosmoBlocks.CHOCOLATE_ICE_CREAM_BRICKS.get(), CosmoBlocks.CHISELED_CHOCOLATE_ICE_CREAM_BLOCK.get());
        registerFourBlocksRecipe(finished, CosmoBlocks.ADZUKI_ICE_CREAM_BRICKS.get(), CosmoBlocks.CHISELED_ADZUKI_ICE_CREAM_BLOCK.get());
        registerFourBlocksRecipe(finished, CosmoBlocks.MINT_ICE_CREAM_BRICKS.get(), CosmoBlocks.CHISELED_MINT_ICE_CREAM_BLOCK.get());
        registerFourBlocksRecipe(finished, CosmoBlocks.BANANA_ICE_CREAM_BRICKS.get(), CosmoBlocks.CHISELED_BANANA_ICE_CREAM_BLOCK.get());

        registerBoth(finished, Items.WATER_BUCKET, Items.BUCKET, Fluids.WATER, 1000);
        registerBoth(finished, Items.LAVA_BUCKET, Items.BUCKET, Fluids.LAVA, 1000);
        registerBoth(finished, Items.MILK_BUCKET, Items.BUCKET, ForgeRegistries.FLUIDS.getValue(new ResourceLocation("minecraft", "milk")), 1000);

        registerBoth(finished, NeapolitanItems.MILK_BOTTLE.get(), Items.GLASS_BOTTLE, ForgeRegistries.FLUIDS.getValue(new ResourceLocation("minecraft", "milk")), 250);
        registerBoth(finished, MDItems.MILK_CUP.get(), MDItems.COPPER_CUP.get(), ForgeRegistries.FLUIDS.getValue(new ResourceLocation("minecraft", "milk")), 500);
        registerBoth(finished, CCItems.GOLDEN_MILK_BUCKET.get(), CCItems.GOLDEN_BUCKET.get(), ForgeRegistries.FLUIDS.getValue(new ResourceLocation("minecraft", "milk")), 1000);

        registerBoth(finished, CosmoItems.CONDENSED_MILK_BUCKET.get(), Items.BUCKET, CosmoFluids.CONDENSED_MILK.get(), 1000);
        registerBoth(finished, CosmoItems.CONDENSED_MILK_BOTTLE.get(), Items.GLASS_BOTTLE, CosmoFluids.CONDENSED_MILK.get(), 250);
        registerBoth(finished, CosmoItems.CREAM_BUCKET.get(), Items.BUCKET, CosmoFluids.CREAM.get(), 1000);
        registerBoth(finished, CosmoItems.CREAM.get(), Items.BOWL, CosmoFluids.CREAM.get(), 250);

        registerFlavorRecipesWithoutMilkshake(finished, ItemRegistry.CherryIceCream.get(), null, CosmoFluids.CHERRY_ICE_CREAM.get(), CosmoCompat.SD);

        registerFlavorRecipesWithoutMilkshake(finished, ForgeRegistries.ITEMS.getValue(new ResourceLocation(CosmoCompat.RF, "green_tea_ice_cream")), null, CosmoFluids.GREEN_TEA_ICE_CREAM.get(), CosmoCompat.RF);
        registerFlavorRecipes(finished, ForgeRegistries.ITEMS.getValue(new ResourceLocation(CosmoCompat.RF, "yellow_tea_ice_cream")), null, CosmoFluids.YELLOW_TEA_ICE_CREAM.get(), CosmoCompat.RF);
        registerFlavorRecipesWithoutMilkshake(finished, ForgeRegistries.ITEMS.getValue(new ResourceLocation(CosmoCompat.RF, "black_tea_ice_cream")), null, CosmoFluids.BLACK_TEA_ICE_CREAM.get(), CosmoCompat.RF);
        registerFlavorRecipesWithoutMilkshake(finished, ForgeRegistries.ITEMS.getValue(new ResourceLocation(CosmoCompat.RF, "coffee_ice_cream")), null, CosmoFluids.COFFEE_ICE_CREAM.get(), CosmoCompat.RF);

        registerFlavorRecipes(finished, NeapolitanItems.VANILLA_ICE_CREAM.get(), NeapolitanItems.VANILLA_MILKSHAKE.get(), CosmoFluids.VANILLA_ICE_CREAM.get(), CosmoCompat.NEA);
        registerFlavorRecipes(finished, NeapolitanItems.STRAWBERRY_ICE_CREAM.get(), NeapolitanItems.STRAWBERRY_MILKSHAKE.get(), CosmoFluids.STRAWBERRY_ICE_CREAM.get(), CosmoCompat.NEA);
        registerFlavorRecipes(finished, NeapolitanItems.CHOCOLATE_ICE_CREAM.get(), NeapolitanItems.CHOCOLATE_MILKSHAKE.get(), CosmoFluids.CHOCOLATE_ICE_CREAM.get(), CosmoCompat.NEA);
        registerFlavorRecipes(finished, NeapolitanItems.BANANA_ICE_CREAM.get(), NeapolitanItems.BANANA_MILKSHAKE.get(), CosmoFluids.BANANA_ICE_CREAM.get(), CosmoCompat.NEA);
        registerFlavorRecipes(finished, NeapolitanItems.ADZUKI_ICE_CREAM.get(), NeapolitanItems.ADZUKI_MILKSHAKE.get(), CosmoFluids.ADZUKI_ICE_CREAM.get(), CosmoCompat.NEA);
        registerFlavorRecipes(finished, NeapolitanItems.MINT_ICE_CREAM.get(), NeapolitanItems.MINT_MILKSHAKE.get(), CosmoFluids.MINT_ICE_CREAM.get(), CosmoCompat.NEA);

        registerFlavorRecipes(finished, CosmoItems.APPLE_ICE_CREAM.get(), CosmoItems.APPLE_MILKSHAKE.get(), CosmoFluids.APPLE_ICE_CREAM.get(), CosmoCompat.NEA);
        registerFlavorRecipes(finished, CosmoItems.CARROT_ICE_CREAM.get(), CosmoItems.CARROT_MILKSHAKE.get(), CosmoFluids.CARROT_ICE_CREAM.get(), CosmoCompat.NEA);
        registerFlavorRecipes(finished, CosmoItems.GLOW_BERRY_ICE_CREAM.get(), CosmoItems.GLOW_BERRY_MILKSHAKE.get(), CosmoFluids.GLOW_BERRY_ICE_CREAM.get(), CosmoCompat.NEA);

        registerFlavorRecipes(finished, CosmoItems.ENCHANTED_FRUIT_ICE_CREAM.get(), CosmoItems.ENCHANTED_FRUIT_MILKSHAKE.get(), CosmoFluids.ENCHANTED_FRUIT_ICE_CREAM.get(), CosmoCompat.NEA, CosmoCompat.QUA);
        registerFlavorRecipes(finished, CosmoItems.SOURCE_BERRY_ICE_CREAM.get(), CosmoItems.SOURCE_BERRY_MILKSHAKE.get(), CosmoFluids.SOURCE_BERRY_ICE_CREAM.get(), CosmoCompat.NEA, CosmoCompat.AN);
        registerFlavorRecipes(finished, CosmoItems.KABLOOM_ICE_CREAM.get(), CosmoItems.KABLOOM_MILKSHAKE.get(), CosmoFluids.KABLOOM_ICE_CREAM.get(), CosmoCompat.NEA, CosmoCompat.HA);

        registerFlavorRecipes(finished, DelightfulItems.MATCHA_ICE_CREAM.get(), DelightfulItems.MATCHA_MILKSHAKE.get(), CosmoFluids.MATCHA_ICE_CREAM.get(), CosmoCompat.NEA, CosmoCompat.DF);
        registerFlavorRecipes(finished, DelightfulItems.SALMONBERRY_ICE_CREAM.get(), DelightfulItems.SALMONBERRY_MILKSHAKE.get(), CosmoFluids.SALMONBERRY_ICE_CREAM.get(), CosmoCompat.NEA, CosmoCompat.DF);

        registerFlavorRecipes(finished, CRItems.LIME_ICE_CREAM.get(), CRItems.LIME_MILKSHAKE.get(), CosmoFluids.LIME_ICE_CREAM.get(), CosmoCompat.NEA, CosmoCompat.CR);
        registerFlavorRecipes(finished, CRItems.POMEGRANATE_ICE_CREAM.get(), CRItems.POMEGRANATE_MILKSHAKE.get(), CosmoFluids.POMEGRANATE_ICE_CREAM.get(), CosmoCompat.NEA, CosmoCompat.CR);

        registerFlavorRecipes(finished, ForgeRegistries.ITEMS.getValue(new ResourceLocation(CosmoCompat.TFD, "aurora_ice_cream")), ForgeRegistries.ITEMS.getValue(new ResourceLocation(CosmoCompat.TFD, "aurora_milkshake")), CosmoFluids.AURORA_ICE_CREAM.get(), CosmoCompat.NEA, CosmoCompat.TFD);
        registerFlavorRecipes(finished, ForgeRegistries.ITEMS.getValue(new ResourceLocation(CosmoCompat.TFD, "glacier_ice_cream")), ForgeRegistries.ITEMS.getValue(new ResourceLocation(CosmoCompat.TFD, "glacier_milkshake")), CosmoFluids.GLACIER_ICE_CREAM.get(), CosmoCompat.NEA, CosmoCompat.TFD);
        registerFlavorRecipes(finished, ForgeRegistries.ITEMS.getValue(new ResourceLocation(CosmoCompat.TFD, "phytochemical_ice_cream")), ForgeRegistries.ITEMS.getValue(new ResourceLocation(CosmoCompat.TFD, "phytochemical_milkshake")), CosmoFluids.PHYTOCHEMICAL_ICE_CREAM.get(), CosmoCompat.NEA, CosmoCompat.TFD);
        registerFlavorRecipes(finished, ForgeRegistries.ITEMS.getValue(new ResourceLocation(CosmoCompat.TFD, "torchberry_ice_cream")), ForgeRegistries.ITEMS.getValue(new ResourceLocation(CosmoCompat.TFD, "torchberry_milkshake")), CosmoFluids.TORCHBERRY_ICE_CREAM.get(), CosmoCompat.NEA, CosmoCompat.TFD);

        registerFlavorRecipes(finished, ExquisitoItems.CHORUS_ICE_CREAM.get(), ExquisitoItems.CHORUS_MILKSHAKE.get(), CosmoFluids.CHORUS_FRUIT_ICE_CREAM.get(), CosmoCompat.EX);
        registerFlavorRecipes(finished, ExquisitoItems.WARZIPAN_ICE_CREAM.get(), ExquisitoItems.WARZIPAN_MILKSHAKE.get(), CosmoFluids.WARZIPAN_ICE_CREAM.get(), CosmoCompat.EX);
        registerFlavorRecipes(finished, ExquisitoItems.ETHER_BULB_ICE_CREAM.get(), ExquisitoItems.ETHER_BULB_MILKSHAKE.get(), CosmoFluids.STARCLOUD_ICE_CREAM.get(), CosmoCompat.EX);
        registerFlavorRecipes(finished, ExquisitoItems.NIGHTSHADE_BERRY_ICE_CREAM.get(), ExquisitoItems.NIGHTSHADE_BERRY_MILKSHAKE.get(), CosmoFluids.MIDNIGHT_ICE_CREAM.get(), CosmoCompat.EX);
        registerFlavorRecipes(finished, ExquisitoItems.JELLY_RING_ICE_CREAM.get(), ExquisitoItems.JELLY_RING_MILKSHAKE.get(), CosmoFluids.JELLY_RING_ICE_CREAM.get(), CosmoCompat.EX, CosmoCompat.EE);
        registerFlavorRecipes(finished, ExquisitoItems.ZURE_BERRY_ICE_CREAM.get(), ExquisitoItems.ZURE_BERRY_MILKSHAKE.get(), CosmoFluids.AZURE_BERRY_ICE_CREAM.get(), CosmoCompat.EX, CosmoCompat.EE);

        registerFlavorRecipes(finished, PeculiarsItems.ALOE_ICE_CREAM.get(), PeculiarsItems.ALOE_MILKSHAKE.get(), CosmoFluids.ALOE_ICE_CREAM.get(), CosmoCompat.PEC);
        registerFlavorRecipes(finished, PeculiarsItems.PASSIONFRUIT_ICE_CREAM.get(), PeculiarsItems.PASSIONFRUIT_MILKSHAKE.get(), CosmoFluids.PASSION_FRUIT_ICE_CREAM.get(), CosmoCompat.PEC);
        registerFlavorRecipes(finished, PeculiarsItems.YUCCA_ICE_CREAM.get(), PeculiarsItems.YUCCA_MILKSHAKE.get(), CosmoFluids.YUCCA_ICE_CREAM.get(), CosmoCompat.PEC);

        registerFlavorRecipes(finished, SeasonalsItems.BEETROOT_ICE_CREAM.get(), SeasonalsItems.BEETROOT_MILKSHAKE.get(), CosmoFluids.BEETROOT_ICE_CREAM.get(), CosmoCompat.SEA);
        registerFlavorRecipes(finished, SeasonalsItems.PUMPKIN_ICE_CREAM.get(), SeasonalsItems.PUMPKIN_MILKSHAKE.get(), CosmoFluids.PUMPKIN_ICE_CREAM.get(), CosmoCompat.SEA);
        registerFlavorRecipes(finished, SeasonalsItems.SWEET_BERRY_ICE_CREAM.get(), SeasonalsItems.SWEET_BERRY_MILKSHAKE.get(), CosmoFluids.SWEET_BERRY_ICE_CREAM.get(), CosmoCompat.SEA);

        //special thanks to Delightful...
        registerIceCreamInteraction(finished, NeapolitanItemTags.FRUITS_STRAWBERRY, CosmoFluids.STRAWBERRY_ICE_CREAM.get());
        registerIceCreamInteraction(finished, CosmoItemTags.CHOCOLATE, CosmoFluids.CHOCOLATE_ICE_CREAM.get());
        registerIceCreamInteraction(finished, NeapolitanItems.DRIED_VANILLA_PODS.get(), CosmoFluids.VANILLA_ICE_CREAM.get());
        registerIceCreamInteraction(finished, DelightfulItemTags.FRUITS_BANANA, CosmoFluids.BANANA_ICE_CREAM.get());
        registerIceCreamInteraction(finished, NeapolitanItems.MINT_LEAVES.get(), CosmoFluids.MINT_ICE_CREAM.get());
        registerIceCreamInteraction(finished, NeapolitanItems.ROASTED_ADZUKI_BEANS.get(), CosmoFluids.ADZUKI_ICE_CREAM.get());

        registerIceCreamInteraction(finished, CosmoItemTags.APPLE, CosmoFluids.APPLE_ICE_CREAM.get());
        registerIceCreamInteraction(finished, CosmoItemTags.CARROT, CosmoFluids.CARROT_ICE_CREAM.get());
        registerIceCreamInteraction(finished, CosmoItemTags.GLOW_BERRY, CosmoFluids.GLOW_BERRY_ICE_CREAM.get());

        registerIceCreamInteraction(finished, CosmoCompat.KABLOOM, CosmoFluids.KABLOOM_ICE_CREAM.get(), CosmoCompat.NEA, CosmoCompat.HA);
        registerIceCreamInteraction(finished, CosmoCompat.SOURCEBERRY, CosmoFluids.SOURCE_BERRY_ICE_CREAM.get(), CosmoCompat.NEA, CosmoCompat.AN);
        registerIceCreamInteraction(finished, ForgeRegistries.ITEMS.getValue(new ResourceLocation(CosmoCompat.QUA, "ancient_fruit")), CosmoFluids.ENCHANTED_FRUIT_ICE_CREAM.get(), CosmoCompat.NEA, CosmoCompat.QUA);

        registerIceCreamInteraction(finished, SeasonalsItems.ROASTED_BEETROOT.get(), CosmoFluids.BEETROOT_ICE_CREAM.get(), CosmoCompat.SEA);
        registerIceCreamInteraction(finished, SeasonalsItems.PUMPKIN_PUREE.get(), CosmoFluids.PUMPKIN_ICE_CREAM.get(), CosmoCompat.SEA);
        registerIceCreamInteraction(finished, CosmoItemTags.SWEET_BERRY, CosmoFluids.SWEET_BERRY_ICE_CREAM.get(), CosmoCompat.SEA);

        registerIceCreamInteraction(finished, AtmosphericItems.ALOE_LEAVES.get(), CosmoFluids.ALOE_ICE_CREAM.get(), CosmoCompat.PEC);
        registerIceCreamInteraction(finished, AtmosphericItemTags.FRUITS_PASSION_FRUIT, CosmoFluids.PASSION_FRUIT_ICE_CREAM.get(), CosmoCompat.PEC);
        registerIceCreamInteraction(finished, AtmosphericItems.YUCCA_FRUIT.get(), CosmoFluids.YUCCA_ICE_CREAM.get(), CosmoCompat.PEC);

        registerIceCreamInteraction(finished, CosmoItemTags.CHORUS, CosmoFluids.CHORUS_FRUIT_ICE_CREAM.get(), CosmoCompat.EX);
        registerIceCreamInteraction(finished, ExquisitoItems.WARZIPAN.get(), CosmoFluids.WARZIPAN_ICE_CREAM.get(), CosmoCompat.EX);
        registerIceCreamInteraction(finished, ExquisitoItemTags.MIDNIGHT_INGREDIENTS, CosmoFluids.MIDNIGHT_ICE_CREAM.get(), CosmoCompat.EX);
        registerIceCreamInteraction(finished, ExquisitoItemTags.STARCLOUD_INGREDIENTS, CosmoFluids.STARCLOUD_ICE_CREAM.get(), CosmoCompat.EX);
        registerIceCreamInteraction(finished, ExquisitoItems.JELLY_RING.get(), CosmoFluids.JELLY_RING_ICE_CREAM.get(), CosmoCompat.EX, CosmoCompat.EE);
        registerIceCreamInteraction(finished, ForgeRegistries.ITEMS.getValue(new ResourceLocation(CosmoCompat.EE, "azure_berries")), CosmoFluids.AZURE_BERRY_ICE_CREAM.get(), CosmoCompat.EX, CosmoCompat.EE);

        registerIceCreamInteraction(finished, DelightfulItemTags.MATCHA, CosmoFluids.MATCHA_ICE_CREAM.get(), CosmoCompat.NEA, CosmoCompat.DF);
        registerIceCreamInteraction(finished, DelightfulItemTags.FRUITS_SALMONBERRIES, CosmoFluids.SALMONBERRY_ICE_CREAM.get(), CosmoCompat.NEA, CosmoCompat.DF);
        registerIceCreamInteraction(finished, DelightfulItemTags.FRUITS_LIME, CosmoFluids.LIME_ICE_CREAM.get(), CosmoCompat.NEA, CosmoCompat.CR);
        registerIceCreamInteraction(finished, DelightfulItemTags.FRUITS_POMEGRANATE, CosmoFluids.POMEGRANATE_ICE_CREAM.get(), CosmoCompat.NEA, CosmoCompat.CR);

        registerIceCreamInteraction(finished, TFItems.TORCHBERRIES.get(), CosmoFluids.TORCHBERRY_ICE_CREAM.get(), CosmoCompat.NEA, CosmoCompat.TFD);

        registerIceCreamInteraction(finished, FRItems.GREEN_TEA_LEAVES.get(), CosmoFluids.GREEN_TEA_ICE_CREAM.get(), CosmoCompat.NEA, CosmoCompat.RF);
        registerIceCreamInteraction(finished, FRItems.YELLOW_TEA_LEAVES.get(), CosmoFluids.YELLOW_TEA_ICE_CREAM.get(), CosmoCompat.NEA, CosmoCompat.RF);
        registerIceCreamInteraction(finished, FRItems.BLACK_TEA_LEAVES.get(), CosmoFluids.BLACK_TEA_ICE_CREAM.get(), CosmoCompat.NEA, CosmoCompat.RF);
        registerIceCreamInteraction(finished, FRItems.COFFEE_BEANS.get(), CosmoFluids.COFFEE_ICE_CREAM.get(), CosmoCompat.NEA, CosmoCompat.RF);

        registerIceCreamInteraction(finished, CosmoItemTags.CHERRY, CosmoFluids.CHERRY_ICE_CREAM.get(), CosmoCompat.NEA, CosmoCompat.SD);
    }

    private void registerNineStorageRecipe(Consumer<FinishedRecipe> finished, ItemLike item, ItemLike result){
        ResourceLocation key = ForgeRegistries.ITEMS.getKey((Item) item);
        ResourceLocation resultKey = ForgeRegistries.BLOCKS.getKey(((Block) result));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, result)
                .define('A', item)
                .pattern("AAA").pattern("AAA").pattern("AAA")
                .unlockedBy("has_" + key, has(item)).save(finished);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, item, 9)
                .requires(result)
                .unlockedBy("has_" + resultKey, has(result)).save(finished);
    }

    private void registerFourStorageRecipe(Consumer<FinishedRecipe> finished, ItemLike item, ItemLike result){
        ResourceLocation key = ForgeRegistries.ITEMS.getKey((Item) item);
        ResourceLocation resultKey = ForgeRegistries.BLOCKS.getKey(((Block) result));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, result)
                .define('A', item)
                .pattern("AA").pattern("AA")
                .unlockedBy("has_" + key, has(item)).save(finished);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, item, 4)
                .requires(result)
                .requires(Items.GLASS_BOTTLE).requires(Items.GLASS_BOTTLE).requires(Items.GLASS_BOTTLE).requires(Items.GLASS_BOTTLE)
                .unlockedBy("has_" + resultKey, has(result)).save(finished);
    }

    private void registerConeRecipe(Consumer<FinishedRecipe> finished, ItemLike item, ItemLike iceCream, ItemLike result) {
        ResourceLocation key = ForgeRegistries.ITEMS.getKey((Item) item);
        ResourceLocation iceCreamKey = ForgeRegistries.ITEMS.getKey((Item) iceCream);
        ResourceLocation resultKey = ForgeRegistries.ITEMS.getKey((Item) result);
        ResourceLocation id = new ResourceLocation(Cosmopolitan.MODID, "neapolitan/" + resultKey.getPath());
        ResourceLocation id2 = new ResourceLocation(Cosmopolitan.MODID, "neapolitan/" + resultKey.getPath() + "from_ice_cream");

        ShapelessRecipeBuilder builder = ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, result, 3)
                .requires(CosmoItems.WAFER_CONE.get())
                .requires(CosmoItems.WAFER_CONE.get())
                .requires(CosmoItems.WAFER_CONE.get())
                .requires(item)
                .requires(CosmoItemTags.MILK)
                .requires(DelightfulItemTags.ICE_CUBES)
                .requires(Items.SUGAR)
                .unlockedBy("has_" + key.getPath(), has(item));

        ShapelessRecipeBuilder builder2 = ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, result, 3)
                .requires(iceCream)
                .requires(CosmoItems.WAFER_CONE.get())
                .requires(CosmoItems.WAFER_CONE.get())
                .requires(CosmoItems.WAFER_CONE.get())
                .unlockedBy("has_" + iceCreamKey.getPath(), has(iceCream));

        ICondition[] conditions = {
                new ModLoadedCondition("neapolitan"),
                new ItemExistsCondition(key.toString()),
                new ItemExistsCondition(iceCreamKey.toString())
        };

        registerConditionalRecipe(finished, id, builder, conditions);
        registerConditionalRecipe(finished, id2, builder2, conditions);
    }

    private void registerConeRecipe (Consumer<FinishedRecipe> finished, TagKey<Item> item, ItemLike iceCream, ItemLike result) {
        ResourceLocation iceCreamKey = ForgeRegistries.ITEMS.getKey((Item) iceCream);
        ResourceLocation resultKey = ForgeRegistries.ITEMS.getKey((Item) result);
        ResourceLocation id = new ResourceLocation(Cosmopolitan.MODID, "neapolitan/" + resultKey.getPath());
        ResourceLocation id2 = new ResourceLocation(Cosmopolitan.MODID, "neapolitan/" + resultKey.getPath() + "from_ice_cream");

        ShapelessRecipeBuilder builder = ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, result, 3)
                .requires(CosmoItems.WAFER_CONE.get())
                .requires(CosmoItems.WAFER_CONE.get())
                .requires(CosmoItems.WAFER_CONE.get())
                .requires(item)
                .requires(CosmoItemTags.MILK)
                .requires(DelightfulItemTags.ICE_CUBES)
                .requires(Items.SUGAR)
                .unlockedBy("has_" + item, has(item));

        ShapelessRecipeBuilder builder2 = ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, result, 3)
                .requires(iceCream)
                .requires(CosmoItems.WAFER_CONE.get())
                .requires(CosmoItems.WAFER_CONE.get())
                .requires(CosmoItems.WAFER_CONE.get())
                .unlockedBy("has_" + iceCreamKey.getPath(), has(iceCream));

        ICondition[] conditions = {
                new ModLoadedCondition("neapolitan"),
                new NotCondition(new TagEmptyCondition(item.location())),
                new ItemExistsCondition(iceCreamKey.toString())
        };

        registerConditionalRecipe(finished, id, builder, conditions);
        registerConditionalRecipe(finished, id2, builder2, conditions);
    }

    private void registerFourBlocksRecipe (Consumer<FinishedRecipe> finished, ItemLike block, ItemLike result) {
        ResourceLocation key = ForgeRegistries.BLOCKS.getKey((Block) block);
        ResourceLocation resultKey = ForgeRegistries.BLOCKS.getKey((Block) result);
        ResourceLocation id = new ResourceLocation(Cosmopolitan.MODID, "neapolitan/block/" + resultKey.getPath());

        ShapedRecipeBuilder builder = ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, result, 4)
                .define('#', block)
                .pattern("##")
                .pattern("##")
                .unlockedBy("has_" + key.getPath(),has(block));

        ConditionalRecipe.builder()
                .addCondition(new ModLoadedCondition("neapolitan"))
                .addRecipe(consumer -> builder.save(consumer, id))
                .build(finished, id);
    }

    private void registerIceCreamBlocksRecipe (Consumer<FinishedRecipe> finished, ItemLike iceCream, ItemLike result) {
        ResourceLocation key = ForgeRegistries.ITEMS.getKey((Item) iceCream);
        ResourceLocation resultKey = ForgeRegistries.BLOCKS.getKey((Block) result);
        ResourceLocation id = new ResourceLocation(Cosmopolitan.MODID, "neapolitan/block/" + resultKey.getPath());

        ShapedRecipeBuilder builder = ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, result, 8)
                .define('A', Blocks.SNOW_BLOCK)
                .define('B', iceCream)
                .pattern("AAA")
                .pattern("ABA")
                .pattern("AAA")
                .unlockedBy("has_" + key.getPath(),has(iceCream));

        ConditionalRecipe.builder()
                .addCondition(new ModLoadedCondition("neapolitan"))
                .addRecipe(consumer -> builder.save(consumer, id))
                .build(finished, id);
    }

    private void registerIceCreamInteraction (Consumer<FinishedRecipe> finished, Item item, Fluid result) {
        registerTubInteraction(finished, modsLoaded(CosmoCompat.NEA), List.of(itemIngredient(item), fluidIngredient(CosmoFluids.CREAM.get(), 1)), resultFluid(result, 1), 1);
    }

    private void registerIceCreamInteraction (Consumer<FinishedRecipe> finished, Item item, Fluid result, String... conditions) {
        registerTubInteraction(finished, modsLoaded(conditions), List.of(itemIngredient(item), fluidIngredient(CosmoFluids.CREAM.get(), 1)), resultFluid(result, 1), 1);
    }

    private void registerIceCreamInteraction (Consumer<FinishedRecipe> finished, TagKey<Item> item, Fluid result) {
        registerTubInteraction(finished, modsLoaded(CosmoCompat.NEA), List.of(tagKeyIngredient(item), fluidIngredient(CosmoFluids.CREAM.get(), 1)), resultFluid(result, 1), 1);
    }

    private void registerIceCreamInteraction (Consumer<FinishedRecipe> finished, TagKey<Item> item, Fluid result, String... conditions) {
        registerTubInteraction(finished, modsLoaded(conditions), List.of(tagKeyIngredient(item), fluidIngredient(CosmoFluids.CREAM.get(), 1)), resultFluid(result, 1), 1);
    }

    private void registerTubInteraction(Consumer<FinishedRecipe> consumer, List<ICondition> conditions, List<JsonObject> ingredients, JsonObject result, int baseCount) {
        JsonObject json = new JsonObject();
        JsonArray condArr = new JsonArray();
        json.addProperty("type", "cosmopolitan:tub_interacting");

        if (!conditions.isEmpty()) {
            for (ICondition condition : conditions) {
                condArr.add(CraftingHelper.serialize(condition));
            }
            json.add("conditions", condArr);
        }

        JsonArray ingArr = new JsonArray();
        ingredients.forEach(ingArr::add);
        json.add("ingredient", ingArr);

        json.add("result", result);

        json.addProperty("baseCount", baseCount);
        json.addProperty("requiresCooling", true);

        ResourceLocation fluidId = new ResourceLocation(result.get("fluid").getAsString());
        String name = fluidId.getPath();
        ResourceLocation id = new ResourceLocation(Cosmopolitan.MODID, "tub_interacting/" + name);
        consumer.accept(new CustomFinishedRecipe(id, CosmoRecipes.TUB_INTERACTING_SERIALIZER.get(), json));
    }

    private void registerBoth(Consumer<FinishedRecipe> consumer, Item injectItem, Item emptyItem, Fluid fluid, int amount) {
        ResourceLocation injectKey = ForgeRegistries.ITEMS.getKey(injectItem);
        ResourceLocation emptyKey = ForgeRegistries.ITEMS.getKey(emptyItem);
        String name = Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(injectItem)).getPath();

        registerTubRecipe(
                consumer,
                name,
                CosmoRecipes.TUB_INJECT_SERIALIZER.get(),
                List.of(
                        new ItemExistsCondition(injectKey.toString()),
                        new ItemExistsCondition(emptyKey.toString())
                ),
                List.of(itemIngredient(injectItem)),
                List.of(
                        resultItem(emptyItem, 1),
                        resultFluid(fluid, amount)
                )
        );
        registerTubRecipe(
                consumer,
                name + "_extract",
                CosmoRecipes.TUB_EXTRACT_SERIALIZER.get(),
                List.of(
                        new ItemExistsCondition(injectKey.toString()),
                        new ItemExistsCondition(emptyKey.toString())
                ),
                List.of(
                        itemIngredient(emptyItem),
                        fluidIngredient(fluid, amount)
                ),
                List.of(resultItem(injectItem, 1))
        );
    }

    private void registerFlavorRecipesWithoutMilkshake(Consumer<FinishedRecipe> consumer, Item iceCreamItem, Item milkshakeItem, Fluid iceCreamFluid, String... modids) {
        String name = Objects.requireNonNull(ForgeRegistries.FLUIDS.getKey(iceCreamFluid)).getPath();
        List<ICondition> conds = modsLoaded(modids);

        registerTubRecipe(
                consumer,
                name,
                CosmoRecipes.TUB_EXTRACT_SERIALIZER.get(),
                conds,
                List.of(itemIngredient(Items.BOWL), fluidIngredient(iceCreamFluid, 750)),
                List.of(resultItem(iceCreamItem, 1))
        );
        registerTubRecipe(
                consumer,
                name,
                CosmoRecipes.TUB_INJECT_SERIALIZER.get(),
                conds,
                List.of(itemIngredient(iceCreamItem)),
                List.of(resultItem(Items.BOWL, 1), resultFluid(iceCreamFluid, 750))
        );

        String coneName = name + "_cone";
        Item coneItem = CosmoItems.WAFER_CONE.get();
        registerTubRecipe(
                consumer,
                coneName,
                CosmoRecipes.TUB_EXTRACT_SERIALIZER.get(),
                conds,
                List.of(itemIngredient(coneItem), fluidIngredient(iceCreamFluid, 250)),
                List.of(resultItem(ForgeRegistries.ITEMS.getValue(new ResourceLocation(Cosmopolitan.MODID, coneName)), 1))
        );
    }

    private void registerFlavorRecipes(Consumer<FinishedRecipe> consumer, Item iceCreamItem, Item milkshakeItem, Fluid iceCreamFluid, String... modids) {
        String name = Objects.requireNonNull(ForgeRegistries.FLUIDS.getKey(iceCreamFluid)).getPath();
        List<ICondition> conds = modsLoaded(modids);

        registerTubRecipe(
                consumer,
                name,
                CosmoRecipes.TUB_EXTRACT_SERIALIZER.get(),
                conds,
                List.of(itemIngredient(Items.BOWL), fluidIngredient(iceCreamFluid, 750)),
                List.of(resultItem(iceCreamItem, 1))
        );
        registerTubRecipe(
                consumer,
                name,
                CosmoRecipes.TUB_INJECT_SERIALIZER.get(),
                conds,
                List.of(itemIngredient(iceCreamItem)),
                List.of(resultItem(Items.BOWL, 1), resultFluid(iceCreamFluid, 750))
        );

        String coneName = name + "_cone";
        Item coneItem = CosmoItems.WAFER_CONE.get();
        registerTubRecipe(
                consumer,
                coneName,
                CosmoRecipes.TUB_EXTRACT_SERIALIZER.get(),
                conds,
                List.of(itemIngredient(coneItem), fluidIngredient(iceCreamFluid, 250)),
                List.of(resultItem(ForgeRegistries.ITEMS.getValue(new ResourceLocation(Cosmopolitan.MODID, coneName)), 1))
        );

        String shakeName = name + "_milkshake";
        registerTubRecipe(
                consumer,
                shakeName,
                CosmoRecipes.TUB_EXTRACT_SERIALIZER.get(),
                conds,
                List.of(tagIngredient("forge:milk/milk_bottle"), fluidIngredient(iceCreamFluid, 250)),
                List.of(resultItem(milkshakeItem, 1))
        );
    }

    private void registerTubRecipe(Consumer<FinishedRecipe> consumer, String name, RecipeSerializer<?> serializer, List<ICondition> conditions, List<JsonObject> ingredients, List<JsonObject> results) {
        JsonObject json = new JsonObject();
        JsonArray condArr = new JsonArray();
        if (!conditions.isEmpty()) {
            for (ICondition condition : conditions) {
                condArr.add(CraftingHelper.serialize(condition));
            }
            json.add("conditions", condArr);
        }
        JsonArray ingArr = new JsonArray();
        ingredients.forEach(ingArr::add);
        json.add("ingredient", ingArr.size() == 1 ? ingArr.get(0) : ingArr);
        JsonArray resArr = new JsonArray();
        results.forEach(resArr::add);
        json.add("result", resArr.size() == 1 ? resArr.get(0) : resArr);

        ResourceLocation id = new ResourceLocation(Cosmopolitan.MODID, (serializer == CosmoRecipes.TUB_EXTRACT_SERIALIZER.get() ? "tub_extracting/" : "tub_injecting/") + name);
        consumer.accept(new CustomFinishedRecipe(id, serializer, json));
    }

    private List<ICondition> modsLoaded(String... modids) {
        return Arrays.stream(modids)
                .map(ModLoadedCondition::new)
                .collect(Collectors.toList());
    }

    private JsonObject itemIngredient(Item item) {
        JsonObject obj = new JsonObject();
        obj.addProperty("item", Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(item)).toString());
        return obj;
    }

    private JsonObject tagIngredient(String tag) {
        JsonObject obj = new JsonObject();
        obj.addProperty("tag", tag);
        return obj;
    }

    private JsonObject tagKeyIngredient(TagKey<Item> tag) {
        JsonObject obj = new JsonObject();
        obj.addProperty("tag", tag.location().toString());
        return obj;
    }

    private JsonObject fluidIngredient(Fluid fluid, int amount) {
        JsonObject obj = new JsonObject();
        JsonObject fj = new JsonObject();
        fj.addProperty("name", Objects.requireNonNull(ForgeRegistries.FLUIDS.getKey(fluid)).toString());
        fj.addProperty("amount", amount);
        obj.add("fluid", fj);
        return obj;
    }

    private JsonObject resultItem(Item item, int count) {
        JsonObject obj = new JsonObject();
        obj.addProperty("item", Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(item)).toString());
        obj.addProperty("count", count);
        return obj;
    }

    private JsonObject resultFluid(Fluid fluid, int amount) {
        JsonObject obj = new JsonObject();
        obj.addProperty("fluid", Objects.requireNonNull(ForgeRegistries.FLUIDS.getKey(fluid)).toString());
        obj.addProperty("amount", amount);
        return obj;
    }

    private void registerConditionalRecipe(Consumer<FinishedRecipe> finished, ResourceLocation id, ShapelessRecipeBuilder builder, ICondition[] conditions) {
        ConditionalRecipe.Builder conditional = ConditionalRecipe.builder();
        for (ICondition condition : conditions) {
            conditional.addCondition(condition);
        }
        conditional.addRecipe(consumer -> builder.save(consumer, id))
                .build(finished, id);
    }

    private record CustomFinishedRecipe(ResourceLocation id, RecipeSerializer<?> serializer, JsonObject json) implements FinishedRecipe {
        @Override
            public void serializeRecipeData(JsonObject out) {
                out.addProperty("type", Objects.requireNonNull(ForgeRegistries.RECIPE_SERIALIZERS.getKey(serializer)).toString());
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


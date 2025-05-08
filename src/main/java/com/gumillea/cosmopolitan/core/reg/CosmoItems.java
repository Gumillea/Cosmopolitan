package com.gumillea.cosmopolitan.core.reg;

import com.gumillea.cosmopolitan.Cosmopolitan;
import com.gumillea.cosmopolitan.common.item.*;
import com.gumillea.cosmopolitan.core.util.CosmoCompat;
import com.sammy.minersdelight.setup.MDFoodValues;
import com.teamabnormals.blueprint.core.util.registry.ItemSubRegistryHelper;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.lang.reflect.Constructor;
import java.util.Objects;
import java.util.function.Supplier;

@Mod.EventBusSubscriber(modid = Cosmopolitan.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CosmoItems {
    public static final ItemSubRegistryHelper HELPER = Cosmopolitan.REGISTRY_HELPER.getItemSubHelper();

    //general
    public static final RegistryObject<Item> WILDBERRY = HELPER.createItem("wildberry", () -> new Item(new Item.Properties().food(CosmopolitanFoods.WILDBERRY)));
    public static final RegistryObject<Item> BERRY_SYRUP_BOTTLE = HELPER.createItem("berry_syrup_bottle", () -> new DrinkItem(new Item.Properties().food(CosmopolitanFoods.BERRY_SYRUP_BOTTLE), true));
    public static final RegistryObject<Item> JELLY_ROLL = HELPER.createItem("jelly_roll", () -> new LongEatDurationItem(new Item.Properties().food(CosmopolitanFoods.JELLY_ROLL)));
    public static final RegistryObject<Item> CLASSIC_FRUIT_SALAD = HELPER.createItem("classic_fruit_salad", () -> new EffectBowlItem(new Item.Properties().food(CosmopolitanFoods.CLASSIC_FRUIT_SALAD).stacksTo(16).craftRemainder(Items.BOWL)));
    
    public static final RegistryObject<Item> CHOCOLATE_ROLL = HELPER.createItem("chocolate_roll", () -> new LongEatDurationItem(new Item.Properties().food(CosmopolitanFoods.CHOCOLATE_ROLL)));
    public static final RegistryObject<Item> INK_ROLL = HELPER.createItem("ink_roll", () -> new LongEatDurationItem(new Item.Properties().food(CosmopolitanFoods.INK_ROLL)));

    public static final RegistryObject<Item> FIDDLEHEAD = HELPER.createItem("fiddlehead", () -> new EffectItem(new Item.Properties().food(CosmopolitanFoods.FIDDLEHEAD)));
    public static final RegistryObject<Item> BAKED_FIDDLEHEAD = HELPER.createItem("baked_fiddlehead", () -> new Item(new Item.Properties().food(CosmopolitanFoods.BAKED_FIDDLEHEAD)));
    public static final RegistryObject<Item> IRON_FIDDLEHEAD = HELPER.createItem("iron_fiddlehead", () -> new LongEatDurationItem(new Item.Properties().food(CosmopolitanFoods.IRON_FIDDLEHEAD)));

    public static final RegistryObject<Item> WHEATGRASS = HELPER.createItem("wheatgrass", () -> new WheatgrassItem(new Item.Properties().food(CosmopolitanFoods.WHEATGRASS)));
    public static final RegistryObject<Item> PAW_COOKIE = HELPER.createItem("paw_cookie", () -> new WheatgrassItem(new Item.Properties().food(CosmopolitanFoods.PAW_COOKIE)));

    public static final RegistryObject<Item> CUT_POTATOES = HELPER.createItem("cut_potatoes", () -> new Item(new Item.Properties().food(CosmopolitanFoods.POTATO_SLICES)));
    public static final RegistryObject<Item> POTATO_WEDGES = HELPER.createItem("potato_wedges", () -> new Item(new Item.Properties().food(CosmopolitanFoods.BAKED_POTATO_SLICES)));
    public static final RegistryObject<Item> MASHED_POTATO = HELPER.createItem("mashed_potato", () -> new BowlFoodItem(new Item.Properties().stacksTo(16).food(CosmopolitanFoods.MASHED_POTATO).craftRemainder(Items.BOWL)));
    public static final RegistryObject<Item> MASHED_POTATO_CONE = HELPER.createItem("mashed_potato_cone", () -> new Item(new Item.Properties().food(CosmopolitanFoods.MASHED_POTATO_CONE)));

    public static final RegistryObject<Item> TOFFEE_APPLE = HELPER.createItem("toffee_apple", () -> new EffectItem(new Item.Properties().food(CosmopolitanFoods.TOFFEE_APPLE)));
    public static final RegistryObject<Item> TOFFEE_GOLDEN_APPLE = HELPER.createItem("toffee_golden_apple", () -> new EffectItem(new Item.Properties().food(CosmopolitanFoods.TOFFEE_GOLDEN_APPLE)));

    public static final RegistryObject<Item> WAFER = HELPER.createItem("wafer", () -> new Item(new Item.Properties().food(CosmopolitanFoods.WAFFLE)));
    public static final RegistryObject<Item> WAFER_CONE = HELPER.createItem("wafer_cone", () -> new Item(new Item.Properties().food(CosmopolitanFoods.WAFFLE)));
    public static final RegistryObject<Item> SNOW_CONE = HELPER.createItem("snow_cone", () -> new NeapolitanIceCreamItem(new Item.Properties().food(CosmopolitanFoods.SNOW_CONE), false, 80));

    public static final RegistryObject<Item> BIRCH_SAP_BOTTLE = HELPER.createItem("birch_sap_bottle", () -> new DrinkItem(new Item.Properties().food(CosmopolitanFoods.BIRCH_SAP_BOTTLE), true));

    public static final RegistryObject<Item> SPRING_SODA = HELPER.createItem("spring_soda", () -> new SeasonalDrinkItem(new Item.Properties().food(CosmopolitanFoods.DRINK), false, "spring"));
    public static final RegistryObject<Item> SUMMER_CORDIAL = HELPER.createItem("summer_cordial", () -> new SeasonalDrinkItem(new Item.Properties().food(CosmopolitanFoods.DRINK), false, "summer"));
    public static final RegistryObject<Item> AUTUMN_TEA = HELPER.createItem("autumn_tea", () -> new SeasonalDrinkItem(new Item.Properties().food(CosmopolitanFoods.DRINK), false, "autumn"));
    public static final RegistryObject<Item> WINTER_GLOGG = HELPER.createItem("winter_glogg", () -> new SeasonalDrinkItem(new Item.Properties().food(CosmopolitanFoods.DRINK), false, "winter"));

    public static final RegistryObject<Item> GULIME = HELPER.createItem("gulime", () -> new GulimeItem(new Item.Properties().food(CosmopolitanFoods.GULIME), true, CosmoItems.GULIME_SMALL));
    public static final RegistryObject<Item> GULIME_SMALL = HELPER.createItem("gulime_small", () -> new GulimeItem(new Item.Properties().food(CosmopolitanFoods.GULIME_SMALL), false, CosmoItems.GULIME));
    public static final RegistryObject<Item> UNDERGROUND_GULIME = HELPER.createItem("underground_gulime", () -> new GulimeItem(new Item.Properties().food(CosmopolitanFoods.UNDERGROUND_GULIME), true, CosmoItems.UNDERGROUND_GULIME_SMALL));
    public static final RegistryObject<Item> UNDERGROUND_GULIME_SMALL = HELPER.createItem("underground_gulime_small", () -> new GulimeItem(new Item.Properties().food(CosmopolitanFoods.UNDERGROUND_GULIME_SMALL), false, CosmoItems.UNDERGROUND_GULIME));
    public static final RegistryObject<Item> TAIGA_GULIME = HELPER.createItem("taiga_gulime", () -> new GulimeItem(new Item.Properties().food(CosmopolitanFoods.TAIGA_GULIME), true, CosmoItems.TAIGA_GULIME_SMALL));
    public static final RegistryObject<Item> TAIGA_GULIME_SMALL = HELPER.createItem("taiga_gulime_small", () -> new GulimeItem(new Item.Properties().food(CosmopolitanFoods.TAIGA_GULIME_SMALL), false, CosmoItems.TAIGA_GULIME));
    public static final RegistryObject<Item> CHORUS_GULIME = HELPER.createItem("chorus_gulime", () -> new GulimeItem(new Item.Properties().food(CosmopolitanFoods.CHORUS_GULIME), true, CosmoItems.CHORUS_GULIME_SMALL));
    public static final RegistryObject<Item> CHORUS_GULIME_SMALL = HELPER.createItem("chorus_gulime_small", () -> new GulimeItem(new Item.Properties().food(CosmopolitanFoods.CHORUS_GULIME_SMALL), false, CosmoItems.CHORUS_GULIME));
    public static final RegistryObject<Item> GLIMMERING_GULIME = HELPER.createItem("glimmering_gulime", () -> new GulimeItem(new Item.Properties().food(CosmopolitanFoods.GLIMMERING_GULIME), true, CosmoItems.GLIMMERING_GULIME_SMALL));
    public static final RegistryObject<Item> GLIMMERING_GULIME_SMALL = HELPER.createItem("glimmering_gulime_small", () -> new GulimeItem(new Item.Properties().food(CosmopolitanFoods.GLIMMERING_GULIME_SMALL), false, CosmoItems.GLIMMERING_GULIME));
    public static final RegistryObject<Item> STRAWBERRY_GULIME = HELPER.createItem("strawberry_gulime", () -> new GulimeItem(new Item.Properties().food(CosmopolitanFoods.GULIME), true, CosmoItems.STRAWBERRY_GULIME_SMALL));
    public static final RegistryObject<Item> STRAWBERRY_GULIME_SMALL = HELPER.createItem("strawberry_gulime_small", () -> new GulimeItem(new Item.Properties().food(CosmopolitanFoods.GULIME_SMALL), false, CosmoItems.STRAWBERRY_GULIME));

    //farmersdelight
    public static final RegistryObject<Item> POTATO_PANCAKES = HELPER.createItem("potato_pancakes", () -> new Item(new Item.Properties().food(CosmopolitanFoods.POTATO_PANCAKES)));
    public static final RegistryObject<Item> GREEN_SAUCE = HELPER.createItem("green_sauce", () -> new BowlFoodItem(new Item.Properties().food(CosmopolitanFoods.GREEN_SAUCE)));
    public static final RegistryObject<Item> GREEN_CREAM_STEW = HELPER.createItem("green_cream_stew", () -> new EffectBowlItem(new Item.Properties().food(CosmopolitanFoods.GREEN_STEW).stacksTo(16)));
    public static final RegistryObject<Item> GREEN_PASTA = HELPER.createItem("green_pasta", () -> new EffectBowlItem(new Item.Properties().food(CosmopolitanFoods.GREEN_PASTA).stacksTo(16)));

    public static final RegistryObject<Item> JELLY_ROLL_SLICE = HELPER.createItem("jelly_roll_slice", () -> new Item(new Item.Properties().food(CosmopolitanFoods.JELLY_ROLL_SLICE)));
    public static final RegistryObject<Item> CHOCOLATE_ROLL_SLICE = HELPER.createItem("chocolate_roll_slice", () -> new EffectItem(new Item.Properties().food(CosmopolitanFoods.CHOCOLATE_ROLL_SLICE)));
    public static final RegistryObject<Item> INK_ROLL_SLICE = HELPER.createItem("ink_roll_slice", () -> new EffectItem(new Item.Properties().food(CosmopolitanFoods.INK_ROLL_SLICE)));

    //neapolitan
    public static final RegistryObject<Item> ADZUKI_ICE_CREAM_CONE = HELPER.createItem("adzuki_ice_cream_cone", () -> new NeapolitanIceCreamItem(new Item.Properties().food(CosmopolitanFoods.ADZUKI_ICE_CREAM_CONE), false, 80));
    public static final RegistryObject<Item> BANANA_ICE_CREAM_CONE = HELPER.createItem("banana_ice_cream_cone", () -> new NeapolitanIceCreamItem(new Item.Properties().food(CosmopolitanFoods.BANANA_ICE_CREAM_CONE), false, 80));
    public static final RegistryObject<Item> CHOCOLATE_ICE_CREAM_CONE = HELPER.createItem("chocolate_ice_cream_cone", () -> new NeapolitanIceCreamItem(new Item.Properties().food(CosmopolitanFoods.CHOCOLATE_ICE_CREAM_CONE), false, 80));
    public static final RegistryObject<Item> MINT_ICE_CREAM_CONE = HELPER.createItem("mint_ice_cream_cone", () -> new NeapolitanIceCreamItem(new Item.Properties().food(CosmopolitanFoods.MINT_ICE_CREAM_CONE), false, 80));
    public static final RegistryObject<Item> STRAWBERRY_ICE_CREAM_CONE = HELPER.createItem("strawberry_ice_cream_cone", () -> new NeapolitanStrawberryItem(new Item.Properties().food(CosmopolitanFoods.ICE_CREAM_CONE), false, 80, 1.0F));
    public static final RegistryObject<Item> VANILLA_ICE_CREAM_CONE = HELPER.createItem("vanilla_ice_cream_cone", () -> new NeapolitanIceCreamItem(new Item.Properties().food(CosmopolitanFoods.VANILLA_ICE_CREAM_CONE), false, 80));
    public static final RegistryObject<Item> NEAPOLITAN_ICE_CREAM_SANDWICH = HELPER.createItem("neapolitan_ice_cream_sandwich", () -> new NeapolitanStrawberryItem(new Item.Properties().food(CosmopolitanFoods.NEAPOLITAN_ICE_CREAM_SANDWICH), false, 100, 1.0F));

    //exquisito
    public static final RegistryObject<Item> CHORUS_ICE_CREAM_CONE = HELPER.createItem("chorus_fruit_ice_cream_cone", () -> new NeapolitanIceCreamItem(new Item.Properties().food(CosmopolitanFoods.CHORUS_ICE_CREAM_CONE), false, 80));
    public static final RegistryObject<Item> WARZIPAN_ICE_CREAM_CONE = HELPER.createItem("warzipan_ice_cream_cone", () -> new NeapolitanIceCreamItem(new Item.Properties().food(CosmopolitanFoods.WARZIPAN_ICE_CREAM_CONE), false, 80));
    public static final RegistryObject<Item> MIDNIGHT_ICE_CREAM_CONE = HELPER.createItem("midnight_ice_cream_cone", () -> new NeapolitanIceCreamItem(new Item.Properties().food(CosmopolitanFoods.MIDNIGHT_ICE_CREAM_CONE), false, 80));
    public static final RegistryObject<Item> STARCLOUD_ICE_CREAM_CONE = HELPER.createItem("starcloud_ice_cream_cone", () -> new NeapolitanIceCreamItem(new Item.Properties().food(CosmopolitanFoods.STARCLOUD_ICE_CREAM_CONE), false, 80));
    public static final RegistryObject<Item> JELLY_RING_ICE_CREAM_CONE = HELPER.createItem("jelly_ring_ice_cream_cone", () -> new NeapolitanIceCreamItem(new Item.Properties().food(CosmopolitanFoods.JELLY_RING_ICE_CREAM_CONE), false, 80));
    public static final RegistryObject<Item> AZURE_BERRY_ICE_CREAM_CONE = HELPER.createItem("azure_berry_ice_cream_cone", () -> new NeapolitanIceCreamItem(new Item.Properties().food(CosmopolitanFoods.AZURE_BERRY_ICE_CREAM_CONE), false, 80));

    //peculiars
    public static final RegistryObject<Item> ALOE_ICE_CREAM_CONE = HELPER.createItem("aloe_ice_cream_cone", () -> new NeapolitanIceCreamItem(new Item.Properties().food(CosmopolitanFoods.ALOE_ICE_CREAM_CONE), false, 80));
    public static final RegistryObject<Item> PASSION_FRUIT_ICE_CREAM_CONE = HELPER.createItem("passion_fruit_ice_cream_cone", () -> new NeapolitanIceCreamItem(new Item.Properties().food(CosmopolitanFoods.PASSION_FRUIT_ICE_CREAM_CONE), false, 80));
    public static final RegistryObject<Item> YUCCA_ICE_CREAM_CONE = HELPER.createItem("yucca_ice_cream_cone", () -> new NeapolitanIceCreamItem(new Item.Properties().food(CosmopolitanFoods.YUCCA_ICE_CREAM_CONE), false, 80));
    public static final RegistryObject<Item> PECULIAR_ICE_CREAM = HELPER.createItem("peculiar_ice_cream", () -> new NeapolitanIceCreamItem(new Item.Properties().food(CosmopolitanFoods.PECULIAR_ICE_CREAM).craftRemainder(Items.BOWL), true, 200));
    public static final RegistryObject<Item> PECULIAR_ICE_CREAM_SANDWICH = HELPER.createItem("peculiar_ice_cream_sandwich", () -> new NeapolitanIceCreamItem(new Item.Properties().food(CosmopolitanFoods.PECULIAR_ICE_CREAM_SANDWICH), false, 100));

    //seasonals
    public static final RegistryObject<Item> BEETROOT_ICE_CREAM_CONE = HELPER.createItem("beetroot_ice_cream_cone", () -> new NeapolitanIceCreamItem(new Item.Properties().food(CosmopolitanFoods.BEETROOT_ICE_CREAM_CONE), false, 80));
    public static final RegistryObject<Item> PUMPKIN_ICE_CREAM_CONE = HELPER.createItem("pumpkin_ice_cream_cone", () -> new NeapolitanIceCreamItem(new Item.Properties().food(CosmopolitanFoods.PUMPKIN_ICE_CREAM_CONE), false, 80));
    public static final RegistryObject<Item> SWEET_BERRY_ICE_CREAM_CONE = HELPER.createItem("sweet_berry_ice_cream_cone", () -> new NeapolitanIceCreamItem(new Item.Properties().food(CosmopolitanFoods.SWEET_BERRY_ICE_CREAM_CONE), false, 80));
    public static final RegistryObject<Item> SEASONAL_ICE_CREAM = HELPER.createItem("seasonal_ice_cream", () -> new NeapolitanIceCreamItem(new Item.Properties().food(CosmopolitanFoods.SEASONAL_ICE_CREAM).craftRemainder(Items.BOWL), true, 200));
    public static final RegistryObject<Item> SEASONAL_ICE_CREAM_SANDWICH = HELPER.createItem("seasonal_ice_cream_sandwich", () -> new NeapolitanIceCreamItem(new Item.Properties().food(CosmopolitanFoods.SEASONAL_ICE_CREAM_SANDWICH), false, 100));

    //neapolitan x vanilla
    public static final RegistryObject<Item> APPLE_ICE_CREAM = HELPER.createItem("apple_ice_cream", () -> new NeapolitanIceCreamItem(new Item.Properties().food(CosmopolitanFoods.APPLE_ICE_CREAM).craftRemainder(Items.BOWL), true, 200));
    public static final RegistryObject<Item> APPLE_ICE_CREAM_CONE = HELPER.createItem("apple_ice_cream_cone", () -> new NeapolitanIceCreamItem(new Item.Properties().food(CosmopolitanFoods.APPLE_ICE_CREAM_CONE), false, 80));
    public static final RegistryObject<Item> CARROT_ICE_CREAM = HELPER.createItem("carrot_ice_cream", () -> new NeapolitanIceCreamItem(new Item.Properties().food(CosmopolitanFoods.CARROT_ICE_CREAM).craftRemainder(Items.BOWL), true, 200));
    public static final RegistryObject<Item> CARROT_ICE_CREAM_CONE = HELPER.createItem("carrot_ice_cream_cone", () -> new NeapolitanIceCreamItem(new Item.Properties().food(CosmopolitanFoods.CARROT_ICE_CREAM_CONE), false, 80));
    public static final RegistryObject<Item> GLOW_BERRY_ICE_CREAM = HELPER.createItem("glow_berry_ice_cream", () -> new NeapolitanIceCreamItem(new Item.Properties().food(CosmopolitanFoods.GLOW_BERRY_ICE_CREAM).craftRemainder(Items.BOWL), true, 200));
    public static final RegistryObject<Item> GLOW_BERRY_ICE_CREAM_CONE = HELPER.createItem("glow_berry_ice_cream_cone", () -> new NeapolitanIceCreamItem(new Item.Properties().food(CosmopolitanFoods.GLOW_BERRY_ICE_CREAM_CONE), false, 80));
    public static final RegistryObject<Item> CLASSIC_ICE_CREAM = HELPER.createItem("classic_ice_cream", () -> new NeapolitanIceCreamItem(new Item.Properties().food(CosmopolitanFoods.CLASSIC_ICE_CREAM), true, 200));
    public static final RegistryObject<Item> CLASSIC_ICE_CREAM_SANDWICH = HELPER.createItem("classic_ice_cream_sandwich", () -> new NeapolitanIceCreamItem(new Item.Properties().food(CosmopolitanFoods.CLASSIC_ICE_CREAM_SANDWICH), false, 100));

    //ars_nouveau
    public static final RegistryObject<Item> MENDOSTEEN_TART = HELPER.createItem("mendosteen_tart", () -> new EffectItem(new Item.Properties().food(CosmopolitanFoods.MENDOSTEEN_TART)));

    //abnormals x ars_nouveau
    public static final RegistryObject<Item> SOURCE_BERRY_PIPS = HELPER.createItem("source_berry_pips", () -> new SourceBerryPipsItem(CosmoCompat.SOURCE_BERRY_BLOCK, new Item.Properties()));

    public static final RegistryObject<Item> SOURCE_BERRY_ICE_CREAM = HELPER.createItem("source_berry_ice_cream", () -> new NeapolitanIceCreamItem(new Item.Properties().food(CosmopolitanFoods.SOURCE_BERRY_ICE_CREAM).craftRemainder(Items.BOWL), true, 200));
    public static final RegistryObject<Item> SOURCE_BERRY_ICE_CREAM_CONE = HELPER.createItem("source_berry_ice_cream_cone", () -> new NeapolitanIceCreamItem(new Item.Properties().food(CosmopolitanFoods.SOURCE_BERRY_ICE_CREAM_CONE), false, 80));

    //neapolitan x delightful
    public static final RegistryObject<Item> MATCHA_ICE_CREAM_CONE = HELPER.createItem("matcha_ice_cream_cone", () -> new NeapolitanIceCreamItem(new Item.Properties().food(CosmopolitanFoods.MATCHA_ICE_CREAM_CONE), false, 80));
    public static final RegistryObject<Item> SALMONBERRY_ICE_CREAM_CONE = HELPER.createItem("salmonberry_ice_cream_cone", () -> new NeapolitanIceCreamItem(new Item.Properties().food(CosmopolitanFoods.SALMONBERRY_ICE_CREAM_CONE), false, 80));

    //neapolitan x collectorsreap
    public static final RegistryObject<Item> LIME_ICE_CREAM_CONE = HELPER.createItem("lime_ice_cream_cone", () -> new NeapolitanIceCreamItem(new Item.Properties().food(CosmopolitanFoods.LIME_ICE_CREAM_CONE), false, 80));
    public static final RegistryObject<Item> POMEGRANATE_ICE_CREAM_CONE = HELPER.createItem("pomegranate_ice_cream_cone", () -> new NeapolitanIceCreamItem(new Item.Properties().food(CosmopolitanFoods.POMEGRANATE_ICE_CREAM_CONE), false, 80));

    //abnormals x habitat
    public static final RegistryObject<Item> KABLOOM_PIPS = HELPER.createItem("kabloom_pips", () -> new ItemNameBlockItem(CosmoCompat.KABLOOM_BLOCK, new Item.Properties()));

    public static final RegistryObject<Item> KABLOOM_ICE_CREAM = HELPER.createItem("kabloom_ice_cream", () -> new NeapolitanIceCreamItem(new Item.Properties().food(CosmopolitanFoods.KABLOOM_ICE_CREAM).craftRemainder(Items.BOWL), true, 200));
    public static final RegistryObject<Item> KABLOOM_ICE_CREAM_CONE = HELPER.createItem("kabloom_ice_cream_cone", () -> new NeapolitanIceCreamItem(new Item.Properties().food(CosmopolitanFoods.KABLOOM_ICE_CREAM_CONE), false, 80));

    //abnormals x undergarden
    public static final RegistryObject<Item> BLISTERBERRY_PIPS = HELPER.createItem("blisterberry_pips", () -> new ItemNameBlockItem(CosmoCompat.BLISTERBERRY_BUSH, new Item.Properties()));
    public static final RegistryObject<Item> SPROUTED_UNDERBEANS = HELPER.createItem("sprouted_underbeans", () -> new ItemNameBlockItem(CosmoCompat.UNDERBEAN_BUSH, new Item.Properties()));
    public static final RegistryObject<Item> DROOPFRUIT_PIPS = HELPER.createItem("droopfruit_pips", () -> new ItemNameBlockItem(CosmoCompat.DROOP_VINE, new Item.Properties()));
    public static final RegistryObject<Item> BLISTERBERRY_SORBET = HELPER.createItem("blisterberry_sorbet", () -> new NeapolitanIceCreamItem(new Item.Properties().food(CosmopolitanFoods.BLISTERBERRY_SORBET).craftRemainder(Items.BOWL), true, 200));
    public static final RegistryObject<Item> DROOPFRUIT_SORBET = HELPER.createItem("droopfruit_sorbet", () -> new NeapolitanIceCreamItem(new Item.Properties().food(CosmopolitanFoods.DROOPFRUIT_SORBET).craftRemainder(Items.BOWL), true, 200));

    //neapolitan x quark
    public static final RegistryObject<Item> ENCHANTED_FRUIT_ICE_CREAM = HELPER.createItem("enchanted_fruit_ice_cream", () -> new QuarkEnchantedFruitItem(new Item.Properties().food(CosmopolitanFoods.ICE_CREAM).craftRemainder(Items.BOWL), true, 200, 15));
    public static final RegistryObject<Item> ENCHANTED_FRUIT_ICE_CREAM_CONE = HELPER.createItem("enchanted_fruit_ice_cream_cone", () -> new QuarkEnchantedFruitItem(new Item.Properties().food(CosmopolitanFoods.ICE_CREAM_CONE), false, 80, 5));

    //twilight_forest
    public static final RegistryObject<Item> AURORA_KOHAKUTOU = HELPER.createItem("aurora_kohakutou", () -> new EffectItem(new Item.Properties().food(CosmopolitanFoods.AURORA_KOHAKUTOU)));
    public static final RegistryObject<Item> GLACIER_ESSENCE = HELPER.createItem("glacier_essence", () -> new NeapolitanIceCreamItem(new Item.Properties().food(CosmopolitanFoods.GLACIER_ESSENCE), false, 40));
    public static final RegistryObject<Item> STEELEAF_NECTAR = HELPER.createItem("steeleaf_nectar", () -> new DrinkItem(new Item.Properties().food(CosmopolitanFoods.STEELEAF_NECTAR), true));

    //twilight_delight
    public static final RegistryObject<Item> AURORA_ICE_CREAM_CONE = HELPER.createItem("aurora_ice_cream_cone", () -> new NeapolitanIceCreamItem(new Item.Properties().food(CosmopolitanFoods.AURORA_ICE_CREAM_CONE), false, 80));
    public static final RegistryObject<Item> GLACIER_ICE_CREAM_CONE = HELPER.createItem("glacier_ice_cream_cone", () -> new NeapolitanIceCreamItem(new Item.Properties().food(CosmopolitanFoods.GLACIER_ICE_CREAM_CONE), false, 80));
    public static final RegistryObject<Item> PHYTOCHEMICAL_ICE_CREAM_CONE = HELPER.createItem("phytochemical_ice_cream_cone", () -> new NeapolitanIceCreamItem(new Item.Properties().food(CosmopolitanFoods.PHYTOCHEMICAL_ICE_CREAM_CONE), false, 80));
    public static final RegistryObject<Item> TORCHBERRY_ICE_CREAM_CONE = HELPER.createItem("torchberry_ice_cream_cone", () -> new NeapolitanIceCreamItem(new Item.Properties().food(CosmopolitanFoods.TORCHBERRY_ICE_CREAM_CONE), false, 80));
    public static final RegistryObject<Item> RAINBOW_ICE_CREAM_SANDWICH = HELPER.createItem("rainbow_ice_cream_sandwich", () -> new NeapolitanIceCreamItem(new Item.Properties().food(CosmopolitanFoods.RAINBOW_ICE_CREAM_SANDWICH), false, 80));
    public static final RegistryObject<Item> REFRESHING_ICE_CREAM_SANDWICH = HELPER.createItem("refreshing_ice_cream_sandwich", () -> new NeapolitanIceCreamItem(new Item.Properties().food(CosmopolitanFoods.REFRESHING_ICE_CREAM_SANDWICH), false, 80));
    public static final RegistryObject<Item> TWILIGHT_ICE_CREAM_SANDWICH = HELPER.createItem("twilight_ice_cream_sandwich", () -> new NeapolitanIceCreamItem(new Item.Properties().food(CosmopolitanFoods.TWILIGHT_ICE_CREAM_SANDWICH), false, 80));

    //undergarden
    public static final RegistryObject<Item> BLISTERBERRY_TART = HELPER.createItem("blisterberry_tart", () -> new EffectItem(new Item.Properties().food(CosmopolitanFoods.BLISTERBERRY_TART)));
    public static final RegistryObject<Item> BLISTERBERRY_DOUBLE_POPSICLE = HELPER.createItem("blisterberry_popsicle_double", () -> new FrozenDessertItem(new Item.Properties().food(CosmopolitanFoods.BLISTERBERRY_DOUBLE_POPSICLE), false, 160));
    public static final RegistryObject<Item> BLISTERBERRY_POPSICLE = HELPER.createItem("blisterberry_popsicle", () -> new FrozenDessertItem(new Item.Properties().food(CosmopolitanFoods.BLISTERBERRY_POPSICLE), false, 80));

    public static final RegistryObject<Item> RAINDROOP_CAKE = HELPER.createItem("raindroop_cake", () -> new EffectItem(new Item.Properties().food(CosmopolitanFoods.RAINDROOP_CAKE)));

    //cocktails
    public static final RegistryObject<Item> COSMOPOLITAN_COCKTAIL = HELPER.createItem("cosmopolitan_cocktail", () -> new CocktailItem(new Item.Properties().food(CosmopolitanFoods.DRINK)));
    public static final RegistryObject<Item> ENCHANTED_COSMOPOLITAN_COCKTAIL = HELPER.createItem("enchanted_cosmopolitan_cocktail", () -> new CocktailItem(new Item.Properties().food(CosmopolitanFoods.DRINK).stacksTo(1).rarity(Rarity.RARE)));

    //miners_delight
    public static final RegistryObject<Item> GREEN_CREAM_STEW_CUP = HELPER.createItem("green_cream_stew_cup", createCupItem(CosmopolitanFoods.GREEN_STEW));
    public static final RegistryObject<Item> JELLY_CUP = HELPER.createItem("jelly_cup", createCupItem(CosmopolitanFoods.VC_JELLY));
    public static final RegistryObject<Item> MAGMA_JELLY_CUP = HELPER.createItem("magma_jelly_cup", createCupItem(CosmopolitanFoods.VC_JELLY));

    public static Supplier<Item> createCupItem(FoodProperties food) {
        return () -> {
            if (CosmoCompat.mf) {
                try {
                    Class<?> cupClass = Class.forName("com.sammy.minersdelight.content.item.CopperCupFoodItem");
                    Constructor<?> constructor = cupClass.getConstructor(Item.Properties.class);
                    return (Item) constructor.newInstance(new Item.Properties().food(MDFoodValues.cupFoodProperties(food)).stacksTo(16).craftRemainder(Objects.requireNonNull(ForgeRegistries.ITEMS.getValue(new ResourceLocation(CosmoCompat.MF, "copper_cup")))));
                } catch (Exception e) {
                    throw new RuntimeException("Failed to create CopperCupItem", e);
                }
            } else {
                return new Item(new Item.Properties());
            }
        };
    }

    static class CosmopolitanFoods {
        //general
        public static final FoodProperties WILDBERRY = (new FoodProperties.Builder()).nutrition(2).fast().alwaysEat().build();
        public static final FoodProperties WHEATGRASS = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.5F).alwaysEat().build();
        public static final FoodProperties PAW_COOKIE = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.5F).build();

        public static final FoodProperties FIDDLEHEAD = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.4F).effect(() -> new MobEffectInstance(MobEffects.POISON, 100), 0.2F).fast().build();
        public static final FoodProperties IRON_FIDDLEHEAD = (new FoodProperties.Builder()).effect(() -> new MobEffectInstance(MobEffects.POISON, 200), 1).effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 200), 0.5F).build();
        public static final FoodProperties BAKED_FIDDLEHEAD = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.6F).fast().build();

        public static final FoodProperties BERRY_SYRUP_BOTTLE = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.1F).build();
        public static final FoodProperties JELLY_ROLL = (new FoodProperties.Builder()).nutrition(15).saturationMod(0.8F).build();
        public static final FoodProperties CHOCOLATE_ROLL = (new FoodProperties.Builder()).nutrition(15).saturationMod(0.8F).effect(() -> new MobEffectInstance(CosmoCompat.SUGAR_RUSH, 1800, 1), 1.0F).build();
        public static final FoodProperties INK_ROLL = (new FoodProperties.Builder()).nutrition(15).saturationMod(0.8F).effect(() -> new MobEffectInstance(MobEffects.GLOWING, 1200), 1.0F).build();
        public static final FoodProperties TOFFEE_APPLE = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.6F).effect(() -> new MobEffectInstance(CosmoEffects.EXUBERANT.get(), 1200), 1.0F).build();
        public static final FoodProperties TOFFEE_GOLDEN_APPLE = (new FoodProperties.Builder()).nutrition(6).saturationMod(1.2F).effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 100, 1), 1.0F).effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 2400, 0), 1.0F).alwaysEat().build();

        public static final FoodProperties POTATO_SLICES = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.3F).fast().build();
        public static final FoodProperties BAKED_POTATO_SLICES = (new FoodProperties.Builder()).nutrition(3).saturationMod(1F).fast().build();
        public static final FoodProperties MASHED_POTATO = (new FoodProperties.Builder()).nutrition(9).saturationMod(0.6F).build();
        public static final FoodProperties MASHED_POTATO_CONE = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.6F).build();

        public static final FoodProperties WAFFLE = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.2F).fast().build();
        public static final FoodProperties SNOW_CONE = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.6F).effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 200), 1.0F).build();

        public static final FoodProperties CLASSIC_FRUIT_SALAD = (new FoodProperties.Builder()).nutrition(7).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoEffects.EXUBERANT.get(), 1200), 1.0F).build();

        public static final FoodProperties BIRCH_SAP_BOTTLE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.1F).build();
        public static final FoodProperties DRINK = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.1F).build();

        public static final FoodProperties GULIME = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.1F).effect(() -> new MobEffectInstance(MobEffects.JUMP, 200), 1.0F).build();
        public static final FoodProperties GULIME_SMALL = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.1F).effect(() -> new MobEffectInstance(MobEffects.JUMP, 200), 1.0F).fast().build();
        public static final FoodProperties UNDERGROUND_GULIME = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.1F).effect(() -> new MobEffectInstance(MobEffects.JUMP, 200), 1.0F).effect(() -> new MobEffectInstance(CosmoEffects.TRACER.get(), 200), 1.0F).build();
        public static final FoodProperties UNDERGROUND_GULIME_SMALL = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.1F).effect(() -> new MobEffectInstance(MobEffects.JUMP, 200), 1.0F).effect(() -> new MobEffectInstance(CosmoEffects.TRACER.get(), 200), 1.0F).fast().build();
        public static final FoodProperties TAIGA_GULIME = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.1F).effect(() -> new MobEffectInstance(MobEffects.JUMP, 200), 1.0F).effect(() -> new MobEffectInstance(CosmoCompat.THORN_RESISTANCE, 200), 1.0F).build();
        public static final FoodProperties TAIGA_GULIME_SMALL = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.1F).effect(() -> new MobEffectInstance(MobEffects.JUMP, 200), 1.0F).effect(() -> new MobEffectInstance(CosmoCompat.THORN_RESISTANCE, 200), 1.0F).fast().build();
        public static final FoodProperties CHORUS_GULIME = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.1F).effect(() -> new MobEffectInstance(MobEffects.JUMP, 200), 1.0F).effect(() -> new MobEffectInstance(CosmoCompat.RESONANCE, 200), 1.0F).build();
        public static final FoodProperties CHORUS_GULIME_SMALL = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.1F).effect(() -> new MobEffectInstance(MobEffects.JUMP, 200), 1.0F).effect(() -> new MobEffectInstance(CosmoCompat.RESONANCE, 200), 1.0F).fast().build();
        public static final FoodProperties GLIMMERING_GULIME = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.1F).effect(() -> new MobEffectInstance(MobEffects.JUMP, 200), 1.0F).effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 200), 1.0F).build();
        public static final FoodProperties GLIMMERING_GULIME_SMALL = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.1F).effect(() -> new MobEffectInstance(MobEffects.JUMP, 200), 1.0F).effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 200), 1.0F).fast().build();

        //farmersdelight
        public static final FoodProperties POTATO_PANCAKES = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.8F).build();
        public static final FoodProperties GREEN_SAUCE = (new FoodProperties.Builder()).nutrition(4).saturationMod(1F).build();
        public static final FoodProperties GREEN_STEW = (new FoodProperties.Builder()).nutrition(12).saturationMod(0.8F).effect(() -> new MobEffectInstance(CosmoCompat.COMFORT, 6000), 1.0F).build();
        public static final FoodProperties GREEN_PASTA = (new FoodProperties.Builder()).nutrition(16).saturationMod(1.2F).effect(() -> new MobEffectInstance(CosmoCompat.NOURISHMENT, 6000), 1.0F).build();
        public static final FoodProperties JELLY_ROLL_SLICE = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.8F).build();
        public static final FoodProperties CHOCOLATE_ROLL_SLICE = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.8F).effect(() -> new MobEffectInstance(CosmoCompat.SUGAR_RUSH, 600, 1), 1.0F).build();
        public static final FoodProperties INK_ROLL_SLICE = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.8F).effect(() -> new MobEffectInstance(MobEffects.GLOWING, 400), 1.0F).build();

        //an
        public static final FoodProperties MENDOSTEEN_TART = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.5F).effect(() -> new MobEffectInstance(CosmoCompat.RECOVERY, 900), 1.0F).build();

        //ug
        public static final FoodProperties BLISTERBERRY_TART = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.5F).effect(() -> new MobEffectInstance(CosmoEffects.VARDOGER.get(), 500), 1.0F).build();
        public static final FoodProperties BLISTERBERRY_DOUBLE_POPSICLE = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.2F).effect(() -> new MobEffectInstance(CosmoEffects.VARDOGER.get(), 1000), 1.0F).build();
        public static final FoodProperties BLISTERBERRY_POPSICLE = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.2F).effect(() -> new MobEffectInstance(CosmoEffects.VARDOGER.get(), 500), 1.0F).fast().build();

        public static final FoodProperties RAINDROOP_CAKE = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.8F).effect(() -> new MobEffectInstance(CosmoEffects.ABYSMAL_TORCH.get(), -1, 1), 1.0F).build();

        //neapolitan
        public static final FoodProperties ICE_CREAM = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.3F).build();

        public static final FoodProperties BLISTERBERRY_SORBET = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoEffects.VARDOGER.get(), 1200), 1.0F).build();
        public static final FoodProperties DROOPFRUIT_SORBET = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoEffects.ABYSMAL_TORCH.get(), -1, 4), 1.0F).build();

        public static final FoodProperties APPLE_ICE_CREAM = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoEffects.EXUBERANT.get(), 600, 1), 1.0F).build();
        public static final FoodProperties CARROT_ICE_CREAM = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoEffects.CAROTENE.get(), 6000), 1.0F).build();
        public static final FoodProperties GLOW_BERRY_ICE_CREAM = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoEffects.TRACER.get(), 600, 2), 1.0F).build();

        public static final FoodProperties SOURCE_BERRY_ICE_CREAM = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoCompat.MANA_REGEN, 540, 2), 1.0F).build();
        public static final FoodProperties KABLOOM_ICE_CREAM = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoCompat.BLAST_ENDURANCE, 600, 2), 1.0F).build();

        public static final FoodProperties ICE_CREAM_CONE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.3F).build();
        public static final FoodProperties ADZUKI_ICE_CREAM_CONE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoCompat.HARMONY, 200), 1.0F).build();
        public static final FoodProperties BANANA_ICE_CREAM_CONE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoCompat.AGILITY, 400), 1.0F).build();
        public static final FoodProperties CHOCOLATE_ICE_CREAM_CONE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoCompat.SUGAR_RUSH, 200, 2), 1.0F).build();
        public static final FoodProperties MINT_ICE_CREAM_CONE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoCompat.BERSERKING, 550), 1.0F).build();
        public static final FoodProperties VANILLA_ICE_CREAM_CONE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoCompat.VANILLA_SCENT, 140), 1.0F).build();
        public static final FoodProperties NEAPOLITAN_ICE_CREAM_SANDWICH = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoCompat.SUGAR_RUSH, 200, 2), 1.0F).effect(() -> new MobEffectInstance(CosmoCompat.VANILLA_SCENT, 100), 1.0F).build();

        public static final FoodProperties APPLE_ICE_CREAM_CONE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoEffects.EXUBERANT.get(), 200), 1.0F).build();
        public static final FoodProperties CARROT_ICE_CREAM_CONE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoEffects.CAROTENE.get(), 2000), 1.0F).build();
        public static final FoodProperties GLOW_BERRY_ICE_CREAM_CONE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoEffects.TRACER.get(), 200, 2), 1.0F).build();
        public static final FoodProperties CLASSIC_ICE_CREAM = (new FoodProperties.Builder()).nutrition(12).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoEffects.EXUBERANT.get(), 1200, 1), 1.0F).effect(() -> new MobEffectInstance(CosmoEffects.CAROTENE.get(), 3000), 1.0F).effect(() -> new MobEffectInstance(CosmoEffects.TRACER.get(), 400, 2), 1.0F).build();
        public static final FoodProperties CLASSIC_ICE_CREAM_SANDWICH = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoEffects.EXUBERANT.get(), 1200), 1.0F).effect(() -> new MobEffectInstance(CosmoEffects.CAROTENE.get(), 1500), 1.0F).effect(() -> new MobEffectInstance(CosmoEffects.TRACER.get(), 200, 2), 1.0F).build();

        public static final FoodProperties CHORUS_ICE_CREAM_CONE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoCompat.RESONANCE_ICE_CREAM, 400), 1.0F).build();
        public static final FoodProperties WARZIPAN_ICE_CREAM_CONE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoCompat.MODULATION, 600), 1.0F).build();
        public static final FoodProperties JELLY_RING_ICE_CREAM_CONE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoCompat.FUCHSIA_GOO, 200), 1.0F).build();
        public static final FoodProperties AZURE_BERRY_ICE_CREAM_CONE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoCompat.SPACE_DIVING, 600, 2), 1.0F).build();
        public static final FoodProperties MIDNIGHT_ICE_CREAM_CONE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoCompat.MORGOTH, 200), 1.0F).build();
        public static final FoodProperties STARCLOUD_ICE_CREAM_CONE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoCompat.EARENDEL, 200, 2), 1.0F).build();

        public static final FoodProperties SWEET_BERRY_ICE_CREAM_CONE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoCompat.THORN_RESISTANCE_ICE_CREAM, 600), 1.0F).build();
        public static final FoodProperties PUMPKIN_ICE_CREAM_CONE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoCompat.STUFFED, 260), 1.0F).build();
        public static final FoodProperties BEETROOT_ICE_CREAM_CONE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoCompat.ROOTED, 260), 1.0F).build();
        public static final FoodProperties SEASONAL_ICE_CREAM = (new FoodProperties.Builder()).nutrition(12).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoCompat.STUFFED, 800), 1.0F).effect(() -> new MobEffectInstance(CosmoCompat.THORN_RESISTANCE_ICE_CREAM, 900), 1.0F).effect(() -> new MobEffectInstance(CosmoCompat.ROOTED, 800), 1.0F).build();
        public static final FoodProperties SEASONAL_ICE_CREAM_SANDWICH = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoCompat.STUFFED, 400), 1.0F).effect(() -> new MobEffectInstance(CosmoCompat.THORN_RESISTANCE_ICE_CREAM, 450), 1.0F).effect(() -> new MobEffectInstance(CosmoCompat.ROOTED, 400), 1.0F).build();

        public static final FoodProperties ALOE_ICE_CREAM_CONE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoCompat.RELIEF, 260, 2), 1.0F).build();
        public static final FoodProperties PASSION_FRUIT_ICE_CREAM_CONE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoCompat.SPITTING, 33, 2), 1.0F).build();
        public static final FoodProperties YUCCA_ICE_CREAM_CONE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoCompat.PERSISTENCE, 200, 2), 1.0F).build();
        public static final FoodProperties PECULIAR_ICE_CREAM = (new FoodProperties.Builder()).nutrition(12).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoCompat.RELIEF, 600, 1), 1.0F).effect(() -> new MobEffectInstance(CosmoCompat.PERSISTENCE, 400, 1), 1.0F).effect(() -> new MobEffectInstance(CosmoCompat.SPITTING, 100, 1), 1.0F).build();
        public static final FoodProperties PECULIAR_ICE_CREAM_SANDWICH = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoCompat.RELIEF, 300, 1), 1.0F).effect(() -> new MobEffectInstance(CosmoCompat.PERSISTENCE, 200, 1), 1.0F).effect(() -> new MobEffectInstance(CosmoCompat.SPITTING, 50, 1), 1.0F).build();

        public static final FoodProperties SOURCE_BERRY_ICE_CREAM_CONE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoCompat.MANA_REGEN, 180, 2), 1.0F).build();
        public static final FoodProperties KABLOOM_ICE_CREAM_CONE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoCompat.BLAST_ENDURANCE, 200, 2), 1.0F).build();

        public static final FoodProperties SALMONBERRY_ICE_CREAM_CONE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.3F).effect(() -> new MobEffectInstance(MobEffects.WATER_BREATHING, 200), 1.0F).build();
        public static final FoodProperties MATCHA_ICE_CREAM_CONE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.3F).effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 140), 1.0F).effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 160), 1.0F).build();

        public static final FoodProperties LIME_ICE_CREAM_CONE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoCompat.CORROSION, 400, 1), 1.0F).build();
        public static final FoodProperties POMEGRANATE_ICE_CREAM_CONE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoCompat.VOLATILITY, 540, 1), 1.0F).effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 160), 1.0F).build();

        public static final FoodProperties AURORA_KOHAKUTOU = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.6F).effect(() -> new MobEffectInstance(CosmoCompat.AURORA, 200), 1.0F).build();
        public static final FoodProperties GLACIER_ESSENCE = (new FoodProperties.Builder()).effect(() -> new MobEffectInstance(CosmoCompat.FROZEN_RANGE, 80), 1.0F).fast().build();
        public static final FoodProperties STEELEAF_NECTAR = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.2F).effect(() -> new MobEffectInstance(CosmoCompat.POISON_RANGE, 300), 1.0F).build();

        public static final FoodProperties AURORA_ICE_CREAM_CONE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoCompat.AURORA, 600), 1.0F).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 600, 2), 1.0F).effect(() -> new MobEffectInstance(MobEffects.JUMP, 600, 1), 1.0F).build();
        public static final FoodProperties GLACIER_ICE_CREAM_CONE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoCompat.FROZEN_RANGE, 600), 1.0F).build();
        public static final FoodProperties PHYTOCHEMICAL_ICE_CREAM_CONE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoCompat.POISON_RANGE, 600), 1.0F).build();
        public static final FoodProperties TORCHBERRY_ICE_CREAM_CONE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoCompat.FIRE_RANGE, 600), 1.0F).build();
        public static final FoodProperties RAINBOW_ICE_CREAM_SANDWICH = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoCompat.AURORA, 300), 1.0F).effect(() -> new MobEffectInstance(CosmoCompat.AGILITY, 300), 1.0F).effect(() -> new MobEffectInstance(CosmoCompat.HARMONY, 300), 1.0F).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 300, 2), 1.0F).effect(() -> new MobEffectInstance(MobEffects.JUMP, 300, 1), 1.0F).build();
        public static final FoodProperties REFRESHING_ICE_CREAM_SANDWICH = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoCompat.POISON_RANGE, 300), 1.0F).effect(() -> new MobEffectInstance(CosmoCompat.FROZEN_RANGE, 300), 1.0F).effect(() -> new MobEffectInstance(CosmoCompat.BERSERKING, 300), 1.0F).build();
        public static final FoodProperties TWILIGHT_ICE_CREAM_SANDWICH = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoCompat.FIRE_RANGE, 300), 1.0F).effect(() -> new MobEffectInstance(CosmoCompat.SUGAR_RUSH, 900), 1.0F).build();

        //vc
        public static final FoodProperties VC_JELLY = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.45F).effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 400), 1.0F).build();

    }

}


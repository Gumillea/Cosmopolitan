package com.gumillea.cosmopolitan.core.reg;

import com.gumillea.cosmopolitan.Cosmopolitan;
import com.gumillea.cosmopolitan.common.item.DrinkItem;
import com.gumillea.cosmopolitan.common.item.FrozenDessertItem;
import com.gumillea.cosmopolitan.common.item.NeapolitanStrawberryItem;
import com.gumillea.cosmopolitan.common.item.QuarkEnchantedFruitItem;
import com.gumillea.cosmopolitan.core.util.CosmoCompat;
import com.hollingsworth.arsnouveau.setup.registry.CreativeTabRegistry;
import com.teamabnormals.blueprint.core.util.item.CreativeModeTabContentsPopulator;
import com.teamabnormals.blueprint.core.util.registry.BlockSubRegistryHelper;
import com.teamabnormals.blueprint.core.util.registry.ItemSubRegistryHelper;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import twilightforest.init.TFCreativeTabs;
import vectorwing.farmersdelight.common.registry.ModCreativeTabs;

import java.util.function.Predicate;

import static net.minecraft.world.item.CreativeModeTabs.FOOD_AND_DRINKS;
import static net.minecraft.world.item.crafting.Ingredient.of;

@Mod.EventBusSubscriber(modid = Cosmopolitan.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CosmoItems {
    public static final ItemSubRegistryHelper HELPER = Cosmopolitan.REGISTRY_HELPER.getItemSubHelper();

    //general
    public static final RegistryObject<Item> SNAKEBERRY = HELPER.createItem("snakeberry", () -> new Item(new Item.Properties().food(CosmopolitanFoods.POTATO_SLICES)));
    public static final RegistryObject<Item> FIDDLEHEAD = HELPER.createItem("fiddlehead", () -> new Item(new Item.Properties().food(CosmopolitanFoods.POTATO_SLICES)));

    public static final RegistryObject<Item> CUT_POTATOES = HELPER.createItem("cut_potatoes", () -> new Item(new Item.Properties().food(CosmopolitanFoods.POTATO_SLICES)));
    public static final RegistryObject<Item> POTATO_WEDGES = HELPER.createItem("potato_wedges", () -> new Item(new Item.Properties().food(CosmopolitanFoods.BAKED_POTATO_SLICES)));
    public static final RegistryObject<Item> MASHED_POTATO = HELPER.createItem("mashed_potato", () -> new BowlFoodItem(new Item.Properties().stacksTo(16).food(CosmopolitanFoods.MASHED_POTATO).craftRemainder(Items.BOWL)));
    public static final RegistryObject<Item> MASHED_POTATO_CONE = HELPER.createItem("mashed_potato_cone", () -> new Item(new Item.Properties().food(CosmopolitanFoods.MASHED_POTATO_CONE)));

    public static final RegistryObject<Item> WAFER = HELPER.createItem("wafer", () -> new Item(new Item.Properties().food(CosmopolitanFoods.WAFFLE)));
    public static final RegistryObject<Item> WAFER_CONE = HELPER.createItem("wafer_cone", () -> new Item(new Item.Properties().food(CosmopolitanFoods.WAFFLE)));
    public static final RegistryObject<Item> SNOW_CONE = HELPER.createItem("snow_cone", () -> new FrozenDessertItem(new Item.Properties().food(CosmopolitanFoods.SNOW_CONE), false, 80));

    //farmersdelight
    public static final RegistryObject<Item> POTATO_PANCAKES = HELPER.createItem("potato_pancakes", () -> new Item(new Item.Properties().food(CosmopolitanFoods.POTATO_PANCAKES)));

    //neapolitan
    public static final RegistryObject<Item> ADZUKI_ICE_CREAM_CONE = HELPER.createItem("adzuki_ice_cream_cone", () -> new FrozenDessertItem(new Item.Properties().food(CosmopolitanFoods.ADZUKI_ICE_CREAM_CONE), false, 80));
    public static final RegistryObject<Item> BANANA_ICE_CREAM_CONE = HELPER.createItem("banana_ice_cream_cone", () -> new FrozenDessertItem(new Item.Properties().food(CosmopolitanFoods.BANANA_ICE_CREAM_CONE), false, 80));
    public static final RegistryObject<Item> CHOCOLATE_ICE_CREAM_CONE = HELPER.createItem("chocolate_ice_cream_cone", () -> new FrozenDessertItem(new Item.Properties().food(CosmopolitanFoods.CHOCOLATE_ICE_CREAM_CONE), false, 80));
    public static final RegistryObject<Item> MINT_ICE_CREAM_CONE = HELPER.createItem("mint_ice_cream_cone", () -> new FrozenDessertItem(new Item.Properties().food(CosmopolitanFoods.MINT_ICE_CREAM_CONE), false, 80));
    public static final RegistryObject<Item> STRAWBERRY_ICE_CREAM_CONE = HELPER.createItem("strawberry_ice_cream_cone", () -> new NeapolitanStrawberryItem(new Item.Properties().food(CosmopolitanFoods.ICE_CREAM_CONE), false, 80, 1.0F));
    public static final RegistryObject<Item> VANILLA_ICE_CREAM_CONE = HELPER.createItem("vanilla_ice_cream_cone", () -> new FrozenDessertItem(new Item.Properties().food(CosmopolitanFoods.VANILLA_ICE_CREAM_CONE), false, 80));
    public static final RegistryObject<Item> NEAPOLITAN_ICE_CREAM_SANDWICH = HELPER.createItem("neapolitan_ice_cream_sandwich", () -> new NeapolitanStrawberryItem(new Item.Properties().food(CosmopolitanFoods.NEAPOLITAN_ICE_CREAM_SANDWICH), false, 100, 1.0F));

    //exquisito
    public static final RegistryObject<Item> CHORUS_ICE_CREAM_CONE = HELPER.createItem("chorus_ice_cream_cone", () -> new FrozenDessertItem(new Item.Properties().food(CosmopolitanFoods.CHORUS_ICE_CREAM_CONE), false, 80));
    public static final RegistryObject<Item> WARZIPAN_ICE_CREAM_CONE = HELPER.createItem("warzipan_ice_cream_cone", () -> new FrozenDessertItem(new Item.Properties().food(CosmopolitanFoods.WARZIPAN_ICE_CREAM_CONE), false, 80));
    public static final RegistryObject<Item> MIDNIGHT_ICE_CREAM_CONE = HELPER.createItem("midnight_ice_cream_cone", () -> new FrozenDessertItem(new Item.Properties().food(CosmopolitanFoods.MIDNIGHT_ICE_CREAM_CONE), false, 80));
    public static final RegistryObject<Item> STARCLOUD_ICE_CREAM_CONE = HELPER.createItem("starcloud_ice_cream_cone", () -> new FrozenDessertItem(new Item.Properties().food(CosmopolitanFoods.STARCLOUD_ICE_CREAM_CONE), false, 80));
    public static final RegistryObject<Item> JELLY_RING_ICE_CREAM_CONE = HELPER.createItem("jelly_ring_ice_cream_cone", () -> new FrozenDessertItem(new Item.Properties().food(CosmopolitanFoods.JELLY_RING_ICE_CREAM_CONE), false, 80));
    public static final RegistryObject<Item> AZURE_BERRY_ICE_CREAM_CONE = HELPER.createItem("azure_berry_ice_cream_cone", () -> new FrozenDessertItem(new Item.Properties().food(CosmopolitanFoods.AZURE_BERRY_ICE_CREAM_CONE), false, 80));

    //seasonals
    public static final RegistryObject<Item> BEETROOT_ICE_CREAM_CONE = HELPER.createItem("beetroot_ice_cream_cone", () -> new FrozenDessertItem(new Item.Properties().food(CosmopolitanFoods.BEETROOT_ICE_CREAM_CONE), false, 80));
    public static final RegistryObject<Item> PUMPKIN_ICE_CREAM_CONE = HELPER.createItem("pumpkin_ice_cream_cone", () -> new FrozenDessertItem(new Item.Properties().food(CosmopolitanFoods.PUMPKIN_ICE_CREAM_CONE), false, 80));
    public static final RegistryObject<Item> SWEET_BERRY_ICE_CREAM_CONE = HELPER.createItem("sweet_berry_ice_cream_cone", () -> new FrozenDessertItem(new Item.Properties().food(CosmopolitanFoods.SWEET_BERRY_ICE_CREAM_CONE), false, 80));
    public static final RegistryObject<Item> SEASONAL_ICE_CREAM = HELPER.createItem("seasonal_ice_cream", () -> new FrozenDessertItem(new Item.Properties().food(CosmopolitanFoods.SEASONAL_ICE_CREAM).craftRemainder(Items.BOWL), true, 200));
    public static final RegistryObject<Item> SEASONAL_ICE_CREAM_SANDWICH = HELPER.createItem("seasonal_ice_cream_sandwich", () -> new FrozenDessertItem(new Item.Properties().food(CosmopolitanFoods.SEASONAL_ICE_CREAM_SANDWICH), false, 100));

    //neapolitan x vanilla
    public static final RegistryObject<Item> APPLE_ICE_CREAM = HELPER.createItem("apple_ice_cream", () -> new FrozenDessertItem(new Item.Properties().food(CosmopolitanFoods.APPLE_ICE_CREAM).craftRemainder(Items.BOWL), true, 200));
    public static final RegistryObject<Item> APPLE_ICE_CREAM_CONE = HELPER.createItem("apple_ice_cream_cone", () -> new FrozenDessertItem(new Item.Properties().food(CosmopolitanFoods.APPLE_ICE_CREAM_CONE), false, 80));
    public static final RegistryObject<Item> CARROT_ICE_CREAM = HELPER.createItem("carrot_ice_cream", () -> new FrozenDessertItem(new Item.Properties().food(CosmopolitanFoods.CARROT_ICE_CREAM).craftRemainder(Items.BOWL), true, 200));
    public static final RegistryObject<Item> CARROT_ICE_CREAM_CONE = HELPER.createItem("carrot_ice_cream_cone", () -> new FrozenDessertItem(new Item.Properties().food(CosmopolitanFoods.CARROT_ICE_CREAM_CONE), false, 80));
    public static final RegistryObject<Item> GLOW_BERRY_ICE_CREAM = HELPER.createItem("glow_berry_ice_cream", () -> new FrozenDessertItem(new Item.Properties().food(CosmopolitanFoods.GLOW_BERRY_ICE_CREAM).craftRemainder(Items.BOWL), true, 200));
    public static final RegistryObject<Item> GLOW_BERRY_ICE_CREAM_CONE = HELPER.createItem("glow_berry_ice_cream_cone", () -> new FrozenDessertItem(new Item.Properties().food(CosmopolitanFoods.GLOW_BERRY_ICE_CREAM_CONE), false, 80));

    //neapolitan x ars_nouveau
    public static final RegistryObject<Item> SOURCE_BERRY_PIPS = HELPER.createItem("source_berry_pips", () -> new ItemNameBlockItem(CosmoCompat.SOURCE_BERRY_BLOCK, new Item.Properties()));

    public static final RegistryObject<Item> SOURCE_BERRY_ICE_CREAM = HELPER.createItem("source_berry_ice_cream", () -> new FrozenDessertItem(new Item.Properties().food(CosmopolitanFoods.SOURCE_BERRY_ICE_CREAM).craftRemainder(Items.BOWL), true, 200));
    public static final RegistryObject<Item> SOURCE_BERRY_ICE_CREAM_CONE = HELPER.createItem("source_berry_ice_cream_cone", () -> new FrozenDessertItem(new Item.Properties().food(CosmopolitanFoods.SOURCE_BERRY_ICE_CREAM_CONE), false, 80));

    //neapolitan x habitat
    public static final RegistryObject<Item> KABLOOM_ICE_CREAM = HELPER.createItem("kabloom_ice_cream", () -> new FrozenDessertItem(new Item.Properties().food(CosmopolitanFoods.KABLOOM_ICE_CREAM).craftRemainder(Items.BOWL), true, 200));
    public static final RegistryObject<Item> KABLOOM_ICE_CREAM_CONE = HELPER.createItem("kabloom_ice_cream_cone", () -> new FrozenDessertItem(new Item.Properties().food(CosmopolitanFoods.KABLOOM_ICE_CREAM_CONE), false, 80));

    //neapolitan x quark
    public static final RegistryObject<Item> ENCHANTED_FRUIT_ICE_CREAM = HELPER.createItem("enchanted_fruit_ice_cream", () -> new QuarkEnchantedFruitItem(new Item.Properties().food(CosmopolitanFoods.ICE_CREAM).craftRemainder(Items.BOWL), true, 200, 15));
    public static final RegistryObject<Item> ENCHANTED_FRUIT_ICE_CREAM_CONE = HELPER.createItem("enchanted_fruit_ice_cream_cone", () -> new QuarkEnchantedFruitItem(new Item.Properties().food(CosmopolitanFoods.ICE_CREAM_CONE), false, 80, 5));

    //twilight_forest
    public static final RegistryObject<Item> AURORA_KOHAKUTOU = HELPER.createItem("aurora_kohakutou", () -> new Item(new Item.Properties().food(CosmopolitanFoods.AURORA_KOHAKUTOU)));
    public static final RegistryObject<Item> GLACIER_ESSENCE = HELPER.createItem("glacier_essence", () -> new FrozenDessertItem(new Item.Properties().food(CosmopolitanFoods.GLACIER_ESSENCE), false, 40));
    public static final RegistryObject<Item> STEELEAF_NECTAR = HELPER.createItem("steeleaf_nectar", () -> new DrinkItem(new Item.Properties().food(CosmopolitanFoods.STEELEAF_NECTAR)));

    //twilight_delight
    public static final RegistryObject<Item> AURORA_ICE_CREAM_CONE = HELPER.createItem("aurora_ice_cream_cone", () -> new FrozenDessertItem(new Item.Properties().food(CosmopolitanFoods.AURORA_ICE_CREAM_CONE), false, 80));
    public static final RegistryObject<Item> GLACIER_ICE_CREAM_CONE = HELPER.createItem("glacier_ice_cream_cone", () -> new FrozenDessertItem(new Item.Properties().food(CosmopolitanFoods.GLACIER_ICE_CREAM_CONE), false, 80));
    public static final RegistryObject<Item> PHYTOCHEMICAL_ICE_CREAM_CONE = HELPER.createItem("phytochemical_ice_cream_cone", () -> new FrozenDessertItem(new Item.Properties().food(CosmopolitanFoods.PHYTOCHEMICAL_ICE_CREAM_CONE), false, 80));
    public static final RegistryObject<Item> TORCHBERRY_ICE_CREAM_CONE = HELPER.createItem("torchberry_ice_cream_cone", () -> new FrozenDessertItem(new Item.Properties().food(CosmopolitanFoods.TORCHBERRY_ICE_CREAM_CONE), false, 80));
    public static final RegistryObject<Item> RAINBOW_ICE_CREAM_SANDWICH = HELPER.createItem("rainbow_ice_cream_sandwich", () -> new FrozenDessertItem(new Item.Properties().food(CosmopolitanFoods.TORCHBERRY_ICE_CREAM_CONE), false, 80));
    public static final RegistryObject<Item> REFRESHING_ICE_CREAM_SANDWICH = HELPER.createItem("refreshing_ice_cream_sandwich", () -> new FrozenDessertItem(new Item.Properties().food(CosmopolitanFoods.TORCHBERRY_ICE_CREAM_CONE), false, 80));
    public static final RegistryObject<Item> TWILIGHT_ICE_CREAM_SANDWICH = HELPER.createItem("twilight_ice_cream_sandwich", () -> new FrozenDessertItem(new Item.Properties().food(CosmopolitanFoods.TORCHBERRY_ICE_CREAM_CONE), false, 80));

    public static void setupTabEditors() {
        CreativeModeTabContentsPopulator.mod(Cosmopolitan.MODID)
                .tab(FOOD_AND_DRINKS)
                .addItemsAfter(modLoaded(Items.POTATO, CosmoCompat.FD), CUT_POTATOES)
                .addItemsAfter(modLoaded(Items.BAKED_POTATO, CosmoCompat.FD), POTATO_WEDGES)
                .addItemsAfter(of(Items.RABBIT_STEW), MASHED_POTATO)
                .addItemsBefore(of(Items.POTION), WAFER, WAFER_CONE, MASHED_POTATO_CONE, SNOW_CONE)

                .predicate(event -> (ModList.get().isLoaded(CosmoCompat.CAD) || ModList.get().isLoaded(CosmoCompat.FCD)) && event.getTabKey() == ModCreativeTabs.TAB_FARMERS_DELIGHT.getKey())
                .addItems(POTATO_PANCAKES)

                .predicate(event -> event.getTabKey() == FOOD_AND_DRINKS && ModList.get().isLoaded(CosmoCompat.NEA))
                .addItemsBefore(of(Items.POTION), APPLE_ICE_CREAM_CONE, CARROT_ICE_CREAM_CONE, GLOW_BERRY_ICE_CREAM_CONE, ADZUKI_ICE_CREAM_CONE, BANANA_ICE_CREAM_CONE, CHOCOLATE_ICE_CREAM_CONE, MINT_ICE_CREAM_CONE, STRAWBERRY_ICE_CREAM_CONE, VANILLA_ICE_CREAM_CONE, NEAPOLITAN_ICE_CREAM_SANDWICH)

                .addItemsBefore(of(Items.HONEY_BOTTLE), APPLE_ICE_CREAM, CARROT_ICE_CREAM, GLOW_BERRY_ICE_CREAM)

                .addItemsAfter(modLoaded(GLOW_BERRY_ICE_CREAM, CosmoCompat.AN), SOURCE_BERRY_ICE_CREAM)
                .addItemsAfter(modLoaded(GLOW_BERRY_ICE_CREAM, CosmoCompat.HA), KABLOOM_ICE_CREAM)
                .addItemsAfter(modLoaded(GLOW_BERRY_ICE_CREAM, CosmoCompat.QUA), ENCHANTED_FRUIT_ICE_CREAM)

                .addItemsAfter(modLoaded(VANILLA_ICE_CREAM_CONE, CosmoCompat.EX), CHORUS_ICE_CREAM_CONE, WARZIPAN_ICE_CREAM_CONE, MIDNIGHT_ICE_CREAM_CONE, STARCLOUD_ICE_CREAM_CONE, JELLY_RING_ICE_CREAM_CONE, AZURE_BERRY_ICE_CREAM_CONE)
                .addItemsAfter(modLoaded(VANILLA_ICE_CREAM_CONE, CosmoCompat.SEA), BEETROOT_ICE_CREAM_CONE, PUMPKIN_ICE_CREAM_CONE, SWEET_BERRY_ICE_CREAM_CONE, SEASONAL_ICE_CREAM)
                .addItemsAfter(modLoaded(VANILLA_ICE_CREAM_CONE, CosmoCompat.TFD), AURORA_ICE_CREAM_CONE, GLACIER_ICE_CREAM_CONE, PHYTOCHEMICAL_ICE_CREAM_CONE, TORCHBERRY_ICE_CREAM_CONE)
                .addItemsAfter(modLoaded(NEAPOLITAN_ICE_CREAM_SANDWICH, CosmoCompat.TFD), RAINBOW_ICE_CREAM_SANDWICH, REFRESHING_ICE_CREAM_SANDWICH, TWILIGHT_ICE_CREAM_SANDWICH)
                .addItemsAfter(modLoaded(NEAPOLITAN_ICE_CREAM_SANDWICH, CosmoCompat.SEA), SEASONAL_ICE_CREAM_SANDWICH)

                .addItemsAfter(modLoaded(VANILLA_ICE_CREAM_CONE, CosmoCompat.AN), SOURCE_BERRY_ICE_CREAM_CONE)
                .addItemsAfter(modLoaded(VANILLA_ICE_CREAM_CONE, CosmoCompat.HA), KABLOOM_ICE_CREAM_CONE)
                .addItemsAfter(modLoaded(VANILLA_ICE_CREAM_CONE, CosmoCompat.QUA), ENCHANTED_FRUIT_ICE_CREAM_CONE)

                .predicate(event -> ModList.get().isLoaded(CosmoCompat.TF) && event.getTabKey() == TFCreativeTabs.ITEMS.getKey())
                .addItemsFirst(AURORA_KOHAKUTOU, STEELEAF_NECTAR, GLACIER_ESSENCE)

                .predicate(event -> ModList.get().isLoaded(CosmoCompat.BG) && ModList.get().isLoaded(CosmoCompat.AN) && event.getTabKey() == CreativeTabRegistry.BLOCKS.getKey())
                .addItemsAfter(ofID(new ResourceLocation(CosmoCompat.AN, "magebloom_crop")), SOURCE_BERRY_PIPS)
        ;
    }

    public static Predicate<ItemStack> modLoaded(ItemLike item, String... modids) {
        return stack -> of(item).test(stack) && BlockSubRegistryHelper.areModsLoaded(modids);
    }

    public static Predicate<ItemStack> modLoaded(RegistryObject<Item> item, String... modids) {
        return stack -> {
            item.get();
            return of(item.get()).test(stack) && BlockSubRegistryHelper.areModsLoaded(modids);
        };
    }

    public static Predicate<ItemStack> ofID(ResourceLocation location, String... modids) {
        return stack -> (BlockSubRegistryHelper.areModsLoaded(modids) && of(ForgeRegistries.ITEMS.getValue(location)).test(stack));
    }

    static class CosmopolitanFoods {
        //general
        public static final FoodProperties POTATO_SLICES = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.3F).fast().build();
        public static final FoodProperties BAKED_POTATO_SLICES = (new FoodProperties.Builder()).nutrition(3).saturationMod(1F).fast().build();
        public static final FoodProperties MASHED_POTATO = (new FoodProperties.Builder()).nutrition(9).saturationMod(0.6F).build();
        public static final FoodProperties MASHED_POTATO_CONE = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.6F).build();
        public static final FoodProperties WAFFLE = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.2F).fast().build();
        public static final FoodProperties SNOW_CONE = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.6F).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200), 1.0F).build();

        //farmersdelight
        public static final FoodProperties POTATO_PANCAKES = (new FoodProperties.Builder()).nutrition(4).saturationMod(1F).build();

        //neapolitan
        public static final FoodProperties ICE_CREAM = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.3F).build();

        public static final FoodProperties APPLE_ICE_CREAM = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoEffects.EXUBERANT.get(), 600, 2), 1.0F).build();
        public static final FoodProperties CARROT_ICE_CREAM = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoEffects.CAROTENE.get(), 1200), 1.0F).build();
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
        public static final FoodProperties CARROT_ICE_CREAM_CONE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoEffects.CAROTENE.get(), 400), 1.0F).build();
        public static final FoodProperties GLOW_BERRY_ICE_CREAM_CONE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoEffects.TRACER.get(), 200, 2), 1.0F).build();

        public static final FoodProperties CHORUS_ICE_CREAM_CONE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoCompat.RESONANCE, 400), 1.0F).build();
        public static final FoodProperties WARZIPAN_ICE_CREAM_CONE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoCompat.MODULATION, 600), 1.0F).build();
        public static final FoodProperties JELLY_RING_ICE_CREAM_CONE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoCompat.FUCHSIA_GOO, 200), 1.0F).build();
        public static final FoodProperties AZURE_BERRY_ICE_CREAM_CONE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoCompat.SPACE_DIVING, 600, 2), 1.0F).build();
        public static final FoodProperties MIDNIGHT_ICE_CREAM_CONE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoCompat.MORGOTH, 200), 1.0F).build();
        public static final FoodProperties STARCLOUD_ICE_CREAM_CONE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoCompat.EARENDEL, 200, 2), 1.0F).build();

        public static final FoodProperties SWEET_BERRY_ICE_CREAM_CONE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoCompat.THORN_RESISTANCE, 600), 1.0F).build();
        public static final FoodProperties PUMPKIN_ICE_CREAM_CONE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoCompat.STUFFED, 260), 1.0F).build();
        public static final FoodProperties BEETROOT_ICE_CREAM_CONE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoCompat.ROOTED, 260), 1.0F).build();
        public static final FoodProperties SEASONAL_ICE_CREAM = (new FoodProperties.Builder()).nutrition(12).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoCompat.STUFFED, 800), 1.0F).effect(() -> new MobEffectInstance(CosmoCompat.THORN_RESISTANCE, 900), 1.0F).effect(() -> new MobEffectInstance(CosmoCompat.ROOTED, 800), 1.0F).build();
        public static final FoodProperties SEASONAL_ICE_CREAM_SANDWICH = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoCompat.STUFFED, 400), 1.0F).effect(() -> new MobEffectInstance(CosmoCompat.THORN_RESISTANCE, 450), 1.0F).effect(() -> new MobEffectInstance(CosmoCompat.ROOTED, 400), 1.0F).build();

        public static final FoodProperties SOURCE_BERRY_ICE_CREAM_CONE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoCompat.MANA_REGEN, 180, 2), 1.0F).build();
        public static final FoodProperties KABLOOM_ICE_CREAM_CONE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoCompat.BLAST_ENDURANCE, 200, 2), 1.0F).build();

        public static final FoodProperties AURORA_KOHAKUTOU = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.6F).effect(() -> new MobEffectInstance(CosmoCompat.AURORA, 200), 1.0F).build();
        public static final FoodProperties GLACIER_ESSENCE = (new FoodProperties.Builder()).effect(() -> new MobEffectInstance(CosmoCompat.FROZEN_RANGE, 80), 1.0F).fast().build();
        public static final FoodProperties STEELEAF_NECTAR = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.2F).effect(() -> new MobEffectInstance(CosmoCompat.POISON_RANGE, 300), 1.0F).build();

        public static final FoodProperties AURORA_ICE_CREAM_CONE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoCompat.AURORA, 180), 1.0F).build();
        public static final FoodProperties GLACIER_ICE_CREAM_CONE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoCompat.FROZEN_RANGE, 180), 1.0F).build();
        public static final FoodProperties PHYTOCHEMICAL_ICE_CREAM_CONE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoCompat.POISON_RANGE, 180), 1.0F).build();
        public static final FoodProperties TORCHBERRY_ICE_CREAM_CONE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoCompat.FIRE_RANGE, 180), 1.0F).build();
    }

}


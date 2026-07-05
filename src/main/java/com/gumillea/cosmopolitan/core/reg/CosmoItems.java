package com.gumillea.cosmopolitan.core.reg;

import com.gumillea.cosmopolitan.Cosmopolitan;
import com.gumillea.cosmopolitan.common.item.*;
import com.gumillea.cosmopolitan.core.util.CosmoCompat;
import com.teamabnormals.blueprint.common.item.BlueprintRecordItem;
import com.teamabnormals.blueprint.core.util.registry.ItemSubRegistryHelper;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.*;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

import static net.minecraft.world.item.crafting.Ingredient.of;

@Mod.EventBusSubscriber(modid = Cosmopolitan.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CosmoItems {
    public static final ItemSubRegistryHelper HELPER = Cosmopolitan.REGISTRY_HELPER.getItemSubHelper();

    //general
    public static final RegistryObject<Item> WILDBERRY = HELPER.createItem("wildberry", () -> new WildberryItem(new Item.Properties().food(CosmopolitanFoods.SNACK), CosmoBlocks.POTTED_WILDBERRY_BUSH));
    public static final RegistryObject<Item> WILDBERRY_MEDLEY = HELPER.createItem("wildberry_medley", () -> new EffectBowlItem(new Item.Properties().stacksTo(16).craftRemainder(Items.BOWL).food(CosmopolitanFoods.WILDBERRY_MEDLEY)));
    public static final RegistryObject<Item> BERRY_SYRUP_BOTTLE = HELPER.createItem("berry_syrup_bottle", () -> new DrinkItem(new Item.Properties().food(CosmopolitanFoods.BERRY_SYRUP_BOTTLE).craftRemainder(Items.GLASS_BOTTLE).stacksTo(16), true, false));
    public static final RegistryObject<Item> JELLY_ROLL = HELPER.createItem("jelly_roll", () -> new RollCakeItem(CosmoBlocks.JELLY_ROLL.get(), new Item.Properties().food(CosmopolitanFoods.JELLY_ROLL)));
    public static final RegistryObject<Item> CLASSIC_FRUIT_SALAD = HELPER.createItem("classic_fruit_salad", () -> new EffectBowlItem(new Item.Properties().food(CosmopolitanFoods.CLASSIC_FRUIT_SALAD).stacksTo(16).craftRemainder(Items.BOWL)));

    public static final RegistryObject<Item> BOILBERRY = HELPER.createItem("boilberry", () -> new EffectItem(new Item.Properties().food(CosmopolitanFoods.BOILBERRY)));
    public static final RegistryObject<Item> SPINALBERRY = HELPER.createItem("spinalberry", () -> new EffectItem(new Item.Properties().food(CosmopolitanFoods.SPINALBERRY)));

    public static final RegistryObject<Item> ARBUTUS_BERRIES = HELPER.createItem("arbutus_berries", () -> new EffectItem(new Item.Properties().food(CosmopolitanFoods.ARBUTUS_BERRIES)));
    public static final RegistryObject<Item> GOLDEN_ARBUTUS_BERRIES = HELPER.createItem("golden_arbutus_berries", () -> new EffectItem(new Item.Properties().food(CosmopolitanFoods.GOLDEN_ARBUTUS_BERRIES).rarity(Rarity.RARE)));
    public static final RegistryObject<Item> ENCHANTED_GOLDEN_ARBUTUS_BERRIES = HELPER.createItem("enchanted_golden_arbutus_berries", () -> new EnchantedFoodItem(new Item.Properties().food(CosmopolitanFoods.ENCHANTED_GOLDEN_ARBUTUS_BERRIES).rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> LUSH_CONFITURE_BOTTLE = HELPER.createItem("lush_confiture_bottle", () -> new DrinkItem(new Item.Properties().food(CosmopolitanFoods.LUSH_CONFITURE_BOTTLE).craftRemainder(Items.GLASS_BOTTLE).stacksTo(16), true, false));
    public static final RegistryObject<Item> ARBUTUS_BERRY_COOKIE = HELPER.createItem("arbutus_berry_cookie", () -> new EffectItem(new Item.Properties().food(CosmopolitanFoods.ARBUTUS_BERRY_COOKIE)));

    public static final RegistryObject<Item> FUNGUIS_BOTTLE = HELPER.createItem("funguis_bottle", () -> new DrinkItem(new Item.Properties().food(CosmopolitanFoods.FUNGUIS_BOTTLE).craftRemainder(Items.GLASS_BOTTLE).stacksTo(16), true, false));
    public static final RegistryObject<Item> WARPED_FUNGUIS_BOTTLE = HELPER.createItem("warped_funguis_bottle", () -> new DrinkItem(new Item.Properties().food(CosmopolitanFoods.FUNGUIS_BOTTLE).craftRemainder(Items.GLASS_BOTTLE).stacksTo(16), true, false));
    public static final RegistryObject<Item> SOULBLIGHT_FUNGUIS_BOTTLE = HELPER.createItem("soulblight_funguis_bottle", () -> new DrinkItem(new Item.Properties().food(CosmopolitanFoods.FUNGUIS_BOTTLE).craftRemainder(Items.GLASS_BOTTLE).stacksTo(16), true, false));
    public static final RegistryObject<Item> GHOSTCREAM = HELPER.createItem("ghostcream", () -> new SpecialFoodItem(new Item.Properties().food(Foods.BREAD)));
    public static final RegistryObject<Item> WARPED_GHOSTCREAM = HELPER.createItem("warped_ghostcream", () -> new SpecialFoodItem(new Item.Properties().food(Foods.BREAD)));
    public static final RegistryObject<Item> SOULBLIGHT_GHOSTCREAM = HELPER.createItem("soulblight_ghostcream", () -> new SpecialFoodItem(new Item.Properties().food(Foods.BREAD)));

    public static final RegistryObject<Item> ECTOCARAMEL = HELPER.createItem("ectocaramel", () -> new EctocaramelItem(new Item.Properties().food(CosmopolitanFoods.ECTOCARAMEL), 3));
    public static final RegistryObject<Item> OCCULT_APPLE = HELPER.createItem("occult_apple", () -> new EctocaramelItem(new Item.Properties().food(CosmopolitanFoods.OCCULT_APPLE).rarity(Rarity.RARE), 6));
    public static final RegistryObject<Item> POPWART = HELPER.createItem("popwart", () -> new EffectBowlItem(new Item.Properties().food(CosmopolitanFoods.POPWART).stacksTo(16).craftRemainder(Items.BOWL)));
    public static final RegistryObject<Item> HOWLING_COOKIE = HELPER.createItem("howling_cookie", () -> new EctocaramelItem(new Item.Properties().food(CosmopolitanFoods.HOWLING_COOKIE), 2));

    public static final RegistryObject<Item> BAGASSE = HELPER.createItem("bagasse", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SUGARCANE_PIECES = HELPER.createItem("sugarcane_pieces", () -> new EffectBowlItem(new Item.Properties().craftRemainder(CosmoItems.BAGASSE.get()).food(CosmopolitanFoods.SUGARCANE_PIECES)));
    public static final RegistryObject<Item> SUGARCANE_JUICE = HELPER.createItem("sugarcane_juice", () -> new DrinkItem(new Item.Properties().food(CosmopolitanFoods.SUGARCANE_JUICE).craftRemainder(Items.GLASS_BOTTLE).stacksTo(16), false, true));

    public static final RegistryObject<Item> MOLASSES_BOTTLE = HELPER.createItem("molasses_bottle", () -> new DrinkItem(new Item.Properties().food(CosmopolitanFoods.BIRCH_SAP_BOTTLE).craftRemainder(Items.GLASS_BOTTLE).stacksTo(16), true, true));
    public static final RegistryObject<Item> MOLASSES_COOKIE = HELPER.createItem("molasses_cookie", () -> new EffectItem(new Item.Properties().food(Foods.COOKIE)));

    public static final RegistryObject<Item> BIRCH_SAP_BOTTLE = HELPER.createItem("birch_sap_bottle", () -> new DrinkItem(new Item.Properties().food(CosmopolitanFoods.BIRCH_SAP_BOTTLE).craftRemainder(Items.GLASS_BOTTLE).stacksTo(16), true, true));
    public static final RegistryObject<Item> BIRCH_COOKIE = HELPER.createItem("birch_cookie", () -> new EffectItem(new Item.Properties().food(Foods.COOKIE)));

    public static final RegistryObject<Item> WATTLESEEDS = HELPER.createItem("wattleseeds", () -> new EffectItem(new Item.Properties().food(CosmopolitanFoods.SNACK)));
    public static final RegistryObject<Item> BUSH_BREAD = HELPER.createItem("bush_bread", () -> new DurabilityFoodItem(new Item.Properties().food(CosmopolitanFoods.BUSH_BREAD), 4, false, false));
    public static final RegistryObject<Item> MEADOW_BREAD = HELPER.createItem("meadow_bread", () -> new DurabilityFoodItem(new Item.Properties().food(CosmopolitanFoods.MEADOW_BREAD), 4, false, true));
    public static final RegistryObject<Item> GEODE_BREAD = HELPER.createItem("geode_bread", () -> new DurabilityFoodItem(new Item.Properties().food(CosmopolitanFoods.GEODE_BREAD), 4, true, false));

    public static final RegistryObject<Item> HERBAL_POWDER = HELPER.createItem("herbal_powder", () -> new EffectItem(new Item.Properties().food(CosmopolitanFoods.SNACK)));
    public static final RegistryObject<Item> HERBAL_COOKIE = HELPER.createItem("herbal_cookie", () -> new HerbalFoodItem(new Item.Properties().food(CosmopolitanFoods.HERBAL_COOKIE)));
    public static final RegistryObject<Item> TISANE = HELPER.createItem("tisane", () -> new HerbalFoodItem(new Item.Properties().food(CosmopolitanFoods.COMFORT_DRINK).stacksTo(16).craftRemainder(Items.GLASS_BOTTLE)));

    public static final RegistryObject<Item> SWEET_QINGTUAN = HELPER.createItem("sweet_qingtuan", () -> new SpecialFoodItem(new Item.Properties().food(CosmopolitanFoods.QINGTUAN)));
    public static final RegistryObject<Item> SALTED_QINGTUAN = HELPER.createItem("salted_qingtuan", () -> new SpecialFoodItem(new Item.Properties().food(CosmopolitanFoods.QINGTUAN)));

    public static final RegistryObject<Item> CHOCOLATE_ROLL = HELPER.createItem("chocolate_roll", () -> new RollCakeItem(CosmoBlocks.CHOCOLATE_ROLL.get(), new Item.Properties().food(CosmopolitanFoods.CHOCOLATE_ROLL)));
    public static final RegistryObject<Item> INK_ROLL = HELPER.createItem("ink_roll", () -> new RollCakeItem(CosmoBlocks.INK_ROLL.get(), new Item.Properties().food(CosmopolitanFoods.INK_ROLL)));
    public static final RegistryObject<Item> YULE_LOG = HELPER.createItem("yule_log", () -> new RollCakeItem(CosmoBlocks.YULE_LOG.get(), new Item.Properties().food(CosmopolitanFoods.YULE_LOG)));

    public static final RegistryObject<Item> FIDDLEHEAD = HELPER.createItem("fiddlehead", () -> new PottedCropItem(new Item.Properties().food(CosmopolitanFoods.FIDDLEHEAD), CosmoBlocks.POTTED_FIDDLEHEAD_GREENS));
    public static final RegistryObject<Item> BAKED_FIDDLEHEAD = HELPER.createItem("baked_fiddlehead", () -> new Item(new Item.Properties().food(CosmopolitanFoods.BAKED_FIDDLEHEAD)));
    public static final RegistryObject<Item> FIDDLEHEAD_TEMPURA = HELPER.createItem("fiddlehead_tempura", () -> new Item(new Item.Properties().food(CosmopolitanFoods.BAKED_FIDDLEHEAD)));
    public static final RegistryObject<Item> IRON_FIDDLEHEAD = HELPER.createItem("iron_fiddlehead", () -> new EffectItem(new Item.Properties().food(CosmopolitanFoods.IRON_FIDDLEHEAD)));

    public static final RegistryObject<Item> WHEATGRASS = HELPER.createItem("wheatgrass", () -> new WheatgrassItem(new Item.Properties().food(CosmopolitanFoods.WHEATGRASS)));
    public static final RegistryObject<Item> PAW_COOKIE = HELPER.createItem("paw_cookie", () -> new WheatgrassItem(new Item.Properties().food(CosmopolitanFoods.PAW_COOKIE)));

    public static final RegistryObject<Item> CHARD = HELPER.createItem("chard", () -> new EffectItem(new Item.Properties().food(CosmopolitanFoods.CHARD)));
    public static final RegistryObject<Item> CHARD_ROLLS = HELPER.createItem("chard_rolls", () -> new EffectItem(new Item.Properties().food(CosmopolitanFoods.CHARD_ROLLS)));
    public static final RegistryObject<Item> BEETROOT_MIXED_RICE = HELPER.createItem("beetroot_mixed_rice", () -> new EffectBowlItem(new Item.Properties().stacksTo(16).craftRemainder(Items.BOWL).food(CosmopolitanFoods.BEETROOT_MIXED_RICE)));

    public static final RegistryObject<Item> TUBER = HELPER.createItem("tuber", () -> new EffectItem(new Item.Properties().food(CosmopolitanFoods.TUBER)));
    public static final RegistryObject<Item> CUT_TUBERS = HELPER.createItem("cut_tubers", () -> new EffectItem(new Item.Properties().food(CosmopolitanFoods.CUT_TUBERS)));
    public static final RegistryObject<Item> TUBER_CHIPS = HELPER.createItem("tuber_chips", () -> new EffectItem(new Item.Properties().food(CosmopolitanFoods.TUBER_CHIPS)));
    public static final RegistryObject<Item> TUBER_CHIP_BAG = HELPER.createItem("tuber_chip_bag", () -> new DurabilityFoodItem(new Item.Properties().food(CosmopolitanFoods.TUBER_CHIP_BAG), 9, false, true));

    public static final RegistryObject<Item> ROASTED_TUBER = HELPER.createItem("roasted_tuber", () -> new EffectItem(new Item.Properties().food(CosmopolitanFoods.ROASTED_TUBER)));
    public static final RegistryObject<Item> TUBER_PUREE = HELPER.createItem("tuber_puree", () -> new EffectBowlItem(new Item.Properties().stacksTo(16).food(CosmopolitanFoods.TUBER_PUREE).craftRemainder(Items.BOWL)));
    public static final RegistryObject<Item> TUBER_PUREE_WITH_CONFITURE = HELPER.createItem("tuber_puree_with_confiture", () -> new EffectBowlItem(new Item.Properties().stacksTo(16).food(CosmopolitanFoods.TUBER_PUREE_WITH_CONFITURE).craftRemainder(Items.BOWL)));
    public static final RegistryObject<Item> TUBER_PUREE_CONE = HELPER.createItem("tuber_puree_cone", () -> new EffectItem(new Item.Properties().food(CosmopolitanFoods.TUBER_PUREE_CONE)));
    public static final RegistryObject<Item> TUBER_PUREE_CONE_WITH_CONFITURE = HELPER.createItem("tuber_puree_cone_with_confiture", () -> new EffectItem(new Item.Properties().food(CosmopolitanFoods.TUBER_PUREE_CONE_WITH_CONFITURE)));

    public static final RegistryObject<Item> CUT_POTATOES = HELPER.createItem("cut_potatoes", () -> new Item(new Item.Properties().food(CosmopolitanFoods.POTATO_SLICES)));
    public static final RegistryObject<Item> POTATO_WEDGES = HELPER.createItem("potato_wedges", () -> new Item(new Item.Properties().food(CosmopolitanFoods.BAKED_POTATO_SLICES)));
    public static final RegistryObject<Item> MASHED_POTATO = HELPER.createItem("mashed_potato", () -> new BowlFoodItem(new Item.Properties().stacksTo(16).food(CosmopolitanFoods.MASHED_POTATO).craftRemainder(Items.BOWL)));
    public static final RegistryObject<Item> MASHED_POTATO_CONE = HELPER.createItem("mashed_potato_cone", () -> new Item(new Item.Properties().food(CosmopolitanFoods.MASHED_POTATO_CONE)));

    public static final RegistryObject<Item> DRIPLEAF_ROLL = HELPER.createItem("dripleaf_roll", () -> new EffectItem(new Item.Properties().food(CosmopolitanFoods.DRIPLEAF_ROLL)));

    public static final RegistryObject<Item> ROASTED_MUSHROOM = HELPER.createItem("roasted_mushroom", () -> new Item(new Item.Properties().food(CosmopolitanFoods.ROASTED_MUSHROOM)));
    public static final RegistryObject<Item> FLYING_DUTCHMAN_BURGER = HELPER.createItem("flying_dutchman_burger", () -> new EffectItem(new Item.Properties().food(CosmopolitanFoods.FLYING_DUTCHMAN_BURGER)));

    public static final RegistryObject<Item> FLOWER_LOVE = HELPER.createItem("flower_love", () -> new EffectItem(new Item.Properties().food(CosmopolitanFoods.FLOWER_LOVE)));
    public static final RegistryObject<Item> FISH_KEBAB = HELPER.createItem("fish_kebab", () -> new EffectItem(new Item.Properties().food(CosmopolitanFoods.FISH_KEBAB)));
    public static final RegistryObject<Item> STRAWBERRY_TANGHULU = HELPER.createItem("strawberry_tanghulu", () -> new NeapolitanStrawberryItem(new Item.Properties().food(CosmopolitanFoods.STRAWBERRY_TANGHULU), false, 0, 4.0F));

    public static final RegistryObject<Item> TOFFEE_APPLE = HELPER.createItem("toffee_apple", () -> new EffectItem(new Item.Properties().food(CosmopolitanFoods.TOFFEE_APPLE)));
    public static final RegistryObject<Item> TOFFEE_GOLDEN_APPLE = HELPER.createItem("toffee_golden_apple", () -> new EffectItem(new Item.Properties().food(CosmopolitanFoods.TOFFEE_GOLDEN_APPLE)));

    public static final RegistryObject<Item> BERRY_CHEESECAKE_BAR = HELPER.createItem("berry_cheesecake_bar", () -> new EffectItem(new Item.Properties().food(CosmopolitanFoods.DOUBLE_POPSICLE)));
    public static final RegistryObject<Item> BERRY_DOUBLE_POPSICLE = HELPER.createItem("berry_popsicle_double", () -> new DoublePopsicleItem(new Item.Properties().food(CosmopolitanFoods.DOUBLE_POPSICLE), false, 160, CosmoItems.BERRY_POPSICLE));
    public static final RegistryObject<Item> BERRY_POPSICLE = HELPER.createItem("berry_popsicle", () -> new FrozenDessertItem(new Item.Properties().food(CosmopolitanFoods.POPSICLE), false, 80));

    public static final RegistryObject<Item> LLAMA_MARSHMALLOW = HELPER.createItem("llama_marshmallow", () -> new EffectItem(new Item.Properties().food(CosmopolitanFoods.LLAMA_MARSHMALLOW)));
    public static final RegistryObject<Item> LLAMA_MARSHMALLOW_BROWN = HELPER.createItem("llama_marshmallow_brown", () -> new EffectItem(new Item.Properties().food(CosmopolitanFoods.LLAMA_MARSHMALLOW_BROWN)));

    public static final RegistryObject<Item> WANDERING_GELATO = HELPER.createItem("wandering_gelato", () -> new NeapolitanIceCreamItem(new Item.Properties().food(CosmopolitanFoods.WANDERING_GELATO), false, 80));
    public static final RegistryObject<Item> TRAVELERS_PANINI = HELPER.createItem("travelers_panini", () -> new EffectItem(new Item.Properties().food(CosmopolitanFoods.TRAVELERS_PANINI)));
    public static final RegistryObject<Item> LLAMA_MARSHMALLOW_TRADER = HELPER.createItem("llama_marshmallow_trader", () -> new EffectItem(new Item.Properties().food(CosmopolitanFoods.LLAMA_MARSHMALLOW_TRADER)));
    public static final RegistryObject<Item> EMERALD_CANDY = HELPER.createItem("emerald_candy", () -> new SpecialFoodItem(new Item.Properties().food(CosmopolitanFoods.EMERALD_CANDY)));

    public static final RegistryObject<Item> BAGEL = HELPER.createItem("bagel", () -> new EffectItem(new Item.Properties().food(CosmopolitanFoods.BAGEL)));
    public static final RegistryObject<Item> BAGEL_SANDWICH = HELPER.createItem("bagel_sandwich", () -> new EffectItem(new Item.Properties().food(CosmopolitanFoods.BAGEL_SANDWICH)));
    public static final RegistryObject<Item> BACON_EGG_BAGEL = HELPER.createItem("bacon_egg_bagel", () -> new EffectItem(new Item.Properties().food(CosmopolitanFoods.BACON_EGG_BAGEL)));
    public static final RegistryObject<Item> BERRY_CREAM_CHEESE_BAGEL = HELPER.createItem("berry_cream_cheese_bagel", () -> new EffectItem(new Item.Properties().food(CosmopolitanFoods.BERRY_CREAM_CHEESE_BAGEL)));
    public static final RegistryObject<Item> MATCHA_CREAM_INK_BAGEL = HELPER.createItem("matcha_cream_cheese_ink_bagel", () -> new EffectItem(new Item.Properties().food(CosmopolitanFoods.MATCHA_CREAM_INK_BAGEL)));
    public static final RegistryObject<Item> NEAPOLITAN_ICE_CREAM_BAGEL = HELPER.createItem("neapolitan_ice_cream_bagel", () -> new NeapolitanStrawberryItem(new Item.Properties().food(CosmopolitanFoods.NEAPOLITAN_ICE_CREAM_BAGEL),false, 100, 1.0F));

    public static final RegistryObject<Item> WAFER = HELPER.createItem("wafer", () -> new Item(new Item.Properties().food(CosmopolitanFoods.WAFFLE)));
    public static final RegistryObject<Item> WAFER_CONE = HELPER.createItem("wafer_cone", () -> new Item(new Item.Properties().food(CosmopolitanFoods.WAFFLE)));
    public static final RegistryObject<Item> SNOW_CONE = HELPER.createItem("snow_cone", () -> new NeapolitanIceCreamItem(new Item.Properties().food(CosmopolitanFoods.SNOW_CONE), false, 80));
    public static final RegistryObject<Item> SLIME_CONE = HELPER.createItem("slime_cone", () -> new GummyItem(new Item.Properties().food(CosmopolitanFoods.SLIME_CONE)));

    public static final RegistryObject<Item> ACACIA_SNOW_CONE = HELPER.createItem("acacia_snow_cone", () -> new NeapolitanIceCreamItem(new Item.Properties().food(CosmopolitanFoods.ACACIA_SNOW_CONE).craftRemainder(CosmoCompat.PINECONE), true, 100));
    public static final RegistryObject<Item> LUSH_SNOW_CONE = HELPER.createItem("lush_snow_cone", () -> new NeapolitanIceCreamItem(new Item.Properties().food(CosmopolitanFoods.LUSH_SNOW_CONE).craftRemainder(CosmoCompat.PINECONE), true, 100));

    public static final RegistryObject<Item> CAVE_CONE = HELPER.createItem("cave_cone", () -> new CaveConeItem(new Item.Properties().food(CosmopolitanFoods.CAVE_CONE)));
    public static final RegistryObject<Item> ABYSSAL_CAVE_CONE = HELPER.createItem("abyssal_cave_cone", () -> new CaveConeItem(new Item.Properties().food(CosmopolitanFoods.ABYSSAL_CAVE_CONE)));
    public static final RegistryObject<Item> CANDY_CAVE_CONE = HELPER.createItem("candy_cave_cone", () -> new CaveConeItem(new Item.Properties().food(CosmopolitanFoods.CANDY_CAVE_CONE)));
    public static final RegistryObject<Item> FORLORN_CAVE_CONE = HELPER.createItem("forlorn_cave_cone", () -> new CaveConeItem(new Item.Properties().food(CosmopolitanFoods.CAVE_CONE)));
    public static final RegistryObject<Item> PRIMORDIAL_CAVE_CONE = HELPER.createItem("primordial_cave_cone", () -> new CaveConeItem(new Item.Properties().food(CosmopolitanFoods.PRIMORDIAL_CAVE_CONE)));
    public static final RegistryObject<Item> MAGNETIC_CAVE_CONE = HELPER.createItem("magnetic_cave_cone", () -> new CaveConeItem(new Item.Properties().food(CosmopolitanFoods.MAGNETIC_CAVE_CONE)));
    public static final RegistryObject<Item> TOXIC_CAVE_CONE = HELPER.createItem("toxic_cave_cone", () -> new CaveConeItem(new Item.Properties().food(CosmopolitanFoods.CAVE_CONE)));

    public static final RegistryObject<Item> CONDENSED_MILK_BUCKET = HELPER.createItem("condensed_milk_bucket", () -> new DrinkItem(new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).food(CosmopolitanFoods.CONDENSED_MILK), true, true));
    public static final RegistryObject<Item> CONDENSED_MILK_BOTTLE = HELPER.createItem("condensed_milk_bottle", () -> new DrinkItem(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE).stacksTo(16).food(CosmopolitanFoods.CONDENSED_MILK), true, true));
    public static final RegistryObject<Item> PENUCHE = HELPER.createItem("penuche", () -> new GummyItem(new Item.Properties().food(CosmopolitanFoods.PENUCHE)));

    public static final RegistryObject<Item> CREAM_BUCKET = HELPER.createItem("cream_bucket", () -> new DrinkItem(new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).food(CosmopolitanFoods.CREAM), true, true));
    public static final RegistryObject<Item> CREAM = HELPER.createItem("cream", () -> new EffectBowlItem(new Item.Properties().craftRemainder(Items.BOWL).food(CosmopolitanFoods.CREAM).stacksTo(16)));

    public static final RegistryObject<Item> MERINGUE = HELPER.createItem("meringue", () -> new SpecialFoodItem(new Item.Properties().food(CosmopolitanFoods.SNACK)));

    public static final RegistryObject<Item> ETON_MESS = HELPER.createItem("eton_mess", () -> new NeapolitanStrawberryItem(new Item.Properties().food(CosmopolitanFoods.ETON_MESS), true, 0, 3.0F));
    public static final RegistryObject<Item> MOJANG_MESS = HELPER.createItem("mojang_mess", () -> new EffectBowlItem(new Item.Properties().food(CosmopolitanFoods.MOJANG_MESS)));

    public static final RegistryObject<Item> CREAM_BUN = HELPER.createItem("cream_bun", () -> new EffectItem(new Item.Properties().food(CosmopolitanFoods.CREAM_BUN)));
    public static final RegistryObject<Item> CHOCOLATE_BANANA_CREAM_BUN = HELPER.createItem("chocolate_banana_cream_bun", () -> new EffectItem(new Item.Properties().food(CosmopolitanFoods.CHOCOLATE_BANANA_CREAM_BUN)));
    public static final RegistryObject<Item> STRAWBERRY_VANILLA_CREAM_BUN = HELPER.createItem("strawberry_vanilla_cream_bun", () -> new NeapolitanStrawberryItem(new Item.Properties().food(CosmopolitanFoods.STRAWBERRY_VANILLA_CREAM_BUN), false, 0, 2));
    public static final RegistryObject<Item> ADZUKI_MINT_CREAM_BUN = HELPER.createItem("adzuki_mint_cream_bun", () -> new EffectItem(new Item.Properties().food(CosmopolitanFoods.MINT_ADZUKI_CREAM_BUN)));

    public static final RegistryObject<Item> BERRY_DUO_CREAM_BUN = HELPER.createItem("berry_duo_cream_bun", () -> new EffectItem(new Item.Properties().food(CosmopolitanFoods.BERRY_DUO_CREAM_BUN)));
    public static final RegistryObject<Item> ECTOCARAMEL_POMEGRANATE_CREAM_BUN = HELPER.createItem("ectocaramel_pomegranate_cream_bun", () -> new EffectItem(new Item.Properties().food(CosmopolitanFoods.ECTOCARAMEL_POMEGRANATE_CREAM_BUN)));
    public static final RegistryObject<Item> MATCHA_SALMONBERRY_CREAM_BUN = HELPER.createItem("matcha_salmonberry_cream_bun", () -> new EffectItem(new Item.Properties().food(CosmopolitanFoods.MATCHA_SALMONBERRY_CREAM_BUN)));
    public static final RegistryObject<Item> BLISTERBERRY_DROOPFRUIT_CREAM_BUN = HELPER.createItem("blisterberry_droopfruit_cream_bun", () -> new EffectItem(new Item.Properties().food(CosmopolitanFoods.BLISTERBERRY_DROOPFRUIT_CREAM_BUN)));

    public static final RegistryObject<Item> WATER_PIE = HELPER.createItem("water_pie", () -> new EdibleBlockItem(CosmoBlocks.WATER_PIE.get(), new Item.Properties().food(CosmopolitanFoods.WATER_PIE)));
    public static final RegistryObject<Item> WATER_PIE_SLICE = HELPER.createItem("water_pie_slice", () -> new EffectItem(new Item.Properties().food(CosmopolitanFoods.WATER_PIE_SLICE)));
    public static final RegistryObject<Item> SHOOFLY_PIE = HELPER.createItem("shoofly_pie", () -> new EdibleBlockItem(CosmoBlocks.SHOOFLY_PIE.get(), new Item.Properties().food(CosmopolitanFoods.SHOOFLY_PIE)));
    public static final RegistryObject<Item> SHOOFLY_PIE_SLICE = HELPER.createItem("shoofly_pie_slice", () -> new EffectItem(new Item.Properties().food(CosmopolitanFoods.SHOOFLY_PIE_SLICE)));
    public static final RegistryObject<Item> MOSS_PIE = HELPER.createItem("moss_pie", () -> new EdibleBlockItem(CosmoBlocks.MOSS_PIE.get(), new Item.Properties().food(CosmopolitanFoods.MOSS_PIE)));
    public static final RegistryObject<Item> MOSS_PIE_SLICE = HELPER.createItem("moss_pie_slice", () -> new EffectItem(new Item.Properties().food(CosmopolitanFoods.MOSS_PIE_SLICE)));

    public static final RegistryObject<Item> WOODLAND_SUB = HELPER.createItem("woodland_sub", () -> new EffectItem(new Item.Properties().food(CosmopolitanFoods.WOODLAND_SUB)));

    public static final RegistryObject<Item> GLOW_BERRY_CUBECAKE = HELPER.createItem("glow_berry_cubecake", () -> new EdibleBlockItem(CosmoBlocks.GLOW_BERRY_CUBECAKE.get(), new Item.Properties().food(CosmopolitanFoods.GLOW_BERRY_CUBECAKE)));
    public static final RegistryObject<Item> WHEATGRASS_CUBECAKE = HELPER.createItem("wheatgrass_cubecake", () -> new EdibleBlockItem(CosmoBlocks.WHEATGRASS_CUBECAKE.get(), new Item.Properties().food(CosmopolitanFoods.WHEATGRASS_CUBECAKE)));
    public static final RegistryObject<Item> CHORUS_FRUIT_CUBECAKE = HELPER.createItem("chorus_fruit_cubecake", () -> new EdibleBlockItem(CosmoBlocks.CHORUS_FRUIT_CUBECAKE.get(), new Item.Properties().food(CosmopolitanFoods.CHORUS_FRUIT_CUBECAKE)));
    public static final RegistryObject<Item> WARPED_VELVET_CUBECAKE = HELPER.createItem("warped_velvet_cubecake", () -> new EdibleBlockItem(CosmoBlocks.WARPED_VELVET_CUBECAKE.get(), new Item.Properties().food(CosmopolitanFoods.WARPED_VELVET_CUBECAKE)));

    public static final RegistryObject<Item> SPRING_SODA = HELPER.createItem("spring_soda", () -> new SeasonalDrinkItem(new Item.Properties().food(CosmopolitanFoods.DRINK).craftRemainder(Items.GLASS_BOTTLE).stacksTo(16), false, "spring"));
    public static final RegistryObject<Item> ICE_CREAM_FLOAT = HELPER.createItem("ice_cream_float", () -> new SeasonalDrinkItem(new Item.Properties().food(CosmopolitanFoods.ICE_CREAM_FLOAT).craftRemainder(Items.GLASS_BOTTLE).stacksTo(16), true, "spring"));
    public static final RegistryObject<Item> SUMMER_CORDIAL = HELPER.createItem("summer_cordial", () -> new SeasonalDrinkItem(new Item.Properties().food(CosmopolitanFoods.DRINK).craftRemainder(Items.GLASS_BOTTLE).stacksTo(16), false, "summer"));
    public static final RegistryObject<Item> AUTUMN_TEA = HELPER.createItem("autumn_tea", () -> new SeasonalDrinkItem(new Item.Properties().food(CosmopolitanFoods.COMFORT_DRINK).craftRemainder(Items.GLASS_BOTTLE).stacksTo(16), false, "autumn"));
    public static final RegistryObject<Item> WINTER_GLOGG = HELPER.createItem("winter_glogg", () -> new SeasonalDrinkItem(new Item.Properties().food(CosmopolitanFoods.COMFORT_DRINK).craftRemainder(Items.GLASS_BOTTLE).stacksTo(16), false, "winter"));
    public static final RegistryObject<Item> KYKEON = HELPER.createItem("kykeon", () -> new KykeonItem(new Item.Properties().food(CosmopolitanFoods.DRINK).craftRemainder(Items.GLASS_BOTTLE).rarity(Rarity.RARE)));

    public static final RegistryObject<Item> ABC_SOUP = HELPER.createItem("abc_soup", () -> new EffectBowlItem(new Item.Properties().food(CosmopolitanFoods.ABC_SOUP).craftRemainder(Items.BOWL).stacksTo(16)));
    public static final RegistryObject<Item> ABC_SOUP_CUP = HELPER.createItem("abc_soup_cup", () -> new MDCupItem(new Item.Properties().food(CosmopolitanFoods.ABC_SOUP_CUP)));
    public static final RegistryObject<Item> LUSH_STEW = HELPER.createItem("lush_stew", () -> new EffectBowlItem(new Item.Properties().food(CosmopolitanFoods.LUSH_STEW).craftRemainder(Items.BOWL).stacksTo(16)));
    public static final RegistryObject<Item> LUSH_STEW_CUP = HELPER.createItem("lush_stew_cup", () -> new MDCupItem(new Item.Properties().food(CosmopolitanFoods.LUSH_STEW_CUP)));
    public static final RegistryObject<Item> JELLO_SALAD = HELPER.createItem("jello_salad", () -> new EffectBowlItem(new Item.Properties().food(CosmopolitanFoods.JELLO_SALAD).craftRemainder(Items.BOWL).stacksTo(16)));
    public static final RegistryObject<Item> JELLO_SALAD_CUP = HELPER.createItem("jello_salad_cup", () -> new MDCupItem(new Item.Properties().food(CosmopolitanFoods.JELLO_SALAD_CUP)));
    public static final RegistryObject<Item> STOBHACH_GAELACH = HELPER.createItem("stobhach_gaelach", () -> new EffectBowlItem(new Item.Properties().food(CosmopolitanFoods.STOBHACH_GAELACH).craftRemainder(Items.BOWL).stacksTo(16)));
    public static final RegistryObject<Item> STOBHACH_GAELACH_CUP = HELPER.createItem("stobhach_gaelach_cup", () -> new MDCupItem(new Item.Properties().food(CosmopolitanFoods.STOBHACH_GAELACH_CUP)));

    public static final RegistryObject<Item> GULIME = HELPER.createItem("gulime", () -> new GulimeItem(new Item.Properties().food(CosmopolitanFoods.GULIME), true, CosmoItems.GULIME_SMALL));
    public static final RegistryObject<Item> GULIME_SMALL = HELPER.createItem("gulime_small", () -> new GulimeItem(new Item.Properties().food(CosmopolitanFoods.GULIME_SMALL), false, CosmoItems.GULIME));

    public static final RegistryObject<Item> UNDERGROUND_GULIME = HELPER.createItem("underground_gulime", () -> new GulimeItem(new Item.Properties().food(CosmopolitanFoods.UNDERGROUND_GULIME), true, CosmoItems.UNDERGROUND_GULIME_SMALL));
    public static final RegistryObject<Item> UNDERGROUND_GULIME_SMALL = HELPER.createItem("underground_gulime_small", () -> new GulimeItem(new Item.Properties().food(CosmopolitanFoods.UNDERGROUND_GULIME_SMALL), false, CosmoItems.UNDERGROUND_GULIME));
    public static final RegistryObject<Item> TAIGA_GULIME = HELPER.createItem("taiga_gulime", () -> new GulimeItem(new Item.Properties().food(CosmopolitanFoods.TAIGA_GULIME), true, CosmoItems.TAIGA_GULIME_SMALL));
    public static final RegistryObject<Item> TAIGA_GULIME_SMALL = HELPER.createItem("taiga_gulime_small", () -> new GulimeItem(new Item.Properties().food(CosmopolitanFoods.TAIGA_GULIME_SMALL), false, CosmoItems.TAIGA_GULIME));
    public static final RegistryObject<Item> CHORUS_GULIME = HELPER.createItem("chorus_gulime", () -> new GulimeItem(new Item.Properties().food(CosmopolitanFoods.CHORUS_GULIME), true, CosmoItems.CHORUS_GULIME_SMALL));
    public static final RegistryObject<Item> CHORUS_GULIME_SMALL = HELPER.createItem("chorus_gulime_small", () -> new GulimeItem(new Item.Properties().food(CosmopolitanFoods.CHORUS_GULIME_SMALL), false, CosmoItems.CHORUS_GULIME));
    public static final RegistryObject<Item> WARPED_GULIME = HELPER.createItem("warped_gulime", () -> new GulimeItem(new Item.Properties().food(CosmopolitanFoods.WARPED_GULIME), true, CosmoItems.WARPED_GULIME_SMALL));
    public static final RegistryObject<Item> WARPED_GULIME_SMALL = HELPER.createItem("warped_gulime_small", () -> new GulimeItem(new Item.Properties().food(CosmopolitanFoods.WARPED_GULIME_SMALL), false, CosmoItems.WARPED_GULIME));
    public static final RegistryObject<Item> ARID_GULIME = HELPER.createItem("arid_gulime", () -> new GulimeItem(new Item.Properties().food(CosmopolitanFoods.ARID_GULIME), true, CosmoItems.ARID_GULIME_SMALL));
    public static final RegistryObject<Item> ARID_GULIME_SMALL = HELPER.createItem("arid_gulime_small", () -> new GulimeItem(new Item.Properties().food(CosmopolitanFoods.ARID_GULIME_SMALL), false, CosmoItems.ARID_GULIME));

    public static final RegistryObject<Item> GLIMMERING_GULIME = HELPER.createItem("glimmering_gulime", () -> new GulimeItem(new Item.Properties().food(CosmopolitanFoods.GLIMMERING_GULIME), true, CosmoItems.GLIMMERING_GULIME_SMALL));
    public static final RegistryObject<Item> GLIMMERING_GULIME_SMALL = HELPER.createItem("glimmering_gulime_small", () -> new GulimeItem(new Item.Properties().food(CosmopolitanFoods.GLIMMERING_GULIME_SMALL), false, CosmoItems.GLIMMERING_GULIME));
    public static final RegistryObject<Item> STRAWBERRY_GULIME = HELPER.createItem("strawberry_gulime", () -> new GulimeItem(new Item.Properties().food(CosmopolitanFoods.GULIME), true, CosmoItems.STRAWBERRY_GULIME_SMALL));
    public static final RegistryObject<Item> STRAWBERRY_GULIME_SMALL = HELPER.createItem("strawberry_gulime_small", () -> new GulimeItem(new Item.Properties().food(CosmopolitanFoods.GULIME_SMALL), false, CosmoItems.STRAWBERRY_GULIME));

    //farmersdelight
    public static final RegistryObject<Item> POTATO_PANCAKES = HELPER.createItem("potato_pancakes", () -> new Item(new Item.Properties().food(CosmopolitanFoods.POTATO_PANCAKES)));
    public static final RegistryObject<Item> GREEN_SAUCE = HELPER.createItem("green_sauce", () -> new BowlFoodItem(new Item.Properties().food(CosmopolitanFoods.GREEN_SAUCE)));
    public static final RegistryObject<Item> GREEN_CREAM_STEW = HELPER.createItem("green_cream_stew", () -> new EffectBowlItem(new Item.Properties().food(CosmopolitanFoods.GREEN_STEW).stacksTo(16).craftRemainder(Items.BOWL)));
    public static final RegistryObject<Item> GREEN_CREAM_STEW_CUP = HELPER.createItem("green_cream_stew_cup",  () -> new MDCupItem(new Item.Properties().food(CosmopolitanFoods.GREEN_STEW)));

    public static final RegistryObject<Item> GREEN_PASTA = HELPER.createItem("green_pasta", () -> new EffectBowlItem(new Item.Properties().food(CosmopolitanFoods.GREEN_PASTA).craftRemainder(Items.BOWL).stacksTo(16)));
    public static final RegistryObject<Item> BAKED_COD_WITH_MASHED_POTATOES = HELPER.createItem("baked_cod_with_mashed_potatoes", () -> new EffectBowlItem(new Item.Properties().food(CosmopolitanFoods.BAKED_COD_WITH_PESTO).craftRemainder(Items.BOWL).stacksTo(16)));

    public static final RegistryObject<Item> WILD_RISOTTO = HELPER.createItem("wild_risotto", () -> new EffectBowlItem(new Item.Properties().food(CosmopolitanFoods.WILD_RISOTTO).craftRemainder(Items.BOWL).stacksTo(16)));
    public static final RegistryObject<Item> SPAGHETTIEIS = HELPER.createItem("spaghettieis", () -> new NeapolitanIceCreamItem(new Item.Properties().food(CosmopolitanFoods.SPAGHETTIEIS).craftRemainder(Items.BOWL).stacksTo(16), true, 200));

    public static final RegistryObject<Item> FARINA = HELPER.createItem("farina", () -> new EffectBowlItem(new Item.Properties().food(CosmopolitanFoods.FARINA).craftRemainder(Items.BOWL).stacksTo(16)));
    public static final RegistryObject<Item> COUSCOUS_WITH_VEGETABLES = HELPER.createItem("couscous_with_vegetables", () -> new EffectBowlItem(new Item.Properties().food(CosmopolitanFoods.WILD_RISOTTO).craftRemainder(Items.BOWL).stacksTo(16)));
    public static final RegistryObject<Item> COUSCOUS_WITH_MUTTON = HELPER.createItem("couscous_with_mutton", () -> new EffectBowlItem(new Item.Properties().food(CosmopolitanFoods.WILD_RISOTTO).craftRemainder(Items.BOWL).stacksTo(16)));

    public static final RegistryObject<Item> RODGROD = HELPER.createItem("rodgrod", () -> new EffectBottleFoodItem(new Item.Properties().food(CosmopolitanFoods.RODGROD)));
    public static final RegistryObject<Item> RICE_PUDDING = HELPER.createItem("rice_pudding", () -> new EffectBottleFoodItem(new Item.Properties().food(CosmopolitanFoods.RICE_PUDDING)));
    public static final RegistryObject<Item> TRIFLE = HELPER.createItem("trifle", () -> new EffectBottleFoodItem(new Item.Properties().food(CosmopolitanFoods.TRIFLE)));
    public static final RegistryObject<Item> ZEBRA_CAKE = HELPER.createItem("zebra_cake", () -> new EffectBottleFoodItem(new Item.Properties().food(CosmopolitanFoods.ZEBRA_CAKE)));

    public static final RegistryObject<Item> JELLY_ROLL_SLICE = HELPER.createItem("jelly_roll_slice", () -> new Item(new Item.Properties().food(CosmopolitanFoods.JELLY_ROLL_SLICE)));
    public static final RegistryObject<Item> CHOCOLATE_ROLL_SLICE = HELPER.createItem("chocolate_roll_slice", () -> new EffectItem(new Item.Properties().food(CosmopolitanFoods.CHOCOLATE_ROLL_SLICE)));
    public static final RegistryObject<Item> INK_ROLL_SLICE = HELPER.createItem("ink_roll_slice", () -> new EffectItem(new Item.Properties().food(CosmopolitanFoods.INK_ROLL_SLICE)));
    public static final RegistryObject<Item> YULE_LOG_SLICE = HELPER.createItem("yule_log_slice", () -> new EffectItem(new Item.Properties().food(CosmopolitanFoods.YULE_LOG_SLICE)));

    public static final RegistryObject<Item> GLAZED_FISH = HELPER.createItem("glazed_fish", () -> new EffectItem(new Item.Properties().food(CosmopolitanFoods.GLAZED_FISH)));
    public static final RegistryObject<Item> GLAZED_FISH_ROLL = HELPER.createItem("glazed_fish_roll", () -> new EffectItem(new Item.Properties().food(CosmopolitanFoods.GLAZED_FISH_ROLL)));

    //farmersrespite
    public static final RegistryObject<Item> GAMBLERS_POPSICLE_DOUBLE = HELPER.createItem("gamblers_popsicle_double", () -> new DoubleSplitPopsicleItem(new Item.Properties().food(CosmopolitanFoods.DOUBLE_POPSICLE), CosmoItems.TRANQUIL_SPLIT_POPSICLE, MobEffects.GLOWING, MobEffects.WITHER, 300));
    public static final RegistryObject<Item> GAMBLERS_POPSICLE = HELPER.createItem("gamblers_popsicle", () -> new SplitPopsicleItem(new Item.Properties().food(CosmopolitanFoods.POPSICLE), MobEffects.GLOWING, MobEffects.WITHER, 150));

    //sunflowerdelight
    public static final RegistryObject<Item> GLOWY_ICE_CREAM_CONE = HELPER.createItem("glowy_ice_cream_cone", () -> new NeapolitanIceCreamItem(new Item.Properties().food(CosmopolitanFoods.GLOWY_ICE_CREAM_CONE), false, 80));
    public static final RegistryObject<Item> FLAVORED_ICE_CREAM_CONE = HELPER.createItem("flavored_ice_cream_cone", () -> new NeapolitanIceCreamItem(new Item.Properties().food(CosmopolitanFoods.FLAVORED_ICE_CREAM_CONE), false, 80));
    public static final RegistryObject<Item> TRICOLORED_ICE_CREAM_SANDWICH = HELPER.createItem("tricolored_ice_cream_sandwich", () -> new NeapolitanIceCreamItem(new Item.Properties().food(CosmopolitanFoods.TRICOLORED_ICE_CREAM_SANDWICH), false, 100));

    //seeddelight
    public static final RegistryObject<Item> CHERRY_ICE_CREAM_CONE = HELPER.createItem("cherry_ice_cream_cone", () -> new NeapolitanIceCreamItem(new Item.Properties().food(CosmopolitanFoods.ICE_CREAM_CONE), false, 80));

    //bnc
    public static final RegistryObject<Item> ROOT_BEER = HELPER.createItem("root_beer", () -> new BnCDrinkItem(new Item.Properties().food(CosmopolitanFoods.ROOT_BEER).craftRemainder(CosmoCompat.TANKARD).stacksTo(16), false, false, CosmoFluids.ROOT_BEER.get()));
    public static final RegistryObject<Item> BLACK_COW = HELPER.createItem("black_cow", () -> new IcedDrinkItem(new Item.Properties().food(CosmopolitanFoods.BLACK_COW).craftRemainder(Items.GLASS_BOTTLE).stacksTo(16), true, false));

    public static final RegistryObject<Item> GREEN_BEER = HELPER.createItem("green_beer", () -> new BnCDrinkItem(new Item.Properties().food(CosmopolitanFoods.GREEN_BEER).craftRemainder(CosmoCompat.TANKARD).stacksTo(16), false, false, CosmoFluids.GREEN_BEER.get()));
    public static final RegistryObject<Item> WILDBERRY_PUNCH = HELPER.createItem("wildberry_punch", () -> new BnCDrinkItem(new Item.Properties().food(CosmopolitanFoods.ALCOHOL_DRINK).craftRemainder(CosmoCompat.TANKARD).stacksTo(16), false, true, CosmoFluids.WILDBERRY_PUNCH.get()));
    public static final RegistryObject<Item> GENERIC_ROMANCE = HELPER.createItem("generic_romance", () -> new BnCDrinkItem(new Item.Properties().food(CosmopolitanFoods.ALCOHOL_DRINK).craftRemainder(CosmoCompat.TANKARD).stacksTo(16), false, true, CosmoFluids.GENERIC_ROMANCE.get()));

    public static final RegistryObject<Item> CACHACA = HELPER.createItem("cachaca", () -> new EnhanceDrinkItem(new Item.Properties().food(CosmopolitanFoods.ALCOHOL_DRINK).craftRemainder(CosmoCompat.TANKARD).stacksTo(16), CosmoFluids.CACHACA.get(), MobEffects.MOVEMENT_SPEED));
    public static final RegistryObject<Item> TWILIGHT_CHARTREUSE = HELPER.createItem("twilight_chartreuse", () -> new BnCDrinkItem(new Item.Properties().food(CosmopolitanFoods.TWILIGHT_CHARTREUSE).craftRemainder(CosmoCompat.TANKARD).stacksTo(16), false, false, CosmoFluids.TWILIGHT_CHARTREUSE.get()));
    public static final RegistryObject<Item> SMOGGY_APEROL = HELPER.createItem("smoggy_aperol", () -> new BnCDrinkItem(new Item.Properties().food(CosmopolitanFoods.SMOGGY_APEROL).craftRemainder(CosmoCompat.TANKARD).stacksTo(16), false, false, CosmoFluids.SMOGGY_APEROL.get()));
    public static final RegistryObject<Item> EXOTIC_MIRAGE = HELPER.createItem("exotic_mirage", () -> new BnCDrinkItem(new Item.Properties().food(CosmopolitanFoods.EXOTIC_MIRAGE).craftRemainder(CosmoCompat.TANKARD).stacksTo(16), false, false, CosmoFluids.EXOTIC_MIRAGE.get()));
    public static final RegistryObject<Item> NEVERENDING_NIGHT = HELPER.createItem("neverending_night", () -> new EnhanceDrinkItem(new Item.Properties().food(CosmopolitanFoods.NEVERENDING_NIGHT).craftRemainder(CosmoCompat.TANKARD).stacksTo(16), CosmoFluids.NEVERENDING_NIGHT.get(), CosmoCompat.MORGOTH));
    public static final RegistryObject<Item> MORNING_FOG = HELPER.createItem("morning_fog", () -> new EnhanceDrinkItem(new Item.Properties().food(CosmopolitanFoods.MORNING_FOG).craftRemainder(CosmoCompat.TANKARD).stacksTo(16), CosmoFluids.MORNING_FOG.get(), CosmoCompat.SPELL_DAMAGE));

    //environmental
    public static final RegistryObject<Item> HOT_CATTAIL = HELPER.createItem("hot_cattail", () -> new SpecialFoodItem(new Item.Properties().food(CosmopolitanFoods.CREAM_BUN)));
    public static final RegistryObject<Item> SLABFISH_JELLY_POPSICLE = HELPER.createItem("slabfish_jelly_popsicle", () -> new GummyItem(new Item.Properties().food(CosmopolitanFoods.SLABFISH_JELLY_POPSICLE)));

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

    public static final RegistryObject<Item> CHORUS_FRUIT_DOUBLE_POPSICLE = HELPER.createItem("chorus_fruit_popsicle_double", () -> new DoublePopsicleItem(new Item.Properties().food(CosmopolitanFoods.CHORUS_FRUIT_DOUBLE_POPSICLE), false, 160, CosmoItems.CHORUS_FRUIT_POPSICLE));
    public static final RegistryObject<Item> CHORUS_FRUIT_POPSICLE = HELPER.createItem("chorus_fruit_popsicle", () -> new FrozenDessertItem(new Item.Properties().food(CosmopolitanFoods.CHORUS_FRUIT_POPSICLE), false, 80));

    public static final RegistryObject<Item> EXQUISITE_ICE_CREAM = HELPER.createItem("exquisite_ice_cream", () -> new NeapolitanIceCreamItem(new Item.Properties().food(CosmopolitanFoods.EXQUISITE_ICE_CREAM).craftRemainder(Items.BOWL), true, 200));
    public static final RegistryObject<Item> EXQUISITE_ICE_CREAM_SANDWICH = HELPER.createItem("exquisite_ice_cream_sandwich", () -> new NeapolitanIceCreamItem(new Item.Properties().food(CosmopolitanFoods.EXQUISITE_ICE_CREAM_SANDWICH), false, 100));

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

    //respiteful
    public static final RegistryObject<Item> GREEN_TEA_ICE_CREAM_CONE = HELPER.createItem("green_tea_ice_cream_cone", () -> new NeapolitanIceCreamItem(new Item.Properties().food(CosmopolitanFoods.GREEN_TEA_ICE_CREAM_CONE), false, 80));
    public static final RegistryObject<Item> YELLOW_TEA_ICE_CREAM_CONE = HELPER.createItem("yellow_tea_ice_cream_cone", () -> new NeapolitanIceCreamItem(new Item.Properties().food(CosmopolitanFoods.YELLOW_TEA_ICE_CREAM_CONE), false, 80));
    public static final RegistryObject<Item> BLACK_TEA_ICE_CREAM_CONE = HELPER.createItem("black_tea_ice_cream_cone", () -> new NeapolitanIceCreamItem(new Item.Properties().food(CosmopolitanFoods.BLACK_TEA_ICE_CREAM_CONE), false, 80));
    public static final RegistryObject<Item> COFFEE_ICE_CREAM_CONE = HELPER.createItem("coffee_ice_cream_cone", () -> new NeapolitanIceCreamItem(new Item.Properties().food(CosmopolitanFoods.COFFEE_ICE_CREAM_CONE), false, 80));
    public static final RegistryObject<Item> RESPITEFUL_ICE_CREAM_SANDWICH = HELPER.createItem("respiteful_ice_cream_sandwich", () -> new NeapolitanIceCreamItem(new Item.Properties().food(CosmopolitanFoods.RESPITEFUL_ICE_CREAM_SANDWICH), false, 100));

    //neapolitan x vanilla
    public static final RegistryObject<Item> APPLE_ICE_CREAM = HELPER.createItem("apple_ice_cream", () -> new NeapolitanIceCreamItem(new Item.Properties().food(CosmopolitanFoods.APPLE_ICE_CREAM).craftRemainder(Items.BOWL), true, 200));
    public static final RegistryObject<Item> APPLE_ICE_CREAM_CONE = HELPER.createItem("apple_ice_cream_cone", () -> new NeapolitanIceCreamItem(new Item.Properties().food(CosmopolitanFoods.APPLE_ICE_CREAM_CONE), false, 80));
    public static final RegistryObject<Item> CARROT_ICE_CREAM = HELPER.createItem("carrot_ice_cream", () -> new NeapolitanIceCreamItem(new Item.Properties().food(CosmopolitanFoods.ICE_CREAM).craftRemainder(Items.BOWL), true, 200));
    public static final RegistryObject<Item> CARROT_ICE_CREAM_CONE = HELPER.createItem("carrot_ice_cream_cone", () -> new NeapolitanIceCreamItem(new Item.Properties().food(CosmopolitanFoods.ICE_CREAM_CONE), false, 80));
    public static final RegistryObject<Item> GLOW_BERRY_ICE_CREAM = HELPER.createItem("glow_berry_ice_cream", () -> new NeapolitanIceCreamItem(new Item.Properties().food(CosmopolitanFoods.GLOW_BERRY_ICE_CREAM).craftRemainder(Items.BOWL), true, 200));
    public static final RegistryObject<Item> GLOW_BERRY_ICE_CREAM_CONE = HELPER.createItem("glow_berry_ice_cream_cone", () -> new NeapolitanIceCreamItem(new Item.Properties().food(CosmopolitanFoods.GLOW_BERRY_ICE_CREAM_CONE), false, 80));
    public static final RegistryObject<Item> CLASSIC_ICE_CREAM = HELPER.createItem("classic_ice_cream", () -> new NeapolitanIceCreamItem(new Item.Properties().food(CosmopolitanFoods.CLASSIC_ICE_CREAM), true, 200));
    public static final RegistryObject<Item> CLASSIC_ICE_CREAM_SANDWICH = HELPER.createItem("classic_ice_cream_sandwich", () -> new NeapolitanIceCreamItem(new Item.Properties().food(CosmopolitanFoods.CLASSIC_ICE_CREAM_SANDWICH), false, 100));

    public static final RegistryObject<Item> BERRY_SYRUP_SHAVED_ICE = HELPER.createItem("berry_syrup_shaved_ice", () -> new NeapolitanIceCreamItem(new Item.Properties().food(CosmopolitanFoods.ICE_CREAM).craftRemainder(Items.BOWL), true, 200));
    public static final RegistryObject<Item> BERRY_SYRUP_SHAVED_ICE_CONE = HELPER.createItem("berry_syrup_shaved_ice_cone", () -> new NeapolitanIceCreamItem(new Item.Properties().food(CosmopolitanFoods.ICE_CREAM_CONE), false, 80));

    public static final RegistryObject<Item> APPLE_MILKSHAKE = HELPER.createItem("apple_milkshake", () -> new DrinkItem(new Item.Properties().food(CosmopolitanFoods.APPLE_MILKSHAKE).craftRemainder(Items.GLASS_BOTTLE).stacksTo(16), true, false));
    public static final RegistryObject<Item> CARROT_MILKSHAKE = HELPER.createItem("carrot_milkshake", () -> new DrinkItem(new Item.Properties().food(CosmopolitanFoods.MILKSHAKE).craftRemainder(Items.GLASS_BOTTLE).stacksTo(16), true, false));
    public static final RegistryObject<Item> GLOW_BERRY_MILKSHAKE = HELPER.createItem("glow_berry_milkshake", () -> new DrinkItem(new Item.Properties().food(CosmopolitanFoods.GLOW_BERRY_MILKSHAKE).craftRemainder(Items.GLASS_BOTTLE).stacksTo(16), true, false));

    //ars_nouveau
    public static final RegistryObject<Item> MENDOSTEEN_TART = HELPER.createItem("mendosteen_tart", () -> new EffectItem(new Item.Properties().food(CosmopolitanFoods.MENDOSTEEN_TART)));
    public static final RegistryObject<Item> MAGEBLOOM_TART = HELPER.createItem("magebloom_tart", () -> new EffectItem(new Item.Properties().food(CosmopolitanFoods.MAGEBLOOMING_TART)));

    public static final RegistryObject<Item> RECOVERY_LAVA_CAKE = HELPER.createItem("recovery_lava_cake", () -> new EffectItem(new Item.Properties().food(CosmopolitanFoods.RECOVERY_LAVA_CAKE)));
    public static final RegistryObject<Item> SHIELDING_BUTTER_BUN = HELPER.createItem("shielding_butter_bun", () -> new EffectItem(new Item.Properties().food(CosmopolitanFoods.SHIELDING_BUTTER_BUN)));

    public static final RegistryObject<Item> MANA_SALAD = HELPER.createItem("mana_salad", () -> new EffectBowlItem(new Item.Properties().food(CosmopolitanFoods.MANA_SALAD).craftRemainder(Items.BOWL).stacksTo(16)));
    public static final RegistryObject<Item> CHARMED_INFUSION = HELPER.createItem("charmed_infusion", () -> new DrinkItem(new Item.Properties().food(CosmopolitanFoods.CHARMED_INFUSION).craftRemainder(Items.GLASS_BOTTLE).stacksTo(16), false, false));

    public static final RegistryObject<Item> TRANQUIL_SPLIT_POPSICLE_DOUBLE = HELPER.createItem("tranquil_split_popsicle_double", () -> new DoubleSplitPopsicleItem(new Item.Properties().food(CosmopolitanFoods.DOUBLE_POPSICLE), CosmoItems.TRANQUIL_SPLIT_POPSICLE, CosmoCompat.RECOVERY, CosmoCompat.FREEZING, 300));
    public static final RegistryObject<Item> TRANQUIL_SPLIT_POPSICLE = HELPER.createItem("tranquil_split_popsicle", () -> new SplitPopsicleItem(new Item.Properties().food(CosmopolitanFoods.POPSICLE), CosmoCompat.RECOVERY, CosmoCompat.FREEZING, 150));
    public static final RegistryObject<Item> ARDENT_SPLIT_POPSICLE_DOUBLE = HELPER.createItem("ardent_split_popsicle_double", () -> new DoubleSplitPopsicleItem(new Item.Properties().food(CosmopolitanFoods.DOUBLE_POPSICLE), CosmoItems.ARDENT_SPLIT_POPSICLE, CosmoCompat.DEFENCE, CosmoCompat.BLAST, 300));
    public static final RegistryObject<Item> ARDENT_SPLIT_POPSICLE = HELPER.createItem("ardent_split_popsicle", () -> new SplitPopsicleItem(new Item.Properties().food(CosmopolitanFoods.POPSICLE), CosmoCompat.DEFENCE, CosmoCompat.BLAST, 150));

    public static final RegistryObject<Item> MENDOSTEEN_GUMMY = HELPER.createItem("mendosteen_gummy", () -> new GummyItem(new Item.Properties().food(CosmopolitanFoods.MENDOSTEEN_GUMMY)));
    public static final RegistryObject<Item> BASTION_GUMMY = HELPER.createItem("bastion_gummy", () -> new GummyItem(new Item.Properties().food(CosmopolitanFoods.BASTION_GUMMY)));

    //abnormals x ars_nouveau
    public static final RegistryObject<Item> SOURCE_BERRY_PIPS = HELPER.createItem("source_berry_pips", () -> new SourceBerryPipsItem(CosmoCompat.SOURCE_BERRY_BLOCK, new Item.Properties()));

    public static final RegistryObject<Item> SOURCE_BERRY_ICE_CREAM = HELPER.createItem("source_berry_ice_cream", () -> new NeapolitanIceCreamItem(new Item.Properties().food(CosmopolitanFoods.SOURCE_BERRY_ICE_CREAM).craftRemainder(Items.BOWL), true, 200));
    public static final RegistryObject<Item> SOURCE_BERRY_ICE_CREAM_CONE = HELPER.createItem("source_berry_ice_cream_cone", () -> new NeapolitanIceCreamItem(new Item.Properties().food(CosmopolitanFoods.SOURCE_BERRY_ICE_CREAM_CONE), false, 80));
    public static final RegistryObject<Item> SOURCE_BERRY_MILKSHAKE = HELPER.createItem("source_berry_milkshake", () -> new DrinkItem(new Item.Properties().food(CosmopolitanFoods.SOURCE_BERRY_MILKSHAKE).craftRemainder(Items.GLASS_BOTTLE).stacksTo(16), true, false));

    //neapolitan x delightful
    public static final RegistryObject<Item> MATCHA_ICE_CREAM_CONE = HELPER.createItem("matcha_ice_cream_cone", () -> new NeapolitanIceCreamItem(new Item.Properties().food(CosmopolitanFoods.MATCHA_ICE_CREAM_CONE), false, 80));
    public static final RegistryObject<Item> SALMONBERRY_ICE_CREAM_CONE = HELPER.createItem("salmonberry_ice_cream_cone", () -> new NeapolitanIceCreamItem(new Item.Properties().food(CosmopolitanFoods.SALMONBERRY_ICE_CREAM_CONE), false, 80));

    public static final RegistryObject<Item> DELIGHTFUL_ICE_CREAM = HELPER.createItem("delightful_ice_cream", () -> new NeapolitanIceCreamItem(new Item.Properties().food(CosmopolitanFoods.DELIGHTFUL_ICE_CREAM).craftRemainder(Items.BOWL), true, 200));
    public static final RegistryObject<Item> DELIGHTFUL_ICE_CREAM_SANDWICH = HELPER.createItem("delightful_ice_cream_sandwich", () -> new NeapolitanIceCreamItem(new Item.Properties().food(CosmopolitanFoods.DELIGHTFUL_ICE_CREAM_SANDWICH), false, 100));

    //neapolitan x collectorsreap
    public static final RegistryObject<Item> LIME_ICE_CREAM_CONE = HELPER.createItem("lime_ice_cream_cone", () -> new NeapolitanIceCreamItem(new Item.Properties().food(CosmopolitanFoods.LIME_ICE_CREAM_CONE), false, 80));
    public static final RegistryObject<Item> POMEGRANATE_ICE_CREAM_CONE = HELPER.createItem("pomegranate_ice_cream_cone", () -> new NeapolitanIceCreamItem(new Item.Properties().food(CosmopolitanFoods.POMEGRANATE_ICE_CREAM_CONE), false, 80));
    public static final RegistryObject<Item> PINK_DRAGON_FRUIT_ICE_CREAM_CONE = HELPER.createItem("pink_dragon_fruit_ice_cream_cone", () -> new NeapolitanIceCreamItem(new Item.Properties().food(CosmopolitanFoods.PINK_DRAGON_FRUIT_ICE_CREAM_CONE), false, 80));
    public static final RegistryObject<Item> LUCUMA_ICE_CREAM_CONE = HELPER.createItem("lucuma_ice_cream_cone", () -> new NeapolitanIceCreamItem(new Item.Properties().food(CosmopolitanFoods.LUCUMA_ICE_CREAM_CONE), false, 80));

    public static final RegistryObject<Item> COLLECTIVE_ICE_CREAM = HELPER.createItem("collective_ice_cream", () -> new NeapolitanIceCreamItem(new Item.Properties().food(CosmopolitanFoods.COLLECTIVE_ICE_CREAM).craftRemainder(Items.BOWL), true, 200));
    public static final RegistryObject<Item> COLLECTIVE_ICE_CREAM_SANDWICH = HELPER.createItem("collective_ice_cream_sandwich", () -> new NeapolitanIceCreamItem(new Item.Properties().food(CosmopolitanFoods.COLLECTIVE_ICE_CREAM_SANDWICH), false, 100));
    public static final RegistryObject<Item> SUNNY_ICE_CREAM_SANDWICH = HELPER.createItem("sunny_ice_cream_sandwich", () -> new NeapolitanStrawberryItem(new Item.Properties().food(CosmopolitanFoods.SUNNY_ICE_CREAM_SANDWICH), false, 100, 1.0F));

    //kofi
    public static final RegistryObject<Item> NETHERESSO = HELPER.createItem("netheresso", () -> new DrinkItem(new Item.Properties().food(CosmopolitanFoods.COFFEE).craftRemainder(Items.GLASS_BOTTLE).stacksTo(16), false, false));
    public static final RegistryObject<Item> ICED_AMERICANO = HELPER.createItem("iced_americano", () -> new IcedDrinkItem(new Item.Properties().food(CosmopolitanFoods.COFFEE).stacksTo(16), false, false));
    public static final RegistryObject<Item> MOCHA = HELPER.createItem("mocha", () -> new DrinkItem(new Item.Properties().food(CosmopolitanFoods.MOCHA).craftRemainder(Items.GLASS_BOTTLE).stacksTo(16), false, false));
    public static final RegistryObject<Item> CHA_JAU = HELPER.createItem("cha_jau", () -> new DrinkItem(new Item.Properties().food(CosmopolitanFoods.CHA_JAU).craftRemainder(Items.GLASS_BOTTLE).stacksTo(16), false, false));

    public static final RegistryObject<Item> STRAWBERRY_MATCHA_LATTE = HELPER.createItem("strawberry_matcha_latte", () -> new DrinkItem(new Item.Properties().food(CosmopolitanFoods.TEA).craftRemainder(Items.GLASS_BOTTLE).stacksTo(16), true, false));

    public static final RegistryObject<Item> BERRY_SYRUP_AMERICANO = HELPER.createItem("berry_syrup_americano", () -> new IcedDrinkItem(new Item.Properties().food(CosmopolitanFoods.COFFEE).stacksTo(16), false, false));
    public static final RegistryObject<Item> CHORUS_FRUIT_AMERICANO = HELPER.createItem("chorus_fruit_americano", () -> new IcedDrinkItem(new Item.Properties().food(CosmopolitanFoods.CHORUS_FRUIT_AMERICANO).stacksTo(16), false, false));
    public static final RegistryObject<Item> ORANGE_AMERICANO = HELPER.createItem("orange_americano", () -> new IcedDrinkItem(new Item.Properties().food(CosmopolitanFoods.ORANGE_AMERICANO).stacksTo(16), false, false));
    public static final RegistryObject<Item> BROCCOLI_AMERICANO = HELPER.createItem("broccoli_americano", () -> new IcedDrinkItem(new Item.Properties().food(CosmopolitanFoods.BROCCOLI_AMERICANO).stacksTo(16), false, false));

    public static final RegistryObject<Item> MATE = HELPER.createItem("mate", () -> new DrinkItem(new Item.Properties().food(CosmopolitanFoods.MATE), false, false));
    public static final RegistryObject<Item> DANDELION_COFFEE = HELPER.createItem("dandelion_coffee", () -> new DrinkItem(new Item.Properties().food(CosmopolitanFoods.DANDELION_COFFEE), false, false));

    //collectorsreap
    public static final RegistryObject<Item> GREENDAY_JUICE = HELPER.createItem("greenday_juice", () -> new DrinkItem(new Item.Properties().food(CosmopolitanFoods.GREENDAY_JUICE), false, false));

    public static final RegistryObject<Item> LIME_DOUBLE_POPSICLE = HELPER.createItem("lime_popsicle_double", () -> new DoublePopsicleItem(new Item.Properties().food(CosmopolitanFoods.LIME_DOUBLE_POPSICLE), false, 160, CosmoCompat.LIME_POPSICLE));

    public static final RegistryObject<Item> CARROT_GUMMY = HELPER.createItem("carrot_gummy", () -> new GummyItem(new Item.Properties().food(CosmopolitanFoods.GUMMY)));
    public static final RegistryObject<Item> KABLOOM_GUMMY = HELPER.createItem("kabloom_gummy", () -> new GummyItem(new Item.Properties().food(CosmopolitanFoods.KABLOOM_GUMMY)));
    public static final RegistryObject<Item> ENCHANTED_FRUIT_GUMMY = HELPER.createItem("enchanted_fruit_gummy", () -> new QuarkEnchantedFruitItem(new Item.Properties().food(CosmopolitanFoods.GUMMY), false, 0, 15));
    public static final RegistryObject<Item> ARBUTUS_BERRY_GUMMY = HELPER.createItem("arbutus_berry_gummy", () -> new GummyItem(new Item.Properties().food(CosmopolitanFoods.ARBUTUS_BERRY_GUMMY)));
    public static final RegistryObject<Item> BERRY_SYRUP_GUMMY = HELPER.createItem("berry_syrup_gummy", () -> new GummyItem(new Item.Properties().food(CosmopolitanFoods.GUMMY)));
    public static final RegistryObject<Item> BLISTERBERRY_GUMMY = HELPER.createItem("blisterberry_gummy", () -> new GummyItem(new Item.Properties().food(CosmopolitanFoods.BLISTERBERRY_GUMMY)));
    public static final RegistryObject<Item> DROOPFRUIT_GUMMY = HELPER.createItem("droopfruit_gummy", () -> new GummyItem(new Item.Properties().food(CosmopolitanFoods.DROOPFRUIT_GUMMY)));
    public static final RegistryObject<Item> BOILBERRY_GUMMY = HELPER.createItem("boilberry_gummy", () -> new GummyItem(new Item.Properties().food(CosmopolitanFoods.BOILBERRY_GUMMY)));
    public static final RegistryObject<Item> SPINALBERRY_GUMMY = HELPER.createItem("spinalberry_gummy", () -> new GummyItem(new Item.Properties().food(CosmopolitanFoods.SPINALBERRY_GUMMY)));
    //abnormals x habitat
    public static final RegistryObject<Item> KABLOOM_PIPS = HELPER.createItem("kabloom_pips", () -> new ItemNameBlockItem(CosmoCompat.KABLOOM_BLOCK, new Item.Properties()));

    public static final RegistryObject<Item> KABLOOM_ICE_CREAM = HELPER.createItem("kabloom_ice_cream", () -> new NeapolitanIceCreamItem(new Item.Properties().food(CosmopolitanFoods.KABLOOM_ICE_CREAM).craftRemainder(Items.BOWL), true, 200));
    public static final RegistryObject<Item> KABLOOM_ICE_CREAM_CONE = HELPER.createItem("kabloom_ice_cream_cone", () -> new NeapolitanIceCreamItem(new Item.Properties().food(CosmopolitanFoods.KABLOOM_ICE_CREAM_CONE), false, 80));
    public static final RegistryObject<Item> KABLOOM_MILKSHAKE = HELPER.createItem("kabloom_milkshake", () -> new DrinkItem(new Item.Properties().food(CosmopolitanFoods.KABLOOM_MILKSHAKE).craftRemainder(Items.GLASS_BOTTLE).stacksTo(16), true, false));

    //abnormals x undergarden
    public static final RegistryObject<Item> BLISTERBERRY_PIPS = HELPER.createItem("blisterberry_pips", () -> new ItemNameBlockItem(CosmoCompat.BLISTERBERRY_BUSH, new Item.Properties()));
    public static final RegistryObject<Item> SPROUTED_UNDERBEANS = HELPER.createItem("sprouted_underbeans", () -> new ItemNameBlockItem(CosmoCompat.UNDERBEAN_BUSH, new Item.Properties()));
    public static final RegistryObject<Item> DROOPFRUIT_PIPS = HELPER.createItem("droopfruit_pips", () -> new ItemNameBlockItem(CosmoCompat.DROOP_VINE, new Item.Properties()));
    public static final RegistryObject<Item> BLISTERBERRY_SORBET = HELPER.createItem("blisterberry_sorbet", () -> new NeapolitanIceCreamItem(new Item.Properties().food(CosmopolitanFoods.BLISTERBERRY_SORBET).craftRemainder(Items.BOWL), true, 200));
    public static final RegistryObject<Item> DROOPFRUIT_SORBET = HELPER.createItem("droopfruit_sorbet", () -> new NeapolitanIceCreamItem(new Item.Properties().food(CosmopolitanFoods.DROOPFRUIT_SORBET).craftRemainder(Items.BOWL), true, 200));

    //neapolitan x quark
    public static final RegistryObject<Item> ENCHANTED_FRUIT_ICE_CREAM = HELPER.createItem("enchanted_fruit_ice_cream", () -> new QuarkEnchantedFruitItem(new Item.Properties().food(CosmopolitanFoods.ICE_CREAM).craftRemainder(Items.BOWL), true, 200, 15));
    public static final RegistryObject<Item> ENCHANTED_FRUIT_ICE_CREAM_CONE = HELPER.createItem("enchanted_fruit_ice_cream_cone", () -> new QuarkEnchantedFruitItem(new Item.Properties().food(CosmopolitanFoods.ICE_CREAM_CONE), false, 80, 5));
    public static final RegistryObject<Item> ENCHANTED_FRUIT_MILKSHAKE = HELPER.createItem("enchanted_fruit_milkshake", () -> new DrinkItem(new Item.Properties().food(CosmopolitanFoods.MILKSHAKE).craftRemainder(Items.GLASS_BOTTLE).stacksTo(16), true, false));

    //twilight_forest
    public static final RegistryObject<Item> AURORA_KOHAKUTOU = HELPER.createItem("aurora_kohakutou", () -> new EffectItem(new Item.Properties().food(CosmopolitanFoods.AURORA_KOHAKUTOU)));
    public static final RegistryObject<Item> GLACIER_ESSENCE = HELPER.createItem("glacier_essence", () -> new NeapolitanIceCreamItem(new Item.Properties().food(CosmopolitanFoods.GLACIER_ESSENCE), false, 40));
    public static final RegistryObject<Item> STEELEAF_NECTAR = HELPER.createItem("steeleaf_nectar", () -> new DrinkItem(new Item.Properties().food(CosmopolitanFoods.STEELEAF_NECTAR).craftRemainder(Items.GLASS_BOTTLE).stacksTo(16), true, false));

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
    public static final RegistryObject<Item> BLISTERBERRY_DOUBLE_POPSICLE = HELPER.createItem("blisterberry_popsicle_double", () -> new DoublePopsicleItem(new Item.Properties().food(CosmopolitanFoods.BLISTERBERRY_DOUBLE_POPSICLE), false, 160, CosmoItems.BLISTERBERRY_POPSICLE));
    public static final RegistryObject<Item> BLISTERBERRY_POPSICLE = HELPER.createItem("blisterberry_popsicle", () -> new FrozenDessertItem(new Item.Properties().food(CosmopolitanFoods.BLISTERBERRY_POPSICLE), false, 80));
    public static final RegistryObject<Item> GLITTERKELP_BURRITO = HELPER.createItem("glitterkelp_burrito", () -> new EffectItem(new Item.Properties().food(CosmopolitanFoods.GLITTERKELP_BURRITO)));

    public static final RegistryObject<Item> RAINDROOP_CAKE = HELPER.createItem("raindroop_cake", () -> new EffectItem(new Item.Properties().food(CosmopolitanFoods.RAINDROOP_CAKE)));

    //enigmaticlegacy
    public static final RegistryObject<Item> COSMIC_SNOW_CONE = HELPER.createItem("cosmic_snow_cone", () -> new DurabilityFoodItem(new Item.Properties().food(CosmopolitanFoods.COSMIC_SNOW_CONE).rarity(Rarity.EPIC), 2, true, true));

    //smc
    public static final RegistryObject<Item> ASTERA_ICE_CREAM_CONE = HELPER.createItem("astera_ice_cream_cone", () -> new NeapolitanIceCreamItem(new Item.Properties().food(CosmopolitanFoods.ASTERA_ICE_CREAM_CONE), false, 80));
    public static final RegistryObject<Item> BROCCOLI_ICE_CREAM_CONE = HELPER.createItem("broccoli_ice_cream_cone", () -> new NeapolitanIceCreamItem(new Item.Properties().food(CosmopolitanFoods.BROCCOLI_ICE_CREAM_CONE), false, 80));
    public static final RegistryObject<Item> FROST_ICE_CREAM_CONE = HELPER.createItem("frost_ice_cream_cone", () -> new NeapolitanIceCreamItem(new Item.Properties().food(CosmopolitanFoods.FROST_ICE_CREAM_CONE), false, 80));
    public static final RegistryObject<Item> SMC_ICE_CREAM_SANDWICH = HELPER.createItem("smc_ice_cream_sandwich", () -> new NeapolitanIceCreamItem(new Item.Properties().food(CosmopolitanFoods.SMC_ICE_CREAM_SANDWICH), false, 80));
    public static final RegistryObject<Item> RAINBOW_ICE_CREAM_SANDWICH_SMC = HELPER.createItem("rainbow_ice_cream_sandwich_smc", () -> new NeapolitanIceCreamItem(new Item.Properties().food(CosmopolitanFoods.RAINBOW_ICE_CREAM_SANDWICH_SMC), false, 80));

    public static final RegistryObject<Item> ORGANIC_MUFFIN = HELPER.createItem("organic_muffin", () -> new EffectItem(new Item.Properties().food(CosmopolitanFoods.ORGANIC_MUFFIN)));
    public static final RegistryObject<Item> COLORFUL_CREAM_BUN = HELPER.createItem("colorful_cream_bun", () -> new EffectItem(new Item.Properties().food(CosmopolitanFoods.COLORFUL_CREAM_BUN)));

    public static final RegistryObject<Item> ASTERA_GUMMY = HELPER.createItem("astera_gummy", () -> new GummyItem(new Item.Properties().food(CosmopolitanFoods.ASTERA_GUMMY)));
    public static final RegistryObject<Item> BROCCOLI_GUMMY = HELPER.createItem("broccoli_gummy", () -> new GummyItem(new Item.Properties().food(CosmopolitanFoods.BROCCOLI_GUMMY)));
    public static final RegistryObject<Item> FROST_GUMMY = HELPER.createItem("frost_gummy", () -> new GummyItem(new Item.Properties().food(CosmopolitanFoods.FROST_GUMMY)));

    //cocktails
    public static final RegistryObject<Item> COSMOPOLITAN_COCKTAIL = HELPER.createItem("cosmopolitan_cocktail", () -> new CocktailItem(new Item.Properties().food(CosmopolitanFoods.DRINK).craftRemainder(Items.GLASS_BOTTLE)));
    public static final RegistryObject<Item> ENCHANTED_COSMOPOLITAN_COCKTAIL = HELPER.createItem("enchanted_cosmopolitan_cocktail", () -> new CocktailItem(new Item.Properties().food(CosmopolitanFoods.DRINK).stacksTo(1).craftRemainder(Items.GLASS_BOTTLE).rarity(Rarity.RARE)));

    //disc
    public static final RegistryObject<Item> MUSIC_DISC_WOC = HELPER.createItem("music_disc_woc", () -> new BlueprintRecordItem(10, CosmoSoundEvents.MUSIC_DISC_WOC, new Item.Properties().stacksTo(1).rarity(Rarity.RARE), 151));

    static class CosmopolitanFoods {
        //general
        public static final FoodProperties SNACK = (new FoodProperties.Builder()).nutrition(2).fast().alwaysEat().build();
        public static final FoodProperties WHEATGRASS = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.5F).alwaysEat().build();
        public static final FoodProperties PAW_COOKIE = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.5F).build();

        public static final FoodProperties SUGARCANE_PIECES = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.4F).build();
        public static final FoodProperties SUGARCANE_JUICE = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.4F).build();

        public static final FoodProperties FIDDLEHEAD = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.4F).effect(() -> new MobEffectInstance(MobEffects.POISON, 100), 0.2F).fast().build();
        public static final FoodProperties IRON_FIDDLEHEAD = (new FoodProperties.Builder()).effect(() -> new MobEffectInstance(MobEffects.POISON, 200), 1).effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 200), 0.5F).build();
        public static final FoodProperties BAKED_FIDDLEHEAD = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.6F).fast().build();

        public static final FoodProperties BERRY_SYRUP_BOTTLE = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.1F).build();
        public static final FoodProperties JELLY_ROLL = (new FoodProperties.Builder()).nutrition(15).saturationMod(0.8F).build();
        public static final FoodProperties CHOCOLATE_ROLL = (new FoodProperties.Builder()).nutrition(15).saturationMod(0.8F).effect(() -> new MobEffectInstance(CosmoCompat.SUGAR_RUSH, 1800, 1), 1.0F).build();
        public static final FoodProperties INK_ROLL = (new FoodProperties.Builder()).nutrition(15).saturationMod(0.8F).effect(() -> new MobEffectInstance(MobEffects.GLOWING, 1200), 1.0F).build();
        public static final FoodProperties YULE_LOG = (new FoodProperties.Builder()).nutrition(15).saturationMod(0.8F).effect(() -> new MobEffectInstance(CosmoCompat.FROST_RESISTANCE, 1200), 1.0F).build();

        public static final FoodProperties TOFFEE_APPLE = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.6F).effect(() -> new MobEffectInstance(CosmoEffects.EXUBERANT.get(), 1200), 1.0F).build();
        public static final FoodProperties TOFFEE_GOLDEN_APPLE = (new FoodProperties.Builder()).nutrition(6).saturationMod(1.2F).effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 100, 1), 1.0F).effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 2400, 0), 1.0F).alwaysEat().build();

        public static final FoodProperties POTATO_SLICES = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.3F).fast().build();
        public static final FoodProperties BAKED_POTATO_SLICES = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.3F).fast().build();
        public static final FoodProperties MASHED_POTATO = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.6F).build();
        public static final FoodProperties MASHED_POTATO_CONE = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.6F).build();

        public static final FoodProperties ROASTED_MUSHROOM = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.2F).build();
        public static final FoodProperties GLAZED_FISH = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.6F).build();
        public static final FoodProperties GLAZED_FISH_ROLL = (new FoodProperties.Builder()).nutrition(9).saturationMod(0.6F).build();

        public static final FoodProperties WAFFLE = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.2F).fast().build();
        public static final FoodProperties SNOW_CONE = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.6F).effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 200), 1.0F).build();
        public static final FoodProperties SLIME_CONE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.5F).effect(() -> new MobEffectInstance(MobEffects.JUMP, 200), 1.0F).build();
        public static final FoodProperties COSMIC_SNOW_CONE = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.6F).effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 600), 1.0F).effect(() -> new MobEffectInstance(MobEffects.HEALTH_BOOST, 600), 1.0F).build();
        public static final FoodProperties WANDERING_GELATO = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.6F).effect(() -> new MobEffectInstance(MobEffects.LUCK, 600), 1.0F).build();

        public static final FoodProperties ACACIA_SNOW_CONE = (new FoodProperties.Builder()).nutrition(15).saturationMod(0.6F).effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 300), 1.0F).build();
        public static final FoodProperties LUSH_SNOW_CONE = (new FoodProperties.Builder()).nutrition(15).saturationMod(0.6F).effect(() -> new MobEffectInstance(CosmoEffects.TRACER.get(), 300), 1.0F).build();

        public static final FoodProperties EMERALD_CANDY = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.4F).effect(() -> new MobEffectInstance(MobEffects.LUCK, 800), 1.0F).build();

        public static final FoodProperties ECTOCARAMEL = (new FoodProperties.Builder()).effect(() -> new MobEffectInstance(CosmoEffects.OBSCURE.get(), 800), 1.0F).build();
        public static final FoodProperties HOWLING_COOKIE = (new FoodProperties.Builder()).effect(() -> new MobEffectInstance(CosmoEffects.OBSCURE.get(), 200), 1.0F).effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 200), 0.5F).build();
        public static final FoodProperties OCCULT_APPLE = (new FoodProperties.Builder()).effect(() -> new MobEffectInstance(CosmoEffects.OBSCURE.get(), 1200, 2), 1.0F).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1200, 1), 1.0F).alwaysEat().build();
        public static final FoodProperties POPWART = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.5F).effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 400), 1.0F).effect(() -> new MobEffectInstance(CosmoEffects.OBSCURE.get(), 400), 1.0F).effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 400), 1.0F).build();

        public static final FoodProperties WILDBERRY_MEDLEY = (new FoodProperties.Builder()).nutrition(6).effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 100), 1.0F).build();
        public static final FoodProperties CLASSIC_FRUIT_SALAD = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoEffects.EXUBERANT.get(), 1200), 1.0F).build();
        public static final FoodProperties ETON_MESS = (new FoodProperties.Builder()).nutrition(8).saturationMod(0.5F).build();
        public static final FoodProperties MOJANG_MESS = (new FoodProperties.Builder()).nutrition(8).saturationMod(0.5F).effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 100, 1), 1.0F).effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 1200, 1), 1.0F).build();

        public static final FoodProperties BIRCH_SAP_BOTTLE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.1F).build();
        public static final FoodProperties FUNGUIS_BOTTLE = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.1F).effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 100), 0.5F).build();
        public static final FoodProperties DRINK = (new FoodProperties.Builder()).alwaysEat().build();
        public static final FoodProperties CREAM = (new FoodProperties.Builder()).nutrition(1).fast().alwaysEat().build();
        public static final FoodProperties CONDENSED_MILK = (new FoodProperties.Builder()).nutrition(3).alwaysEat().build();

        public static final FoodProperties FLOWER_LOVE = (new FoodProperties.Builder()).nutrition(9).saturationMod(0.7F).build();
        public static final FoodProperties FISH_KEBAB = (new FoodProperties.Builder()).nutrition(8).saturationMod(0.9F).build();
        public static final FoodProperties STRAWBERRY_TANGHULU = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.6F).build();

        public static final FoodProperties BUSH_BREAD = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.6F).build();
        public static final FoodProperties MEADOW_BREAD = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.6F).build();
        public static final FoodProperties GEODE_BREAD = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.7F).effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 400), 1.0F).build();

        public static final FoodProperties FARINA = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.5F).effect(() -> new MobEffectInstance(CosmoCompat.NOURISHMENT, 400), 1.0F).build();

        public static final FoodProperties RODGROD = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.6F).effect(() -> new MobEffectInstance(CosmoCompat.SWEET_BERRIES, 600), 1.0F).build();
        public static final FoodProperties RICE_PUDDING = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.6F).effect(() -> new MobEffectInstance(CosmoCompat.NOURISHMENT, 200), 1.0F).build();
        public static final FoodProperties TRIFLE = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.6F).effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 200), 1.0F).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200), 1.0F).build();
        public static final FoodProperties ZEBRA_CAKE = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.5F).effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 600), 1.0F).effect(() -> new MobEffectInstance(CosmoCompat.CHOCOLATE, 600), 1.0F).build();

        public static final FoodProperties CREAM_BUN = (new FoodProperties.Builder()).nutrition(5).saturationMod(1.0F).build();
        public static final FoodProperties CHOCOLATE_BANANA_CREAM_BUN = (new FoodProperties.Builder()).nutrition(5).saturationMod(1.0F).effect(() -> new MobEffectInstance(CosmoCompat.SUGAR_RUSH, 600, 1), 1.0F).effect(() -> new MobEffectInstance(CosmoCompat.AGILITY, 200), 1.0F).build();
        public static final FoodProperties STRAWBERRY_VANILLA_CREAM_BUN = (new FoodProperties.Builder()).nutrition(5).saturationMod(1.0F).effect(() -> new MobEffectInstance(CosmoCompat.VANILLA_SCENT, 400), 1.0F).build();
        public static final FoodProperties MINT_ADZUKI_CREAM_BUN = (new FoodProperties.Builder()).nutrition(5).saturationMod(1.0F).effect(() -> new MobEffectInstance(CosmoCompat.BERSERKING, 800), 1.0F).effect(() -> new MobEffectInstance(CosmoCompat.HARMONY, 400), 1.0F).build();
        public static final FoodProperties BERRY_DUO_CREAM_BUN = (new FoodProperties.Builder()).nutrition(5).saturationMod(1.0F).effect(() -> new MobEffectInstance(CosmoCompat.SWEET_BERRIES, 600), 1.0F).effect(() -> new MobEffectInstance(CosmoEffects.TRACER.get(), 400), 1.0F).build();
        public static final FoodProperties ECTOCARAMEL_POMEGRANATE_CREAM_BUN = (new FoodProperties.Builder()).nutrition(5).saturationMod(1.0F).effect(() -> new MobEffectInstance(CosmoCompat.POMEGRANATE, 600), 1.0F).effect(() -> new MobEffectInstance(CosmoEffects.OBSCURE.get(), 600), 1.0F).build();
        public static final FoodProperties BLISTERBERRY_DROOPFRUIT_CREAM_BUN = (new FoodProperties.Builder()).nutrition(5).saturationMod(1.0F).effect(() -> new MobEffectInstance(CosmoEffects.VARDOGER.get(), 600), 1.0F).effect(() -> new MobEffectInstance(CosmoEffects.ABYSMAL_TORCH.get(), -1), 1.0F).build();
        public static final FoodProperties MATCHA_SALMONBERRY_CREAM_BUN = (new FoodProperties.Builder()).nutrition(5).saturationMod(1.0F).effect(() -> new MobEffectInstance(CosmoCompat.TEA_POLYPHENOLS, 200), 1.0F).effect(() -> new MobEffectInstance(MobEffects.WATER_BREATHING, 600), 1.0F).build();
        public static final FoodProperties COLORFUL_CREAM_BUN = (new FoodProperties.Builder()).nutrition(5).saturationMod(1.0F).effect(() -> new MobEffectInstance(CosmoCompat.POISON_RESISTANCE, 300), 1.0F).effect(() -> new MobEffectInstance(CosmoCompat.FROST_RESISTANCE_SMC, 300), 1.0F).effect(() -> new MobEffectInstance(CosmoCompat.STAR_LIGHT, 300), 1.0F).build();

        public static final FoodProperties GLOW_BERRY_CUBECAKE = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.5F).effect(() -> new MobEffectInstance(CosmoEffects.TRACER.get(), 300), 1.0F).build();
        public static final FoodProperties WHEATGRASS_CUBECAKE = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.5F).build();
        public static final FoodProperties CHORUS_FRUIT_CUBECAKE = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.5F).effect(() -> new MobEffectInstance(CosmoCompat.CHORUS_FRUIT, 300), 1.0F).build();
        public static final FoodProperties WARPED_VELVET_CUBECAKE = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.5F).effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 200), 1.0F).effect(() -> new MobEffectInstance(CosmoCompat.BEETROOT, 200), 1.0F).build();

        public static final FoodProperties GULIME = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.1F).effect(() -> new MobEffectInstance(MobEffects.JUMP, 200), 1.0F).build();
        public static final FoodProperties GULIME_SMALL = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.1F).effect(() -> new MobEffectInstance(MobEffects.JUMP, 200), 1.0F).fast().build();
        public static final FoodProperties UNDERGROUND_GULIME = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.1F).effect(() -> new MobEffectInstance(MobEffects.JUMP, 200), 1.0F).effect(() -> new MobEffectInstance(CosmoEffects.TRACER.get(), 200), 1.0F).build();
        public static final FoodProperties UNDERGROUND_GULIME_SMALL = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.1F).effect(() -> new MobEffectInstance(MobEffects.JUMP, 200), 1.0F).effect(() -> new MobEffectInstance(CosmoEffects.TRACER.get(), 200), 1.0F).fast().build();
        public static final FoodProperties TAIGA_GULIME = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.1F).effect(() -> new MobEffectInstance(MobEffects.JUMP, 200), 1.0F).effect(() -> new MobEffectInstance(CosmoCompat.SWEET_BERRIES, 200), 1.0F).build();
        public static final FoodProperties TAIGA_GULIME_SMALL = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.1F).effect(() -> new MobEffectInstance(MobEffects.JUMP, 200), 1.0F).effect(() -> new MobEffectInstance(CosmoCompat.SWEET_BERRIES, 200), 1.0F).fast().build();
        public static final FoodProperties CHORUS_GULIME = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.1F).effect(() -> new MobEffectInstance(MobEffects.JUMP, 200), 1.0F).effect(() -> new MobEffectInstance(CosmoCompat.CHORUS_FRUIT, 200), 1.0F).build();
        public static final FoodProperties CHORUS_GULIME_SMALL = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.1F).effect(() -> new MobEffectInstance(MobEffects.JUMP, 200), 1.0F).effect(() -> new MobEffectInstance(CosmoCompat.CHORUS_FRUIT, 200), 1.0F).fast().build();
        public static final FoodProperties GLIMMERING_GULIME = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.1F).effect(() -> new MobEffectInstance(MobEffects.JUMP, 200), 1.0F).effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 200), 1.0F).build();
        public static final FoodProperties GLIMMERING_GULIME_SMALL = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.1F).effect(() -> new MobEffectInstance(MobEffects.JUMP, 200), 1.0F).effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 200), 1.0F).fast().build();
        public static final FoodProperties WARPED_GULIME = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.1F).effect(() -> new MobEffectInstance(MobEffects.JUMP, 200), 1.0F).effect(() -> new MobEffectInstance(CosmoCompat.POMEGRANATE, 200), 1.0F).build();
        public static final FoodProperties WARPED_GULIME_SMALL = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.1F).effect(() -> new MobEffectInstance(MobEffects.JUMP, 200), 1.0F).effect(() -> new MobEffectInstance(CosmoCompat.POMEGRANATE, 200), 1.0F).fast().build();
        public static final FoodProperties ARID_GULIME = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.1F).effect(() -> new MobEffectInstance(MobEffects.JUMP, 200), 1.0F).effect(() -> new MobEffectInstance(CosmoCompat.PINK_PITAYA, 200), 1.0F).build();
        public static final FoodProperties ARID_GULIME_SMALL = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.1F).effect(() -> new MobEffectInstance(MobEffects.JUMP, 200), 1.0F).effect(() -> new MobEffectInstance(CosmoCompat.PINK_PITAYA, 200), 1.0F).fast().build();

        public static final FoodProperties LUSH_STEW = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.6F).effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 300), 1.0F).effect(() -> new MobEffectInstance(CosmoEffects.TRACER.get(), 400), 1.0F).build();
        public static final FoodProperties LUSH_STEW_CUP = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.6F).effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 150), 1.0F).effect(() -> new MobEffectInstance(CosmoEffects.TRACER.get(), 200), 1.0F).effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 200), 1.0F).fast().build();

        public static final FoodProperties JELLO_SALAD = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.6F).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400), 1.0F).build();
        public static final FoodProperties JELLO_SALAD_CUP = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.6F).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200), 1.0F).effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 200), 1.0F).fast().build();

        //farmersdelight
        public static final FoodProperties POTATO_PANCAKES = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.8F).build();
        public static final FoodProperties GREEN_SAUCE = (new FoodProperties.Builder()).nutrition(4).saturationMod(1F).build();
        public static final FoodProperties GREEN_STEW = (new FoodProperties.Builder()).nutrition(12).saturationMod(0.8F).effect(() -> new MobEffectInstance(CosmoCompat.NOURISHMENT, 1800), 1.0F).build();

        public static final FoodProperties GREEN_PASTA = (new FoodProperties.Builder()).nutrition(16).saturationMod(0.7F).effect(() -> new MobEffectInstance(CosmoCompat.NOURISHMENT, 6000), 1.0F).build();
        public static final FoodProperties BAKED_COD_WITH_PESTO = (new FoodProperties.Builder()).nutrition(16).saturationMod(0.7F).effect(() -> new MobEffectInstance(CosmoCompat.NOURISHMENT, 6000), 1.0F).build();
        public static final FoodProperties WILD_RISOTTO = (new FoodProperties.Builder()).nutrition(12).saturationMod(1.0F).effect(() -> new MobEffectInstance(CosmoCompat.NOURISHMENT, 3000), 1.0F).build();
        public static final FoodProperties BEETROOT_MIXED_RICE = (new FoodProperties.Builder()).nutrition(14).saturationMod(1.0F).effect(() -> new MobEffectInstance(CosmoCompat.NOURISHMENT, 2400), 1.0F).effect(() -> new MobEffectInstance(CosmoCompat.BEETROOT, 600, 1), 1.0F).build();
        public static final FoodProperties SPAGHETTIEIS = (new FoodProperties.Builder()).nutrition(12).saturationMod(0.8F).effect(() -> new MobEffectInstance(CosmoCompat.NOURISHMENT, 1200), 1.0F).effect(() -> new MobEffectInstance(CosmoCompat.VANILLA_SCENT, 1200), 1.0F).build();

        public static final FoodProperties ABC_SOUP = (new FoodProperties.Builder()).nutrition(8).saturationMod(0.6F).effect(() -> new MobEffectInstance(CosmoCompat.NOURISHMENT, 1200), 1.0F).build();
        public static final FoodProperties ABC_SOUP_CUP = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.6F).effect(() -> new MobEffectInstance(CosmoCompat.NOURISHMENT, 600), 1.0F).effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 200), 1.0F).fast().build();

        public static final FoodProperties STOBHACH_GAELACH = (new FoodProperties.Builder()).nutrition(12).saturationMod(0.8F).effect(() -> new MobEffectInstance(CosmoCompat.NOURISHMENT, 1200), 1.0F).effect(() -> new MobEffectInstance(CosmoEffects.INGRAINED.get(), 2400), 1.0F).build();
        public static final FoodProperties STOBHACH_GAELACH_CUP = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.8F).effect(() -> new MobEffectInstance(CosmoCompat.NOURISHMENT, 600), 1.0F).effect(() -> new MobEffectInstance(CosmoEffects.INGRAINED.get(), 1200), 1.0F).effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 200), 1.0F).fast().build();

        public static final FoodProperties FLYING_DUTCHMAN_BURGER = (new FoodProperties.Builder()).nutrition(8).saturationMod(1.0F).effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 1200), 1.0F).build();

        public static final FoodProperties QINGTUAN = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.3F).build();
        public static final FoodProperties PENUCHE = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.1F).fast().build();

        public static final FoodProperties JELLY_ROLL_SLICE = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.8F).build();
        public static final FoodProperties CHOCOLATE_ROLL_SLICE = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.8F).effect(() -> new MobEffectInstance(CosmoCompat.CHOCOLATE, 600, 1), 1.0F).build();
        public static final FoodProperties INK_ROLL_SLICE = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.8F).effect(() -> new MobEffectInstance(MobEffects.GLOWING, 400), 1.0F).build();
        public static final FoodProperties YULE_LOG_SLICE = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.8F).effect(() -> new MobEffectInstance(CosmoCompat.FROST_RESISTANCE, 400), 1.0F).build();

        public static final FoodProperties DOUBLE_POPSICLE = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.2F).build();
        public static final FoodProperties POPSICLE = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.2F).fast().build();

        public static final FoodProperties LIME_DOUBLE_POPSICLE = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.2F).effect(()-> new MobEffectInstance(CosmoCompat.CORROSION, 1800), 1.0F) .build();

        //an
        public static final FoodProperties MAGEBLOOMING_TART = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.5F).effect(() -> new MobEffectInstance(CosmoCompat.SPELL_DAMAGE, 1800), 1.0F).build();
        public static final FoodProperties MENDOSTEEN_TART = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.5F).effect(() -> new MobEffectInstance(CosmoCompat.RECOVERY, 900), 1.0F).build();
        public static final FoodProperties RECOVERY_LAVA_CAKE = (new FoodProperties.Builder()).nutrition(8).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoCompat.RECOVERY, 600), 1.0F).effect(() -> new MobEffectInstance(CosmoCompat.CHOCOLATE, 1200, 1), 1.0F).build();
        public static final FoodProperties SHIELDING_BUTTER_BUN = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.6F).effect(() -> new MobEffectInstance(CosmoCompat.DEFENCE, 900), 1.0F).build();

        public static final FoodProperties MANA_SALAD = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.6F).effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 100), 1.0F).effect(() -> new MobEffectInstance(CosmoCompat.MANA_REGEN, 600), 1.0F).build();
        public static final FoodProperties CHARMED_INFUSION = (new FoodProperties.Builder()).effect(() -> new MobEffectInstance(CosmoCompat.SPELL_DAMAGE, 600), 1.0F).effect(() -> new MobEffectInstance(CosmoCompat.MANA_REGEN, 600), 1.0F).alwaysEat().build();

        //cr
        public static final FoodProperties GUMMY = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.0F).effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 160, 2), 1.0F).alwaysEat().fast().build();
        public static final FoodProperties KABLOOM_GUMMY = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.0F).effect(() -> new MobEffectInstance(CosmoCompat.BLAST_ENDURANCE, 200, 2), 1.0F).alwaysEat().fast().build();
        public static final FoodProperties ARBUTUS_BERRY_GUMMY = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.0F).effect(() -> new MobEffectInstance(CosmoEffects.PHOTOTAXIS.get(), 100, 2), 1.0F).alwaysEat().fast().build();
        public static final FoodProperties BLISTERBERRY_GUMMY = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.0F).effect(() -> new MobEffectInstance(CosmoEffects.VARDOGER.get(), 200, 2), 1.0F).alwaysEat().fast().build();
        public static final FoodProperties DROOPFRUIT_GUMMY = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.0F).effect(() -> new MobEffectInstance(CosmoEffects.ABYSMAL_TORCH.get(), -1, 1), 1.0F).alwaysEat().fast().build();

        public static final FoodProperties MENDOSTEEN_GUMMY = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.0F).effect(() -> new MobEffectInstance(CosmoCompat.RECOVERY, 200, 2), 1.0F).alwaysEat().fast().build();
        public static final FoodProperties BASTION_GUMMY = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.0F).effect(() -> new MobEffectInstance(CosmoCompat.DEFENCE, 200, 2), 1.0F).alwaysEat().fast().build();

        public static final FoodProperties ASTERA_GUMMY = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.0F).effect(() -> new MobEffectInstance(CosmoCompat.STAR_LIGHT, 200, 2), 1.0F).alwaysEat().fast().build();
        public static final FoodProperties BROCCOLI_GUMMY = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.0F).effect(() -> new MobEffectInstance(CosmoCompat.POISON_RESISTANCE, 200, 2), 1.0F).alwaysEat().fast().build();
        public static final FoodProperties FROST_GUMMY = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.0F).effect(() -> new MobEffectInstance(CosmoCompat.FROST_RESISTANCE_SMC, 200, 2), 1.0F).alwaysEat().fast().build();

        public static final FoodProperties BOILBERRY_GUMMY = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.0F).effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 200, 2), 1.0F).effect(() -> new MobEffectInstance(MobEffects.WITHER, 200, 1), 1.0F).alwaysEat().fast().build();
        public static final FoodProperties SPINALBERRY_GUMMY = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.0F).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, 2), 1.0F).effect(() -> new MobEffectInstance(MobEffects.BLINDNESS, 200), 1.0F).alwaysEat().fast().build();

        public static final FoodProperties GREENDAY_JUICE = (new FoodProperties.Builder()).effect(() -> new MobEffectInstance(CosmoCompat.LIME, 600), 1.0F).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 600), 1.0F).alwaysEat().fast().build();

        //ex
        public static final FoodProperties CHORUS_FRUIT_DOUBLE_POPSICLE = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.2F).effect(() -> new MobEffectInstance(CosmoCompat.CHORUS_FRUIT, 800), 1.0F).build();
        public static final FoodProperties CHORUS_FRUIT_POPSICLE = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.2F).effect(() -> new MobEffectInstance(CosmoCompat.CHORUS_FRUIT, 400), 1.0F).fast().build();

        //en
        public static final FoodProperties SLABFISH_JELLY_POPSICLE = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.4F).effect(() -> new MobEffectInstance(MobEffects.WATER_BREATHING, 500), 1.0F).effect(() -> new MobEffectInstance(MobEffects.LUCK, 500), 1.0F).build();

        //ug
        public static final FoodProperties BLISTERBERRY_TART = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.5F).effect(() -> new MobEffectInstance(CosmoEffects.VARDOGER.get(), 500), 1.0F).build();
        public static final FoodProperties BLISTERBERRY_DOUBLE_POPSICLE = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.2F).effect(() -> new MobEffectInstance(CosmoEffects.VARDOGER.get(), 1000), 1.0F).build();
        public static final FoodProperties BLISTERBERRY_POPSICLE = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.2F).effect(() -> new MobEffectInstance(CosmoEffects.VARDOGER.get(), 500), 1.0F).fast().build();
        public static final FoodProperties GLITTERKELP_BURRITO = (new FoodProperties.Builder()).nutrition(6).saturationMod(1.0F).effect(() -> new MobEffectInstance(CosmoEffects.VARDOGER.get(), 500), 1.0F).build();

        public static final FoodProperties RAINDROOP_CAKE = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.8F).effect(() -> new MobEffectInstance(CosmoEffects.ABYSMAL_TORCH.get(), -1, 1), 1.0F).build();

        //neapolitan
        public static final FoodProperties ICE_CREAM = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.3F).build();
        public static final FoodProperties MILKSHAKE = (new FoodProperties.Builder()).nutrition(2).saturationMod(1.5F).alwaysEat().build();

        public static final FoodProperties BLISTERBERRY_SORBET = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoEffects.VARDOGER.get(), 1200), 1.0F).build();
        public static final FoodProperties DROOPFRUIT_SORBET = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoEffects.ABYSMAL_TORCH.get(), -1, 4), 1.0F).build();

        public static final FoodProperties APPLE_ICE_CREAM = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoEffects.EXUBERANT.get(), 600, 1), 1.0F).build();
        public static final FoodProperties APPLE_MILKSHAKE = (new FoodProperties.Builder()).alwaysEat().nutrition(2).saturationMod(1.5F).effect(() -> new MobEffectInstance(CosmoEffects.EXUBERANT.get(), 900), 1.0F).alwaysEat().build();
        public static final FoodProperties GLOW_BERRY_ICE_CREAM = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoEffects.TRACER.get(), 600, 2), 1.0F).build();
        public static final FoodProperties GLOW_BERRY_MILKSHAKE = (new FoodProperties.Builder()).alwaysEat().nutrition(6).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoEffects.TRACER.get(), 600), 1.0F).alwaysEat().build();

        public static final FoodProperties SOURCE_BERRY_ICE_CREAM = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoCompat.MANA_REGEN, 540, 2), 1.0F).build();
        public static final FoodProperties SOURCE_BERRY_MILKSHAKE = (new FoodProperties.Builder()).alwaysEat().nutrition(2).saturationMod(1.5F).effect(() -> new MobEffectInstance(CosmoCompat.MANA_REGEN, 540), 1.0F).alwaysEat().build();
        public static final FoodProperties KABLOOM_ICE_CREAM = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoCompat.BLAST_ENDURANCE, 600, 2), 1.0F).build();
        public static final FoodProperties KABLOOM_MILKSHAKE = (new FoodProperties.Builder()).alwaysEat().nutrition(6).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoCompat.BLAST_ENDURANCE, 600), 1.0F).alwaysEat().build();

        public static final FoodProperties ICE_CREAM_CONE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.3F).build();
        public static final FoodProperties ADZUKI_ICE_CREAM_CONE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoCompat.HARMONY, 200), 1.0F).build();
        public static final FoodProperties BANANA_ICE_CREAM_CONE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoCompat.AGILITY, 400), 1.0F).build();
        public static final FoodProperties CHOCOLATE_ICE_CREAM_CONE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoCompat.SUGAR_RUSH, 200, 2), 1.0F).build();
        public static final FoodProperties MINT_ICE_CREAM_CONE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoCompat.BERSERKING, 550), 1.0F).build();
        public static final FoodProperties VANILLA_ICE_CREAM_CONE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoCompat.VANILLA_SCENT, 140), 1.0F).build();
        public static final FoodProperties NEAPOLITAN_ICE_CREAM_SANDWICH = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoCompat.SUGAR_RUSH, 200, 2), 1.0F).effect(() -> new MobEffectInstance(CosmoCompat.VANILLA_SCENT, 100), 1.0F).build();

        public static final FoodProperties APPLE_ICE_CREAM_CONE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoEffects.EXUBERANT.get(), 200), 1.0F).build();
        public static final FoodProperties GLOW_BERRY_ICE_CREAM_CONE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoEffects.TRACER.get(), 200, 2), 1.0F).build();
        public static final FoodProperties CLASSIC_ICE_CREAM = (new FoodProperties.Builder()).nutrition(12).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoEffects.EXUBERANT.get(), 1200, 1), 1.0F).effect(() -> new MobEffectInstance(CosmoEffects.TRACER.get(), 400, 2), 1.0F).build();
        public static final FoodProperties CLASSIC_ICE_CREAM_SANDWICH = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoEffects.EXUBERANT.get(), 1200), 1.0F).effect(() -> new MobEffectInstance(CosmoEffects.TRACER.get(), 200, 2), 1.0F).build();

        public static final FoodProperties CHORUS_ICE_CREAM_CONE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoCompat.RESONANCE, 400), 1.0F).build();
        public static final FoodProperties WARZIPAN_ICE_CREAM_CONE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoCompat.MODULATION, 600), 1.0F).build();
        public static final FoodProperties JELLY_RING_ICE_CREAM_CONE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoCompat.FUCHSIA_GOO, 200), 1.0F).build();
        public static final FoodProperties AZURE_BERRY_ICE_CREAM_CONE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoCompat.SPACE_DIVING, 600, 2), 1.0F).build();
        public static final FoodProperties MIDNIGHT_ICE_CREAM_CONE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoCompat.MORGOTH, 200), 1.0F).build();
        public static final FoodProperties STARCLOUD_ICE_CREAM_CONE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoCompat.EARENDEL, 200, 2), 1.0F).build();
        public static final FoodProperties EXQUISITE_ICE_CREAM = (new FoodProperties.Builder()).nutrition(12).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoCompat.RESONANCE, 800), 1.0F).effect(() -> new MobEffectInstance(CosmoCompat.FUCHSIA_GOO, 600), 1.0F).effect(() -> new MobEffectInstance(CosmoCompat.MORGOTH, 800), 1.0F).build();
        public static final FoodProperties EXQUISITE_ICE_CREAM_SANDWICH = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoCompat.RESONANCE, 400), 1.0F).effect(() -> new MobEffectInstance(CosmoCompat.FUCHSIA_GOO, 300), 1.0F).effect(() -> new MobEffectInstance(CosmoCompat.MORGOTH, 400), 1.0F).build();

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
        public static final FoodProperties MATCHA_ICE_CREAM_CONE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoCompat.TEA_POLYPHENOLS, 160, 1), 1.0F).effect(() -> new MobEffectInstance(CosmoCompat.CAFFEINATED, 100), 1.0F).build();
        public static final FoodProperties DELIGHTFUL_ICE_CREAM = (new FoodProperties.Builder()).nutrition(12).saturationMod(0.3F).effect(() -> new MobEffectInstance(MobEffects.WATER_BREATHING, 500), 1.0F).effect(() -> new MobEffectInstance(CosmoCompat.TEA_POLYPHENOLS, 400), 1.0F).effect(() -> new MobEffectInstance(CosmoCompat.CAFFEINATED, 300), 1.0F).effect(() -> new MobEffectInstance(CosmoCompat.MANA_REGEN, 600), 1.0F).build();
        public static final FoodProperties DELIGHTFUL_ICE_CREAM_SANDWICH = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.3F).effect(() -> new MobEffectInstance(MobEffects.WATER_BREATHING, 250), 1.0F).effect(() -> new MobEffectInstance(CosmoCompat.TEA_POLYPHENOLS, 200), 1.0F).effect(() -> new MobEffectInstance(CosmoCompat.CAFFEINATED, 150), 1.0F).effect(() -> new MobEffectInstance(CosmoCompat.MANA_REGEN, 300), 1.0F).build();

        public static final FoodProperties LIME_ICE_CREAM_CONE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoCompat.CORROSION, 400, 1), 1.0F).build();
        public static final FoodProperties POMEGRANATE_ICE_CREAM_CONE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoCompat.VOLATILITY, 540, 1), 1.0F).build();
        public static final FoodProperties PINK_DRAGON_FRUIT_ICE_CREAM_CONE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoCompat.SURGE, 540), 1.0F).build();
        public static final FoodProperties LUCUMA_ICE_CREAM_CONE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoCompat.REBOUND, 540), 1.0F).build();
        public static final FoodProperties COLLECTIVE_ICE_CREAM = (new FoodProperties.Builder()).nutrition(12).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoCompat.CORROSION, 600, 1), 1.0F).effect(() -> new MobEffectInstance(CosmoCompat.VOLATILITY, 600, 1), 1.0F).effect(() -> new MobEffectInstance(CosmoCompat.SURGE, 600), 1.0F).build();
        public static final FoodProperties COLLECTIVE_ICE_CREAM_SANDWICH = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoCompat.CORROSION, 300, 1), 1.0F).effect(() -> new MobEffectInstance(CosmoCompat.VOLATILITY, 300, 1), 1.0F).effect(() -> new MobEffectInstance(CosmoCompat.SURGE, 600), 1.0F).build();
        public static final FoodProperties SUNNY_ICE_CREAM_SANDWICH = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoCompat.REBOUND, 800, 1), 1.0F).effect(() -> new MobEffectInstance(CosmoCompat.VANILLA_SCENT, 100), 1.0F).effect(() -> new MobEffectInstance(CosmoCompat.SURGE, 600), 1.0F).build();

        public static final FoodProperties GREEN_TEA_ICE_CREAM_CONE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoCompat.VITALITY, 200, 1), 1.0F).build();
        public static final FoodProperties YELLOW_TEA_ICE_CREAM_CONE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoCompat.TENACITY, 200, 1), 1.0F).build();
        public static final FoodProperties BLACK_TEA_ICE_CREAM_CONE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoCompat.MATURITY, 200, 1), 1.0F).build();
        public static final FoodProperties COFFEE_ICE_CREAM_CONE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoCompat.CAFFEINATED_ICE_CREAM, 400, 2), 1.0F).build();
        public static final FoodProperties RESPITEFUL_ICE_CREAM_SANDWICH = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoCompat.VITALITY, 460), 1.0F).effect(() -> new MobEffectInstance(CosmoCompat.TENACITY, 460), 1.0F).effect(() -> new MobEffectInstance(CosmoCompat.MATURITY, 460), 1.0F).build();

        public static final FoodProperties ASTERA_ICE_CREAM_CONE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoCompat.STAR_LIGHT, 400), 1.0F).build();
        public static final FoodProperties BROCCOLI_ICE_CREAM_CONE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoCompat.POISON_RESISTANCE, 400), 1.0F).build();
        public static final FoodProperties FROST_ICE_CREAM_CONE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoCompat.FROST_RESISTANCE_SMC, 400), 1.0F).build();
        public static final FoodProperties SMC_ICE_CREAM_SANDWICH = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoCompat.STAR_LIGHT, 600), 1.0F).effect(() -> new MobEffectInstance(CosmoCompat.POISON_RESISTANCE, 600), 1.0F).effect(() -> new MobEffectInstance(CosmoCompat.FROST_RESISTANCE_SMC, 600), 1.0F).build();
        public static final FoodProperties RAINBOW_ICE_CREAM_SANDWICH_SMC = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoCompat.RAINBOW, 460), 1.0F).build();

        public static final FoodProperties GLOWY_ICE_CREAM_CONE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.3F).effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, 400), 1.0F).build();
        public static final FoodProperties FLAVORED_ICE_CREAM_CONE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.3F).effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 400), 1.0F).build();
        public static final FoodProperties TRICOLORED_ICE_CREAM_SANDWICH = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoCompat.PURE_MIND, 100), 1.0F).build();

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

        //bnc
        public static final FoodProperties ALCOHOL_DRINK = (new FoodProperties.Builder()).effect(() -> new MobEffectInstance(CosmoCompat.TIPSY, 1200), 1.0F).effect(() -> new MobEffectInstance(CosmoCompat.INTOXICATION, 1200), 1.0F).alwaysEat().build();
        public static final FoodProperties NEVERENDING_NIGHT = (new FoodProperties.Builder()).effect(() -> new MobEffectInstance(CosmoCompat.TIPSY, 1200, 1), 1.0F).effect(() -> new MobEffectInstance(CosmoCompat.INTOXICATION, 1200), 1.0F).effect(() -> new MobEffectInstance(CosmoCompat.MANA_REGEN, 1200), 1.0F).effect(() -> new MobEffectInstance(CosmoCompat.FRESH_COOL, 600), 1.0F).alwaysEat().build();
        public static final FoodProperties MORNING_FOG = (new FoodProperties.Builder()).effect(() -> new MobEffectInstance(CosmoCompat.TIPSY, 1200, 1), 1.0F).effect(() -> new MobEffectInstance(CosmoCompat.INTOXICATION, 1200), 1.0F).effect(() -> new MobEffectInstance(CosmoCompat.EARENDEL, 1200), 1.0F).effect(() -> new MobEffectInstance(CosmoCompat.FEVER_SPICY, 600), 1.0F).alwaysEat().build();
        public static final FoodProperties GREEN_BEER = (new FoodProperties.Builder()).effect(() -> new MobEffectInstance(CosmoCompat.TIPSY, 1200, 1), 1.0F).effect(() -> new MobEffectInstance(CosmoCompat.INTOXICATION, 1200), 1.0F).effect(() -> new MobEffectInstance(MobEffects.LUCK, 1200), 1.0F).alwaysEat().build();

        public static final FoodProperties ROOT_BEER = (new FoodProperties.Builder()).effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 100), 1.0F).alwaysEat().build();
        public static final FoodProperties ICE_CREAM_FLOAT = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.3F).effect(() -> new MobEffectInstance(CosmoCompat.VANILLA_SCENT, 200), 1.0F).alwaysEat().build();
        public static final FoodProperties BLACK_COW = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.3F).effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 100), 1.0F).effect(() -> new MobEffectInstance(CosmoCompat.VANILLA_SCENT, 200), 1.0F).alwaysEat().build();

        public static final FoodProperties TWILIGHT_CHARTREUSE = (new FoodProperties.Builder()).effect(() -> new MobEffectInstance(CosmoCompat.TIPSY, 1800), 1.0F).effect(() -> new MobEffectInstance(CosmoCompat.INTOXICATION, 1800), 1.0F).effect(() -> new MobEffectInstance(CosmoCompat.POISON_RANGE, 1200), 1.0F).alwaysEat().build();
        public static final FoodProperties SMOGGY_APEROL = (new FoodProperties.Builder()).effect(() -> new MobEffectInstance(CosmoCompat.TIPSY, 1800), 1.0F).effect(() -> new MobEffectInstance(CosmoCompat.INTOXICATION, 1800), 1.0F).effect(() -> new MobEffectInstance(CosmoEffects.VARDOGER.get(), 1200), 1.0F).alwaysEat().build();
        public static final FoodProperties EXOTIC_MIRAGE = (new FoodProperties.Builder()).effect(() -> new MobEffectInstance(CosmoCompat.TIPSY, 1800, 2), 1.0F).effect(() -> new MobEffectInstance(CosmoCompat.INTOXICATION, 1800), 1.0F).effect(() -> new MobEffectInstance(MobEffects.BLINDNESS, 1200), 1.0F).effect(() -> new MobEffectInstance(CosmoCompat.AURORA, 1200), 1.0F).effect(() -> new MobEffectInstance(CosmoEffects.ABYSMAL_TORCH.get(), -1, 2), 1.0F).alwaysEat().build();

        //misc
        public static final FoodProperties LLAMA_MARSHMALLOW = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.5F).effect(() -> new MobEffectInstance(MobEffects.SLOW_FALLING, 200), 1.0F).alwaysEat().build();
        public static final FoodProperties LLAMA_MARSHMALLOW_BROWN = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.5F).effect(() -> new MobEffectInstance(MobEffects.JUMP, 200), 1.0F).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200), 1.0F).alwaysEat().build();
        public static final FoodProperties LLAMA_MARSHMALLOW_TRADER = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.5F).effect(() -> new MobEffectInstance(MobEffects.LEVITATION, 200), 1.0F).effect(() -> new MobEffectInstance(MobEffects.INVISIBILITY, 200), 1.0F).alwaysEat().build();

        public static final FoodProperties WOODLAND_SUB = (new FoodProperties.Builder()).nutrition(10).saturationMod(1.2F).build();
        public static final FoodProperties TRAVELERS_PANINI = (new FoodProperties.Builder()).nutrition(10).saturationMod(1.0F).effect(() -> new MobEffectInstance(MobEffects.LUCK, 600), 1.0F).effect(() -> new MobEffectInstance(MobEffects.INVISIBILITY, 600), 1.0F).build();
        public static final FoodProperties WATER_PIE = (new FoodProperties.Builder()).nutrition(8).saturationMod(0.2F).build();
        public static final FoodProperties WATER_PIE_SLICE = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.2F).fast().build();
        public static final FoodProperties SHOOFLY_PIE = (new FoodProperties.Builder()).nutrition(12).saturationMod(0.2F).build();
        public static final FoodProperties SHOOFLY_PIE_SLICE = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.2F).fast().build();
        public static final FoodProperties MOSS_PIE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.2F).effect(() -> new MobEffectInstance(CosmoEffects.TRACER.get(), 600), 1.0F).build();
        public static final FoodProperties MOSS_PIE_SLICE = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.2F).fast().effect(() -> new MobEffectInstance(CosmoEffects.TRACER.get(), 125), 1.0F).build();

        public static final FoodProperties CHARD = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.6F).fast().build();
        public static final FoodProperties CHARD_ROLLS = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.8F).build();
        public static final FoodProperties DRIPLEAF_ROLL = (new FoodProperties.Builder()).nutrition(4).saturationMod(1F).effect(() -> new MobEffectInstance(CosmoCompat.PEACE, 400), 1.0F).build();

        public static final FoodProperties TUBER = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.4F).effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 200), 0.3F).effect(() -> new MobEffectInstance(CosmoEffects.INGRAINED.get(), 300), 1.0F).build();
        public static final FoodProperties CUT_TUBERS = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.2F).effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 100), 0.3F).effect(() -> new MobEffectInstance(CosmoEffects.INGRAINED.get(), 150), 1.0F).fast().build();
        public static final FoodProperties TUBER_CHIPS = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.2F).effect(() -> new MobEffectInstance(CosmoEffects.INGRAINED.get(), 150), 1.0F).fast().build();
        public static final FoodProperties TUBER_CHIP_BAG = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.2F).effect(() -> new MobEffectInstance(CosmoEffects.INGRAINED.get(), 200), 1.0F).build();

        public static final FoodProperties ROASTED_TUBER = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.6F).effect(() -> new MobEffectInstance(CosmoEffects.INGRAINED.get(), 600), 1.0F).build();
        public static final FoodProperties TUBER_PUREE = (new FoodProperties.Builder()).nutrition(7).saturationMod(0.6F).effect(() -> new MobEffectInstance(CosmoEffects.INGRAINED.get(), 1800), 1.0F).build();
        public static final FoodProperties TUBER_PUREE_CONE = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.6F).effect(() -> new MobEffectInstance(CosmoEffects.INGRAINED.get(), 600), 1.0F).build();

        public static final FoodProperties HERBAL_COOKIE = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.1F).alwaysEat().fast().build();

        public static final FoodProperties SPINALBERRY = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.2F).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200), 0.2F).effect(() -> new MobEffectInstance(MobEffects.BLINDNESS, 200), 0.2F).build();
        public static final FoodProperties BOILBERRY = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.2F).effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 200), 0.2F).effect(() -> new MobEffectInstance(MobEffects.WITHER, 200), 0.2F).fast().build();

        public static final FoodProperties ARBUTUS_BERRIES = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.2F).effect(() -> new MobEffectInstance(CosmoEffects.PHOTOTAXIS.get(), 200), 1.0F).build();
        public static final FoodProperties GOLDEN_ARBUTUS_BERRIES =  (new FoodProperties.Builder()).nutrition(4).saturationMod(1.0F).effect(() -> new MobEffectInstance(CosmoEffects.PHOTOTAXIS.get(), 600), 1.0F).effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 600, 1), 1.0F).alwaysEat().build();
        public static final FoodProperties ENCHANTED_GOLDEN_ARBUTUS_BERRIES =  (new FoodProperties.Builder()).nutrition(4).saturationMod(1.0F).effect(() -> new MobEffectInstance(MobEffects.GLOWING, 1200), 1.0F).effect(() -> new MobEffectInstance(CosmoEffects.PHOTOTAXIS.get(), 1200, 1), 1.0F).effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 1200, 1), 1.0F).alwaysEat().build();
        public static final FoodProperties LUSH_CONFITURE_BOTTLE = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.1F).effect(() -> new MobEffectInstance(CosmoEffects.PHOTOTAXIS.get(), 600), 1.0F).effect(() -> new MobEffectInstance(CosmoEffects.TRACER.get(), 600), 1.0F).build();;
        public static final FoodProperties TUBER_PUREE_WITH_CONFITURE = (new FoodProperties.Builder()).nutrition(12).saturationMod(0.5F).effect(() -> new MobEffectInstance(CosmoEffects.INGRAINED.get(), 1800), 1.0F).effect(() -> new MobEffectInstance(CosmoEffects.PHOTOTAXIS.get(), 600), 1.0F).effect(() -> new MobEffectInstance(CosmoEffects.TRACER.get(), 600), 1.0F).build();
        public static final FoodProperties TUBER_PUREE_CONE_WITH_CONFITURE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.5F).effect(() -> new MobEffectInstance(CosmoEffects.INGRAINED.get(), 600), 1.0F).effect(() -> new MobEffectInstance(CosmoEffects.PHOTOTAXIS.get(), 200), 1.0F).effect(() -> new MobEffectInstance(CosmoEffects.TRACER.get(), 200), 1.0F).build();
        public static final FoodProperties ARBUTUS_BERRY_COOKIE = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.1F).fast().effect(() -> new MobEffectInstance(CosmoEffects.PHOTOTAXIS.get(), 100), 1.0F).build();

        public static final FoodProperties COFFEE = (new FoodProperties.Builder()).effect(() -> new MobEffectInstance(CosmoCompat.CAFFEINATED,  CosmoCompat.CAFFEINATED_DURATION(5400), 1), 1.0F).alwaysEat().build();
        public static final FoodProperties CHA_JAU = (new FoodProperties.Builder()).effect(() -> new MobEffectInstance(CosmoCompat.CAFFEINATED,  CosmoCompat.CAFFEINATED_DURATION(2400), 1), 1.0F).alwaysEat().fast().build();
        public static final FoodProperties ORANGE_AMERICANO = (new FoodProperties.Builder()).effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 1200), 1.0F).effect(() -> new MobEffectInstance(CosmoCompat.CAFFEINATED, CosmoCompat.CAFFEINATED_DURATION(3200)), 1.0F).alwaysEat().build();
        public static final FoodProperties CHORUS_FRUIT_AMERICANO = (new FoodProperties.Builder()).effect(() -> new MobEffectInstance(CosmoCompat.CHORUS_FRUIT, 1200), 1.0F).effect(() -> new MobEffectInstance(CosmoCompat.CAFFEINATED, CosmoCompat.CAFFEINATED_DURATION(3200)), 1.0F).alwaysEat().build();
        public static final FoodProperties BROCCOLI_AMERICANO = (new FoodProperties.Builder()).effect(() -> new MobEffectInstance(CosmoCompat.POISON_RESISTANCE, 1200), 1.0F).effect(() -> new MobEffectInstance(CosmoCompat.CAFFEINATED, CosmoCompat.CAFFEINATED_DURATION(3200)), 1.0F).alwaysEat().build();

        public static final FoodProperties MOCHA = (new FoodProperties.Builder()).nutrition(2).effect(() -> new MobEffectInstance(CosmoCompat.SUGAR_RUSH, 1600, 1), 1.0F).effect(() -> new MobEffectInstance(CosmoCompat.CAFFEINATED, CosmoCompat.CAFFEINATED_DURATION(3200)), 1.0F).alwaysEat().build();
        public static final FoodProperties MATE = (new FoodProperties.Builder()).effect(() -> new MobEffectInstance(CosmoCompat.THORNS, 600), 1.0F).effect(() -> new MobEffectInstance(CosmoCompat.CAFFEINATED, CosmoCompat.CAFFEINATED_DURATION(2400)), 1.0F).alwaysEat().build();
        public static final FoodProperties TEA = (new FoodProperties.Builder()).effect(() -> new MobEffectInstance(CosmoCompat.TEA_POLYPHENOLS, 800), 1.0F).alwaysEat().build();
        public static final FoodProperties DANDELION_COFFEE = (new FoodProperties.Builder()).effect(() -> new MobEffectInstance(CosmoEffects.COMFORT.get(), 4800), 1.0F).alwaysEat().build();
        public static final FoodProperties COMFORT_DRINK = (new FoodProperties.Builder()).effect(() -> new MobEffectInstance(CosmoEffects.COMFORT.get(), 1200), 1.0F).alwaysEat().build();

        public static final FoodProperties CAVE_CONE = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.8F).build();
        public static final FoodProperties ABYSSAL_CAVE_CONE = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.8F).effect(() -> new MobEffectInstance(CosmoCompat.DEEPSIGHT, 400), 1.0F).build();
        public static final FoodProperties CANDY_CAVE_CONE = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.8F).effect(() -> new MobEffectInstance(CosmoCompat.SUGAR_RUSH_ALEX, 200), 0.2F).build();
        public static final FoodProperties PRIMORDIAL_CAVE_CONE = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.8F).effect(() -> new MobEffectInstance(CosmoCompat.RAGE, 600), 1.0F).build();
        public static final FoodProperties MAGNETIC_CAVE_CONE = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.8F).effect(() -> new MobEffectInstance(CosmoCompat.MAGNETIZING, 600), 1.0F).build();

        public static final FoodProperties ORGANIC_MUFFIN = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.8F).effect(() -> new MobEffectInstance(CosmoCompat.POISON_RESISTANCE, 200), 0.5F).effect(() -> new MobEffectInstance(CosmoCompat.SWEET_BERRIES, 100), 0.25F).build();

        public static final FoodProperties BAGEL = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.6F).build();
        public static final FoodProperties BAGEL_SANDWICH = (new FoodProperties.Builder()).nutrition(8).saturationMod(0.6F).build();
        public static final FoodProperties BACON_EGG_BAGEL = (new FoodProperties.Builder()).nutrition(9).saturationMod(0.8F).build();
        public static final FoodProperties BERRY_CREAM_CHEESE_BAGEL = (new FoodProperties.Builder()).nutrition(7).saturationMod(0.8F).build();
        public static final FoodProperties MATCHA_CREAM_INK_BAGEL = (new FoodProperties.Builder()).nutrition(7).saturationMod(0.8F).effect(() -> new MobEffectInstance(CosmoCompat.TEA_POLYPHENOLS, 800), 1.0F).effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 200), 1.0F).build();
        public static final FoodProperties NEAPOLITAN_ICE_CREAM_BAGEL = (new FoodProperties.Builder()).nutrition(8).saturationMod(0.6F).effect(() -> new MobEffectInstance(CosmoCompat.SUGAR_RUSH, 200, 2), 1.0F).effect(() -> new MobEffectInstance(CosmoCompat.VANILLA_SCENT, 100), 1.0F).build();
    }

}


package com.gumillea.cosmopolitan;

import com.teamabnormals.blueprint.core.annotations.ConfigKey;
import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public class CosmoConfig
{
    public static final ForgeConfigSpec COMMON_SPEC;
    public static final CosmoConfig.Common COMMON;

    public static final ForgeConfigSpec CLIENT_SPEC;
    public static final CosmoConfig.Client CLIENT;

    static {
        final Pair<CosmoConfig.Common, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(CosmoConfig.Common::new);
        COMMON_SPEC = specPair.getRight();
        COMMON = specPair.getLeft();

        Pair<CosmoConfig.Client, ForgeConfigSpec> clientSpecPair = new ForgeConfigSpec.Builder().configure(CosmoConfig.Client::new);
        CLIENT_SPEC = clientSpecPair.getRight();
        CLIENT = clientSpecPair.getLeft();
    }

    public static class Common {
        @ConfigKey("enable_apple_flavor")
        public static ForgeConfigSpec.BooleanValue APPLE_FLAVOR;
        @ConfigKey("enable_carrot_flavor")
        public static ForgeConfigSpec.BooleanValue CARROT_FLAVOR;
        @ConfigKey("enable_glow_berry_flavor")
        public static ForgeConfigSpec.BooleanValue GLOW_BERRY_FLAVOR;
        @ConfigKey("enable_flavored_syrup")
        public static ForgeConfigSpec.BooleanValue FLAVORED_SYRUP;

        @ConfigKey("enable_enchanted_fruit_flavor")
        public static ForgeConfigSpec.BooleanValue ENCHANTED_FRUIT_FLAVOR;
        @ConfigKey("enable_kabloom_flavor")
        public static ForgeConfigSpec.BooleanValue KABLOOM_FLAVOR;
        @ConfigKey("enable_source_berry_flavor")
        public static ForgeConfigSpec.BooleanValue SOURCE_BERRY_FLAVOR;
        @ConfigKey("enable_blisterberry_flavor")
        public static ForgeConfigSpec.BooleanValue BLISTERBERRY_FLAVOR;
        @ConfigKey("enable_droopfruit_flavor")
        public static ForgeConfigSpec.BooleanValue DROOPFRUIT_FLAVOR;
        public static ForgeConfigSpec.BooleanValue MORE_INGRAINED_SOURCES;

        @ConfigKey("enable_gulime")
        public static ForgeConfigSpec.BooleanValue GULIME;
        @ConfigKey("enable_cosmopolitan")
        public static ForgeConfigSpec.BooleanValue COSMOPOLITAN_COCKTAIL;

        public static ForgeConfigSpec.BooleanValue FOOD_MODIFICATION;
        public static ForgeConfigSpec.BooleanValue CAFFEINE_TWEAKS;

        @ConfigKey("bg_tweaks")
        public static ForgeConfigSpec.BooleanValue BERRY_GOOD_COMPAT_TWEAKS;
        @ConfigKey("create_neapolitan_recipe_tweaks")
        public static ForgeConfigSpec.BooleanValue CREATE_NEAPOLITAN_RECIPE_TWEAKS;
        @ConfigKey("tfd_recipe_tweaks")
        public static ForgeConfigSpec.BooleanValue TWILIGHT_DELIGHT_RECIPE_TWEAKS;
        @ConfigKey("seasonals_recipe_tweaks")
        public static ForgeConfigSpec.BooleanValue SEASONALS_RECIPE_TWEAKS;

        public static ForgeConfigSpec.BooleanValue EXUBERANT_BALANCE;
        public static ForgeConfigSpec.DoubleValue EXUBERANT_MAXIMUM;
        public static ForgeConfigSpec.DoubleValue BLISTERBERRY_CHANCE;

        public static ForgeConfigSpec.DoubleValue SOUR_RATE;
        public static ForgeConfigSpec.DoubleValue SWEET_RATE;
        public static ForgeConfigSpec.DoubleValue BITTER_RATE;
        public static ForgeConfigSpec.DoubleValue SPICY_RATE;

        public static ForgeConfigSpec.DoubleValue SOUR_ARMOR;
        public static ForgeConfigSpec.DoubleValue SWEET_HEALING;
        public static ForgeConfigSpec.IntValue BITTER_EXP;
        public static ForgeConfigSpec.DoubleValue SPICY_DMG;

        public static ForgeConfigSpec.IntValue PLACEABLE_FOOD_SETTING;
        public static ForgeConfigSpec.IntValue GULIME_TICK;
        public static ForgeConfigSpec.DoubleValue GULIME_CHANCE;
        public static ForgeConfigSpec.DoubleValue WILDBERRY_CHANCE;
        public static ForgeConfigSpec.DoubleValue BOILBERRY_CHANCE;
        public static ForgeConfigSpec.DoubleValue SPINALBERRY_CHANCE;

        Common(ForgeConfigSpec.Builder builder) {
            builder.push("Items");
            PLACEABLE_FOOD_SETTING = builder.comment("Defines the usage modes for placeable food (0 - Can only be eaten as an item; 1 - Can be eaten as an item, or placed as a block while sneaking; 2 - Can only be placed as a block).")
                    .defineInRange("placeableFoodSetting", 1, 0, 2);
            GULIME = builder.comment("Allows Gulime and its biome varieties.")
                    .define("gulime", true);
            GULIME_TICK = builder.comment("Defines the interval in ticks between each Gulime regeneration check")
                    .defineInRange("gulimeTick", 1200, 100, Integer.MAX_VALUE);
            GULIME_CHANCE = builder.comment("Defines the chance of successful Gulime regeneration at each check")
                    .defineInRange("gulimeChance", 0.6, 0.01, 1);
            WILDBERRY_CHANCE = builder.comment("Defines the chance of triggering the Wildberry special effect")
                    .defineInRange("wildberryChance", 0.1, 0.01, 1);
            BOILBERRY_CHANCE = builder.comment("Defines the drop rate for Boilberry")
                    .defineInRange("boilberryChance", 0.25, 0, 1);
            SPINALBERRY_CHANCE = builder.comment("Defines the drop rate for Spinalberry")
                    .defineInRange("spinalberryChance", 0.4, 0, 1);
            COSMOPOLITAN_COCKTAIL = builder.comment("Allows Cosmopolitan Cocktail and its enchanted variety.")
                    .define("cosmopolitanCocktail", true);
            builder.pop();
            builder.push("Flavors");
            builder.push("Basic Flavors");
            APPLE_FLAVOR = builder.comment("Allows Apple to be crafted into desserts such as ice cream and apply specific mob effects.")
                    .define("appleFlavor", true);
            CARROT_FLAVOR = builder.comment("Allows Carrot to be crafted into desserts such as ice cream and apply specific mob effects.")
                    .define("carrotFlavor", true);
            GLOW_BERRY_FLAVOR = builder.comment("Allows Glow Berries to be crafted into desserts such as ice cream and apply specific mob effects.")
                    .define("glowBerryFlavor", true);
            FLAVORED_SYRUP = builder.comment("Allow the crafting of Berry Syrup Bottles in different flavors and enable the seasoning mechanism.")
                    .define("flavoredSyrup", true);
            MORE_INGRAINED_SOURCES = builder.comment("Allow food from other mods to serve as a source of the Ingrained effect, such as the Cave Carrot from Miner's Delight.")
                    .define("moreIngrainedSource", true);
            builder.pop();
            builder.push("Compatible Flavors");
            ENCHANTED_FRUIT_FLAVOR = builder.comment("Allows Enchanted Fruit to be crafted into desserts such as ice cream and apply specific mob effects when Quark is installed.")
                    .define("enchantedFruitFlavor", true);
            KABLOOM_FLAVOR = builder.comment("Allows Kabloom Pulp to be crafted into desserts such as ice cream and apply specific mob effects when Habitat is installed.")
                    .define("kabloomFlavor", true);
            SOURCE_BERRY_FLAVOR = builder.comment("Allows Source Berry to be crafted into desserts such as ice cream and apply specific mob effects when Ars Nouveau is installed.")
                    .define("sourceBerryFlavor", true);
            BLISTERBERRY_FLAVOR = builder.comment("Allows Blisterberry to be crafted into desserts such as ice cream and apply specific mob effects when Undergarden is installed.")
                    .define("blisterberryFlavor", true);
            DROOPFRUIT_FLAVOR = builder.comment("Allows Droopfruit to be crafted into desserts such as ice cream and apply specific mob effects when Undergarden is installed.")
                    .define("droopfruitFlavor", true);
            builder.pop();
            builder.pop();
            builder.push("Effects");
            EXUBERANT_BALANCE = builder.comment("Allows the ending effect of Exuberant to be changed to restore health.")
                    .define("exuberantBalance", false);
            EXUBERANT_MAXIMUM = builder.comment("Defines the maximum extra health generated by the Exuberance effect (based on user's max health percentage)")
                    .defineInRange("exuberantMaximum", 0.3, 0.1, 1.0);
            BLISTERBERRY_CHANCE = builder.comment("Defines the chance of triggering the Vardøgerx's damage doubling effect.")
                    .defineInRange("blisterberryChance", 0.15, 0.01, 1.0);
            SOUR_RATE = builder.comment("Defines the multiplier for effect duration for the Sour flavor.")
                    .defineInRange("sourRate", 0.2, 0.01, 1.0);
            SOUR_ARMOR = builder.comment("Defines the armor reduction amount for the sour flavor.")
                    .defineInRange("sourArmor", 1.5, 0.01, Double.MAX_VALUE);
            SWEET_RATE = builder.comment("Defines the rate of reduction in the effect duration for the Sweet flavor.")
                    .defineInRange("sweetRate", 0.2, 0.01, 1.0);
            SWEET_HEALING = builder.comment("Defines the amount of healing provided by the Sweet flavor.")
                    .defineInRange("sweetHealing", 0.5, 0.01, Double.MAX_VALUE);
            BITTER_RATE = builder.comment("Defines the multiplier for effect duration for the Bitter flavor.")
                    .defineInRange("bitterRate", 0.2, 0.01, 1.0);
            BITTER_EXP = builder.comment("Defines the amount of experience granted by the Bitter flavor.")
                    .defineInRange("bitterExp", 5, 1, Integer.MAX_VALUE);
            SPICY_RATE = builder.comment("Defines the rate of reduction in the effect duration for the Spicy flavor.")
                    .defineInRange("spicyRate", 0.2, 0.01, 1.0);
            SPICY_DMG = builder.comment("Defines the amount of damage dealt by the Spicy flavor.")
                    .defineInRange("spicyDmg", 2, 0.01, Double.MAX_VALUE);
            builder.pop();
            builder.push("Tweaks");
            FOOD_MODIFICATION = builder.comment("Allows the food modifications for vanilla and compatible mods.").define("enableModifications", true);
            CAFFEINE_TWEAKS = builder.comment("Allows players to delay the spawning of Phantoms while gaining the Caffeine effect from Farmer's Respite.").define("enableCaffeineTweak", true);
            builder.push("Farming");
            BERRY_GOOD_COMPAT_TWEAKS = builder.comment("Allows tweaks to some of the recipes in Twilight's Flavours & Delights.").define("berryGoodTweaks", true);
            builder.pop();
            builder.push("Recipes");
            CREATE_NEAPOLITAN_RECIPE_TWEAKS = builder.comment("Allows tweaks to Neapolitan's recipes for Create machines.").define("createNeapolitanRecipeTweaks", true);
            TWILIGHT_DELIGHT_RECIPE_TWEAKS = builder.comment("Allows tweaks to some of the recipes in Twilight's Flavours & Delights.").define("tfdRecipeTweaks", true);
            SEASONALS_RECIPE_TWEAKS = builder.comment("Allows tweaks to some of the recipes in Seasonals.").define("seasonalsRecipeTweaks", true);
            builder.pop();
            builder.pop();
        }
    }

    public static class Client {
        public static ForgeConfigSpec.BooleanValue EFFECT_TOOLTIP;
        public static ForgeConfigSpec.BooleanValue SEASONED_EFFECT_ICON;
        public static ForgeConfigSpec.BooleanValue WILDBERRY_DISPLAY;
        Client(ForgeConfigSpec.Builder builder) {
            EFFECT_TOOLTIP = builder.comment("Allows food items to display their mob effects in tooltips.")
                    .define("effectTooltip",  true);
            SEASONED_EFFECT_ICON = builder.comment("Allows the seasoned effect to display a special icon background.")
                    .define("seasonedEffectIcon",  true);
            WILDBERRY_DISPLAY = builder.comment("Allows Wildberry to be displayed in various textures.")
                    .define("wildberryDisplay", true);
        }
    }
}

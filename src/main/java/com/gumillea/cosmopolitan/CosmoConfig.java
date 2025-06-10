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

        @ConfigKey("enable_gulime")
        public static ForgeConfigSpec.BooleanValue GULIME;
        @ConfigKey("enable_cosmopolitan")
        public static ForgeConfigSpec.BooleanValue COSMOPOLITAN_COCKTAIL;

        public static ForgeConfigSpec.BooleanValue FOOD_MODIFICATION;
        @ConfigKey("bg_tweaks")
        public static ForgeConfigSpec.BooleanValue BERRY_GOOD_COMPAT_TWEAKS;
        @ConfigKey("create_neapolitan_recipe_tweaks")
        public static ForgeConfigSpec.BooleanValue CREATE_NEAPOLITAN_RECIPE_TWEAKS;
        @ConfigKey("tfd_recipe_tweaks")
        public static ForgeConfigSpec.BooleanValue TWILIGHT_DELIGHT_RECIPE_TWEAKS;
        @ConfigKey("seasonals_recipe_tweaks")
        public static ForgeConfigSpec.BooleanValue SEASONALS_RECIPE_TWEAKS;

        public static ForgeConfigSpec.DoubleValue EXUBERANT_MAXIMUM;
        public static ForgeConfigSpec.DoubleValue BLISTERBERRY_CHANCE;

        public static ForgeConfigSpec.IntValue GULIME_TICK;
        public static ForgeConfigSpec.DoubleValue GULIME_CHANCE;

        Common(ForgeConfigSpec.Builder builder) {
            builder.push("Items");
            GULIME = builder.comment("Allows Gulime and its biome varieties.")
                    .define("gulime", true);
            GULIME_TICK = builder.comment("Defines the interval in ticks between each Gulime regeneration check")
                    .defineInRange("gulimeTick", 1200, 100, Integer.MAX_VALUE);
            GULIME_CHANCE = builder.comment("Defines the chance of successful Gulime regeneration at each check")
                    .defineInRange("gulimeChance", 0.6, 0.01, 1);
            COSMOPOLITAN_COCKTAIL = builder.comment("Allows Cosmopolitan Cocktail and its enchanted variety.")
                    .define("cosmopolitanCocktail", true);
            builder.pop();
            builder.push("Flavors");
            builder.push("Basic Flavors");
            APPLE_FLAVOR = builder.comment("Allows Apple to be crafted into desserts such as ice cream and apply specific mob effects when Neapolitan is installed.")
                    .define("appleFlavor", true);
            CARROT_FLAVOR = builder.comment("Allows Carrot to be crafted into desserts such as ice cream and apply specific mob effects when Neapolitan is installed.")
                    .define("carrotFlavor", true);
            GLOW_BERRY_FLAVOR = builder.comment("Allows Glow Berries to be crafted into desserts such as ice cream and apply specific mob effects when Neapolitan is installed.")
                    .define("glowBerryFlavor", true);
            builder.pop();
            builder.push("Compatible Flavors");
            ENCHANTED_FRUIT_FLAVOR = builder.comment("Allows Enchanted Fruit to be crafted into desserts such as ice cream and apply specific mob effects when Neapolitan and Quark are installed.")
                    .define("enchantedFruitFlavor", true);
            KABLOOM_FLAVOR = builder.comment("Allows Kabloom Pulp to be crafted into desserts such as ice cream and apply specific mob effects when Neapolitan and Habitat are installed.")
                    .define("kabloomFlavor", true);
            SOURCE_BERRY_FLAVOR = builder.comment("Allows Source Berry to be crafted into desserts such as ice cream and apply specific mob effects when Neapolitan and Ars Nouveau are installed.")
                    .define("sourceBerryFlavor", true);
            BLISTERBERRY_FLAVOR = builder.comment("Allows Blisterberry to be crafted into desserts such as ice cream and apply specific mob effects when Neapolitan and Undergarden are installed.")
                    .define("blisterberryFlavor", true);
            DROOPFRUIT_FLAVOR = builder.comment("Allows Droopfruit to be crafted into desserts such as ice cream and apply specific mob effects when Neapolitan and Undergarden are installed.")
                    .define("droopfruitFlavor", true);
            builder.pop();
            builder.pop();
            builder.push("Effects");
            EXUBERANT_MAXIMUM = builder.comment("Defines the maximum extra health generated by the Exuberance effect (based on user's max health percentage)")
                    .defineInRange("exuberantMaximum", 0.3, 0.1, 1.0);
            BLISTERBERRY_CHANCE = builder.comment("Defines the chance of triggering the Vardøgerx's damage doubling effect.")
                    .defineInRange("blisterberryChance", 0.15, 0.01, 1.0);
            builder.pop();
            builder.push("Tweaks");
            FOOD_MODIFICATION = builder.comment("Allows the food modifications for vanilla and compatible mods.").define("enableModifications", true);
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
        Client(ForgeConfigSpec.Builder builder) {
            EFFECT_TOOLTIP = builder.comment("Allows food items to display their mob effects in tooltips.")
                    .define("effectTooltip",  true);
        }
    }
}

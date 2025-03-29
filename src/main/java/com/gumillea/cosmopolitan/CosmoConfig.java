package com.gumillea.cosmopolitan;

import com.teamabnormals.blueprint.core.annotations.ConfigKey;
import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public class CosmoConfig
{
    public static final ForgeConfigSpec COMMON_SPEC;
    public static final CosmoConfig.Common COMMON;

    static {
        final Pair<CosmoConfig.Common, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(CosmoConfig.Common::new);
        COMMON_SPEC = specPair.getRight();
        COMMON = specPair.getLeft();
    }

    public static class Common {
        @ConfigKey("tfd_recipe_tweaks")
        public static ForgeConfigSpec.BooleanValue TWILIGHT_DELIGHT_RECIPE_TWEAKS;

        Common(ForgeConfigSpec.Builder builder) {
            builder.push("Tweaks");
            builder.push("Recipes");
            TWILIGHT_DELIGHT_RECIPE_TWEAKS = builder.comment("Whether to allow tweaks to some of the recipes in Twilight's Flavours & Delights.").define("Twilight's Delights Recipe Tweaks", true);
            builder.pop();
            builder.pop();
        }
    }
}

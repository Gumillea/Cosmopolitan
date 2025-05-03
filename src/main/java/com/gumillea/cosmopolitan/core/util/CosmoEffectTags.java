package com.gumillea.cosmopolitan.core.util;

import com.gumillea.cosmopolitan.Cosmopolitan;
import com.teamabnormals.blueprint.core.util.TagUtil;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;

public class CosmoEffectTags {
    public static final TagKey<MobEffect> BLACKLIST = mobEffectTag("blacklist");
    public static final TagKey<MobEffect> CONVERTIBLE_BY_CAROTENE = mobEffectTag("convertible_by_carotene");

    public CosmoEffectTags() {}

    private static TagKey<MobEffect> mobEffectTag(String name) {
        return TagUtil.mobEffectTag(Cosmopolitan.MODID, name);
    }
}

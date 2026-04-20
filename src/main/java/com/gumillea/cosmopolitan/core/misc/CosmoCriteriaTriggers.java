package com.gumillea.cosmopolitan.core.misc;

import com.gumillea.cosmopolitan.Cosmopolitan;
import com.teamabnormals.blueprint.common.advancement.EmptyTrigger;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Cosmopolitan.MODID)
public class CosmoCriteriaTriggers {
    public static final EmptyTrigger WILDBERRY = CriteriaTriggers.register(new EmptyTrigger(prefix("wildberry")));
    public static final EmptyTrigger POTTED_CROP = CriteriaTriggers.register(new EmptyTrigger(prefix("potted_crop")));
    public static final EmptyTrigger HERBAL_COOKIE = CriteriaTriggers.register(new EmptyTrigger(prefix("herbal_cookie")));
    public static final EmptyTrigger WHEATGRASS = CriteriaTriggers.register(new EmptyTrigger(prefix("wheatgrass")));
    public static final EmptyTrigger GULIME = CriteriaTriggers.register(new EmptyTrigger(prefix("gulime")));

    public static final EmptyTrigger SOUR = CriteriaTriggers.register(new EmptyTrigger(prefix("sour")));
    public static final EmptyTrigger SWEET = CriteriaTriggers.register(new EmptyTrigger(prefix("sweet")));
    public static final EmptyTrigger BITTER = CriteriaTriggers.register(new EmptyTrigger(prefix("bitter")));
    public static final EmptyTrigger SPICY = CriteriaTriggers.register(new EmptyTrigger(prefix("spicy")));
    public static final EmptyTrigger ALL_FLAVORS = CriteriaTriggers.register(new EmptyTrigger(prefix("all_flavors")));

    private static ResourceLocation prefix(String name) {
        return new ResourceLocation(Cosmopolitan.MODID, name);
    }
}

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

    private static ResourceLocation prefix(String name) {
        return new ResourceLocation(Cosmopolitan.MODID, name);
    }
}

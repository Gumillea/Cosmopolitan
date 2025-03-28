package com.gumillea.cosmopolitan.core.reg;

import com.gumillea.cosmopolitan.Cosmopolitan;
import com.gumillea.cosmopolitan.common.effect.ExuberantEffect;
import com.teamabnormals.blueprint.common.effect.BlueprintMobEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CosmoEffects {
    public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, Cosmopolitan.MODID);

    public static final RegistryObject<MobEffect> CAROTENE = EFFECTS.register("carotene", () -> new BlueprintMobEffect(MobEffectCategory.BENEFICIAL, 0xD16035));
    public static final RegistryObject<MobEffect> EXUBERANT = EFFECTS.register("exuberant", ExuberantEffect::new);
    public static final RegistryObject<MobEffect> TRACER = EFFECTS.register("tracer", () -> new BlueprintMobEffect(MobEffectCategory.BENEFICIAL, 0xE98F3F));
    public static final RegistryObject<MobEffect> MARKED = EFFECTS.register("marked", () -> new BlueprintMobEffect(MobEffectCategory.HARMFUL, 0xE98F3F));
}

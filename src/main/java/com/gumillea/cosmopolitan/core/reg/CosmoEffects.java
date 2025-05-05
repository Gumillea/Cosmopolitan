package com.gumillea.cosmopolitan.core.reg;

import com.gumillea.cosmopolitan.CosmoConfig;
import com.gumillea.cosmopolitan.Cosmopolitan;
import com.gumillea.cosmopolitan.common.effect.ExuberantEffect;
import com.gumillea.cosmopolitan.common.effect.MarkedEffect;
import com.teamabnormals.blueprint.common.effect.BlueprintMobEffect;
import com.teamabnormals.blueprint.core.util.DataUtil;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CosmoEffects {
    public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, Cosmopolitan.MODID);
    public static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(ForgeRegistries.POTIONS, Cosmopolitan.MODID);

    public static final RegistryObject<MobEffect> CAROTENE = EFFECTS.register("carotene", () -> new BlueprintMobEffect(MobEffectCategory.BENEFICIAL, 0xD16035));
    public static final RegistryObject<MobEffect> EXUBERANT = EFFECTS.register("exuberant", ExuberantEffect::new);
    public static final RegistryObject<MobEffect> TRACER = EFFECTS.register("tracer", () -> new BlueprintMobEffect(MobEffectCategory.BENEFICIAL, 0xE98F3F));
    public static final RegistryObject<MobEffect> MARKED = EFFECTS.register("marked", MarkedEffect::new);

    public static final RegistryObject<MobEffect> ABYSMAL_TORCH = EFFECTS.register("abysmal_torch", () -> new BlueprintMobEffect(MobEffectCategory.NEUTRAL, 0x97B5D9));
    public static final RegistryObject<MobEffect> VARDOGER = EFFECTS.register("vardoger", () -> new BlueprintMobEffect(MobEffectCategory.NEUTRAL, 0xEE4A34));

    public static final RegistryObject<MobEffect> PLACEHOLDER = EFFECTS.register("placeholder", () -> new BlueprintMobEffect(MobEffectCategory.NEUTRAL, 0));

    //potions
    public static final RegistryObject<Potion> IRON_HEART = POTIONS.register("iron_heart", () -> new Potion(new MobEffectInstance(MobEffects.POISON, 800, 2), new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 600, 1)));
    public static final RegistryObject<Potion> IRON_HEART_LONG = POTIONS.register("iron_heart_long", () -> new Potion(new MobEffectInstance(MobEffects.POISON, 1600, 2), new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 1200, 1)));
    public static final RegistryObject<Potion> IRON_HEART_STRONG = POTIONS.register("iron_heart_strong", () -> new Potion(new MobEffectInstance(MobEffects.POISON, 800, 3), new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 600, 2)));

    public static void registerBrewingRecipes() {
        DataUtil.addMix(Potions.AWKWARD, CosmoItems.IRON_FIDDLEHEAD.get(), IRON_HEART.get());
        DataUtil.addMix(IRON_HEART.get(), Items.GLOWSTONE_DUST, IRON_HEART_STRONG.get());
        DataUtil.addMix(IRON_HEART.get(), Items.REDSTONE, IRON_HEART_LONG.get());
    }
}

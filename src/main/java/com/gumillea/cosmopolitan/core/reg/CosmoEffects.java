package com.gumillea.cosmopolitan.core.reg;

import com.gumillea.cosmopolitan.CosmoConfig;
import com.gumillea.cosmopolitan.Cosmopolitan;
import com.gumillea.cosmopolitan.common.effect.ExuberantEffect;
import com.gumillea.cosmopolitan.common.effect.MarkedEffect;
import com.gumillea.cosmopolitan.common.effect.PhototaxisEffect;
import com.teamabnormals.blueprint.common.effect.BlueprintMobEffect;
import com.teamabnormals.blueprint.core.util.DataUtil;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
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

    public static final RegistryObject<MobEffect> PHOTOTAXIS = EFFECTS.register("phototaxis", PhototaxisEffect::new);
    public static final RegistryObject<MobEffect> INGRAINED = EFFECTS.register("ingrained", () -> new BlueprintMobEffect(MobEffectCategory.BENEFICIAL, 0x734937));

    public static final RegistryObject<MobEffect> OBSCURE = EFFECTS.register("obscure", () -> new BlueprintMobEffect(MobEffectCategory.NEUTRAL, 0xb3f5c7));

    public static final RegistryObject<MobEffect> ABYSMAL_TORCH = EFFECTS.register("abysmal_torch", () -> new BlueprintMobEffect(MobEffectCategory.NEUTRAL, 0x97B5D9));
    public static final RegistryObject<MobEffect> VARDOGER = EFFECTS.register("vardoger", () -> new BlueprintMobEffect(MobEffectCategory.NEUTRAL, 0xEE4A34));
    //The icon and design of this status effect are based on Farmer's Delight by vectorwing: https://github.com/vectorwing/FarmersDelight/blob/1.20/src/main/java/vectorwing/farmersdelight/common/effect/ComfortEffect.java. Used and modified under the MIT License.
    public static final RegistryObject<MobEffect> COMFORT = EFFECTS.register("comfort", () -> new BlueprintMobEffect(MobEffectCategory.BENEFICIAL, 0xA6EBFF));

    public static final RegistryObject<MobEffect> PLACEHOLDER = EFFECTS.register("placeholder", () -> new BlueprintMobEffect(MobEffectCategory.NEUTRAL, 0));

    //potions
    public static final RegistryObject<Potion> IRON_HEART = POTIONS.register("iron_heart", () -> new Potion(new MobEffectInstance(MobEffects.POISON, 800, 2), new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 600, 1)));
    public static final RegistryObject<Potion> IRON_HEART_LONG = POTIONS.register("iron_heart_long", () -> new Potion(new MobEffectInstance(MobEffects.POISON, 1600, 2), new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 1200, 1)));
    public static final RegistryObject<Potion> IRON_HEART_STRONG = POTIONS.register("iron_heart_strong", () -> new Potion(new MobEffectInstance(MobEffects.POISON, 800, 3), new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 600, 2)));

    public static final RegistryObject<Potion> LUSH = POTIONS.register("lush", () -> new Potion(new MobEffectInstance(PHOTOTAXIS.get(), 1200, 1), new MobEffectInstance(MobEffects.DAMAGE_BOOST, 400)));
    public static final RegistryObject<Potion> LUSH_LONG = POTIONS.register("lush_long", () -> new Potion(new MobEffectInstance(PHOTOTAXIS.get(), 2000, 1), new MobEffectInstance(MobEffects.DAMAGE_BOOST, 1000)));
    public static final RegistryObject<Potion> LUSH_STRONG = POTIONS.register("lush_strong", () -> new Potion(new MobEffectInstance(PHOTOTAXIS.get(), 1200, 2), new MobEffectInstance(MobEffects.DAMAGE_BOOST, 200)));

    public static final RegistryObject<Potion> PANIC = POTIONS.register("panic", () -> new Potion(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1800, 1), new MobEffectInstance(MobEffects.BLINDNESS, 1800)));
    public static final RegistryObject<Potion> PANIC_LONG = POTIONS.register("panic_long", () -> new Potion(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 3600, 1), new MobEffectInstance(MobEffects.BLINDNESS, 3600)));
    public static final RegistryObject<Potion> PANIC_STRONG = POTIONS.register("panic_strong", () -> new Potion(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1800, 2), new MobEffectInstance(MobEffects.BLINDNESS, 1800)));

    public static final RegistryObject<Potion> WRATH = POTIONS.register("wrath", () -> new Potion(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 1800, 1), new MobEffectInstance(MobEffects.WITHER, 1800)));
    public static final RegistryObject<Potion> WRATH_LONG = POTIONS.register("wrath_long", () -> new Potion(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 3600, 1), new MobEffectInstance(MobEffects.WITHER, 3600)));
    public static final RegistryObject<Potion> WRATH_STRONG = POTIONS.register("wrath_strong", () -> new Potion(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 1800, 2), new MobEffectInstance(MobEffects.WITHER, 1800, 1)));

    public static void registerBrewingRecipes() {
        DataUtil.addMix(Potions.AWKWARD, CosmoItems.IRON_FIDDLEHEAD.get(), IRON_HEART.get());
        DataUtil.addMix(IRON_HEART.get(), Items.GLOWSTONE_DUST, IRON_HEART_STRONG.get());
        DataUtil.addMix(IRON_HEART.get(), Items.REDSTONE, IRON_HEART_LONG.get());

        DataUtil.addMix(Potions.AWKWARD, CosmoItems.GOLDEN_ARBUTUS_BERRIES.get(), LUSH.get());
        DataUtil.addMix(LUSH.get(), Items.GLOWSTONE_DUST, LUSH_STRONG.get());
        DataUtil.addMix(LUSH.get(), Items.REDSTONE, LUSH_LONG.get());

        if (CosmoConfig.Common.SPINALBERRY_CHANCE.get() > 0) {
            DataUtil.addMix(Potions.SWIFTNESS, CosmoItems.SPINALBERRY.get(), PANIC.get());
            DataUtil.addMix(PANIC.get(), Items.GLOWSTONE_DUST, PANIC_STRONG.get());
            DataUtil.addMix(PANIC.get(), Items.REDSTONE, PANIC_LONG.get());
        }

        if (CosmoConfig.Common.BOILBERRY_CHANCE.get() > 0) {
            DataUtil.addMix(Potions.STRENGTH, CosmoItems.BOILBERRY.get(), WRATH.get());
            DataUtil.addMix(WRATH.get(), Items.GLOWSTONE_DUST, WRATH_STRONG.get());
            DataUtil.addMix(WRATH.get(), Items.REDSTONE, WRATH_LONG.get());
        }
    }
}

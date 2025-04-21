package com.gumillea.cosmopolitan.core.util;

import net.minecraft.util.Tuple;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class FoodEffectChanger {
    public static void  apply() {
        try {
            FoodProperties food = Items.APPLE.getFoodProperties();

            Field effectsField = FoodProperties.class.getDeclaredField("p_38735_");
            effectsField.setAccessible(true);

            Field modifiers = Field.class.getDeclaredField("modifiers");
            modifiers.setAccessible(true);
            modifiers.setInt(effectsField, effectsField.getModifiers() & ~Modifier.FINAL);

            List<Tuple<MobEffectInstance, Float>> newEffects = new ArrayList<>();
            newEffects.add(new Tuple<>(
                    new MobEffectInstance(MobEffects.LEVITATION, 100, 0),
                    1.0F
            ));

            effectsField.set(food, newEffects);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
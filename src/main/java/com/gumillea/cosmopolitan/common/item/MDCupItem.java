package com.gumillea.cosmopolitan.common.item;

import com.gumillea.cosmopolitan.core.util.CosmoCompat;
import net.minecraft.world.food.FoodProperties;

import java.util.Objects;

public class MDCupItem extends EffectBowlItem {

    public MDCupItem(Properties properties, FoodProperties food) {
        super(properties.food(Objects.requireNonNull(CosmoCompat.CUP(food))).stacksTo(16).craftRemainder(CosmoCompat.COPPER_CUP));
    }

}

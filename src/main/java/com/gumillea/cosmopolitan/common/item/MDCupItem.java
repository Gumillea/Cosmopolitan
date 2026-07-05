package com.gumillea.cosmopolitan.common.item;

import com.gumillea.cosmopolitan.core.util.CosmoCompat;

public class MDCupItem extends EffectBowlItem {

    public MDCupItem(Properties properties) {
        super(properties.stacksTo(16).craftRemainder(CosmoCompat.COPPER_CUP));
    }

}

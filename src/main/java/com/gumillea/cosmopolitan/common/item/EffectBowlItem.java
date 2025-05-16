package com.gumillea.cosmopolitan.common.item;

import com.gumillea.cosmopolitan.core.reg.CosmoItems;
import com.gumillea.cosmopolitan.core.util.CosmoEvents;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public class EffectBowlItem extends EffectItem{
    public EffectBowlItem(Item.Properties properties) {
        super(properties);
    }

    public ItemStack finishUsingItem(ItemStack itemStack, Level level, LivingEntity living) {
        ItemStack $$3 = super.finishUsingItem(itemStack, level, living);
        if (this == CosmoItems.CREAM.get()) {
            CosmoEvents.creamEffect(level, living, itemStack);
        }

        return living instanceof Player && ((Player)living).getAbilities().instabuild ? $$3 : new ItemStack(Items.BOWL);
    }
}


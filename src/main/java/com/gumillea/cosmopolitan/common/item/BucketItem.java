package com.gumillea.cosmopolitan.common.item;

import com.gumillea.cosmopolitan.core.reg.CosmoItems;
import com.gumillea.cosmopolitan.core.util.CosmoEvents;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;

public class BucketItem extends EffectItem{

    private final boolean honey_drink;

    public BucketItem(Item.Properties properties, boolean honey_drink) {
        super(properties.craftRemainder(Items.BUCKET).stacksTo(1));
        this.honey_drink = honey_drink;
    }

@Override
    public ItemStack finishUsingItem(ItemStack itemStack, Level level, LivingEntity living) {
        super.finishUsingItem(itemStack, level, living);
        if (living instanceof ServerPlayer serverPlayer) {
            CriteriaTriggers.CONSUME_ITEM.trigger(serverPlayer, itemStack);
            serverPlayer.awardStat(Stats.ITEM_USED.get(this));
        }

        if (this == CosmoItems.CONDENSED_MILK_BOTTLE.get()) {
            CosmoEvents.condensedMilkEffect(level, living, itemStack);
        }

        if (itemStack.isEmpty()) {
            return new ItemStack(Items.BUCKET);
        } else {
            if (living instanceof Player player && !((Player)living).getAbilities().instabuild) {
                ItemStack stack = new ItemStack(Items.BUCKET);
                if (!player.getInventory().add(stack)) {
                    player.drop(stack, false);
                }
            }

            return itemStack;
        }
    }

    public int getUseDuration(ItemStack itemStack) {
        return 32;
    }

    public UseAnim getUseAnimation(ItemStack itemStack) {
        return UseAnim.DRINK;
    }

    public SoundEvent getDrinkingSound() {
        return honey_drink ? SoundEvents.HONEY_DRINK : SoundEvents.GENERIC_DRINK;
    }

    public SoundEvent getEatingSound() {
        return SoundEvents.HONEY_DRINK;
    }
}

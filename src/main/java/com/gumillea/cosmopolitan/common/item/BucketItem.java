package com.gumillea.cosmopolitan.common.item;

import com.gumillea.cosmopolitan.CosmoConfig;
import com.gumillea.cosmopolitan.Cosmopolitan;
import com.gumillea.cosmopolitan.core.reg.CosmoItems;
import com.gumillea.cosmopolitan.core.util.CosmoEvents;
import net.minecraft.ChatFormatting;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;

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

        if (this == CosmoItems.CONDENSED_MILK_BUCKET.get()) {
            CosmoEvents.condensedMilkEffect(level, living, itemStack);
        }

        if (this == CosmoItems.CREAM_BUCKET.get()) {
            CosmoEvents.creamEffect(level, living, itemStack);
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


    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        if (!CosmoConfig.Client.EFFECT_TOOLTIP.get()) return;
        super.appendHoverText(stack, worldIn, tooltip, flagIn);

        if (this == CosmoItems.CREAM_BUCKET.get()) {
            MutableComponent coldDrink = Component.translatable("tooltip." + Cosmopolitan.MODID + ".cream_bucket.when_consumed");
            tooltip.add(coldDrink.withStyle(ChatFormatting.BLUE));
        }
        if (this == CosmoItems.CONDENSED_MILK_BUCKET.get()) {
            MutableComponent coldDrink = Component.translatable("tooltip." + Cosmopolitan.MODID + ".condensed_milk_bucket.when_consumed");
            tooltip.add(coldDrink.withStyle(ChatFormatting.BLUE));
        }
    }
}

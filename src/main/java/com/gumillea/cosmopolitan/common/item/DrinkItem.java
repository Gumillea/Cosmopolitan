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
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.MobEffectEvent;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DrinkItem extends EffectItem {

    private final boolean honey_drink;

    public DrinkItem(Item.Properties properties, boolean honey_drink) {
        super(properties.craftRemainder(Items.GLASS_BOTTLE).stacksTo(16));
        this.honey_drink = honey_drink;
    }

    public ItemStack finishUsingItem(ItemStack itemStack, Level level, LivingEntity living) {
        super.finishUsingItem(itemStack, level, living);
        if (living instanceof ServerPlayer serverPlayer) {
            CriteriaTriggers.CONSUME_ITEM.trigger(serverPlayer, itemStack);
            serverPlayer.awardStat(Stats.ITEM_USED.get(this));
        }

        if (living instanceof Player player && this == CosmoItems.ENCHANTED_FRUIT_MILKSHAKE.get()) {
            player.giveExperiencePoints(8);
            player.playSound(SoundEvents.EXPERIENCE_ORB_PICKUP, 1.0F, 1.0F);
        }

        if (this == CosmoItems.CONDENSED_MILK_BOTTLE.get()) {
            CosmoEvents.condensedMilkEffect(level, living, itemStack);
        }

        if (itemStack.isEmpty()) {
            return new ItemStack(Items.GLASS_BOTTLE);
        } else {
            if (living instanceof Player player && !((Player)living).getAbilities().instabuild) {
                ItemStack stack = new ItemStack(Items.GLASS_BOTTLE);
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


    @Override
    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        if (!CosmoConfig.Client.EFFECT_TOOLTIP.get()) return;
        if (this == CosmoItems.CONDENSED_MILK_BOTTLE.get()) {
            MutableComponent coldDrink = Component.translatable("tooltip." + Cosmopolitan.MODID + ".condensed_milk_bottle.when_consumed");
            tooltip.add(coldDrink.withStyle(ChatFormatting.BLUE));
        }
    }
}


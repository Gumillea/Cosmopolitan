package com.gumillea.cosmopolitan.common.item;

import com.gumillea.cosmopolitan.CosmoConfig;
import com.gumillea.cosmopolitan.Cosmopolitan;
import com.gumillea.cosmopolitan.core.reg.CosmoEffects;
import com.gumillea.cosmopolitan.core.reg.CosmoItems;
import com.gumillea.cosmopolitan.core.util.CosmoEvents;
import net.minecraft.ChatFormatting;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.MobEffectEvent;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class DrinkItem extends EffectItem {

    private final boolean honey_drink;
    public final boolean tooltip;

    public DrinkItem(Item.Properties properties, boolean honey_drink, boolean tooltip) {
        super(properties);
        this.honey_drink = honey_drink;
        this.tooltip = tooltip;
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

        if (!level.isClientSide) {
            if (this == CosmoItems.BIRCH_SAP_BOTTLE.get()) living.removeEffect(MobEffects.DIG_SLOWDOWN);
            if (this == CosmoItems.BERRY_SYRUP_BOTTLE.get()) living.removeEffect(MobEffects.WEAKNESS);

            if (this == CosmoItems.ROOT_BEER.get()) {
                this.covertEffect(living, MobEffects.DIG_SLOWDOWN, MobEffects.DIG_SPEED);
            }

            if (this == CosmoItems.WILDBERRY_PUNCH.get()) {
                this.covertEffect(living, MobEffects.WEAKNESS, MobEffects.DAMAGE_BOOST);
            }
        }

        if (this == CosmoItems.ICE_CREAM_FLOAT.get()) {
            living.setTicksFrozen(living.getTicksFrozen() + 80);
        }

        if (this == CosmoItems.CONDENSED_MILK_BOTTLE.get()) {
            CosmoEvents.condensedMilkEffect(level, living, itemStack);
        }

        if (this == CosmoItems.CONDENSED_MILK_BUCKET.get()) {
            CosmoEvents.condensedMilkEffect(level, living, itemStack);
        }

        if (this == CosmoItems.CREAM_BUCKET.get()) {
            CosmoEvents.creamEffect(level, living, itemStack);
        }

        if (itemStack.isEmpty()) {
            return new ItemStack(this.getCraftingRemainingItem());
        } else {
            if (living instanceof Player player && !player.getAbilities().instabuild) {
                ItemStack stack = new ItemStack(this.getCraftingRemainingItem());
                if (!player.getInventory().add(stack)) {
                    player.drop(stack, false);
                }
            }

            return itemStack;
        }
    }

    private void covertEffect (LivingEntity living, MobEffect effect, MobEffect newEffect) {
        if (living.hasEffect(effect)) {
            int a = Objects.requireNonNull(living.getEffect(effect)).getAmplifier();
            int d = Objects.requireNonNull(living.getEffect(effect)).getDuration();

            living.addEffect(new MobEffectInstance(newEffect, d, a));
            living.removeEffect(effect);
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

        if (this.tooltip) {
            ResourceLocation key = Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(this));
            MutableComponent coldDrink = Component.translatable("tooltip." + Cosmopolitan.MODID + "." + key.getPath() +  ".when_consumed");
            tooltip.add(coldDrink.withStyle(ChatFormatting.BLUE));
        }

        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }
}


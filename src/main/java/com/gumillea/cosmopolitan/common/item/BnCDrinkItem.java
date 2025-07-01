package com.gumillea.cosmopolitan.common.item;

import com.gumillea.cosmopolitan.CosmoConfig;
import com.mojang.datafixers.util.Pair;
import net.minecraft.ChatFormatting;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import umpaz.brewinandchewin.common.registry.BnCEffects;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Supplier;

// Adapted from: https://github.com/MerchantCalico/BrewinAndChewin/blob/1.20.1/src/main/java/umpaz/brewinandchewin/common/item/BoozeItem.java
public class BnCDrinkItem extends DrinkItem{

    private final Fluid fluid;

    public BnCDrinkItem(Properties properties, boolean honey_drink, boolean tooltip , Fluid fluid) {
        super(properties, honey_drink, tooltip);
        this.fluid = fluid;
    }

    public Fluid getFluid() {
        return this.fluid;
    }

    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity consumer) {
        if (!level.isClientSide) {
            Optional<Pair<MobEffectInstance, Float>> tipsy = stack.getFoodProperties(consumer).getEffects().stream().filter((pair) -> ((MobEffectInstance)pair.getFirst()).getEffect() == BnCEffects.TIPSY.get()).findFirst();
            this.affectConsumer(consumer, tipsy.map((pair) -> pair.getFirst().getDuration()).orElse(0), (Integer)tipsy.map((pair) -> ((MobEffectInstance)pair.getFirst()).getAmplifier()).orElse(-1));
        }

        ItemStack containerStack = stack.getCraftingRemainingItem();
        if (stack.isEdible()) {
            super.finishUsingItem(stack, level, consumer);
        } else {
            Player player = consumer instanceof Player ? (Player)consumer : null;
            if (player instanceof ServerPlayer) {
                CriteriaTriggers.CONSUME_ITEM.trigger((ServerPlayer)player, stack);
            }

            if (player != null) {
                player.awardStat(Stats.ITEM_USED.get(this));
                if (!player.getAbilities().instabuild) {
                    stack.shrink(1);
                }
            }
        }

        if (stack.isEmpty()) {
            return containerStack;
        } else {
            if (consumer instanceof Player) {
                Player player = (Player)consumer;
                if (!((Player)consumer).getAbilities().instabuild && !player.getInventory().add(containerStack)) {
                    player.drop(containerStack, false);
                }
            }

            return stack;
        }
    }


    public void affectConsumer(LivingEntity consumer, int duration, int potency) {
        if (consumer.hasEffect(BnCEffects.TIPSY.get())) {
            MobEffectInstance effect = consumer.getEffect(BnCEffects.TIPSY.get());
            consumer.addEffect(new MobEffectInstance(BnCEffects.TIPSY.get(), effect.getDuration() == -1 ? -1 : effect.getDuration() + duration, Math.min(effect.getAmplifier() + potency + 1, 9), effect.isAmbient(), effect.isVisible(), effect.showIcon()));
        }

    }

    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        if (!CosmoConfig.Client.EFFECT_TOOLTIP.get()) return;
        super.appendHoverText(stack, worldIn, tooltip, flagIn);

        for(int i = 0; i < tooltip.size(); ++i) {
            Component component = tooltip.get(i);
            if (Set.of(BnCEffects.TIPSY, (Supplier)() -> MobEffects.BAD_OMEN).stream().anyMatch((supplier) -> component.contains(Component.translatable(((MobEffect)supplier.get()).getDescriptionId())))) {
                tooltip.set(i, component.copy().withStyle(ChatFormatting.RED));
            }
        }

    }


}

package com.gumillea.cosmopolitan.common.item;

import com.gumillea.cosmopolitan.CosmoConfig;
import com.gumillea.cosmopolitan.Cosmopolitan;
import com.gumillea.cosmopolitan.core.reg.CosmoEffects;
import com.gumillea.cosmopolitan.core.util.CosmoEvents;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;

public class EnhanceDrinkItem extends BnCDrinkItem{

    private final MobEffect effect;

    public EnhanceDrinkItem(Properties properties, Fluid fluid, MobEffect effect) {
        super(properties, false, false, fluid);
        this.effect = effect;
    }

    public ItemStack finishUsingItem(ItemStack itemStack, Level level, LivingEntity living) {
        if (living.hasEffect(effect)) {
            MobEffectInstance instance = living.getEffect(effect);
            int amp = instance.getAmplifier();
            int duration = instance.getDuration();
            if (amp  < 2) {
                CosmoEvents.applyAmplifierAdjustment(living, instance, 1);
            } else if (duration < 1200) {
                CosmoEvents.applyDurationAdjustment(living, instance, 600);
            } else {
                living.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 600, 0));
            }
        } else {
            living.addEffect(new MobEffectInstance(effect, 600, 0));
        }

        return super.finishUsingItem(itemStack, level, living);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag flag) {
        if (!CosmoConfig.Client.EFFECT_TOOLTIP.get()) return;

        if (effect != CosmoEffects.PLACEHOLDER.get()) {
            Component effectName = Component.translatable(effect.getDescriptionId());
            tooltip.add(Component.translatable("tooltip." + Cosmopolitan.MODID + ".enhance_drink", effectName).withStyle(ChatFormatting.BLUE));
        }

        super.appendHoverText(stack, world, tooltip, flag);
    }

}

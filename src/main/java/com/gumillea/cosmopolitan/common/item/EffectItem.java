package com.gumillea.cosmopolitan.common.item;

import com.gumillea.cosmopolitan.CosmoConfig;
import com.gumillea.cosmopolitan.Cosmopolitan;
import com.mojang.datafixers.util.Pair;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffectUtil;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;

public class EffectItem extends Item {

    public EffectItem(Properties properties) {
        super(properties);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag flag) {
        if (!CosmoConfig.Common.EFFECT_TOOLTIP.get()) return;

        FoodProperties properties = this.getFoodProperties(stack, null);
        if (properties == null) return;

        for (Pair<MobEffectInstance, Float> pair : properties.getEffects()) {
            MobEffectInstance effect = pair.getFirst();
            float probability = pair.getSecond();

            MutableComponent effectTooltip = Component.literal(" ")
                    .append(Component.translatable(effect.getDescriptionId()))
                    .append(effect.getAmplifier() > 0 ? Component.literal(" ").append(Component.translatable("potion.potency." + effect.getAmplifier())) : Component.empty())
                    .append(effect.getDuration() > 20 ? Component.literal(" (").append(MobEffectUtil.formatDuration(effect, 1.0F)).append(")") : Component.empty())
                    .append(probability < 1.0f ? Component.literal(" - " + (int)(probability * 100) + "%") : Component.empty());

            tooltip.add(effectTooltip.withStyle(effect.getEffect().getCategory().getTooltipFormatting()));
        }
    }
}

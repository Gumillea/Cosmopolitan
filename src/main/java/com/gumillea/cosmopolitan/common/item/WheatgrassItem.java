package com.gumillea.cosmopolitan.common.item;

import com.google.common.collect.Lists;
import com.gumillea.cosmopolitan.CosmoConfig;
import com.gumillea.cosmopolitan.Cosmopolitan;
import com.gumillea.cosmopolitan.core.reg.CosmoItems;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffectUtil;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;

public class WheatgrassItem extends Item {

    public static final List<MobEffectInstance> EFFECTS = Lists.newArrayList(
            new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 6000, 0),
            new MobEffectInstance(MobEffects.REGENERATION, 6000, 0));

    public WheatgrassItem(Properties properties) {
        super(properties);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        if (!CosmoConfig.Client.EFFECT_TOOLTIP.get()) return;

        MutableComponent whenFeeding = Component.translatable("tooltip." + Cosmopolitan.MODID + ".wheatgrass.when_feeding");
        tooltip.add(whenFeeding.withStyle(ChatFormatting.GRAY));

        for (MobEffectInstance effectinstance : EFFECTS) {
            MutableComponent effectDescription = Component.literal(" ");
            MutableComponent effectName = Component.translatable(effectinstance.getDescriptionId());
            effectDescription.append(effectName);
            MobEffect effect = effectinstance.getEffect();

            if (effectinstance.getAmplifier() > 0) {
                effectDescription.append(" ").append(Component.translatable("potion.potency." + effectinstance.getAmplifier()));
            }

            if (effectinstance.getDuration() > 20) {
                effectDescription.append(" (").append(MobEffectUtil.formatDuration(effectinstance, 1.0F)).append(")");
            }

            tooltip.add(effectDescription.withStyle(effect.getCategory().getTooltipFormatting()));
        }
    }


    @Override
    public int getUseDuration(ItemStack stack) {
        return this == CosmoItems.WHEATGRASS.get() ? 80 : 32;
    }

}

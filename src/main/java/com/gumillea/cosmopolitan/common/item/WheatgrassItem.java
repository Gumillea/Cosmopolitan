package com.gumillea.cosmopolitan.common.item;

import com.google.common.collect.Lists;
import com.gumillea.cosmopolitan.CosmoConfig;
import com.gumillea.cosmopolitan.Cosmopolitan;
import com.gumillea.cosmopolitan.core.reg.CosmoItems;
import com.gumillea.cosmopolitan.core.util.CosmoTooltipEvent;
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
        if (CosmoConfig.Client.EFFECT_TOOLTIP.get()) {
            CosmoTooltipEvent.addWheatgrassTooltip(tooltip);
        }

    }


    @Override
    public int getUseDuration(ItemStack stack) {
        return this == CosmoItems.WHEATGRASS.get() ? 80 : 32;
    }

}

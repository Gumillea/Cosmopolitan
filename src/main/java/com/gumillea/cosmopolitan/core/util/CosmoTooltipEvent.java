package com.gumillea.cosmopolitan.core.util;

import com.gumillea.cosmopolitan.CosmoConfig;
import com.gumillea.cosmopolitan.Cosmopolitan;
import com.gumillea.cosmopolitan.core.reg.CosmoEffects;
import net.minecraft.client.Minecraft;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffectUtil;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;
@Mod.EventBusSubscriber(modid = Cosmopolitan.MODID, value = Dist.CLIENT)
public class CosmoTooltipEvent {


    @SubscribeEvent
    public static void onEffectItemTooltip(ItemTooltipEvent event) {
        if (!CosmoConfig.Client.EFFECT_TOOLTIP.get()) return;

        ItemStack stack = event.getItemStack();
        if (!stack.isEdible() && stack.getFoodProperties(Minecraft.getInstance().player) != null) return;

        List<Component> tooltip = event.getToolTip();
        var properties = stack.getFoodProperties(Minecraft.getInstance().player);
        int nutrition = properties == null ? 0 : properties.getNutrition();

        if (CosmoConfig.Common.APPLE_FLAVOR.get() && stack.is(CosmoItemTags.EXUBERANT_SOURCES)) {
            int duration = (nutrition < 10 ? 10 - nutrition : 1) * 300;
            appendItem(tooltip, CosmoEffects.EXUBERANT.get(), duration, 0);
        }
        if (CosmoConfig.Common.GLOW_BERRY_FLAVOR.get() && stack.is(CosmoItemTags.TRACER_SOURCES)) {
            int duration = nutrition < 10 ? 300 : 600;
            int amplifier = nutrition < 10 ? 0 : 1;
            appendItem(tooltip, CosmoEffects.TRACER.get(), duration, amplifier);
        }
        if (CosmoConfig.Common.CARROT_FLAVOR.get() && stack.is(CosmoItemTags.CAROTENE_SOURCES)) {
            int duration = (nutrition < 10 ? 300 : 600) * 5;
            appendItem(tooltip, CosmoEffects.CAROTENE.get(), duration, 0);
        }
        if (CosmoConfig.Common.DROOPFRUIT_FLAVOR.get() && stack.is(CosmoItemTags.ABYSMAL_TORCH_SOURCES)) {
            int amplifier = nutrition < 10 ? 0 : 1;
            appendItem(tooltip, CosmoEffects.ABYSMAL_TORCH.get(), -1, amplifier);
        }
        if (CosmoConfig.Common.BLISTERBERRY_FLAVOR.get() && stack.is(CosmoItemTags.VARDOGER_SOURCES)) {
            int duration = (int) ((nutrition < 10 ? 300 : 600) * 1.5);
            appendItem(tooltip, CosmoEffects.VARDOGER.get(), duration, 0);
        }
    }

    @SubscribeEvent
    public static void onSeasonedItemTooltip(ItemTooltipEvent event) {
        ItemStack stack = event.getItemStack();
        CompoundTag tag = stack.getTag();
        if (tag == null) return;

        List<Component> tooltip = event.getToolTip();
        if (tag.getBoolean("has_condensed_milk")) {
            tooltip.add(Component.literal("❖ ").append(Component.translatable("tooltip." + Cosmopolitan.MODID + ".seasoned.condensed_milk")).withStyle(style -> style.withColor(0xFFF8E0)));
        }

        if (tag.getBoolean("has_cream")) {
            tooltip.add(Component.literal("❖ ").append(Component.translatable("tooltip." + Cosmopolitan.MODID + ".seasoned.cream")).withStyle(style -> style.withColor(0xF7D7B4)));
        }
    }

    private static void appendItem(List<Component> tooltip, MobEffect effect, int duration, int amplifier) {
        MobEffectInstance mobEffectInstance = new MobEffectInstance(effect, duration, amplifier);
        MutableComponent component = Component.translatable(effect.getDescriptionId())
                .append(amplifier > 0 ? Component.literal(" ").append(Component.translatable("potion.potency." + amplifier)) : Component.empty())
                .append(duration > 20 ? Component.literal(" (").append(MobEffectUtil.formatDuration(mobEffectInstance, 1.0F)).append(")") : Component.empty())
                .withStyle(effect.getCategory().getTooltipFormatting());

        tooltip.add(component);
    }


}

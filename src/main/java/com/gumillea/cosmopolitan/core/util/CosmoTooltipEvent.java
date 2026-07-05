package com.gumillea.cosmopolitan.core.util;

import com.gumillea.cosmopolitan.CosmoConfig;
import com.gumillea.cosmopolitan.Cosmopolitan;
import com.gumillea.cosmopolitan.common.item.WheatgrassItem;
import com.gumillea.cosmopolitan.core.misc.BerrfectFlavorHelper;
import com.gumillea.cosmopolitan.core.reg.CosmoEffects;
import com.mojang.datafixers.util.Pair;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffectUtil;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

        if (CosmoConfig.Common.CARROT_FLAVOR.get() && stack.is(CosmoItemTags.CAROTENE_SOURCES)) {
            tooltip.add(Component.translatable("tooltip." + Cosmopolitan.MODID + ".carrot").withStyle(ChatFormatting.BLUE));
        }
        if (CosmoConfig.Common.APPLE_FLAVOR.get() && stack.is(CosmoItemTags.EXUBERANT_SOURCES)) {
            int duration = (nutrition < 10 ? 10 - nutrition : 1) * 900;
            appendItem(tooltip, CosmoEffects.EXUBERANT.get(), duration, 0);
        }
        if (CosmoConfig.Common.GLOW_BERRY_FLAVOR.get() && stack.is(CosmoItemTags.TRACER_SOURCES)) {
            int duration = nutrition < 10 ? 300 : 600;
            int amplifier = nutrition < 10 ? 0 : 1;
            appendItem(tooltip, CosmoEffects.TRACER.get(), duration, amplifier);
        }
        if (CosmoConfig.Common.DROOPFRUIT_FLAVOR.get() && stack.is(CosmoItemTags.ABYSMAL_TORCH_SOURCES)) {
            int amplifier = nutrition < 10 ? 0 : 1;
            appendItem(tooltip, CosmoEffects.ABYSMAL_TORCH.get(), -1, amplifier);
        }
        if (CosmoConfig.Common.BLISTERBERRY_FLAVOR.get() && stack.is(CosmoItemTags.VARDOGER_SOURCES)) {
            int duration = (int) ((nutrition < 10 ? 300 : 600) * 1.5);
            appendItem(tooltip, CosmoEffects.VARDOGER.get(), duration, 0);
        }
        if (CosmoConfig.Common.MORE_INGRAINED_SOURCES.get() && stack.is(CosmoItemTags.INGRAINED_SOURCES)) {
            int duration = (nutrition < 10 ? 300 : 600);
            appendItem(tooltip, CosmoEffects.INGRAINED.get(), duration, 0);
        }
        if (CosmoConfig.Common.COMFORT_REDESIGN.get() && stack.is(CosmoItemTags.COMFORT_SOURCES)) {
            appendItem(tooltip, CosmoEffects.COMFORT.get(), 1200, 0);
        }
    }

    @SubscribeEvent
    public static void onSeasonedItemTooltip(ItemTooltipEvent event) {
        ItemStack stack = event.getItemStack();
        CompoundTag tag = stack.getTag();
        if (tag == null) return;

        List<Component> tooltip = event.getToolTip();
        if (tag.getBoolean("has_condensed_milk")) {
            CosmoUtils.shiftTooltip(tooltip,
                    Component.literal("◆ ").append(Component.translatable("tooltip." + Cosmopolitan.MODID + ".seasoned.condensed_milk.info")).withStyle(style -> style.withColor(0xFFF8E0)),
                    Component.literal("◆ ").append(Component.translatable("tooltip." + Cosmopolitan.MODID + ".seasoned.condensed_milk")).withStyle(style -> style.withColor(0xFFF8E0))
            );
        }

        if (tag.getBoolean("has_cream")) {
            CosmoUtils.shiftTooltip(tooltip,
                    Component.literal("◆ ").append(Component.translatable("tooltip." + Cosmopolitan.MODID + ".seasoned.cream.info")).withStyle(style -> style.withColor(0xFFF8E0)),
                    Component.literal("◆ ").append(Component.translatable("tooltip." + Cosmopolitan.MODID + ".seasoned.cream")).withStyle(style -> style.withColor(0xFFF8E0))
            );
        }

        if (CosmoConfig.Common.FLAVORED_SYRUP.get() && tag.contains(BerrfectFlavorHelper.KEY)) {
            String flavor = stack.getTag().getString(BerrfectFlavorHelper.KEY);

            switch (flavor) {
                case "sour" -> appendFlavoredItem(event, "sour", 0xFFDC6C);
                case "sweet" -> appendFlavoredItem(event, "sweet", 0xF65095);
                case "bitter" -> appendFlavoredItem(event, "bitter", 0x4CCD5C);
                case "spicy" -> appendFlavoredItem(event, "spicy", 0xD22525);
                case "strange" -> appendFlavoredItem(event, "strange", 0x9578AA);
            }
        }
    }

    private static void appendFlavoredItem(ItemTooltipEvent event, String flavor, int color) {
        List<Component> tooltip = event.getToolTip();
        CosmoUtils.shiftTooltip(tooltip,
                Component.literal("❖ ").append(Component.translatable("tooltip." + Cosmopolitan.MODID + ".flavor." + flavor + ".info")).withStyle(style -> style.withColor(color)),
                Component.literal("❖ ").append(Component.translatable("tooltip." + Cosmopolitan.MODID + ".flavor." + flavor)).withStyle(style -> style.withColor(color))
        );
    }

    private static void appendItem(List<Component> tooltip, MobEffect effect, int duration, int amplifier) {
        MobEffectInstance mobEffectInstance = new MobEffectInstance(effect, duration, amplifier);
        MutableComponent component = Component.translatable(effect.getDescriptionId())
                .append(amplifier > 0 ? Component.literal(" ").append(Component.translatable("potion.potency." + amplifier)) : Component.empty())
                .append(duration > 20 ? Component.literal(" (").append(MobEffectUtil.formatDuration(mobEffectInstance, 1.0F)).append(")") : Component.empty())
                .withStyle(effect.getCategory().getTooltipFormatting());

        tooltip.add(component);
    }

    public static void addEffectTooltip(Item item, ItemStack stack, List<Component> tooltip) {
        FoodProperties properties = item.getFoodProperties(stack, null);
        if (properties == null) return;

        List<Pair<Attribute, AttributeModifier>> attributeList = new ArrayList<>();

        for (Pair<MobEffectInstance, Float> pair : properties.getEffects()) {
            MobEffectInstance effectInstance = pair.getFirst();
            float probability = pair.getSecond();
            MobEffect effect = effectInstance.getEffect();

            if (effect == CosmoEffects.PLACEHOLDER.get()) continue;

            MutableComponent effectDescription = Component.translatable(effect.getDescriptionId());

            if (effectInstance.getAmplifier() > 0) {
                effectDescription = Component.translatable("potion.withAmplifier", effectDescription, Component.translatable("potion.potency." + effectInstance.getAmplifier()));
            }

            if (effectInstance.getDuration() > 20) {
                effectDescription = Component.translatable("potion.withDuration", effectDescription, MobEffectUtil.formatDuration(effectInstance, 1.0F));
            }

            if (probability < 1.0f) {
                effectDescription.append(Component.literal(" - " + (int) (probability * 100) + "%"));
            }

            tooltip.add(effectDescription.withStyle(effect.getCategory().getTooltipFormatting()));

            Map<Attribute, AttributeModifier> rawModifiers = effect.getAttributeModifiers();
            for (Map.Entry<Attribute, AttributeModifier> entry : rawModifiers.entrySet()) {
                Attribute attribute = entry.getKey();
                AttributeModifier value = entry.getValue();
                AttributeModifier modifier = new AttributeModifier(value.getName(), effect.getAttributeModifierValue(effectInstance.getAmplifier(), value), value.getOperation());
                attributeList.add(Pair.of(attribute, modifier));
            }
        }

        if (!attributeList.isEmpty()) {
            tooltip.add(Component.empty());
            tooltip.add(Component.translatable("potion.whenDrank").withStyle(ChatFormatting.DARK_PURPLE));

            for (Pair<Attribute, AttributeModifier> pair : attributeList) {
                Attribute attribute = pair.getFirst();
                AttributeModifier modifier = pair.getSecond();
                double d0 = modifier.getAmount();
                double d1 = (modifier.getOperation() == AttributeModifier.Operation.MULTIPLY_BASE || modifier.getOperation() == AttributeModifier.Operation.MULTIPLY_TOTAL) ? d0 * 100.0D : d0;
                String translationKey = d0 > 0.0D ? "attribute.modifier.plus." + modifier.getOperation().toValue() : "attribute.modifier.take." + modifier.getOperation().toValue();

                ChatFormatting style = d0 > 0.0D ? ChatFormatting.BLUE : ChatFormatting.RED;
                if (d0 < 0.0D) d1 *= -1.0D;

                tooltip.add(Component.translatable(translationKey, ItemStack.ATTRIBUTE_MODIFIER_FORMAT.format(d1), Component.translatable(attribute.getDescriptionId())).withStyle(style));
            }
        }
    }


    // Adapted from: https://github.com/vectorwing/FarmersDelight/blob/1.20/src/main/java/vectorwing/farmersdelight/common/item/DogFoodItem.java
    public static void addWheatgrassTooltip(List<Component> tooltip) {
        MutableComponent whenFeeding = Component.translatable("tooltip." + Cosmopolitan.MODID + ".wheatgrass.when_feeding");
        tooltip.add(whenFeeding.withStyle(ChatFormatting.GRAY));

        for (MobEffectInstance effectinstance : WheatgrassItem.EFFECTS) {
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

}



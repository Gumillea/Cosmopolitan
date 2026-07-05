package com.gumillea.cosmopolitan.common.item;

import com.gumillea.cosmopolitan.CosmoConfig;
import com.gumillea.cosmopolitan.Cosmopolitan;
import com.gumillea.cosmopolitan.core.reg.CosmoItems;
import com.gumillea.cosmopolitan.core.util.CosmoCompat;
import com.gumillea.cosmopolitan.core.util.CosmoEvents;
import com.gumillea.cosmopolitan.core.util.CosmoTooltipEvent;
import com.gumillea.cosmopolitan.core.util.CosmoUtils;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffectUtil;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;

public class CaveConeItem extends EffectBowlItem{

    public CaveConeItem(Properties properties) {
        super(properties.craftRemainder(Items.POINTED_DRIPSTONE).stacksTo(16));
    }

    public ItemStack finishUsingItem(ItemStack itemStack, Level level, LivingEntity living) {
        if (CosmoCompat.ac) {
            if (this == CosmoItems.FORLORN_CAVE_CONE.get() && living.hasEffect(CosmoCompat.DARKNESS_INCARNATE)) CosmoEvents.applyDurationAdjustment(living, new MobEffectInstance(CosmoCompat.DARKNESS_INCARNATE) ,200);
            if (this == CosmoItems.TOXIC_CAVE_CONE.get() && living.hasEffect(CosmoCompat.IRRADIATED)) CosmoUtils.applyHealing(4, living);
        }

        if (living.getY() < 16) {
            living.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 600));
            if (living instanceof Player player) {
                int nutrition = this.getFoodProperties().getNutrition() / 2;
                float saturation = this.getFoodProperties().getSaturationModifier() / 2;
                player.getFoodData().eat(nutrition, saturation);
            }

        }

        return super.finishUsingItem(itemStack, level, living);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        if (!CosmoConfig.Client.EFFECT_TOOLTIP.get()) return;

        CosmoTooltipEvent.addEffectTooltip(this, stack, tooltip);

        tooltip.add(Component.translatable("tooltip." + Cosmopolitan.MODID + ".cave_cone.when_consumed.in_underground").withStyle(ChatFormatting.GRAY));
        tooltip.add(Component.literal(" ").append(Component.translatable("tooltip." + Cosmopolitan.MODID + ".cave_cone.when_consumed.in_underground.nutrition")).withStyle(ChatFormatting.BLUE));

        MobEffectInstance instance = new MobEffectInstance(MobEffects.DIG_SPEED, 600);
        MobEffect effect = instance.getEffect();

        tooltip.add(Component.literal(" ")
                .append(Component.translatable(effect.getDescriptionId()))
                .append(Component.literal(" ").append(Component.translatable("potion.potency.0")))
                .append(Component.literal(" (").append(MobEffectUtil.formatDuration(instance, 1.0F)).append(")"))
                .withStyle(effect.getCategory().getTooltipFormatting()));
    }
}

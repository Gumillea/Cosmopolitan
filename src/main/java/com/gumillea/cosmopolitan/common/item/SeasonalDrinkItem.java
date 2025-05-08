package com.gumillea.cosmopolitan.common.item;

import com.google.common.collect.Lists;
import com.gumillea.cosmopolitan.CosmoConfig;
import com.gumillea.cosmopolitan.Cosmopolitan;
import com.gumillea.cosmopolitan.core.util.CosmoCompat;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffectUtil;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import sereneseasons.api.season.Season;
import sereneseasons.api.season.SeasonHelper;
import sereneseasons.init.ModConfig;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class SeasonalDrinkItem extends DrinkItem{

    private final String season;
    private final boolean isSpring;
    private final boolean isSummer;
    private final boolean isAutumn;
    private final boolean isWinter;

    private final Supplier<List<MobEffectInstance>> SEASONAL_EFFECTS;

    public SeasonalDrinkItem(Properties properties, boolean honey_drink, String season) {
        super(properties, honey_drink);
        this.season = season;
        this.isSpring = season.equals("spring");
        this.isSummer = season.equals("summer");
        this.isAutumn = season.equals("autumn");
        this.isWinter = season.equals("winter");

        this.SEASONAL_EFFECTS = () -> {
            if (isSpring) {
                return List.of(new MobEffectInstance(MobEffects.HEALTH_BOOST, 1200, 0));
            } else if (isSummer) {
                return List.of(new MobEffectInstance(MobEffects.WATER_BREATHING, 600, 0));
            } else if (isAutumn) {
                return List.of(new MobEffectInstance(MobEffects.LUCK, 1200, 0));
            } else if (isWinter) {
                return List.of(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 600, 0));
            }
            return List.of();
        };
    }
    public ItemStack finishUsingItem(ItemStack itemStack, Level level, LivingEntity living) {
        super.finishUsingItem(itemStack, level, living);
        if (level.isClientSide()) return itemStack;

        if (isSpring || isSummer) {
            living.clearFire();
        }
        if (isAutumn || isWinter) {
            living.setTicksFrozen(0);
        }

        if (CosmoCompat.ss && ModConfig.fertility.seasonalCrops) {
            Season currentSeason = SeasonHelper.getSeasonState(level).getSeason();

            Map<Season, Boolean> map = Map.of(
                    Season.SPRING, isSpring,
                    Season.SUMMER, isSummer,
                    Season.AUTUMN, isAutumn,
                    Season.WINTER, isWinter
            );

            if (map.get(currentSeason)){
                for (MobEffectInstance effect : SEASONAL_EFFECTS.get()) {
                    living.addEffect(new MobEffectInstance(effect));
                }
            }
        }

        return itemStack;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        if (!CosmoConfig.Client.EFFECT_TOOLTIP.get()) return;

        if (isSpring || isSummer) {
            MutableComponent coldDrink = Component.translatable("tooltip." + Cosmopolitan.MODID + ".seasonal_drink.when_drinking.cold");
            tooltip.add(coldDrink.withStyle(ChatFormatting.GRAY));
        } else {
            MutableComponent hotDrink = Component.translatable("tooltip." + Cosmopolitan.MODID + ".seasonal_drink.when_drinking.hot");
            tooltip.add(hotDrink.withStyle(ChatFormatting.GRAY));
        }

        if (!CosmoCompat.ss) return;
        MutableComponent seasonalEffect = Component.translatable("tooltip." + Cosmopolitan.MODID + ".seasonal_drink.when_drinking.in_" + season);
        tooltip.add(seasonalEffect.withStyle(ChatFormatting.GRAY));

        for (MobEffectInstance effectinstance : SEASONAL_EFFECTS.get()) {
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

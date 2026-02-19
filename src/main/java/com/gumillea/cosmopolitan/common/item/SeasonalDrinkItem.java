package com.gumillea.cosmopolitan.common.item;

import com.gumillea.cosmopolitan.CosmoConfig;
import com.gumillea.cosmopolitan.Cosmopolitan;
import com.gumillea.cosmopolitan.core.util.CosmoCompat;
import com.teamtea.eclipticseasons.api.constant.solar.SolarTerm;
import com.teamtea.eclipticseasons.common.core.SolarHolders;
import com.teamtea.eclipticseasons.common.core.solar.SolarDataManager;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.server.level.ServerLevel;
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
        super(properties, honey_drink, false);
        this.season = season;
        this.isSpring = season.contains("spring");
        this.isSummer = season.contains("summer");
        this.isAutumn = season.contains("autumn");
        this.isWinter = season.contains("winter");

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
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity living) {
        if (level.isClientSide()) return stack;

        if (isSpring || isSummer) {
            living.clearFire();
        }
        if (isAutumn || isWinter) {
            living.setTicksFrozen(0);
        }


        if (!(level instanceof ServerLevel serverLevel)) return super.finishUsingItem(stack, level, living);

        if (CosmoCompat.ss) {
            Season currentSeason = SeasonHelper.getSeasonState(serverLevel).getSeason();

            Map<Season, Boolean> map = Map.of(
                    Season.SPRING, isSpring,
                    Season.SUMMER, isSummer,
                    Season.AUTUMN, isAutumn,
                    Season.WINTER, isWinter
            );

            if (map.get(currentSeason)) {
                for (MobEffectInstance effect : SEASONAL_EFFECTS.get()) {
                    living.addEffect(new MobEffectInstance(effect));
                }
            }
        } else if (CosmoCompat.es) {
            com.teamtea.eclipticseasons.api.constant.solar.Season currentSeason = SolarHolders.getSaveData(serverLevel).getSolarTerm().getSeason();

            Map<com.teamtea.eclipticseasons.api.constant.solar.Season, Boolean> map = Map.of(
                    com.teamtea.eclipticseasons.api.constant.solar.Season.SPRING, isSpring,
                    com.teamtea.eclipticseasons.api.constant.solar.Season.SUMMER, isSummer,
                    com.teamtea.eclipticseasons.api.constant.solar.Season.AUTUMN, isAutumn,
                    com.teamtea.eclipticseasons.api.constant.solar.Season.WINTER, isWinter
            );

            if (map.get(currentSeason)) {
                for (MobEffectInstance effect : SEASONAL_EFFECTS.get()) {
                    living.addEffect(new MobEffectInstance(effect));
                }
            }
        }


        return super.finishUsingItem(stack, level, living);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        if (!CosmoConfig.Client.EFFECT_TOOLTIP.get()) return;

        if (isSpring || isSummer) {
            MutableComponent coldDrink = Component.translatable("tooltip." + Cosmopolitan.MODID + ".seasonal_drink.when_consumed.cold");
            tooltip.add(coldDrink.withStyle(ChatFormatting.BLUE));
        } else {
            MutableComponent hotDrink = Component.translatable("tooltip." + Cosmopolitan.MODID + ".seasonal_drink.when_consumed.hot");
            tooltip.add(hotDrink.withStyle(ChatFormatting.BLUE));
        }

        if (!CosmoCompat.ss && !CosmoCompat.es) return;
        MutableComponent seasonalEffect = Component.translatable("tooltip." + Cosmopolitan.MODID + ".seasonal_drink.when_consumed.in_" + season);
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

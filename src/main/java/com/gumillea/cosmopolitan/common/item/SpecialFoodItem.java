package com.gumillea.cosmopolitan.common.item;

import com.gumillea.cosmopolitan.CosmoConfig;
import com.gumillea.cosmopolitan.Cosmopolitan;
import com.gumillea.cosmopolitan.core.reg.CosmoItems;
import com.gumillea.cosmopolitan.core.util.CosmoCompat;
import com.gumillea.cosmopolitan.core.util.CosmoEvents;
import com.gumillea.cosmopolitan.core.util.CosmoTooltipEvent;
import com.gumillea.cosmopolitan.core.util.CosmoUtils;
import com.teamabnormals.environmental.core.registry.EnvironmentalItems;
import com.teamabnormals.environmental.core.registry.EnvironmentalParticleTypes;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.items.ItemHandlerHelper;

import javax.annotation.Nullable;
import java.util.List;

public class SpecialFoodItem extends EffectItem {

    public SpecialFoodItem(Properties properties) {
        super(properties);
    }

    public ItemStack finishUsingItem(ItemStack itemStack, Level level, LivingEntity living) {
        if (level.isClientSide) return super.finishUsingItem(itemStack, level, living);

        if (this == CosmoItems.HOT_CATTAIL.get() && CosmoCompat.en) {
            if (living instanceof Player player) {
                RandomSource random = level.getRandom();
                int cats = random.nextInt(3) + 1;

                for (int i = 0; i < cats; i++) {
                    double offset = (random.nextDouble() - 0.5D) * 0.8D;
                    double movement = 0.15D + random.nextDouble() * 0.1D;

                    double x = player.getX() + offset;
                    double y = player.getY() + player.getEyeHeight() -0.2D;
                    double z = player.getZ() + offset;
                    double d = (random.nextDouble() - 0.5D) * movement;

                    ItemStack fluff = new ItemStack(EnvironmentalItems.CATTAIL_FLUFF.get());
                    ItemEntity fluffEntity = new ItemEntity(level, x, y, z, fluff);

                    fluffEntity.setDeltaMovement(d, movement, d);
                    fluffEntity.setPickUpDelay(20);

                    level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.WOOL_HIT, SoundSource.PLAYERS, 2.0F, 2.0F);
                    level.addFreshEntity(fluffEntity);

                    if (level instanceof ServerLevel server) {
                        server.sendParticles(EnvironmentalParticleTypes.CATTAIL_FLUFF.get(), x, y, z, 0, d, movement, d, 0.5);
                    }
                }
            }
        }

        if (living instanceof Player player && this == CosmoItems.EMERALD_CANDY.get()) {
            if (CosmoUtils.random(level, .08F)) {
                if (player.getHealth() > 2) player.hurt(player.damageSources().generic(), 1);
                level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.AMETHYST_BLOCK_BREAK, SoundSource.PLAYERS, 1.0F, 1.0F);
                ItemHandlerHelper.giveItemToPlayer(player, Items.EMERALD.getDefaultInstance());
            }
        }

        if (this == CosmoItems.SALTED_QINGTUAN.get()) {
            List<MobEffectInstance> effects = living.getActiveEffects().stream().filter(inst -> inst.getDuration() != -1 && !inst.getEffect().isBeneficial()).map(MobEffectInstance::new).toList();

            if (!effects.isEmpty()) {
                for (MobEffectInstance effect : effects) {
                    CosmoEvents.applyDurationAdjustment(living, effect, (int) (-effect.getDuration() * 0.25F));
                }
            }
        }

        if (this == CosmoItems.SWEET_QINGTUAN.get()) {
            List<MobEffectInstance> effects = living.getActiveEffects().stream().filter(inst -> inst.getDuration() != -1 && !inst.getEffect().isBeneficial()).map(MobEffectInstance::new).toList();

            if (!effects.isEmpty()) {
                for (MobEffectInstance effect : effects) {
                    CosmoEvents.applyAmplifierAdjustment(living, effect, -1);
                }
            }
        }


        return super.finishUsingItem(itemStack, level, living);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag flag) {
        if (!CosmoConfig.Client.EFFECT_TOOLTIP.get()) return;

        if (this == CosmoItems.SWEET_QINGTUAN.get()) {
            tooltip.add(Component.translatable("tooltip." + Cosmopolitan.MODID + ".sweet_qingtuan.when_consumed").withStyle(ChatFormatting.BLUE));
        }

        if (this == CosmoItems.SALTED_QINGTUAN.get()) {
            tooltip.add(Component.translatable("tooltip." + Cosmopolitan.MODID + ".salt_qingtuan.when_consumed").withStyle(ChatFormatting.BLUE));
        }

        CosmoTooltipEvent.addEffectTooltip(this, stack, tooltip);
    }

}

package com.gumillea.cosmopolitan.common.item;

import com.gumillea.cosmopolitan.CosmoConfig;
import com.gumillea.cosmopolitan.core.reg.CosmoItems;
import com.gumillea.cosmopolitan.core.util.CosmoCompat;
import com.gumillea.cosmopolitan.core.util.CosmoEvents;
import com.gumillea.cosmopolitan.core.util.CosmoUtils;
import com.mojang.datafixers.util.Pair;
import net.minecraft.ChatFormatting;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.registries.ForgeRegistries;
import umpaz.brewinandchewin.common.registry.BnCEffects;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Supplier;

// Adapted from: https://github.com/MerchantCalico/BrewinAndChewin/blob/1.20.1/src/main/java/umpaz/brewinandchewin/common/item/BoozeItem.java
public class BnCDrinkItem extends DrinkItem {

    private final Fluid fluid;

    public BnCDrinkItem(Properties properties, boolean honey_drink, boolean tooltip , Fluid fluid) {
        super(properties, honey_drink, tooltip);
        this.fluid = fluid;
    }

    public Fluid getFluid() {
        return this.fluid;
    }

    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity living) {
        if (!level.isClientSide) {
            Optional<Pair<MobEffectInstance, Float>> tipsy = stack.getFoodProperties(living).getEffects().stream().filter((pair) -> pair.getFirst().getEffect() == BnCEffects.TIPSY.get()).findFirst();
            this.affectConsumer(living, tipsy.map((pair) -> pair.getFirst().getDuration()).orElse(0), tipsy.map((pair) -> pair.getFirst().getAmplifier()).orElse(-1));

            if (living instanceof Player player && this == CosmoItems.GENERIC_ROMANCE.get()) {
                AABB box = player.getBoundingBox().inflate(8);

                List<Animal> animals = level.getEntitiesOfClass(Animal.class, box, animal -> !animal.isBaby() && !animal.isInLove());
                int count = 0;
                for (Animal animal : animals) {
                    animal.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 300));
                    animal.setInLove(player);
                    count++;
                    if (count >= 4) break;
                }

                player.getCooldowns().addCooldown(this, 2400);
            }

            if (this == CosmoItems.WILDBERRY_PUNCH.get()) {
                CompoundTag data = living.getPersistentData().getCompound("Berrfect");
                List<MobEffectInstance> effects = living.getActiveEffects().stream().filter(inst -> data.contains(ForgeRegistries.MOB_EFFECTS.getKey(inst.getEffect()).toString())).map(MobEffectInstance::new).toList();
                if (!effects.isEmpty()) {
                    CosmoUtils.applyHealing(0.5F * effects.size(), living);
                    for (MobEffectInstance inst : effects) {
                        living.removeEffect(inst.getEffect());
                    }
                }
            }

        }

        ItemStack containerStack = stack.getCraftingRemainingItem();
        if (stack.isEdible()) {
            super.finishUsingItem(stack, level, living);
        } else {
            Player player = living instanceof Player ? (Player)living : null;
            if (player instanceof ServerPlayer) {
                CriteriaTriggers.CONSUME_ITEM.trigger((ServerPlayer)player, stack);
            }

            if (player != null) {
                player.awardStat(Stats.ITEM_USED.get(this));
                if (!player.getAbilities().instabuild) {
                    stack.shrink(1);
                }
            }
        }

        if (stack.isEmpty()) {
            return containerStack;
        } else {
            if (living instanceof Player) {
                Player player = (Player)living;
                if (!((Player)living).getAbilities().instabuild && !player.getInventory().add(containerStack)) {
                    player.drop(containerStack, false);
                }
            }

            return stack;
        }
    }

    public void affectConsumer(LivingEntity consumer, int duration, int potency) {
        if (consumer.hasEffect(BnCEffects.TIPSY.get())) {
            MobEffectInstance effect = consumer.getEffect(BnCEffects.TIPSY.get());
            consumer.addEffect(new MobEffectInstance(BnCEffects.TIPSY.get(), effect.getDuration() == -1 ? -1 : effect.getDuration() + duration, Math.min(effect.getAmplifier() + potency + 1, 9), effect.isAmbient(), effect.isVisible(), effect.showIcon()));
        }

    }

    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        if (!CosmoCompat.bnc && !CosmoConfig.Client.EFFECT_TOOLTIP.get()) return;
        super.appendHoverText(stack, worldIn, tooltip, flagIn);

        for(int i = 0; i < tooltip.size(); ++i) {
            Component component = tooltip.get(i);
            if (Set.of(BnCEffects.TIPSY, (Supplier)() -> MobEffects.BAD_OMEN).stream().anyMatch((supplier) -> component.contains(Component.translatable(((MobEffect)supplier.get()).getDescriptionId())))) {
                tooltip.set(i, component.copy().withStyle(ChatFormatting.RED));
            }
        }

    }


}

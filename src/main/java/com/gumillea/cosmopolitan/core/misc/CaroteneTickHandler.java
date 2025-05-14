package com.gumillea.cosmopolitan.core.misc;

import com.gumillea.cosmopolitan.CosmoConfig;
import com.gumillea.cosmopolitan.Cosmopolitan;
import com.gumillea.cosmopolitan.core.reg.CosmoEffects;
import com.gumillea.cosmopolitan.core.util.CosmoItemTags;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;

@Mod.EventBusSubscriber(modid = Cosmopolitan.MODID)
public class CaroteneTickHandler {
    private static int tickCounter = 0;

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase != TickEvent.Phase.END || event.player.level().isClientSide) {
            return;
        }
        tickCounter++;

        if (tickCounter < CaroteneCapability.TICK_INTERVAL) return;
        tickCounter = 0;

        ServerPlayer player = (ServerPlayer) event.player;
        player.getCapability(CaroteneCapability.CAP).ifPresent(cap -> {
            boolean hasEffect = player.hasEffect(CosmoEffects.CAROTENE.get());
            int decay = hasEffect ? CaroteneCapability.DECAY_RATE * 4 : CaroteneCapability.DECAY_RATE;

            cap.add(-decay);
            updateCaroteneEffect(player, cap.get());
        });
    }

    @SubscribeEvent
    public static void onItemUsed(LivingEntityUseItemEvent.Finish event) {
        if (!CosmoConfig.Common.CARROT_FLAVOR.get()) return;
        ItemStack stack = event.getItem();
        Entity user = event.getEntity();

        if (user instanceof ServerPlayer player && stack.isEdible() && stack.is(CosmoItemTags.CAROTENE_SOURCES)) {
            int nutrition = Objects.requireNonNull(stack.getFoodProperties(player)).getNutrition();
            player.getCapability(CaroteneCapability.CAP).ifPresent(cap -> {
                cap.add(nutrition * 30);
                updateCaroteneEffect(player, cap.get());
            });
        }
    }

    @SubscribeEvent
    public static void onPlayerDeath(LivingDeathEvent event) {
        if (!(event.getEntity() instanceof ServerPlayer player)) return;
        player.getCapability(CaroteneCapability.CAP).ifPresent(cap -> {
            cap.set(0);
        });
    }

    private static void updateCaroteneEffect(ServerPlayer player, int i) {
        boolean hasEffect = player.hasEffect(CosmoEffects.CAROTENE.get());
        if (i >= CaroteneCapability.THRESHOLD) {
            if (!hasEffect) {
                player.addEffect(new MobEffectInstance(CosmoEffects.CAROTENE.get(), -1, 0));
            }
        }
        if (i <= CaroteneCapability.REMOVE_THRESHOLD && hasEffect) {
            player.removeEffect(CosmoEffects.CAROTENE.get());
        }
    }

}

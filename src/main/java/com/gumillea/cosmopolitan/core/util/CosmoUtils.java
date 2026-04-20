package com.gumillea.cosmopolitan.core.util;

import com.gumillea.cosmopolitan.Cosmopolitan;
import com.teamabnormals.neapolitan.common.item.HealingItem;
import net.minecraft.client.gui.components.Tooltip;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;

public class CosmoUtils {

    public static void effect(LivingEntity entity, MobEffect effect, int d, int a) {
        entity.addEffect(new MobEffectInstance(effect, d, a));
    }

    public static void applyHealing (float amount, LivingEntity living) {
        if (CosmoCompat.nea) {
            HealingItem.applyHealing(amount, living.level(), living);
        } else {
            living.heal(amount);
        }
    }

    public static void giveExperience(int amount, LivingEntity living) {
        if (living instanceof Player player && !player.level().isClientSide) {
            player.giveExperiencePoints(amount);
            player.playNotifySound(SoundEvents.EXPERIENCE_ORB_PICKUP, player.getSoundSource(),1.0F, 1.0F);
        }
    }

    public static void gainRandomEffect (Level level, LivingEntity living, MobEffect effect1, MobEffect effect2, int duration) {
        if (level.getRandom().nextBoolean()) {
            living.addEffect(new MobEffectInstance(effect1, duration));
        } else {
            living.addEffect(new MobEffectInstance(effect2, duration));
        }
    }

    public static boolean random (Level level, float chance) {
        return level.getRandom().nextFloat() <= chance;
    }

    public static boolean random (Level level, double chance) {
        return level.getRandom().nextFloat() <= chance;
    }

    public static boolean tickRandom (Level level, int tick, double chance) {
        return level.getGameTime() % tick == 0 && random(level, chance);
    }

    public static void addItem (Entity entity, Item item) {
        addItem(entity, item, 1);
    }

    public static void addItem (Entity entity, Item item, int i) {
        if (entity instanceof Player player) {
            player.addItem(new ItemStack(item, i));
        }
    }

    public static void dropLoot (Entity entity, String name) {
        if (entity instanceof ServerPlayer player) {
            ServerLevel level = player.serverLevel();
            LootTable table = level.getServer().getLootData().getLootTable(new ResourceLocation(Cosmopolitan.MODID, name));

            table.getRandomItems(new LootParams.Builder(level).withParameter(LootContextParams.THIS_ENTITY, player).withParameter(LootContextParams.ORIGIN, player.position()).create(LootContextParamSets.GIFT), player::addItem);
        }
    }
    public static boolean hasNbt(ItemStack stack, String nbt) {
        return stack.hasTag() && stack.getTag().getBoolean(nbt);
    }

    public static boolean containsNbt(ItemStack stack, String nbt) {
        return stack.hasTag() && stack.getTag().contains(nbt);
    }

    public static boolean isTagEmpty(TagKey<Item> tagKey) {
        return BuiltInRegistries.ITEM.getTag(tagKey).map(tag -> tag.size() == 0).orElse(true);
    }

    public static List<MobEffectInstance> getLivingEffects(LivingEntity living, Boolean isBeneficial) {
        return living.getActiveEffects().stream().filter(inst -> inst.getDuration() != -1 && (isBeneficial == inst.getEffect().isBeneficial())).map(MobEffectInstance::new).toList();
    }

    public static void shiftTooltip(List<Component> tooltip, Component component1, Component component2) {
        if (Screen.hasShiftDown()) {
            tooltip.add(component1);
        } else {
            tooltip.add(component2);
        }
    }

    public static Block modBlock(String modid, String path) {
        return ForgeRegistries.BLOCKS.getValue(id(modid, path));
    }

    public static Item modItem(String modid, String path) {
        return ForgeRegistries.ITEMS.getValue(id(modid, path));
    }

    public static MobEffect modEffect(String modid, String path) {
        return ForgeRegistries.MOB_EFFECTS.getValue(id(modid, path));
    }

    public static ResourceLocation id(String modid, String path) {
        return new ResourceLocation(modid, path);
    }

}

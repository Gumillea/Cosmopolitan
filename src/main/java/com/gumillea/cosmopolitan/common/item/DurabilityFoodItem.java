package com.gumillea.cosmopolitan.common.item;

import com.aizistral.enigmaticlegacy.registries.EnigmaticSounds;
import com.gumillea.cosmopolitan.core.reg.CosmoItems;
import com.gumillea.cosmopolitan.core.util.CosmoCompat;
import com.mojang.datafixers.util.Pair;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;

public class DurabilityFoodItem extends EffectItem{

    public final boolean isEternal;

    public DurabilityFoodItem(Properties properties, int i, boolean isEternal) {
        super(properties.durability(i));
        this.isEternal = isEternal;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack itemStack, Level level, LivingEntity entity) {
        if (!this.isEdible() || (this.isEternal && itemStack.getDamageValue() == itemStack.getMaxDamage() - 1)) return itemStack;

        level.playSound(null, entity.getX(), entity.getY(), entity.getZ(), this.getEatingSound(), SoundSource.NEUTRAL, 1.0F, 1.0F + (level.random.nextFloat() - level.random.nextFloat()) * 0.4F);
        eat(itemStack, level, entity);
        entity.gameEvent(GameEvent.EAT);

        itemStack.setDamageValue(itemStack.getDamageValue() + 1);

        if (entity instanceof Player player) {
            if (this.isEternal && itemStack.getDamageValue() >= itemStack.getMaxDamage() - 2) {
                player.getCooldowns().addCooldown(this, itemStack.getMaxDamage() * 300);
            }

            if (itemStack.getDamageValue() >= itemStack.getMaxDamage()) {
                if (!player.getAbilities().instabuild){
                    itemStack.shrink(1);
                } else{
                    itemStack.setDamageValue(0);
                }
            }
        }

        return itemStack;
    }

    private void eat(ItemStack itemStack, Level level, LivingEntity entity) {
        Item item = itemStack.getItem();
        if (item.isEdible()) {
            if (entity instanceof Player player) {
                player.getFoodData().eat(this, itemStack, player);
            }

            for(Pair<MobEffectInstance, Float> pair : itemStack.getFoodProperties(entity).getEffects()) {
                if (!level.isClientSide && pair.getFirst() != null && level.random.nextFloat() < pair.getSecond()) {
                    entity.addEffect(new MobEffectInstance(pair.getFirst()));
                    }
            }
        }
    }

    @Override
    public void inventoryTick(ItemStack itemStack, Level level, Entity entity, int i, boolean b) {
        if (level.isClientSide || !this.isEternal || !(entity instanceof Player player)) return;

        if (!player.getCooldowns().isOnCooldown(this)) {
            if (itemStack.getDamageValue() >= itemStack.getMaxDamage() - 1) {
                SoundEvent event = CosmoCompat.el ? EnigmaticSounds.EAT_REVERSE : this.getEatingSound();
                itemStack.setDamageValue(0);
                level.playSound(null, entity.getX(), entity.getY(), entity.getZ(), event, SoundSource.NEUTRAL, 1.0F, 1.0F + (level.random.nextFloat() - level.random.nextFloat()) * 0.4F);
            }
        }
    }

    public int getUseDuration(ItemStack stack) {
        return this == CosmoItems.MEADOW_BREAD.get() ? 32 : 48;
    }

    public boolean isBarVisible(ItemStack stack) {
        return false;
    }

    public boolean isRepairable(ItemStack stack) {
        return false;
    }

    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        return false;
    }

    public boolean isEnchantable(ItemStack stack) {
        return false;
    }

}

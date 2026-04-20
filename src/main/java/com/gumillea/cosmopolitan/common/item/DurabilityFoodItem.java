package com.gumillea.cosmopolitan.common.item;

import com.aizistral.enigmaticlegacy.registries.EnigmaticSounds;
import com.gumillea.cosmopolitan.CosmoConfig;
import com.gumillea.cosmopolitan.core.reg.CosmoEffects;
import com.gumillea.cosmopolitan.core.reg.CosmoItems;
import com.gumillea.cosmopolitan.core.util.CosmoCompat;
import com.gumillea.cosmopolitan.core.util.CosmoEvents;
import com.gumillea.cosmopolitan.core.util.CosmoUtils;
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
    public final boolean isFast;

    public DurabilityFoodItem(Properties properties, int i, boolean isEternal, boolean isFast) {
        super(properties.durability(i));
        this.isEternal = isEternal;
        this.isFast = isFast;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack itemStack, Level level, LivingEntity entity) {
        if (!this.isEdible() || (this == CosmoItems.COSMIC_SNOW_CONE.get() && itemStack.getDamageValue() == itemStack.getMaxDamage() - 1)) return itemStack;

        level.playSound(null, entity.getX(), entity.getY(), entity.getZ(), this.getEatingSound(), SoundSource.NEUTRAL, 1.0F, 1.0F + (level.random.nextFloat() - level.random.nextFloat()) * 0.4F);
        eat(itemStack, level, entity);
        entity.gameEvent(GameEvent.EAT);

        itemStack.setDamageValue(itemStack.getDamageValue() + 1);

        if (entity instanceof Player player) {
            if (this == CosmoItems.COSMIC_SNOW_CONE.get() && itemStack.getDamageValue() >= itemStack.getMaxDamage() - 2) {
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
        if (itemStack.getDamageValue() > 0) {
            if (this == CosmoItems.COSMIC_SNOW_CONE.get() && !player.getCooldowns().isOnCooldown(this)) {
                SoundEvent event = CosmoCompat.el ? EnigmaticSounds.EAT_REVERSE : this.getEatingSound();
                itemStack.setDamageValue(0);
                level.playSound(null, entity.getX(), entity.getY(), entity.getZ(), event, SoundSource.NEUTRAL, 1.0F, 1.0F + (level.random.nextFloat() - level.random.nextFloat()) * 0.4F);
            } else if (CosmoUtils.tickRandom(level, 1200, 0.4F)) {
                itemStack.setDamageValue(itemStack.getDamageValue() - 1);
            }
        }
    }

    public int getUseDuration(ItemStack stack) {
        return isFast ? 32 : 48;
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

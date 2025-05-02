package com.gumillea.cosmopolitan.common.item;

import com.gumillea.cosmopolitan.Cosmopolitan;
import com.gumillea.cosmopolitan.core.reg.CosmoItems;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;

public class CocktailItem extends DrinkItem {

    private final RegistryObject<Item> enchanted = CosmoItems.ENCHANTED_COSMOPOLITAN_COCKTAIL;

    public CocktailItem(Properties properties) {
        super(properties, false);
    }

    public boolean isFoil(ItemStack p_41172_) {
        return this == enchanted.get();
    }

    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity living) {
        super.finishUsingItem(stack, level, living);
        if (!level.isClientSide && living instanceof ServerPlayer player) {
            if (this == CosmoItems.COSMOPOLITAN_COCKTAIL.get() || this == enchanted.get()) {
                CompoundTag nbt = player.getPersistentData();
                if (!nbt.getBoolean("has_cosmopolitan_effect")) {
                    MobEffectInstance effect = applyCocktailEffect(level);
                    if (effect != null) {
                        player.addEffect(effect);
                        level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.PLAYER_LEVELUP, SoundSource.PLAYERS, 1.0f, 1.0f);
                        nbt.putBoolean("has_cosmopolitan_effect", true);
                    }
                }
                super.finishUsingItem(stack, level, living);
            }
        }

        return stack;
    }

    private MobEffectInstance applyCocktailEffect (Level level){
        List<MobEffect> availableEffects = new ArrayList<>();
        int amplifier = this == enchanted.get() ? 2: 0;

        for (Holder<MobEffect> holder : BuiltInRegistries.MOB_EFFECT.asHolderIdMap()) {
            MobEffect effect = holder.value();
            //if (!isEffectBlacklisted(effect)) {
                availableEffects.add(effect);
                //}
        }

        if (availableEffects.isEmpty()) {
            return null;
        }

        MobEffect effect = availableEffects.get(level.getRandom().nextInt(availableEffects.size()));
        return new MobEffectInstance(effect, -1, amplifier);
    }

}

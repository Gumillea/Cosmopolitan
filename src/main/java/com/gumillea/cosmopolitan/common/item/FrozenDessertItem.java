package com.gumillea.cosmopolitan.common.item;

import com.gumillea.cosmopolitan.Cosmopolitan;
import com.gumillea.cosmopolitan.core.reg.CosmoItems;
import com.gumillea.cosmopolitan.core.util.CosmoCompat;
import com.teamabnormals.neapolitan.core.registry.NeapolitanSoundEvents;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffectUtil;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;

public class FrozenDessertItem extends EffectItem {
    private final boolean bowl;
    private final int tFrozen;


    public FrozenDessertItem(Properties properties, boolean bowl, int tFrozen) {
        super(properties.stacksTo(bowl ? 1 : 64));
        this.tFrozen = tFrozen;
        this.bowl = bowl;
    }

    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity living) {
        ItemStack itemstack = super.finishUsingItem(stack, level, living);
        living.setTicksFrozen(living.getTicksFrozen() + tFrozen);

        return !bowl || living instanceof Player && ((Player)living).getAbilities().instabuild ? itemstack : new ItemStack(Items.BOWL);
    }

    public SoundEvent getDrinkingSound() {
        return CosmoCompat.nea ? NeapolitanSoundEvents.ICE_CUBES_EAT.get() : SoundEvents.GENERIC_EAT;
    }

    public SoundEvent getEatingSound() {
        return CosmoCompat.nea ? NeapolitanSoundEvents.ICE_CUBES_EAT.get() : SoundEvents.GENERIC_EAT;
    }

}


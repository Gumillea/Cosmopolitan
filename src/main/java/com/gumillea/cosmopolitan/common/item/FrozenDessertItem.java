package com.gumillea.cosmopolitan.common.item;

import com.gumillea.cosmopolitan.core.util.CosmoCompat;
import com.teamabnormals.neapolitan.core.registry.NeapolitanSoundEvents;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

public class FrozenDessertItem extends EffectItem {
    private final boolean bowl;
    private final int tFrozen;

    public FrozenDessertItem(Properties properties, boolean bowl, int tFrozen) {
        super(properties.stacksTo(bowl && tFrozen > 100 ? 1 : 64));
        this.tFrozen = tFrozen;
        this.bowl = bowl;
    }

    public ItemStack finishUsingItem(ItemStack itemStack, Level level, LivingEntity living) {
        living.setTicksFrozen(living.getTicksFrozen() + tFrozen);

        if (!bowl || this.getCraftingRemainingItem() == null) return super.finishUsingItem(itemStack, level, living);

        if (itemStack.isEmpty()) {
            return new ItemStack(this.getCraftingRemainingItem());
        } else {
            if (living instanceof Player player && !player.getAbilities().instabuild) {
                ItemStack remainingStack = new ItemStack(this.getCraftingRemainingItem());
                if (!player.getInventory().add(remainingStack)) {
                    player.drop(remainingStack, false);
                }
            }

            return super.finishUsingItem(itemStack, level, living);
        }

    }

    public SoundEvent getDrinkingSound() {
        return CosmoCompat.nea ? NeapolitanSoundEvents.ICE_CUBES_EAT.get() : SoundEvents.GENERIC_EAT;
    }

    public SoundEvent getEatingSound() {
        return CosmoCompat.nea ? NeapolitanSoundEvents.ICE_CUBES_EAT.get() : SoundEvents.GENERIC_EAT;
    }

    public int getFrozen() {
        return tFrozen;
    }

}


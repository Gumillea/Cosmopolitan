package com.gumillea.cosmopolitan.common.item;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class QuarkEnchantedFruitItem extends FrozenDessertItem {
    private final int eAmount;
    public QuarkEnchantedFruitItem(Properties p, boolean bowl, int tFrozen, int eAmount) {
        super(p, bowl, tFrozen);
        this.eAmount = eAmount;
    }

    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity living) {
        if (level instanceof ServerLevel && living instanceof Player player) {
            player.giveExperiencePoints(eAmount);
            player.playSound(SoundEvents.EXPERIENCE_ORB_PICKUP, 1.0F, 1.0F);
        }
        return super.finishUsingItem(stack, level, living);
    }
}

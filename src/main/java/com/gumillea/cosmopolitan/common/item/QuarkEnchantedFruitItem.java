package com.gumillea.cosmopolitan.common.item;

import com.gumillea.cosmopolitan.core.reg.CosmoItems;
import com.gumillea.cosmopolitan.core.util.CosmoCompat;
import com.gumillea.cosmopolitan.core.util.CosmoUtils;
import com.teamabnormals.neapolitan.core.registry.NeapolitanSoundEvents;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;

public class QuarkEnchantedFruitItem extends NeapolitanIceCreamItem {
    private final int eAmount;
    private SoundEvent event;

    public QuarkEnchantedFruitItem(Properties p, boolean bowl, int tFrozen, int eAmount) {
        super(p, bowl, tFrozen);
        this.eAmount = eAmount;
    }

    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity living) {
        CosmoUtils.giveExperience(eAmount, living);
        return super.finishUsingItem(stack, level, living);
    }

    public SoundEvent getDrinkingSound() {
        if (CosmoCompat.nea && this.gettFrozen() > 0) {
            event = NeapolitanSoundEvents.ICE_CREAM_EAT.get();
        } else if (this == CosmoItems.ENCHANTED_FRUIT_GUMMY.get()) {
            event = SoundEvents.HONEY_BLOCK_HIT;
        } else {
            event = SoundEvents.GENERIC_DRINK;
        }
        return event;
    }

    public SoundEvent getEatingSound() {
        if (CosmoCompat.nea && this.gettFrozen() > 0) {
            event = NeapolitanSoundEvents.ICE_CREAM_EAT.get();
        } else if (this == CosmoItems.ENCHANTED_FRUIT_GUMMY.get()) {
            event = SoundEvents.HONEY_BLOCK_HIT;
        } else {
            event = SoundEvents.GENERIC_EAT;
        }
        return event;
    }
}

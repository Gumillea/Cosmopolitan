package com.gumillea.cosmopolitan.common.item;

import com.gumillea.cosmopolitan.CosmoConfig;
import com.gumillea.cosmopolitan.Cosmopolitan;
import com.gumillea.cosmopolitan.core.reg.CosmoItems;
import com.gumillea.cosmopolitan.core.util.CosmoCompat;
import com.teamabnormals.neapolitan.core.registry.NeapolitanSoundEvents;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;

public class NeapolitanIceCreamItem extends FrozenDessertItem{
    public NeapolitanIceCreamItem(Properties properties, boolean bowl, int tFrozen) {
        super(properties, bowl, tFrozen);
    }

    public SoundEvent getDrinkingSound() {
        return CosmoCompat.nea ? NeapolitanSoundEvents.ICE_CREAM_EAT.get() : SoundEvents.GENERIC_EAT;
    }

    public SoundEvent getEatingSound() {
        return CosmoCompat.nea ? NeapolitanSoundEvents.ICE_CREAM_EAT.get() : SoundEvents.GENERIC_EAT;
    }

    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        if (!CosmoConfig.Client.EFFECT_TOOLTIP.get()) return;
        super.appendHoverText(stack, worldIn, tooltip, flagIn);

        if (this == CosmoItems.BERRY_SYRUP_SHAVED_ICE.get()) {
            MutableComponent coldDrink = Component.translatable("tooltip." + Cosmopolitan.MODID + ".berry_syrup_shaved_ice.when_consumed");
            tooltip.add(coldDrink.withStyle(ChatFormatting.BLUE));
        }
    }
    

}

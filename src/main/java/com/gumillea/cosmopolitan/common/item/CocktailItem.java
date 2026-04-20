package com.gumillea.cosmopolitan.common.item;

import com.gumillea.cosmopolitan.CosmoConfig;
import com.gumillea.cosmopolitan.core.reg.CosmoItems;
import com.gumillea.cosmopolitan.core.util.CosmoEffectTags;
import com.gumillea.cosmopolitan.core.util.CosmoEvents;
import com.gumillea.cosmopolitan.core.util.CosmoUtils;
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
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;

public class CocktailItem extends DrinkItem {

    private final RegistryObject<Item> enchanted = CosmoItems.ENCHANTED_COSMOPOLITAN_COCKTAIL;

    public CocktailItem(Properties properties) {
        super(properties, false, true);
    }

    public boolean isFoil(ItemStack p_41172_) {
        return this == enchanted.get();
    }

    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity living) {
        super.finishUsingItem(stack, level, living);
        CompoundTag data = living.getPersistentData().getCompound("Berrfect");
        List<MobEffectInstance> effects = living.getActiveEffects().stream().filter(inst -> inst.getAmplifier() < 2 && data.contains(ForgeRegistries.MOB_EFFECTS.getKey(inst.getEffect()).toString())).map(MobEffectInstance::new).toList();
        if (!effects.isEmpty()) {
            int amp = this == enchanted.get() ? 2 : 1;
            if (living instanceof Player player) player.playNotifySound(SoundEvents.PLAYER_LEVELUP, player.getSoundSource(),1.0F, 2.0F);
            for (MobEffectInstance inst : effects) {
                living.addEffect(new MobEffectInstance(inst.getEffect(), inst.getDuration(), Math.min(inst.getAmplifier() + amp, 2)));
            }
        }

        return stack;
    }

}

package com.gumillea.cosmopolitan.common.item;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.ForgeHooks;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

public class HerbalCookieItem extends EffectItem {
    public static final String EFFECTS_TAG = "Effects";
    public static final String EFFECT_ID_TAG = "EffectId";
    public static final String EFFECT_DURATION_TAG = "EffectDuration";

    public HerbalCookieItem(Item.Properties properties) {
        super(properties);
    }

    public static void saveMobEffect(ItemStack stack, MobEffect effect, int i) {
        CompoundTag compoundtag = stack.getOrCreateTag();
        ListTag listtag = compoundtag.getList(EFFECTS_TAG, 9);
        CompoundTag compoundtag1 = new CompoundTag();
        compoundtag1.putInt(EFFECT_ID_TAG, MobEffect.getId(effect));
        ForgeHooks.saveMobEffect(compoundtag1, "forge:effect_id", effect);
        compoundtag1.putInt(EFFECT_DURATION_TAG, i);
        listtag.add(compoundtag1);
        compoundtag.put(EFFECTS_TAG, listtag);
    }

    private static void listPotionEffects(ItemStack stack, Consumer<MobEffectInstance> consumer) {
        CompoundTag compoundtag = stack.getTag();
        if (compoundtag != null && compoundtag.contains(EFFECTS_TAG, 9)) {
            ListTag listtag = compoundtag.getList(EFFECTS_TAG, 10);

            for(int i = 0; i < listtag.size(); ++i) {
                CompoundTag compoundtag1 = listtag.getCompound(i);
                int j;
                if (compoundtag1.contains(EFFECT_DURATION_TAG, 99)) {
                    int duration = compoundtag1.getInt(EFFECT_DURATION_TAG);
                    j = duration / 2 < 1 ? duration : duration / 2;
                } else {
                    j = 80;
                }

                MobEffect mobeffect = MobEffect.byId(compoundtag1.getInt(EFFECT_ID_TAG));
                mobeffect = ForgeHooks.loadMobEffect(compoundtag1, "forge:effect_id", mobeffect);
                if (mobeffect != null) {
                    consumer.accept(new MobEffectInstance(mobeffect, j));
                }
            }
        }

    }

    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> components, TooltipFlag flag) {
        super.appendHoverText(stack, level, components, flag);
        if (flag.isCreative()) {
            List<MobEffectInstance> list = new ArrayList();
            Objects.requireNonNull(list);
            listPotionEffects(stack, list::add);
            PotionUtils.addPotionTooltip(list, components, 1.0F);
        }
    }

    public ItemStack finishUsingItem(ItemStack itemStack, Level level, LivingEntity living) {
        ItemStack itemstack = super.finishUsingItem(itemStack, level, living);
        Objects.requireNonNull(living);
        listPotionEffects(itemstack, living::addEffect);
        return itemstack;
    }
}
package com.gumillea.cosmopolitan.common.item;

import com.gumillea.cosmopolitan.core.misc.CosmoCriteriaTriggers;
import com.gumillea.cosmopolitan.core.reg.CosmoItems;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.ForgeHooks;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

public class HerbalFoodItem extends EffectItem {
    public static final String EFFECTS_TAG = "Effects";
    public static final String EFFECT_ID_TAG = "EffectId";
    public static final String EFFECT_DURATION_TAG = "EffectDuration";

    public HerbalFoodItem(Item.Properties properties) {
        super(properties);
    }

    public static void saveMobEffect(ItemStack stack, MobEffect effect, int duration) {
        CompoundTag compoundtag = stack.getOrCreateTag();
        ListTag list = compoundtag.getList(EFFECTS_TAG, 10);

        int effectId = MobEffect.getId(effect);
        boolean found = false;

        int addedDuration = stack.is(CosmoItems.TISANE.get()) && effect != MobEffects.SATURATION ? duration * 2 : duration;

        for (int i = 0; i < list.size(); ++i) {
            CompoundTag tag = list.getCompound(i);
            if (tag.getInt(EFFECT_ID_TAG) == effectId) {
                tag.putInt(EFFECT_DURATION_TAG, tag.getInt(EFFECT_DURATION_TAG) + addedDuration);
                found = true;
                break;
            }
        }

        if (!found) {
            CompoundTag newEffectTag = new CompoundTag();
            newEffectTag.putInt(EFFECT_ID_TAG, effectId);

            ForgeHooks.saveMobEffect(newEffectTag, "forge:effect_id", effect);
            newEffectTag.putInt(EFFECT_DURATION_TAG, addedDuration);

            list.add(newEffectTag);
        }

        compoundtag.put(EFFECTS_TAG, list);
    }

    private static void listPotionEffects(ItemStack stack, Consumer<MobEffectInstance> consumer) {
        CompoundTag compoundtag = stack.getTag();
        if (compoundtag != null) {
            ListTag listtag = compoundtag.getList(EFFECTS_TAG, 10);

            for(int i = 0; i < listtag.size(); ++i) {
                CompoundTag compoundtag1 = listtag.getCompound(i);
                int j;
                if (compoundtag1.contains(EFFECT_DURATION_TAG, 99)) {
                    int duration = compoundtag1.getInt(EFFECT_DURATION_TAG);
                    if (stack.is(CosmoItems.TISANE.get())) {
                        j = duration <= 1 ? duration : duration * 2;
                    } else {
                        j = duration / 2 < 1 ? duration : duration / 2;
                    }
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

        if (living instanceof ServerPlayer serverPlayer && this == CosmoItems.HERBAL_COOKIE.get()) CosmoCriteriaTriggers.HERBAL_COOKIE.trigger(serverPlayer);

        if (this == CosmoItems.TISANE.get()) {
            ItemStack glass = new ItemStack(Items.GLASS_BOTTLE);
            if (itemStack.isEmpty()) {
                return glass;
            } else {
                if (living instanceof Player player && !player.getAbilities().instabuild) {
                    if (!player.getInventory().add(glass)) {
                        player.drop(glass, false);
                    }
                }
                return itemStack;
            }
        }
        return itemstack;
    }

    public UseAnim getUseAnimation(ItemStack itemStack) {
        return this == CosmoItems.TISANE.get() ? UseAnim.DRINK : UseAnim.EAT;
    }

    public SoundEvent getDrinkingSound() {
        return SoundEvents.GENERIC_DRINK;
    }

    public SoundEvent getEatingSound() {
        return SoundEvents.GENERIC_EAT;
    }
}
package com.gumillea.cosmopolitan.common.item;

import com.gumillea.cosmopolitan.CosmoConfig;
import com.gumillea.cosmopolitan.Cosmopolitan;
import com.gumillea.cosmopolitan.core.reg.CosmoItems;
import com.gumillea.cosmopolitan.core.util.CosmoEvents;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;

public class EffectBowlItem extends EffectItem {
    public EffectBowlItem(Item.Properties properties) {
        super(properties);
    }

    public ItemStack finishUsingItem(ItemStack itemStack, Level level, LivingEntity living) {
        super.finishUsingItem(itemStack, level, living);

        if (this == CosmoItems.CREAM.get()) {
            CosmoEvents.creamEffect(level, living, itemStack);
        }

        if (this == CosmoItems.CLASSIC_FRUIT_SALAD.get()) {
            WildberryItem.applyBerryEffect(level, living, 1);
        }

        if (this == CosmoItems.WILDBERRY_MEDLEY.get()) {
            WildberryItem.applyBerryEffect(level, living, 4);
        }

        if (this.getCraftingRemainingItem() == null) return itemStack;

        if (itemStack.isEmpty()) {
            return new ItemStack(this.getCraftingRemainingItem());
        } else {
            if (living instanceof Player player && !player.getAbilities().instabuild) {
                ItemStack stack = new ItemStack(this.getCraftingRemainingItem());
                if (!player.getInventory().add(stack)) {
                    player.drop(stack, false);
                }
            }

            return itemStack;
        }
    }

    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        if (!CosmoConfig.Client.EFFECT_TOOLTIP.get()) return;
        super.appendHoverText(stack, worldIn, tooltip, flagIn);


        if (this == CosmoItems.CREAM.get()) {
            MutableComponent coldDrink = Component.translatable("tooltip." + Cosmopolitan.MODID + ".cream.when_consumed");
            tooltip.add(coldDrink.withStyle(ChatFormatting.BLUE));
        }
    }

}


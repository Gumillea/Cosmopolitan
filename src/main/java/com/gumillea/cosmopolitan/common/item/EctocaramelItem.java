package com.gumillea.cosmopolitan.common.item;

import com.gumillea.cosmopolitan.CosmoConfig;
import com.gumillea.cosmopolitan.Cosmopolitan;
import com.gumillea.cosmopolitan.core.util.CosmoUtils;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;

public class EctocaramelItem extends EffectItem {

    private final int i;

    public EctocaramelItem(Properties properties, int i) {
        super(properties);
        this.i = i;
    }

    public ItemStack finishUsingItem(ItemStack itemStack, Level level, LivingEntity living) {
        if (living instanceof Player player) {
            int ectocaramel = level.random.nextInt(2 * i) - i;
            if (ectocaramel > 0) {
                player.getFoodData().eat(ectocaramel, 0F);
            } else {
                FoodData food = player.getFoodData();
                food.setFoodLevel(Math.max(food.getFoodLevel() + ectocaramel, 0));
            }
        }
        return super.finishUsingItem(itemStack, level, living);
    }

    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        if (!CosmoConfig.Client.EFFECT_TOOLTIP.get()) return;
        super.appendHoverText(stack, worldIn, tooltip, flagIn);

        CosmoUtils.shiftTooltip(tooltip,
                Component.literal("◆ ").append(Component.translatable("tooltip." + Cosmopolitan.MODID + ".ghost_food.info")).withStyle(style -> style.withColor(0x9ff3c5)),
                Component.literal("◆ ").append(Component.translatable("tooltip." + Cosmopolitan.MODID + ".ghost_food")).withStyle(style -> style.withColor(0x9ff3c5))
        );

    }

}
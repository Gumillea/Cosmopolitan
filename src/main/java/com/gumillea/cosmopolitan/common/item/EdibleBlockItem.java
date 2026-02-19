package com.gumillea.cosmopolitan.common.item;

import com.gumillea.cosmopolitan.CosmoConfig;
import com.gumillea.cosmopolitan.Cosmopolitan;
import com.gumillea.cosmopolitan.core.reg.CosmoItems;
import com.gumillea.cosmopolitan.core.util.CosmoTooltipEvent;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.List;

public class EdibleBlockItem extends BlockItem {

    public EdibleBlockItem(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        int setting = CosmoConfig.Common.PLACEABLE_FOOD_SETTING.get();

        if (setting == 2) {
            return InteractionResultHolder.pass(player.getItemInHand(hand));
        }

        return super.use(level, player, hand);
    }

    public @NotNull InteractionResult place(BlockPlaceContext context) {
        Player player = context.getPlayer();
        int setting = CosmoConfig.Common.PLACEABLE_FOOD_SETTING.get();

        if (setting == 0) return InteractionResult.FAIL;
        if (setting == 1 && player != null && !player.isShiftKeyDown()) return InteractionResult.FAIL;

        return super.place(context);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        if (!CosmoConfig.Client.EFFECT_TOOLTIP.get()) return;

        int setting = CosmoConfig.Common.PLACEABLE_FOOD_SETTING.get();

        if (setting != 0) {
        MutableComponent placeableSetting = setting == 1 ? Component.translatable("tooltip." + Cosmopolitan.MODID + ".placeable_while_sneaking") : Component.translatable("tooltip." + Cosmopolitan.MODID + ".placeable");
        tooltip.add(placeableSetting.withStyle(ChatFormatting.DARK_GRAY, ChatFormatting.ITALIC));
        }

        if (setting != 2) {
            CosmoTooltipEvent.addEffectTooltip(this, stack, tooltip);
        }

        if (this == CosmoItems.WHEATGRASS_CUBECAKE.get()) {
            CosmoTooltipEvent.addWheatgrassTooltip(tooltip);
        }
    }

}

package com.gumillea.cosmopolitan.common.item;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class SourceBerryPipsItem extends Item {

    private final Block bush;

    public SourceBerryPipsItem(Block block, Properties properties) {
        super(properties);
        this.bush = block;
    }

    @Override
    public @NotNull InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos clickedPos = context.getClickedPos();
        Direction direction = context.getClickedFace();
        BlockState bush = this.bush.defaultBlockState();
        Player player = context.getPlayer();
        ItemStack stack = context.getItemInHand();

        if (level.getBlockState(clickedPos).canBeReplaced() && bush.canSurvive(level, clickedPos)) {
            placeBush(level, clickedPos, player, stack);
            return InteractionResult.sidedSuccess(level.isClientSide());
        }

        BlockPos targetPos = clickedPos.relative(direction);
        if (level.getBlockState(targetPos).canBeReplaced() && bush.canSurvive(level, targetPos)) {
            placeBush(level, targetPos, player, stack);
            return InteractionResult.sidedSuccess(level.isClientSide());
        }

        return InteractionResult.FAIL;
    }

    private void placeBush(Level level, BlockPos pos, Player player, ItemStack stack) {
        level.setBlock(pos, bush.defaultBlockState(), 3);
        level.playSound(player, pos, SoundEvents.SWEET_BERRY_BUSH_PLACE, SoundSource.BLOCKS, 1.0F, level.getRandom().nextFloat() * 0.4F + 0.8F);

        if (player instanceof ServerPlayer serverPlayer) {
            CriteriaTriggers.PLACED_BLOCK.trigger(serverPlayer, pos, stack);
        }
        if (player == null || !player.getAbilities().instabuild) {
            stack.shrink(1);
        }
    }


}
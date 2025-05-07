package com.gumillea.cosmopolitan.common.block;

import com.gumillea.cosmopolitan.core.reg.CosmoItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class SappyLogBlock extends RotatedPillarBlock {

    private final Block log;

    public SappyLogBlock(Properties properties, Block log) {
        super(properties);
        this.log = log;
        this.registerDefaultState(this.stateDefinition.any().setValue(AXIS, Direction.Axis.Y));
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        ItemStack inHand = player.getItemInHand(hand);
        if (inHand.is(Items.GLASS_BOTTLE)) {
            level.playSound(player, pos.getX(), pos.getY(), pos.getZ(), SoundEvents.BOTTLE_FILL, SoundSource.BLOCKS, 1.0F, 1.0F);
            if (inHand.isEmpty()) {
                player.setItemInHand(hand, new ItemStack(CosmoItems.BIRCH_SAP_BOTTLE.get()));
            } else if (!player.getInventory().add(new ItemStack(CosmoItems.BIRCH_SAP_BOTTLE.get()))) {
                player.drop(new ItemStack(CosmoItems.BIRCH_SAP_BOTTLE.get()), false);
            }

            level.setBlock(pos, log.defaultBlockState().setValue(AXIS, state.getValue(RotatedPillarBlock.AXIS)), 11);
            return InteractionResult.sidedSuccess(level.isClientSide);
        }
        return InteractionResult.PASS;
    }
}

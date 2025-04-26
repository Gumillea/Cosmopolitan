package com.gumillea.cosmopolitan.common.block;

import com.gumillea.cosmopolitan.common.blockEntity.FrozenDessertTubBlockEntity;
import com.gumillea.cosmopolitan.core.misc.TubExtractRecipe;
import com.gumillea.cosmopolitan.core.misc.TubInjectRecipe;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class FrozenDessertTubBlock extends BaseEntityBlock implements EntityBlock {
    private static final VoxelShape INSIDE = Block.box(2, 1, 2, 14, 16, 14);
    private static final VoxelShape SHAPE = Shapes.join(Shapes.block(), INSIDE, BooleanOp.ONLY_FIRST);

    public FrozenDessertTubBlock(Properties props) {
        super(props);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, net.minecraft.world.phys.shapes.CollisionContext context) {
        return SHAPE;
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        var entity = level.getBlockEntity(pos);
        if (!(entity instanceof FrozenDessertTubBlockEntity tub)) return InteractionResult.PASS;

        ItemStack inHand = player.getItemInHand(hand);
        ItemStack result;
        result = TubInjectRecipe.tryApply(level, tub, inHand, player, hand);
        if (!result.isEmpty()) {
            player.setItemInHand(hand, result);
            return InteractionResult.SUCCESS;
        }

        result = TubExtractRecipe.tryApply(level, tub, inHand, player, hand);
        if (!result.isEmpty()) {
            player.setItemInHand(hand, result);
            return InteractionResult.SUCCESS;
        }

        return InteractionResult.PASS;
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new FrozenDessertTubBlockEntity(pos, state);
    }
}
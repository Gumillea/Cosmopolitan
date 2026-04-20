package com.gumillea.cosmopolitan.common.block;

import com.gumillea.cosmopolitan.core.reg.CosmoBlocks;
import com.mojang.datafixers.util.Pair;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.event.ForgeEventFactory;
import vectorwing.farmersdelight.common.utility.ItemUtils;

import java.util.function.Supplier;

public class RollCakeBlock extends FDPieBlock{
    public static final BooleanProperty DOUBLE = BooleanProperty.create("double");
    protected static final VoxelShape SHAPE = Block.box(1.0F, 0.0F, 1.0F, 15.0F, 5.0F, 15.0F);

    public RollCakeBlock(Properties properties, Supplier<Item> pieSlice) {
        super(properties, pieSlice);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(DOUBLE, false).setValue(BITES, 0));
    }

    @Override
    public int getMaxBites() {
        return 3;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection()).setValue(DOUBLE, false).setValue(BITES, 0);
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, BITES, DOUBLE);
    }

    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        ItemStack heldStack = player.getItemInHand(hand);
        Boolean d = state.getValue(DOUBLE);
        int bites = state.getValue(BITES);

        if (heldStack.is(this.getPieItem().getItem()) && !d) {
            level.playSound(null, pos, SoundEvents.WOOL_PLACE, SoundSource.PLAYERS, 0.8F, 0.8F);
            level.setBlock(pos, state.setValue(BITES, bites).setValue(DOUBLE, true), 3);
            if (!player.isCreative()) heldStack.shrink(1);
            return InteractionResult.SUCCESS;
        }

        return super.use(state, level, pos, player, hand, hit);
    }

    @Override
    protected InteractionResult consumeBite(Level level, BlockPos pos, BlockState state, Player playerIn) {
        if (!playerIn.canEat(false)) {
            return InteractionResult.PASS;
        } else {
            ItemStack sliceStack = this.getPieSliceItem();
            ItemStack sliceCopy = sliceStack.copy();
            FoodProperties sliceFood = sliceStack.getItem().getFoodProperties();
            playerIn.getFoodData().eat(sliceStack.getItem(), sliceStack);
            ForgeEventFactory.onItemUseFinish(playerIn, sliceCopy, 0, ItemStack.EMPTY);
            if (this.getPieSliceItem().getItem().isEdible() && sliceFood != null) {
                for(Pair<MobEffectInstance, Float> pair : sliceFood.getEffects()) {
                    if (!level.isClientSide && pair.getFirst() != null && level.random.nextFloat() < pair.getSecond()) {
                        playerIn.addEffect(new MobEffectInstance(pair.getFirst()));
                    }
                }
            }

            int bites = state.getValue(BITES);
            Boolean d = state.getValue(DOUBLE);
            if (bites < this.getMaxBites() - 1) {
                level.setBlock(pos, state.setValue(BITES, bites + 1).setValue(DOUBLE, d), 3);
            } else if (d) {
                level.setBlock(pos, state.setValue(BITES, 0).setValue(DOUBLE, false), 3);
            } else {
                level.removeBlock(pos, false);
            }

            level.playSound(null, pos, SoundEvents.GENERIC_EAT, SoundSource.PLAYERS, 0.8F, 0.8F);
            return InteractionResult.SUCCESS;
        }
    }

    @Override
    protected InteractionResult cutSlice(Level level, BlockPos pos, BlockState state, Player player) {
        int bites = state.getValue(BITES);
        boolean d = state.getValue(DOUBLE);

        if (bites < this.getMaxBites() - 1) {
            level.setBlock(pos, state.setValue(BITES, bites + 1), 3);
        } else if (d) {
            level.setBlock(pos, state.setValue(BITES, 0).setValue(DOUBLE, false), 3);
        } else {
            level.removeBlock(pos, false);
        }

        Direction direction = player.getDirection().getOpposite();
        ItemStack roll = this.getPieSliceItem();
        ItemUtils.spawnItemEntity(level, roll, (double)pos.getX() + (double)0.5F, (double)pos.getY() + 0.3, (double)pos.getZ() + (double)0.5F, (double)direction.getStepX() * 0.15, 0.05, (double)direction.getStepZ() * 0.15);
        level.playSound(null, pos, SoundEvents.WOOL_BREAK, SoundSource.PLAYERS, 0.8F, 0.8F);
        return InteractionResult.SUCCESS;
    }

    @Override
    public int getLightEmission(BlockState state, BlockGetter level, BlockPos pos) {
        return this == CosmoBlocks.INK_ROLL.get() ? 10 : 0;
    }


}

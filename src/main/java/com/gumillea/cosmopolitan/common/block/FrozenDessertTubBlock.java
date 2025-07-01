package com.gumillea.cosmopolitan.common.block;

import com.gumillea.cosmopolitan.common.blockEntity.FrozenDessertTubBlockEntity;
import com.gumillea.cosmopolitan.common.fluid.CosmoIceCreamFluidType;
import com.gumillea.cosmopolitan.core.misc.recipes.TubExtractRecipe;
import com.gumillea.cosmopolitan.core.misc.recipes.TubInjectRecipe;
import com.gumillea.cosmopolitan.core.misc.recipes.TubInteractingRecipe;
import com.gumillea.cosmopolitan.core.reg.CosmoBlockEntityTypes;
import com.gumillea.cosmopolitan.core.reg.CosmoFluids;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.fluids.FluidStack;

public class FrozenDessertTubBlock extends BaseEntityBlock implements EntityBlock {
    public static final BooleanProperty OPEN = BooleanProperty.create("open");
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    private static final VoxelShape INSIDE = Block.box(2, 1, 2, 14, 16, 14);
    private static final VoxelShape SHAPE = Shapes.join(Shapes.block(), INSIDE, BooleanOp.ONLY_FIRST);


    public FrozenDessertTubBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(OPEN, true));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(OPEN);
        builder.add(FACING);
    }


    public BlockState getStateForPlacement(BlockPlaceContext context) {
        boolean player = context.getPlayer() != null && context.getPlayer().isShiftKeyDown();
        return player ? this.defaultBlockState().setValue(OPEN, false).setValue(FACING, context.getHorizontalDirection()) : this.defaultBlockState().setValue(FACING, context.getHorizontalDirection());
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        if (!state.getValue(OPEN)) {
            return Shapes.block();
        }
        return SHAPE;
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (!(level.getBlockEntity(pos) instanceof FrozenDessertTubBlockEntity tub)) return InteractionResult.PASS;

        boolean open = state.getValue(OPEN);
        ItemStack inHand = player.getItemInHand(hand);
        ItemStack result;

        if (player.isShiftKeyDown() || (!inHand.isEmpty() && inHand.is(ItemTags.PICKAXES))) {
            if (!level.isClientSide) {
                setOpen(state, level, pos, player);
            }
            return InteractionResult.sidedSuccess(level.isClientSide);
        }

        if (!open) {
            return InteractionResult.PASS;
        }

        result = TubInjectRecipe.tryApply(level, tub, inHand, player, hand);
        if (!result.isEmpty()) {
            contentApply(level, pos);
            return InteractionResult.SUCCESS;
        }

        result = TubExtractRecipe.tryApply(level, tub, inHand, player, hand);
        if (!result.isEmpty()) {
            FluidStack stack = tub.getTank().getFluid();
            if (stack.getFluid().getFluidType() instanceof CosmoIceCreamFluidType || stack.getFluid().isSame(CosmoFluids.CREAM.get())) {
                level.playSound(null, pos, SoundEvents.SNOW_BREAK, SoundSource.BLOCKS, 0.8F, 0.8F);
            } else {
                level.playSound(null, pos, SoundEvents.BUCKET_FILL, SoundSource.BLOCKS, 0.8F, 0.8F);
            }
            return InteractionResult.SUCCESS;
        }

        return InteractionResult.PASS;
    }

    public static void setOpen(BlockState state, Level level, BlockPos pos, Player player) {
        boolean open = state.getValue(OPEN);

        level.playSound(null, pos, SoundEvents.IRON_DOOR_OPEN, SoundSource.BLOCKS, 0.8F, 0.8F);
        level.setBlock(pos, state.setValue(OPEN, !open), 3);
        level.gameEvent(player, !open ? GameEvent.BLOCK_OPEN : GameEvent.BLOCK_CLOSE, pos);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new FrozenDessertTubBlockEntity(pos, state);
    }

    @Override
    public int getLightEmission(BlockState state, BlockGetter getter, BlockPos pos) {
        BlockEntity entity = getter.getBlockEntity(pos);
        if (entity instanceof FrozenDessertTubBlockEntity tub) {
            FluidStack stack = tub.getTank().getFluid();
            if (!stack.isEmpty() && state.getValue(OPEN)) {
                return stack.getFluid().getFluidType().getLightLevel(stack);
            }
        }
        return super.getLightEmission(state, getter, pos);
    }

    @Override
    public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        super.entityInside(state, level, pos, entity);

        if (level.isClientSide || !state.getValue(OPEN)) return;

        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (!(blockEntity instanceof FrozenDessertTubBlockEntity tub)) return;
        FluidStack fluidStack = tub.getTank().getFluid();

        if (entity instanceof ItemEntity) {
            TubInteractingRecipe.tryApply(level, tub, pos, state);
        }

        if (fluidStack.getFluid().isSame(Fluids.LAVA)) {
            entity.lavaHurt();
        } else {
            if (entity.isOnFire()) {
                entity.clearFire();
            }
            if (fluidStack.getFluid().getFluidType() instanceof CosmoIceCreamFluidType) {
                entity.setIsInPowderSnow(true);
            }
        }
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        return level.isClientSide ? null : createTickerHelper(type, CosmoBlockEntityTypes.FROZEN_DESSERT_TUB.get(), FrozenDessertTubBlockEntity::tick);
    }

    @Override
    public boolean isPathfindable(BlockState state, BlockGetter getter, BlockPos pos, PathComputationType type) {
        return false;
    }

    public static void contentApply(Level level, BlockPos pos) {
        RandomSource rand = level.getRandom();
        BlockEntity entity = level.getBlockEntity(pos);

        if (entity instanceof FrozenDessertTubBlockEntity tub) {
            FluidStack stack = tub.getTank().getFluid();
            if (stack.getFluid().isSame(Fluids.LAVA)) {
                level.playSound(null, pos, SoundEvents.BUCKET_EMPTY_LAVA, SoundSource.BLOCKS, 0.8F, 0.8F);
            } else if (stack.getFluid().isSame(CosmoFluids.CREAM.get()) || stack.getFluid().getFluidType() instanceof CosmoIceCreamFluidType) {
                level.playSound(null, pos, SoundEvents.SNOW_PLACE, SoundSource.BLOCKS, 0.8F, 0.8F);
            } else {
                level.playSound(null, pos, SoundEvents.BUCKET_EMPTY, SoundSource.BLOCKS, 0.8F, 0.8F);
            }
        }

        if (!level.isClientSide && level instanceof ServerLevel server)
            for(int i = 0; i < 6; ++i) {
                double d0 = (rand.nextDouble() - 0.5) * 0.02;
                double d1 = 0.075D;
                double d2 = (rand.nextDouble() - 0.5) * 0.02;

                double x = pos.getX() + 0.3 + rand.nextDouble() * 0.4;
                double y = pos.getY() + 1;
                double z = pos.getZ() + 0.3 + rand.nextDouble() * 0.4;
                server.sendParticles(ParticleTypes.SNOWFLAKE, x, y, z, 0, d0, d1, d2, 0.5);
            }
    }
}


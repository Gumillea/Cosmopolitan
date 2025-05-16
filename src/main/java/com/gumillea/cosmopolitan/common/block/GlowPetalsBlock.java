package com.gumillea.cosmopolitan.common.block;

import com.gumillea.cosmopolitan.core.reg.CosmoEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class GlowPetalsBlock extends Block {

    public GlowPetalsBlock(Properties p_49795_) {
        super(p_49795_);
    }

    public VoxelShape getShape(BlockState p_273399_, BlockGetter p_273568_, BlockPos p_273314_, CollisionContext p_273274_) {
        return Block.box(0.0F, 0.0F, 0.0F, 16.0F, 3.0F, 16.0F);
    }

    @Override
    public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        super.stepOn(level, pos, state, entity);
        if (entity instanceof LivingEntity living && living.hasEffect(CosmoEffects.MARKED.get())) return;

        Vec3 movement = entity.getDeltaMovement();
        Vec3 boosted = new Vec3(movement.x * 1.25, movement.y, movement.z * 1.25);
        entity.setDeltaMovement(boosted);
    }

    @Override
    public void onPlace(BlockState state, Level level, BlockPos pos, BlockState state1, boolean b) {
        if (!level.isClientSide) {
            level.scheduleTick(pos, this, 300);
        }
    }

    @Override
    public void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        level.removeBlock(pos, true);
    }


    @Override
    public int getLightEmission(BlockState state, BlockGetter level, BlockPos pos) {
        return 10;
    }
}

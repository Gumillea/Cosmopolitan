package com.gumillea.cosmopolitan.common.block;

import com.gumillea.cosmopolitan.core.util.CosmoCompat;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.fml.ModList;
import org.jetbrains.annotations.NotNull;
import quek.undergarden.registry.UGParticleTypes;

public class LifelightBlock extends Block {
    public static final IntegerProperty AGE = IntegerProperty.create("age", 0, 4);

    public LifelightBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(AGE, 0));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource randomSource) {
        int age = state.getValue(AGE);
        if (age < 4) {
            if (randomSource.nextInt(5) == 0) {
                BlockState next = state.setValue(AGE, age + 1);
                level.setBlock(pos, next, 2);
                level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(next));
            }
        } else {
            level.destroyBlock(pos, true);
        }
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        SimpleParticleType p = CosmoCompat.ug ? UGParticleTypes.SHIMMER.get() : ParticleTypes.SOUL_FIRE_FLAME;
        double x = (double)pos.getX() + (double)random.nextFloat();
        double y = (double)pos.getY() + 0.2 + (double)random.nextFloat();
        double z = (double)pos.getZ() + (double)random.nextFloat();
        double xSpeed = (double)random.nextFloat() * -0.9 * (double)random.nextFloat();
        double zSpeed = (double)random.nextFloat() * -0.9 * (double)random.nextFloat();
        level.addParticle(p, x, y, z, xSpeed, 0.0F, zSpeed);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext p_55659_) {
        return this.defaultBlockState().setValue(AGE, 0);
    }

    @Override
    public int getLightEmission(BlockState state, BlockGetter level, BlockPos pos) {
        return 15 - state.getValue(AGE) * 3;
    }
}

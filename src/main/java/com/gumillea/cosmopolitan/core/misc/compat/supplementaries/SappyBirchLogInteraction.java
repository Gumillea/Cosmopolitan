package com.gumillea.cosmopolitan.core.misc.compat.supplementaries;

import com.gumillea.cosmopolitan.core.reg.CosmoBlocks;
import net.mehvahdjukaar.supplementaries.common.block.faucet.FaucetSource;
import net.mehvahdjukaar.supplementaries.common.block.faucet.FluidOffer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class SappyBirchLogInteraction implements FaucetSource.BlState {

    @Override
    public FluidOffer getProvidedFluid(Level level, BlockPos pos, Direction dir, BlockState state) {
        Block backBlock = state.getBlock();

        if (backBlock == CosmoBlocks.SAPPY_BIRCH_LOG.get()) {
            return FluidOffer.of(CosmoSoftFluids.BIRCH_SAP.getHolder());
        }
        return null;
    }

    @Override
    public void drain(Level level, BlockPos pos, Direction dir, BlockState state, int amount) {
        level.setBlock(pos, Blocks.STRIPPED_BIRCH_LOG.withPropertiesOf(state), 3);
    }
}
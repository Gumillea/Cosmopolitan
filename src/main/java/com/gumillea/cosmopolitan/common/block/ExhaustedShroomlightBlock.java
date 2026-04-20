package com.gumillea.cosmopolitan.common.block;

import com.gumillea.cosmopolitan.core.reg.CosmoBlocks;
import com.gumillea.cosmopolitan.core.util.CosmoUtils;
import net.jadenxgamer.netherexp.registry.block.JNEBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.fml.ModList;

public class ExhaustedShroomlightBlock extends Block {
    private final Block shroomlight;
    private static String MODID = "netherexp";
    public static Block SHROOMNIGHT = ModList.get().isLoaded(MODID) ? CosmoUtils.modBlock(MODID, "shroomnight") : CosmoBlocks.PLACEHOLDER.get();
    public static Block SHROOMBLIGHT = ModList.get().isLoaded(MODID) ? CosmoUtils.modBlock(MODID, "shroomblight") : CosmoBlocks.PLACEHOLDER.get();

    public ExhaustedShroomlightBlock(Properties properties, Block shroomlight) {
        super(properties);
        this.shroomlight = shroomlight;
    }

    @Override
    public void onPlace(BlockState state, Level level, BlockPos pos, BlockState state1, boolean b) {
        if (!level.isClientSide) {
            level.scheduleTick(pos, this, 3600 + level.getRandom().nextInt(3600));
        }
    }

    @Override
    public void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        level.setBlock(pos, shroomlight.defaultBlockState(), 3);
    }


    @Override
    public int getLightEmission(BlockState state, BlockGetter level, BlockPos pos) {
        return 0;
    }
}



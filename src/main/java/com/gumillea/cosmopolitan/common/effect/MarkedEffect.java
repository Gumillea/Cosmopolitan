package com.gumillea.cosmopolitan.common.effect;

import com.gumillea.cosmopolitan.CosmoConfig;
import com.gumillea.cosmopolitan.core.reg.CosmoEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

public class MarkedEffect extends MobEffect {

    public MarkedEffect() {
        super(MobEffectCategory.HARMFUL, 0xE98F3F);
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        if (!(entity.level() instanceof ServerLevel level)) return;
        BlockPos pos = entity.blockPosition();
        BlockState state = level.getBlockState(pos);
        if (state.isAir() || state.canBeReplaced()) {
            BlockState glowingBlock = Blocks.SNOW.defaultBlockState();
            level.setBlockAndUpdate(pos, glowingBlock);
        }

    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }
}

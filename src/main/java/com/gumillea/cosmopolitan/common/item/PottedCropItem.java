package com.gumillea.cosmopolitan.common.item;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraftforge.registries.RegistryObject;

public class PottedCropItem extends EffectItem {
    private final RegistryObject<Block> crop;

    public PottedCropItem(Properties properties, RegistryObject<Block> block) {
        super(properties);
        this.crop = block;
    }

    public void plantCrop(Level level, BlockPos pos, Player player, ItemStack seed) {
        level.setBlock(pos, crop.get().defaultBlockState(), 3);
        level.playSound(null, pos, SoundEvents.SWEET_BERRY_BUSH_PLACE, SoundSource.BLOCKS, 1.0F, 1.0F);
        level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(player, crop.get().defaultBlockState()));

        if (!player.isCreative()) {
            seed.shrink(1);
        }
    }

}
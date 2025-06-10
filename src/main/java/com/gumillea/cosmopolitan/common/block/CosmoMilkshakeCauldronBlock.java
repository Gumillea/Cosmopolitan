package com.gumillea.cosmopolitan.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.cauldron.CauldronInteraction;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LayeredCauldronBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Map;
import java.util.function.Predicate;

public class CosmoMilkshakeCauldronBlock extends LayeredCauldronBlock {
    public static final Predicate<Biome.Precipitation> FALSE = (precipitation) -> false;

    public CosmoMilkshakeCauldronBlock(Map<Item, CauldronInteraction> map) {
        super(BlockBehaviour.Properties.copy(Blocks.CAULDRON), FALSE, map);
    }

    public ItemStack getCloneItemStack(BlockGetter worldIn, BlockPos pos, BlockState state) {
        return new ItemStack(Items.CAULDRON);
    }
}

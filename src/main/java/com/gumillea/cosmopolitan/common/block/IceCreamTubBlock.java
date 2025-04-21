package com.gumillea.cosmopolitan.common.block;

import com.gumillea.cosmopolitan.core.reg.CosmoBlocks;
import com.gumillea.cosmopolitan.core.reg.CosmoItems;
import com.gumillea.cosmopolitan.core.util.CosmoCompat;
import com.teamabnormals.neapolitan.core.registry.NeapolitanItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.fml.ModList;

import java.util.HashMap;
import java.util.Map;

public class IceCreamTubBlock extends Block {
    public static final IntegerProperty LEVEL = IntegerProperty.create("level", 0, 6);

    public IceCreamTubBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(LEVEL, 0));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(LEVEL);
    }

    @Override
    public ItemStack getCloneItemStack(BlockGetter p_57256_, BlockPos p_57257_, BlockState p_57258_) {
        return new ItemStack(CosmoBlocks.ICE_CREAM_TUB.get());
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player,
                                 InteractionHand hand, BlockHitResult hit) {

        if (!ModList.get().isLoaded(CosmoCompat.NEA)) return InteractionResult.PASS;

        ItemStack heldItem = player.getItemInHand(hand);
        int currentLevel = state.getValue(LEVEL);

        for (IceCreamData.IceCreamFlavor flavor : IceCreamData.FLAVORS) {
            if (heldItem.is(flavor.bowl) && state.getValue(LEVEL) < 6) {
                if (this == CosmoBlocks.ICE_CREAM_TUB.get()) {
                    IceCreamApply(level, pos);
                    level.setBlock(pos, flavor.block.defaultBlockState().setValue(LEVEL, 3), 3);
                    if (!player.getAbilities().instabuild) heldItem.shrink(1);
                    return InteractionResult.SUCCESS;
                } else if (this == flavor.block && state.getValue(LEVEL) < 6) {
                    int newLevel = Math.min(6, currentLevel + 3);
                    IceCreamApply(level, pos);
                    level.setBlock(pos, state.setValue(LEVEL, newLevel), 3);
                    if (!player.getAbilities().instabuild) heldItem.shrink(1);
                    return InteractionResult.SUCCESS;
                }
            }

            if (heldItem.is(Items.BOWL)) {
                if (this == flavor.block && currentLevel >= 3) {
                    if (!player.getAbilities().instabuild) heldItem.shrink(1);
                    level.playSound(null, pos, SoundEvents.SNOW_BREAK, SoundSource.BLOCKS, 0.8F, 0.8F);
                    player.addItem(new ItemStack(flavor.bowl));

                    int newLevel = currentLevel - 3;
                    if (newLevel == 0) {
                        level.setBlock(pos, CosmoBlocks.ICE_CREAM_TUB.get().defaultBlockState(), 3);
                    } else {
                        level.setBlock(pos, state.setValue(LEVEL, newLevel), 3);
                    }
                    return InteractionResult.SUCCESS;
                }
            }

            if (heldItem.is(CosmoItems.WAFER_CONE.get())) {
                if (this == flavor.block && currentLevel >= 1) {
                    level.playSound(null, pos, SoundEvents.SNOW_BREAK, SoundSource.BLOCKS, 0.8F, 0.8F);
                    player.addItem(new ItemStack(flavor.cone));
                    int newLevel = currentLevel - 1;
                    if (newLevel == 0) {
                        level.setBlock(pos, CosmoBlocks.ICE_CREAM_TUB.get().defaultBlockState(), 3);
                    } else {
                        level.setBlock(pos, state.setValue(LEVEL, newLevel), 3);
                    }
                    return InteractionResult.SUCCESS;
                }
            }
        }

        return InteractionResult.PASS;
    }

    public static void IceCreamApply (Level level, BlockPos pos) {
        RandomSource rand = level.getRandom();
        level.playSound(null, pos, SoundEvents.SNOW_PLACE, SoundSource.BLOCKS, 0.8F, 0.8F);

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

    public static class IceCreamData {
        public static final Map<Item, Block> ICE_CREAM_TO_TUB = new HashMap<>();
        public static final Map<Block, Item> TUB_TO_ICE_CREAM = new HashMap<>();
        public static final Map<Block, Item> TUB_TO_CONE = new HashMap<>();
        public static final IceCreamFlavor[] FLAVORS;

        static {
            registerFlavor(
                    NeapolitanItems.CHOCOLATE_ICE_CREAM.get(),
                    CosmoBlocks.CHOCOLATE_ICE_CREAM_TUB.get(),
                    NeapolitanItems.CHOCOLATE_ICE_CREAM.get(),
                    CosmoItems.CHOCOLATE_ICE_CREAM_CONE.get()
            );

            registerFlavor(
                    NeapolitanItems.STRAWBERRY_ICE_CREAM.get(),
                    CosmoBlocks.STRAWBERRY_ICE_CREAM_TUB.get(),
                    NeapolitanItems.STRAWBERRY_ICE_CREAM.get(),
                    CosmoItems.STRAWBERRY_ICE_CREAM_CONE.get()
            );

            FLAVORS = new IceCreamFlavor[] {
                    new IceCreamFlavor(NeapolitanItems.CHOCOLATE_ICE_CREAM.get(), CosmoBlocks.CHOCOLATE_ICE_CREAM_TUB.get(), NeapolitanItems.CHOCOLATE_ICE_CREAM.get(), CosmoItems.CHOCOLATE_ICE_CREAM_CONE.get()),
                    new IceCreamFlavor(NeapolitanItems.STRAWBERRY_ICE_CREAM.get(), CosmoBlocks.STRAWBERRY_ICE_CREAM_TUB.get(), NeapolitanItems.STRAWBERRY_ICE_CREAM.get(), CosmoItems.STRAWBERRY_ICE_CREAM_CONE.get())
            };
        }

        private static void registerFlavor(Item iceCream, Block tub, Item bowl, Item cone) {
            ICE_CREAM_TO_TUB.put(iceCream, tub);
            TUB_TO_ICE_CREAM.put(tub, bowl);
            TUB_TO_CONE.put(tub, cone);
        }

        public record IceCreamFlavor(Item iceCream, Block block, Item bowl, Item cone) {}
    }
}

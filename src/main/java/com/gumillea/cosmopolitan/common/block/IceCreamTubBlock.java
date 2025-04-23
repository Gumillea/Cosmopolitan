package com.gumillea.cosmopolitan.common.block;

import com.cosmicgelatin.seasonals.core.registry.SeasonalsItems;
import com.gumillea.cosmopolitan.core.reg.CosmoBlocks;
import com.gumillea.cosmopolitan.core.reg.CosmoItems;
import com.gumillea.cosmopolitan.core.util.CosmoCompat;
import com.gumillea.cosmopolitan.core.util.CosmoItemTags;
import com.teamabnormals.neapolitan.core.registry.NeapolitanItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
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
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.fml.ModList;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IceCreamTubBlock extends Block {
    public static final IntegerProperty LEVEL = IntegerProperty.create("level", 0, 6);
    private static final VoxelShape INSIDE = box(2.0F, 1.0F, 2.0F, 14.0F, 16.0F, 14.0F);
    protected static final VoxelShape SHAPE;

    static {
        SHAPE = Shapes.join(Shapes.block(), INSIDE, BooleanOp.ONLY_FIRST);
    }

    public IceCreamTubBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(LEVEL, 0));
    }

    public VoxelShape getShape(BlockState p_151964_, BlockGetter p_151965_, BlockPos p_151966_, CollisionContext p_151967_) {
        return SHAPE;
    }

    public VoxelShape getInteractionShape(BlockState p_151955_, BlockGetter p_151956_, BlockPos p_151957_) {
        return INSIDE;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(LEVEL);
    }

    @Override
    public ItemStack getCloneItemStack(BlockGetter p_57256_, BlockPos p_57257_, BlockState p_57258_) {
        return new ItemStack(CosmoBlocks.FROZEN_DESSERT_TUB.get());
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player,
                                 InteractionHand hand, BlockHitResult result) {

        if (!ModList.get().isLoaded(CosmoCompat.NEA)) return InteractionResult.PASS;

        ItemStack inHand = player.getItemInHand(hand);
        int iceCreamLevel = state.getValue(LEVEL);

        for (IceCreamData.IceCreamFlavor flavor : IceCreamData.FLAVORS) {
            if (inHand.is(flavor.iceCream()) && state.getValue(LEVEL) < 6) {
                if (this == CosmoBlocks.FROZEN_DESSERT_TUB.get()) {
                    iceCreamApply(level, pos);
                    level.setBlock(pos, flavor.tub().defaultBlockState().setValue(LEVEL, 3), 3);
                    if (!player.getAbilities().instabuild) inHand.shrink(1);
                    level.updateNeighborsAt(pos, this);
                    return InteractionResult.SUCCESS;
                } else if (this == flavor.tub() && state.getValue(LEVEL) < 6) {
                    int newLevel = Math.min(6, iceCreamLevel + 3);
                    iceCreamApply(level, pos);
                    level.setBlock(pos, state.setValue(LEVEL, newLevel), 3);
                    level.updateNeighborsAt(pos, this);

                    if (!player.getAbilities().instabuild) {
                        player.addItem(new ItemStack(Items.BOWL));
                        inHand.shrink(1);
                    }

                    return InteractionResult.SUCCESS;
                }
            }

            if (inHand.is(Items.BOWL)) {
                if (this == flavor.tub() && iceCreamLevel >= 3) {
                    if (!player.getAbilities().instabuild) inHand.shrink(1);
                    level.playSound(null, pos, SoundEvents.SNOW_BREAK, SoundSource.BLOCKS, 0.8F, 0.8F);
                    player.addItem(new ItemStack(flavor.iceCream()));

                    int newLevel = iceCreamLevel - 3;
                    if (newLevel == 0) {
                        level.setBlock(pos, CosmoBlocks.FROZEN_DESSERT_TUB.get().defaultBlockState(), 3);
                    } else {
                        level.setBlock(pos, state.setValue(LEVEL, newLevel), 3);
                    }
                    level.updateNeighborsAt(pos, this);

                    return InteractionResult.SUCCESS;
                }
            }

            if (inHand.is(CosmoItems.WAFER_CONE.get())) {
                if (this == flavor.tub() && iceCreamLevel >= 1) {
                    level.playSound(null, pos, SoundEvents.SNOW_BREAK, SoundSource.BLOCKS, 0.8F, 0.8F);
                    player.addItem(new ItemStack(flavor.cone()));
                    int newLevel = iceCreamLevel - 1;
                    if (newLevel == 0) {
                        level.setBlock(pos, CosmoBlocks.FROZEN_DESSERT_TUB.get().defaultBlockState(), 3);
                    } else {
                        level.setBlock(pos, state.setValue(LEVEL, newLevel), 3);
                    }
                    level.updateNeighborsAt(pos, this);

                    return InteractionResult.SUCCESS;
                }
            }

            if (inHand.is(CosmoItemTags.MILK_BOTTLE)) {
                if (this == flavor.tub() && iceCreamLevel >= 1 && flavor.milkshake() != null) {
                    level.playSound(null, pos, SoundEvents.BOTTLE_FILL, SoundSource.BLOCKS, 0.8F, 0.8F);
                    player.addItem(new ItemStack(flavor.milkshake()));
                    int newLevel = iceCreamLevel - 1;
                    if (newLevel == 0) {
                        level.setBlock(pos, CosmoBlocks.FROZEN_DESSERT_TUB.get().defaultBlockState(), 3);
                    } else {
                        level.setBlock(pos, state.setValue(LEVEL, newLevel), 3);
                    }
                    level.updateNeighborsAt(pos, this);

                    return InteractionResult.SUCCESS;
                }
            }
        }

        return InteractionResult.PASS;
    }

    public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        if (state.getValue(LEVEL) > 3) {
            entity.setIsInPowderSnow(true);
            if (!level.isClientSide) {
                entity.setSharedFlagOnFire(false);
            }
        }
    }

    @Override
    public boolean isSignalSource(BlockState state) {
        return true;
    }

    @Override
    public int getSignal(BlockState state, BlockGetter world, BlockPos pos, Direction direction) {
        return state.getValue(LEVEL) * 2;
    }

    @Override
    public boolean isPathfindable(BlockState state, BlockGetter world, BlockPos pos, PathComputationType type) {
        return false;
    }

    public static void iceCreamApply(Level level, BlockPos pos) {
        RandomSource rand = level.getRandom();
        level.playSound(null, pos, SoundEvents.SNOW_PLACE, SoundSource.BLOCKS, 0.8F, 0.8F);

        if (!level.isClientSide && level instanceof ServerLevel server)
            for (int i = 0; i < 6; ++i) {
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
        public static IceCreamFlavor[] FLAVORS;

        private static final List<IceCreamFlavor> FLAVOR_LIST = new ArrayList<>();

        static {
            if (ModList.get().isLoaded(CosmoCompat.NEA)) {
                FLAVOR_LIST.addAll(List.of(
                        new IceCreamFlavor(
                                NeapolitanItems.CHOCOLATE_ICE_CREAM.get(),
                                CosmoBlocks.CHOCOLATE_ICE_CREAM_TUB.get(),
                                CosmoItems.CHOCOLATE_ICE_CREAM_CONE.get(),
                                NeapolitanItems.CHOCOLATE_MILKSHAKE.get()
                        ),
                        new IceCreamFlavor(
                                NeapolitanItems.STRAWBERRY_ICE_CREAM.get(),
                                CosmoBlocks.STRAWBERRY_ICE_CREAM_TUB.get(),
                                CosmoItems.STRAWBERRY_ICE_CREAM_CONE.get(),
                                NeapolitanItems.STRAWBERRY_MILKSHAKE.get()
                        ),
                        new IceCreamFlavor(
                                NeapolitanItems.VANILLA_ICE_CREAM.get(),
                                CosmoBlocks.VANILLA_ICE_CREAM_TUB.get(),
                                CosmoItems.VANILLA_ICE_CREAM_CONE.get(),
                                NeapolitanItems.VANILLA_MILKSHAKE.get()
                        ),
                        new IceCreamFlavor(
                                NeapolitanItems.ADZUKI_ICE_CREAM.get(),
                                CosmoBlocks.ADZUKI_ICE_CREAM_TUB.get(),
                                CosmoItems.ADZUKI_ICE_CREAM_CONE.get(),
                                NeapolitanItems.ADZUKI_MILKSHAKE.get()
                        ),
                        new IceCreamFlavor(
                                NeapolitanItems.BANANA_ICE_CREAM.get(),
                                CosmoBlocks.BANANA_ICE_CREAM_TUB.get(),
                                CosmoItems.BANANA_ICE_CREAM_CONE.get(),
                                NeapolitanItems.BANANA_MILKSHAKE.get()
                        ),
                        new IceCreamFlavor(
                                NeapolitanItems.MINT_ICE_CREAM.get(),
                                CosmoBlocks.MINT_ICE_CREAM_TUB.get(),
                                CosmoItems.MINT_ICE_CREAM_CONE.get(),
                                NeapolitanItems.MINT_MILKSHAKE.get()
                        ),
                        new IceCreamFlavor(
                                CosmoItems.APPLE_ICE_CREAM.get(),
                                CosmoBlocks.APPLE_ICE_CREAM_TUB.get(),
                                CosmoItems.APPLE_ICE_CREAM_CONE.get(),
                                null
                        ),
                        new IceCreamFlavor(
                                CosmoItems.GLOW_BERRY_ICE_CREAM.get(),
                                CosmoBlocks.GLOW_BERRY_ICE_CREAM_TUB.get(),
                                CosmoItems.GLOW_BERRY_ICE_CREAM_CONE.get(),
                                null
                        ),
                        new IceCreamFlavor(
                                CosmoItems.CARROT_ICE_CREAM.get(),
                                CosmoBlocks.CARROT_ICE_CREAM_TUB.get(),
                                CosmoItems.CARROT_ICE_CREAM_CONE.get(),
                                null
                        )
                ));
                if (ModList.get().isLoaded(CosmoCompat.QUA)) {
                    FLAVOR_LIST.add(new IceCreamFlavor(
                            CosmoItems.ENCHANTED_FRUIT_ICE_CREAM.get(),
                            CosmoBlocks.ENCHANTED_FRUIT_ICE_CREAM_TUB.get(),
                            CosmoItems.ENCHANTED_FRUIT_ICE_CREAM_CONE.get(),
                            null
                    ));
                }
                if (ModList.get().isLoaded(CosmoCompat.AN)) {
                    FLAVOR_LIST.add(new IceCreamFlavor(
                            CosmoItems.SOURCE_BERRY_ICE_CREAM.get(),
                            CosmoBlocks.SOURCE_BERRY_ICE_CREAM_TUB.get(),
                            CosmoItems.SOURCE_BERRY_ICE_CREAM_CONE.get(),
                            null
                    ));
                }
                if (ModList.get().isLoaded(CosmoCompat.HA)) {
                    FLAVOR_LIST.add(new IceCreamFlavor(
                            CosmoItems.KABLOOM_ICE_CREAM.get(),
                            CosmoBlocks.KABLOOM_ICE_CREAM_TUB.get(),
                            CosmoItems.KABLOOM_ICE_CREAM_CONE.get(),
                            null
                    ));
                }
                if (ModList.get().isLoaded(CosmoCompat.SEA)) {
                }
                if (ModList.get().isLoaded(CosmoCompat.PEC)) {
                }
            }

            for (IceCreamFlavor flavor : FLAVOR_LIST) {
                ICE_CREAM_TO_TUB.put(flavor.iceCream(), flavor.tub());
                TUB_TO_ICE_CREAM.put(flavor.tub(), flavor.iceCream());
                TUB_TO_CONE.put(flavor.tub(), flavor.cone());
            }
            FLAVORS = FLAVOR_LIST.toArray(new IceCreamFlavor[0]);
        }

        public record IceCreamFlavor(Item iceCream, Block tub, Item cone, @Nullable Item milkshake) {}
    }
}

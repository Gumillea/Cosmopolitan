package com.gumillea.cosmopolitan.common.block;

import com.gumillea.cosmopolitan.core.reg.CosmoBlocks;
import com.gumillea.cosmopolitan.core.reg.CosmoItems;
import com.gumillea.cosmopolitan.core.util.CosmoItemTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
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
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PottedCropBlock extends BushBlock implements BonemealableBlock {
    protected static final VoxelShape SHAPE = Block.box(5.0F, 0.0F, 5.0F, 11.0F, 6.0F, (double)11.0F);
    public static final int MAX_AGE = 1;
    public static final BooleanProperty PRUNED = BooleanProperty.create("pruned");
    public static final IntegerProperty AGE = IntegerProperty.create("age", 0, 1);
    private static final Logger log = LoggerFactory.getLogger(PottedCropBlock.class);
    private final RegistryObject<Item> crop;

    public PottedCropBlock(Properties properties, RegistryObject<Item> crop) {
        super(properties);
        this.crop = crop;
        this.registerDefaultState(this.stateDefinition.any().setValue(AGE, 0).setValue(PRUNED, false));
    }

    public VoxelShape getShape(BlockState p_53556_, BlockGetter p_53557_, BlockPos p_53558_, CollisionContext p_53559_) {
        return SHAPE;
    }

    public RenderShape getRenderShape(BlockState p_53554_) {
        return RenderShape.MODEL;
    }

    public ItemStack getCropItem() {
        return new ItemStack(crop.get());
    }

    public ItemStack getCloneItemStack(BlockGetter getter, BlockPos pos, BlockState state) {
        ItemStack stack = this.getCropItem();
        if (stack.is(CosmoItems.WILDBERRY.get())) stack.getOrCreateTag().putBoolean("icon", true);

        return stack;
    }

    private boolean isMaxAge(BlockState state) {
        return state.getValue(AGE) == MAX_AGE;
    }

    public boolean isRandomlyTicking(BlockState state) {
        return !isMaxAge(state);
    }

    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource source) {
        int i = state.getValue(AGE);
        if (!state.getValue(PRUNED) && !isMaxAge(state) && level.getRawBrightness(pos.above(), 0) >= 9 && ForgeHooks.onCropsGrowPre(level, pos, state, source.nextInt(5) == 0)) {
            BlockState blockstate = state.setValue(AGE, i + 1);
            level.setBlock(pos, blockstate, 2);
            level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(blockstate));
            ForgeHooks.onCropsGrowPost(level, pos, state);
        }
    }

    public void pruneCrop(BlockState state, Level level, BlockPos pos, Player player) {
        boolean pruned = state.getValue(PRUNED);
        RandomSource rand = level.getRandom();

        if (level instanceof ServerLevel serverLevel) {
            for (int i = 0; i < 5; ++i) {
                double d0 = (rand.nextDouble() - 0.5) * 0.02;
                double d1 = 0.075D;
                double d2 = (rand.nextDouble() - 0.5) * 0.02;

                double x = pos.getX() + 0.3 + rand.nextDouble() * 0.4;
                double y = pos.getY() + 1;
                double z = pos.getZ() + 0.3 + rand.nextDouble() * 0.4;
                serverLevel.sendParticles(new BlockParticleOption(ParticleTypes.BLOCK, Blocks.AZALEA_LEAVES.defaultBlockState()), x, y, z, 0, d0, d1, d2, 0.5);
            }
        }

        level.playSound(null, pos, SoundEvents.SHEEP_SHEAR, SoundSource.BLOCKS, 0.8F, 0.8F);
        level.setBlock(pos, state.setValue(PRUNED, !pruned), 3);
        level.gameEvent(player, !pruned ? GameEvent.BLOCK_OPEN : GameEvent.BLOCK_CLOSE, pos);
    }


    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
        boolean flag = isMaxAge(state);
        boolean pruned = state.getValue(PRUNED);
        ItemStack inHand = player.getItemInHand(hand);

        if (!inHand.isEmpty() && inHand.is(Items.SHEARS)) {
            if (!level.isClientSide) {
                pruneCrop(state, level, pos, player);
            }
            return InteractionResult.sidedSuccess(level.isClientSide);
        }

        if (pruned) {
            return InteractionResult.PASS;
        }

        if (flag) {
            int amount = crop.get().getDefaultInstance().is(CosmoItemTags.BERRIES) ? 1 + level.random.nextInt(2) : 1;
            popResource(level, pos, new ItemStack(crop.get(), amount));
            level.playSound(null, pos, SoundEvents.CAVE_VINES_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 0.8F + level.random.nextFloat() * 0.4F);

            BlockState blockstate = state.setValue(AGE, 0);
            level.setBlock(pos, blockstate, 2);
            level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(player, blockstate));

            return InteractionResult.sidedSuccess(level.isClientSide);
        } else if (player.getItemInHand(hand).is(Items.BONE_MEAL)) {
            return InteractionResult.PASS;
        } else {
            ItemStack crop = new ItemStack(this.crop.get());

            if (!player.addItem(crop)) {
                player.drop(crop, false);
            }

            level.setBlock(pos, Blocks.FLOWER_POT.defaultBlockState(), 3);
            level.playSound(null, pos, SoundEvents.AZALEA_BREAK, SoundSource.BLOCKS, 0.8F, 0.8F);
            level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(player, Blocks.FLOWER_POT.defaultBlockState()));

            return InteractionResult.sidedSuccess(level.isClientSide);
        }

    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE);
        builder.add(PRUNED);
    }

    public boolean isValidBonemealTarget(LevelReader reader, BlockPos pos, BlockState state, boolean b) {
        return !state.getValue(PRUNED) && state.getValue(AGE) < MAX_AGE;
    }

    public boolean isBonemealSuccess(Level level, RandomSource source, BlockPos pos, BlockState state) {
        return true;
    }

    public void performBonemeal(ServerLevel level, RandomSource source, BlockPos pos, BlockState state) {
        level.setBlock(pos, state.setValue(AGE, state.getValue(AGE) + 1), 2);
    }

    @Override
    protected boolean mayPlaceOn(BlockState p_51042_, BlockGetter p_51043_, BlockPos p_51044_) {
        return true;
    }

    @Override
    public boolean canSurvive(BlockState p_51028_, LevelReader p_51029_, BlockPos p_51030_) {
        return true;
    }

}

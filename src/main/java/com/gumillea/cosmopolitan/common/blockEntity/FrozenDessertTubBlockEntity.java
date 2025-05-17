package com.gumillea.cosmopolitan.common.blockEntity;

import com.gumillea.cosmopolitan.common.block.FrozenDessertTubBlock;
import com.gumillea.cosmopolitan.core.reg.CosmoBlockEntityTypes;
import com.gumillea.cosmopolitan.core.reg.CosmoFluids;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fluids.capability.templates.FluidTank;

import javax.annotation.Nullable;

public class FrozenDessertTubBlockEntity extends BlockEntity {
    public static final int capacity = 3000;
    private int remainingTime = 0;
    private boolean isProcessing = false;


    private final FluidTank tank = new FluidTank(capacity) {
        @Override
        public int fill(FluidStack stack, FluidAction action) {
            BlockState state = level.getBlockState(worldPosition);
            if (!state.getValue(FrozenDessertTubBlock.OPEN)) return 0;
            return super.fill(stack, action);
        }
        @Override
        public FluidStack drain(FluidStack stack, FluidAction action) {
            BlockState state = level.getBlockState(worldPosition);
            if (!state.getValue(FrozenDessertTubBlock.OPEN)) return FluidStack.EMPTY;
            return super.drain(stack, action);
        }
        @Override
        protected void onContentsChanged() {
            setChanged();
            if (level != null && !level.isClientSide) {
                level.sendBlockUpdated(worldPosition, getBlockState(), getBlockState(), Block.UPDATE_ALL);
            }
        }
    };

    public FrozenDessertTubBlockEntity(BlockPos pos, BlockState state) {
        super(CosmoBlockEntityTypes.FROZEN_DESSERT_TUB.get(), pos, state);
    }

    public FluidTank getTank() {
        return tank;
    }

    public IFluidHandler getFluidHandler() {
        return tank;
    }

    public static <T extends BlockEntity> void tick(Level level, BlockPos pos, BlockState state, T blockEntity) {
        BooleanProperty OPEN = FrozenDessertTubBlock.OPEN;
        boolean isOpen = state.getValue(OPEN);
        if (blockEntity instanceof FrozenDessertTubBlockEntity tub) {
            if (tub.isProcessing) {
                if (isOpen) {
                    tub.isProcessing = false;
                    tub.remainingTime = 0;
                } else if (--tub.remainingTime <= 0) {
                    completeProcessing(level, pos, tub);
                }
                level.sendBlockUpdated(pos, state, state, 3);
            } else if (!isOpen && isValidFluid(tub)) {
                startProcessing(tub);
            }
        }
    }

    private static boolean isValidFluid(FrozenDessertTubBlockEntity tub) {
        FluidStack stack = tub.getTank().getFluid();
        return !stack.isEmpty() && stack.getFluid().isSame(CosmoFluids.CONDENSED_MILK.get());
    }

    private static void startProcessing(FrozenDessertTubBlockEntity tub) {
        tub.isProcessing = true;
        tub.remainingTime = 6000;
    }

    private static void completeProcessing(Level level, BlockPos pos, FrozenDessertTubBlockEntity tub) {
        FluidStack stack = tub.getTank().getFluid();
        if (stack.getFluid() != CosmoFluids.CONDENSED_MILK.get()) return;

        tub.getTank().setFluid(new FluidStack(CosmoFluids.CREAM.get(), stack.getAmount()));
        tub.isProcessing = false;
        level.playSound(null, pos, SoundEvents.BREWING_STAND_BREW, SoundSource.BLOCKS, 1.0F, 1.0F);
        FrozenDessertTubBlock.contentApply(level, pos);
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        tank.readFromNBT(tag.getCompound("Tank"));
        this.remainingTime = tag.getInt("RemainingTime");
        this.isProcessing = tag.getBoolean("IsProcessing");
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.put("Tank", tank.writeToNBT(new CompoundTag()));
        tag.putInt("RemainingTime", this.remainingTime);
        tag.putBoolean("IsProcessing", this.isProcessing);
    }

    private final LazyOptional<IFluidHandler> holder = LazyOptional.of(() -> tank);

    @Override
    public <T> LazyOptional<T> getCapability(Capability<T> cap, @Nullable Direction side) {
        if (cap == ForgeCapabilities.FLUID_HANDLER) {
            return holder.cast();
        }
        return super.getCapability(cap, side);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        holder.invalidate();
    }

    @Override
    public CompoundTag getUpdateTag() {
        CompoundTag tag = super.getUpdateTag();
        tag.put("Tank", tank.writeToNBT(new CompoundTag()));
        return tag;
    }

    @Override
    public void handleUpdateTag(CompoundTag tag) {
        super.handleUpdateTag(tag);
        if (tag.contains("Tank")) {
            tank.readFromNBT(tag.getCompound("Tank"));
        }
    }

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public void onDataPacket(Connection net, ClientboundBlockEntityDataPacket pkt) {
        handleUpdateTag(pkt.getTag());
    }
}
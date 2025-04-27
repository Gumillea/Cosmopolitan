package com.gumillea.cosmopolitan.common.blockEntity;

import com.gumillea.cosmopolitan.common.block.FrozenDessertTubBlock;
import com.gumillea.cosmopolitan.core.reg.CosmoBlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fluids.capability.templates.FluidTank;

import javax.annotation.Nullable;

public class FrozenDessertTubBlockEntity extends BlockEntity {
    public static final int CAPACITY = 3000;

    private final FluidTank tank = new FluidTank(CAPACITY) {
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

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        tank.readFromNBT(tag.getCompound("Tank"));
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.put("Tank", tank.writeToNBT(new CompoundTag()));
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
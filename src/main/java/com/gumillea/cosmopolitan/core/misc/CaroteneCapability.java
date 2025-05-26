package com.gumillea.cosmopolitan.core.misc;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.Mth;
import net.minecraftforge.common.capabilities.*;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class CaroteneCapability implements ICapabilityProvider, INBTSerializable<CompoundTag> {
    private int value = 0;

    public static final int MAX = 1000;
    public static final int THRESHOLD = 800;
    public static final int REMOVE_THRESHOLD = 500;
    public static final int DECAY_RATE = 10;
    public static final int TICK_INTERVAL = 400;

    private final LazyOptional<CaroteneCapability> holder = LazyOptional.of(() -> this);

    public int get() {
        return value;
    }

    public void set(int v) {
        value = Mth.clamp(v, 0, MAX);
    }

    public void add(int delta) {
        set(value + delta);
    }

    public static Capability<CaroteneCapability> CAP = CapabilityManager.get(new CapabilityToken<>(){});

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        return CAP.orEmpty(cap, holder);
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = new CompoundTag();
        nbt.putInt("carotene", value);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        value = Mth.clamp(nbt.getInt("carotene"), 0, MAX);
    }

}


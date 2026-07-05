package com.gumillea.cosmopolitan.core.misc;

import com.gumillea.cosmopolitan.core.reg.client.BerrfectPacketHandler;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public record BerrfectPacket(int entity, CompoundTag tag) {

    public static void encode(BerrfectPacket packet, FriendlyByteBuf byteBuf) {
        byteBuf.writeInt(packet.entity);
        byteBuf.writeNbt(packet.tag);
    }

    public static BerrfectPacket decode(FriendlyByteBuf byteBuf) {
        return new BerrfectPacket(byteBuf.readInt(), byteBuf.readNbt());
    }

    public static void handle(BerrfectPacket packet, Supplier<NetworkEvent.Context> context) {
        context.get().enqueueWork(() -> DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> BerrfectPacketHandler.handle(packet)));
        context.get().setPacketHandled(true);
    }
}
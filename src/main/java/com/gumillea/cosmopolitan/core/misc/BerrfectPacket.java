package com.gumillea.cosmopolitan.core.misc;

import net.minecraft.client.Minecraft;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
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
        context.get().enqueueWork(() -> {
            Level level = Minecraft.getInstance().level;
            if (level != null && level.getEntity(packet.entity) instanceof LivingEntity living) {
                living.getPersistentData().put("Berrfect", packet.tag);
            }
        });
        context.get().setPacketHandled(true);
    }
}
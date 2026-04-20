package com.gumillea.cosmopolitan.core.misc;

import com.gumillea.cosmopolitan.Cosmopolitan;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;

public class CosmoPacketHandler {
    private static final String PROTOCOL_VERSION = "1";
    public static final SimpleChannel INSTANCE = NetworkRegistry.newSimpleChannel(new ResourceLocation(Cosmopolitan.MODID, "main"), () -> PROTOCOL_VERSION, PROTOCOL_VERSION::equals, PROTOCOL_VERSION::equals);

    private static int nextId = 0;

    public static void register() {
        INSTANCE.registerMessage(nextId++, BerrfectPacket.class, BerrfectPacket::encode, BerrfectPacket::decode, BerrfectPacket::handle);
    }

    public static void sendPacket(LivingEntity entity, CompoundTag tag) {
        INSTANCE.send(PacketDistributor.TRACKING_ENTITY_AND_SELF.with(() -> entity), new BerrfectPacket(entity.getId(), tag));
    }
}
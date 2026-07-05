package com.gumillea.cosmopolitan.core.reg.client;

import com.gumillea.cosmopolitan.core.misc.BerrfectPacket;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class BerrfectPacketHandler {
    public static void handle(BerrfectPacket packet) {
        Level level = Minecraft.getInstance().level;
        if (level != null && level.getEntity(packet.entity()) instanceof LivingEntity living) {
            living.getPersistentData().put("Berrfect", packet.tag());
        }
    }
}
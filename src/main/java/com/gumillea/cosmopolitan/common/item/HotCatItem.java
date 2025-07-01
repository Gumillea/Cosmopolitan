package com.gumillea.cosmopolitan.common.item;

import com.gumillea.cosmopolitan.core.util.CosmoCompat;
import com.teamabnormals.environmental.core.registry.EnvironmentalItems;
import com.teamabnormals.environmental.core.registry.EnvironmentalParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class HotCatItem extends Item {

    public HotCatItem(Properties properties) {
        super(properties);
    }

    public ItemStack finishUsingItem(ItemStack itemStack, Level level, LivingEntity living) {
        super.finishUsingItem(itemStack, level, living);

        if (CosmoCompat.en) {
            if (!level.isClientSide && living instanceof Player player) {
                RandomSource random = level.getRandom();
                int cats = random.nextInt(3) + 1;

                for (int i = 0; i < cats; i++) {
                    double offset = (random.nextDouble() - 0.5D) * 0.8D;
                    double movement = 0.15D + random.nextDouble() * 0.1D;

                    double x = player.getX() + offset;
                    double y = player.getY() + player.getEyeHeight() -0.2D;
                    double z = player.getZ() + offset;
                    double d = (random.nextDouble() - 0.5D) * movement;

                    ItemStack fluff = new ItemStack(EnvironmentalItems.CATTAIL_FLUFF.get());
                    ItemEntity fluffEntity = new ItemEntity(level, x, y, z, fluff);

                    fluffEntity.setDeltaMovement(d, movement, d);
                    fluffEntity.setPickUpDelay(20);

                    level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.WOOL_HIT, SoundSource.PLAYERS, 2.0F, 2.0F);
                    level.addFreshEntity(fluffEntity);

                    if (level instanceof ServerLevel server) {
                        server.sendParticles(EnvironmentalParticleTypes.CATTAIL_FLUFF.get(), x, y, z, 0, d, movement, d, 0.5);
                    }
                }
            }

        }
        return itemStack;
    }

}

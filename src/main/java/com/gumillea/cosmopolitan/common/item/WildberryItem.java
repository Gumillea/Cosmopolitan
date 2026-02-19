package com.gumillea.cosmopolitan.common.item;

import com.gumillea.cosmopolitan.core.misc.CosmoCriteriaTriggers;
import com.gumillea.cosmopolitan.core.util.CosmoUtils;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.function.Consumer;

public class WildberryItem extends PottedCropItem{

    public WildberryItem(Properties properties, RegistryObject<Block> block) {
        super(properties, block);
    }

    public static List<Consumer<LivingEntity>> BERRY_MAGIC = List.of(
            living -> CosmoUtils.dropLoot(living, "gameplay/wildberry"),
            living -> CosmoUtils.applyHealing(1.0F, living),
            living -> CosmoUtils.giveExperience(1, living),
            living -> living.setSecondsOnFire(1),
            living -> living.setTicksFrozen(living.getTicksFrozen() + 30),
            living -> CosmoUtils.effect(living, MobEffects.DARKNESS, 40, 0),
            living -> CosmoUtils.effect(living, MobEffects.NIGHT_VISION, 40, 0),
            living -> CosmoUtils.effect(living, MobEffects.POISON, 40, 0)
    );

    public ItemStack finishUsingItem(ItemStack itemStack, Level level, LivingEntity living) {
        if (!level.isClientSide && CosmoUtils.random(level, 1F)) {
            Consumer<LivingEntity> effect = BERRY_MAGIC.get(level.random.nextInt(BERRY_MAGIC.size()));
            effect.accept(living);

            if (living instanceof ServerPlayer serverPlayer) CosmoCriteriaTriggers.WILDBERRY.trigger(serverPlayer);
        }
        return super.finishUsingItem(itemStack, level, living);
    }
}

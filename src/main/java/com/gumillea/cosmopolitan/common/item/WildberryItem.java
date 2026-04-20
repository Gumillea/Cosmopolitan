package com.gumillea.cosmopolitan.common.item;

import com.gumillea.cosmopolitan.CosmoConfig;
import com.gumillea.cosmopolitan.core.misc.CosmoCriteriaTriggers;
import com.gumillea.cosmopolitan.core.reg.CosmoItems;
import com.gumillea.cosmopolitan.core.util.CosmoUtils;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
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
        applyBerryEffect(level, living, 1);

        if (this == CosmoItems.WILDBERRY_MEDLEY.get()) {
            ItemStack bowl = new ItemStack(Items.BOWL);
            if (itemStack.isEmpty()) {
                return bowl;
            } else {
                if (living instanceof Player player && !player.getAbilities().instabuild) {
                    if (!player.getInventory().add(bowl)) {
                        player.drop(bowl, false);
                    }
                }
                return itemStack;
            }
        }

        return super.finishUsingItem(itemStack, level, living);
    }

    public static void applyBerryEffect(Level level, LivingEntity living, int i) {
        if (!level.isClientSide) {
            double chance = CosmoConfig.Common.WILDBERRY_CHANCE.get() * i;

            if (level.random.nextDouble() < chance) {
                BERRY_MAGIC.get(level.random.nextInt(BERRY_MAGIC.size())).accept(living);
                if (living instanceof ServerPlayer serverPlayer) CosmoCriteriaTriggers.WILDBERRY.trigger(serverPlayer);
            }
        }
    }

}

package com.gumillea.cosmopolitan.common.item;

import com.gumillea.cosmopolitan.CosmoConfig;
import com.gumillea.cosmopolitan.core.reg.CosmoItems;
import com.gumillea.cosmopolitan.core.util.CosmoCompat;
import com.teamabnormals.neapolitan.common.item.HealingItem;
import com.teamabnormals.neapolitan.core.other.NeapolitanBiomeModifiers;
import com.teamabnormals.neapolitan.core.other.tags.NeapolitanBiomeTags;
import com.teamabnormals.neapolitan.core.registry.NeapolitanBiomes;
import net.minecraft.core.Holder;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.RegistryObject;
import org.violetmoon.quark.content.world.module.GlimmeringWealdModule;

public class GulimeItem extends Item {

    private final boolean large;
    private final RegistryObject<Item> result;

    public GulimeItem(Properties properties, boolean large, RegistryObject<Item> result) {
        super(properties.stacksTo(large ? 16: 64));
        this.large = large;
        this.result = result;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity living) {
        ItemStack resultStack = super.finishUsingItem(stack, level, living);

        if (CosmoCompat.nea && (this == CosmoItems.STRAWBERRY_GULIME.get() || this == CosmoItems.STRAWBERRY_GULIME_SMALL.get())) {
            HealingItem.applyHealing(2, level, living);
        }

        if (!level.isClientSide && this.large && living instanceof Player player) {
            ItemStack smallGulime = new ItemStack(result.get(), 4);

            if (!player.getInventory().add(smallGulime)) {
                player.drop(smallGulime, false);
            }
        }

        return resultStack;
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slot, boolean selected) {
        if (level.isClientSide || !(entity instanceof Player player)) return;
        if (this.large) return;

        long time = level.getGameTime();
        if (time % CosmoConfig.Common.GULIME_TICK.get() != 0) return;

        int gulimes = 0;
        for (ItemStack invStack : player.getInventory().items) {
            if (invStack.is(this)) {
                gulimes += invStack.getCount();
            }
        }
        if (gulimes >= 4) {
            Item actualGumlime = this.result.get();
            int removed = 0;
            for (int i = 0; i < player.getInventory().items.size() && removed < 4; i++) {
                ItemStack invStack = player.getInventory().items.get(i);
                if (invStack.is(this)) {
                    int toRemove = Math.min(4 - removed, invStack.getCount());
                    invStack.shrink(toRemove);
                    removed += toRemove;
                }
            }

            if (this == CosmoItems.GULIME_SMALL.get()) {
                Holder<Biome> biome = level.getBiome(player.blockPosition());
                if (biome.is(Biomes.LUSH_CAVES)) {
                    actualGumlime = CosmoItems.UNDERGROUND_GULIME.get();
                }
                if (biome.is(BiomeTags.IS_HILL)) {
                    actualGumlime = CosmoItems.TAIGA_GULIME.get();
                }
                if (biome.is(Biomes.END_HIGHLANDS)) {
                    actualGumlime = CosmoItems.CHORUS_GULIME.get();
                }
                if (CosmoCompat.qua && biome.is(GlimmeringWealdModule.BIOME_KEY)) {
                    actualGumlime = CosmoItems.GLIMMERING_GULIME.get();
                }
                if (CosmoCompat.nea && biome.is(NeapolitanBiomes.STRAWBERRY_FIELDS)) {
                    actualGumlime = CosmoItems.STRAWBERRY_GULIME.get();
                }
            }

            ItemStack resultGulime = new ItemStack(actualGumlime);
            level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.SLIME_BLOCK_PLACE, SoundSource.PLAYERS, 1.0f, 1.0f);
            player.getInventory().add(resultGulime);
        }
    }

    public SoundEvent getDrinkingSound() {
        return SoundEvents.HONEY_BLOCK_HIT;
    }

    public SoundEvent getEatingSound() {
        return SoundEvents.HONEY_BLOCK_HIT;
    }

}

package com.gumillea.cosmopolitan.common.item;

import com.gumillea.cosmopolitan.CosmoConfig;
import com.gumillea.cosmopolitan.core.misc.CosmoCriteriaTriggers;
import com.gumillea.cosmopolitan.core.reg.CosmoItems;
import com.gumillea.cosmopolitan.core.util.CosmoCompat;
import com.teamabnormals.neapolitan.common.item.HealingItem;
import com.teamabnormals.neapolitan.core.registry.NeapolitanBiomes;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraftforge.registries.RegistryObject;
import org.violetmoon.quark.content.world.module.GlimmeringWealdModule;

import java.util.HashMap;
import java.util.Map;

public class GulimeItem extends GummyItem {

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
        if (level.getRandom().nextFloat() < CosmoConfig.Common.GULIME_CHANCE.get()) return;

        int gulimes = 0;
        for (ItemStack invStack : player.getInventory().items) {
            if (invStack.is(this)) {
                gulimes += invStack.getCount();
            }
        }
        if (gulimes < 4) return;

        Item resultGulime = this.result.get();

        Map<ResourceKey<Biome>, Item> BIOME_GULIME_MAP = new HashMap<>(Map.of(
                Biomes.LUSH_CAVES, CosmoItems.UNDERGROUND_GULIME.get(),
                Biomes.WARPED_FOREST, CosmoItems.WARPED_GULIME.get(),
                Biomes.END_HIGHLANDS, CosmoItems.CHORUS_GULIME.get()
        ));

        Map<TagKey<Biome>, Item> BIOME_TAG_GULIME_MAP = new HashMap<>(Map.of(
                BiomeTags.IS_BADLANDS, CosmoItems.ARID_GULIME.get(),
                BiomeTags.IS_TAIGA, CosmoItems.TAIGA_GULIME.get()
        ));

        if (CosmoCompat.qua) BIOME_GULIME_MAP.put(GlimmeringWealdModule.BIOME_KEY, CosmoItems.GLIMMERING_GULIME.get());
        if (CosmoCompat.nea) BIOME_GULIME_MAP.put(NeapolitanBiomes.STRAWBERRY_FIELDS, CosmoItems.STRAWBERRY_GULIME.get());

        if (this == CosmoItems.GULIME_SMALL.get()) {
            Holder<Biome> biome = level.getBiome(player.blockPosition());
            ResourceKey<Biome> biomeKey = biome.unwrapKey().orElse(null);

            if (biomeKey != null && BIOME_GULIME_MAP.containsKey(biomeKey)) {
                resultGulime = BIOME_GULIME_MAP.get(biomeKey);
            } else {
                for (Map.Entry<TagKey<Biome>, Item> entry : BIOME_TAG_GULIME_MAP.entrySet()) {
                    if (biome.is(entry.getKey())) {
                        resultGulime = entry.getValue();
                        break;
                    }
                }
            }
        }

        ItemStack resultStack = new ItemStack(resultGulime);
        boolean canAdd = false;
        for (ItemStack itemStack : player.getInventory().items) {
            if (itemStack.isEmpty() || (itemStack.is(resultStack.getItem()) && itemStack.getCount() < itemStack.getMaxStackSize())) {
                canAdd = true;
                break;
            }
        }

        if (!canAdd) return;

        int removed = 0;
        for (int i = 0; i < player.getInventory().items.size() && removed < 4; i++) {
            ItemStack invStack = player.getInventory().items.get(i);
            if (invStack.is(this)) {
                int toRemove = Math.min(4 - removed, invStack.getCount());
                invStack.shrink(toRemove);
                removed += toRemove;
            }
        }

        player.getInventory().add(resultStack);
        level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.SLIME_BLOCK_PLACE, SoundSource.PLAYERS, 1.0F, 1.0F);
        if (player instanceof ServerPlayer serverPlayer) CosmoCriteriaTriggers.GULIME.trigger(serverPlayer);

    }
}

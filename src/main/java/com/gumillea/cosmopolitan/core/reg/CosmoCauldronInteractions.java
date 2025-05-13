package com.gumillea.cosmopolitan.core.reg;

import com.gumillea.cosmopolitan.Cosmopolitan;
import com.gumillea.cosmopolitan.core.util.CosmoCompat;
import com.teamabnormals.blueprint.core.api.BlueprintCauldronInteraction;
import com.teamabnormals.blueprint.core.util.BlockUtil;
import com.teamabnormals.neapolitan.core.NeapolitanConfig;
import com.teamabnormals.neapolitan.core.other.NeapolitanCauldronInteractions;
import net.minecraft.core.cauldron.CauldronInteraction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.gameevent.GameEvent;

import java.util.Map;

public class CosmoCauldronInteractions {
    public static BlueprintCauldronInteraction APPLE_MILKSHAKE = BlueprintCauldronInteraction.register(new ResourceLocation(Cosmopolitan.MODID, "apple_milkshake"), CauldronInteraction.newInteractionMap());
    public static BlueprintCauldronInteraction CARROT_MILKSHAKE = BlueprintCauldronInteraction.register(new ResourceLocation(Cosmopolitan.MODID, "carrot_milkshake"), CauldronInteraction.newInteractionMap());
    public static BlueprintCauldronInteraction GLOW_BERRY_MILKSHAKE = BlueprintCauldronInteraction.register(new ResourceLocation(Cosmopolitan.MODID, "glow_berry_milkshake"), CauldronInteraction.newInteractionMap());
    public static BlueprintCauldronInteraction ENCHANTED_FRUIT_MILKSHAKE = BlueprintCauldronInteraction.register(new ResourceLocation(Cosmopolitan.MODID, "enchanted_fruit_milkshake"), CauldronInteraction.newInteractionMap());
    public static BlueprintCauldronInteraction KABLOOM_MILKSHAKE = BlueprintCauldronInteraction.register(new ResourceLocation(Cosmopolitan.MODID, "kabloom_milkshake"), CauldronInteraction.newInteractionMap());
    public static BlueprintCauldronInteraction SOURCE_BERRY_MILKSHAKE = BlueprintCauldronInteraction.register(new ResourceLocation(Cosmopolitan.MODID, "source_berry_milkshake"), CauldronInteraction.newInteractionMap());

    public CosmoCauldronInteractions() {
    }

    public static void registerCauldronInteractions() {
        if (CosmoCompat.nea && NeapolitanConfig.COMMON.milkshakeCauldrons.get()) {
            addMilkshakeInteractions(CosmoItems.APPLE_MILKSHAKE.get(), CosmoBlocks.APPLE_MILKSHAKE_CAULDRON.get(), CosmoItems.APPLE_ICE_CREAM.get(), APPLE_MILKSHAKE.map());
            addMilkshakeInteractions(CosmoItems.CARROT_MILKSHAKE.get(), CosmoBlocks.CARROT_MILKSHAKE_CAULDRON.get(), CosmoItems.CARROT_ICE_CREAM.get(), CARROT_MILKSHAKE.map());
            addMilkshakeInteractions(CosmoItems.GLOW_BERRY_MILKSHAKE.get(), CosmoBlocks.GLOW_BERRY_MILKSHAKE_CAULDRON.get(), CosmoItems.GLOW_BERRY_ICE_CREAM.get(), GLOW_BERRY_MILKSHAKE.map());
            addMilkshakeInteractions(CosmoItems.ENCHANTED_FRUIT_MILKSHAKE.get(), CosmoBlocks.ENCHANTED_FRUIT_MILKSHAKE_CAULDRON.get(), CosmoItems.ENCHANTED_FRUIT_ICE_CREAM.get(), ENCHANTED_FRUIT_MILKSHAKE.map());
            addMilkshakeInteractions(CosmoItems.KABLOOM_MILKSHAKE.get(), CosmoBlocks.KABLOOM_MILKSHAKE_CAULDRON.get(), CosmoItems.KABLOOM_ICE_CREAM.get(), KABLOOM_MILKSHAKE.map());
            addMilkshakeInteractions(CosmoItems.SOURCE_BERRY_MILKSHAKE.get(), CosmoBlocks.SOURCE_BERRY_MILKSHAKE_CAULDRON.get(), CosmoItems.SOURCE_BERRY_ICE_CREAM.get(), SOURCE_BERRY_MILKSHAKE.map());
        }

    }

    public static void addMilkshakeInteractions(Item filledBottle, Block filledCauldron, Item iceCream, Map<Item, CauldronInteraction> map) {
        if (!CosmoCompat.nea) return;
        NeapolitanCauldronInteractions.addMilkInteractions(filledBottle, filledCauldron, map);
        if (NeapolitanConfig.COMMON.milkCauldron.get()) {
            NeapolitanCauldronInteractions.MILK.map().put(iceCream, (state, level, pos, player, hand, stack) -> {
                if (!level.isClientSide) {
                    Item item = stack.getItem();
                    player.setItemInHand(hand, ItemUtils.createFilledResult(stack, player, new ItemStack(Items.BOWL)));
                    player.awardStat(Stats.USE_CAULDRON);
                    player.awardStat(Stats.ITEM_USED.get(item));
                    level.setBlockAndUpdate(pos, BlockUtil.transferAllBlockStates(level.getBlockState(pos), filledCauldron.defaultBlockState()));
                    level.playSound(null, pos, SoundEvents.BUCKET_EMPTY_POWDER_SNOW, SoundSource.BLOCKS, 1.0F, 1.0F);
                    level.gameEvent(null, GameEvent.FLUID_PLACE, pos);
                }

                return InteractionResult.sidedSuccess(level.isClientSide);
            });
        }

    }
}

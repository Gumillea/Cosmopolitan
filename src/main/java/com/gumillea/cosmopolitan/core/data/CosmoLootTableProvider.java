package com.gumillea.cosmopolitan.core.data;

import com.google.common.collect.ImmutableList;
import com.gumillea.cosmopolitan.Cosmopolitan;
import com.gumillea.cosmopolitan.common.block.FrozenDessertTubBlock;
import com.gumillea.cosmopolitan.core.reg.CosmoBlocks;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.CopyNameFunction;
import net.minecraft.world.level.storage.loot.functions.CopyNbtFunction;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.providers.nbt.ContextNbtProvider;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CosmoLootTableProvider extends LootTableProvider {

    public CosmoLootTableProvider(PackOutput output) {
        super(output, BuiltInLootTables.all(), ImmutableList.of(new LootTableProvider.SubProviderEntry(CosmoBlockLoot::new, LootContextParamSets.BLOCK)));
    }

    @Override
    protected void validate(Map<ResourceLocation, LootTable> map, ValidationContext context) {
    }

    private static class CosmoBlockLoot extends BlockLootSubProvider {
        private static final Set<Item> EXPLOSION_RESISTANT = Stream.of(Blocks.DRAGON_EGG, Blocks.BEACON, Blocks.CONDUIT, Blocks.SKELETON_SKULL, Blocks.WITHER_SKELETON_SKULL, Blocks.PLAYER_HEAD, Blocks.ZOMBIE_HEAD, Blocks.CREEPER_HEAD, Blocks.DRAGON_HEAD, Blocks.PIGLIN_HEAD, Blocks.SHULKER_BOX, Blocks.BLACK_SHULKER_BOX, Blocks.BLUE_SHULKER_BOX, Blocks.BROWN_SHULKER_BOX, Blocks.CYAN_SHULKER_BOX, Blocks.GRAY_SHULKER_BOX, Blocks.GREEN_SHULKER_BOX, Blocks.LIGHT_BLUE_SHULKER_BOX, Blocks.LIGHT_GRAY_SHULKER_BOX, Blocks.LIME_SHULKER_BOX, Blocks.MAGENTA_SHULKER_BOX, Blocks.ORANGE_SHULKER_BOX, Blocks.PINK_SHULKER_BOX, Blocks.PURPLE_SHULKER_BOX, Blocks.RED_SHULKER_BOX, Blocks.WHITE_SHULKER_BOX, Blocks.YELLOW_SHULKER_BOX).map(ItemLike::asItem).collect(Collectors.toSet());

        protected CosmoBlockLoot() {
            super(EXPLOSION_RESISTANT, FeatureFlags.REGISTRY.allFlags());
        }

        @Override
        public void generate() {
            this.dropSelf(CosmoBlocks.VANILLA_ICE_CREAM_BRICKS.get());
            this.dropSelf(CosmoBlocks.ADZUKI_ICE_CREAM_BRICKS.get());
            this.dropSelf(CosmoBlocks.STRAWBERRY_ICE_CREAM_BRICKS.get());
            this.dropSelf(CosmoBlocks.MINT_ICE_CREAM_BRICKS.get());
            this.dropSelf(CosmoBlocks.CHOCOLATE_ICE_CREAM_BRICKS.get());
            this.dropSelf(CosmoBlocks.BANANA_ICE_CREAM_BRICKS.get());

            this.dropSelf(CosmoBlocks.CHISELED_VANILLA_ICE_CREAM_BLOCK.get());
            this.dropSelf(CosmoBlocks.CHISELED_ADZUKI_ICE_CREAM_BLOCK.get());
            this.dropSelf(CosmoBlocks.CHISELED_STRAWBERRY_ICE_CREAM_BLOCK.get());
            this.dropSelf(CosmoBlocks.CHISELED_MINT_ICE_CREAM_BLOCK.get());
            this.dropSelf(CosmoBlocks.CHISELED_CHOCOLATE_ICE_CREAM_BLOCK.get());
            this.dropSelf(CosmoBlocks.CHISELED_BANANA_ICE_CREAM_BLOCK.get());

            this.dropSelf(CosmoBlocks.APPLE_ICE_CREAM_BLOCK.get());
            this.dropSelf(CosmoBlocks.CARROT_ICE_CREAM_BLOCK.get());
            this.dropSelf(CosmoBlocks.GLOW_BERRY_ICE_CREAM_BLOCK.get());
            this.dropSelf(CosmoBlocks.ENCHANTED_FRUIT_ICE_CREAM_BLOCK.get());
            this.dropSelf(CosmoBlocks.KABLOOM_ICE_CREAM_BLOCK.get());
            this.dropSelf(CosmoBlocks.SOURCE_BERRY_ICE_CREAM_BLOCK.get());

            this.dropSelf(CosmoBlocks.SAPPY_BIRCH_LOG.get());
            this.dropSelf(CosmoBlocks.MASHED_POTATO_BLOCK.get());
            this.dropSelf(CosmoBlocks.WHEATGRASS_BALE.get());

            this.dropCauldron(CosmoBlocks.APPLE_MILKSHAKE_CAULDRON.get());
            this.dropCauldron(CosmoBlocks.CARROT_MILKSHAKE_CAULDRON.get());
            this.dropCauldron(CosmoBlocks.GLOW_BERRY_MILKSHAKE_CAULDRON.get());
            this.dropCauldron(CosmoBlocks.ENCHANTED_FRUIT_MILKSHAKE_CAULDRON.get());
            this.dropCauldron(CosmoBlocks.KABLOOM_MILKSHAKE_CAULDRON.get());
            this.dropCauldron(CosmoBlocks.SOURCE_BERRY_MILKSHAKE_CAULDRON.get());

            this.dropTub(CosmoBlocks.COPPER_FROZEN_DESSERT_TUB.get());
            this.dropTub(CosmoBlocks.IRON_FROZEN_DESSERT_TUB.get());
            this.dropTub(CosmoBlocks.NETHERITE_FROZEN_DESSERT_TUB.get());

            this.dropNothing(CosmoBlocks.GLOW_PETALS.get());
            this.dropNothing(CosmoBlocks.LIFELIGHT.get());
        }

        private void dropCauldron(Block block) {
           this.dropOther(block, Blocks.CAULDRON);
        }

        private void dropNothing(Block block) {
            this.add(block, noDrop());
        }

        private void dropTub(Block block) {
            final String poolName = ForgeRegistries.BLOCKS.getKey(block).getPath();

            LootPool.Builder pool = LootPool.lootPool()
                    .name(poolName)
                    .setRolls(ConstantValue.exactly(1))
                    .add(LootItem.lootTableItem(block)
                            .apply(CopyNameFunction.copyName(CopyNameFunction.NameSource.BLOCK_ENTITY))
                            .apply(CopyNbtFunction.copyData(ContextNbtProvider.BLOCK_ENTITY)
                                    .copy("Tank", "BlockEntityTag.Tank", CopyNbtFunction.MergeStrategy.REPLACE))
                            .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                    .setProperties(StatePropertiesPredicate.Builder.properties()
                                            .hasProperty(FrozenDessertTubBlock.OPEN, false)))
                    )
                    .add(LootItem.lootTableItem(block)
                            .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                    .setProperties(StatePropertiesPredicate.Builder.properties()
                                            .hasProperty(FrozenDessertTubBlock.OPEN, true)))
                    );
            this.add(block, LootTable.lootTable().withPool(pool));
        }

        @Override
        public Iterable<Block> getKnownBlocks() {
            return ForgeRegistries.BLOCKS.getValues().stream().filter(block -> ForgeRegistries.BLOCKS.getKey(block) != null && Cosmopolitan.MODID.equals(ForgeRegistries.BLOCKS.getKey(block).getNamespace())).collect(Collectors.toSet());
        }
    }
}
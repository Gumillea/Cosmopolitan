package com.gumillea.cosmopolitan.core.data;

import com.gumillea.cosmopolitan.Cosmopolitan;
import com.gumillea.cosmopolitan.core.reg.CosmoItems;
import com.gumillea.cosmopolitan.core.util.CosmoCompat;
import com.teamabnormals.atmospheric.core.registry.AtmosphericItems;
import com.teamabnormals.blueprint.common.loot.modification.LootModifierProvider;
import com.teamabnormals.blueprint.common.loot.modification.modifiers.LootPoolEntriesModifier;
import com.teamabnormals.blueprint.common.loot.modification.modifiers.LootPoolsModifier;
import com.teamabnormals.blueprint.core.util.modification.selection.ConditionedResourceSelector;
import com.teamabnormals.blueprint.core.util.modification.selection.selectors.NamesResourceSelector;
import net.minecraft.advancements.critereon.*;
import net.minecraft.data.PackOutput;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.ApplyExplosionDecay;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.*;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.ModLoadedCondition;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class CosmoLootModifierProvider extends LootModifierProvider {

    public CosmoLootModifierProvider(PackOutput output, CompletableFuture<Provider> provider) {
        super(Cosmopolitan.MODID, output, provider);
    }

    public static final LootItemCondition.Builder HAS_NO_SHEARS_OR_SILK_TOUCH = MatchTool.toolMatches(ItemPredicate.Builder.item().of(Items.SHEARS)).or(MatchTool.toolMatches(ItemPredicate.Builder.item().hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.Ints.atLeast(1))))).invert();

    @Override
    protected void registerEntries(Provider provider) {
        //wildberry
        this.entry("tall_grass").selects("blocks/tall_grass")
                .addModifier(new LootPoolsModifier(Collections.singletonList(LootPool
                        .lootPool().name("cosmopolitan:wildberry_from_tall_grass")
                        .setRolls(ConstantValue.exactly(1.0F))
                        .when(HAS_NO_SHEARS_OR_SILK_TOUCH)
                        .add(LootItem.lootTableItem(CosmoItems.WILDBERRY.get())
                                .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE))
                                .apply(ApplyExplosionDecay.explosionDecay())
                                .when(LootItemRandomChanceCondition.randomChance(0.125F))) .build()), false));
        this.entry("grass").selects("blocks/grass")
                .addModifier(new LootPoolsModifier(Collections.singletonList(LootPool
                        .lootPool().name("cosmopolitan:wildberry")
                        .setRolls(ConstantValue.exactly(1.0F))
                        .when(HAS_NO_SHEARS_OR_SILK_TOUCH)
                        .add(LootItem.lootTableItem(CosmoItems.WILDBERRY.get())
                                .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE))
                                .apply(ApplyExplosionDecay.explosionDecay())
                                .when(LootItemRandomChanceCondition.randomChance(0.125F))) .build()), false));
        //fiddlehead
        this.entry("large_fern").selects("blocks/large_fern")
                .addModifier(new LootPoolsModifier(Collections.singletonList(LootPool
                        .lootPool().name("cosmopolitan:fiddlehead_from_large_fern")
                        .setRolls(ConstantValue.exactly(1.0F))
                        .when(HAS_NO_SHEARS_OR_SILK_TOUCH)
                        .add(LootItem.lootTableItem(CosmoItems.FIDDLEHEAD.get())
                                .apply(ApplyExplosionDecay.explosionDecay())
                                .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.LARGE_FERN)
                                        .setProperties(StatePropertiesPredicate.Builder.properties()
                                                .hasProperty(BlockStateProperties.HALF, "lower"))))
                        .add(LootItem.lootTableItem(CosmoItems.FIDDLEHEAD.get())
                                .apply(ApplyExplosionDecay.explosionDecay())
                                .when(BonusLevelTableCondition.bonusLevelFlatChance(Enchantments.BLOCK_FORTUNE, 0.05F, 0.055555557F, 0.0625F, 0.08333334F, 0.25F))).build()), false));
        this.entry("fern").selects("blocks/fern")
                .addModifier(new LootPoolsModifier(Collections.singletonList(LootPool
                        .lootPool().name("cosmopolitan:fiddlehead")
                        .setRolls(ConstantValue.exactly(1.0F))
                        .when(HAS_NO_SHEARS_OR_SILK_TOUCH)
                        .add(LootItem.lootTableItem(CosmoItems.FIDDLEHEAD.get())
                                .apply(ApplyExplosionDecay.explosionDecay())
                                .when(BonusLevelTableCondition.bonusLevelFlatChance(Enchantments.BLOCK_FORTUNE, 0.05F, 0.055555557F, 0.0625F, 0.08333334F, 0.25F))).build()), false));
        //wheatgrass
        this.entry("wheat").selects("blocks/wheat")
                .addModifier(new LootPoolsModifier(Collections.singletonList(
                        LootPool.lootPool().name("cosmopolitan:wheatgrass")
                                .setRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem.lootTableItem(CosmoItems.WHEATGRASS.get())
                                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.WHEAT)
                                                .setProperties(StatePropertiesPredicate.Builder.properties()
                                                        .hasProperty(BlockStateProperties.AGE_7, 3))
                                                .or(LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.WHEAT)
                                                        .setProperties(StatePropertiesPredicate.Builder.properties()
                                                                .hasProperty(BlockStateProperties.AGE_7, 4))))
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2)))
                                        .apply(ApplyExplosionDecay.explosionDecay()))
                                .add(LootItem.lootTableItem(CosmoItems.WHEATGRASS.get())
                                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.WHEAT)
                                                .setProperties(StatePropertiesPredicate.Builder.properties()
                                                        .hasProperty(BlockStateProperties.AGE_7, 5))
                                                .or(LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.WHEAT)
                                                        .setProperties(StatePropertiesPredicate.Builder.properties()
                                                                .hasProperty(BlockStateProperties.AGE_7, 6))))
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 4)))
                                        .apply(ApplyExplosionDecay.explosionDecay()))
                                .build()
                ), false));
        //pips
        this.entry("sourceberry_bush").selector(new ConditionedResourceSelector(new NamesResourceSelector(new ResourceLocation(CosmoCompat.AN, "blocks/sourceberry_bush")), new ModLoadedCondition(CosmoCompat.BG)))
                .addModifier(new LootPoolsModifier(List.of(
                        LootPool.lootPool().name("cosmopolitan:sourceberry_bush")
                        .setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(CosmoItems.SOURCE_BERRY_PIPS.get()))
                        .build()), false));
        this.entry("droopvine").selector(new ConditionedResourceSelector(new NamesResourceSelector(new ResourceLocation(CosmoCompat.UG, "blocks/droopvine")), new ModLoadedCondition(CosmoCompat.BG)))
                .addModifier(new LootPoolsModifier(List.of(
                        LootPool.lootPool().name("cosmopolitan:droopvine")
                                .setRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem.lootTableItem(CosmoItems.DROOPFRUIT_PIPS.get()))
                                .build()), false));
        this.entry("blisterberry_bush").selector(new ConditionedResourceSelector(new NamesResourceSelector(new ResourceLocation(CosmoCompat.UG, "blocks/blisterberry_bush")), new ModLoadedCondition(CosmoCompat.BG)))
                .addModifier(new LootPoolsModifier(List.of(
                        LootPool.lootPool().name("cosmopolitan:blisterberry_bush")
                                .setRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem.lootTableItem(CosmoItems.BLISTERBERRY_PIPS.get()))
                                .build()), false));
        this.entry("kabloom_bush").selector(new ConditionedResourceSelector(new NamesResourceSelector(new ResourceLocation(CosmoCompat.HA, "blocks/kabloom_bush")), new ModLoadedCondition(CosmoCompat.BG)))
                .addModifier(new LootPoolsModifier(List.of(
                        LootPool.lootPool().name("cosmopolitan:kabloom_bush")
                                .setRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem.lootTableItem(CosmoItems.KABLOOM_PIPS.get()))
                                .build()), false));
        //enchanted_cosmopolitan
        this.entry("ancien_city").selects(new ResourceLocation[]{BuiltInLootTables.ANCIENT_CITY})
                .addModifier(new LootPoolEntriesModifier(false, 0, List.of(
                        LootItem.lootTableItem(CosmoItems.ENCHANTED_COSMOPOLITAN_COCKTAIL.get()).setWeight(1).build())));
        this.entry("stronghold_library").selects(new ResourceLocation[]{BuiltInLootTables.STRONGHOLD_LIBRARY})
                .addModifier(new LootPoolEntriesModifier(false, 0, List.of(
                        LootItem.lootTableItem(CosmoItems.ENCHANTED_COSMOPOLITAN_COCKTAIL.get()).setWeight(15).build())));
    }

}
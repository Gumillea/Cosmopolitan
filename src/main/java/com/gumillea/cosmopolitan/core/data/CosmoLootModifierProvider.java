package com.gumillea.cosmopolitan.core.data;

import com.gumillea.cosmopolitan.Cosmopolitan;
import com.gumillea.cosmopolitan.core.reg.CosmoItems;
import com.teamabnormals.blueprint.common.loot.modification.LootModifierProvider;
import com.teamabnormals.blueprint.common.loot.modification.modifiers.LootPoolsModifier;
import net.minecraft.advancements.critereon.EnchantmentPredicate;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.MinMaxBounds;
import net.minecraft.data.PackOutput;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyExplosionDecay;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.BonusLevelTableCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.Collections;
import java.util.concurrent.CompletableFuture;

public class CosmoLootModifierProvider extends LootModifierProvider {

    public CosmoLootModifierProvider(PackOutput output, CompletableFuture<Provider> provider) {
        super(Cosmopolitan.MODID, output, provider);
    }

    public static final LootItemCondition.Builder HAS_NO_SHEARS_OR_SILK_TOUCH = MatchTool.toolMatches(ItemPredicate.Builder.item().of(Items.SHEARS)).or(MatchTool.toolMatches(ItemPredicate.Builder.item().hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.Ints.atLeast(1))))).invert();

    @Override
    protected void registerEntries(Provider provider) {
        this.entry("tall_grass").selects("blocks/tall_grass")
                .addModifier(new LootPoolsModifier(Collections.singletonList(LootPool
                        .lootPool().name("cosmopolitan:redberry_from_tall_grass")
                        .setRolls(ConstantValue.exactly(1.0F))
                        .when(HAS_NO_SHEARS_OR_SILK_TOUCH)
                        .add(LootItem.lootTableItem(CosmoItems.WILDBERRY.get())
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3)))
                                .apply(ApplyExplosionDecay.explosionDecay())
                                .when(BonusLevelTableCondition.bonusLevelFlatChance(Enchantments.BLOCK_FORTUNE, 0.05F, 0.055555557F, 0.0625F, 0.08333334F, 0.25F))).build()), false));
        this.entry("grass").selects("blocks/grass")
                .addModifier(new LootPoolsModifier(Collections.singletonList(LootPool
                        .lootPool().name("cosmopolitan:redberry")
                        .setRolls(ConstantValue.exactly(1.0F))
                        .when(HAS_NO_SHEARS_OR_SILK_TOUCH)
                        .add(LootItem.lootTableItem(CosmoItems.WILDBERRY.get())
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2)))
                                .apply(ApplyExplosionDecay.explosionDecay())
                                .when(BonusLevelTableCondition.bonusLevelFlatChance(Enchantments.BLOCK_FORTUNE, 0.025F, 0.027777778F, 0.03125F, 0.04166667F, 0.125F))).build()), false));

        this.entry("tall_fern").selects("blocks/large_fern")
                .addModifier(new LootPoolsModifier(Collections.singletonList(LootPool
                        .lootPool().name("cosmopolitan:fiddlehead_from_large_fern")
                        .setRolls(ConstantValue.exactly(1.0F))
                        .when(HAS_NO_SHEARS_OR_SILK_TOUCH)
                        .add(LootItem.lootTableItem(CosmoItems.FIDDLEHEAD.get())
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2)))
                                .apply(ApplyExplosionDecay.explosionDecay())
                                .when(BonusLevelTableCondition.bonusLevelFlatChance(Enchantments.BLOCK_FORTUNE, 0.05F, 0.055555557F, 0.0625F, 0.08333334F, 0.25F))).build()), false));
        this.entry("fern").selects("blocks/fern")
                .addModifier(new LootPoolsModifier(Collections.singletonList(LootPool
                        .lootPool().name("cosmopolitan:fiddlehead")
                        .setRolls(ConstantValue.exactly(1.0F))
                        .when(HAS_NO_SHEARS_OR_SILK_TOUCH)
                        .add(LootItem.lootTableItem(CosmoItems.FIDDLEHEAD.get())
                                .apply(ApplyExplosionDecay.explosionDecay())
                                .when(BonusLevelTableCondition.bonusLevelFlatChance(Enchantments.BLOCK_FORTUNE, 0.025F, 0.027777778F, 0.03125F, 0.04166667F, 0.125F))).build()), false));
    }

}
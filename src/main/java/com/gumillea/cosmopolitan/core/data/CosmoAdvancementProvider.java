package com.gumillea.cosmopolitan.core.data;

import com.gumillea.cosmopolitan.Cosmopolitan;
import com.gumillea.cosmopolitan.core.misc.CosmoCriteriaTriggers;
import com.gumillea.cosmopolitan.core.reg.CosmoItems;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.PackOutput;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeAdvancementProvider;
import net.minecraft.core.HolderLookup.Provider;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class CosmoAdvancementProvider implements ForgeAdvancementProvider.AdvancementGenerator {

    public static ForgeAdvancementProvider create(PackOutput output, CompletableFuture<Provider> provider, ExistingFileHelper helper) {
        return new ForgeAdvancementProvider(output, provider, helper, List.of(new CosmoAdvancementProvider()));
    }

    @Override
    public void generate(Provider provider, Consumer<Advancement> consumer, ExistingFileHelper helper) {
        createAdvancement("eat_special_wildberry", "husbandry", new ResourceLocation("husbandry/plant_seed"), CosmoItems.WILDBERRY.get(), FrameType.TASK, true, true, false)
                .addCriterion("eat_special_wildberry", CosmoCriteriaTriggers.WILDBERRY.createInstance())
                .save(consumer, Cosmopolitan.MODID + ":husbandry/eat_special_wildberry");

        createAdvancement("plant_potted_crop", "husbandry", new ResourceLocation("husbandry/plant_seed"), Items.FLOWER_POT, FrameType.TASK, true, true, false)
                .addCriterion("plant_potted_crop", CosmoCriteriaTriggers.POTTED_CROP.createInstance())
                .save(consumer, Cosmopolitan.MODID + ":husbandry/plant_potted_crop");

        createAdvancement("feed_wheatgrass", "husbandry", new ResourceLocation("husbandry/tame_an_animal"), CosmoItems.PAW_COOKIE.get(), FrameType.TASK, true, true, false)
                .addCriterion("feed_wheatgrass", CosmoCriteriaTriggers.WHEATGRASS.createInstance())
                .save(consumer, Cosmopolitan.MODID + ":husbandry/feed_wheatgrass");

        createAdvancement("eat_herbal_cookie", "husbandry", new ResourceLocation("husbandry/safely_harvest_honey"), CosmoItems.HERBAL_COOKIE.get(), FrameType.TASK, true, true, false)
                .addCriterion("eat_herbal_cookie", CosmoCriteriaTriggers.HERBAL_COOKIE.createInstance())
                .save(consumer, Cosmopolitan.MODID + ":husbandry/eat_herbal_cookie");

        createAdvancement("restore_gulime", "husbandry", new ResourceLocation("husbandry/safely_harvest_honey"), CosmoItems.GULIME.get(), FrameType.TASK, true, true, false)
                .addCriterion("restore_gulime", CosmoCriteriaTriggers.GULIME.createInstance())
                .save(consumer, Cosmopolitan.MODID + ":husbandry/restore_gulime");

        createAdvancement("obtain_all_biome_gulimes", "husbandry", new ResourceLocation(Cosmopolitan.MODID, "husbandry/restore_gulime"), CosmoItems.UNDERGROUND_GULIME.get(), FrameType.CHALLENGE, true, true, false)
                .addCriterion("underground_gulime", InventoryChangeTrigger.TriggerInstance.hasItems(CosmoItems.UNDERGROUND_GULIME.get()))
                .addCriterion("taiga_gulime", InventoryChangeTrigger.TriggerInstance.hasItems(CosmoItems.TAIGA_GULIME.get()))
                .addCriterion("chorus_gulime", InventoryChangeTrigger.TriggerInstance.hasItems(CosmoItems.CHORUS_GULIME.get()))
                .addCriterion("arid_gulime", InventoryChangeTrigger.TriggerInstance.hasItems(CosmoItems.ARID_GULIME.get()))
                .addCriterion("warped_gulime", InventoryChangeTrigger.TriggerInstance.hasItems(CosmoItems.WARPED_GULIME.get()))
                .rewards(AdvancementRewards.Builder.experience(50))
                .save(consumer, Cosmopolitan.MODID + ":husbandry/obtain_all_biome_gulimes");
    }

    private static Advancement.Builder createAdvancement(String name, String category, ResourceLocation parent, ItemLike icon, FrameType frame, boolean showToast, boolean announceToChat, boolean hidden) {
        return createAdvancement(name, category, Advancement.Builder.advancement().build(parent), icon, frame, showToast, announceToChat, hidden);
    }

    private static Advancement.Builder createAdvancement(String name, String category, Advancement parent, ItemLike icon, FrameType frame, boolean showToast, boolean announceToChat, boolean hidden) {
        return Advancement.Builder.advancement().parent(parent).display(icon,
                Component.translatable("advancements." + Cosmopolitan.MODID + "." + category + "." + name + ".title"),
                Component.translatable("advancements." + Cosmopolitan.MODID + "." + category + "." + name + ".description"),
                null, frame, showToast, announceToChat, hidden);
    }
}
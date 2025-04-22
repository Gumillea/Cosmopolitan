package com.gumillea.cosmopolitan.core.util;

import com.cosmicgelatin.seasonals.core.registry.SeasonalsMobEffects;
import com.gumillea.cosmopolitan.core.reg.CosmoEffects;
import com.gumillea.exquisito.core.reg.ExquisitoEffects;
import com.hollingsworth.arsnouveau.setup.registry.ModPotions;
import com.teamabnormals.atmospheric.core.registry.AtmosphericMobEffects;
import com.teamabnormals.neapolitan.core.registry.NeapolitanMobEffects;
import mod.schnappdragon.habitat.core.registry.HabitatEffects;
import net.brdle.collectorsreap.common.effect.CREffects;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.ForgeRegistries;
import quek.undergarden.registry.UGBlocks;

public class CosmoCompat {
    public static final String AN = "ars_nouveau";
    public static final String AT = "atmospheric";
    public static final String CR = "collectorsreap";
    public static final String BAC = "brewinandchewin";
    public static final String BG = "berry_good";
    public static final String DF = "delightful";
    public static final String EX = "exquisito";
    public static final String EE = "enlightened_end";
    public static final String CAD = "casualness_delight";
    public static final String FCD = "frycooks_delight";
    public static final String FD = "farmersdelight";
    public static final String HA = "habitat";
    public static final String NEA = "neapolitan";
    public static final String PEC = "peculiars";
    public static final String QUA = "quark";
    public static final String TF = "twilightforest";
    public static final String TFD = "twilightdelight";
    public static final String SEA = "seasonals";
    public static final String UG = "undergarden";

    //ars_nouveau
    public static final MobEffect MANA_REGEN = ((ModList.get().isLoaded(AN)) ? (ModPotions.MANA_REGEN_EFFECT.get()) : CosmoEffects.PLACEHOLDER.get());
    public static Item SOURCEBERRY = ForgeRegistries.ITEMS.getValue(new ResourceLocation(AN, "sourceberry_bush"));
    public static Block SOURCE_BERRY_BLOCK = ModList.get().isLoaded(AN) ? ForgeRegistries.BLOCKS.getValue(new ResourceLocation(AN, "sourceberry_bush")) : Blocks.SWEET_BERRY_BUSH;

    //atmospheric
    public static final MobEffect PERSISTENCE = ((ModList.get().isLoaded(AT)) ? (AtmosphericMobEffects.PERSISTENCE.get()) : CosmoEffects.PLACEHOLDER.get());
    public static final MobEffect RELIEF = ((ModList.get().isLoaded(AT)) ? (AtmosphericMobEffects.RELIEF.get()) : CosmoEffects.PLACEHOLDER.get());
    public static final MobEffect SPITTING = ((ModList.get().isLoaded(AT)) ? (AtmosphericMobEffects.SPITTING.get()) : CosmoEffects.PLACEHOLDER.get());

    //collectorsreap
    public static final MobEffect CORROSION = ((ModList.get().isLoaded(CR)) ? (CREffects.CORROSION.get()) : CosmoEffects.PLACEHOLDER.get());
    public static final MobEffect VOLATILITY = ((ModList.get().isLoaded(CR)) ? (CREffects.VOLATILITY.get()) : CosmoEffects.PLACEHOLDER.get());

    //habitat
    public static final MobEffect BLAST_ENDURANCE = ((ModList.get().isLoaded(HA)) ? (HabitatEffects.BLAST_ENDURANCE.get()) : CosmoEffects.PLACEHOLDER.get());
    public static Item KABLOOM = ForgeRegistries.ITEMS.getValue(new ResourceLocation(HA, "kabloom_pulp"));
    public static Block KABLOOM_BLOCK = ModList.get().isLoaded(AN) ? ForgeRegistries.BLOCKS.getValue(new ResourceLocation(HA, "kabloom_bush")) : Blocks.SWEET_BERRY_BUSH;

    //neapolitan
    public static final MobEffect AGILITY = ((ModList.get().isLoaded(NEA)) ? (NeapolitanMobEffects.AGILITY.get()) : CosmoEffects.PLACEHOLDER.get());
    public static final MobEffect BERSERKING = ((ModList.get().isLoaded(NEA)) ? (NeapolitanMobEffects.BERSERKING.get()) : CosmoEffects.PLACEHOLDER.get());
    public static final MobEffect HARMONY = ((ModList.get().isLoaded(NEA)) ? (NeapolitanMobEffects.HARMONY.get()) : CosmoEffects.PLACEHOLDER.get());
    public static final MobEffect SUGAR_RUSH = ((ModList.get().isLoaded(NEA)) ? (NeapolitanMobEffects.SUGAR_RUSH.get()) : CosmoEffects.PLACEHOLDER.get());
    public static final MobEffect VANILLA_SCENT = ((ModList.get().isLoaded(NEA)) ? (NeapolitanMobEffects.VANILLA_SCENT.get()) : CosmoEffects.PLACEHOLDER.get());

    //exquisito
    public static final MobEffect RESONANCE = ((ModList.get().isLoaded(EX)) ? (ExquisitoEffects.RESONANCE.get()) : CosmoEffects.PLACEHOLDER.get());
    public static final MobEffect MODULATION = ((ModList.get().isLoaded(EX)) ? (ExquisitoEffects.MODULATION.get()) : CosmoEffects.PLACEHOLDER.get());
    public static final MobEffect FUCHSIA_GOO = ((ModList.get().isLoaded(EX) && ModList.get().isLoaded(EE)) ? (ExquisitoEffects.FUCHSIA_GOO.get()) : CosmoEffects.PLACEHOLDER.get());
    public static final MobEffect SPACE_DIVING = ((ModList.get().isLoaded(EX)) ? (ExquisitoEffects.SPACE_DIVING.get()) : CosmoEffects.PLACEHOLDER.get());
    public static final MobEffect EARENDEL = ((ModList.get().isLoaded(EX)) ? (ExquisitoEffects.EARENDEL.get()) : CosmoEffects.PLACEHOLDER.get());
    public static final MobEffect MORGOTH = ((ModList.get().isLoaded(EX)) ? (ExquisitoEffects.MORGOTH.get()) : CosmoEffects.PLACEHOLDER.get());

    //seasonals
    public static final MobEffect ROOTED = ((ModList.get().isLoaded(SEA)) ? (SeasonalsMobEffects.ROOTED.get()) : CosmoEffects.PLACEHOLDER.get());
    public static final MobEffect STUFFED = ((ModList.get().isLoaded(SEA)) ? (SeasonalsMobEffects.STUFFED.get()) : CosmoEffects.PLACEHOLDER.get());
    public static final MobEffect THORN_RESISTANCE = ((ModList.get().isLoaded(SEA)) ? (SeasonalsMobEffects.THORN_RESISTANCE.get()) : CosmoEffects.PLACEHOLDER.get());

    //twilight_delight
    public static MobEffect AURORA = ModList.get().isLoaded(TFD) ? ForgeRegistries.MOB_EFFECTS.getValue(new ResourceLocation(TFD, "aurora_glowing")): MobEffects.MOVEMENT_SPEED;
    public static MobEffect FIRE_RANGE = ModList.get().isLoaded(TFD) ? ForgeRegistries.MOB_EFFECTS.getValue(new ResourceLocation(TFD, "fire_range")): MobEffects.GLOWING;
    public static MobEffect POISON_RANGE = ModList.get().isLoaded(TFD) ? ForgeRegistries.MOB_EFFECTS.getValue(new ResourceLocation(TFD, "poison_range")): MobEffects.DAMAGE_BOOST;
    public static MobEffect FROZEN_RANGE = ModList.get().isLoaded(TFD) ? ForgeRegistries.MOB_EFFECTS.getValue(new ResourceLocation(TFD, "frozen_range")): MobEffects.FIRE_RESISTANCE;

    //undergarden
    public static Item BLISTERBERRY = ForgeRegistries.ITEMS.getValue(new ResourceLocation(UG, "blisterberry"));
    public static Item DROOPFRUIT = ForgeRegistries.ITEMS.getValue(new ResourceLocation(UG, "droopvine_item"));
    public static Block BLISTERBERRY_BUSH = ModList.get().isLoaded(UG) ? ForgeRegistries.BLOCKS.getValue(new ResourceLocation(UG, "blisterberry_bush")) : Blocks.SWEET_BERRY_BUSH;
    public static Block DROOP_VINE = ModList.get().isLoaded(UG) ? UGBlocks.DROOPVINE.get() : Blocks.CAVE_VINES;
}


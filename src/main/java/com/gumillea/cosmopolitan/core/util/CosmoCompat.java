package com.gumillea.cosmopolitan.core.util;

import com.cosmicgelatin.seasonals.core.registry.SeasonalsMobEffects;
import com.gumillea.exquisito.core.reg.ExquisitoEffects;
import com.hollingsworth.arsnouveau.setup.registry.ModPotions;
import com.teamabnormals.neapolitan.core.registry.NeapolitanMobEffects;
import mod.schnappdragon.habitat.core.registry.HabitatEffects;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.ForgeRegistries;

public class CosmoCompat {
    public static final String AN = "ars_nouveau";
    public static final String EX = "exquisito";
    public static final String EE = "enlightened_end";
    public static final String CAD = "casualness_delight";
    public static final String FCD = "frycooks_delight";
    public static final String FD = "farmersdelight";
    public static final String HA = "habitat";
    public static final String NEA = "neapolitan";
    public static final String QUA = "quark";
    public static final String TF = "twilightforest";
    public static final String TFD = "twilightdelight";
    public static final String SEA = "seasonals";

    //ars_nouveau
    public static final MobEffect MANA_REGEN = ((ModList.get().isLoaded(AN)) ? (ModPotions.MANA_REGEN_EFFECT.get()) : MobEffects.GLOWING);

    //habitat
    public static final MobEffect BLAST_ENDURANCE = ((ModList.get().isLoaded(HA)) ? (HabitatEffects.BLAST_ENDURANCE.get()) : MobEffects.GLOWING);

    //neapolitan
    public static final MobEffect AGILITY = ((ModList.get().isLoaded(NEA)) ? (NeapolitanMobEffects.AGILITY.get()) : MobEffects.GLOWING);
    public static final MobEffect BERSERKING = ((ModList.get().isLoaded(NEA)) ? (NeapolitanMobEffects.BERSERKING.get()) : MobEffects.GLOWING);
    public static final MobEffect HARMONY = ((ModList.get().isLoaded(NEA)) ? (NeapolitanMobEffects.HARMONY.get()) : MobEffects.GLOWING);
    public static final MobEffect SUGAR_RUSH = ((ModList.get().isLoaded(NEA)) ? (NeapolitanMobEffects.SUGAR_RUSH.get()) : MobEffects.GLOWING);
    public static final MobEffect VANILLA_SCENT = ((ModList.get().isLoaded(NEA)) ? (NeapolitanMobEffects.VANILLA_SCENT.get()) : MobEffects.GLOWING);

    //exquisito
    public static final MobEffect RESONANCE = ((ModList.get().isLoaded(EX)) ? (ExquisitoEffects.RESONANCE.get()) : MobEffects.GLOWING);
    public static final MobEffect MODULATION = ((ModList.get().isLoaded(EX)) ? (ExquisitoEffects.MODULATION.get()) : MobEffects.GLOWING);
    public static final MobEffect FUCHSIA_GOO = ((ModList.get().isLoaded(EX)) ? (ExquisitoEffects.FUCHSIA_GOO.get()) : MobEffects.GLOWING);
    public static final MobEffect SPACE_DIVING = ((ModList.get().isLoaded(EX)) ? (ExquisitoEffects.SPACE_DIVING.get()) : MobEffects.GLOWING);
    public static final MobEffect EARENDEL = ((ModList.get().isLoaded(EX)) ? (ExquisitoEffects.EARENDEL.get()) : MobEffects.GLOWING);
    public static final MobEffect MORGOTH = ((ModList.get().isLoaded(EX)) ? (ExquisitoEffects.MORGOTH.get()) : MobEffects.GLOWING);

    //seasonals
    public static final MobEffect ROOTED = ((ModList.get().isLoaded(SEA)) ? (SeasonalsMobEffects.ROOTED.get()) : MobEffects.GLOWING);
    public static final MobEffect STUFFED = ((ModList.get().isLoaded(SEA)) ? (SeasonalsMobEffects.STUFFED.get()) : MobEffects.GLOWING);
    public static final MobEffect THORN_RESISTANCE = ((ModList.get().isLoaded(SEA)) ? (SeasonalsMobEffects.THORN_RESISTANCE.get()) : MobEffects.GLOWING);

    //twilight_delight
    public static MobEffect AURORA = ModList.get().isLoaded(TFD) ? ForgeRegistries.MOB_EFFECTS.getValue(new ResourceLocation(TFD, "aurora_glowing")): MobEffects.GLOWING;
    public static MobEffect FIRE_RANGE = ModList.get().isLoaded(TFD) ? ForgeRegistries.MOB_EFFECTS.getValue(new ResourceLocation(TFD, "fire_range")): MobEffects.GLOWING;
    public static MobEffect POISON_RANGE = ModList.get().isLoaded(TFD) ? ForgeRegistries.MOB_EFFECTS.getValue(new ResourceLocation(TFD, "poison_range")): MobEffects.DAMAGE_BOOST;
    public static MobEffect FROZEN_RANGE = ModList.get().isLoaded(TFD) ? ForgeRegistries.MOB_EFFECTS.getValue(new ResourceLocation(TFD, "frozen_range")): MobEffects.FIRE_RESISTANCE;

}


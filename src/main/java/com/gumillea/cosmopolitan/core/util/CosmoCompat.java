package com.gumillea.cosmopolitan.core.util;

import com.cosmicgelatin.seasonals.core.registry.SeasonalsMobEffects;
import com.gumillea.cosmopolitan.core.reg.CosmoBlocks;
import com.gumillea.cosmopolitan.core.reg.CosmoEffects;
import com.gumillea.cosmopolitan.core.reg.CosmoItems;
import com.gumillea.exquisito.core.reg.ExquisitoEffects;
import com.sammy.minersdelight.setup.MDFoodValues;
import com.teamabnormals.atmospheric.core.registry.AtmosphericMobEffects;
import com.teamabnormals.neapolitan.common.item.HealingItem;
import com.teamabnormals.neapolitan.core.registry.NeapolitanMobEffects;
import mod.schnappdragon.habitat.core.registry.HabitatEffects;
import net.brdle.collectorsreap.common.effect.CREffects;
import net.brdle.collectorsreap.common.item.CRItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import quek.undergarden.registry.UGBlocks;
import umpaz.brewinandchewin.common.registry.BnCEffects;
import umpaz.brewinandchewin.common.registry.BnCItems;
import umpaz.farmersrespite.common.registry.FREffects;
import vectorwing.farmersdelight.common.registry.ModEffects;

public class CosmoCompat {
    public static final String AD  = "abnormals_delight";
    public static final boolean ad = ModList.get().isLoaded(AD);
    public static final String AN  = "ars_nouveau";
    public static final boolean an = ModList.get().isLoaded(AN);
    public static final String AT  = "atmospheric";
    public static final boolean at = ModList.get().isLoaded(AT);
    public static final String BF  = "bountifulfares";
    public static final boolean bf = ModList.get().isLoaded(BF);
    public static final String CR  = "collectorsreap";
    public static final boolean cr = ModList.get().isLoaded(CR);
    public static final String COS = "cookielicious";
    public static final boolean cos = ModList.get().isLoaded(COS);
    public static final String BAC = "brewinandchewin";
    public static final boolean bnc = ModList.get().isLoaded(BAC);
    public static final String BG  = "berry_good";
    public static final boolean bg = ModList.get().isLoaded(BG);
    public static final String BOP  = "biomesoplenty";
    public static final boolean bop = ModList.get().isLoaded(BOP);
    public static final String DF  = "delightful";
    public static final boolean df = ModList.get().isLoaded(DF);
    public static final String EX  = "exquisito";
    public static final boolean ex = ModList.get().isLoaded(EX);
    public static final String EE  = "enlightened_end";
    public static final boolean ee = ModList.get().isLoaded(EE);
    public static final String EN  = "environmental";
    public static final boolean en = ModList.get().isLoaded(EN);
    public static final String EL  = "enigmaticlegacy";
    public static final boolean el = ModList.get().isLoaded(EL);
    public static final String ES  = "eclipticseasons";
    public static final boolean es = ModList.get().isLoaded(ES);
    public static final String CAD = "casualness_delight";
    public static final boolean cad = ModList.get().isLoaded(CAD);
    public static final String FCD = "frycooks_delight";
    public static final boolean fcd = ModList.get().isLoaded(FCD);
    public static final String FD  = "farmersdelight";
    public static final boolean fd = ModList.get().isLoaded(FD);
    public static final String FR  = "farmersrespite";
    public static final boolean fr = ModList.get().isLoaded(FR);
    public static final String HA  = "habitat";
    public static final boolean ha = ModList.get().isLoaded(HA);
    public static final String KK  = "kitchenkarrot";
    public static final boolean kk = ModList.get().isLoaded(KK);
    public static final String MB = "manors_bounty";
    public static final boolean mb = ModList.get().isLoaded(MB);
    public static final String MD = "miners_delight";
    public static final boolean md = ModList.get().isLoaded(MD);
    public static final String NEA = "neapolitan";
    public static final boolean nea = ModList.get().isLoaded(NEA);
    public static final String PEC = "peculiars";
    public static final boolean pec = ModList.get().isLoaded(PEC);
    public static final String QUA = "quark";
    public static final boolean qua = ModList.get().isLoaded(QUA);
    public static final String TF  = "twilightforest";
    public static final boolean tf = ModList.get().isLoaded(TF);
    public static final String TFD = "twilightdelight";
    public static final boolean tfd = ModList.get().isLoaded(TFD);;
    public static final String RF = "respiteful";
    public static final boolean rf = ModList.get().isLoaded(RF);
    public static final String SD = "seeddelight";
    public static final boolean sd = ModList.get().isLoaded(SD);
    public static final String SEA = "seasonals";
    public static final boolean sea = ModList.get().isLoaded(SEA);
    public static final String SS = "sereneseasons";
    public static final boolean ss = ModList.get().isLoaded(SS);
    public static final String SUD = "sunflowerdelight";
    public static final boolean sud = ModList.get().isLoaded(SUD);
    public static final String SUP = "supplementaries";
    public static final boolean sup = ModList.get().isLoaded(SUP);
    public static final String UG  = "undergarden";
    public static final boolean ug = ModList.get().isLoaded(UG);
    public static final String VC  = "vanillacookbook";
    public static final boolean vc = ModList.get().isLoaded(VC);

    //ars_nouveau
    public static final MobEffect MANA_REGEN = an ? modEffect(AN, "mana_regen") : CosmoEffects.PLACEHOLDER.get();
    public static final MobEffect RECOVERY = an ? modEffect(AN, "recovery") : CosmoEffects.PLACEHOLDER.get();
    public static final MobEffect BLAST = an ? modEffect(AN, "blasting") : CosmoEffects.PLACEHOLDER.get();
    public static final MobEffect FREEZING = an ? modEffect(AN, "freezing") : CosmoEffects.PLACEHOLDER.get();
    public static final MobEffect DEFENCE = an ? modEffect(AN, "shielding") : CosmoEffects.PLACEHOLDER.get();
    public static final MobEffect SPELL_DAMAGE = an ? modEffect(AN, "spell_damage") : CosmoEffects.PLACEHOLDER.get();
    public static Item SOURCEBERRY = modItem(AN, "sourceberry_bush");
    public static Item BASTION_POD = modItem(AN, "bastion_pod");
    public static Item BOMBEGRANATE_POD = modItem(AN, "bombegranate_pod");
    public static Item FROSTAYA_POD = modItem(AN, "frostaya_pod");
    public static Item MENDOSTEEN_POD = modItem(AN, "mendosteen_pod");
    public static Block SOURCE_BERRY_BLOCK = an ? modBlock(AN, "sourceberry_bush") : CosmoBlocks.PLACEHOLDER.get();

    //atmospheric
    public static final MobEffect PERSISTENCE = at ? (AtmosphericMobEffects.PERSISTENCE.get()) : CosmoEffects.PLACEHOLDER.get();
    public static final MobEffect RELIEF = at ? (AtmosphericMobEffects.RELIEF.get()) : CosmoEffects.PLACEHOLDER.get();
    public static final MobEffect SPITTING = at ? (AtmosphericMobEffects.SPITTING.get()) : CosmoEffects.PLACEHOLDER.get();

    //collectorsreap
    public static final MobEffect CORROSION = cr ? (CREffects.CORROSION.get()) : CosmoEffects.PLACEHOLDER.get();
    public static final MobEffect LIME = cr ? (CREffects.CORROSION.get()) : MobEffects.DIG_SPEED;
    public static final MobEffect VOLATILITY = cr ? (CREffects.VOLATILITY.get()) : CosmoEffects.PLACEHOLDER.get();
    public static final MobEffect POMEGRANATE = cr ? (CREffects.VOLATILITY.get()) : MobEffects.DAMAGE_BOOST;
    public static final MobEffect SURGE = cr ? (CREffects.SURGE.get()) : CosmoEffects.PLACEHOLDER.get();
    public static final MobEffect PINK_PITAYA = cr ? (CREffects.SURGE.get()) : MobEffects.FIRE_RESISTANCE;
    public static final MobEffect REBOUND = cr ? (CREffects.REBOUND.get()) : CosmoEffects.PLACEHOLDER.get();
    public static RegistryObject<Item> LIME_POPSICLE = cr ? CRItems.LIME_POPSICLE : CosmoItems.BERRY_POPSICLE;

    //farmersdelight
    public static final MobEffect COMFORT = fd ? (ModEffects.COMFORT.get()) : CosmoEffects.PLACEHOLDER.get();
    public static final MobEffect NOURISHMENT = fd ? (ModEffects.NOURISHMENT.get()) : CosmoEffects.PLACEHOLDER.get();
    public static final MobEffectInstance COMFORT_STEW = fd ? new MobEffectInstance(ModEffects.COMFORT.get(), 6000) : new MobEffectInstance(MobEffects.REGENERATION, 100);

    public static Item COPPER_CUP = md ? ForgeRegistries.ITEMS.getValue(new ResourceLocation(CosmoCompat.MD, "copper_cup")) : Items.BOWL;
    public static FoodProperties CUP (FoodProperties food) {
        return md ? MDFoodValues.cupFoodProperties(food) : Foods.APPLE;
    }

    //b&c
    public static Item TANKARD = bnc ? BnCItems.TANKARD.get() : Items.GLASS_BOTTLE;
    public static final MobEffect TIPSY = bnc ? (BnCEffects.TIPSY.get()) : CosmoEffects.PLACEHOLDER.get();
    public static final MobEffect INTOXICATION = bnc ? (BnCEffects.INTOXICATION.get()) : CosmoEffects.PLACEHOLDER.get();

    //habitat
    public static final MobEffect BLAST_ENDURANCE = ha ? (HabitatEffects.BLAST_ENDURANCE.get()) : CosmoEffects.PLACEHOLDER.get();
    public static Item KABLOOM = modItem(HA, "kabloom_pulp");
    public static Block KABLOOM_BLOCK = ha ? modBlock(HA, "kabloom_bush") : CosmoBlocks.PLACEHOLDER.get();

    //neapolitan
    public static final MobEffect AGILITY = nea ? (NeapolitanMobEffects.AGILITY.get()) : CosmoEffects.PLACEHOLDER.get();
    public static final MobEffect BANANA = nea ? (NeapolitanMobEffects.AGILITY.get()) : MobEffects.JUMP;
    public static final MobEffect BERSERKING = nea ? (NeapolitanMobEffects.BERSERKING.get()) : CosmoEffects.PLACEHOLDER.get();
    public static final MobEffect HARMONY = nea ? (NeapolitanMobEffects.HARMONY.get()) : CosmoEffects.PLACEHOLDER.get();
    public static final MobEffect SUGAR_RUSH = nea ? (NeapolitanMobEffects.SUGAR_RUSH.get()) : CosmoEffects.PLACEHOLDER.get();
    public static final MobEffect VANILLA_SCENT = nea ? (NeapolitanMobEffects.VANILLA_SCENT.get()) : CosmoEffects.PLACEHOLDER.get();




    //respiteful
    public static final MobEffect VITALITY = rf ? modEffect(RF, "vitality") : CosmoEffects.PLACEHOLDER.get();
    public static final MobEffect TENACITY = rf ? modEffect(RF, "tenacity") : CosmoEffects.PLACEHOLDER.get();
    public static final MobEffect MATURITY = rf ? modEffect(RF, "maturity") : CosmoEffects.PLACEHOLDER.get();
    public static final MobEffect CAFFEINATED = rf ? FREffects.CAFFEINATED.get() : CosmoEffects.PLACEHOLDER.get();

    public static Item GREEN_TEA_ICE_CREAM = modItem(RF, "green_tea_ice_cream");
    public static Item YELLOW_TEA_ICE_CREAM = modItem(RF, "yellow_tea_ice_cream");
    public static Item BLACK_TEA_ICE_CREAM = modItem(RF, "black_tea_ice_cream");
    public static Item COFFEE_ICE_CREAM = modItem(RF, "coffee_ice_cream");

    //exquisito
    public static final MobEffect RESONANCE = ex ? (ExquisitoEffects.RESONANCE.get()) : CosmoEffects.PLACEHOLDER.get();
    public static final MobEffect CHORUS_FRUIT = ex ? (ExquisitoEffects.RESONANCE.get()) : MobEffects.SLOW_FALLING;
    public static final MobEffect MODULATION = ex ? (ExquisitoEffects.MODULATION.get()) : CosmoEffects.PLACEHOLDER.get();
    public static final MobEffect FUCHSIA_GOO = ex ? (ExquisitoEffects.FUCHSIA_GOO.get()) : CosmoEffects.PLACEHOLDER.get();
    public static final MobEffect SPACE_DIVING = ex ? (ExquisitoEffects.SPACE_DIVING.get()) : CosmoEffects.PLACEHOLDER.get();
    public static final MobEffect EARENDEL = ex ? (ExquisitoEffects.EARENDEL.get()) : CosmoEffects.PLACEHOLDER.get();
    public static final MobEffect MORGOTH = ex ? (ExquisitoEffects.MORGOTH.get()) : CosmoEffects.PLACEHOLDER.get();

    //seasonals
    public static final MobEffect ROOTED = sea ? (SeasonalsMobEffects.ROOTED.get()) : CosmoEffects.PLACEHOLDER.get();
    public static final MobEffect BEETROOT = sea ? (SeasonalsMobEffects.ROOTED.get()) : CosmoEffects.INGRAINED.get();
    public static final MobEffect STUFFED = sea ? (SeasonalsMobEffects.STUFFED.get()) : CosmoEffects.PLACEHOLDER.get();
    public static final MobEffect THORN_RESISTANCE_ICE_CREAM = sea ? (SeasonalsMobEffects.THORN_RESISTANCE.get()) : CosmoEffects.PLACEHOLDER.get();
    public static final MobEffect THORN_RESISTANCE = sea ? (SeasonalsMobEffects.THORN_RESISTANCE.get()) : MobEffects.REGENERATION;

    //twilight_delight
    public static MobEffect AURORA = tfd ? modEffect(TFD, "aurora_glowing"): MobEffects.MOVEMENT_SPEED;
    public static MobEffect FIRE_RANGE = tfd ? modEffect(TFD, "fire_range"): MobEffects.GLOWING;
    public static MobEffect POISON_RANGE = tfd ? modEffect(TFD, "poison_range"): MobEffects.DAMAGE_BOOST;
    public static MobEffect FROZEN_RANGE = tfd ? modEffect(TFD, "frozen_range"): MobEffects.FIRE_RESISTANCE;

    public static Item AURORA_ICE_CREAM = modItem(TFD, "aurora_ice_cream");
    public static Item AURORA_MILKSHAKE = modItem(TFD, "aurora_milkshake");
    public static Item GLACIER_ICE_CREAM = modItem(TFD, "glacier_ice_cream");
    public static Item GLACIER_MILKSHAKE = modItem(TFD, "glacier_milkshake");
    public static Item PHYTOCHEMICAL_ICE_CREAM = modItem(TFD, "phytochemical_ice_cream");
    public static Item PHYTOCHEMICAL_MILKSHAKE = modItem(TFD, "phytochemical_milkshake");
    public static Item TORCHBERRY_ICE_CREAM = modItem(TFD, "torchberry_ice_cream");
    public static Item TORCHBERRY_MILKSHAKE = modItem(TFD, "torchberry_milkshake");

    //sunflowerdelight
    public static MobEffect PURE_MIND = sud ? modEffect(SUD, "pure_mind"): CosmoEffects.PLACEHOLDER.get();

    //undergarden
    public static Item BLISTERBERRY = modItem(UG, "blisterberry");
    public static Item UNDERBEANS = modItem(UG, "underbeans");
    public static Item DROOPFRUIT = modItem(UG, "droopvine_item");
    public static Block BLISTERBERRY_BUSH = ug ? modBlock(UG, "blisterberry_bush") : CosmoBlocks.PLACEHOLDER.get();
    public static Block UNDERBEAN_BUSH = ug ? modBlock(UG, "underbean_bush") : CosmoBlocks.PLACEHOLDER.get();
    public static Block DROOP_VINE = ug ? UGBlocks.DROOPVINE.get() : CosmoBlocks.PLACEHOLDER.get();

    public static boolean isTagEmpty(TagKey<Item> tagKey) {
        return BuiltInRegistries.ITEM.getTag(tagKey).map(tag -> tag.size() == 0).orElse(true);
    }

    public static Block modBlock(String modid, String path) {
        return ForgeRegistries.BLOCKS.getValue(id(modid, path));
    }

    public static Item modItem(String modid, String path) {
        return ForgeRegistries.ITEMS.getValue(id(modid, path));
    }

    public static MobEffect modEffect(String modid, String path) {
        return ForgeRegistries.MOB_EFFECTS.getValue(id(modid, path));
    }
    
    public static ResourceLocation id(String modid, String path) {
        return new ResourceLocation(modid, path);
    }
    
}


package com.gumillea.cosmopolitan.core.util;

import com.cosmicgelatin.seasonals.core.registry.SeasonalsMobEffects;
import com.gumillea.cosmopolitan.core.reg.CosmoBlocks;
import com.gumillea.cosmopolitan.core.reg.CosmoEffects;
import com.gumillea.cosmopolitan.core.reg.CosmoItems;
import com.gumillea.exquisito.core.reg.ExquisitoEffects;
import com.teamabnormals.atmospheric.core.registry.AtmosphericMobEffects;
import com.teamabnormals.neapolitan.core.registry.NeapolitanMobEffects;
import mod.schnappdragon.habitat.core.registry.HabitatEffects;
import net.brdle.collectorsreap.common.effect.CREffects;
import net.brdle.collectorsreap.common.item.CRItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
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
    public static final String AC  = "alexscaves";
    public static final boolean ac = ModList.get().isLoaded(AC);
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
    public static final String FRD  = "frightsdelight";
    public static final boolean frd = ModList.get().isLoaded(FRD);
    public static final String GD  = "gardens_of_the_dead";
    public static final boolean gd = ModList.get().isLoaded(GD);
    public static final String HA  = "habitat";
    public static final boolean ha = ModList.get().isLoaded(HA);
    public static final String JA  = "netherexp";
    public static final boolean ja = ModList.get().isLoaded(JA);
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
    public static final String SMC = "smc";
    public static final boolean smc = ModList.get().isLoaded(SMC);
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
    public static final String WS  = "windswept";
    public static final boolean ws = ModList.get().isLoaded(WS);
    public static final String WD  = "windswept_delights";
    public static final boolean wd = ModList.get().isLoaded(WD);
    public static final String YH  = "youkaishomecoming";
    public static final boolean yh = ModList.get().isLoaded(YH);

    //alexscaves
    public static final MobEffect MAGNETIZING = ac ? modEffect(AC, "magnetizing") : CosmoEffects.PLACEHOLDER.get();
    public static final MobEffect RAGE = ac ? modEffect(AC, "rage") : CosmoEffects.PLACEHOLDER.get();
    public static final MobEffect DARKNESS_INCARNATE = ac ? modEffect(AC, "darkness_incarnate") : CosmoEffects.PLACEHOLDER.get();
    public static final MobEffect SUGAR_RUSH_ALEX = ac ? modEffect(AC, "sugar_rush") : CosmoEffects.PLACEHOLDER.get();
    public static final MobEffect DEEPSIGHT = ac ? modEffect(AC, "deepsight") : CosmoEffects.PLACEHOLDER.get();
    public static final MobEffect IRRADIATED = ac ? modEffect(AC, "irradiated") : CosmoEffects.PLACEHOLDER.get();

    public static Item TREE_STAR = modItem(AC, "tree_star");
    public static Item PINE_NUTS = modItem(AC, "pine_nuts");

    public static Item SULFUR_DUST = modItem(AC, "sulfur_dust");
    public static Item GREEN_SOYLENT = modItem(AC, "green_soylent");

    public static Item RAW_AZURE_NEODYMIUM = modItem(AC, "raw_azure_neodymium");
    public static Item RAW_SCARLET_NEODYMIUM = modItem(AC, "raw_scarlet_neodymium");

    public static Item PURE_DARKNESS = modItem(AC, "pure_darkness");
    public static Item MOTH_DUST = modItem(AC, "moth_dust");

    public static Item CARAMEL = modItem(AC, "caramel");
    public static Item CANDY_CANE = modItem(AC, "candy_cane");

    public static Item LANTERNFISH = modItem(AC, "lanternfish");
    public static Item BIOLUMINESSCENCE = modItem(AC, "bioluminesscence");

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
    public static final MobEffect NOURISHMENT = fd ? (ModEffects.NOURISHMENT.get()) : CosmoEffects.PLACEHOLDER.get();
    public static final MobEffect COMFORT = modEffect(FD, "comfort");
    public static Item COPPER_CUP = md ? ForgeRegistries.ITEMS.getValue(new ResourceLocation(CosmoCompat.MD, "copper_cup")) : Items.BOWL;

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
    public static final MobEffect CHOCOLATE = nea ? (NeapolitanMobEffects.SUGAR_RUSH.get()) : MobEffects.MOVEMENT_SPEED;
    public static final MobEffect VANILLA_SCENT = nea ? (NeapolitanMobEffects.VANILLA_SCENT.get()) : CosmoEffects.PLACEHOLDER.get();

    //respiteful
    public static final MobEffect VITALITY = rf ? modEffect(RF, "vitality") : CosmoEffects.PLACEHOLDER.get();
    public static final MobEffect TENACITY = rf ? modEffect(RF, "tenacity") : CosmoEffects.PLACEHOLDER.get();
    public static final MobEffect MATURITY = rf ? modEffect(RF, "maturity") : CosmoEffects.PLACEHOLDER.get();
    public static final MobEffect CAFFEINATED = fr ? FREffects.CAFFEINATED.get() : MobEffects.MOVEMENT_SPEED;
    public static final MobEffect CAFFEINATED_ICE_CREAM = rf ? FREffects.CAFFEINATED.get() : CosmoEffects.PLACEHOLDER.get();

    public static int CAFFEINATED_DURATION (int i) {
        return fr ? i : i / 3;
    }

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
    public static final MobEffect SWEET_BERRIES = sea ? (SeasonalsMobEffects.THORN_RESISTANCE.get()) : MobEffects.HEALTH_BOOST;

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
    public static Item TORCHBERRIES = modItem(TF, "torchberries");
    public static Item TORCHBERRY_ICE_CREAM = modItem(TFD, "torchberry_ice_cream");
    public static Item TORCHBERRY_MILKSHAKE = modItem(TFD, "torchberry_milkshake");

    //vintagedelight
    public static Item GEARO_BERRY = modItem("vintagedelight", "gearo_berry");

    //frightsdelight
    public static Item SOUL_BERRY = modItem(FRD, "soul_berry");
    public static Item WITHER_BERRY = modItem(FRD, "wither_berry");

    //windswept
    public static Item HOLLY_BERRIES = modItem(WS, "holly_berries");
    public static Item WILD_BERRIES = modItem(WS, "wild_berries");
    public static Item PINECONE = modItem(WS, "pinecone");
    public static Item MIMOSA = modItem(WS, "mimosa");

    public static MobEffect FROST_RESISTANCE = ws ? modEffect(WS, "frost_resistance"): CosmoEffects.PLACEHOLDER.get();
    public static MobEffect THORNS = ws ? modEffect(WS, "thorns"): CosmoEffects.PLACEHOLDER.get();

    //sunflowerdelight
    public static MobEffect PURE_MIND = sud ? modEffect(SUD, "pure_mind"): CosmoEffects.PLACEHOLDER.get();

    //smc
    public static Item BROCCOLI = modItem(SMC, "broccoli");
    public static Item FROST_BERRIES = modItem(SMC, "frost_berries");
    public static Item RAINBOW_CHIP = modItem(SMC, "rainbow_chip");
    public static Item STAR_DUST = modItem(SMC, "star_dust");

    public static Item SMC_ICE_CREAM = modItem(SMC, "smc_ice_cream");
    public static Item ASTERA_ICE_CREAM = modItem(SMC, "astera_ice_cream");
    public static Item ASTERA_MILKSHAKE = modItem(SMC, "astera_milkshake");
    public static Item BROCCOLI_ICE_CREAM = modItem(SMC, "broccoli_ice_cream");
    public static Item BROCCOLI_MILKSHAKE = modItem(SMC, "broccoli_milkshake");
    public static Item FROST_ICE_CREAM = modItem(SMC, "frost_ice_cream");
    public static Item FROST_MILKSHAKE = modItem(SMC, "frost_milkshake");
    public static Item RAINBOW_ICE_CREAM = modItem(SMC, "rainbow_ice_cream");
    public static Item RAINBOW_MILKSHAKE = modItem(SMC, "rainbow_milkshake");

    public static MobEffect FROST_RESISTANCE_SMC = smc ? modEffect(SMC, "frost_resistance"): CosmoEffects.PLACEHOLDER.get();
    public static MobEffect POISON_RESISTANCE = smc ? modEffect(SMC, "poison_resistance"): CosmoEffects.PLACEHOLDER.get();
    public static MobEffect STAR_LIGHT = smc ? modEffect(SMC, "star_light"): CosmoEffects.PLACEHOLDER.get();
    public static MobEffect RAINBOW = smc ? modEffect(SMC, "rainbow"): CosmoEffects.PLACEHOLDER.get();

    public static MobEffect FRESH_COOL = smc ? modEffect(SMC, "fresh_cool"): MobEffects.NIGHT_VISION;
    public static MobEffect FEVER_SPICY = smc ? modEffect(SMC, "fever_spicy"): MobEffects.DIG_SPEED;
    public static MobEffect PEACE = smc ? modEffect(SMC, "peace"): MobEffects.WATER_BREATHING;

    //undergarden
    public static Item BLISTERBERRY = modItem(UG, "blisterberry");
    public static Item UNDERBEANS = modItem(UG, "underbeans");
    public static Item DROOPFRUIT = modItem(UG, "droopvine_item");
    public static Block BLISTERBERRY_BUSH = ug ? modBlock(UG, "blisterberry_bush") : CosmoBlocks.PLACEHOLDER.get();
    public static Block UNDERBEAN_BUSH = ug ? modBlock(UG, "underbean_bush") : CosmoBlocks.PLACEHOLDER.get();
    public static Block DROOP_VINE = ug ? UGBlocks.DROOPVINE.get() : CosmoBlocks.PLACEHOLDER.get();

    //youkaishomecoming
    public static MobEffect TEA_POLYPHENOLS = yh ? modEffect(YH, "tea_polyphenols"): MobEffects.DIG_SPEED;

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


package com.gumillea.cosmopolitan.core.reg;

import com.gumillea.cosmopolitan.Cosmopolitan;
import com.gumillea.cosmopolitan.common.block.*;
import com.teamabnormals.blueprint.common.block.BlueprintDirectionalBlock;
import com.teamabnormals.blueprint.core.util.registry.BlockSubRegistryHelper;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = Cosmopolitan.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CosmoBlocks {
    public static final BlockSubRegistryHelper HELPER = Cosmopolitan.REGISTRY_HELPER.getBlockSubHelper();

    public static final RegistryObject<Block> PLACEHOLDER = HELPER.createBlock("placeholder", () -> new AirBlock(BlockBehaviour.Properties.copy(Blocks.AIR)));

    //Placeable
    public static final RegistryObject<Block> WATER_PIE = HELPER.createBlockNoItem("water_pie_block", () -> new FDPieBlock(BlockBehaviour.Properties.copy(Blocks.CAKE), CosmoItems.WATER_PIE_SLICE));
    public static final RegistryObject<Block> SHOOFLY_PIE = HELPER.createBlockNoItem("shoofly_pie_block", () -> new FDPieBlock(BlockBehaviour.Properties.copy(Blocks.CAKE), CosmoItems.SHOOFLY_PIE_SLICE));
    public static final RegistryObject<Block> MOSS_PIE = HELPER.createBlockNoItem("moss_pie_block", () -> new FDPieBlock(BlockBehaviour.Properties.copy(Blocks.CAKE), CosmoItems.MOSS_PIE_SLICE));

    public static final RegistryObject<Block> GLOW_BERRY_CUBECAKE = HELPER.createBlockNoItem("glow_berry_cubecake_block", () -> new CubecakeBlock(BlockBehaviour.Properties.copy(Blocks.CAKE), CosmoItems.GLOW_BERRY_CUBECAKE));
    public static final RegistryObject<Block> WHEATGRASS_CUBECAKE = HELPER.createBlockNoItem("wheatgrass_cubecake_block", () -> new CubecakeBlock(BlockBehaviour.Properties.copy(Blocks.CAKE), CosmoItems.WHEATGRASS_CUBECAKE));
    public static final RegistryObject<Block> CHORUS_FRUIT_CUBECAKE = HELPER.createBlockNoItem("chorus_fruit_cubecake_block", () -> new CubecakeBlock(BlockBehaviour.Properties.copy(Blocks.CAKE), CosmoItems.CHORUS_FRUIT_CUBECAKE));
    public static final RegistryObject<Block> WARPED_VELVET_CUBECAKE = HELPER.createBlockNoItem("warped_velvet_cubecake_block", () -> new CubecakeBlock(BlockBehaviour.Properties.copy(Blocks.CAKE), CosmoItems.WARPED_VELVET_CUBECAKE));

    public static final RegistryObject<Block> JELLY_ROLL = HELPER.createBlockNoItem("jelly_roll_block", () -> new RollCakeBlock(BlockBehaviour.Properties.copy(Blocks.CAKE), CosmoItems.JELLY_ROLL_SLICE));
    public static final RegistryObject<Block> CHOCOLATE_ROLL = HELPER.createBlockNoItem("chocolate_roll_block", () -> new RollCakeBlock(BlockBehaviour.Properties.copy(Blocks.CAKE), CosmoItems.CHOCOLATE_ROLL_SLICE));
    public static final RegistryObject<Block> INK_ROLL = HELPER.createBlockNoItem("ink_roll_block", () -> new RollCakeBlock(BlockBehaviour.Properties.copy(Blocks.CAKE), CosmoItems.INK_ROLL_SLICE));
    public static final RegistryObject<Block> YULE_LOG = HELPER.createBlockNoItem("yule_log_block", () -> new RollCakeBlock(BlockBehaviour.Properties.copy(Blocks.CAKE), CosmoItems.YULE_LOG_SLICE));

    //Milkshake
    public static final RegistryObject<Block> APPLE_MILKSHAKE_CAULDRON = HELPER.createBlockNoItem("apple_milkshake_cauldron", () -> new CosmoMilkshakeCauldronBlock(CosmoCauldronInteractions.APPLE_MILKSHAKE.map()));
    public static final RegistryObject<Block> CARROT_MILKSHAKE_CAULDRON = HELPER.createBlockNoItem("carrot_milkshake_cauldron", () -> new CosmoMilkshakeCauldronBlock(CosmoCauldronInteractions.CARROT_MILKSHAKE.map()));
    public static final RegistryObject<Block> GLOW_BERRY_MILKSHAKE_CAULDRON = HELPER.createBlockNoItem("glow_berry_milkshake_cauldron", () -> new CosmoMilkshakeCauldronBlock(CosmoCauldronInteractions.GLOW_BERRY_MILKSHAKE.map()));
    public static final RegistryObject<Block> ENCHANTED_FRUIT_MILKSHAKE_CAULDRON = HELPER.createBlockNoItem("enchanted_fruit_milkshake_cauldron", () -> new CosmoMilkshakeCauldronBlock(CosmoCauldronInteractions.ENCHANTED_FRUIT_MILKSHAKE.map()));
    public static final RegistryObject<Block> KABLOOM_MILKSHAKE_CAULDRON = HELPER.createBlockNoItem("kabloom_milkshake_cauldron", () -> new CosmoMilkshakeCauldronBlock(CosmoCauldronInteractions.KABLOOM_MILKSHAKE.map()));
    public static final RegistryObject<Block> SOURCE_BERRY_MILKSHAKE_CAULDRON = HELPER.createBlockNoItem("source_berry_milkshake_cauldron", () -> new CosmoMilkshakeCauldronBlock(CosmoCauldronInteractions.SOURCE_BERRY_MILKSHAKE.map()));

    //Crops
    public static final RegistryObject<Block> POTTED_WILDBERRY_BUSH = HELPER.createBlockNoItem("potted_wildberry_bush", () -> new PottedCropBlock(BlockBehaviour.Properties.copy(Blocks.POTTED_AZALEA), CosmoItems.WILDBERRY));
    public static final RegistryObject<Block> POTTED_FIDDLEHEAD_GREENS = HELPER.createBlockNoItem("potted_fiddlehead_greens", () -> new PottedCropBlock(BlockBehaviour.Properties.copy(Blocks.POTTED_AZALEA), CosmoItems.FIDDLEHEAD));

    //Ice Cream Tubs//
    public static final RegistryObject<Block> COPPER_FROZEN_DESSERT_TUB = HELPER.createBlock("copper_frozen_dessert_tub", () -> new FrozenDessertTubBlock(BlockBehaviour.Properties.copy(Blocks.COPPER_BLOCK)));
    public static final RegistryObject<Block> IRON_FROZEN_DESSERT_TUB = HELPER.createBlock("frozen_dessert_tub", () -> new FrozenDessertTubBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> NETHERITE_FROZEN_DESSERT_TUB = HELPER.createBlock("netherite_frozen_dessert_tub", () -> new FrozenDessertTubBlock(BlockBehaviour.Properties.copy(Blocks.NETHERITE_BLOCK)));

    //Cookie Tiles//
    public static final RegistryObject<Block> BIRCH_COOKIE_TILE = HELPER.createBlock("birch_cookie_tiles", () -> new Block(Properties.BIRCH_COOKIE));
    public static final RegistryObject<Block> BIRCH_COOKIE_TILE_SLAB = HELPER.createBlock("birch_cookie_tile_slab", () -> new SlabBlock(Properties.BIRCH_COOKIE));
    public static final RegistryObject<Block> BIRCH_COOKIE_TILE_STAIRS = HELPER.createBlock("birch_cookie_tile_stairs", () -> new StairBlock(() -> BIRCH_COOKIE_TILE.get().defaultBlockState(), Properties.BIRCH_COOKIE));
    public static final RegistryObject<Block> BIRCH_COOKIE_TILE_WALL = HELPER.createBlock("birch_cookie_tile_wall", () -> new WallBlock(Properties.BIRCH_COOKIE));

    public static final RegistryObject<Block> HERBAL_COOKIE_TILE = HELPER.createBlock("herbal_cookie_tiles", () -> new Block(Properties.HERBAL_COOKIE));
    public static final RegistryObject<Block> HERBAL_COOKIE_TILE_SLAB = HELPER.createBlock("herbal_cookie_tile_slab", () -> new SlabBlock(Properties.HERBAL_COOKIE));
    public static final RegistryObject<Block> HERBAL_COOKIE_TILE_STAIRS = HELPER.createBlock("herbal_cookie_tile_stairs", () -> new StairBlock(() -> HERBAL_COOKIE_TILE.get().defaultBlockState(), Properties.HERBAL_COOKIE));
    public static final RegistryObject<Block> HERBAL_COOKIE_TILE_WALL = HELPER.createBlock("herbal_cookie_tile_wall", () -> new WallBlock(Properties.HERBAL_COOKIE));

    public static final RegistryObject<Block> PAW_COOKIE_TILE = HELPER.createBlock("paw_cookie_tiles", () -> new Block(Properties.PAW_COOKIE));
    public static final RegistryObject<Block> PAW_COOKIE_TILE_SLAB = HELPER.createBlock("paw_cookie_tile_slab", () -> new SlabBlock(Properties.PAW_COOKIE));
    public static final RegistryObject<Block> PAW_COOKIE_TILE_STAIRS = HELPER.createBlock("paw_cookie_tile_stairs", () -> new StairBlock(() -> PAW_COOKIE_TILE.get().defaultBlockState(), Properties.PAW_COOKIE));
    public static final RegistryObject<Block> PAW_COOKIE_TILE_WALL = HELPER.createBlock("paw_cookie_tile_wall", () -> new WallBlock(Properties.PAW_COOKIE));

    //Ice Cream Bricks
    public static final RegistryObject<Block> ADZUKI_ICE_CREAM_BRICKS = HELPER.createBlock("adzuki_ice_cream_bricks", () -> new Block(Properties.ADZUKI_ICE_CREAM_BLOCK));
    public static final RegistryObject<Block> BANANA_ICE_CREAM_BRICKS = HELPER.createBlock("banana_ice_cream_bricks", () -> new Block(Properties.BANANA_ICE_CREAM_BLOCK));
    public static final RegistryObject<Block> CHOCOLATE_ICE_CREAM_BRICKS = HELPER.createBlock("chocolate_ice_cream_bricks", () -> new Block(Properties.CHOCOLATE_ICE_CREAM_BLOCK));
    public static final RegistryObject<Block> MINT_ICE_CREAM_BRICKS = HELPER.createBlock("mint_ice_cream_bricks", () -> new Block(Properties.MINT_ICE_CREAM_BLOCK));
    public static final RegistryObject<Block> STRAWBERRY_ICE_CREAM_BRICKS = HELPER.createBlock("strawberry_ice_cream_bricks", () -> new Block(Properties.STRAWBERRY_ICE_CREAM_BLOCK));
    public static final RegistryObject<Block> VANILLA_ICE_CREAM_BRICKS = HELPER.createBlock("vanilla_ice_cream_bricks", () -> new Block(Properties.VANILLA_ICE_CREAM_BLOCK));

    public static final RegistryObject<Block> APPLE_ICE_CREAM_BRICKS = HELPER.createBlock("apple_ice_cream_bricks", () -> new Block(Properties.APPLE_ICE_CREAM_BLOCK));
    public static final RegistryObject<Block> CARROT_ICE_CREAM_BRICKS = HELPER.createBlock("carrot_ice_cream_bricks", () -> new Block(Properties.CARROT_ICE_CREAM_BLOCK));
    public static final RegistryObject<Block> GLOW_BERRY_ICE_CREAM_BRICKS = HELPER.createBlock("glow_berry_ice_cream_bricks", () -> new Block(Properties.GLOW_BERRY_ICE_CREAM_BLOCK));

    public static final RegistryObject<Block> ENCHANTED_FRUIT_ICE_CREAM_BRICKS = HELPER.createBlock("enchanted_fruit_ice_cream_bricks", () -> new Block(Properties.ENCHANTED_FRUIT_ICE_CREAM_BLOCK));
    public static final RegistryObject<Block> SOURCE_BERRY_ICE_CREAM_BRICKS = HELPER.createBlock("source_berry_ice_cream_bricks", () -> new Block(Properties.SOURCE_BERRY_ICE_CREAM_BLOCK));
    public static final RegistryObject<Block> KABLOOM_ICE_CREAM_BRICKS = HELPER.createBlock("kabloom_ice_cream_bricks", () -> new Block(Properties.KABLOOM_ICE_CREAM_BLOCK));

    public static final RegistryObject<Block> BEETROOT_ICE_CREAM_BRICKS = HELPER.createBlock("beetroot_ice_cream_bricks", () -> new Block(Properties.BEETROOT_ICE_CREAM_BLOCK));
    public static final RegistryObject<Block> PUMPKIN_ICE_CREAM_BRICKS = HELPER.createBlock("pumpkin_ice_cream_bricks", () -> new Block(Properties.PUMPKIN_ICE_CREAM_BLOCK));
    public static final RegistryObject<Block> SWEET_BERRY_ICE_CREAM_BRICKS = HELPER.createBlock("sweet_berry_ice_cream_bricks", () -> new Block(Properties.SWEET_BERRY_ICE_CREAM_BLOCK));

    public static final RegistryObject<Block> ALOE_ICE_CREAM_BRICKS = HELPER.createBlock("aloe_ice_cream_bricks", () -> new Block(Properties.ALOE_ICE_CREAM_BLOCK));
    public static final RegistryObject<Block> PASSION_FRUIT_ICE_CREAM_BRICKS = HELPER.createBlock("passion_fruit_ice_cream_bricks", () -> new Block(Properties.PASSION_FRUIT_ICE_CREAM_BLOCK));
    public static final RegistryObject<Block> YUCCA_ICE_CREAM_BRICKS = HELPER.createBlock("yucca_ice_cream_bricks", () -> new Block(Properties.YUCCA_ICE_CREAM_BLOCK));

    public static final RegistryObject<Block> CHORUS_FRUIT_ICE_CREAM_BRICKS = HELPER.createBlock("chorus_fruit_ice_cream_bricks", () -> new Block(Properties.CHORUS_FRUIT_ICE_CREAM_BLOCK));
    public static final RegistryObject<Block> WARZIPAN_ICE_CREAM_BRICKS = HELPER.createBlock("warzipan_ice_cream_bricks", () -> new Block(Properties.WARZIPAN_ICE_CREAM_BLOCK));
    public static final RegistryObject<Block> JELLY_RING_ICE_CREAM_BRICKS = HELPER.createBlock("jelly_ring_ice_cream_bricks", () -> new Block(Properties.JELLY_RING_ICE_CREAM_BLOCK));
    public static final RegistryObject<Block> AZURE_BERRY_ICE_CREAM_BRICKS = HELPER.createBlock("azure_berry_ice_cream_bricks", () -> new Block(Properties.AZURE_BERRY_ICE_CREAM_BLOCK));
    public static final RegistryObject<Block> MIDNIGHT_ICE_CREAM_BRICKS = HELPER.createBlock("midnight_ice_cream_bricks", () -> new Block(Properties.MIDNIGHT_ICE_CREAM_BLOCK));
    public static final RegistryObject<Block> STARCLOUD_ICE_CREAM_BRICKS = HELPER.createBlock("starcloud_ice_cream_bricks", () -> new Block(Properties.STARCLOUD_ICE_CREAM_BLOCK));

    public static final RegistryObject<Block> GREEN_TEA_ICE_CREAM_BRICKS = HELPER.createBlock("green_tea_ice_cream_bricks", () -> new Block(Properties.GREEN_TEA_ICE_CREAM_BLOCK));
    public static final RegistryObject<Block> YELLOW_TEA_ICE_CREAM_BRICKS = HELPER.createBlock("yellow_tea_ice_cream_bricks", () -> new Block(Properties.YELLOW_TEA_ICE_CREAM_BLOCK));
    public static final RegistryObject<Block> BLACK_TEA_ICE_CREAM_BRICKS = HELPER.createBlock("black_tea_ice_cream_bricks", () -> new Block(Properties.BLACK_TEA_ICE_CREAM_BLOCK));
    public static final RegistryObject<Block> COFFEE_ICE_CREAM_BRICKS = HELPER.createBlock("coffee_ice_cream_bricks", () -> new Block(Properties.COFFEE_ICE_CREAM_BLOCK));

    public static final RegistryObject<Block> GLOWY_ICE_CREAM_BRICKS = HELPER.createBlock("glowy_ice_cream_bricks", () -> new Block(Properties.GLOWY_ICE_CREAM_BLOCK));
    public static final RegistryObject<Block> FLAVORED_ICE_CREAM_BRICKS = HELPER.createBlock("flavored_ice_cream_bricks", () -> new Block(Properties.FLAVORED_ICE_CREAM_BLOCK));

    public static final RegistryObject<Block> CHERRY_ICE_CREAM_BRICKS = HELPER.createBlock("cherry_ice_cream_bricks", () -> new Block(Properties.CHERRY_ICE_CREAM_BLOCK));

    public static final RegistryObject<Block> TORCHBERRY_ICE_CREAM_BRICKS = HELPER.createBlock("torchberry_ice_cream_bricks", () -> new Block(Properties.TORCHBERRY_ICE_CREAM_BLOCK));
    public static final RegistryObject<Block> PHYTOCHEMICAL_ICE_CREAM_BRICKS = HELPER.createBlock("phytochemical_ice_cream_bricks", () -> new Block(Properties.PHYTOCHEMICAL_ICE_CREAM_BLOCK));
    public static final RegistryObject<Block> GLACIER_ICE_CREAM_BRICKS = HELPER.createBlock("glacier_ice_cream_bricks", () -> new Block(Properties.GLACIER_ICE_CREAM_BLOCK));
    public static final RegistryObject<Block> AURORA_ICE_CREAM_BRICKS = HELPER.createBlock("aurora_ice_cream_bricks", () -> new Block(Properties.AURORA_ICE_CREAM_BLOCK));

    public static final RegistryObject<Block> SALMONBERRY_ICE_CREAM_BRICKS = HELPER.createBlock("salmonberry_ice_cream_bricks", () -> new Block(Properties.SALMONBERRY_ICE_CREAM_BLOCK));
    public static final RegistryObject<Block> MATCHA_ICE_CREAM_BRICKS = HELPER.createBlock("matcha_ice_cream_bricks", () -> new Block(Properties.MATCHA_ICE_CREAM_BLOCK));

    public static final RegistryObject<Block> POMEGRANATE_ICE_CREAM_BRICKS = HELPER.createBlock("pomegranate_ice_cream_bricks", () -> new Block(Properties.POMEGRANATE_ICE_CREAM_BLOCK));
    public static final RegistryObject<Block> LIME_ICE_CREAM_BRICKS = HELPER.createBlock("lime_ice_cream_bricks", () -> new Block(Properties.LIME_ICE_CREAM_BLOCK));
    public static final RegistryObject<Block> PINK_DRAGON_FRUIT_ICE_CREAM_BRICKS = HELPER.createBlock("pink_dragon_fruit_ice_cream_bricks", () -> new Block(Properties.PINK_DRAGON_FRUIT_ICE_CREAM_BLOCK));
    public static final RegistryObject<Block> LUCUMA_ICE_CREAM_BRICKS = HELPER.createBlock("lucuma_ice_cream_bricks", () -> new Block(Properties.LUCUMA_ICE_CREAM_BLOCK));

    public static final RegistryObject<Block> ASTERA_ICE_CREAM_BRICKS = HELPER.createBlock("astera_ice_cream_bricks", () -> new Block(Properties.ASTERA_ICE_CREAM_BLOCK));
    public static final RegistryObject<Block> BROCCOLI_ICE_CREAM_BRICKS = HELPER.createBlock("broccoli_ice_cream_bricks", () -> new Block(Properties.BROCCOLI_ICE_CREAM_BLOCK));
    public static final RegistryObject<Block> FROST_ICE_CREAM_BRICKS = HELPER.createBlock("frost_ice_cream_bricks", () -> new Block(Properties.FROST_ICE_CREAM_BLOCK));
    public static final RegistryObject<Block> RAINBOW_ICE_CREAM_BRICKS = HELPER.createBlock("rainbow_ice_cream_bricks", () -> new Block(Properties.RAINBOW_ICE_CREAM_BLOCK));

    //Chiseled Ice Cream Blocks
    public static final RegistryObject<Block> CHISELED_ADZUKI_ICE_CREAM_BLOCK = HELPER.createBlock("chiseled_adzuki_ice_cream_block", () -> new Block(Properties.ADZUKI_ICE_CREAM_BLOCK));
    public static final RegistryObject<Block> CHISELED_BANANA_ICE_CREAM_BLOCK = HELPER.createBlock("chiseled_banana_ice_cream_block", () -> new Block(Properties.BANANA_ICE_CREAM_BLOCK));
    public static final RegistryObject<Block> CHISELED_CHOCOLATE_ICE_CREAM_BLOCK = HELPER.createBlock("chiseled_chocolate_ice_cream_block", () -> new Block(Properties.CHOCOLATE_ICE_CREAM_BLOCK));
    public static final RegistryObject<Block> CHISELED_MINT_ICE_CREAM_BLOCK = HELPER.createBlock("chiseled_mint_ice_cream_block", () -> new Block(Properties.MINT_ICE_CREAM_BLOCK));
    public static final RegistryObject<Block> CHISELED_STRAWBERRY_ICE_CREAM_BLOCK = HELPER.createBlock("chiseled_strawberry_ice_cream_block", () -> new Block(Properties.STRAWBERRY_ICE_CREAM_BLOCK));
    public static final RegistryObject<Block> CHISELED_VANILLA_ICE_CREAM_BLOCK = HELPER.createBlock("chiseled_vanilla_ice_cream_block", () -> new Block(Properties.VANILLA_ICE_CREAM_BLOCK));

    //Ice Cream Blocks
    public static final RegistryObject<Block> APPLE_ICE_CREAM_BLOCK = HELPER.createBlock("apple_ice_cream_block", () -> new Block(Properties.APPLE_ICE_CREAM_BLOCK));
    public static final RegistryObject<Block> CARROT_ICE_CREAM_BLOCK = HELPER.createBlock("carrot_ice_cream_block", () -> new Block(Properties.CARROT_ICE_CREAM_BLOCK));
    public static final RegistryObject<Block> GLOW_BERRY_ICE_CREAM_BLOCK = HELPER.createBlock("glow_berry_ice_cream_block", () -> new Block(Properties.GLOW_BERRY_ICE_CREAM_BLOCK));

    public static final RegistryObject<Block> ENCHANTED_FRUIT_ICE_CREAM_BLOCK = HELPER.createBlock("enchanted_fruit_ice_cream_block", () -> new Block(Properties.ENCHANTED_FRUIT_ICE_CREAM_BLOCK));
    public static final RegistryObject<Block> KABLOOM_ICE_CREAM_BLOCK = HELPER.createBlock("kabloom_ice_cream_block", () -> new Block(Properties.KABLOOM_ICE_CREAM_BLOCK));
    public static final RegistryObject<Block> SOURCE_BERRY_ICE_CREAM_BLOCK = HELPER.createBlock("source_berry_ice_cream_block", () -> new Block(Properties.SOURCE_BERRY_ICE_CREAM_BLOCK));

    public static final RegistryObject<Block> CHERRY_ICE_CREAM_BLOCK = HELPER.createBlock("cherry_ice_cream_block", () -> new Block(Properties.CHERRY_ICE_CREAM_BLOCK));

    public static final RegistryObject<Block> TORCHBERRY_ICE_CREAM_BLOCK = HELPER.createBlock("torchberry_ice_cream_block", () -> new Block(Properties.TORCHBERRY_ICE_CREAM_BLOCK));
    public static final RegistryObject<Block> PHYTOCHEMICAL_ICE_CREAM_BLOCK = HELPER.createBlock("phytochemical_ice_cream_block", () -> new Block(Properties.PHYTOCHEMICAL_ICE_CREAM_BLOCK));
    public static final RegistryObject<Block> GLACIER_ICE_CREAM_BLOCK = HELPER.createBlock("glacier_ice_cream_block", () -> new Block(Properties.GLACIER_ICE_CREAM_BLOCK));
    public static final RegistryObject<Block> AURORA_ICE_CREAM_BLOCK = HELPER.createBlock("aurora_ice_cream_block", () -> new Block(Properties.AURORA_ICE_CREAM_BLOCK));

    public static final RegistryObject<Block> ASTERA_ICE_CREAM_BLOCK = HELPER.createBlock("astera_ice_cream_block", () -> new Block(Properties.ASTERA_ICE_CREAM_BLOCK));
    public static final RegistryObject<Block> BROCCOLI_ICE_CREAM_BLOCK = HELPER.createBlock("broccoli_ice_cream_block", () -> new Block(Properties.BROCCOLI_ICE_CREAM_BLOCK));
    public static final RegistryObject<Block> FROST_ICE_CREAM_BLOCK = HELPER.createBlock("frost_ice_cream_block", () -> new Block(Properties.FROST_ICE_CREAM_BLOCK));
    public static final RegistryObject<Block> RAINBOW_ICE_CREAM_BLOCK = HELPER.createBlock("rainbow_ice_cream_block", () -> new Block(Properties.RAINBOW_ICE_CREAM_BLOCK));


    //Storage Blocks
    public static final RegistryObject<Block> WHEATGRASS_BALE = HELPER.createBlock("wheatgrass_bale", () -> new HayBlock(BlockBehaviour.Properties.copy(Blocks.HAY_BLOCK)));
    public static final RegistryObject<Block> MASHED_POTATO_BLOCK = HELPER.createBlock("mashed_potato_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.SAND)));

    public static final RegistryObject<Block> WILDBERRIES_BASKET = HELPER.createBlock("wildberries_basket", () -> new BlueprintDirectionalBlock(Properties.WILDBERRY_BASKET));
    public static final RegistryObject<Block> ARBUTUS_BERRIES_BASKET = HELPER.createBlock("arbutus_berries_basket", () -> new BlueprintDirectionalBlock(Properties.WILDBERRY_BASKET));
    public static final RegistryObject<Block> GOLDEN_ARBUTUS_BERRIES_BASKET = HELPER.createBlock("golden_arbutus_berries_basket", () -> new BlueprintDirectionalBlock(Properties.GOLDEN_ARBUTUS_BERRIES_BASKET));

    public static final RegistryObject<Block> FIDDLEHEAD_CRATE = HELPER.createBlock("fiddlehead_crate", () -> new BlueprintDirectionalBlock(Properties.FIDDLEHEAD_CRATE));
    public static final RegistryObject<Block> IRON_FIDDLEHEAD_CRATE = HELPER.createBlock("iron_fiddlehead_crate", () -> new BlueprintDirectionalBlock(Properties.IRON_FIDDLEHEAD_CRATE));
    public static final RegistryObject<Block> TUBER_CRATE = HELPER.createBlock("tuber_crate", () -> new BlueprintDirectionalBlock(Properties.TUBER_CRATE));
    public static final RegistryObject<Block> WATTLESEED_SACK = HELPER.createBlock("wattleseed_sack", () -> new BlueprintDirectionalBlock(Properties.WATTLESEED_SACK));

    public static final RegistryObject<Block> SWEET_BERRY_SYRUP_BLOCK = HELPER.createBlock("berry_syrup_block", () -> new SyrupBlock(Properties.SWEET_BERRY_SYRUP_BLOCK));
    public static final RegistryObject<Block> SOUR_BERRY_SYRUP_BLOCK = HELPER.createBlock("sour_berry_syrup_block", () -> new SyrupBlock(Properties.SOUR_BERRY_SYRUP_BLOCK));
    public static final RegistryObject<Block> BITTER_BERRY_SYRUP_BLOCK = HELPER.createBlock("bitter_berry_syrup_block", () -> new SyrupBlock(Properties.BITTER_BERRY_SYRUP_BLOCK));
    public static final RegistryObject<Block> SPICY_BERRY_SYRUP_BLOCK = HELPER.createBlock("spicy_berry_syrup_block", () -> new SyrupBlock(Properties.SPICY_BERRY_SYRUP_BLOCK));
    public static final RegistryObject<Block> STRANGE_BERRY_SYRUP_BLOCK = HELPER.createBlock("strange_berry_syrup_block", () -> new SyrupBlock(Properties.STRANGE_BERRY_SYRUP_BLOCK));

    public static final RegistryObject<Block> BIRCH_SAP_BLOCK = HELPER.createBlock("birch_sap_block", () -> new SyrupBlock(Properties.BIRCH_SAP_BLOCK));
    public static final RegistryObject<Block> STEELEAF_NECTAR_BLOCK = HELPER.createBlock("steeleaf_nectar_block", () -> new SyrupBlock(Properties.STEELEAF_NECTAR_BLOCK));
    public static final RegistryObject<Block> MOLASSES_BLOCK = HELPER.createBlock("molasses_block", () -> new HoneyBlock(Properties.MOLASSES_BLOCK));

    //Others
    public static final RegistryObject<Block> EXHAUSTED_SHROOMLIGHT = HELPER.createBlock("exhausted_shroomlight", () -> new ExhaustedShroomlightBlock(BlockBehaviour.Properties.copy(Blocks.SHROOMLIGHT), Blocks.SHROOMLIGHT));
    public static final RegistryObject<Block> EXHAUSTED_SHROOMNIGHT = HELPER.createBlock("exhausted_shroomnight", () -> new ExhaustedShroomlightBlock(BlockBehaviour.Properties.copy(Blocks.SHROOMLIGHT), ExhaustedShroomlightBlock.SHROOMNIGHT));
    public static final RegistryObject<Block> EXHAUSTED_SHROOMBLIGHT = HELPER.createBlock("exhausted_shroomblight", () -> new ExhaustedShroomlightBlock(BlockBehaviour.Properties.copy(Blocks.SHROOMLIGHT), ExhaustedShroomlightBlock.SHROOMBLIGHT));
    public static final RegistryObject<Block> SAPPY_BIRCH_LOG = HELPER.createBlock("sappy_birch_log", () -> new SappyLogBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_LOG), Blocks.STRIPPED_BIRCH_LOG));
    public static final RegistryObject<Block> LIFELIGHT = HELPER.createBlock("lifelight", () -> new LifelightBlock(Properties.LIFELIGHT));
    public static final RegistryObject<Block> GLOW_PETALS = HELPER.createBlock("glow_petals", () -> new GlowPetalsBlock(Properties.LIFELIGHT));



    static class Properties {
        //Ice Cream Blocks
        public static final BlockBehaviour.Properties ADZUKI_ICE_CREAM_BLOCK = BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).instrument(NoteBlockInstrument.CHIME).strength(0.2F).sound(SoundType.SNOW);
        public static final BlockBehaviour.Properties BANANA_ICE_CREAM_BLOCK = BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).instrument(NoteBlockInstrument.CHIME).strength(0.2F).sound(SoundType.SNOW);
        public static final BlockBehaviour.Properties CHOCOLATE_ICE_CREAM_BLOCK = BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).instrument(NoteBlockInstrument.CHIME).strength(0.2F).sound(SoundType.SNOW);
        public static final BlockBehaviour.Properties MINT_ICE_CREAM_BLOCK = BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GREEN).instrument(NoteBlockInstrument.CHIME).strength(0.2F).sound(SoundType.SNOW);
        public static final BlockBehaviour.Properties STRAWBERRY_ICE_CREAM_BLOCK = BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PINK).instrument(NoteBlockInstrument.CHIME).strength(0.2F).sound(SoundType.SNOW);
        public static final BlockBehaviour.Properties VANILLA_ICE_CREAM_BLOCK = BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_WHITE).instrument(NoteBlockInstrument.CHIME).strength(0.2F).sound(SoundType.SNOW);

        public static final BlockBehaviour.Properties APPLE_ICE_CREAM_BLOCK = BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_WHITE).instrument(NoteBlockInstrument.CHIME).strength(0.2F).sound(SoundType.SNOW);
        public static final BlockBehaviour.Properties CARROT_ICE_CREAM_BLOCK = BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).instrument(NoteBlockInstrument.CHIME).strength(0.2F).sound(SoundType.SNOW);
        public static final BlockBehaviour.Properties GLOW_BERRY_ICE_CREAM_BLOCK = BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).instrument(NoteBlockInstrument.CHIME).strength(0.2F).sound(SoundType.SNOW).lightLevel(state -> 12);

        public static final BlockBehaviour.Properties ENCHANTED_FRUIT_ICE_CREAM_BLOCK = BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).instrument(NoteBlockInstrument.CHIME).strength(0.2F).sound(SoundType.SNOW);
        public static final BlockBehaviour.Properties KABLOOM_ICE_CREAM_BLOCK = BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GREEN).instrument(NoteBlockInstrument.CHIME).strength(0.2F).sound(SoundType.SNOW);
        public static final BlockBehaviour.Properties SOURCE_BERRY_ICE_CREAM_BLOCK = BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE).instrument(NoteBlockInstrument.CHIME).strength(0.2F).sound(SoundType.SNOW);

        public static final BlockBehaviour.Properties CHORUS_FRUIT_ICE_CREAM_BLOCK = BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE).instrument(NoteBlockInstrument.CHIME).strength(0.2F).sound(SoundType.SNOW);
        public static final BlockBehaviour.Properties AZURE_BERRY_ICE_CREAM_BLOCK = BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_BLUE).instrument(NoteBlockInstrument.CHIME).strength(0.2F).sound(SoundType.SNOW);
        public static final BlockBehaviour.Properties JELLY_RING_ICE_CREAM_BLOCK = BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PINK).instrument(NoteBlockInstrument.CHIME).strength(0.2F).sound(SoundType.SNOW);
        public static final BlockBehaviour.Properties MIDNIGHT_ICE_CREAM_BLOCK = BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLUE).instrument(NoteBlockInstrument.CHIME).strength(0.2F).sound(SoundType.SNOW).lightLevel(state -> 12);
        public static final BlockBehaviour.Properties STARCLOUD_ICE_CREAM_BLOCK = BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_BLUE).instrument(NoteBlockInstrument.CHIME).strength(0.2F).sound(SoundType.SNOW).lightLevel(state -> 12);
        public static final BlockBehaviour.Properties WARZIPAN_ICE_CREAM_BLOCK = BlockBehaviour.Properties.of().mapColor(MapColor.SAND).instrument(NoteBlockInstrument.CHIME).strength(0.2F).sound(SoundType.SNOW);

        public static final BlockBehaviour.Properties PUMPKIN_ICE_CREAM_BLOCK = Block.Properties.of().mapColor(MapColor.TERRACOTTA_YELLOW).instrument(NoteBlockInstrument.CHIME).strength(0.2F).sound(SoundType.SNOW);
        public static final BlockBehaviour.Properties SWEET_BERRY_ICE_CREAM_BLOCK = Block.Properties.of().mapColor(MapColor.COLOR_MAGENTA).instrument(NoteBlockInstrument.CHIME).strength(0.2F).sound(SoundType.SNOW);
        public static final BlockBehaviour.Properties BEETROOT_ICE_CREAM_BLOCK = Block.Properties.of().mapColor(MapColor.COLOR_RED).instrument(NoteBlockInstrument.CHIME).strength(0.2F).sound(SoundType.SNOW);

        public static final BlockBehaviour.Properties YUCCA_ICE_CREAM_BLOCK = Block.Properties.of().mapColor(MapColor.COLOR_LIGHT_GREEN).instrument(NoteBlockInstrument.CHIME).strength(0.2F).sound(SoundType.SNOW);
        public static final BlockBehaviour.Properties ALOE_ICE_CREAM_BLOCK = Block.Properties.of().mapColor(MapColor.COLOR_LIGHT_GREEN).instrument(NoteBlockInstrument.CHIME).strength(0.2F).sound(SoundType.SNOW);
        public static final BlockBehaviour.Properties PASSION_FRUIT_ICE_CREAM_BLOCK = Block.Properties.of().mapColor(MapColor.COLOR_YELLOW).instrument(NoteBlockInstrument.CHIME).strength(0.2F).sound(SoundType.SNOW);

        public static final BlockBehaviour.Properties GREEN_TEA_ICE_CREAM_BLOCK = Block.Properties.of().mapColor(MapColor.COLOR_LIGHT_GREEN).instrument(NoteBlockInstrument.CHIME).strength(0.2F).sound(SoundType.SNOW);
        public static final BlockBehaviour.Properties YELLOW_TEA_ICE_CREAM_BLOCK = Block.Properties.of().mapColor(MapColor.COLOR_YELLOW).instrument(NoteBlockInstrument.CHIME).strength(0.2F).sound(SoundType.SNOW);
        public static final BlockBehaviour.Properties BLACK_TEA_ICE_CREAM_BLOCK = Block.Properties.of().mapColor(MapColor.COLOR_BROWN).instrument(NoteBlockInstrument.CHIME).strength(0.2F).sound(SoundType.SNOW);
        public static final BlockBehaviour.Properties COFFEE_ICE_CREAM_BLOCK = Block.Properties.of().mapColor(MapColor.COLOR_BROWN).instrument(NoteBlockInstrument.CHIME).strength(0.2F).sound(SoundType.SNOW);

        public static final BlockBehaviour.Properties LIME_ICE_CREAM_BLOCK = Block.Properties.of().mapColor(MapColor.COLOR_LIGHT_GREEN).instrument(NoteBlockInstrument.CHIME).strength(0.2F).sound(SoundType.SNOW);
        public static final BlockBehaviour.Properties POMEGRANATE_ICE_CREAM_BLOCK = Block.Properties.of().mapColor(MapColor.COLOR_MAGENTA).instrument(NoteBlockInstrument.CHIME).strength(0.2F).sound(SoundType.SNOW);

        public static final BlockBehaviour.Properties SALMONBERRY_ICE_CREAM_BLOCK = Block.Properties.of().mapColor(MapColor.COLOR_ORANGE).instrument(NoteBlockInstrument.CHIME).strength(0.2F).sound(SoundType.SNOW);
        public static final BlockBehaviour.Properties MATCHA_ICE_CREAM_BLOCK = Block.Properties.of().mapColor(MapColor.COLOR_GREEN).instrument(NoteBlockInstrument.CHIME).strength(0.2F).sound(SoundType.SNOW);

        public static final BlockBehaviour.Properties GLOWY_ICE_CREAM_BLOCK = Block.Properties.of().mapColor(MapColor.COLOR_ORANGE).instrument(NoteBlockInstrument.CHIME).strength(0.2F).sound(SoundType.SNOW).lightLevel(state -> 12);
        public static final BlockBehaviour.Properties FLAVORED_ICE_CREAM_BLOCK = Block.Properties.of().mapColor(MapColor.COLOR_RED).instrument(NoteBlockInstrument.CHIME).strength(0.2F).sound(SoundType.SNOW);
        public static final BlockBehaviour.Properties CHERRY_ICE_CREAM_BLOCK = Block.Properties.of().mapColor(MapColor.COLOR_PINK).instrument(NoteBlockInstrument.CHIME).strength(0.2F).sound(SoundType.SNOW);

        public static final BlockBehaviour.Properties TORCHBERRY_ICE_CREAM_BLOCK = Block.Properties.of().mapColor(MapColor.COLOR_YELLOW).instrument(NoteBlockInstrument.CHIME).strength(0.2F).sound(SoundType.SNOW).lightLevel(state -> 12);
        public static final BlockBehaviour.Properties PHYTOCHEMICAL_ICE_CREAM_BLOCK = Block.Properties.of().mapColor(MapColor.GRASS).instrument(NoteBlockInstrument.CHIME).strength(0.2F).sound(SoundType.SNOW);
        public static final BlockBehaviour.Properties GLACIER_ICE_CREAM_BLOCK = Block.Properties.of().mapColor(MapColor.SNOW).instrument(NoteBlockInstrument.CHIME).strength(0.2F).sound(SoundType.SNOW);
        public static final BlockBehaviour.Properties AURORA_ICE_CREAM_BLOCK = Block.Properties.of().mapColor(MapColor.COLOR_BLUE).instrument(NoteBlockInstrument.CHIME).strength(0.2F).sound(SoundType.SNOW).lightLevel(state -> 12);

        public static final BlockBehaviour.Properties ASTERA_ICE_CREAM_BLOCK = Block.Properties.of().mapColor(MapColor.COLOR_ORANGE).instrument(NoteBlockInstrument.CHIME).strength(0.2F).sound(SoundType.SNOW).lightLevel(state -> 12);
        public static final BlockBehaviour.Properties BROCCOLI_ICE_CREAM_BLOCK = Block.Properties.of().mapColor(MapColor.COLOR_GREEN).instrument(NoteBlockInstrument.CHIME).strength(0.2F).sound(SoundType.SNOW);
        public static final BlockBehaviour.Properties FROST_ICE_CREAM_BLOCK = Block.Properties.of().mapColor(MapColor.SNOW).instrument(NoteBlockInstrument.CHIME).strength(0.2F).sound(SoundType.SNOW);
        public static final BlockBehaviour.Properties RAINBOW_ICE_CREAM_BLOCK = Block.Properties.of().mapColor(MapColor.COLOR_RED).instrument(NoteBlockInstrument.CHIME).strength(0.2F).sound(SoundType.SNOW).lightLevel(state -> 12);

        public static final BlockBehaviour.Properties PINK_DRAGON_FRUIT_ICE_CREAM_BLOCK = Block.Properties.of().mapColor(MapColor.COLOR_PINK).instrument(NoteBlockInstrument.CHIME).strength(0.2F).sound(SoundType.SNOW);
        public static final BlockBehaviour.Properties LUCUMA_ICE_CREAM_BLOCK = Block.Properties.of().mapColor(MapColor.TERRACOTTA_ORANGE).instrument(NoteBlockInstrument.CHIME).strength(0.2F).sound(SoundType.SNOW);


        //cookie tiles
        public static final BlockBehaviour.Properties PAW_COOKIE = Block.Properties.of().mapColor(MapColor.COLOR_LIGHT_GREEN).strength(2.0F, 3.0F).sound(SoundType.WOOD);
        public static final BlockBehaviour.Properties BIRCH_COOKIE = Block.Properties.of().mapColor(MapColor.SNOW).strength(2.0F, 3.0F).sound(SoundType.WOOD);
        public static final BlockBehaviour.Properties HERBAL_COOKIE = Block.Properties.of().mapColor(MapColor.COLOR_GREEN).strength(2.0F, 3.0F).sound(SoundType.WOOD);

        //storage blocks
        public static final BlockBehaviour.Properties SWEET_BERRY_SYRUP_BLOCK = BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_MAGENTA).noOcclusion().instabreak().sound(SoundType.HONEY_BLOCK);
        public static final BlockBehaviour.Properties SOUR_BERRY_SYRUP_BLOCK = BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GREEN).noOcclusion().instabreak().sound(SoundType.HONEY_BLOCK);
        public static final BlockBehaviour.Properties BITTER_BERRY_SYRUP_BLOCK = BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GREEN).noOcclusion().instabreak().sound(SoundType.HONEY_BLOCK);
        public static final BlockBehaviour.Properties SPICY_BERRY_SYRUP_BLOCK = BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).noOcclusion().instabreak().sound(SoundType.HONEY_BLOCK);
        public static final BlockBehaviour.Properties STRANGE_BERRY_SYRUP_BLOCK = BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE).noOcclusion().instabreak().sound(SoundType.HONEY_BLOCK);

        public static final BlockBehaviour.Properties BIRCH_SAP_BLOCK = BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_CYAN).noOcclusion().instabreak().sound(SoundType.HONEY_BLOCK);
        public static final BlockBehaviour.Properties STEELEAF_NECTAR_BLOCK = BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GREEN).noOcclusion().instabreak().sound(SoundType.HONEY_BLOCK);
        public static final BlockBehaviour.Properties MOLASSES_BLOCK = BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).noOcclusion().instabreak().sound(SoundType.HONEY_BLOCK);

        public static final BlockBehaviour.Properties WILDBERRY_BASKET = BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).instrument(NoteBlockInstrument.BASS).strength(1.5F).sound(SoundType.WOOD).ignitedByLava();
        public static final BlockBehaviour.Properties GOLDEN_ARBUTUS_BERRIES_BASKET = BlockBehaviour.Properties.of().mapColor(MapColor.GOLD).instrument(NoteBlockInstrument.BASS).strength(1.5F).sound(SoundType.WOOD);

        public static final BlockBehaviour.Properties FIDDLEHEAD_CRATE = BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GREEN).instrument(NoteBlockInstrument.BASS).strength(1.5F).sound(SoundType.WOOD).ignitedByLava();
        public static final BlockBehaviour.Properties IRON_FIDDLEHEAD_CRATE = BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).instrument(NoteBlockInstrument.BASS).strength(1.5F).sound(SoundType.WOOD).ignitedByLava();
        public static final BlockBehaviour.Properties TUBER_CRATE = BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).instrument(NoteBlockInstrument.BASS).strength(1.5F).sound(SoundType.WOOD).ignitedByLava();
        public static final BlockBehaviour.Properties WATTLESEED_SACK = BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).instrument(NoteBlockInstrument.BASS).strength(1.5F).sound(SoundType.WOOL).ignitedByLava();

        public static final BlockBehaviour.Properties LIFELIGHT = BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_WHITE).instabreak().noCollission().randomTicks().replaceable().sound(SoundType.MOSS);
    }


}



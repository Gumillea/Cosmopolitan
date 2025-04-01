package com.gumillea.cosmopolitan.core.reg;

import com.gumillea.cosmopolitan.Cosmopolitan;
import com.gumillea.cosmopolitan.common.block.IceCreamTubBlock;
import com.gumillea.cosmopolitan.core.util.CosmoCompat;
import com.teamabnormals.blueprint.core.util.item.CreativeModeTabContentsPopulator;
import com.teamabnormals.blueprint.core.util.registry.BlockSubRegistryHelper;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

import static net.minecraft.world.item.CreativeModeTabs.BUILDING_BLOCKS;
import static net.minecraft.world.item.CreativeModeTabs.FUNCTIONAL_BLOCKS;

@Mod.EventBusSubscriber(modid = Cosmopolitan.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CosmoBlocks {
    public static final BlockSubRegistryHelper HELPER = Cosmopolitan.REGISTRY_HELPER.getBlockSubHelper();

    public static final RegistryObject<Block> ICE_CREAM_TUB = HELPER.createBlock("ice_cream_tub", () -> new IceCreamTubBlock(Properties.CHISELED_ADZUKI_ICE_CREAM_BLOCK));

    //Chiseled Ice Cream Blocks
    public static final RegistryObject<Block> CHISELED_ADZUKI_ICE_CREAM_BLOCK = HELPER.createBlock("chiseled_adzuki_ice_cream_block", () -> new Block(Properties.CHISELED_ADZUKI_ICE_CREAM_BLOCK));
    public static final RegistryObject<Block> CHISELED_BANANA_ICE_CREAM_BLOCK = HELPER.createBlock("chiseled_banana_ice_cream_block", () -> new Block(Properties.CHISELED_BANANA_ICE_CREAM_BLOCK));
    public static final RegistryObject<Block> CHISELED_CHOCOLATE_ICE_CREAM_BLOCK = HELPER.createBlock("chiseled_chocolate_ice_cream_block", () -> new Block(Properties.CHISELED_CHOCOLATE_ICE_CREAM_BLOCK));
    public static final RegistryObject<Block> CHISELED_MINT_ICE_CREAM_BLOCK = HELPER.createBlock("chiseled_mint_ice_cream_block", () -> new Block(Properties.CHISELED_MINT_ICE_CREAM_BLOCK));
    public static final RegistryObject<Block> CHISELED_STRAWBERRY_ICE_CREAM_BLOCK = HELPER.createBlock("chiseled_strawberry_ice_cream_block", () -> new Block(Properties.CHISELED_STRAWBERRY_ICE_CREAM_BLOCK));
    public static final RegistryObject<Block> CHISELED_VANILLA_ICE_CREAM_BLOCK = HELPER.createBlock("chiseled_vanilla_ice_cream_block", () -> new Block(Properties.CHISELED_VANILLA_ICE_CREAM_BLOCK));

    //Ice Cream Blocks
    public static final RegistryObject<Block> ENCHANTED_FRUIT_ICE_CREAM_BLOCK = HELPER.createBlock("enchanted_fruit_ice_cream_block", () -> new Block(Properties.ENCHANTED_FRUIT_ICE_CREAM_BLOCK));
    public static final RegistryObject<Block> KABLOOM_ICE_CREAM_BLOCK = HELPER.createBlock("kabloom_ice_cream_block", () -> new Block(Properties.KABLOOM_ICE_CREAM_BLOCK));
    public static final RegistryObject<Block> SOURCE_BERRY_ICE_CREAM_BLOCK = HELPER.createBlock("source_berry_ice_cream_block", () -> new Block(Properties.SOURCE_BERRY_ICE_CREAM_BLOCK));

    public static void setupTabEditors() {
        CreativeModeTabContentsPopulator.mod(Cosmopolitan.MODID)

                .tab(FUNCTIONAL_BLOCKS)
                .addItems(ICE_CREAM_TUB)
                .tab(BUILDING_BLOCKS)
                .predicate(event -> event.getTabKey() == BUILDING_BLOCKS && ModList.get().isLoaded(CosmoCompat.NEA))
                .addItems(CHISELED_ADZUKI_ICE_CREAM_BLOCK, CHISELED_BANANA_ICE_CREAM_BLOCK, CHISELED_CHOCOLATE_ICE_CREAM_BLOCK, CHISELED_MINT_ICE_CREAM_BLOCK, CHISELED_STRAWBERRY_ICE_CREAM_BLOCK, CHISELED_VANILLA_ICE_CREAM_BLOCK,
                        ENCHANTED_FRUIT_ICE_CREAM_BLOCK, KABLOOM_ICE_CREAM_BLOCK, SOURCE_BERRY_ICE_CREAM_BLOCK)
                ;
    }

    static class Properties {
        //Chiseled Cream Blocks
        public static final BlockBehaviour.Properties CHISELED_ADZUKI_ICE_CREAM_BLOCK = BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).instrument(NoteBlockInstrument.CHIME).strength(0.2F).sound(SoundType.SNOW);
        public static final BlockBehaviour.Properties CHISELED_BANANA_ICE_CREAM_BLOCK = BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).instrument(NoteBlockInstrument.CHIME).strength(0.2F).sound(SoundType.SNOW);
        public static final BlockBehaviour.Properties CHISELED_CHOCOLATE_ICE_CREAM_BLOCK = BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).instrument(NoteBlockInstrument.CHIME).strength(0.2F).sound(SoundType.SNOW);
        public static final BlockBehaviour.Properties CHISELED_MINT_ICE_CREAM_BLOCK = BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GREEN).instrument(NoteBlockInstrument.CHIME).strength(0.2F).sound(SoundType.SNOW);
        public static final BlockBehaviour.Properties CHISELED_STRAWBERRY_ICE_CREAM_BLOCK = BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PINK).instrument(NoteBlockInstrument.CHIME).strength(0.2F).sound(SoundType.SNOW);
        public static final BlockBehaviour.Properties CHISELED_VANILLA_ICE_CREAM_BLOCK = BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_WHITE).instrument(NoteBlockInstrument.CHIME).strength(0.2F).sound(SoundType.SNOW);

        //Ice Cream Blocks
        public static final BlockBehaviour.Properties ENCHANTED_FRUIT_ICE_CREAM_BLOCK = BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).instrument(NoteBlockInstrument.CHIME).strength(0.2F).sound(SoundType.SNOW);
        public static final BlockBehaviour.Properties KABLOOM_ICE_CREAM_BLOCK = BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GREEN).instrument(NoteBlockInstrument.CHIME).strength(0.2F).sound(SoundType.SNOW);
        public static final BlockBehaviour.Properties SOURCE_BERRY_ICE_CREAM_BLOCK = BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE).instrument(NoteBlockInstrument.CHIME).strength(0.2F).sound(SoundType.SNOW);
    }
}



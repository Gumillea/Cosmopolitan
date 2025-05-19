package com.gumillea.cosmopolitan;

import com.google.common.eventbus.Subscribe;
import com.gumillea.cosmopolitan.core.data.CosmoLanguageProvider;
import com.gumillea.cosmopolitan.core.data.CosmoLootModifierProvider;
import com.gumillea.cosmopolitan.core.data.CosmoLootTableProvider;
import com.gumillea.cosmopolitan.core.data.CosmoRecipeProvider;
import com.gumillea.cosmopolitan.core.data.models.CosmoBlockStateProvider;
import com.gumillea.cosmopolitan.core.data.models.CosmoItemModelProvider;
import com.gumillea.cosmopolitan.core.data.tags.CosmoBlockTagsProvider;
import com.gumillea.cosmopolitan.core.data.tags.CosmoEffectTagsProvider;
import com.gumillea.cosmopolitan.core.data.tags.CosmoItemTagsProvider;
import com.gumillea.cosmopolitan.core.misc.CaroteneCapability;
import com.gumillea.cosmopolitan.core.reg.*;
import com.gumillea.cosmopolitan.core.util.CosmoCompostableItems;
import com.gumillea.exquisito.core.reg.ExquisitoCauldronInteractions;
import com.teamabnormals.blueprint.core.util.registry.RegistryHelper;
import net.brnbrd.delightful.Util;
import net.brnbrd.delightful.common.block.DelightfulCauldronInteractions;
import net.brnbrd.delightful.common.item.DelightfulItems;
import net.brnbrd.delightful.network.DPacketHandler;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.entity.animal.Parrot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.common.crafting.CompoundIngredient;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.event.AddPackFindersEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collections;
import java.util.concurrent.CompletableFuture;

@Mod(Cosmopolitan.MODID)
@Mod.EventBusSubscriber(modid = Cosmopolitan.MODID)
public class Cosmopolitan {

    public static final String MODID = "cosmopolitan";
    public static final RegistryHelper REGISTRY_HELPER = new RegistryHelper(MODID);
    public static final Logger LOGGER = LogManager.getLogger(MODID);

    public Cosmopolitan() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModLoadingContext context = ModLoadingContext.get();
        MinecraftForge.EVENT_BUS.register(this);

        REGISTRY_HELPER.register(modEventBus);

        CosmoEffects.EFFECTS.register(modEventBus);
        CosmoEffects.POTIONS.register(modEventBus);
        CosmoRecipes.RECIPE_SERIALIZERS.register(modEventBus);
        CosmoRecipes.RECIPE_TYPE.register(modEventBus);
        CosmoFluids.FLUIDS.register(modEventBus);
        CosmoFluids.FLUID_TYPES.register(modEventBus);
        CosmoCreativeTabs.TABS.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::clientSetup);
        modEventBus.addListener(this::addBuiltinPacks);
        modEventBus.addListener(this::gatherData);

        CosmoLootConditions.LOOT_CONDITION_TYPES.register(modEventBus);

        context.registerConfig(ModConfig.Type.COMMON, CosmoConfig.COMMON_SPEC);
        context.registerConfig(ModConfig.Type.CLIENT, CosmoConfig.CLIENT_SPEC);
    }

    private void commonSetup(FMLCommonSetupEvent e) {
        e.enqueueWork(() -> {
            CosmoCompostableItems.registerCompostableItems();
            CosmoEffects.registerBrewingRecipes();
            if (ModList.get().isLoaded("neapolitan")) {
                CosmoCauldronInteractions.registerCauldronInteractions();
            }

        });
    }

    private void clientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            ItemBlockRenderTypes.setRenderLayer(CosmoBlocks.LIFELIGHT.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(CosmoBlocks.GLOW_PETALS.get(), RenderType.cutout());
        });
    }

    private void addBuiltinPacks(AddPackFindersEvent event) {
        if (event.getPackType() == PackType.CLIENT_RESOURCES) {
            CosmoResourcePacks.addPackFinders(event);
        }
    }

    private void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> provider = event.getLookupProvider();
        ExistingFileHelper helper = event.getExistingFileHelper();

        boolean includeServer = event.includeServer();
        CosmoBlockTagsProvider blockTagsProvider = new CosmoBlockTagsProvider(output, provider, helper);
        generator.addProvider(includeServer, blockTagsProvider);
        generator.addProvider(includeServer, new CosmoItemTagsProvider(output, provider, blockTagsProvider.contentsGetter(), helper));
        generator.addProvider(includeServer, new CosmoLootModifierProvider(output, provider));
        generator.addProvider(includeServer, new CosmoRecipeProvider(output));
        generator.addProvider(includeServer, new CosmoEffectTagsProvider(output, provider, helper));
        generator.addProvider(includeServer, new CosmoLootTableProvider(output));

        boolean client = event.includeClient();
        generator.addProvider(client, new CosmoItemModelProvider(output, helper));
        generator.addProvider(client, new CosmoBlockStateProvider(output, helper));
        generator.addProvider(client, new CosmoLanguageProvider(output));
    }
}

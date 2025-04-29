package com.gumillea.cosmopolitan;

import com.gumillea.cosmopolitan.core.data.CosmoLanguageProvider;
import com.gumillea.cosmopolitan.core.data.CosmoLootModifierProvider;
import com.gumillea.cosmopolitan.core.data.CosmoRecipeProvider;
import com.gumillea.cosmopolitan.core.data.models.CosmoBlockStateProvider;
import com.gumillea.cosmopolitan.core.data.models.CosmoItemModelProvider;
import com.gumillea.cosmopolitan.core.data.tags.CosmopolitanBlockTagsProvider;
import com.gumillea.cosmopolitan.core.data.tags.CosmopolitanItemTagsProvider;
import com.gumillea.cosmopolitan.core.reg.*;
import com.gumillea.cosmopolitan.core.util.CosmoCompostableItems;
import com.teamabnormals.blueprint.core.util.registry.RegistryHelper;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.server.packs.PackType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.event.AddPackFindersEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import java.util.concurrent.CompletableFuture;

@Mod(Cosmopolitan.MODID)
@Mod.EventBusSubscriber(modid = Cosmopolitan.MODID)
public class Cosmopolitan {

    public static final String MODID = "cosmopolitan";
    public static final RegistryHelper REGISTRY_HELPER = new RegistryHelper(MODID);

    public Cosmopolitan() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModLoadingContext context = ModLoadingContext.get();
        MinecraftForge.EVENT_BUS.register(this);

        REGISTRY_HELPER.register(modEventBus);

        CosmoEffects.EFFECTS.register(modEventBus);
        CosmoRecipes.RECIPE_SERIALIZERS.register(modEventBus);
        CosmoRecipes.RECIPE_TYPE.register(modEventBus);
        CosmoFluids.FLUIDS.register(modEventBus);
        CosmoFluids.FLUID_TYPES.register(modEventBus);
        CosmoCreativeTabs.TABS.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::addBuiltinPacks);
        modEventBus.addListener(this::gatherData);

        CosmoLootConditions.LOOT_CONDITION_TYPES.register(modEventBus);

        context.registerConfig(ModConfig.Type.COMMON, CosmoConfig.COMMON_SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        CosmoCompostableItems.registerCompostableItems();
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
        CosmopolitanBlockTagsProvider blockTagsProvider = new CosmopolitanBlockTagsProvider(output, provider, helper);
        generator.addProvider(includeServer, blockTagsProvider);
        generator.addProvider(includeServer, new CosmopolitanItemTagsProvider(output, provider, blockTagsProvider.contentsGetter(), helper));
        generator.addProvider(includeServer, new CosmoLootModifierProvider(output, provider));
        generator.addProvider(includeServer, new CosmoRecipeProvider(output));

        boolean client = event.includeClient();
        generator.addProvider(client, new CosmoItemModelProvider(output, helper));
        generator.addProvider(client, new CosmoBlockStateProvider(output, helper));
        generator.addProvider(client, new CosmoLanguageProvider(output));
    }
}

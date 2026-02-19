package com.gumillea.cosmopolitan;

import com.gumillea.cosmopolitan.core.data.*;
import com.gumillea.cosmopolitan.core.data.models.CosmoBlockStateProvider;
import com.gumillea.cosmopolitan.core.data.models.CosmoItemModelProvider;
import com.gumillea.cosmopolitan.core.data.modifier.CosmoLootModifierProvider;
import com.gumillea.cosmopolitan.core.data.tags.CosmoBlockTagsProvider;
import com.gumillea.cosmopolitan.core.data.tags.CosmoEffectTagsProvider;
import com.gumillea.cosmopolitan.core.data.tags.CosmoItemTagsProvider;
import com.gumillea.cosmopolitan.core.misc.compat.supplementaries.SappyBirchLogInteraction;
import com.gumillea.cosmopolitan.core.misc.compat.supplementaries.CosmoSoftFluids;
import com.gumillea.cosmopolitan.core.reg.*;
import com.gumillea.cosmopolitan.core.util.CosmoCompat;
import com.gumillea.cosmopolitan.core.util.CosmoCompostableItems;
import com.teamabnormals.blueprint.core.util.registry.RegistryHelper;
import net.mehvahdjukaar.supplementaries.common.block.faucet.FaucetBehaviorsManager;
import net.mehvahdjukaar.supplementaries.common.block.tiles.FaucetBlockTile;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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

        ForgeMod.enableMilkFluid();

        CosmoEffects.EFFECTS.register(modEventBus);
        CosmoEffects.POTIONS.register(modEventBus);
        CosmoRecipes.RECIPE_SERIALIZERS.register(modEventBus);
        CosmoRecipes.RECIPE_TYPE.register(modEventBus);
        CosmoFluids.FLUIDS.register(modEventBus);
        CosmoFluids.FLUID_TYPES.register(modEventBus);
        CosmoCreativeTabs.TABS.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::clientSetup);
        modEventBus.addListener(this::gatherData);

        CosmoLootConditions.LOOT_CONDITION_TYPES.register(modEventBus);

        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> CosmoItems::setupTabEditors);


        context.registerConfig(ModConfig.Type.COMMON, CosmoConfig.COMMON_SPEC);
        context.registerConfig(ModConfig.Type.CLIENT, CosmoConfig.CLIENT_SPEC);
    }

    private void commonSetup(FMLCommonSetupEvent e) {
        e.enqueueWork(() -> {
            CosmoCompostableItems.registerCompostableItems();
            CosmoEffects.registerBrewingRecipes();
            if (CosmoCompat.nea) {
                CosmoCauldronInteractions.registerCauldronInteractions();
            }
            if (CosmoCompat.sup) {
                CosmoSoftFluids.init();
                FaucetBehaviorsManager.addRegisterFaucetInteraction(() -> FaucetBlockTile.registerInteraction(new SappyBirchLogInteraction()));
            }
        });
    }

    private void clientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            ItemBlockRenderTypes.setRenderLayer(CosmoBlocks.BERRY_SYRUP_BLOCK.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(CosmoBlocks.BIRCH_SAP_BLOCK.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(CosmoBlocks.STEELEAF_NECTAR_BLOCK.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(CosmoBlocks.LIFELIGHT.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(CosmoBlocks.GLOW_PETALS.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(CosmoBlocks.POTTED_WILDBERRY_BUSH.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(CosmoBlocks.POTTED_FIDDLEHEAD_GREENS.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(CosmoBlocks.GLOW_BERRY_CUBECAKE.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(CosmoBlocks.WHEATGRASS_CUBECAKE.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(CosmoBlocks.WARPED_VELVET_CUBECAKE.get(), RenderType.cutout());

            // Based on the item property implementation from Snowy Spirit by MehVahdJukaar: https://github.com/MehVahdJukaar/SnowySpirit/blob/1.20/common/src/main/java/net/mehvahdjukaar/snowyspirit/reg/ClientRegistry.java
            ItemProperties.register(CosmoItems.WILDBERRY.get(), new ResourceLocation("shape"), (stack, world, entity, s) -> (stack.hasTag() && stack.getTag().contains("icon")) ? 0F : (System.identityHashCode(stack) % 9) / 8F);
        });
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
        generator.addProvider(includeServer, CosmoAdvancementProvider.create(output, provider, helper));

        boolean client = event.includeClient();
        generator.addProvider(client, new CosmoItemModelProvider(output, helper));
        generator.addProvider(client, new CosmoBlockStateProvider(output, helper));
        generator.addProvider(client, new CosmoLanguageProvider(output));
    }
}

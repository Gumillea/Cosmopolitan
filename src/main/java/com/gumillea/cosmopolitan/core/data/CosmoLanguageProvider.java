package com.gumillea.cosmopolitan.core.data;

import com.gumillea.cosmopolitan.Cosmopolitan;
import com.gumillea.cosmopolitan.core.reg.CosmoBlocks;
import com.gumillea.cosmopolitan.core.reg.CosmoEffects;
import com.gumillea.cosmopolitan.core.reg.CosmoFluids;
import com.gumillea.cosmopolitan.core.reg.CosmoItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.commons.lang3.text.WordUtils;

import java.util.Objects;

public class CosmoLanguageProvider extends LanguageProvider {

    public CosmoLanguageProvider(PackOutput output) {
        super(output, Cosmopolitan.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
        this.addItem(
                CosmoItems.WILDBERRY.get(), CosmoItems.BERRY_SYRUP_BOTTLE.get(), CosmoItems.COSMOPOLITAN_COCKTAIL.get(), CosmoItems.FIDDLEHEAD.get(), CosmoItems.CUT_POTATOES.get(), CosmoItems.POTATO_WEDGES.get(), CosmoItems.MASHED_POTATO.get(), CosmoItems.MASHED_POTATO_CONE.get(), CosmoItems.WAFER.get(), CosmoItems.WAFER_CONE.get(), CosmoItems.SNOW_CONE.get(), CosmoItems.POTATO_PANCAKES.get(), CosmoItems.ADZUKI_ICE_CREAM_CONE.get(), CosmoItems.BANANA_ICE_CREAM_CONE.get(), CosmoItems.CHOCOLATE_ICE_CREAM_CONE.get(), CosmoItems.MINT_ICE_CREAM_CONE.get(), CosmoItems.STRAWBERRY_ICE_CREAM_CONE.get(), CosmoItems.VANILLA_ICE_CREAM_CONE.get(), CosmoItems.NEAPOLITAN_ICE_CREAM_SANDWICH.get(), CosmoItems.CHORUS_ICE_CREAM_CONE.get(), CosmoItems.WARZIPAN_ICE_CREAM_CONE.get(), CosmoItems.MIDNIGHT_ICE_CREAM_CONE.get(), CosmoItems.STARCLOUD_ICE_CREAM_CONE.get(), CosmoItems.JELLY_RING_ICE_CREAM_CONE.get(), CosmoItems.AZURE_BERRY_ICE_CREAM_CONE.get(), CosmoItems.BEETROOT_ICE_CREAM_CONE.get(), CosmoItems.PUMPKIN_ICE_CREAM_CONE.get(), CosmoItems.SWEET_BERRY_ICE_CREAM_CONE.get(), CosmoItems.SEASONAL_ICE_CREAM.get(), CosmoItems.SEASONAL_ICE_CREAM_SANDWICH.get(), CosmoItems.APPLE_ICE_CREAM.get(), CosmoItems.APPLE_ICE_CREAM_CONE.get(), CosmoItems.CARROT_ICE_CREAM.get(), CosmoItems.CARROT_ICE_CREAM_CONE.get(), CosmoItems.GLOW_BERRY_ICE_CREAM.get(), CosmoItems.GLOW_BERRY_ICE_CREAM_CONE.get(), CosmoItems.DROOPFRUIT_PIPS.get(), CosmoItems.SOURCE_BERRY_PIPS.get(), CosmoItems.KABLOOM_PIPS.get(), CosmoItems.BLISTERBERRY_PIPS.get(), CosmoItems.SOURCE_BERRY_ICE_CREAM.get(), CosmoItems.SOURCE_BERRY_ICE_CREAM_CONE.get(), CosmoItems.KABLOOM_ICE_CREAM.get(), CosmoItems.KABLOOM_ICE_CREAM_CONE.get(), CosmoItems.ENCHANTED_FRUIT_ICE_CREAM.get(), CosmoItems.ENCHANTED_FRUIT_ICE_CREAM_CONE.get(), CosmoItems.AURORA_KOHAKUTOU.get(), CosmoItems.GLACIER_ESSENCE.get(), CosmoItems.STEELEAF_NECTAR.get(), CosmoItems.AURORA_ICE_CREAM_CONE.get(), CosmoItems.GLACIER_ICE_CREAM_CONE.get(), CosmoItems.PHYTOCHEMICAL_ICE_CREAM_CONE.get(), CosmoItems.TORCHBERRY_ICE_CREAM_CONE.get(), CosmoItems.RAINBOW_ICE_CREAM_SANDWICH.get(), CosmoItems.REFRESHING_ICE_CREAM_SANDWICH.get(), CosmoItems.TWILIGHT_ICE_CREAM_SANDWICH.get(),
                CosmoItems.WHEATGRASS.get(), CosmoItems.BAKED_FIDDLEHEAD.get(), CosmoItems.GREEN_SAUCE.get(), CosmoItems.GREEN_PASTA.get(), CosmoItems.ALOE_ICE_CREAM_CONE.get(), CosmoItems.PASSION_FRUIT_ICE_CREAM_CONE.get(), CosmoItems.YUCCA_ICE_CREAM_CONE.get(), CosmoItems.PECULIAR_ICE_CREAM.get(), CosmoItems.PECULIAR_ICE_CREAM_SANDWICH.get(), CosmoItems.JELLY_ROLL.get(), CosmoItems.CHOCOLATE_ROLL.get(),  CosmoItems.SALMONBERRY_ICE_CREAM_CONE.get(), CosmoItems.MATCHA_ICE_CREAM_CONE.get(), CosmoItems.LIME_ICE_CREAM_CONE.get(), CosmoItems.POMEGRANATE_ICE_CREAM_CONE.get(), CosmoItems.BLISTERBERRY_TART.get(), CosmoItems.RAINDROOP_CAKE.get(), CosmoItems.BLISTERBERRY_SORBET.get(), CosmoItems.DROOPFRUIT_SORBET.get(), CosmoItems.UNDERGROUND_GULIME.get(), CosmoItems.ENCHANTED_COSMOPOLITAN_COCKTAIL.get(), CosmoItems.TAIGA_GULIME.get(), CosmoItems.GULIME.get()
        );
        this.addSmallGulime(
                CosmoItems.GULIME_SMALL.get(), CosmoItems.UNDERGROUND_GULIME_SMALL.get(), CosmoItems.TAIGA_GULIME_SMALL.get()
        );
        this.addSlice(
                CosmoItems.JELLY_ROLL_SLICE.get(), CosmoItems.CHOCOLATE_ROLL_SLICE.get()
        );
        this.addBlock(
                CosmoBlocks.COOPER_FROZEN_DESSERT_TUB.get(), CosmoBlocks.IRON_FROZEN_DESSERT_TUB.get(), CosmoBlocks.NETHERITE_FROZEN_DESSERT_TUB.get(), CosmoBlocks.MASHED_POTATO_BLOCK.get(), CosmoBlocks.WHEATGRASS_BALE.get(),
                CosmoBlocks.CHISELED_ADZUKI_ICE_CREAM_BLOCK.get(), CosmoBlocks.CHISELED_BANANA_ICE_CREAM_BLOCK.get(), CosmoBlocks.CHISELED_CHOCOLATE_ICE_CREAM_BLOCK.get(), CosmoBlocks.CHISELED_MINT_ICE_CREAM_BLOCK.get(), CosmoBlocks.CHISELED_STRAWBERRY_ICE_CREAM_BLOCK.get(), CosmoBlocks.CHISELED_VANILLA_ICE_CREAM_BLOCK.get(),
                CosmoBlocks.APPLE_ICE_CREAM_BLOCK.get(), CosmoBlocks.CARROT_ICE_CREAM_BLOCK.get(), CosmoBlocks.GLOW_BERRY_ICE_CREAM_BLOCK.get(), CosmoBlocks.ENCHANTED_FRUIT_ICE_CREAM_BLOCK.get(), CosmoBlocks.KABLOOM_ICE_CREAM_BLOCK.get(), CosmoBlocks.SOURCE_BERRY_ICE_CREAM_BLOCK.get()
        );
        this.addFluidType(
                CosmoFluids.VANILLA_ICE_CREAM_TYPE.get(), CosmoFluids.STRAWBERRY_ICE_CREAM_TYPE.get(), CosmoFluids.CHOCOLATE_ICE_CREAM_TYPE.get(), CosmoFluids.MINT_ICE_CREAM_TYPE.get(), CosmoFluids.ADZUKI_ICE_CREAM_TYPE.get(), CosmoFluids.BANANA_ICE_CREAM_TYPE.get(), CosmoFluids.APPLE_ICE_CREAM_TYPE.get(), CosmoFluids.CARROT_ICE_CREAM_TYPE.get(), CosmoFluids.GLOW_BERRY_ICE_CREAM_TYPE.get(), CosmoFluids.ALOE_ICE_CREAM_TYPE.get(), CosmoFluids.PASSION_FRUIT_ICE_CREAM_TYPE.get(), CosmoFluids.YUCCA_ICE_CREAM_TYPE.get(), CosmoFluids.BEETROOT_ICE_CREAM_TYPE.get(), CosmoFluids.SWEET_BERRY_ICE_CREAM_TYPE.get(), CosmoFluids.PUMPKIN_ICE_CREAM_TYPE.get(), CosmoFluids.LIME_ICE_CREAM_TYPE.get(), CosmoFluids.POMEGRANATE_ICE_CREAM_TYPE.get(), CosmoFluids.MATCHA_ICE_CREAM_TYPE.get(), CosmoFluids.SALMONBERRY_ICE_CREAM_TYPE.get(), CosmoFluids.CHORUS_FRUIT_ICE_CREAM_TYPE.get(), CosmoFluids.WARZIPAN_ICE_CREAM_TYPE.get(), CosmoFluids.JELLY_RING_ICE_CREAM_TYPE.get(), CosmoFluids.AZURE_BERRY_ICE_CREAM_TYPE.get(), CosmoFluids.MIDNIGHT_ICE_CREAM_TYPE.get(), CosmoFluids.STARCLOUD_ICE_CREAM_TYPE.get(), CosmoFluids.KABLOOM_ICE_CREAM_TYPE.get(), CosmoFluids.SOURCE_BERRY_ICE_CREAM_TYPE.get(), CosmoFluids.ENCHANTED_FRUIT_ICE_CREAM_TYPE.get(),
                CosmoFluids.AURORA_ICE_CREAM_TYPE.get(), CosmoFluids.PHYTOCHEMICAL_ICE_CREAM_TYPE.get(), CosmoFluids.GLACIER_ICE_CREAM_TYPE.get(), CosmoFluids.TORCHBERRY_ICE_CREAM_TYPE.get()
        );

        this.addEffect("Gain a small amount of extra health at the end of the duration, which expires if the user is injured during the duration.", CosmoEffects.EXUBERANT.get());
        this.addEffect("Converts Blindness, Darkness, and Nausea into brief Night Vision", CosmoEffects.CAROTENE.get());
        this.addEffect("The user will leave a glowing trail on the blocks they pass over.", CosmoEffects.MARKED.get());
        this.addEffect("The user's ranged attacks will mark and blind the first living target they hit", CosmoEffects.TRACER.get());
        this.addEffect("The original effect of the item could not be applied because the compatible mod was not installed.", CosmoEffects.PLACEHOLDER.get());
        this.add("tooltip." + Cosmopolitan.MODID + ".wheatgrass.when_feeding", "When fed to a tamed Cat:");

        this.addJeiItemDescriptions("Fiddlehead can be dropped when breaking fern or large fern.", CosmoItems.FIDDLEHEAD.get());
        this.addJeiItemDescriptions("Wildberry can be dropped when breaking grass or tall grass.", CosmoItems.WILDBERRY.get());
        this.addJeiItemDescriptions("Wheatgrass can be obtained by harvesting a wheat crop that is in the middle of its growth phase.", CosmoItems.WHEATGRASS.get());
    }

    private void addBlock(Block... blocks) {
        for (Block block : blocks)
            this.add(block, format(Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block))));
    }

    private void addFluidType(FluidType... fluidTypes) {
        for (FluidType fluidType : fluidTypes) {
            ResourceLocation id = ForgeRegistries.FLUID_TYPES.get().getKey(fluidType);
            String key = "fluid_type." + id.getNamespace() + "." + id.getPath();
            add(key, format(id));
        }
    }

    private void addEffect(String description, MobEffect... effects) {
        for (MobEffect effect : effects) {
            ResourceLocation key = Objects.requireNonNull(ForgeRegistries.MOB_EFFECTS.getKey(effect));
            String path = "effect." + key.getNamespace() + "." + key.getPath();

            this.add(effect, format(key));
            this.add(path + ".description", description);
        }
    }
    private void addItem(Item... items) {
        for (Item item : items)
            this.add(item, format(Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(item))));
    }

    private void addSlice(Item... items) {
        for (Item item : items)
            this.add(item, "Slice of " + format(Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(item))).replace(" Slice", ""));
    }

    private void addSmallGulime(Item... items) {
        for (Item item : items)
            this.add(item, "Small " + format(Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(item))).replace(" Small", ""));
    }

    private void addJeiItemDescriptions(String description, Item... items) {
        for (Item item : items) {
            ResourceLocation id = Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(item));
            String key = "jei." + id.getNamespace() + "." + id.getPath() + ".desc";
            add(key, description);
        }
    }

    private String format(ResourceLocation registryName) {
        return WordUtils.capitalizeFully(registryName.getPath().replace("_", " "));
    }

}

package com.gumillea.cosmopolitan.core.data;

import com.gumillea.cosmopolitan.Cosmopolitan;
import com.gumillea.cosmopolitan.core.reg.CosmoBlocks;
import com.gumillea.cosmopolitan.core.reg.CosmoEffects;
import com.gumillea.cosmopolitan.core.reg.CosmoItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.LanguageProvider;
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
                CosmoItems.WILDBERRY.get(), CosmoItems.FIDDLEHEAD.get(), CosmoItems.CUT_POTATOES.get(), CosmoItems.POTATO_WEDGES.get(), CosmoItems.MASHED_POTATO.get(), CosmoItems.MASHED_POTATO_CONE.get(), CosmoItems.WAFER.get(), CosmoItems.WAFER_CONE.get(), CosmoItems.SNOW_CONE.get(), CosmoItems.POTATO_PANCAKES.get(), CosmoItems.ADZUKI_ICE_CREAM_CONE.get(), CosmoItems.BANANA_ICE_CREAM_CONE.get(), CosmoItems.CHOCOLATE_ICE_CREAM_CONE.get(), CosmoItems.MINT_ICE_CREAM_CONE.get(), CosmoItems.STRAWBERRY_ICE_CREAM_CONE.get(), CosmoItems.VANILLA_ICE_CREAM_CONE.get(), CosmoItems.NEAPOLITAN_ICE_CREAM_SANDWICH.get(), CosmoItems.CHORUS_ICE_CREAM_CONE.get(), CosmoItems.WARZIPAN_ICE_CREAM_CONE.get(), CosmoItems.MIDNIGHT_ICE_CREAM_CONE.get(), CosmoItems.STARCLOUD_ICE_CREAM_CONE.get(), CosmoItems.JELLY_RING_ICE_CREAM_CONE.get(), CosmoItems.AZURE_BERRY_ICE_CREAM_CONE.get(), CosmoItems.BEETROOT_ICE_CREAM_CONE.get(), CosmoItems.PUMPKIN_ICE_CREAM_CONE.get(), CosmoItems.SWEET_BERRY_ICE_CREAM_CONE.get(), CosmoItems.SEASONAL_ICE_CREAM.get(), CosmoItems.SEASONAL_ICE_CREAM_SANDWICH.get(), CosmoItems.APPLE_ICE_CREAM.get(), CosmoItems.APPLE_ICE_CREAM_CONE.get(), CosmoItems.CARROT_ICE_CREAM.get(), CosmoItems.CARROT_ICE_CREAM_CONE.get(), CosmoItems.GLOW_BERRY_ICE_CREAM.get(), CosmoItems.GLOW_BERRY_ICE_CREAM_CONE.get(), CosmoItems.SOURCE_BERRY_PIPS.get(), CosmoItems.SOURCE_BERRY_ICE_CREAM.get(), CosmoItems.SOURCE_BERRY_ICE_CREAM_CONE.get(), CosmoItems.KABLOOM_ICE_CREAM.get(), CosmoItems.KABLOOM_ICE_CREAM_CONE.get(), CosmoItems.ENCHANTED_FRUIT_ICE_CREAM.get(), CosmoItems.ENCHANTED_FRUIT_ICE_CREAM_CONE.get(), CosmoItems.AURORA_KOHAKUTOU.get(), CosmoItems.GLACIER_ESSENCE.get(), CosmoItems.STEELEAF_NECTAR.get(), CosmoItems.AURORA_ICE_CREAM_CONE.get(), CosmoItems.GLACIER_ICE_CREAM_CONE.get(), CosmoItems.PHYTOCHEMICAL_ICE_CREAM_CONE.get(), CosmoItems.TORCHBERRY_ICE_CREAM_CONE.get(), CosmoItems.RAINBOW_ICE_CREAM_SANDWICH.get(), CosmoItems.REFRESHING_ICE_CREAM_SANDWICH.get(), CosmoItems.TWILIGHT_ICE_CREAM_SANDWICH.get(),
                CosmoItems.BAKED_FIDDLEHEAD.get(), CosmoItems.GREEN_SAUCE.get(), CosmoItems.ALOE_ICE_CREAM_CONE.get(), CosmoItems.PASSION_FRUIT_ICE_CREAM_CONE.get(), CosmoItems.YUCCA_ICE_CREAM_CONE.get(), CosmoItems.PECULIAR_ICE_CREAM.get(), CosmoItems.PECULIAR_ICE_CREAM_SANDWICH.get()
        );
        this.addBlock(
                CosmoBlocks.CHISELED_ADZUKI_ICE_CREAM_BLOCK.get(), CosmoBlocks.CHISELED_BANANA_ICE_CREAM_BLOCK.get(), CosmoBlocks.CHISELED_CHOCOLATE_ICE_CREAM_BLOCK.get(), CosmoBlocks.CHISELED_MINT_ICE_CREAM_BLOCK.get(), CosmoBlocks.CHISELED_STRAWBERRY_ICE_CREAM_BLOCK.get(), CosmoBlocks.CHISELED_VANILLA_ICE_CREAM_BLOCK.get(),
                CosmoBlocks.ENCHANTED_FRUIT_ICE_CREAM_BLOCK.get(), CosmoBlocks.KABLOOM_ICE_CREAM_BLOCK.get(), CosmoBlocks.SOURCE_BERRY_ICE_CREAM_BLOCK.get()
        );
        this.addEffect(
                CosmoEffects.EXUBERANT.get(), CosmoEffects.CAROTENE.get(), CosmoEffects.MARKED.get(), CosmoEffects.TRACER.get()
        );
    }

    private void addBlock(Block... blocks) {
        for (Block block : blocks) {
            this.add(block, format(Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block))));
        }
    }

    private void addEffect(MobEffect... effects) {
        for (MobEffect effect : effects) {
            this.add(effect, format(Objects.requireNonNull(ForgeRegistries.MOB_EFFECTS.getKey(effect))));
        }
    }

    private void addItem(Item... items) {
        for (Item item : items) {
            this.add(item, format(Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(item))));
        }
    }

    private String format(ResourceLocation registryName) {
        return WordUtils.capitalizeFully(registryName.getPath().replace("_", " "));
    }

}

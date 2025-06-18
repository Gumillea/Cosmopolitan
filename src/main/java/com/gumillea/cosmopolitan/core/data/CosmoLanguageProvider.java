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
import net.minecraft.world.item.alchemy.Potion;
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
                CosmoItems.TWILIGHT_CHARTREUSE.get(), CosmoItems.SMOGGY_APEROL.get(), CosmoItems.WANDERING_GELATO.get(), CosmoItems.ICE_CREAM_FLOAT.get(), CosmoItems.WILDBERRY_PUNCH.get(), CosmoItems.ROOT_BEER.get(), CosmoItems.BLACK_COW.get(), CosmoItems.HOT_CATTAIL.get(), CosmoItems.TRICOLORED_ICE_CREAM_SANDWICH.get(), CosmoItems.RESPITEFUL_ICE_CREAM_SANDWICH.get(), CosmoItems.WHEATGRASS_CUBECAKE.get(), CosmoItems.ADZUKI_MINT_CREAM_BUN.get(), CosmoItems.STRAWBERRY_VANILLA_CREAM_BUN.get(), CosmoItems.CHOCOLATE_BANANA_CREAM_BUN.get(), CosmoItems.CREAM_BUN.get(), CosmoItems.GLOW_BERRY_CUBECAKE.get(), CosmoItems.CHORUS_FRUIT_POPSICLE.get(), CosmoItems.GLOWY_ICE_CREAM_CONE.get(), CosmoItems.FLAVORED_ICE_CREAM_CONE.get(), CosmoItems.CHERRY_ICE_CREAM_CONE.get(), CosmoItems.BERRY_CHEESECAKE_BAR.get(), CosmoItems.BERRY_POPSICLE.get(), CosmoItems.COFFEE_ICE_CREAM_CONE.get(), CosmoItems.BLACK_TEA_ICE_CREAM_CONE.get(), CosmoItems.YELLOW_TEA_ICE_CREAM_CONE.get(), CosmoItems.GREEN_TEA_ICE_CREAM_CONE.get(), CosmoItems.JELLO_SALAD.get(), CosmoItems.JELLO_SALAD_CUP.get(), CosmoItems.CREAM_BUCKET.get(), CosmoItems.CREAM.get(), CosmoItems.CONDENSED_MILK_BUCKET.get(), CosmoItems.CONDENSED_MILK_BOTTLE.get(), CosmoItems.KABLOOM_MILKSHAKE.get(), CosmoItems.SOURCE_BERRY_MILKSHAKE.get(), CosmoItems.ENCHANTED_FRUIT_MILKSHAKE.get(), CosmoItems.APPLE_MILKSHAKE.get(), CosmoItems.CARROT_MILKSHAKE.get(), CosmoItems.GLOW_BERRY_MILKSHAKE.get(), CosmoItems.WILD_RISOTTO.get(), CosmoItems.ROASTED_MUSHROOM.get(), CosmoItems.INK_ROLL.get(), CosmoItems.SUMMER_CORDIAL.get(), CosmoItems.AUTUMN_TEA.get(), CosmoItems.WINTER_GLOGG.get(), CosmoItems.BIRCH_SAP_BOTTLE.get(), CosmoItems.SPRING_SODA.get(), CosmoItems.SPROUTED_UNDERBEANS.get(), CosmoItems.CLASSIC_ICE_CREAM.get(), CosmoItems.CLASSIC_ICE_CREAM_SANDWICH.get(), CosmoItems.CLASSIC_FRUIT_SALAD.get(), CosmoItems.TOFFEE_GOLDEN_APPLE.get(), CosmoItems.LUSH_STEW_CUP.get(), CosmoItems.LUSH_STEW.get(), CosmoItems.WILDBERRY.get(), CosmoItems.BERRY_SYRUP_BOTTLE.get(), CosmoItems.COSMOPOLITAN_COCKTAIL.get(), CosmoItems.FIDDLEHEAD.get(), CosmoItems.IRON_FIDDLEHEAD.get(), CosmoItems.GREEN_CREAM_STEW.get(), CosmoItems.CUT_POTATOES.get(), CosmoItems.POTATO_WEDGES.get(), CosmoItems.MASHED_POTATO.get(), CosmoItems.MASHED_POTATO_CONE.get(), CosmoItems.WAFER.get(), CosmoItems.WAFER_CONE.get(), CosmoItems.SNOW_CONE.get(), CosmoItems.POTATO_PANCAKES.get(), CosmoItems.ADZUKI_ICE_CREAM_CONE.get(), CosmoItems.BANANA_ICE_CREAM_CONE.get(), CosmoItems.CHOCOLATE_ICE_CREAM_CONE.get(), CosmoItems.MINT_ICE_CREAM_CONE.get(), CosmoItems.STRAWBERRY_ICE_CREAM_CONE.get(), CosmoItems.VANILLA_ICE_CREAM_CONE.get(), CosmoItems.NEAPOLITAN_ICE_CREAM_SANDWICH.get(), CosmoItems.CHORUS_ICE_CREAM_CONE.get(), CosmoItems.WARZIPAN_ICE_CREAM_CONE.get(), CosmoItems.MIDNIGHT_ICE_CREAM_CONE.get(), CosmoItems.STARCLOUD_ICE_CREAM_CONE.get(), CosmoItems.JELLY_RING_ICE_CREAM_CONE.get(), CosmoItems.AZURE_BERRY_ICE_CREAM_CONE.get(), CosmoItems.BEETROOT_ICE_CREAM_CONE.get(), CosmoItems.PUMPKIN_ICE_CREAM_CONE.get(), CosmoItems.SWEET_BERRY_ICE_CREAM_CONE.get(), CosmoItems.SEASONAL_ICE_CREAM.get(), CosmoItems.SEASONAL_ICE_CREAM_SANDWICH.get(), CosmoItems.APPLE_ICE_CREAM.get(), CosmoItems.APPLE_ICE_CREAM_CONE.get(), CosmoItems.CARROT_ICE_CREAM.get(), CosmoItems.CARROT_ICE_CREAM_CONE.get(), CosmoItems.GLOW_BERRY_ICE_CREAM.get(), CosmoItems.GLOW_BERRY_ICE_CREAM_CONE.get(), CosmoItems.DROOPFRUIT_PIPS.get(), CosmoItems.SOURCE_BERRY_PIPS.get(), CosmoItems.KABLOOM_PIPS.get(), CosmoItems.BLISTERBERRY_PIPS.get(), CosmoItems.SOURCE_BERRY_ICE_CREAM.get(), CosmoItems.SOURCE_BERRY_ICE_CREAM_CONE.get(), CosmoItems.KABLOOM_ICE_CREAM.get(), CosmoItems.KABLOOM_ICE_CREAM_CONE.get(), CosmoItems.ENCHANTED_FRUIT_ICE_CREAM.get(), CosmoItems.ENCHANTED_FRUIT_ICE_CREAM_CONE.get(), CosmoItems.AURORA_KOHAKUTOU.get(), CosmoItems.GLACIER_ESSENCE.get(), CosmoItems.STEELEAF_NECTAR.get(), CosmoItems.AURORA_ICE_CREAM_CONE.get(), CosmoItems.GLACIER_ICE_CREAM_CONE.get(), CosmoItems.PHYTOCHEMICAL_ICE_CREAM_CONE.get(), CosmoItems.TORCHBERRY_ICE_CREAM_CONE.get(), CosmoItems.RAINBOW_ICE_CREAM_SANDWICH.get(), CosmoItems.REFRESHING_ICE_CREAM_SANDWICH.get(), CosmoItems.TWILIGHT_ICE_CREAM_SANDWICH.get(),
                CosmoItems.WHEATGRASS.get(), CosmoItems.PAW_COOKIE.get(),  CosmoItems.BAKED_FIDDLEHEAD.get(), CosmoItems.GREEN_SAUCE.get(), CosmoItems.GREEN_PASTA.get(), CosmoItems.ALOE_ICE_CREAM_CONE.get(), CosmoItems.STRAWBERRY_GULIME.get() , CosmoItems.PASSION_FRUIT_ICE_CREAM_CONE.get(), CosmoItems.YUCCA_ICE_CREAM_CONE.get(), CosmoItems.PECULIAR_ICE_CREAM.get(), CosmoItems.PECULIAR_ICE_CREAM_SANDWICH.get(), CosmoItems.JELLY_ROLL.get(), CosmoItems.CHOCOLATE_ROLL.get(),  CosmoItems.SALMONBERRY_ICE_CREAM_CONE.get(), CosmoItems.MATCHA_ICE_CREAM_CONE.get(), CosmoItems.LIME_ICE_CREAM_CONE.get(), CosmoItems.POMEGRANATE_ICE_CREAM_CONE.get(), CosmoItems.BLISTERBERRY_TART.get(), CosmoItems.RAINDROOP_CAKE.get(), CosmoItems.BLISTERBERRY_SORBET.get(), CosmoItems.DROOPFRUIT_SORBET.get(), CosmoItems.UNDERGROUND_GULIME.get(), CosmoItems.ENCHANTED_COSMOPOLITAN_COCKTAIL.get(), CosmoItems.TAIGA_GULIME.get(), CosmoItems.GULIME.get(), CosmoItems.GLIMMERING_GULIME.get(), CosmoItems.CHORUS_GULIME.get(), CosmoItems.BLISTERBERRY_POPSICLE.get(), CosmoItems.MENDOSTEEN_TART.get(), CosmoItems.GREEN_CREAM_STEW_CUP.get(), CosmoItems.TOFFEE_APPLE.get()
        );
        this.addSmallGulime(
                CosmoItems.GULIME_SMALL.get(), CosmoItems.UNDERGROUND_GULIME_SMALL.get(), CosmoItems.TAIGA_GULIME_SMALL.get(), CosmoItems.CHORUS_GULIME_SMALL.get(), CosmoItems.GLIMMERING_GULIME_SMALL.get(), CosmoItems.STRAWBERRY_GULIME_SMALL.get()
        );
        this.addSlice(
                CosmoItems.JELLY_ROLL_SLICE.get(), CosmoItems.CHOCOLATE_ROLL_SLICE.get(), CosmoItems.INK_ROLL_SLICE.get()
        );
        this.addDoublePopsicle(
                CosmoItems.CHORUS_FRUIT_DOUBLE_POPSICLE.get(), CosmoItems.LIME_DOUBLE_POPSICLE.get(), CosmoItems.BERRY_DOUBLE_POPSICLE.get(), CosmoItems.BLISTERBERRY_DOUBLE_POPSICLE.get()
        );
        this.addBlock(
                CosmoBlocks.IRON_FIDDLEHEAD_CRATE.get(), CosmoBlocks.FIDDLEHEAD_CRATE.get(), CosmoBlocks.BIRCH_SAP_BLOCK.get(), CosmoBlocks.BERRY_SYRUP_BLOCK.get(), CosmoBlocks.SOURCE_BERRY_ICE_CREAM_BRICKS.get(), CosmoBlocks.ENCHANTED_FRUIT_ICE_CREAM_BRICKS.get(), CosmoBlocks.KABLOOM_ICE_CREAM_BRICKS.get(), CosmoBlocks.GLOW_BERRY_ICE_CREAM_BRICKS.get(), CosmoBlocks.CARROT_ICE_CREAM_BRICKS.get(), CosmoBlocks.APPLE_ICE_CREAM_BRICKS.get(), CosmoBlocks.STRAWBERRY_ICE_CREAM_BRICKS.get(), CosmoBlocks.CHOCOLATE_ICE_CREAM_BRICKS.get(), CosmoBlocks.VANILLA_ICE_CREAM_BRICKS.get(), CosmoBlocks.MINT_ICE_CREAM_BRICKS.get(), CosmoBlocks.BANANA_ICE_CREAM_BRICKS.get(), CosmoBlocks.ADZUKI_ICE_CREAM_BRICKS.get(),
                CosmoBlocks.GLOW_PETALS.get(), CosmoBlocks.SOURCE_BERRY_MILKSHAKE_CAULDRON.get(), CosmoBlocks.KABLOOM_MILKSHAKE_CAULDRON.get(), CosmoBlocks.ENCHANTED_FRUIT_MILKSHAKE_CAULDRON.get(), CosmoBlocks.GLOW_BERRY_MILKSHAKE_CAULDRON.get(), CosmoBlocks.CARROT_MILKSHAKE_CAULDRON.get(), CosmoBlocks.APPLE_MILKSHAKE_CAULDRON.get(), CosmoBlocks.SAPPY_BIRCH_LOG.get(), CosmoBlocks.LIFELIGHT.get(), CosmoBlocks.COPPER_FROZEN_DESSERT_TUB.get(), CosmoBlocks.IRON_FROZEN_DESSERT_TUB.get(), CosmoBlocks.NETHERITE_FROZEN_DESSERT_TUB.get(), CosmoBlocks.MASHED_POTATO_BLOCK.get(), CosmoBlocks.WHEATGRASS_BALE.get(),
                CosmoBlocks.CHISELED_ADZUKI_ICE_CREAM_BLOCK.get(), CosmoBlocks.CHISELED_BANANA_ICE_CREAM_BLOCK.get(), CosmoBlocks.CHISELED_CHOCOLATE_ICE_CREAM_BLOCK.get(), CosmoBlocks.CHISELED_MINT_ICE_CREAM_BLOCK.get(), CosmoBlocks.CHISELED_STRAWBERRY_ICE_CREAM_BLOCK.get(), CosmoBlocks.CHISELED_VANILLA_ICE_CREAM_BLOCK.get(),
                CosmoBlocks.GLOWY_ICE_CREAM_BRICKS.get(), CosmoBlocks.FLAVORED_ICE_CREAM_BRICKS.get(), CosmoBlocks.CHERRY_ICE_CREAM_BRICKS.get(), CosmoBlocks.TORCHBERRY_ICE_CREAM_BRICKS.get(), CosmoBlocks.PHYTOCHEMICAL_ICE_CREAM_BRICKS.get(), CosmoBlocks.GLACIER_ICE_CREAM_BRICKS.get(), CosmoBlocks.AURORA_ICE_CREAM_BRICKS.get(), CosmoBlocks.SALMONBERRY_ICE_CREAM_BRICKS.get(), CosmoBlocks.MATCHA_ICE_CREAM_BRICKS.get(), CosmoBlocks.POMEGRANATE_ICE_CREAM_BRICKS.get(), CosmoBlocks.LIME_ICE_CREAM_BRICKS.get(), CosmoBlocks.CHORUS_FRUIT_ICE_CREAM_BRICKS.get(), CosmoBlocks.WARZIPAN_ICE_CREAM_BRICKS.get(), CosmoBlocks.AZURE_BERRY_ICE_CREAM_BRICKS.get(), CosmoBlocks.JELLY_RING_ICE_CREAM_BRICKS.get(), CosmoBlocks.MIDNIGHT_ICE_CREAM_BRICKS.get(), CosmoBlocks.STARCLOUD_ICE_CREAM_BRICKS.get(), CosmoBlocks.BEETROOT_ICE_CREAM_BRICKS.get(), CosmoBlocks.SWEET_BERRY_ICE_CREAM_BRICKS.get(), CosmoBlocks.PUMPKIN_ICE_CREAM_BRICKS.get(), CosmoBlocks.ALOE_ICE_CREAM_BRICKS.get(), CosmoBlocks.PASSION_FRUIT_ICE_CREAM_BRICKS.get(), CosmoBlocks.YUCCA_ICE_CREAM_BRICKS.get(), CosmoBlocks.GREEN_TEA_ICE_CREAM_BRICKS.get(), CosmoBlocks.YELLOW_TEA_ICE_CREAM_BRICKS.get(), CosmoBlocks.BLACK_TEA_ICE_CREAM_BRICKS.get(), CosmoBlocks.COFFEE_ICE_CREAM_BRICKS.get(),
                CosmoBlocks.CHERRY_ICE_CREAM_BLOCK.get(), CosmoBlocks.TORCHBERRY_ICE_CREAM_BLOCK.get(), CosmoBlocks.PHYTOCHEMICAL_ICE_CREAM_BLOCK.get(), CosmoBlocks.GLACIER_ICE_CREAM_BLOCK.get(), CosmoBlocks.AURORA_ICE_CREAM_BLOCK.get(), CosmoBlocks.APPLE_ICE_CREAM_BLOCK.get(), CosmoBlocks.CARROT_ICE_CREAM_BLOCK.get(), CosmoBlocks.GLOW_BERRY_ICE_CREAM_BLOCK.get(), CosmoBlocks.ENCHANTED_FRUIT_ICE_CREAM_BLOCK.get(), CosmoBlocks.KABLOOM_ICE_CREAM_BLOCK.get(), CosmoBlocks.SOURCE_BERRY_ICE_CREAM_BLOCK.get()
        );
        this.addBasket(
                CosmoBlocks.WILDBERRIES_BASKET.get()
        );
        this.addPotion(
                CosmoEffects.IRON_HEART.get(), CosmoEffects.IRON_HEART_LONG.get(), CosmoEffects.IRON_HEART_STRONG.get()
        );
        this.addFluidType(
                CosmoFluids.SMOGGY_APEROL_TYPE.get(), CosmoFluids.TWILIGHT_CHARTREUSE_TYPE.get(), CosmoFluids.STEELEAF_NECTAR_TYPE.get(), CosmoFluids.BERRY_SYRUP_TYPE.get(), CosmoFluids.BIRCH_SAP_TYPE.get(), CosmoFluids.ROOT_BEER_TYPE.get(), CosmoFluids.WILDBERRY_PUNCH_TYPE.get(), CosmoFluids.CONDENSED_MILK_TYPE.get(), CosmoFluids.CREAM_TYPE.get(), CosmoFluids.VANILLA_ICE_CREAM_TYPE.get(), CosmoFluids.STRAWBERRY_ICE_CREAM_TYPE.get(), CosmoFluids.CHOCOLATE_ICE_CREAM_TYPE.get(), CosmoFluids.MINT_ICE_CREAM_TYPE.get(), CosmoFluids.ADZUKI_ICE_CREAM_TYPE.get(), CosmoFluids.BANANA_ICE_CREAM_TYPE.get(), CosmoFluids.APPLE_ICE_CREAM_TYPE.get(), CosmoFluids.CARROT_ICE_CREAM_TYPE.get(), CosmoFluids.GLOW_BERRY_ICE_CREAM_TYPE.get(), CosmoFluids.ALOE_ICE_CREAM_TYPE.get(), CosmoFluids.PASSION_FRUIT_ICE_CREAM_TYPE.get(), CosmoFluids.YUCCA_ICE_CREAM_TYPE.get(), CosmoFluids.BEETROOT_ICE_CREAM_TYPE.get(), CosmoFluids.SWEET_BERRY_ICE_CREAM_TYPE.get(), CosmoFluids.PUMPKIN_ICE_CREAM_TYPE.get(), CosmoFluids.LIME_ICE_CREAM_TYPE.get(), CosmoFluids.POMEGRANATE_ICE_CREAM_TYPE.get(), CosmoFluids.MATCHA_ICE_CREAM_TYPE.get(), CosmoFluids.SALMONBERRY_ICE_CREAM_TYPE.get(), CosmoFluids.CHORUS_FRUIT_ICE_CREAM_TYPE.get(), CosmoFluids.WARZIPAN_ICE_CREAM_TYPE.get(), CosmoFluids.JELLY_RING_ICE_CREAM_TYPE.get(), CosmoFluids.AZURE_BERRY_ICE_CREAM_TYPE.get(), CosmoFluids.MIDNIGHT_ICE_CREAM_TYPE.get(), CosmoFluids.STARCLOUD_ICE_CREAM_TYPE.get(), CosmoFluids.KABLOOM_ICE_CREAM_TYPE.get(), CosmoFluids.SOURCE_BERRY_ICE_CREAM_TYPE.get(), CosmoFluids.ENCHANTED_FRUIT_ICE_CREAM_TYPE.get(),
                CosmoFluids.CHERRY_ICE_CREAM_TYPE.get(), CosmoFluids.GLOWY_ICE_CREAM_TYPE.get(), CosmoFluids.FLAVORED_ICE_CREAM_TYPE.get(), CosmoFluids.BLACK_TEA_ICE_CREAM_TYPE.get(), CosmoFluids.COFFEE_ICE_CREAM_TYPE.get(), CosmoFluids.GREEN_TEA_ICE_CREAM_TYPE.get(), CosmoFluids.YELLOW_TEA_ICE_CREAM_TYPE.get(), CosmoFluids.AURORA_ICE_CREAM_TYPE.get(), CosmoFluids.PHYTOCHEMICAL_ICE_CREAM_TYPE.get(), CosmoFluids.GLACIER_ICE_CREAM_TYPE.get(), CosmoFluids.TORCHBERRY_ICE_CREAM_TYPE.get()
        );

        this.addEffect("Gain a small amount of extra health at the end of the duration. It will be removed if the user takes damage before it ends.", CosmoEffects.EXUBERANT.get());
        this.addEffect("This effect activates after the player has consumed enough carrot-based food, canceling the flickering of the Night Vision and converting some of the visual obstruction effects to Night Vision.", CosmoEffects.CAROTENE.get());
        this.addEffect("The user will leave a glowing trail on the blocks they pass over.", CosmoEffects.MARKED.get());
        this.addEffect("The user's ranged attack will mark and blind the first living target they hit.", CosmoEffects.TRACER.get());

        this.addEffect("Summons a temporary glowing block upon killing a monster. While in The Undergarden, this block also provides healing.", CosmoEffects.ABYSMAL_TORCH.get());
        this.addEffect("When the user attacks or takes damage, the outgoing damage has a chance to be doubled. While in The Undergarden, this extra damage becomes an explosion.", CosmoEffects.VARDOGER.get());

        this.addEffect("The original effect of the item could not be applied because the compatible mod was not installed.", CosmoEffects.PLACEHOLDER.get());

        this.add("tooltip." + Cosmopolitan.MODID + ".wheatgrass.when_feeding", "When fed to a tamed Cat:");
        this.add("tooltip." + Cosmopolitan.MODID + ".seasonal_drink.when_consumed.in_spring", "When consumed in Spring:");
        this.add("tooltip." + Cosmopolitan.MODID + ".seasonal_drink.when_consumed.in_summer", "When consumed in Summer:");
        this.add("tooltip." + Cosmopolitan.MODID + ".seasonal_drink.when_consumed.in_autumn", "When consumed in Autumn:");
        this.add("tooltip." + Cosmopolitan.MODID + ".seasonal_drink.when_consumed.in_winter", "When consumed in Winter:");

        this.add("tooltip." + Cosmopolitan.MODID + ".seasoned.condensed_milk", "Smooth");
        this.add("tooltip." + Cosmopolitan.MODID + ".seasoned.cream", "Luscious");

        this.add("tooltip." + Cosmopolitan.MODID + ".cream.when_consumed", "Randomly increases or decreases the duration of 1 effect");
        this.add("tooltip." + Cosmopolitan.MODID + ".cream_bucket.when_consumed", "Randomly increases or decreases the duration of all effects");

        this.add("tooltip." + Cosmopolitan.MODID + ".condensed_milk_bottle.when_consumed", "Clears One Level 1 Effect");
        this.add("tooltip." + Cosmopolitan.MODID + ".condensed_milk_bucket.when_consumed", "Clears All Level 1 Effects");

        this.add("tooltip." + Cosmopolitan.MODID + ".seasonal_drink.when_consumed.cold", "Clears Fire");
        this.add("tooltip." + Cosmopolitan.MODID + ".seasonal_drink.when_consumed.hot", "Clears Freeze");

        this.add("tooltip." + Cosmopolitan.MODID + ".birch_sap_bottle.when_consumed", "Clears Mining Fatigue");
        this.add("tooltip." + Cosmopolitan.MODID + ".root_beer.when_consumed", "Converts Mining Fatigue into Haste");
        this.add("tooltip." + Cosmopolitan.MODID + ".berry_syrup_bottle.when_consumed", "Clears Weakness");
        this.add("tooltip." + Cosmopolitan.MODID + ".wildberry_punch.when_consumed", "Converts Weakness into Strength");

        this.addJeiItemDescriptions("Fiddlehead can be dropped when breaking fern or large fern.", CosmoItems.FIDDLEHEAD.get());
        this.addJeiItemDescriptions("Wildberry can be dropped when breaking grass or tall grass.", CosmoItems.WILDBERRY.get());
        this.addJeiItemDescriptions("Wheatgrass can be obtained by harvesting a wheat crop that is in the middle of its growth phase.", CosmoItems.WHEATGRASS.get());
        this.addJeiItemDescriptions("A kind of edible golem that can split into 4 small, edible pieces after eating. It will slowly restore if the player has more than 4 pieces in their inventory and might change its form if the restore takes place in some specific biomes.", CosmoItems.GULIME.get());
        this.addJeiItemDescriptions("The player can share this type of popsicle with most creatures they meet.", CosmoItems.BLISTERBERRY_DOUBLE_POPSICLE.get());
        this.addJeiItemDescriptions("Condensed milk can be used in crafting recipes in place of milk; foods crafted with it will be slightly faster to consume.", CosmoItems.CONDENSED_MILK_BUCKET.get());
        this.addJeiItemDescriptions("Cream can be used in crafting recipes in place of milk; foods crafted with it will restore extra hunger points.", CosmoItems.CREAM_BUCKET.get());

        this.addJeiItemDescriptions("Frozen Dessert Tubs are a type of specialised block used for crafting and storing ice cream from the Neapolitan and its add-ons. Firstly, pour milk into the tub and add sugar to begin the transformation into condensed milk. Once the tub is closed, the condensed milk will gradually turn into cream. Place an ice or snow block nearby, add flavor ingredients to the cream, and you will have a tub of ice cream.", CosmoBlocks.IRON_FROZEN_DESSERT_TUB.get());

        this.add("item_group." + Cosmopolitan.MODID + ".tab", "Cosmopolitan");
    }

    private void addBlock(Block... blocks) {
        for (Block block : blocks)
            this.add(block, format(Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block))));
    }

    private void addBasket(Block... blocks) {
        for (Block block : blocks)
            this.add(block, "Basket of " + format(Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block))).replace(" Basket", ""));
    }

    private void addFluidType(FluidType... fluidTypes) {
        for (FluidType fluidType : fluidTypes) {
            ResourceLocation id = ForgeRegistries.FLUID_TYPES.get().getKey(fluidType);
            String key = "fluid_type." + id.getNamespace() + "." + id.getPath();
            add(key, format(id));
        }
    }

    private void addPotion(Potion... potions) {
        for (Potion potion : potions) {
            ResourceLocation id = ForgeRegistries.POTIONS.getKey(potion);
            String key = "item.minecraft.potion.effect." + id.getPath();
            add(key, "Potion of " + format(id).replace(" Long", "").replace(" Strong", ""));
            String key2 = "item.minecraft.splash_potion.effect." + id.getPath();
            add(key2,  "Splash Potion of " + format(id).replace(" Long", "").replace(" Strong", ""));
            String key3 = "item.minecraft.lingering_potion.effect." + id.getPath();
            add(key3,  "Lingering Potion of " + format(id).replace(" Long", "").replace(" Strong", ""));
            String key4 = "item.minecraft.tipped_arrow.effect." + id.getPath();
            add(key4,  "Arrow of " + format(id).replace(" Long", "").replace(" Strong", ""));
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

    private void addDoublePopsicle(Item... items) {
        for (Item item : items)
            this.add(item, "Double " + format(Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(item))).replace(" Double", ""));
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

    private void addJeiItemDescriptions(String description, Block... blocks) {
        for (Block block : blocks) {
            ResourceLocation id = Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block));
            String key = "jei." + id.getNamespace() + "." + id.getPath() + ".desc";
            add(key, description);
        }
    }

    private String format(ResourceLocation registryName) {
        return WordUtils.capitalizeFully(registryName.getPath().replace("_", " "));
    }

}

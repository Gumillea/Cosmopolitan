package com.gumillea.cosmopolitan.core.util.jei;

import com.gumillea.cosmopolitan.Cosmopolitan;
import com.gumillea.cosmopolitan.core.reg.CosmoBlocks;
import com.gumillea.cosmopolitan.core.reg.CosmoItems;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

@JeiPlugin
@ParametersAreNonnullByDefault
public class CosmoJEIPlugin implements IModPlugin {
    public static final ResourceLocation ID = new ResourceLocation(Cosmopolitan.MODID, "jei_plugin");

    private static final List<Supplier<Item>> INFO_ITEMS = List.of(
            CosmoItems.FIDDLEHEAD, CosmoItems.WILDBERRY, CosmoItems.WHEATGRASS, CosmoItems.BLISTERBERRY_DOUBLE_POPSICLE
    );

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        for (Supplier<Item> itemSupplier : INFO_ITEMS) {
            Item item = itemSupplier.get();
            ResourceLocation key = Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(item));
            String translationKey = "jei." + Cosmopolitan.MODID + "." + key.getPath() + ".desc";

            registration.addIngredientInfo(
                    new ItemStack(item),
                    VanillaTypes.ITEM_STACK,
                    Component.translatable(translationKey)
            );
        }

        registration.addIngredientInfo(
                List.of(
                        new ItemStack(CosmoItems.GULIME.get()),
                        new ItemStack(CosmoItems.UNDERGROUND_GULIME.get()),
                        new ItemStack(CosmoItems.TAIGA_GULIME.get()),
                        new ItemStack(CosmoItems.CHORUS_GULIME.get()),
                        new ItemStack(CosmoItems.GULIME_SMALL.get()),
                        new ItemStack(CosmoItems.UNDERGROUND_GULIME_SMALL.get()),
                        new ItemStack(CosmoItems.TAIGA_GULIME_SMALL.get()),
                        new ItemStack(CosmoItems.CHORUS_GULIME_SMALL.get())
                ),
                VanillaTypes.ITEM_STACK,
                Component.translatable("jei." + Cosmopolitan.MODID + ".gulime.desc")
        );

        registration.addIngredientInfo(
                List.of(
                        new ItemStack(CosmoItems.CONDENSED_MILK_BUCKET.get()),
                        new ItemStack(CosmoItems.CONDENSED_MILK_BOTTLE.get())
                ),
                VanillaTypes.ITEM_STACK,
                Component.translatable("jei." + Cosmopolitan.MODID + ".condensed_milk_bucket.desc")
        );

        registration.addIngredientInfo(
                List.of(
                        new ItemStack(CosmoItems.CREAM_BUCKET.get()),
                        new ItemStack(CosmoItems.CREAM.get())
                ),
                VanillaTypes.ITEM_STACK,
                Component.translatable("jei." + Cosmopolitan.MODID + ".cream_bucket.desc")
        );

        registration.addIngredientInfo(
                List.of(
                        new ItemStack(CosmoBlocks.COPPER_FROZEN_DESSERT_TUB.get()),
                        new ItemStack(CosmoBlocks.IRON_FROZEN_DESSERT_TUB.get())
                ),
                VanillaTypes.ITEM_STACK,
                Component.translatable("jei." + Cosmopolitan.MODID + ".frozen_dessert_tub.desc")
        );
    }
    @Override
    public ResourceLocation getPluginUid() {
        return ID;
    }
}


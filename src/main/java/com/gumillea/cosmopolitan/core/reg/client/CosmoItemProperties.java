package com.gumillea.cosmopolitan.core.reg.client;

import com.gumillea.cosmopolitan.CosmoConfig;
import com.gumillea.cosmopolitan.core.misc.BerrfectFlavorHelper;
import com.gumillea.cosmopolitan.core.reg.CosmoItems;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

import java.util.List;

public class CosmoItemProperties {

    public static List<Item> USING = List.of(
            CosmoItems.TUBER_CHIP_BAG.get(),
            CosmoItems.MOJANG_MESS.get(),
            CosmoItems.ETON_MESS.get()
    );

    public static List<Item> FLAVOR_TYPE = List.of(
            CosmoItems.BERRY_SYRUP_BOTTLE.get(),
            CosmoItems.BERRY_CHEESECAKE_BAR.get(),
            CosmoItems.BERRY_SYRUP_AMERICANO.get(),
            CosmoItems.BERRY_SYRUP_GUMMY.get(),
            CosmoItems.BERRY_SYRUP_SHAVED_ICE.get(),
            CosmoItems.BERRY_SYRUP_SHAVED_ICE_CONE.get(),
            CosmoItems.BERRY_POPSICLE.get(),
            CosmoItems.BERRY_DOUBLE_POPSICLE.get()
    );

    public static void registerItemProperties() {
        // Based on the item property implementation from Snowy Spirit by MehVahdJukaar: https://github.com/MehVahdJukaar/SnowySpirit/blob/1.20/common/src/main/java/net/mehvahdjukaar/snowyspirit/reg/ClientRegistry.java
        ItemProperties.register(CosmoItems.WILDBERRY.get(), new ResourceLocation("shape"), (stack, level, entity, s) -> (stack.hasTag() && stack.getTag().contains("icon")) || !CosmoConfig.Client.WILDBERRY_DISPLAY.get() ? 0F : (System.identityHashCode(stack) % 9) / 8F);

        for (Item item : USING) {
            ItemProperties.register(item, new ResourceLocation("using"), (stack, level, entity, s) -> (entity != null && entity.isUsingItem() && entity.getUseItem() == stack) ? 1.0F : 0.0F);
        }

        for (Item item : FLAVOR_TYPE) {
            ItemProperties.register(item, new ResourceLocation("flavor_type"), (stack, level, entity, s) -> {
                CompoundTag tag = stack.getTag();
                if (!CosmoConfig.Common.FLAVORED_SYRUP.get() || tag == null) return 0.0F;

                String flavor = stack.getTag().getString(BerrfectFlavorHelper.KEY);

                return switch (flavor) {
                    case "sour" -> 1.0F;
                    case "bitter" -> 2.0F;
                    case "spicy" -> 3.0F;
                    case "strange" -> 4.0F;
                    default -> 0.0F;
                };
            });
        }

    }

}

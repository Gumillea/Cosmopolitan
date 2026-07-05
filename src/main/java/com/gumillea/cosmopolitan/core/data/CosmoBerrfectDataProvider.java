package com.gumillea.cosmopolitan.core.data;

import com.gumillea.cosmopolitan.core.reg.CosmoItems;
import com.gumillea.cosmopolitan.core.util.CosmoCompat;
import com.gumillea.cosmopolitan.core.util.CosmoItemTags;
import com.gumillea.exquisito.core.util.tags.ExquisitoItemTags;
import net.minecraft.data.PackOutput;

public class CosmoBerrfectDataProvider extends BerrfectDataProvider {

    public CosmoBerrfectDataProvider(PackOutput output) {
        super(output);
    }

    @Override
    public void generate() {
        add(CosmoItemTags.SWEET_BERRY, 1, 3, 0, 0);
        add(CosmoItemTags.GLOW_BERRY, 2, 1, 1, 0);
        add(CosmoItemTags.STRAWBERRY, 2, 3, 0, 0);
        add(CosmoItemTags.SALMONBERRIES, 3, 2, 0, 1);
        add(CosmoItemTags.BLUEBERRY, 1, 2, 0, 0);
        add(CosmoItemTags.CRANBERRY, 5, 0, 1, 0);
        add(CosmoItemTags.BAYBERRY, 2, 2, 1, 0);
        add(CosmoItemTags.CHERRY, 4, 2, 0, 0);
        add(CosmoItemTags.CURRANT, 3, 2, 1, 0);
        add(CosmoItemTags.MULBERRY, 2, 2, 0, 0);
        add(CosmoItemTags.ELDERBERRY, 2, 0, 5, 0);
        add(ExquisitoItemTags.STARCLOUD_INGREDIENTS, 0, 5, 0, 0);
        add(ExquisitoItemTags.MIDNIGHT_INGREDIENTS, 0, 0, 5, 0);

        add(CosmoItems.ARBUTUS_BERRIES.get(), 1, 1, 0, 0);
        add(CosmoItems.BOILBERRY.get(), 1, 0, 0, 3);
        add(CosmoItems.SPINALBERRY.get(), 0, 1, 3, 0);

        add(CosmoCompat.TORCHBERRIES, 0, 1, 2, 1);
        add(CosmoCompat.SOURCEBERRY, 3, 2, 1, 0);
        add(CosmoCompat.BLISTERBERRY, 1, 2, 2, 2);
        add(CosmoCompat.DROOPFRUIT, 0, 3, 1, 0);
        add(CosmoCompat.WILD_BERRIES, 2, 2, 0, 0);
        add(CosmoCompat.GEARO_BERRY, 2, 2, 0, 1);
        add(CosmoCompat.SOUL_BERRY, 0, 2, 4, 0);
        add(CosmoCompat.WITHER_BERRY, 0, 0, 2, 4);
        add(CosmoCompat.FROST_BERRIES, 1, 3, 1, 0);
    }
}
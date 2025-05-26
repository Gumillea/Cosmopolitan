package com.gumillea.cosmopolitan.common.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;

public class DoublePopsicleItem extends FrozenDessertItem{

    private final RegistryObject<Item> result;

    public DoublePopsicleItem(Properties properties, boolean bowl, int tFrozen, RegistryObject<Item> result) {
        super(properties, bowl, tFrozen);
        this.result = result;
    }

    public RegistryObject<Item> getResult() {
        return result;
    }
}

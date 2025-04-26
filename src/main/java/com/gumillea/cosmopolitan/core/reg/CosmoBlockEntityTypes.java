package com.gumillea.cosmopolitan.core.reg;

import com.gumillea.cosmopolitan.Cosmopolitan;
import com.gumillea.cosmopolitan.common.blockEntity.FrozenDessertTubBlockEntity;
import com.teamabnormals.blueprint.core.util.registry.BlockEntitySubRegistryHelper;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

@Mod.EventBusSubscriber(modid = Cosmopolitan.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CosmoBlockEntityTypes {
    public static final BlockEntitySubRegistryHelper HELPER = Cosmopolitan.REGISTRY_HELPER.getBlockEntitySubHelper();

    public static final RegistryObject<BlockEntityType<FrozenDessertTubBlockEntity>> FROZEN_DESSERT_TUB = HELPER.createBlockEntity("frozen_dessert_tub", FrozenDessertTubBlockEntity::new, () -> Set.of(CosmoBlocks.FROZEN_DESSERT_TUB.get()));
}
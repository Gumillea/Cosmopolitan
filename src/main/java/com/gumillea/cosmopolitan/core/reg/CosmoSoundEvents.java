package com.gumillea.cosmopolitan.core.reg;

import com.gumillea.cosmopolitan.Cosmopolitan;
import com.teamabnormals.blueprint.core.util.registry.SoundSubRegistryHelper;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;


@Mod.EventBusSubscriber(modid = Cosmopolitan.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CosmoSoundEvents {
    public static final SoundSubRegistryHelper HELPER = Cosmopolitan.REGISTRY_HELPER.getSoundSubHelper();

    public static final RegistryObject<SoundEvent> MUSIC_DISC_WOC = HELPER.createSoundEvent("music_disc.woc");
}

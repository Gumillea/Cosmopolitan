package com.gumillea.cosmopolitan.core.reg;

import com.gumillea.cosmopolitan.Cosmopolitan;
import net.minecraft.network.chat.Component;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.PathPackResources;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraftforge.event.AddPackFindersEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class CosmoResourcePacks {

    public CosmoResourcePacks() {
        FMLJavaModLoadingContext.get().getModEventBus().register(this);
    }

    public static void addPackFinders(AddPackFindersEvent event)
    {
        if (event.getPackType() == PackType.CLIENT_RESOURCES)
        {
            var resourcePath = ModList.get().getModFileById(Cosmopolitan.MODID).getFile().findResource("resourcepacks/cosmopolitan_tweaks");
            var pack = Pack.readMetaAndCreate("cosmopolitan:cosmopolitan_tweaks", Component.literal("Cosmopolitan Tweaks"), false,
                    (path) -> new PathPackResources(path, resourcePath, false), PackType.CLIENT_RESOURCES, Pack.Position.TOP, PackSource.BUILT_IN);
            event.addRepositorySource((packConsumer) -> packConsumer.accept(pack));
        }
    }
}
package com.gumillea.cosmopolitan.core.reg;

import com.gumillea.cosmopolitan.Cosmopolitan;
import net.minecraft.network.chat.Component;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.PathPackResources;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraftforge.event.AddPackFindersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Cosmopolitan.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CosmoResourcePacks {

    @SubscribeEvent
    public static void addPackFinders(AddPackFindersEvent event) {
        if (event.getPackType() == PackType.CLIENT_RESOURCES)
        {
            var resourcePath = ModList.get().getModFileById(Cosmopolitan.MODID).getFile().findResource("resourcepacks/cosmopolitan_tweaks");
            var pack = Pack.readMetaAndCreate("cosmopolitan:cosmopolitan_tweaks", Component.literal("Cosmopolitan Tweaks"), false,
                    (path) -> new PathPackResources(path, resourcePath, false), PackType.CLIENT_RESOURCES, Pack.Position.TOP, PackSource.BUILT_IN);

            var resourcePath2 = ModList.get().getModFileById(Cosmopolitan.MODID).getFile().findResource("resourcepacks/cosmopolitan_vanilla");
            var pack2 = Pack.readMetaAndCreate("cosmopolitan:cosmopolitan_vanilla", Component.literal("Cosmopolitan Vanilla"), false,
                    (path) -> new PathPackResources(path, resourcePath2, false), PackType.CLIENT_RESOURCES, Pack.Position.TOP, PackSource.BUILT_IN);

            event.addRepositorySource((consumer) -> {
                consumer.accept(pack);
                consumer.accept(pack2);
            });
        }
    }
}
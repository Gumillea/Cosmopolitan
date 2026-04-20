package com.gumillea.cosmopolitan.core.data.tags;

import com.gumillea.cosmopolitan.Cosmopolitan;
import com.gumillea.cosmopolitan.core.util.CosmoEffectTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.IntrinsicHolderTagsProvider;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.concurrent.CompletableFuture;

public class CosmoEffectTagsProvider extends IntrinsicHolderTagsProvider<MobEffect> {
    public CosmoEffectTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> provider, ExistingFileHelper helper) {
        super(output, Registries.MOB_EFFECT, provider, (effect) -> ForgeRegistries.MOB_EFFECTS.getResourceKey(effect).get(), Cosmopolitan.MODID, helper);
    }

    protected void addTags(HolderLookup.Provider provider) {
        this.tag(CosmoEffectTags.BLACKLIST)
                .add(MobEffects.BAD_OMEN, MobEffects.HERO_OF_THE_VILLAGE);
    }
}

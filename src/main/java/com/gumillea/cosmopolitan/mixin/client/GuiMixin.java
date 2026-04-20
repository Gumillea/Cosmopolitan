package com.gumillea.cosmopolitan.mixin.client;

import com.gumillea.cosmopolitan.CosmoConfig;
import com.gumillea.cosmopolitan.Cosmopolitan;
import com.gumillea.cosmopolitan.core.util.CosmoUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.registries.ForgeRegistries;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Collection;
import java.util.Comparator;

@Mixin(Gui.class)
public abstract class GuiMixin {
    @Unique
    private static final ResourceLocation BERRFECT_BACKGROUNDS = CosmoUtils.id(Cosmopolitan.MODID, "textures/gui/container/berrfect_backgrounds.png");

    @Inject(method = "renderEffects", at = @At(value = "INVOKE", target = "Ljava/util/List;forEach(Ljava/util/function/Consumer;)V", shift = At.Shift.BEFORE))
    private void berrfect$overrideBackgrounds(GuiGraphics graphics, CallbackInfo ci) {
        Minecraft mc = Minecraft.getInstance();
        Player player = mc.player;
        if (!CosmoConfig.Client.SEASONED_EFFECT_ICON.get()) return;
        if (player == null) return;

        CompoundTag berrfect = player.getPersistentData().getCompound("Berrfect");
        Collection<MobEffectInstance> effects = player.getActiveEffects();

        int j1 = 0;
        int k1 = 0;
        int screenWidth = mc.getWindow().getGuiScaledWidth();

        for (MobEffectInstance inst : effects.stream().sorted(Comparator.reverseOrder()).toList()) {
            var renderer = net.minecraftforge.client.extensions.common.IClientMobEffectExtensions.of(inst);
            if (!renderer.isVisibleInGui(inst)) continue;
            if (!inst.showIcon()) continue;

            String id = ForgeRegistries.MOB_EFFECTS.getKey(inst.getEffect()).toString();

            int i = screenWidth;
            int j = 1;

            if (mc.isDemo()) j += 15;

            if (inst.getEffect().isBeneficial()) {
                ++j1;
                i -= 25 * j1;
            } else {
                ++k1;
                i -= 25 * k1;
                j += 26;
            }

            if (!berrfect.contains(id)) continue;

            String flavor = berrfect.getString(id);

            int u = berrfect$uOffest(flavor);
            int v = 64;

            graphics.blit(BERRFECT_BACKGROUNDS, i, j, u, v, 24, 24, 256, 256);
        }
    }

    @Unique
    private int berrfect$uOffest(String flavor) {
        int index = switch (flavor) {
            case "spicy" -> 1;
            case "sour" -> 2;
            case "bitter" -> 3;
            case "strange" -> 4;
            default -> 0;
        };

        return 128 + index * 24;
    }
}


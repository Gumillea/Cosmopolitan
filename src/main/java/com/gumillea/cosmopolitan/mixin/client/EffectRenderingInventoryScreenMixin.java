package com.gumillea.cosmopolitan.mixin.client;

import com.gumillea.cosmopolitan.CosmoConfig;
import com.gumillea.cosmopolitan.Cosmopolitan;
import com.gumillea.cosmopolitan.core.util.CosmoUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.screens.inventory.EffectRenderingInventoryScreen;
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

@Mixin(EffectRenderingInventoryScreen.class)
public abstract class EffectRenderingInventoryScreenMixin {
    @Unique
    private static final ResourceLocation BERRFECT_BACKGROUNDS = CosmoUtils.id(Cosmopolitan.MODID, "textures/gui/container/berrfect_backgrounds.png");

    @Inject(method = "renderBackgrounds", at = @At("TAIL"))
    private void berrfect$overrideBackgrounds(GuiGraphics graphics, int x, int spacing, Iterable<MobEffectInstance> effects, boolean wide, CallbackInfo ci) {
        Player player = Minecraft.getInstance().player;
        if (!CosmoConfig.Client.SEASONED_EFFECT_ICON.get()) return;
        if (player == null) return;

        CompoundTag berrfect = player.getPersistentData().getCompound("Berrfect");
        if (berrfect.isEmpty()) return;

        int top = ((AbstractContainerScreen<?>) (Object) this).getGuiTop();
        int index = 0;

        for (MobEffectInstance inst : effects) {
            int y = top + index * spacing;
            String effectId = ForgeRegistries.MOB_EFFECTS.getKey(inst.getEffect()).toString();

            if (berrfect.contains(effectId)) {
                String flavor = berrfect.getString(effectId);
                int uOffset = "strange".equals(flavor) ? -128 : 0;
                graphics.blit(BERRFECT_BACKGROUNDS, x, y, uOffset, berrfect$vOffset(flavor, wide), wide ? 120 : 32, 32);
            } else {
                ResourceLocation location = AbstractContainerScreen.INVENTORY_LOCATION;
                if (wide) {
                    graphics.blit(location, x, y, 0, 166, 120, 32);
                } else {
                    graphics.blit(location, x, y, 0, 198, 32, 32);
                }
            }

            index++;
        }

    }

    @Unique
    private int berrfect$vOffset(String flavor, boolean isWide) {
        int index = switch (flavor) {
            case "spicy" -> 1;
            case "sour" -> 2;
            case "bitter" -> 3;
            default -> 0;
        };

        return index * 64 + (isWide ? 0 : 32);
    }
}
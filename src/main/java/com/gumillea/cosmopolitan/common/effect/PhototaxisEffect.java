package com.gumillea.cosmopolitan.common.effect;

import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.*;
import net.minecraft.world.level.LevelAccessor;

import java.util.Map;

public class PhototaxisEffect extends MobEffect {

    public PhototaxisEffect() {
        super(MobEffectCategory.BENEFICIAL, 0xB559B2);
        this.addAttributeModifier(Attributes.ATTACK_SPEED, "57A79E5A-56D2-B639-E7D5-4A0A09FADC6A", 0.02F, AttributeModifier.Operation.MULTIPLY_TOTAL);
    }

    @Override
    public void addAttributeModifiers(LivingEntity entity, AttributeMap map, int amplifier) {
        LevelAccessor level = entity.level();

        if (!level.isClientSide()) {
            double x = entity.getX();
            double y = entity.getY();
            double z = entity.getZ();
            BlockPos pos = BlockPos.containing(x, y, z);
            int light = level.getRawBrightness(pos, level.getSkyDarken()) + 1;
            float amount = entity.hasEffect(MobEffects.GLOWING) ? (amplifier + 1) * 16F : light * (amplifier + 1);

            for (Map.Entry<Attribute, AttributeModifier> entry : this.getAttributeModifiers().entrySet()) {
                AttributeInstance instance = map.getInstance(entry.getKey());
                if (instance != null) {
                    AttributeModifier modifier = entry.getValue();
                    instance.removeModifier(modifier);
                    instance.addTransientModifier(new AttributeModifier(modifier.getId(),
                            this.getDescriptionId() + " " + amplifier,
                            amount * this.getAttributeModifierValue(amplifier, modifier),
                            modifier.getOperation()));
                }
            }

        }
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        this.addAttributeModifiers(entity, entity.getAttributes(), amplifier);
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }
}
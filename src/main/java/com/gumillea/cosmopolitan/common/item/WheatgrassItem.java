package com.gumillea.cosmopolitan.common.item;

import com.google.common.collect.Lists;
import com.gumillea.cosmopolitan.Cosmopolitan;
import net.minecraft.ChatFormatting;
import net.minecraft.client.particle.Particle;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffectUtil;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.animal.Cat;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import vectorwing.farmersdelight.common.utility.MathUtils;

import javax.annotation.Nullable;
import java.util.List;

public class WheatgrassItem extends Item {

    public static final List<MobEffectInstance> EFFECTS = Lists.newArrayList(
            new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 6000, 0),
            new MobEffectInstance(MobEffects.REGENERATION, 6000, 0));

    public WheatgrassItem(Properties properties) {
        super(properties);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        MutableComponent whenFeeding = Component.translatable("tooltip." + Cosmopolitan.MODID + ".wheatgrass.when_feeding");
        tooltip.add(whenFeeding.withStyle(ChatFormatting.GRAY));

        for (MobEffectInstance effectinstance : EFFECTS) {
            MutableComponent effectDescription = Component.literal(" ");
            MutableComponent effectName = Component.translatable(effectinstance.getDescriptionId());
            effectDescription.append(effectName);
            MobEffect effect = effectinstance.getEffect();

            if (effectinstance.getAmplifier() > 0) {
                effectDescription.append(" ").append(Component.translatable("potion.potency." + effectinstance.getAmplifier()));
            }

            if (effectinstance.getDuration() > 20) {
                effectDescription.append(" (").append(MobEffectUtil.formatDuration(effectinstance, 1.0F)).append(")");
            }

            tooltip.add(effectDescription.withStyle(effect.getCategory().getTooltipFormatting()));
        }
    }

    @Mod.EventBusSubscriber(modid = Cosmopolitan.MODID)
    public static class WheatgrassEvent
    {
        @SubscribeEvent
        public static void onEntityInteract(PlayerInteractEvent.EntityInteract event) {
            Player player = event.getEntity();
            Entity target = event.getTarget();
            ItemStack stack = event.getItemStack();
            if (target instanceof Cat cat) {
                if (cat.isAlive() && cat.isTame() && stack.getItem() instanceof WheatgrassItem) {
                    for (MobEffectInstance effect : EFFECTS) {
                        cat.addEffect(new MobEffectInstance(effect));
                    }
                    cat.level().playSound(null, target.blockPosition(), SoundEvents.GENERIC_EAT, SoundSource.PLAYERS, 0.8F, 0.8F);

                    for (int i = 0; i < 5; ++i) {
                        double d0 = MathUtils.RAND.nextGaussian() * 0.02D;
                        double d1 = MathUtils.RAND.nextGaussian() * 0.02D;
                        double d2 = MathUtils.RAND.nextGaussian() * 0.02D;
                        cat.level().addParticle(ParticleTypes.HAPPY_VILLAGER, cat.getRandomX(1.0D), cat.getRandomY() + 0.5D, cat.getRandomZ(1.0D), d0, d1, d2);
                    }

                    if (stack.getCraftingRemainingItem() != ItemStack.EMPTY && !player.isCreative()) {
                        player.addItem(stack.getCraftingRemainingItem());
                        stack.shrink(1);
                    }

                    event.setCancellationResult(InteractionResult.SUCCESS);
                    event.setCanceled(true);
                }
            }
        }
    }

}

package com.gumillea.cosmopolitan.core.util;

import com.gumillea.cosmopolitan.CosmoConfig;
import com.gumillea.cosmopolitan.Cosmopolitan;
import com.gumillea.cosmopolitan.common.item.WheatgrassItem;
import com.gumillea.cosmopolitan.core.reg.CosmoEffects;
import com.gumillea.cosmopolitan.core.reg.CosmoItems;
import com.gumillea.exquisito.core.reg.ExquisitoEffects;
import com.teamabnormals.neapolitan.core.other.tags.NeapolitanMobEffectTags;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.WrappedGoal;
import net.minecraft.world.entity.animal.Cat;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.event.entity.living.MobEffectEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.tags.ITagManager;
import quek.undergarden.registry.UGDimensions;
import vectorwing.farmersdelight.common.utility.MathUtils;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Mod.EventBusSubscriber(modid = Cosmopolitan.MODID)
public class CosmoEvents {

    @SubscribeEvent
    public static void onEntityAttacked(LivingDamageEvent event) {
        DamageSource source = event.getSource();
        LivingEntity target = event.getEntity();
        if (target.getEffect(CosmoEffects.EXUBERANT.get()) != null) {
            target.removeEffect(CosmoEffects.EXUBERANT.get());
            if (target instanceof Player player){
                player.playSound(SoundEvents.AZALEA_BREAK, 1.5F, 1.0F);
            }
        }
        if (source.getEntity() instanceof LivingEntity attacker) {
            if (target.getEffect(CosmoEffects.VARDOGER.get()) != null && target.getRandom().nextFloat() < CosmoConfig.Common.BLISTERBERRY_CHANCE.get()) {
                handleVardoger(target.level(), target, event);
            }
            if (attacker.getEffect(CosmoEffects.VARDOGER.get()) != null && attacker.getRandom().nextFloat() < CosmoConfig.Common.BLISTERBERRY_CHANCE.get()) {
                handleVardoger(target.level(), target, event);
            }
            if (source.isIndirect() && source.getDirectEntity() instanceof Projectile) {
                if (attacker.getEffect(CosmoEffects.TRACER.get()) != null) {
                    int amplifier = Objects.requireNonNull(attacker.getEffect(CosmoEffects.TRACER.get())).getAmplifier() + 1;
                    target.addEffect(new MobEffectInstance(CosmoEffects.MARKED.get(), 300 * amplifier));
                    target.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 300 * amplifier));
                    attacker.removeEffect(CosmoEffects.TRACER.get());
                }
            }
        }
    }

    private static void handleVardoger(Level level, LivingEntity target, LivingDamageEvent event) {
        float amount = event.getAmount();

        target.playSound(SoundEvents.ELDER_GUARDIAN_CURSE, 1.5F, 1.0F);

        if (CosmoCompat.ug && level.dimension() == UGDimensions.UNDERGARDEN_LEVEL) {
            float power = amount < 10 ? amount / 2 : 5;
            level.explode(null, target.getX(), target.getY(), target.getZ(), power, Level.ExplosionInteraction.NONE);
        } else {
            event.setAmount(amount * 2);
        }
    }

    @SubscribeEvent
    public static void onItemUsed(LivingEntityUseItemEvent.Finish event) {
        ItemStack stack = event.getItem();
        Entity user = event.getEntity();
        if (user instanceof LivingEntity living && stack.isEdible()) {
            int nutrition = Objects.requireNonNull(stack.getFoodProperties(living)).getNutrition();
            int duration = nutrition < 10 ? 300 : 600;
            int amplifier = nutrition < 10 ? 0 : 1;
            if (CosmoConfig.Common.APPLE_FLAVOR.get() && stack.is(CosmoItemTags.EXUBERANT_SOURCES)){
                duration = nutrition < 10 ? 10 - nutrition : 9;
                living.addEffect(new MobEffectInstance(CosmoEffects.EXUBERANT.get(), duration * 300));
            }
            if (CosmoConfig.Common.GLOW_BERRY_FLAVOR.get() && stack.is(CosmoItemTags.TRACER_SOURCES)){
                living.addEffect(new MobEffectInstance(CosmoEffects.TRACER.get(), duration, amplifier));
            }
            if (CosmoConfig.Common.CARROT_FLAVOR.get() && stack.is(CosmoItemTags.CAROTENE_SOURCES)){
                living.addEffect(new MobEffectInstance(CosmoEffects.CAROTENE.get(), duration * 2));
            }
            if (CosmoConfig.Common.DROOPFRUIT_FLAVOR.get() && stack.is(CosmoItemTags.ABYSMAL_TORCH_SOURCES)){
                living.addEffect(new MobEffectInstance(CosmoEffects.ABYSMAL_TORCH.get(), (int) (duration * 0.75)));
            }
            if (CosmoConfig.Common.BLISTERBERRY_FLAVOR.get() && stack.is(CosmoItemTags.VARDOGER_SOURCES)){
                living.addEffect(new MobEffectInstance(CosmoEffects.VARDOGER.get(), (int) (duration * 1.5)));
            }
        }
    }

    @SubscribeEvent
    public static void onEffectApplied(MobEffectEvent.Applicable event) {
        MobEffect effect = event.getEffectInstance().getEffect();
        LivingEntity entity = event.getEntity();
        if (entity.getEffect(CosmoEffects.CAROTENE.get()) != null) {
            ITagManager<MobEffect> mobEffectTags = ForgeRegistries.MOB_EFFECTS.tags();
            if (mobEffectTags != null && mobEffectTags.getTag(CosmoEffectTags.CONVERTIBLE_BY_CAROTENE).contains(effect)) {
                entity.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 600));
                event.setResult(Event.Result.DENY);
            }
        }
    }

    @SubscribeEvent
    public static void onEffectAdded(MobEffectEvent.Added event) {
        MobEffect effect = event.getEffectInstance().getEffect();
        LivingEntity entity = event.getEntity();
        if (effect == CosmoEffects.MARKED.get() && entity instanceof PathfinderMob mob) {
            mob.setTarget(null);
            List<Goal> toRemove = mob.goalSelector.getAvailableGoals().stream().map(WrappedGoal::getGoal).filter(goal -> goal instanceof AvoidEntityGoal).toList();
            toRemove.forEach(mob.goalSelector::removeGoal);
            AvoidEntityGoal<Player> goal = new AvoidEntityGoal<>(mob, Player.class, 16.0F, 1.5D, 1.75D, EntitySelector.NO_CREATIVE_OR_SPECTATOR::test);
            mob.goalSelector.addGoal(1, goal);
        }
    }

    @SubscribeEvent
    public static void onEffectRemove(MobEffectEvent.Remove event) {
        MobEffect effect = Objects.requireNonNull(event.getEffectInstance()).getEffect();
        LivingEntity entity = event.getEntity();

        if (effect == CosmoEffects.MARKED.get() && entity instanceof PathfinderMob mob) {
            List<Goal> toRemove = mob.goalSelector.getAvailableGoals().stream().map(WrappedGoal::getGoal).filter(goal -> goal instanceof AvoidEntityGoal).toList();
            toRemove.forEach(mob.goalSelector::removeGoal);
        }
    }

    @SubscribeEvent
    public static void onLivingDeath(LivingDeathEvent event) {
        LivingEntity target = event.getEntity();
        if (target.getEffect(ExquisitoEffects.FUCHSIA_GOO.get()) != null) {
        }
    }

    @SubscribeEvent
    public static void onEntityInteract(PlayerInteractEvent.EntityInteract event) {
        Player player = event.getEntity();
        Entity target = event.getTarget();
        ItemStack stack = event.getItemStack();
        if (target instanceof LivingEntity living && stack.getItem() == CosmoItems.BLISTERBERRY_DOUBLE_POPSICLE.get()) {
            living.level().playSound(null, target.blockPosition(), SoundEvents.GENERIC_EAT, SoundSource.PLAYERS, 0.8F, 0.8F);
            living.addEffect(new MobEffectInstance(CosmoEffects.VARDOGER.get(), 500));
            if (player != null) {
                if (!player.getAbilities().instabuild) {
                    stack.shrink(1);
                    ItemStack popsicle = new ItemStack(CosmoItems.BLISTERBERRY_POPSICLE.get());

                    if (!player.getInventory().add(popsicle)) {
                        player.drop(popsicle, false);
                    }
                }
            }
            event.setCancellationResult(InteractionResult.SUCCESS);
            event.setCanceled(true);
        }
        if (target instanceof Cat cat) {
            if (cat.isAlive() && cat.isTame() && stack.getItem() instanceof WheatgrassItem) {
                for (MobEffectInstance effect : WheatgrassItem.EFFECTS) {
                    cat.addEffect(new MobEffectInstance(effect));
                }
                cat.level().playSound(null, target.blockPosition(), SoundEvents.GENERIC_EAT, SoundSource.PLAYERS, 0.8F, 0.8F);

                for (int i = 0; i < 5; ++i) {
                    double d0 = MathUtils.RAND.nextGaussian() * 0.02D;
                    double d1 = MathUtils.RAND.nextGaussian() * 0.02D;
                    double d2 = MathUtils.RAND.nextGaussian() * 0.02D;
                    cat.level().addParticle(ParticleTypes.HAPPY_VILLAGER, cat.getRandomX(1.0D), cat.getRandomY() + 0.5D, cat.getRandomZ(1.0D), d0, d1, d2);
                }

                if (player != null) {
                    if (!player.getAbilities().instabuild) {
                        stack.shrink(1);
                    }
                }

                event.setCancellationResult(InteractionResult.SUCCESS);
                event.setCanceled(true);
            }
        }
    }

    @SubscribeEvent
    public static void rightClickBlock(PlayerInteractEvent.RightClickBlock event) {
        if (!ModList.get().isLoaded("berry_good") || !CosmoConfig.Common.BERRY_GOOD_COMPAT_TWEAKS.get()) return;

        ItemStack stack = event.getItemStack();

        Map<String, List<Item>> compatMap = Map.of(
                CosmoCompat.AN, List.of(CosmoCompat.SOURCEBERRY),
                CosmoCompat.HA, List.of(CosmoCompat.KABLOOM),
                CosmoCompat.UG, List.of(CosmoCompat.BLISTERBERRY, CosmoCompat.DROOPFRUIT)
        );

        for (Map.Entry<String, List<Item>> entry : compatMap.entrySet()) {
            if (ModList.get().isLoaded(entry.getKey())) {
                for (Item berry : entry.getValue()) {
                    if (stack.is(berry)) {
                        event.setUseItem(Event.Result.DENY);
                        return;
                    }
                }
            }
        }
    }

}

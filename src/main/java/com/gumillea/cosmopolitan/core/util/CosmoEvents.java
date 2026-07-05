package com.gumillea.cosmopolitan.core.util;

import com.gumillea.cosmopolitan.CosmoConfig;
import com.gumillea.cosmopolitan.Cosmopolitan;
import com.gumillea.cosmopolitan.common.block.ExhaustedShroomlightBlock;
import com.gumillea.cosmopolitan.common.item.DoublePopsicleItem;
import com.gumillea.cosmopolitan.common.item.DoubleSplitPopsicleItem;
import com.gumillea.cosmopolitan.common.item.PottedCropItem;
import com.gumillea.cosmopolitan.common.item.WheatgrassItem;
import com.gumillea.cosmopolitan.core.misc.*;
import com.gumillea.cosmopolitan.core.reg.CosmoBlocks;
import com.gumillea.cosmopolitan.core.reg.CosmoEffects;
import com.gumillea.cosmopolitan.core.reg.CosmoItems;
import com.mojang.datafixers.util.Pair;
import com.teamabnormals.blueprint.core.util.TradeUtil;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.AddReloadListenerEvent;
import net.minecraftforge.event.entity.living.*;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerWakeUpEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.network.PacketDistributor;
import sereneseasons.init.ModConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.animal.Cat;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import quek.undergarden.registry.UGDimensions;
import sereneseasons.api.season.Season;
import sereneseasons.api.season.SeasonHelper;
import vectorwing.farmersdelight.common.registry.ModEffects;

import java.util.*;
import java.util.stream.StreamSupport;

@Mod.EventBusSubscriber(modid = Cosmopolitan.MODID)
public class CosmoEvents {

    private static final UUID SOUR_UUID = UUID.fromString("858fc950-466c-4e6a-8e75-a734bb170ced");

    @SubscribeEvent
    public static void onEntityAttacked(LivingDamageEvent event) {
        DamageSource source = event.getSource();
        LivingEntity target = event.getEntity();
        float amount = event.getAmount();
        if (target.hasEffect(CosmoEffects.INGRAINED.get())) {
            if (event.getSource() != target.damageSources().fellOutOfWorld() && event.getSource() != target.damageSources().starve()) {
                double y = target.getY();
                double maxHeight = target.level().getMaxBuildHeight();
                int segment = (int) ((1.0 - (y / maxHeight)) * 4);
                double reduction = Math.max(0, Math.min(segment, 4)) * 0.05;

                event.setAmount((float) (amount * (1 - reduction)));
            }
        }
        if (target.hasEffect(CosmoEffects.EXUBERANT.get())) {
            target.removeEffect(CosmoEffects.EXUBERANT.get());
            if (target instanceof Player player){
                player.playSound(SoundEvents.AZALEA_BREAK, 1.5F, 1.0F);
            }
        }
        if (source.getEntity() instanceof LivingEntity attacker) {
            if (target.hasEffect(CosmoEffects.OBSCURE.get())) {
                handleObscure(target, event);
            } else if (attacker.hasEffect(CosmoEffects.OBSCURE.get())) {
                handleObscure(attacker, event);
            }
            if (target.hasEffect(CosmoEffects.VARDOGER.get()) && target.getRandom().nextFloat() < CosmoConfig.Common.BLISTERBERRY_CHANCE.get()) {
                handleVardoger(target.level(), target, event);
            }
            if (attacker.hasEffect(CosmoEffects.VARDOGER.get()) && attacker.getRandom().nextFloat() < CosmoConfig.Common.BLISTERBERRY_CHANCE.get()) {
                handleVardoger(target.level(), target, event);
            }
            if (source.isIndirect() && source.getDirectEntity() instanceof Projectile) {
                if (attacker.hasEffect(CosmoEffects.TRACER.get())) {
                    int amplifier = Objects.requireNonNull(attacker.getEffect(CosmoEffects.TRACER.get())).getAmplifier() + 1;
                    target.addEffect(new MobEffectInstance(CosmoEffects.MARKED.get(), 300 * amplifier));
                    target.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 300 * amplifier));
                    attacker.removeEffect(CosmoEffects.TRACER.get());
                }
            }
        }
    }

    private static void handleObscure(LivingEntity living, LivingDamageEvent event) {
        MobEffectInstance effect = living.getEffect(CosmoEffects.OBSCURE.get());
        if (effect == null) return;
        double chance = 0.2 + ((effect.getAmplifier() + 1) * 0.1);

        if (living.getRandom().nextDouble() < chance) {
            living.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 20, 0, false, false));
            living.level().playSound(null, living.getX(), living.getY(), living.getZ(), SoundEvents.ELDER_GUARDIAN_CURSE, SoundSource.PLAYERS, 0.5F, 1.5F);
            event.setCanceled(true);
        }
    }

    private static void handleVardoger(Level level, LivingEntity target, LivingDamageEvent event) {
        float amount = event.getAmount();

        target.playSound(SoundEvents.WARDEN_HEARTBEAT, 1.5F, 1.0F);

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
        if (user instanceof LivingEntity living) {
            if (stack.isEdible()) {
                int nutrition = Objects.requireNonNull(stack.getFoodProperties(living)).getNutrition();

                if (CosmoUtils.hasNbt(stack, SeasonedFoodHelper.HAS_CREAM)) {
                    int creamNutrition = nutrition == 0 ? 1 : (int) Math.ceil(nutrition / 4.0);
                    if (living instanceof Player player) {
                        player.getFoodData().eat(creamNutrition, 0);
                    }
                }

                if (CosmoUtils.containsNbt(stack, BerrfectFlavorHelper.KEY)) {
                    int times = stack.is(CosmoItems.BERRY_SYRUP_SHAVED_ICE.get()) ? 3 : 1;

                    for (int i = 0; i < times; i++) {
                        handleBerrfectEffect(living, stack);
                    }
                }

                int duration = nutrition < 10 ? 300 : 600;
                int amplifier = nutrition < 10 ? 0 : 1;
                if (CosmoConfig.Common.APPLE_FLAVOR.get() && stack.is(CosmoItemTags.EXUBERANT_SOURCES)) {
                    duration = nutrition < 10 ? 10 - nutrition : 1;
                    living.addEffect(new MobEffectInstance(CosmoEffects.EXUBERANT.get(), duration * 900));
                }
                if (CosmoConfig.Common.GLOW_BERRY_FLAVOR.get() && stack.is(CosmoItemTags.TRACER_SOURCES)) {
                    living.addEffect(new MobEffectInstance(CosmoEffects.TRACER.get(), duration, amplifier));
                }
                if (CosmoConfig.Common.DROOPFRUIT_FLAVOR.get() && stack.is(CosmoItemTags.ABYSMAL_TORCH_SOURCES)) {
                    living.addEffect(new MobEffectInstance(CosmoEffects.ABYSMAL_TORCH.get(), -1, amplifier));
                }
                if (CosmoConfig.Common.BLISTERBERRY_FLAVOR.get() && stack.is(CosmoItemTags.VARDOGER_SOURCES)) {
                    living.addEffect(new MobEffectInstance(CosmoEffects.VARDOGER.get(), (int) (duration * 1.5)));
                }
                if (CosmoConfig.Common.MORE_INGRAINED_SOURCES.get() && stack.is(CosmoItemTags.INGRAINED_SOURCES)) {
                    living.addEffect(new MobEffectInstance(CosmoEffects.INGRAINED.get(), duration));
                }
            }
            if (CosmoConfig.Common.COMFORT_REDESIGN.get() && stack.is(CosmoItemTags.COMFORT_SOURCES)){
                living.addEffect(new MobEffectInstance(CosmoEffects.COMFORT.get(), 1200));
            }
        }
    }

    @SubscribeEvent
    public static void onEffectApplied(MobEffectEvent.Applicable event) {
        MobEffectInstance inst = event.getEffectInstance();
        MobEffect effect = inst.getEffect();
        LivingEntity entity = event.getEntity();
        Level level = entity.level();

        if (effect == CosmoEffects.PLACEHOLDER.get()) {
            event.setResult(Event.Result.DENY);
        }

        if (effect == CosmoEffects.EXUBERANT.get()) {
            int d1 = event.getEffectInstance().getDuration();
            float a1 = event.getEffectInstance().getAmplifier();
            if (entity.hasEffect(CosmoEffects.EXUBERANT.get())) {
                int d2 = Objects.requireNonNull(entity.getEffect(CosmoEffects.EXUBERANT.get())).getDuration();
                float a2 = Objects.requireNonNull(entity.getEffect(CosmoEffects.EXUBERANT.get())).getAmplifier();
                if (a2 >= a1 && d2 < d1) event.setResult(Event.Result.DENY);
            }
        }


        if (effect == MobEffects.HEAL && CosmoCompat.nea) {
            float a = event.getEffectInstance().getAmplifier();
            RandomSource rand = entity.getRandom();
            if (level.isClientSide()) {
                int times = 2 * Math.round(a + 2);

                for(int i = 0; i < times; ++i) {
                    double d0 = rand.nextGaussian() * 0.02;
                    double d1 = rand.nextGaussian() * 0.02;
                    double d2 = rand.nextGaussian() * 0.02;
                    level.addParticle(ParticleTypes.HEART, entity.getRandomX(1.0F), entity.getRandomY() + (double)0.5F, entity.getRandomZ(1.0F), d0, d1, d2);
                }
            }
        }
    }

    @SubscribeEvent
    public static void onEffectAdded(MobEffectEvent.Added event) {
        MobEffectInstance instance = event.getEffectInstance();
        MobEffect effect = instance.getEffect();
        int duration = instance.getDuration();
        int amplifier = instance.getAmplifier();
        LivingEntity entity = event.getEntity();

        if (CosmoCompat.rf && effect == CosmoCompat.CAFFEINATED && entity instanceof ServerPlayer player) {
            var restTime = Stats.CUSTOM.get(Stats.TIME_SINCE_REST);
            if (amplifier >= 2) {
                player.resetStat(restTime);
            } else {
                var stats = player.getStats();
                int current = stats.getValue(restTime);
                stats.setValue(player, restTime, (int) (current * (1.0 - (amplifier + 1) * 0.3)));
            }
        }

        if (effect == CosmoEffects.ABYSMAL_TORCH.get()) {
            MobEffectInstance current = entity.getEffect(effect);

            if (current != null) {
                int oldAmplifier = current.getAmplifier();
                if (current == instance) return;
                int combined = Math.min(10 - 1, oldAmplifier + amplifier + 1);

                entity.forceAddEffect(new MobEffectInstance(effect, Math.max(current.getDuration(), instance.getDuration()), combined), null);
            }
        }

    }

    @SubscribeEvent
    public static void onEffectRemoved(MobEffectEvent.Remove event) {
        Entity entity = event.getEntity();
        MobEffect effect = event.getEffect();
        String key = ForgeRegistries.MOB_EFFECTS.getKey(effect).toString();
        if (entity instanceof LivingEntity living && living.getPersistentData().getCompound("Berrfect").contains(key)) {
            clearBerrfectNbt(living, effect);
        }
    }

    @SubscribeEvent
    public static void onEffectExpired(MobEffectEvent.Expired event) {
        Entity entity = event.getEntity();
        Level level = event.getEntity().level();
        MobEffect effect = event.getEffectInstance().getEffect();
        String key = ForgeRegistries.MOB_EFFECTS.getKey(effect).toString();
        CompoundTag data = entity.getPersistentData().getCompound("Berrfect");
        if (entity instanceof LivingEntity living && data.contains(key)) {
            String flavor = data.getString(key);
            int amplifier = event.getEffectInstance().getAmplifier();

            if (living.isAlive()){
                switch (flavor) {
                    case "bitter" -> CosmoUtils.giveExperience(CosmoConfig.Common.BITTER_EXP.get() + (amplifier * CosmoConfig.Common.BITTER_EXP.get()), living);
                    case "spicy" -> {
                        float spicyPower = (float) (CosmoConfig.Common.SPICY_DMG.get() + (amplifier * CosmoConfig.Common.SPICY_DMG.get()));
                        level.playSound(null, living.blockPosition(), SoundEvents.GENERIC_EXPLODE, SoundSource.NEUTRAL, 1.0F, 1.0F);
                        if (level instanceof ServerLevel serverLevel) serverLevel.sendParticles(ParticleTypes.EXPLOSION, living.getX(), living.getEyeY(), living.getZ(), 1, 0.0D, 0.0D, 0.0D, 0.0D);

                        for(LivingEntity targets : entity.level().getNearbyEntities(Monster.class, TargetingConditions.DEFAULT, living, entity.getBoundingBox().inflate(5.0F))) {
                            targets.hurt(entity.damageSources().inFire(), spicyPower);
                            targets.setSecondsOnFire((int) (2 * spicyPower));
                            targets.knockback(0.5F, living.getX() - targets.getX(), living.getZ() - targets.getZ());
                        }
                    }
                }
            }

            clearBerrfectNbt(living, effect);
        }
    }


    @SubscribeEvent
    public static void onLivingTick(LivingEvent.LivingTickEvent event) {
        LivingEntity living = event.getEntity();
        if (living.level().isClientSide || living.tickCount % 20 != 0) return;

        CompoundTag data = living.getPersistentData();
        boolean hasSweet = false;
        boolean hasSpicy = false;
        boolean hasBitter = false;
        boolean hasSour = false;
        int maxLevel = 0;

        if (data.contains("Berrfect")) {
            CompoundTag berrfect = data.getCompound("Berrfect");

            for (MobEffectInstance inst : living.getActiveEffects()) {
                String key = ForgeRegistries.MOB_EFFECTS.getKey(inst.getEffect()).toString();

                if (berrfect.contains(key)) {
                    String flavor = berrfect.getString(key);
                    int level = inst.getAmplifier() + 1;

                    switch (flavor) {
                        case "sweet" -> {
                            hasSweet = true;
                            living.heal((float) (CosmoConfig.Common.SWEET_HEALING.get() * level));
                        }
                        case "sour" -> {
                            hasSour = true;
                            maxLevel = Math.max(maxLevel, level);
                        }
                        case "spicy" -> hasSpicy = true;
                        case "bitter" -> hasBitter = true;
                    }
                }
            }
        }

        if (hasSour) {
            applySourModifier(living, maxLevel);
        } else {
            AttributeInstance armor = living.getAttribute(Attributes.ARMOR);
            if (armor != null && armor.getModifier(SOUR_UUID) != null) {
                armor.removeModifier(SOUR_UUID);
            }
        }

        if (living instanceof ServerPlayer serverPlayer && hasBitter && hasSpicy && hasSweet && hasSour) {
            CosmoCriteriaTriggers.ALL_FLAVORS.trigger(serverPlayer);
        }

        if (CosmoCompat.fd) {
            if (CosmoConfig.Common.COMFORT_REDESIGN.get() && living.hasEffect(CosmoCompat.COMFORT)) {
                living.forceAddEffect(new MobEffectInstance(CosmoEffects.COMFORT.get(), Math.max(Objects.requireNonNull(living.getEffect(CosmoCompat.COMFORT)).getDuration() / 2, 1200), 0), null);
                living.removeEffect(CosmoCompat.COMFORT);
            }
            if (!CosmoConfig.Common.COMFORT_REDESIGN.get() && living.hasEffect(CosmoEffects.COMFORT.get())) {
                living.forceAddEffect(new MobEffectInstance(CosmoCompat.COMFORT, Objects.requireNonNull(living.getEffect(CosmoEffects.COMFORT.get())).getDuration(), 0), null);
                living.removeEffect(CosmoEffects.COMFORT.get());
            }
        }
    }

    private static void applySourModifier(LivingEntity entity, int level) {
        AttributeInstance armor = entity.getAttribute(Attributes.ARMOR);
        if (armor == null) return;

        double amp = -CosmoConfig.Common.SOUR_ARMOR.get() * level;
        AttributeModifier modifier = armor.getModifier(SOUR_UUID);

        if (modifier != null && modifier.getAmount() == amp) {
            return;
        }

        armor.removeModifier(SOUR_UUID);
        armor.addTransientModifier(new AttributeModifier(SOUR_UUID, "berrfectSour", amp, AttributeModifier.Operation.ADDITION));
    }

    @SubscribeEvent
    public static void onLivingDeath(LivingDeathEvent event) {
        LivingEntity target = event.getEntity();
        Level level = target.level();
        BlockPos pos = target.getOnPos().above();
        Entity killer = event.getSource().getEntity();
        MobEffect at = CosmoEffects.ABYSMAL_TORCH.get();

        if (target instanceof Monster && killer instanceof LivingEntity livingKiller && livingKiller.hasEffect(at) && (level.getBlockState(pos).isAir() || level.getBlockState(pos).canBeReplaced())) {
            int amplifier = Objects.requireNonNull(livingKiller.getEffect(at)).getAmplifier();
            level.setBlock(pos, CosmoBlocks.LIFELIGHT.get().defaultBlockState(), 3);
            level.gameEvent(GameEvent.BLOCK_PLACE, pos, GameEvent.Context.of(level.getBlockState(pos)));
            livingKiller.removeEffect(at);
            if (amplifier > 0) {
                livingKiller.addEffect(new MobEffectInstance(at, -1, amplifier - 1));
            }
        }
    }

    @SubscribeEvent
    public static void onLivingDrops(LivingDropsEvent event) {
        LivingEntity target = event.getEntity();
        Level level = target.level();
        Entity killer = event.getSource().getEntity();

        dropParasiteBerry(event, killer, target, level, Biomes.CRIMSON_FOREST, CosmoItems.BOILBERRY.get(), CosmoConfig.Common.BOILBERRY_CHANCE.get(), true);
        dropParasiteBerry(event, killer, target, level, Biomes.WARPED_FOREST, CosmoItems.SPINALBERRY.get(), CosmoConfig.Common.SPINALBERRY_CHANCE.get(), false);
    }

    private static void dropParasiteBerry (LivingDropsEvent event, Entity killer, LivingEntity target, Level level, ResourceKey<Biome> biome, Item berry, double f, boolean b) {
        if (killer instanceof Player player && level.getBiome(target.blockPosition()).is(biome)) {
            ItemStack handItem = player.getMainHandItem();
            int looting = EnchantmentHelper.getTagEnchantmentLevel(Enchantments.MOB_LOOTING, handItem);
            float chance = Math.min((float) (f + (looting * f * 0.5)), 1);
            if (CosmoUtils.random(level, chance)) {
                int amount = b ? 1 + looting : 1;
                event.getDrops().add(new ItemEntity(target.level(), target.getX(), target.getY(), target.getZ(), new ItemStack(berry, 1 + level.getRandom().nextInt(amount))));
            }
        }
    }

    @SubscribeEvent
    public static void onEntityInteract(PlayerInteractEvent.EntityInteract event) {
        Player player = event.getEntity();
        Entity target = event.getTarget();
        ItemStack stack = event.getItemStack();
        Item item = stack.getItem();
        if (player !=null && item instanceof DoublePopsicleItem doublePopsicle && !player.getCooldowns().isOnCooldown(item) && target instanceof LivingEntity living) {
            FoodProperties food =  item.getFoodProperties();
            if (food == null) return;

            if (living instanceof Player player1) {
                player1.getFoodData().eat(food.getNutrition() / 2, food.getSaturationModifier());
            }

            living.setTicksFrozen(living.getTicksFrozen() + 80);
            living.level().playSound(null, target.blockPosition(), SoundEvents.GENERIC_EAT, SoundSource.PLAYERS, 0.8F, 0.8F);

            if (!food.getEffects().isEmpty()) {
                for (Pair<MobEffectInstance, Float> effectPair : food.getEffects()) {
                    MobEffectInstance doubleEffect = effectPair.getFirst();
                    MobEffectInstance effect = new MobEffectInstance(doubleEffect.getEffect(), doubleEffect.getDuration() / 2, doubleEffect.getAmplifier());
                    living.addEffect(effect);
                }
            }

            if (item instanceof DoubleSplitPopsicleItem splitPopsicle) {
                CosmoUtils.gainRandomEffect(living.level(), living, splitPopsicle.getEffect1(), splitPopsicle.getEffect2(), splitPopsicle.getDuration() / 2);
            }

            if (item == CosmoItems.BERRY_DOUBLE_POPSICLE.get()) {
                if (CosmoUtils.containsNbt(stack, BerrfectFlavorHelper.KEY)) {
                    handleBerrfectEffect(living, stack);
                }
            }

            if (!player.getAbilities().instabuild) {
                stack.shrink(1);
                ItemStack popsicle = new ItemStack(doublePopsicle.getResult().get());

                if (!player.getInventory().add(popsicle)) {
                    player.drop(popsicle, false);
                }
            }

            player.getCooldowns().addCooldown(item, 80);
            event.setCancellationResult(InteractionResult.SUCCESS);
            event.setCanceled(true);
        }
        if (target instanceof Cat cat) {
            if (cat.isAlive() && cat.isTame() && (stack.getItem() instanceof WheatgrassItem || stack.getItem() == CosmoItems.WHEATGRASS_CUBECAKE.get())) {
                for (MobEffectInstance effect : WheatgrassItem.EFFECTS) {
                    cat.addEffect(new MobEffectInstance(effect));
                }
                cat.level().playSound(null, target.blockPosition(), SoundEvents.GENERIC_EAT, SoundSource.PLAYERS, 0.8F, 0.8F);

                for (int i = 0; i < 5; ++i) {
                    double d0 = new Random().nextGaussian() * 0.02D;
                    double d1 = new Random().nextGaussian() * 0.02D;
                    double d2 = new Random().nextGaussian() * 0.02D;
                    cat.level().addParticle(ParticleTypes.HAPPY_VILLAGER, cat.getRandomX(1.0D), cat.getRandomY() + 0.5D, cat.getRandomZ(1.0D), d0, d1, d2);
                }

                if (player != null) {
                    if (!player.getAbilities().instabuild) {
                        stack.shrink(1);
                    }
                    if (player instanceof ServerPlayer serverPlayer) CosmoCriteriaTriggers.WHEATGRASS.trigger(serverPlayer);
                }

                event.setCancellationResult(InteractionResult.SUCCESS);
                event.setCanceled(true);
            }
        }
    }

    @SubscribeEvent
    public static void rightClickBlock(PlayerInteractEvent.RightClickBlock event) {
        Level level = event.getLevel();
        Player player = event.getEntity();
        InteractionHand hand = event.getHand();
        ItemStack inHand = player.getItemInHand(hand);
        BlockState state = level.getBlockState(event.getPos());
        BlockPos pos = event.getPos();
        Block block = state.getBlock();

        if (!level.isClientSide && inHand.getItem() instanceof AxeItem) {
            if (CosmoCompat.ss && ModConfig.fertility.seasonalCrops) {
                Season season = SeasonHelper.getSeasonState(level).getSeason();
                if (season != Season.SPRING && season != Season.WINTER) return;
            }

            if (block == Blocks.BIRCH_LOG && level.getRandom().nextFloat() < 0.5) {
                level.setBlock(pos, CosmoBlocks.SAPPY_BIRCH_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, state.getValue(RotatedPillarBlock.AXIS)), 11);
                level.playSound(null, pos, SoundEvents.AXE_STRIP, SoundSource.BLOCKS, 1.0F, 1.0F);

                level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(player));

                inHand.hurtAndBreak(1, player, (p) -> p.broadcastBreakEvent(hand));

                event.setCancellationResult(InteractionResult.SUCCESS);
                event.setCanceled(true);
            }
        }

        if (!level.isClientSide && inHand.getItem() == Items.GLASS_BOTTLE) {
            funguisInteraction(event, Blocks.SHROOMLIGHT, CosmoBlocks.EXHAUSTED_SHROOMLIGHT.get(), CosmoItems.FUNGUIS_BOTTLE.get());
            if (CosmoCompat.ja) {
                funguisInteraction(event, ExhaustedShroomlightBlock.SHROOMNIGHT, CosmoBlocks.EXHAUSTED_SHROOMNIGHT.get(), CosmoItems.WARPED_FUNGUIS_BOTTLE.get());
                if (CosmoCompat.gd) funguisInteraction(event, ExhaustedShroomlightBlock.SHROOMBLIGHT, CosmoBlocks.EXHAUSTED_SHROOMBLIGHT.get(), CosmoItems.SOULBLIGHT_FUNGUIS_BOTTLE.get());
            }
        }


        if (!level.isClientSide && inHand.getItem() instanceof HoeItem && block == Blocks.ROOTED_DIRT) {
            RandomSource random = level.getRandom();
                if (CosmoUtils.random(level, 0.25)) {
                    Block.popResource(level, pos, new ItemStack(CosmoItems.TUBER.get(), 1 + random.nextInt(3)));
                }
        }

        if (!level.isClientSide && inHand.getItem() instanceof PottedCropItem seed && block == Blocks.FLOWER_POT) {
            player.swing(hand);
            seed.plantCrop(level, pos, player, inHand);

            if (player instanceof ServerPlayer serverPlayer) CosmoCriteriaTriggers.POTTED_CROP.trigger(serverPlayer);

            event.setCancellationResult(InteractionResult.SUCCESS);
            event.setCanceled(true);
        }

        if (!CosmoCompat.bg || !CosmoConfig.Common.BERRY_GOOD_COMPAT_TWEAKS.get()) return;

        ItemStack stack = event.getItemStack();

        Map<String, List<Item>> compatMap = Map.of(
                CosmoCompat.AN, List.of(CosmoCompat.SOURCEBERRY),
                CosmoCompat.HA, List.of(CosmoCompat.KABLOOM),
                CosmoCompat.UG, List.of(CosmoCompat.BLISTERBERRY, CosmoCompat.UNDERBEANS, CosmoCompat.DROOPFRUIT)
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

    private static void funguisInteraction(PlayerInteractEvent.RightClickBlock event, Block block1, Block block2, Item result) {
        Level level = event.getLevel();
        BlockPos pos = event.getPos();
        BlockState state = level.getBlockState(event.getPos());
        Block block = state.getBlock();
        Player player = event.getEntity();
        ItemStack inHand = event.getItemStack();
        InteractionHand hand = event.getHand();

        if (block != block1) return;

        player.swing(hand);

        level.levelEvent(2001, pos, Block.getId(state));
        level.setBlock(pos, block2.defaultBlockState(), 11);

        level.playSound(null, pos, SoundEvents.BOTTLE_FILL, SoundSource.BLOCKS, 1.0F, 1.0F);
        level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(player));

        ItemStack funguis = new ItemStack(result);
        if (!player.isCreative()) {
            inHand.shrink(1);
        }

        if (inHand.isEmpty()) {
            player.setItemInHand(hand, funguis);
        } else if (!player.getInventory().add(funguis)) {
            player.drop(funguis, false);
        }

        event.setCancellationResult(InteractionResult.SUCCESS);
        event.setCanceled(true);
    }

    @SubscribeEvent
    public static void onVillagerTrades(VillagerTradesEvent event) {
        if (event.getType().equals(VillagerProfession.FARMER)) {
            TradeUtil.addVillagerTrades(event, 1,
                    new TradeUtil.BlueprintTrade(CosmoItems.WILDBERRY.get(), 32, 1, 16, 2),
                    new TradeUtil.BlueprintTrade(CosmoItems.ARBUTUS_BERRIES.get(), 24, 1, 16, 2),
                    new TradeUtil.BlueprintTrade(CosmoItems.WATTLESEEDS.get(), 24, 1, 16, 2),
                    new TradeUtil.BlueprintTrade(CosmoItems.FIDDLEHEAD.get(), 32, 1, 16, 2)
            );
            TradeUtil.addVillagerTrades(event, 2,
                    new TradeUtil.BlueprintTrade(CosmoItems.WHEATGRASS.get(), 24, 1, 12, 5),
                    new TradeUtil.BlueprintTrade(CosmoItems.CHARD.get(), 28, 1, 12, 5)
            );

        }
    }

    @SubscribeEvent
    public static void onWandererTradesEvent(WandererTradesEvent event) {
        if (!CosmoCompat.fd) {
            TradeUtil.addWandererTrades(event, new TradeUtil.BlueprintTrade(2, CosmoItems.LLAMA_MARSHMALLOW.get(), 1, 16, 2));
            TradeUtil.addWandererTrades(event, new TradeUtil.BlueprintTrade(3, CosmoItems.LLAMA_MARSHMALLOW.get(), 2, 8, 3));
            TradeUtil.addWandererTrades(event, new TradeUtil.BlueprintTrade(2, CosmoItems.LLAMA_MARSHMALLOW_BROWN.get(), 1, 16, 2));
            TradeUtil.addWandererTrades(event, new TradeUtil.BlueprintTrade(3, CosmoItems.LLAMA_MARSHMALLOW_BROWN.get(), 2, 8, 3));
        }
        TradeUtil.addWandererTrades(event, new TradeUtil.BlueprintTrade(2, CosmoItems.WANDERING_GELATO.get(), 1, 16, 2));
        TradeUtil.addWandererTrades(event, new TradeUtil.BlueprintTrade(3, CosmoItems.WANDERING_GELATO.get(), 2, 8, 3));
        TradeUtil.addWandererTrades(event, new TradeUtil.BlueprintTrade(2, CosmoItems.LLAMA_MARSHMALLOW_TRADER.get(), 1, 16, 2));
        TradeUtil.addWandererTrades(event, new TradeUtil.BlueprintTrade(3, CosmoItems.LLAMA_MARSHMALLOW_TRADER.get(), 2, 8, 3));
        if (CosmoCompat.en) TradeUtil.addWandererTrades(event, new TradeUtil.BlueprintTrade(3, CosmoItems.SLABFISH_JELLY_POPSICLE.get(), 1, 16, 2));
        TradeUtil.addWandererTrades(event, new TradeUtil.BlueprintTrade(6, CosmoItems.TRAVELERS_PANINI.get(), 1, 8, 2));
        TradeUtil.addWandererTrades(event, new TradeUtil.BlueprintTrade(9, CosmoItems.TRAVELERS_PANINI.get(), 2, 4, 3));
        TradeUtil.addWandererTrades(event, new TradeUtil.BlueprintTrade(12, CosmoItems.EMERALD_CANDY.get(), 8, 4, 3));
        if(CosmoCompat.an && CosmoConfig.Common.BERRY_GOOD_COMPAT_TWEAKS.get()) TradeUtil.addWandererTrades(event, new TradeUtil.BlueprintTrade(1, CosmoItems.SOURCE_BERRY_PIPS.get(), 1, 12, 1));
        if(CosmoCompat.ha && CosmoConfig.Common.BERRY_GOOD_COMPAT_TWEAKS.get()) TradeUtil.addWandererTrades(event, new TradeUtil.BlueprintTrade(1, CosmoItems.KABLOOM_PIPS.get(), 1, 12, 1));
    }

    @SubscribeEvent
    public static void registerFuel(FurnaceFuelBurnTimeEvent event) {
        ItemStack itemStack = event.getItemStack();

        if (itemStack.is(CosmoItems.BAGASSE.get())) {
            event.setBurnTime(100);
        }

    }

    @SubscribeEvent
    public static void addReloadListeners(AddReloadListenerEvent event) {
        event.addListener(new BerrfectDataLoader());
    }

    @SubscribeEvent
    public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
        sendBerrfectPacket(event.getEntity());
    }

    @SubscribeEvent
    public static void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
        sendBerrfectPacket(event.getEntity());
    }

    @SubscribeEvent
    public static void onPlayerWakeUp(PlayerWakeUpEvent event) {
        Player player = event.getEntity();
        if (!player.level().isClientSide() && player.hasEffect(CosmoEffects.COMFORT.get())) {
            int duration = Math.max(player.getEffect(CosmoEffects.COMFORT.get()).getDuration(), 1200);
            int amplifier = player.getEffect(CosmoEffects.COMFORT.get()).getAmplifier() + 1;

            Registry<MobEffect> registry = player.level().registryAccess().registryOrThrow(Registries.MOB_EFFECT);
            List<Holder<MobEffect>> effects = StreamSupport.stream(registry.getTagOrEmpty(CosmoEffectTags.COMFORT_REWARDS).spliterator(), false).toList();
            if (!effects.isEmpty()) {
                MobEffect chosen = effects.get(player.getRandom().nextInt(effects.size())).get();
                player.addEffect(new MobEffectInstance(chosen, duration));
            }

            CosmoUtils.giveExperience(5 * amplifier, player);
            player.removeEffect(CosmoEffects.COMFORT.get());
        }
    }

    private static void sendBerrfectPacket(Entity entity) {
        if (entity instanceof ServerPlayer player) {
            CompoundTag berrfect = player.getPersistentData().getCompound("Berrfect");
            if (!berrfect.isEmpty()) CosmoPacketHandler.INSTANCE.send(PacketDistributor.PLAYER.with(() -> player), new BerrfectPacket(player.getId(), berrfect));
        }
    }

    public static void condensedMilkEffect (Level level, LivingEntity living, ItemStack stack){
        Iterator<MobEffectInstance> itr = living.getActiveEffects().iterator();
        ArrayList<MobEffect> effects = new ArrayList<>();

        while(itr.hasNext()) {
            MobEffectInstance effect = itr.next();
            if (effect.getAmplifier() < 1 && effect.isCurativeItem(new ItemStack(Items.MILK_BUCKET))) {
                effects.add(effect.getEffect());
            }
        }

        if (!effects.isEmpty()) {
            if (stack.is(CosmoItems.CONDENSED_MILK_BUCKET.get())) {
                for (MobEffect effect : effects) {
                    MobEffectInstance instance = living.getEffect(effect);
                    if (instance != null && !MinecraftForge.EVENT_BUS.post(new MobEffectEvent.Remove(living, instance))) {
                        living.removeEffect(effect);
                    }
                }
            } else {
                MobEffect effect = effects.get(level.random.nextInt(effects.size()));
                MobEffectInstance instance = living.getEffect(effect);
                if (instance != null && !MinecraftForge.EVENT_BUS.post(new MobEffectEvent.Remove(living, instance))) {
                    living.removeEffect(effect);
                }
            }
        }
    }

    public static void creamEffect(Level level,LivingEntity living, ItemStack stack) {
        RandomSource random = level.getRandom();
        List<MobEffectInstance> effects = living.getActiveEffects().stream().filter(inst -> inst.getDuration() != -1).map(MobEffectInstance::new).toList();

        if (effects.isEmpty()) return;
        if (stack.is(CosmoItems.CREAM.get())) {
            MobEffectInstance pick = effects.get(random.nextInt(effects.size()));
            applyDurationAdjustment(living, pick, random.nextInt(401) - 200);
        } else {
            for (MobEffectInstance inst : effects) {
                applyDurationAdjustment(living, inst, random.nextInt(401) - 200);
            }
        }
    }

    public static void applyDurationAdjustment(LivingEntity living, MobEffectInstance instance, int i) {
        if (CosmoCompat.nea && living.hasEffect(CosmoCompat.VANILLA_SCENT)) return;

        int newDuration = Math.max(instance.getDuration() + i, 20);
        MobEffectInstance newInstance = new MobEffectInstance(instance.getEffect(), newDuration, instance.getAmplifier(), instance.isAmbient(), instance.isVisible(), instance.showIcon());
        living.forceAddEffect(newInstance, null);

    }

    public static void applyAmplifierAdjustment(LivingEntity living, MobEffectInstance instance, int i) {
        if (CosmoCompat.nea && living.hasEffect(CosmoCompat.VANILLA_SCENT)) return;

        int newAmplifier = Math.max(instance.getAmplifier() + i, 0);
        MobEffectInstance newInstance = new MobEffectInstance(instance.getEffect(), instance.getDuration(), newAmplifier, instance.isAmbient(), instance.isVisible(), instance.showIcon());
        living.forceAddEffect(newInstance, null);
    }

    public static void handleBerrfectEffect(LivingEntity living, ItemStack stack) {
        if (!CosmoConfig.Common.FLAVORED_SYRUP.get()) return;
        CompoundTag data = living.getPersistentData().getCompound("Berrfect");

        List<MobEffectInstance> harmful_effects = living.getActiveEffects().stream().filter(inst -> isBerrfect(inst, data) && !inst.getEffect().isBeneficial()).map(MobEffectInstance::new).toList();
        List<MobEffectInstance> beneficial_effects = living.getActiveEffects().stream().filter(inst -> isBerrfect(inst, data) && inst.getEffect().isBeneficial()).map(MobEffectInstance::new).toList();
        RandomSource random = living.level().getRandom();
        String flavor = stack.hasTag() ? stack.getTag().getString(BerrfectFlavorHelper.KEY) : "";

        boolean strange1 = false;
        MobEffectInstance strangeEffect1 = null;

        if (!harmful_effects.isEmpty()) {
            MobEffectInstance pick = harmful_effects.get(random.nextInt(harmful_effects.size()));
            switch (flavor) {
                case "bitter" -> seasonEffect("bitter", living, pick, Math.max((int) (pick.getDuration() * CosmoConfig.Common.BITTER_RATE.get()), 100));
                case "sweet" -> seasonEffect("sweet", living, pick, -Math.max((int) (pick.getDuration() * CosmoConfig.Common.SWEET_RATE.get()), 100));
                case "strange" -> {
                    strange1 = true;
                    strangeEffect1 = pick;
                }
            }
        }

        boolean strange2 = false;
        MobEffectInstance strangeEffect2 = null;

        if (!beneficial_effects.isEmpty()) {
            MobEffectInstance pick = beneficial_effects.get(random.nextInt(beneficial_effects.size()));
            switch (flavor) {
                case "sour" -> seasonEffect("sour", living, pick, Math.max((int) (pick.getDuration() * CosmoConfig.Common.SOUR_RATE.get()), 100));
                case "spicy" -> seasonEffect("spicy", living, pick, -Math.max((int) (pick.getDuration() * CosmoConfig.Common.SPICY_RATE.get()), 100));
                case "strange" -> {
                    strange2 = true;
                    strangeEffect2 = pick;
                }
            }
        }

        if (strange1 && strange2) {
            MobEffectInstance newInstance1 = new MobEffectInstance(strangeEffect1.getEffect(), strangeEffect2.getDuration(), strangeEffect2.getAmplifier());
            MobEffectInstance newInstance2 = new MobEffectInstance(strangeEffect2.getEffect(), strangeEffect1.getDuration(), strangeEffect1.getAmplifier());

            living.removeEffect(strangeEffect1.getEffect());
            living.removeEffect(strangeEffect2.getEffect());
            living.addEffect(newInstance1);
            living.addEffect(newInstance2);

            String key = ForgeRegistries.MOB_EFFECTS.getKey(strangeEffect1.getEffect()).toString();
            String key2 = ForgeRegistries.MOB_EFFECTS.getKey(strangeEffect2.getEffect()).toString();

            data.putString(key, flavor);
            data.putString(key2, flavor);
            living.getPersistentData().put("Berrfect", data);

            if (!living.level().isClientSide) {
                CosmoPacketHandler.sendPacket(living, data);
                if (living instanceof Player player) {
                    player.playNotifySound(SoundEvents.BREWING_STAND_BREW, player.getSoundSource(),1.0F, 1.0F);
                }
            }
        }

    }

    public static boolean isBerrfect(MobEffectInstance inst, CompoundTag data) {
        return inst.getDuration() != -1 && !inst.isAmbient() && inst.isVisible() && !data.contains(ForgeRegistries.MOB_EFFECTS.getKey(inst.getEffect()).toString()) && !ForgeRegistries.MOB_EFFECTS.tags().getTag(CosmoEffectTags.BLACKLIST).contains(inst.getEffect());
    }

    private static void seasonEffect(String flavor, LivingEntity living, MobEffectInstance inst, int i) {
        CompoundTag data = living.getPersistentData().getCompound("Berrfect");
        String key = ForgeRegistries.MOB_EFFECTS.getKey(inst.getEffect()).toString();

        applyDurationAdjustment(living, inst, i);

        data.putString(key, flavor);
        living.getPersistentData().put("Berrfect", data);

        if (!living.level().isClientSide) {
            CosmoPacketHandler.sendPacket(living, data);
            if (living instanceof Player player) {
                player.playNotifySound(SoundEvents.BREWING_STAND_BREW, player.getSoundSource(),1.0F, 1.0F);
                if (player instanceof ServerPlayer serverPlayer) {
                    switch (flavor) {
                        case "sour" -> CosmoCriteriaTriggers.SOUR.trigger(serverPlayer);
                        case "sweet" -> CosmoCriteriaTriggers.SWEET.trigger(serverPlayer);
                        case "bitter" -> CosmoCriteriaTriggers.BITTER.trigger(serverPlayer);
                        case "spicy" -> CosmoCriteriaTriggers.SPICY.trigger(serverPlayer);
                    }
                }
            }
        }
    }

    private static void clearBerrfectNbt(LivingEntity entity, MobEffect effect) {
        CompoundTag data = entity.getPersistentData();
        if (!data.contains("Berrfect")) return;

        CompoundTag berrfect = data.getCompound("Berrfect");
        String key = ForgeRegistries.MOB_EFFECTS.getKey(effect).toString();

        if (berrfect.contains(key)) {
            berrfect.remove(key);
            if (berrfect.isEmpty()) {
                data.remove("Berrfect");
            } else {
                data.put("Berrfect", berrfect);
            }
        }

        if (!entity.level().isClientSide) {
            CosmoPacketHandler.sendPacket(entity, berrfect);
        }
    }

}


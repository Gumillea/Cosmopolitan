package com.gumillea.cosmopolitan.core.util;

import com.gumillea.cosmopolitan.CosmoConfig;
import com.gumillea.cosmopolitan.Cosmopolitan;
import com.gumillea.cosmopolitan.common.item.DoublePopsicleItem;
import com.gumillea.cosmopolitan.common.item.DoubleSplitPopsicleItem;
import com.gumillea.cosmopolitan.common.item.PottedCropItem;
import com.gumillea.cosmopolitan.common.item.WheatgrassItem;
import com.gumillea.cosmopolitan.core.misc.CosmoCriteriaTriggers;
import com.gumillea.cosmopolitan.core.reg.CosmoBlocks;
import com.gumillea.cosmopolitan.core.reg.CosmoEffects;
import com.gumillea.cosmopolitan.core.reg.CosmoItems;
import com.mojang.datafixers.util.Pair;
import com.teamabnormals.blueprint.core.util.TradeUtil;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.event.village.WandererTradesEvent;
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
import sereneseasons.api.season.Season;
import sereneseasons.api.season.SeasonHelper;

import java.util.*;

@Mod.EventBusSubscriber(modid = Cosmopolitan.MODID)
public class CosmoEvents {

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

            if (stack.hasTag() && stack.getTag().getBoolean("has_cream")) {
                int creamNutrition =  nutrition == 0 ? 1 : (int) Math.ceil(nutrition / 4.0);
                if (living instanceof Player player) {
                    player.getFoodData().eat(creamNutrition, 0);
                }
            }

            int duration = nutrition < 10 ? 300 : 600;
            int amplifier = nutrition < 10 ? 0 : 1;
            if (CosmoConfig.Common.APPLE_FLAVOR.get() && stack.is(CosmoItemTags.EXUBERANT_SOURCES)){
                duration = nutrition < 10 ? 10 - nutrition : 1;
                living.addEffect(new MobEffectInstance(CosmoEffects.EXUBERANT.get(), duration * 300));
            }
            if (CosmoConfig.Common.GLOW_BERRY_FLAVOR.get() && stack.is(CosmoItemTags.TRACER_SOURCES)){
                living.addEffect(new MobEffectInstance(CosmoEffects.TRACER.get(), duration, amplifier));
            }
            if (CosmoConfig.Common.DROOPFRUIT_FLAVOR.get() && stack.is(CosmoItemTags.ABYSMAL_TORCH_SOURCES)){
                living.addEffect(new MobEffectInstance(CosmoEffects.ABYSMAL_TORCH.get(), 600, amplifier));
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
        if (effect == CosmoEffects.PLACEHOLDER.get()) {
            event.setResult(Event.Result.DENY);
        }

        if (entity.hasEffect(CosmoEffects.CAROTENE.get())) {
            ITagManager<MobEffect> mobEffectTags = ForgeRegistries.MOB_EFFECTS.tags();
            if (mobEffectTags != null && mobEffectTags.getTag(CosmoEffectTags.CONVERTIBLE_BY_CAROTENE).contains(effect)) {
                for (int i = 0; i < 8; ++i) {
                    double d0 = new Random().nextGaussian() * 0.02D;
                    double d1 = new Random().nextGaussian() * 0.02D;
                    double d2 = new Random().nextGaussian() * 0.02D;
                    entity.level().addParticle(ParticleTypes.HAPPY_VILLAGER, entity.getRandomX(1.0D), entity.getRandomY() + 0.5D, entity.getRandomZ(1.0D), d0, d1, d2);
                }
                entity.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 600));
                event.setResult(Event.Result.DENY);
            }
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
    }

    @SubscribeEvent
    public static void onEffectAdded(MobEffectEvent.Added event) {
        MobEffectInstance instance = event.getEffectInstance();
        MobEffect effect = instance.getEffect();
        LivingEntity entity = event.getEntity();
        if (CosmoCompat.rf && effect == CosmoCompat.CAFFEINATED && entity instanceof ServerPlayer player) {
            int amplifier = instance.getAmplifier();
            var restTime = Stats.CUSTOM.get(Stats.TIME_SINCE_REST);
            if (amplifier >= 2) {
                player.resetStat(restTime);
            } else {
                var stats = player.getStats();
                int current = stats.getValue(restTime);

                stats.setValue(player, restTime, (int) (current * (1.0 - (amplifier + 1) * 0.3)));
            }
        }
    }

    @SubscribeEvent
    public static void onLivingDeath(LivingDeathEvent event) {
        LivingEntity target = event.getEntity();
        Level level = target.level();
        BlockPos pos = target.getOnPos().above();
        Entity killer = event.getSource().getEntity();
        MobEffect at = CosmoEffects.ABYSMAL_TORCH.get();

        if (target instanceof Monster && killer instanceof LivingEntity livingKiller && livingKiller.hasEffect(at) && (level.getBlockState(pos).isAir()|| level.getBlockState(pos).canBeReplaced())) {
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
            } else if (item instanceof DoubleSplitPopsicleItem splitPopsicle) {
                CosmoUtils.gainRandomEffect(living.level(), living, splitPopsicle.getEffect1(), splitPopsicle.getEffect2(), splitPopsicle.getDuration() / 2);
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

        if (!level.isClientSide && inHand.getItem() instanceof HoeItem && block == Blocks.ROOTED_DIRT) {
            for (int i = 0; i < 4 ; i++) {
                if (level.getRandom().nextFloat() < 0.25) {
                    Block.popResource(level, pos, new ItemStack(CosmoItems.TUBER.get()));
                }
            }
        }

        if (!level.isClientSide && inHand.getItem() instanceof PottedCropItem seed && block == Blocks.FLOWER_POT) {
            player.swing(hand);
            seed.plantCrop(level, pos, player, inHand);

            if (player instanceof ServerPlayer serverPlayer) CosmoCriteriaTriggers.POTTED_CROP.trigger(serverPlayer);

            event.setCancellationResult(InteractionResult.SUCCESS);
            event.setCanceled(true);
        }

        if (block.getStateDefinition().getProperties().stream().anyMatch(prop -> prop.getName().equals("bites"))) {
            if (CosmoCompat.fd && player.getItemInHand(hand).is(CosmoItemTags.KNIVES)) return;

            if (CosmoConfig.Common.APPLE_FLAVOR.get() && state.is(CosmoBlockTags.EXUBERANT_SOURCES)) {
                player.addEffect(new MobEffectInstance(CosmoEffects.EXUBERANT.get(), 2100));
            }
            if (CosmoConfig.Common.GLOW_BERRY_FLAVOR.get() && state.is(CosmoBlockTags.TRACER_SOURCES)) {
                player.addEffect(new MobEffectInstance(CosmoEffects.TRACER.get(), 300));
            }
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

    @SubscribeEvent
    public static void onVillagerTrades(VillagerTradesEvent event) {
        if (event.getType().equals(VillagerProfession.FARMER)) {
            TradeUtil.addVillagerTrades(event, 1,
                    new TradeUtil.BlueprintTrade(CosmoItems.WILDBERRY.get(), 32, 1, 16, 2),
                    new TradeUtil.BlueprintTrade(CosmoItems.FIDDLEHEAD.get(), 32, 1, 16, 2));
            TradeUtil.addVillagerTrades(event, 2,
                    new TradeUtil.BlueprintTrade(CosmoItems.WHEATGRASS.get(), 24, 1, 12, 5));
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
        if(CosmoCompat.an && CosmoConfig.Common.BERRY_GOOD_COMPAT_TWEAKS.get()) TradeUtil.addWandererTrades(event, new TradeUtil.BlueprintTrade(1, CosmoItems.SOURCE_BERRY_PIPS.get(), 1, 12, 1));
        if(CosmoCompat.ha && CosmoConfig.Common.BERRY_GOOD_COMPAT_TWEAKS.get()) TradeUtil.addWandererTrades(event, new TradeUtil.BlueprintTrade(1, CosmoItems.KABLOOM_PIPS.get(), 1, 12, 1));
        if(CosmoConfig.Common.COSMOPOLITAN_COCKTAIL.get()) TradeUtil.addRareWandererTrades(event, new TradeUtil.BlueprintTrade(64, CosmoItems.COSMOPOLITAN_COCKTAIL.get(), 1, 1, 5));
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
            applyAdjustment(living, pick, random);
        } else {
            for (MobEffectInstance inst : effects) {
                applyAdjustment(living, inst, random);
            }
        }
    }

    private static void applyAdjustment(LivingEntity living, MobEffectInstance instance, RandomSource random) {
        int i = random.nextInt(401) - 200;
        int newDuration = instance.getDuration() + i;

        living.removeEffect(instance.getEffect());
        if (newDuration > 0) {
            MobEffectInstance newInstance = new MobEffectInstance(instance.getEffect(), newDuration, instance.getAmplifier(), instance.isAmbient(), instance.isVisible(), instance.showIcon());
            living.addEffect(newInstance);
        }
    }
}

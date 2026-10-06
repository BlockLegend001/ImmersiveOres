package com.blocklegend001.immersiveores.item.custom.vulpus;

import com.blocklegend001.immersiveores.ImmersiveOresClient;
import com.blocklegend001.immersiveores.config.VulpusConfig;
import com.blocklegend001.immersiveores.util.map.ArrowCountMap;
import com.blocklegend001.immersiveores.util.tools.bow.BowTier;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Unit;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.arrow.AbstractArrow;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import java.util.function.Consumer;

public class VulpusBow extends BowItem {
    private final BowTier tier;
    private final int ARROW_COUNT = VulpusConfig.arrowCountVulpusBow;

    private static Properties createSettings(Properties base, boolean unbreakable, int durability) {
        base.durability(durability).fireResistant();
        if (unbreakable) {
            base.component(DataComponents.UNBREAKABLE, Unit.INSTANCE);
        }
        return base;
    }

    public VulpusBow(BowTier tier, Properties settings) {
        super(createSettings(settings, VulpusConfig.unbreakableVulpus, VulpusConfig.durabilityVulpus));
        this.tier = tier;
    }

    @Override
    public Component getName(ItemStack stack) {
        return super.getName(stack).copy().withStyle(ChatFormatting.RED);
    }

    @Override
    public boolean releaseUsing(ItemStack stack, Level world, LivingEntity user, int remainingUseTicks) {
        if (user instanceof Player player) {
            ItemStack arrowStack = user.getProjectile(stack);

            Registry<Enchantment> registry = world.registryAccess()
                    .lookupOrThrow(Registries.ENCHANTMENT);

            boolean hasInfinity = EnchantmentHelper.getEnchantmentLevel(
                    registry.getOrThrow(Enchantments.INFINITY),
                    player
            ) > 0;

            int powerLevel = EnchantmentHelper.getEnchantmentLevel(
                    registry.getOrThrow(Enchantments.POWER),
                    player
            );

            int punchLevel = EnchantmentHelper.getEnchantmentLevel(
                    registry.getOrThrow(Enchantments.PUNCH),
                    player
            );

            int charge = getUseDuration(stack, player) - remainingUseTicks;
            boolean hasArrows = arrowStack.is(Items.ARROW);

            float arrowVelocity = getPowerForTime(charge);

            if (arrowVelocity >= 0.1) {
                for (int i = 0; i < ARROW_COUNT; i++) {
                    ArrowItem arrowItem = (ArrowItem) (arrowStack.getItem() instanceof ArrowItem ? arrowStack.getItem() : Items.ARROW);
                    AbstractArrow arrowEntity = arrowItem.createArrow(world, arrowStack, user, stack);
                    int damage = stack.getOrDefault(DataComponents.DAMAGE, 0);

                    arrowEntity.shootFromRotation(user, user.getXRot(), user.getYRot(), 0.0F, arrowVelocity * 3.0F, 1.0F);

                    if (powerLevel > 0) {
                        arrowEntity.setBaseDamage(damage + (powerLevel * 0.5 + 1.0));
                    }

                    if (punchLevel > 0) {
                        double resistance = Math.max(0.0, 1.0 - user.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
                        Vec3 knockbackVec = arrowEntity.getDeltaMovement()
                                .normalize()
                                .scale(punchLevel * 0.6 * resistance);

                        arrowEntity.setDeltaMovement(
                                arrowEntity.getDeltaMovement().add(knockbackVec)
                        );
                    }
                    AbstractArrow.Pickup pickupPermission = hasInfinity ? AbstractArrow.Pickup.DISALLOWED : AbstractArrow.Pickup.ALLOWED;

                    if (i == 0) {
                        arrowEntity.pickup = pickupPermission;
                    } else {
                        arrowEntity.pickup = AbstractArrow.Pickup.DISALLOWED;
                    }

                    if (arrowVelocity == 1.0F) {
                        arrowEntity.setCritArrow(true);
                    }

                    arrowEntity.setRemainingFireTicks(600);
                    world.addFreshEntity(arrowEntity);
                }

                world.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.ARROW_SHOOT, SoundSource.PLAYERS, 1.0F, 1.0F / (player.getRandom().nextFloat() * 0.4F + 1.2F) + arrowVelocity * 0.5F);

                if (hasArrows && !player.getAbilities().instabuild && !hasInfinity) {
                    arrowStack.shrink(1);
                    if (arrowStack.isEmpty()) {
                        player.getInventory().removeItem(arrowStack);
                    }
                }
                stack.hurtAndBreak(1, player, InteractionHand.MAIN_HAND);
            }
        }
        return false;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext conComponent, TooltipDisplay tooltip, Consumer<Component> ComponentConsumer, TooltipFlag options) {
        int arrowCount = getArrowCount(stack);
        ChatFormatting color = ChatFormatting.RED;

        if (ImmersiveOresClient.isShiftKeyPressed()) {
            Component damage = Component.literal("+" + this.tier.getAttackDamageBonus() + " ")
                    .append(Component.translatable("tooltip.immersiveores.damage.tooltip"))
                    .withStyle(color);
            ComponentConsumer.accept(damage);

            if (VulpusConfig.unbreakableVulpus) {
                Component unbreakable = Component.translatable("tooltip.immersiveores.unbreakble.tooltip")
                        .withStyle(color);
                ComponentConsumer.accept(unbreakable);
            }

            Component fireImmune = Component.translatable("tooltip.immersiveores.immunetofire.tooltip")
                    .withStyle(color);
            ComponentConsumer.accept(fireImmune);

            Component arrow = Component.literal("Can shoot ")
                    .withStyle(color)
                    .append(Component.literal(String.valueOf(arrowCount)).withStyle(ChatFormatting.YELLOW))
                    .append(Component.literal(" Flaming Arrows").withStyle(color));
            ComponentConsumer.accept(arrow);
        } else {
            Component pressShift = Component.translatable("tooltip.immersiveores.pressshiftformoreinfo.tooltip")
                    .withStyle(color);
            ComponentConsumer.accept(pressShift);
        }
    }

    private int getArrowCount(ItemStack stack) {
        if (ArrowCountMap.VULPUS_BOW_ARROW_COUNT.containsKey(stack.getItem())) {
            return ArrowCountMap.VULPUS_BOW_ARROW_COUNT.get(stack.getItem());
        }
        return 0;
    }
}
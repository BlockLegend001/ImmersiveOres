package com.blocklegend001.immersiveores.item.custom.vibranium;

import com.blocklegend001.immersiveores.config.VibraniumConfig;
import com.blocklegend001.immersiveores.util.map.ArrowCountMap;
import com.blocklegend001.immersiveores.util.tools.bow.BowTier;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class VibraniumBow extends BowItem {
    private static Properties createSettings(BowTier tier) {
        return new Properties()
                .fireResistant()
                .stacksTo(1)
                .durability(tier.getUses());
    }

    private final BowTier tier;
    private final int ARROW_COUNT = VibraniumConfig.arrowCountVibraniumBow.get();

    public VibraniumBow(BowTier tier, Properties properties) {
        super(createSettings(tier));
        this.tier = tier;
    }

    @Override
    public Component getName(ItemStack stack) {
        return super.getName(stack).copy().withStyle(ChatFormatting.LIGHT_PURPLE);
    }

    @Override
    public AbstractArrow customArrow(AbstractArrow arrow) {
        arrow.setBaseDamage(arrow.getBaseDamage() + this.tier.getAttackDamageBonus());
        return arrow;
    }

    @Override
    public int getEnchantmentValue() {
        return this.tier.getEnchantmentValue();
    }

    @Override
    public boolean isEnchantable(ItemStack p_41456_) {
        return true;
    }

    @Override
    public void releaseUsing(ItemStack stack, Level world, LivingEntity entityLiving, int timeLeft) {
        if (entityLiving instanceof Player player) {
            ItemStack arrowStack = player.getProjectile(stack);

            ItemStack mainHand = player.getMainHandItem();
            boolean hasInfinity = EnchantmentHelper.getTagEnchantmentLevel(Enchantments.INFINITY_ARROWS, mainHand) > 0;

            int powerLevel = EnchantmentHelper.getTagEnchantmentLevel(Enchantments.POWER_ARROWS, mainHand);

            int punchLevel = EnchantmentHelper.getTagEnchantmentLevel(Enchantments.PUNCH_ARROWS, mainHand);

            int charge = getUseDuration(stack) - timeLeft;
            float arrowVelocity = getPowerForTime(charge);
            if (arrowVelocity >= 0.1) {
                if (!world.isClientSide) {
                    boolean isPrimaryArrow = true;

                    for (int i = 0; i < ARROW_COUNT; i++) {
                        ArrowItem arrowItem = (ArrowItem) (arrowStack.getItem() instanceof ArrowItem ? arrowStack.getItem() : Items.ARROW);
                        AbstractArrow arrowEntity = arrowItem.createArrow(world, arrowStack, player);

                        arrowEntity.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, arrowVelocity * 3.0F, 1.0F);

                        if (powerLevel > 0) {
                            arrowEntity.setBaseDamage(arrowEntity.getBaseDamage() + (powerLevel * 0.5 + 1.0));
                        }

                        if (punchLevel > 0) {
                            double resistance = Math.max(0.0, 1.0 - entityLiving.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
                            double factor = punchLevel * 0.6 * resistance;
                            Vec3 knockbackVec = arrowEntity.getDeltaMovement().normalize().multiply(factor, factor, factor);

                            arrowEntity.addDeltaMovement(new Vec3(knockbackVec.x, 0.1, knockbackVec.z));
                        }

                        if (arrowVelocity == 1.0F) {
                            arrowEntity.setCritArrow(true);
                        }

                        if (isPrimaryArrow) {
                            arrowEntity.pickup = hasInfinity ? AbstractArrow.Pickup.DISALLOWED : AbstractArrow.Pickup.ALLOWED;
                            isPrimaryArrow = false;
                        } else {
                            arrowEntity.pickup = AbstractArrow.Pickup.DISALLOWED;
                        }

                        world.addFreshEntity(arrowEntity);
                    }
                }
                world.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.ARROW_SHOOT, SoundSource.PLAYERS, 1.0F, 1.0F / (player.getRandom().nextFloat() * 0.4F + 1.2F) + arrowVelocity * 0.5F);

                if (!player.getAbilities().instabuild && !hasInfinity) {
                    arrowStack.shrink(1);
                    if (arrowStack.isEmpty()) {
                        player.getInventory().removeItem(arrowStack);
                    }
                }
                player.getMainHandItem().hurtAndBreak(1, player,
                        p -> p.broadcastBreakEvent(p.getUsedItemHand()));
            }
        }
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pContext, List<Component> components, TooltipFlag pTooltipFlag) {
        int arrowCount = getArrowCount(pStack);
        ChatFormatting color = ChatFormatting.LIGHT_PURPLE;

        if (Screen.hasShiftDown()) {
            Component damage = Component.literal("+" + this.tier.getAttackDamageBonus() + " ")
                    .append(Component.translatable("tooltip.immersiveores.damage.tooltip"))
                    .withStyle(color);
            components.add(damage);

            if (VibraniumConfig.unbreakableVibranium.get()) {
                Component unbreakable = Component.translatable("tooltip.immersiveores.unbreakble.tooltip")
                        .withStyle(color);
                components.add(unbreakable);
            }

            Component fireImmune = Component.translatable("tooltip.immersiveores.immunetofire.tooltip")
                    .withStyle(color);
            components.add(fireImmune);

            Component arrow = Component.literal("Can shoot ")
                    .withStyle(color)
                    .append(Component.literal(String.valueOf(arrowCount)).withStyle(ChatFormatting.YELLOW))
                    .append(Component.literal(" Arrows").withStyle(color));
            components.add(arrow);
        } else {
            Component pressShift = Component.translatable("tooltip.immersiveores.pressshiftformoreinfo.tooltip")
                    .withStyle(color);
            components.add(pressShift);
        }
    }

    private int getArrowCount(ItemStack stack) {
        if (ArrowCountMap.getVibraniumBowArrowCount().containsKey(stack.getItem())) {
            return ArrowCountMap.getVibraniumBowArrowCount().get(stack.getItem());
        }
        return 0;
    }
}
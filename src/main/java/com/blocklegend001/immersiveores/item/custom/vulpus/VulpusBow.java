package com.blocklegend001.immersiveores.item.custom.vulpus;

import com.blocklegend001.immersiveores.util.BowTier;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class VulpusBow extends BowItem {
    private final BowTier tier;

    public VulpusBow(BowTier tier, Properties properties) {
        super(properties.durability(tier.getUses()));
        this.tier = tier;
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
    public void releaseUsing(ItemStack stack, Level world, LivingEntity entityLiving, int timeLeft) {
        if (entityLiving instanceof Player player) {
            boolean infiniteArrows = player.getAbilities().instabuild || EnchantmentHelper.getItemEnchantmentLevel(Enchantments.INFINITY_ARROWS, stack) > 0;
            ItemStack arrowStack = player.getProjectile(stack);

            int charge = getUseDuration(stack) - timeLeft;
            float arrowVelocity = getPowerForTime(charge);
            if (arrowVelocity >= 0.1) {
                if (!world.isClientSide) {
                    int arrowCount = 3; // Number of arrows to shoot
                    for (int i = 0; i < arrowCount; i++) {
                        ArrowItem arrowItem = (ArrowItem) (arrowStack.getItem() instanceof ArrowItem ? arrowStack.getItem() : Items.ARROW);
                        AbstractArrow arrowEntity = arrowItem.createArrow(world, arrowStack, player);
                        arrowEntity.shootFromRotation(player, player.getXRot(), player.getYRot() + i * 10 - (arrowCount - 1) * 5, 0.0F, arrowVelocity * 3.0F, 1.0F);

                        if (arrowVelocity == 1.0F) {
                            arrowEntity.setCritArrow(true);
                        }

                        applyEnchantments(player, arrowEntity, stack);

                        // Set the arrow on fire regardless of the bow's enchantments
                        arrowEntity.setSecondsOnFire(300);

                        if (infiniteArrows || player.getAbilities().instabuild && (i == 0 || arrowStack.is(Items.SPECTRAL_ARROW))) {
                            arrowEntity.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
                        }

                        world.addFreshEntity(arrowEntity);
                    }

                    // Add fire particles to create the effect of a wall of fire
                    for (int j = 0; j < 20; j++) {
                        double d0 = player.getRandom().nextGaussian() * 0.02D;
                        double d1 = player.getRandom().nextGaussian() * 0.02D;
                        double d2 = player.getRandom().nextGaussian() * 0.02D;
                        world.addParticle(ParticleTypes.FLAME, player.getX() + (double) (player.getRandom().nextFloat() * player.getBbWidth() * 2.0F) - (double) player.getBbWidth(), player.getY() + 0.5D + (double) (player.getRandom().nextFloat() * player.getBbHeight()), player.getZ() + (double) (player.getRandom().nextFloat() * player.getBbWidth() * 2.0F) - (double) player.getBbWidth(), d0, d1, d2);
                    }
                }
                world.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.ARROW_SHOOT, SoundSource.PLAYERS, 1.0F, 1.0F / (player.getRandom().nextFloat() * 0.4F + 1.2F) + arrowVelocity * 0.5F);
                stack.hurtAndBreak(1, player, (p) -> p.broadcastBreakEvent(player.getUsedItemHand()));

                if (!infiniteArrows && !player.getAbilities().instabuild) {
                    arrowStack.shrink(1);
                    if (arrowStack.isEmpty()) {
                        player.getInventory().removeItem(arrowStack);
                    }
                }
            }
        }
    }

    private void applyEnchantments(Player player, AbstractArrow arrowEntity, ItemStack bowStack) {
        int powerLevel = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.POWER_ARROWS, bowStack);
        if (powerLevel > 0) {
            arrowEntity.setBaseDamage(arrowEntity.getBaseDamage() + (double) powerLevel * 0.5D + 0.5D);
        }

        int punchLevel = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.PUNCH_ARROWS, bowStack);
        if (punchLevel > 0) {
            arrowEntity.setKnockback(punchLevel);
        }

        arrowEntity.setSecondsOnFire(300);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> components, TooltipFlag flag) {
        if(Screen.hasShiftDown()) {
            components.add(Component.literal("+" + Float.toString(this.tier.getAttackDamageBonus()) + " ")
                    .append(Component.translatable("tooltip.immersiveores.damage.tooltip")).withStyle(ChatFormatting.RED));
            components.add(Component.translatable("tooltip.immersiveores.unbreakble.tooltip").withStyle(ChatFormatting.RED));
            components.add(Component.translatable("tooltip.immersiveores.immunetofire.tooltip").withStyle(ChatFormatting.RED));
            components.add(Component.translatable("tooltip.immersiveores.shoot3arrows.tooltip").withStyle(ChatFormatting.RED));
        } else {
            components.add(Component.translatable("tooltip.immersiveores.pressshiftformoreinfo.tooltip").withStyle(ChatFormatting.RED));
        }
    }
}

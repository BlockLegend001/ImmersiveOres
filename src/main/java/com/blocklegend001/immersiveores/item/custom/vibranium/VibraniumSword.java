package com.blocklegend001.immersiveores.item.custom.vibranium;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;

import java.util.List;
import java.util.function.Consumer;

public class VibraniumSword extends Item {

    public VibraniumSword(ToolMaterial material, float attackDamage, float attackSpeed, Properties settings) {
        super(computeSettings(material, settings, attackDamage, attackSpeed));
    }

    private static Properties computeSettings(ToolMaterial material, Properties settings, float attackDamage, float attackSpeed) {
        settings.sword(wrapMaterial(material, material.durability()), attackDamage, attackSpeed);
        return settings;
    }

    @Override
    public void hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (!(attacker instanceof Player player)) return;

        Level world = player.level();
        if (world.isClientSide) return;

        if (!player.isSprinting()
                && player.onGround()
                && target.isDeadOrDying()) {

            double sweepRadius = 1.0;
            List<LivingEntity> nearby = world.getEntitiesOfClass(LivingEntity.class,
                    player.getBoundingBox().inflate(sweepRadius, 0.25, sweepRadius),
                    e -> e != player && e != target && e.isAlive());

            Registry<Enchantment> enchantmentRegistry = world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT);
            Holder.Reference<Enchantment> enchantmentReference = enchantmentRegistry.getOrThrow(Enchantments.SWEEPING_EDGE);

            int sweepingLevel = EnchantmentHelper.getItemEnchantmentLevel(enchantmentReference, player.getMainHandItem());
            float sweepDamage = 1.0F + sweepingLevel * 1.0F;

            for (LivingEntity entity : nearby) {
                entity.hurt(player.damageSources().playerAttack(player), sweepDamage);

                double dx = entity.getX() - player.getX();
                double dz = entity.getZ() - player.getZ();
                double dist = Math.max(0.001, dx * dx + dz * dz);
                entity.knockback(0.4F, dx / dist, dz / dist);
            }

            world.playSound(null, player.getX(), player.getY(), player.getZ(),
                    SoundEvents.PLAYER_ATTACK_SWEEP, SoundSource.PLAYERS, 1.0F, 1.0F);

            if (world instanceof ServerLevel serverLevel) {
                serverLevel.sendParticles(ParticleTypes.SWEEP_ATTACK,
                        player.getX(), player.getY(0.5D), player.getZ(),
                        0, 0, 0, 0, 0.0);
            }
        }
    }

    private static ToolMaterial wrapMaterial(ToolMaterial toolMaterial, int durability) {
        return new ToolMaterial(
                toolMaterial.incorrectBlocksForDrops(),
                durability,
                toolMaterial.speed(),
                toolMaterial.attackDamageBonus(),
                toolMaterial.enchantmentValue(),
                toolMaterial.repairItems()
        );
    }
    @Override
    public void appendHoverText(ItemStack pStack, TooltipContext p_333372_, TooltipDisplay p_396484_, Consumer<Component> consumer, TooltipFlag p_41424_) {
        super.appendHoverText(pStack, p_333372_, p_396484_, consumer, p_41424_);
        if(Screen.hasShiftDown()) {
            consumer.accept(Component.translatable("tooltip.immersiveores.unbreakble.tooltip").withStyle(ChatFormatting.LIGHT_PURPLE));
            consumer.accept(Component.translatable("tooltip.immersiveores.immunetofire.tooltip").withStyle(ChatFormatting.LIGHT_PURPLE));
        } else {
            consumer.accept(Component.translatable("tooltip.immersiveores.pressshiftformoreinfo.tooltip").withStyle(ChatFormatting.LIGHT_PURPLE));
        }
    }
}

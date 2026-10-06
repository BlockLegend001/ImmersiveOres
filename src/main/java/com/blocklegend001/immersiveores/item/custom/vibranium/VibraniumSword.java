package com.blocklegend001.immersiveores.item.custom.vibranium;

import com.blocklegend001.immersiveores.ImmersiveOresClient;
import com.blocklegend001.immersiveores.config.VibraniumConfig;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Unit;
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
        super(computeSettings(material, settings, attackDamage, attackSpeed, VibraniumConfig.unbreakableVibranium, VibraniumConfig.durabilityVibranium));
    }

    private static Properties computeSettings(ToolMaterial material, Properties settings, float attackDamage, float attackSpeed, boolean unbreakable, int durability) {
        settings.sword(wrapMaterial(material, material.durability()), attackDamage, attackSpeed)
                .durability(durability).fireResistant();
        if (unbreakable) {
            settings.component(DataComponents.UNBREAKABLE, Unit.INSTANCE);
        }
        return settings;
    }

    @Override
    public Component getName(ItemStack stack) {
        return super.getName(stack).copy().withStyle(ChatFormatting.LIGHT_PURPLE);
    }

    @Override
    public void postHurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (attacker instanceof Player player) {
            if (!player.isSprinting() &&
                    player.onGround() &&
                    target.isDeadOrDying() &&
                    !player.level().isClientSide()) {

                Level world = player.level();
                double sweepRadius = 1.0;
                List<LivingEntity> entities = world.getEntitiesOfClass(
                        LivingEntity.class,
                        player.getBoundingBox().expandTowards(sweepRadius, 0.25, sweepRadius),
                        e -> e != player && e != target && e.isAlive() && player.canBeSeenAsEnemy()
                );

                Registry<Enchantment> registry = world.registryAccess()
                        .lookupOrThrow(Registries.ENCHANTMENT);

                int sweepingLevel = EnchantmentHelper.getEnchantmentLevel(
                        registry.getOrThrow(Enchantments.SWEEPING_EDGE),
                        player
                );

                float sweepDamage = 1.0F + sweepingLevel * 1.0F;

                for (LivingEntity entity : entities) {
                    entity.hurtServer((ServerLevel) world, player.damageSources().playerAttack(player), sweepDamage);

                    double dx = entity.getX() - player.getX();
                    double dz = entity.getZ() - player.getZ();
                    double dist = Math.max(0.001, dx * dx + dz * dz);
                    entity.knockback(0.4F, dx / dist, dz / dist, player.damageSources().mobAttack(attacker), 1.0F);
                }

                world.playSound(null, player.getX(), player.getY(), player.getZ(),
                        SoundEvents.PLAYER_ATTACK_SWEEP, SoundSource.PLAYERS, 1.0F, 1.0F);
            }
        }

        super.postHurtEnemy(stack, target, attacker);
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
    public void appendHoverText(ItemStack stack, TooltipContext context, TooltipDisplay displayComponent, Consumer<Component> textConsumer, TooltipFlag type) {
        super.appendHoverText(stack, context, displayComponent, textConsumer, type);
        if(ImmersiveOresClient.isShiftKeyPressed()) {
            if (VibraniumConfig.unbreakableVibranium) {
                textConsumer.accept(Component.translatable("tooltip.immersiveores.unbreakble.tooltip").withStyle(ChatFormatting.LIGHT_PURPLE));
            }
            textConsumer.accept(Component.translatable("tooltip.immersiveores.immunetofire.tooltip").withStyle(ChatFormatting.LIGHT_PURPLE));
        } else {
            textConsumer.accept(Component.translatable("tooltip.immersiveores.pressshiftformoreinfo.tooltip").withStyle(ChatFormatting.LIGHT_PURPLE));
        }
    }
}

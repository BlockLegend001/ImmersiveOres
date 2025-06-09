package com.blocklegend001.immersiveores.item.custom.vulpus;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.component.type.TooltipDisplayComponent;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

import java.util.List;
import java.util.function.Consumer;

public class VulpusSword extends Item {
    public VulpusSword(ToolMaterial material, float attackDamage, float attackSpeed, Item.Settings settings) {
        super(computeSettings(material, settings, attackDamage, attackSpeed));
    }

    private static Item.Settings computeSettings(ToolMaterial material, Item.Settings settings, float attackDamage, float attackSpeed) {
        settings.sword(wrapMaterial(material, material.durability()), attackDamage, attackSpeed);
        return settings;
    }

    @Override
    public void postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.setOnFireFor(15);

        if (attacker instanceof PlayerEntity player) {
            if (!player.isSprinting() &&
                    player.isOnGround() &&
                    target.isDead() &&
                    !player.getWorld().isClient) {

                World world = player.getWorld();
                double sweepRadius = 1.0;
                List<LivingEntity> entities = world.getEntitiesByClass(
                        LivingEntity.class,
                        player.getBoundingBox().expand(sweepRadius, 0.25, sweepRadius),
                        e -> e != player && e != target && e.isAlive() && player.canSee(e)
                );

                Registry<Enchantment> enchantmentRegistry = world.getRegistryManager().getOrThrow(RegistryKeys.ENCHANTMENT);
                RegistryEntry.Reference<Enchantment> enchantmentReference = enchantmentRegistry.getOrThrow(Enchantments.SWEEPING_EDGE);

                int sweepingLevel = EnchantmentHelper.getLevel(enchantmentReference, player.getMainHandStack());
                float sweepDamage = 1.0F + sweepingLevel * 1.0F;

                for (LivingEntity entity : entities) {
                    entity.damage((ServerWorld) world, player.getDamageSources().playerAttack(player), sweepDamage);

                    double dx = entity.getX() - player.getX();
                    double dz = entity.getZ() - player.getZ();
                    double dist = Math.max(0.001, dx * dx + dz * dz);
                    entity.takeKnockback(0.4F, dx / dist, dz / dist);
                }

                world.playSound(null, player.getX(), player.getY(), player.getZ(),
                        SoundEvents.ENTITY_PLAYER_ATTACK_SWEEP, SoundCategory.PLAYERS, 1.0F, 1.0F);
                player.spawnSweepAttackParticles();
            }
        }

        super.postHit(stack, target, attacker);
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
    public void appendTooltip(ItemStack stack, TooltipContext context, TooltipDisplayComponent displayComponent, Consumer<Text> textConsumer, TooltipType type) {
        super.appendTooltip(stack, context, displayComponent, textConsumer, type);
        if(Screen.hasShiftDown()) {
            textConsumer.accept(Text.translatable("tooltip.immersiveores.unbreakble.tooltip").formatted(Formatting.RED));
            textConsumer.accept(Text.translatable("tooltip.immersiveores.immunetofire.tooltip").formatted(Formatting.RED));
            textConsumer.accept(Text.translatable("tooltip.immersiveores.cansetmobonfire.tooltip").formatted(Formatting.RED));
        } else {
            textConsumer.accept(Text.translatable("tooltip.immersiveores.pressshiftformoreinfo.tooltip").formatted(Formatting.RED));
        }
    }
}
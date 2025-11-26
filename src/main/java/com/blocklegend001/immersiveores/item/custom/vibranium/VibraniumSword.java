package com.blocklegend001.immersiveores.item.custom.vibranium;

import com.blocklegend001.immersiveores.config.VibraniumConfig;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class VibraniumSword extends SwordItem {
    private static Settings createSettings() {
        return new Settings()
                .fireproof();
    }

    public VibraniumSword(ToolMaterial material, int attackDamage, float attackSpeed) {
        super(material, attackDamage, attackSpeed,
                createSettings());
    }

    @Override
    public boolean isEnchantable(ItemStack p_41456_) {
        return true;
    }

    @Override
    public Text getName(ItemStack stack) {
        return super.getName(stack).copy().formatted(Formatting.LIGHT_PURPLE);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (attacker instanceof PlayerEntity player) {
            if (!player.isSprinting() &&
                    player.isOnGround() &&
                    player.getAttackCooldownProgress(0.5F) > 0.9F &&
                    target.isDead() &&
                    !player.getWorld().isClient) {

                World world = player.getWorld();
                double sweepRadius = 1.0;
                List<LivingEntity> entities = world.getEntitiesByClass(
                        LivingEntity.class,
                        player.getBoundingBox().expand(sweepRadius, 0.25, sweepRadius),
                        e -> e != player && e != target && e.isAlive() && player.canSee(e)
                );

                Registry<Enchantment> enchantmentRegistry = world.getRegistryManager().get(RegistryKeys.ENCHANTMENT);
                Enchantment enchantmentReference = enchantmentRegistry.getEntry(Enchantments.SWEEPING).value();

                int sweepingLevel = EnchantmentHelper.getLevel(enchantmentReference, player.getMainHandStack());
                float sweepDamage = 1.0F + sweepingLevel * 1.0F;

                for (LivingEntity entity : entities) {
                    entity.damage(player.getDamageSources().playerAttack(player), sweepDamage);

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

        return super.postHit(stack, target, attacker);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World contex, List<Text> tooltip, TooltipContext options) {
        if(Screen.hasShiftDown()) {
            if (VibraniumConfig.unbreakableVibranium) {
                tooltip.add(Text.translatable("tooltip.immersiveores.unbreakble.tooltip").formatted(Formatting.LIGHT_PURPLE));
            }
            tooltip.add(Text.translatable("tooltip.immersiveores.immunetofire.tooltip").formatted(Formatting.LIGHT_PURPLE));
        } else {
            tooltip.add(Text.translatable("tooltip.immersiveores.pressshiftformoreinfo.tooltip").formatted(Formatting.LIGHT_PURPLE));
        }
    }
}

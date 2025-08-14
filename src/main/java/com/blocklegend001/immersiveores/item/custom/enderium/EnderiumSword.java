package com.blocklegend001.immersiveores.item.custom.enderium;

import com.blocklegend001.immersiveores.ImmersiveOres;
import com.blocklegend001.immersiveores.config.EnderiumConfig;
import com.blocklegend001.immersiveores.item.ModToolMaterials;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.UnbreakableComponent;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

import java.util.List;

public class EnderiumSword extends SwordItem {
    private static Settings createSettings(boolean unbreakable, int durability) {
        var base = SwordItem.createAttributeModifiers(
                        ModToolMaterials.ENDERIUM,
                        EnderiumConfig.attackDamageEnderiumSword,
                        (float) EnderiumConfig.attackSpeedEnderiumSword
                )
                .with(
                        EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
                        new EntityAttributeModifier(
                                Identifier.of(ImmersiveOres.MOD_ID, "enderium_entity_reach"),
                                EnderiumConfig.attackRangeEnderiumSword,
                                EntityAttributeModifier.Operation.ADD_VALUE
                        ),
                        AttributeModifierSlot.MAINHAND
                );

        Settings settings = new Settings()
                .maxDamage(durability)
                .fireproof()
                .attributeModifiers(base);

        if (unbreakable) {
            settings.component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true));
        }

        return settings;
    }

    public EnderiumSword(ToolMaterial material, int attackDamage, float attackSpeed) {
        super(material,
                createSettings(EnderiumConfig.unbreakableEnderium, EnderiumConfig.durabilityEnderium));
    }

    @Override
    public boolean isEnchantable(ItemStack p_41456_) {
        return true;
    }

    @Override
    public Text getName(ItemStack stack) {
        return super.getName(stack).copy().formatted(Formatting.DARK_AQUA);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.setOnFireFor(30);

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
                RegistryEntry.Reference<Enchantment> enchantmentReference = enchantmentRegistry.getEntry(Enchantments.SWEEPING_EDGE).orElseThrow();

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
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType options) {
        if(Screen.hasShiftDown()) {
            if (EnderiumConfig.unbreakableEnderium) {
                tooltip.add(Text.translatable("tooltip.immersiveores.unbreakble.tooltip").formatted(Formatting.DARK_AQUA));
            }
            tooltip.add(Text.translatable("tooltip.immersiveores.immunetofire.tooltip").formatted(Formatting.DARK_AQUA));
            tooltip.add(Text.translatable("tooltip.immersiveores.cansetmobonfire.tooltip").formatted(Formatting.DARK_AQUA));
        } else {
            tooltip.add(Text.translatable("tooltip.immersiveores.pressshiftformoreinfo.tooltip").formatted(Formatting.DARK_AQUA));
        }
    }
}

package com.blocklegend001.immersiveores.item.custom.vulpus;

import com.blocklegend001.immersiveores.config.VulpusConfig;
import com.blocklegend001.immersiveores.item.ModItems;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

import java.util.List;

public class VulpusArmor extends ArmorItem {
    public VulpusArmor(RegistryEntry<ArmorMaterial> material, ArmorItem.Type type, Settings settings) {
        super(material, type, settings);
    }
    
    @Override
    public boolean isEnchantable(ItemStack p_41456_) {
        return true;
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!world.isClient()) {
            if(entity instanceof PlayerEntity player) {
            if (player.getInventory().getArmorStack(0).getItem() == ModItems.VULPUS_BOOTS) {
                if (VulpusConfig.speedIIVulpusArmor) {
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 0, 1, false, false));
                } if (VulpusConfig.jumpIIVulpusArmor) {
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 0, 1, false, false));
                } if (VulpusConfig.fireResistanceVulpusArmor) {
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 0, 0, false, false));
                }
                if (!player.isOnGround() && player.fallDistance >= 1.0F && VulpusConfig.immuneToFallDamageVulpusArmor) {
                    player.fallDistance = 0F;
                }
            }
            if (player.getInventory().getArmorStack(2).getItem() == ModItems.VULPUS_CHESTPLATE) {
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 0, 1, false, false));
            }
            if (player.getInventory().getArmorStack(3).getItem() == ModItems.VULPUS_HELMET) {
                if (VulpusConfig.nightVisionVulpusArmor) {
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 400, 0, false, false));
                } if (VulpusConfig.fireResistanceVulpusArmor) {
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 0, 0, false, false));
                }
            }
            if (player.getInventory().getArmorStack(1).getItem() == ModItems.VULPUS_LEGGINGS) {
                if (VulpusConfig.fireResistanceVulpusArmor) {
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 0, 0, false, false));
                }
                if (VulpusConfig.neverLoseHungerVulpusArmor) {
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.SATURATION, 0, 99, false, false));
                }
            }
            }
        }
    }

    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType options) {
        if(Screen.hasShiftDown()){
            if (ModItems.VULPUS_BOOTS == stack.getItem()) {
                tooltip.add(Text.translatable("tooltip.immersiveores.unbreakble.tooltip").formatted(Formatting.RED));
                tooltip.add(Text.translatable("tooltip.immersiveores.immunetofire.tooltip").formatted(Formatting.RED));
                if (VulpusConfig.speedIIVulpusArmor) {
                    tooltip.add(Text.translatable("tooltip.immersiveores.speed2.tooltip").formatted(Formatting.RED));
                } if (VulpusConfig.jumpIIVulpusArmor) {
                    tooltip.add(Text.translatable("tooltip.immersiveores.jump2.tooltip").formatted(Formatting.RED));
                }
                if (VulpusConfig.canWalkOnPowderedSnowVulpus) {
                    tooltip.add(Text.translatable("tooltip.immersiveores.canwalkonpowderedsnow.tooltip").formatted(Formatting.RED));
                } if (VulpusConfig.makesPiglinsNeutralVulpus) {
                    tooltip.add(Text.translatable("tooltip.immersiveores.immunetopiglin.tooltip").formatted(Formatting.RED));
                } if (VulpusConfig.fireResistanceVulpusArmor) {
                    tooltip.add(Text.translatable("tooltip.immersiveores.playerimmunetofire.tooltip").formatted(Formatting.RED));
                } if (VulpusConfig.immuneToFallDamageVulpusArmor) {
                    tooltip.add(Text.translatable("tooltip.immersiveores.immunetofalldamage.tooltip").formatted(Formatting.RED));
                }
            }
            if (ModItems.VULPUS_CHESTPLATE == stack.getItem()) {
                tooltip.add(Text.translatable("tooltip.immersiveores.unbreakble.tooltip").formatted(Formatting.RED));
                tooltip.add(Text.translatable("tooltip.immersiveores.immunetofire.tooltip").formatted(Formatting.RED));
                if (VulpusConfig.makesPiglinsNeutralVulpus) {
                    tooltip.add(Text.translatable("tooltip.immersiveores.immunetopiglin.tooltip").formatted(Formatting.RED));
                } if (VulpusConfig.fireResistanceVulpusArmor) {
                    tooltip.add(Text.translatable("tooltip.immersiveores.playerimmunetofire.tooltip").formatted(Formatting.RED));
                }
            }
            if (ModItems.VULPUS_HELMET == stack.getItem()) {
                tooltip.add(Text.translatable("tooltip.immersiveores.unbreakble.tooltip").formatted(Formatting.RED));
                tooltip.add(Text.translatable("tooltip.immersiveores.immunetofire.tooltip").formatted(Formatting.RED));
                if (VulpusConfig.nightVisionVulpusArmor) {
                    tooltip.add(Text.translatable("tooltip.immersiveores.nightvision.tooltip").formatted(Formatting.RED));
                } if (VulpusConfig.makesPiglinsNeutralVulpus) {
                    tooltip.add(Text.translatable("tooltip.immersiveores.immunetopiglin.tooltip").formatted(Formatting.RED));
                } if (VulpusConfig.fireResistanceVulpusArmor) {
                    tooltip.add(Text.translatable("tooltip.immersiveores.playerimmunetofire.tooltip").formatted(Formatting.RED));
                }
            }
            if (ModItems.VULPUS_LEGGINGS == stack.getItem()) {
                tooltip.add(Text.translatable("tooltip.immersiveores.unbreakble.tooltip").formatted(Formatting.RED));
                tooltip.add(Text.translatable("tooltip.immersiveores.immunetofire.tooltip").formatted(Formatting.RED));
                if (VulpusConfig.makesPiglinsNeutralVulpus) {
                    tooltip.add(Text.translatable("tooltip.immersiveores.immunetopiglin.tooltip").formatted(Formatting.RED));
                } if (VulpusConfig.fireResistanceVulpusArmor) {
                    tooltip.add(Text.translatable("tooltip.immersiveores.playerimmunetofire.tooltip").formatted(Formatting.RED));
                } if (VulpusConfig.neverLoseHungerVulpusArmor) {
                    tooltip.add(Text.translatable("tooltip.immersiveores.nerverlosehunger.tooltip").formatted(Formatting.RED));
                }
            }
        } else {
            tooltip.add(Text.translatable("tooltip.immersiveores.pressshiftformoreinfo.tooltip").formatted(Formatting.RED));
        }
    }
}

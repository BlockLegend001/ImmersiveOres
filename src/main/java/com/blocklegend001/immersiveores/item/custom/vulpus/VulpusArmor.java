package com.blocklegend001.immersiveores.item.custom.vulpus;

import com.blocklegend001.immersiveores.config.VulpusConfig;
import com.blocklegend001.immersiveores.item.ModArmorMaterials;
import com.blocklegend001.immersiveores.item.ModItems;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.UnbreakableComponent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

import java.util.List;

public class VulpusArmor extends ArmorItem {
    private static Settings createSettings(Settings base, boolean unbreakable, int durability) {
        base.maxDamage(durability).fireproof();
        if (unbreakable) {
            base.component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true));
        }
        return base;
    }

    public VulpusArmor(ArmorMaterial material, EquipmentType type, Settings settings) {
        super(material, type, createSettings(settings, VulpusConfig.unbreakableVulpus, VulpusConfig.durabilityVulpus));
    }

    @Override
    public Text getName(ItemStack stack) {
        return super.getName(stack).copy().formatted(Formatting.RED);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!world.isClient()) {
            if(entity instanceof PlayerEntity player) {
            if (player.getInventory().getArmorStack(0).getItem() == ModItems.VULPUS_BOOTS) {
                if (VulpusConfig.speedIIVulpusArmor) {
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 400, 1, false, false));
                } if (VulpusConfig.jumpIIVulpusArmor) {
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 400, 1, false, false));
                } if (VulpusConfig.fireResistanceVulpusArmor) {
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 400, 0, false, false));
                }
                if (!player.isOnGround() && player.fallDistance >= 1.0F && VulpusConfig.immuneToFallDamageVulpusArmor) {
                    player.fallDistance = 0F;
                }
            }
            if (player.getInventory().getArmorStack(2).getItem() == ModItems.VULPUS_CHESTPLATE) {
                if (VulpusConfig.fireResistanceVulpusArmor) {
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 400, 0, false, false));
                }
            }
            if (player.getInventory().getArmorStack(3).getItem() == ModItems.VULPUS_HELMET) {
                if (VulpusConfig.nightVisionVulpusArmor) {
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 400, 0, false, false));
                } if (VulpusConfig.fireResistanceVulpusArmor) {
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 400, 0, false, false));
                }
            }
            if (player.getInventory().getArmorStack(1).getItem() == ModItems.VULPUS_LEGGINGS) {
                if (VulpusConfig.fireResistanceVulpusArmor) {
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 400, 0, false, false));
                }
                if (VulpusConfig.neverLoseHungerVulpusArmor) {
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.SATURATION, 400, 99, false, false));
                }
            }
            }
        }
    }

    @Override
    public void onCraftByPlayer(ItemStack stack, World world, PlayerEntity player) {
        super.onCraftByPlayer(stack, world, player);

        Item resultItem = stack.getItem();

        for (int i = 1; i <= 9; i++) {
            ItemStack ingredient = player.currentScreenHandler.getSlot(i).getStack();
            Item ingredientItem = ingredient.getItem();

            if (resultItem == ModItems.VULPUS_HELMET && ingredientItem == ModItems.VIBRANIUM_HELMET
                    || resultItem == ModItems.VULPUS_CHESTPLATE && ingredientItem == ModItems.VIBRANIUM_CHESTPLATE
                    || resultItem == ModItems.VULPUS_LEGGINGS && ingredientItem == ModItems.VIBRANIUM_LEGGINGS
                    || resultItem == ModItems.VULPUS_BOOTS && ingredientItem == ModItems.VIBRANIUM_BOOTS) {

                var ench = ingredient.get(DataComponentTypes.ENCHANTMENTS);
                if (ench != null) {
                    stack.set(DataComponentTypes.ENCHANTMENTS, ench);
                }

                var customName = ingredient.get(DataComponentTypes.CUSTOM_NAME);
                if (customName != null) {
                    stack.set(DataComponentTypes.CUSTOM_NAME, customName);
                }

                break;
            }
        }
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType options) {
        if(Screen.hasShiftDown()){
            if (ModItems.VULPUS_BOOTS == stack.getItem()) {
                if (VulpusConfig.unbreakableVulpus) {
                    tooltip.add(Text.translatable("tooltip.immersiveores.unbreakble.tooltip").formatted(Formatting.RED));
                }
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
                if (VulpusConfig.unbreakableVulpus) {
                    tooltip.add(Text.translatable("tooltip.immersiveores.unbreakble.tooltip").formatted(Formatting.RED));
                }
                tooltip.add(Text.translatable("tooltip.immersiveores.immunetofire.tooltip").formatted(Formatting.RED));
                if (VulpusConfig.makesPiglinsNeutralVulpus) {
                    tooltip.add(Text.translatable("tooltip.immersiveores.immunetopiglin.tooltip").formatted(Formatting.RED));
                } if (VulpusConfig.fireResistanceVulpusArmor) {
                    tooltip.add(Text.translatable("tooltip.immersiveores.playerimmunetofire.tooltip").formatted(Formatting.RED));
                }
            }
            if (ModItems.VULPUS_HELMET == stack.getItem()) {
                if (VulpusConfig.unbreakableVulpus) {
                    tooltip.add(Text.translatable("tooltip.immersiveores.unbreakble.tooltip").formatted(Formatting.RED));
                }
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
                if (VulpusConfig.unbreakableVulpus) {
                    tooltip.add(Text.translatable("tooltip.immersiveores.unbreakble.tooltip").formatted(Formatting.RED));
                }
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
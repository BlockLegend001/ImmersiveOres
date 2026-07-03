package com.blocklegend001.immersiveores.item.custom.vulpus;

import com.blocklegend001.immersiveores.ImmersiveOresClient;
import com.blocklegend001.immersiveores.config.VulpusConfig;
import com.blocklegend001.immersiveores.item.ModItems;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.EquippableComponent;
import net.minecraft.component.type.TooltipDisplayComponent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.item.equipment.trim.ArmorTrim;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Unit;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Consumer;

public class VulpusArmor extends Item {
    public VulpusArmor(ArmorMaterial material, EquipmentType type, Settings settings) {
        super(computeSettings(material, type, settings, VulpusConfig.unbreakableVulpus, VulpusConfig.durabilityVulpus));
    }

    private static Settings computeSettings(ArmorMaterial material, EquipmentType type, Settings settings, boolean unbreakable, int durability) {
        settings.armor(material, EquipmentType.BODY)
                .attributeModifiers(material.createAttributeModifiers(type))
                .enchantable(material.enchantmentValue())
                .component(DataComponentTypes.EQUIPPABLE, EquippableComponent.builder(type.getEquipmentSlot()).equipSound(material.equipSound()).model(material.assetId()).build())
                .maxDamage(durability).fireproof();
                if (unbreakable) {
                    settings.component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE);
                }

        return settings;
    }

    @Override
    public Text getName(ItemStack stack) {
        return super.getName(stack).copy().formatted(Formatting.RED);
    }

    @Override
    public void inventoryTick(ItemStack stack, ServerWorld world, Entity entity, @Nullable EquipmentSlot slot) {
        if (!world.isClient()) {
            if(entity instanceof PlayerEntity player) {
            if (player.getEquippedStack(EquipmentSlot.FEET).getItem() == ModItems.VULPUS_BOOTS) {
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
            if (player.getEquippedStack(EquipmentSlot.CHEST).getItem() == ModItems.VULPUS_CHESTPLATE) {
                if (VulpusConfig.fireResistanceVulpusArmor) {
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 400, 0, false, false));
                }
            }
            if (player.getEquippedStack(EquipmentSlot.HEAD).getItem() == ModItems.VULPUS_HELMET) {
                if (VulpusConfig.nightVisionVulpusArmor) {
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 400, 0, false, false));
                } if (VulpusConfig.fireResistanceVulpusArmor) {
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 400, 0, false, false));
                }
            }
            if (player.getEquippedStack(EquipmentSlot.LEGS).getItem() == ModItems.VULPUS_LEGGINGS) {
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
    public void onCraftByPlayer(ItemStack stack, PlayerEntity player) {
        super.onCraftByPlayer(stack, player);

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

                ArmorTrim trim = ingredient.get(DataComponentTypes.TRIM);
                if (trim != null) {
                    stack.set(DataComponentTypes.TRIM, trim);
                }

                break;
            }
        }
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, TooltipDisplayComponent displayComponent, Consumer<Text> textConsumer, TooltipType type) {
        super.appendTooltip(stack, context, displayComponent, textConsumer, type);
        if(ImmersiveOresClient.isShiftKeyPressed()){
            if (ModItems.VULPUS_BOOTS == stack.getItem()) {
                if (VulpusConfig.unbreakableVulpus) {
                    textConsumer.accept(Text.translatable("tooltip.immersiveores.unbreakble.tooltip").formatted(Formatting.RED));
                }
                textConsumer.accept(Text.translatable("tooltip.immersiveores.immunetofire.tooltip").formatted(Formatting.RED));
                if (VulpusConfig.speedIIVulpusArmor) {
                    textConsumer.accept(Text.translatable("tooltip.immersiveores.speed2.tooltip").formatted(Formatting.RED));
                } if (VulpusConfig.jumpIIVulpusArmor) {
                    textConsumer.accept(Text.translatable("tooltip.immersiveores.jump2.tooltip").formatted(Formatting.RED));
                }
                if (VulpusConfig.canWalkOnPowderedSnowVulpus) {
                    textConsumer.accept(Text.translatable("tooltip.immersiveores.canwalkonpowderedsnow.tooltip").formatted(Formatting.RED));
                } if (VulpusConfig.makesPiglinsNeutralVulpus) {
                    textConsumer.accept(Text.translatable("tooltip.immersiveores.immunetopiglin.tooltip").formatted(Formatting.RED));
                } if (VulpusConfig.fireResistanceVulpusArmor) {
                    textConsumer.accept(Text.translatable("tooltip.immersiveores.playerimmunetofire.tooltip").formatted(Formatting.RED));
                } if (VulpusConfig.immuneToFallDamageVulpusArmor) {
                    textConsumer.accept(Text.translatable("tooltip.immersiveores.immunetofalldamage.tooltip").formatted(Formatting.RED));
                }
            }
            if (ModItems.VULPUS_CHESTPLATE == stack.getItem()) {
                if (VulpusConfig.unbreakableVulpus) {
                    textConsumer.accept(Text.translatable("tooltip.immersiveores.unbreakble.tooltip").formatted(Formatting.RED));
                }
                textConsumer.accept(Text.translatable("tooltip.immersiveores.immunetofire.tooltip").formatted(Formatting.RED));
                if (VulpusConfig.makesPiglinsNeutralVulpus) {
                    textConsumer.accept(Text.translatable("tooltip.immersiveores.immunetopiglin.tooltip").formatted(Formatting.RED));
                } if (VulpusConfig.fireResistanceVulpusArmor) {
                    textConsumer.accept(Text.translatable("tooltip.immersiveores.playerimmunetofire.tooltip").formatted(Formatting.RED));
                }
            }
            if (ModItems.VULPUS_HELMET == stack.getItem()) {
                if (VulpusConfig.unbreakableVulpus) {
                    textConsumer.accept(Text.translatable("tooltip.immersiveores.unbreakble.tooltip").formatted(Formatting.RED));
                }
                textConsumer.accept(Text.translatable("tooltip.immersiveores.immunetofire.tooltip").formatted(Formatting.RED));
                if (VulpusConfig.nightVisionVulpusArmor) {
                    textConsumer.accept(Text.translatable("tooltip.immersiveores.nightvision.tooltip").formatted(Formatting.RED));
                } if (VulpusConfig.makesPiglinsNeutralVulpus) {
                    textConsumer.accept(Text.translatable("tooltip.immersiveores.immunetopiglin.tooltip").formatted(Formatting.RED));
                } if (VulpusConfig.fireResistanceVulpusArmor) {
                    textConsumer.accept(Text.translatable("tooltip.immersiveores.playerimmunetofire.tooltip").formatted(Formatting.RED));
                }
            }
            if (ModItems.VULPUS_LEGGINGS == stack.getItem()) {
                if (VulpusConfig.unbreakableVulpus) {
                    textConsumer.accept(Text.translatable("tooltip.immersiveores.unbreakble.tooltip").formatted(Formatting.RED));
                }
                textConsumer.accept(Text.translatable("tooltip.immersiveores.immunetofire.tooltip").formatted(Formatting.RED));
                if (VulpusConfig.makesPiglinsNeutralVulpus) {
                    textConsumer.accept(Text.translatable("tooltip.immersiveores.immunetopiglin.tooltip").formatted(Formatting.RED));
                } if (VulpusConfig.fireResistanceVulpusArmor) {
                    textConsumer.accept(Text.translatable("tooltip.immersiveores.playerimmunetofire.tooltip").formatted(Formatting.RED));
                } if (VulpusConfig.neverLoseHungerVulpusArmor) {
                    textConsumer.accept(Text.translatable("tooltip.immersiveores.nerverlosehunger.tooltip").formatted(Formatting.RED));
                }
            }
        } else {
            textConsumer.accept(Text.translatable("tooltip.immersiveores.pressshiftformoreinfo.tooltip").formatted(Formatting.RED));
        }
    }
}
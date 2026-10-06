package com.blocklegend001.immersiveores.item.custom.vulpus;

import com.blocklegend001.immersiveores.ImmersiveOresClient;
import com.blocklegend001.immersiveores.config.VulpusConfig;
import com.blocklegend001.immersiveores.item.ModItems;
import net.minecraft.ChatFormatting;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Unit;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.Equippable;
import net.minecraft.world.item.equipment.trim.ArmorTrim;
import org.jspecify.annotations.Nullable;

import java.util.function.Consumer;

public class VulpusArmor extends Item {
    public VulpusArmor(ArmorMaterial material, ArmorType type, Properties settings) {
        super(computeSettings(material, type, settings, VulpusConfig.unbreakableVulpus, VulpusConfig.durabilityVulpus));
    }

    private static Properties computeSettings(ArmorMaterial material, ArmorType type, Properties settings, boolean unbreakable, int durability) {
        settings.humanoidArmor(material, ArmorType.BODY)
                .attributes(material.createAttributes(type))
                .enchantable(material.enchantmentValue())
                .component(DataComponents.EQUIPPABLE, Equippable.builder(type.getSlot()).setEquipSound(material.equipSound()).setAsset(material.assetId()).build())
                .durability(durability).fireResistant();
                if (unbreakable) {
                    settings.component(DataComponents.UNBREAKABLE, Unit.INSTANCE);
                }

        return settings;
    }

    @Override
    public Component getName(ItemStack stack) {
        return super.getName(stack).copy().withStyle(ChatFormatting.RED);
    }

    @Override
    public void inventoryTick(ItemStack stack, ServerLevel world, Entity entity, @Nullable EquipmentSlot slot) {
        if (!world.isClientSide()) {
            if(entity instanceof Player player) {
            if (player.getItemBySlot(EquipmentSlot.FEET).getItem() == ModItems.VULPUS_BOOTS) {
                if (VulpusConfig.speedIIVulpusArmor) {
                    player.addEffect(new MobEffectInstance(MobEffects.SPEED, 400, 1, false, false));
                } if (VulpusConfig.jumpIIVulpusArmor) {
                    player.addEffect(new MobEffectInstance(MobEffects.JUMP_BOOST, 400, 1, false, false));
                } if (VulpusConfig.fireResistanceVulpusArmor) {
                    player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 400, 0, false, false));
                }
                if (!player.onGround() && player.fallDistance >= 1.0F && VulpusConfig.immuneToFallDamageVulpusArmor) {
                    player.fallDistance = 0F;
                }
            }
            if (player.getItemBySlot(EquipmentSlot.CHEST).getItem() == ModItems.VULPUS_CHESTPLATE) {
                if (VulpusConfig.fireResistanceVulpusArmor) {
                    player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 400, 0, false, false));
                }
            }
            if (player.getItemBySlot(EquipmentSlot.HEAD).getItem() == ModItems.VULPUS_HELMET) {
                if (VulpusConfig.nightVisionVulpusArmor) {
                    player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0, false, false));
                } if (VulpusConfig.fireResistanceVulpusArmor) {
                    player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 400, 0, false, false));
                }
            }
            if (player.getItemBySlot(EquipmentSlot.LEGS).getItem() == ModItems.VULPUS_LEGGINGS) {
                if (VulpusConfig.fireResistanceVulpusArmor) {
                    player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 400, 0, false, false));
                }
                if (VulpusConfig.neverLoseHungerVulpusArmor) {
                    player.addEffect(new MobEffectInstance(MobEffects.SATURATION, 400, 99, false, false));
                }
            }
            }
        }
    }

    @Override
    public void onCraftedBy(ItemStack stack, Player player) {
        super.onCraftedBy(stack, player);

        Item resultItem = stack.getItem();

        for (int i = 1; i <= 9; i++) {
            ItemStack ingredient = player.containerMenu.getSlot(i).getItem();
            Item ingredientItem = ingredient.getItem();

            if (resultItem == ModItems.VULPUS_HELMET && ingredientItem == ModItems.VIBRANIUM_HELMET
                    || resultItem == ModItems.VULPUS_CHESTPLATE && ingredientItem == ModItems.VIBRANIUM_CHESTPLATE
                    || resultItem == ModItems.VULPUS_LEGGINGS && ingredientItem == ModItems.VIBRANIUM_LEGGINGS
                    || resultItem == ModItems.VULPUS_BOOTS && ingredientItem == ModItems.VIBRANIUM_BOOTS) {

                var ench = ingredient.get(DataComponents.ENCHANTMENTS);
                if (ench != null) {
                    stack.set(DataComponents.ENCHANTMENTS, ench);
                }

                var customName = ingredient.get(DataComponents.CUSTOM_NAME);
                if (customName != null) {
                    stack.set(DataComponents.CUSTOM_NAME, customName);
                }

                ArmorTrim trim = ingredient.get(DataComponents.TRIM);
                if (trim != null) {
                    stack.set(DataComponents.TRIM, trim);
                }

                break;
            }
        }
    }
    
    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, TooltipDisplay displayComponent, Consumer<Component> textConsumer, TooltipFlag type) {
        super.appendHoverText(stack, context, displayComponent, textConsumer, type);
        if(ImmersiveOresClient.isShiftKeyPressed()){
            if (ModItems.VULPUS_BOOTS == stack.getItem()) {
                if (VulpusConfig.unbreakableVulpus) {
                    textConsumer.accept(Component.translatable("tooltip.immersiveores.unbreakble.tooltip").withStyle(ChatFormatting.RED));
                }
                textConsumer.accept(Component.translatable("tooltip.immersiveores.immunetofire.tooltip").withStyle(ChatFormatting.RED));
                if (VulpusConfig.speedIIVulpusArmor) {
                    textConsumer.accept(Component.translatable("tooltip.immersiveores.speed2.tooltip").withStyle(ChatFormatting.RED));
                } if (VulpusConfig.jumpIIVulpusArmor) {
                    textConsumer.accept(Component.translatable("tooltip.immersiveores.jump2.tooltip").withStyle(ChatFormatting.RED));
                }
                if (VulpusConfig.canWalkOnPowderedSnowVulpus) {
                    textConsumer.accept(Component.translatable("tooltip.immersiveores.canwalkonpowderedsnow.tooltip").withStyle(ChatFormatting.RED));
                } if (VulpusConfig.makesPiglinsNeutralVulpus) {
                    textConsumer.accept(Component.translatable("tooltip.immersiveores.immunetopiglin.tooltip").withStyle(ChatFormatting.RED));
                } if (VulpusConfig.fireResistanceVulpusArmor) {
                    textConsumer.accept(Component.translatable("tooltip.immersiveores.playerimmunetofire.tooltip").withStyle(ChatFormatting.RED));
                } if (VulpusConfig.immuneToFallDamageVulpusArmor) {
                    textConsumer.accept(Component.translatable("tooltip.immersiveores.immunetofalldamage.tooltip").withStyle(ChatFormatting.RED));
                }
            }
            if (ModItems.VULPUS_CHESTPLATE == stack.getItem()) {
                if (VulpusConfig.unbreakableVulpus) {
                    textConsumer.accept(Component.translatable("tooltip.immersiveores.unbreakble.tooltip").withStyle(ChatFormatting.RED));
                }
                textConsumer.accept(Component.translatable("tooltip.immersiveores.immunetofire.tooltip").withStyle(ChatFormatting.RED));
                if (VulpusConfig.makesPiglinsNeutralVulpus) {
                    textConsumer.accept(Component.translatable("tooltip.immersiveores.immunetopiglin.tooltip").withStyle(ChatFormatting.RED));
                } if (VulpusConfig.fireResistanceVulpusArmor) {
                    textConsumer.accept(Component.translatable("tooltip.immersiveores.playerimmunetofire.tooltip").withStyle(ChatFormatting.RED));
                }
            }
            if (ModItems.VULPUS_HELMET == stack.getItem()) {
                if (VulpusConfig.unbreakableVulpus) {
                    textConsumer.accept(Component.translatable("tooltip.immersiveores.unbreakble.tooltip").withStyle(ChatFormatting.RED));
                }
                textConsumer.accept(Component.translatable("tooltip.immersiveores.immunetofire.tooltip").withStyle(ChatFormatting.RED));
                if (VulpusConfig.nightVisionVulpusArmor) {
                    textConsumer.accept(Component.translatable("tooltip.immersiveores.nightvision.tooltip").withStyle(ChatFormatting.RED));
                } if (VulpusConfig.makesPiglinsNeutralVulpus) {
                    textConsumer.accept(Component.translatable("tooltip.immersiveores.immunetopiglin.tooltip").withStyle(ChatFormatting.RED));
                } if (VulpusConfig.fireResistanceVulpusArmor) {
                    textConsumer.accept(Component.translatable("tooltip.immersiveores.playerimmunetofire.tooltip").withStyle(ChatFormatting.RED));
                }
            }
            if (ModItems.VULPUS_LEGGINGS == stack.getItem()) {
                if (VulpusConfig.unbreakableVulpus) {
                    textConsumer.accept(Component.translatable("tooltip.immersiveores.unbreakble.tooltip").withStyle(ChatFormatting.RED));
                }
                textConsumer.accept(Component.translatable("tooltip.immersiveores.immunetofire.tooltip").withStyle(ChatFormatting.RED));
                if (VulpusConfig.makesPiglinsNeutralVulpus) {
                    textConsumer.accept(Component.translatable("tooltip.immersiveores.immunetopiglin.tooltip").withStyle(ChatFormatting.RED));
                } if (VulpusConfig.fireResistanceVulpusArmor) {
                    textConsumer.accept(Component.translatable("tooltip.immersiveores.playerimmunetofire.tooltip").withStyle(ChatFormatting.RED));
                } if (VulpusConfig.neverLoseHungerVulpusArmor) {
                    textConsumer.accept(Component.translatable("tooltip.immersiveores.nerverlosehunger.tooltip").withStyle(ChatFormatting.RED));
                }
            }
        } else {
            textConsumer.accept(Component.translatable("tooltip.immersiveores.pressshiftformoreinfo.tooltip").withStyle(ChatFormatting.RED));
        }
    }
}
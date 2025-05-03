package com.blocklegend001.immersiveores.item.custom.enderium;

import com.blocklegend001.immersiveores.config.EnderiumConfig;
import com.blocklegend001.immersiveores.item.ModItems;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.Equippable;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Consumer;

public class EnderiumArmor extends Item {

    public EnderiumArmor(ArmorMaterial material, ArmorType type, Properties settings) {
        super(computeSettings(material, type, settings));
    }

    private static Properties computeSettings(ArmorMaterial material, ArmorType type, Properties settings) {
        settings.humanoidArmor(material, ArmorType.BODY)
                .attributes(material.createAttributes(type))
                .enchantable(material.enchantmentValue())
                .component(DataComponents.EQUIPPABLE, Equippable.builder(type.getSlot()).setEquipSound(material.equipSound()).setAsset(material.assetId()).build());
        return settings;
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, @Nullable EquipmentSlot slot, int slotIndex) {
        super.inventoryTick(stack, level, entity, slot, slotIndex);
        if (!level.isClientSide()) {
            if (entity instanceof Player player) {
                if (player.getItemBySlot(EquipmentSlot.FEET).getItem() == ModItems.ENDERIUM_BOOTS.get()) {
                    if (EnderiumConfig.speedIIIEnderiumArmor) {
                        player.addEffect(new MobEffectInstance(MobEffects.SPEED, 400, 2, false, false));
                    }
                    if (EnderiumConfig.jumpIIIEnderiumArmor) {
                        player.addEffect(new MobEffectInstance(MobEffects.JUMP_BOOST, 400, 2, false, false));
                    }
                    if (EnderiumConfig.fireResistanceEnderiumArmor) {
                        player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 400, 1, false, false));
                    }
                    if (!player.onGround() && player.fallDistance >= 1.0F && EnderiumConfig.immuneToFallDamageEnderiumArmor) {
                        player.fallDistance = 0F;
                    }
                }
                if (player.getItemBySlot(EquipmentSlot.CHEST).getItem() == ModItems.ENDERIUM_CHESTPLATE.get()) {
                    if (EnderiumConfig.fireResistanceEnderiumArmor) {
                        player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 400, 0, false, false));
                    }
                }
                if (player.getItemBySlot(EquipmentSlot.HEAD).getItem() == ModItems.ENDERIUM_HELMET.get()) {
                    if (EnderiumConfig.nightVisionEnderiumArmor) {
                        player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0, false, false));
                    }
                    if (EnderiumConfig.fireResistanceEnderiumArmor) {
                        player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 400, 0, false, false));
                    }
                }
                if (player.getItemBySlot(EquipmentSlot.LEGS).getItem() == ModItems.ENDERIUM_LEGGINGS.get()) {
                    if (EnderiumConfig.neverLoseHungerEnderiumArmor) {
                        player.addEffect(new MobEffectInstance(MobEffects.SATURATION, 400, 99, false, false));
                    }
                    if (EnderiumConfig.fireResistanceEnderiumArmor) {
                        player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 400, 0, false, false));
                    }
                }
            }
        }
    }

    @Override
    public void appendHoverText(ItemStack pStack, Item.TooltipContext p_333372_, TooltipDisplay p_396484_, Consumer<Component> consumer, TooltipFlag p_41424_) {
        super.appendHoverText(pStack, p_333372_, p_396484_, consumer, p_41424_);
        if(Screen.hasShiftDown()) {
            if (ModItems.ENDERIUM_BOOTS.get() == pStack.getItem()) {
                consumer.accept(Component.translatable("tooltip.immersiveores.unbreakble.tooltip").withStyle(ChatFormatting.DARK_AQUA));
                consumer.accept(Component.translatable("tooltip.immersiveores.immunetofire.tooltip").withStyle(ChatFormatting.DARK_AQUA));
                if (EnderiumConfig.speedIIIEnderiumArmor) {
                    consumer.accept(Component.translatable("tooltip.immersiveores.speed3.tooltip").withStyle(ChatFormatting.DARK_AQUA));
                } if (EnderiumConfig.jumpIIIEnderiumArmor) {
                    consumer.accept(Component.translatable("tooltip.immersiveores.jump3.tooltip").withStyle(ChatFormatting.DARK_AQUA));
                } if (EnderiumConfig.canWalkOnPowderedSnowEnderium) {
                    consumer.accept(Component.translatable("tooltip.immersiveores.canwalkonpowderedsnow.tooltip").withStyle(ChatFormatting.DARK_AQUA));
                } if (EnderiumConfig.fireResistanceEnderiumArmor) {
                    consumer.accept(Component.translatable("tooltip.immersiveores.playerimmunetofire.tooltip").withStyle(ChatFormatting.DARK_AQUA));
                } if (EnderiumConfig.makesPiglinsNeutralEnderium) {
                    consumer.accept(Component.translatable("tooltip.immersiveores.immunetopiglin.tooltip").withStyle(ChatFormatting.DARK_AQUA));
                } if (EnderiumConfig.immuneToFallDamageEnderiumArmor) {
                    consumer.accept(Component.translatable("tooltip.immersiveores.immunetofalldamage.tooltip").withStyle(ChatFormatting.DARK_AQUA));
                } if (EnderiumConfig.canFlyEnderiumArmor) {
                    consumer.accept(Component.translatable("tooltip.immersiveores.canfly.tooltip").withStyle(ChatFormatting.DARK_AQUA));
                }
            }
            if (ModItems.ENDERIUM_CHESTPLATE.get() == pStack.getItem()) {
                consumer.accept(Component.translatable("tooltip.immersiveores.unbreakble.tooltip").withStyle(ChatFormatting.DARK_AQUA));
                consumer.accept(Component.translatable("tooltip.immersiveores.immunetofire.tooltip").withStyle(ChatFormatting.DARK_AQUA));
                if (EnderiumConfig.fireResistanceEnderiumArmor) {
                    consumer.accept(Component.translatable("tooltip.immersiveores.playerimmunetofire.tooltip").withStyle(ChatFormatting.DARK_AQUA));
                } if (EnderiumConfig.makesPiglinsNeutralEnderium) {
                    consumer.accept(Component.translatable("tooltip.immersiveores.immunetopiglin.tooltip").withStyle(ChatFormatting.DARK_AQUA));
                }
            }
            if (ModItems.ENDERIUM_LEGGINGS.get() == pStack.getItem()) {
                consumer.accept(Component.translatable("tooltip.immersiveores.unbreakble.tooltip").withStyle(ChatFormatting.DARK_AQUA));
                if (EnderiumConfig.fireResistanceEnderiumArmor) {
                    consumer.accept(Component.translatable("tooltip.immersiveores.immunetofire.tooltip").withStyle(ChatFormatting.DARK_AQUA));
                } if (EnderiumConfig.makesPiglinsNeutralEnderium) {
                    consumer.accept(Component.translatable("tooltip.immersiveores.immunetopiglin.tooltip").withStyle(ChatFormatting.DARK_AQUA));
                } if (EnderiumConfig.neverLoseHungerEnderiumArmor) {
                    consumer.accept(Component.translatable("tooltip.immersiveores.nerverlosehunger.tooltip").withStyle(ChatFormatting.DARK_AQUA));
                }
            }
            if (ModItems.ENDERIUM_HELMET.get() == pStack.getItem()) {
                consumer.accept(Component.translatable("tooltip.immersiveores.unbreakble.tooltip").withStyle(ChatFormatting.DARK_AQUA));
                consumer.accept(Component.translatable("tooltip.immersiveores.immunetofire.tooltip").withStyle(ChatFormatting.DARK_AQUA));
                if (EnderiumConfig.nightVisionEnderiumArmor) {
                    consumer.accept(Component.translatable("tooltip.immersiveores.nightvision.tooltip").withStyle(ChatFormatting.DARK_AQUA));
                } if (EnderiumConfig.makesPiglinsNeutralEnderium) {
                    consumer.accept(Component.translatable("tooltip.immersiveores.immunetopiglin.tooltip").withStyle(ChatFormatting.DARK_AQUA));
                } if (EnderiumConfig.endermanWillNotBeAngryWithYouEnderium) {
                    consumer.accept(Component.translatable("tooltip.immersiveores.endermanwillnotbeangrywithyou.tooltip").withStyle(ChatFormatting.DARK_AQUA));
                }
            }
        } else {
            consumer.accept(Component.translatable("tooltip.immersiveores.pressshiftformoreinfo.tooltip").withStyle(ChatFormatting.DARK_AQUA));
        }
    }

    @Override
    public boolean canWalkOnPowderedSnow(ItemStack stack, LivingEntity wearer) {
        return EnderiumConfig.canWalkOnPowderedSnowEnderium;
    }

    public boolean makesPiglinsNeutral(ItemStack stack, LivingEntity wearer) {
        return EnderiumConfig.makesPiglinsNeutralEnderium;
    }
}
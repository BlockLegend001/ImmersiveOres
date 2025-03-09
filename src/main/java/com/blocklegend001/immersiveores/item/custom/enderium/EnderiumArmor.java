package com.blocklegend001.immersiveores.item.custom.enderium;

import com.blocklegend001.immersiveores.config.EnderiumConfig;
import com.blocklegend001.immersiveores.item.ModItems;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.level.Level;

import java.util.List;

public class EnderiumArmor extends ArmorItem {

    public EnderiumArmor(ArmorMaterial p_371793_, ArmorType p_371848_, Properties p_40388_) {
        super(p_371793_, p_371848_, p_40388_);
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int pSlotId, boolean pIsSelected) {
        if (!level.isClientSide()) {
            if (entity instanceof Player player) {
                if (player.getItemBySlot(EquipmentSlot.FEET).getItem() == ModItems.ENDERIUM_BOOTS.get()) {
                    if (EnderiumConfig.speedIIIEnderiumArmor) {
                        player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 0, 2, false, false));
                    }
                    if (EnderiumConfig.jumpIIIEnderiumArmor) {
                        player.addEffect(new MobEffectInstance(MobEffects.JUMP, 0, 2, false, false));
                    }
                    if (EnderiumConfig.fireResistanceEnderiumArmor) {
                        player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 0, 1, false, false));
                    }
                    if (!player.onGround() && player.fallDistance >= 1.0F && EnderiumConfig.immuneToFallDamageEnderiumArmor) {
                        player.fallDistance = 0F;
                    }
                }
                if (player.getItemBySlot(EquipmentSlot.CHEST).getItem() == ModItems.ENDERIUM_CHESTPLATE.get()) {
                    if (EnderiumConfig.fireResistanceEnderiumArmor) {
                        player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 0, 0, false, false));
                    }
                }
                if (player.getItemBySlot(EquipmentSlot.HEAD).getItem() == ModItems.ENDERIUM_HELMET.get()) {
                    if (EnderiumConfig.nightVisionEnderiumArmor) {
                        player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0, false, false));
                    }
                    if (EnderiumConfig.fireResistanceEnderiumArmor) {
                        player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 0, 0, false, false));
                    }
                }
                if (player.getItemBySlot(EquipmentSlot.LEGS).getItem() == ModItems.ENDERIUM_LEGGINGS.get()) {
                    if (EnderiumConfig.neverLoseHungerEnderiumArmor) {
                        player.addEffect(new MobEffectInstance(MobEffects.SATURATION, 0, 99, false, false));
                    }
                    if (EnderiumConfig.fireResistanceEnderiumArmor) {
                        player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 0, 0, false, false));
                    }
                }
            }
        }
    }

    @Override
    public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> components, TooltipFlag pTooltipFlag) {
        if(Screen.hasShiftDown()) {
            if (ModItems.ENDERIUM_BOOTS.get() == pStack.getItem()) {
                components.add(Component.translatable("tooltip.immersiveores.unbreakble.tooltip").withStyle(ChatFormatting.DARK_AQUA));
                components.add(Component.translatable("tooltip.immersiveores.immunetofire.tooltip").withStyle(ChatFormatting.DARK_AQUA));
                if (EnderiumConfig.speedIIIEnderiumArmor) {
                    components.add(Component.translatable("tooltip.immersiveores.speed3.tooltip").withStyle(ChatFormatting.DARK_AQUA));
                } if (EnderiumConfig.jumpIIIEnderiumArmor) {
                    components.add(Component.translatable("tooltip.immersiveores.jump3.tooltip").withStyle(ChatFormatting.DARK_AQUA));
                } if (EnderiumConfig.canWalkOnPowderedSnowEnderium) {
                    components.add(Component.translatable("tooltip.immersiveores.canwalkonpowderedsnow.tooltip").withStyle(ChatFormatting.DARK_AQUA));
                } if (EnderiumConfig.fireResistanceEnderiumArmor) {
                    components.add(Component.translatable("tooltip.immersiveores.playerimmunetofire.tooltip").withStyle(ChatFormatting.DARK_AQUA));
                } if (EnderiumConfig.makesPiglinsNeutralEnderium) {
                    components.add(Component.translatable("tooltip.immersiveores.immunetopiglin.tooltip").withStyle(ChatFormatting.DARK_AQUA));
                } if (EnderiumConfig.immuneToFallDamageEnderiumArmor) {
                    components.add(Component.translatable("tooltip.immersiveores.immunetofalldamage.tooltip").withStyle(ChatFormatting.DARK_AQUA));
                } if (EnderiumConfig.canFlyEnderiumArmor) {
                    components.add(Component.translatable("tooltip.immersiveores.canfly.tooltip").withStyle(ChatFormatting.DARK_AQUA));
                }
            }
            if (ModItems.ENDERIUM_CHESTPLATE.get() == pStack.getItem()) {
                components.add(Component.translatable("tooltip.immersiveores.unbreakble.tooltip").withStyle(ChatFormatting.DARK_AQUA));
                components.add(Component.translatable("tooltip.immersiveores.immunetofire.tooltip").withStyle(ChatFormatting.DARK_AQUA));
                if (EnderiumConfig.fireResistanceEnderiumArmor) {
                    components.add(Component.translatable("tooltip.immersiveores.playerimmunetofire.tooltip").withStyle(ChatFormatting.DARK_AQUA));
                } if (EnderiumConfig.makesPiglinsNeutralEnderium) {
                    components.add(Component.translatable("tooltip.immersiveores.immunetopiglin.tooltip").withStyle(ChatFormatting.DARK_AQUA));
                }
            }
            if (ModItems.ENDERIUM_LEGGINGS.get() == pStack.getItem()) {
                components.add(Component.translatable("tooltip.immersiveores.unbreakble.tooltip").withStyle(ChatFormatting.DARK_AQUA));
                components.add(Component.translatable("tooltip.immersiveores.immunetofire.tooltip").withStyle(ChatFormatting.DARK_AQUA));
                if (EnderiumConfig.fireResistanceEnderiumArmor) {
                    components.add(Component.translatable("tooltip.immersiveores.immunetofire.tooltip").withStyle(ChatFormatting.DARK_AQUA));
                } if (EnderiumConfig.makesPiglinsNeutralEnderium) {
                    components.add(Component.translatable("tooltip.immersiveores.immunetopiglin.tooltip").withStyle(ChatFormatting.DARK_AQUA));
                } if (EnderiumConfig.neverLoseHungerEnderiumArmor) {
                    components.add(Component.translatable("tooltip.immersiveores.nerverlosehunger.tooltip").withStyle(ChatFormatting.DARK_AQUA));
                }
            }
            if (ModItems.ENDERIUM_HELMET.get() == pStack.getItem()) {
                components.add(Component.translatable("tooltip.immersiveores.unbreakble.tooltip").withStyle(ChatFormatting.DARK_AQUA));
                components.add(Component.translatable("tooltip.immersiveores.immunetofire.tooltip").withStyle(ChatFormatting.DARK_AQUA));
                if (EnderiumConfig.nightVisionEnderiumArmor) {
                    components.add(Component.translatable("tooltip.immersiveores.nightvision.tooltip").withStyle(ChatFormatting.DARK_AQUA));
                } if (EnderiumConfig.makesPiglinsNeutralEnderium) {
                    components.add(Component.translatable("tooltip.immersiveores.immunetopiglin.tooltip").withStyle(ChatFormatting.DARK_AQUA));
                } if (EnderiumConfig.endermanWillNotBeAngryWithYouEnderium) {
                    components.add(Component.translatable("tooltip.immersiveores.endermanwillnotbeangrywithyou.tooltip").withStyle(ChatFormatting.DARK_AQUA));
                }
            }
        } else {
            components.add(Component.translatable("tooltip.immersiveores.pressshiftformoreinfo.tooltip").withStyle(ChatFormatting.DARK_AQUA));
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

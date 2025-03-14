package com.blocklegend001.immersiveores.item.custom.vulpus;

import com.blocklegend001.immersiveores.config.VulpusConfig;
import com.blocklegend001.immersiveores.item.ModItems;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.List;

public class VulpusArmor extends ArmorItem {
    public VulpusArmor(Holder<ArmorMaterial> pMaterial, Type pType, Properties pProperties) {
        super(pMaterial, pType, pProperties);
    }
    @Override
    public boolean isEnchantable(ItemStack p_41456_) {
        return true;
    }

    @Override
    public void onInventoryTick(ItemStack stack, Level world, Player player, int slotIndex, int selectedIndex) {
        if (!world.isClientSide()){
            if (player.getItemBySlot(EquipmentSlot.FEET).getItem() == ModItems.VULPUS_BOOTS.get()) {
                if (VulpusConfig.speedIIVulpusArmor) {
                    player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 0, 1, false, false));
                } if (VulpusConfig.jumpIIVulpusArmor) {
                    player.addEffect(new MobEffectInstance(MobEffects.JUMP, 0, 1, false, false));
                } if (VulpusConfig.fireResistanceVulpusArmor) {
                    player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 0, 0, false, false));
                }
                if (!player.onGround() && player.fallDistance >= 1.0F && VulpusConfig.immuneToFallDamageVulpusArmor) {
                    player.fallDistance = 0F;
                }
            }
            if (player.getItemBySlot(EquipmentSlot.CHEST).getItem() == ModItems.VULPUS_CHESTPLATE.get()) {
                player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 0, 1, false, false));
            }
            if (player.getItemBySlot(EquipmentSlot.HEAD).getItem() == ModItems.VULPUS_HELMET.get()) {
                if (VulpusConfig.nightVisionVulpusArmor) {
                    player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0, false, false));
                } if (VulpusConfig.fireResistanceVulpusArmor) {
                    player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 0, 0, false, false));
                }
            }
            if (player.getItemBySlot(EquipmentSlot.LEGS).getItem() == ModItems.VULPUS_LEGGINGS.get()) {
                if (VulpusConfig.fireResistanceVulpusArmor) {
                    player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 0, 0, false, false));
                } if (VulpusConfig.neverLoseHungerVulpusArmor) {
                    player.addEffect(new MobEffectInstance(MobEffects.SATURATION, 0, 99, false, false));
                }
            }
        }
    }

    @Override
    public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> components, TooltipFlag pTooltipFlag) {
        if(Screen.hasShiftDown()){
            if (ModItems.VULPUS_BOOTS.get() == pStack.getItem()) {
                components.add(Component.translatable("tooltip.immersiveores.unbreakble.tooltip").withStyle(ChatFormatting.RED));
                components.add(Component.translatable("tooltip.immersiveores.immunetofire.tooltip").withStyle(ChatFormatting.RED));
                if (VulpusConfig.speedIIVulpusArmor) {
                    components.add(Component.translatable("tooltip.immersiveores.speed2.tooltip").withStyle(ChatFormatting.RED));
                } if (VulpusConfig.jumpIIVulpusArmor) {
                    components.add(Component.translatable("tooltip.immersiveores.jump2.tooltip").withStyle(ChatFormatting.RED));
                }
                if (VulpusConfig.canWalkOnPowderedSnowVulpus) {
                    components.add(Component.translatable("tooltip.immersiveores.canwalkonpowderedsnow.tooltip").withStyle(ChatFormatting.RED));
                } if (VulpusConfig.makesPiglinsNeutralVulpus) {
                    components.add(Component.translatable("tooltip.immersiveores.immunetopiglin.tooltip").withStyle(ChatFormatting.RED));
                } if (VulpusConfig.fireResistanceVulpusArmor) {
                    components.add(Component.translatable("tooltip.immersiveores.playerimmunetofire.tooltip").withStyle(ChatFormatting.RED));
                } if (VulpusConfig.immuneToFallDamageVulpusArmor) {
                    components.add(Component.translatable("tooltip.immersiveores.immunetofalldamage.tooltip").withStyle(ChatFormatting.RED));
                }
            }
            if (ModItems.VULPUS_CHESTPLATE.get() == pStack.getItem()) {
                components.add(Component.translatable("tooltip.immersiveores.unbreakble.tooltip").withStyle(ChatFormatting.RED));
                components.add(Component.translatable("tooltip.immersiveores.immunetofire.tooltip").withStyle(ChatFormatting.RED));
                if (VulpusConfig.makesPiglinsNeutralVulpus) {
                    components.add(Component.translatable("tooltip.immersiveores.immunetopiglin.tooltip").withStyle(ChatFormatting.RED));
                } if (VulpusConfig.fireResistanceVulpusArmor) {
                    components.add(Component.translatable("tooltip.immersiveores.playerimmunetofire.tooltip").withStyle(ChatFormatting.RED));
                }
            }
            if (ModItems.VULPUS_HELMET.get() == pStack.getItem()) {
                components.add(Component.translatable("tooltip.immersiveores.unbreakble.tooltip").withStyle(ChatFormatting.RED));
                components.add(Component.translatable("tooltip.immersiveores.immunetofire.tooltip").withStyle(ChatFormatting.RED));
                if (VulpusConfig.nightVisionVulpusArmor) {
                    components.add(Component.translatable("tooltip.immersiveores.nightvision.tooltip").withStyle(ChatFormatting.RED));
                } if (VulpusConfig.makesPiglinsNeutralVulpus) {
                    components.add(Component.translatable("tooltip.immersiveores.immunetopiglin.tooltip").withStyle(ChatFormatting.RED));
                } if (VulpusConfig.fireResistanceVulpusArmor) {
                    components.add(Component.translatable("tooltip.immersiveores.playerimmunetofire.tooltip").withStyle(ChatFormatting.RED));
                }
            }
            if (ModItems.VULPUS_LEGGINGS.get() == pStack.getItem()) {
                components.add(Component.translatable("tooltip.immersiveores.unbreakble.tooltip").withStyle(ChatFormatting.RED));
                components.add(Component.translatable("tooltip.immersiveores.immunetofire.tooltip").withStyle(ChatFormatting.RED));
                if (VulpusConfig.makesPiglinsNeutralVulpus) {
                    components.add(Component.translatable("tooltip.immersiveores.immunetopiglin.tooltip").withStyle(ChatFormatting.RED));
                } if (VulpusConfig.fireResistanceVulpusArmor) {
                    components.add(Component.translatable("tooltip.immersiveores.playerimmunetofire.tooltip").withStyle(ChatFormatting.RED));
                } if (VulpusConfig.neverLoseHungerVulpusArmor) {
                    components.add(Component.translatable("tooltip.immersiveores.nerverlosehunger.tooltip").withStyle(ChatFormatting.RED));
                }
            }
        } else {
            components.add(Component.translatable("tooltip.immersiveores.pressshiftformoreinfo.tooltip").withStyle(ChatFormatting.RED));
        }
    }

    public boolean makesPiglinsNeutral(ItemStack stack, LivingEntity wearer) {
        return VulpusConfig.canWalkOnPowderedSnowVulpus;
    }

    @Override
    public boolean canWalkOnPowderedSnow(ItemStack stack, LivingEntity wearer) {
        return VulpusConfig.makesPiglinsNeutralVulpus;
    }

}

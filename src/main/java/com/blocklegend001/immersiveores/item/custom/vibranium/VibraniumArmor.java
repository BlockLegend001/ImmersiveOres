package com.blocklegend001.immersiveores.item.custom.vibranium;

import com.blocklegend001.immersiveores.config.VibraniumConfig;
import com.blocklegend001.immersiveores.item.ModItems;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.level.Level;

import java.util.List;

public class VibraniumArmor extends ArmorItem {

    public VibraniumArmor(ArmorMaterial p_364741_, ArmorType p_365617_, Properties p_40388_) {
        super(p_364741_, p_365617_, p_40388_);
    }

    @Override
    public void onInventoryTick(ItemStack stack, Level world, Player player, int slotIndex, int selectedIndex) {
        if (!world.isClientSide()){
            if (player.getItemBySlot(EquipmentSlot.FEET).getItem() == ModItems.VIBRANIUM_BOOTS.get()) {
                if (VibraniumConfig.speedIVibraniumArmor) {
                    player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 0, 0, false, false));
                } if (VibraniumConfig.jumpIVibraniumArmor) {
                    player.addEffect(new MobEffectInstance(MobEffects.JUMP, 0, 0, false, false));
                }
            }
            if (player.getItemBySlot(EquipmentSlot.HEAD).getItem() == ModItems.VIBRANIUM_HELMET.get()) {
                if (VibraniumConfig.nightVisionVibraniumArmor) {
                    player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0, false, false));
                }
            }
        }
    }

    @Override
    public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> components, TooltipFlag pTooltipFlag) {
        if(Screen.hasShiftDown()) {
            if (ModItems.VIBRANIUM_BOOTS.get() == pStack.getItem()) {
                components.add(Component.translatable("tooltip.immersiveores.unbreakble.tooltip").withStyle(ChatFormatting.LIGHT_PURPLE));
                components.add(Component.translatable("tooltip.immersiveores.immunetofire.tooltip").withStyle(ChatFormatting.LIGHT_PURPLE));
                if (VibraniumConfig.speedIVibraniumArmor) {
                    components.add(Component.translatable("tooltip.immersiveores.speed1.tooltip").withStyle(ChatFormatting.LIGHT_PURPLE));
                } if (VibraniumConfig.jumpIVibraniumArmor) {
                    components.add(Component.translatable("tooltip.immersiveores.jump1.tooltip").withStyle(ChatFormatting.LIGHT_PURPLE));
                } if (VibraniumConfig.canWalkOnPowderedSnowVibranium) {
                    components.add(Component.translatable("tooltip.immersiveores.canwalkonpowderedsnow.tooltip").withStyle(ChatFormatting.LIGHT_PURPLE));
                }
            }
            if (ModItems.VIBRANIUM_CHESTPLATE.get() == pStack.getItem()) {
                components.add(Component.translatable("tooltip.immersiveores.unbreakble.tooltip").withStyle(ChatFormatting.LIGHT_PURPLE));
                components.add(Component.translatable("tooltip.immersiveores.immunetofire.tooltip").withStyle(ChatFormatting.LIGHT_PURPLE));
            }
            if (ModItems.VIBRANIUM_HELMET.get() == pStack.getItem()) {
                components.add(Component.translatable("tooltip.immersiveores.unbreakble.tooltip").withStyle(ChatFormatting.LIGHT_PURPLE));
                components.add(Component.translatable("tooltip.immersiveores.immunetofire.tooltip").withStyle(ChatFormatting.LIGHT_PURPLE));
                if (VibraniumConfig.nightVisionVibraniumArmor) {
                    components.add(Component.translatable("tooltip.immersiveores.nightvision.tooltip").withStyle(ChatFormatting.LIGHT_PURPLE));
                }
            }
            if (ModItems.VIBRANIUM_LEGGINGS.get() == pStack.getItem()) {
                components.add(Component.translatable("tooltip.immersiveores.unbreakble.tooltip").withStyle(ChatFormatting.LIGHT_PURPLE));
                components.add(Component.translatable("tooltip.immersiveores.immunetofire.tooltip").withStyle(ChatFormatting.LIGHT_PURPLE));
            }
        } else {
            components.add(Component.translatable("tooltip.immersiveores.pressshiftformoreinfo.tooltip").withStyle(ChatFormatting.LIGHT_PURPLE));
        }
    }

    @Override
    public boolean canWalkOnPowderedSnow(ItemStack stack, LivingEntity wearer) {
        return VibraniumConfig.canWalkOnPowderedSnowVibranium;
    }
}

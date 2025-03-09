package com.blocklegend001.immersiveores.item.custom.vibranium;

import com.blocklegend001.immersiveores.config.VibraniumConfig;
import com.blocklegend001.immersiveores.item.ModItems;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

import java.util.List;

public class VibraniumArmor extends ArmorItem {
    public VibraniumArmor(ArmorMaterial material, EquipmentType type, Settings settings) {
        super(material, type, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!world.isClient()){
            if(entity instanceof PlayerEntity player) {
                if (player.getInventory().getArmorStack(0).getItem() == ModItems.VIBRANIUM_BOOTS) {
                    if (VibraniumConfig.speedIVibraniumArmor) {
                        player.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 0, 0, false, false));
                    }
                    if (VibraniumConfig.jumpIVibraniumArmor) {
                        player.addStatusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 0, 0, false, false));
                    }
                }
                if (player.getInventory().getArmorStack(3).getItem() == ModItems.VIBRANIUM_HELMET) {
                    if (VibraniumConfig.nightVisionVibraniumArmor) {
                        player.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 400, 0, false, false));
                    }
                }
            }
        }
    }

    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType options) {
        if(Screen.hasShiftDown()) {
            if (ModItems.VIBRANIUM_BOOTS == stack.getItem()) {
                tooltip.add(Text.translatable("tooltip.immersiveores.unbreakble.tooltip").formatted(Formatting.LIGHT_PURPLE));
                tooltip.add(Text.translatable("tooltip.immersiveores.immunetofire.tooltip").formatted(Formatting.LIGHT_PURPLE));
                if (VibraniumConfig.speedIVibraniumArmor) {
                    tooltip.add(Text.translatable("tooltip.immersiveores.speed1.tooltip").formatted(Formatting.LIGHT_PURPLE));
                } if (VibraniumConfig.jumpIVibraniumArmor) {
                    tooltip.add(Text.translatable("tooltip.immersiveores.jump1.tooltip").formatted(Formatting.LIGHT_PURPLE));
                } if (VibraniumConfig.canWalkOnPowderedSnowVibranium) {
                    tooltip.add(Text.translatable("tooltip.immersiveores.canwalkonpowderedsnow.tooltip").formatted(Formatting.LIGHT_PURPLE));
                }
            }
            if (ModItems.VIBRANIUM_CHESTPLATE == stack.getItem()) {
                tooltip.add(Text.translatable("tooltip.immersiveores.unbreakble.tooltip").formatted(Formatting.LIGHT_PURPLE));
                tooltip.add(Text.translatable("tooltip.immersiveores.immunetofire.tooltip").formatted(Formatting.LIGHT_PURPLE));
            }
            if (ModItems.VIBRANIUM_HELMET == stack.getItem()) {
                tooltip.add(Text.translatable("tooltip.immersiveores.unbreakble.tooltip").formatted(Formatting.LIGHT_PURPLE));
                tooltip.add(Text.translatable("tooltip.immersiveores.immunetofire.tooltip").formatted(Formatting.LIGHT_PURPLE));
                if (VibraniumConfig.nightVisionVibraniumArmor) {
                    tooltip.add(Text.translatable("tooltip.immersiveores.nightvision.tooltip").formatted(Formatting.LIGHT_PURPLE));
                }
            }
            if (ModItems.VIBRANIUM_LEGGINGS == stack.getItem()) {
                tooltip.add(Text.translatable("tooltip.immersiveores.unbreakble.tooltip").formatted(Formatting.LIGHT_PURPLE));
                tooltip.add(Text.translatable("tooltip.immersiveores.immunetofire.tooltip").formatted(Formatting.LIGHT_PURPLE));
            }
        } else {
            tooltip.add(Text.translatable("tooltip.immersiveores.pressshiftformoreinfo.tooltip").formatted(Formatting.LIGHT_PURPLE));
        }
    }
}

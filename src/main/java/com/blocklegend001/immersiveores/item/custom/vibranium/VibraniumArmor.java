package com.blocklegend001.immersiveores.item.custom.vibranium;

import com.blocklegend001.immersiveores.config.VibraniumConfig;
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
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.Unbreakable;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.trim.ArmorTrim;
import net.minecraft.world.level.Level;

import java.util.List;

public class VibraniumArmor extends ArmorItem {
    private static Properties createSettings(Properties properties, boolean unbreakable, int durability) {
        properties.durability(durability);

        if (unbreakable) {
            properties.component(DataComponents.UNBREAKABLE, new Unbreakable(true));
        }
        return properties;
    }

    public VibraniumArmor(ArmorMaterial p_371793_, ArmorType p_371848_, Properties p_40388_) {
        super(p_371793_, p_371848_, createSettings(p_40388_, VibraniumConfig.UNBREAKABLE_VIBRANIUM.get(), VibraniumConfig.DURABILITY_VIBRANIUM.get()));
    }

    @Override
    public Component getName(ItemStack stack) {
        return super.getName(stack).copy().withStyle(ChatFormatting.LIGHT_PURPLE);
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int pSlotId, boolean pIsSelected) {
        if (!level.isClientSide()) {
            if (entity instanceof Player player) {
                if (player.getItemBySlot(EquipmentSlot.FEET).getItem() == ModItems.VIBRANIUM_BOOTS.get()) {
                    if (VibraniumConfig.SPEED_I_VIBRANIUM_ARMOR.get()) {
                        player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400, 0, false, false));
                    }
                    if (VibraniumConfig.JUMP_I_VIBRANIUM_ARMOR.get()) {
                        player.addEffect(new MobEffectInstance(MobEffects.JUMP, 400, 0, false, false));
                    }
                }
                if (player.getItemBySlot(EquipmentSlot.HEAD).getItem() == ModItems.VIBRANIUM_HELMET.get()) {
                    if (VibraniumConfig.NIGHT_VISION_VIBRANIUM_ARMOR.get()) {
                        player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0, false, false));
                    }
                }
            }
        }
    }

    @Override
    public void onCraftedBy(ItemStack stack, Level level, Player player) {
        super.onCraftedBy(stack, level, player);

        Item resultItem = stack.getItem();

        for (int i = 1; i <= 9; i++) {
            ItemStack ingredient = player.containerMenu.getSlot(i).getItem();
            Item ingredientItem = ingredient.getItem();

            if (resultItem == ModItems.VIBRANIUM_HELMET.get() && ingredientItem == Items.NETHERITE_HELMET
                    || resultItem == ModItems.VIBRANIUM_CHESTPLATE.get() && ingredientItem == Items.NETHERITE_CHESTPLATE
                    || resultItem == ModItems.VIBRANIUM_LEGGINGS.get() && ingredientItem == Items.NETHERITE_LEGGINGS
                    || resultItem == ModItems.VIBRANIUM_BOOTS.get() && ingredientItem == Items.NETHERITE_BOOTS) {

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
    public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> components, TooltipFlag pTooltipFlag) {
        if(Screen.hasShiftDown()) {
            if (ModItems.VIBRANIUM_BOOTS.get() == pStack.getItem()) {
                components.add(Component.translatable("tooltip.immersiveores.unbreakble.tooltip").withStyle(ChatFormatting.LIGHT_PURPLE));
                components.add(Component.translatable("tooltip.immersiveores.immunetofire.tooltip").withStyle(ChatFormatting.LIGHT_PURPLE));
                if (VibraniumConfig.SPEED_I_VIBRANIUM_ARMOR.get()) {
                    components.add(Component.translatable("tooltip.immersiveores.speed1.tooltip").withStyle(ChatFormatting.LIGHT_PURPLE));
                }
                if (VibraniumConfig.JUMP_I_VIBRANIUM_ARMOR.get()) {
                    components.add(Component.translatable("tooltip.immersiveores.jump1.tooltip").withStyle(ChatFormatting.LIGHT_PURPLE));
                }
                if (VibraniumConfig.CAN_WALK_ON_POWDERED_SNOW_VIBRANIUM.get()) {
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
                if (VibraniumConfig.NIGHT_VISION_VIBRANIUM_ARMOR.get()) {
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
        return VibraniumConfig.CAN_WALK_ON_POWDERED_SNOW_VIBRANIUM.get();
    }
}

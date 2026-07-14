package com.blocklegend001.immersiveores.item.custom.vibranium;

import com.blocklegend001.immersiveores.config.VibraniumConfig;
import com.blocklegend001.immersiveores.item.ModItems;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Unit;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.Equippable;
import net.minecraft.world.item.equipment.trim.ArmorTrim;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Consumer;

public class VibraniumArmor extends Item {

    public VibraniumArmor(ArmorMaterial material, ArmorType type, Properties settings) {
        super(computeSettings(material, type, VibraniumConfig.unbreakableVibranium.get(), VibraniumConfig.durabilityVibranium.get(), settings));
    }

    private static Properties computeSettings(ArmorMaterial material, ArmorType type, boolean unbreakable, int durability, Properties settings) {
        settings.humanoidArmor(material, ArmorType.BODY)
                .attributes(material.createAttributes(type))
                .enchantable(material.enchantmentValue())
                .component(DataComponents.EQUIPPABLE, Equippable.builder(type.getSlot()).setEquipSound(material.equipSound()).setAsset(material.assetId()).build())
                .durability(durability);

        if (unbreakable) {
            settings.component(DataComponents.UNBREAKABLE, Unit.INSTANCE);
        }
        return settings;
    }

    @Override
    public Component getName(ItemStack stack) {
        return super.getName(stack).copy().withStyle(ChatFormatting.LIGHT_PURPLE);
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, @Nullable EquipmentSlot slot, int slotIndex) {
        super.inventoryTick(stack, level, entity, slot, slotIndex);
        if (!level.isClientSide()) {
            if (entity instanceof Player player) {
                if (player.getItemBySlot(EquipmentSlot.FEET).getItem() == ModItems.VIBRANIUM_BOOTS.get()) {
                    if (VibraniumConfig.speedIVibraniumArmor.get()) {
                        player.addEffect(new MobEffectInstance(MobEffects.SPEED, 400, 0, false, false));
                    }
                    if (VibraniumConfig.jumpIVibraniumArmor.get()) {
                        player.addEffect(new MobEffectInstance(MobEffects.JUMP_BOOST, 400, 0, false, false));
                    }
                }
                if (player.getItemBySlot(EquipmentSlot.HEAD).getItem() == ModItems.VIBRANIUM_HELMET.get()) {
                    if (VibraniumConfig.nightVisionVibraniumArmor.get()) {
                        player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0, false, false));
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
    public void appendHoverText(ItemStack pStack, Item.TooltipContext p_333372_, TooltipDisplay p_396484_, Consumer<Component> consumer, TooltipFlag p_41424_) {
        super.appendHoverText(pStack, p_333372_, p_396484_, consumer, p_41424_);
        if(Screen.hasShiftDown()) {
            if (ModItems.VIBRANIUM_BOOTS.get() == pStack.getItem()) {
                if (VibraniumConfig.unbreakableVibranium.get()) {
                    consumer.accept(Component.translatable("tooltip.immersiveores.unbreakble.tooltip").withStyle(ChatFormatting.LIGHT_PURPLE));
                }
                consumer.accept(Component.translatable("tooltip.immersiveores.immunetofire.tooltip").withStyle(ChatFormatting.LIGHT_PURPLE));
                if (VibraniumConfig.speedIVibraniumArmor.get()) {
                    consumer.accept(Component.translatable("tooltip.immersiveores.speed1.tooltip").withStyle(ChatFormatting.LIGHT_PURPLE));
                } if (VibraniumConfig.jumpIVibraniumArmor.get()) {
                    consumer.accept(Component.translatable("tooltip.immersiveores.jump1.tooltip").withStyle(ChatFormatting.LIGHT_PURPLE));
                } if (VibraniumConfig.canWalkOnPowderedSnowVibranium.get()) {
                    consumer.accept(Component.translatable("tooltip.immersiveores.canwalkonpowderedsnow.tooltip").withStyle(ChatFormatting.LIGHT_PURPLE));
                }
            }
            if (ModItems.VIBRANIUM_CHESTPLATE.get() == pStack.getItem()) {
                if (VibraniumConfig.unbreakableVibranium.get()) {
                    consumer.accept(Component.translatable("tooltip.immersiveores.unbreakble.tooltip").withStyle(ChatFormatting.LIGHT_PURPLE));
                }
                consumer.accept(Component.translatable("tooltip.immersiveores.immunetofire.tooltip").withStyle(ChatFormatting.LIGHT_PURPLE));
            }
            if (ModItems.VIBRANIUM_HELMET.get() == pStack.getItem()) {
                if (VibraniumConfig.unbreakableVibranium.get()) {
                    consumer.accept(Component.translatable("tooltip.immersiveores.unbreakble.tooltip").withStyle(ChatFormatting.LIGHT_PURPLE));
                }
                consumer.accept(Component.translatable("tooltip.immersiveores.immunetofire.tooltip").withStyle(ChatFormatting.LIGHT_PURPLE));
                if (VibraniumConfig.nightVisionVibraniumArmor.get()) {
                    consumer.accept(Component.translatable("tooltip.immersiveores.nightvision.tooltip").withStyle(ChatFormatting.LIGHT_PURPLE));
                }
            }
            if (ModItems.VIBRANIUM_LEGGINGS.get() == pStack.getItem()) {
                if (VibraniumConfig.unbreakableVibranium.get()) {
                    consumer.accept(Component.translatable("tooltip.immersiveores.unbreakble.tooltip").withStyle(ChatFormatting.LIGHT_PURPLE));
                }
                consumer.accept(Component.translatable("tooltip.immersiveores.immunetofire.tooltip").withStyle(ChatFormatting.LIGHT_PURPLE));
            }
        } else {
            consumer.accept(Component.translatable("tooltip.immersiveores.pressshiftformoreinfo.tooltip").withStyle(ChatFormatting.LIGHT_PURPLE));
        }
    }

    @Override
    public boolean canWalkOnPowderedSnow(ItemStack stack, LivingEntity wearer) {
        return VibraniumConfig.canWalkOnPowderedSnowVibranium.get();
    }
}
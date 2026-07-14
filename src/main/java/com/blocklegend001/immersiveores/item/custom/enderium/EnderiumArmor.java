package com.blocklegend001.immersiveores.item.custom.enderium;

import com.blocklegend001.immersiveores.config.EnderiumConfig;
import com.blocklegend001.immersiveores.item.ModItems;
import com.blocklegend001.immersiveores.util.ScreenUtils;
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

public class EnderiumArmor extends Item {

    public EnderiumArmor(ArmorMaterial material, ArmorType type, Properties settings) {
        super(computeSettings(material, type, EnderiumConfig.unbreakableEnderium.get(), EnderiumConfig.durabilityEnderium.get(), settings));
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
        return super.getName(stack).copy().withStyle(ChatFormatting.DARK_AQUA);
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, @Nullable EquipmentSlot slot, int slotIndex) {
        super.inventoryTick(stack, level, entity, slot, slotIndex);
        if (!level.isClientSide()) {
            if (entity instanceof Player player) {
                if (player.getItemBySlot(EquipmentSlot.FEET).getItem() == ModItems.ENDERIUM_BOOTS.get()) {
                    if (EnderiumConfig.speedIIIEnderiumArmor.get()) {
                        player.addEffect(new MobEffectInstance(MobEffects.SPEED, 400, 2, false, false));
                    }
                    if (EnderiumConfig.jumpIIIEnderiumArmor.get()) {
                        player.addEffect(new MobEffectInstance(MobEffects.JUMP_BOOST, 400, 2, false, false));
                    }
                    if (EnderiumConfig.fireResistanceEnderiumArmor.get()) {
                        player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 400, 1, false, false));
                    }
                    if (!player.onGround() && player.fallDistance >= 1.0F && EnderiumConfig.immuneToFallDamageEnderiumArmor.get()) {
                        player.fallDistance = 0F;
                    }
                }
                if (player.getItemBySlot(EquipmentSlot.CHEST).getItem() == ModItems.ENDERIUM_CHESTPLATE.get()) {
                    if (EnderiumConfig.fireResistanceEnderiumArmor.get()) {
                        player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 400, 0, false, false));
                    }
                }
                if (player.getItemBySlot(EquipmentSlot.HEAD).getItem() == ModItems.ENDERIUM_HELMET.get()) {
                    if (EnderiumConfig.nightVisionEnderiumArmor.get()) {
                        player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0, false, false));
                    }
                    if (EnderiumConfig.fireResistanceEnderiumArmor.get()) {
                        player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 400, 0, false, false));
                    }
                }
                if (player.getItemBySlot(EquipmentSlot.LEGS).getItem() == ModItems.ENDERIUM_LEGGINGS.get()) {
                    if (EnderiumConfig.neverLoseHungerEnderiumArmor.get()) {
                        player.addEffect(new MobEffectInstance(MobEffects.SATURATION, 400, 99, false, false));
                    }
                    if (EnderiumConfig.fireResistanceEnderiumArmor.get()) {
                        player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 400, 0, false, false));
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

            if (resultItem == ModItems.ENDERIUM_HELMET.get() && ingredientItem == ModItems.VULPUS_HELMET.get()
                    || resultItem == ModItems.ENDERIUM_CHESTPLATE.get() && ingredientItem == ModItems.VULPUS_CHESTPLATE.get()
                    || resultItem == ModItems.ENDERIUM_LEGGINGS.get() && ingredientItem == ModItems.VULPUS_LEGGINGS.get()
                    || resultItem == ModItems.ENDERIUM_BOOTS.get() && ingredientItem == ModItems.VULPUS_BOOTS.get()) {

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
        if(ScreenUtils.isShiftDown()) {
            if (ModItems.ENDERIUM_BOOTS.get() == pStack.getItem()) {
                if (EnderiumConfig.unbreakableEnderium.get()) {
                    consumer.accept(Component.translatable("tooltip.immersiveores.unbreakble.tooltip").withStyle(ChatFormatting.DARK_AQUA));
                }
                consumer.accept(Component.translatable("tooltip.immersiveores.immunetofire.tooltip").withStyle(ChatFormatting.DARK_AQUA));
                if (EnderiumConfig.speedIIIEnderiumArmor.get()) {
                    consumer.accept(Component.translatable("tooltip.immersiveores.speed3.tooltip").withStyle(ChatFormatting.DARK_AQUA));
                } if (EnderiumConfig.jumpIIIEnderiumArmor.get()) {
                    consumer.accept(Component.translatable("tooltip.immersiveores.jump3.tooltip").withStyle(ChatFormatting.DARK_AQUA));
                } if (EnderiumConfig.canWalkOnPowderedSnowEnderium.get()) {
                    consumer.accept(Component.translatable("tooltip.immersiveores.canwalkonpowderedsnow.tooltip").withStyle(ChatFormatting.DARK_AQUA));
                } if (EnderiumConfig.fireResistanceEnderiumArmor.get()) {
                    consumer.accept(Component.translatable("tooltip.immersiveores.playerimmunetofire.tooltip").withStyle(ChatFormatting.DARK_AQUA));
                } if (EnderiumConfig.makesPiglinsNeutralEnderium.get()) {
                    consumer.accept(Component.translatable("tooltip.immersiveores.immunetopiglin.tooltip").withStyle(ChatFormatting.DARK_AQUA));
                } if (EnderiumConfig.immuneToFallDamageEnderiumArmor.get()) {
                    consumer.accept(Component.translatable("tooltip.immersiveores.immunetofalldamage.tooltip").withStyle(ChatFormatting.DARK_AQUA));
                } if (EnderiumConfig.canFlyEnderiumArmor.get()) {
                    consumer.accept(Component.translatable("tooltip.immersiveores.canfly.tooltip").withStyle(ChatFormatting.DARK_AQUA));
                }
            }
            if (ModItems.ENDERIUM_CHESTPLATE.get() == pStack.getItem()) {
                if (EnderiumConfig.unbreakableEnderium.get()) {
                    consumer.accept(Component.translatable("tooltip.immersiveores.unbreakble.tooltip").withStyle(ChatFormatting.DARK_AQUA));
                }
                consumer.accept(Component.translatable("tooltip.immersiveores.immunetofire.tooltip").withStyle(ChatFormatting.DARK_AQUA));
                if (EnderiumConfig.fireResistanceEnderiumArmor.get()) {
                    consumer.accept(Component.translatable("tooltip.immersiveores.playerimmunetofire.tooltip").withStyle(ChatFormatting.DARK_AQUA));
                } if (EnderiumConfig.makesPiglinsNeutralEnderium.get()) {
                    consumer.accept(Component.translatable("tooltip.immersiveores.immunetopiglin.tooltip").withStyle(ChatFormatting.DARK_AQUA));
                }
            }
            if (ModItems.ENDERIUM_LEGGINGS.get() == pStack.getItem()) {
                if (EnderiumConfig.unbreakableEnderium.get()) {
                    consumer.accept(Component.translatable("tooltip.immersiveores.unbreakble.tooltip").withStyle(ChatFormatting.DARK_AQUA));
                }
                consumer.accept(Component.translatable("tooltip.immersiveores.immunetofire.tooltip").withStyle(ChatFormatting.DARK_AQUA));
                if (EnderiumConfig.fireResistanceEnderiumArmor.get()) {
                    consumer.accept(Component.translatable("tooltip.immersiveores.playerimmunetofire.tooltip").withStyle(ChatFormatting.DARK_AQUA));
                } if (EnderiumConfig.makesPiglinsNeutralEnderium.get()) {
                    consumer.accept(Component.translatable("tooltip.immersiveores.immunetopiglin.tooltip").withStyle(ChatFormatting.DARK_AQUA));
                } if (EnderiumConfig.neverLoseHungerEnderiumArmor.get()) {
                    consumer.accept(Component.translatable("tooltip.immersiveores.nerverlosehunger.tooltip").withStyle(ChatFormatting.DARK_AQUA));
                }
            }
            if (ModItems.ENDERIUM_HELMET.get() == pStack.getItem()) {
                if (EnderiumConfig.unbreakableEnderium.get()) {
                    consumer.accept(Component.translatable("tooltip.immersiveores.unbreakble.tooltip").withStyle(ChatFormatting.DARK_AQUA));
                }
                consumer.accept(Component.translatable("tooltip.immersiveores.immunetofire.tooltip").withStyle(ChatFormatting.DARK_AQUA));
                if (EnderiumConfig.nightVisionEnderiumArmor.get()) {
                    consumer.accept(Component.translatable("tooltip.immersiveores.nightvision.tooltip").withStyle(ChatFormatting.DARK_AQUA));
                } if (EnderiumConfig.makesPiglinsNeutralEnderium.get()) {
                    consumer.accept(Component.translatable("tooltip.immersiveores.immunetopiglin.tooltip").withStyle(ChatFormatting.DARK_AQUA));
                } if (EnderiumConfig.endermanWillNotBeAngryWithYouEnderium.get()) {
                    consumer.accept(Component.translatable("tooltip.immersiveores.endermanwillnotbeangrywithyou.tooltip").withStyle(ChatFormatting.DARK_AQUA));
                }
            }
        } else {
            consumer.accept(Component.translatable("tooltip.immersiveores.pressshiftformoreinfo.tooltip").withStyle(ChatFormatting.DARK_AQUA));
        }
    }

    @Override
    public boolean canWalkOnPowderedSnow(ItemStack stack, LivingEntity wearer) {
        return EnderiumConfig.canWalkOnPowderedSnowEnderium.get();
    }

    public boolean makesPiglinsNeutral(ItemStack stack, LivingEntity wearer) {
        return EnderiumConfig.makesPiglinsNeutralEnderium.get();
    }
}
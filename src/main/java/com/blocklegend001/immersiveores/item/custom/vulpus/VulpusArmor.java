package com.blocklegend001.immersiveores.item.custom.vulpus;

import com.blocklegend001.immersiveores.config.VulpusConfig;
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
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.Equippable;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

public class VulpusArmor extends Item {

    public VulpusArmor(ArmorMaterial material, ArmorType type, Properties settings) {
        super(computeSettings(material, type, VulpusConfig.unbreakableVulpus.get(), VulpusConfig.durabilityVulpus.get(), settings));
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
        return super.getName(stack).copy().withStyle(ChatFormatting.RED);
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, @Nullable EquipmentSlot slot, int slotIndex) {
        super.inventoryTick(stack, level, entity, slot, slotIndex);
        if (!level.isClientSide()) {
            if (entity instanceof Player player) {
                if (player.getItemBySlot(EquipmentSlot.FEET).getItem() == ModItems.VULPUS_BOOTS.get()) {
                    if (VulpusConfig.speedIIVulpusArmor.get()) {
                        player.addEffect(new MobEffectInstance(MobEffects.SPEED, 400, 1, false, false));
                    }
                    if (VulpusConfig.jumpIIVulpusArmor.get()) {
                        player.addEffect(new MobEffectInstance(MobEffects.JUMP_BOOST, 400, 1, false, false));
                    }
                    if (VulpusConfig.fireResistanceVulpusArmor.get()) {
                        player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 400, 0, false, false));
                    }
                    if (!player.onGround() && player.fallDistance >= 1.0F && VulpusConfig.immuneToFallDamageVulpusArmor.get()) {
                        player.fallDistance = 0F;
                    }
                }
                if (player.getItemBySlot(EquipmentSlot.CHEST).getItem() == ModItems.VULPUS_CHESTPLATE.get()) {
                    if (VulpusConfig.fireResistanceVulpusArmor.get()) {
                        player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 400, 0, false, false));
                    }
                }
                if (player.getItemBySlot(EquipmentSlot.HEAD).getItem() == ModItems.VULPUS_HELMET.get()) {
                    if (VulpusConfig.nightVisionVulpusArmor.get()) {
                        player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0, false, false));
                    }
                    if (VulpusConfig.fireResistanceVulpusArmor.get()) {
                        player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 400, 0, false, false));
                    }
                }
                if (player.getItemBySlot(EquipmentSlot.LEGS).getItem() == ModItems.VULPUS_LEGGINGS.get()) {
                    if (VulpusConfig.fireResistanceVulpusArmor.get()) {
                        player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 400, 0, false, false));
                    }
                    if (VulpusConfig.neverLoseHungerVulpusArmor.get()) {
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

            if (resultItem == ModItems.VULPUS_HELMET.get() && ingredientItem == ModItems.VIBRANIUM_HELMET.get()
                    || resultItem == ModItems.VULPUS_CHESTPLATE.get() && ingredientItem == ModItems.VIBRANIUM_CHESTPLATE.get()
                    || resultItem == ModItems.VULPUS_LEGGINGS.get() && ingredientItem == ModItems.VIBRANIUM_LEGGINGS.get()
                    || resultItem == ModItems.VULPUS_BOOTS.get() && ingredientItem == ModItems.VIBRANIUM_BOOTS.get()) {

                var ench = ingredient.get(DataComponents.ENCHANTMENTS);
                if (ench != null) {
                    stack.set(DataComponents.ENCHANTMENTS, ench);
                }

                var customName = ingredient.get(DataComponents.CUSTOM_NAME);
                if (customName != null) {
                    stack.set(DataComponents.CUSTOM_NAME, customName);
                }

                break;
            }
        }
    }

    @Override
    public void appendHoverText(ItemStack pStack, Item.TooltipContext p_333372_, TooltipDisplay p_396484_, Consumer<Component> consumer, TooltipFlag p_41424_) {
        super.appendHoverText(pStack, p_333372_, p_396484_, consumer, p_41424_);
        if(Screen.hasShiftDown()){
            if (ModItems.VULPUS_BOOTS.get() == pStack.getItem()) {
                if (VulpusConfig.unbreakableVulpus.get()) {
                    consumer.accept(Component.translatable("tooltip.immersiveores.unbreakble.tooltip").withStyle(ChatFormatting.RED));
                }
                consumer.accept(Component.translatable("tooltip.immersiveores.immunetofire.tooltip").withStyle(ChatFormatting.RED));
                if (VulpusConfig.speedIIVulpusArmor.get()) {
                    consumer.accept(Component.translatable("tooltip.immersiveores.speed2.tooltip").withStyle(ChatFormatting.RED));
                } if (VulpusConfig.jumpIIVulpusArmor.get()) {
                    consumer.accept(Component.translatable("tooltip.immersiveores.jump2.tooltip").withStyle(ChatFormatting.RED));
                }
                if (VulpusConfig.canWalkOnPowderedSnowVulpus.get()) {
                    consumer.accept(Component.translatable("tooltip.immersiveores.canwalkonpowderedsnow.tooltip").withStyle(ChatFormatting.RED));
                } if (VulpusConfig.makesPiglinsNeutralVulpus.get()) {
                    consumer.accept(Component.translatable("tooltip.immersiveores.immunetopiglin.tooltip").withStyle(ChatFormatting.RED));
                } if (VulpusConfig.fireResistanceVulpusArmor.get()) {
                    consumer.accept(Component.translatable("tooltip.immersiveores.playerimmunetofire.tooltip").withStyle(ChatFormatting.RED));
                } if (VulpusConfig.immuneToFallDamageVulpusArmor.get()) {
                    consumer.accept(Component.translatable("tooltip.immersiveores.immunetofalldamage.tooltip").withStyle(ChatFormatting.RED));
                }
            }
            if (ModItems.VULPUS_CHESTPLATE.get() == pStack.getItem()) {
                if (VulpusConfig.unbreakableVulpus.get()) {
                    consumer.accept(Component.translatable("tooltip.immersiveores.unbreakble.tooltip").withStyle(ChatFormatting.RED));
                }
                consumer.accept(Component.translatable("tooltip.immersiveores.immunetofire.tooltip").withStyle(ChatFormatting.RED));
                if (VulpusConfig.makesPiglinsNeutralVulpus.get()) {
                    consumer.accept(Component.translatable("tooltip.immersiveores.immunetopiglin.tooltip").withStyle(ChatFormatting.RED));
                } if (VulpusConfig.fireResistanceVulpusArmor.get()) {
                    consumer.accept(Component.translatable("tooltip.immersiveores.playerimmunetofire.tooltip").withStyle(ChatFormatting.RED));
                }
            }
            if (ModItems.VULPUS_HELMET.get() == pStack.getItem()) {
                if (VulpusConfig.unbreakableVulpus.get()) {
                    consumer.accept(Component.translatable("tooltip.immersiveores.unbreakble.tooltip").withStyle(ChatFormatting.RED));
                }
                consumer.accept(Component.translatable("tooltip.immersiveores.immunetofire.tooltip").withStyle(ChatFormatting.RED));
                if (VulpusConfig.nightVisionVulpusArmor.get()) {
                    consumer.accept(Component.translatable("tooltip.immersiveores.nightvision.tooltip").withStyle(ChatFormatting.RED));
                } if (VulpusConfig.makesPiglinsNeutralVulpus.get()) {
                    consumer.accept(Component.translatable("tooltip.immersiveores.immunetopiglin.tooltip").withStyle(ChatFormatting.RED));
                } if (VulpusConfig.fireResistanceVulpusArmor.get()) {
                    consumer.accept(Component.translatable("tooltip.immersiveores.playerimmunetofire.tooltip").withStyle(ChatFormatting.RED));
                }
            }
            if (ModItems.VULPUS_LEGGINGS.get() == pStack.getItem()) {
                if (VulpusConfig.unbreakableVulpus.get()) {
                    consumer.accept(Component.translatable("tooltip.immersiveores.unbreakble.tooltip").withStyle(ChatFormatting.RED));
                }
                consumer.accept(Component.translatable("tooltip.immersiveores.immunetofire.tooltip").withStyle(ChatFormatting.RED));
                if (VulpusConfig.makesPiglinsNeutralVulpus.get()) {
                    consumer.accept(Component.translatable("tooltip.immersiveores.immunetopiglin.tooltip").withStyle(ChatFormatting.RED));
                } if (VulpusConfig.fireResistanceVulpusArmor.get()) {
                    consumer.accept(Component.translatable("tooltip.immersiveores.playerimmunetofire.tooltip").withStyle(ChatFormatting.RED));
                } if (VulpusConfig.neverLoseHungerVulpusArmor.get()) {
                    consumer.accept(Component.translatable("tooltip.immersiveores.nerverlosehunger.tooltip").withStyle(ChatFormatting.RED));
                }
            }
        } else {
            consumer.accept(Component.translatable("tooltip.immersiveores.pressshiftformoreinfo.tooltip").withStyle(ChatFormatting.RED));
        }
    }

    public boolean makesPiglinsNeutral(ItemStack stack, LivingEntity wearer) {
        return VulpusConfig.canWalkOnPowderedSnowVulpus.get();
    }

    @Override
    public boolean canWalkOnPowderedSnow(ItemStack stack, LivingEntity wearer) {
        return VulpusConfig.makesPiglinsNeutralVulpus.get();
    }

}
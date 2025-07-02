package com.blocklegend001.immersiveores.item.custom.vulpus;

import com.blocklegend001.immersiveores.config.VulpusConfig;
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
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.Unbreakable;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.level.Level;

import java.util.List;

public class VulpusArmor extends ArmorItem {
    private static Properties createSettings(Properties properties, boolean unbreakable, int durability) {
        properties.durability(durability);

        if (unbreakable) {
            properties.component(DataComponents.UNBREAKABLE, new Unbreakable(true));
        }
        return properties;
    }

    public VulpusArmor(ArmorMaterial p_371793_, ArmorType p_371848_, Properties p_40388_) {
        super(p_371793_, p_371848_, createSettings(p_40388_, VulpusConfig.UNBREAKABLE_VULPUS.get(), VulpusConfig.DURABILITY_VULPUS.get()));
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int pSlotId, boolean pIsSelected) {
        if (!level.isClientSide()) {
            if (entity instanceof Player player) {
                if (player.getItemBySlot(EquipmentSlot.FEET).getItem() == ModItems.VULPUS_BOOTS.get()) {
                    if (VulpusConfig.SPEED_II_VULPUS_ARMOR.get()) {
                        player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400, 1, false, false));
                    }
                    if (VulpusConfig.JUMP_II_VULPUS_ARMOR.get()) {
                        player.addEffect(new MobEffectInstance(MobEffects.JUMP, 400, 1, false, false));
                    }
                    if (VulpusConfig.FIRE_RESISTANCE_VULPUS_ARMOR.get()) {
                        player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 400, 0, false, false));
                    }
                    if (!player.onGround() && player.fallDistance >= 1.0F && VulpusConfig.IMMUNE_TO_FALL_DAMAGE_VULPUS_ARMOR.get()) {
                        player.fallDistance = 0F;
                    }
                }
                if (player.getItemBySlot(EquipmentSlot.CHEST).getItem() == ModItems.VULPUS_CHESTPLATE.get()) {
                    player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 400, 1, false, false));
                }
                if (player.getItemBySlot(EquipmentSlot.HEAD).getItem() == ModItems.VULPUS_HELMET.get()) {
                    if (VulpusConfig.NIGHT_VISION_VULPUS_ARMOR.get()) {
                        player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0, false, false));
                    }
                    if (VulpusConfig.FIRE_RESISTANCE_VULPUS_ARMOR.get()) {
                        player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 400, 0, false, false));
                    }
                }
                if (player.getItemBySlot(EquipmentSlot.LEGS).getItem() == ModItems.VULPUS_LEGGINGS.get()) {
                    if (VulpusConfig.FIRE_RESISTANCE_VULPUS_ARMOR.get()) {
                        player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 400, 0, false, false));
                    }
                    if (VulpusConfig.NEVER_LOSE_HUNGER_VULPUS_ARMOR.get()) {
                        player.addEffect(new MobEffectInstance(MobEffects.SATURATION, 400, 99, false, false));
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
    public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> components, TooltipFlag pTooltipFlag) {
        if(Screen.hasShiftDown()){
            if (ModItems.VULPUS_BOOTS.get() == pStack.getItem()) {
                components.add(Component.translatable("tooltip.immersiveores.unbreakble.tooltip").withStyle(ChatFormatting.RED));
                components.add(Component.translatable("tooltip.immersiveores.immunetofire.tooltip").withStyle(ChatFormatting.RED));
                if (VulpusConfig.SPEED_II_VULPUS_ARMOR.get()) {
                    components.add(Component.translatable("tooltip.immersiveores.speed2.tooltip").withStyle(ChatFormatting.RED));
                } if (VulpusConfig.JUMP_II_VULPUS_ARMOR.get()) {
                    components.add(Component.translatable("tooltip.immersiveores.jump2.tooltip").withStyle(ChatFormatting.RED));
                }
                if (VulpusConfig.CAN_WALK_ON_POWDERED_SNOW_VULPUS.get()) {
                    components.add(Component.translatable("tooltip.immersiveores.canwalkonpowderedsnow.tooltip").withStyle(ChatFormatting.RED));
                } if (VulpusConfig.MAKES_PIGLINS_NEUTRAL_VULPUS.get()) {
                    components.add(Component.translatable("tooltip.immersiveores.immunetopiglin.tooltip").withStyle(ChatFormatting.RED));
                } if (VulpusConfig.FIRE_RESISTANCE_VULPUS_ARMOR.get()) {
                    components.add(Component.translatable("tooltip.immersiveores.playerimmunetofire.tooltip").withStyle(ChatFormatting.RED));
                } if (VulpusConfig.IMMUNE_TO_FALL_DAMAGE_VULPUS_ARMOR.get()) {
                    components.add(Component.translatable("tooltip.immersiveores.immunetofalldamage.tooltip").withStyle(ChatFormatting.RED));
                }
            }
            if (ModItems.VULPUS_CHESTPLATE.get() == pStack.getItem()) {
                components.add(Component.translatable("tooltip.immersiveores.unbreakble.tooltip").withStyle(ChatFormatting.RED));
                components.add(Component.translatable("tooltip.immersiveores.immunetofire.tooltip").withStyle(ChatFormatting.RED));
                if (VulpusConfig.MAKES_PIGLINS_NEUTRAL_VULPUS.get()) {
                    components.add(Component.translatable("tooltip.immersiveores.immunetopiglin.tooltip").withStyle(ChatFormatting.RED));
                } if (VulpusConfig.FIRE_RESISTANCE_VULPUS_ARMOR.get()) {
                    components.add(Component.translatable("tooltip.immersiveores.playerimmunetofire.tooltip").withStyle(ChatFormatting.RED));
                }
            }
            if (ModItems.VULPUS_HELMET.get() == pStack.getItem()) {
                components.add(Component.translatable("tooltip.immersiveores.unbreakble.tooltip").withStyle(ChatFormatting.RED));
                components.add(Component.translatable("tooltip.immersiveores.immunetofire.tooltip").withStyle(ChatFormatting.RED));
                if (VulpusConfig.NIGHT_VISION_VULPUS_ARMOR.get()) {
                    components.add(Component.translatable("tooltip.immersiveores.nightvision.tooltip").withStyle(ChatFormatting.RED));
                } if (VulpusConfig.MAKES_PIGLINS_NEUTRAL_VULPUS.get()) {
                    components.add(Component.translatable("tooltip.immersiveores.immunetopiglin.tooltip").withStyle(ChatFormatting.RED));
                } if (VulpusConfig.FIRE_RESISTANCE_VULPUS_ARMOR.get()) {
                    components.add(Component.translatable("tooltip.immersiveores.playerimmunetofire.tooltip").withStyle(ChatFormatting.RED));
                }
            }
            if (ModItems.VULPUS_LEGGINGS.get() == pStack.getItem()) {
                components.add(Component.translatable("tooltip.immersiveores.unbreakble.tooltip").withStyle(ChatFormatting.RED));
                components.add(Component.translatable("tooltip.immersiveores.immunetofire.tooltip").withStyle(ChatFormatting.RED));
                if (VulpusConfig.MAKES_PIGLINS_NEUTRAL_VULPUS.get()) {
                    components.add(Component.translatable("tooltip.immersiveores.immunetopiglin.tooltip").withStyle(ChatFormatting.RED));
                } if (VulpusConfig.FIRE_RESISTANCE_VULPUS_ARMOR.get()) {
                    components.add(Component.translatable("tooltip.immersiveores.playerimmunetofire.tooltip").withStyle(ChatFormatting.RED));
                } if (VulpusConfig.NEVER_LOSE_HUNGER_VULPUS_ARMOR.get()) {
                    components.add(Component.translatable("tooltip.immersiveores.nerverlosehunger.tooltip").withStyle(ChatFormatting.RED));
                }
            }
        } else {
            components.add(Component.translatable("tooltip.immersiveores.pressshiftformoreinfo.tooltip").withStyle(ChatFormatting.RED));
        }
    }

    public boolean makesPiglinsNeutral(ItemStack stack, LivingEntity wearer) {
        return VulpusConfig.CAN_WALK_ON_POWDERED_SNOW_VULPUS.get();
    }

    @Override
    public boolean canWalkOnPowderedSnow(ItemStack stack, LivingEntity wearer) {
        return VulpusConfig.MAKES_PIGLINS_NEUTRAL_VULPUS.get();
    }

}

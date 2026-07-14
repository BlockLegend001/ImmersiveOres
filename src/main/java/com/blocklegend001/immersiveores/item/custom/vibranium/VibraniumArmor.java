package com.blocklegend001.immersiveores.item.custom.vibranium;

import com.blocklegend001.immersiveores.config.EnderiumConfig;
import com.blocklegend001.immersiveores.config.VibraniumConfig;
import com.blocklegend001.immersiveores.item.ModItems;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.armortrim.ArmorTrim;
import net.minecraft.world.item.component.Unbreakable;
import net.minecraft.world.level.Level;

import java.util.List;

public class VibraniumArmor extends ArmorItem {
    private static Properties createSettings(boolean unbreakable, int durability) {
        Properties settings = new Properties()
                .durability(durability);

        if (unbreakable) {
            settings.component(DataComponents.UNBREAKABLE, new Unbreakable(true));
        }
        return settings;
    }

    public VibraniumArmor(Holder<ArmorMaterial> pMaterial, Type pType, Properties pProperties) {
        super(pMaterial, pType, createSettings(VibraniumConfig.unbreakableVibranium.get(), VibraniumConfig.durabilityVibranium.get()));
    }

    @Override
    public Component getName(ItemStack stack) {
        return super.getName(stack).copy().withStyle(ChatFormatting.LIGHT_PURPLE);
    }

    @Override
    public boolean isEnchantable(ItemStack p_41456_) {
        return true;
    }

    @Override
    public void onInventoryTick(ItemStack stack, Level world, Player player, int slotIndex, int selectedIndex) {
        if (!world.isClientSide()){
            if (player.getItemBySlot(EquipmentSlot.FEET).getItem() == ModItems.VIBRANIUM_BOOTS.get()) {
                if (VibraniumConfig.speedIVibraniumArmor.get()) {
                    player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400, 0, false, false));
                } if (VibraniumConfig.jumpIVibraniumArmor.get()) {
                    player.addEffect(new MobEffectInstance(MobEffects.JUMP, 400, 0, false, false));
                }
            }
            if (player.getItemBySlot(EquipmentSlot.HEAD).getItem() == ModItems.VIBRANIUM_HELMET.get()) {
                if (VibraniumConfig.nightVisionVibraniumArmor.get()) {
                    player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0, false, false));
                }
            }
        }
    }

    @Override
    public void onCraftedBy(ItemStack stack, Level level, Player player) {
        super.onCraftedBy(stack, level, player);

        for (int i = 1; i <= 9; i++) {
            ItemStack ingredient = player.containerMenu.getSlot(i).getItem();

            if (ingredient.getItem() instanceof ArmorItem armorItem &&
                    armorItem.getMaterial() == ArmorMaterials.NETHERITE &&
                    armorItem.getType() == ((ArmorItem) stack.getItem()).getType()) {

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
                if (VibraniumConfig.unbreakableVibranium.get()) {
                    components.add(Component.translatable("tooltip.immersiveores.unbreakble.tooltip").withStyle(ChatFormatting.LIGHT_PURPLE));
                }
                components.add(Component.translatable("tooltip.immersiveores.immunetofire.tooltip").withStyle(ChatFormatting.LIGHT_PURPLE));
                if (VibraniumConfig.speedIVibraniumArmor.get()) {
                    components.add(Component.translatable("tooltip.immersiveores.speed1.tooltip").withStyle(ChatFormatting.LIGHT_PURPLE));
                } if (VibraniumConfig.jumpIVibraniumArmor.get()) {
                    components.add(Component.translatable("tooltip.immersiveores.jump1.tooltip").withStyle(ChatFormatting.LIGHT_PURPLE));
                } if (VibraniumConfig.canWalkOnPowderedSnowVibranium.get()) {
                    components.add(Component.translatable("tooltip.immersiveores.canwalkonpowderedsnow.tooltip").withStyle(ChatFormatting.LIGHT_PURPLE));
                }
            }
            if (ModItems.VIBRANIUM_CHESTPLATE.get() == pStack.getItem()) {
                if (VibraniumConfig.unbreakableVibranium.get()) {
                    components.add(Component.translatable("tooltip.immersiveores.unbreakble.tooltip").withStyle(ChatFormatting.LIGHT_PURPLE));
                }
                components.add(Component.translatable("tooltip.immersiveores.immunetofire.tooltip").withStyle(ChatFormatting.LIGHT_PURPLE));
            }
            if (ModItems.VIBRANIUM_HELMET.get() == pStack.getItem()) {
                if (VibraniumConfig.unbreakableVibranium.get()) {
                    components.add(Component.translatable("tooltip.immersiveores.unbreakble.tooltip").withStyle(ChatFormatting.LIGHT_PURPLE));
                }
                components.add(Component.translatable("tooltip.immersiveores.immunetofire.tooltip").withStyle(ChatFormatting.LIGHT_PURPLE));
                if (VibraniumConfig.nightVisionVibraniumArmor.get()) {
                    components.add(Component.translatable("tooltip.immersiveores.nightvision.tooltip").withStyle(ChatFormatting.LIGHT_PURPLE));
                }
            }
            if (ModItems.VIBRANIUM_LEGGINGS.get() == pStack.getItem()) {
                if (VibraniumConfig.unbreakableVibranium.get()) {
                    components.add(Component.translatable("tooltip.immersiveores.unbreakble.tooltip").withStyle(ChatFormatting.LIGHT_PURPLE));
                }
                components.add(Component.translatable("tooltip.immersiveores.immunetofire.tooltip").withStyle(ChatFormatting.LIGHT_PURPLE));
            }
        } else {
            components.add(Component.translatable("tooltip.immersiveores.pressshiftformoreinfo.tooltip").withStyle(ChatFormatting.LIGHT_PURPLE));
        }
    }

    @Override
    public boolean canWalkOnPowderedSnow(ItemStack stack, LivingEntity wearer) {
        return VibraniumConfig.canWalkOnPowderedSnowVibranium.get();
    }
}
package com.blocklegend001.immersiveores.item.custom.enderium;

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
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class EnderiumArmor extends ArmorItem {

    public EnderiumArmor(ArmorMaterial p_40386_, Type p_266831_, Properties p_40388_) {
        super(p_40386_, p_266831_, p_40388_);
    }

    @Override
    public boolean isEnchantable(ItemStack p_41456_) {
        return true;
    }

    @Override
    public void onArmorTick(ItemStack stack, Level world, Player player) {
        if (!world.isClientSide()) {
            if (player.getItemBySlot(EquipmentSlot.FEET).getItem() == ModItems.ENDERIUM_BOOTS.get()) {
                player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 0, 2, false, false));
                player.addEffect(new MobEffectInstance(MobEffects.JUMP, 0, 2, false, false));
                player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 0, 1, false, false));
                if (!player.onGround()) {
                    if (player.fallDistance >= 1.0F) {
                        player.fallDistance = 0F;
                    }
                }
            }
            if (player.getItemBySlot(EquipmentSlot.CHEST).getItem() == ModItems.ENDERIUM_CHESTPLATE.get()) {
                player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 0, 0, false, false));
            }
            if (player.getItemBySlot(EquipmentSlot.HEAD).getItem() == ModItems.ENDERIUM_HELMET.get()) {
                player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 200, 0, false, false));
                player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 0, 0, false, false));
            }
            if (player.getItemBySlot(EquipmentSlot.LEGS).getItem() == ModItems.ENDERIUM_LEGGINGS.get()) {
                player.addEffect(new MobEffectInstance(MobEffects.SATURATION, 0, 99, false, false));
                player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 0, 0, false, false));
            }
        }
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> components, TooltipFlag flag) {
        if(Screen.hasShiftDown()) {
            if (ModItems.ENDERIUM_BOOTS.get() == stack.getItem()) {
                components.add(Component.translatable("tooltip.immersiveores.unbreakble.tooltip").withStyle(ChatFormatting.DARK_AQUA));
                components.add(Component.translatable("tooltip.immersiveores.immunetofire.tooltip").withStyle(ChatFormatting.DARK_AQUA));
                components.add(Component.translatable("tooltip.immersiveores.speed3.tooltip").withStyle(ChatFormatting.DARK_AQUA));
                components.add(Component.translatable("tooltip.immersiveores.jump3.tooltip").withStyle(ChatFormatting.DARK_AQUA));
                components.add(Component.translatable("tooltip.immersiveores.canwalkonpowderedsnow.tooltip").withStyle(ChatFormatting.DARK_AQUA));
                components.add(Component.translatable("tooltip.immersiveores.playerimmunetofire.tooltip").withStyle(ChatFormatting.DARK_AQUA));
                components.add(Component.translatable("tooltip.immersiveores.immunetopiglin.tooltip").withStyle(ChatFormatting.DARK_AQUA));
                components.add(Component.translatable("tooltip.immersiveores.immunetofalldamage.tooltip").withStyle(ChatFormatting.DARK_AQUA));
                components.add(Component.translatable("tooltip.immersiveores.canfly.tooltip").withStyle(ChatFormatting.DARK_AQUA));
            }
            if (ModItems.ENDERIUM_CHESTPLATE.get() == stack.getItem()) {
                components.add(Component.translatable("tooltip.immersiveores.unbreakble.tooltip").withStyle(ChatFormatting.DARK_AQUA));
                components.add(Component.translatable("tooltip.immersiveores.immunetofire.tooltip").withStyle(ChatFormatting.DARK_AQUA));
                components.add(Component.translatable("tooltip.immersiveores.playerimmunetofire.tooltip").withStyle(ChatFormatting.DARK_AQUA));
                components.add(Component.translatable("tooltip.immersiveores.immunetopiglin.tooltip").withStyle(ChatFormatting.DARK_AQUA));
            }
            if (ModItems.ENDERIUM_LEGGINGS.get() == stack.getItem()) {
                components.add(Component.translatable("tooltip.immersiveores.unbreakble.tooltip").withStyle(ChatFormatting.DARK_AQUA));
                components.add(Component.translatable("tooltip.immersiveores.immunetofire.tooltip").withStyle(ChatFormatting.DARK_AQUA));
                components.add(Component.translatable("tooltip.immersiveores.immunetopiglin.tooltip").withStyle(ChatFormatting.DARK_AQUA));
                components.add(Component.translatable("tooltip.immersiveores.nerverlosehunger.tooltip").withStyle(ChatFormatting.DARK_AQUA));
            }
            if (ModItems.ENDERIUM_HELMET.get() == stack.getItem()) {
                components.add(Component.translatable("tooltip.immersiveores.unbreakble.tooltip").withStyle(ChatFormatting.DARK_AQUA));
                components.add(Component.translatable("tooltip.immersiveores.immunetofire.tooltip").withStyle(ChatFormatting.DARK_AQUA));
                components.add(Component.translatable("tooltip.immersiveores.nightvision.tooltip").withStyle(ChatFormatting.DARK_AQUA));
                components.add(Component.translatable("tooltip.immersiveores.immunetopiglin.tooltip").withStyle(ChatFormatting.DARK_AQUA));
                components.add(Component.translatable("tooltip.immersiveores.endermanwillnotbeangrywithyou.tooltip").withStyle(ChatFormatting.DARK_AQUA));
            }
        } else {
            components.add(Component.translatable("tooltip.immersiveores.pressshiftformoreinfo.tooltip").withStyle(ChatFormatting.DARK_AQUA));
        }
    }

    @Override
    public boolean canWalkOnPowderedSnow(ItemStack stack, LivingEntity wearer) {
        return true;
    }

    public boolean makesPiglinsNeutral(ItemStack stack, LivingEntity wearer) {
        return true;
    }
}

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
import net.minecraft.world.item.*;
import net.minecraft.world.item.armortrim.ArmorTrim;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;

public class VibraniumArmor extends ArmorItem {
    private static Properties createSettings() {
        return new Properties()
                .fireResistant();
    }

    public VibraniumArmor(ArmorMaterial material, Type type, Properties settings) {
        super(material, type, createSettings());
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

                Map<Enchantment, Integer> ench = EnchantmentHelper.getEnchantments(ingredient);
                if (!ench.isEmpty()) {
                    EnchantmentHelper.setEnchantments(ench, stack);
                }

                if (ingredient.hasCustomHoverName()) {
                    stack.setHoverName(ingredient.getHoverName());
                }

                ArmorTrim.getTrim(level.registryAccess(), ingredient)
                        .ifPresent(trim -> ArmorTrim.setTrim(level.registryAccess(), stack, trim));

                break;
            }
        }
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pContext, List<Component> components, TooltipFlag pTooltipFlag) {
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

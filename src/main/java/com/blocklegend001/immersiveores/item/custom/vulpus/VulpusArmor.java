package com.blocklegend001.immersiveores.item.custom.vulpus;

import com.blocklegend001.immersiveores.config.VulpusConfig;
import com.blocklegend001.immersiveores.item.ModArmorMaterials;
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
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;

public class VulpusArmor extends ArmorItem {
    private static Properties createSettings() {
        return new Properties()
                .fireResistant();
    }

    public VulpusArmor(ArmorMaterial material, Type type, Properties settings) {
        super(material, type, createSettings());
    }

    @Override
    public Component getName(ItemStack stack) {
        return super.getName(stack).copy().withStyle(ChatFormatting.RED);
    }

    @Override
    public boolean isEnchantable(ItemStack p_41456_) {
        return true;
    }

    @Override
    public void onInventoryTick(ItemStack stack, Level world, Player player, int slotIndex, int selectedIndex) {
        if (!world.isClientSide()){
            if (player.getItemBySlot(EquipmentSlot.FEET).getItem() == ModItems.VULPUS_BOOTS.get()) {
                if (VulpusConfig.speedIIVulpusArmor.get()) {
                    player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400, 1, false, false));
                } if (VulpusConfig.jumpIIVulpusArmor.get()) {
                    player.addEffect(new MobEffectInstance(MobEffects.JUMP, 400, 1, false, false));
                } if (VulpusConfig.fireResistanceVulpusArmor.get()) {
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
                } if (VulpusConfig.fireResistanceVulpusArmor.get()) {
                    player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 400, 0, false, false));
                }
            }
            if (player.getItemBySlot(EquipmentSlot.LEGS).getItem() == ModItems.VULPUS_LEGGINGS.get()) {
                if (VulpusConfig.fireResistanceVulpusArmor.get()) {
                    player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 400, 0, false, false));
                } if (VulpusConfig.neverLoseHungerVulpusArmor.get()) {
                    player.addEffect(new MobEffectInstance(MobEffects.SATURATION, 400, 99, false, false));
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
                    armorItem.getMaterial() == ModArmorMaterials.VIBRANIUM &&
                    armorItem.getType() == ((ArmorItem) stack.getItem()).getType()) {

                Map<Enchantment, Integer> ench = EnchantmentHelper.getEnchantments(ingredient);
                if (!ench.isEmpty()) {
                    EnchantmentHelper.setEnchantments(ench, stack);
                }

                if (ingredient.hasCustomHoverName()) {
                    stack.setHoverName(ingredient.getHoverName());
                }

                break;
            }
        }
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pContext, List<Component> components, TooltipFlag pTooltipFlag) {
        if(Screen.hasShiftDown()){
            if (ModItems.VULPUS_BOOTS.get() == pStack.getItem()) {
                if (VulpusConfig.unbreakableVulpus.get()) {
                    components.add(Component.translatable("tooltip.immersiveores.unbreakble.tooltip").withStyle(ChatFormatting.RED));
                }
                components.add(Component.translatable("tooltip.immersiveores.immunetofire.tooltip").withStyle(ChatFormatting.RED));
                if (VulpusConfig.speedIIVulpusArmor.get()) {
                    components.add(Component.translatable("tooltip.immersiveores.speed2.tooltip").withStyle(ChatFormatting.RED));
                } if (VulpusConfig.jumpIIVulpusArmor.get()) {
                    components.add(Component.translatable("tooltip.immersiveores.jump2.tooltip").withStyle(ChatFormatting.RED));
                }
                if (VulpusConfig.canWalkOnPowderedSnowVulpus.get()) {
                    components.add(Component.translatable("tooltip.immersiveores.canwalkonpowderedsnow.tooltip").withStyle(ChatFormatting.RED));
                } if (VulpusConfig.makesPiglinsNeutralVulpus.get()) {
                    components.add(Component.translatable("tooltip.immersiveores.immunetopiglin.tooltip").withStyle(ChatFormatting.RED));
                } if (VulpusConfig.fireResistanceVulpusArmor.get()) {
                    components.add(Component.translatable("tooltip.immersiveores.playerimmunetofire.tooltip").withStyle(ChatFormatting.RED));
                } if (VulpusConfig.immuneToFallDamageVulpusArmor.get()) {
                    components.add(Component.translatable("tooltip.immersiveores.immunetofalldamage.tooltip").withStyle(ChatFormatting.RED));
                }
            }
            if (ModItems.VULPUS_CHESTPLATE.get() == pStack.getItem()) {
                if (VulpusConfig.unbreakableVulpus.get()) {
                    components.add(Component.translatable("tooltip.immersiveores.unbreakble.tooltip").withStyle(ChatFormatting.RED));
                }
                components.add(Component.translatable("tooltip.immersiveores.immunetofire.tooltip").withStyle(ChatFormatting.RED));
                if (VulpusConfig.makesPiglinsNeutralVulpus.get()) {
                    components.add(Component.translatable("tooltip.immersiveores.immunetopiglin.tooltip").withStyle(ChatFormatting.RED));
                } if (VulpusConfig.fireResistanceVulpusArmor.get()) {
                    components.add(Component.translatable("tooltip.immersiveores.playerimmunetofire.tooltip").withStyle(ChatFormatting.RED));
                }
            }
            if (ModItems.VULPUS_HELMET.get() == pStack.getItem()) {
                if (VulpusConfig.unbreakableVulpus.get()) {
                    components.add(Component.translatable("tooltip.immersiveores.unbreakble.tooltip").withStyle(ChatFormatting.RED));
                }
                components.add(Component.translatable("tooltip.immersiveores.immunetofire.tooltip").withStyle(ChatFormatting.RED));
                if (VulpusConfig.nightVisionVulpusArmor.get()) {
                    components.add(Component.translatable("tooltip.immersiveores.nightvision.tooltip").withStyle(ChatFormatting.RED));
                } if (VulpusConfig.makesPiglinsNeutralVulpus.get()) {
                    components.add(Component.translatable("tooltip.immersiveores.immunetopiglin.tooltip").withStyle(ChatFormatting.RED));
                } if (VulpusConfig.fireResistanceVulpusArmor.get()) {
                    components.add(Component.translatable("tooltip.immersiveores.playerimmunetofire.tooltip").withStyle(ChatFormatting.RED));
                }
            }
            if (ModItems.VULPUS_LEGGINGS.get() == pStack.getItem()) {
                if (VulpusConfig.unbreakableVulpus.get()) {
                    components.add(Component.translatable("tooltip.immersiveores.unbreakble.tooltip").withStyle(ChatFormatting.RED));
                }
                components.add(Component.translatable("tooltip.immersiveores.immunetofire.tooltip").withStyle(ChatFormatting.RED));
                if (VulpusConfig.makesPiglinsNeutralVulpus.get()) {
                    components.add(Component.translatable("tooltip.immersiveores.immunetopiglin.tooltip").withStyle(ChatFormatting.RED));
                } if (VulpusConfig.fireResistanceVulpusArmor.get()) {
                    components.add(Component.translatable("tooltip.immersiveores.playerimmunetofire.tooltip").withStyle(ChatFormatting.RED));
                } if (VulpusConfig.neverLoseHungerVulpusArmor.get()) {
                    components.add(Component.translatable("tooltip.immersiveores.nerverlosehunger.tooltip").withStyle(ChatFormatting.RED));
                }
            }
        } else {
            components.add(Component.translatable("tooltip.immersiveores.pressshiftformoreinfo.tooltip").withStyle(ChatFormatting.RED));
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

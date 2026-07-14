package com.blocklegend001.immersiveores.item.custom.enderium;

import com.blocklegend001.immersiveores.config.EnderiumConfig;
import com.blocklegend001.immersiveores.item.ModArmorMaterials;
import com.blocklegend001.immersiveores.item.ModItems;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.armortrim.ArmorTrim;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;

public class EnderiumArmor extends ArmorItem {
    private static Properties createSettings() {
        return new Properties()
                .fireResistant();
    }

    public EnderiumArmor(ArmorMaterial material, Type type, Properties settings) {
        super(material, type, createSettings());
    }

    @Override
    public Component getName(ItemStack stack) {
        return super.getName(stack).copy().withStyle(ChatFormatting.DARK_AQUA);
    }

    @Override
    public boolean isEnchantable(ItemStack p_41456_) {
        return true;
    }

    @Override
    public void onInventoryTick(ItemStack stack, Level world, Player player, int slotIndex, int selectedIndex) {
        if (!world.isClientSide()) {
            if (player.getItemBySlot(EquipmentSlot.FEET).getItem() == ModItems.ENDERIUM_BOOTS.get()) {
                if (EnderiumConfig.speedIIIEnderiumArmor.get()) {
                    player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400, 2, false, false));
                } if (EnderiumConfig.jumpIIIEnderiumArmor.get()) {
                    player.addEffect(new MobEffectInstance(MobEffects.JUMP, 400, 2, false, false));
                } if (EnderiumConfig.fireResistanceEnderiumArmor.get()) {
                    player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 400, 1, false, false));
                } if (!player.onGround() && player.fallDistance >= 1.0F && EnderiumConfig.immuneToFallDamageEnderiumArmor.get()) {
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
                } if (EnderiumConfig.fireResistanceEnderiumArmor.get()) {
                    player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 400, 0, false, false));
                }
            }
            if (player.getItemBySlot(EquipmentSlot.LEGS).getItem() == ModItems.ENDERIUM_LEGGINGS.get()) {
                if (EnderiumConfig.neverLoseHungerEnderiumArmor.get()) {
                    player.addEffect(new MobEffectInstance(MobEffects.SATURATION, 400, 99, false, false));
                } if (EnderiumConfig.fireResistanceEnderiumArmor.get()) {
                    player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 400, 0, false, false));
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
                    armorItem.getMaterial() == ModArmorMaterials.VULPUS &&
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
            if (ModItems.ENDERIUM_BOOTS.get() == pStack.getItem()) {
                if (EnderiumConfig.unbreakableEnderium.get()) {
                    components.add(Component.translatable("tooltip.immersiveores.unbreakble.tooltip").withStyle(ChatFormatting.DARK_AQUA));
                }
                components.add(Component.translatable("tooltip.immersiveores.immunetofire.tooltip").withStyle(ChatFormatting.DARK_AQUA));
                if (EnderiumConfig.speedIIIEnderiumArmor.get()) {
                    components.add(Component.translatable("tooltip.immersiveores.speed3.tooltip").withStyle(ChatFormatting.DARK_AQUA));
                } if (EnderiumConfig.jumpIIIEnderiumArmor.get()) {
                    components.add(Component.translatable("tooltip.immersiveores.jump3.tooltip").withStyle(ChatFormatting.DARK_AQUA));
                } if (EnderiumConfig.canWalkOnPowderedSnowEnderium.get()) {
                    components.add(Component.translatable("tooltip.immersiveores.canwalkonpowderedsnow.tooltip").withStyle(ChatFormatting.DARK_AQUA));
                } if (EnderiumConfig.fireResistanceEnderiumArmor.get()) {
                    components.add(Component.translatable("tooltip.immersiveores.playerimmunetofire.tooltip").withStyle(ChatFormatting.DARK_AQUA));
                } if (EnderiumConfig.makesPiglinsNeutralEnderium.get()) {
                    components.add(Component.translatable("tooltip.immersiveores.immunetopiglin.tooltip").withStyle(ChatFormatting.DARK_AQUA));
                } if (EnderiumConfig.immuneToFallDamageEnderiumArmor.get()) {
                    components.add(Component.translatable("tooltip.immersiveores.immunetofalldamage.tooltip").withStyle(ChatFormatting.DARK_AQUA));
                } if (EnderiumConfig.canFlyEnderiumArmor.get()) {
                    components.add(Component.translatable("tooltip.immersiveores.canfly.tooltip").withStyle(ChatFormatting.DARK_AQUA));
                }
            }
            if (ModItems.ENDERIUM_CHESTPLATE.get() == pStack.getItem()) {
                if (EnderiumConfig.unbreakableEnderium.get()) {
                    components.add(Component.translatable("tooltip.immersiveores.unbreakble.tooltip").withStyle(ChatFormatting.DARK_AQUA));
                }
                components.add(Component.translatable("tooltip.immersiveores.immunetofire.tooltip").withStyle(ChatFormatting.DARK_AQUA));
                if (EnderiumConfig.fireResistanceEnderiumArmor.get()) {
                    components.add(Component.translatable("tooltip.immersiveores.playerimmunetofire.tooltip").withStyle(ChatFormatting.DARK_AQUA));
                } if (EnderiumConfig.makesPiglinsNeutralEnderium.get()) {
                    components.add(Component.translatable("tooltip.immersiveores.immunetopiglin.tooltip").withStyle(ChatFormatting.DARK_AQUA));
                }
            }
            if (ModItems.ENDERIUM_LEGGINGS.get() == pStack.getItem()) {
                if (EnderiumConfig.unbreakableEnderium.get()) {
                    components.add(Component.translatable("tooltip.immersiveores.unbreakble.tooltip").withStyle(ChatFormatting.DARK_AQUA));
                }
                components.add(Component.translatable("tooltip.immersiveores.immunetofire.tooltip").withStyle(ChatFormatting.DARK_AQUA));
                if (EnderiumConfig.fireResistanceEnderiumArmor.get()) {
                    components.add(Component.translatable("tooltip.immersiveores.playerimmunetofire.tooltip").withStyle(ChatFormatting.DARK_AQUA));
                } if (EnderiumConfig.makesPiglinsNeutralEnderium.get()) {
                    components.add(Component.translatable("tooltip.immersiveores.immunetopiglin.tooltip").withStyle(ChatFormatting.DARK_AQUA));
                } if (EnderiumConfig.neverLoseHungerEnderiumArmor.get()) {
                    components.add(Component.translatable("tooltip.immersiveores.nerverlosehunger.tooltip").withStyle(ChatFormatting.DARK_AQUA));
                }
            }
            if (ModItems.ENDERIUM_HELMET.get() == pStack.getItem()) {
                if (EnderiumConfig.unbreakableEnderium.get()) {
                    components.add(Component.translatable("tooltip.immersiveores.unbreakble.tooltip").withStyle(ChatFormatting.DARK_AQUA));
                }
                components.add(Component.translatable("tooltip.immersiveores.immunetofire.tooltip").withStyle(ChatFormatting.DARK_AQUA));
                if (EnderiumConfig.nightVisionEnderiumArmor.get()) {
                    components.add(Component.translatable("tooltip.immersiveores.nightvision.tooltip").withStyle(ChatFormatting.DARK_AQUA));
                } if (EnderiumConfig.makesPiglinsNeutralEnderium.get()) {
                    components.add(Component.translatable("tooltip.immersiveores.immunetopiglin.tooltip").withStyle(ChatFormatting.DARK_AQUA));
                } if (EnderiumConfig.endermanWillNotBeAngryWithYouEnderium.get()) {
                    components.add(Component.translatable("tooltip.immersiveores.endermanwillnotbeangrywithyou.tooltip").withStyle(ChatFormatting.DARK_AQUA));
                } if (EnderiumConfig.fireResistanceEnderiumArmor.get()) {
                    components.add(Component.translatable("tooltip.immersiveores.playerimmunetofire.tooltip").withStyle(ChatFormatting.DARK_AQUA));
                }
            }
        } else {
            components.add(Component.translatable("tooltip.immersiveores.pressshiftformoreinfo.tooltip").withStyle(ChatFormatting.DARK_AQUA));
        }
    }

    @Override
    public boolean canWalkOnPowderedSnow(ItemStack stack, LivingEntity wearer) {
        return EnderiumConfig.canWalkOnPowderedSnowEnderium.get();
    }

    @Override
    public boolean isEnderMask(ItemStack stack, Player player, EnderMan endermanEntity) {
        return EnderiumConfig.endermanWillNotBeAngryWithYouEnderium.get();
    }

    public boolean makesPiglinsNeutral(ItemStack stack, LivingEntity wearer) {
        return EnderiumConfig.makesPiglinsNeutralEnderium.get();
    }
}

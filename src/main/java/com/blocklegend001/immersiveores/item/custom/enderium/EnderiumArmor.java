package com.blocklegend001.immersiveores.item.custom.enderium;

import com.blocklegend001.immersiveores.config.EnderiumConfig;
import com.blocklegend001.immersiveores.item.ModArmorMaterials;
import com.blocklegend001.immersiveores.item.ModItems;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.UnbreakableComponent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

import java.util.List;

public class EnderiumArmor extends ArmorItem {
    private static Settings createSettings(Settings base, boolean unbreakable, int durability) {
        base.maxDamage(durability).fireproof();
        if (unbreakable) {
            base.component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true));
        }
        return base;
    }

    public EnderiumArmor(ArmorMaterial material, EquipmentType type, Settings settings) {
        super(material, type, createSettings(settings, EnderiumConfig.unbreakableEnderium, EnderiumConfig.durabilityEnderium));
    }

    @Override
    public Text getName(ItemStack stack) {
        return super.getName(stack).copy().formatted(Formatting.DARK_AQUA);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!world.isClient()) {
            if (entity instanceof PlayerEntity player) {
                if (player.getInventory().getArmorStack(0).getItem() == ModItems.ENDERIUM_BOOTS) {
                    if (EnderiumConfig.speedIIIEnderiumArmor) {
                        player.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 400, 2, false, false));
                    }
                    if (EnderiumConfig.jumpIIIEnderiumArmor) {
                        player.addStatusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 400, 2, false, false));
                    }
                    if (EnderiumConfig.fireResistanceEnderiumArmor) {
                        player.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 400, 1, false, false));
                    }
                    if (!player.isOnGround() && player.fallDistance >= 1.0F && EnderiumConfig.immuneToFallDamageEnderiumArmor) {
                        player.fallDistance = 0F;
                    }
                }
                if (player.getInventory().getArmorStack(2).getItem() == ModItems.ENDERIUM_CHESTPLATE) {
                    if (EnderiumConfig.fireResistanceEnderiumArmor) {
                        player.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 400, 0, false, false));
                    }
                }
                if (player.getInventory().getArmorStack(3).getItem() == ModItems.ENDERIUM_HELMET) {
                    if (EnderiumConfig.nightVisionEnderiumArmor) {
                        player.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 400, 0, false, false));
                    }
                    if (EnderiumConfig.fireResistanceEnderiumArmor) {
                        player.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 400, 0, false, false));
                    }
                }
                if (player.getInventory().getArmorStack(1).getItem() == ModItems.ENDERIUM_LEGGINGS) {
                    if (EnderiumConfig.neverLoseHungerEnderiumArmor) {
                        player.addStatusEffect(new StatusEffectInstance(StatusEffects.SATURATION, 400, 99, false, false));
                    }
                    if (EnderiumConfig.fireResistanceEnderiumArmor) {
                        player.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 400, 0, false, false));
                    }
                }
            }
        }
    }

    @Override
    public void onCraftByPlayer(ItemStack stack, World world, PlayerEntity player) {
        super.onCraftByPlayer(stack, world, player);

        Item resultItem = stack.getItem();

        for (int i = 1; i <= 9; i++) {
            ItemStack ingredient = player.currentScreenHandler.getSlot(i).getStack();
            Item ingredientItem = ingredient.getItem();

            if (resultItem == ModItems.ENDERIUM_HELMET && ingredientItem == ModItems.VULPUS_HELMET
                    || resultItem == ModItems.ENDERIUM_CHESTPLATE && ingredientItem == ModItems.VULPUS_CHESTPLATE
                    || resultItem == ModItems.ENDERIUM_LEGGINGS && ingredientItem == ModItems.VULPUS_LEGGINGS
                    || resultItem == ModItems.ENDERIUM_BOOTS && ingredientItem == ModItems.VULPUS_BOOTS) {

                var ench = ingredient.get(DataComponentTypes.ENCHANTMENTS);
                if (ench != null) {
                    stack.set(DataComponentTypes.ENCHANTMENTS, ench);
                }

                var customName = ingredient.get(DataComponentTypes.CUSTOM_NAME);
                if (customName != null) {
                    stack.set(DataComponentTypes.CUSTOM_NAME, customName);
                }

                break;
            }
        }
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType options) {
        if(Screen.hasShiftDown()) {
            if (ModItems.ENDERIUM_BOOTS == stack.getItem()) {
                if (EnderiumConfig.unbreakableEnderium) {
                    tooltip.add(Text.translatable("tooltip.immersiveores.unbreakble.tooltip").formatted(Formatting.DARK_AQUA));
                }
                tooltip.add(Text.translatable("tooltip.immersiveores.immunetofire.tooltip").formatted(Formatting.DARK_AQUA));
                if (EnderiumConfig.speedIIIEnderiumArmor) {
                    tooltip.add(Text.translatable("tooltip.immersiveores.speed3.tooltip").formatted(Formatting.DARK_AQUA));
                } if (EnderiumConfig.jumpIIIEnderiumArmor) {
                    tooltip.add(Text.translatable("tooltip.immersiveores.jump3.tooltip").formatted(Formatting.DARK_AQUA));
                } if (EnderiumConfig.canWalkOnPowderedSnowEnderium) {
                    tooltip.add(Text.translatable("tooltip.immersiveores.canwalkonpowderedsnow.tooltip").formatted(Formatting.DARK_AQUA));
                } if (EnderiumConfig.fireResistanceEnderiumArmor) {
                    tooltip.add(Text.translatable("tooltip.immersiveores.playerimmunetofire.tooltip").formatted(Formatting.DARK_AQUA));
                } if (EnderiumConfig.makesPiglinsNeutralEnderium) {
                    tooltip.add(Text.translatable("tooltip.immersiveores.immunetopiglin.tooltip").formatted(Formatting.DARK_AQUA));
                } if (EnderiumConfig.immuneToFallDamageEnderiumArmor) {
                    tooltip.add(Text.translatable("tooltip.immersiveores.immunetofalldamage.tooltip").formatted(Formatting.DARK_AQUA));
                } if (EnderiumConfig.canFlyEnderiumArmor) {
                    tooltip.add(Text.translatable("tooltip.immersiveores.canfly.tooltip").formatted(Formatting.DARK_AQUA));
                }
            }
            if (ModItems.ENDERIUM_CHESTPLATE == stack.getItem()) {
                if (EnderiumConfig.unbreakableEnderium) {
                    tooltip.add(Text.translatable("tooltip.immersiveores.unbreakble.tooltip").formatted(Formatting.DARK_AQUA));
                }
                tooltip.add(Text.translatable("tooltip.immersiveores.immunetofire.tooltip").formatted(Formatting.DARK_AQUA));
                if (EnderiumConfig.fireResistanceEnderiumArmor) {
                    tooltip.add(Text.translatable("tooltip.immersiveores.playerimmunetofire.tooltip").formatted(Formatting.DARK_AQUA));
                } if (EnderiumConfig.makesPiglinsNeutralEnderium) {
                    tooltip.add(Text.translatable("tooltip.immersiveores.immunetopiglin.tooltip").formatted(Formatting.DARK_AQUA));
                }
            }
            if (ModItems.ENDERIUM_LEGGINGS == stack.getItem()) {
                if (EnderiumConfig.unbreakableEnderium) {
                    tooltip.add(Text.translatable("tooltip.immersiveores.unbreakble.tooltip").formatted(Formatting.DARK_AQUA));
                }
                if (EnderiumConfig.fireResistanceEnderiumArmor) {
                    tooltip.add(Text.translatable("tooltip.immersiveores.immunetofire.tooltip").formatted(Formatting.DARK_AQUA));
                } if (EnderiumConfig.makesPiglinsNeutralEnderium) {
                    tooltip.add(Text.translatable("tooltip.immersiveores.immunetopiglin.tooltip").formatted(Formatting.DARK_AQUA));
                } if (EnderiumConfig.neverLoseHungerEnderiumArmor) {
                    tooltip.add(Text.translatable("tooltip.immersiveores.nerverlosehunger.tooltip").formatted(Formatting.DARK_AQUA));
                }
            }
            if (ModItems.ENDERIUM_HELMET == stack.getItem()) {
                if (EnderiumConfig.unbreakableEnderium) {
                    tooltip.add(Text.translatable("tooltip.immersiveores.unbreakble.tooltip").formatted(Formatting.DARK_AQUA));
                }
                tooltip.add(Text.translatable("tooltip.immersiveores.immunetofire.tooltip").formatted(Formatting.DARK_AQUA));
                if (EnderiumConfig.nightVisionEnderiumArmor) {
                    tooltip.add(Text.translatable("tooltip.immersiveores.nightvision.tooltip").formatted(Formatting.DARK_AQUA));
                } if (EnderiumConfig.makesPiglinsNeutralEnderium) {
                    tooltip.add(Text.translatable("tooltip.immersiveores.immunetopiglin.tooltip").formatted(Formatting.DARK_AQUA));
                } if (EnderiumConfig.endermanWillNotBeAngryWithYouEnderium) {
                    tooltip.add(Text.translatable("tooltip.immersiveores.endermanwillnotbeangrywithyou.tooltip").formatted(Formatting.DARK_AQUA));
                }
            }
        } else {
            tooltip.add(Text.translatable("tooltip.immersiveores.pressshiftformoreinfo.tooltip").formatted(Formatting.DARK_AQUA));
        }
    }
}

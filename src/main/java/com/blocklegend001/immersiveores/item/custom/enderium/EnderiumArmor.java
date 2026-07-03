package com.blocklegend001.immersiveores.item.custom.enderium;

import com.blocklegend001.immersiveores.config.EnderiumConfig;
import com.blocklegend001.immersiveores.item.ModItems;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.EquippableComponent;
import net.minecraft.component.type.TooltipDisplayComponent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.item.equipment.trim.ArmorTrim;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Unit;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Consumer;

public class EnderiumArmor extends Item {

    public EnderiumArmor(ArmorMaterial material, EquipmentType type, Settings settings) {
        super(computeSettings(material, type, EnderiumConfig.unbreakableEnderium, EnderiumConfig.durabilityEnderium, settings));
    }

    private static Item.Settings computeSettings(ArmorMaterial material, EquipmentType type, boolean unbreakable, int durability, Item.Settings settings) {
        settings.armor(material, EquipmentType.BODY)
                .attributeModifiers(material.createAttributeModifiers(type))
                .enchantable(material.enchantmentValue())
                .component(DataComponentTypes.EQUIPPABLE, EquippableComponent.builder(type.getEquipmentSlot()).equipSound(material.equipSound()).model(material.assetId()).build())
                .maxDamage(durability);
                if (unbreakable) {
                    settings.component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE);
                }
        return settings;
    }

    @Override
    public Text getName(ItemStack stack) {
        return super.getName(stack).copy().formatted(Formatting.DARK_AQUA);
    }

    @Override
    public void inventoryTick(ItemStack stack, ServerWorld world, Entity entity, @Nullable EquipmentSlot slot) {
        if (!world.isClient()) {
            if (entity instanceof PlayerEntity player) {
                if (player.getEquippedStack(EquipmentSlot.FEET).getItem() == ModItems.ENDERIUM_BOOTS) {
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
                if (player.getEquippedStack(EquipmentSlot.CHEST).getItem() == ModItems.ENDERIUM_CHESTPLATE) {
                    if (EnderiumConfig.fireResistanceEnderiumArmor) {
                        player.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 400, 0, false, false));
                    }
                }
                if (player.getEquippedStack(EquipmentSlot.HEAD).getItem() == ModItems.ENDERIUM_HELMET) {
                    if (EnderiumConfig.nightVisionEnderiumArmor) {
                        player.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 400, 0, false, false));
                    }
                    if (EnderiumConfig.fireResistanceEnderiumArmor) {
                        player.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 400, 0, false, false));
                    }
                }
                if (player.getEquippedStack(EquipmentSlot.LEGS).getItem() == ModItems.ENDERIUM_LEGGINGS) {
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
    public void onCraftByPlayer(ItemStack stack, PlayerEntity player) {
        super.onCraftByPlayer(stack, player);

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

                ArmorTrim trim = ingredient.get(DataComponentTypes.TRIM);
                if (trim != null) {
                    stack.set(DataComponentTypes.TRIM, trim);
                }

                break;
            }
        }
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, TooltipDisplayComponent displayComponent, Consumer<Text> textConsumer, TooltipType type) {
        super.appendTooltip(stack, context, displayComponent, textConsumer, type);
        if(Screen.hasShiftDown()) {
            if (ModItems.ENDERIUM_BOOTS == stack.getItem()) {
                if (EnderiumConfig.unbreakableEnderium) {
                    textConsumer.accept(Text.translatable("tooltip.immersiveores.unbreakble.tooltip").formatted(Formatting.DARK_AQUA));
                }
                textConsumer.accept(Text.translatable("tooltip.immersiveores.immunetofire.tooltip").formatted(Formatting.DARK_AQUA));
                if (EnderiumConfig.speedIIIEnderiumArmor) {
                    textConsumer.accept(Text.translatable("tooltip.immersiveores.speed3.tooltip").formatted(Formatting.DARK_AQUA));
                } if (EnderiumConfig.jumpIIIEnderiumArmor) {
                    textConsumer.accept(Text.translatable("tooltip.immersiveores.jump3.tooltip").formatted(Formatting.DARK_AQUA));
                } if (EnderiumConfig.canWalkOnPowderedSnowEnderium) {
                    textConsumer.accept(Text.translatable("tooltip.immersiveores.canwalkonpowderedsnow.tooltip").formatted(Formatting.DARK_AQUA));
                } if (EnderiumConfig.fireResistanceEnderiumArmor) {
                    textConsumer.accept(Text.translatable("tooltip.immersiveores.playerimmunetofire.tooltip").formatted(Formatting.DARK_AQUA));
                } if (EnderiumConfig.makesPiglinsNeutralEnderium) {
                    textConsumer.accept(Text.translatable("tooltip.immersiveores.immunetopiglin.tooltip").formatted(Formatting.DARK_AQUA));
                } if (EnderiumConfig.immuneToFallDamageEnderiumArmor) {
                    textConsumer.accept(Text.translatable("tooltip.immersiveores.immunetofalldamage.tooltip").formatted(Formatting.DARK_AQUA));
                } if (EnderiumConfig.canFlyEnderiumArmor) {
                    textConsumer.accept(Text.translatable("tooltip.immersiveores.canfly.tooltip").formatted(Formatting.DARK_AQUA));
                }
            }
            if (ModItems.ENDERIUM_CHESTPLATE == stack.getItem()) {
                if (EnderiumConfig.unbreakableEnderium) {
                    textConsumer.accept(Text.translatable("tooltip.immersiveores.unbreakble.tooltip").formatted(Formatting.DARK_AQUA));
                }
                textConsumer.accept(Text.translatable("tooltip.immersiveores.immunetofire.tooltip").formatted(Formatting.DARK_AQUA));
                if (EnderiumConfig.fireResistanceEnderiumArmor) {
                    textConsumer.accept(Text.translatable("tooltip.immersiveores.playerimmunetofire.tooltip").formatted(Formatting.DARK_AQUA));
                } if (EnderiumConfig.makesPiglinsNeutralEnderium) {
                    textConsumer.accept(Text.translatable("tooltip.immersiveores.immunetopiglin.tooltip").formatted(Formatting.DARK_AQUA));
                }
            }
            if (ModItems.ENDERIUM_LEGGINGS == stack.getItem()) {
                if (EnderiumConfig.unbreakableEnderium) {
                    textConsumer.accept(Text.translatable("tooltip.immersiveores.unbreakble.tooltip").formatted(Formatting.DARK_AQUA));
                }
                textConsumer.accept(Text.translatable("tooltip.immersiveores.immunetofire.tooltip").formatted(Formatting.DARK_AQUA));
                if (EnderiumConfig.fireResistanceEnderiumArmor) {
                    textConsumer.accept(Text.translatable("tooltip.immersiveores.playerimmunetofire.tooltip").formatted(Formatting.DARK_AQUA));
                } if (EnderiumConfig.makesPiglinsNeutralEnderium) {
                    textConsumer.accept(Text.translatable("tooltip.immersiveores.immunetopiglin.tooltip").formatted(Formatting.DARK_AQUA));
                } if (EnderiumConfig.neverLoseHungerEnderiumArmor) {
                    textConsumer.accept(Text.translatable("tooltip.immersiveores.nerverlosehunger.tooltip").formatted(Formatting.DARK_AQUA));
                }
            }
            if (ModItems.ENDERIUM_HELMET == stack.getItem()) {
                if (EnderiumConfig.unbreakableEnderium) {
                    textConsumer.accept(Text.translatable("tooltip.immersiveores.unbreakble.tooltip").formatted(Formatting.DARK_AQUA));
                }
                textConsumer.accept(Text.translatable("tooltip.immersiveores.immunetofire.tooltip").formatted(Formatting.DARK_AQUA));
                if (EnderiumConfig.nightVisionEnderiumArmor) {
                    textConsumer.accept(Text.translatable("tooltip.immersiveores.nightvision.tooltip").formatted(Formatting.DARK_AQUA));
                } if (EnderiumConfig.makesPiglinsNeutralEnderium) {
                    textConsumer.accept(Text.translatable("tooltip.immersiveores.immunetopiglin.tooltip").formatted(Formatting.DARK_AQUA));
                } if (EnderiumConfig.endermanWillNotBeAngryWithYouEnderium) {
                    textConsumer.accept(Text.translatable("tooltip.immersiveores.endermanwillnotbeangrywithyou.tooltip").formatted(Formatting.DARK_AQUA));
                } if (EnderiumConfig.fireResistanceEnderiumArmor) {
                    textConsumer.accept(Text.translatable("tooltip.immersiveores.playerimmunetofire.tooltip").formatted(Formatting.DARK_AQUA));
                }
            }
        } else {
            textConsumer.accept(Text.translatable("tooltip.immersiveores.pressshiftformoreinfo.tooltip").formatted(Formatting.DARK_AQUA));
        }
    }
}

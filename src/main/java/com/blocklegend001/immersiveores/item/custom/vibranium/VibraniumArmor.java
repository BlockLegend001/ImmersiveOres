package com.blocklegend001.immersiveores.item.custom.vibranium;

import com.blocklegend001.immersiveores.config.VibraniumConfig;
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
import net.minecraft.item.Items;
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

public class VibraniumArmor extends Item {
    public VibraniumArmor(ArmorMaterial material, EquipmentType type, Item.Settings settings) {
        super(computeSettings(material, type, settings, VibraniumConfig.unbreakableVibranium, VibraniumConfig.durabilityVibranium));
    }

    private static Item.Settings computeSettings(ArmorMaterial material, EquipmentType type, Item.Settings settings,  boolean unbreakable, int durability) {
        settings.armor(material, EquipmentType.BODY)
                .attributeModifiers(material.createAttributeModifiers(type))
                .enchantable(material.enchantmentValue())
                .component(DataComponentTypes.EQUIPPABLE, EquippableComponent.builder(type.getEquipmentSlot()).equipSound(material.equipSound()).model(material.assetId()).build())
                .maxDamage(durability).fireproof();
                if (unbreakable) {
                    settings.component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE);
                }
        return settings;
    }

    @Override
    public Text getName(ItemStack stack) {
        return super.getName(stack).copy().formatted(Formatting.LIGHT_PURPLE);
    }

    @Override
    public void inventoryTick(ItemStack stack, ServerWorld world, Entity entity, @Nullable EquipmentSlot slot) {
        if (!world.isClient()){
            if(entity instanceof PlayerEntity player) {
                if (player.getEquippedStack(EquipmentSlot.FEET).getItem() == ModItems.VIBRANIUM_BOOTS) {
                    if (VibraniumConfig.speedIVibraniumArmor) {
                        player.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 400, 0, false, false));
                    }
                    if (VibraniumConfig.jumpIVibraniumArmor) {
                        player.addStatusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 400, 0, false, false));
                    }
                }
                if (player.getEquippedStack(EquipmentSlot.HEAD).getItem() == ModItems.VIBRANIUM_HELMET) {
                    if (VibraniumConfig.nightVisionVibraniumArmor) {
                        player.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 400, 0, false, false));
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

            if (resultItem == ModItems.VIBRANIUM_HELMET && ingredientItem == Items.NETHERITE_HELMET
                    || resultItem == ModItems.VIBRANIUM_CHESTPLATE && ingredientItem == Items.NETHERITE_CHESTPLATE
                    || resultItem == ModItems.VIBRANIUM_LEGGINGS && ingredientItem == Items.NETHERITE_LEGGINGS
                    || resultItem == ModItems.VIBRANIUM_BOOTS && ingredientItem == Items.NETHERITE_BOOTS) {

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
            if (ModItems.VIBRANIUM_BOOTS == stack.getItem()) {
                if (VibraniumConfig.unbreakableVibranium) {
                    textConsumer.accept(Text.translatable("tooltip.immersiveores.unbreakble.tooltip").formatted(Formatting.LIGHT_PURPLE));
                }
                textConsumer.accept(Text.translatable("tooltip.immersiveores.immunetofire.tooltip").formatted(Formatting.LIGHT_PURPLE));
                if (VibraniumConfig.speedIVibraniumArmor) {
                    textConsumer.accept(Text.translatable("tooltip.immersiveores.speed1.tooltip").formatted(Formatting.LIGHT_PURPLE));
                } if (VibraniumConfig.jumpIVibraniumArmor) {
                    textConsumer.accept(Text.translatable("tooltip.immersiveores.jump1.tooltip").formatted(Formatting.LIGHT_PURPLE));
                } if (VibraniumConfig.canWalkOnPowderedSnowVibranium) {
                    textConsumer.accept(Text.translatable("tooltip.immersiveores.canwalkonpowderedsnow.tooltip").formatted(Formatting.LIGHT_PURPLE));
                }
            }
            if (ModItems.VIBRANIUM_CHESTPLATE == stack.getItem()) {
                if (VibraniumConfig.unbreakableVibranium) {
                    textConsumer.accept(Text.translatable("tooltip.immersiveores.unbreakble.tooltip").formatted(Formatting.LIGHT_PURPLE));
                }
                textConsumer.accept(Text.translatable("tooltip.immersiveores.immunetofire.tooltip").formatted(Formatting.LIGHT_PURPLE));
            }
            if (ModItems.VIBRANIUM_HELMET == stack.getItem()) {
                if (VibraniumConfig.unbreakableVibranium) {
                    textConsumer.accept(Text.translatable("tooltip.immersiveores.unbreakble.tooltip").formatted(Formatting.LIGHT_PURPLE));
                }
                textConsumer.accept(Text.translatable("tooltip.immersiveores.immunetofire.tooltip").formatted(Formatting.LIGHT_PURPLE));
                if (VibraniumConfig.nightVisionVibraniumArmor) {
                    textConsumer.accept(Text.translatable("tooltip.immersiveores.nightvision.tooltip").formatted(Formatting.LIGHT_PURPLE));
                }
            }
            if (ModItems.VIBRANIUM_LEGGINGS == stack.getItem()) {
                if (VibraniumConfig.unbreakableVibranium) {
                    textConsumer.accept(Text.translatable("tooltip.immersiveores.unbreakble.tooltip").formatted(Formatting.LIGHT_PURPLE));
                }
                textConsumer.accept(Text.translatable("tooltip.immersiveores.immunetofire.tooltip").formatted(Formatting.LIGHT_PURPLE));
            }
        } else {
            textConsumer.accept(Text.translatable("tooltip.immersiveores.pressshiftformoreinfo.tooltip").formatted(Formatting.LIGHT_PURPLE));
        }
    }
}

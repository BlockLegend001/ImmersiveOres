package com.blocklegend001.immersiveores.item.custom.vibranium;

import com.blocklegend001.immersiveores.config.EnderiumConfig;
import com.blocklegend001.immersiveores.config.VibraniumConfig;
import com.blocklegend001.immersiveores.item.ModItems;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.UnbreakableComponent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

import java.util.List;

public class VibraniumArmor extends ArmorItem {
    private static Settings createSettings(boolean unbreakable, int durability) {
        Settings settings = new Settings()
                .maxDamage(durability)
                .fireproof();

        if (unbreakable) {
            settings.component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true));
        }

        return settings;
    }

    public VibraniumArmor(RegistryEntry<ArmorMaterial> material, Type type, Settings settings) {
        super(material, type, createSettings(VibraniumConfig.unbreakableVibranium, VibraniumConfig.durabilityVibranium));
    }

    @Override
    public boolean isEnchantable(ItemStack p_41456_) {
        return true;
    }

    @Override
    public Text getName(ItemStack stack) {
        return super.getName(stack).copy().formatted(Formatting.LIGHT_PURPLE);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!world.isClient()){
            if(entity instanceof PlayerEntity player) {
                if (player.getInventory().getArmorStack(0).getItem() == ModItems.VIBRANIUM_BOOTS) {
                    if (VibraniumConfig.speedIVibraniumArmor) {
                        player.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 400, 0, false, false));
                    }
                    if (VibraniumConfig.jumpIVibraniumArmor) {
                        player.addStatusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 400, 0, false, false));
                    }
                }
                if (player.getInventory().getArmorStack(3).getItem() == ModItems.VIBRANIUM_HELMET) {
                    if (VibraniumConfig.nightVisionVibraniumArmor) {
                        player.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 400, 0, false, false));
                    }
                }
            }
        }
    }

    @Override
    public void onCraftByPlayer(ItemStack stack, World world, PlayerEntity player) {
        super.onCraftByPlayer(stack, world, player);

        for (int i = 1; i <= 9; i++) {
            ItemStack ingredient = player.currentScreenHandler.getSlot(i).getStack();

            if (ingredient.getItem() instanceof ArmorItem armorItem &&
                    armorItem.getMaterial() == ArmorMaterials.NETHERITE &&
                    armorItem.getType() == ((ArmorItem) stack.getItem()).getType()) {

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
            if (ModItems.VIBRANIUM_BOOTS == stack.getItem()) {
                if (VibraniumConfig.unbreakableVibranium) {
                    tooltip.add(Text.translatable("tooltip.immersiveores.unbreakble.tooltip").formatted(Formatting.LIGHT_PURPLE));
                }
                tooltip.add(Text.translatable("tooltip.immersiveores.immunetofire.tooltip").formatted(Formatting.LIGHT_PURPLE));
                if (VibraniumConfig.speedIVibraniumArmor) {
                    tooltip.add(Text.translatable("tooltip.immersiveores.speed1.tooltip").formatted(Formatting.LIGHT_PURPLE));
                } if (VibraniumConfig.jumpIVibraniumArmor) {
                    tooltip.add(Text.translatable("tooltip.immersiveores.jump1.tooltip").formatted(Formatting.LIGHT_PURPLE));
                } if (VibraniumConfig.canWalkOnPowderedSnowVibranium) {
                    tooltip.add(Text.translatable("tooltip.immersiveores.canwalkonpowderedsnow.tooltip").formatted(Formatting.LIGHT_PURPLE));
                }
            }
            if (ModItems.VIBRANIUM_CHESTPLATE == stack.getItem()) {
                if (VibraniumConfig.unbreakableVibranium) {
                    tooltip.add(Text.translatable("tooltip.immersiveores.unbreakble.tooltip").formatted(Formatting.LIGHT_PURPLE));
                }
                tooltip.add(Text.translatable("tooltip.immersiveores.immunetofire.tooltip").formatted(Formatting.LIGHT_PURPLE));
            }
            if (ModItems.VIBRANIUM_HELMET == stack.getItem()) {
                if (VibraniumConfig.unbreakableVibranium) {
                    tooltip.add(Text.translatable("tooltip.immersiveores.unbreakble.tooltip").formatted(Formatting.LIGHT_PURPLE));
                }
                tooltip.add(Text.translatable("tooltip.immersiveores.immunetofire.tooltip").formatted(Formatting.LIGHT_PURPLE));
                if (VibraniumConfig.nightVisionVibraniumArmor) {
                    tooltip.add(Text.translatable("tooltip.immersiveores.nightvision.tooltip").formatted(Formatting.LIGHT_PURPLE));
                }
            }
            if (ModItems.VIBRANIUM_LEGGINGS == stack.getItem()) {
                if (VibraniumConfig.unbreakableVibranium) {
                    tooltip.add(Text.translatable("tooltip.immersiveores.unbreakble.tooltip").formatted(Formatting.LIGHT_PURPLE));
                }
                tooltip.add(Text.translatable("tooltip.immersiveores.immunetofire.tooltip").formatted(Formatting.LIGHT_PURPLE));
            }
        } else {
            tooltip.add(Text.translatable("tooltip.immersiveores.pressshiftformoreinfo.tooltip").formatted(Formatting.LIGHT_PURPLE));
        }
    }
}
package com.blocklegend001.immersiveores.item.custom.enderium;

import com.blocklegend001.immersiveores.ImmersiveOres;
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
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

import java.util.List;

public class EnderiumArmor extends ArmorItem {
    private static Settings createSettings(boolean unbreakable, int durability) {
        Settings settings = new Settings()
                .maxDamage(durability)
                .fireproof();

        if (unbreakable) {
            settings.component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true));
        }

        return settings;
    }

    public EnderiumArmor(RegistryEntry<ArmorMaterial> material, Type type, Settings settings) {
        super(material, type, createSettings(ImmersiveOres.ENDERIUM_CONFIG.toolTier().unbreakable, ImmersiveOres.ENDERIUM_CONFIG.toolTier().durability));
    }

    @Override
    public boolean isEnchantable(ItemStack p_41456_) {
        return true;
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
                    if (ImmersiveOres.ENDERIUM_CONFIG.armorAbilities().speedIII) {
                        player.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 400, 2, false, false));
                    }
                    if (ImmersiveOres.ENDERIUM_CONFIG.armorAbilities().jumpIII) {
                        player.addStatusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 400, 2, false, false));
                    }
                    if (ImmersiveOres.ENDERIUM_CONFIG.armorAbilities().fireResistance) {
                        player.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 400, 1, false, false));
                    }
                    if (!player.isOnGround() && player.fallDistance >= 1.0F && ImmersiveOres.ENDERIUM_CONFIG.armorAbilities().immuneToFallDamage) {
                        player.fallDistance = 0F;
                    }
                }
                if (player.getInventory().getArmorStack(2).getItem() == ModItems.ENDERIUM_CHESTPLATE) {
                    if (ImmersiveOres.ENDERIUM_CONFIG.armorAbilities().fireResistance) {
                        player.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 400, 0, false, false));
                    }
                }
                if (player.getInventory().getArmorStack(3).getItem() == ModItems.ENDERIUM_HELMET) {
                    if (ImmersiveOres.ENDERIUM_CONFIG.armorAbilities().nightVision) {
                        player.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 400, 0, false, false));
                    }
                    if (ImmersiveOres.ENDERIUM_CONFIG.armorAbilities().fireResistance) {
                        player.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 400, 0, false, false));
                    }
                }
                if (player.getInventory().getArmorStack(1).getItem() == ModItems.ENDERIUM_LEGGINGS) {
                    if (ImmersiveOres.ENDERIUM_CONFIG.armorAbilities().neverLoseHunger) {
                        player.addStatusEffect(new StatusEffectInstance(StatusEffects.SATURATION, 400, 99, false, false));
                    }
                    if (ImmersiveOres.ENDERIUM_CONFIG.armorAbilities().fireResistance) {
                        player.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 400, 0, false, false));
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
                    armorItem.getMaterial() == ModArmorMaterials.VULPUS &&
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
            if (ModItems.ENDERIUM_BOOTS == stack.getItem()) {
                if (ImmersiveOres.ENDERIUM_CONFIG.toolTier().unbreakable) {
                    tooltip.add(Text.translatable("tooltip.immersiveores.unbreakble.tooltip").formatted(Formatting.DARK_AQUA));
                }
                tooltip.add(Text.translatable("tooltip.immersiveores.immunetofire.tooltip").formatted(Formatting.DARK_AQUA));
                if (ImmersiveOres.ENDERIUM_CONFIG.armorAbilities().speedIII) {
                    tooltip.add(Text.translatable("tooltip.immersiveores.speed3.tooltip").formatted(Formatting.DARK_AQUA));
                } if (ImmersiveOres.ENDERIUM_CONFIG.armorAbilities().jumpIII) {
                    tooltip.add(Text.translatable("tooltip.immersiveores.jump3.tooltip").formatted(Formatting.DARK_AQUA));
                } if (ImmersiveOres.ENDERIUM_CONFIG.armorAbilities().canWalkOnPowderedSnow) {
                    tooltip.add(Text.translatable("tooltip.immersiveores.canwalkonpowderedsnow.tooltip").formatted(Formatting.DARK_AQUA));
                } if (ImmersiveOres.ENDERIUM_CONFIG.armorAbilities().fireResistance) {
                    tooltip.add(Text.translatable("tooltip.immersiveores.playerimmunetofire.tooltip").formatted(Formatting.DARK_AQUA));
                } if (ImmersiveOres.ENDERIUM_CONFIG.armorAbilities().makesPiglinsNeutral) {
                    tooltip.add(Text.translatable("tooltip.immersiveores.immunetopiglin.tooltip").formatted(Formatting.DARK_AQUA));
                } if (ImmersiveOres.ENDERIUM_CONFIG.armorAbilities().immuneToFallDamage) {
                    tooltip.add(Text.translatable("tooltip.immersiveores.immunetofalldamage.tooltip").formatted(Formatting.DARK_AQUA));
                } if (ImmersiveOres.ENDERIUM_CONFIG.armorAbilities().canFly) {
                    tooltip.add(Text.translatable("tooltip.immersiveores.canfly.tooltip").formatted(Formatting.DARK_AQUA));
                }
            }
            if (ModItems.ENDERIUM_CHESTPLATE == stack.getItem()) {
                if (ImmersiveOres.ENDERIUM_CONFIG.toolTier().unbreakable) {
                    tooltip.add(Text.translatable("tooltip.immersiveores.unbreakble.tooltip").formatted(Formatting.DARK_AQUA));
                }
                tooltip.add(Text.translatable("tooltip.immersiveores.immunetofire.tooltip").formatted(Formatting.DARK_AQUA));
                if (ImmersiveOres.ENDERIUM_CONFIG.armorAbilities().fireResistance) {
                    tooltip.add(Text.translatable("tooltip.immersiveores.playerimmunetofire.tooltip").formatted(Formatting.DARK_AQUA));
                } if (ImmersiveOres.ENDERIUM_CONFIG.armorAbilities().makesPiglinsNeutral) {
                    tooltip.add(Text.translatable("tooltip.immersiveores.immunetopiglin.tooltip").formatted(Formatting.DARK_AQUA));
                }
            }
            if (ModItems.ENDERIUM_LEGGINGS == stack.getItem()) {
                if (ImmersiveOres.ENDERIUM_CONFIG.toolTier().unbreakable) {
                    tooltip.add(Text.translatable("tooltip.immersiveores.unbreakble.tooltip").formatted(Formatting.DARK_AQUA));
                }
                tooltip.add(Text.translatable("tooltip.immersiveores.immunetofire.tooltip").formatted(Formatting.DARK_AQUA));
                if (ImmersiveOres.ENDERIUM_CONFIG.armorAbilities().fireResistance) {
                    tooltip.add(Text.translatable("tooltip.immersiveores.playerimmunetofire.tooltip").formatted(Formatting.DARK_AQUA));
                } if (ImmersiveOres.ENDERIUM_CONFIG.armorAbilities().makesPiglinsNeutral) {
                    tooltip.add(Text.translatable("tooltip.immersiveores.immunetopiglin.tooltip").formatted(Formatting.DARK_AQUA));
                } if (ImmersiveOres.ENDERIUM_CONFIG.armorAbilities().neverLoseHunger) {
                    tooltip.add(Text.translatable("tooltip.immersiveores.nerverlosehunger.tooltip").formatted(Formatting.DARK_AQUA));
                }
            }
            if (ModItems.ENDERIUM_HELMET == stack.getItem()) {
                if (ImmersiveOres.ENDERIUM_CONFIG.toolTier().unbreakable) {
                    tooltip.add(Text.translatable("tooltip.immersiveores.unbreakble.tooltip").formatted(Formatting.DARK_AQUA));
                }
                tooltip.add(Text.translatable("tooltip.immersiveores.immunetofire.tooltip").formatted(Formatting.DARK_AQUA));
                if (ImmersiveOres.ENDERIUM_CONFIG.armorAbilities().nightVision) {
                    tooltip.add(Text.translatable("tooltip.immersiveores.nightvision.tooltip").formatted(Formatting.DARK_AQUA));
                } if (ImmersiveOres.ENDERIUM_CONFIG.armorAbilities().makesPiglinsNeutral) {
                    tooltip.add(Text.translatable("tooltip.immersiveores.immunetopiglin.tooltip").formatted(Formatting.DARK_AQUA));
                } if (ImmersiveOres.ENDERIUM_CONFIG.armorAbilities().endermenNeutral) {
                    tooltip.add(Text.translatable("tooltip.immersiveores.endermanwillnotbeangrywithyou.tooltip").formatted(Formatting.DARK_AQUA));
                } if (ImmersiveOres.ENDERIUM_CONFIG.armorAbilities().fireResistance) {
                    tooltip.add(Text.translatable("tooltip.immersiveores.playerimmunetofire.tooltip").formatted(Formatting.DARK_AQUA));
                }
            }
        } else {
            tooltip.add(Text.translatable("tooltip.immersiveores.pressshiftformoreinfo.tooltip").formatted(Formatting.DARK_AQUA));
        }
    }
}

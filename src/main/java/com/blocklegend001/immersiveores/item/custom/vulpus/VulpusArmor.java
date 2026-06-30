package com.blocklegend001.immersiveores.item.custom.vulpus;

import com.blocklegend001.immersiveores.config.VulpusConfig;
import com.blocklegend001.immersiveores.item.ModArmorMaterials;
import com.blocklegend001.immersiveores.item.ModItems;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.item.trim.ArmorTrim;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class VulpusArmor extends ArmorItem {
    private static Settings createSettings() {
        return new Settings()
                .fireproof();
    }

    public VulpusArmor(ArmorMaterial material, Type type, Settings settings) {
        super(material, type, createSettings());
    }

    @Override
    public boolean isEnchantable(ItemStack p_41456_) {
        return true;
    }

    @Override
    public Text getName(ItemStack stack) {
        return super.getName(stack).copy().formatted(Formatting.RED);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!world.isClient()) {
            if(entity instanceof PlayerEntity player) {
                if (player.getInventory().getArmorStack(0).getItem() == ModItems.VULPUS_BOOTS) {
                    if (VulpusConfig.speedIIVulpusArmor) {
                        player.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 400, 1, false, false));
                    } if (VulpusConfig.jumpIIVulpusArmor) {
                        player.addStatusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 400, 1, false, false));
                    } if (VulpusConfig.fireResistanceVulpusArmor) {
                        player.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 400, 0, false, false));
                    }
                    if (!player.isOnGround() && player.fallDistance >= 1.0F && VulpusConfig.immuneToFallDamageVulpusArmor) {
                        player.fallDistance = 0F;
                    }
                }
                if (player.getInventory().getArmorStack(2).getItem() == ModItems.VULPUS_CHESTPLATE) {
                    if (VulpusConfig.fireResistanceVulpusArmor) {
                        player.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 400, 0, false, false));
                    }
                }
                if (player.getInventory().getArmorStack(3).getItem() == ModItems.VULPUS_HELMET) {
                    if (VulpusConfig.nightVisionVulpusArmor) {
                        player.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 400, 0, false, false));
                    } if (VulpusConfig.fireResistanceVulpusArmor) {
                        player.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 400, 0, false, false));
                    }
                }
                if (player.getInventory().getArmorStack(1).getItem() == ModItems.VULPUS_LEGGINGS) {
                    if (VulpusConfig.fireResistanceVulpusArmor) {
                        player.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 400, 0, false, false));
                    }
                    if (VulpusConfig.neverLoseHungerVulpusArmor) {
                        player.addStatusEffect(new StatusEffectInstance(StatusEffects.SATURATION, 400, 99, false, false));
                    }
                }
            }
        }
    }

    @Override
    public void onCraft(ItemStack stack, World world, PlayerEntity player) {
        super.onCraft(stack, world, player);

        for (int i = 1; i <= 9; i++) {
            ItemStack ingredient = player.currentScreenHandler.getSlot(i).getStack();

            if (ingredient.getItem() instanceof ArmorItem armorItem &&
                    armorItem.getMaterial() == ModArmorMaterials.VIBRANIUM &&
                    armorItem.getType() == ((ArmorItem) stack.getItem()).getType()) {

                Map<Enchantment, Integer> ench = EnchantmentHelper.get(ingredient);
                if (!ench.isEmpty()) {
                    EnchantmentHelper.set(ench, stack);
                }

                if (ingredient.hasCustomName()) {
                    stack.setCustomName(ingredient.getName());
                }

                Optional<ArmorTrim> trim = ArmorTrim.getTrim(world.getRegistryManager(), ingredient);
                trim.ifPresent(t -> ArmorTrim.apply(world.getRegistryManager(), stack, t));

                break;
            }
        }
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World contex, List<Text> tooltip, TooltipContext options) {
        if(Screen.hasShiftDown()){
            if (ModItems.VULPUS_BOOTS == stack.getItem()) {
                if (VulpusConfig.unbreakableVulpus) {
                    tooltip.add(Text.translatable("tooltip.immersiveores.unbreakble.tooltip").formatted(Formatting.RED));
                }
                tooltip.add(Text.translatable("tooltip.immersiveores.immunetofire.tooltip").formatted(Formatting.RED));
                if (VulpusConfig.speedIIVulpusArmor) {
                    tooltip.add(Text.translatable("tooltip.immersiveores.speed2.tooltip").formatted(Formatting.RED));
                } if (VulpusConfig.jumpIIVulpusArmor) {
                    tooltip.add(Text.translatable("tooltip.immersiveores.jump2.tooltip").formatted(Formatting.RED));
                }
                if (VulpusConfig.canWalkOnPowderedSnowVulpus) {
                    tooltip.add(Text.translatable("tooltip.immersiveores.canwalkonpowderedsnow.tooltip").formatted(Formatting.RED));
                } if (VulpusConfig.makesPiglinsNeutralVulpus) {
                    tooltip.add(Text.translatable("tooltip.immersiveores.immunetopiglin.tooltip").formatted(Formatting.RED));
                } if (VulpusConfig.fireResistanceVulpusArmor) {
                    tooltip.add(Text.translatable("tooltip.immersiveores.playerimmunetofire.tooltip").formatted(Formatting.RED));
                } if (VulpusConfig.immuneToFallDamageVulpusArmor) {
                    tooltip.add(Text.translatable("tooltip.immersiveores.immunetofalldamage.tooltip").formatted(Formatting.RED));
                }
            }
            if (ModItems.VULPUS_CHESTPLATE == stack.getItem()) {
                if (VulpusConfig.unbreakableVulpus) {
                    tooltip.add(Text.translatable("tooltip.immersiveores.unbreakble.tooltip").formatted(Formatting.RED));
                }
                tooltip.add(Text.translatable("tooltip.immersiveores.immunetofire.tooltip").formatted(Formatting.RED));
                if (VulpusConfig.makesPiglinsNeutralVulpus) {
                    tooltip.add(Text.translatable("tooltip.immersiveores.immunetopiglin.tooltip").formatted(Formatting.RED));
                } if (VulpusConfig.fireResistanceVulpusArmor) {
                    tooltip.add(Text.translatable("tooltip.immersiveores.playerimmunetofire.tooltip").formatted(Formatting.RED));
                }
            }
            if (ModItems.VULPUS_HELMET == stack.getItem()) {
                if (VulpusConfig.unbreakableVulpus) {
                    tooltip.add(Text.translatable("tooltip.immersiveores.unbreakble.tooltip").formatted(Formatting.RED));
                }
                tooltip.add(Text.translatable("tooltip.immersiveores.immunetofire.tooltip").formatted(Formatting.RED));
                if (VulpusConfig.nightVisionVulpusArmor) {
                    tooltip.add(Text.translatable("tooltip.immersiveores.nightvision.tooltip").formatted(Formatting.RED));
                } if (VulpusConfig.makesPiglinsNeutralVulpus) {
                    tooltip.add(Text.translatable("tooltip.immersiveores.immunetopiglin.tooltip").formatted(Formatting.RED));
                } if (VulpusConfig.fireResistanceVulpusArmor) {
                    tooltip.add(Text.translatable("tooltip.immersiveores.playerimmunetofire.tooltip").formatted(Formatting.RED));
                }
            }
            if (ModItems.VULPUS_LEGGINGS == stack.getItem()) {
                if (VulpusConfig.unbreakableVulpus) {
                    tooltip.add(Text.translatable("tooltip.immersiveores.unbreakble.tooltip").formatted(Formatting.RED));
                }
                tooltip.add(Text.translatable("tooltip.immersiveores.immunetofire.tooltip").formatted(Formatting.RED));
                if (VulpusConfig.makesPiglinsNeutralVulpus) {
                    tooltip.add(Text.translatable("tooltip.immersiveores.immunetopiglin.tooltip").formatted(Formatting.RED));
                } if (VulpusConfig.fireResistanceVulpusArmor) {
                    tooltip.add(Text.translatable("tooltip.immersiveores.playerimmunetofire.tooltip").formatted(Formatting.RED));
                } if (VulpusConfig.neverLoseHungerVulpusArmor) {
                    tooltip.add(Text.translatable("tooltip.immersiveores.nerverlosehunger.tooltip").formatted(Formatting.RED));
                }
            }
        } else {
            tooltip.add(Text.translatable("tooltip.immersiveores.pressshiftformoreinfo.tooltip").formatted(Formatting.RED));
        }
    }
}
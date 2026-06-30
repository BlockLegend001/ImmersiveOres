package com.blocklegend001.immersiveores.item.custom.enderium;

import com.blocklegend001.immersiveores.config.EnderiumConfig;
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

public class EnderiumArmor extends ArmorItem {
    private static Settings createSettings() {
        return new Settings()
                .fireproof();
    }

    public EnderiumArmor(ArmorMaterial material, Type type, Settings settings) {
        super(material, type, createSettings());
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
    public void onCraft(ItemStack stack, World world, PlayerEntity player) {
        super.onCraft(stack, world, player);

        for (int i = 1; i <= 9; i++) {
            ItemStack ingredient = player.currentScreenHandler.getSlot(i).getStack();

            if (ingredient.getItem() instanceof ArmorItem armorItem &&
                    armorItem.getMaterial() == ModArmorMaterials.VULPUS &&
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
                tooltip.add(Text.translatable("tooltip.immersiveores.immunetofire.tooltip").formatted(Formatting.DARK_AQUA));
                if (EnderiumConfig.fireResistanceEnderiumArmor) {
                    tooltip.add(Text.translatable("tooltip.immersiveores.playerimmunetofire.tooltip").formatted(Formatting.DARK_AQUA));
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
                } if (EnderiumConfig.fireResistanceEnderiumArmor) {
                    tooltip.add(Text.translatable("tooltip.immersiveores.playerimmunetofire.tooltip").formatted(Formatting.DARK_AQUA));
                }
            }
        } else {
            tooltip.add(Text.translatable("tooltip.immersiveores.pressshiftformoreinfo.tooltip").formatted(Formatting.DARK_AQUA));
        }
    }
}
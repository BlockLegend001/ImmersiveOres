package com.blocklegend001.immersiveores.item.custom.enderium;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;

import java.util.function.Consumer;

public class EnderiumSword extends Item {
    public EnderiumSword(ToolMaterial material, float attackDamage, float attackSpeed, Properties settings) {
        super(computeSettings(material, settings, attackDamage, attackSpeed));
    }

    private static Properties computeSettings(ToolMaterial material, Properties settings, float attackDamage, float attackSpeed) {
        settings.sword(wrapMaterial(material, material.durability()), attackDamage, attackSpeed);
        return settings;
    }

    @Override
    public void postHurtEnemy(ItemStack arg, LivingEntity arg2, LivingEntity arg3) {
        arg2.setRemainingFireTicks(30);
        super.postHurtEnemy(arg, arg2, arg3);
    }

    private static ToolMaterial wrapMaterial(ToolMaterial toolMaterial, int durability) {
        return new ToolMaterial(
                toolMaterial.incorrectBlocksForDrops(),
                durability,
                toolMaterial.speed(),
                toolMaterial.attackDamageBonus(),
                toolMaterial.enchantmentValue(),
                toolMaterial.repairItems()
        );
    }

    @Override
    public void appendHoverText(ItemStack pStack, TooltipContext p_333372_, TooltipDisplay p_396484_, Consumer<Component> consumer, TooltipFlag p_41424_) {
        super.appendHoverText(pStack, p_333372_, p_396484_, consumer, p_41424_);
        if(Screen.hasShiftDown()) {
            consumer.accept(Component.translatable("tooltip.immersiveores.unbreakble.tooltip").withStyle(ChatFormatting.DARK_AQUA));
            consumer.accept(Component.translatable("tooltip.immersiveores.immunetofire.tooltip").withStyle(ChatFormatting.DARK_AQUA));
            consumer.accept(Component.translatable("tooltip.immersiveores.cansetmobonfire.tooltip").withStyle(ChatFormatting.DARK_AQUA));
        } else {
            consumer.accept(Component.translatable("tooltip.immersiveores.pressshiftformoreinfo.tooltip").withStyle(ChatFormatting.DARK_AQUA));
        }
    }
}

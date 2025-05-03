package com.blocklegend001.immersiveores.item.custom.enderium;

import com.blocklegend001.immersiveores.item.ModToolTiers;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;

import java.util.function.Consumer;

public class EnderiumSword extends Item {
    public EnderiumSword(ModToolTiers material, float attackDamage, float attackSpeed, Item.Properties settings) {
        super(material.applySwordProperties(settings, attackDamage, attackSpeed));
    }

    @Override
    public void hurtEnemy(ItemStack arg, LivingEntity arg2, LivingEntity arg3) {
        arg2.setRemainingFireTicks(30);
        super.hurtEnemy(arg, arg2, arg3);
    }

    @Override
    public void appendHoverText(ItemStack pStack, Item.TooltipContext p_333372_, TooltipDisplay p_396484_, Consumer<Component> consumer, TooltipFlag p_41424_) {
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

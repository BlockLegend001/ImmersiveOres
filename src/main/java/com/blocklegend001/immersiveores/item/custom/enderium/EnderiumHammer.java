package com.blocklegend001.immersiveores.item.custom.enderium;

import com.blocklegend001.immersiveores.config.EnderiumConfig;
import com.blocklegend001.immersiveores.item.ModToolTiers;
import com.blocklegend001.immersiveores.item.custom.base.Hammer;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.Unbreakable;

import java.util.List;

public class EnderiumHammer extends Hammer {
    private static Properties createSettings(boolean unbreakable, int durability) {
        Properties settings = new Properties()
                .durability(durability)
                .attributes(EnderiumHammer.createAttributes(
                        ModToolTiers.ENDERIUM,
                        EnderiumConfig.attackDamageEnderiumHammer.get(),
                        (float) EnderiumConfig.attackSpeedEnderiumHammer.get().doubleValue()
                ));

        if (unbreakable) {
            settings.component(DataComponents.UNBREAKABLE, new Unbreakable(true));
        }
        return settings;
    }

    public EnderiumHammer(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, createSettings(EnderiumConfig.unbreakableEnderium.get(), EnderiumConfig.durabilityEnderium.get()));
    }

    @Override
    public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> components, TooltipFlag pTooltipFlag) {
        if(Screen.hasShiftDown()) {
            if (EnderiumConfig.unbreakableEnderium.get()) {
                components.add(Component.translatable("tooltip.immersiveores.unbreakble.tooltip").withStyle(ChatFormatting.DARK_AQUA));
            }
            components.add(Component.translatable("tooltip.immersiveores.immunetofire.tooltip").withStyle(ChatFormatting.DARK_AQUA));
            components.add(Component.translatable("tooltip.immersiveores.7x7.tooltip").withStyle(ChatFormatting.DARK_AQUA));
        } else {
            components.add(Component.translatable("tooltip.immersiveores.pressshiftformoreinfo.tooltip").withStyle(ChatFormatting.DARK_AQUA));
        }
    }
}


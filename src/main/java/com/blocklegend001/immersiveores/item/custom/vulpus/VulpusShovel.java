package com.blocklegend001.immersiveores.item.custom.vulpus;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;

public class VulpusShovel extends ShovelItem {
    public VulpusShovel(ToolMaterial pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Settings pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType options) {
        if(Screen.hasShiftDown()) {
            tooltip.add(Text.translatable("tooltip.immersiveores.unbreakble.tooltip").formatted(Formatting.RED));
            tooltip.add(Text.translatable("tooltip.immersiveores.immunetofire.tooltip").formatted(Formatting.RED));
        } else {
            tooltip.add(Text.translatable("tooltip.immersiveores.pressshiftformoreinfo.tooltip").formatted(Formatting.RED));
        }
    }
}

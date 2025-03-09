package com.blocklegend001.immersiveores.item.custom.vibranium;

import com.blocklegend001.immersiveores.item.custom.base.Excavator;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;

public class VibraniumExcavator extends Excavator {

    public VibraniumExcavator(ToolMaterial pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Settings pProperties) {
        super(pTier, pProperties);
    }

    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType options) {
        if(Screen.hasShiftDown()) {
            tooltip.add(Text.translatable("tooltip.immersiveores.unbreakble.tooltip").formatted(Formatting.LIGHT_PURPLE));
            tooltip.add(Text.translatable("tooltip.immersiveores.immunetofire.tooltip").formatted(Formatting.LIGHT_PURPLE));
            tooltip.add(Text.translatable("tooltip.immersiveores.3x3.tooltip").formatted(Formatting.LIGHT_PURPLE));
        } else {
            tooltip.add(Text.translatable("tooltip.immersiveores.pressshiftformoreinfo.tooltip").formatted(Formatting.LIGHT_PURPLE));
        }
    }
}


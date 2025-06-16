package com.blocklegend001.immersiveores.item.custom.vibranium;

import com.blocklegend001.immersiveores.item.custom.base.Hammer;
import com.blocklegend001.immersiveores.util.RadiusMap;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;

public class VibraniumHammer extends Hammer {

    public VibraniumHammer(ToolMaterial pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Settings pProperties) {
        super(pTier, pProperties);
    }

    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType options) {
        int radius = getRadiusForHammer(stack);
        int widht = radius * 2 + 1;

        if (Screen.hasShiftDown()) {
            tooltip.add(Text.translatable("tooltip.immersiveores.unbreakble.tooltip").formatted(Formatting.LIGHT_PURPLE));
            tooltip.add(Text.translatable("tooltip.immersiveores.immunetofire.tooltip").formatted(Formatting.LIGHT_PURPLE));
            Text text = Text.literal("Dig area: ")
                    .formatted(Formatting.LIGHT_PURPLE)
                    .append(Text.literal(widht + "x1").formatted(Formatting.YELLOW));

            tooltip.add(text);

            super.appendTooltip(stack, context, tooltip, options);
        } else {
            tooltip.add(Text.translatable("tooltip.immersiveores.pressshiftformoreinfo.tooltip").formatted(Formatting.LIGHT_PURPLE));
        }
    }

    private int getRadiusForHammer(ItemStack stack) {
        if (RadiusMap.VIBRANIUM_HAMMER_RADIUS.containsKey(stack.getItem())) {
            return RadiusMap.VIBRANIUM_HAMMER_RADIUS.get(stack.getItem());
        }
        return 0;
    }
}
package com.blocklegend001.immersiveores.blocks.custom.vibranium;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;

public class VibraniumOre extends Block {

    public VibraniumOre(Settings arg) {
        super(arg);
    }

    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType options) {
        {
            tooltip.add(Text.translatable("tooltip.immersiveores.vibraniumore.tooltip").formatted(Formatting.LIGHT_PURPLE));
            tooltip.add(Text.translatable("tooltip.immersiveores.vibraniumorelevel.tooltip").formatted(Formatting.LIGHT_PURPLE));
            tooltip.add(Text.translatable("tooltip.immersiveores.breakvibranium.tooltip").formatted(Formatting.LIGHT_PURPLE));
        }

        super.appendTooltip(stack, context, tooltip, options);
    }
}
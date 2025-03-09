package com.blocklegend001.immersiveores.blocks.custom.enderium;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;

public class EnderiumOre extends Block {

    public EnderiumOre(Settings arg) {
        super(arg);
    }

    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType options) {

        {
            tooltip.add(Text.translatable("tooltip.immersiveores.enderiumore.tooltip").formatted(Formatting.DARK_AQUA));
            tooltip.add(Text.translatable("tooltip.immersiveores.enderiumorelevel.tooltip").formatted(Formatting.DARK_AQUA));
            tooltip.add(Text.translatable("tooltip.immersiveores.breakenderium.tooltip").formatted(Formatting.DARK_AQUA));
        }

        super.appendTooltip(stack, context, tooltip, options);
    }
}

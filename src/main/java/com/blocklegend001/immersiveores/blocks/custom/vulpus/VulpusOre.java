package com.blocklegend001.immersiveores.blocks.custom.vulpus;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;

public class VulpusOre extends Block {

    public VulpusOre(Settings arg) {
        super(arg);
    }

    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType options) {

        {
            tooltip.add(Text.translatable("tooltip.immersiveores.vulpusore.tooltip").formatted(Formatting.RED));
            tooltip.add(Text.translatable("tooltip.immersiveores.vulpusorelevel.tooltip").formatted(Formatting.RED));
            tooltip.add(Text.translatable("tooltip.immersiveores.breakvulpus.tooltip").formatted(Formatting.RED));

        }

        super.appendTooltip(stack, context, tooltip, options);
    }
}

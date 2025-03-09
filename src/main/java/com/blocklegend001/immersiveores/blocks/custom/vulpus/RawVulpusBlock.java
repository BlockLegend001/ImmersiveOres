package com.blocklegend001.immersiveores.blocks.custom.vulpus;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;

public class RawVulpusBlock extends Block {
    public RawVulpusBlock(Settings p_49795_) {
        super(p_49795_);
    }

    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType options) {

        {
            tooltip.add(Text.translatable("tooltip.immersiveores.breakvulpus.tooltip").formatted(Formatting.RED));
        }

        super.appendTooltip(stack, context, tooltip, options);
    }
}

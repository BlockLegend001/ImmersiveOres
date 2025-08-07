package com.blocklegend001.immersiveores.blocks.custom.vulpus;

import com.blocklegend001.immersiveores.tooltip.TooltipBlock;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;

public class RawVulpusBlock extends Block implements TooltipBlock {
    public RawVulpusBlock(Settings p_49795_) {
        super(p_49795_);
    }

    @Override
    public void appendClientTooltip(ItemStack stack, TooltipAccept tooltips) {
        tooltips.accept(Text.translatable("tooltip.immersiveores.breakvulpus.tooltip").formatted(Formatting.RED));
    }
}

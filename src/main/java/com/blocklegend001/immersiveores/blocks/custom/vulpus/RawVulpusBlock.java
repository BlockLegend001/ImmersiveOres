package com.blocklegend001.immersiveores.blocks.custom.vulpus;

import com.blocklegend001.immersiveores.util.tooltip.TooltipBlock;
import com.blocklegend001.immersiveores.util.color.ColoredBlock;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

public class RawVulpusBlock extends Block implements TooltipBlock, ColoredBlock {
    public RawVulpusBlock(Settings p_49795_) {
        super(p_49795_);
    }

    @Override
    public Formatting getColor() {
        return Formatting.RED;
    }

    @Override
    public void appendClientTooltip(ItemStack stack, TooltipAccept tooltips) {
        tooltips.accept(Text.translatable("tooltip.immersiveores.breakvulpus.tooltip").formatted(Formatting.RED));
    }
}

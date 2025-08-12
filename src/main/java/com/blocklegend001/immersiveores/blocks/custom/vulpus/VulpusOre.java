package com.blocklegend001.immersiveores.blocks.custom.vulpus;

import com.blocklegend001.immersiveores.tooltip.TooltipBlock;
import com.blocklegend001.immersiveores.util.color.ColoredBlock;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;

public class VulpusOre extends Block implements TooltipBlock, ColoredBlock {
    public VulpusOre(Settings arg) {
        super(arg);
    }

    @Override
    public Formatting getColor() {
        return Formatting.RED;
    }

    @Override
    public void appendClientTooltip(ItemStack stack, TooltipAccept tooltips) {
        tooltips.accept(Text.translatable("tooltip.immersiveores.vulpusore.tooltip").formatted(Formatting.RED));
        tooltips.accept(Text.translatable("tooltip.immersiveores.vulpusorelevel.tooltip").formatted(Formatting.RED));
        tooltips.accept(Text.translatable("tooltip.immersiveores.breakvulpus.tooltip").formatted(Formatting.RED));
    }
}

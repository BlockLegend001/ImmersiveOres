package com.blocklegend001.immersiveores.blocks.custom.vibranium;

import com.blocklegend001.immersiveores.tooltip.TooltipBlock;
import com.blocklegend001.immersiveores.util.color.ColoredBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;

public class VibraniumBlock extends Block implements TooltipBlock, ColoredBlock {
    public VibraniumBlock(Settings p_49795_) {
        super(p_49795_);
    }

    @Override
    public Formatting getColor() {
        return Formatting.LIGHT_PURPLE;
    }

    @Override
    public void appendClientTooltip(ItemStack stack, TooltipAccept tooltips) {
        tooltips.accept(Text.translatable("tooltip.immersiveores.breakvibranium.tooltip").formatted(Formatting.LIGHT_PURPLE));
    }
}

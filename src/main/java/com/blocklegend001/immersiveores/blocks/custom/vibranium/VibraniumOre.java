package com.blocklegend001.immersiveores.blocks.custom.vibranium;

import com.blocklegend001.immersiveores.tooltip.TooltipBlock;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;

public class VibraniumOre extends Block implements TooltipBlock {
    public VibraniumOre(Settings arg) {
        super(arg);
    }

    @Override
    public void appendClientTooltip(ItemStack stack, TooltipAccept tooltips) {
        tooltips.accept(Text.translatable("tooltip.immersiveores.vibraniumore.tooltip").formatted(Formatting.LIGHT_PURPLE));
        tooltips.accept(Text.translatable("tooltip.immersiveores.vibraniumorelevel.tooltip").formatted(Formatting.LIGHT_PURPLE));
        tooltips.accept(Text.translatable("tooltip.immersiveores.breakvibranium.tooltip").formatted(Formatting.LIGHT_PURPLE));
    }
}
package com.blocklegend001.immersiveores.blocks.custom.enderium;

import com.blocklegend001.immersiveores.tooltip.TooltipBlock;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

public class EnderiumBlock extends Block implements TooltipBlock {
    public EnderiumBlock(Settings p_49795_) {
        super(p_49795_);
    }

    @Override
    public void appendClientTooltip(ItemStack stack, TooltipAccept tooltips) {
        tooltips.accept(Text.translatable("tooltip.immersiveores.breakenderium.tooltip").formatted(Formatting.DARK_AQUA));
    }
}

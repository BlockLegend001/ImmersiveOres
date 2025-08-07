package com.blocklegend001.immersiveores.blocks.custom.enderium;

import com.blocklegend001.immersiveores.tooltip.TooltipBlock;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

public class EnderiumOre extends Block implements TooltipBlock {
    public EnderiumOre(Settings settings) {
        super(settings);
    }

    @Override
    public void appendClientTooltip(ItemStack stack, TooltipAccept tooltips) {
        tooltips.accept(Text.translatable("tooltip.immersiveores.enderiumore.tooltip").formatted(Formatting.DARK_AQUA));
        tooltips.accept(Text.translatable("tooltip.immersiveores.enderiumorelevel.tooltip").formatted(Formatting.DARK_AQUA));
        tooltips.accept(Text.translatable("tooltip.immersiveores.breakenderium.tooltip").formatted(Formatting.DARK_AQUA));
    }
}

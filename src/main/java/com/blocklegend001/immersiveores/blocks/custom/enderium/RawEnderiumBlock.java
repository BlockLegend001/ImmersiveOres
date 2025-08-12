package com.blocklegend001.immersiveores.blocks.custom.enderium;

import com.blocklegend001.immersiveores.util.color.ColoredBlock;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;

public class RawEnderiumBlock extends Block implements ColoredBlock {
    public RawEnderiumBlock(Settings p_49795_) {
        super(p_49795_);
    }

    @Override
    public Formatting getColor() {
        return Formatting.DARK_AQUA;
    }

    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType options) {

        {
            tooltip.add(Text.translatable("tooltip.immersiveores.breakenderium.tooltip").formatted(Formatting.DARK_AQUA));
        }

        super.appendTooltip(stack, context, tooltip, options);
    }
}

package com.blocklegend001.immersiveores.blocks.custom.vibranium;

import com.blocklegend001.immersiveores.util.color.ColoredBlock;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;

public class RawVibraniumBlock extends Block implements ColoredBlock {
    public RawVibraniumBlock(Settings p_49795_) {
        super(p_49795_);
    }

    @Override
    public Formatting getColor() {
        return Formatting.LIGHT_PURPLE;
    }

    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType options) {
        {
            tooltip.add(Text.translatable("tooltip.immersiveores.breakvibranium.tooltip").formatted(Formatting.LIGHT_PURPLE));
        }

        super.appendTooltip(stack, context, tooltip, options);
    }

}

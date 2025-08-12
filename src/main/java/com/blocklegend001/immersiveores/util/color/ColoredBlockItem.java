package com.blocklegend001.immersiveores.util.color;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.Style;
import net.minecraft.util.Formatting;

public class ColoredBlockItem extends BlockItem {
    private final Formatting color;

    public ColoredBlockItem(Block block, Settings settings, Formatting color) {
        super(block, settings);
        this.color = color;
    }

    @Override
    public Text getName(ItemStack stack) {
        return super.getName(stack).copy().setStyle(Style.EMPTY.withColor(color));
    }
}

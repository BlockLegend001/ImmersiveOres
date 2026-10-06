package com.blocklegend001.immersiveores.util.tooltip;

import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;

/**
 * Represents a block item that has a tooltip.<br>
 * Basically redirects the tooltip to the corresponding block extending {@link TooltipItem} in the registry.
 */
public class TooltipBlockItem extends BlockItem implements TooltipItem {
    public TooltipBlockItem(TooltipBlock block, Properties settings) {
        super((Block) block, settings);
    }

    @Override
    public void appendClientTooltip(ItemStack stack, TooltipAccept tooltips) {
        Identifier value = stack.getItem().components().get(DataComponents.ITEM_MODEL);
        @Nullable Block block = BuiltInRegistries.BLOCK.getValue(value);

        if(block instanceof TooltipItem tooltipItem) {
            tooltipItem.appendClientTooltip(stack, tooltips);
        }
    }
}

package com.blocklegend001.immersiveores.util.tooltip;

import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;

public class TooltipBlockItem extends BlockItem implements TooltipItem {
    public TooltipBlockItem(TooltipBlock block, Properties settings) {
        super((Block) block, settings);
    }

    @Override
    public void appendClientTooltip(ItemStack stack, TooltipAccept tooltips) {
        Identifier value = stack.getItem().components().get(DataComponents.ITEM_MODEL);
        if (value == null) return;

        ResourceKey<Block> key = ResourceKey.create(Registries.BLOCK, value);
        Holder.Reference<Block> block = BuiltInRegistries.BLOCK.get(key).orElse(null);

        if (block instanceof TooltipItem tooltipItem) {
            tooltipItem.appendClientTooltip(stack, tooltips);
        }
    }
}
package com.blocklegend001.immersiveores.util.color;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextColor;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import org.jspecify.annotations.Nullable;

public class ColoredBlockItem extends BlockItem {
    private final TextColor color;

    public ColoredBlockItem(Block block, Properties settings, @Nullable TextColor color) {
        super(block, settings);
        this.color = color;
    }

    @Override
    public Component getName(ItemStack stack) {
        assert color != null;
        return Component.translatable(this.getDescriptionId())
                .withColor(color.getValue());
    }
}

package com.blocklegend001.immersiveores.util.color;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class ColoredItem extends Item {
    private final ChatFormatting color;

    public ColoredItem(Properties properties, ChatFormatting color) {
        super(properties);
        this.color = color;
    }

    @Override
    public Component getName(ItemStack stack) {
        return Component.translatable(this.getDescriptionId(stack))
                .setStyle(Style.EMPTY.withColor(color));
    }
}

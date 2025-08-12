package com.blocklegend001.immersiveores.util.color;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

public class ColoredItem extends Item {
    private final Formatting color;

    public ColoredItem(Settings settings, Formatting color) {
        super(settings);
        this.color = color;
    }

    @Override
    public Text getName(ItemStack stack) {
        return Text.translatable(this.getTranslationKey(stack))
                .setStyle(Style.EMPTY.withColor(color));
    }
}
package com.blocklegend001.immersiveores.util.tooltip;


import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;

import java.util.List;

/**
 * Interface for items that have a tooltip.<br>
 * This method is used on the client side. See mod client initializer.
 */
public interface TooltipItem {
    void appendClientTooltip(ItemStack stack, TooltipAccept tooltips);

    record TooltipAccept(
            List<Component> tooltips
    ) {
        public void accept(Component text) {
            tooltips.add(text);
        }
    }
}
package com.blocklegend001.immersiveores.util.tooltip;

import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import java.util.List;

/**
 * Interface for items that have a tooltip.<br>
 * This method is used on the client side. See mod client initializer.
 */
public interface TooltipItem {
    void appendClientTooltip(ItemStack stack, TooltipAccept tooltips);

    record TooltipAccept(
            List<Text> tooltips
    ) {
        public void accept(Text text) {
            tooltips.add(text);
        }
    }
}
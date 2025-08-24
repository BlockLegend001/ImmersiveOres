package com.blocklegend001.immersiveores;

import com.blocklegend001.immersiveores.util.tooltip.TooltipItem;
import com.blocklegend001.immersiveores.util.tools.excavator.*;
import com.blocklegend001.immersiveores.util.tools.hammer.*;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;

public class ImmersiveOresClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ExcavatorOverlayRenderer.init();
        HammerOverlayRenderer.init();

        ItemTooltipCallback.EVENT.register((itemStack, tooltipContext, tooltipType, list
        ) -> {
            if(itemStack.getItem() instanceof TooltipItem tooltipItem) {
                tooltipItem.appendClientTooltip(itemStack, new TooltipItem.TooltipAccept(list));
            }
        });
    }
}
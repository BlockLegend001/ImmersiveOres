package com.blocklegend001.immersiveores.util.tooltip;

import com.blocklegend001.immersiveores.ImmersiveOres;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;

@EventBusSubscriber(modid = ImmersiveOres.MODID, value = Dist.CLIENT)
public class ModClientTooltipHandler {

    @SubscribeEvent
    public static void onItemTooltip(ItemTooltipEvent event) {
        ItemStack stack = event.getItemStack();

        if (stack.getItem() instanceof TooltipItem tooltipItem) {
            tooltipItem.appendClientTooltip(stack, new TooltipItem.TooltipAccept(event.getToolTip()));
        }
    }
}

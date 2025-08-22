package com.blocklegend001.immersiveores.util.tooltip;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import com.blocklegend001.immersiveores.ImmersiveOres;
import net.minecraft.world.item.ItemStack;

@Mod.EventBusSubscriber(modid = ImmersiveOres.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ModClientTooltipHandler {

    @SubscribeEvent
    public static void onItemTooltip(ItemTooltipEvent event) {
        ItemStack stack = event.getItemStack();

        if (stack.getItem() instanceof TooltipItem tooltipItem) {
            tooltipItem.appendClientTooltip(stack, new TooltipItem.TooltipAccept(event.getToolTip()));
        }
    }
}

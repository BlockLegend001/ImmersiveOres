package com.blocklegend001.immersiveores.event;

import com.blocklegend001.immersiveores.ImmersiveOres;
import com.blocklegend001.immersiveores.util.tools.ModEventsToolHandler;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.listener.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ImmersiveOres.MODID, value = Dist.CLIENT)
public class ClientEvents {
    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent event) {
        if (Minecraft.getInstance().player != null) {
            ModEventsToolHandler.isSneaking = Minecraft.getInstance().player.isShiftKeyDown();
        }
    }
}
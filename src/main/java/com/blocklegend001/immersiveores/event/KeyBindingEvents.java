package com.blocklegend001.immersiveores.event;

import com.blocklegend001.immersiveores.ImmersiveOres;
import com.blocklegend001.immersiveores.util.KeyBinding;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ImmersiveOres.MODID, value = Dist.CLIENT)

public class KeyBindingEvents {

    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent event) {
        if (event.phase != TickEvent.Phase.END) return;

        while (KeyBinding.SHOW_OUTLINE_KEY.consumeClick()) {
            ImmersiveOres.SHOW_OUTLINE_ENABLED =
                    !ImmersiveOres.SHOW_OUTLINE_ENABLED;

            if (Minecraft.getInstance().player != null) {
                Minecraft.getInstance().player.displayClientMessage(
                        Component.literal(
                                "Outline: " +
                                        (ImmersiveOres.SHOW_OUTLINE_ENABLED ? "ON" : "OFF")
                        ), false
                );
            }
        }
    }
}
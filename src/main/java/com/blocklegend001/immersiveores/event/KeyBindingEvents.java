package com.blocklegend001.immersiveores.event;

import com.blocklegend001.immersiveores.ImmersiveOres;
import com.blocklegend001.immersiveores.util.KeyBinding;
import dev.architectury.event.events.common.TickEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ClientTickEvent;

@EventBusSubscriber(modid = ImmersiveOres.MODID, value = Dist.CLIENT)

public class KeyBindingEvents {

    @SubscribeEvent
    public static void onClientTick(ClientTickEvent.Post event) {

        if (KeyBinding.SHOW_OUTLINE_KEY.get().consumeClick()) {

            ImmersiveOres.SHOW_OUTLINE_ENABLED =
                    !ImmersiveOres.SHOW_OUTLINE_ENABLED;

            var mc = Minecraft.getInstance();

            if (mc.player != null) {
                mc.player.sendSystemMessage(
                        Component.literal(
                                "Outline: " +
                                        (ImmersiveOres.SHOW_OUTLINE_ENABLED ? "ON" : "OFF")
                        )
                );
            }
        }
    }
}
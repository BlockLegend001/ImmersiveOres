package com.blocklegend001.immersiveores;

import com.blocklegend001.immersiveores.util.tooltip.TooltipItem;
import com.blocklegend001.immersiveores.util.tools.excavator.*;
import com.blocklegend001.immersiveores.util.tools.hammer.*;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.minecraft.client.Minecraft;
import org.lwjgl.glfw.GLFW;

public class ImmersiveOresClient implements ClientModInitializer {
    private static boolean shiftKeyPressed = false;

    @Override
    public void onInitializeClient() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> updateShiftKey());
        ItemTooltipCallback.EVENT.register((itemStack, tooltipContext, tooltipType, list
        ) -> {
            if(itemStack.getItem() instanceof TooltipItem tooltipItem) {
                tooltipItem.appendClientTooltip(itemStack, new TooltipItem.TooltipAccept(list));
            }
        });
    }

    private static void updateShiftKey() {
        Minecraft mc = Minecraft.getInstance();
        if (mc == null || mc.getWindow() == null) return;

        long handle = mc.getWindow().handle();

        shiftKeyPressed = GLFW.glfwGetKey(handle, GLFW.GLFW_KEY_LEFT_SHIFT) == GLFW.GLFW_PRESS;
    }

    public static boolean isShiftKeyPressed() {
        return shiftKeyPressed;
    }
}
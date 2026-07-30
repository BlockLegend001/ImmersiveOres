package com.blocklegend001.immersiveores;

import com.blocklegend001.immersiveores.util.tooltip.TooltipItem;
import com.blocklegend001.immersiveores.util.tools.excavator.*;
import com.blocklegend001.immersiveores.util.tools.hammer.*;
import com.mojang.blaze3d.platform.InputConstants;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.fabricmc.fabric.api.client.keymapping.v1.KeyMappingHelper;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import org.lwjgl.glfw.GLFW;

public class ImmersiveOresClient implements ClientModInitializer {
    private static boolean shiftKeyPressed = false;

    public static KeyMapping SHOW_OUTLINE_KEY;
    public static boolean SHOW_OUTLINE_ENABLED = true;

    private static final KeyMapping.Category CATEGORY =
            KeyMapping.Category.register(
                    Identifier.fromNamespaceAndPath("immersiveores", "showoutline")
            );

    @Override
    public void onInitializeClient() {
        SHOW_OUTLINE_KEY = KeyMappingHelper.registerKeyMapping(
                new KeyMapping(
                        "key.immersiveores.showoutline",
                        InputConstants.Type.KEYSYM,
                        GLFW.GLFW_KEY_O,
                        CATEGORY
                )
        );

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (SHOW_OUTLINE_KEY.consumeClick()) {
                SHOW_OUTLINE_ENABLED = !SHOW_OUTLINE_ENABLED;

                if (client.player != null) {
                    client.player.sendSystemMessage(
                            Component.literal("Outline: " + (SHOW_OUTLINE_ENABLED ? "ON" : "OFF"))
                    );
                }
            }
        });

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
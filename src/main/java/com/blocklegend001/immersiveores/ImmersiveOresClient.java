package com.blocklegend001.immersiveores;

import com.blocklegend001.immersiveores.util.tooltip.TooltipItem;
import com.blocklegend001.immersiveores.util.tools.excavator.*;
import com.blocklegend001.immersiveores.util.tools.hammer.*;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.lwjgl.glfw.GLFW;

public class ImmersiveOresClient implements ClientModInitializer {
    private static boolean shiftKeyPressed = false;

    public static KeyBinding SHOW_OUTLINE_KEY;
    public static boolean SHOW_OUTLINE_ENABLED = true;

    private static final KeyBinding.Category CATEGORY =
            KeyBinding.Category.create(
                    Identifier.of("immersiveores", "showoutline")
            );

    @Override
    public void onInitializeClient() {
        SHOW_OUTLINE_KEY = KeyBindingHelper.registerKeyBinding(
                new KeyBinding(
                        "key.immersiveores.showoutline",
                        InputUtil.Type.KEYSYM,
                        GLFW.GLFW_KEY_O,
                        CATEGORY
                )
        );

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (SHOW_OUTLINE_KEY.wasPressed()) {
                SHOW_OUTLINE_ENABLED = !SHOW_OUTLINE_ENABLED;

                if (client.player != null) {
                    client.player.sendMessage(
                            Text.literal("Outline: " + (SHOW_OUTLINE_ENABLED ? "ON" : "OFF")),
                            false
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
        MinecraftClient mc = MinecraftClient.getInstance();
        if (mc == null || mc.getWindow() == null) return;

        long handle = mc.getWindow().getHandle();

        shiftKeyPressed = GLFW.glfwGetKey(handle, GLFW.GLFW_KEY_LEFT_SHIFT) == GLFW.GLFW_PRESS;
    }

    public static boolean isShiftKeyPressed() {
        return shiftKeyPressed;
    }
}
package com.blocklegend001.immersiveores;

import com.blocklegend001.immersiveores.util.tools.bow.ModItemProperties;
import com.blocklegend001.immersiveores.util.tools.excavator.*;
import com.blocklegend001.immersiveores.util.tools.hammer.*;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;

public class ImmersiveOresClient implements ClientModInitializer {

    public static KeyBinding SHOW_OUTLINE_KEY;
    private static boolean wasPressed = false;
    public static boolean SHOW_OUTLINE_ENABLED = true;

    @Override
    public void onInitializeClient() {
        SHOW_OUTLINE_KEY = KeyBindingHelper.registerKeyBinding(
                new KeyBinding(
                        "key.immersiveores.showoutline",
                        InputUtil.Type.KEYSYM,
                        GLFW.GLFW_KEY_O,
                        "key.category.immersiveores.showoutline"
                )
        );

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (SHOW_OUTLINE_KEY.isPressed()) {
                if (!wasPressed) {
                    SHOW_OUTLINE_ENABLED = !SHOW_OUTLINE_ENABLED;

                    if (client.player != null) {
                        client.player.sendMessage(
                                Text.literal("Outline: " + (SHOW_OUTLINE_ENABLED ? "ON" : "OFF")),
                                false
                        );
                    }
                }
                wasPressed = true;
            } else{
                wasPressed = false;
                }
        });

        ModItemProperties.registerModModels();
        ExcavatorOverlayRenderer.init();
        HammerOverlayRenderer.init();
    }
}

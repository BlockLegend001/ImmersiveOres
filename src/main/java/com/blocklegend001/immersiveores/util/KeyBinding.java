package com.blocklegend001.immersiveores.util;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.listener.SubscribeEvent;
import org.lwjgl.glfw.GLFW;

import static com.blocklegend001.immersiveores.ImmersiveOres.MODID;

public class KeyBinding {
    public static final KeyMapping.Category IMMERSIVEORES_CATEGORY =
            KeyMapping.Category.register(
                    ResourceLocation.fromNamespaceAndPath(MODID, "showoutline")
            );

    public static final KeyMapping SHOW_OUTLINE_KEY = new KeyMapping(
            "key.immersiveores.showoutline",
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_O,
            IMMERSIVEORES_CATEGORY
    );

    @SubscribeEvent
    public static void registerKeys(RegisterKeyMappingsEvent event) {
        event.register(SHOW_OUTLINE_KEY);
    }
}

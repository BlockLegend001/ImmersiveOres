package com.blocklegend001.immersiveores.util;

import com.blocklegend001.immersiveores.ImmersiveOres;
import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.common.util.Lazy;
import org.lwjgl.glfw.GLFW;

@EventBusSubscriber(modid = ImmersiveOres.MODID, value = Dist.CLIENT, bus = EventBusSubscriber.Bus.MOD)
public class KeyBinding {
    public static final Lazy<KeyMapping> SHOW_OUTLINE_KEY = Lazy.of(() ->
            new KeyMapping(
                "key.immersiveores.showoutline",
                InputConstants.Type.KEYSYM,
                GLFW.GLFW_KEY_O,
                "key.category.immersiveores.showoutline"
            )
    );

    @SubscribeEvent
    public static void registerKeys(RegisterKeyMappingsEvent event) {
        event.register(SHOW_OUTLINE_KEY.get());
    }
}
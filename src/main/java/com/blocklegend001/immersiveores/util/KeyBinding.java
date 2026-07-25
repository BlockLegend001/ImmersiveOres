package com.blocklegend001.immersiveores.util;

import com.blocklegend001.immersiveores.ImmersiveOres;
import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.common.util.Lazy;
import org.lwjgl.glfw.GLFW;

import static com.blocklegend001.immersiveores.ImmersiveOres.MODID;

@EventBusSubscriber(modid = MODID, value = Dist.CLIENT)
public class KeyBinding {
    public static final KeyMapping.Category IMMERSIVEORES_CATEGORY =
            KeyMapping.Category.register(
                    ResourceLocation.fromNamespaceAndPath(MODID, "showoutline")
            );

    public static final Lazy<KeyMapping> SHOW_OUTLINE_KEY = Lazy.of(() ->
            new KeyMapping(
                    "key.immersiveores.showoutline",
                    InputConstants.Type.KEYSYM,
                    GLFW.GLFW_KEY_O,
                    IMMERSIVEORES_CATEGORY
            )
    );

    @SubscribeEvent
    public static void registerKeys(RegisterKeyMappingsEvent event) {
        event.register(SHOW_OUTLINE_KEY.get());
    }
}
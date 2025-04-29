package com.blocklegend001.immersiveores;

import com.blocklegend001.immersiveores.util.ModItemProperties;
import com.blocklegend001.immersiveores.util.tools.excavator.ExcavatorOverlayRenderer;
import com.blocklegend001.immersiveores.util.tools.hammer.HammerOverlayRenderer;
import net.fabricmc.api.ClientModInitializer;

public class ImmersiveOresClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ExcavatorOverlayRenderer.init();
        HammerOverlayRenderer.init();
        ModItemProperties.registerModModels();
    }
}

package com.blocklegend001.immersiveores;

import com.blocklegend001.immersiveores.util.tools.excavator.*;
import com.blocklegend001.immersiveores.util.tools.hammer.*;
import net.fabricmc.api.ClientModInitializer;

public class ImmersiveOresClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ExcavatorOverlayRenderer.init();
        HammerOverlayRenderer.init();
    }
}
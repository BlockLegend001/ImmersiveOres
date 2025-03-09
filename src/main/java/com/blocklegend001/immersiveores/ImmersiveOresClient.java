package com.blocklegend001.immersiveores;

import com.blocklegend001.immersiveores.util.ModItemProperties;
import net.fabricmc.api.ClientModInitializer;

public class ImmersiveOresClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ModItemProperties.registerModModels();
    }
}

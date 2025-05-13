package com.blocklegend001.immersiveores;

import com.blocklegend001.immersiveores.util.tools.excavator.*;
import com.blocklegend001.immersiveores.util.tools.hammer.*;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.minecraft.util.ActionResult;

public class ImmersiveOresClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ExcavatorOverlayRenderer.init();
        HammerOverlayRenderer.init();

        AttackBlockCallback.EVENT.register((player, world, hand, pos, direction) -> {
            if (world.isClient) {
                ModEventsVibraniumExcavator.isSneaking = player.isSneaking();
                ModEventsVulpusExcavator.isSneaking = player.isSneaking();
                ModEventsEnderiumExcavator.isSneaking = player.isSneaking();

                ModEventsVibraniumHammer.isSneaking = player.isSneaking();
                ModEventsVulpusHammer.isSneaking = player.isSneaking();
                ModEventsEnderiumHammer.isSneaking = player.isSneaking();
            }
            return ActionResult.PASS;
        });
    }
}
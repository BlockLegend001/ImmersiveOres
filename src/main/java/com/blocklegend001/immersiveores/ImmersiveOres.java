package com.blocklegend001.immersiveores;

import com.blocklegend001.immersiveores.blocks.ModBlocks;
import com.blocklegend001.immersiveores.config.EnderiumConfig;
import com.blocklegend001.immersiveores.config.VibraniumConfig;
import com.blocklegend001.immersiveores.config.VulpusConfig;
import com.blocklegend001.immersiveores.item.ModItemGroups;
import com.blocklegend001.immersiveores.item.ModItems;
import com.blocklegend001.immersiveores.util.tools.excavator.ModEventsEnderiumExcavator;
import com.blocklegend001.immersiveores.util.tools.excavator.ModEventsVibraniumExcavator;
import com.blocklegend001.immersiveores.util.tools.excavator.ModEventsVulpusExcavator;
import com.blocklegend001.immersiveores.util.tools.hammer.ModEventsEnderiumHammer;
import com.blocklegend001.immersiveores.util.tools.hammer.ModEventsVibraniumHammer;
import com.blocklegend001.immersiveores.util.tools.hammer.ModEventsVulpusHammer;
import com.blocklegend001.immersiveores.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;

import java.util.logging.Logger;

public class ImmersiveOres implements ModInitializer {
    public static final String MOD_ID = "immersiveores";
    public static final Logger LOGGER = Logger.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        VibraniumConfig.loadConfig();
        VulpusConfig.loadConfig();
        EnderiumConfig.loadConfig();
        ModItemGroups.registerItemGroups();
        ModItems.registerModItems();
        ModBlocks.registerModels();
        ModWorldGeneration.generateModWorldGen();
        PlayerBlockBreakEvents.BEFORE.register(new ModEventsVibraniumExcavator());
        PlayerBlockBreakEvents.BEFORE.register(new ModEventsVulpusExcavator());
        PlayerBlockBreakEvents.BEFORE.register(new ModEventsEnderiumExcavator());
        PlayerBlockBreakEvents.BEFORE.register(new ModEventsVibraniumHammer());
        PlayerBlockBreakEvents.BEFORE.register(new ModEventsVulpusHammer());
        PlayerBlockBreakEvents.BEFORE.register(new ModEventsEnderiumHammer());
    }
}
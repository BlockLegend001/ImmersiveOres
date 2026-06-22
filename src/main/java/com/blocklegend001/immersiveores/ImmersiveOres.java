package com.blocklegend001.immersiveores;

import com.blocklegend001.immersiveores.blocks.ModBlocks;
import com.blocklegend001.immersiveores.config.EnderiumConfig;
import com.blocklegend001.immersiveores.config.VibraniumConfig;
import com.blocklegend001.immersiveores.config.VulpusConfig;
import com.blocklegend001.immersiveores.item.ModItemGroups;
import com.blocklegend001.immersiveores.item.ModItems;
import com.blocklegend001.immersiveores.util.tools.excavator.ModEventsExcavator;
import com.blocklegend001.immersiveores.util.tools.hammer.ModEventsHammer;
import com.blocklegend001.immersiveores.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;

import java.util.logging.Logger;

public class ImmersiveOres implements ModInitializer {
    public static final String MOD_ID = "immersiveores";
    public static final Logger LOGGER = Logger.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        VibraniumConfig.registerConfigs();
        VulpusConfig.registerConfigs();
        EnderiumConfig.registerConfigs();
        ModItemGroups.registerItemGroups();
        ModItems.registerModItems();
        ModBlocks.registerModels();
        ModWorldGeneration.generateModWorldGen();
        PlayerBlockBreakEvents.BEFORE.register(new ModEventsExcavator());
        PlayerBlockBreakEvents.BEFORE.register(new ModEventsHammer());
    }
}
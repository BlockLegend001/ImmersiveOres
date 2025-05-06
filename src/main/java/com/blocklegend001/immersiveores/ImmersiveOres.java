package com.blocklegend001.immersiveores;

import com.blocklegend001.immersiveores.block.ModBlocks;
import com.blocklegend001.immersiveores.config.EnderiumConfig;
import com.blocklegend001.immersiveores.config.VibraniumConfig;
import com.blocklegend001.immersiveores.config.VulpusConfig;
import com.blocklegend001.immersiveores.event.ModEventHandler;
import com.blocklegend001.immersiveores.item.ModCreativeModTabs;
import com.blocklegend001.immersiveores.item.ModItems;
import com.blocklegend001.immersiveores.util.ModItemProperties;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;

import java.util.logging.Logger;

@Mod(ImmersiveOres.MODID)
public class ImmersiveOres
{
    public static final String MODID = "immersiveores";
    public static final Logger LOGGER = Logger.getLogger(MODID);

    public ImmersiveOres(IEventBus modEventBus) {
        VibraniumConfig.loadConfig();
        VulpusConfig.loadConfig();
        EnderiumConfig.loadConfig();
        NeoForge.EVENT_BUS.register(ModEventHandler.class);
        modEventBus.addListener(this::clientSetup);
        ModBlocks.register(modEventBus);
        ModItems.register(modEventBus);
        ModCreativeModTabs.register(modEventBus);
        modEventBus.addListener(this::commonSetup);
    }

    public void clientSetup(final FMLClientSetupEvent event) {
        ModItemProperties.addCustomItemProperties();
    }

    public void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info(MODID + " loaded!");
    }
}

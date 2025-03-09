package com.blocklegend001.immersiveores;

import com.blocklegend001.immersiveores.blocks.ModBlocks;
import com.blocklegend001.immersiveores.config.EnderiumConfig;
import com.blocklegend001.immersiveores.config.VibraniumConfig;
import com.blocklegend001.immersiveores.config.VulpusConfig;
import com.blocklegend001.immersiveores.event.ModEventHandler;
import com.blocklegend001.immersiveores.item.ModCreativeModTabs;
import com.blocklegend001.immersiveores.item.ModItems;
import com.blocklegend001.immersiveores.util.ModItemProperties;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(ImmersiveOres.MODID)
public class ImmersiveOres {
    public static final String MODID = "immersiveores";

    public ImmersiveOres() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        VibraniumConfig.loadConfig();
        VulpusConfig.loadConfig();
        EnderiumConfig.loadConfig();
        MinecraftForge.EVENT_BUS.register(ModEventHandler.class);
        ModBlocks.register(modEventBus);
        ModItems.register(modEventBus);
        ModCreativeModTabs.register(modEventBus);
        modEventBus.addListener(this::clientSetup);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void clientSetup(final FMLClientSetupEvent event) {
        ModItemProperties.addCustomItemProperties();
    }
}